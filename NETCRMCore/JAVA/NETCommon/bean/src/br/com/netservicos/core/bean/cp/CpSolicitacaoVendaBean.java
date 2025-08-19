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

import br.com.netservicos.core.bean.sn.SnTipoSolicBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_SOLICITACAO_VENDA.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_solicitacao_venda" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false" batch-size="10"
 * @hibernate.cache usage="read-write"
 */
public class CpSolicitacaoVendaBean extends DomainBean {

	private static final long serialVersionUID = 4767416916176162444L;

    private static final String PRIMARY_KEY = "idSolicitacaoVenda";

    private Long idSolicitacaoVenda;
    private String dsSolicitacao;
    private SnTipoSolicBean tipoSolic;

    /**
     * Construtor padrão
     */
    public CpSolicitacaoVendaBean() {
        super(CpSolicitacaoVendaBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the dsSolicitacao
     * @hibernate.property column = "DS_SOLICITACAO" length = "50" not-null =
     *                     "true"
     */
    public String getDsSolicitacao() {
        return this.dsSolicitacao;
    }

    /**
     * @return Returns the idSolicitacaoVenda
     * @hibernate.id column = "ID_SOLICITACAO_VENDA" length = "10"
     *               generator-class = "assigned"
     */
    public Long getIdSolicitacaoVenda() {
        return this.idSolicitacaoVenda;
    }

    /**
     * @return Returns the SnTipoSolicBean
     * @hibernate.many-to-one column = "ID_TIPO_SOLIC" lazy="proxy"
     */
    public SnTipoSolicBean getTipoSolic() {
        return this.tipoSolic;
    }

	/**
	 * @param idSolicitacaoVenda the idSolicitacaoVenda to set
	 */
	public void setIdSolicitacaoVenda(Long idSolicitacaoVenda) {
		this.idSolicitacaoVenda = idSolicitacaoVenda;
	}

	/**
	 * @param dsSolicitacao the dsSolicitacao to set
	 */
	public void setDsSolicitacao(String dsSolicitacao) {
		this.dsSolicitacao = dsSolicitacao;
	}

	/**
	 * @param tipoSolic the tipoSolic to set
	 */
	public void setTipoSolic(SnTipoSolicBean tipoSolic) {
		this.tipoSolic = tipoSolic;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idSolicitacaoVenda != null) {
            result = prime * result + this.idSolicitacaoVenda.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpSolicitacaoVendaBean) {
            final CpSolicitacaoVendaBean comp = (CpSolicitacaoVendaBean) key;
            test = this.getIdSolicitacaoVenda().equals(comp.getIdSolicitacaoVenda());
        }
        return test;
    }
}