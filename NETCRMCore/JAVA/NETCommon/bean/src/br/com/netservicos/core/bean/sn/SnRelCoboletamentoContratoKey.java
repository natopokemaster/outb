/*
 * Created on 29/07/2008
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.sn;

import java.io.Serializable;
import java.util.Date;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Key que representa a chave composta para a tabela sn_rel_coboletamento_contrato.
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
 * 20/01/2010 Alexandre Soares N/A      NETCRMcore      Created.
 * ==============================================================================
 * </PRE>
 * 
 * 
 */
public class SnRelCoboletamentoContratoKey implements Serializable,BaseCompositeKey {

	private static final long serialVersionUID = 3981399504801236322L;
	
	private Long numContrato;
	
	private String cidContrato;
	
	private Date dtInicio;
	
	/**
	 *  
	 */
	public SnRelCoboletamentoContratoKey() {
	}

	/**
	 *  
	 */
	public SnRelCoboletamentoContratoKey(Long numContrato, String cidContrato, Date dtInicio) {
		this.numContrato = numContrato;
		this.cidContrato = cidContrato;
		this.dtInicio = dtInicio;
		
	}

	/**
	 * 
	 */
	public boolean equals(Object key) {
		if (key instanceof SnRelCoboletamentoContratoKey) {
			SnRelCoboletamentoContratoKey comp = (SnRelCoboletamentoContratoKey) key;
			return this.getNumContrato().equals(comp.getNumContrato())
					&& this.getCidContrato().equals(comp.getCidContrato())
					&& this.getDtInicio().equals(comp.getDtInicio());
		} else {
			return super.equals(key);
		}
	}

	/**
	 * 
	 */
	public int hashCode() {
		int value = (getNumContrato().hashCode() + getCidContrato().hashCode() * 2 + getDtInicio().hashCode());
		return (int) (value ^ (value >>> 32));
	}

	/**
	 * @return Returns the cidContrato.
	 * @hibernate.property
	 * column = "cid_contrato"
	 * type = "string"
	 * 
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * @param cidContrato The cidContrato to set.
	 * 
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	/**
	 * @return Returns the numContrato.
	 * @hibernate.property
	 * column = "num_contrato"
	 * type = "long"
	 * 
	 */
	public Long getNumContrato() {
		return numContrato;
	}

	/**
	 * 
	 * @param numContrato
	 */
	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
	}

	/**
	 * @return Returns the dtInicio.
	 * @hibernate.property
	 * column = "dt_inicio"
	 * 
	 */
	public Date getDtInicio() {
		return dtInicio;
	}

	/**
	 * 
	 * @param dtInicio
	 */
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public void buildKey(String value) {
		// TODO Auto-generated method stub
		
	}
	
}
