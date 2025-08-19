package br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes;

public class DadoCadastralTitularPessoaFisicaType extends DadoCadastralTitularType {

	private static final long serialVersionUID = 8225464376278228020L;
	
	private PessoaFisicaType pessoaFisica;

	public PessoaFisicaType getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisicaType pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

}
