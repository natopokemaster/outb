/*
 * Created on 04/03/2005
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
 * 	Classe Bean que representa a tabela sn_rel_classe_preco_tipo_ass.
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
 *                            Prior
 * Date       By              Version  Project/CSR    Description
 * ---------- --------------  -------- -------------- ---------------------------
 * 04/02/2005 Ricardo Limonta N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_rel_classe_preco_tipo_ass"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 * 					proxy="br.com.netservicos.core.bean.sn.SnRelClassePrecoTipoAssinanteBean"
 * 					lazy="true"
 *
 *                            
 *                                           
 *                  
 * 
 * 
 */
public class SnRelClassePrecoTipoAssinanteBean extends WebBean {

	private SnRelClassePrecoTipoAssinanteKey compositeKey;

	private Double desconto;
	
	/**
	 * Default method constructor
	 * 
	 */
	public SnRelClassePrecoTipoAssinanteBean() {
		super("compositeKey");
	}

	/**
	 * @return Returns the compositeKey.
	 * @hibernate.id
	 * type = "composite"
	 * 
	 */
	public SnRelClassePrecoTipoAssinanteKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 * 
	 */
	public void setCompositeKey(SnRelClassePrecoTipoAssinanteKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * @return Returns the desconto.
	 * @hibernate.property column = "desconto"
	 * type = "double"
	 * 
	 */
	public Double getDesconto() {
		return desconto;
	}

	/**
	 * @param desconto The desconto to set.
	 * 
	 */
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public int hashCode() {
		return compositeKey.hashCode();
	}

	public boolean equals(Object obj) {

		if (obj instanceof SnRelClassePrecoTipoAssinanteBean) {
			return this.compositeKey
					.equals(((SnRelClassePrecoTipoAssinanteBean) obj)
							.getCompositeKey());
		} else {
			return false;
		}
	}
}
