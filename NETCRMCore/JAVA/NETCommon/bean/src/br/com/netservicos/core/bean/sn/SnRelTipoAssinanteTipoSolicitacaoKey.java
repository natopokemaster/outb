/**
 * Created on 21/06/2005
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
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * @author  :Luciano Teixeira 
 * @version : 
 * <P><B>
 * Classe Key que representa a chave composta para a tabela sn_rel_tipo_assinante_tp_solic.
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
 * Description                                Date        By	
 * -----------------------------------------  ----------- ------------------------- 
 * Bean usado para fazer a associação de      20/06/2005  Luciano Teixeira
 * tipo de assinante com tipo de solicitacao.
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
 * 21/06/2005 Luciano Teixeira N/A      Created 	
 * ==============================================================================
 * </PRE>
 */
public class SnRelTipoAssinanteTipoSolicitacaoKey implements Serializable,
		BaseCompositeKey {

	private SnTipoAssinanteBean tipoAssinante;
	private SnTipoSolicBean tipoSolic;

	public boolean equals(Object key) {
		if (key instanceof SnRelTipoAssinanteTipoSolicitacaoKey) {
			SnRelTipoAssinanteTipoSolicitacaoKey comp = (SnRelTipoAssinanteTipoSolicitacaoKey) key;
			return (this.getTipoAssinante().getPrimaryKey().equals(
					comp.getTipoAssinante().getPrimaryKey()) && this
					.getTipoSolic().getPrimaryKey().equals(
							comp.getTipoSolic().getPrimaryKey()));
		} else {
			return super.equals(key);
		}
	}

	public int hashCode() {
		int value = (tipoAssinante.getIdTipoAssinante().hashCode() + tipoSolic
				.getIdTipoSolic().hashCode() * 2);
		return (int) (value ^ (value >>> 32));
	}

	public void buildKey(String value) {
		StringTokenizer tok = new StringTokenizer(value, "|");
		Integer idTipoAssinante = new Integer(tok.nextToken());
		Integer idTipoSolic = new Integer(tok.nextToken());
		this.tipoAssinante = new SnTipoAssinanteBean(idTipoAssinante);
		this.tipoSolic = new SnTipoSolicBean(idTipoSolic);
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
	 * Obtains and returns the SnTipoSolicBean.
	 *
	 * @return Returns the tipoSolic.
	 * 
	 * @hibernate.many-to-one  
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoSolicBean" 
	 * 		column="id_tipo_solic"
	 * 		cascade="none"
	 * 		not-null="false"
	 */
	public SnTipoSolicBean getTipoSolic() {
		return this.tipoSolic;
	}

	/**
	 * 
	 * @param tipoSolic The tipoSolic to set
	 */
	public void setTipoSolic(SnTipoSolicBean tipoSolic) {
		this.tipoSolic = tipoSolic;
	}
}