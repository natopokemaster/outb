/*
 * Created on 25/01/2005
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

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_tipo_contrato.
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
 * Date       By             Version  Project/CSR     Description
 * ---------- -------------- -------- --------------- ---------------------------
 * 25/01/2005 Ramon Carvalho N/A      Entidades       Created.
 * 25/01/2005 Ramon Carvalho 1.0      Entidades       Development.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_tipo_contrato"
 *                  lazy="false"
 *                  
 * @hibernate.cache
 *      usage = "read-write"
 *
 * @hibernate.query name  = "lstSnTipoContrato"
 *                   query = "SELECT tipoContrato.idTipoContrato, tipoContrato.descricao 
 *                            FROM br.com.netservicos.core.bean.sn.SnTipoContratoBean tipoContrato"
 * 
 * 
 */
public class SnTipoContratoBean extends WebBean {

	private Integer idTipoContrato;

	private String descricao;

	public static final String ATRIBUTO_ID_TIPO_CONTRATO = "idTipoContrato";

	/**
	 *  
	 */
	public SnTipoContratoBean() {
		super(ATRIBUTO_ID_TIPO_CONTRATO);
	}

	/**
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * unsaved-value = "null"
	 * column="id_tipo_contrato"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getIdTipoContrato() {
		return idTipoContrato;
	}

	/**
	 * @param idTipoContrato The idTipoContrato to set.
	 * 
	 */
	public void setIdTipoContrato(Integer idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
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

}
