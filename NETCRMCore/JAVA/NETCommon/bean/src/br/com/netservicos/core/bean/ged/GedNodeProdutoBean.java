/*
 * Created on 12/09/2007
 *
 * Copyright © 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.ged;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * =============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * =============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 12/09/2007 Rodrigo Silva  N/A      NETCommon      Created.
 * ==============================================================================
 * </PRE>
 * 
 * @hibernate.class 
 * 		table="NODE_PRODUTO"
 * 		dynamic-insert="true"
 * 		dynamic-update="true"
 * 		lazy="false"
 *                  
 * @hibernate.cache
 * 		usage="read-write"
 */
public class GedNodeProdutoBean extends DomainBean {

	private static final long serialVersionUID = 1L;
	
	private GedNodeProdutoKey compositeKey;
	private Date dtAtivacao;
	private Date dtAtivacaoCom;
	private Date dtAtualizacao;
	private Date dtPrevAtivacao;
	private Date dtPrevAtivacaoCom;
	private Long qtdHpInstal;
	
	/**
	 * @param primaryKeyName
	 */
	public GedNodeProdutoBean(String primaryKeyName) {
		super("compositeKey");
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.id
	 * 		type="composite"
	 */
	public GedNodeProdutoKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 */
	public void setCompositeKey(GedNodeProdutoKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="DT_ATIVACAO"
	 */
	public Date getDtAtivacao() {
		return dtAtivacao;
	}

	/**
	 * @param dtAtivacao The dtAtivacao to set.
	 */
	public void setDtAtivacao(Date dtAtivacao) {
		this.dtAtivacao = dtAtivacao;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="DT_ATIVACAO_COM"
	 */
	public Date getDtAtivacaoCom() {
		return dtAtivacaoCom;
	}

	/**
	 * @param dtAtivacaoCom The dtAtivacaoCom to set.
	 */
	public void setDtAtivacaoCom(Date dtAtivacaoCom) {
		this.dtAtivacaoCom = dtAtivacaoCom;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="DT_ATUALIZACAO"
	 */
	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	/**
	 * @param dtAtualizacao The dtAtualizacao to set.
	 */
	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="DT_PREV_ATIVACAO"
	 */
	public Date getDtPrevAtivacao() {
		return dtPrevAtivacao;
	}

	/**
	 * @param dtPrevAtivacao The dtPrevAtivacao to set.
	 */
	public void setDtPrevAtivacao(Date dtPrevAtivacao) {
		this.dtPrevAtivacao = dtPrevAtivacao;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="DT_PREV_ATIVACAO_COM"
	 */
	public Date getDtPrevAtivacaoCom() {
		return dtPrevAtivacaoCom;
	}

	/**
	 * @param dtPrevAtivacaoCom The dtPrevAtivacaoCom to set.
	 */
	public void setDtPrevAtivacaoCom(Date dtPrevAtivacaoCom) {
		this.dtPrevAtivacaoCom = dtPrevAtivacaoCom;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 *		column="QTD_HP_INSTAL"
	 */
	public Long getQtdHpInstal() {
		return qtdHpInstal;
	}

	/**
	 * @param qtdHpInstal The qtdHpInstal to set.
	 */
	public void setQtdHpInstal(Long qtdHpInstal) {
		this.qtdHpInstal = qtdHpInstal;
	}

}