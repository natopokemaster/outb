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
 * Classe Bean que representa a tabela SN_CARACTERISTICA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_caracteristica" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnCaracteristicaBean extends DomainBean {

    private static final long serialVersionUID = 8682190217991905607L;

    public static final String PRIMARY_KEY = "idCaracteristica";

    private Long idCaracteristica;
    private String descricao;
    private Long idSegmentoNegocios;

    /**
     * Construtor padrao
     */
    public SnCaracteristicaBean() {
        super(SnCaracteristicaBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idCaracteristica.
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="id_caracteristica"
     */
    public Long getIdCaracteristica() {
        return this.idCaracteristica;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.property column="descricao"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return Returns the idSegmentoNegocios.
     * @hibernate.property column="id_segmento_negocios"
     */
    public Long getIdSegmentoNegocios() {
        return this.idSegmentoNegocios;
    }

    /**
	 * @param idCaracteristica the idCaracteristica to set
	 */
	public void setIdCaracteristica(Long idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param idSegmentoNegocios the idSegmentoNegocios to set
	 */
	public void setIdSegmentoNegocios(Long idSegmentoNegocios) {
		this.idSegmentoNegocios = idSegmentoNegocios;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idCaracteristica != null) {
            result = prime * result + this.idCaracteristica.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnCaracteristicaBean) {
            final SnCaracteristicaBean comp = (SnCaracteristicaBean) key;
            test = this.getIdCaracteristica().equals(comp.getIdCaracteristica());
        }
        return test;
    }
}