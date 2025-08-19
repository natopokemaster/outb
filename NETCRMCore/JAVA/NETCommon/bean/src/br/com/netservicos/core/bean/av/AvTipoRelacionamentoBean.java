/*
 * Created on 07/04/2011
 * Project : NETGESCOMCommon
 *
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.av;

import br.com.netservicos.core.bean.BeanConstants;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela TIPO_RELACIONAMENTO.
 * </p>
 * <b> Issues: <br>
 *
 * </b>
 *
 * @since 07/04/2011
 * @version 1.0
 * @hibernate.class table = "av_tipo_relacionamento" dynamic-insert = "true"
 *                  dynamic-update = "true"
 *
 */
public class AvTipoRelacionamentoBean extends DomainBean {

	/**
	 * Identificador do tipo de recibo.
	 */
	private static final String ID_TIPO_RELACIONAMENTO = "idTipoRelacionamento";


	/**
	 * long
	 */
	private static final long serialVersionUID = 3670284140634510919L;
	
	
	/**
	 * ID_TIPO_RELACIONAMENTO NUMBER(10) N. Identificador do tipo do relacionamento.
	 */
	private Long idTipoRelacionamento;
	
	/**
	 * DS_TIPO_RELACIONAMENTO VARCHAR2(50) N. Descricao do tipo de relacionamento.
	 */
	private String dsTipoRelacionamento;

	/**
	 * Construtor Padrao.
	 */
	public AvTipoRelacionamentoBean() {
		super(ID_TIPO_RELACIONAMENTO);
	}

	/**
	 * Recupera o identificador do tipo de relacionamento.
	 * 
	 * @return the idTipoRelacionamento
	 * @hibernate.id column = "ID_TIPO_RELACIONAMENTO"
	 *               generator-class="assigned"
	 */
	public final Long getIdTipoRelacionamento() {
		return this.idTipoRelacionamento;
	}

	/**
	 * Recupera a descricao do tipo de relacionamento.
	 * 
	 * @return the dsTipoRelacionamento
	 * @hibernate.property column="DS_TIPO_RELACIONAMENTO"
	 */
	public final String getDsTipoRelacionamento() {
		return this.dsTipoRelacionamento;
	}

	/**
	 * @param pIdTipoRel
	 *            the idTipoRelacionamento to set
	 */
	public final void setIdTipoRelacionamento(final Long pIdTipoRel) {
		this.idTipoRelacionamento = pIdTipoRel;
	}

	/**
	 * @param pDsTipoRel
	 *            the dsTipoRelacionamento to set
	 */
	public final void setDsTipoRelacionamento(final String pDsTipoRel) {
		this.dsTipoRelacionamento = pDsTipoRel;
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
		if (this.idTipoRelacionamento != null) {
			result = prime * result + this.idTipoRelacionamento.hashCode();
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
		if (obj instanceof AvTipoRelacionamentoBean) {
			final AvTipoRelacionamentoBean comp = (AvTipoRelacionamentoBean) obj;
			test = getIdTipoRelacionamento().equals(
					comp.getIdTipoRelacionamento());
		}
		return test;
	}

}
