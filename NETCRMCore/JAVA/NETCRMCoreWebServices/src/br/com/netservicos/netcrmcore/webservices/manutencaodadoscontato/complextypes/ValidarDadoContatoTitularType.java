package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ValidarDadoContatoTitularType implements BaseComplexType {

	private static final long serialVersionUID = 5422074689696180368L;
	
	private IdentificadorContratoType identificadorContrato;
	
	private DadoContatoTitularType dadoContatoTitular;

	public IdentificadorContratoType getIdentificadorContrato() {
		return identificadorContrato;
	}

	public void setIdentificadorContrato(
			IdentificadorContratoType identificadorContrato) {
		this.identificadorContrato = identificadorContrato;
	}

	public DadoContatoTitularType getDadoContatoTitular() {
		return dadoContatoTitular;
	}

	public void setDadoContatoTitular(DadoContatoTitularType dadoContatoTitular) {
		this.dadoContatoTitular = dadoContatoTitular;
	}
	
}
