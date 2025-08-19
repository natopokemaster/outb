/*
 * Created on 26/02/2005
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

import java.io.Serializable;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Key que representa a chave composta para a tabela SN_TIPO_COBR_FAT_EMAIL.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * =============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * =============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                                  Prior
 * Date       By                   Version Project/CSR 	  Description
 * ---------- -------------------- ------- -------------- -------------------------
 * 29/09/2009 					   N/A     Faturas Email  Created.
 * ==============================================================================
 * </PRE>
 *
 *
 * 
 */
public class SnTipoCobrFatEmailKey implements Serializable, BaseCompositeKey {



	/**
	 * 
	 */
	private static final long serialVersionUID = 4277121113904541845L;

	private Integer idTipoCobranca;

	private String cidContrato;

	public SnTipoCobrFatEmailKey() {
	}

	public SnTipoCobrFatEmailKey(Integer idTipoCobranca, String cidContrato) {
		this.idTipoCobranca = idTipoCobranca;
		this.cidContrato = cidContrato;
	}

	/*
	 * @see br.com.netservicos.framework.core.bean.BaseCompositeKey#buildKey(java.lang.String)
	 * 
	 */
	public void buildKey(String value) {
		StringTokenizer tok = new StringTokenizer(value, "|");
		Integer idTipoCobranca = Integer.parseInt(tok.nextToken());
		String cidContrato = tok.nextToken();
		this.idTipoCobranca = idTipoCobranca;
		this.cidContrato = cidContrato;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * 
	 */
	public boolean equals(Object key) {
		if (key instanceof SnTipoCobrFatEmailKey) {
			SnTipoCobrFatEmailKey comp = (SnTipoCobrFatEmailKey) key;
			return this.getIdTipoCobranca().equals(comp.getIdTipoCobranca())
					&& this.getCidContrato().equals(comp.getCidContrato());
		} else {
			return super.equals(key);
		}
	}

	public int hashCode() {
		int value = (getIdTipoCobranca().hashCode() + getCidContrato().hashCode() * 2);
		return (int) (value ^ (value >>> 32));
	}

	/**
	 * Obtains and returns the idEmpresa.
	 *
	 * @return Returns the idEmpresa.
	 * @hibernate.property column = "id_tipo_cobranca"
	 * 
	 */
	public Integer getIdTipoCobranca() {
		return idTipoCobranca;
	}

	/**
	 * @param idTipoCobranca The idTipoCobranca to set.
	 * 
	 */
	public void setIdTipoCobranca(Integer idTipoCobranca) {
		this.idTipoCobranca = idTipoCobranca;
	}

	/**
	 * @return Returns the cidContrato.
	 * @hibernate.property column = "cid_contrato"
	 * 
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * @param cidContrato The cidContrato to set.
	 * 
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

}
