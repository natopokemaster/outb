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
public class DadosAgregadoPropostaType implements BaseComplexType {

	private static final long serialVersionUID = 4272930613410280413L;

	private IdentificacaoOperadoraType cidadeOperadora;	
	private Long idProposta;
	private AgregadoTvType[] lstAgregadoTvType;
	private AgregadoVirtuaType[] lstAgregadoVirtuaType;
	private AgregadoFoneType[] lstAgregadoFoneType;
	
	/**
	 * Construtor Padrão.
	 */
	public DadosAgregadoPropostaType(){
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
	 * @return the lstAgregadoTvType
	 */
	public AgregadoTvType[] getLstAgregadoTvType() {
		return lstAgregadoTvType;
	}

	/**
	 * @param lstAgregadoTvType the lstAgregadoTvType to set
	 */
	public void setLstAgregadoTvType(AgregadoTvType[] lstAgregadoTvType) {
		this.lstAgregadoTvType = lstAgregadoTvType;
	}

	/**
	 * @return the lstAgregadoVirtuaType
	 */
	public AgregadoVirtuaType[] getLstAgregadoVirtuaType() {
		return lstAgregadoVirtuaType;
	}

	/**
	 * @param lstAgregadoVirtuaType the lstAgregadoVirtuaType to set
	 */
	public void setLstAgregadoVirtuaType(AgregadoVirtuaType[] lstAgregadoVirtuaType) {
		this.lstAgregadoVirtuaType = lstAgregadoVirtuaType;
	}

	/**
	 * @return the lstAgregadoFoneType
	 */
	public AgregadoFoneType[] getLstAgregadoFoneType() {
		return lstAgregadoFoneType;
	}

	/**
	 * @param lstAgregadoFoneType the lstAgregadoFoneType to set
	 */
	public void setLstAgregadoFoneType(AgregadoFoneType[] lstAgregadoFoneType) {
		this.lstAgregadoFoneType = lstAgregadoFoneType;
	}
}
