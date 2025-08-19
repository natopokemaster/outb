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
 * Classe Bean que representa a tabela SN_TIPO_PRODUTO_IVA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_tipo_produto_iva" dynamic-insert = "true" dynamic-update = "true" lazy="true"
 * @hibernate.cache usage = "read-write"
 */
public class SnTipoProdutoIvaBean extends DomainBean {

    private static final long serialVersionUID = -4981034498739662001L;

    public static final String PRIMARY_KEY = "idTipoProdutoIva";

    private Integer idTipoProdutoIva;
    private String descricao;

    /**
	 *  Construtor Padrão.
	 */
    public SnTipoProdutoIvaBean() {
        super(PRIMARY_KEY);
    }

    /**
     * @return Returns the idProduto.
     * @hibernate.id generator-class="assigned" unsaved-value = "null" column="id_tipo_produto_iva"
     */
    public Integer getIdTipoProdutoIva() {
        return this.idTipoProdutoIva;
    }

    /**
     * @return Returns the idProduto.
     * @hibernate.id generator-class="assigned" unsaved-value = "null" column="descricao"
     */
    public String getDescricao() {
        return this.descricao;
    }

	/**
	 * @param idTipoProdutoIva the idTipoProdutoIva to set
	 */
	public void setIdTipoProdutoIva(Integer idTipoProdutoIva) {
		this.idTipoProdutoIva = idTipoProdutoIva;
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
        if (this.idTipoProdutoIva != null) {
            result = prime * result + this.idTipoProdutoIva.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnTipoProdutoIvaBean) {
            final SnTipoProdutoIvaBean comp = (SnTipoProdutoIvaBean) key;
            test = this.getIdTipoProdutoIva().equals(comp.getIdTipoProdutoIva());
        }
        return test;
    }
}
