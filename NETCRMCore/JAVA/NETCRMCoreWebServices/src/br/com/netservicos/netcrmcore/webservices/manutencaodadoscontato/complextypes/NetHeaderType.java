package br.com.netservicos.netcrmcore.webservices.manutencaodadoscontato.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class NetHeaderType implements BaseComplexType {

	private static final long serialVersionUID = -5877113586128617834L;
	
	private String aplicacao;
	
	private String funcionalidade;
	
	private String versaoServico;
	
	private String token;
	
	private AtendimentoType atendimento;
	
	private String username;

	public String getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(String aplicacao) {
		this.aplicacao = aplicacao;
	}

	public String getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(String funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public String getVersaoServico() {
		return versaoServico;
	}

	public void setVersaoServico(String versaoServico) {
		this.versaoServico = versaoServico;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AtendimentoType getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(AtendimentoType atendimento) {
		this.atendimento = atendimento;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
