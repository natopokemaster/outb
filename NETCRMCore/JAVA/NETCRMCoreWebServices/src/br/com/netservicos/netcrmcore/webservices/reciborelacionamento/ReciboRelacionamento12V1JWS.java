package br.com.netservicos.netcrmcore.webservices.reciborelacionamento;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.rpc.soap.SOAPFaultException;
import javax.xml.soap.SOAPElement;

import org.w3c.dom.DOMException;

import weblogic.jws.Binding;
import weblogic.jws.Context;
import weblogic.jws.security.RolesAllowed;
import weblogic.jws.security.SecurityRole;
import weblogic.wsee.jws.JwsContext;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.gescom.util.UtilXML;
import br.com.netservicos.gescom.util.XMLFinder;
import br.com.netservicos.netcrmcore.gescom.constants.ReciboConstants;
import br.com.netservicos.netcrmcore.gescom.reciborelacionamento.facade.ReciboRelacionamentoService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.reciborelacionamento.complextypes.ReciboRelacionamentoType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

/**
 * JWS que recebe as requisi��es ao CORE, respons�vel pela cria��o dos recibos de relacionamento. 
 * Esta camada � uma casca para exposi��o do servi�o implementado no EJB. Utiliza soap 1.2
 * 
 */
//Anota��es para configura��o dos atributos do web services SOAP 1.2
@WebService(name = ReciboConstants.WEB_SERVICE_NAME, serviceName = ReciboConstants.WEB_SERVICE_SERVICE_NAME, 
		targetNamespace = ReciboConstants.WEB_SERVICE_TARGET)
// Anote��es das configura��es de binding do web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@Binding(Binding.Type.SOAP12)
public class ReciboRelacionamento12V1JWS extends AbstractNETCRMCoreWS {

	// Declara��o do contexto com anota��o para inje��o pelo container
	// � necess�rio que seja colocado na classe 'final'do webservice, caso
	// contr�rio a inje��o ocorre
	@Context
	protected JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}
	
	/**
	 * Opera��o que realiza a cria��o de um recibo relacionamento.
	 * 
	 * @param header
	 * informacoes do header enviados no request.
	 * 
	 * @param reciboRelacionamento
	 * informacoes necessarias para realizar a cria��o do recibo.
	 * 
	 * @return id do recibo relacionamento criado.
	 * 
	 * @throws DOMException
	 * @throws Exception
	 */
	
	//Nome da a��o do web service
	@WebMethod(action = ReciboConstants.WEB_METHOD_CRIAR_ACTION)
	//Defini��o das roles de acesso necess�rias para a execu��o do web services
	@RolesAllowed({@SecurityRole (role="ACESSO")})
	@WebResult(name = ReciboConstants.WEB_RESULT_CRIAR_RECIBO_NAME, 
			partName = ReciboConstants.WEB_RESULT_CRIAR_RECIBO_PARTNAME, 
			targetNamespace = ReciboConstants.WEB_RESULT_TARGET)
	public Long criarReciboRelacionamento(
		@WebParam(header = true, name = ReciboConstants.WEB_PARAM_HEADER_NAME, 
				targetNamespace = ReciboConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
		@WebParam(name = ReciboConstants.WEB_PARAM_CRIAR_NAME, 
				targetNamespace = ReciboConstants.WEB_PARAM_TARGET) ReciboRelacionamentoType reciboRelacionamento) 
	throws DOMException, Exception{getUserInfo(header);
		
		DynamicBean recibo = new DynamicBean();
		
		recibo.put(ReciboConstants.RECIBO_RELACIONAMENTO, reciboRelacionamento.getXmlReciboRelacionamento());
		ReciboRelacionamentoService reciboRelacionamentoService = this.getService(ReciboRelacionamentoService.class);
		try {
			return reciboRelacionamentoService.criarReciboRelacionamento(recibo);
		} catch (Exception e) {
			// Monta SOAPFaultException em caso de erro
			if(e.getMessage().contains(WebServicesConstants.RESOURCE_ERROR_CRIAR_RECIBO_DUPLICADO)){
				SOAPFaultException soapFaultException = generateSOAPFaultException(
						WebServicesConstants.RESOURCE_CRIAR_RECIBO_RELACIONAMENTO,  
						WebServicesConstants.RESOURCE_ERROR_CRIAR_RECIBO_DUPLICADO, e);
				throw soapFaultException;
			}else{
				SOAPElement obj =  (SOAPElement) recibo.get(ReciboConstants.RECIBO_RELACIONAMENTO);
				XMLFinder finder = new XMLFinder (UtilXML.toXMLString(obj));
				String protocolo = finder.getString(ReciboConstants.NODE_PROTOCOLO);
		
				final Object[] parameters = new Object[] {protocolo, e.getMessage()};
				final SOAPFaultException soapFaultException = generateSOAPFaultException(
						WebServicesConstants.RESOURCE_ERROR_CRIAR_RECIBO , parameters,
						WebServicesConstants.RESOURCE_ERROR_CRIAR_RECIBO, e);
				throw soapFaultException;
				
			}
		}
	}
}
