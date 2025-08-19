/**
* Created on 04/01/2010
* Project : NETCommon
*
* Copyright © 2007 NET.
* Brasil
* All rights reserved.
*
* This software is the confidential and proprietary information of NET.
* You shall not disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with Net Serviços.
*
* $Id: SnCidadeBaseKey.java,v 1.6 2011/01/26 12:12:57 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import java.io.Serializable;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>Description :</B><BR>
 * Classe que representa a chave primária da tabela sn_cidade_base
 * </P>
 * <P>
 * <B> Issues : <BR>
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    	Description
 * ---------- -------------- -------- --------------    -------------------------
 * 04/01/2010 Luis Carneiro  N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 04/01/2010
 * @version $Revision: 1.6 $
 */
public class SnCidadeBaseKey implements Serializable, BaseCompositeKey {

	private static final long serialVersionUID = 3721065243423668452L;

	private String cidContrato;
	private String nomeAlias;

	/**
	 * @return Returns the cidContrato.
	 *
	 * @hibernate.property 
	 * 		column="cid_contrato"
	 * 		type="string"
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * @param cidContrato 
	 *				The cidContrato to set.
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}
	
	/**
	 * @return Returns the nomeAlias.
	 *
	 * @hibernate.property 
	 * 		column = "nm_alias"
	 * 		type = "string"
	 */
	public String getNomeAlias() {
		return nomeAlias;
	}
	
	/**
	 * @param nomeAlias 
	 *				The nomeAlias to set.
	 */
	public void setNomeAlias(String nomeAlias) {
		this.nomeAlias = nomeAlias;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SnCidadeBaseKey && (getCidContrato() != null && getNomeAlias() != null)) {
			SnCidadeBaseKey comp = (SnCidadeBaseKey) obj;
			
			return this.getCidContrato().equals(comp.getCidContrato())
				&& this.getNomeAlias().equals(comp.getNomeAlias());
		}
		return super.equals(obj);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cidContrato == null) ? 0 : cidContrato.hashCode());
		result = prime * result
				+ ((nomeAlias == null) ? 0 : nomeAlias.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see br.com.netservicos.framework.core.bean.BaseCompositeKey#buildKey(java.lang.String)
	 */
	public void buildKey(String value) {
		StringTokenizer tok = new StringTokenizer(value, "|");
		this.cidContrato =  String.valueOf(tok.nextToken());
		this.nomeAlias = String.valueOf(tok.nextToken());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(getCidContrato()) 
				+ "|" + String.valueOf(getNomeAlias());
	}

}
