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
 * Classe Type que representa os dados para solicitar reenvio um aviso de relacionamento.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 19/04/2011
 * @version 1.0
 */
public class DadosSolicitarReenvioAvisoRelacionamentoType implements BaseComplexType {

	private static final long serialVersionUID = 115648945619849451L;

	private Long identificadorAviso;
	private String motivo;

	/**
	 * Construtor Padrão.
	 */
	public DadosSolicitarReenvioAvisoRelacionamentoType(){
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

	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
