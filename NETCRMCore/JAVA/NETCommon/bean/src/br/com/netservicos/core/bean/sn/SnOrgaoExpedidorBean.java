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
* $Id: SnOrgaoExpedidorBean.java,v 1.3 2010/05/14 19:25:13 T5001097 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_orgao_expedidor
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
 *		table="sn_orgao_expedidor"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 *
 * @hibernate.query 
 * 		name = "orgaoExpedidorByDescricao"
 * 		query = "SELECT orgaoExpedidor
 * 				FROM br.com.netservicos.core.bean.sn.SnOrgaoExpedidorBean orgaoExpedidor
 * 				WHERE orgaoExpedidor.descricao = :descricao"
 */
public class SnOrgaoExpedidorBean extends DomainBean {

	private static final long serialVersionUID = 6457391071579113985L;
	public static final String ID_ORGAO_EXPEDIDOR = "idOrgaoExpedidor";
	
	public static final String ORGAO_EXPEDIDOR_BY_DESCRICAO = "orgaoExpedidorByDescricao";

	private Integer idOrgaoExpedidor;
	private String descricao;

	public SnOrgaoExpedidorBean() {
		super(ID_ORGAO_EXPEDIDOR);
	}
	
	public SnOrgaoExpedidorBean(Integer idOrgaoExpedidor) {
		this();
		this.idOrgaoExpedidor = idOrgaoExpedidor;
	}

	/**
	 * @return Returns the idOrgaoExpedidor.
	 *
	 * @hibernate.id 
	 *		generator-class="assigned"
	 *		unsaved-value="null"
	 *		column="id_orgao_expedidor"
	 *		type="int"
	 */
	public Integer getIdOrgaoExpedidor() {
		return idOrgaoExpedidor;
	}

	/**
	 * @param idOrgaoExpedidor 
	 *				The idOrgaoExpedidor to set.
	 */
	public void setIdOrgaoExpedidor(Integer idOrgaoExpedidor) {
		this.idOrgaoExpedidor = idOrgaoExpedidor;
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
