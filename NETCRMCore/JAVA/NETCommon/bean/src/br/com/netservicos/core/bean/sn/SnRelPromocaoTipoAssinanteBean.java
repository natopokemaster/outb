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
 * <B> Description :Classe Bean que representa a tabela sn_rel_promocao_tipo_assinante. 
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
 * @hibernate.class table = "sn_rel_promocao_tipo_assinante"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"       
 *                   proxy = "br.com.netservicos.core.bean.sn.SnRelPromocaoTipoAssinanteBean"                                                                      					 
 * 					 lazy="true"
 *
 * @hibernate.query name  =  "lstSnRelPromocaoTipoAssinanteByTipoAssinante"
 *                   query = "FROM	SnRelPromocaoTipoAssinanteBean relationship
 *                   		  WHERE relationship.compositeKey.tipoAssinante.idTipoAssinante = :compositeKey.tipoAssinante.idTipoAssinante"
 *                  
 */

public class SnRelPromocaoTipoAssinanteBean extends WebBean {

	private SnRelPromocaoTipoAssinanteKey compositeKey;

	public SnRelPromocaoTipoAssinanteBean() {
		super("compositeKey");
	}

	/**
	 * @hibernate.id 
	 * type = "composite"
	 */
	public SnRelPromocaoTipoAssinanteKey getCompositeKey() {
		return compositeKey;
	}

	public void setCompositeKey(SnRelPromocaoTipoAssinanteKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	public boolean equals(Object obj) {
		if (obj instanceof SnRelPromocaoTipoAssinanteBean) {
			return this.compositeKey
					.equals(((SnRelPromocaoTipoAssinanteBean) obj)
							.getCompositeKey());
		} else {
			return false;
		}
	}

}
