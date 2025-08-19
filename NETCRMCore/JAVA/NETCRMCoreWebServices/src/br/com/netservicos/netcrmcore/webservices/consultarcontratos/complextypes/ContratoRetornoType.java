package br.com.netservicos.netcrmcore.webservices.consultarcontratos.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ContratoRetornoType implements BaseComplexType {

	private static final long serialVersionUID = -2666878924314523941L;

	public ContratoRetornoType() {
		super();
	}
	
	public ContratoRetornoType(String codigoOperadora, String codigoStatus,
			String descricaoStatus, String codigoHP, String codigoImovel, String cidadeContrato,
			String idTipoContrato, String descricaoTipoContrato,
			String descricaoModalidade, String numeroContrato,
			String codigoAssinante, String nomeTitular) {
		
		this.codigoOperadora = codigoOperadora;
		this.codigoStatus = codigoStatus;
		this.descricaoStatus = descricaoStatus;
		this.codigoHP = codigoHP;
		this.codigoImovel = codigoImovel;
		this.cidadeContrato = cidadeContrato;
		this.idTipoContrato = idTipoContrato;
		this.descricaoTipoContrato = descricaoTipoContrato;
		this.descricaoModalidade = descricaoModalidade;
		this.numeroContrato = numeroContrato;
		this.codigoAssinante = codigoAssinante;
		this.nomeTitular = nomeTitular;
	}
	private String codigoOperadora;
    private String codigoStatus;
    private String descricaoStatus;
    private String codigoHP;
    private String codigoImovel;
    private String cidadeContrato;
    private String idTipoContrato;
    private String descricaoTipoContrato;
    private String descricaoModalidade;
    private String numeroContrato;
    private String codigoAssinante;
    private String nomeTitular;
    
	/**
	 * @return the codigoOperadora
	 */
	public String getCodigoOperadora() {
		return codigoOperadora;
	}
	/**
	 * @param codigoOperadora the codigoOperadora to set
	 */
	public void setCodigoOperadora(String codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
	}
	/**
	 * @return the codigoStatus
	 */
	public String getCodigoStatus() {
		return codigoStatus;
	}
	/**
	 * @param codigoStatus the codigoStatus to set
	 */
	public void setCodigoStatus(String codigoStatus) {
		this.codigoStatus = codigoStatus;
	}
	/**
	 * @return the descricaoStatus
	 */
	public String getDescricaoStatus() {
		return descricaoStatus;
	}
	/**
	 * @param descricaoStatus the descricaoStatus to set
	 */
	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}
	/**
	 * @return the codigoHP
	 */
	public String getCodigoHP() {
		return codigoHP;
	}
	/**
	 * @param codigoHP the codigoHP to set
	 */
	public void setCodigoHP(String codigoHP) {
		this.codigoHP = codigoHP;
	}
	
	/**
	 * @return the codigoImovel
	 */
	public String getCodigoImovel() {
		return codigoImovel;
	}

	/**
	 * @param codigoImovel the codigoImovel to set
	 */
	public void setCodigoImovel(String codigoImovel) {
		this.codigoImovel = codigoImovel;
	}

	/**
	 * @return the cidadeContrato
	 */
	public String getCidadeContrato() {
		return cidadeContrato;
	}
	/**
	 * @param cidadeContrato the cidadeContrato to set
	 */
	public void setCidadeContrato(String cidadeContrato) {
		this.cidadeContrato = cidadeContrato;
	}
	/**
	 * @return the idTipoContrato
	 */
	public String getIdTipoContrato() {
		return idTipoContrato;
	}
	/**
	 * @param idTipoContrato the idTipoContrato to set
	 */
	public void setIdTipoContrato(String idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}
	/**
	 * @return the descricaoTipoContrato
	 */
	public String getDescricaoTipoContrato() {
		return descricaoTipoContrato;
	}
	/**
	 * @param descricaoTipoContrato the descricaoTipoContrato to set
	 */
	public void setDescricaoTipoContrato(String descricaoTipoContrato) {
		this.descricaoTipoContrato = descricaoTipoContrato;
	}
	/**
	 * @return the descricaoModalidade
	 */
	public String getDescricaoModalidade() {
		return descricaoModalidade;
	}
	/**
	 * @param descricaoModalidade the descricaoModalidade to set
	 */
	public void setDescricaoModalidade(String descricaoModalidade) {
		this.descricaoModalidade = descricaoModalidade;
	}
	/**
	 * @return the numeroContrato
	 */
	public String getNumeroContrato() {
		return numeroContrato;
	}
	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	/**
	 * @return the codigoAssinante
	 */
	public String getCodigoAssinante() {
		return codigoAssinante;
	}
	/**
	 * @param codigoAssinante the codigoAssinante to set
	 */
	public void setCodigoAssinante(String codigoAssinante) {
		this.codigoAssinante = codigoAssinante;
	}
	/**
	 * @return the nomeTitular
	 */
	public String getNomeTitular() {
		return nomeTitular;
	}
	/**
	 * @param nomeTitular the nomeTitular to set
	 */
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
    
    
}
