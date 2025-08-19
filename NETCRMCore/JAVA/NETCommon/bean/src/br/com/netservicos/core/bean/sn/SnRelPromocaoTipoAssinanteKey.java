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
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * @author  :Luciano Teixeira 
 * @version : 
 * <P><B>
 * Classe Key que representa a chave composta para a tabela sn_rel_promocao_tipo_assinante.
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
 * promocao com o tipo de assinante. 
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
public class SnRelPromocaoTipoAssinanteKey implements Serializable,
		BaseCompositeKey {

	private SnTipoAssinanteBean tipoAssinante;
	private SnPromocaoBean promocao;

	public boolean equals(Object key) {
		if (key instanceof SnRelPromocaoTipoAssinanteKey) {
			SnRelPromocaoTipoAssinanteKey comp = (SnRelPromocaoTipoAssinanteKey) key;
			return (this.getPromocao().getPrimaryKey().equals(
					comp.getPromocao().getPrimaryKey()) && this
					.getTipoAssinante().getPrimaryKey().equals(
							comp.getTipoAssinante().getPrimaryKey()));
		} else {
			return super.equals(key);
		}
	}

	public int hashCode() {
		int value = (promocao.getIdPromocao().hashCode() + tipoAssinante
				.getIdTipoAssinante().hashCode() * 2);
		return (int) (value ^ (value >>> 32));
	}

	public void buildKey(String value) {
		StringTokenizer tok = new StringTokenizer(value, "|");
		Integer idPromocao = new Integer(tok.nextToken());
		Integer idTipoAssinante = new Integer(tok.nextToken());
		this.promocao = new SnPromocaoBean(idPromocao);
		this.tipoAssinante = new SnTipoAssinanteBean(idTipoAssinante);
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
	 * @param tipoAssinante The tipo de assinate to set.
	 */
	public void setTipoAssinante(SnTipoAssinanteBean tipoAssinante) {
		this.tipoAssinante = tipoAssinante;
	}

	/**
	 * Obtains and returns the SnPromocaoBean.
	 *
	 * @return Returns the promocao.
	 * 
	 * @hibernate.many-to-one  
	 * 		class="br.com.netservicos.core.bean.sn.SnPromocaoBean" 
	 * 		column="id_promocao"
	 * 		cascade="none"
	 * 		not-null="false"
	 */
	public SnPromocaoBean getPromocao() {
		return this.promocao;
	}

	/**
	 * 
	 * @param promocao The promocao to set
	 */
	public void setPromocao(SnPromocaoBean promocao) {
		this.promocao = promocao;
	}

}