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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa a tabela AV_FORMA_ENVIO.
 * </P>
 * <B> Issues : <BR>
 * 
 * @since 31/03/2011
 * @hibernate.class table = "av_forma_envio" dynamic-insert = "true"
 *                  dynamic-update = "true"
 */
public class AvFormaEnvioBean extends DomainBean{

	/**
	 * Identificador da forma de envio do aviso.
	 */
	private static final String ID_FORMA_ENVIO = "idFormaEnvio";

	/**
	 * long
	 */
	private static final long serialVersionUID = -3412251958498341290L;
	
	public static final String PROCURAR_FORMAS_ENVIO_PPV_PADRAO = "procurarFormasEnvioPPVPadrao";

	/**
	 * ID_FORMA_ENVIO NUMBER(10) N. Identificador da forma de envio.
	 */
	private Long idFormaEnvio;
	
	/**
	 * DS_FORMA_ENVIO VARCHAR2(50) N. Descricao da forma de envio.
	 */
	private String dsFormaEnvio;

	/**
	 * Construtor padrao.
	 */
	public AvFormaEnvioBean() {
		super(ID_FORMA_ENVIO);
	}

	/**
	 * Construtor com identificador da forma de envio.
	 * 
	 * @param idFormaEnvio
	 */
	public AvFormaEnvioBean(final Long idFormaEnvio){
		this();
		this.idFormaEnvio = idFormaEnvio;
	}

	/**
	 * Recupera o identificador da forma de envio.
	 * 
	 * @return the idFormaEnvio
	 * @hibernate.id column = "ID_FORMA_ENVIO" 
	 * 				 generator-class="assigned"
	 * 				 unsaved-value="null"
	 */
	public Long getIdFormaEnvio() {
		return idFormaEnvio;
	}

	/**
	 * @param idFormaEnvio the idFormaEnvio to set
	 */
	public void setIdFormaEnvio(Long idFormaEnvio) {
		this.idFormaEnvio = idFormaEnvio;
	}

	/**
	 * Recupera a descricao da forma de envio.
	 * 
	 * @return the dsFormaEnvio
	 * @hibernate.property column = "DS_FORMA_ENVIO" 
	 */
	public String getDsFormaEnvio() {
		return dsFormaEnvio;
	}


	/**
	 * @param dsFormaEnvio the dsFormaEnvio to set
	 */
	public void setDsFormaEnvio(String dsFormaEnvio) {
		this.dsFormaEnvio = dsFormaEnvio;
	}
}
