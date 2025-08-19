package br.com.netservicos.core.bean.ged;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela hp_imovel
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
 *                            Prior
 * Date       By              Version  Project/CSR    Description
 * ---------- --------------  -------- -------------- ----------------------------
 * 13/09/2010 Márcio Dantas		 N/A	NETCombo      Created.
 * ==============================================================================
 * </PRE>
 *
 *@hibernate.class table="hp_imovel"
 *                 schema="ged"
 *                 dynamic-insert="true"
 *                 dynamic-update="true"
 *                 lazy="true"
 *                 batch-size="10"
 */
public class HPImovelBean extends DomainBean {

	private static final long serialVersionUID = -2211849301152937332L;
	public static final String LST_IMOVEL_BY_EDIFICACAO = "lstDadosImovelByEdificacao";

	private HPImovelKey composite;
	
	private Integer codTipoImovel;                           
	private Integer codSitSolicitacao;	
	private String indSituacao;
	private Date dtSitSolicitacao;
	private Integer codArea;
	private Integer codMotivoSituacao;
	private String codCategoriaSE;
	private Long codImovel; //
	private String codTipoCompl1;
	private String txtCompl1;
	private String codTipoCompl2;
	//private String txtCompl2;
	private Integer qtdPontosTV;
	private Integer qtdComodos;
	private Integer numTelHP;
	private String codHPSMS;
	private Integer numDDDHP;
	private String codHPDBM;
	private Date dtAtualizacao;
	private String codUsuario;
	private String codSitSMS;
	private Date dtSitSMS;
	private String indCondicao;
	private String indClandestino;
	private Date dtParaExportar;
	private Date dtParaExportarInfo;
	private Date dtParaExportarNode;
	private String indOrigem;
	private String codPreContrato;
	private Date dtRegistroSolicitacao;
	private Date dtNaoExportar;
	private Long idLM;
	private Long idSAR;
	private String txtObsBloqueio;
	private Date dtParaExportarSiebel;
	private Date dtInclusaoExportar;
	
	public static final String ATRIBUTO_ID_COMPOSITE = "composite";

	/**
	 *  
	 */
	public HPImovelBean() {
		super(ATRIBUTO_ID_COMPOSITE);
	}

	/**
	 * 
	 * @return Composite
	 * 
	 * @hibernate.id
	 * type = "composite" 
	 */
	public HPImovelKey getComposite() {
		return composite;
	}
	
	/**
	 * 
	 * @param composite
	 */
	public void setComposite(HPImovelKey composite) {
		this.composite = composite;
	}

	/**
	 * @return the codTipoImovel
	 * @hibernate.property
	 * column = "cod_tipo_imovel"
	 * type = "int"
	 */
	public Integer getCodTipoImovel() {
		return codTipoImovel;
	}

	/**
	 * @param codTipoImovel the codTipoImovel to set
	 */
	public void setCodTipoImovel(Integer codTipoImovel) {
		this.codTipoImovel = codTipoImovel;
	}

	/**
	 * @return the codSitSolicitacao
	 * @hibernate.property
	 * column = "cod_sit_solicitacao"
	 * type = "int"
	 */
	public Integer getCodSitSolicitacao() {
		return codSitSolicitacao;
	}

	/**
	 * @param codSitSolicitacao the codSitSolicitacao to set
	 */
	public void setCodSitSolicitacao(Integer codSitSolicitacao) {
		this.codSitSolicitacao = codSitSolicitacao;
	}

	/**
	 * @return the indSituacao
	 * @hibernate.property
	 * column = "ind_situacao"
	 * type = "string"
	 */
	public String getIndSituacao() {
		return indSituacao;
	}

	/**
	 * @param indSituacao the indSituacao to set
	 */
	public void setIndSituacao(String indSituacao) {
		this.indSituacao = indSituacao;
	}

	/**
	 * @return the dtSitSolicitacao
	 * @hibernate.property
	 * column = "dt_sit_solicitacao"
	 * type = "date"
	 */
	public Date getDtSitSolicitacao() {
		return dtSitSolicitacao;
	}

	/**
	 * @param dtSitSolicitacao the dtSitSolicitacao to set
	 */
	public void setDtSitSolicitacao(Date dtSitSolicitacao) {
		this.dtSitSolicitacao = dtSitSolicitacao;
	}

	/**
	 * @return the codArea
	 * @hibernate.property
	 * column = "cod_area"
	 * type = "int"
	 */
	public Integer getCodArea() {
		return codArea;
	}

	/**
	 * @param codArea the codArea to set
	 */
	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}

	/**
	 * @return the codMotivoSituacao
	 * @hibernate.property
	 * column = "cod_motivo_situacao"
	 * type = "int"
	 */
	public Integer getCodMotivoSituacao() {
		return codMotivoSituacao;
	}

	/**
	 * @param codMotivoSituacao the codMotivoSituacao to set
	 */
	public void setCodMotivoSituacao(Integer codMotivoSituacao) {
		this.codMotivoSituacao = codMotivoSituacao;
	}

	/**
	 * @return the codCategoriaSE
	 * @hibernate.property
	 * column = "cod_categoria_se"
	 * type = "string"
	 */
	public String getCodCategoriaSE() {
		return codCategoriaSE;
	}

	/**
	 * @param codCategoriaSE the codCategoriaSE to set
	 */
	public void setCodCategoriaSE(String codCategoriaSE) {
		this.codCategoriaSE = codCategoriaSE;
	}

	/**
	 * @return the codImovel
	 * @hibernate.property
	 * column = "cod_imovel"
	 * type = "long"
	 */
	public Long getCodImovel() {
		return codImovel;
	}

	/**
	 * @param codImovel the codImovel to set
	 */
	public void setCodImovel(Long codImovel) {
		this.codImovel = codImovel;
	}

	/**
	 * @return the codTipoCompl1
	 * @hibernate.property
	 * column = "cod_tipo_compl1"
	 * type = "string"
	 */
	public String getCodTipoCompl1() {
		return codTipoCompl1;
	}

	/**
	 * @param codTipoCompl1 the codTipoCompl1 to set
	 */
	public void setCodTipoCompl1(String codTipoCompl1) {
		this.codTipoCompl1 = codTipoCompl1;
	}

	/**
	 * @return the txtCompl1
	 * @hibernate.property
	 * column = "txt_compl1"
	 * type = "string"
	 */
	public String getTxtCompl1() {
		return txtCompl1;
	}

	/**
	 * @param txtCompl1 the txtCompl1 to set
	 */
	public void setTxtCompl1(String txtCompl1) {
		this.txtCompl1 = txtCompl1;
	}

	/**
	 * @return the codTipoCompl2
	 * @hibernate.property
	 * column = "cod_tipo_compl2"
	 * type = "string"
	 */
	public String getCodTipoCompl2() {
		return codTipoCompl2;
	}

	/**
	 * @param codTipoCompl2 the codTipoCompl2 to set
	 */
	public void setCodTipoCompl2(String codTipoCompl2) {
		this.codTipoCompl2 = codTipoCompl2;
	}

	/**
	 * @return the qtdPontosTV
	 * @hibernate.property
	 * column = "qtd_pontos_tv"
	 * type = "int"
	 */
	public Integer getQtdPontosTV() {
		return qtdPontosTV;
	}

	/**
	 * @param qtdPontosTV the qtdPontosTV to set
	 */
	public void setQtdPontosTV(Integer qtdPontosTV) {
		this.qtdPontosTV = qtdPontosTV;
	}

	/**
	 * @return the qtdComodos
	 * @hibernate.property
	 * column = "qtd_comodos"
	 * type = "int"
	 */
	public Integer getQtdComodos() {
		return qtdComodos;
	}

	/**
	 * @param qtdComodos the qtdComodos to set
	 */
	public void setQtdComodos(Integer qtdComodos) {
		this.qtdComodos = qtdComodos;
	}

	/**
	 * @return the numTelHP
	 * @hibernate.property
	 * column = "num_tel_hp"
	 * type = "int"
	 */
	public Integer getNumTelHP() {
		return numTelHP;
	}

	/**
	 * @param numTelHP the numTelHP to set
	 */
	public void setNumTelHP(Integer numTelHP) {
		this.numTelHP = numTelHP;
	}

	/**
	 * @return the codHPSMS
	 * @hibernate.property
	 * column = "cod_hp_sms"
	 * type = "string"
	 */
	public String getCodHPSMS() {
		return codHPSMS;
	}

	/**
	 * @param codHPSMS the codHPSMS to set
	 */
	public void setCodHPSMS(String codHPSMS) {
		this.codHPSMS = codHPSMS;
	}

	/**
	 * @return the numDDDHP
	 * @hibernate.property
	 * column = "num_ddd_hp"
	 * type = "int"
	 */
	public Integer getNumDDDHP() {
		return numDDDHP;
	}

	/**
	 * @param numDDDHP the numDDDHP to set
	 */
	public void setNumDDDHP(Integer numDDDHP) {
		this.numDDDHP = numDDDHP;
	}

	/**
	 * @return the codHPDBM
	 * @hibernate.property
	 * column = "cod_hp_dbm"
	 * type = "string"
	 */
	public String getCodHPDBM() {
		return codHPDBM;
	}

	/**
	 * @param codHPDBM the codHPDBM to set
	 */
	public void setCodHPDBM(String codHPDBM) {
		this.codHPDBM = codHPDBM;
	}

	/**
	 * @return the dtAtualizacao
	 * @hibernate.property
	 * column = "dt_atualizacao"
	 * type = "date"
	 */
	public Date getDtAtualizacao() {
		return dtAtualizacao;
	}

	/**
	 * @param dtAtualizacao the dtAtualizacao to set
	 */
	public void setDtAtualizacao(Date dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}

	/**
	 * @return the codUsuario
	 * @hibernate.property
	 * column = "cod_usuario"
	 * type = "string"
	 */
	public String getCodUsuario() {
		return codUsuario;
	}

	/**
	 * @param codUsuario the codUsuario to set
	 */
	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	/**
	 * @return the codSitSMS
	 * @hibernate.property
	 * column = "cod_sit_sms"
	 * type = "string"
	 */
	public String getCodSitSMS() {
		return codSitSMS;
	}

	/**
	 * @param codSitSMS the codSitSMS to set
	 */
	public void setCodSitSMS(String codSitSMS) {
		this.codSitSMS = codSitSMS;
	}

	/**
	 * @return the dtSitSMS
	 * @hibernate.property
	 * column = "dt_sit_sms"
	 * type = "date"
	 */
	public Date getDtSitSMS() {
		return dtSitSMS;
	}

	/**
	 * @param dtSitSMS the dtSitSMS to set
	 */
	public void setDtSitSMS(Date dtSitSMS) {
		this.dtSitSMS = dtSitSMS;
	}

	/**
	 * @return the indCondicao
	 * @hibernate.property
	 * column = "ind_condicao"
	 * type = "string"
	 */
	public String getIndCondicao() {
		return indCondicao;
	}

	/**
	 * @param indCondicao the indCondicao to set
	 */
	public void setIndCondicao(String indCondicao) {
		this.indCondicao = indCondicao;
	}

	/**
	 * @return the indClandestino
	 * @hibernate.property
	 * column = "ind_clandestino"
	 * type = "string"
	 */
	public String getIndClandestino() {
		return indClandestino;
	}

	/**
	 * @param indClandestino the indClandestino to set
	 */
	public void setIndClandestino(String indClandestino) {
		this.indClandestino = indClandestino;
	}

	/**
	 * @return the dtParaExportar
	 * @hibernate.property
	 * column = "dt_para_exportar"
	 * type = "date"
	 */
	public Date getDtParaExportar() {
		return dtParaExportar;
	}

	/**
	 * @param dtParaExportar the dtParaExportar to set
	 */
	public void setDtParaExportar(Date dtParaExportar) {
		this.dtParaExportar = dtParaExportar;
	}

	/**
	 * @return the dtParaExportarInfo
	 * @hibernate.property
	 * column = "dt_para_exportar_info"
	 * type = "date"
	 */
	public Date getDtParaExportarInfo() {
		return dtParaExportarInfo;
	}

	/**
	 * @param dtParaExportarInfo the dtParaExportarInfo to set
	 */
	public void setDtParaExportarInfo(Date dtParaExportarInfo) {
		this.dtParaExportarInfo = dtParaExportarInfo;
	}

	/**
	 * @return the dtParaExportarNode
	 * @hibernate.property
	 * column = "dt_para_exportar_node"
	 * type = "date"
	 */
	public Date getDtParaExportarNode() {
		return dtParaExportarNode;
	}

	/**
	 * @param dtParaExportarNode the dtParaExportarNode to set
	 */
	public void setDtParaExportarNode(Date dtParaExportarNode) {
		this.dtParaExportarNode = dtParaExportarNode;
	}

	/**
	 * @return the indOrigem
	 * @hibernate.property
	 * column = "ind_origem"
	 * type = "string"
	 */
	public String getIndOrigem() {
		return indOrigem;
	}

	/**
	 * @param indOrigem the indOrigem to set
	 */
	public void setIndOrigem(String indOrigem) {
		this.indOrigem = indOrigem;
	}

	/**
	 * @return the codPreContrato
	 * @hibernate.property
	 * column = "cod_pre_contrato"
	 * type = "string"
	 */
	public String getCodPreContrato() {
		return codPreContrato;
	}

	/**
	 * @param codPreContrato the codPreContrato to set
	 */
	public void setCodPreContrato(String codPreContrato) {
		this.codPreContrato = codPreContrato;
	}

	/**
	 * @return the dtRegistroSolicitacao
	 * @hibernate.property
	 * column = "dt_registro_solicitacao"
	 * type = "date"
	 */
	public Date getDtRegistroSolicitacao() {
		return dtRegistroSolicitacao;
	}

	/**
	 * @param dtRegistroSolicitacao the dtRegistroSolicitacao to set
	 */
	public void setDtRegistroSolicitacao(Date dtRegistroSolicitacao) {
		this.dtRegistroSolicitacao = dtRegistroSolicitacao;
	}

	/**
	 * @return the dtNaoExportar
	 * @hibernate.property
	 * column = "dt_nao_exportar"
	 * type = "date"
	 */
	public Date getDtNaoExportar() {
		return dtNaoExportar;
	}

	/**
	 * @param dtNaoExportar the dtNaoExportar to set
	 */
	public void setDtNaoExportar(Date dtNaoExportar) {
		this.dtNaoExportar = dtNaoExportar;
	}

	/**
	 * @return the idLM
	 * @hibernate.property
	 * column = "id_lm"
	 * type = "long"
	 */
	public Long getIdLM() {
		return idLM;
	}

	/**
	 * @param idLM the idLM to set
	 */
	public void setIdLM(Long idLM) {
		this.idLM = idLM;
	}

	/**
	 * @return the idSAR
	 * @hibernate.property
	 * column = "id_sar"
	 * type = "long"
	 */
	public Long getIdSAR() {
		return idSAR;
	}

	/**
	 * @param idSAR the idSAR to set
	 */
	public void setIdSAR(Long idSAR) {
		this.idSAR = idSAR;
	}

	/**
	 * @return the txtObsBloqueio
	 * @hibernate.property
	 * column = "txt_obs_bloqueio"
	 * type = "string"
	 */
	public String getTxtObsBloqueio() {
		return txtObsBloqueio;
	}

	/**
	 * @param txtObsBloqueio the txtObsBloqueio to set
	 */
	public void setTxtObsBloqueio(String txtObsBloqueio) {
		this.txtObsBloqueio = txtObsBloqueio;
	}

	/**
	 * @return the dtParaExportarSiebel
	 * @hibernate.property
	 * column = "dt_para_exportar_siebel"
	 * type = "date"
	 */
	public Date getDtParaExportarSiebel() {
		return dtParaExportarSiebel;
	}

	/**
	 * @param dtParaExportarSiebel the dtParaExportarSiebel to set
	 */
	public void setDtParaExportarSiebel(Date dtParaExportarSiebel) {
		this.dtParaExportarSiebel = dtParaExportarSiebel;
	}

	/**
	 * @return the dtInclusaoExportar
	 * @hibernate.property
	 * column = "dt_inclusao_exportar"
	 * type = "date"
	 */
	public Date getDtInclusaoExportar() {
		return dtInclusaoExportar;
	}

	/**
	 * @param dtInclusaoExportar the dtInclusaoExportar to set
	 */
	public void setDtInclusaoExportar(Date dtInclusaoExportar) {
		this.dtInclusaoExportar = dtInclusaoExportar;
	}
	
	
}