/*
 * Created on 15/08/2005
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
package br.com.netservicos.core.bean.sgs;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
* <P><B>
* Description :
* </B>
* <BR>
* 	Classe Bean que representa a tabela sgs.cidade.
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
*                           Prior
* Date       By             Version  Project/CSR    Description
* ---------- -------------- -------- -------------- ----------------------------
* 15/08/2005 Juliano Tarini N/A      Entidades      Created.
* ==============================================================================
* </PRE>
*
* @hibernate.class table = "sgs.cidade"
*                  dynamic-insert = "true"
*                  dynamic-update = "true"
*                  lazy="false"
* 
* @hibernate.cache
*       usage = "read-write"
*/
public class SgsCidadeBean extends DomainBean {

	private Long codCidade;
	private String sglEstado;
	private String nomCidade;
	private Long codOperadora;
	private String indSms;
	private String indVenda;
	
	public static final String ATRIBUTO_COD_CIDADE = "codCidade";
	
	public SgsCidadeBean(){
	    super(ATRIBUTO_COD_CIDADE);
	}
	
	/**
	 * @return Returns the codCidade.
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * unsaved-value = "null"
	 * column="cod_cidade"
	 * type = "long"
	 */
	public Long getCodCidade() {
		return codCidade;
	}
	/**
	 * @param codCidade The codCidade to set.
	 */
	public void setCodCidade(Long codCidade) {
		this.codCidade = codCidade;
	}
	
	/**
	 * Obtains and returns the new value of the sglEstado attribute.
	 *
	 * @return Returns the sglEstado.
	 * 
	 * @hibernate.property
	 * column="sgl_estado"
	 * type = "string"
	 */
	public String getSglEstado() {
		return sglEstado;
	}
	
	/**
	 * @param sglEstado The sglEstado to set.
	 */
	public void setSglEstado(String sglEstado) {
		this.sglEstado = sglEstado;
	}
	
	/**
	 * Obtains and returns the new value of the nomCidade attribute.
	 *
	 * @return Returns the nomCidade.
	 * 
	 * @hibernate.property
	 * column="nom_cidade"
	 * type = "string"
	 */
	public String getNomCidade() {
		return nomCidade;
	}
	
	/**
	 * @param nomCidade The nomCidade to set.
	 */
	public void setNomCidade(String nomCidade) {
		this.nomCidade = nomCidade;
	}
	
	/**
	 * Obtains and returns the new value of the codOperadora attribute.
	 *
	 * @return Returns the codOperadora.
	 * 
	 * @hibernate.property
	 * column="cod_operadora"
	 * type = "long"
	 */
	public Long getCodOperadora() {
		return codOperadora;
	}
	
	/**
	 * @param codOperadora The codOperadora to set.
	 */
	public void setCodOperadora(Long codOperadora) {
		this.codOperadora = codOperadora;
	}
	
	/**
	 * Obtains and returns the new value of the indSms attribute.
	 *
	 * @return Returns the indSms.
	 * 
	 * @hibernate.property
	 * column="ind_sms"
	 * type = "string"
	 */
	public String getIndSms() {
		return indSms;
	}
	
	/**
	 * @param indSms The indSms to set.
	 */
	public void setIndSms(String indSms) {
		this.indSms = indSms;
	}
	
	/**
	 * Obtains and returns the new value of the indVenda attribute.
	 *
	 * @return Returns the indVenda.
	 * 
	 * @hibernate.property
	 * column="ind_venda"
	 * type = "string"
	 */
	public String getIndVenda() {
		return indVenda;
	}
	
	/**
	 * @param indVenda The indVenda to set.
	 */
	public void setIndVenda(String indVenda) {
		this.indVenda = indVenda;
	}
	
}
