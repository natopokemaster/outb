package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class EmailType implements BaseComplexType {

	private static final long serialVersionUID = -87150579956567184L;
	
	private String enderecoEmail;
	
	private boolean aceitaContato;

	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}

	public boolean isAceitaContato() {
		return aceitaContato;
	}

	public void setAceitaContato(boolean aceitaContato) {
		this.aceitaContato = aceitaContato;
	}
	
}
