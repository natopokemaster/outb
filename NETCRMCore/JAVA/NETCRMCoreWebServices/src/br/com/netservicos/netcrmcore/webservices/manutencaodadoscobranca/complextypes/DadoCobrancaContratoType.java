package br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadoCobrancaContratoType implements BaseComplexType {

	private static final long serialVersionUID = 590661927417675414L;

	public DadoCobrancaContratoType(){
		super();
	}

	public DadoCobrancaContratoType(Long numeroContrato, String identificacaoCidade, Boolean indicadorCoboletamento, Long idTipoPostagem, String nomeContato, String telefoneContato, String observacao){
		this.numeroContrato = numeroContrato;
		this.identificacaoCidade = identificacaoCidade;
		this.indicadorCoboletamento = indicadorCoboletamento;
		this.idTipoPostagem = idTipoPostagem;
		this.nomeContato = nomeContato;
		this.telefoneContato = telefoneContato;
		this.observacao = observacao;
	}

	private Long numeroContrato;
	private String identificacaoCidade;
	private Boolean indicadorCoboletamento;
	private Long idTipoPostagem;
	private String nomeContato;
	private String telefoneContato;
	private String observacao;

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
	public Boolean getIndicadorCoboletamento() {
		return indicadorCoboletamento;
	}
	public void setIndicadorCoboletamento(Boolean indicadorCoboletamento) {
		this.indicadorCoboletamento = indicadorCoboletamento;
	}
	public Long getIdTipoPostagem() {
		return idTipoPostagem;
	}
	public void setIdTipoPostagem(Long idTipoPostagem) {
		this.idTipoPostagem = idTipoPostagem;
	}
	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	public String getTelefoneContato() {
		return telefoneContato;
	}
	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
