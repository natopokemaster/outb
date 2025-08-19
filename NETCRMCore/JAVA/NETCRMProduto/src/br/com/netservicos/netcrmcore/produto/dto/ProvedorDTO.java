/*
 * Created on 28/09/2010
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
 * Classe Type que representa os dados para alteração de Provedor.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 28/09/2010
 * @version 1.0
 */
public class ProvedorDTO implements Serializable {

	private static final long serialVersionUID = 4273941815450280413L;

	private String idTipoPonto;
	private String idProduto;
    private String idPromocao;
    private String idLocalizacao;
    private String idPagamento;
    private String idCaracteristica;
    private String precoAdesao;
    private String precoMensal;
	
	/**
	 * Construtor Padrão.
	 */
	public ProvedorDTO(){
		super();
	}

	/**
	 * @return the idTipoPonto
	 */
	public String getIdTipoPonto() {
		return idTipoPonto;
	}

	/**
	 * @param idTipoPonto the idTipoPonto to set
	 */
	public void setIdTipoPonto(String idTipoPonto) {
		this.idTipoPonto = idTipoPonto;
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
	 * @return the idLocalizacao
	 */
	public String getIdLocalizacao() {
		return idLocalizacao;
	}

	/**
	 * @param idLocalizacao the idLocalizacao to set
	 */
	public void setIdLocalizacao(String idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
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
	 * @return the idCaracteristica
	 */
	public String getIdCaracteristica() {
		return idCaracteristica;
	}

	/**
	 * @param idCaracteristica the idCaracteristica to set
	 */
	public void setIdCaracteristica(String idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
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
