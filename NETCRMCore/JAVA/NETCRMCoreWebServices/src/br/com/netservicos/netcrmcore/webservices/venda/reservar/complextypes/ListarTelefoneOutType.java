package br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ListarTelefoneOutType implements BaseComplexType {

	private static final long serialVersionUID = -2666878924314523941L;
	
    /**
	 * 
	 */
	public ListarTelefoneOutType() {
		super();
	}
	
	/**
	 * @param cidContrato
	 * @param numContrato
	 * @param idPonto
	 * @param dddTelefoneVoip
	 * @param numTelefoneVoip
	 * @param fQDN
	 * @param numPorta
	 * @param dtIni
	 * @param dtFim
	 * @param dtAlteracao
	 * @param idStatusTelefoneVoip
	 * @param golden
	 * @param tmId
	 * @param idEscolhido
	 * @param publicar
	 * @param nomePublicacao
	 * @param numContratoAvaliacao
	 * @param idSistemaExterno
	 * @param cidContratoOrigem
	 * @param idSoftX
	 * @param fcNumeroPortado
	 * @param fcInterceptado
	 */
	public ListarTelefoneOutType(String cidContrato, String numContrato,
			String idPonto, String dddTelefoneVoip, String numTelefoneVoip,
			String fQDN, String numPorta, String dtIni, String dtFim,
			String dtAlteracao, String idStatusTelefoneVoip, String golden,
			String tmId, String idEscolhido, String publicar,
			String nomePublicacao, String numContratoAvaliacao,
			String idSistemaExterno, String cidContratoOrigem, String idSoftX,
			String fcNumeroPortado, String fcInterceptado) {
		super();
		this.cidContrato = cidContrato;
		this.numContrato = numContrato;
		this.idPonto = idPonto;
		this.dddTelefoneVoip = dddTelefoneVoip;
		this.numTelefoneVoip = numTelefoneVoip;
		FQDN = fQDN;
		this.numPorta = numPorta;
		this.dtIni = dtIni;
		this.dtFim = dtFim;
		this.dtAlteracao = dtAlteracao;
		this.idStatusTelefoneVoip = idStatusTelefoneVoip;
		this.golden = golden;
		this.tmId = tmId;
		this.idEscolhido = idEscolhido;
		this.publicar = publicar;
		this.nomePublicacao = nomePublicacao;
		this.numContratoAvaliacao = numContratoAvaliacao;
		this.idSistemaExterno = idSistemaExterno;
		this.cidContratoOrigem = cidContratoOrigem;
		this.idSoftX = idSoftX;
		this.fcNumeroPortado = fcNumeroPortado;
		this.fcInterceptado = fcInterceptado;
	}

	private String cidContrato;
    private String numContrato;
    private String idPonto;
    private String dddTelefoneVoip;
    private String numTelefoneVoip;
    private String FQDN;
    private String numPorta;
    private String dtIni;
    private String dtFim;
    private String dtAlteracao;
    private String idStatusTelefoneVoip;
    private String golden;
    private String tmId;
    private String idEscolhido;
    private String publicar;
    private String nomePublicacao;
    private String numContratoAvaliacao;
    private String idSistemaExterno;
    private String cidContratoOrigem;
    private String idSoftX;
    private String fcNumeroPortado;
    private String fcInterceptado;

	/**
	 * @return the cidContrato
	 */
	public String getCidContrato() {
		return cidContrato;
	}

	/**
	 * @param cidContrato the cidContrato to set
	 */
	public void setCidContrato(String cidContrato) {
		this.cidContrato = cidContrato;
	}

	/**
	 * @return the numContrato
	 */
	public String getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	/**
	 * @return the idPonto
	 */
	public String getIdPonto() {
		return idPonto;
	}

	/**
	 * @param idPonto the idPonto to set
	 */
	public void setIdPonto(String idPonto) {
		this.idPonto = idPonto;
	}

	/**
	 * @return the dddTelefoneVoip
	 */
	public String getDddTelefoneVoip() {
		return dddTelefoneVoip;
	}

	/**
	 * @param dddTelefoneVoip the dddTelefoneVoip to set
	 */
	public void setDddTelefoneVoip(String dddTelefoneVoip) {
		this.dddTelefoneVoip = dddTelefoneVoip;
	}

	/**
	 * @return the numTelefoneVoip
	 */
	public String getNumTelefoneVoip() {
		return numTelefoneVoip;
	}

	/**
	 * @param numTelefoneVoip the numTelefoneVoip to set
	 */
	public void setNumTelefoneVoip(String numTelefoneVoip) {
		this.numTelefoneVoip = numTelefoneVoip;
	}

	/**
	 * @return the fQDN
	 */
	public String getFQDN() {
		return FQDN;
	}

	/**
	 * @param fQDN the fQDN to set
	 */
	public void setFQDN(String fQDN) {
		FQDN = fQDN;
	}

	/**
	 * @return the numPorta
	 */
	public String getNumPorta() {
		return numPorta;
	}

	/**
	 * @param numPorta the numPorta to set
	 */
	public void setNumPorta(String numPorta) {
		this.numPorta = numPorta;
	}

	/**
	 * @return the dtIni
	 */
	public String getDtIni() {
		return dtIni;
	}

	/**
	 * @param dtIni the dtIni to set
	 */
	public void setDtIni(String dtIni) {
		this.dtIni = dtIni;
	}

	/**
	 * @return the dtFim
	 */
	public String getDtFim() {
		return dtFim;
	}

	/**
	 * @param dtFim the dtFim to set
	 */
	public void setDtFim(String dtFim) {
		this.dtFim = dtFim;
	}

	/**
	 * @return the dtAlteracao
	 */
	public String getDtAlteracao() {
		return dtAlteracao;
	}

	/**
	 * @param dtAlteracao the dtAlteracao to set
	 */
	public void setDtAlteracao(String dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	/**
	 * @return the idStatusTelefoneVoip
	 */
	public String getIdStatusTelefoneVoip() {
		return idStatusTelefoneVoip;
	}

	/**
	 * @param idStatusTelefoneVoip the idStatusTelefoneVoip to set
	 */
	public void setIdStatusTelefoneVoip(String idStatusTelefoneVoip) {
		this.idStatusTelefoneVoip = idStatusTelefoneVoip;
	}

	/**
	 * @return the golden
	 */
	public String getGolden() {
		return golden;
	}

	/**
	 * @param golden the golden to set
	 */
	public void setGolden(String golden) {
		this.golden = golden;
	}

	/**
	 * @return the tmId
	 */
	public String getTmId() {
		return tmId;
	}

	/**
	 * @param tmId the tmId to set
	 */
	public void setTmId(String tmId) {
		this.tmId = tmId;
	}

	/**
	 * @return the idEscolhido
	 */
	public String getIdEscolhido() {
		return idEscolhido;
	}

	/**
	 * @param idEscolhido the idEscolhido to set
	 */
	public void setIdEscolhido(String idEscolhido) {
		this.idEscolhido = idEscolhido;
	}

	/**
	 * @return the publicar
	 */
	public String getPublicar() {
		return publicar;
	}

	/**
	 * @param publicar the publicar to set
	 */
	public void setPublicar(String publicar) {
		this.publicar = publicar;
	}

	/**
	 * @return the nomePublicacao
	 */
	public String getNomePublicacao() {
		return nomePublicacao;
	}

	/**
	 * @param nomePublicacao the nomePublicacao to set
	 */
	public void setNomePublicacao(String nomePublicacao) {
		this.nomePublicacao = nomePublicacao;
	}

	/**
	 * @return the numContratoAvaliacao
	 */
	public String getNumContratoAvaliacao() {
		return numContratoAvaliacao;
	}

	/**
	 * @param numContratoAvaliacao the numContratoAvaliacao to set
	 */
	public void setNumContratoAvaliacao(String numContratoAvaliacao) {
		this.numContratoAvaliacao = numContratoAvaliacao;
	}

	/**
	 * @return the idSistemaExterno
	 */
	public String getIdSistemaExterno() {
		return idSistemaExterno;
	}

	/**
	 * @param idSistemaExterno the idSistemaExterno to set
	 */
	public void setIdSistemaExterno(String idSistemaExterno) {
		this.idSistemaExterno = idSistemaExterno;
	}

	/**
	 * @return the cidContratoOrigem
	 */
	public String getCidContratoOrigem() {
		return cidContratoOrigem;
	}

	/**
	 * @param cidContratoOrigem the cidContratoOrigem to set
	 */
	public void setCidContratoOrigem(String cidContratoOrigem) {
		this.cidContratoOrigem = cidContratoOrigem;
	}

	/**
	 * @return the idSoftX
	 */
	public String getIdSoftX() {
		return idSoftX;
	}

	/**
	 * @param idSoftX the idSoftX to set
	 */
	public void setIdSoftX(String idSoftX) {
		this.idSoftX = idSoftX;
	}

	/**
	 * @return the fcNumeroPortado
	 */
	public String getFcNumeroPortado() {
		return fcNumeroPortado;
	}

	/**
	 * @param fcNumeroPortado the fcNumeroPortado to set
	 */
	public void setFcNumeroPortado(String fcNumeroPortado) {
		this.fcNumeroPortado = fcNumeroPortado;
	}

	/**
	 * @return the fcInterceptado
	 */
	public String getFcInterceptado() {
		return fcInterceptado;
	}

	/**
	 * @param fcInterceptado the fcInterceptado to set
	 */
	public void setFcInterceptado(String fcInterceptado) {
		this.fcInterceptado = fcInterceptado;
	}
    
    
}
