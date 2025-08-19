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
 * Classe Bean que representa a tabela SN_PROMOCAO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "sn_promocao" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false"
 * @hibernate.cache usage="read-write"
 */
public class SnPromocaoBean extends DomainBean {

    private static final long serialVersionUID = 3258130271474759225L;

    public static final String PRIMARY_KEY = "idPromocao";
    
    private Integer idPromocao;
    private String nomePromocao;
    private String descricao;
    private String publicoAlvo;
    private String msgContrato;
    private Integer pendenciaAdesao;
    private SnTipoPromocaoBean snTipoPromocao;

    /**
     * Construtor Padrão.
     */
    public SnPromocaoBean() {
        super(PRIMARY_KEY);
    }

    public SnPromocaoBean(Integer idPromocao) {
        this();
        this.idPromocao = idPromocao;
    }
    
    /**
     * @hibernate.id generator-class="sequence" unsaved-value = "null"
     *               column="id_promocao" type = "int"
     * @hibernate.generator-param name = "sequence" value = "ssn_id_promocao"
     * @return Integer
     */
    public Integer getIdPromocao() {
        return this.idPromocao;
    }

    /**
     * Obtains and returns the new value of the descricao attribute.
     * @return Returns the descricao.
     * @hibernate.property column="descricao" type = "string" not-null="true"
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Obtains and returns the new value of the msgContrato attribute.
     * @return Returns the msgContrato.
     * @hibernate.property column="msg_contrato" type = "string"
     */
    public String getMsgContrato() {
        return this.msgContrato;
    }

    /**
     * Obtains and returns the new value of the nomePromocao attribute.
     * @return Returns the nomePromocao.
     * @hibernate.property column="nome_promocao" type = "string"
     *                     not-null="true"
     */
    public String getNomePromocao() {
        return this.nomePromocao;
    }

    /**
     * Obtains and returns the new value of the pendenciaAdesao attribute.
     * @return Returns the pendenciaAdesao.
     * @hibernate.property column="pendencia_adesao" type = "int"
     *                     not-null="true"
     */
    public Integer getPendenciaAdesao() {
        return this.pendenciaAdesao;
    }

    /**
     * Obtains and returns the new value of the publicoAlvo attribute.
     * @return Returns the publicoAlvo.
     * @hibernate.property column="publico_alvo" type = "string"
     */
    public String getPublicoAlvo() {
        return this.publicoAlvo;
    }

    /**
     * Obtains and returns the SnTipoPromocaoBean.
     * @return Returns the snTipoPromocao.
     * @hibernate.many-to-one
     *                        class="br.com.netservicos.core.bean.sn.SnTipoPromocaoBean"
     *                        column="id_tipo_promocao" cascade="none"
     *                        not-null="true"
     */
    public SnTipoPromocaoBean getSnTipoPromocao() {
        return this.snTipoPromocao;
    }

    /**
	 * @param idPromocao the idPromocao to set
	 */
	public void setIdPromocao(Integer idPromocao) {
		this.idPromocao = idPromocao;
	}

	/**
	 * @param nomePromocao the nomePromocao to set
	 */
	public void setNomePromocao(String nomePromocao) {
		this.nomePromocao = nomePromocao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param publicoAlvo the publicoAlvo to set
	 */
	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	/**
	 * @param msgContrato the msgContrato to set
	 */
	public void setMsgContrato(String msgContrato) {
		this.msgContrato = msgContrato;
	}

	/**
	 * @param pendenciaAdesao the pendenciaAdesao to set
	 */
	public void setPendenciaAdesao(Integer pendenciaAdesao) {
		this.pendenciaAdesao = pendenciaAdesao;
	}

	/**
	 * @param snTipoPromocao the snTipoPromocao to set
	 */
	public void setSnTipoPromocao(SnTipoPromocaoBean snTipoPromocao) {
		this.snTipoPromocao = snTipoPromocao;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (this.idPromocao != null) {
            result = prime * result + this.idPromocao.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof SnPromocaoBean) {
            final SnPromocaoBean comp = (SnPromocaoBean) key;
            test = this.getIdPromocao().equals(comp.getIdPromocao());
        }
        return test;
    }
}
