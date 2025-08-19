package br.com.netservicos.netcrmcore.webservices.prospect.manterprospect;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.rpc.soap.SOAPFaultException;

import weblogic.jws.Binding;
import weblogic.jws.Context;
import weblogic.jws.security.RolesAllowed;
import weblogic.jws.security.SecurityRole;
import weblogic.wsee.jws.JwsContext;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.oms.constants.ManifestacaoOmbudsmanConstants;
import br.com.netservicos.netcrmcore.prospect.constants.ManutencaoProspectConstants;
import br.com.netservicos.netcrmcore.prospect.constants.ProspectConstants;
import br.com.netservicos.netcrmcore.prospect.core.facade.ProspectService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.prospect.manterprospect.complextypes.DadosProspectRetornoType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterprospect.complextypes.DadosProspectType;
import br.com.netservicos.netcrmcore.webservices.prospect.manutencaodadoscadastrais.complextypes.AlteracaoDadosCadastraisProspectType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name = ClienteConstants.WEBSERVICE_NAME_CRIAR_PROSPECT, serviceName = 
    ClienteConstants.WEBSERVICE_SERVICE_NAME_CRIAR_PROSPECT, targetNamespace = 
        ClienteConstants.WEBSERVICE_TARGET_CRIAR_PROSPECT)

// Anoteções das configurações de binding do web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)

@Binding(Binding.Type.SOAP12)
public class ManterProspect12V1JWS extends AbstractNETCRMCoreWS {

	// Declaração do contexto com anotação para injeção pelo container
	// É necessário que seja colocado na classe 'final'do webservice, caso
	// contrário a injeção ocorre
	@Context
	protected JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}

	// Nome da ação do web service
	@WebMethod(action = ClienteConstants.WEB_METHOD_CRIAR_PROSPECT_ACTION)
	
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole(role="ACESSO")}) //INCLUIR_INTEGRACAO_MANIFESTACAO
	
	@WebResult(name="criarProposta",
			   partName="criarPropostaResponse",
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.prospect.criarprospect.complextypes")
	public DadosProspectRetornoType criarProposta(
			@WebParam(header = true, name = ClienteConstants.WEB_PARAM_HEADER_NAME, 
            targetNamespace = ClienteConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = ClienteConstants.WEB_PARAM_CRIAR_PROSPECT_NAME, 
			targetNamespace = ClienteConstants.WEB_PARAM_TARGET_CRIAR_PROSPECT) DadosProspectType dadosProspectType) {

		getUserInfo(header);// Popula as informações do usuário

		// Dynamic Bean
		final DynamicBean dadosProspect = new DynamicBean();
		Bean dadosRetorno = null;
		//Instancia retorno
		final DadosProspectRetornoType retorno = new DadosProspectRetornoType();		
		Long idProspect = null;
		Long idProposta = null;
		// Localiza e efetua chamada ao EJB
		try {
			dadosProspect.set(ClienteConstants.HEADER, header);
			dadosProspect.set(ClienteConstants.WEB_PARAM_CRIAR_PROSPECT_NAME, dadosProspectType);
			dadosProspect.addBeanProperty(ProspectConstants.CID_CONTRATO, 
			dadosProspectType.getCidadeOperadora().getIdentificacaoCidade());
			dadosProspect.addBeanProperty(ProspectConstants.NOME, dadosProspectType.getNome());
			dadosProspect.addBeanProperty(ProspectConstants.DDD, dadosProspectType.getDddTelPrincipal());
			dadosProspect.addBeanProperty(ProspectConstants.TELEFONE, dadosProspectType.getTelPrincipal());
			dadosProspect.addBeanProperty(ProspectConstants.PROPERTY_COD_HP, dadosProspectType.getCodHp());			
			dadosProspect.addBeanProperty(ProspectConstants.PROPERTY_ID_MIDIA, dadosProspectType.getIdMidia());
			dadosProspect.addBeanProperty(ProspectConstants.PROPERTY_ID_CAMPAMNHA, dadosProspectType.getIdCampanha());
			dadosProspect.addBeanProperty(ProspectConstants.PROPERTY_ID_TIPO_CONTRATO,
			dadosProspectType.getIdTipoContrato());
			dadosProspect.addBeanProperty(ProspectConstants.PROPERTY_ID_TIPO_ASSINANTE, 
			dadosProspectType.getIdTipoAssinante());
			dadosProspect.addBeanProperty(ProspectConstants.PROPERTY_ID_TIPO_VENDA, dadosProspectType.getIdTipoVenda());
			dadosProspect.addBeanProperty(ProspectConstants.PROPERTY_ID_TIPO_SEGMENTO, 
			dadosProspectType.getIdTipoSegmento());
			
			
			final ProspectService prospectSerice = super.getService(ProspectService.class);
			dadosRetorno = prospectSerice.criarProposta(dadosProspect);
			idProspect = GeralUtil.toLong(dadosRetorno.getBeanProperty(ProspectConstants.ID_PROSPECT));
			idProposta = GeralUtil.toLong(dadosRetorno.getBeanProperty(ProspectConstants.ID_PROPOSTA));
			retorno.setIdProspect(idProspect);
			retorno.setIdProposta(idProposta);

		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CRIAR_PROSPECT};
			final SOAPFaultException exception =  generateSOAPFaultException(
			WebServicesConstants.RESOURCE_ERROR, parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
		return retorno;

	}
	
	
	// Nome da ação do web service
	@WebMethod(action = ManutencaoProspectConstants.WEB_METHOD_MANIFESTACAO_CONTRATO_ACTION)
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole(role="ACESSO")})
	
	public void alterarDadosCadastraisProspect(
			@WebParam(header = true, name = ManutencaoProspectConstants.WEB_PARAM_HEADER_NAME, 
			targetNamespace = ManutencaoProspectConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = ManutencaoProspectConstants.WEB_METHOD_MANIFESTACAO_CONTRATO_ACTION, 
			targetNamespace = ManutencaoProspectConstants.WEB_PARAM_TARGET) 
			AlteracaoDadosCadastraisProspectType altPropostaType) {
		
		getUserInfo(header);// Popula as informações do usuário

		final DynamicBean bean = new DynamicBean();

		try {
			
			bean.set(ManifestacaoOmbudsmanConstants.HEADER, header);
			bean.set(ManutencaoProspectConstants.ID_PROSPECT, altPropostaType.getIdProspect());
			bean.set(ManutencaoProspectConstants.ID_TIPO_PESSOA, altPropostaType.getIdTipoPessoa());
			bean.set(ManutencaoProspectConstants.DS_NOME, altPropostaType.getDsNome());
			bean.set(ManutencaoProspectConstants.DS_COMPLEMENTO, altPropostaType.getDsComplemento());
			bean.set(ManutencaoProspectConstants.SEXO, altPropostaType.getSexo());
			bean.set(ManutencaoProspectConstants.DS_EMAIL, altPropostaType.getDsEmail());
			bean.set(ManutencaoProspectConstants.DT_NASCIMENTO, altPropostaType.getDtNascimento());
			bean.set(ManutencaoProspectConstants.DS_CPF, altPropostaType.getDsCpf());
			bean.set(ManutencaoProspectConstants.DS_CNPJ, altPropostaType.getDsCnpj());
			bean.set(ManutencaoProspectConstants.DS_IE, altPropostaType.getDsIe());
			bean.set(ManutencaoProspectConstants.DS_RG, altPropostaType.getDsRg());
			bean.set(ManutencaoProspectConstants.DDD_CELULAR, altPropostaType.getDddCelular());
			bean.set(ManutencaoProspectConstants.TEL_CELULAR, altPropostaType.getTelCelular());
			bean.set(ManutencaoProspectConstants.DDD_TEL_COM, altPropostaType.getDddTelCom());
			bean.set(ManutencaoProspectConstants.TEL_COMERCIAL, altPropostaType.getTelComercial());
			bean.set(ManutencaoProspectConstants.DDD_TEL_RES, altPropostaType.getDddTelRes());
			bean.set(ManutencaoProspectConstants.TEL_RESIDENCIAL, altPropostaType.getTelResidencial());
			
			bean.set(ManutencaoProspectConstants.PROFISSAO, altPropostaType.getProfissao());
            bean.set(ManutencaoProspectConstants.ORGAO_EXPEDIDOR, altPropostaType.getOrgaoExpedidor());
            bean.set(ManutencaoProspectConstants.ESTADO_CIVIL, altPropostaType.getEstadoCivil());
			
			final ProspectService prospectService = super.getService(ProspectService.class);
			prospectService.alterarDadosPessoais(bean);

		} catch (Exception e) {
			// Monta SOAPFaultException em caso de erro
		    final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_ALTERAR_DADOS_CADASTRAIS};
            final SOAPFaultException soapException =  
                generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR,
                    parameters, WebServicesConstants.RESOURCE_ERROR, e);
            
            throw soapException;
		}

	}
	
	

}
