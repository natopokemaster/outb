package br.com.netservicos.netcrmcore.webservices.venda.operadora;

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
import br.com.netservicos.netcrmcore.venda.constants.OperadoraTelefoniaConstants;
import br.com.netservicos.netcrmcore.venda.telefone.facade.OperadoraTelefoniaService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;
import br.com.netservicos.netcrmcore.webservices.venda.operadora.complextypes.ListarOperadoraTelefoniaInType;
import br.com.netservicos.netcrmcore.webservices.venda.operadora.complextypes.ListarOperadoraTelefoniaOutType;

//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name = OperadoraTelefoniaConstants.WEBSERVICE_NAME, serviceName = OperadoraTelefoniaConstants.
WEBSERVICE_SERVICE_NAME, targetNamespace = OperadoraTelefoniaConstants.WEBSERVICE_TARGET)

// Anoteções das configurações de binding do web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)

@Binding(Binding.Type.SOAP12)
public class OperadoraTelefonia12V1JWS extends AbstractNETCRMCoreWS {

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
	@WebMethod(action = OperadoraTelefoniaConstants.WEB_METHOD_LISTAR_OPERADORA_TELEFONIA_ACTION)
	
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole(role="ACESSO")}) //INCLUIR_INTEGRACAO_MANIFESTACAO
	
	@WebResult(name="listarOperadoraTelefonia",
			   partName="listarOperadoraTelefoniaResponse",
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.venda.operadora.complextypes")
	public ListarOperadoraTelefoniaOutType[] listarOperadoraTelefonia(
			@WebParam(header = true, name = OperadoraTelefoniaConstants.WEB_PARAM_HEADER_NAME, 
			targetNamespace = OperadoraTelefoniaConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = OperadoraTelefoniaConstants.WEB_PARAM_LISTAR_OPERADORA_TELEFONIA_NAME, 
			targetNamespace = OperadoraTelefoniaConstants.WEB_PARAM_TARGET) 
			ListarOperadoraTelefoniaInType operadoraType) {

		getUserInfo(header); // Popula as informações do usuário
		
		// Dynamic Bean
		final DynamicBean integracaoBean = new DynamicBean();
		
		//Instancia retorno
		ListarOperadoraTelefoniaOutType[] retorno;

		// Localiza e efetua chamada ao EJB
		try {
			integracaoBean.set(OperadoraTelefoniaConstants.HEADER, header);
			integracaoBean.set(OperadoraTelefoniaConstants.
			                                        WEB_PARAM_LISTAR_OPERADORA_TELEFONIA_NAME, 
			                                        operadoraType);
			integracaoBean.addBeanProperty(OperadoraTelefoniaConstants.PNUMERO_DDD,
			                                        operadoraType.getNumeroDDD().toString());
			
			// Chama o EJB e traz os dados numa lista para 
			final OperadoraTelefoniaService telefoniaService = super.getService(OperadoraTelefoniaService.class);
			final List<?> lista = telefoniaService.listarOperadorasTelefonia(integracaoBean);
			
			//retorna a quantidade de registros
			retorno = new ListarOperadoraTelefoniaOutType[lista.size()];
			
			for (int j = 0; j < retorno.length; j++) {
				for (Object object : lista) {
					final ListarOperadoraTelefoniaOutType operadora = new ListarOperadoraTelefoniaOutType();
					final DynamicBean bean = (DynamicBean) object;
					operadora.setCodigoOperadoraTelefonia((Integer) bean.get(
					                                        OperadoraTelefoniaConstants.CODIGO_OPERADORA_TELEFONIA));
					operadora.setNomeOperadoraTelefonia(bean.get(
					                           OperadoraTelefoniaConstants.NOME_OPERADORA_TELEFONIA).toString());
					operadora.setProdutoEBT(bean.get(
					                                        OperadoraTelefoniaConstants.PRODUTO_EBT).toString());
					operadora.setNumeroDDD(bean.get(OperadoraTelefoniaConstants.NUMERO_DDD).toString());
					retorno[j] = operadora;
					j++;
				}
			}
			return retorno;
			
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_LISTAR_OPERADORA_TELEFONIA};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.
			                                        RESOURCE_ERROR_LISTAR_OPERADORA_TELEFONIA, parameters, 
			                                        WebServicesConstants.RESOURCE_ERROR_LISTAR_OPERADORA_TELEFONIA, e);
			throw exception;
		}
	}
}
