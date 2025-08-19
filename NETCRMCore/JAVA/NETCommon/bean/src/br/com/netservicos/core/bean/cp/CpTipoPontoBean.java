/*
 * Created on 21/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.cp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_TIPO_PONTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_tipo_ponto" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class CpTipoPontoBean extends DomainBean {

    public static final int PROVEDOR = 1;
    public static final int AQUISICAO = 2;
    public static final int DEGUSTACAO = 3;
    public static final int IP_EXTRA = 4;
    public static final Long PONTO_PRINCIPAL = new Long(5);
    public static final Long PONTO_ADICIONAL = new Long(6);
    public static final Long PONTO_FORMA_AQUISICAO = new Long(1);
    public static final Long PONTO_PROVEDOR = new Long(2);
    
	private static final long serialVersionUID = 165498121984096198L;

	public static final String PRIMARY_KEY = "idTipoPonto";
    
	private Long idTipoPonto;
    private String descricao;

    /**
     * Construtor Padrão.
     */
    public CpTipoPontoBean() {
        super(CpTipoPontoBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idTipoPonto.
     * @hibernate.id column="id_tipo_ponto" generator-class="assigned"
     */
    public Long getIdTipoPonto() {
    	return this.idTipoPonto;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.property column="descricao" not-null="true"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
	 * @param idTipoPonto the idTipoPonto to set
	 */
	public void setIdTipoPonto(Long idTipoPonto) {
		this.idTipoPonto = idTipoPonto;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idTipoPonto != null) {
            result = prime * result + this.idTipoPonto.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpTipoPontoBean) {
            final CpTipoPontoBean comp = (CpTipoPontoBean) key;
            test = this.getIdTipoPonto().equals(comp.getIdTipoPonto());
        }
        return test;
    }
}