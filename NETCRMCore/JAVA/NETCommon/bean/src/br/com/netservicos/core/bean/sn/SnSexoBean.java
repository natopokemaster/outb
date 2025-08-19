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
* $Id: SnSexoBean.java,v 1.3 2010/05/14 19:25:13 T5001097 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_sexo
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
 *		table="sn_sexo"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 *
 * @hibernate.query 
 * 		name = "sexoByDescricao"
 * 		query = "SELECT sexo
 * 				FROM br.com.netservicos.core.bean.sn.SnSexoBean sexo
 * 				WHERE sexo.descricao = :descricao"
 */
public class SnSexoBean extends DomainBean {

	private static final long serialVersionUID = -8728952849293035299L;
	public static final String ID_SEXO = "idSexo";
	
	public static final String SEXO_BY_DESCRICAO = "sexoByDescricao";
	
	private Integer idSexo;
	private String descricao;
	
	public SnSexoBean() {
		super(ID_SEXO);
	}

	public SnSexoBean(Integer idSexo) {
		this();
		this.idSexo = idSexo;
	}

	/**
	 * @return Returns the idSexo.
	 *
	 * @hibernate.id 
	 *		generator-class="sequence"
	 *		unsaved-value="null"
	 *		column="id_sexo"
	 *		type="int"
	 */
	public Integer getIdSexo() {
		return idSexo;
	}

	/**
	 * @param idSexo 
	 *				The idSexo to set.
	 */
	public void setIdSexo(Integer idSexo) {
		this.idSexo = idSexo;
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
