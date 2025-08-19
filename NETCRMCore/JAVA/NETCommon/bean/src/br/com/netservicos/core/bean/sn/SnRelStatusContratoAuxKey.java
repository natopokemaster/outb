package br.com.netservicos.core.bean.sn;

import java.io.Serializable;
import java.util.Date;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Key que representa a chave composta para a tabela sn_rel_status_contrato_aux.
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
public class SnRelStatusContratoAuxKey implements Serializable,BaseCompositeKey {

	private static final long serialVersionUID = 3981399504801231434L;
	
	private Integer numContrato;                       
	private String cidContrato;                          
	private Integer idStatus;  
	private Date dtIni; 
	private Date dtFim; 
	private Date horaStatusIni;  
	
	/**
	 *  
	 */
	public SnRelStatusContratoAuxKey() {
	}

	/**
	 *  
	 */
	public SnRelStatusContratoAuxKey(Integer numContrato, String cidContrato, Integer idStatus, Date dtIni, Date dtFim, Date horaStatusIni) {
		
		this.numContrato = numContrato;
		this.cidContrato = cidContrato;
		this.idStatus = idStatus;
		this.dtIni = dtIni;
		this.dtFim = dtFim;
		this.horaStatusIni = horaStatusIni;
		
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
		result = prime * result
				+ ((horaStatusIni == null) ? 0 : horaStatusIni.hashCode());
		result = prime * result
				+ ((idStatus == null) ? 0 : idStatus.hashCode());
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
		SnRelStatusContratoAuxKey other = (SnRelStatusContratoAuxKey) obj;
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
		if (horaStatusIni == null) {
			if (other.horaStatusIni != null)
				return false;
		} else if (!horaStatusIni.equals(other.horaStatusIni))
			return false;
		if (idStatus == null) {
			if (other.idStatus != null)
				return false;
		} else if (!idStatus.equals(other.idStatus))
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
	 * type = "int"
	 */
	public Integer getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(Integer numContrato) {
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

	/**
	 * @return the idStatus
	 * @hibernate.property
	 * column = "id_status"
	 * type = "int"
	 */
	public Integer getIdStatus() {
		return idStatus;
	}

	/**
	 * @param idStatus the idStatus to set
	 */
	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
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

	/**
	 * @return the horaStatusIni
	 * @hibernate.property
	 * column = "hora_status_ini"
	 * type = "date"
	 */
	public Date getHoraStatusIni() {
		return horaStatusIni;
	}

	/**
	 * @param horaStatusIni the horaStatusIni to set
	 */
	public void setHoraStatusIni(Date horaStatusIni) {
		this.horaStatusIni = horaStatusIni;
	}

	public void buildKey(String value) {
		// TODO Auto-generated method stub
		
	}
	
}