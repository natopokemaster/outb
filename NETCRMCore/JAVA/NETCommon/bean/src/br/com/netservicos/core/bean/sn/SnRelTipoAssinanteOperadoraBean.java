/**
 * Created on 20/06/2005
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
 * <B> Description :Classe Bean que representa a tabela sn_rel_tipo_assinante_oper. 
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
 * 20/06/2005 Luciano Teixeira  N/A      Created
 * ===========================================================================
 * 
 * </PRE>
 * @hibernate.class table = "sn_rel_tipo_assinante_oper"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"       
 *                   proxy = "br.com.netservicos.core.bean.sn.SnRelTipoAssinanteOperadoraBean"                                                                      					 
 * 					 lazy="true"
 * 
 * @hibernate.query name  =  "lstSnRelTipoAssinanteOperadoraByTipoAssinante"
 *                   query = "SELECT relationship.compositeKey.idOperadora,
 *                                   relationship.compositeKey.tipoAssinante.idTipoAssinante,
 *                                   relationship.compositeKey.dtIni,
 *                                   relationship.compositeKey.dtFim,
 *                                   relationship.operadora.ciNome,
 *                                   relationship.operadora.cidContrato
 *                            FROM	SnRelTipoAssinanteOperadoraBean relationship
 *                   		  WHERE relationship.compositeKey.tipoAssinante.idTipoAssinante = :tipoAssinante.idTipoAssinante"
 * 
 */

public class SnRelTipoAssinanteOperadoraBean extends WebBean {

	private SnRelTipoAssinanteOperadoraKey compositeKey;

	private SnCidadeOperadoraBean operadora;

	public SnRelTipoAssinanteOperadoraBean() {
		super("compositeKey");
	}

	/**
	 * @hibernate.id 
	 * type = "composite"
	 */
	public SnRelTipoAssinanteOperadoraKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(SnRelTipoAssinanteOperadoraKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * @hibernate.many-to-one 
	 * class="br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean"
	 * cascade="none"
	 * column="id_operadora"
	 * insert="false"
	 * update="false"
	 * property-ref="idEmpresa"
	 * 
	 * @return
	 */
	public SnCidadeOperadoraBean getOperadora() {
		return operadora;
	}

	public void setOperadora(SnCidadeOperadoraBean operadora) {
		this.operadora = operadora;
	}

	public boolean equals(Object obj) {
		if (obj instanceof SnRelTipoAssinanteOperadoraBean) {
			return this.getCompositeKey().equals(
					((SnRelTipoAssinanteOperadoraBean) obj).getCompositeKey());
		} else {
			return false;
		}
	}

}
