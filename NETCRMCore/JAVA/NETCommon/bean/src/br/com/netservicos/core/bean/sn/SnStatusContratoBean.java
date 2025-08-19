/*
 * Created on 04/02/2005
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_status_contrato.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 15/09/2010 Wellington     N/A      Entidades      Created. 
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_status_contrato"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="false"
 *                   
 * @hibernate.cache
 *      usage="read-write"
 * 
 * 
 */
public class SnStatusContratoBean extends DomainBean {

	private static final String ATRIBUTO_ID_STATUS_CONTRATO = "idStatusContrato";

	private Integer idStatusContrato;

	private String descricao;

	private String codCor;

	private Integer instalado;

	/**
	 *  
	 */
	public SnStatusContratoBean() {
		super(ATRIBUTO_ID_STATUS_CONTRATO);
	}

	/**
	 * @return Returns the idStatusContrato.
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * unsaved-value = "null"
	 * column="id_status_contrato"
	 * type = "int"
	 * 
	 */
	public Integer getIdStatusContrato() {
		return idStatusContrato;
	}

	/**
	 * @param idStatusContrato The idStatusContrato to set.
	 * 
	 */
	public void setIdStatusContrato(Integer idStatusContrato) {
		this.idStatusContrato = idStatusContrato;
	}

	/**
	 * Obtains and returns the new value of the codCor attribute.
	 *
	 * @return Returns the codCor.
	 * 
	 * @hibernate.property
	 * column="cod_cor"
	 * type = "string"
	 * 
	 */
	public String getCodCor() {
		return codCor;
	}

	/**
	 * @param codCor The codCor to set.
	 * 
	 */
	public void setCodCor(String codCor) {
		this.codCor = codCor;
	}

	/**
	 * Obtains and returns the new value of the descricao attribute.
	 *
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * column="descricao"
	 * type = "string"
	 * 
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao The descricao to set.
	 * 
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Obtains and returns the new value of the instalado attribute.
	 *
	 * @return Returns the instalado.
	 * 
	 * @hibernate.property
	 * column="instalado"
	 * type = "int"
	 * 
	 */
	public Integer getInstalado() {
		return instalado;
	}

	/**
	 * @param instalado The instalado to set.
	 * 
	 */
	public void setInstalado(Integer instalado) {
		this.instalado = instalado;
	}

}
