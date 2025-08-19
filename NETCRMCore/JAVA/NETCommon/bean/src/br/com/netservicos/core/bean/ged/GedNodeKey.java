/*
 * Created on 26/08/2005
 *
 * Copyright © 2005 NET.
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
 * 	Classe Key que representa a chave composta para a tabela sn_parametro.
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
 * 26/08/2005 Giovanni F.    N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 *
 *
 * 
 */
public class GedNodeKey implements Serializable {

    private static final long serialVersionUID = -8173012043451795451L;
    private String codNode;
    private Integer codOperadora;

    public GedNodeKey() {

    }

    public GedNodeKey(Integer codOperadora, String codNode) {
        this.codOperadora = codOperadora;
        this.codNode = codNode;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     * 
     */
    public boolean equals(Object key) {
        if (key instanceof GedNodeKey) {
            GedNodeKey comp = (GedNodeKey) key;
            return this.getCodOperadora().equals(comp.getCodOperadora())
                    && this.getCodNode().equals(comp.getCodNode());
        } else {
            return super.equals(key);
        }
    }

    /**
     * @return Returns the codNode.
     * @hibernate.property
     *      column="cod_node"
     */
    public String getCodNode() {
        return codNode;
    }

    /**
     * @return Returns the codOperadora.
     * @hibernate.property
     *      column="cod_operadora"
     */
    public Integer getCodOperadora() {
        return codOperadora;
    }

    public int hashCode() {
        final int prime = 32;
        int value = (getCodOperadora().hashCode() + getCodNode().hashCode() * 2);
        return (int) (value ^ (value >>> prime));
    }

    /**
     * @param codNode The codNode to set.
     */
    public void setCodNode(String codNode) {
        this.codNode = codNode;
    }

    /**
     * @param codOperadora The codOperadora to set.
     */
    public void setCodOperadora(Integer codOperadora) {
        this.codOperadora = codOperadora;
    }

}
