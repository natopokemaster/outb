/*
 * Created on 31/03/2011
 * Project : NETGESCOMCommon
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.av.types;

import br.com.netservicos.framework.util.exception.BaseFailureException;

/**
 *
 * <p>
 * <b>Description: </b><br>
 * Define o tipo de configuração de condição para exibição de frases.
 * </p>
 * <b> Issues: <br>
 *
 * </b>
 *
 * @author diego.amaral
 * @since 06/05/2011
 * @version
 */
public enum TipoCondicao {

	JAVA_CLASS("J"), XPATH_EXPR("X");

	/**
	 * Valor (key) do tipo de condição.
	 */
	private String value;
	
	/**
	 * Constroi um tipo de condição.
	 * 
	 * @param value - chave da condição.
	 */
	private TipoCondicao(final String value) {
		this.value = value;
	}
	/**
	 *
	 * <p><b>Description:</b><br/>
	 * Valor (key) do tipo de condição.
	 * <p>
	 * @return
	 * @since 29/06/2011
	 * @author diego.amaral
	 */
	public String getValue() {
		return this.value;
	}
	/**
	 *
	 * <p><b>Description:</b><br/>
	 * Obtém um tipo de condição pela chave. Uma exceção é lançada se a chave não for encontrado.
	 * <p>
	 * @param value
	 * @return
	 * @since 29/06/2011
	 * @author diego.amaral
	 */
	public static TipoCondicao fromValue(final String value) {

		for (final TipoCondicao val : values()) {
			if (val.value.equals(value)) {
				return val;
			}
		}
		throw new BaseFailureException("Valor '" + value + "' invalido para "+ TipoCondicao.class);

	}

}
