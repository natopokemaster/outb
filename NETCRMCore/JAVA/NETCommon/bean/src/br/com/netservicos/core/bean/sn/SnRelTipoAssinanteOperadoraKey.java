/**
 * Created on 20/06/2005
 * Project : ADM 
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;
import br.com.netservicos.framework.util.exception.BaseFailureException;

/**
 * @author  :Luciano Teixeira 
 * @version : 
 * <P><B>
 * Classe Key que representa a chave composta para a tabela sn_rel_tipo_assinante_oper.
 * </B>
 * <BR>
 * TODO:
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By	
 * ---------------------------------------- ----------- ------------------------- 
 * Bean usado para fazer a associação de    20/06/2005  Luciano Teixeira
 * tipo de assinante com operadora.
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                             Prior
 * Date       By               Version  Description
 * ---------- ---------------- -------- -----------------------------------------
 * 20/06/2005 Luciano Teixeira N/A      Created 	
 * ==============================================================================
 * </PRE>
 */
public class SnRelTipoAssinanteOperadoraKey implements Serializable,
		BaseCompositeKey {

	private SnTipoAssinanteBean tipoAssinante;
	private String idOperadora;
	private Date dtIni;
	private Date dtFim;

	public boolean equals(Object key) {
		if (key instanceof SnRelTipoAssinanteOperadoraKey) {
			SnRelTipoAssinanteOperadoraKey comp = (SnRelTipoAssinanteOperadoraKey) key;
			return (this.getTipoAssinante().getPrimaryKey().equals(
					comp.getTipoAssinante().getPrimaryKey())
					&& this.getIdOperadora().equals(comp.getIdOperadora())
					&& this.getDtIni().equals(comp.getDtIni()) && this
					.getDtFim().equals(comp.getDtFim()));
		} else {
			return super.equals(key);
		}
	}

	public int hashCode() {
		int value = (tipoAssinante.getIdTipoAssinante().hashCode()
				+ idOperadora.hashCode() * 2 + dtIni.hashCode() * 3 + dtFim
				.hashCode() * 4);
		return (int) (value ^ (value >>> 32));
	}

	public void buildKey(String value) {
		StringTokenizer tok = new StringTokenizer(value, "|");
		Integer idTipoAssinante = new Integer(tok.nextToken());
		String idOperadora = tok.nextToken();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateIni = null;
		Date dateFim = null;
		try {
			dateIni = sdf.parse(tok.nextToken());
			dateFim = sdf.parse(tok.nextToken());
		} catch (ParseException pe) {
			throw new BaseFailureException(pe);
		}
		this.tipoAssinante = new SnTipoAssinanteBean(idTipoAssinante);
		this.idOperadora = idOperadora;
		this.dtIni = dateIni;
		this.dtFim = dateFim;
	}

	/**
	 * Obtains and returns the SnTipoAssinanteBean.
	 *
	 * @return Returns the tipo assinante.
	 * 
	 * @hibernate.many-to-one  
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoAssinanteBean" 
	 * 		column="id_tipo_assinante"
	 * 		cascade="none"
	 * 		not-null="false"
	 */
	public SnTipoAssinanteBean getTipoAssinante() {
		return tipoAssinante;
	}

	/**
	 * 
	 * @param tipoAssinante The tipo assinante to set.
	 */
	public void setTipoAssinante(SnTipoAssinanteBean tipoAssinante) {
		this.tipoAssinante = tipoAssinante;
	}

	/**
	 * @hibernate.property 
	 * column = "id_operadora"
	 * type = "string"
	 * not-null = "true"
	 * 
	 * @return
	 */
	public String getIdOperadora() {
		return idOperadora;
	}

	public void setIdOperadora(String idOperadora) {
		this.idOperadora = idOperadora;
	}

	/**
	 * Obtains and returns the new value of the dtFim attribute.
	 *
	 * @return Returns the dtFim
	 * 
	 * @hibernate.property 
	 * column="dt_fim"
	 * type = "date"
	 */
	public Date getDtFim() {
		return dtFim;
	}

	/**
	 * 
	 * @param dtFim The dtFim to set.
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	/**
	 * Obtains and returns the new value of the dtIni attribute.
	 *
	 * @return Returns the dtIni
	 * 
	 * @hibernate.property 
	 * column="dt_ini"
	 * type = "date"
	 */
	public Date getDtIni() {
		return dtIni;
	}

	/**
	 * 
	 * @param dtIni The dtIni to set.
	 */
	public void setDtIni(Date dtIni) {
		this.dtIni = dtIni;
	}

}