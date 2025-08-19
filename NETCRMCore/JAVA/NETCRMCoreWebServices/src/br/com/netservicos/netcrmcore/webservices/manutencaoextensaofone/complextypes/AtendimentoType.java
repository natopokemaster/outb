package br.com.netservicos.netcrmcore.webservices.manutencaoextensaofone.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class AtendimentoType implements BaseComplexType {

	private static final long serialVersionUID = 6944832232188905619L;

	private String numeroProtocolo;
	
	private String numeroChamada;

	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}

	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}

	public String getNumeroChamada() {
		return numeroChamada;
	}

	public void setNumeroChamada(String numeroChamada) {
		this.numeroChamada = numeroChamada;
	}
}
