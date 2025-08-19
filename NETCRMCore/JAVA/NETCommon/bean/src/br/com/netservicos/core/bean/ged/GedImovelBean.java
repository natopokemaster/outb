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
* 	Classe Bean que representa a tabela ged.imovel.
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
* @hibernate.class table = "imovel"
*                  dynamic-insert = "true"
*                  dynamic-update = "true"
*                  lazy="false"
*                  
* @hibernate.cache
*       usage = "read-write"
*       
*                           
*/
public class GedImovelBean extends DomainBean {
	
	private static final long serialVersionUID = -519208456013332476L;
	
	private GedImovelKey composite;
    private String codNode;
    private Long codBloqueioVendas;
    private Date dtAtualizacao;
    private Long codCidade;
    private Long codCompRede;
    private String codCelula;
    private String codCategoriaSe;
    private Long codLogradouro;
    private Long codEndereco;
    private Long codTipoImovel;
    private Date dtSitImovel;
    private String indSitImovel;
    private Long codSitImovel;
    private Long codCondominio;
    private String indTipoEdificacao;
    private Long codSitComercial;
    private Long qtdUnidadesPrev;
    private Date dtSitComercial;
    private String indEstagioConstrucao;
    private Long qtdUnidadesIns;
    private Long qtdPontos;
    private String nomContato1;
    private Long numDddContato1;
    private Long numTelContato1;
    private String indRetornoRede;
    private String indTipoContato1;
    private String txtObsContato1;
    private Date dtPrevAtivacao;
    private Date dtAtivacao;
    private String nomContato2;
    private Long numDddContato2;
    private String nomImovel;
    private Long numTelContato2;
    private String indTipoContato2;
    private String txtObsContato2;
    private String indSituacaoInclusao;
    private String codUsuario;
    private String indOrigem;
    private String indDisponivel;
    private Long codHPMaster;
    private String indContratoColetivo;
    private Long codSitRetorno;
    private Date dtSitRetorno;
    private Long codSitComercialRetorno;
    private Date dtSitComercialRetorno;
    private Date dtAtivacaoRetorno;
    private Date dtPrevAtivacaoRetorno;
    private Long codBloqueioVendasRetorno;
    private Long codTipoCabeamento;
    private String numUtmPoste;
    private Double numCoordXPoste;
    private Double numCoordYPoste;
    private String txtReferencia;
    private String indDrop;
    private String codNodeReconstrucao;
    private Date dtIncExportar;
    private Date dtAltExportar;
    private Date dtAltSitComercial;
    private Date dtAltAtivNode;
    private Long indTipoBackbone;
    private String indFonteAlimentacao;
    private String indTipoAmplificador;
    private String indTipoProjetoBackbone;
    private String numUtmEdif;
    private Long numIdSar;
    private String indSolicitanteSar;
    private Date dtIniSar;
    private Date dtFimPrevSar;
    private Date dtFimSar;
    private String indSituacaoSar;
    private String seggeo;
    private Double propass;
        
    public static final String RETORNA_COD_IMOVEL_BY_HP = "retornaCodImovelByHP";
    public static final String RETORNA_CODIGOS_IMOVEL_BY_HPS = "retornaCodigosImovelByHPs";
    public static final String COMPOSITE_KEY = "composite";
    
    public GedImovelBean(){
        super(COMPOSITE_KEY);
    }
    
	/**
	 * @hibernate.id
	 * type = "composite"
	 */
    public GedImovelKey getComposite() {
		return composite;
	}

	public void setComposite(GedImovelKey composite) {
		this.composite = composite;
	}
	
	/** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_bloqueio_vendas"
	 * type = "long"
	 */
    public Long getCodBloqueioVendas() {
        return codBloqueioVendas;
    }

    public void setCodBloqueioVendas(Long codBloqueioVendas) {
        this.codBloqueioVendas = codBloqueioVendas;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_bloqueio_vendas_retorno"
	 * type = "long"
	 */
    public Long getCodBloqueioVendasRetorno() {
        return codBloqueioVendasRetorno;
    }

    public void setCodBloqueioVendasRetorno(Long codBloqueioVendasRetorno) {
        this.codBloqueioVendasRetorno = codBloqueioVendasRetorno;
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
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_celula"
	 * type = "string"
	 */
    public String getCodCelula() {
        return codCelula;
    }

    public void setCodCelula(String codCelula) {
        this.codCelula = codCelula;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_cidade"
	 * type = "long"
	 */
    public Long getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(Long codCidade) {
        this.codCidade = codCidade;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_comp_rede"
	 * type = "long"
	 */
    public Long getCodCompRede() {
        return codCompRede;
    }

    public void setCodCompRede(Long codCompRede) {
        this.codCompRede = codCompRede;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_condominio"
	 * type = "long"
	 */
    public Long getCodCondominio() {
        return codCondominio;
    }

    public void setCodCondominio(Long codCondominio) {
        this.codCondominio = codCondominio;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_endereco"
	 * type = "long"
	 */
    public Long getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Long codEndereco) {
        this.codEndereco = codEndereco;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_hp_master"
	 * type = "long"
	 */
    public Long getCodHPMaster() {
        return codHPMaster;
    }

    public void setCodHPMaster(Long codHPMaster) {
        this.codHPMaster = codHPMaster;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_logradouro"
	 * type = "long"
	 */
    public Long getCodLogradouro() {
        return codLogradouro;
    }

    public void setCodLogradouro(Long codLogradouro) {
        this.codLogradouro = codLogradouro;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_node"
	 * type = "string"
	 */
    public String getCodNode() {
        return codNode;
    }

    public void setCodNode(String codNode) {
        this.codNode = codNode;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="cod_node_reconstrucao"
	 * type = "string"
	 */
    public String getCodNodeReconstrucao() {
        return codNodeReconstrucao;
    }

    public void setCodNodeReconstrucao(String codNodeReconstrucao) {
        this.codNodeReconstrucao = codNodeReconstrucao;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_sit_comercial"
	 * type = "long"
	 */
    public Long getCodSitComercial() {
        return codSitComercial;
    }

    public void setCodSitComercial(Long codSitComercial) {
        this.codSitComercial = codSitComercial;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_sit_comercial_retorno"
	 * type = "long"
	 */
    public Long getCodSitComercialRetorno() {
        return codSitComercialRetorno;
    }

    public void setCodSitComercialRetorno(Long codSitComercialRetorno) {
        this.codSitComercialRetorno = codSitComercialRetorno;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_sit_imovel"
	 * type = "long"
	 */
    public Long getCodSitImovel() {
        return codSitImovel;
    }

    public void setCodSitImovel(Long codSitImovel) {
        this.codSitImovel = codSitImovel;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_sit_retorno"
	 * type = "long"
	 */
    public Long getCodSitRetorno() {
        return codSitRetorno;
    }

    public void setCodSitRetorno(Long codSitRetorno) {
        this.codSitRetorno = codSitRetorno;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_tipo_cabeamento"
	 * type = "long"
	 */
    public Long getCodTipoCabeamento() {
        return codTipoCabeamento;
    }

    public void setCodTipoCabeamento(Long codTipoCabeamento) {
        this.codTipoCabeamento = codTipoCabeamento;
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
	 * column="dt_alt_ativ_node"
	 * type = "date"
	 */
    public Date getDtAltAtivNode() {
        return dtAltAtivNode;
    }

    public void setDtAltAtivNode(Date dtAltAtivNode) {
        this.dtAltAtivNode = dtAltAtivNode;
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
	 * column="dt_alt_sit_comercial"
	 * type = "date"
	 */
    public Date getDtAltSitComercial() {
        return dtAltSitComercial;
    }

    public void setDtAltSitComercial(Date dtAltSitComercial) {
        this.dtAltSitComercial = dtAltSitComercial;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_ativacao"
	 * type = "date"
	 */
    public Date getDtAtivacao() {
        return dtAtivacao;
    }

    public void setDtAtivacao(Date dtAtivacao) {
        this.dtAtivacao = dtAtivacao;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_ativacao_retorno"
	 * type = "date"
	 */
    public Date getDtAtivacaoRetorno() {
        return dtAtivacaoRetorno;
    }

    public void setDtAtivacaoRetorno(Date dtAtivacaoRetorno) {
        this.dtAtivacaoRetorno = dtAtivacaoRetorno;
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
	 * column="dt_fim_prev_sar"
	 * type = "date"
	 */
    public Date getDtFimPrevSar() {
        return dtFimPrevSar;
    }

    public void setDtFimPrevSar(Date dtFimPrevSar) {
        this.dtFimPrevSar = dtFimPrevSar;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_fim_sar"
	 * type = "date"
	 */
    public Date getDtFimSar() {
        return dtFimSar;
    }

    public void setDtFimSar(Date dtFimSar) {
        this.dtFimSar = dtFimSar;
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
	 * column="dt_ini_sar"
	 * type = "date"
	 */
    public Date getDtIniSar() {
        return dtIniSar;
    }

    public void setDtIniSar(Date dtIniSar) {
        this.dtIniSar = dtIniSar;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_prev_ativacao"
	 * type = "date"
	 */
    public Date getDtPrevAtivacao() {
        return dtPrevAtivacao;
    }

    public void setDtPrevAtivacao(Date dtPrevAtivacao) {
        this.dtPrevAtivacao = dtPrevAtivacao;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_prev_ativacao_retorno"
	 * type = "date"
	 */
    public Date getDtPrevAtivacaoRetorno() {
        return dtPrevAtivacaoRetorno;
    }

    public void setDtPrevAtivacaoRetorno(Date dtPrevAtivacaoRetorno) {
        this.dtPrevAtivacaoRetorno = dtPrevAtivacaoRetorno;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_sit_comercial"
	 * type = "date"
	 */
    public Date getDtSitComercial() {
        return dtSitComercial;
    }

    public void setDtSitComercial(Date dtSitComercial) {
        this.dtSitComercial = dtSitComercial;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_sit_comercial_retorno"
	 * type = "date"
	 */
    public Date getDtSitComercialRetorno() {
        return dtSitComercialRetorno;
    }

    public void setDtSitComercialRetorno(Date dtSitComercialRetorno) {
        this.dtSitComercialRetorno = dtSitComercialRetorno;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_sit_imovel"
	 * type = "date"
	 */
    public Date getDtSitImovel() {
        return dtSitImovel;
    }

    public void setDtSitImovel(Date dtSitImovel) {
        this.dtSitImovel = dtSitImovel;
    }

    /** 
	 * @return Date
	 * 
	 * @hibernate.property
	 * column="dt_sit_retorno"
	 * type = "date"
	 */
    public Date getDtSitRetorno() {
        return dtSitRetorno;
    }

    public void setDtSitRetorno(Date dtSitRetorno) {
        this.dtSitRetorno = dtSitRetorno;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_contrato_coletivo"
	 * type = "string"
	 */
    public String getIndContratoColetivo() {
        return indContratoColetivo;
    }

    public void setIndContratoColetivo(String indContratoColetivo) {
        this.indContratoColetivo = indContratoColetivo;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_disponivel"
	 * type = "string"
	 */
    public String getIndDisponivel() {
        return indDisponivel;
    }

    public void setIndDisponivel(String indDisponivel) {
        this.indDisponivel = indDisponivel;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_drop"
	 * type = "string"
	 */
    public String getIndDrop() {
        return indDrop;
    }

    public void setIndDrop(String indDrop) {
        this.indDrop = indDrop;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_estagio_construcao"
	 * type = "string"
	 */
    public String getIndEstagioConstrucao() {
        return indEstagioConstrucao;
    }

    public void setIndEstagioConstrucao(String indEstagioConstrucao) {
        this.indEstagioConstrucao = indEstagioConstrucao;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_fonte_alimentacao"
	 * type = "string"
	 */
    public String getIndFonteAlimentacao() {
        return indFonteAlimentacao;
    }

    public void setIndFonteAlimentacao(String indFonteAlimentacao) {
        this.indFonteAlimentacao = indFonteAlimentacao;
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
	 * column="ind_retorno_rede"
	 * type = "string"
	 */
    public String getIndRetornoRede() {
        return indRetornoRede;
    }

    public void setIndRetornoRede(String indRetornoRede) {
        this.indRetornoRede = indRetornoRede;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_sit_imovel"
	 * type = "string"
	 */
    public String getIndSitImovel() {
        return indSitImovel;
    }

    public void setIndSitImovel(String indSitImovel) {
        this.indSitImovel = indSitImovel;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_situacao_inclusao"
	 * type = "string"
	 */
    public String getIndSituacaoInclusao() {
        return indSituacaoInclusao;
    }

    public void setIndSituacaoInclusao(String indSituacaoInclusao) {
        this.indSituacaoInclusao = indSituacaoInclusao;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_situacao_sar"
	 * type = "string"
	 */
    public String getIndSituacaoSar() {
        return indSituacaoSar;
    }

    public void setIndSituacaoSar(String indSituacaoSar) {
        this.indSituacaoSar = indSituacaoSar;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_solicitante_sar"
	 * type = "string"
	 */
    public String getIndSolicitanteSar() {
        return indSolicitanteSar;
    }

    public void setIndSolicitanteSar(String indSolicitanteSar) {
        this.indSolicitanteSar = indSolicitanteSar;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_tipo_amplificador"
	 * type = "string"
	 */
    public String getIndTipoAmplificador() {
        return indTipoAmplificador;
    }

    public void setIndTipoAmplificador(String indTipoAmplificador) {
        this.indTipoAmplificador = indTipoAmplificador;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="ind_tipo_backbone"
	 * type = "long"
	 */
    public Long getIndTipoBackbone() {
        return indTipoBackbone;
    }

    public void setIndTipoBackbone(Long indTipoBackbone) {
        this.indTipoBackbone = indTipoBackbone;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_tipo_contato1"
	 * type = "string"
	 */
    public String getIndTipoContato1() {
        return indTipoContato1;
    }

    public void setIndTipoContato1(String indTipoContato1) {
        this.indTipoContato1 = indTipoContato1;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_tipo_contato2"
	 * type = "string"
	 */
    public String getIndTipoContato2() {
        return indTipoContato2;
    }

    public void setIndTipoContato2(String indTipoContato2) {
        this.indTipoContato2 = indTipoContato2;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_tipo_edificacao"
	 * type = "string"
	 */
    public String getIndTipoEdificacao() {
        return indTipoEdificacao;
    }

    public void setIndTipoEdificacao(String indTipoEdificacao) {
        this.indTipoEdificacao = indTipoEdificacao;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_tipo_projeto_backbone"
	 * type = "string"
	 */
    public String getIndTipoProjetoBackbone() {
        return indTipoProjetoBackbone;
    }

    public void setIndTipoProjetoBackbone(String indTipoProjetoBackbone) {
        this.indTipoProjetoBackbone = indTipoProjetoBackbone;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_contato1"
	 * type = "string"
	 */
    public String getNomContato1() {
        return nomContato1;
    }

    public void setNomContato1(String nomContato1) {
        this.nomContato1 = nomContato1;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_imovel"
	 * type = "string"
	 */
    public String getNomImovel() {
        return nomImovel;
    }

    public void setNomImovel(String nomImovel) {
        this.nomImovel = nomImovel;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_contato2"
	 * type = "string"
	 */
    public String getNomContato2() {
        return nomContato2;
    }

    public void setNomContato2(String nomContato2) {
        this.nomContato2 = nomContato2;
    }

    /** 
	 * @return Double
	 * 
	 * @hibernate.property
	 * column="num_coordx_poste"
	 * type = "double"
	 */
    public Double getNumCoordXPoste() {
        return numCoordXPoste;
    }

    public void setNumCoordXPoste(Double numCoordXPoste) {
        this.numCoordXPoste = numCoordXPoste;
    }

    /** 
	 * @return Double
	 * 
	 * @hibernate.property
	 * column="num_coordy_poste"
	 * type = "double"
	 */
    public Double getNumCoordYPoste() {
        return numCoordYPoste;
    }

    public void setNumCoordYPoste(Double numCoordYPoste) {
        this.numCoordYPoste = numCoordYPoste;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="num_ddd_contato1"
	 * type = "long"
	 */
    public Long getNumDddContato1() {
        return numDddContato1;
    }

    public void setNumDddContato1(Long numDddContato1) {
        this.numDddContato1 = numDddContato1;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="num_ddd_contato2"
	 * type = "long"
	 */
    public Long getNumDddContato2() {
        return numDddContato2;
    }

    public void setNumDddContato2(Long numDddContato2) {
        this.numDddContato2 = numDddContato2;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="num_id_sar"
	 * type = "long"
	 */
    public Long getNumIdSar() {
        return numIdSar;
    }

    public void setNumIdSar(Long numIdSar) {
        this.numIdSar = numIdSar;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="num_tel_contato1"
	 * type = "long"
	 */
    public Long getNumTelContato1() {
        return numTelContato1;
    }

    public void setNumTelContato1(Long numTelContato1) {
        this.numTelContato1 = numTelContato1;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="num_tel_contato2"
	 * type = "long"
	 */
    public Long getNumTelContato2() {
        return numTelContato2;
    }

    public void setNumTelContato2(Long numTelContato2) {
        this.numTelContato2 = numTelContato2;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="num_utm_edif"
	 * type = "string"
	 */
    public String getNumUtmEdif() {
        return numUtmEdif;
    }

    public void setNumUtmEdif(String numUtmEdif) {
        this.numUtmEdif = numUtmEdif;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="num_utm_poste"
	 * type = "string"
	 */
    public String getNumUtmPoste() {
        return numUtmPoste;
    }

    public void setNumUtmPoste(String numUtmPoste) {
        this.numUtmPoste = numUtmPoste;
    }

    /** 
	 * @return Double
	 * 
	 * @hibernate.property
	 * column="propass"
	 * type = "double"
	 */
    public Double getPropass() {
        return propass;
    }

    public void setPropass(Double propass) {
        this.propass = propass;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="qtd_pontos"
	 * type = "long"
	 */
    public Long getQtdPontos() {
        return qtdPontos;
    }

    public void setQtdPontos(Long qtdPontos) {
        this.qtdPontos = qtdPontos;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="qtd_unidades_ins"
	 * type = "long"
	 */
    public Long getQtdUnidadesIns() {
        return qtdUnidadesIns;
    }

    public void setQtdUnidadesIns(Long qtdUnidadesIns) {
        this.qtdUnidadesIns = qtdUnidadesIns;
    }

    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="qtd_unidades_prev"
	 * type = "long"
	 */
    public Long getQtdUnidadesPrev() {
        return qtdUnidadesPrev;
    }

    public void setQtdUnidadesPrev(Long qtdUnidadesPrev) {
        this.qtdUnidadesPrev = qtdUnidadesPrev;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="seggeo"
	 * type = "string"
	 */
    public String getSeggeo() {
        return seggeo;
    }

    public void setSeggeo(String seggeo) {
        this.seggeo = seggeo;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="txt_obs_contato1"
	 * type = "string"
	 */
    public String getTxtObsContato1() {
        return txtObsContato1;
    }

    public void setTxtObsContato1(String txtObsContato1) {
        this.txtObsContato1 = txtObsContato1;
    }

    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="txt_obs_contato2"
	 * type = "string"
	 */
    public String getTxtObsContato2() {
        return txtObsContato2;
    }

    public void setTxtObsContato2(String txtObsContato2) {
        this.txtObsContato2 = txtObsContato2;
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
    
}
