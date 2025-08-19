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

import br.com.netservicos.core.bean.BeanConstants;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela SN_CHAMADA.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 * @hibernate.class table = "sn_chamada" dynamic-insert = "true" dynamic-update
 *                  = "true"
 */
public class SnChamadaBean extends DomainBean {

	private static final String ID_CHAMADA = "idChamada";

	/**
	 * long
	 */
	private static final long serialVersionUID = 678449275525407687L;

	/**
	 * ID_CHAMADA NUMBER(10) N. Identificador da chamada.
	 */
	private Long idChamada;

	/**
	 * ID_PROTOCOLO VARCHAR2(15) N. Identificador do numero de protocolo.
	 */
	private SnProtocoloBean protocolo;

	/**
	 * Construtor Padrao.
	 */
	public SnChamadaBean() {
		super(ID_CHAMADA);
	}

	/**
	 * @param pIdChamada
	 * @param pProtocolo
	 */
	public SnChamadaBean(final Long pIdChamada, final SnProtocoloBean pProtocolo) {
		this();
		this.idChamada = pIdChamada;
		this.protocolo = pProtocolo;
	}

	/**
	 * Recupera o identificador da chamada.
	 * 
	 * @return the idChamada
	 * @hibernate.id column="id_chamada" generator-class="sequence"
	 * @hibernate.generator-param name="sequence" value="SQ_ID_CHAMADA"
	 */
	public Long getIdChamada() {
		return this.idChamada;
	}

	/**
	 * Recupera a entidade protocolo.
	 * 
	 * @return the protocolo
	 * @hibernate.many-to-one 
	 *                        class="br.com.netservicos.core.bean.sn.SnProtocoloBean"
	 *                        cascade="none" not-null="false"
	 * @hibernate.column name="ID_PROTOCOLO"
	 */
	public SnProtocoloBean getProtocolo() {
		return this.protocolo;
	}

	/**
	 * @param pIdChamada
	 *            the idChamada to set
	 */
	public void setIdChamada(final Long pIdChamada) {
		this.idChamada = pIdChamada;
	}

	/**
	 * @param pProtocolo
	 *            the protocolo to set
	 */
	public void setProtocolo(final SnProtocoloBean pProtocolo) {
		this.protocolo = pProtocolo;
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
		if (this.idChamada != null) {
			result = prime * result + this.idChamada.hashCode();
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
		if (obj instanceof SnChamadaBean) {
			final SnChamadaBean comp = (SnChamadaBean) obj;
			test = getIdChamada().equals(comp.getIdChamada());
		}
		return test;
	}

}
