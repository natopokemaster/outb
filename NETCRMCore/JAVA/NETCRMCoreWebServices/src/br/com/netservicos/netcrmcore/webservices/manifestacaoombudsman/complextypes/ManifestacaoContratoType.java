package br.com.netservicos.netcrmcore.webservices.manifestacaoombudsman.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ManifestacaoContratoType implements BaseComplexType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 317951561921978624L;

	public ManifestacaoContratoType(){
		super();
	}

	public ManifestacaoContratoType(String descricaoAssunto, String canal, String codigoOperadora, String descricao, Long numeroContrato, String protocolo, String tipoPessoa){
		this.descricaoAssunto = descricaoAssunto;
		this.canal = canal;
		this.codigoOperadora = codigoOperadora;
		this.descricao = descricao;
		this.numeroContrato = numeroContrato;
		this.protocolo = protocolo;
		this.tipoPessoa = tipoPessoa;
	}

	private String descricaoAssunto;
	private String canal;
	private String codigoOperadora;
	private String descricao;
	private Long numeroContrato;
	private String protocolo;
	private String tipoPessoa;

	public String getDescricaoAssunto() {
		return descricaoAssunto;
	}

	public void setDescricaoAssunto(String descricaoAssunto) {
		this.descricaoAssunto = descricaoAssunto;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getCodigoOperadora() {
		return codigoOperadora;
	}

	public void setCodigoOperadora(String codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}



}
