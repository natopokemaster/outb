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
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela AV_AVISO_RELACIONAMENTO.
 * </P>
 * <B> Issues : <BR>
 *
 * @since 31/03/2011
 * @hibernate.class table = "av_aviso_relacionamento" dynamic-insert = "true"
 *                  dynamic-update = "true"
 *
 */
public class AvAvisoRelacionamentoBean extends DomainBean {

	/**
	 * long.
	 */
	private static final long serialVersionUID = -5362413080033187057L;
	
	/**
	 * String. Chave primária da tabela AV_AVISO_RELACIONAMENTO.
	 */
	private static final String PRIMARY_KEY = "idAvisoRelacionamento";

	/**
	 * ID_AVISO_RELACIONAMENTO NUMBER(10) N. Identificador do aviso de
	 * relacionamento.
	 */
	private Long idAvisoRelacionamento;

	/**
	 * SnContratoBean. Entidade que representa os dados do contrato.
	 */
	private SnContratoBean contrato;

	/**
	 * CID_CONTRATO VARCHAR2(6) N. Cidade operadora do contrato.
	 */
	private String cidContrato;

	/**
	 * NUM_CONTRATO NUMBER(9) N. Numero de contrato do cliente.
	 */
	private Long numContrato;

	/**
	 * DH_GERACAO DATE N. Data e hora de geração do aviso de relacionamento.
	 */
	private Date dhGeracao;

	/**
	 * XT_DETALHE_AVISO XMLTYPE N. Detalhes do aviso de relacionamento
	 */
	private String xtDetalheAviso;

	/**
	 * XT_LAYOUT_AVISO XMLTYPE N. Detalhes do layout aviso de relacionamento
	 */
	private String xtLayoutAviso;

	/**
	 * NR_HASH_CODE VARCHAR2(40) N. Hash Code com a identificação única para
	 * geração do aviso de relacionamento.
	 */
	private String nrHashCode;

	/**
	 * ID_STATUS_AVISO_RELACIONAMENTO NUMBER(10) N. Identificador do status de
	 * envio do aviso de relacionamento.
	 */
	private AvStatusAvisoRelacionamentoBean statusAviso;

	/**
	 * ID_TIPO_RELACIONAMENTO NUMBER(10) N. Identificador do tipo de relacionamento.
	 */
	private AvTipoRelacionamentoBean tipoRelacionamento;

	/**
	 * Construtor Padrao.
	 */
	public AvAvisoRelacionamentoBean() {
		super(PRIMARY_KEY);
	}

	/**
	 * Construtor com parâmetro do identificador do aviso.
	 * 
	 * @param pIdAvisoRel
	 */
	public AvAvisoRelacionamentoBean(final Long pIdAvisoRel) {
		this();
		this.idAvisoRelacionamento = pIdAvisoRel;
	}

	/**
	 * Recupera o identificador do aviso relacionamento.
	 * 
	 * @return the idAvisoRelacionamento
	 * @hibernate.id column="id_aviso_relacionamento" generator-class="sequence"
	 * @hibernate.generator-param name="sequence"
	 *                            value="SQ_AVISO_RELACIONAMENTO"
	 */
	public Long getIdAvisoRelacionamento() {
		return this.idAvisoRelacionamento;
	}

	/**
	 * @param pIdAvisoRel
	 *            the idAvisoRelacionamento to set
	 */
	public void setIdAvisoRelacionamento(final Long pIdAvisoRel) {
		this.idAvisoRelacionamento = pIdAvisoRel;
	}

	/**
	 * Recupera o a entidade SnContratoBean.
	 * 
	 * @return the contrato
	 */
	public SnContratoBean getContrato() {
		return this.contrato;
	}

	/**
	 * @param pContrato
	 *            the contrato to set
	 */
	public void setContrato(final SnContratoBean pContrato) {
		this.contrato = pContrato;
	}

	/**
	 * Recupera a data de geracao do recibo.
	 * 
	 * @return the dhGeracao
	 * @hibernate.property column = "dh_geracao"
	 */
	public Date getDhGeracao() {
		return this.dhGeracao;
	}

	/**
	 * @param pDhGeracao
	 *            the dhGeracao to set
	 */
	public void setDhGeracao(final Date pDhGeracao) {
		this.dhGeracao = pDhGeracao;
	}

	/**
	 * Recupera o detalhe do aviso.
	 * 
	 * @return the xtDetalheAviso
	 * @hibernate.property column="xt_detalhe_aviso" type="br.com.netservicos.gescom.util.bd.HibernateXMLType"
	 */
	public String getXtDetalheAviso() {
		return this.xtDetalheAviso;
	}

	/**
	 * @param pXtDetalheAviso
	 *            the xtDetalheAviso to set
	 */
	public void setXtDetalheAviso(final String pXtDetalheAviso) {
		this.xtDetalheAviso = pXtDetalheAviso;
	}

	/**
	 * Recupera o hashCode do arquivo.
	 * 
	 * @return the nrHashCode
	 * @hibernate.property column="nr_hash_code"
	 */
	public String getNrHashCode() {
		return this.nrHashCode;
	}

	/**
	 * @param pNrHashCode
	 *            the nrHashCode to set
	 */
	public void setNrHashCode(final String pNrHashCode) {
		this.nrHashCode = pNrHashCode;
	}

	/**
	 * Recupera o Status do aviso.
	 * 
	 * @return the statusAviso
	 * @hibernate.many-to-one class=
	 *                        "br.com.netservicos.core.bean.av.AvStatusAvisoRelacionamentoBean"
	 *                        cascade="none" not-null="false"
	 * @hibernate.column name="id_status_aviso_relacionamento"
	 */
	public AvStatusAvisoRelacionamentoBean getStatusAviso() {
		return this.statusAviso;
	}

	/**
	 * Recupera o tipo de relacionammento do aviso.
	 * 
	 * @return the tipoRelacionamento
	 * @hibernate.many-to-one
	 *                        class="br.com.netservicos.core.bean.av.AvTipoRelacionamentoBean"
	 *                        cascade="none" not-null="false"
	 * @hibernate.column name="id_tipo_relacionamento"
	 */
	public AvTipoRelacionamentoBean getTipoRelacionamento() {
		return this.tipoRelacionamento;
	}

	/**
	 * @param pTipoRelacionamento
	 *            the tipoRelacionamento to set
	 */
	public final void setTipoRelacionamento(
			final AvTipoRelacionamentoBean pTipoRelacionamento) {
		this.tipoRelacionamento = pTipoRelacionamento;
	}

	/**
	 * @param pStatusAviso
	 *            the statusAviso to set
	 */
	public void setStatusAviso(
			final AvStatusAvisoRelacionamentoBean pStatusAviso) {
		this.statusAviso = pStatusAviso;
	}

	/**
	 * Recupera a cidade operadora.
	 * 
	 * @return the cidContrato
	 * @hibernate.property column="cid_contrato"
	 */
	public String getCidContrato() {
		return this.cidContrato;
	}

	/**
	 * @param pCidContrato
	 *            the cidContrato to set
	 */
	public void setCidContrato(final String pCidContrato) {
		this.cidContrato = pCidContrato;
	}

	/**
	 * Recupera o numero de contrato do cliente.
	 * 
	 * @return the numContrato
	 * @hibernate.property column="num_contrato"
	 */
	public Long getNumContrato() {
		return this.numContrato;
	}

	/**
	 * @param pNumContrato
	 *            the numContrato to set
	 */
	public void setNumContrato(final Long pNumContrato) {
		this.numContrato = pNumContrato;
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
		if (this.idAvisoRelacionamento != null) {
			result = prime * result + this.idAvisoRelacionamento.hashCode();
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
		if (obj instanceof AvAvisoRelacionamentoBean) {
			final AvAvisoRelacionamentoBean comp = (AvAvisoRelacionamentoBean) obj;
			test = getIdAvisoRelacionamento().equals(
					comp.getIdAvisoRelacionamento());
		}
		return test;
	}

	/**
	 * @param xtLayoutAviso
	 *            the xtLayoutAviso to set
	 */
	public void setXtLayoutAviso(final String xtLayoutAviso) {
		this.xtLayoutAviso = xtLayoutAviso;
	}

	/**
	 * @return the xtLayoutAviso
	 * @hibernate.property column="xt_layout_aviso" type="br.com.netservicos.gescom.util.bd.HibernateXMLType"
	 */
	public String getXtLayoutAviso() {
		return this.xtLayoutAviso;
	}

}
