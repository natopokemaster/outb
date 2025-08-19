/**
 * Created on 20/02/2008
 * Project : ModuloCobrancaWebServices
 *
 * Copyright  2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Servicos.
 * 
 * $Id: AbstractWeblogicWS.java,v 1.3 2011/01/24 18:05:49 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.webservices;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.handler.MessageContext;

import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axiom.soap.SOAP12Constants;

import weblogic.wsee.jws.JwsContext;
import weblogic.wsee.jws.Protocol;
import br.com.netservicos.framework.web.ws.AbstractBaseWS;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

/**
 * 
 * <P><B>Description :</B><BR>
 * 	Abstract instance of the WebService specific for the WebLogic environment.
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Anton Vlassov
 * @since 20/02/2008
 */
public abstract class AbstractWeblogicWS extends AbstractBaseWS {

	static {
		System.setProperty("javax.xml.soap.SOAPFactory", "weblogic.xml.saaj.SOAPFactoryImpl");
	}	
	/**
	 * Retrieve the context for the request.<br>
	 * Weblogic does not inject annotations into the abstract classes of the webservices.<br>
	 * The implementation must declare a classe variable and the annotation :<br>
	 * <code>
	 * @Context
	 * protected JwsContext context;
	 * </code>
	 * @since 20/02/2008
	 * @return instance of the context
	 */
	protected abstract JwsContext getWSContext();

	/**
	 * Gets the servlets request from the web context.
	 * 
	 * @see br.com.netservicos.framework.web.ws.AbstractBaseWS#getServletRequest()
	 */
	protected HttpServletRequest getServletRequest() {
		JwsContext webServiceContext = this.getWSContext();
		if (webServiceContext != null) {
			HttpServletRequest request = (HttpServletRequest) webServiceContext.getMessageContext()
											.getProperty(MessageContext.SERVLET_REQUEST);
			return request;
		} else {
			log.debug("WebServiceContext is not available using the state of this class for variables. " +
					"See Bug WebServiceContext");
			return null;
		}
	}

	/**
	 * Overrides super method setSoapEnvelopeNamespace
	 * 
	 * Set soapEnvelopeNamespace based on informations from the WebLogic request/context
	 * 
	 * Defaults to SOAP 1.1
	 *  
	 * @author Gustavo Dalla Nora
	 * @since 29/09/2009
	 *  
	 */
	@Override
	public void setSoapEnvelopeNamespace() {
		Protocol protocolo = this.getWSContext().getProtocol();
		this.soapEnvelopeNamespace = SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI;
    	String currSOAPFactory = System.getProperty("javax.xml.soap.SOAPFactory");
    	
    	/*
    	if (SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI.equals(this.soapEnvelopeNamespace)){
    			
    	} else {
    			
    	}
    	*/
    	
		System.setProperty("javax.xml.soap.SOAPFactory", currSOAPFactory);
		
		if (Protocol.isSoap11(protocolo)) {
			this.soapEnvelopeNamespace = SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI;
			this.soapFactoryClassName = WebServicesConstants.WEBLOGIC_SOAP11_FACTORY;
		}
		if (Protocol.isSoap12(protocolo)) {
			this.soapEnvelopeNamespace = SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI;
			this.soapFactoryClassName = WebServicesConstants.WEBLOGIC_SOAP12_FACTORY;
		}
	}
	
	/**
	 * Get the Principal if the WebServiceContext is available
	 * @return Principal id the WebServiceContext is available else null
	 */
	protected Principal getPrincipal() {
		
		JwsContext webServiceContext = this.getWSContext();
		if (webServiceContext != null) {
			return webServiceContext.getCallerPrincipal();
		} else {
			return null;
		}
	}

}
