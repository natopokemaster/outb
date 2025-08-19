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
public class GedTrechosRestritosKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codLogradouro;
	private Integer codOperadora;
	private Long numSeqTrechos;
	
	/**
	 * @param codLogradouro
	 * @param codOperadora
	 * @param numSeqTrechos
	 */
	public GedTrechosRestritosKey(Long codLogradouro, Integer codOperadora, Long numSeqTrechos) {
		this.codLogradouro = codLogradouro;
		this.codOperadora = codOperadora;
		this.numSeqTrechos = numSeqTrechos;
	}
	
	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="COD_LOGRADOURO"
	 */
	public Long getCodLogradouro() {
		return codLogradouro;
	}
	
	/**
	 * @param codLogradouro The codLogradouro to set.
	 */
	public void setCodLogradouro(Long codLogradouro) {
		this.codLogradouro = codLogradouro;
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
	 * 		column="NUM_SEQ_TRECHOS"
	 */
	public Long getNumSeqTrechos() {
		return numSeqTrechos;
	}
	
	/**
	 * @param numSeqTrechos The numSeqTrechos to set.
	 */
	public void setNumSeqTrechos(Long numSeqTrechos) {
		this.numSeqTrechos = numSeqTrechos;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
        final int prime = 32;
        final int x = 3;
        long value = codLogradouro.hashCode() + codOperadora.hashCode() * 2 + numSeqTrechos.hashCode() * x;
        return (int) (value ^ (value >>> prime));
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
        if (obj instanceof GedTrechosRestritosKey) {
        	GedTrechosRestritosKey key = (GedTrechosRestritosKey) obj;
            return codLogradouro.equals(key.getCodLogradouro()) && 
            	codOperadora.equals(key.getCodOperadora()) &&
            	numSeqTrechos.equals(key.getNumSeqTrechos());
        } else {
            return super.equals(obj);
        }
	}
	
}