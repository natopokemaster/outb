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
 * Classe Bean que representa a tabela SN_SOLIC_DESAB.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_solic_desab" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false" batch-size="10"
 * @hibernate.cache usage="read-write"
 */
public class SnSolicDesabBean extends DomainBean {

    private static final long serialVersionUID = -1630566634094205488L;

    private static final String PRIMARY_KEY = "idRazaoSolic";

    private Integer idRazaoSolic;
    private String descricao;

    /**
     * Construtor Padrão.
     */
    public SnSolicDesabBean() {
        super(SnSolicDesabBean.PRIMARY_KEY);
    }

    /**
     * @return the idRazaoSolic
     * @hibernate.id column="id_razao_solic"
     *               generator-class="assigned"
     */
    public Integer getIdRazaoSolic() {
        return this.idRazaoSolic;
    }

    /**
     * @return the descricao
     * @hibernate.property column="descricao"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
	 * @param idRazaoSolic the idRazaoSolic to set
	 */
	public void setIdRazaoSolic(Integer idRazaoSolic) {
		this.idRazaoSolic = idRazaoSolic;
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
        if (this.idRazaoSolic != null) {
            result = prime * result + this.idRazaoSolic.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnSolicDesabBean) {
            final SnSolicDesabBean comp = (SnSolicDesabBean) key;
            test = this.getIdRazaoSolic().equals(comp.getIdRazaoSolic());
        }
        return test;
    }
}
