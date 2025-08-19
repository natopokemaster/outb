/**
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
 * <B> Description :Classe Bean que representa a tabela sn_rel_tipo_venda_tipo_asn. 
 * </B> 
 * <BR>
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
 * @hibernate.class table = "sn_rel_tipo_venda_tipo_asn"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"       
 * 					 lazy="true"
 * 
 * @hibernate.cache
 *      usage="read-write"
 *
 * @hibernate.query name  =  "lstSnRelTipoVendaTipoAssinanteByTipoAssinante"
 *                   query = "FROM	SnRelTipoVendaTipoAssinanteBean relationship
 *                   		  WHERE relationship.compositeKey.tipoAssinante.idTipoAssinante = :compositeKey.tipoAssinante.idTipoAssinante"
 *                  
 * @hibernate.query name  = "relTipoAssinanteByTipoVenda"
 *                  query = "SELECT rel
 *                           FROM	br.com.netservicos.core.bean.sn.SnRelTipoVendaTipoAssinanteBean rel
 * 							WHERE	rel.compositeKey.tipoVenda.idTipoVenda = :idTipoVenda"
 *                  
 */

public class SnRelTipoVendaTipoAssinanteBean extends WebBean {

	private SnRelTipoVendaTipoAssinanteKey compositeKey;

	public static final String LST_BY_ID_TIPO_VENDA = "relTipoAssinanteByTipoVenda";

	public SnRelTipoVendaTipoAssinanteBean() {
		super("compositeKey");
	}

	/**
	 * @hibernate.id 
	 * type = "composite"
	 */
	public SnRelTipoVendaTipoAssinanteKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(SnRelTipoVendaTipoAssinanteKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	public int hashCode() {
		return compositeKey.hashCode();
	}

	/**
	 */
	public boolean equals(Object bean) {
		if (bean instanceof SnRelTipoVendaTipoAssinanteBean) {
			SnRelTipoVendaTipoAssinanteKey key = ((SnRelTipoVendaTipoAssinanteBean) bean)
					.getCompositeKey();
			return this.getCompositeKey().equals(key);
		} else {
			return false;
		}
	}

}
