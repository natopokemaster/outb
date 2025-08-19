package br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class AlterarDadoCadastralTitularPessoaFisicaType implements BaseComplexType {

	private static final long serialVersionUID = -4047045103386038763L;
	
	private IdentificadorContratoType identificadorContrato;
	
	private DadoCadastralTitularPessoaFisicaType dadoCadastralTitularPessoaFisica;
	
	private RegistroContatoType registroContato;

	public IdentificadorContratoType getIdentificadorContrato() {
		return identificadorContrato;
	}

	public void setIdentificadorContrato(
			IdentificadorContratoType identificadorContrato) {
		this.identificadorContrato = identificadorContrato;
	}

	public DadoCadastralTitularPessoaFisicaType getDadoCadastralTitularPessoaFisica() {
		return dadoCadastralTitularPessoaFisica;
	}

	public void setDadoCadastralTitularPessoaFisica(
			DadoCadastralTitularPessoaFisicaType dadoCadastralTitularPessoaFisica) {
		this.dadoCadastralTitularPessoaFisica = dadoCadastralTitularPessoaFisica;
	}

	public RegistroContatoType getRegistroContato() {
		return registroContato;
	}

	public void setRegistroContato(RegistroContatoType registroContato) {
		this.registroContato = registroContato;
	}
	
	

}
