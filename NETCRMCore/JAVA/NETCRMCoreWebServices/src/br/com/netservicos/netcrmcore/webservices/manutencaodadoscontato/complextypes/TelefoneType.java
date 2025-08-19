package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class TelefoneType implements BaseComplexType {

	private static final long serialVersionUID = -1083171979964267502L;
	
	private String dddTelefone;
	
	private String numeroTelefone;

	public String getDddTelefone() {
		return dddTelefone;
	}

	public void setDddTelefone(String dddTelefone) {
		this.dddTelefone = dddTelefone;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	

}
