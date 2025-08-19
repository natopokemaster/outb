/*
 * Created on 20/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.rh;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela RH_TIPO_PESSOA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/09/2010
 * @version 1.0
 * @hibernate.class table="rh_tipo_pessoa" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class RhTipoPessoaBean extends DomainBean {

    private static final long serialVersionUID = 588035147204935378L;

    public static final String PRIMARY_KEY = "codTipoPessoa";

    private String descricao = null;
    private String codTipoPessoa = null;

    /**
     * Construtor Padrão.
     */
    public RhTipoPessoaBean() {
        super(RhTipoPessoaBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the codTipoPessoa.
     * @hibernate.id generator-class="assigned" unsaved-value = "null"
     *               column="cod_tipo_pessoa"
     */
    public String getCodTipoPessoa() {
        return this.codTipoPessoa;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.property column="descricao" type = "string"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param codTipoPessoa the codTipoPessoa to set
	 */
	public void setCodTipoPessoa(String codTipoPessoa) {
		this.codTipoPessoa = codTipoPessoa;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.codTipoPessoa == null) ? 0 : this.codTipoPessoa.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof RhTipoPessoaBean) {
            final RhTipoPessoaBean comp = (RhTipoPessoaBean) key;
            test = this.getCodTipoPessoa().equals(comp.getCodTipoPessoa());
        }
        return test;
    }
}
