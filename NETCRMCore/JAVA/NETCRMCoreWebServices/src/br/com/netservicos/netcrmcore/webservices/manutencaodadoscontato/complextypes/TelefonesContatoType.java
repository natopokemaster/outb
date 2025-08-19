package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class TelefonesContatoType implements BaseComplexType {

	private static final long serialVersionUID = -5900101674980141646L;
	
	private TelefoneContatoType[] telefone;

	public TelefoneContatoType[] getTelefone() {
		return telefone;
	}

	public void setTelefone(TelefoneContatoType[] telefone) {
		this.telefone = telefone.clone();
	}
	
}
