package br.com.netservicos.netcrmcore.webservices.consultarcontratos;

import java.util.List;

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
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants;
import br.com.netservicos.netcrmcore.cliente.contrato.facade.ConsultarContratosService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.consultarcontratos.complextypes.ConsultarContratosPorEdificacaoType;
import br.com.netservicos.netcrmcore.webservices.consultarcontratos.complextypes.ContratoRetornoType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name = ClienteConstants.WEBSERVICE_NAME, serviceName = 
ClienteConstants.WEBSERVICE_SERVICE_NAME, targetNamespace = ClienteConstants.WEBSERVICE_TARGET)

// Anoteções das configurações de binding do web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)

@Binding(Binding.Type.SOAP12)
public class ConsultarContratos12V1JWS extends AbstractNETCRMCoreWS {

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
	@WebMethod(action = ClienteConstants.WEB_METHOD_CONSULTAR_CONTRATOS_EDIFICACAO_ACTION)
	
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole(role="ACESSO")}) //INCLUIR_INTEGRACAO_MANIFESTACAO
	
	@WebResult(name="consultarContratosPorEdificacao",
			   partName="consultarContratosPorEdificacaoResponse",
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.consultarcontratos.complextypes")
	public ContratoRetornoType[] consultarContratosPorEdificacao(
			@WebParam(header = true, name = ClienteConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
			    ClienteConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = ClienteConstants.WEB_PARAM_CONSULTAR_CONTRATOS_EDIFICACAO_NAME, targetNamespace = 
			    ClienteConstants.WEB_PARAM_TARGET) ConsultarContratosPorEdificacaoType type) {

		getUserInfo(header);// Popula as informações do usuário
		
		// Dynamic Bean
		final DynamicBean integracaoContratosBean = new DynamicBean();
		
		//Instancia retorno
		ContratoRetornoType[] retorno;

		// Localiza e efetua chamada ao EJB
		try {
			integracaoContratosBean.set(ClienteConstants.HEADER, header);
			integracaoContratosBean.set(ClienteConstants.
			WEB_PARAM_CONSULTAR_CONTRATOS_EDIFICACAO_NAME, type);
			integracaoContratosBean.addBeanProperty("codigoImovel", type.getCodigoImovel());
			integracaoContratosBean.addBeanProperty("codigoHP", type.getCodigoHP());
			
			final ConsultarContratosService service = super.getService(ConsultarContratosService.class);
			final List<?> listaContrato = service.consultarContratosPorImovelAndHP(integracaoContratosBean);
			
			//retorna a quantidade de registros
			retorno = new ContratoRetornoType[listaContrato.size()];
			
			for (int j = 0; j < retorno.length; j++) {
				for (Object object : listaContrato) {
					final ContratoRetornoType contrato = new ContratoRetornoType();
					final DynamicBean dynamicBean = (DynamicBean) object;
					contrato.setCodigoStatus(dynamicBean.get("idStatus").toString());
					contrato.setDescricaoStatus(dynamicBean.get("descricaoStatus").toString());
					contrato.setCodigoAssinante(dynamicBean.get("idAssinante").toString());
					contrato.setCodigoOperadora(dynamicBean.get("codOperadora").toString());
					contrato.setCidadeContrato(dynamicBean.get("cidContrato").toString());
					contrato.setCodigoImovel(dynamicBean.get("codImovel").toString());
					contrato.setDescricaoTipoContrato(dynamicBean.get("descricaoTipoContrato").toString());
					contrato.setNumeroContrato(dynamicBean.get("numContrato").toString());
					contrato.setNomeTitular(dynamicBean.get("nomeTitular").toString());
					contrato.setDescricaoModalidade(dynamicBean.get("descricaoModalidade").toString());
					contrato.setIdTipoContrato(dynamicBean.get("idTipoContrato").toString());
					if(dynamicBean.containsKey("codHP")){
						contrato.setCodigoHP(dynamicBean.get("codHP").toString());
					}else{
						contrato.setCodigoHP("");
					}
					

					retorno[j] = contrato;
					j++;
				}
				return retorno;
			}
			return null;
			
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CONSULTAR_CONTRATOS_POR_EDIFICACAO};
			final SOAPFaultException exception =  generateSOAPFaultException(
			WebServicesConstants.RESOURCE_ERROR, parameters,WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
	}
	
}
