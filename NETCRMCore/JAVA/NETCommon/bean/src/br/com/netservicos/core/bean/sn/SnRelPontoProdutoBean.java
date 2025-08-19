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

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Bean que representa a tabela SN_REL_PONTO_PRODUTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/10/2010
 * @version 1.0
 * @hibernate.class table = "sn_rel_ponto_produto" dynamic-insert = "true" dynamic-update = "true"
 */
public class SnRelPontoProdutoBean extends DomainBean {

    private static final long serialVersionUID = -3316398885470753404L;
    
    private SnRelPontoProdutoKey compositeKey;
    private Date dtIni;
    private Date dtFim;
    private Integer instalado;
    private Date dtAlterado;
    private Integer consolCbr;
    private Integer consolVendas;
    private Integer codOc;
    private String codOs;
    private Date dtFimDemo;
    private Long idDemonstracao;
    private Long idtipoContratacao;
    private Integer explicito;
    private SnTipoPontoBean idTipoPonto;

    /**
     * Construtor Padrão.
     */
    public SnRelPontoProdutoBean() {
        super("compositeKey");
    }

    /**
     * @hibernate.id type = "composite"
     * @return Returns the composite.
     */
    public SnRelPontoProdutoKey getCompositeKey() {
        return this.compositeKey;
    }

    /**
     * @hibernate.property column="COD_OC"
     * @return Returns the codOc.
     */
    public Integer getCodOc() {
        return this.codOc;
    }

    /**
     * @hibernate.property column="COD_OS"
     * @return Returns the codOs.
     */
    public String getCodOs() {
        return this.codOs;
    }

    /**
     * @hibernate.property column="CONSOL_CBR"
     * @return Returns the consolCbr.
     */
    public Integer getConsolCbr() {
        return this.consolCbr;
    }

    /**
     * @hibernate.property column="CONSOL_VENDAS"
     * @return Returns the consolVendas.
     */
    public Integer getConsolVendas() {
        return this.consolVendas;
    }

    /**
     * @hibernate.property column="DT_ALTERADO"
     * @return Returns the dtAlterado.
     */
    public Date getDtAlterado() {
        return this.dtAlterado;
    }

    /**
     * @hibernate.property column="DT_FIM"
     * @return Returns the dtFim.
     */
    public Date getDtFim() {
        return this.dtFim;
    }

    /**
     * @hibernate.property column="DT_FIM_DEMO"
     * @return Returns the dtFimDemo.
     */
    public Date getDtFimDemo() {
        return this.dtFimDemo;
    }

    /**
     * @hibernate.property column="DT_INI"
     * @return Returns the dtIni.
     */
    public Date getDtIni() {
        return this.dtIni;
    }

    /**
     * @hibernate.property column="EXPLICITO"
     * @return Returns the explicito.
     */
    public Integer getExplicito() {
        return this.explicito;
    }

    /**
     * @hibernate.property column="ID_DEMONSTRACAO"
     * @return Returns the idDemonstracao.
     */
    public Long getIdDemonstracao() {
        return this.idDemonstracao;
    }

    /**
     * @hibernate.property column="ID_TIPO_CONTRATACAO"
     * @return Returns the idtipoContratacao.
     */
    public Long getIdtipoContratacao() {
        return this.idtipoContratacao;
    }

    /**
     * @hibernate.property column="INSTALADO"
     * @return Returns the instalado.
     */
    public Integer getInstalado() {
        return this.instalado;
    }

    /**
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnTipoPontoBean" cascade="none"
     *                        column="ID_TIPO_PONTO"
     * @return Returns the tipoPonto.
     */
    public SnTipoPontoBean getIdTipoPonto() {
        return this.idTipoPonto;
    }

    /**
     * @param composite
     *        The composite to set.
     */
    public void setCompositeKey(final SnRelPontoProdutoKey composite) {
        this.compositeKey = composite;
    }

    /**
     * @param pCodOc
     *        The codOc to set.
     */
    public void setCodOc(final Integer pCodOc) {
        this.codOc = pCodOc;
    }

    /**
     * @param pCodOs
     *        The codOs to set.
     */
    public void setCodOs(final String pCodOs) {
        this.codOs = pCodOs;
    }

    /**
     * @param pConsolCbr
     *        The consolCbr to set.
     */
    public void setConsolCbr(final Integer pConsolCbr) {
        this.consolCbr = pConsolCbr;
    }

    /**
     * @param pConsolVendas
     *        The consolVendas to set.
     */
    public void setConsolVendas(final Integer pConsolVendas) {
        this.consolVendas = pConsolVendas;
    }

    /**
     * @param pDtAlterado
     *        The dtAlterado to set.
     */
    public void setDtAlterado(final Date pDtAlterado) {
        this.dtAlterado = pDtAlterado;
    }

    /**
     * @param pDtFim
     *        The dtFim to set.
     */
    public void setDtFim(final Date pDtFim) {
        this.dtFim = pDtFim;
    }

    /**
     * @param pDtFimDemo
     *        The dtFimDemo to set.
     */
    public void setDtFimDemo(final Date pDtFimDemo) {
        this.dtFimDemo = pDtFimDemo;
    }

    /**
     * @param pDtIni
     *        The dtIni to set.
     */
    public void setDtIni(final Date pDtIni) {
        this.dtIni = pDtIni;
    }

    /**
     * @param pExplicito
     *        The explicito to set.
     */
    public void setExplicito(final Integer pExplicito) {
        this.explicito = pExplicito;
    }

    /**
     * @param pIdDemonstracao
     *        The idDemonstracao to set.
     */
    public void setIdDemonstracao(final Long pIdDemonstracao) {
        this.idDemonstracao = pIdDemonstracao;
    }

    /**
     * @param pIdtipoContratacao
     *        The idtipoContratacao to set.
     */
    public void setIdtipoContratacao(final Long pIdtipoContratacao) {
        this.idtipoContratacao = pIdtipoContratacao;
    }

    /**
     * @param pInstalado
     *        The instalado to set.
     */
    public void setInstalado(final Integer pInstalado) {
        this.instalado = pInstalado;
    }

    /**
     * @param pIdTipoPonto
     *        The idTipoPonto to set.
     */
    public void setIdTipoPonto(final SnTipoPontoBean pIdTipoPonto) {
        this.idTipoPonto = pIdTipoPonto;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.compositeKey == null) ? 0 : this.compositeKey.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object key) {
        boolean test = false;
        if (key instanceof SnRelPontoProdutoBean) {
            final SnRelPontoProdutoBean comp = (SnRelPontoProdutoBean) key;
            test = this.getCompositeKey().equals(comp.getCompositeKey());
        } else {
            test = super.equals(key);
        }
        return test;
    }
}
