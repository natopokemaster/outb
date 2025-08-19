/**
* Created on 04/01/2010
* Project : NETCommon
*
* Copyright © 2007 NET.
* Brasil
* All rights reserved.
*
* This software is the confidential and proprietary information of NET.
* You shall not disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with Net Serviços.
*
* $Id: SnEscolaridadeBean.java,v 1.3 2010/05/14 19:25:13 T5001097 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_escolaridade
 * </P>
 * <P>
 * <B> Issues : <BR>
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    	Description
 * ---------- -------------- -------- --------------    -------------------------
 * 04/01/2010 Luis Carneiro  N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 04/01/2010
 * @version $Revision: 1.3 $
 * 
 * @hibernate.class
 * 		table="sn_escolaridade"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 */
public class SnEscolaridadeBean extends DomainBean {

	private static final long serialVersionUID = 6388437417804434505L;
	public static final String ID_ESCOLARIDADE = "idEscolaridade";
	
	private Integer idEscolaridade;
	private String descricao;
	
	public SnEscolaridadeBean() {
		super(ID_ESCOLARIDADE);
	}
	
	public SnEscolaridadeBean(Integer idEscolaridade) {
		this();
		this.idEscolaridade = idEscolaridade;
	}

	/**
	 * @return Returns the idEscolaridade.
	 *
	 * @hibernate.id 
	 *		generator-class="sequence"
	 *		unsaved-value="null"
	 *		column="id_escolaridade"
	 *		type="int"
	 */
	public Integer getIdEscolaridade() {
		return idEscolaridade;
	}

	/**
	 * @param idEscolaridade 
	 *				The idEscolaridade to set.
	 */
	public void setIdEscolaridade(Integer idEscolaridade) {
		this.idEscolaridade = idEscolaridade;
	}

	/**
	 * @return Returns the descricao.
	 *
	 * @hibernate.property
	 *		column="descricao"
	 *		type="string"
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao 
	 *				The descricao to set.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
