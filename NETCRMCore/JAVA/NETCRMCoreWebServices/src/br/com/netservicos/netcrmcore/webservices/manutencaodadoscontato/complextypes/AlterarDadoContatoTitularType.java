package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class AlterarDadoContatoTitularType implements BaseComplexType {

	private static final long serialVersionUID = -1469902937704490776L;
	
	private IdentificadorContratoType identificadorContrato;
	
	private DadoContatoTitularType dadoContatoTitular;
	
	private RegistroContatoType registroContato;

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

	public RegistroContatoType getRegistroContato() {
		return registroContato;
	}

	public void setRegistroContato(RegistroContatoType registroContato) {
		this.registroContato = registroContato;
	}
	
}
