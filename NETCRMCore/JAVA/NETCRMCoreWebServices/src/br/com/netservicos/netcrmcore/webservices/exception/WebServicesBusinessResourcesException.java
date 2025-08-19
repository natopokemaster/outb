/**
 * Created on 20/02/2008
 * Project : ModuloCobrancaWebServices
 *
 * Copyright © 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Serviços.
 * 
 * $Id: WebServicesBusinessResourcesException.java,v 1.1 2009/12/03 19:07:18 jucenali Exp $
 */
package br.com.netservicos.netcrmcore.webservices.exception;

import java.util.Collection;

import br.com.netservicos.framework.util.exception.BaseBusinessResourcesException;
import static br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants.BUNDLE_KEY;

/**
 * <P><B>Description :</B><BR>
 * 	Especializa o BaseBusinessResourcesException para atender aos requisitosmdo projeto de Webservices
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Anton Vlassov
 * @since 20/02/2008
 */
public class WebServicesBusinessResourcesException extends BaseBusinessResourcesException {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -110735483694670257L;

	public WebServicesBusinessResourcesException(Collection<String> errorKeys) {
		super(errorKeys, BUNDLE_KEY);
	}

	public WebServicesBusinessResourcesException(String errorKey, Object[] errorParameters) {
		super(errorKey, errorParameters, BUNDLE_KEY);
	}

	public WebServicesBusinessResourcesException(String errorKey,
			Object[] errorParameters, Throwable cause) {
		super(errorKey, errorParameters, cause, BUNDLE_KEY);
	}

	public WebServicesBusinessResourcesException(String errorTrace) {
		super(errorTrace, BUNDLE_KEY);
	}

	public WebServicesBusinessResourcesException(String errorKey, Throwable cause) {
		super(errorKey, cause, BUNDLE_KEY);
	}

	public WebServicesBusinessResourcesException() {
		super(BUNDLE_KEY);
	}

	public WebServicesBusinessResourcesException(Throwable cause, String errorTrace) {
		super(cause, errorTrace, BUNDLE_KEY);
	}

}
