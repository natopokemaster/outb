/*
 * Created on 18/08/2005
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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
* <P><B>
* Description :
* </B>
* <BR>
* 	Classe Bean que representa a tabela ged.hp_imovel.
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
* 18/08/2005 Juliano Tarini N/A      Entidades      Created.
* ==============================================================================
* </PRE>
*
* @hibernate.class table = "hp_imovel"
*                  dynamic-insert = "true"
*                  dynamic-update = "true"
*                  lazy="false"
* 
* @hibernate.cache
*       usage = "read-write"
* 
* @hibernate.query name  = "verificaCodHP"
*                  query = "FROM br.com.netservicos.core.bean.ged.GedHpImovelBean hp 
*                  WHERE hp.composite.codHP = :codHP"
*                  
* @hibernate.query name  = "verificaCodHP2"                  
*                  query = "FROM br.com.netservicos.core.bean.ged.GedHpImovelBean hp 
*                           inner join hp.gedImovel imovel
*                  WHERE hp.composite.codHP = :codHP and
*                        imovel.codCidade = :gedEndereco.composite.codCidade"
* 
* @hibernate.query name  = "buscaGedHpImovelByCodHP"
*                  query = "FROM br.com.netservicos.core.bean.ged.GedHpImovelBean hp 
*                  WHERE hp.composite.codHP = :codHPDbm"
*/
public class GedHpImovelBean extends DomainBean {
	
	private static final long serialVersionUID = -6184406976289844597L;
	
	private GedHpImovelKey composite;
    private GedImovelBean gedImovel;
    private Long codTipoImovel;
    private Long codSitSolicitacao;
    private String indSituacao;
    private Date dtSitSolicitacao;
    private Long codArea;
    private Long codMotivoSituacao;
    private String codCategoriaSe;
    private Long codImovel;
    private String codTipoCompl1;
    private String txtCompl1;
    private String codTipoCompl2;
    private String txtCompl2;
    private Long qtdPontosTv;
    private Long qtdComodos;
    private Long numTelHP;
    private String codHPSms;
    private Long numDddHP;
    private Long codHPDbm;
    private Date dtAtualizacao;
    private String codUsuario;
    private String codSitSms;
    private Date dtSitSms;
    private String indCondicao;
    private String indClandestino;
    private Date dtParaExportar;
    private Date dtParaExportarInfo;
    private Date dtParaExportarNode;
    private String indOrigem;
    private String codPreContrato;
    private Date dtRegistroSolicitacao;
    private Date dtNaoExportar;
    private Long idLm;
    private Long idSar;
    private String txtObsBloqueio;
    private Date dtParaExportarSiebel;
    private Date dtInclusaoExportar;
        
    public static final String COMPOSITE_KEY = "composite";
    public static final String BUSCA_GED_HP_IMOVEL_BY_COD_HP = "buscaGedHpImovelByCodHP";
    public static final String BUSCA_HP_DIRETO = "verificaCodHP2";
    
    public GedHpImovelBean(){
        super(COMPOSITE_KEY);
    }
    
	/**
	 * @hibernate.id
	 * type = "composite"
	 */
    public GedHpImovelKey getComposite() {
		return composite;
	}

	public void setComposite(GedHpImovelKey composite) {
		this.composite = composite;
	}
	
    /** 
     * @return GedImovelBean
     * 
     * @hibernate.many-to-one class = "br.com.netservicos.core.bean.ged.GedImovelBean"
     * insert="false"
     * update="false"
     * cascade="none"
     * not-null="false"
     * @hibernate.column name="cod_imovel"
     * @hibernate.column name="cod_operadora"
     */
    public GedImovelBean getGedImovel() {
        return gedImovel;
    }

    public void setGedImovel(GedImovelBean gedImovel) {
        this.gedImovel = gedImovel;
    }
    
	/** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_area"
	 * type = "long"
	 */
    public Long getCodArea() {
        return codArea;
    }
    
    public void setCodArea(Long codArea) {
        this.codArea = codArea;
    }
    
    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_categoria_se"
	 * type = "string"
	 */
    public String getCodCategoriaSe() {
        return codCategoriaSe;
    }

    public void setCodCategoriaSe(String codCategoriaSe) {
        this.codCategoriaSe = codCategoriaSe;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_hp_dbm"
	 * type = "long"
	 */
    public Long getCodHPDbm() {
        return codHPDbm;
    }

    public void setCodHPDbm(Long codHPDbm) {
        this.codHPDbm = codHPDbm;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_hp_sms"
	 * type = "string"
	 */
    public String getCodHPSms() {
        return codHPSms;
    }

    public void setCodHPSms(String codHPSms) {
        this.codHPSms = codHPSms;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_imovel"
	 * type = "long"
	 */
    public Long getCodImovel() {
        return codImovel;
    }

    public void setCodImovel(Long codImovel) {
        this.codImovel = codImovel;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_motivo_situacao"
	 * type = "long"
	 */
    public Long getCodMotivoSituacao() {
        return codMotivoSituacao;
    }

    public void setCodMotivoSituacao(Long codMotivoSituacao) {
        this.codMotivoSituacao = codMotivoSituacao;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_pre_contrato"
	 * type = "string"
	 */
    public String getCodPreContrato() {
        return codPreContrato;
    }

    public void setCodPreContrato(String codPreContrato) {
        this.codPreContrato = codPreContrato;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_sit_sms"
	 * type = "string"
	 */
    public String getCodSitSms() {
        return codSitSms;
    }

    public void setCodSitSms(String codSitSms) {
        this.codSitSms = codSitSms;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_sit_solicitacao"
	 * type = "long"
	 */
    public Long getCodSitSolicitacao() {
        return codSitSolicitacao;
    }

    public void setCodSitSolicitacao(Long codSitSolicitacao) {
        this.codSitSolicitacao = codSitSolicitacao;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_tipo_compl1"
	 * type = "string"
	 */
    public String getCodTipoCompl1() {
        return codTipoCompl1;
    }

    public void setCodTipoCompl1(String codTipoCompl1) {
        this.codTipoCompl1 = codTipoCompl1;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_tipo_compl2"
	 * type = "string"
	 */
    public String getCodTipoCompl2() {
        return codTipoCompl2;
    }

    public void setCodTipoCompl2(String codTipoCompl2) {
        this.codTipoCompl2 = codTipoCompl2;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_tipo_imovel"
	 * type = "long"
	 */
    public Long getCodTipoImovel() {
        return codTipoImovel;
    }

    public void setCodTipoImovel(Long codTipoImovel) {
        this.codTipoImovel = codTipoImovel;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_usuario"
	 * type = "string"
	 */
    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
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
	 * column="dt_inclusao_exportar"
	 * type = "date"
	 */
    public Date getDtInclusaoExportar() {
        return dtInclusaoExportar;
    }

    public void setDtInclusaoExportar(Date dtInclusaoExportar) {
        this.dtInclusaoExportar = dtInclusaoExportar;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_nao_exportar"
	 * type = "date"
	 */
    public Date getDtNaoExportar() {
        return dtNaoExportar;
    }

    public void setDtNaoExportar(Date dtNaoExportar) {
        this.dtNaoExportar = dtNaoExportar;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_para_exportar"
	 * type = "date"
	 */
    public Date getDtParaExportar() {
        return dtParaExportar;
    }

    public void setDtParaExportar(Date dtParaExportar) {
        this.dtParaExportar = dtParaExportar;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_para_exportar_info"
	 * type = "date"
	 */
    public Date getDtParaExportarInfo() {
        return dtParaExportarInfo;
    }

    public void setDtParaExportarInfo(Date dtParaExportarInfo) {
        this.dtParaExportarInfo = dtParaExportarInfo;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_para_exportar_node"
	 * type = "date"
	 */
    public Date getDtParaExportarNode() {
        return dtParaExportarNode;
    }

    public void setDtParaExportarNode(Date dtParaExportarNode) {
        this.dtParaExportarNode = dtParaExportarNode;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_para_exportar_siebel"
	 * type = "date"
	 */
    public Date getDtParaExportarSiebel() {
        return dtParaExportarSiebel;
    }

    public void setDtParaExportarSiebel(Date dtParaExportarSiebel) {
        this.dtParaExportarSiebel = dtParaExportarSiebel;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_registro_solicitacao"
	 * type = "date"
	 */
    public Date getDtRegistroSolicitacao() {
        return dtRegistroSolicitacao;
    }

    public void setDtRegistroSolicitacao(Date dtRegistroSolicitacao) {
        this.dtRegistroSolicitacao = dtRegistroSolicitacao;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_sit_sms"
	 * type = "date"
	 */
    public Date getDtSitSms() {
        return dtSitSms;
    }

    public void setDtSitSms(Date dtSitSms) {
        this.dtSitSms = dtSitSms;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_sit_solicitacao"
	 * type = "date"
	 */
    public Date getDtSitSolicitacao() {
        return dtSitSolicitacao;
    }

    public void setDtSitSolicitacao(Date dtSitSolicitacao) {
        this.dtSitSolicitacao = dtSitSolicitacao;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="id_lm"
	 * type = "long"
	 */
    public Long getIdLm() {
        return idLm;
    }

    public void setIdLm(Long idLm) {
        this.idLm = idLm;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="id_sar"
	 * type = "long"
	 */
    public Long getIdSar() {
        return idSar;
    }

    public void setIdSar(Long idSar) {
        this.idSar = idSar;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_clandestino"
	 * type = "string"
	 */
    public String getIndClandestino() {
        return indClandestino;
    }

    public void setIndClandestino(String indClandestino) {
        this.indClandestino = indClandestino;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_condicao"
	 * type = "string"
	 */
    public String getIndCondicao() {
        return indCondicao;
    }

    public void setIndCondicao(String indCondicao) {
        this.indCondicao = indCondicao;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_origem"
	 * type = "string"
	 */
    public String getIndOrigem() {
        return indOrigem;
    }

    public void setIndOrigem(String indOrigem) {
        this.indOrigem = indOrigem;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_situacao"
	 * type = "string"
	 */
    public String getIndSituacao() {
        return indSituacao;
    }

    public void setIndSituacao(String indSituacao) {
        this.indSituacao = indSituacao;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="num_ddd_hp"
	 * type = "long"
	 */
    public Long getNumDddHP() {
        return numDddHP;
    }

    public void setNumDddHP(Long numDddHP) {
        this.numDddHP = numDddHP;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="num_tel_hp"
	 * type = "long"
	 */
    public Long getNumTelHP() {
        return numTelHP;
    }

    public void setNumTelHP(Long numTelHP) {
        this.numTelHP = numTelHP;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="qtd_comodos"
	 * type = "long"
	 */
    public Long getQtdComodos() {
        return qtdComodos;
    }

    public void setQtdComodos(Long qtdComodos) {
        this.qtdComodos = qtdComodos;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="qtd_pontos_tv"
	 * type = "long"
	 */
    public Long getQtdPontosTv() {
        return qtdPontosTv;
    }

    public void setQtdPontosTv(Long qtdPontosTv) {
        this.qtdPontosTv = qtdPontosTv;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="txt_compl1"
	 * type = "string"
	 */
    public String getTxtCompl1() {
        return txtCompl1;
    }

    public void setTxtCompl1(String txtCompl1) {
        this.txtCompl1 = txtCompl1;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="txt_compl2"
	 * type = "string"
	 */
    public String getTxtCompl2() {
        return txtCompl2;
    }

    public void setTxtCompl2(String txtCompl2) {
        this.txtCompl2 = txtCompl2;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="txt_obs_bloqueio"
	 * type = "string"
	 */
    public String getTxtObsBloqueio() {
        return txtObsBloqueio;
    }

    public void setTxtObsBloqueio(String txtObsBloqueio) {
        this.txtObsBloqueio = txtObsBloqueio;
    }
    
}
