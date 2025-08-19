/*
 * Created on 05/10/2010
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
 * Classe Bean que representa a tabela SN_TIPO_CARACTERISTICA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 05/10/2010
 * @version 1.0
 *                              
 * @hibernate.class table = "sn_tipo_caracteristica" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnTipoCaracteristicaBean extends DomainBean {
	
	private static final long serialVersionUID = 4531147452151008527L;

	private static final String PRIMARY_KEY = "idTipoCaracteristica";
	
	private Integer idTipoCaracteristica;
	private String descricaoTipoCaracteristica;

	/**
	 * Construtor Padrão.
	 */
	public SnTipoCaracteristicaBean() {
	    super(SnTipoCaracteristicaBean.PRIMARY_KEY);
	}
	
	/**
	 * @return the idTipoCaracteristica
	 * @hibernate.id column="ID_TIPO_CARACTERISTICA" generator-class="assigned"
	 */
	public Integer getIdTipoCaracteristica() {
		return idTipoCaracteristica;
	}
	
	/**
	 * @return the descricaoTipoCaracteristica
	 * @hibernate.property column="ds_tipo_caracteristica"
	 */
	public String getDescricaoTipoCaracteristica() {
		return descricaoTipoCaracteristica;
	}
	
	/**
	 * @param idTipoCaracteristica the idTipoCaracteristica to set
	 */
	public void setIdTipoCaracteristica(Integer idTipoCaracteristica) {
		this.idTipoCaracteristica = idTipoCaracteristica;
	}
	
	/**
	 * @param descricaoTipoCaracteristica the descricaoTipoCaracteristica to set
	 */
	public void setDescricaoTipoCaracteristica(String descricaoTipoCaracteristica) {
		this.descricaoTipoCaracteristica = descricaoTipoCaracteristica;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idTipoCaracteristica != null) {
            result = prime * result + this.idTipoCaracteristica.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnTipoCaracteristicaBean) {
            final SnTipoCaracteristicaBean comp = (SnTipoCaracteristicaBean) key;
            test = this.getIdTipoCaracteristica().equals(comp.getIdTipoCaracteristica());
        }
        return test;
    }
}
