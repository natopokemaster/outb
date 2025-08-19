package br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais;

import java.text.SimpleDateFormat;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebParam;
import javax.xml.rpc.soap.SOAPFaultException;

import weblogic.jws.Context;
import weblogic.jws.WLHttpTransport;
import weblogic.jws.security.RolesAllowed;
import weblogic.jws.security.SecurityRole;
import weblogic.wsee.jws.JwsContext;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.Atendimento;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.netcrmcore.cliente.contratovenda.facade.ManutencaoDadosCadastraisService;
import br.com.netservicos.netcrmcore.cliente.util.DateValidator;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.NetHeaderType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.AlterarDadoCadastralTitularPessoaFisicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.AlterarDadoCadastralTitularPessoaJuridicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.PessoaFisicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.PessoaJuridicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.ResultadoAlterarDadoCadastralTitularPessoaFisicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.ResultadoAlterarDadoCadastralTitularPessoaJuridicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.ResultadoValidarDadoCadastralTitularPessoaFisicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.ResultadoValidarDadoCadastralTitularPessoaJuridicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.ValidarDadoCadastralTitularPessoaFisicaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes
	.ValidarDadoCadastralTitularPessoaJuridicaType;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.*;
import static br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants.*;
import static br.com.netservicos.netcrmcore.webservices.util.WebServicesUtil.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * JWS que recebe as requisições ao CORE, responsável pela Manutenção dos Dados Cadastrais. 
 * Esta camada é uma casca para exposição do serviço implementado no EJB. Utiliza soap 1.2
 */

@WebService(
		name="ManutencaoDadosCadastrais12V1JWSService",
		serviceName = "ManutencaoDadosCadastrais12V1JWSService", 
		targetNamespace = "http://www.netservicos.com.br/netcrmcore/ManutencaoDadosCadastrais12V1JWS")
@WLHttpTransport(
		contextPath = "netcrmcore", 
		serviceUri = "ManutencaoDadosCadastrais12V1JWS", 
		portName = "ManutencaoDadosCadastrais12V1JWSPort12")
@SOAPBinding(
		style=SOAPBinding.Style.DOCUMENT, 
		use=SOAPBinding.Use.LITERAL,
		parameterStyle=SOAPBinding.ParameterStyle.BARE)
@weblogic.jws.Binding(
		weblogic.jws.Binding.Type.SOAP12)
public class ManutencaoDadosCadastrais12V1JWS extends AbstractNETCRMCoreWS {

	private static final String ALTERACAODADOSCADASTRAISLIVRES = "ALTERACAO_DADOS_CADASTRAIS_LIVRES";
	private static final String ALTERACAODADOSCADASTRAISRESTRITOS = "ALTERACAO_DADOS_CADASTRAIS_RESTRITOS";
	private static final String TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS = 
		"java:br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes";

	//LOG
	private static Log logger = LogFactory.getLog(ManutencaoDadosCadastrais12V1JWS.class);
	
	@Context
	private JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}
	
	/**
	 * Operação que realiza as alterações dos dados cadastrais do Assinante - Pessoa Fisica.
	 * @param requestHeader
	 * informações do header
	 * @param alterarDadoCadastralTitularPessoaFisica
	 * informações usadas para realizar a alteração dos dados cadastrais. 
	 * @return
	 */	
	@WebMethod(
			action="",
			operationName="alterarDadoCadastralTitularPessoaFisica")
	@WebResult(
			name="resultadoAlterarDadoCadastralTitularPessoaFisica", 
			partName="alterarDadoCadastralTitularPessoaFisicaResponse",
			targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
	@RolesAllowed ({
			@SecurityRole (role=ALTERACAODADOSCADASTRAISLIVRES), 
			@SecurityRole (role=ALTERACAODADOSCADASTRAISRESTRITOS)})
	public ResultadoAlterarDadoCadastralTitularPessoaFisicaType alterarDadoCadastralTitularPessoaFisica(
			@WebParam(
					name=NETHEADER, 
					partName= REQUESTHEADER, 
					header=true,
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS) 
			NetHeaderType requestHeader, 
			@WebParam(
					name="parametrosAlterarDadoCadastralTitularPessoaFisica", 
					partName="alterarDadoCadastralTitularPessoaFisicaRequest",
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
			AlterarDadoCadastralTitularPessoaFisicaType alterarDadoCadastralTitularPessoaFisica) {
		
		this.logar("ManutencaoDadosCadastrais12V1JWS:alterarDadoCadastralTitularPessoaFisica::Inicio");
		
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"alterarDadoCadastralTitularPessoaFisica:criarHeader::Inicio");
		NETFrameworkWSHeader header = criarHeader(requestHeader);
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"alterarDadoCadastralTitularPessoaFisica:criarHeader::Fim");

		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"alterarDadoCadastralTitularPessoaFisica:criarBeanComDadosNetHeader::Inicio");
		DynamicBean dadosCadastrais = criarBeanComDadosNetHeader(header);
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"alterarDadoCadastralTitularPessoaFisica:criarBeanComDadosNetHeader::Fim");
		
		//Adiciona os dados do Contrato no Bean 
		if (alterarDadoCadastralTitularPessoaFisica.getIdentificadorContrato() != null) {
			dadosCadastrais.addBeanProperty(CONTRATO_NUM_CONTRATO, Long.toString(
					alterarDadoCadastralTitularPessoaFisica.getIdentificadorContrato().getNumeroContrato()));
			dadosCadastrais.addBeanProperty(CONTRATO_CIDADE, 
					alterarDadoCadastralTitularPessoaFisica.getIdentificadorContrato().getIdentificacaoCidade());
		}
		
		//Adiciona os dados do Assinante no Bean
		dadosCadastrais.addBeanProperty(ASSINANTE_NOME_TITULAR, 
				alterarDadoCadastralTitularPessoaFisica.getDadoCadastralTitularPessoaFisica().getNome());
		dadosCadastrais.addBeanProperty(ASSINANTE_CODIGO_SUFRAMA, 
				alterarDadoCadastralTitularPessoaFisica.getDadoCadastralTitularPessoaFisica().getCodigoSuframa());
		
		PessoaFisicaType pessoaFisica = 
			alterarDadoCadastralTitularPessoaFisica.getDadoCadastralTitularPessoaFisica().getPessoaFisica();
		SimpleDateFormat dateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
		dateFormat.applyPattern(DateValidator.FORMATO_CURTO);
		
		dadosCadastrais.addBeanProperty(ASSINANTE_TIPO_PESSOA, ASSINANTE_TIPO_PESSOA_FISICA);
		if (pessoaFisica.getDataNascimento() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_DATA_NASCIMENTO, 
					dateFormat.format(pessoaFisica.getDataNascimento().getTime()));
		}
		dadosCadastrais.addBeanProperty(ASSINANTE_CPF, pessoaFisica.getCpf());
		dadosCadastrais.addBeanProperty(ASSINANTE_RG, pessoaFisica.getRg());
		dadosCadastrais.addBeanProperty(ASSINANTE_ORGAO_EXPEDIDOR, pessoaFisica.getOrgaoExpedidor());
		if (pessoaFisica.getFlagEstrangeiro() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_ESTRANGEIRO, pessoaFisica.getFlagEstrangeiro().toString());
		}
		dadosCadastrais.addBeanProperty(ASSINANTE_PASSAPORTE, pessoaFisica.getPassaporte());
		dadosCadastrais.addBeanProperty(ASSINANTE_NOME_PAI, pessoaFisica.getNomePai());
		dadosCadastrais.addBeanProperty(ASSINANTE_NOME_MAE, pessoaFisica.getNomeMae());
		if (pessoaFisica.getSexo() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_SEXO, String.valueOf(pessoaFisica.getSexo()));
		}
		if (pessoaFisica.getIdentificacaoEstadoCivil() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_ESTADO_CIVIL, 
					pessoaFisica.getIdentificacaoEstadoCivil().toString());
		}
		if (pessoaFisica.getIdentificacaoProfissao() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_PROFISSAO, pessoaFisica.getIdentificacaoProfissao().toString());
		}
		if (pessoaFisica.getIdentificacaoEscolaridade() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_ESCOLARIDADE, 
					pessoaFisica.getIdentificacaoEscolaridade().toString());
		}

		//Adiciona os dados do Registro Contrato no Bean
		if (alterarDadoCadastralTitularPessoaFisica.getRegistroContato() != null) {
			dadosCadastrais.addBeanProperty(DADOS_REGISTRO_CONTATO_NOME_CONTATO, 
					alterarDadoCadastralTitularPessoaFisica.getRegistroContato().getNomeContato());
			dadosCadastrais.addBeanProperty(DADOS_REGISTRO_CONTATO_DDD_TELEFONE, 
					alterarDadoCadastralTitularPessoaFisica.getRegistroContato().getTelefoneContato()
						.getDddTelefone());
			dadosCadastrais.addBeanProperty(DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE, 
					alterarDadoCadastralTitularPessoaFisica.getRegistroContato().getTelefoneContato()
						.getNumeroTelefone());
			dadosCadastrais.addBeanProperty(DADOS_REGISTRO_CONTATO_OBSERVACAO, 
					alterarDadoCadastralTitularPessoaFisica.getRegistroContato().getObservacao());
		}
				
		//Localiza e efetua chamada ao EJB
		//Monta SOAPFaultException em caso de erro
		try {
			ManutencaoDadosCadastraisService manutencaoDadosCadastraisService = 
				super.getService(ManutencaoDadosCadastraisService.class);
			manutencaoDadosCadastraisService.alterarDadosCadastraisTitular(dadosCadastrais);
		} catch (Exception e) {
			Object[] parameters = new Object[]{RESOURCE_ALTERAR_DADOS_CADASTRAIS_TITULAR};
			SOAPFaultException soapFaultException = 
				generateSOAPFaultException(RESOURCE_ERROR, parameters, RESOURCE_ERROR, e);
			
			throw soapFaultException;
		}
		
		this.logar("ManutencaoDadosCadastrais12V1JWS:alterarDadoCadastralTitularPessoaFisica::Fim");
		
		return new ResultadoAlterarDadoCadastralTitularPessoaFisicaType();
	}

	/**
	 * Operação que realiza as alterações dos dados cadastrais do Assinante - Pessoa Juridica.
	 * @param requestHeader
	 * informações do header
	 * @param alterarDadoCadastralTitularPessoaJuridica
	 * informações usadas para realizar a alteração dos dados cadastrais. 
	 * @return
	 */		
	@WebMethod( 
			action="",
			operationName="alterarDadoCadastralTitularPessoaJuridica")
	@WebResult(
			name="resultadoAlterarDadoCadastralTitularPessoaJuridica", 
			partName="alterarDadoCadastralTitularPessoaJuridicaResponse",
			targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
	@RolesAllowed ({
			@SecurityRole (role=ALTERACAODADOSCADASTRAISLIVRES),
			@SecurityRole (role=ALTERACAODADOSCADASTRAISRESTRITOS)})
	public ResultadoAlterarDadoCadastralTitularPessoaJuridicaType alterarDadoCadastralTitularPessoaJuridica(
			@WebParam(
					name=NETHEADER, 
					partName= REQUESTHEADER, 
					header=true,
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
			NetHeaderType requestHeader,
			@WebParam(
					name="parametrosAlterarDadoCadastralTitularPessoaJuridica", 
					partName="alterarDadoCadastralTitularPessoaJuridicaRequest",
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
			AlterarDadoCadastralTitularPessoaJuridicaType alterarDadoCadastralTitularPessoaJuridica) {

		this.logar("ManutencaoDadosCadastrais12V1JWS:alterarDadoCadastralTitularPessoaJuridica::Inicio");

		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"alterarDadoCadastralTitularPessoaJuridica:criarHeader::Inicio");
		NETFrameworkWSHeader header = criarHeader(requestHeader);
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"alterarDadoCadastralTitularPessoaJuridica:criarHeader::Fim");

		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"alterarDadoCadastralTitularPessoaJuridica:criarBeanComDadosNetHeader::Inicio");
		DynamicBean dadosCadastrais = criarBeanComDadosNetHeader(header);
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"alterarDadoCadastralTitularPessoaJuridica:criarBeanComDadosNetHeader::Fim");

		//Adiciona os dados do Contrato no Bean 
		if (alterarDadoCadastralTitularPessoaJuridica.getIdentificadorContrato() != null) {
			dadosCadastrais.addBeanProperty(
					CONTRATO_NUM_CONTRATO, Long.toString(alterarDadoCadastralTitularPessoaJuridica
							.getIdentificadorContrato().getNumeroContrato()));
			dadosCadastrais.addBeanProperty(
					CONTRATO_CIDADE, alterarDadoCadastralTitularPessoaJuridica.getIdentificadorContrato()
						.getIdentificacaoCidade());
		}
		
		//Adiciona os dados do Assinante no Bean
		dadosCadastrais.addBeanProperty(ASSINANTE_NOME_TITULAR, 
				alterarDadoCadastralTitularPessoaJuridica.getDadoCadastralTitularPessoaJuridica().getNome());
		dadosCadastrais.addBeanProperty(ASSINANTE_CODIGO_SUFRAMA, 
				alterarDadoCadastralTitularPessoaJuridica.getDadoCadastralTitularPessoaJuridica().getCodigoSuframa());

		PessoaJuridicaType pessoaJuridica = 
			alterarDadoCadastralTitularPessoaJuridica.getDadoCadastralTitularPessoaJuridica().getPessoaJuridica();
		dadosCadastrais.addBeanProperty(ASSINANTE_TIPO_PESSOA, ASSINANTE_TIPO_PESSOA_JURIDICA);
		dadosCadastrais.addBeanProperty(ASSINANTE_CNPJ, pessoaJuridica.getCnpj());
		dadosCadastrais.addBeanProperty(ASSINANTE_INSCRICAO_ESTADUAL, pessoaJuridica.getInscricaoEstadual());
		dadosCadastrais.addBeanProperty(ASSINANTE_ORGAO_EXPEDIDOR, pessoaJuridica.getOrgaoExpedidor());

		//Adiciona os dados do Registro Contrato no Bean
		if (alterarDadoCadastralTitularPessoaJuridica.getRegistroContato() != null) {
			dadosCadastrais.addBeanProperty(DADOS_REGISTRO_CONTATO_NOME_CONTATO, 
					alterarDadoCadastralTitularPessoaJuridica.getRegistroContato().getNomeContato());
			dadosCadastrais.addBeanProperty(DADOS_REGISTRO_CONTATO_DDD_TELEFONE, 
					alterarDadoCadastralTitularPessoaJuridica.getRegistroContato().getTelefoneContato()
						.getDddTelefone());
			dadosCadastrais.addBeanProperty(DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE, 
					alterarDadoCadastralTitularPessoaJuridica.getRegistroContato().getTelefoneContato()
						.getNumeroTelefone());
			dadosCadastrais.addBeanProperty(DADOS_REGISTRO_CONTATO_OBSERVACAO, 
					alterarDadoCadastralTitularPessoaJuridica.getRegistroContato().getObservacao());
		}

		//Localiza e efetua chamada ao EJB
		//Monta SOAPFaultException em caso de erro
		try {
			ManutencaoDadosCadastraisService manutencaoDadosCadastraisService = 
				super.getService(ManutencaoDadosCadastraisService.class);
			manutencaoDadosCadastraisService.alterarDadosCadastraisTitular(dadosCadastrais);
		} catch (Exception e) {
			Object[] parameters = new Object[]{RESOURCE_ALTERAR_DADOS_CADASTRAIS_TITULAR};
			SOAPFaultException soapFaultException =
				generateSOAPFaultException(RESOURCE_ERROR, parameters, RESOURCE_ERROR, e);
			
			throw soapFaultException;
		}

		this.logar("ManutencaoDadosCadastrais12V1JWS:alterarDadoCadastralTitularPessoaJuridica::Fim");
		
		return new ResultadoAlterarDadoCadastralTitularPessoaJuridicaType();
	}

	/**
	 * Operação que realiza validações dos dados cadastrais do Assinante - Pessoa Fisica.
	 * @param requestHeader
	 * informações do header
	 * @param validarDadoCadastralTitularPessoaFisica
	 * informações usadas para realizar a alteração dos dados cadastrais. 
	 * @return
	 */		
	@WebMethod(
			action="",
			operationName="validarDadoCadastralTitularPessoaFisica")
	@WebResult(
			name="resultadoValidarDadoCadastralTitularPessoaFisica", 
			partName="validarDadoCadastralTitularPessoaFisicaResponse",
			targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
	@RolesAllowed ({
			@SecurityRole (role=ALTERACAODADOSCADASTRAISLIVRES),
			@SecurityRole (role=ALTERACAODADOSCADASTRAISRESTRITOS)})
	public ResultadoValidarDadoCadastralTitularPessoaFisicaType validarDadoCadastralTitularPessoaFisica(
			@WebParam(
					name=NETHEADER, 
					partName= REQUESTHEADER, 
					header=true,
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
			NetHeaderType requestHeader,
			@WebParam(
					name="parametrosValidarDadoCadastralTitularPessoaFisica", 
					partName="validarDadoCadastralTitularPessoaFisicaRequest",
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
			ValidarDadoCadastralTitularPessoaFisicaType validarDadoCadastralTitularPessoaFisica) {

		this.logar("ManutencaoDadosCadastrais12V1JWS:validarDadoCadastralTitularPessoaFisica::Inicio");		

		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"validarDadoCadastralTitularPessoaFisica:criarHeader::Inicio");
		NETFrameworkWSHeader header = criarHeader(requestHeader);
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"validarDadoCadastralTitularPessoaFisica:criarHeader::Fim");

		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"validarDadoCadastralTitularPessoaFisica:criarBeanComDadosNetHeader::Inicio");
		DynamicBean dadosCadastrais = criarBeanComDadosNetHeader(header);
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"validarDadoCadastralTitularPessoaFisica:criarBeanComDadosNetHeader::Fim");
		
		//Adiciona os dados do Contrato no Bean 
		if (validarDadoCadastralTitularPessoaFisica.getIdentificadorContrato() != null) {
			dadosCadastrais.addBeanProperty(CONTRATO_NUM_CONTRATO, 
					Long.toString(validarDadoCadastralTitularPessoaFisica.getIdentificadorContrato()
							.getNumeroContrato()));
			dadosCadastrais.addBeanProperty(CONTRATO_CIDADE, 
					validarDadoCadastralTitularPessoaFisica.getIdentificadorContrato().getIdentificacaoCidade());
		}
		
		//Adiciona os dados do Assinante no Bean
		dadosCadastrais.addBeanProperty(ASSINANTE_NOME_TITULAR, 
				validarDadoCadastralTitularPessoaFisica.getDadoCadastralTitularPessoaFisica().getNome());
		dadosCadastrais.addBeanProperty(ASSINANTE_CODIGO_SUFRAMA, 
				validarDadoCadastralTitularPessoaFisica.getDadoCadastralTitularPessoaFisica().getCodigoSuframa());
		
		PessoaFisicaType pessoaFisica = 
			validarDadoCadastralTitularPessoaFisica.getDadoCadastralTitularPessoaFisica().getPessoaFisica();
		SimpleDateFormat dateFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance();
		dateFormat.applyPattern(DateValidator.FORMATO_CURTO);
		
		dadosCadastrais.addBeanProperty(ASSINANTE_TIPO_PESSOA, ASSINANTE_TIPO_PESSOA_FISICA);
		if (pessoaFisica.getDataNascimento() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_DATA_NASCIMENTO, 
					dateFormat.format(pessoaFisica.getDataNascimento().getTime()));
		}
		dadosCadastrais.addBeanProperty(ASSINANTE_CPF, pessoaFisica.getCpf());
		dadosCadastrais.addBeanProperty(ASSINANTE_RG, pessoaFisica.getRg());
		dadosCadastrais.addBeanProperty(ASSINANTE_ORGAO_EXPEDIDOR, pessoaFisica.getOrgaoExpedidor());
		if (pessoaFisica.getFlagEstrangeiro() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_ESTRANGEIRO, pessoaFisica.getFlagEstrangeiro().toString());
		}
		dadosCadastrais.addBeanProperty(ASSINANTE_PASSAPORTE, pessoaFisica.getPassaporte());
		dadosCadastrais.addBeanProperty(ASSINANTE_NOME_PAI, pessoaFisica.getNomePai());
		dadosCadastrais.addBeanProperty(ASSINANTE_NOME_MAE, pessoaFisica.getNomeMae());
		if (pessoaFisica.getSexo() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_SEXO, String.valueOf(pessoaFisica.getSexo()));
		}
		if (pessoaFisica.getIdentificacaoEstadoCivil() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_ESTADO_CIVIL, 
					pessoaFisica.getIdentificacaoEstadoCivil().toString());
		}
		if (pessoaFisica.getIdentificacaoProfissao() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_PROFISSAO, 
					String.valueOf(pessoaFisica.getIdentificacaoProfissao()));
		}
		if (pessoaFisica.getIdentificacaoEscolaridade() != null) {
			dadosCadastrais.addBeanProperty(ASSINANTE_ESCOLARIDADE, 
					pessoaFisica.getIdentificacaoEscolaridade().toString());
		}

		//Localiza e efetua chamada ao EJB
		//Monta SOAPFaultException em caso de erro
		try {
			ManutencaoDadosCadastraisService manutencaoDadosCadastraisService = 
				super.getService(ManutencaoDadosCadastraisService.class);
			manutencaoDadosCadastraisService.validarDadosCadastraisTitular(dadosCadastrais);
		} catch (Exception e) {
			Object[] parameters = new Object[]{RESOURCE_VALIDAR_DADOS_CADASTRAIS_TITULAR};
			SOAPFaultException soapFaultException = 
				generateSOAPFaultException(RESOURCE_ERROR, parameters, RESOURCE_ERROR, e);
			
			throw soapFaultException;
		}

		this.logar("ManutencaoDadosCadastrais12V1JWS:validarDadoCadastralTitularPessoaFisica::Fim");
		
		return new ResultadoValidarDadoCadastralTitularPessoaFisicaType();
	}

	/**
	 * Operação que realiza validações dos dados cadastrais do Assinante - Pessoa Juridica.
	 * @param requestHeader
	 * informações do header
	 * @param validarDadoCadastralTitularPessoaJuridica
	 * informações usadas para realizar a alteração dos dados cadastrais. 
	 * @return
	 */		
	@WebMethod(
			action="",
			operationName="validarDadoCadastralTitularPessoaJuridica")
	@WebResult(
			name="resultadoValidarDadoCadastralTitularPessoaJuridica", 
			partName="validarDadoCadastralTitularPessoaJuridicaResponse",
			targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
	@RolesAllowed ({
			@SecurityRole (role=ALTERACAODADOSCADASTRAISLIVRES),
			@SecurityRole (role=ALTERACAODADOSCADASTRAISRESTRITOS)})
	public ResultadoValidarDadoCadastralTitularPessoaJuridicaType validarDadoCadastralTitularPessoaJuridica(
			@WebParam(
					name=NETHEADER, 
					partName= REQUESTHEADER, 
					header=true,
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
			NetHeaderType requestHeader,
			@WebParam(
					name="parametrosValidarDadoCadastralTitularPessoaJuridica", 
					partName="validarDadoCadastralTitularPessoaJuridicaRequest",
					targetNamespace = TARGETNAMESPACEMANUTENCAODADOSCADASTRAIS)
			ValidarDadoCadastralTitularPessoaJuridicaType validarDadoCadastralTitularPessoaJuridica) {

		this.logar("ManutencaoDadosCadastrais12V1JWS::validarDadoCadastralTitularPessoaJuridica::Inicio");

		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"validarDadoCadastralTitularPessoaJuridica:criarHeader::Inicio");
		NETFrameworkWSHeader header = criarHeader(requestHeader);
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"validarDadoCadastralTitularPessoaJuridica:criarHeader::Fim");

		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"validarDadoCadastralTitularPessoaJuridica:criarBeanComDadosNetHeader::Inicio");
		DynamicBean dadosCadastrais = criarBeanComDadosNetHeader(header);
		this.logar("ManutencaoDadosCadastrais12V1JWS:" +
				"validarDadoCadastralTitularPessoaJuridica:criarBeanComDadosNetHeader::Fim");
		
		//Adiciona os dados do Contrato no Bean 
		if (validarDadoCadastralTitularPessoaJuridica.getIdentificadorContrato() != null) {
			dadosCadastrais.addBeanProperty(CONTRATO_NUM_CONTRATO, 
					Long.toString(validarDadoCadastralTitularPessoaJuridica.getIdentificadorContrato()
							.getNumeroContrato()));
			dadosCadastrais.addBeanProperty(CONTRATO_CIDADE, 
					validarDadoCadastralTitularPessoaJuridica.getIdentificadorContrato().getIdentificacaoCidade());
		}
		
		//Adiciona os dados do Assinante no Bean
		dadosCadastrais.addBeanProperty(ASSINANTE_NOME_TITULAR, 
				validarDadoCadastralTitularPessoaJuridica.getDadoCadastralTitularPessoaJuridica().getNome());
		dadosCadastrais.addBeanProperty(ASSINANTE_CODIGO_SUFRAMA, 
				validarDadoCadastralTitularPessoaJuridica.getDadoCadastralTitularPessoaJuridica().getCodigoSuframa());

		PessoaJuridicaType pessoaJuridica = 
			validarDadoCadastralTitularPessoaJuridica.getDadoCadastralTitularPessoaJuridica().getPessoaJuridica();
		dadosCadastrais.addBeanProperty(ASSINANTE_TIPO_PESSOA, ASSINANTE_TIPO_PESSOA_JURIDICA);
		dadosCadastrais.addBeanProperty(ASSINANTE_CNPJ, pessoaJuridica.getCnpj());
		dadosCadastrais.addBeanProperty(ASSINANTE_INSCRICAO_ESTADUAL, pessoaJuridica.getInscricaoEstadual());
		dadosCadastrais.addBeanProperty(ASSINANTE_ORGAO_EXPEDIDOR, pessoaJuridica.getOrgaoExpedidor());

		//Localiza e efetua chamada ao EJB
		//Monta SOAPFaultException em caso de erro
		try {
			ManutencaoDadosCadastraisService manutencaoDadosCadastraisService = 
				super.getService(ManutencaoDadosCadastraisService.class);
			manutencaoDadosCadastraisService.validarDadosCadastraisTitular(dadosCadastrais);
		} catch (Exception e) {
			Object[] parameters = new Object[]{RESOURCE_VALIDAR_DADOS_CADASTRAIS_TITULAR};
			SOAPFaultException soapFaultException = 
				generateSOAPFaultException(RESOURCE_ERROR, parameters, RESOURCE_ERROR, e);
			
			throw soapFaultException;
		}

		this.logar("ManutencaoDadosCadastrais12V1JWS:validarDadoCadastralTitularPessoaJuridica::Fim");
		
		return new ResultadoValidarDadoCadastralTitularPessoaJuridicaType();
	}


	/**
	 * Método responsável em criar um header.
	 * @param requestHeader
	 * Header do request de onde será pego os dados.
	 * @return
	 * NETFrameworkWSHeader, com as informações do header do request.
	 */
	public static NETFrameworkWSHeader criarHeader(NetHeaderType requestHeader){

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
		}

		return header;
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
