/**
 * Created on 29/06/2007
 * Project : NETBaixa
 *
 * Copyright � 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Servi�os.
 * 
 * $Id: NETCRMEventBusinessResourceException.java,v 1.1 2009/12/03 19:08:26 jucenali Exp $
 */
package br.com.netservicos.netcrmcore.event.exceptions;

import static br.com.netservicos.netcrmcore.event.resources.NETCRMEventResources.BUNDLE_NAME;

import java.util.Collection;

import br.com.netservicos.framework.util.exception.BaseBusinessResourcesException;

/**
 * <P><B>Description :</B><BR>
 * 	Exception to be used for all business exceptions of the module NETExamplo
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Robin Michael Gray
 * @since 29/06/2007
 */
public class NETCRMEventBusinessResourceException extends BaseBusinessResourcesException {

	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2594127950127821011L;

	/**
	 * @since 29/06/2007
	 */
	public NETCRMEventBusinessResourceException() {
		super(BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param errorTrace
	 */
	public NETCRMEventBusinessResourceException(String errorTrace) {
		super(errorTrace, BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param errorKeys
	 */
	public NETCRMEventBusinessResourceException(Collection<String> errorKeys) {
		super(errorKeys, BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param cause
	 * @param errorTrace
	 */
	public NETCRMEventBusinessResourceException(Throwable cause, String errorTrace) {
		super(cause, errorTrace, BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param errorKey
	 * @param cause
	 */
	public NETCRMEventBusinessResourceException(String errorKey, Throwable cause) {
		super(errorKey, cause, BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param errorKey
	 * @param errorParameters
	 * @param cause
	 */
	public NETCRMEventBusinessResourceException(String errorKey,
			Object[] errorParameters, Throwable cause) {
		super(errorKey, errorParameters, cause, BUNDLE_NAME);
	}
	
	/**
	 * @since 29/06/2007
	 * @param errorKey
	 * @param errorParameters
	 * @param cause
	 */
	public NETCRMEventBusinessResourceException(String errorKey,
			Object[] errorParameters) {
		super(errorKey, errorParameters, BUNDLE_NAME);
	}

}
