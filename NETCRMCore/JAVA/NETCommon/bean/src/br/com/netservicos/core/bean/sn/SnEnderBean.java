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
* $Id: SnEnderBean.java,v 1.5 2011/01/26 12:12:57 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_ender
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
 * @version $Revision: 1.5 $
 * 
 * @hibernate.class 
 * 		table="sn_ender"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 */
public class SnEnderBean extends DomainBean {

	private static final long serialVersionUID = 1541683591854130329L;
	public static final String ID_ENDER = "idEnder";
	
	private Long idEnder;
	private Long idEdificacao;

	public SnEnderBean() {
		super(ID_ENDER);
	}
	
	public SnEnderBean(Long idEnder) {
		this();
		this.idEnder = idEnder;
	}

	/**
	 * @return Returns the idEnder.
	 *
	 * @hibernate.id 
	 *		generator-class="sequence"
	 *		unsaved-value="null"
	 *		column="id_ender"
	 *		type="long"
	 * 
	 * @hibernate.generator-param 
	 * 		name="sequence" 
	 * 		value="ssn_id_ender"
	 */
	public Long getIdEnder() {
		return idEnder;
	}

	/**
	 * @param idEnder 
	 *				The idEnder to set.
	 */
	public void setIdEnder(Long idEnder) {
		this.idEnder = idEnder;
	}

	/**
	 * @return Returns the idEdificacao.
	 *
	 * @hibernate.property
	 *		column="id_edificacao"
	 *		type="long"
	 */
	public Long getIdEdificacao() {
		return idEdificacao;
	}

	/**
	 * @param idEdificacao 
	 *				The idEdificacao to set.
	 */
	public void setIdEdificacao(Long idEdificacao) {
		this.idEdificacao = idEdificacao;
	}
}
