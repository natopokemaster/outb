/*
 * Created on 12/09/2007
 *
 * Copyright © 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.ged;

import java.io.Serializable;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
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
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 12/09/2007 Rodrigo Silva  N/A      NETCommon      Created.
 * ==============================================================================
 * </PRE>
 */
public class GedNodeProdutoKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codNode;
	private Integer codOperadora;
	private Integer codProduto;
	
	/**
	 * @param codNode
	 * @param codOperadora
	 * @param codProduto
	 */
	public GedNodeProdutoKey(String codNode, Integer codOperadora, Integer codProduto) {
		this.codNode = codNode;
		this.codOperadora = codOperadora;
		this.codProduto = codProduto;
	}
	
	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="COD_NODE"
	 */
	public String getCodNode() {
		return codNode;
	}
	
	/**
	 * @param codNode The codNode to set.
	 */
	public void setCodNode(String codNode) {
		this.codNode = codNode;
	}
	
	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="COD_OPERADORA"
	 */
	public Integer getCodOperadora() {
		return codOperadora;
	}
	
	/**
	 * @param codOperadora The codOperadora to set.
	 */
	public void setCodOperadora(Integer codOperadora) {
		this.codOperadora = codOperadora;
	}
	
	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="COD_PRODUTO"
	 */
	public Integer getCodProduto() {
		return codProduto;
	}
	
	/**
	 * @param codProduto The codProduto to set.
	 */
	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}
	
	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
        final int prime = 32;
        final int x = 3;
        long value = codNode.hashCode() + codOperadora.hashCode() * 2 + codProduto.hashCode() * x;
        return (int) (value ^ (value >>> prime));
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
        if (obj instanceof GedNodeProdutoKey) {
        	GedNodeProdutoKey key = (GedNodeProdutoKey) obj;
            return codNode.equals(key.getCodNode()) && 
            	codOperadora.equals(key.getCodOperadora()) &&
            	codProduto.equals(key.getCodProduto());
        } else {
            return super.equals(obj);
        }
	}
	
}