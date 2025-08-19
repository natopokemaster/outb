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
* $Id: SnTipoTributacaoBean.java,v 1.3 2010/05/14 19:25:13 T5001097 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_tipo_tributacao
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
 * @author lcarneiro
 * @since 04/01/2010
 * @version $Revision: 1.3 $
 * 
 * @hibernate.class 
 *		table="sn_tipo_tributacao"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 */
public class SnTipoTributacaoBean extends DomainBean {

	private static final long serialVersionUID = -5621642156962882227L;
	public static final String ID_TIPO_TRIBUT = "idTipoTribut";
	
	private Integer idTipoTribut;
	private String descricao;
	
	public SnTipoTributacaoBean() {
		super(ID_TIPO_TRIBUT);
	}
	
	public SnTipoTributacaoBean(Integer idTipoTribut) {
		this();
		this.idTipoTribut = idTipoTribut;
	}

	/**
	 * @return Returns the idTipoTribut.
	 *
	 * @hibernate.id
     *		column="id_tipo_tribut"
	 *		generator-class="assigned"
	 */
	public Integer getIdTipoTribut() {
		return idTipoTribut;
	}

	/**
	 * @param idTipoTribut 
	 *				The idTipoTribut to set.
	 */
	public void setIdTipoTribut(Integer idTipoTribut) {
		this.idTipoTribut = idTipoTribut;
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
