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
 * Classe Bean que representa a tabela SN_TIPO_PRODUTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_tipo_produto" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnTipoProdutoBean extends DomainBean {

    public static final long serialVersionUID = 5644965742L;

    public static final String PRIMARY_KEY = "idTipoProduto";

    private Integer idTipoProduto;
    private String descricao;
    private Integer agregado;
    private Integer distribuido;

    /**
     * Construtor padrão.
     */
    public SnTipoProdutoBean() {
        super(PRIMARY_KEY);
    }
    
    /**
     * @return Returns the idTipoProduto.
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="ID_TIPO_PRODUTO" type = "int"
     */
    public Integer getIdTipoProduto() {
        return this.idTipoProduto;
    }

    /**
     * @return Returns the agregado.
     * @hibernate.property column="agregado"
     */
    public Integer getAgregado() {
        return this.agregado;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.property column="descricao"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return Returns the distribuido.
     * @hibernate.property column="distribuido"
     */
    public Integer getDistribuido() {
        return this.distribuido;
    }

	/**
	 * @param idTipoProduto the idTipoProduto to set
	 */
	public void setIdTipoProduto(Integer idTipoProduto) {
		this.idTipoProduto = idTipoProduto;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param agregado the agregado to set
	 */
	public void setAgregado(Integer agregado) {
		this.agregado = agregado;
	}

	/**
	 * @param distribuido the distribuido to set
	 */
	public void setDistribuido(Integer distribuido) {
		this.distribuido = distribuido;
	}
    
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idTipoProduto != null) {
            result = prime * result + this.idTipoProduto.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnTipoProdutoBean) {
            final SnTipoProdutoBean comp = (SnTipoProdutoBean) key;
            test = this.getIdTipoProduto().equals(comp.getIdTipoProduto());
        }
        return test;
    }
}
