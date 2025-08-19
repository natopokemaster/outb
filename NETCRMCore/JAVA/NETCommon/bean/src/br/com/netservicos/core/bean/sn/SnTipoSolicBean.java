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
 * Classe Bean que representa a tabela SN_TIPO_SOLIC.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_tipo_solic" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnTipoSolicBean extends DomainBean {

    private static final long serialVersionUID = 3690475827028899378L;

    public static final String PRIMARY_KEY = "idTipoSolic";

    private Integer idTipoSolic;
    private String descricao;
    private Integer valido;
    private SnProdutoBean prodDe;
    private SnProdutoBean prodPara;
    private Integer flagPonto;
    private Integer flagSolicLote;
   

    /**
     * Construtor
     */
    public SnTipoSolicBean() {
        super(SnTipoSolicBean.PRIMARY_KEY);
    }

    public SnTipoSolicBean(Integer idTipoSolic) {
        this();
        this.idTipoSolic = idTipoSolic;
    }
    
    /**
     * @return Returns the idTipoSolic.
     * @hibernate.id generator-class="sequence" unsaved-value = "null"
     *               column="ID_TIPO_SOLIC" type = "int"
     * @hibernate.generator-param name="sequence" value="SSN_TD_ID_TIPO_SOLIC"
     */
    public Integer getIdTipoSolic() {
        return this.idTipoSolic;
    }

   

    /**
     * @return String
     * @hibernate.property column="descricao" type = "string"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return flagPonto O valor do atributo flagPonto
     * @hibernate.property column = "flag_ponto" length = "1"
     */
    public Integer getFlagPonto() {
        return this.flagPonto;
    }

    /**
     * @return flagSolicLote O valor do atributo flagSolicLote
     * @hibernate.property column = "flag_solic_lote" length = "1"
     */
    public Integer getFlagSolicLote() {
        return this.flagSolicLote;
    }

    /**
     * @return valido O valor do atributo valido.
     * @hibernate.property column = "valido" length = "1"
     */
    public Integer getValido() {
        return this.valido;
    }
    
    /**
     * @param idTipoSolic the idTipoSolic to set
     */
    public void setIdTipoSolic(Integer idTipoSolic) {
        this.idTipoSolic = idTipoSolic;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param valido the valido to set
     */
    public void setValido(Integer valido) {
        this.valido = valido;
    }

    /**
     * @param flagPonto the flagPonto to set
     */
    public void setFlagPonto(Integer flagPonto) {
        this.flagPonto = flagPonto;
    }
    
        /**
     * @return Returns the prodDe.
     *
     * @hibernate.many-to-one
     *      name="prodDe"
     *      class="br.com.netservicos.core.bean.sn.SnProdutoBean"
     *      column="id_prod_de"
     *      cascade="none"
     *      lazy="proxy"      
     */
    public SnProdutoBean getProdDe() {
        return prodDe;
    }

    /**
     * @param prodDe 
     *              The prodDe to set.
     */
    public void setProdDe(SnProdutoBean prodDe) {
        this.prodDe = prodDe;
    }
    
    /**
     * @param flagSolicLote the flagSolicLote to set
     */
    public void setFlagSolicLote(Integer flagSolicLote) {
        this.flagSolicLote = flagSolicLote;
    }

    /**
     * @param produtoPara the produtoPara to set
/**
     * @return Returns the prodPara.
     *
     * @hibernate.many-to-one
     *      name="prodPara"
     *      class="br.com.netservicos.core.bean.sn.SnProdutoBean"
     *      column="id_prod_para"
     *      cascade="none"
     *      lazy="proxy"      
     */
    public SnProdutoBean getProdPara() {
        return prodPara;
    }

    /**
     * @param prodPara 
     *              The prodPara to set.
     */
    public void setProdPara(SnProdutoBean prodPara) {
        this.prodPara = prodPara;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idTipoSolic != null) {
            result = prime * result + this.idTipoSolic.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnTipoSolicBean) {
            final SnTipoSolicBean comp = (SnTipoSolicBean) key;
            test = this.getIdTipoSolic().equals(comp.getIdTipoSolic());
        }
        return test;
    }
}