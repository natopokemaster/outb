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
* $Id: SnRelContratoMestreFiliadoBean.java,v 1.2 2011/01/19 16:25:20 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_rel_contrato_mestre_filiado
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
 * 13/09/2010 Márcio Dantas	  N/A      NetCombo            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author marcio@mdantas.com.br
 * @since 13/09/2010
 * @version $Revision: 1.2 $
 * 
 * @hibernate.class
 * 		table="sn_rel_contrato_mestre_filiado"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 */
public class SnRelContratoMestreFiliadoBean extends DomainBean {

	private static final long serialVersionUID = 820618364406797067L;
	
	private SnRelContratoMestreFiliadoKey composite;
    
	//private Long numContratoMestre; //primaryKey
	//private Long numContratoFiliado; //primaryKey
	//private String cidContrato; //primaryKey
	private Integer idProduto;
	//private Integer idPonto; //primaryKey
	//private Date dtIni; //primaryKey
	//private Date dtFim;//primaryKey
	
	public static final String ATRIBUTO_ID_COMPOSITE = "composite";
	
	
	public SnRelContratoMestreFiliadoBean(Long numContratoMestre) {
		this();
	}
	
	/**
	 *  
	 */
	public SnRelContratoMestreFiliadoBean() {
		super(ATRIBUTO_ID_COMPOSITE);
	}

	/**
	 * 
	 * @return Composite
	 * 
	 * @hibernate.id
	 * type = "composite" 
	 */
	public SnRelContratoMestreFiliadoKey getComposite() {
		return composite;
	}
	
	/**
	 * 
	 * @param composite
	 */
	public void setComposite(SnRelContratoMestreFiliadoKey composite) {
		this.composite = composite;
	}

	/**
	 * @return the idProduto
	 * @hibernate.property
	 * column = "id_produto"
	 * type = "int"
	 */
	public Integer getIdProduto() {
		return idProduto;
	}

	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

}
