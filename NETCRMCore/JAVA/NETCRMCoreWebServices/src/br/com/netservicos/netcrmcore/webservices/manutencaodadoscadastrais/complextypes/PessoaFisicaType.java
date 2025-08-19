package br.com.netservicos.netcrmcore.webservices.manutencaodadoscadastrais.complextypes;

import java.util.Date;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class PessoaFisicaType implements BaseComplexType {

	private static final long serialVersionUID = -1503642049328304887L;
	
	private Date dataNascimento;
	
	private String cpf;
	
	private String rg;
	
	private String orgaoExpedidor;
	
	private Boolean flagEstrangeiro;
	
	private String passaporte;
	
	private String nomePai;
	
	private String nomeMae;
	
	private String sexo;
	
	private Long identificacaoEstadoCivil;
	
	private Long identificacaoProfissao;
	
	private Long identificacaoEscolaridade;

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public Boolean getFlagEstrangeiro() {
		return flagEstrangeiro;
	}

	public void setFlagEstrangeiro(Boolean flagEstrangeiro) {
		this.flagEstrangeiro = flagEstrangeiro;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Long getIdentificacaoEstadoCivil() {
		return identificacaoEstadoCivil;
	}

	public void setIdentificacaoEstadoCivil(Long identificacaoEstadoCivil) {
		this.identificacaoEstadoCivil = identificacaoEstadoCivil;
	}

	public Long getIdentificacaoProfissao() {
		return identificacaoProfissao;
	}

	public void setIdentificacaoProfissao(Long identificacaoProfissao) {
		this.identificacaoProfissao = identificacaoProfissao;
	}

	public Long getIdentificacaoEscolaridade() {
		return identificacaoEscolaridade;
	}

	public void setIdentificacaoEscolaridade(Long identificacaoEscolaridade) {
		this.identificacaoEscolaridade = identificacaoEscolaridade;
	}
	
	

}
