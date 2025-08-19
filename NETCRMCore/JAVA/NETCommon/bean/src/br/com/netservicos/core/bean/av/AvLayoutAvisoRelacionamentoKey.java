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

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import br.com.netservicos.core.bean.BeanConstants;
import br.com.netservicos.framework.core.bean.BaseCompositeKey;
import br.com.netservicos.framework.util.exception.BaseFailureException;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a composite key para a tabela LAYOUT_AVISO_RELACIONAMENTO.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 */
public class AvLayoutAvisoRelacionamentoKey implements Serializable,
		BaseCompositeKey {

	/**
	 * long
	 */
	private static final long serialVersionUID = 4788420429487068041L;

	/**
	 * ID_LAYOUT_AVISO_RELACIONAMENTO NUMBER(10) N. Identificador do layout do
	 * aviso de relacionamento.
	 */
	private Long idLayoutAvisoRel;

	/**
	 * DT_INI DATE N. Data de inicio do texto do layout do aviso de
	 * relacionamento.
	 */
	private Date dtIni;

	/**
	 * DT_FIM DATE N. Data de finalização do texto do layout do aviso de
	 * relacionamento.
	 */
	private Date dtFim;

	/**
	 * Recupera o identificador do layout do aviso.
	 * 
	 * @return the idLayoutAvisoRel
	 * @hibernate.id column="ID_LAYOUT_AVISO_RELACIONAMENTO"
	 *               generator-class="sequence"
	 * @hibernate.generator-param name="sequence"
	 *                            value="SQ_LAYOUT_AVISO_RELACIONAMENTO"
	 */
	public Long getIdLayoutAvisoRel() {
		return this.idLayoutAvisoRel;
	}

	/**
	 * Recupera a data de inicio.
	 * 
	 * @return the dtIni
	 * @hibernate.property column = "DT_INI"
	 */
	public Date getDtIni() {
		return this.dtIni;
	}

	/**
	 * Recupera a data fim.
	 * 
	 * @return the dtFim
	 * @hibernate.property column = "DT_FIM"
	 */
	public Date getDtFim() {
		return this.dtFim;
	}

	/**
	 * @param pIdLayoutAvisoRel
	 *            the idLayoutAvisoRel to set
	 */
	public void setIdLayoutAvisoRel(final Long pIdLayoutAvisoRel) {
		this.idLayoutAvisoRel = pIdLayoutAvisoRel;
	}

	/**
	 * @param pDtIni
	 *            the dtIni to set
	 */
	public void setDtIni(final Date pDtIni) {
		this.dtIni = pDtIni;
	}

	/**
	 * @param pDtFim
	 *            the dtFim to set
	 */
	public void setDtFim(final Date pDtFim) {
		this.dtFim = pDtFim;
	}

	/**
	 * @param pValue
	 */
	public void buildKey(final String pValue) {
		final StringTokenizer tok = new StringTokenizer(pValue, "|");
		try {
			final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
					new Locale("pt", "BR"));
			this.idLayoutAvisoRel = Long.valueOf(tok.nextToken());
			this.dtIni = sdf.parse(tok.nextToken());
			this.dtFim = sdf.parse(tok.nextToken());
		} catch (final ParseException exception) {
			throw new BaseFailureException(exception);
		}
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
		if ((this.idLayoutAvisoRel != null) && (this.dtIni != null)
				&& (this.dtFim != null)) {
			result = prime * result + this.idLayoutAvisoRel.hashCode()
					+ this.dtIni.hashCode() + this.dtFim.hashCode();
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
		if (obj instanceof AvLayoutAvisoRelacionamentoKey) {
			final AvLayoutAvisoRelacionamentoKey comp = (AvLayoutAvisoRelacionamentoKey) obj;
			test = getIdLayoutAvisoRel().equals(comp.getIdLayoutAvisoRel())
					&& getDtIni().equals(comp.getDtIni())
					&& getDtFim().equals(comp.getDtFim());
		}
		return test;
	}

}
