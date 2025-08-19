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
 * Classe Bean que representa a tabela SN_MIDIA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_midia" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnMidiaBean extends DomainBean {

    private static final long serialVersionUID = 3906081239784763700L;

    public static final String PRIMARY_KEY = "idMidia";

    private Integer idMidia;
    private String descricao;

    /**
	 *  Construtor Padrão.
	 */
    public SnMidiaBean() {
        super(SnMidiaBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idMidia
     * @hibernate.id column="id_midia" generator-class="sequence"
     * @hibernate.generator-param name="sequence" value="ssn_id_midia"
     */
    public Integer getIdMidia() {
        return this.idMidia;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.property column="descricao" type = "string"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
	 * @param idMidia the idMidia to set
	 */
	public void setIdMidia(Integer idMidia) {
		this.idMidia = idMidia;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idMidia != null) {
            result = prime * result + this.idMidia.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnMidiaBean) {
            final SnMidiaBean comp = (SnMidiaBean) key;
            test = this.getIdMidia().equals(comp.getIdMidia());
        }
        return test;
    }
}
