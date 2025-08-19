package br.com.netservicos.core.bean.sn;

import java.io.Serializable;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>Description :</B><BR>
 * Classe Key que representa a chave composta da tabela sn_ddd_operadora_telefonia.
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
 * 04/10/2010 Márcio Dantas  N/A      NetCombo          Criação
 * ==============================================================================
 * </PRE>
 *
 * @author marcio@mdantas.com.br
 * @since 04/10/2010
 * @version $Revision: 1.2 $
 */
public class SnDddOperadoraTelefoniaKey implements Serializable, BaseCompositeKey {

	private static final long serialVersionUID = -4376062230182182148L;

	private String nrDdd;
	Long idOperadoraTelefonia;

	/**
	 * @return the nrDdd
	 *
	 * @hibernate.property 
	 * 		column="nr_ddd"
	 * 		type="long"
	 */
	public String getNrDdd() {
		return nrDdd;
	}

	/**
	 * @param nrDdd the nrDdd to set
	 */
	public void setNrDdd(String nrDdd) {
		this.nrDdd = nrDdd;
	}

	/**
	 * @return the idOperadoraTelefonia
	 *
	 * @hibernate.property 
	 * 		column="id_operadora_telefonia"
	 * 		type="long"
	 */
	public Long getIdOperadoraTelefonia() {
		return idOperadoraTelefonia;
	}

	/**
	 * @param idOperadoraTelefonia the idOperadoraTelefonia to set
	 */
	public void setIdOperadoraTelefonia(Long idOperadoraTelefonia) {
		this.idOperadoraTelefonia = idOperadoraTelefonia;
	}
	
	public void buildKey(String value) {
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idOperadoraTelefonia == null) ? 0 : idOperadoraTelefonia
						.hashCode());
		result = prime * result + ((nrDdd == null) ? 0 : nrDdd.hashCode());
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
		SnDddOperadoraTelefoniaKey other = (SnDddOperadoraTelefoniaKey) obj;
		if (idOperadoraTelefonia == null) {
			if (other.idOperadoraTelefonia != null)
				return false;
		} else if (!idOperadoraTelefonia.equals(other.idOperadoraTelefonia))
			return false;
		if (nrDdd == null) {
			if (other.nrDdd != null)
				return false;
		} else if (!nrDdd.equals(other.nrDdd))
			return false;
		return true;
	}
	
}
