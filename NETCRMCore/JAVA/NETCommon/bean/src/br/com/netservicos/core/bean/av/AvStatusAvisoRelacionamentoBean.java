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
 * Classe Bean que representa a tabela STATUS_AVISO_RELACIONAMENTO.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 * @hibernate.class table = "av_status_aviso_relacionamento" dynamic-insert =
 *                  "true" dynamic-update = "true"
 * 
 */
public class AvStatusAvisoRelacionamentoBean extends DomainBean {

	/**
	 * long
	 */
	private static final long serialVersionUID = 4210884773693366190L;

	/**
	 * String.
	 */
	private static final String PRIMARY_KEY = "idStatusAvisoRel";

	/**
	 * ID_STATUS_AVISO_RELACIONAMENTO NUMBER(10) N. Identificador do status do
	 * aviso de relacionamento.
	 */
	private Long idStatusAvisoRel;

	/**
	 * DS_STATUS_AVISO_RELACIONAMENTO VARCHAR2(50) N. Descrição do status do
	 * aviso de relacionamento.
	 */
	private String dsStatusAvisoRel;

	/**
	 * Construtor padrao.
	 */
	public AvStatusAvisoRelacionamentoBean() {
		super(PRIMARY_KEY);
	}

	/**
	 * Recupera o identificador do status do aviso.
	 * 
	 * @return the idStatusAvisoRel
	 * @hibernate.id column = "ID_STATUS_AVISO_RELACIONAMENTO"
	 *               generator-class="assigned"
	 */
	public Long getIdStatusAvisoRel() {
		return this.idStatusAvisoRel;
	}

	/**
	 * @param pIdStatusAvisoRel
	 *            the idStatusAvisoRel to set.
	 */
	public void setIdStatusAvisoRel(final Long pIdStatusAvisoRel) {
		this.idStatusAvisoRel = pIdStatusAvisoRel;
	}

	/**
	 * Recupera a descricao do status do aviso.
	 * 
	 * @return the dsStatusAvisoRel
	 * @hibernate.property column="DS_STATUS_AVISO_RELACIONAMENTO"
	 */
	public String getDsStatusAvisoRel() {
		return this.dsStatusAvisoRel;
	}

	/**
	 * @param pDsStatusAvisoRel
	 *            the dsStatusAvisoRel to set.
	 */
	public void setDsStatusAvisoRel(final String pDsStatusAvisoRel) {
		this.dsStatusAvisoRel = pDsStatusAvisoRel;
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
		if (this.idStatusAvisoRel != null) {
			result = prime * result + this.idStatusAvisoRel.hashCode();
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
		if (obj instanceof AvStatusAvisoRelacionamentoBean) {
			final AvStatusAvisoRelacionamentoBean comp = (AvStatusAvisoRelacionamentoBean) obj;
			test = getIdStatusAvisoRel().equals(comp.getIdStatusAvisoRel());
		}
		return test;
	}

}
