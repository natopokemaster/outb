/*
 * Created on 21/06/2005
 * Project : ADM 
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
 * @author :Luciano Teixeira
 * @version :
 * <P>
 * <B> Description :Classe Bean que representa a tabela sn_rel_tp_assinante_tp_solic. 
 * </B> 
 * <BR>
 * TODO:
 * </P>
 * <P>
 * <B> Issues : </B> 
 * <PRE>
 * 
 * ===========================================================================
 *	Description 							 Date 	     By 
 *	---------------------------------------- ----------- ---------------------
 *  ==========================================================================
 * 
 * </PRE>
 * 
 * <P>
 *          <B> Revision History: </B>
 * 
 * <PRE>
 * 
 * ===========================================================================
 * Prior Date By 				Version  Description 
 * ---------- ----------------  -------- -------------------------------------
 * 21/06/2005 Luciano Teixeira  N/A      Created
 * ===========================================================================
 * 
 * </PRE>
 * @hibernate.class table = "sn_rel_tp_assinante_tp_solic"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"       
 *                   proxy = "br.com.netservicos.core.bean.sn.SnRelTipoAssinanteTipoSolicBean"                                                                      					 
 * 					 lazy="true"
 * 
 * @hibernate.query name  =  "lstSnRelTipoSolicTipoAssinanteByTipoAssinante"
 *                   query = "SELECT relationship.compositeKey.tipoAssinante.idTipoAssinante,
 *                   				 relationship.compositeKey.tipoSolic.idTipoSolic,
 *                   				 relationship.compositeKey.tipoSolic.descricao,                   
 *                                   relationship.adesao 
 *                            FROM	SnRelTipoAssinanteTipoSolicBean relationship
 *                   		 WHERE relationship.compositeKey.tipoAssinante.idTipoAssinante = :tipoAssinante.idTipoAssinante"
 *                            
 * 
 */

public class SnRelTipoAssinanteTipoSolicBean extends WebBean {

	private SnRelTipoAssinanteTipoSolicitacaoKey compositeKey;
	private Integer adesao;

	public SnRelTipoAssinanteTipoSolicBean() {
		super("compositeKey");
	}

	/**
	 * @hibernate.id 
	 * type = "composite"
	 */
	public SnRelTipoAssinanteTipoSolicitacaoKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(
			SnRelTipoAssinanteTipoSolicitacaoKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * @hibernate.property 
	 * column = "adesao"
	 * type = "int"
	 * @return
	 */
	public Integer getAdesao() {
		return adesao;
	}

	/**
	 * 
	 * @param adesao the adesao to set.
	 */
	public void setAdesao(Integer adesao) {
		this.adesao = adesao;
	}

	public boolean equals(Object obj) {
		if (obj instanceof SnRelTipoAssinanteTipoSolicBean) {
			return this.compositeKey
					.equals(((SnRelTipoAssinanteTipoSolicBean) obj)
							.getCompositeKey());
		} else {
			return false;
		}
	}
}