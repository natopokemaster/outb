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
* $Id: SnProfissaoBean.java,v 1.3 2010/05/14 19:25:13 T5001097 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_profissao
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
 *		table="sn_profissao"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 */
public class SnProfissaoBean extends DomainBean {

	private static final long serialVersionUID = -494773707367834341L;
	public static final String ID_PROFISSAO = "idProfissao";

	private Long idProfissao;
	private String descricao;

	public SnProfissaoBean() {
		super(ID_PROFISSAO);
	}
	
	public SnProfissaoBean(Long idProfissao) {
		this();
		this.idProfissao = idProfissao;
	}

	/**
	 * @return Returns the idProfissao.
	 *
	 * @hibernate.id 
	 *		generator-class="sequence"
	 *		unsaved-value="null"
	 *		column="id_profissao"
	 *		type="long"
	 * 
	 * @hibernate.generator-param
	 * 		name="sequence"
	 * 		value="ssn_id_profissao"
	 */
	public Long getIdProfissao() {
		return idProfissao;
	}

	/**
	 * @param idProfissao 
	 *				The idProfissao to set.
	 */
	public void setIdProfissao(Long idProfissao) {
		this.idProfissao = idProfissao;
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
