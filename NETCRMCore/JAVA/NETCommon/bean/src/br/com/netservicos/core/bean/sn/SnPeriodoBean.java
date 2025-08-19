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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B>Descrição:</B><BR>
 * Classe que representa a tabela sn_periodo </B>
 * 
 * @author Marne Campos
 * @since 16/11/2009
 * 
 * @hibernate.class table = "sn_periodo" dynamic-insert = "true" dynamic-update
 *                  = "true" lazy="false"
 * 
 * 
 */
public class SnPeriodoBean extends DomainBean {

	/**
	 * long
	 */
	private static final long serialVersionUID = -7764262789307161574L;
	private Integer idPeriodo;
	private Integer idTipoPeriodo;
	private SnTipoPeriodoBean tipoPeriodo;
	private String cidCodigo;
	private Integer diaBloq;
	private Timestamp hrMaxBloq;
	private Date dt;

	/**
	 * Atributo chave
	 */
	public static final String ATRIBUTO_ID_PERIODO = "idPeriodo";

	/**
	 * Default method constructor.
	 */
	public SnPeriodoBean() {
		super(ATRIBUTO_ID_PERIODO);
	}

	/**
	 * @hibernate.id generator-class="assigned" unsaved-value = "null"
	 *               column="ID_PERIODO" type = "int"
	 * @return Integer
	 */
	public Integer getIdPeriodo() {
		return this.idPeriodo;
	}

	/**
	 * @param pIdPeriodo
	 *            The idTipoPeriodo to set.
	 */
	public void setIdPeriodo(Integer pIdPeriodo) {
		this.idPeriodo = pIdPeriodo;
	}

	/**
	 * Obtains and returns the new value of the idTipoPeriodo attribute.
	 * 
	 * @return Returns the idTipoPeriodo.
	 * 
	 * @hibernate.property column="ID_TIPO_PERIODO" type = "int"
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
	 * Obtains and returns the new value of the cidCodigo attribute.
	 * 
	 * @return Returns the cidCodigo.
	 * 
	 * @hibernate.property column="CID_CODIGO" type = "string"
	 */
	public String getCidCodigo() {
		return this.cidCodigo;
	}

	/**
	 * @param pCidCodigo
	 *            The cidCodigo to set.
	 */
	public void setCidCodigo(String pCidCodigo) {
		this.cidCodigo = pCidCodigo;
	}

	/**
	 * @return Returns the diaBloq.
	 * 
	 * @hibernate.property column="DIA_BLOQ" type = "int"
	 * 
	 */
	public Integer getDiaBloq() {
		return this.diaBloq;
	}

	/**
	 * @param pDiaBloq
	 *            The diaBloq to set.
	 */
	public void setDiaBloq(Integer pDiaBloq) {
		this.diaBloq = pDiaBloq;
	}

	/**
	 * @return Returns the hrMaxBloq.
	 * 
	 * @hibernate.property column="HORA_MAX_BLOQ" type = "timestamp"
	 * 
	 */
	public Timestamp getHrMaxBloq() {
		return this.hrMaxBloq;
	}

	/**
	 * @param pHrMaxBloq
	 *            The hrMaxBloq to set.
	 */
	public void setHrMaxBloq(Timestamp pHrMaxBloq) {
		this.hrMaxBloq = pHrMaxBloq;
	}

	/**
	 * @return Returns the dt.
	 * 
	 * @hibernate.property column="DT" type = "date"
	 * 
	 */
	public Date getDt() {
		return this.dt;
	}

	/**
	 * @param pDt
	 *            The dt to set.
	 */
	public void setDt(Date pDt) {
		this.dt = pDt;
	}

	/**
	 * Retorna apenas o ultimo dia da data de agendamento/instalacao, atraves do
	 * atributo "dt".
	 * 
	 * @return Inteiro contendo o dia.
	 */
	public Integer getDiaMesAgendamento() {
		final Calendar cal = new GregorianCalendar();
		cal.setTime(getDt());
		return Integer.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * Retorna apenas o ultimo dia da data de agendamento/instalacao, atraves do
	 * atributo "dt".
	 * 
	 * @return Inteiro contendo o dia.
	 */
	public Integer getUltimoDiaMesAgendamento() {
		final Calendar cal = new GregorianCalendar();
		cal.setLenient(false);
		cal.setTime(getDt());
		return Integer.valueOf(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
	}

	/**
	 * @hibernate.many-to-one column="id_tipo_periodo" insert="false"
	 *                        update="false"
	 * 
	 * @return SnTipoPeriodoBean
	 */
	public SnTipoPeriodoBean getTipoPeriodo() {
		return this.tipoPeriodo;
	}

	/**
	 * 
	 * <p>
	 * <b>Description:</b><br/>
	 * 
	 * <p>
	 * 
	 * @param pTipoPeriodo
	 * @since 26/03/2010
	 */
	public void setTipoPeriodo(SnTipoPeriodoBean pTipoPeriodo) {
		this.tipoPeriodo = pTipoPeriodo;
	}
}
