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
 * Classe Bean que representa a tabela SN_CAMPANHA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_campanha" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnCampanhaBean extends DomainBean {

    private static final long serialVersionUID = -5767311061752025135L;

    public static final String PRIMARY_KEY = "idCampanha";

    private Integer idCampanha;
    private String campanha;
    private String codCampanha;

    /**
     * Construtor Padrão.
     */
    public SnCampanhaBean() {
        super(SnCampanhaBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idCampanha
     * @hibernate.id column="id_campanha" generator-class="sequence"
     * @hibernate.generator-param name="sequence" value="SSN_ID_CAMPANHA"
     */
    public Integer getIdCampanha() {
        return this.idCampanha;
    }

    /**
     * @return Returns the campanha.
     * @hibernate.property type = "string" column = "CAMPANHA"
     */
    public String getCampanha() {
        return this.campanha;
    }

    /**
     * @return Returns the codCampanha.
     * @hibernate.property type = "string" column = "COD_CAMPANHA"
     */
    public String getCodCampanha() {
        return this.codCampanha;
    }

	/**
	 * @param idCampanha the idCampanha to set
	 */
	public void setIdCampanha(Integer idCampanha) {
		this.idCampanha = idCampanha;
	}

	/**
	 * @param campanha the campanha to set
	 */
	public void setCampanha(String campanha) {
		this.campanha = campanha;
	}

	/**
	 * @param codCampanha the codCampanha to set
	 */
	public void setCodCampanha(String codCampanha) {
		this.codCampanha = codCampanha;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idCampanha != null) {
            result = prime * result + this.idCampanha.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnCampanhaBean) {
            final SnCampanhaBean comp = (SnCampanhaBean) key;
            test = this.getIdCampanha().equals(comp.getIdCampanha());
        }
        return test;
    }
}
