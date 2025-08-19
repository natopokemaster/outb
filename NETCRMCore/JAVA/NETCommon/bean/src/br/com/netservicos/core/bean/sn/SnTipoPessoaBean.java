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
* $Id: SnTipoPessoaBean.java,v 1.3 2010/05/14 19:25:13 T5001097 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_tipo_pessoa
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
 * 04/01/2010 Guilherme Mello		  NetCRM			Variaveis estaticas tp pessoa
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 04/01/2010
 * @version $Revision: 1.3 $
 *
 * @hibernate.class 
 *		table="sn_tipo_pessoa"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 */
public class SnTipoPessoaBean extends DomainBean {

	private static final long serialVersionUID = 7728278711549293901L;
	public static final String ID_TIPO_PESSOA = "idTipoPessoa";
	
	private Integer idTipoPessoa;
	private String descricao;
	
	public static final int TP_FISICA = 1;
    public static final int TP_JURIDICA = 2;
	
	public SnTipoPessoaBean() {
		super(ID_TIPO_PESSOA);
	}
	
	public SnTipoPessoaBean(Integer idTipoPessoa) {
		this();
		this.idTipoPessoa = idTipoPessoa;
	}

	/**
	 * @return Returns the idTipoPessoa.
	 *
	 * @hibernate.id
     *		column="id_tipo_pessoa"
	 *		generator-class="assigned"
	 */
	public Integer getIdTipoPessoa() {
		return idTipoPessoa;
	}

	/**
	 * @param idTipoPessoa 
	 *				The idTipoPessoa to set.
	 */
	public void setIdTipoPessoa(Integer idTipoPessoa) {
		this.idTipoPessoa = idTipoPessoa;
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
