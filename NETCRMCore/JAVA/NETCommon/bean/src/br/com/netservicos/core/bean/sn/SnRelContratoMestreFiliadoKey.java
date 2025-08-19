package br.com.netservicos.core.bean.sn;

import java.io.Serializable;
import java.util.Date;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Key que representa a chave composta para a tabela sn_rel_contrato_mestre_filiado.
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
public class SnRelContratoMestreFiliadoKey implements Serializable,BaseCompositeKey {

	private static final long serialVersionUID = 3981399504801231434L;
	
	private Long numContratoMestre; 
	private Long numContratoFiliado; 
	private String cidContrato; 
	private Integer idPonto;
	private Date dtIni; 
	private Date dtFim;
	
	/**
	 *  
	 */
	public SnRelContratoMestreFiliadoKey() {
	}

	/**
	 *  
	 */
	public SnRelContratoMestreFiliadoKey(Long numContratoMestre, Long numContratoFiliadoo, String cidContrato, Integer idPonto, Date dtIni, Date dtFim) {
		
		this.numContratoMestre = numContratoMestre;
		this.numContratoFiliado = numContratoFiliado;
		this.cidContrato = cidContrato;
		this.idPonto = idPonto;
		this.dtIni = dtIni;
		this.dtFim = dtFim;
		
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
		result = prime * result + ((dtFim == null) ? 0 : dtFim.hashCode());
		result = prime * result + ((dtIni == null) ? 0 : dtIni.hashCode());
		result = prime * result + ((idPonto == null) ? 0 : idPonto.hashCode());
		result = prime
				* result
				+ ((numContratoFiliado == null) ? 0 : numContratoFiliado
						.hashCode());
		result = prime
				* result
				+ ((numContratoMestre == null) ? 0 : numContratoMestre
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
		SnRelContratoMestreFiliadoKey other = (SnRelContratoMestreFiliadoKey) obj;
		if (cidContrato == null) {
			if (other.cidContrato != null)
				return false;
		} else if (!cidContrato.equals(other.cidContrato))
			return false;
		if (dtFim == null) {
			if (other.dtFim != null)
				return false;
		} else if (!dtFim.equals(other.dtFim))
			return false;
		if (dtIni == null) {
			if (other.dtIni != null)
				return false;
		} else if (!dtIni.equals(other.dtIni))
			return false;
		if (idPonto == null) {
			if (other.idPonto != null)
				return false;
		} else if (!idPonto.equals(other.idPonto))
			return false;
		if (numContratoFiliado == null) {
			if (other.numContratoFiliado != null)
				return false;
		} else if (!numContratoFiliado.equals(other.numContratoFiliado))
			return false;
		if (numContratoMestre == null) {
			if (other.numContratoMestre != null)
				return false;
		} else if (!numContratoMestre.equals(other.numContratoMestre))
			return false;
		return true;
	}

	/**
	 * @return the numContratoMestre
	 * @hibernate.property
	 * column = "num_contrato_mestre"
	 * type = "long"
	 */
	public Long getNumContratoMestre() {
		return numContratoMestre;
	}

	/**
	 * @param numContratoMestre the numContratoMestre to set
	 */
	public void setNumContratoMestre(Long numContratoMestre) {
		this.numContratoMestre = numContratoMestre;
	}

	/**
	 * @return the numContratoFiliado
	 * @hibernate.property
	 * column = "num_contrato_filiado"
	 * type = "long"
	 */
	public Long getNumContratoFiliado() {
		return numContratoFiliado;
	}

	/**
	 * @param numContratoFiliado the numContratoFiliado to set
	 */
	public void setNumContratoFiliado(Long numContratoFiliado) {
		this.numContratoFiliado = numContratoFiliado;
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

	/**
	 * @return the idPonto
	 * @hibernate.property
	 * column = "id_ponto"
	 * type = "int"
	 */
	public Integer getIdPonto() {
		return idPonto;
	}

	/**
	 * @param idPonto the idPonto to set
	 */
	public void setIdPonto(Integer idPonto) {
		this.idPonto = idPonto;
	}

	/**
	 * @return the dtIni
	 * @hibernate.property
	 * column = "dt_ini"
	 * type = "date"
	 */
	public Date getDtIni() {
		return dtIni;
	}

	/**
	 * @param dtIni the dtIni to set
	 */
	public void setDtIni(Date dtIni) {
		this.dtIni = dtIni;
	}

	/**
	 * @return the dtFim
	 * @hibernate.property
	 * column = "dt_fim"
	 * type = "date"
	 */
	public Date getDtFim() {
		return dtFim;
	}

	/**
	 * @param dtFim the dtFim to set
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	
	
	public void buildKey(String value) {
		// TODO Auto-generated method stub
		
	}

}