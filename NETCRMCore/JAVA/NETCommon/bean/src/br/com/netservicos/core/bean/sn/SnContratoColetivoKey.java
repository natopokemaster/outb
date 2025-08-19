package br.com.netservicos.core.bean.sn;

import java.io.Serializable;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Key que representa a chave composta para a tabela sn_contrato_coletivo.
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
 * ---------- --------------  -------- -------------- ----------------------------
 * 13/09/2010 Márcio Dantas		 N/A      NETCombo      Created.
 * ==============================================================================
 * </PRE>
 * 
 * 
 */
public class SnContratoColetivoKey implements Serializable,BaseCompositeKey {

	private static final long serialVersionUID = 3981399504801231434L;
	
	private Long numContrato;                       
	private String cidContrato;                          
	
	/**
	 *  
	 */
	public SnContratoColetivoKey() {
	}

	/**
	 *  
	 */
	public SnContratoColetivoKey(Long numContrato, String cidContrato) {
		
		this.numContrato = numContrato;
		this.cidContrato = cidContrato;
		
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
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SnContratoColetivoKey other = (SnContratoColetivoKey) obj;
		if (cidContrato == null) {
			if (other.cidContrato != null)
				return false;
		} else if (!cidContrato.equals(other.cidContrato))
			return false;
		if (numContrato == null) {
			if (other.numContrato != null)
				return false;
		} else if (!numContrato.equals(other.numContrato))
			return false;
		return true;
	}

	/**
	 * @return the numContrato
	 * @hibernate.property
	 * column = "num_contrato"
	 * type = "long"
	 */
	public Long getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
	}

	/**
	 * @return the cidContrato
	 * @hibernate.property
	 * column = "cid_contrato"
	 * type = "string"
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * @param cidContrato the cidContrato to set
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	public void buildKey(String value) {
		// TODO Auto-generated method stub
		
	}
	
}