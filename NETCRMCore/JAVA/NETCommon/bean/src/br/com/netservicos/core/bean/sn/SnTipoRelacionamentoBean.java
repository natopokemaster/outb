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
 * Classe Bean que representa a tabela SN_TIPO_RELACIONAMENTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_tipo_relacionamento" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnTipoRelacionamentoBean extends DomainBean {

    private static final long serialVersionUID = 9080987115821390430L;

    public static final String PRIMARY_KEY = "idTipoRelacionamento";
 
    private Integer idTipoRelacionamento;
    private String descricao;

    /**
     * Constructor Padrão.
     */
    public SnTipoRelacionamentoBean() {
        super(SnTipoRelacionamentoBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idTipoRelacionamento
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="ID_TIPO_RELACIONAMENTO" type = "int"
     */
    public Integer getIdTipoRelacionamento() {
        return this.idTipoRelacionamento;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.property column="DESCRICAO" type = "string"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
	 * @param idTipoRelacionamento the idTipoRelacionamento to set
	 */
	public void setIdTipoRelacionamento(Integer idTipoRelacionamento) {
		this.idTipoRelacionamento = idTipoRelacionamento;
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
        if (this.idTipoRelacionamento != null) {
            result = prime * result + this.idTipoRelacionamento.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnTipoRelacionamentoBean) {
            final SnTipoRelacionamentoBean comp = (SnTipoRelacionamentoBean) key;
            test = this.getIdTipoRelacionamento().equals(comp.getIdTipoRelacionamento());
        }
        return test;
    }
}
