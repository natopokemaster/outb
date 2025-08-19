package br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes;

public class DadoCadastralTitularPessoaJuridicaType extends DadoCadastralTitularType {

	private static final long serialVersionUID = -2229013799544818513L;
	
	private PessoaJuridicaType pessoaJuridica;

	public PessoaJuridicaType getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridicaType pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

}
