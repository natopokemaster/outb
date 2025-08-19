/*
 * Created on 22/08/2005
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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_escolaridade.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Adição dos métodos equals, hashCode e 
 * toString									10/10/2006	Rafael Nami
 * Adição query lstVencimentosDisponiveis	20/11/2006	Bruno Troiano
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 22/08/2005 Bruno Troiano  N/A      Entidades      Created.
 * 22/08/2005 Bruno Troiano  1.0      Entidades      Development.
 * 10/10/2006 Rafael NAmi    1.1	  NETCommon		 Desenvolvimento
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_rel_dia_vcto_operadora"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *
 * @hibernate.query name  = "lstRelDiaVctoOperadora"
 *                   query = "FROM	br.com.netservicos.core.bean.sn.SnRelDiaVctoOperadoraBean relDiaVctoOperadora"
 *               
 * @hibernate.query
 * 		name = "validateDataVencimentoVoip"
 * 		query = "select
 * 					b.dia
 * 				from
 * 					SnRelDiaVctoOperadoraBean a,
 * 					SnDiaVctoBean b,
 * 					SnContratoBean c
 * 				where
 * 					a.idFormaPagamento = 1 and
 * 					a.idDiaVcto = b.idDiaVcto and
 * 					a.idDiaVcto = c.diaVcto.idDiaVcto and
 * 					a.cidContrato = c.compositeKey.cidContrato and
 * 					c.compositeKey.cidContrato = :cidContrato and
 * 					c.compositeKey.numContrato = :numContrato"     
 * 
 * @hibernate.query name = "lstVencimentosDisponiveis"
 * 	query = "SELECT DISTINCT diaVcto.dia,
 * 							 diaVcto.dia 
 * 			 FROM br.com.netservicos.core.bean.sn.SnRelDiaVctoOperadoraBean relDiaVctoOperadora,
 * 				  br.com.netservicos.core.bean.sn.SnDiaVctoBean diaVcto
 * 			 WHERE diaVcto.idDiaVcto = relDiaVctoOperadora.idDiaVcto 
 * 			 AND relDiaVctoOperadora.idFormaPagamento = 1"
 * 
 * 
 */
public class SnRelDiaVctoOperadoraBean extends DomainBean {

	private static final long serialVersionUID = 20340112876068867L;
	
	public static final String VALIDATE_DATA_VENCIMENTO_VOIP = "validateDataVencimentoVoip";

	private Integer idDiaVcto;

	private String cidContrato;
	
	private Integer idFormaPagamento;

	public static final String LST_SN_REL_DIA_VCTO = "lstRelDiaVctoOperadora";

	public static final String ATRIBUTO_ID_DIA_VCTO = "idDiaVcto";

	/**
	 *  
	 */
	public SnRelDiaVctoOperadoraBean() {
		super(ATRIBUTO_ID_DIA_VCTO);
	}

	/**
	 * 
	 * @return String
	 * 
	 * @hibernate.property
	 * 		column="cid_contrato"
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * 
	 * @param cidContrato
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	/**
	 * 
	 * @return Integer
	 * 
	 * @hibernate.property
	 * column="id_forma_pgto"
	 * 
	 */
	public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}

	/**
	 * 
	 * @param idFormaPagamento
	 */
	public void setIdFormaPagamento(Integer idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	/**
	 * 
	 * @return String
	 * @hibernate.id 
	 * 	column="id_dia_vcto"
	 * 	generator-class="assigned"
	 */
	public Integer getIdDiaVcto() {
		return idDiaVcto;
	}

	/**
	 * 
	 * @param idDiaVcto
	 */
	public void setIdDiaVcto(Integer idDiaVcto) {
		this.idDiaVcto = idDiaVcto;
	}

	 /**
	 * Método responsável por comparação atributo a atributo entre duas instâncias
	 * de uma classe
	 * @param 	o 	Objeto a ser comparado com a instância da classe atual.
	 * @return 	se as duas instâncias são iguais ou não. 
	 * 
	 * @author Rafael Nami
	 * @since  10/10/2006
	 */
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SnRelDiaVctoOperadoraBean))
			return false;
		SnRelDiaVctoOperadoraBean obj = (SnRelDiaVctoOperadoraBean) o;
		
		if(idDiaVcto != null ? !idDiaVcto.equals(obj.getIdDiaVcto()) : obj.getIdDiaVcto() != null)
			return false;
		if(idFormaPagamento != null ? !idFormaPagamento.equals(obj.getIdFormaPagamento()) : obj.getIdFormaPagamento() != null)
			return false;
		if(cidContrato != null ? !cidContrato.equals(obj.getCidContrato()) : obj.getCidContrato() != null)
			return false;
		return true;
	}
	
	/**
	 * Método responsável por retornar a instância da classe atual 
	 * no formato hash.
	 * @return  o hash da instância atual
	 * 
	 * @author Rafael Nami
	 * @since  10/10/2006
	 */
	public int hashCode() {
		int hash = 7;
		hash = hash * 31 + (idDiaVcto != null ? idDiaVcto.hashCode() : 0);
		hash = hash * 31 + (idFormaPagamento != null ? idFormaPagamento.hashCode() : 0);
		hash = hash * 31 + (cidContrato != null ? cidContrato.hashCode() : 0);
		return hash;
	}
	
}