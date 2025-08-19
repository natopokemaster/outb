/*
 * Created on 19/04/2011
 * Project : NETCRMCoreWebServices
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Type que representa os dados para gerar PDF um aviso de relacionamento.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 19/04/2011
 * @version 1.0
 */
public class DadosGerarPDFAvisoRelacionamentoType implements BaseComplexType {

	private static final long serialVersionUID = 1216549875135489412L;

	private Long identificadorAviso;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosGerarPDFAvisoRelacionamentoType(){
		super();
	}

	/**
	 * @return the identificadorAviso
	 */
	public Long getIdentificadorAviso() {
		return identificadorAviso;
	}

	/**
	 * @param identificadorAviso the identificadorAviso to set
	 */
	public void setIdentificadorAviso(Long identificadorAviso) {
		this.identificadorAviso = identificadorAviso;
	}
}
