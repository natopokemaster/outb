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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela AV_EVENTO_RECIBO.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 * @hibernate.class table = "av_evento_recibo" dynamic-insert = "true"
 *                  dynamic-update = "true"
 * 
 */
public class AvEventoReciboBean extends DomainBean {

	private static final String RECIBO_RELACIONAMENTO = "reciboRelacionamento";

	/**
	 * long
	 */
	private static final long serialVersionUID = 5337873498353838706L;

	/**
	 * Entidade composta com as chaves primárias da tabela AV_EVENTO_RECIBO.
	 */
	private AvEventoReciboKey compositeKey;

	/**
	 * Construtor Padrao.
	 */
	public AvEventoReciboBean() {
		super(RECIBO_RELACIONAMENTO);
	}

	/**
	 * Recupera a chave composta. 
	 * 
	 * @return Composite
	 * 
	 * @hibernate.id type = "composite"
	 */
	public AvEventoReciboKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * 
	 * @param compositeKey
	 */
	public void setCompositeKey(AvEventoReciboKey compositeKey) {
		this.compositeKey = compositeKey;
	}
}
