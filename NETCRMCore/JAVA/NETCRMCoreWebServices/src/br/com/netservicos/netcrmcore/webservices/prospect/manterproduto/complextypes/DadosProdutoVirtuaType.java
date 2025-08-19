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

package br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

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
public class DadosProdutoVirtuaType implements BaseComplexType {

	private static final long serialVersionUID = 4273930815410280413L;
	
	private ProdutoType produto;
	private FormaAquisicaoType formaAquisicao;
	private ProvedorType provedor;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosProdutoVirtuaType(){
		super();
	}

	/**
	 * @return the produto
	 */
	public ProdutoType getProduto() {
		return produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(ProdutoType produto) {
		this.produto = produto;
	}

	/**
	 * @return the formaAquisicao
	 */
	public FormaAquisicaoType getFormaAquisicao() {
		return formaAquisicao;
	}

	/**
	 * @param formaAquisicao the formaAquisicao to set
	 */
	public void setFormaAquisicao(FormaAquisicaoType formaAquisicao) {
		this.formaAquisicao = formaAquisicao;
	}

	/**
	 * @return the provedor
	 */
	public ProvedorType getProvedor() {
		return provedor;
	}

	/**
	 * @param provedor the provedor to set
	 */
	public void setProvedor(ProvedorType provedor) {
		this.provedor = provedor;
	}
}
