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
 * Classe Bean que representa a tabela AV_REENVIO_AVISO.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 * @hibernate.class table = "av_reenvio_aviso" dynamic-insert = "true"
 *                  dynamic-update = "true"
 * 
 */
public class AvReenvioAvisoBean extends DomainBean {

	
	/**
	 * Identificador do reenvio do aviso.
	 */
	private static final String ID_REENVIO_AVISO = "idReenvioAviso";

	/**
	 * long.
	 */
	private static final long serialVersionUID = -5497278538641883395L;

	/**
	 * ID_REENVIO_AVISO NUMBER(10) N. Identificador do pedido de reenvio do
	 * aviso de relacionamento.
	 */
	private Long idReenvioAviso;

	/**
	 * ID_AVISO_RELACIONAMENTO NUMBER(10) N. Identificador do aviso de
	 * relacionamento.
	 */
	private AvAvisoRelacionamentoBean avisoRelacionamento;

	/**
	 * ID_MOTIVO_REENVIO NUMBER(10) N. Identificador do motivo do reenvio.
	 */
	private AvMotivoReenvioBean motivoReenvio;

	/**
	 * DH_SOLICITACAO_REENVIO DATE N. Data e hora da solicitação do reenvio do
	 * aviso de relacionamento.
	 */
	private Date dhSolicitacaoReenvio;

	/**
	 * CD_USUARIO VARCHAR2(30) N. Login do usuário que solicitou o reenvio do
	 * aviso de relacionamento.
	 */
	private String cdUsuario;

	/**
	 * Construtor Padrao.
	 */
	public AvReenvioAvisoBean() {
		super(ID_REENVIO_AVISO);
	}

	/**
	 * Contrutor padrao com identificador do reenvio.
	 * 
	 * @param pIdReenvioAviso
	 */
	public AvReenvioAvisoBean(final Long pIdReenvioAviso) {
		this();
		this.idReenvioAviso = pIdReenvioAviso;
	}

	/**
	 * Recupera o identificador do reenvio.
	 * 
	 * @return the idReenvioAviso
	 * @hibernate.id column="id_reenvio_aviso" generator-class="sequence"
	 * @hibernate.generator-param name="sequence" value="SQ_REENVIO_AVISO"
	 * 
	 */
	public final Long getIdReenvioAviso() {
		return this.idReenvioAviso;
	}

	/**
	 * Recupera o aviso.
	 * 
	 * @return the avisoRelacionamento
	 * @hibernate.many-to-one 
	 *                        class="br.com.netservicos.core.bean.av.AvAvisoRelacionamentoBean"
	 *                        cascade="none" not-null="false"
	 * @hibernate.column name="id_aviso_relacionamento"
	 */
	public final AvAvisoRelacionamentoBean getAvisoRelacionamento() {
		return this.avisoRelacionamento;
	}

	/**
	 * Recupera o motivo de reenvio.
	 * 
	 * @return the motivoReenvio
	 * @hibernate.many-to-one 
	 *                        class="br.com.netservicos.core.bean.av.AvMotivoReenvioBean"
	 *                        cascade="none" not-null="false"
	 * @hibernate.column name="id_motivo_reenvio"
	 */
	public final AvMotivoReenvioBean getMotivoReenvio() {
		return this.motivoReenvio;
	}

	/**
	 * Recupera a data de solicitacao reenvio.
	 * 
	 * @return the dhSolicitacaoReenvio
	 * @hibernate.property column="dh_solicitacao_reenvio"
	 */
	public final Date getDhSolicitacaoReenvio() {
		return this.dhSolicitacaoReenvio;
	}

	/**
	 * Recupera o codigo do usuario.
	 * 
	 * @return the cdUsuario
	 * @hibernate.property column="cd_usuario"
	 */
	public final String getCdUsuario() {
		return this.cdUsuario;
	}

	/**
	 * @param pIdReenvioAviso
	 *            the idReenvioAviso to set
	 */
	public final void setIdReenvioAviso(final Long pIdReenvioAviso) {
		this.idReenvioAviso = pIdReenvioAviso;
	}

	/**
	 * @param pAvisoRel
	 *            the avisoRelacionamento to set
	 */
	public final void setAvisoRelacionamento(
			final AvAvisoRelacionamentoBean pAvisoRel) {
		this.avisoRelacionamento = pAvisoRel;
	}

	/**
	 * @param pMotivoReenvio
	 *            the motivoReenvio to set
	 */
	public final void setMotivoReenvio(final AvMotivoReenvioBean pMotivoReenvio) {
		this.motivoReenvio = pMotivoReenvio;
	}

	/**
	 * @param pDhSolicReenvio
	 *            the dhSolicitacaoReenvio to set
	 */
	public final void setDhSolicitacaoReenvio(final Date pDhSolicReenvio) {
		this.dhSolicitacaoReenvio = pDhSolicReenvio;
	}

	/**
	 * @param pCdUsuario
	 *            the cdUsuario to set
	 */
	public final void setCdUsuario(final String pCdUsuario) {
		this.cdUsuario = pCdUsuario;
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
		if (this.idReenvioAviso != null) {
			result = prime * result + this.idReenvioAviso.hashCode();
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
		if (obj instanceof AvReenvioAvisoBean) {
			final AvReenvioAvisoBean comp = (AvReenvioAvisoBean) obj;
			test = getIdReenvioAviso().equals(comp.getIdReenvioAviso());
		}
		return test;
	}

}
