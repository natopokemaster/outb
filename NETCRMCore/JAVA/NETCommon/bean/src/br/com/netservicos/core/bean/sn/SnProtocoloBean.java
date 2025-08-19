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
package br.com.netservicos.core.bean.sn;

import java.util.Date;

import br.com.netservicos.core.bean.BeanConstants;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela SN_PROTOCOLO.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 * @hibernate.class table = "sn_protocolo" dynamic-insert = "true"
 *                  dynamic-update = "true"
 */
public class SnProtocoloBean extends DomainBean {

	private static final String ID_PROTOCOLO = "idProtocolo";

	/**
	 * long
	 */
	private static final long serialVersionUID = -8366987866239236821L;

	/**
	 * ID_PROTOCOLO VARCHAR2(15) N. Identificador do protocolo.
	 */
	private String idProtocolo;

	/**
	 * DH_GERACAO DATE N. Data de geracao do protocolo.
	 */
	private Date dhGeracao;

	/**
	 * Construtor Padrao.
	 */
	public SnProtocoloBean() {
		super(ID_PROTOCOLO);
	}

	/**
	 * @param pIdProtocolo
	 * @param pDhGeracao
	 */
	public SnProtocoloBean(final String pIdProtocolo, final Date pDhGeracao) {
		this();
		this.idProtocolo = pIdProtocolo;
		this.dhGeracao = pDhGeracao;
	}

	/**
	 * Recupera o identificador do protocolo.
	 * 
	 * @return the idProtocolo
	 * @hibernate.id column = "ID_PROTOCOLO" generator-class="assigned"
	 */
	public String getIdProtocolo() {
		return this.idProtocolo;
	}

	/**
	 * Recupera a data de geracao do protocolo.
	 * 
	 * @return the dhGeracao
	 * @hibernate.property column="DH_GERACAO"
	 */
	public Date getDhGeracao() {
		return this.dhGeracao;
	}

	/**
	 * @param pIdProtocolo
	 *            the idProtocolo to set
	 */
	public void setIdProtocolo(final String pIdProtocolo) {
		this.idProtocolo = pIdProtocolo;
	}

	/**
	 * @param pDhGeracao
	 *            the dhGeracao to set
	 */
	public void setDhGeracao(final Date pDhGeracao) {
		this.dhGeracao = pDhGeracao;
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
		if (this.idProtocolo != null) {
			result = prime * result + this.idProtocolo.hashCode();
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
		if (obj instanceof SnProtocoloBean) {
			final SnProtocoloBean comp = (SnProtocoloBean) obj;
			test = getIdProtocolo().equals(comp.getIdProtocolo());
		}
		return test;
	}

}
