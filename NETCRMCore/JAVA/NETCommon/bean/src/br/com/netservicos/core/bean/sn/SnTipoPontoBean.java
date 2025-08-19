/*
 * Created on 20/10/2010
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
 * Classe bean que representa a tabela SN_TIPO_PONTO
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/10/2010
 * @version
 * @hibernate.class table = "sn_tipo_ponto" dynamic-insert = "true"
 *                  dynamic-update = "true" lazy="false"
 */

public class SnTipoPontoBean extends DomainBean {

    private static final long serialVersionUID = -2207316963195947608L;

    private static final String PRIMARY_KEY = "idTipoPonto";

    private Integer idTipoPonto;
    private String descricao;

    /**
     * Construtor Padrão.
     */
    public SnTipoPontoBean() {
        super(SnTipoPontoBean.PRIMARY_KEY);
    }

    /**
     * @return Integer
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="ID_TIPO_PONTO"
     */
    public Integer getIdTipoPonto() {
        return this.idTipoPonto;
    }

    /**
     * @param pIdTipoPonto
     *        The setIdTipoPonto to set.
     */
    public void setIdTipoPonto(final Integer pIdTipoPonto) {
        this.idTipoPonto = pIdTipoPonto;
    }

    /**
     * @hibernate.property column="DESCRICAO"
     * @return Returns the descricao.
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @param pDescricao
     *        The descricao to set.
     */
    public void setDescricao(final String pDescricao) {
        this.descricao = pDescricao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (this.idTipoPonto != null) {
            result = prime * result + this.idTipoPonto.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = false;
        if (key instanceof SnTipoPontoBean) {
            final SnTipoPontoBean comp = (SnTipoPontoBean) key;
            test = this.getIdTipoPonto().equals(comp.getIdTipoPonto());
        } else {
            test = super.equals(key);
        }
        return test;
    }
}