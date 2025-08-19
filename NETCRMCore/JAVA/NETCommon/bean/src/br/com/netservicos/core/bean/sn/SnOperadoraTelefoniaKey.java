package br.com.netservicos.core.bean.sn;

import java.io.Serializable;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>Description :</B><BR>
 * Classe Key que representa a chave composta da tabela sn_operadora_telefonia.
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
public class SnOperadoraTelefoniaKey implements Serializable, BaseCompositeKey {

	private static final long serialVersionUID = -4376062230182182148L;

	private Long idOperadoraTelefonia;

	
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
		SnOperadoraTelefoniaKey other = (SnOperadoraTelefoniaKey) obj;
		if (idOperadoraTelefonia == null) {
			if (other.idOperadoraTelefonia != null)
				return false;
		} else if (!idOperadoraTelefonia.equals(other.idOperadoraTelefonia))
			return false;
		return true;
	}

	public void buildKey(String value) {
		
	}
	
}
