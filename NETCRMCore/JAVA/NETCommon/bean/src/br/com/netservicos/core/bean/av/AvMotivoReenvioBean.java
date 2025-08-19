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

import java.util.Date;

import br.com.netservicos.core.bean.BeanConstants;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela AV_MOTIVO_REENVIO.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 * @hibernate.class table = "av_motivo_reenvio" dynamic-insert = "true"
 *                  dynamic-update = "true"
 * 
 */
public class AvMotivoReenvioBean extends DomainBean {

	/**
	 * Identificador do motivo do reenvio.
	 */
	private static final String ID_MOTIVO_REENVIO = "idMotivoReenvio";

	/**
	 * long.
	 */
	private static final long serialVersionUID = -2468133032904242952L;

	/**
	 * ID_MOTIVO_REENVIO NUMBER(10) N. Identificador o motivo reenvio.
	 */
	private Long idMotivoReenvio;
	
	/**
	 * DS_MOTIVO_REENVIO VARCHAR2(100) N. Descricao do motivo reenvio.
	 */
	private String dsMotivoReenvio;
	
	/**
	 * FC_ATIVO CHAR(1) N. Flag para motivo ativo.
	 */
	private String fcAtivo;
	
	/**
	 * DH_ULTIMA_ATUALIZACAO DATE N. Data da ultima atualizacao.
	 */
	private Date dhUltimaAtualizacao;

	/**
	 * Construtor Padrao
	 */
	public AvMotivoReenvioBean() {
		super(ID_MOTIVO_REENVIO);
	}

	/**
	 * Construtor com identificador do motivo.
	 * 
	 * @param pIdMotivoReenvio
	 */
	public AvMotivoReenvioBean(final Long pIdMotivoReenvio) {
		this();
		this.idMotivoReenvio = pIdMotivoReenvio;
	}

	/**
	 * Recupera o identificador do reenvio.
	 * 
	 * @return the idMotivoReenvio
	 * @hibernate.id column="id_motivo_reenvio" generator-class="sequence"
	 * @hibernate.generator-param name="sequence" value="SQ_MOTIVO_REENVIO"
	 */
	public final Long getIdMotivoReenvio() {
		return this.idMotivoReenvio;
	}

	/**
	 * Recupera a descricao do reenvio.
	 * 
	 * @return the dsMotivoReenvio
	 * @hibernate.property column = "DS_MOTIVO_REENVIO"
	 */
	public final String getDsMotivoReenvio() {
		return this.dsMotivoReenvio;
	}

	/**
	 * Recupera a flag se o motivo esta ativo.
	 * 
	 * @return the fcAtivo
	 * @hibernate.property column = "FC_ATIVO"
	 */
	public final String getFcAtivo() {
		return this.fcAtivo;
	}

	/**
	 * Recupera a data da ultima atualizacao.
	 * 
	 * @return the dhUltimaAtualizacao
	 * @hibernate.property column = "DH_ULTIMA_ATUALIZACAO"
	 */
	public final Date getDhUltimaAtualizacao() {
		return this.dhUltimaAtualizacao;
	}

	/**
	 * @param pIdMotivoReenvio
	 *            the idMotivoReenvio to set
	 */
	public final void setIdMotivoReenvio(final Long pIdMotivoReenvio) {
		this.idMotivoReenvio = pIdMotivoReenvio;
	}

	/**
	 * @param pDsMotivoReenvio
	 *            the dsMotivoReenvio to set
	 */
	public final void setDsMotivoReenvio(final String pDsMotivoReenvio) {
		this.dsMotivoReenvio = pDsMotivoReenvio;
	}

	/**
	 * @param pFcAtivo
	 *            the fcAtivo to set
	 */
	public final void setFcAtivo(final String pFcAtivo) {
		this.fcAtivo = pFcAtivo;
	}

	/**
	 * @param pDhUltimaAtualizacao
	 *            the dhUltimaAtualizacao to set
	 */
	public final void setDhUltimaAtualizacao(final Date pDhUltimaAtualizacao) {
		this.dhUltimaAtualizacao = pDhUltimaAtualizacao;
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
		if (this.idMotivoReenvio != null) {
			result = prime * result + this.idMotivoReenvio.hashCode();
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
		if (obj instanceof AvMotivoReenvioBean) {
			final AvMotivoReenvioBean comp = (AvMotivoReenvioBean) obj;
			test = getIdMotivoReenvio().equals(comp.getIdMotivoReenvio());
		}
		return test;
	}

}
