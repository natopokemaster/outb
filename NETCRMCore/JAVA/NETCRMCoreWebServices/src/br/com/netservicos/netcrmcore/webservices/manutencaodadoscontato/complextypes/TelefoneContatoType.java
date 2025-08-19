package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class TelefoneContatoType implements BaseComplexType {

	private static final long serialVersionUID = 4415156849790334520L;

	private String dddTelefone;
	
	private String numeroTelefone;
	
	private String ramal;
	
	private String tipoTelefone;

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

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

}
