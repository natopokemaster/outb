package br.com.netservicos.core.bean.ged;

import java.io.Serializable;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Key que representa a chave composta para a tabela hm_imovel.
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
public class HPImovelKey implements Serializable,BaseCompositeKey {

	private static final long serialVersionUID = 3981399504801236841L;
	
	private Integer codOperadora;
	private Long codHP;
	
	/**
	 *  
	 */
	public HPImovelKey() {
	}

	/**
	 *  
	 */
	public HPImovelKey(Integer codOperadora, Long codHP) {
		this.codOperadora = codOperadora;
		this.codHP = codHP;
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codHP == null) ? 0 : codHP.hashCode());
		result = prime * result
				+ ((codOperadora == null) ? 0 : codOperadora.hashCode());
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
		HPImovelKey other = (HPImovelKey) obj;
		if (codHP == null) {
			if (other.codHP != null)
				return false;
		} else if (!codHP.equals(other.codHP))
			return false;
		if (codOperadora == null) {
			if (other.codOperadora != null)
				return false;
		} else if (!codOperadora.equals(other.codOperadora))
			return false;
		return true;
	}
	
	/**
	 * @return the codOperadora
	 * @hibernate.property
	 * column = "cod_operadora"
	 * type = "integer"
	 */
	public Integer getCodOperadora() {
		return codOperadora;
	}

	/**
	 * @param codOperadora the codOperadora to set
	 */
	public void setCodOperadora(Integer codOperadora) {
		this.codOperadora = codOperadora;
	}

	/**
	 * @return the codHP
	 * @hibernate.property
	 * column = "cod_hp"
	 * type = "long"
	 */
	public Long getCodHP() {
		return codHP;
	}

	/**
	 * @param codHP the codHP to set
	 */
	public void setCodHP(Long codHP) {
		this.codHP = codHP;
	}

	public void buildKey(String value) {
		// TODO Auto-generated method stub
		
	}
	
}
