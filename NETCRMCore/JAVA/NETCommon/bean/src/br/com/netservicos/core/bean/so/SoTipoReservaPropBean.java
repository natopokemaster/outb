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

package br.com.netservicos.core.bean.so;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela SO_TIPO_RESERVA_PROPOSTA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "so_tipo_reserva_proposta" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SoTipoReservaPropBean extends DomainBean {

    private static final long serialVersionUID = -6242442329487734673L;

    public static final String PRIMARY_KEY = "trpId";

    private Integer trpId;
    private String trpDescricao;

    /**
     * Construtor Padrão.
     */
    public SoTipoReservaPropBean() {
        super(SoTipoReservaPropBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the trpId.
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="trp_id" type = "int"
     */
    public Integer getTrpId() {
        return this.trpId;
    }

    /**
     * @return Returns the trpDescricao.
     * @hibernate.property column="trp_descricao" type = "string"
     */
    public String getTrpDescricao() {
        return this.trpDescricao;
    }

    /**
	 * @param trpId the trpId to set
	 */
	public void setTrpId(Integer trpId) {
		this.trpId = trpId;
	}

	/**
	 * @param trpDescricao the trpDescricao to set
	 */
	public void setTrpDescricao(String trpDescricao) {
		this.trpDescricao = trpDescricao;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.trpId != null) {
            result = prime * result + this.trpId.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SoTipoReservaPropBean) {
            final SoTipoReservaPropBean comp = (SoTipoReservaPropBean) key;
            test = this.getTrpId().equals(comp.getTrpId());
        }
        return test;
    }
}
