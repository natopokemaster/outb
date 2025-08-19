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

package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela SN_PLANO_PGTO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_plano_pgto" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnPlanoPgtoBean extends DomainBean {

    private static final long serialVersionUID = 4875958836182372575L;

    public static final String PRIMARY_KEY = "idPlanoPgto";

    public static final String ID_PLANO_PGTO = "idPlanoPgto";

    private Long idPlanoPgto;
    private String descricao;
    private Integer qtdParcelas;
    private Integer vctoFixo;

    /**
     * Construtor Padrão.
     */
    public SnPlanoPgtoBean() {
        super(SnPlanoPgtoBean.PRIMARY_KEY);

    }

    /**
     * @return Returns the idPlanoPgto
     * @hibernate.id generator-class="sequence" unsaved-value = "null"
     *               column="id_plano_pgto" type = "long"
     * @hibernate.generator-param name = "sequence" value = "ssn_id_plano_pgto"
     */
    public Long getIdPlanoPgto() {
        return this.idPlanoPgto;
    }

    /**
     * @return Returns the descricao
     * @hibernate.property column = "descricao"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return Returns the qtdParcelas
     * @hibernate.property column = "qtd_parcelas"
     */
    public Integer getQtdParcelas() {
        return this.qtdParcelas;
    }

    /**
     * @return Returns the vctoFixo
     * @hibernate.property column = "vcto_fixo"
     */
    public Integer getVctoFixo() {
        return this.vctoFixo;
    }

    /**
     * @param idPlanoPgto the idPlanoPgto to set
     */
    public void setIdPlanoPgto(Long idPlanoPgto) {
        this.idPlanoPgto = idPlanoPgto;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param qtdParcelas the qtdParcelas to set
     */
    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    /**
     * @param vctoFixo the vctoFixo to set
     */
    public void setVctoFixo(Integer vctoFixo) {
        this.vctoFixo = vctoFixo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idPlanoPgto != null) {
            result = prime * result + this.idPlanoPgto.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnPlanoPgtoBean) {
            final SnPlanoPgtoBean comp = (SnPlanoPgtoBean) key;
            test = this.getIdPlanoPgto().equals(comp.getIdPlanoPgto());
        }
        return test;
    }
}
