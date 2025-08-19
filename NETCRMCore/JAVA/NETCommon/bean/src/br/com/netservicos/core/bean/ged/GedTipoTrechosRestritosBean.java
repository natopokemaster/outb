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
 * 		table="TIPO_TRECHOS_RESTRITOS"
 * 		dynamic-insert="true"
 * 		dynamic-update="true"
 * 		lazy="false"
 *                  
 * @hibernate.cache
 * 		usage="read-write"
 */
public class GedTipoTrechosRestritosBean extends DomainBean {
	
	private static final long serialVersionUID = 1L;
	
	public static final Integer TIPO_RESTRICAO_NAO_SERVIDO = Integer.valueOf(1);
	public static final Integer TIPO_RESTRICAO_INDISPONIVEL_PARA_VIRTUA = Integer.valueOf(2);	
	public static final Integer TIPO_RESTRICAO_SO_CABO = Integer.valueOf(3);

	private Integer codRestricao;
	private String descMsg;
	private String descRestricao;
	private Integer prioridade;
	
	public GedTipoTrechosRestritosBean(String primaryKeyName) {
		super("codRestricao");
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.id
	 * 		column="COD_RESTRICAO"
	 * 		generator-class="assigned"
	 */
	public Integer getCodRestricao() {
		return codRestricao;
	}

	/**
	 * @param codRestricao The codRestricao to set.
	 */
	public void setCodRestricao(Integer codRestricao) {
		this.codRestricao = codRestricao;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="DESC_MSG"
	 */
	public String getDescMsg() {
		return descMsg;
	}

	/**
	 * @param descMsg The descMsg to set.
	 */
	public void setDescMsg(String descMsg) {
		this.descMsg = descMsg;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="DESC_RESTRICAO"
	 */
	public String getDescRestricao() {
		return descRestricao;
	}

	/**
	 * @param descRestricao The descRestricao to set.
	 */
	public void setDescRestricao(String descRestricao) {
		this.descRestricao = descRestricao;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="PRIORIDADE"
	 */
	public Integer getPrioridade() {
		return prioridade;
	}

	/**
	 * @param prioridade The prioridade to set.
	 */
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}
	
}