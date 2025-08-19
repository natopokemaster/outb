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
 * Classe Bean que representa a tabela SN_LOCALIZACAO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_localizacao" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnLocalizacaoBean extends DomainBean {

    private static final long serialVersionUID = 47774907892522903L;

    public static final String PRIMARY_KEY = "idLocalizacao";
    
    public static final String ID_LOCALIZACAO = "idLocalizacao";

    private Long idLocalizacao;
    private String descricao;

    /**
     * Construtor Padrão.  
     */
    public SnLocalizacaoBean() {
        super(SnLocalizacaoBean.PRIMARY_KEY);
    }

    /**
     * @return Returns the idLocalizacao.
     * @hibernate.id generator-class="assigned" unsaved-value = "null" column="id_localizacao" type = "long"
     */
    public Long getIdLocalizacao() {
        return this.idLocalizacao;
    }

    /**
     * @return Returns the descricao.
     * @hibernate.property column="descricao" type = "string" not-null="false"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @param idLocalizacao the idLocalizacao to set
     */
    public void setIdLocalizacao(Long idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
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
        if (this.idLocalizacao != null) {
            result = prime * result + this.idLocalizacao.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnLocalizacaoBean) {
            final SnLocalizacaoBean comp = (SnLocalizacaoBean) key;
            test = this.getIdLocalizacao().equals(comp.getIdLocalizacao());
        }
        return test;
    }
}
