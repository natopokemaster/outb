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

import java.io.Serializable;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela SN_REL_TIPO_CARAC_PRODUTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 05/10/2010
 * @version 1.0
 */
public class SnRelTipoCaracProdutoKey implements Serializable {
	
	private static final long serialVersionUID = 4531146588751008527L;
	
	private Long idTipoCaracteristica;
	private Long idProduto;
	
	/**
	 * Construtor Padrão.
	 */
	public SnRelTipoCaracProdutoKey() {
	}

	public SnRelTipoCaracProdutoKey(Long idTipoCaracteristica, Long idProduto) {
		this.idTipoCaracteristica = idTipoCaracteristica;
		this.idProduto = idProduto;
	}

	/**
	 * @return Returns the idTipoCaracteristica.
	 * @hibernate.property column="id_tipo_caracteristica" 
	 */
	public Long getIdTipoCaracteristica() {
		return idTipoCaracteristica;
	}

	/**
     * @return Returns the idProduto.
     * @hibernate.property column="id_produto"
     */
	public Long getIdProduto() {
		return idProduto;
	}
	
	/**
	 * @param idTipoCaracteristica the idTipoCaracteristica to set
	 */
	public void setIdTipoCaracteristica(Long idTipoCaracteristica) {
		this.idTipoCaracteristica = idTipoCaracteristica;
	}

	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idProduto != null) {
            result = prime * result + this.idProduto.hashCode();
        }
        if (this.idTipoCaracteristica != null) {
            result = prime * result + this.idTipoCaracteristica.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnRelTipoCaracProdutoKey) {
            final SnRelTipoCaracProdutoKey comp = (SnRelTipoCaracProdutoKey) key;
            test = this.getIdProduto().equals(comp.getIdProduto());
            test = this.getIdTipoCaracteristica().equals(comp.getIdTipoCaracteristica());
        }
        return test;
    }
}
