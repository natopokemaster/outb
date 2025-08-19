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
 * Classe Type que representa os dados para alteração de Produto NET Fone.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 27/09/2010
 * @version 1.0
 */
public class DadosProdutoFoneType implements BaseComplexType {

	private static final long serialVersionUID = 4273930815410280413L;
	
	private ProdutoType produto;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosProdutoFoneType(){
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
}
