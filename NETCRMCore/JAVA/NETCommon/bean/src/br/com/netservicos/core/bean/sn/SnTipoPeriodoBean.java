/*
 * Created on 30/05/2005
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.sn;

import java.sql.Timestamp;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Descrição:</B><BR>
 * Classe que representa a tabela sn_tipo_periodo </B>
 * 
 * @author Marne Campos
 * @since 16/11/2009
 * 
 * @hibernate.class table = "sn_tipo_periodo" dynamic-insert = "true"
 *                  dynamic-update = "true" lazy="false"
 * 
 * @hibernate.cache usage = "nonstrict-read-write"
 * 
 * 
 */
public class SnTipoPeriodoBean extends DomainBean {

	/**
	 * long
	 */
	private static final long serialVersionUID = -687808227549999385L;

	private Integer idTipoPeriodo;

	private String descricao;

	private Integer prioridade;

	private Timestamp hrInicio;

	private Timestamp hrFim;

	/**
	 * Definição do Atributo chave
	 */
	public static final String ATRIBUTO_ID_TIPO_PERIODO = "idTipoPeriodo";

	/**
	 * Default method constructor.
	 * 
	 */
	public SnTipoPeriodoBean() {
		super(ATRIBUTO_ID_TIPO_PERIODO);
	}

	/**
	 * @hibernate.id generator-class="sequence" unsaved-value = "null"
	 *               column="ID_TIPO_PERIODO" type = "int"
	 * @hibernate.generator-param name = "sequence" value =
	 *                            "SSN_ID_TIPO_PERIODO"
	 * @return Integer
	 */
	public Integer getIdTipoPeriodo() {
		return this.idTipoPeriodo;
	}

	/**
	 * @param pIdTipoPeriodo
	 *            The idTipoPeriodo to set.
	 */
	public void setIdTipoPeriodo(Integer pIdTipoPeriodo) {
		this.idTipoPeriodo = pIdTipoPeriodo;
	}

	/**
	 * Obtains and returns the new value of the descricao attribute.
	 * 
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property column="DESCRICAO" type = "string"
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * @param pDescricao
	 *            The descricao to set.
	 */
	public void setDescricao(String pDescricao) {
		if (pDescricao != null) {
			this.descricao = pDescricao.toUpperCase();
		} else {
			this.descricao = pDescricao;
		}
	}

	/**
	 * @return Returns the prioridade.
	 * 
	 * @hibernate.property column="PRIORIDADE" type = "int"
	 */
	public Integer getPrioridade() {
		return this.prioridade;
	}

	/**
	 * @param pPrioridade
	 *            The prioridade to set.
	 */
	public void setPrioridade(Integer pPrioridade) {
		this.prioridade = pPrioridade;
	}

	/**
	 * @return Returns the hrInicio.
	 * 
	 * @hibernate.property column="HR_INI" type = "timestamp"
	 */
	public Timestamp getHrInicio() {
		return this.hrInicio;
	}

	/**
	 * @param pHrInicio
	 *            The hrInicio to set.
	 */
	public void setHrInicio(Timestamp pHrInicio) {
		this.hrInicio = pHrInicio;
	}

	/**
	 * @return Returns the hrFim.
	 * 
	 * @hibernate.property column="HR_FIM" type = "timestamp"
	 */
	public Timestamp getHrFim() {
		return this.hrFim;
	}

	/**
	 * @param pHrFim
	 *            The hrFim to set.
	 * 
	 */
	public void setHrFim(Timestamp pHrFim) {
		this.hrFim = pHrFim;
	}
}
