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
 * Classe Bean que representa a tabela SN_TIPO_SOLIC_PROD.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_tipo_solic_prod" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 * 
 * 
 * 
 * @hibernate.query 
 * 		name = "getIdTipoSolicProdByTipoSolic"
 * 		query = "SELECT solic.idTipoSolicProd
 * 				FROM
 * 					br.com.netservicos.core.bean.sn.SnTipoSolicProdBean solic
 * 				WHERE 
 * 				    solic.tipoSolic.idTipoSolic = :idTipoSolic"
 *  
 * @hibernate.query name = "lstTipoSolicProdExtensaoVOIP"
 *                  query = "SELECT bean.idTipoSolicProd
 *                             FROM br.com.netservicos.core.bean.sn.SnTipoSolicProdBean bean
 * 						      WHERE bean.tipoSolic = 236"
 * 
 * 
 */
public class SnTipoSolicProdBean extends DomainBean {

    private static final long serialVersionUID = 3257004354354492977L;

    public static final String PRIMARY_KEY = "idTipoSolicProd";
	public static final String GET_ID_TIPO_SOLIC_PROD_BY_TIPO_SOLIC = "getIdTipoSolicProdByTipoSolic";
    private Long idTipoSolicProd;
    private SnTipoSolicBean tipoSolic;
    private SnProdutoBean produtoDe;
    private SnProdutoBean produtoPara;
    private SnTipoRelacionamentoBean tipoRelacionamento;

    /**
     * Construtor Padrão.
     */
    public SnTipoSolicProdBean() {
        super(SnTipoSolicProdBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idTipoSolicProd.
     * @hibernate.id generator-class="sequence" unsaved-value = "null"
     *               column="ID_TIPO_SOLIC_PROD" type = "long"
     * @hibernate.generator-param name = "sequence" value =
     *                            "ssn_id_tipo_solic_prod"
     */
    public Long getIdTipoSolicProd() {
        return this.idTipoSolicProd;
    }

    /**
     * @return Returns the tipoSolic.
     * @hibernate.many-to-one name="tipoSolic"
     *                        column="ID_TIPO_SOLIC" cascade="none"
     *                        not-null="false"
     */
    public SnTipoSolicBean getTipoSolic() {
        return this.tipoSolic;
    }

    /**
     * @return Returns the tipoRelacionamento.
     * @hibernate.many-to-one
     *                        column="ID_TIPO_RELACIONAMENTO" cascade="none"
     *                        not-null="false"
     */
    public SnTipoRelacionamentoBean getTipoRelacionamento() {
        return this.tipoRelacionamento;
    }

    /**
     * @return Returns the produto.
     * @hibernate.many-to-one
     *                        column="id_prod_de" cascade="none"
     *                        not-null="false"
     */
    public SnProdutoBean getProdutoDe() {
        return this.produtoDe;
    }

     /**
     * @return Returns the produto.
     * @hibernate.many-to-one
     *                        column="id_prod_para" cascade="none"
     *                        not-null="false"
     */
    public SnProdutoBean getProdutoPara() {
        return this.produtoPara;
    }

	/**
	 * @param idTipoSolicProd the idTipoSolicProd to set
	 */
	public void setIdTipoSolicProd(Long idTipoSolicProd) {
		this.idTipoSolicProd = idTipoSolicProd;
	}

	/**
	 * @param tipoSolic the tipoSolic to set
	 */
	public void setTipoSolic(SnTipoSolicBean tipoSolic) {
		this.tipoSolic = tipoSolic;
	}

	/**
	 * @param produtoDe the produtoDe to set
	 */
	public void setProdutoDe(SnProdutoBean produtoDe) {
		this.produtoDe = produtoDe;
	}

	/**
	 * @param produtoPara the produtoPara to set
	 */
	public void setProdutoPara(SnProdutoBean produtoPara) {
		this.produtoPara = produtoPara;
	}

	/**
	 * @param tipoRelacionamento the tipoRelacionamento to set
	 */
	public void setTipoRelacionamento(SnTipoRelacionamentoBean tipoRelacionamento) {
		this.tipoRelacionamento = tipoRelacionamento;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idTipoSolicProd != null) {
            result = prime * result + this.idTipoSolicProd.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnTipoSolicProdBean) {
            final SnTipoSolicProdBean comp = (SnTipoSolicProdBean) key;
            test = this.getIdTipoSolicProd().equals(comp.getIdTipoSolicProd());
        }
        return test;
    }
}
