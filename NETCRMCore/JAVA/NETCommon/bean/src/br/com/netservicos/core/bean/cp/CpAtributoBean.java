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
 * Classe Bean que representa a tabela CP_ATRIBUTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_atributo" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class CpAtributoBean extends DomainBean {

    private static final long serialVersionUID = 7111220877698323794L;

    public static final String PRIMARY_KEY = "idAtributo";

    private Long idAtributo;
    private String descricao;
    private CpTipoAtributoBean tipoAtributo;
    private CpAtributoBean atributoPai;
    public static final int ASSINANTE_CONCORRENCIA = 3;

    /**
     * Construtor Padrão.
     */
    public CpAtributoBean() {
        super(CpAtributoBean.PRIMARY_KEY);
    }

    /**
     * @return Long
     * @hibernate.id generator-class="sequence" column="id_atributo"
     * @hibernate.generator-param name="sequence" value="scp_atributo"
     */
    public Long getIdAtributo() {
        return this.idAtributo;
    }

    /**
     * @return CpTipoAtributoBean
     * @hibernate.many-to-one column="id_tipo_atributo" not-null="true"
     *                        lazy="proxy"
     */
    public CpTipoAtributoBean getTipoAtributo() {
        return this.tipoAtributo;
    }

    /**
     * @return String
     * @hibernate.property not-null="true"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return CpAtributoBean
     * @hibernate.many-to-one column="id_atributo_pai" lazy="proxy"
     */
    public CpAtributoBean getAtributoPai() {
        return this.atributoPai;
    }
    
    /**
	 * @param idAtributo the idAtributo to set
	 */
	public void setIdAtributo(Long idAtributo) {
		this.idAtributo = idAtributo;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param tipoAtributo the tipoAtributo to set
	 */
	public void setTipoAtributo(CpTipoAtributoBean tipoAtributo) {
		this.tipoAtributo = tipoAtributo;
	}

	/**
	 * @param atributoPai the atributoPai to set
	 */
	public void setAtributoPai(CpAtributoBean atributoPai) {
		this.atributoPai = atributoPai;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idAtributo != null) {
            result = prime * result + this.idAtributo.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpAtributoBean) {
            final CpAtributoBean comp = (CpAtributoBean) key;
            test = this.getIdAtributo().equals(comp.getIdAtributo());
        }
        return test;
    }
}
