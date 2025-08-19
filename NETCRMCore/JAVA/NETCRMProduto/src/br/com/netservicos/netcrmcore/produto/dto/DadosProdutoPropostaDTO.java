/*
 * Created on 20/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.netcrmcore.produto.dto;

import java.io.Serializable;


/**
 * <p>
 * <b>Description: </b><br>
 * Classe DTO que representa os dados para manter Produto.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 */
public class DadosProdutoPropostaDTO implements Serializable {

	private static final long serialVersionUID = 4272930613410280413L;

	private Long idProposta;
	private DadosProdutoTvDTO dadosProdutoNetTvDTO;
	private DadosProdutoVirtuaDTO dadosProdutoNetVirtuaDTO;
	private DadosProdutoFoneDTO dadosProdutoNetFoneDTO;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosProdutoPropostaDTO(){
		super();
	}

	/**
	 * @return the idProposta
	 */
	public Long getIdProposta() {
		return idProposta;
	}

	/**
	 * @param idProposta the idProposta to set
	 */
	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}
	
	/**
	 * @return the dadosProdutoNetTvDTO
	 */
	public DadosProdutoTvDTO getDadosProdutoNetTvDTO() {
		return dadosProdutoNetTvDTO;
	}

	/**
	 * @param dadosProdutoNetTvDTO the dadosProdutoNetTvDTO to set
	 */
	public void setDadosProdutoNetTvDTO(DadosProdutoTvDTO dadosProdutoNetTvDTO) {
		this.dadosProdutoNetTvDTO = dadosProdutoNetTvDTO;
	}

	/**
	 * @return the dadosProdutoNetVirtuaDTO
	 */
	public DadosProdutoVirtuaDTO getDadosProdutoNetVirtuaDTO() {
		return dadosProdutoNetVirtuaDTO;
	}

	/**
	 * @param dadosProdutoNetVirtuaDTO the dadosProdutoNetVirtuaDTO to set
	 */
	public void setDadosProdutoNetVirtuaDTO(DadosProdutoVirtuaDTO dadosProdutoNetVirtuaDTO) {
		this.dadosProdutoNetVirtuaDTO = dadosProdutoNetVirtuaDTO;
	}

	/**
	 * @return the dadosProdutoNetFoneDTO
	 */
	public DadosProdutoFoneDTO getDadosProdutoNetFoneDTO() {
		return dadosProdutoNetFoneDTO;
	}

	/**
	 * @param dadosProdutoNetFoneDTO the dadosProdutoNetFoneDTO to set
	 */
	public void setDadosProdutoNetFoneDTO(DadosProdutoFoneDTO dadosProdutoNetFoneDTO) {
		this.dadosProdutoNetFoneDTO = dadosProdutoNetFoneDTO;
	}
}
