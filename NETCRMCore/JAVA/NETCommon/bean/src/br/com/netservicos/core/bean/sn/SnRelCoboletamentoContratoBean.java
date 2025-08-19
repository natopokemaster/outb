/*
 * Created on 29/07/2008
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.sn;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;
import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_rel_coboletamento_contrato
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                            Prior
 * Date       By              Version  Project/CSR    Description
 * ---------- --------------  -------- -------------- ----------------------------
 *  20/01/2010 Alexandre Soares N/A      NETCRMcore      Created.
 * ==============================================================================
 * </PRE>
 *
 *@hibernate.class table="sn_rel_coboletamento_contrato"
 *                 schema="prod_jd"
 *                 dynamic-insert="true"
 *                 dynamic-update="true"
 *                 lazy="true"
 *                 batch-size="10"
 *
 * @hibernate.query name  = "lsRelCoboletamentoContrato"
 *                   query = "FROM	br.com.netservicos.core.bean.sn.SnRelCoboletamentoContratoBean relCoboletamentoContrato"
 * 
 * @hibernate.query name = "lastCoboletamentoContrato" 
 *                  query = "FROM br.com.netservicos.core.bean.sn.SnRelCoboletamentoContratoBean coboletamentoContrato
 *                           WHERE coboletamentoContrato.composite.numContrato = :composite.numContrato
 *                           and coboletamentoContrato.composite.cidContrato = :composite.cidContrato
 *                           and coboletamentoContrato.dtFim = TO_DATE('30/12/2049','DD/MM/YYYY')"
 */
public class SnRelCoboletamentoContratoBean extends DomainBean {

	private static final long serialVersionUID = -4471849301152937382L;


	private SnRelCoboletamentoContratoKey composite;
	
	
	private String tpCoboletamento;                            
	private String idUsr;                           
	private Integer idInterfaceParceiro;	
	private Date dtFim;
	
	
	public static final String LST_SN_REL_COBOLETAMENTO_CONTRATO = "lsRelCoboletamentoContrato";
	
	public static final String LAST_COBOLETAMENTO_CONTRATO = "lastCoboletamentoContrato";

	public static final String ATRIBUTO_ID_COMPOSITE = "composite";

	/**
	 *  
	 */
	public SnRelCoboletamentoContratoBean() {
		super(ATRIBUTO_ID_COMPOSITE);
	}

	/**
	 * 
	 * @return Composite
	 * 
	 * @hibernate.id
	 * type = "composite" 
	 */
	public SnRelCoboletamentoContratoKey getComposite() {
		return composite;
	}
	
	/**
	 * 
	 * @param composite
	 */
	public void setComposite(SnRelCoboletamentoContratoKey composite) {
		this.composite = composite;
	}

	/**
	 * 
	 * @return String
	 * 
	 * @hibernate.property
	 * column = "tp_coboletamento"
	 * type = "string"
	 */
	public String getTpCoboletamento() {
		return tpCoboletamento;
	}

	/**
	 * 
	 * @param tpCoboletamento
	 */
	public void setTpCoboletamento(String tpCoboletamento) {
		this.tpCoboletamento = tpCoboletamento;
	}

	/**
	 * 
	 * @return String
	 * 
	 * @hibernate.property
	 * column = "id_usr"
	 * type = "string"
	 */
	public String getIdUsr() {
		return idUsr;
	}

	/**
	 * 
	 * @param idUsr
	 */
	public void setIdUsr(String idUsr) {
		this.idUsr = idUsr;
	}

	/**
	 * 
	 * @return Integer
	 * 
	 * @hibernate.property
	 * column = "id_interface_parceiro"
	 */
	public Integer getIdInterfaceParceiro() {
		return idInterfaceParceiro;
	}

	/**
	 * 
	 * @param idInterfaceParceiro
	 */
	public void setIdInterfaceParceiro(Integer idInterfaceParceiro) {
		this.idInterfaceParceiro = idInterfaceParceiro;
	}
	
	/**
	 * @return Returns the dtFim.
	 * @hibernate.property
	 * column = "dt_fim"
	 */
	public Date getDtFim() {
		return dtFim;
	}

	/**
	 * 
	 * @param dtFim
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	
}