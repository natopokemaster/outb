/*
 * Created on 20/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.cp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_CARTAO_CREDITO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_cartao_credito" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class CpCartaoCreditoBean extends DomainBean implements Cloneable{

    private static final long serialVersionUID = -7756792878324859923L;

    private static final String ID_PROSPECT = "idProspect";

    private Long idProspect;
    private String numero;
    private String operadora;
    private String titular;
    private String validade;
    private CpProspectBean prospect;

    /**
     * Construtor Padrao.
     */
    public CpCartaoCreditoBean() {
        super(CpCartaoCreditoBean.ID_PROSPECT);
    }

    /**
     * @return Returns the idProspect.
     * @hibernate.id column="id_prospect" generator-class="assigned"
     */
    public Long getIdProspect() {
        return this.idProspect;
    }

    /**
     * @return Returns the numero.
     * @hibernate.property column="numero" not-null="true"
     */
    public String getNumero() {
        return this.numero;
    }

    /**
     * @return Returns the operadora.
     * @hibernate.property column="operadora" not-null="true"
     */
    public String getOperadora() {
        return this.operadora;
    }

    /**
     * @return Returns the titular.
     * @hibernate.property column="titular"
     */
    public String getTitular() {
    	return this.titular;
    }

    /**
     * @return Returns the validade.
     * @hibernate.property column="validade"
     */
    public String getValidade() {
    	return this.validade;
    }

    /**
     * @return Returns the CpProspectBean.
     * @hibernate.one-to-one column="id_prospect" constrained="true" cascade="none" lazy="proxy"
     */
    public CpProspectBean getProspect() {
        return this.prospect;
    }

    /**
	 * @param idProspect the idProspect to set
	 */
	public void setIdProspect(Long idProspect) {
		this.idProspect = idProspect;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @param operadora the operadora to set
	 */
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	/**
	 * @param titular the titular to set
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}

	/**
	 * @param validade the validade to set
	 */
	public void setValidade(String validade) {
		this.validade = validade;
	}

	/**
	 * @param prospect the prospect to set
	 */
	public void setProspect(CpProspectBean prospect) {
		this.prospect = prospect;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idProspect != null) {
            result = prime * result + this.idProspect.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpCartaoCreditoBean) {
            final CpCartaoCreditoBean comp = (CpCartaoCreditoBean) key;
            test = this.getIdProspect().equals(comp.getIdProspect());
        }
        return test;
    }
}
