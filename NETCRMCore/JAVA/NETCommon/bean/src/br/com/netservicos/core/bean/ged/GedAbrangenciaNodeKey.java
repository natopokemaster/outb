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
public class GedAbrangenciaNodeKey implements Serializable {

	private static final long serialVersionUID = -6421327798378294549L;
	
	private Long codCidade;
	private Long codLogradouro;
	private String codNode;
	private Integer codOperadora;
	private Long numSeqAbrangencia;
	
	/**
	 * 
	 * @param codCidade
	 * @param codLogradouro
	 * @param codNode
	 * @param codOperadora
	 * @param numSeqAbrangencia
	 */
	public GedAbrangenciaNodeKey(Long codCidade, Long codLogradouro, String codNode, Integer codOperadora,
			Long numSeqAbrangencia) {
		super();
		this.codCidade = codCidade;
		this.codLogradouro = codLogradouro;
		this.codNode = codNode;
		this.codOperadora = codOperadora;
		this.numSeqAbrangencia = numSeqAbrangencia;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="COD_CIDADE"
	 */
	public Long getCodCidade() {
		return codCidade;
	}

	/**
	 * @param codCidade The codCidade to set.
	 */
	public void setCodCidade(Long codCidade) {
		this.codCidade = codCidade;
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
	 * 		column="NUM_SEQ_ABRANGENCIA"
	 */
	public Long getNumSeqAbrangencia() {
		return numSeqAbrangencia;
	}

	/**
	 * @param numSeqAbrangencia The numSeqAbrangencia to set.
	 */
	public void setNumSeqAbrangencia(Long numSeqAbrangencia) {
		this.numSeqAbrangencia = numSeqAbrangencia;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 32;
		final int x = 5;
        final int y = 4;
		final int z = 3;

		long value = codCidade.hashCode() +
			codLogradouro.hashCode() * 2 +
			codNode.hashCode() * z
				+ codOperadora.hashCode() * y + numSeqAbrangencia * x;
		return (int) (value ^ (value >>> prime));
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
        if (obj instanceof GedAbrangenciaNodeKey) {
        	GedAbrangenciaNodeKey key = (GedAbrangenciaNodeKey) obj;
            return codCidade.equals(key.getCodCidade()) && 
            	codLogradouro.equals(key.getCodLogradouro()) &&
            	codNode.equals(key.getCodNode()) &&
            	codOperadora.equals(key.getCodOperadora()) &&
            	numSeqAbrangencia.equals(key.getNumSeqAbrangencia());
        } else {
            return super.equals(obj);
        }
	}
	
}