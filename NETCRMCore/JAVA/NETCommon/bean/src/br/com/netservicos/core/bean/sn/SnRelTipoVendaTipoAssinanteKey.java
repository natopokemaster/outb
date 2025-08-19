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
 * Classe Key que representa a chave composta para a tabela sn_rel_tipo_venda_tipo_asn.
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
 * Bean usado para fazer a associação de    21/06/2005  Luciano Teixeira
 * tipo venda com tipo de assinante .
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
public class SnRelTipoVendaTipoAssinanteKey implements Serializable,
		BaseCompositeKey {

	private SnTipoAssinanteBean tipoAssinante;
	private SnTipoVendaBean tipoVenda;

	public boolean equals(Object key) {
		if (key instanceof SnRelTipoVendaTipoAssinanteKey) {
			SnRelTipoVendaTipoAssinanteKey comp = (SnRelTipoVendaTipoAssinanteKey) key;
			return (this.getTipoVenda().getPrimaryKey().equals(
					comp.getTipoVenda().getPrimaryKey()) && this
					.getTipoAssinante().getPrimaryKey().equals(
							comp.getTipoAssinante().getPrimaryKey()));
		} else {
			return super.equals(key);
		}
	}

	public int hashCode() {
		int value = (tipoVenda.getIdTipoVenda().hashCode() + tipoAssinante
				.getIdTipoAssinante().hashCode() * 2);
		return (int) (value ^ (value >>> 32));
	}

	public void buildKey(String value) {
		StringTokenizer tok = new StringTokenizer(value, "|");
		Integer idTipoVenda = new Integer(tok.nextToken());
		Integer idTipoAssinante = new Integer(tok.nextToken());
		this.tipoVenda = new SnTipoVendaBean();
		this.tipoVenda.setIdTipoVenda(idTipoVenda);
		this.tipoAssinante = new SnTipoAssinanteBean(idTipoAssinante);
	}

	/**
	 * Obtains and returns the SnTipoAssinanteBean.
	 *
	 * @return Returns the tipo assinante.
	 * 
	 * @hibernate.many-to-one  
	 * 		name="tipoAssinante" 
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
	 * Obtains and returns the SnCidadeOperadoraBean.
	 *
	 * @return Returns the tipoVenda.
	 * 
	 * @hibernate.many-to-one  
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoVendaBean" 
	 * 		column = "id_tipo_venda"
	 * 		cascade="none"
	 * 		not-null="false"
	 */
	public SnTipoVendaBean getTipoVenda() {
		return this.tipoVenda;
	}

	/**
	 * 
	 * @param operadora The tipoVenda to set
	 */
	public void setTipoVenda(SnTipoVendaBean tipoVenda) {
		this.tipoVenda = tipoVenda;
	}

}