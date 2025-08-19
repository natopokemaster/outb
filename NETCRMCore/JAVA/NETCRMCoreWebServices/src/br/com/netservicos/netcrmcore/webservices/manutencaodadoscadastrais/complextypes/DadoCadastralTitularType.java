package br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadoCadastralTitularType implements BaseComplexType {

	private static final long serialVersionUID = -6560252020658467176L;

	private String nome;

	private String codigoSuframa;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoSuframa() {
		return codigoSuframa;
	}

	public void setCodigoSuframa(String codigoSuframa) {
		this.codigoSuframa = codigoSuframa;
	}

}
