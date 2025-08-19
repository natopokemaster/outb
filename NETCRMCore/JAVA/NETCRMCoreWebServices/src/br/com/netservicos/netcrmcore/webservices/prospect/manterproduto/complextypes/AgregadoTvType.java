/*
 * Created on 08/10/2010
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
 * Classe Type que representa os dados para alteração de Produto.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 08/10/2010
 * @version 1.0
 */
public class AgregadoTvType implements BaseComplexType {

	private static final long serialVersionUID = -6802761539873099027L;
	
	private String idProduto;
    private String idPromocao;
    private String idPagamento;
    private String precoAdesao;
    private String precoMensal;

	/**
	 * Construtor Padrão.
	 */
	public AgregadoTvType(){
		super();
	}

	/**
	 * @return the idProduto
	 */
	public String getIdProduto() {
		return idProduto;
	}

	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	/**
	 * @return the idPromocao
	 */
	public String getIdPromocao() {
		return idPromocao;
	}

	/**
	 * @param idPromocao the idPromocao to set
	 */
	public void setIdPromocao(String idPromocao) {
		this.idPromocao = idPromocao;
	}

	/**
	 * @return the idPagamento
	 */
	public String getIdPagamento() {
		return idPagamento;
	}

	/**
	 * @param idPagamento the idPagamento to set
	 */
	public void setIdPagamento(String idPagamento) {
		this.idPagamento = idPagamento;
	}

	/**
	 * @return the precoAdesao
	 */
	public String getPrecoAdesao() {
		return precoAdesao;
	}

	/**
	 * @param precoAdesao the precoAdesao to set
	 */
	public void setPrecoAdesao(String precoAdesao) {
		this.precoAdesao = precoAdesao;
	}

	/**
	 * @return the precoMensal
	 */
	public String getPrecoMensal() {
		return precoMensal;
	}

	/**
	 * @param precoMensal the precoMensal to set
	 */
	public void setPrecoMensal(String precoMensal) {
		this.precoMensal = precoMensal;
	}
}
