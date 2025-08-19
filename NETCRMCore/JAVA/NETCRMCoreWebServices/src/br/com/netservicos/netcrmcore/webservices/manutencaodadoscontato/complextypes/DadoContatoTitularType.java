package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadoContatoTitularType implements BaseComplexType {

	private static final long serialVersionUID = 4726379093227812152L;
	
	private EmailType email; 
	
	private TelefonesContatoType telefones;

	public EmailType getEmail() {
		return email;
	}

	public void setEmail(EmailType email) {
		this.email = email;
	}

	public TelefonesContatoType getTelefones() {
		return telefones;
	}

	public void setTelefones(TelefonesContatoType telefones) {
		this.telefones = telefones;
	}
	
}
