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
 * Classe Bean que representa a tabela SN_PRODUTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_produto" dynamic-insert = "true" dynamic-update = "true" lazy="true"
 * @hibernate.cache usage = "read-write"
 */
public class SnProdutoBean extends DomainBean {

    private static final long serialVersionUID = -4327891707241986373L;
    public static final String IS_PRODUTO_VIGENTE = "isProdutoVigente"; 
    public static final String ID_PRODUTO = "private Long idProduto;";
    public static final String PRIMARY_KEY = "idProduto";

    private Long idProduto;
    private String descricao;
    private Integer demonstracao;
    private String descricaoAbrev;
    private Integer recorrente;
    private Integer cobravel;
    private Integer prePago;
    private Integer internet;
    private Integer areaCodificada;
    private Integer produtoVirtua;
    private Integer produtoColetivo;
    private Integer maxUs;
    private Integer minUs;
    private Integer maxDs;
    private Integer minDs;
    private Integer ipFixo;
    private Integer qtdIpExtra;
    private Integer provedor;
    private Integer franquia;
    private Integer formaAquisicao;
    private String descricaoBoleto;
    private SnTipoProdutoBean tipoProduto;
    private SnCaracteristicaBean caracteristica;
    private SnTipoProdutoIvaBean tipoProdutoIva;

    /**
     * Construtor Padrão.
     */
    public SnProdutoBean() {
        super(SnProdutoBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idProduto.
     * @hibernate.id generator-class="assigned" unsaved-value = "null" column="ID_PRODUTO"
     */
    public Long getIdProduto() {
        return this.idProduto;
    }

    /**
     * @return Returns the areaCodificada.
     * @hibernate.property column="area_codificada"
     */
    public Integer getAreaCodificada() {
        return this.areaCodificada;
    }

    /**
     * @return Returns the cobravel.
     * @hibernate.property column="cobravel"
     */
    public Integer getCobravel() {
        return this.cobravel;
    }

    /**
     * @return Returns the demonstracao.
     * @hibernate.property column="demonstracao"
     */
    public Integer getDemonstracao() {
        return this.demonstracao;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.property column="descricao"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return Returns the descricaoAbrev.
     * @hibernate.property column="descricao_abrev"
     */
    public String getDescricaoAbrev() {
        return this.descricaoAbrev;
    }

    /**
     * @return Returns the formaAquisicao.
     * @hibernate.property column="forma_aquisicao"
     */

    public Integer getFormaAquisicao() {
        return this.formaAquisicao;
    }

    /**
     * @return Returns the franquia.
     * @hibernate.property column="franquia"
     */
    public Integer getFranquia() {
        return this.franquia;
    }

    /**
     * @return Returns the internet.
     * @hibernate.property column="internet"
     */
    public Integer getInternet() {
        return this.internet;
    }

    /**
     * @return Returns the maxDs.
     * @hibernate.property column="max_ds"
     */
    public Integer getMaxDs() {
        return this.maxDs;
    }

    /**
     * @return Returns the maxUs.
     * @hibernate.property column="max_us"
     */
    public Integer getMaxUs() {
        return this.maxUs;
    }

    /**
     * @return Returns the minDs.
     * @hibernate.property column="min_ds"
     */
    public Integer getMinDs() {
        return this.minDs;
    }

    /**
     * @return Returns the minUs.
     * @hibernate.property column="min_us"
     */
    public Integer getMinUs() {
        return this.minUs;
    }

    /**
     * @return Returns the prePago.
     * @hibernate.property column="pre_pago"
     */
    public Integer getPrePago() {
        return this.prePago;
    }

    /**
     * @return Returns the produtoColetivo.
     * @hibernate.property column="produto_coletivo"
     */
    public Integer getProdutoColetivo() {
        return this.produtoColetivo;
    }

    /**
     * @return Returns the produtoVirtua.
     * @hibernate.property column="produto_virtua"
     */
    public Integer getProdutoVirtua() {
        return this.produtoVirtua;
    }

    /**
     * @return Returns the provedor.
     * @hibernate.property column="provedor"
     */
    public Integer getProvedor() {
        return this.provedor;
    }

    /**
     * @return Returns the qtdIpExtra.
     * @hibernate.property column="qtd_ip_extra"
     */
    public Integer getQtdIpExtra() {
        return this.qtdIpExtra;
    }

    /**
     * @return Returns the recorrente.
     * @hibernate.property column="recorrente"
     */
    public Integer getRecorrente() {
        return this.recorrente;
    }
    
    /**
     * @return Returns the ipFixo
     * @hibernate.property column = "ip_fixo"
     */
    public Integer getIpFixo() {
        return this.ipFixo;
    }

    /**
     * @return Returns the descriçãoBoleto
     * @hibernate.property column = "descricao_boleto"
     */
    public String getDescricaoBoleto() {
        return this.descricaoBoleto;
    }
    
    /**
     * @return Returns the SnCaracteristicaBean.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnCaracteristicaBean"
     *                        column="id_caracteristica" cascade="none" not-null="false"
     */
    public SnCaracteristicaBean getCaracteristica() {
        return this.caracteristica;
    }

    /**
     * @return Returns the SnTipoProdutoBean.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnTipoProdutoBean"
     *                        column="id_tipo_produto"
     *                        cascade="none" not-null="false"
     */
    public SnTipoProdutoBean getTipoProduto() {
        return this.tipoProduto;
    }

    /**
     * @return Returns the SnTipoProdutoIvaBean.
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnTipoProdutoIvaBean"
     *                        column="id_tipo_produto_iva" cascade="none" not-null="false"
     */
    public SnTipoProdutoIvaBean getTipoProdutoIva() {
        return this.tipoProdutoIva;
    }
    
    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param demonstracao the demonstracao to set
     */
    public void setDemonstracao(Integer demonstracao) {
        this.demonstracao = demonstracao;
    }

    /**
     * @param descricaoAbrev the descricaoAbrev to set
     */
    public void setDescricaoAbrev(String descricaoAbrev) {
        this.descricaoAbrev = descricaoAbrev;
    }

    /**
     * @param recorrente the recorrente to set
     */
    public void setRecorrente(Integer recorrente) {
        this.recorrente = recorrente;
    }

    /**
     * @param cobravel the cobravel to set
     */
    public void setCobravel(Integer cobravel) {
        this.cobravel = cobravel;
    }

    /**
     * @param prePago the prePago to set
     */
    public void setPrePago(Integer prePago) {
        this.prePago = prePago;
    }

    /**
     * @param internet the internet to set
     */
    public void setInternet(Integer internet) {
        this.internet = internet;
    }

    /**
     * @param areaCodificada the areaCodificada to set
     */
    public void setAreaCodificada(Integer areaCodificada) {
        this.areaCodificada = areaCodificada;
    }

    /**
     * @param produtoVirtua the produtoVirtua to set
     */
    public void setProdutoVirtua(Integer produtoVirtua) {
        this.produtoVirtua = produtoVirtua;
    }

    /**
     * @param produtoColetivo the produtoColetivo to set
     */
    public void setProdutoColetivo(Integer produtoColetivo) {
        this.produtoColetivo = produtoColetivo;
    }

    /**
     * @param maxUs the maxUs to set
     */
    public void setMaxUs(Integer maxUs) {
        this.maxUs = maxUs;
    }

    /**
     * @param minUs the minUs to set
     */
    public void setMinUs(Integer minUs) {
        this.minUs = minUs;
    }

    /**
     * @param maxDs the maxDs to set
     */
    public void setMaxDs(Integer maxDs) {
        this.maxDs = maxDs;
    }

    /**
     * @param minDs the minDs to set
     */
    public void setMinDs(Integer minDs) {
        this.minDs = minDs;
    }

    /**
     * @param ipFixo the ipFixo to set
     */
    public void setIpFixo(Integer ipFixo) {
        this.ipFixo = ipFixo;
    }

    /**
     * @param qtdIpExtra the qtdIpExtra to set
     */
    public void setQtdIpExtra(Integer qtdIpExtra) {
        this.qtdIpExtra = qtdIpExtra;
    }

    /**
     * @param provedor the provedor to set
     */
    public void setProvedor(Integer provedor) {
        this.provedor = provedor;
    }

    /**
     * @param franquia the franquia to set
     */
    public void setFranquia(Integer franquia) {
        this.franquia = franquia;
    }

    /**
     * @param formaAquisicao the formaAquisicao to set
     */
    public void setFormaAquisicao(Integer formaAquisicao) {
        this.formaAquisicao = formaAquisicao;
    }

    /**
     * @param descricaoBoleto the descricaoBoleto to set
     */
    public void setDescricaoBoleto(String descricaoBoleto) {
        this.descricaoBoleto = descricaoBoleto;
    }

    /**
     * @param tipoProdutoIva the tipoProdutoIva to set
     */
    public void setTipoProdutoIva(SnTipoProdutoIvaBean tipoProdutoIva) {
        this.tipoProdutoIva = tipoProdutoIva;
    }

    /**
     * @param caracteristica the caracteristica to set
     */
    public void setCaracteristica(SnCaracteristicaBean caracteristica) {
        this.caracteristica = caracteristica;
    }

    /**
     * @param tipoProduto the tipoProduto to set
     */
    public void setTipoProduto(SnTipoProdutoBean tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idProduto != null) {
            result = prime * result + this.idProduto.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnProdutoBean) {
            final SnProdutoBean comp = (SnProdutoBean) key;
            test = this.getIdProduto().equals(comp.getIdProduto());
        }
        return test;
    }
}
