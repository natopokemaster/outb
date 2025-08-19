package br.com.netservicos.netcrmcore.webservices.manifestacaoombudsman.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ManifestacaoClienteType implements BaseComplexType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4272930613410280607L;

	public ManifestacaoClienteType(){
		super();
	}

	public ManifestacaoClienteType(String descricaoAssunto, String bairro, String canal, String cep, String cidade, String cnpj, String complemento, String cpf, String ddd, String descricao, String email, String endereco, String nome, String numeroEndereco, String telefoneContato, String tipoPessoa, String uf){
		this.descricaoAssunto = descricaoAssunto;
		this.bairro = bairro;
		this.canal = canal;
		this.cep = cep;
		this.cidade = cidade;
		this.cnpj = cnpj;
		this.complemento = complemento;
		this.cpf = cpf;
		this.ddd = ddd;
		this.descricao = descricao;
		this.email = email;
		this.endereco = endereco;
		this.nome = nome;
		this.numeroEndereco = numeroEndereco;
		this.telefoneContato = telefoneContato;
		this.tipoPessoa = tipoPessoa;
		this.uf = uf;
	}

	private String descricaoAssunto;
	private String bairro;
	private String canal;
	private String cep;
	private String cidade;
	private String cnpj;
	private String complemento;
	private String cpf;
	private String ddd;
	private String descricao;
	private String email;
	private String endereco;
	private String nome;
	private String numeroEndereco;
	private String telefoneContato;
	private String tipoPessoa;
	private String uf;

	public String getDescricaoAssunto() {
		return descricaoAssunto;
	}

	public void setDescricaoAssunto(String descricaoAssunto) {
		this.descricaoAssunto = descricaoAssunto;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	
}
