package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.rpc.soap.SOAPFaultException;

import weblogic.jws.Context;
import weblogic.jws.WLHttpTransport;
import weblogic.jws.security.RolesAllowed;
import weblogic.jws.security.SecurityRole;
import weblogic.wsee.jws.JwsContext;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.ManutencaoDadosCadastrais12V1JWS;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes.NetHeaderType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes.AlterarDadoContatoTitularType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes.
	ResultadoAlterarDadoContatoTitularType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes.
	ResultadoValidarDadoContatoTitularType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes.TelefoneContatoType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes.ValidarDadoContatoTitularType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.Atendimento;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;

import br.com.netservicos.netcrmcore.cliente.contratovenda.facade.ManutencaoDadosContatoService;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.*;
import static br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants.*;
import static br.com.netservicos.netcrmcore.webservices.util.WebServicesUtil.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * JWS que recebe as requisições ao CORE, responsável pela Manutenção dos Dados de Contato. 
 * Esta camada é uma casca para exposição do serviço implementado no EJB. Utiliza soap 1.2
 * correcao para novo caminho
 */

@WebService(
		name="ManutencaoDadosContato12V1JWSService",
		serviceName = "ManutencaoDadosContato12V1JWSService", 
		targetNamespace = "http://www.netservicos.com.br/netcrmcore/ManutencaoDadosContato12V1JWS")
@WLHttpTransport(
		contextPath = "netcrmcore", 
		serviceUri = "ManutencaoDadosContato12V1JWS", 
		portName = "ManutencaoDadosContato12V1JWSPort12")
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.BARE)
@weblogic.jws.Binding(
		weblogic.jws.Binding.Type.SOAP12)
public class ManutencaoDadosContato12V1JWS extends AbstractNETCRMCoreWS {

	private static final String ALTERACAODADOSCONTATO = "ALTERACAO_DADOS_CONTATO";
	private static final String TARGETNAMESPACEMANUTENCAODADOSCONTATO = 
		"java:br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes";
	
	//LOG
	private static Log logger = LogFactory.getLog(ManutencaoDadosCadastrais12V1JWS.class);
	
	@Context
	private JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}

	/**
	 * Operação que realiza as alterações de dados de contato do Assinante.
	 * @param requestHeader
	 * informações do header
	 * @param alterarDadoContatoTitular
	 * informações usadas para realizar a alteração dos dados de contato
	 * @return
	 */
	@WebMethod( 
				action="",
				operationName="alterarDadoContatoTitular")
	@WebResult(
			name="resultadoAlterarDadoContatoTitular", 
			partName="alterarDadoContatoTitularResponse",
			targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCONTATO)
	@RolesAllowed ({
				@SecurityRole (role=ALTERACAODADOSCONTATO)
	})
	public ResultadoAlterarDadoContatoTitularType alterarDadoContatoTitular(
			@WebParam(
					name = NETHEADER, 
					partName = REQUESTHEADER, 
					header=true,
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCONTATO)
			NetHeaderType requestHeader,
			@WebParam(
					name="parametrosAlterarDadoContatoTitular", 
					partName="alterarDadoContatoTitularRequest",
					targetNamespace = "java:br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato" +
							".complextypes")
			AlterarDadoContatoTitularType alterarDadoContatoTitular){
		
		this.logar("ManutencaoDadosContato12V1JWS:alterarDadoContatoTitular::Inicio");

		NETFrameworkWSHeader header = this.criarHeader(requestHeader);

		this.logar("ManutencaoDadosContato12V1JWS:alterarDadoContatoTitular:" +
				"criarBeanComDadosNetHeader::Inicio");
		DynamicBean dadosContato = criarBeanComDadosNetHeader(header);
		this.logar("ManutencaoDadosContato12V1JWS:" +
				"alterarDadoContatoTitular:criarBeanComDadosNetHeader::Fim");
		
		//Adiciona os dados do Contrato no Bean 
		if (alterarDadoContatoTitular.getIdentificadorContrato() != null) {
			dadosContato.addBeanProperty(CONTRATO_NUM_CONTRATO, 
					Long.toString(alterarDadoContatoTitular.getIdentificadorContrato().getNumeroContrato()));
			dadosContato.addBeanProperty(CONTRATO_CIDADE, alterarDadoContatoTitular.getIdentificadorContrato()
					.getIdentificacaoCidade());
		}

		//Adiciona os dados do Contato no Bean
		if (alterarDadoContatoTitular.getDadoContatoTitular().getEmail() != null) {
			dadosContato.addBeanProperty(DADOS_CONTATO_EMAIL, 
					alterarDadoContatoTitular.getDadoContatoTitular().getEmail().getEnderecoEmail());
			dadosContato.addBeanProperty(DADOS_CONTATO_ACEITA_CONTATO, 
					Boolean.toString(alterarDadoContatoTitular.getDadoContatoTitular().getEmail().isAceitaContato()));
		}
		
		if (alterarDadoContatoTitular.getDadoContatoTitular().getTelefones() != null &&
				alterarDadoContatoTitular.getDadoContatoTitular().getTelefones().getTelefone() != null) {

			TelefoneContatoType[] telefones = 
				alterarDadoContatoTitular.getDadoContatoTitular().getTelefones().getTelefone();
			
			dadosContato.addBeanProperty(DADOS_CONTATO_RESIDENCIAL, WebServicesConstants.FALSO);
			dadosContato.addBeanProperty(DADOS_CONTATO_COMERCIAL, WebServicesConstants.FALSO);
			dadosContato.addBeanProperty(DADOS_CONTATO_CELULAR, WebServicesConstants.FALSO);
			dadosContato.addBeanProperty(DADOS_CONTATO_FAX, WebServicesConstants.FALSO);
			dadosContato.addBeanProperty(DADOS_CONTATO_OUTROS, WebServicesConstants.FALSO);

			this.tratarTelefone(telefones, dadosContato);
			
		}
		
		//Adiciona os dados do Registro Contato no Bean
		if (alterarDadoContatoTitular.getRegistroContato() != null) {
			dadosContato.addBeanProperty(DADOS_REGISTRO_CONTATO_NOME_CONTATO, 
					alterarDadoContatoTitular.getRegistroContato().getNomeContato());
			dadosContato.addBeanProperty(DADOS_REGISTRO_CONTATO_DDD_TELEFONE, 
					alterarDadoContatoTitular.getRegistroContato().getTelefoneContato().getDddTelefone());
			dadosContato.addBeanProperty(DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE, 
					alterarDadoContatoTitular.getRegistroContato().getTelefoneContato().getNumeroTelefone());
			dadosContato.addBeanProperty(DADOS_REGISTRO_CONTATO_OBSERVACAO, 
					alterarDadoContatoTitular.getRegistroContato().getObservacao());
		}
				
		//Localiza e efetua chamada ao EJB
		//Monta SOAPFaultException em caso de erro
		try {
			ManutencaoDadosContatoService manutencaoDadosContatoService = 
				super.getService(ManutencaoDadosContatoService.class);
			manutencaoDadosContatoService.alterarDadosContatoTitular(dadosContato);
		} catch (Exception e) {
			Object[] parameters = new Object[]{RESOURCE_ALTERAR_DADOS_CONTATO_TITULAR};
			SOAPFaultException soapFaultException = 
				generateSOAPFaultException(RESOURCE_ERROR, parameters, RESOURCE_ERROR, e);
			
			throw soapFaultException;
		}

		this.logar("ManutencaoDadosContato12V1JWS:alterarDadoContatoTitular::Fim");
		
		return new ResultadoAlterarDadoContatoTitularType();
		
	}

	/**
	 * Operação que realiza as validações dos dados de contato do Assinante.
	 * @param requestHeader
	 * informações do header
	 * @param validarDadoContatoTitular
	 * informações usadas para realizar a validação dos dados de contato
	 * @return
	 * Retorna possiveis erros de validação (Ex.: Telefone invalido).
	 */
	@WebMethod( 
				action="",
				operationName="validarDadoContatoTitular")
	@WebResult(
			name="resultadoValidarDadoContatoTitular", 
			partName="validarDadoContatoTitularResponse",
			targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCONTATO)
	@RolesAllowed ({
				@SecurityRole (role=ALTERACAODADOSCONTATO)})
	public ResultadoValidarDadoContatoTitularType validarDadoContatoTitular(
			@WebParam(
					name = NETHEADER, 
					partName = REQUESTHEADER, 
					header=true,
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCONTATO)
			NetHeaderType requestHeader,
			@WebParam(
					name="parametrosValidarDadoContatoTitular", 
					partName="validarDadoContatoTitularRequest",
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCONTATO)
			ValidarDadoContatoTitularType validarDadoContatoTitular){
		
		this.logar("ManutencaoDadosContato12V1JWS:validarDadoContatoTitular::Inicio");
		
		NETFrameworkWSHeader header = this.criarHeader(requestHeader);

		this.logar("ManutencaoDadosContato12V1JWS:" +
				"validarDadoContatoTitular:criarBeanComDadosNetHeader::Inicio");
		DynamicBean dadosContato = criarBeanComDadosNetHeader(header);
		this.logar("ManutencaoDadosContato12V1JWS:" +
				"validarDadoContatoTitular:criarBeanComDadosNetHeader::Fim");

		//Adiciona os dados do Contrato no Bean 
		if (validarDadoContatoTitular.getIdentificadorContrato() != null) {
			dadosContato.addBeanProperty(CONTRATO_NUM_CONTRATO, 
					Long.toString(validarDadoContatoTitular.getIdentificadorContrato().getNumeroContrato()));
			dadosContato.addBeanProperty(CONTRATO_CIDADE, 
					validarDadoContatoTitular.getIdentificadorContrato().getIdentificacaoCidade());
		}

		//Adiciona os dados do Contato no Bean 
		if (validarDadoContatoTitular.getDadoContatoTitular().getEmail() != null) {
			dadosContato.addBeanProperty(DADOS_CONTATO_EMAIL, 
					validarDadoContatoTitular.getDadoContatoTitular().getEmail().getEnderecoEmail());
			dadosContato.addBeanProperty(DADOS_CONTATO_ACEITA_CONTATO, 
					Boolean.toString(validarDadoContatoTitular.getDadoContatoTitular().getEmail().isAceitaContato()));
		}
		
		if (validarDadoContatoTitular.getDadoContatoTitular().getTelefones() != null &&
				validarDadoContatoTitular.getDadoContatoTitular().getTelefones().getTelefone() != null) {
			
			TelefoneContatoType[] telefones = 
				validarDadoContatoTitular.getDadoContatoTitular().getTelefones().getTelefone();
			
			dadosContato.addBeanProperty(DADOS_CONTATO_RESIDENCIAL, WebServicesConstants.FALSO);
			dadosContato.addBeanProperty(DADOS_CONTATO_COMERCIAL, WebServicesConstants.FALSO);
			dadosContato.addBeanProperty(DADOS_CONTATO_CELULAR, WebServicesConstants.FALSO);
			dadosContato.addBeanProperty(DADOS_CONTATO_FAX, WebServicesConstants.FALSO);
			dadosContato.addBeanProperty(DADOS_CONTATO_OUTROS, WebServicesConstants.FALSO);

			this.tratarTelefone(telefones, dadosContato);
			
		}
		
		//Localiza e efetua chamada ao EJB
		//Monta SOAPFaultException em caso de erro
		try {
			ManutencaoDadosContatoService manutencaoDadosContatoService = 
				super.getService(ManutencaoDadosContatoService.class);
			manutencaoDadosContatoService.validarDadosContatoTitular(dadosContato);
		} catch (Exception e) {
			Object[] parameters = new Object[]{RESOURCE_VALIDAR_DADOS_CONTATO_TITULAR};
			SOAPFaultException soapFaultException =  
				generateSOAPFaultException(RESOURCE_ERROR, parameters, RESOURCE_ERROR, e);

			throw soapFaultException;
		}

		this.logar("ManutencaoDadosContato12V1JWS:validarDadoContatoTitular::Fim");
		
		return new ResultadoValidarDadoContatoTitularType();
	}


	/**
	 * Metodo responsavel em criar um header.
	 * @param requestHeader
	 * header do request de onde será pego os dados.
	 * @return
	 * NETFrameworkWSHeader, com as informações do header do request.
	 */
	private NETFrameworkWSHeader criarHeader(NetHeaderType requestHeader){
		
		this.logar("ManutencaoDadosContato12V1JWS:criarHeader::Inicio");
		
		NETFrameworkWSHeader header = null;
		
		if (requestHeader != null) {
			Atendimento atendimento = null;
			if (requestHeader.getAtendimento() != null) {
				atendimento = new Atendimento();
				atendimento.setNumeroChamada(requestHeader.getAtendimento().getNumeroChamada());
				atendimento.setNumeroProtocolo(requestHeader.getAtendimento().getNumeroProtocolo());
			}

			header = new NETFrameworkWSHeader();
			if (requestHeader.getAplicacao() != null) {
				header.setAplicacao(requestHeader.getAplicacao());
			}

			if (atendimento != null) {
				header.setAtendimento(atendimento);
			}
			
			header.setFuncionalidade(requestHeader.getFuncionalidade());
			header.setToken(requestHeader.getToken());
			header.setUsername(requestHeader.getUsername());
			header.setVersaoServico(requestHeader.getVersaoServico());
			
			getUserInfo(header);
		}

		this.logar("ManutencaoDadosContato12V1JWS:criarHeader::Fim");

		return header;
	}
	

	/**
	 * Metodo responsavel em fazer o tratamento do telefone.
	 * @param telefones
	 * telefones que serão tratados.
	 * @param dadosContato
	 * bean onde será armazenado o telefone.
	 */
	private void tratarTelefone(TelefoneContatoType[] telefones, DynamicBean dadosContato){
		
		this.logar("ManutencaoDadosContato12V1JWS:tratarTelefone::Inicio");
		
		for (int i = 0; i < telefones.length; i++) {
			TelefoneContatoType telefone = telefones[i];
			
			if (telefone.getTipoTelefone() != null) {
				if (telefone.getTipoTelefone().equals(WebServicesConstants.TIPO_TELEFONE_RESIDENCIAL)) {
					dadosContato.set(DADOS_CONTATO_RESIDENCIAL, WebServicesConstants.VERDADEIRO);
					dadosContato.addBeanProperty(DADOS_CONTATO_DDD_RESIDENCIAL, telefone.getDddTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_TELEFONE_RESIDENCIAL, telefone.getNumeroTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_RAMAL_RESIDENCIAL, telefone.getRamal());
				}
				if (telefone.getTipoTelefone().equals(WebServicesConstants.TIPO_TELEFONE_COMERCIAL)) {
					dadosContato.set(DADOS_CONTATO_COMERCIAL, WebServicesConstants.VERDADEIRO);
					dadosContato.addBeanProperty(DADOS_CONTATO_DDD_COMERCIAL, telefone.getDddTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_TELEFONE_COMERCIAL, telefone.getNumeroTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_RAMAL_COMERCIAL, telefone.getRamal());
				}
				if (telefone.getTipoTelefone().equals(WebServicesConstants.TIPO_TELEFONE_CELULAR)) {
					dadosContato.set(DADOS_CONTATO_CELULAR, WebServicesConstants.VERDADEIRO);
					dadosContato.addBeanProperty(DADOS_CONTATO_DDD_CELULAR, telefone.getDddTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_TELEFONE_CELULAR, telefone.getNumeroTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_RAMAL_CELULAR, telefone.getRamal());
				}
				if (telefone.getTipoTelefone().equals(WebServicesConstants.TIPO_TELEFONE_FAX)) {
					dadosContato.set(DADOS_CONTATO_FAX, WebServicesConstants.VERDADEIRO);
					dadosContato.addBeanProperty(DADOS_CONTATO_DDD_FAX, telefone.getDddTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_TELEFONE_FAX, telefone.getNumeroTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_RAMAL_FAX, telefone.getRamal());
				}
				if (telefone.getTipoTelefone().equals(WebServicesConstants.TIPO_TELEFONE_OUTROS)) {
					dadosContato.set(DADOS_CONTATO_OUTROS, WebServicesConstants.VERDADEIRO);
					dadosContato.addBeanProperty(DADOS_CONTATO_DDD_OUTROS, telefone.getDddTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_TELEFONE_OUTROS, telefone.getNumeroTelefone());
					dadosContato.addBeanProperty(DADOS_CONTATO_RAMAL_OUTROS, telefone.getRamal());
				}
			}
			
		}
		
		this.logar("ManutencaoDadosContato12V1JWS:tratarTelefone::Fim");
	}
	

	/**
	 * Metódo responsável em logar 1 texto.
	 * @param texto
	 * texto que será logado.
	 */
	private void logar(String texto){
		if (logger.isDebugEnabled()) {
			logger.debug(texto);		
		}
	}
	
}
