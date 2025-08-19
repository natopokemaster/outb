package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class IdentificadorContratoType implements BaseComplexType {

	private static final long serialVersionUID = 4414132292933765752L;
	
	private Long numeroContrato;
	
	private String identificacaoCidade;

	public Long getNumeroContrato() {
		return numeroContrato;
	}

	public void setNumeroContrato(Long numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public String getIdentificacaoCidade() {
		return identificacaoCidade;
	}

	public void setIdentificacaoCidade(String identificacaoCidade) {
		this.identificacaoCidade = identificacaoCidade;
	}

}
