package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class RegistroContatoType implements BaseComplexType {

	private static final long serialVersionUID = 6985401640270196267L;

	private String nomeContato;
	
	private TelefoneType telefoneContato;
	
	private String observacao;

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public TelefoneType getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(TelefoneType telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
