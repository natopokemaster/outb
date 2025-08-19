/*
 * Created on 21/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela SN_DIA_VCTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 22/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_dia_vcto" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnDiaVctoBean extends DomainBean {

    private static final long serialVersionUID = 3470344702351096448L;

    public static final String PRIMARY_KEY = "idDiaVcto";

    private Integer idDiaVcto;
    private String cidContrato;
    private Integer dia;
    private Integer diaEbt;

    /**
	 *  Construtor Padrão.
	 */
    public SnDiaVctoBean() {
        super(SnDiaVctoBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the cidContrato
     * @hibernate.property column="cid_contrato" type = "string"
     */
    public String getCidContrato() {
        return this.cidContrato;
    }

    /**
     * @return Returns the dia
     * @hibernate.property column="dia" type = "int"
     */
    public Integer getDia() {
        return this.dia;
    }

    /**
     * @return Returns the diaEbt
     * @hibernate.property column="dia_ebt" type = "int"
     */
    public Integer getDiaEbt() {
        return this.diaEbt;
    }

    /**
     * @return Returns the idDiaVcto
     * @hibernate.id column="id_dia_vcto" generator-class="assigned"
     */
    public Integer getIdDiaVcto() {
        return this.idDiaVcto;
    }

	/**
	 * @param idDiaVcto the idDiaVcto to set
	 */
	public void setIdDiaVcto(Integer idDiaVcto) {
		this.idDiaVcto = idDiaVcto;
	}

	/**
	 * @param cidContrato the cidContrato to set
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(Integer dia) {
		this.dia = dia;
	}

	/**
	 * @param diaEbt the diaEbt to set
	 */
	public void setDiaEbt(Integer diaEbt) {
		this.diaEbt = diaEbt;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idDiaVcto != null) {
            result = prime * result + this.idDiaVcto.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnDiaVctoBean) {
            final SnDiaVctoBean comp = (SnDiaVctoBean) key;
            test = this.getIdDiaVcto().equals(comp.getIdDiaVcto());
        }
        return test;
    }
}