package br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone;

import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_DDD;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_FLAG_IMEDIATA;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_NUMERO_EXTENSOES;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_NOME_SOLICITANTE;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_OBSERVACAO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NET_HEADER_APLICACAO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NET_HEADER_FUNCIONALIDADE;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NET_HEADER_NUMERO_CHAMADA;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NET_HEADER_NUMERO_PROTOCOLO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NET_HEADER_TOKEN;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NET_HEADER_USERNAME;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NET_HEADER_VERSAO_SERVICO;
import static br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants.RESOURCE_ERROR_EXTENSAO_FONE;
import static br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants
	.RESOURCE_MANUTENCAO_EXTENSAO_FONE;

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
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.Atendimento;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.netcrmcore.venda.extensaofone.facade.ManutencaoExtensaoFoneService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes.NetHeaderType;

import br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes
	.ParametrosSolicitarExtensaoFoneType;

import br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes.ResultadoSolicitarType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * JWS que recebe as requisições ao CORE, responsável pela Manutenção de Extensões de Fone. 
 * Esta camada é uma casca para exposição do serviço implementado no EJB. Utiliza soap 1.2
 */

@WebService(
		name="ManutencaoExtensaoFoneJWSService",
		serviceName = "ManutencaoExtensaoFoneJWSService", 
		targetNamespace = "http://www.netservicos.com.br/netcrmcore/ManutencaoExtensaoFoneJWS")
@WLHttpTransport(
		contextPath = "netcrmcore", 
		serviceUri = "ManutencaoExtensaoFoneJWS", 
		portName = "ManutencaoExtensaoFoneJWSPort12")
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.BARE)
@weblogic.jws.Binding(
		weblogic.jws.Binding.Type.SOAP12)
public class ManutencaoExtensaoFoneJWS extends AbstractNETCRMCoreWS {
 
	//LOG
	private static Log logger = LogFactory.getLog(ManutencaoExtensaoFoneJWS.class);
	
	@Context
	private JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}

	/**
	 * Operação responsável por inserir as solicitações de extensão para o telefone de um determinado contrato. 
	 * A operação retorna uma lista com os códigos das ordens de campo (OS para o legado) geradas pelas solicitações
	 * de extensão. O que determina quantos códigos serão retornados é o número de extensões que o serviço deve 
	 * adicionar.
	 * @param requestHeader
	 * informações do header
	 * @param parametrosSolicitarExtensaoFone
	 * informações usadas para gerar extensão
	 * @return
	 * lista com os códigos das ordens de campo
	 */
	@WebMethod(action = "", operationName = "solicitarExtensaoFone")
	@WebResult(name = "resultadoExtensaoFone", partName = "extensaoFoneResponse", 
			targetNamespace = "java:br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes")
	@RolesAllowed( { @SecurityRole(role = "SOLICITAR_EXTENSAO_FONE") })
	public ResultadoSolicitarType solicitarExtensaoFone(
			@WebParam(name = "NetHeader", partName = "requestHeader", header = true, 
					targetNamespace = "java:br.com.netservicos.netcrmcore.webservices."
					+ "manutencaoextensaofone.complextypes")
			NetHeaderType requestHeader,
			@WebParam(name = "parametrosSolicitarExtensaoFone", partName = "solicitarExtensaoFoneRequest", 
					targetNamespace = 
						"java:br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes")
			ParametrosSolicitarExtensaoFoneType parametrosSolicitarExtensaoFone) {

		this.logar("ManutencaoExtensaoFoneJWS.solicitarExtensaoFone::Inicio");
		
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

		DynamicBean extensaoFoneBean = this.criarBeanComDadosNetHeader(header);

		// Adiciona os dados no Bean de validacao venda

		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO, parametrosSolicitarExtensaoFone
				.getIdentificadorContrato().getIdentificacaoCidade());
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO, 
				Long.toString(parametrosSolicitarExtensaoFone.getIdentificadorContrato().getNumeroContrato()));
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_FLAG_IMEDIATA, 
				Boolean.toString(parametrosSolicitarExtensaoFone.getDadosExtensaoFone().isFlagImediata()));
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO, 
				Long.toString(parametrosSolicitarExtensaoFone.getDadosExtensaoFone()
						.getIdentificadorLocalDomicilio()));
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO, 
				Long.toString(parametrosSolicitarExtensaoFone.getDadosExtensaoFone()
						.getIdentificadorPlanoPagamento()));
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_NUMERO_EXTENSOES, 
				Long.toString(parametrosSolicitarExtensaoFone.getDadosExtensaoFone().getNumeroExtensoes()));
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_DDD,
				parametrosSolicitarExtensaoFone.getDadosExtensaoFone().getTelefoneVoip().getDdd());
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE,
				parametrosSolicitarExtensaoFone.getDadosExtensaoFone().getTelefoneVoip().getNumeroTelefone());
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_NOME_SOLICITANTE,
				parametrosSolicitarExtensaoFone.getDadosExtensaoFone().getNomeSolicitante());
		extensaoFoneBean.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_OBSERVACAO,
				parametrosSolicitarExtensaoFone.getDadosExtensaoFone().getObservacao());

		String[] listaIdsSolicitacao;

		// Localiza e efetua chamada ao EJB
		// Monta SOAPFaultException em caso de erro
		try {
			
			this.logar("ManutencaoExtensaoFoneJWS.solicitarExtensaoFone::Chamada EJB " +
					"br.com.netservicos.netcrmcore.venda.extensaofone.facade.ManutencaoExtensaoFoneService ");
			
			ManutencaoExtensaoFoneService manutencaoExtensaoFoneService = super
					.getService(ManutencaoExtensaoFoneService.class);
			listaIdsSolicitacao = manutencaoExtensaoFoneService
					.solicitarExtensaoFone(extensaoFoneBean);
		} catch (Exception e) {
			Object[] parameters = new Object[] { RESOURCE_MANUTENCAO_EXTENSAO_FONE };
			SOAPFaultException soapFaultException = generateSOAPFaultException(
					RESOURCE_ERROR_EXTENSAO_FONE, parameters, RESOURCE_ERROR_EXTENSAO_FONE, e);

			throw soapFaultException;
		}

		ResultadoSolicitarType resultadoSolicitarType = new ResultadoSolicitarType();
		resultadoSolicitarType.setCodigoOrdemCampo(listaIdsSolicitacao);

		this.logar("ManutencaoExtensaoFoneJWS.solicitarExtensaoFone::Fim");
		
		return resultadoSolicitarType;

	}

	
	/**
	 * Cria 1 dynamicBean, com dados do netheader.
	 * @param header
	 * header de onde será pego os dados.
	 * @return
	 * dynamicBean que contém os dados do netHeader.
	 */
	private DynamicBean criarBeanComDadosNetHeader(NETFrameworkWSHeader header){

		DynamicBean extensaoFoneBean = new DynamicBean();
		
		// Adiciona os dados do NetHeader no Bean
		if (header != null) {
			extensaoFoneBean.addBeanProperty(NET_HEADER_APLICACAO, header.getAplicacao());
			extensaoFoneBean.addBeanProperty(NET_HEADER_FUNCIONALIDADE, header.getFuncionalidade());
			extensaoFoneBean.addBeanProperty(NET_HEADER_VERSAO_SERVICO, header.getVersaoServico());
			extensaoFoneBean.addBeanProperty(NET_HEADER_TOKEN, header.getToken());
			if (header.getAtendimento() != null) {
				extensaoFoneBean.addBeanProperty(NET_HEADER_NUMERO_PROTOCOLO, header.getAtendimento()
						.getNumeroProtocolo());
				extensaoFoneBean.addBeanProperty(NET_HEADER_NUMERO_CHAMADA,	header.getAtendimento()
						.getNumeroChamada());
			}
			extensaoFoneBean.addBeanProperty(NET_HEADER_USERNAME, header.getUsername());
		}
		
		return extensaoFoneBean;
		
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
