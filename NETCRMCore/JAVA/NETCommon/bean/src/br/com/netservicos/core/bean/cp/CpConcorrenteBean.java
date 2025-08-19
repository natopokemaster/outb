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

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_CONCORRENTE.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 * @hibernate.class table="cp_concorrente" dynamic-insert="true"
 *                  dynamic-update="true" lazy="true" batch-size="10"
 * @hibernate.cache usage="read-write"
 */
public class CpConcorrenteBean extends DomainBean {

    private static final long serialVersionUID = -7284394969028969145L;

    public static final String PRIMARY_KEY = "idConcorrente";

    private Integer idConcorrente;
    private String nmConcorrente;
    private Date dtIni;
    private Date dtFim;
    private Integer idTipoConcorrente;

    /**
     * Construtor Padrão.
     */
    public CpConcorrenteBean() {
        super(CpConcorrenteBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idAtividade.
     * @hibernate.id column="id_concorrente" generator-class="sequence"
     * @hibernate.generator-param name="sequence" value="sqcp_concorrente"
     */
    public Integer getIdConcorrente() {
        return this.idConcorrente;
    }

    /**
     * @return Returns the nmConcorrente.
     * @hibernate.property column="nm_concorrente"
     */
    public String getNmConcorrente() {
        return this.nmConcorrente;
    }

    /**
     * @return Returns the dtIni.
     * @hibernate.property column="dt_ini"
     */
    public Date getDtIni() {
        return this.dtIni;
    }

    /**
     * @return Returns the dtFim.
     * @hibernate.property column="dt_fim"
     */
    public Date getDtFim() {
        return this.dtFim;
    }

    /**
     * @return Returns the idTipoConcorrente.
     * @hibernate.property column="id_tipo_concorrente"
     */
    public Integer getIdTipoConcorrente() {
        return this.idTipoConcorrente;
    }
    
    /**
	 * @param idConcorrente the idConcorrente to set
	 */
	public void setIdConcorrente(Integer idConcorrente) {
		this.idConcorrente = idConcorrente;
	}

	/**
	 * @param nmConcorrente the nmConcorrente to set
	 */
	public void setNmConcorrente(String nmConcorrente) {
		this.nmConcorrente = nmConcorrente;
	}

	/**
	 * @param dtIni the dtIni to set
	 */
	public void setDtIni(Date dtIni) {
		this.dtIni = dtIni;
	}

	/**
	 * @param dtFim the dtFim to set
	 */
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	/**
	 * @param idTipoConcorrente the idTipoConcorrente to set
	 */
	public void setIdTipoConcorrente(Integer idTipoConcorrente) {
		this.idTipoConcorrente = idTipoConcorrente;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idConcorrente != null) {
            result = prime * result + this.idConcorrente.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpConcorrenteBean) {
            final CpConcorrenteBean comp = (CpConcorrenteBean) key;
            test = this.getIdConcorrente().equals(comp.getIdConcorrente());
        }
        return test;
    }
}
