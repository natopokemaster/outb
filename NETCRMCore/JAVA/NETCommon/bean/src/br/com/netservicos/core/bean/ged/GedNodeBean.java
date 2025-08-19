/*
 * Created on 26/08/2005
 *
 * Copyright © 2005 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.ged;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela node.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Criação da Classe						26/08/2005  Giovanni F.
 * Adição do HQL lstGedNodeByIdCodOperadora 19/03/2007	Rafael Mauricio Nami
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 26/08/2005 Giovanni F.    N/A      Entidades      Created.
 * 19/03/2007 Rafael Nami	 1.1	  Entidades		 Updated.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table="node"
 *                  dynamic-insert="true"
 *                  dynamic-update="true"
 *                  lazy="true"
 *                  
 * @hibernate.cache
 *       usage = "read-write"
 *
 *
 */
public class GedNodeBean extends DomainBean {

    private static final String COMPOSITE_KEY = "compositeKey";

    private static final long serialVersionUID = -9184990091052690776L;

    private Integer codBolsao;
    private Integer codDistrito;
    private String codHeadend;
    private Integer codTipoCabeamento;
    private GedNodeKey compositeKey;
    private Date dtAtivacao;
    private Date dtAtivacaoCom;
    private Date dtAtivacaoRetorno;
    private Date dtAtualizacao;
    private Date dtCodificacaoNode;
    private Date dtPrevAtivacao;
    private Date dtPrevAtivacaoCom;
    private Date dtPrevAtivacaoRetorno;
    private String indOrigem;
    private String indReconstrucao;
    private String indRetorno;
    private Integer qtdHpInstal;
    private Integer qtdHpPrev;
    private Integer qtdKm;

    public GedNodeBean() {
        super(COMPOSITE_KEY);
    }

    /**
     * @return Returns the codBolsao.
     * @hibernate.property
     *      column="cod_bolsao"
     */
    public Integer getCodBolsao() {
        return codBolsao;
    }

    /**
     * @return Returns the codDistrito.
     * @hibernate.property
     *      column="cod_distrito"
     */
    public Integer getCodDistrito() {
        return codDistrito;
    }

    /**
     * @return Returns the codHeadend.
     * @hibernate.property
     *      column="cod_headend"
     */
    public String getCodHeadend() {
        return codHeadend;
    }

    /**
     * @return Returns the codTipoCabeamento.
     * @hibernate.property
     *      column="cod_tipo_cabeamento"
     */
    public Integer getCodTipoCabeamento() {
        return codTipoCabeamento;
    }

    /**
     * @return Returns the compositeKey.
     * @hibernate.id
     */
    public GedNodeKey getCompositeKey() {
        return compositeKey;
    }

    /**
     * @return Returns the dtAtivacao.
     * @hibernate.property
     *      column="dt_ativacao"
     */
    public Date getDtAtivacao() {
        return dtAtivacao;
    }

    /**
     * @return Returns the dtAtivacaoCom.
     * @hibernate.property
     *      column="dt_ativacao_com"
     */
    public Date getDtAtivacaoCom() {
        return dtAtivacaoCom;
    }

    /**
     * @return Returns the dtAtivacaoRetorno.
     * @hibernate.property
     *      column="dt_ativacao_retorno"
     */
    public Date getDtAtivacaoRetorno() {
        return dtAtivacaoRetorno;
    }

    /**
     * @return Returns the dtAtualizacao.
     * @hibernate.property
     *      column="dt_atualizacao"
     */
    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    /**
     * @return Returns the dtCodificacaoNode.
     * @hibernate.property
     *      column="dt_codificacao_node"
     */
    public Date getDtCodificacaoNode() {
        return dtCodificacaoNode;
    }

    /**
     * @return Returns the dtPrevAtivacao.
     * @hibernate.property
     *      column="dt_prev_ativacao"
     */
    public Date getDtPrevAtivacao() {
        return dtPrevAtivacao;
    }

    /**
     * @return Returns the dtPrevAtivacaoCom.
     * @hibernate.property
     *      column="dt_prev_ativacao_com"
     */
    public Date getDtPrevAtivacaoCom() {
        return dtPrevAtivacaoCom;
    }

    /**
     * @return Returns the dtPrevAtivacaoRetorno.
     * @hibernate.property
     *      column="dt_prev_ativacao_retorno"
     */
    public Date getDtPrevAtivacaoRetorno() {
        return dtPrevAtivacaoRetorno;
    }

    /**
     * @return Returns the indOrigem.
     * @hibernate.property
     *      column="ind_origem"
     */
    public String getIndOrigem() {
        return indOrigem;
    }

    /**
     * @return Returns the indReconstrucao.
     * @hibernate.property
     *      column="ind_reconstrucao"
     */
    public String getIndReconstrucao() {
        return indReconstrucao;
    }

    /**
     * @return Returns the indRetorno.
     * @hibernate.property
     *      column="ind_retorno"
     */
    public String getIndRetorno() {
        return indRetorno;
    }

    /**
     * @return Returns the qtdHpInstal.
     * @hibernate.property
     *      column="qtd_hp_instal"
     */
    public Integer getQtdHpInstal() {
        return qtdHpInstal;
    }

    /**
     * @return Returns the qtdHpPrev.
     * @hibernate.property
     *      column="qtd_hp_prev"
     */
    public Integer getQtdHpPrev() {
        return qtdHpPrev;
    }

    /**
     * @return Returns the qtdKm.
     * @hibernate.property
     *      column="qtd_km"
     */
    public Integer getQtdKm() {
        return qtdKm;
    }

    /**
     * @param codBolsao The codBolsao to set.
     */
    public void setCodBolsao(Integer codBolsao) {
        this.codBolsao = codBolsao;
    }

    /**
     * @param codDistrito The codDistrito to set.
     */
    public void setCodDistrito(Integer codDistrito) {
        this.codDistrito = codDistrito;
    }

    /**
     * @param codHeadend The codHeadend to set.
     */
    public void setCodHeadend(String codHeadend) {
        this.codHeadend = codHeadend;
    }

    /**
     * @param codTipoCabeamento The codTipoCabeamento to set.
     */
    public void setCodTipoCabeamento(Integer codTipoCabeamento) {
        this.codTipoCabeamento = codTipoCabeamento;
    }

    /**
     * @param compositeKey The compositeKey to set.
     */
    public void setCompositeKey(GedNodeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    /**
     * @param dtAtivacao The dtAtivacao to set.
     */
    public void setDtAtivacao(Date dtAtivacao) {
        this.dtAtivacao = dtAtivacao;
    }

    /**
     * @param dtAtivacaoCom The dtAtivacaoCom to set.
     */
    public void setDtAtivacaoCom(Date dtAtivacaoCom) {
        this.dtAtivacaoCom = dtAtivacaoCom;
    }

    /**
     * @param dtAtivacaoRetorno The dtAtivacaoRetorno to set.
     */
    public void setDtAtivacaoRetorno(Date dtAtivacaoRetorno) {
        this.dtAtivacaoRetorno = dtAtivacaoRetorno;
    }

    /**
     * @param dtAtualizacao The dtAtualizacao to set.
     */
    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    /**
     * @param dtCodificacaoNode The dtCodificacaoNode to set.
     */
    public void setDtCodificacaoNode(Date dtCodificacaoNode) {
        this.dtCodificacaoNode = dtCodificacaoNode;
    }

    /**
     * @param dtPrevAtivacao The dtPrevAtivacao to set.
     */
    public void setDtPrevAtivacao(Date dtPrevAtivacao) {
        this.dtPrevAtivacao = dtPrevAtivacao;
    }

    /**
     * @param dtPrevAtivacaoCom The dtPrevAtivacaoCom to set.
     */
    public void setDtPrevAtivacaoCom(Date dtPrevAtivacaoCom) {
        this.dtPrevAtivacaoCom = dtPrevAtivacaoCom;
    }

    /**
     * @param dtPrevAtivacaoRetorno The dtPrevAtivacaoRetorno to set.
     */
    public void setDtPrevAtivacaoRetorno(Date dtPrevAtivacaoRetorno) {
        this.dtPrevAtivacaoRetorno = dtPrevAtivacaoRetorno;
    }

    /**
     * @param indOrigem The indOrigem to set.
     */
    public void setIndOrigem(String indOrigem) {
        this.indOrigem = indOrigem;
    }

    /**
     * @param indReconstrucao The indReconstrucao to set.
     */
    public void setIndReconstrucao(String indReconstrucao) {
        this.indReconstrucao = indReconstrucao;
    }

    /**
     * @param indRetorno The indRetorno to set.
     */
    public void setIndRetorno(String indRetorno) {
        this.indRetorno = indRetorno;
    }

    /**
     * @param qtdHpInstal The qtdHpInstal to set.
     */
    public void setQtdHpInstal(Integer qtdHpInstal) {
        this.qtdHpInstal = qtdHpInstal;
    }

    /**
     * @param qtdHpPrev The qtdHpPrev to set.
     */
    public void setQtdHpPrev(Integer qtdHpPrev) {
        this.qtdHpPrev = qtdHpPrev;
    }

    /**
     * @param qtdKm The qtdKm to set.
     */
    public void setQtdKm(Integer qtdKm) {
        this.qtdKm = qtdKm;
    }

}
