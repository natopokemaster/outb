/*
 * Created on 03/06/2009
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
package br.com.netservicos.core.bean.cp;

import java.math.BigDecimal;

import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_extensao_netfone_proposta.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Criação da classe						03/06/2009	Cristiano Monteiro
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           		Prior
 * Date       By             		Version  Project/CSR    Description
 * ---------- -------------- 		-------- -------------- ---------------------
 * 03/06/2009 Cristiano Monteiro	N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "cp_extensao_netfone_proposta"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="true"
 *                   batch-size="10"
 *                   
 * @hibernate.cache
 *      usage="read-write"
 *
 * @hibernate.query name  = "lstCpExtensaoNETFoneProposta"
 *                   query = "FROM	br.com.netservicos.core.bean.cp.CpExtensaoNETFonePropostaBean bean"
 * 
 * @hibernate.query name  = "lstExtensoesNETFonePropostaByPropostaAndPonto"
 *                   query = "SELECT extensao.idExtensaoNETFone,
 *                   				 extensao.ponto.idPonto,
 *                                   extensao.planoPgto.idPlanoPgto,
 *                                   extensao.planoPgto.descricao,
 *                                   extensao.qtde,
 *                                   extensao.precoUnitario
 *                              FROM br.com.netservicos.core.bean.cp.CpExtensaoNETFonePropostaBean extensao,
 *                   				 br.com.netservicos.core.bean.cp.CpPontoBean ponto,
 *                                   br.com.netservicos.core.bean.cp.CpPropostaBean proposta
 *                             WHERE proposta.idProposta = ponto.proposta.idProposta
 *                               AND ponto.idPonto = extensao.ponto.idPonto
 *                               AND ponto.proposta.idProposta = :idProposta
 *                               AND ponto.idPonto = :idPonto"
 */
public class CpExtensaoNETFonePropostaBean extends DomainBean {

    private static final String ID_EXTENSAO_NETFONE = "idExtensaoNETFone";
    private static final long serialVersionUID = 1L;
    private Long idExtensaoNETFone = null;
    private Long idPlanoPgto;
    private Integer qtde;
    private BigDecimal precoUnitario = new BigDecimal(0);
    private CpPontoBean ponto;
    private SnPlanoPgtoBean planoPgto;
    
	public CpExtensaoNETFonePropostaBean() {
        super(ID_EXTENSAO_NETFONE);
    }
    
    //**** Getters *****//
	
	/**
     * @hibernate.id 
     * 		column="id_extensao_netfone"
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="sq_id_extensao_netfone"
     */
    public Long getIdExtensaoNETFone() {
        return idExtensaoNETFone;
    } 
    
   
    public Long getIdPlanoPgto() {
        return idPlanoPgto;
    }

    /**
     * @hibernate.property
     * 		column="qt_extensao"
     * 		not-null="true"
     */
    public Integer getQtde() {
        return qtde;
    }

    /**
     * @hibernate.property
     * 		column="vl_unitario"
     *      not-null="true"
     */
    public BigDecimal getPrecoUnitario() {
        if (precoUnitario != null)
            return precoUnitario.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        return new BigDecimal(0.00);
    }
    
    /**
     * @hibernate.many-to-one
     * 		column="id_ponto"
     * 		insert="true"
     * 		update="false"
     * 		not-null="true"
     */
    public CpPontoBean getPonto() {
        return ponto;
    }

    /**
     * @hibernate.many-to-one
     *      column="id_plano_pgto"
     */
	public SnPlanoPgtoBean getPlanoPgto() {
		return planoPgto;
	}
	
	//**** Setters *****//
    
	/**
	 * @param idExtensaoNETFone
	 */
	public void setIdExtensaoNETFone(Long idExtensaoNETFone) {
		this.idExtensaoNETFone = idExtensaoNETFone;
	}

	/**
	 * @param idPlanoPagto
	 */
	public void setIdPlanoPgto(Long idPlanoPgto) {
		this.idPlanoPgto = idPlanoPgto;
	}

	/**
	 * @param qtde
	 */
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	/**
	 * @param precoUnitario
	 */
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/**
	 * @param ponto
	 */
	public void setPonto(CpPontoBean ponto) {
		this.ponto = ponto;
	}

	/**
	 * @param planoPgto
	 */
	public void setPlanoPgto(SnPlanoPgtoBean planoPgto) {
		this.planoPgto = planoPgto;
	}

	//**** Override equals *****//
	
	public boolean equals(Object obj) {
        if (obj instanceof CpExtensaoNETFonePropostaBean) {
        	if(((CpExtensaoNETFonePropostaBean) obj).getIdExtensaoNETFone()==null)
        		return false;
            return ((CpExtensaoNETFonePropostaBean) obj).getIdExtensaoNETFone().equals(this.getIdExtensaoNETFone());
        } else {
            return false;
        }
	}
	
}