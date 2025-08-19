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
 * Classe Bean que representa a tabela SN_TIPO_PROMOCAO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_tipo_promocao" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnTipoPromocaoBean extends DomainBean {

    private static final long serialVersionUID = 3761408612114839856L;

    public static final String PRIMARY_KEY = "idTipoPromocao";

    private Integer idTipoPromocao;
    private String descricao;

    /**
	 *  Construtor Padrão.
	 */
    public SnTipoPromocaoBean() {
        super(PRIMARY_KEY);
    }

    /**
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="id_tipo_promocao" type = "int"
     * @return Integer
     */
    public Integer getIdTipoPromocao() {
        return this.idTipoPromocao;
    }

    /**
     * Obtains and returns the new value of the descricao attribute.
     * @return Returns the descricao.
     * @hibernate.property column="descricao" type = "string"
     */
    public String getDescricao() {
        return this.descricao;
    }
    
    /**
     * @param pIdTipoPromocao
     *        The idTipoPromocao to set.
     */
    public void setIdTipoPromocao(final Integer pIdTipoPromocao) {
        this.idTipoPromocao = pIdTipoPromocao;
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
        result = prime * result;
        if (this.idTipoPromocao != null) {
            result = prime * result + this.idTipoPromocao.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnTipoPromocaoBean) {
            final SnTipoPromocaoBean comp = (SnTipoPromocaoBean) key;
            test = this.getIdTipoPromocao().equals(comp.getIdTipoPromocao());
        }
        return test;
    }
}
