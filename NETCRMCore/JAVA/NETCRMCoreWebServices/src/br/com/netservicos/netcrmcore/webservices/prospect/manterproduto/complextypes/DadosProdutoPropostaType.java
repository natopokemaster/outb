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

package br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Type que representa os dados para manter Produto.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 */
public class DadosProdutoPropostaType implements BaseComplexType {

	private static final long serialVersionUID = 4272930613410280413L;

	private IdentificacaoOperadoraType cidadeOperadora;	
	private Long idProposta;
	private DadosProdutoTvType[] lstProdutoTvType;
	private DadosProdutoVirtuaType[] lstProdutoVirtuaType;
	private DadosProdutoFoneType[] lstProdutoFoneType;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosProdutoPropostaType(){
		super();
	}
	
	/**
	 * @return the cidadeOperadora
	 */
	public IdentificacaoOperadoraType getCidadeOperadora() {
		return cidadeOperadora;
	}

	/**
	 * @param cidadeOperadora the cidadeOperadora to set
	 */
	public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
		this.cidadeOperadora = cidadeOperadora;
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
	 * @return the lstProdutoTvType
	 */
	public DadosProdutoTvType[] getLstProdutoTvType() {
		return lstProdutoTvType;
	}

	/**
	 * @param lstProdutoTvType the lstProdutoTvType to set
	 */
	public void setLstProdutoTvType(DadosProdutoTvType[] lstProdutoTvType) {
		this.lstProdutoTvType = lstProdutoTvType;
	}

	/**
	 * @return the lstProdutoVirtuaType
	 */
	public DadosProdutoVirtuaType[] getLstProdutoVirtuaType() {
		return lstProdutoVirtuaType;
	}

	/**
	 * @param lstProdutoVirtuaType the lstProdutoVirtuaType to set
	 */
	public void setLstProdutoVirtuaType(DadosProdutoVirtuaType[] lstProdutoVirtuaType) {
		this.lstProdutoVirtuaType = lstProdutoVirtuaType;
	}

	/**
	 * @return the lstProdutoFoneType
	 */
	public DadosProdutoFoneType[] getLstProdutoFoneType() {
		return lstProdutoFoneType;
	}

	/**
	 * @param lstProdutoFoneType the lstProdutoFoneType to set
	 */
	public void setLstProdutoFoneType(DadosProdutoFoneType[] lstProdutoFoneType) {
		this.lstProdutoFoneType = lstProdutoFoneType;
	}
}
