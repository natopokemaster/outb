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
* $Id: SnCPFInadimplenteBean.java,v 1.3 2011/01/24 18:05:50 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_cpf_inadimplente
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
 * 04/01/2010 gfmello		  N/A      NetCRM            Criação
 * 08/06/2010 aimamura		  N/A      NetCRM            Ajuste de nome de atributo
 * ==============================================================================
 * </PRE>
 *
 * @author Guilherme Formaggio de Mello
 * @since 04/01/2010
 * @version $Revision: 1.3 $
 *
 * @hibernate.class 
 *		table="sn_cpf_inadimplente"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 */
public class SnCPFInadimplenteBean extends DomainBean {

	private static final long serialVersionUID = -8728952849293035299L;
	public static final String ID_CPF_INADIMPLENTE = "cpf";
	
	private String cpf;
	private Date dtGer;
	
	public SnCPFInadimplenteBean() {
		super(ID_CPF_INADIMPLENTE);
	}

	public SnCPFInadimplenteBean(String cpf) {
		this();
		this.cpf = cpf;
	}
	
	/**
	 * @return Returns the cpf
	 *
	 * @hibernate.id 
	 *		generator-class="assigned"
	 *		column="cpf"
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * 
	 * the CPF to set
	 * 
	 * @param cpf
	 * 
	 * @since 04/01/2010
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return Returns the descricao.
	 *
	 * @hibernate.property
	 *		column="dt_ger"
	 */
	public Date getDtGer() {
		return dtGer;
	}

	/**
	 * 
	 * The date to set
	 * 
	 * @param dtGer
	 * 
	 * @since 04/01/2010
	 */
	public void setDtGer(Date dtGer) {
		this.dtGer = dtGer;
	}

}
