/**
 * Created on 20/02/2008
 * Project : ModuloCobrancaWebServices
 *
 * Copyright 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Servicos.
 * 
 * $Id: AbstractNETCRMCoreWS.java,v 1.1 2009/12/03 19:07:16 jucenali Exp $
 */
package br.com.netservicos.netcrmcore.webservices;

import javax.xml.rpc.soap.SOAPFaultException;

import org.apache.commons.lang.StringUtils;
import org.w3c.dom.Document;

import br.com.netservicos.framework.auth.util.jaas.SecurityParametersEnum;
import br.com.netservicos.framework.util.BaseConstants;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;


/**
 * 
 * <P><B>Description :</B><BR>
 * 	Abstract Classe for the webservices - NET Modelo - projeto de exemplo
 * 
 * </B>
 * @author Anton Vlassov
 * @since 20/02/2008
 */
public abstract class AbstractNETCRMCoreWS extends AbstractWeblogicWS {

	/**
	 * Key which represents the database in which the user was authenticated
	 * TODO constant - Loginaction
	 */
	private static final String IDENTITY_BASE = SecurityParametersEnum.IDENTIFICATION_DATABASE.identifier;
	
	
	/**
	 * Gets the database service from the identity of the database and the prefix of the database service.
	 * 
	 * @see br.com.netservicos.framework.web.ws.AbstractBaseWS#getDatabaseService()
	 */
	@Override
	protected String getDatabaseService() {
		
		String identityBase = getPrincipalProperties().getProperty(IDENTITY_BASE);
		if (StringUtils.isNotBlank(identityBase)) { 
			String currentDBService = GeralConstants.PREFIXO_DATABASE_SERVICE + identityBase; 
			getPrincipalProperties().setProperty(BaseConstants.CURRENT_DB_SERVICE, currentDBService);
			return currentDBService;
		} else {
			throw new IllegalArgumentException("Not possible get the database service for the user. " +
					"The identity base was not found.");
		}
	}

	/**
	 * Generates a SOAPFaultException.
	 * @since 26/02/2008
	 * @param resourceKey Key for the resource message
	 * @param resourceParameters The paramters for the resource message
	 * @param faultCodeKey Key of the resource fault code
	 * @return SOAPFaultException
	 */
	protected SOAPFaultException generateSOAPFaultException(String resourceKey, Object[] resourceParameters, String faultCodeKey) {
		return super.generateSOAPFaultException(WebServicesConstants.BUNDLE_KEY, resourceKey,
				resourceParameters, faultCodeKey);
	}

	/**
	 * Generates a SOAPFaultException.
	 * @since 26/02/2008
	 * @param resourceKey Key for the resource message
	 * @param faultCodeKey Key of the resource fault code
	 * @return SOAPFaultException 
	 */
	protected SOAPFaultException generateSOAPFaultException(String resourceKey, String faultCodeKey) {
		return super.generateSOAPFaultException(WebServicesConstants.BUNDLE_KEY, resourceKey, faultCodeKey);
	}

	/**
	 * Generates a SOAPFaultException.
	 * @since 26/02/2008
	 * @param resourceKey Key for the resource message
	 * @param resourceParameters The paramters for the resource message
	 * @param faultCodeKey Key of the resource fault code
	 * @param throwable Exception which caused the error
	 * @return SOAPFaultException
	 */
	protected SOAPFaultException generateSOAPFaultException(String resourceKey, String faultCodeKey,
			Throwable throwable) {
		return super.generateSOAPFaultException(WebServicesConstants.BUNDLE_KEY, resourceKey,
				null, faultCodeKey, throwable);
	}
	
	/**
	 * Generates a SOAPFaultException.
	 * @since 26/02/2008
	 * @param resourceKey Key for the resource message
	 * @param resourceParameters The paramters for the resource message
	 * @param faultCodeKey Key of the resource fault code
	 * @param throwable Exception which caused the error
	 * @return SOAPFaultException
	 */
	protected SOAPFaultException generateSOAPFaultException(String resourceKey, Object[] resourceParameters, String faultCodeKey,
			Throwable throwable) {
		return super.generateSOAPFaultException(WebServicesConstants.BUNDLE_KEY, resourceKey,
				resourceParameters, faultCodeKey, throwable);
	}	

	/**
	 * Generates a SOAPFaultException.
	 * @since 26/02/2008
	 * @param resourceKey Key for the resource message
	 * @param resourceParameters The paramters for the resource message
	 * @param faultCodeKey Key of the resource fault code
	 * @param faultDetail Extra information to be included in the fault detail, this can be passed as null
	 * @return SOAPFaultException
	 */
	protected SOAPFaultException generateSOAPFaultException(String resourceKey, Object[] resourceParameters,
			String faultCodeKey, Document faultDetail) {
		return super.generateSOAPFaultException(WebServicesConstants.BUNDLE_KEY, resourceKey,
				resourceParameters, faultCodeKey, faultDetail);
	}

	/**
	 * Generates a SOAPFaultException.
	 * @since 26/02/2008
	 * @param resourceKey Key for the resource message
	 * @param resourceParameters The paramters for the resource message
	 * @param faultCodeKey Key of the resource fault code
	 * @param throwable Exception which caused the error, this can be passed as null
	 * @param faultDetail Extra information to be included in the fault detail, this can be passed as null
	 * @return SOAPFaultException
	 */
	protected SOAPFaultException generateSOAPFaultException(String resourceKey, Object[] resourceParameters,
			String faultCodeKey, Throwable throwable, Document faultDetail) {
		return super.generateSOAPFaultException(WebServicesConstants.BUNDLE_KEY, resourceKey,
				resourceParameters, faultCodeKey, throwable, faultDetail);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.web.ws.AbstractBaseWS#getMessage(java.lang.String, java.lang.String, java.lang.Object[])
	 */
	protected String getMessage(String resourceKey, Object[] resourceParameters) {
		return super.getMessage(WebServicesConstants.BUNDLE_KEY, resourceKey, resourceParameters);
	}

	/**
	 * 
	 * @see br.com.netservicos.framework.web.ws.AbstractBaseWS#getMessage(java.lang.String, java.lang.String)
	 */
	protected String getMessage(String resourceKey) {
		return super.getMessage(WebServicesConstants.BUNDLE_KEY, resourceKey);
	}
	
	/**
	 * Metodo para montar uma SoapFault propagando a excecao de negocio
	 * @param businessMessage
	 * @param faultCodeKey
	 * @param resourceKey
	 * @return SOAPFaultException
	 */
	protected SOAPFaultException generateSOAPFaultException(String businessMessage, String faultCodeKey, String resourceKey ) {
		
		return super.generateSOAPFaultException(businessMessage,WebServicesConstants.BUNDLE_KEY, resourceKey, null, faultCodeKey, null, null);
	}
	
}
