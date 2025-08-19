/*
 * Created on 04/03/2005
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

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Key que representa a chave composta para a tabela sn_rel_classe_preco_tipo_ass.
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
 * ---------- --------------  -------- -------------- ---------------------------
 * 18/05/2005 Ricardo Limonta N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 * 
 */
public class SnRelClassePrecoTipoAssinanteKey implements Serializable {

	private Integer idClassePreco;

	private Integer idTipoAssinante;
	private Date dtIni;
	private Date dtFim;

	/**
	 * Default method constructor	
	 * 
	 */
	public SnRelClassePrecoTipoAssinanteKey() {
	}

	/**
	 * @param idClassePreco id_classe_preco attribute 
	 * @param idTipoAssinante id_tipo_assinante attribute
	 * 
	 */
	public SnRelClassePrecoTipoAssinanteKey(Integer idClassePreco,
			Integer idTipoAssinante, Date dtIni, Date dtFim) {
		this.idClassePreco = idClassePreco;
		this.idTipoAssinante = idTipoAssinante;
		this.dtIni = dtIni;
		this.dtFim = dtFim;
	}

	/**
	 * Implement equals method
	 * 
	 */
	public boolean equals(Object key) {
		if (key instanceof SnRelClassePrecoTipoAssinanteKey) {
			SnRelClassePrecoTipoAssinanteKey comp = (SnRelClassePrecoTipoAssinanteKey) key;
			return this.getIdClassePreco().equals(comp.getIdClassePreco())
					&& this.getIdTipoAssinante().equals(
							comp.getIdTipoAssinante())
					&& this.getDtIni().equals(comp.getDtIni())
					&& this.getDtFim().equals(comp.getDtFim());
		} else {
			return super.equals(key);
		}
	}

	/**
	 * Implement hashCode method
	 * 
	 */
	public int hashCode() {

		if ((getIdClassePreco() != null) && (getIdTipoAssinante() != null)
				&& (getDtIni() != null) && (getDtFim() != null)) {
			int value = (getIdClassePreco().hashCode()
					+ getIdTipoAssinante().hashCode() * 2
					+ getDtIni().hashCode() * 3 + getDtFim().hashCode() * 4);
			return (int) (value ^ (value >>> 32));
		} else {
			return super.hashCode();
		}

	}

	/**
	 * @return Returns the idTipoAssinante.
	 * @hibernate.property column = "id_tipo_assinante"
	 * 
	 */
	public Integer getIdTipoAssinante() {
		return idTipoAssinante;
	}

	/**
	 * @param idTipoAssinante The idTipoAssinante to set.
	 * 
	 */
	public void setIdTipoAssinante(Integer idTipoAssinante) {
		this.idTipoAssinante = idTipoAssinante;
	}

	/**
	 * @return Returns the idClassePreco.
	 * @hibernate.property column = "id_classe_preco"
	 * 
	 */
	public Integer getIdClassePreco() {
		return idClassePreco;
	}

	/**
	 * @param idClassePreco The idClassePreco to set.
	 * 
	 */
	public void setIdClassePreco(Integer idClassePreco) {
		this.idClassePreco = idClassePreco;
	}

	/**
	 * @return Returns the dtIni.
	 * @hibernate.property column = "dt_ini"
	 * type = "date"
	 * 
	 */
	public Date getDtIni() {
		return dtIni;
	}

	/**
	 * @param dtIni The dtIni to set.
	 * 
	 */
	public void setDtIni(Date dtIni) {
		this.dtIni = dtIni;
	}

	/**
	 * @return Returns the dtIni.
	 * @hibernate.property column = "dt_fim"
	 * type = "date"
	 * 
	 */
	public Date getDtFim() {
		return dtFim;
	}

	/**
	 * @param dtFim The dtFim to set.
	 * 
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

}
