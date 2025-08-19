/*
 * Created on 20/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Type que representa os dados para alteração de Cobrança.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 */
public class DadosCobrancaPropostaType implements BaseComplexType {

	private static final long serialVersionUID = 4272930613410280413L;

	private IdentificacaoOperadoraType cidadeOperadora;	

	private Long idProposta;
	private Integer idTipoCobranca;
	private Integer diaVencimento;
	private Boolean isCheckedFaturaEmail;
	
	private String idProspect;
    private String agencia;
    private String conta;
    private String digitoConta;
    private String idBanco;
    private String titular;

	/**
	 * Construtor Padrão.
	 */
	public DadosCobrancaPropostaType(){
		super();
	}
	
	/**
	 * @return the cidadeOperadora
	 */
	public IdentificacaoOperadoraType getCidadeOperadora() {
		return cidadeOperadora;
	}

	/**
	 * @param cidadeOperadora the cidadeOperadora to set
	 */
	public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
		this.cidadeOperadora = cidadeOperadora;
	}

	/**
	 * @return the idTipoCobranca
	 */
	public Integer getIdTipoCobranca() {
		return idTipoCobranca;
	}

	/**
	 * @param idTipoCobranca the idTipoCobranca to set
	 */
	public void setIdTipoCobranca(Integer idTipoCobranca) {
		this.idTipoCobranca = idTipoCobranca;
	}

	/**
	 * @return the idDiaVencimento
	 */
	public Integer getDiaVencimento() {
		return diaVencimento;
	}

	/**
	 * @param idDiaVencimento the idDiaVencimento to set
	 */
	public void setDiaVencimento(Integer diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	/**
	 * @return the isCheckedFaturaEmail
	 */
	public Boolean getIsCheckedFaturaEmail() {
		return isCheckedFaturaEmail;
	}

	/**
	 * @param isCheckedFaturaEmail the isCheckedFaturaEmail to set
	 */
	public void setIsCheckedFaturaEmail(Boolean isCheckedFaturaEmail) {
		this.isCheckedFaturaEmail = isCheckedFaturaEmail;
	}

	/**
	 * @return the idProposta
	 */
	public Long getIdProposta() {
		return idProposta;
	}

	/**
	 * @param idProposta the idProposta to set
	 */
	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}

	/**
	 * @return the idProspect
	 */
	public String getIdProspect() {
		return idProspect;
	}

	/**
	 * @param idProspect the idProspect to set
	 */
	public void setIdProspect(String idProspect) {
		this.idProspect = idProspect;
	}

	/**
	 * @return the agencia
	 */
	public String getAgencia() {
		return agencia;
	}

	/**
	 * @param agencia the agencia to set
	 */
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	/**
	 * @return the conta
	 */
	public String getConta() {
		return conta;
	}

	/**
	 * @param conta the conta to set
	 */
	public void setConta(String conta) {
		this.conta = conta;
	}

	/**
	 * @return the digitoConta
	 */
	public String getDigitoConta() {
		return digitoConta;
	}

	/**
	 * @param digitoConta the digitoConta to set
	 */
	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
	}

	/**
	 * @return the idBanco
	 */
	public String getIdBanco() {
		return idBanco;
	}

	/**
	 * @param idBanco the idBanco to set
	 */
	public void setIdBanco(String idBanco) {
		this.idBanco = idBanco;
	}

	/**
	 * @return the titular
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * @param titular the titular to set
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}
}
