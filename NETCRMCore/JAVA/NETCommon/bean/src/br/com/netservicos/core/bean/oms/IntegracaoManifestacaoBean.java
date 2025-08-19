/*
 * Created on 08/01/2010
 * Project : NETOMSCommon
 *
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.oms;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela netoms.integracao_manifestacao.
 * </p>
 * <b> Issues: <br>
 * 
 * </b>
 * 
 * @author jorge.silva
 * @since 10/04/2010
 * @version 1.0
 * @hibernate.class table = "INTEGRACAO_MANIFESTACAO" schema = "NETOMS"
 *                  dynamic-insert = "true" dynamic-update = "true" lazy="true"
 * 
 */
public class IntegracaoManifestacaoBean extends DomainBean {
	
	/**
	 * long.
	 */
	private static final long serialVersionUID = 156464898L;
	
	private static final String PRIMARY_KEY = "idIntegManif";
	private Long idIntegManif;
	private CanalAtendimentoBean canalAtendimentoBean;
	private Date dtManifestacao;
	private Date hrManifestacao;
	private Date dhUltAtualiz;
	private String tpPessoa;
	private String nrDocumento;
	private String nmCliente;
	private String nrTelCliente;
	private String nmLogradouro;
	private String nrLogradouro;
	private String dsComplemento;
	private String nrCep;
	private String nmBairro;
	private String nmCidade;
	private String sgUf;
	private String dsEmail;
	private String cdProtocolo;
	private String dsAssunto;
	private String dsManifestacao;
	private String cdCidadeOperadora;
	private Long cdContrato;
	private String cdOperadora;
	private String cdUsuario;
	private String dsMotivo;
	private String stIntegracao;
	
	
	/**
	 * Construtor Padrão.
	 */
	public IntegracaoManifestacaoBean() {
		super(PRIMARY_KEY);
	}

	/**
	 * @return the idIntegManif
	 * @hibernate.id column = "ID_INTEGRACAO_MANIFESTACAO" generator-class =
	 *               "sequence"
	 * @hibernate.generator-param name = "sequence" value =
	 *                            "NETOMS.SQ_INTEGRACAO_MANIFESTACAO"
	 */
	public Long getIdIntegManif() {
		return this.idIntegManif;
	}

	/**
	 * @param idIntegManif
	 *            the idIntegManif to set
	 */
	public void setIdIntegManif(Long idIntegManif) {
		this.idIntegManif = idIntegManif;
	}

	/**
	 * @return the canalAtendimentoBean
	 * @hibernate.many-to-one 
	 *                        class="br.com.netservicos.core.bean.oms.CanalAtendimentoBean"
	 *                        column="ID_CANAL_ATENDIMENTO" lazy="false"
	 */
	public CanalAtendimentoBean getCanalAtendimentoBean() {
		return this.canalAtendimentoBean;
	}

	/**
	 * @param canalAtendP
	 *            the canalAtend to set
	 */
	public void setCanalAtendimentoBean(CanalAtendimentoBean canalAtendimentoBean) {
		this.canalAtendimentoBean = canalAtendimentoBean;
	}

	/**
	 * @return the dtManifestacao
	 * @hibernate.property column="DT_MANIFESTACAO"
	 */
	public Date getDtManifestacao() {
		return this.dtManifestacao;
	}

	/**
	 * @param dtManifestacao
	 *            the dtManifestacao to set
	 */
	public void setDtManifestacao(Date dtManifestacao) {
		this.dtManifestacao = dtManifestacao;
	}

	/**
	 * @return the hrManifestacao
	 * @hibernate.property column="HR_MANIFESTACAO"
	 */
	public Date getHrManifestacao() {
		return this.hrManifestacao;
	}

	/**
	 * @param hrManifestacao
	 *            the hrManifestacao to set
	 */
	public void setHrManifestacao(Date hrManifestacao) {
		this.hrManifestacao = hrManifestacao;
	}

	/**
	 * @return the tpPessoa
	 * @hibernate.property column="TP_PESSOA"
	 */
	public String getTpPessoa() {
		return this.tpPessoa;
	}

	/**
	 * @param tpPessoa
	 *            the tpPessoa to set
	 */
	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	/**
	 * @return the nrDocumento
	 * @hibernate.property column="NR_DOCUMENTO"
	 */
	public String getNrDocumento() {
		return this.nrDocumento;
	}

	/**
	 * @param nrDocumento
	 *            the nrDocumento to set
	 */
	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}

	/**
	 * @param nmClienteP
	 *            the nmCliente to set
	 */
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	/**
	 * @return the nmCliente
	 * @hibernate.property column="NM_CLIENTE"
	 */
	public String getNmCliente() {
		return this.nmCliente;
	}

	/**
	 * @param nrTelClienteP
	 *            the nrTelCliente to set
	 */
	public void setNrTelCliente(String nrTelCliente) {
		this.nrTelCliente = nrTelCliente;
	}

	/**
	 * @return the nrTelCliente
	 * @hibernate.property column="NR_TELEFONE_CLIENTE"
	 */
	public String getNrTelCliente() {
		return this.nrTelCliente;
	}
	
	/**
	 * @return the nmLogradouro
	 * @hibernate.property column="NM_LOGRADOURO"
	 */
	public String getNmLogradouro() {
		return this.nmLogradouro;
	}

	/**
	 * @param nmLogradouro
	 *            the nmLogradouro to set
	 */
	public void setNmLogradouro(String nmLogradouro) {
		this.nmLogradouro = nmLogradouro;
	}
	
	/**
	 * @return the nrLogradouro
	 * @hibernate.property column="NR_LOGRADOURO"
	 */
	public String getNrLogradouro() {
		return this.nrLogradouro;
	}

	/**
	 * @param nrLogradouro
	 *            the nrLogradouro to set
	 */
	public void setNrLogradouro(String nrLogradouro) {
		this.nrLogradouro = nrLogradouro;
	}

	/**
	 * @return the dsComplemento
	 * @hibernate.property column="DS_COMPLEMENTO"
	 */
	public String getDsComplemento() {
		return this.dsComplemento;
	}

	/**
	 * @param dsComplementoP
	 *            the dsComplemento to set
	 */
	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	/**
	 * @return the nrCep
	 * @hibernate.property column="NR_CEP"
	 */
	public String getNrCep() {
		return this.nrCep;
	}

	/**
	 * @param nrCep
	 *            the nrCep to set
	 */
	public void setNrCep(String nrCep) {
		this.nrCep = nrCep;
	}

	/**
	 * @return the nmBairro
	 * @hibernate.property column="NM_BAIRRO"
	 */
	public String getNmBairro() {
		return this.nmBairro;
	}

	/**
	 * @param nmBairro
	 *            the nmBairro to set
	 */
	public void setNmBairro(String nmBairro) {
		this.nmBairro = nmBairro;
	}

	/**
	 * @return the nmCidade
	 * @hibernate.property column="NM_CIDADE"
	 */
	public String getNmCidade() {
		return this.nmCidade;
	}

	/**
	 * @param nmCidade
	 *            the nmCidade to set
	 */
	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}

	/**
	 * @return the sgUf
	 * @hibernate.property column="SG_UF"
	 */
	public String getSgUf() {
		return this.sgUf;
	}

	/**
	 * @param sgUf
	 *            the sgUf to set
	 */
	public void setSgUf(String sgUf) {
		this.sgUf = sgUf;
	}

	/**
	 * @return the dsEmail
	 * @hibernate.property column="DS_EMAIL"
	 */
	public String getDsEmail() {
		return this.dsEmail;
	}

	/**
	 * @param dsEmailP
	 *            the dsEmail to set
	 */
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	/**
	 * @return the cdProtocolo
	 * @hibernate.property column="CD_PROTOCOLO"
	 */
	public String getCdProtocolo() {
		return this.cdProtocolo;
	}

	/**
	 * @param cdProtocolo
	 *            the cdProtocolo to set
	 */
	public void setCdProtocolo(String cdProtocolo) {
		this.cdProtocolo = cdProtocolo;
	}

	/**
	 * @return the dsAssunto
	 * @hibernate.property column="DS_ASSUNTO"
	 */
	public String getDsAssunto() {
		return this.dsAssunto;
	}

	/**
	 * @param dsAssunto
	 *            the dsAssunto to set
	 */
	public void setDsAssunto(String dsAssunto) {
		this.dsAssunto = dsAssunto;
	}

	/**
	 * @return the dsManifestacao
	 * @hibernate.property column="DS_MANIFESTACAO"
	 */
	public String getDsManifestacao() {
		return this.dsManifestacao;
	}

	/**
	 * @param dsManifestacao
	 *            the dsManifestacao to set
	 */
	public void setDsManifestacao(String dsManifestacao) {
		this.dsManifestacao = dsManifestacao;
	}
	
	/**
	 * @return the cdCidadeOperadora
	 * @hibernate.property column="CD_CIDADE_OPERADORA"
	 */
	public String getCdCidadeOperadora() {
		return this.cdCidadeOperadora;
	}

	/**
	 * @param cdCidadeOper
	 *            the cdCidadeOperadora to set
	 */
	public void setCdCidadeOperadora(String cdCidadeOper) {
		this.cdCidadeOperadora = cdCidadeOper;
	}

	/**
	 * @return the cdContrato
	 * @hibernate.property column="CD_CONTRATO"
	 */
	public Long getCdContrato() {
		return this.cdContrato;
	}

	/**
	 * @param cdContrato
	 *            the cdContrato to set
	 */
	public void setCdContrato(Long cdContrato) {
		this.cdContrato = cdContrato;
	}

	/**
	 * @return the cdOperadora
	 * @hibernate.property column="CD_OPERADORA"
	 */
	public String getCdOperadora() {
		return this.cdOperadora;
	}

	/**
	 * @param cdOperadora
	 *            the cdOperadora to set
	 */
	public void setCdOperadora(String cdOperadora) {
		this.cdOperadora = cdOperadora;
	}

	/**
	 * @return the cdUsuario
	 * @hibernate.property column="CD_USUARIO"
	 */
	public String getCdUsuario() {
		return this.cdUsuario;
	}

	/**
	 * @param cdUsuario
	 *            the cdUsuario to set
	 */
	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	/**
	 * @return the dsMotivo
	 * @hibernate.property column="DS_MOTIVO"
	 */
	public String getDsMotivo() {
		return this.dsMotivo;
	}

	/**
	 * @param dsMotivo
	 *            the dsMotivo to set
	 */
	public void setDsMotivo(String dsMotivo) {
		this.dsMotivo = dsMotivo;
	}

	/**
	 * @param dhUltAtualiz
	 *            the dhUltAtualiz to set
	 */
	public void setDhUltAtualiz(Date dhUltAtualiz) {
		this.dhUltAtualiz = dhUltAtualiz;
	}

	/**
	 * @return the dhUltAtualiz
	 * @hibernate.property column="DH_ULTIMA_ATUALIZACAO"
	 */
	public Date getDhUltAtualiz() {
		return this.dhUltAtualiz;
	}
	
	/**
	 * @return the stIntegracao
	 * @hibernate.property column="ST_INTEGRACAO"
	 */
	public String getStIntegracao() {
		return stIntegracao;
	}

	public void setStIntegracao(String stIntegracao) {
		this.stIntegracao = stIntegracao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int value = this.idIntegManif == null ? 0 : this.idIntegManif
				.hashCode();
		return value ^ (value >>> 31);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object key) {
		boolean test = super.equals(key);
		if (key instanceof IntegracaoManifestacaoBean) {
			final IntegracaoManifestacaoBean comp = (IntegracaoManifestacaoBean) key;
			test = this.getIdIntegManif().equals(comp.getIdIntegManif());
		}
		return test;
	}

}
