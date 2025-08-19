/**
* Created on 06/01/2009
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
* $Id: SnContratoKey.java,v 1.9 2011/01/26 12:12:57 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import java.io.Serializable;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>Description :</B><BR>
 * Classe que representa a chave primária da tabela sn_contrato
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
 * 06/01/2009 Luis Carneiro  N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 06/01/2009
 * @version $Revision: 1.9 $
 */
public class SnContratoKey implements Serializable, BaseCompositeKey {

	private static final long serialVersionUID = -128887289158145259L;

	private Long numContrato;
	private String cidContrato;

	public SnContratoKey() {
	}

	public SnContratoKey(Long numContrato, String cidContrato) {
		this.numContrato = numContrato;
		this.cidContrato = cidContrato;
	}

	/**
	 * @return Returns the numContrato.
	 *
	 * @hibernate.property 
	 * 		column = "num_contrato"
	 * 		type="long"
	 */
	public Long getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato 
	 *				The numContrato to set.
	 */
	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
	}

	/**
	 * @return Returns the cidContrato.
	 *
	 * @hibernate.property 
	 * 		column = "cid_contrato"
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SnContratoKey && (getNumContrato() != null && getCidContrato() != null)) {
				SnContratoKey comp = (SnContratoKey) obj;
					
				return getNumContrato().equals(comp.getNumContrato()) && 
					getCidContrato().equals(comp.getCidContrato());
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
				+ ((numContrato == null) ? 0 : numContrato.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see br.com.netservicos.framework.core.bean.BaseCompositeKey#buildKey(java.lang.String)
	 */
	public void buildKey(String value) {
		StringTokenizer tok = new StringTokenizer(value, "|");
		this.numContrato = Long.valueOf(tok.nextToken());
		this.cidContrato = String.valueOf(tok.nextToken());  // new String(tok.nextToken());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.valueOf(getNumContrato()) 
				+ "|" + String.valueOf(getCidContrato());
	}

}