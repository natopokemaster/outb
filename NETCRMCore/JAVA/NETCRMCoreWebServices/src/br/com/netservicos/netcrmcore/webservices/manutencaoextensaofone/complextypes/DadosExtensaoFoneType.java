package br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes;

public class DadosExtensaoFoneType {
	private boolean flagImediata;

	private Long identificadorLocalDomicilio;

	private Long identificadorPlanoPagamento;

	private Long numeroExtensoes;

	private String nomeSolicitante;

	private String observacao;

	private TelefoneVoipType telefoneVoip;

	public boolean isFlagImediata() {
		return flagImediata;
	}

	public void setFlagImediata(boolean flagImediata) {
		this.flagImediata = flagImediata;
	}

	public Long getIdentificadorLocalDomicilio() {
		return identificadorLocalDomicilio;
	}

	public void setIdentificadorLocalDomicilio(Long identificadorLocalDomicilio) {
		this.identificadorLocalDomicilio = identificadorLocalDomicilio;
	}

	public Long getIdentificadorPlanoPagamento() {
		return identificadorPlanoPagamento;
	}

	public void setIdentificadorPlanoPagamento(Long identificadorPlanoPagamento) {
		this.identificadorPlanoPagamento = identificadorPlanoPagamento;
	}

	public Long getNumeroExtensoes() {
		return numeroExtensoes;
	}

	public void setNumeroExtensoes(Long numeroExtensoes) {
		this.numeroExtensoes = numeroExtensoes;
	}

	public TelefoneVoipType getTelefoneVoip() {
		return telefoneVoip;
	}

	public void setTelefoneVoip(TelefoneVoipType telefoneVoip) {
		this.telefoneVoip = telefoneVoip;
	}

	public String getNomeSolicitante() {
		return nomeSolicitante;
	}

	public void setNomeSolicitante(String nomeSolicitante) {
		this.nomeSolicitante = nomeSolicitante;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
