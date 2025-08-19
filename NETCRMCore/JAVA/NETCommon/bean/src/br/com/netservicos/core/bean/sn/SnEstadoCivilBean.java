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
* $Id: SnEstadoCivilBean.java,v 1.4 2011/01/24 18:05:50 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_estado_civil
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
 *                            Prior
 * Date       By              Version  Project/CSR    	Description
 * ---------- --------------  -------- --------------    -------------------------
 * 04/01/2010 Luis Carneiro   N/A      NetCRM            Criação
 * 08/06/2010 Arnaldo Imamura N/A      NetCRM            Ajuste de nome de constante
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 04/01/2010
 * @version $Revision: 1.4 $
 * 
 * @hibernate.class 
 *		table="sn_estado_civil"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 * @hibernate.cache
 *		usage="read-only"
 */
public class SnEstadoCivilBean extends DomainBean {

	private static final long serialVersionUID = 2873341853823934069L;
	public static final String ID_ESTADO_CIVIL = "idEstadoCivil";

	private Integer idEstadoCivil;
	private String descricao;
	
	public SnEstadoCivilBean() {
		super(ID_ESTADO_CIVIL);
	}

	public SnEstadoCivilBean(Integer idEstadoCivil) {
		this();
		this.idEstadoCivil = idEstadoCivil;
	}

	/**
	 * @return Returns the idEstadoCivil.
	 *
	 * @hibernate.id 
	 *		generator-class="sequence"
	 *		unsaved-value="null"
	 *		column="id_estado_civil"
	 *		type="int"
	 */
	public Integer getIdEstadoCivil() {
		return idEstadoCivil;
	}

	/**
	 * @param idEstadoCivil 
	 *				The idEstadoCivil to set.
	 */
	public void setIdEstadoCivil(Integer idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
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
