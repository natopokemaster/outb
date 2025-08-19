/**
* Created on 23/10/2009
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
* $Id: SnTipoCobrancaBean.java,v 1.4 2011/01/26 12:12:57 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_tipo_cobranca
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
 * 23/10/2009 Luis Carneiro  N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 23/10/2009
 * @version $Revision: 1.4 $
 *
 * @hibernate.class 
 *		table="sn_tipo_cobranca"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-write"
 */
public class SnTipoCobrancaBean extends DomainBean {

	private static final long serialVersionUID = 2784956262077564431L;
	public static final String ID_TIPO_COBRANCA = "idTipoCobranca";
	
	private Integer idTipoCobranca;
	private String descricao;
	private Integer adesao;
	private Integer assinatura;
	
	public SnTipoCobrancaBean() {
		super(ID_TIPO_COBRANCA);
	}
	
	public SnTipoCobrancaBean(Integer idTipoCobranca) {
		this();
		this.idTipoCobranca = idTipoCobranca;
	}

	/**
	 * @return Returns the idTipoCobranca.
	 *
	 * @hibernate.id
	 *		column="id_tipo_cobranca"
	 *		generator-class="assigned"
	 */
	public Integer getIdTipoCobranca() {
		return idTipoCobranca;
	}

	/**
	 * @param idTipoCobranca 
	 *				The idTipoCobranca to set.
	 */
	public void setIdTipoCobranca(Integer idTipoCobranca) {
		this.idTipoCobranca = idTipoCobranca;
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

	/**
	 * @return Returns the adesao.
	 *
	 * @hibernate.property
	 *		column="adesao"
	 *		type="integer"
	 */
	public Integer getAdesao() {
		return adesao;
	}

	/**
	 * @param adesao 
	 *				The adesao to set.
	 */
	public void setAdesao(Integer adesao) {
		this.adesao = adesao;
	}

	/**
	 * @return Returns the assinatura.
	 *
	 * @hibernate.property
	 *		column="assinatura"
	 *		type="integer"
	 */
	public Integer getAssinatura() {
		return assinatura;
	}

	/**
	 * @param assinatura 
	 *				The assinatura to set.
	 */
	public void setAssinatura(Integer assinatura) {
		this.assinatura = assinatura;
	}
}
