/*
 * Created on 27/09/2010
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
 * Classe Type que representa os dados para alteração de Produto NET Virtua.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 27/09/2010
 * @version 1.0
 */
public class DadosProdutoVirtuaDTO implements Serializable {

	private static final long serialVersionUID = 4273930815410280413L;
	
	private ProdutoDTO produto;
	private FormaAquisicaoDTO formaAquisicao;
	private ProvedorDTO provedor;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosProdutoVirtuaDTO(){
		super();
	}

	/**
	 * @return the produto
	 */
	public ProdutoDTO getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	/**
	 * @return the formaAquisicao
	 */
	public FormaAquisicaoDTO getFormaAquisicao() {
		return formaAquisicao;
	}

	/**
	 * @param formaAquisicao the formaAquisicao to set
	 */
	public void setFormaAquisicao(FormaAquisicaoDTO formaAquisicao) {
		this.formaAquisicao = formaAquisicao;
	}

	/**
	 * @return the provedor
	 */
	public ProvedorDTO getProvedor() {
		return provedor;
	}

	/**
	 * @param provedor the provedor to set
	 */
	public void setProvedor(ProvedorDTO provedor) {
		this.provedor = provedor;
	}
}
