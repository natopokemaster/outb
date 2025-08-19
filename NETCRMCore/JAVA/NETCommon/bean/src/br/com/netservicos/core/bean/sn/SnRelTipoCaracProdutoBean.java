/*
 * Created on 05/10/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela SN_REL_TIPO_CARAC_PRODUTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 05/10/2010
 * @version 1.0
 *                              
 * @hibernate.class table = "prod_jd.sn_rel_tipo_carac_produto" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnRelTipoCaracProdutoBean extends DomainBean {
	
	private static final long serialVersionUID = 4531147448751008527L;
	
	private static final String PRIMARY_KEY = "composite";
	
	private SnRelTipoCaracProdutoKey composite;

	/**
	 * Construtor Padrão.
	 */
	public SnRelTipoCaracProdutoBean() {
	    super(SnRelTipoCaracProdutoBean.PRIMARY_KEY);
	}
	
	/**
	 * @hibernate.id
	 * type = "composite"
	 */
	public SnRelTipoCaracProdutoKey getComposite() {
		return composite;
	}

	/**
	 * @param composite The composite to set.
	 * 
	 */
	public void setComposite(SnRelTipoCaracProdutoKey composite) {
		this.composite = composite;
	}
}
