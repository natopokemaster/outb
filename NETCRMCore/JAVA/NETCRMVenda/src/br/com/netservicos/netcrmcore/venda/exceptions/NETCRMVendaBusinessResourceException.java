/**
 * Created on 29/06/2007
 * Project : NETBaixa
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
 * $Id: NETCRMVendaBusinessResourceException.java,v 1.1 2009/12/03 19:10:35 jucenali Exp $
 */
package br.com.netservicos.netcrmcore.venda.exceptions;

import static br.com.netservicos.netcrmcore.venda.resources.NETCRMVendaResources.BUNDLE_NAME;

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
public class NETCRMVendaBusinessResourceException extends BaseBusinessResourcesException {

	
	/**
	 * Serial version
	 */
	private static final long serialVersionUID = -2594127950127821011L;

	/**
	 * @since 29/06/2007
	 */
	public NETCRMVendaBusinessResourceException() {
		super(BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param errorTrace
	 */
	public NETCRMVendaBusinessResourceException(String errorTrace) {
		super(errorTrace, BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param errorKeys
	 */
	public NETCRMVendaBusinessResourceException(Collection<String> errorKeys) {
		super(errorKeys, BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param cause
	 * @param errorTrace
	 */
	public NETCRMVendaBusinessResourceException(Throwable cause, String errorTrace) {
		super(cause, errorTrace, BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param errorKey
	 * @param cause
	 */
	public NETCRMVendaBusinessResourceException(String errorKey, Throwable cause) {
		super(errorKey, cause, BUNDLE_NAME);
	}

	/**
	 * @since 29/06/2007
	 * @param errorKey
	 * @param errorParameters
	 * @param cause
	 */
	public NETCRMVendaBusinessResourceException(String errorKey,
			Object[] errorParameters, Throwable cause) {
		super(errorKey, errorParameters, cause, BUNDLE_NAME);
	}
	
	/**
	 * @since 29/06/2007
	 * @param errorKey
	 * @param errorParameters
	 * @param cause
	 */
	public NETCRMVendaBusinessResourceException(String errorKey,
			Object[] errorParameters) {
		super(errorKey, errorParameters, BUNDLE_NAME);
	}

}
