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
 * @since 22/09/2010
 * @version 1.0
 */
public class DadosEnderecoCobrancaType implements BaseComplexType {

	private static final long serialVersionUID = 4272930614587450413L;

	private IdentificacaoOperadoraType cidadeOperadora;
	private Long idProspect;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String referencia;
    
	/**
	 * Construtor Padrão.
	 */
	public DadosEnderecoCobrancaType(){
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
	 * @return the idProspect
	 */
	public Long getIdProspect() {
		return idProspect;
	}

	/**
	 * @param idProspect the idProspect to set
	 */
	public void setIdProspect(Long idProspect) {
		this.idProspect = idProspect;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
}
