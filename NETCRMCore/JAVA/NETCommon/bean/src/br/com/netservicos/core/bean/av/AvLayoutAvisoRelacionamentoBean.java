/*
 * Created on 31/03/2011
 * Project : NETGESCOMCommon
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.av;

import br.com.netservicos.core.bean.BeanConstants;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela LAYOUT_AVISO_RELACIONAMENTO.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 * @hibernate.class table = "av_layout_aviso_relacionamento" dynamic-insert =
 *                  "true" dynamic-update = "true"
 * 
 */
public class AvLayoutAvisoRelacionamentoBean extends DomainBean {

	/**
	 * long
	 */
	private static final long serialVersionUID = 8065653355273611947L;

	/**
	 * Entidade com as chaves primárias da tabela AV_LAYOUT_AVISO_RELACIONAMENTO.
	 */
	private AvLayoutAvisoRelacionamentoKey compositeKey;

	/**
	 * FC_TIPO_PESSOA CHAR(1) N. Identifica se o layout deve ser utilizado para
	 * gerar avisos de relacionamento de clientes do tipo pessoa física ou
	 * jurídica (F / J).
	 */
	private String fcTipoPessoa;

	/**
	 * FC_TIPO_CLIENTE CHAR(1) N. Identifica se o layout deve ser utilizado para
	 * gerar avisos de relacionamento de clientes prospect ou base (P / B).
	 */
	private String fcTipoCliente;

	/**
	 * NM_ARQUIVO VARCHAR2(50) N. Nome do arquivo do lay out da carta no JASPER.
	 */
	private String nmArquivo;

	/**
	 * Construtor Padrao.
	 */
	public AvLayoutAvisoRelacionamentoBean() {
		super("compositeKey");
	}

	/**
	 * Recupera as chaves compostas da entidade AvLayoutAvisoRelacionamentoKey.
	 * 
	 * @return the compositeKey
	 * @hibernate.id type = "composite"
	 */
	public AvLayoutAvisoRelacionamentoKey getCompositeKey() {
		return this.compositeKey;
	}

	/**
	 * Recupera o tipo de pessoa.
	 * 
	 * @return the fcTipoPessoa
	 * @hibernate.property column = "FC_TIPO_PESSOA"
	 */
	public String getFcTipoPessoa() {
		return this.fcTipoPessoa;
	}

	/**
	 * Recupera o tipo de cliente.
	 * 
	 * @return the fcTipoCliente
	 * @hibernate.property column = "FC_TIPO_CLIENTE"
	 */
	public String getFcTipoCliente() {
		return this.fcTipoCliente;
	}

	/**
	 * Recupera o nome do arquivo do Report.
	 * 
	 * @return the nmArquivo
	 * @hibernate.property column = "NM_ARQUIVO"
	 */
	public String getNmArquivo() {
		return this.nmArquivo;
	}

	/**
	 * @param pFcTipoPessoa
	 *            the fcTipoPessoa to set
	 */
	public void setFcTipoPessoa(final String pFcTipoPessoa) {
		this.fcTipoPessoa = pFcTipoPessoa;
	}

	/**
	 * @param pFcTipoCliente
	 *            the fcTipoCliente to set
	 */
	public void setFcTipoCliente(final String pFcTipoCliente) {
		this.fcTipoCliente = pFcTipoCliente;
	}

	/**
	 * @param pNmArquivo
	 *            the nmArquivo to set
	 */
	public void setNmArquivo(final String pNmArquivo) {
		this.nmArquivo = pNmArquivo;
	}

	/**
	 * @param pCompositeKey
	 *            the compositeKey to set
	 */
	public void setCompositeKey(
			final AvLayoutAvisoRelacionamentoKey pCompositeKey) {
		this.compositeKey = pCompositeKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = BeanConstants.HASH_PRIME;
		int result = 1;
		result = prime * result;
		if (this.compositeKey != null) {
			result = prime * result + this.compositeKey.hashCode();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		boolean test = super.equals(obj);
		if (obj instanceof AvLayoutAvisoRelacionamentoBean) {
			final AvLayoutAvisoRelacionamentoBean comp = (AvLayoutAvisoRelacionamentoBean) obj;
			test = getCompositeKey().equals(comp.getCompositeKey());
		}
		return test;
	}

}
