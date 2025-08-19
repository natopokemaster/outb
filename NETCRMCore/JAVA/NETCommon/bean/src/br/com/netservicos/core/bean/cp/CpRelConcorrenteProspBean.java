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
 * Classe Bean que representa a tabela CP_REL_CONCORRENTE_PROSPECT.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 * @hibernate.class table="cp_rel_concorrente_prospect" dynamic-insert="true"
 *                  dynamic-update="true" dynamic-delete="true" lazy="false"
 *                  batch-size="10"
 */
public class CpRelConcorrenteProspBean extends DomainBean {

    private static final long serialVersionUID = 2108870373713517310L;

    public static final String ID_REL_CONCOR_PROSP = "idRelConcorrenteProsp";

    private Long idRelConcorrenteProsp;
    private String dsPcteConcorrente;
    private Long qtPtosConcorrente;
    private Double vlConcorrente;
    private CpProspectBean prospect;
    private CpConcorrenteBean concorrente;

    /**
     * Construtor Padrão.
     */
    public CpRelConcorrenteProspBean() {
        super(CpRelConcorrenteProspBean.ID_REL_CONCOR_PROSP);
    }

    /**
     * @return Returns the idRelConcorrenteProsp
     * @hibernate.id column="id_rel_concorrente_prospect"
     *               generator-class="sequence"
     * @hibernate.generator-param name="sequence"
     *                            value="sqcp_rel_concorrente_prospect"
     */
    public Long getIdRelConcorrenteProsp() {
        return this.idRelConcorrenteProsp;
    }

    /**
     * @return Returns the dsPcteConcorrente.
     * @hibernate.property column="ds_pacote_concorrente"
     */
    public String getDsPcteConcorrente() {
        return this.dsPcteConcorrente;
    }

    /**
     * @return Returns the qtPtosConcorrente.
     * @hibernate.property column="qt_pontos_concorrente"
     */
    public Long getQtPtosConcorrente() {
        return this.qtPtosConcorrente;
    }

    /**
     * @return Returns the vlConcorrente.
     * @hibernate.property column="vl_concorrente"
     */
    public Double getVlConcorrente() {
        return this.vlConcorrente;
    }
    
    /**
     * @return Returns the CpConcorrenteBean.
     * @hibernate.many-to-one column="id_concorrente" cascade="none"
     *                        insert="true" update="true" not-null="true"
     */
    public CpConcorrenteBean getConcorrente() {
        return this.concorrente;
    }

    /**
     * @return Returns the CpProspectBean.
     * @hibernate.many-to-one column="id_prospect" cascade="none" insert="true"
     *                        update="true" not-null="true"
     */
    public CpProspectBean getProspect() {
        return this.prospect;
    }
    
    /**
	 * @param idRelConcorrenteProsp the idRelConcorrenteProsp to set
	 */
	public void setIdRelConcorrenteProsp(Long idRelConcorrenteProsp) {
		this.idRelConcorrenteProsp = idRelConcorrenteProsp;
	}

	/**
	 * @param dsPcteConcorrente the dsPcteConcorrente to set
	 */
	public void setDsPcteConcorrente(String dsPcteConcorrente) {
		this.dsPcteConcorrente = dsPcteConcorrente;
	}

	/**
	 * @param qtPtosConcorrente the qtPtosConcorrente to set
	 */
	public void setQtPtosConcorrente(Long qtPtosConcorrente) {
		this.qtPtosConcorrente = qtPtosConcorrente;
	}

	/**
	 * @param vlConcorrente the vlConcorrente to set
	 */
	public void setVlConcorrente(Double vlConcorrente) {
		this.vlConcorrente = vlConcorrente;
	}

	/**
	 * @param prospect the prospect to set
	 */
	public void setProspect(CpProspectBean prospect) {
		this.prospect = prospect;
	}

	/**
	 * @param concorrente the concorrente to set
	 */
	public void setConcorrente(CpConcorrenteBean concorrente) {
		this.concorrente = concorrente;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idRelConcorrenteProsp != null) {
            result = prime * result + this.idRelConcorrenteProsp.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpRelConcorrenteProspBean) {
            final CpRelConcorrenteProspBean comp = (CpRelConcorrenteProspBean) key;
            test = this.getIdRelConcorrenteProsp().equals(comp.getIdRelConcorrenteProsp());
        }
        return test;
    }
}
