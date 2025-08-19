/*
 * Created on 15/08/2005
 *
 * Copyright © 2004 NET.
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

import br.com.netservicos.core.bean.sgs.SgsCidadeBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
* <P><B>
* Description :
* </B>
* <BR>
* 	Classe Bean que representa a tabela ged.logradouro.
* </P>
* <P>
* <B>
* Issues :
* </B>
* <PRE>    
* ==============================================================================
* Description                              Date        By
* ---------------------------------------- ----------- -------------------------
* 
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
* 15/08/2005 Juliano Tarini N/A      Entidades      Created.
* ==============================================================================
* </PRE>
*
* @hibernate.class table = "logradouro"
*                   dynamic-insert = "true"
*                   dynamic-update = "true"
* 
* @hibernate.cache
*       usage = "read-write"
*/
public class GedLogradouroBean extends DomainBean {
	
    private GedLogradouroKey composite;
    private SgsCidadeBean sgsCidade;
    private String codTipoLogr;
    private Long codOperadora;
    private String codTitulo;
    private Date dtAtualizacao;
    private Date dtTrocaNom;
    private String nomApelido;
    private Long numUltLote;
    private String codTituloAnt;
    private String codTipoLogrAnt;
    private String nomLogradouro;
    private String nomLogrAbrev;
    private String codFonetico;
    private String nomAnterior;
    private String indTipoInclusao;
    private String codUsuarioNom;
    private Date dtInclusaoLogr;
    private String codUsuarioInc;
    private String txtReferencia;
    private String codPreposicao;
    private String nomApelidoAnt;
    private String codPreposicaoAnt;
    private String nomLogrCompleto;
    private String indAbrangenciaLogr;
    private Date dtIncExportar;
    private Date dtAltExportar;
    private Date dtAltCepExportar;
    private String node;
    
    public static final String COMPOSITE_KEY = "composite";
    
    public GedLogradouroBean(){
        super(COMPOSITE_KEY);
    }
    
	/**
	 * @hibernate.id
	 * type = "composite"
	 */
    public GedLogradouroKey getComposite() {
		return composite;
	}

	public void setComposite(GedLogradouroKey composite) {
		this.composite = composite;
	}
	
	/** 
	 * @return SgsCidadeBean
	 * 
	 * @hibernate.many-to-one 
     * class="br.com.netservicos.core.bean.sgs.SgsCidadeBean"
	 * column="cod_cidade"
	 * insert="false"
	 * update="false"
	 * cascade="none"
	 * not-null="false"
	 */
    public SgsCidadeBean getSgsCidade() {
        return sgsCidade;
    }

    public void setSgsCidade(SgsCidadeBean sgsCidade) {
        this.sgsCidade = sgsCidade;
    }
    
    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_fonetico"
	 * type = "string"
	 */
    public String getCodFonetico() {
        return codFonetico;
    }

    public void setCodFonetico(String codFonetico) {
        this.codFonetico = codFonetico;
    }
    
    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_operadora"
	 * type = "long"
	 */
    public Long getCodOperadora() {
        return codOperadora;
    }

    public void setCodOperadora(Long codOperadora) {
        this.codOperadora = codOperadora;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_preposicao"
	 * type = "string"
	 */
    public String getCodPreposicao() {
        return codPreposicao;
    }

    public void setCodPreposicao(String codPreposicao) {
        this.codPreposicao = codPreposicao;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_preposicao_ant"
	 * type = "string"
	 */
    public String getCodPreposicaoAnt() {
        return codPreposicaoAnt;
    }

    public void setCodPreposicaoAnt(String codPreposicaoAnt) {
        this.codPreposicaoAnt = codPreposicaoAnt;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_tipo_logr"
	 * type = "string"
	 */
    public String getCodTipoLogr() {
        return codTipoLogr;
    }

    public void setCodTipoLogr(String codTipoLogr) {
        this.codTipoLogr = codTipoLogr;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_tipo_logr_ant"
	 * type = "string"
	 */
    public String getCodTipoLogrAnt() {
        return codTipoLogrAnt;
    }

    public void setCodTipoLogrAnt(String codTipoLogrAnt) {
        this.codTipoLogrAnt = codTipoLogrAnt;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * 		column="cod_titulo"
	 */
    public String getCodTitulo() {
        return codTitulo;
    }

    public void setCodTitulo(String codTitulo) {
        this.codTitulo = codTitulo;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_titulo_ant"
	 * type = "string"
	 */
    public String getCodTituloAnt() {
        return codTituloAnt;
    }

    public void setCodTituloAnt(String codTituloAnt) {
        this.codTituloAnt = codTituloAnt;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_usuario_inc"
	 * type = "string"
	 */
    public String getCodUsuarioInc() {
        return codUsuarioInc;
    }

    public void setCodUsuarioInc(String codUsuarioInc) {
        this.codUsuarioInc = codUsuarioInc;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_usuario_nom"
	 * type = "string"
	 */
    public String getCodUsuarioNom() {
        return codUsuarioNom;
    }

    public void setCodUsuarioNom(String codUsuarioNom) {
        this.codUsuarioNom = codUsuarioNom;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_alt_cep_exportar"
	 * type = "date"
	 */
    public Date getDtAltCepExportar() {
        return dtAltCepExportar;
    }

    public void setDtAltCepExportar(Date dtAltCepExportar) {
        this.dtAltCepExportar = dtAltCepExportar;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_alt_exportar"
	 * type = "date"
	 */
    public Date getDtAltExportar() {
        return dtAltExportar;
    }

    public void setDtAltExportar(Date dtAltExportar) {
        this.dtAltExportar = dtAltExportar;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_atualizacao"
	 * type = "date"
	 */
    public Date getDtAtualizacao() {
        return dtAtualizacao;
    }

    public void setDtAtualizacao(Date dtAtualizacao) {
        this.dtAtualizacao = dtAtualizacao;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_inc_exportar"
	 * type = "date"
	 */
    public Date getDtIncExportar() {
        return dtIncExportar;
    }

    public void setDtIncExportar(Date dtIncExportar) {
        this.dtIncExportar = dtIncExportar;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_inclusao_logr"
	 * type = "date"
	 */
    public Date getDtInclusaoLogr() {
        return dtInclusaoLogr;
    }

    public void setDtInclusaoLogr(Date dtInclusaoLogr) {
        this.dtInclusaoLogr = dtInclusaoLogr;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_troca_nom"
	 * type = "date"
	 */
    public Date getDtTrocaNom() {
        return dtTrocaNom;
    }

    public void setDtTrocaNom(Date dtTrocaNom) {
        this.dtTrocaNom = dtTrocaNom;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_abrangencia_logr"
	 * type = "string"
	 */
    public String getIndAbrangenciaLogr() {
        return indAbrangenciaLogr;
    }

    public void setIndAbrangenciaLogr(String indAbrangenciaLogr) {
        this.indAbrangenciaLogr = indAbrangenciaLogr;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_tipo_inclusao"
	 * type = "string"
	 */
    public String getIndTipoInclusao() {
        return indTipoInclusao;
    }

    public void setIndTipoInclusao(String indTipoInclusao) {
        this.indTipoInclusao = indTipoInclusao;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_anterior"
	 * type = "string"
	 */
    public String getNomAnterior() {
        return nomAnterior;
    }

    public void setNomAnterior(String nomAnterior) {
        this.nomAnterior = nomAnterior;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_apelido"
	 * type = "string"
	 */
    public String getNomApelido() {
        return nomApelido;
    }

    public void setNomApelido(String nomApelido) {
        this.nomApelido = nomApelido;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_apelido_ant"
	 * type = "string"
	 */
    public String getNomApelidoAnt() {
        return nomApelidoAnt;
    }

    public void setNomApelidoAnt(String nomApelidoAnt) {
        this.nomApelidoAnt = nomApelidoAnt;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_logr_abrev"
	 * type = "string"
	 */
    public String getNomLogrAbrev() {
        return nomLogrAbrev;
    }

    public void setNomLogrAbrev(String nomLogrAbrev) {
        this.nomLogrAbrev = nomLogrAbrev;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_logradouro"
	 * type = "string"
	 */
    public String getNomLogradouro() {
        return nomLogradouro;
    }

    public void setNomLogradouro(String nomLogradouro) {
        this.nomLogradouro = nomLogradouro;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_logr_completo"
	 * type = "string"
	 */
    public String getNomLogrCompleto() {
        return nomLogrCompleto;
    }

    public void setNomLogrCompleto(String nomLogrCompleto) {
        this.nomLogrCompleto = nomLogrCompleto;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="num_ult_lote"
	 * type = "long"
	 */
    public Long getNumUltLote() {
        return numUltLote;
    }

    public void setNumUltLote(Long numUltLote) {
        this.numUltLote = numUltLote;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="txt_referencia"
	 * type = "string"
	 */
    public String getTxtReferencia() {
        return txtReferencia;
    }

    public void setTxtReferencia(String txtReferencia) {
        this.txtReferencia = txtReferencia;
    }

    
    /**
     * @hibernate.property
     * 	formula="(SELECT distinct nd.COD_NODE
     *        	FROM GED.ABRANGENCIA_NODE nd,
     *        		 prod_jd.SN_CIDADE_OPERADORA co
     *          WHERE 
     *          	nd.cod_operadora  = co.cod_operadora
     *          	and  co.cid_contrato   = COD_CIDADE
     *          	and  nd.cod_logradouro = COD_LOGRADOURO
     *          	and  nd.COD_NODE = (select min(n.COD_NODE) from GED.ABRANGENCIA_NODE n
     *          						where n.cod_operadora  = nd.cod_operadora and 
     *          						n.cod_logradouro = nd.cod_logradouro))"
     * @return String
     */
    public String getNode(){
    	return this.node;
    }
    public void setNode(String node){
    	this.node = node;
    }
}
