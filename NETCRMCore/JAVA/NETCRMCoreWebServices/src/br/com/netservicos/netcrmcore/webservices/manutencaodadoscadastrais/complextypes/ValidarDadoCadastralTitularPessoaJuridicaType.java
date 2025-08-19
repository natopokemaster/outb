package br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ValidarDadoCadastralTitularPessoaJuridicaType implements
		BaseComplexType {

	private static final long serialVersionUID = -8550277551476465255L;

	private IdentificadorContratoType identificadorContrato;
	
	private DadoCadastralTitularPessoaJuridicaType dadoCadastralTitularPessoaJuridica;

	public IdentificadorContratoType getIdentificadorContrato() {
		return identificadorContrato;
	}

	public void setIdentificadorContrato(
			IdentificadorContratoType identificadorContrato) {
		this.identificadorContrato = identificadorContrato;
	}

	public DadoCadastralTitularPessoaJuridicaType getDadoCadastralTitularPessoaJuridica() {
		return dadoCadastralTitularPessoaJuridica;
	}

	public void setDadoCadastralTitularPessoaJuridica(
			DadoCadastralTitularPessoaJuridicaType dadoCadastralTitularPessoaJuridica) {
		this.dadoCadastralTitularPessoaJuridica = dadoCadastralTitularPessoaJuridica;
	}
	
}
