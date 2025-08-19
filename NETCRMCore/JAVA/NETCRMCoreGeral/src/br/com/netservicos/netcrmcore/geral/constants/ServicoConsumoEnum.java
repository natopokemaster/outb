/*
 * Created on 20/11/2009
 * Project : NETVendaGeral
 *
 * Copyright © 2009 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */


package br.com.netservicos.netcrmcore.geral.constants;

/**
 * <p><b>Description: </b><br>
 *
 * </p>
 * <b>
 * Issues: <br>
 *
 * </b>
 * @author marne.campos
 * @since 20/11/2009
 * @version 1.0
 */
public enum ServicoConsumoEnum {
	// TODO - OTHER É UM VALOR TEMPORÁRIO PARA APLICACAO
	APLICACAO("OTHER");
	
	
	
	private String string;
	
	public String getString(){
		return this.string;
	}
	
	/**
	 * 
	 */
	private ServicoConsumoEnum(String stringParam) {
		this.string = stringParam;
	}
}
