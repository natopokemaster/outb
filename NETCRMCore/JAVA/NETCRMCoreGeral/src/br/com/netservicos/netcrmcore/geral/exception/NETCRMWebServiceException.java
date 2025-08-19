/*
 * Created on 16/04/2010
 * Project : NETVendaGeral
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.netcrmcore.geral.exception;

import static br.com.netservicos.netcrmcore.geral.resources.GeralResources.BUNDLE_KEY;
import br.com.netservicos.framework.util.exception.BaseBusinessException;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe utilizada para Web Services.
 * </p>
 * <b>
 * Issues: <br>
 * </b>
 * 
 * @author mauricio.araujo
 * @since 16/04/2010
 * @version 1.0
 */
public class NETCRMWebServiceException extends BaseBusinessException {
	/**
	 * . Serial version
	 */
	private static final long serialVersionUID = -2594127950127821011L;

	/**
	 * . String
	 */
	private String mensagemErro;

	/**
	 * @since 29/06/2007
	 */
	public NETCRMWebServiceException() {
		super(BUNDLE_KEY);
	}

	/**
	 * Método construtor da classe.
	 * 
	 * @param cause
	 *            Rebece a exceção causada.
	 * @param errorTrace
	 *            Recebe a mensagem do erro.
	 * @param msg
	 *            the msg
	 */
	public NETCRMWebServiceException(final String errorTrace, final Throwable cause, final String msg) {
		super();
		super.setErrorTrace(errorTrace);
		super.setStackTrace(cause.getStackTrace());
		this.mensagemErro = msg;
	}

	/**
	 * Método construtor da classe.
	 * 
	 * @param cause
	 *            Rebece a exceção causada.
	 * @param errorTrace
	 *            Recebe a mensagem do erro.
	 * @param msg
	 *            the msg
	 */
	public NETCRMWebServiceException(final Throwable cause, final String errorTrace, final String msg) {
		super();
		super.setErrorTrace(errorTrace);
		super.setStackTrace(cause.getStackTrace());

		this.mensagemErro = msg;
	}

	/**
	 * @return the mensagemErro
	 */
	public String getMensagemErro() {
		return this.mensagemErro;
	}

	/**
	 * @param pMensagemErro
	 *            the mensagemErro to set
	 */
	public void setMensagemErro(final String pMensagemErro) {
		this.mensagemErro = pMensagemErro;
	}
}
