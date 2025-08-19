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

import br.com.netservicos.core.bean.so.SoTipoReservaPropBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela SN_TIPO_VENDA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_tipo_venda" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnTipoVendaBean extends DomainBean {

    private static final long serialVersionUID = -6607085027048588351L;

    private static final String PRIMARY_KEY = "idTipoVenda";

    private Integer idTipoVenda;
    private String descricao;
    private SoTipoReservaPropBean tipoReservaProp;
	private Long trpId;

    /**
     * Construtor Padrão.
     */
    public SnTipoVendaBean() {
        super(SnTipoVendaBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idTipoVenda.
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="id_tipo_venda" type = "int"
     */
    public Integer getIdTipoVenda() {
        return this.idTipoVenda;
    }
    
    /**
     * @return Returns the descricao.
     * @hibernate.property column="descricao" type = "string"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return Returns the tipoReservaProposta.
     * @hibernate.many-to-one column="trp_id" cascade="none" outer-join="true"
     *                        not-null="false" lazy="proxy"
     */
    public SoTipoReservaPropBean getTipoReservaProp() {
        return this.tipoReservaProp;
    }
    
    /**
	 * @param idTipoVenda the idTipoVenda to set
	 */
	public void setIdTipoVenda(Integer idTipoVenda) {
		this.idTipoVenda = idTipoVenda;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param tipoReservaProp the tipoReservaProp to set
	 */
	public void setTipoReservaProp(SoTipoReservaPropBean tipoReservaProp) {
		this.tipoReservaProp = tipoReservaProp;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idTipoVenda != null) {
            result = prime * result + this.idTipoVenda.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnTipoVendaBean) {
            final SnTipoVendaBean comp = (SnTipoVendaBean) key;
            test = this.getIdTipoVenda().equals(comp.getIdTipoVenda());
        }
        return test;
    }
}
