package br.com.netservicos.netcrmcore.venda.agendamento.dto;

import java.io.Serializable;

import javax.xml.datatype.XMLGregorianCalendar;

public class PeriodoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private java.lang.String descricao;
	private XMLGregorianCalendar data;
	private XMLGregorianCalendar horaInicial;
	private XMLGregorianCalendar horaFinal;
	private int idTipoPeriodo;
	private int emergenciaFlag;
	private String codigoJanela;
	private int minutosDisp;



	public PeriodoBean(final java.lang.String descricao,
			final XMLGregorianCalendar data,
			final XMLGregorianCalendar horaInicial,
			final XMLGregorianCalendar horaFinal, final int idTipoPeriodo,
			final int emergenciaFlag, final String codigoJanela) {
		this.descricao = descricao;
		this.data = data;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.idTipoPeriodo = idTipoPeriodo;
		this.emergenciaFlag = emergenciaFlag;
		this.codigoJanela = codigoJanela;
	}

	public PeriodoBean() {
		super();
	}



	
	/**
	 * @return the minutosDisp
	 */
	public int getMinutosDisp() {
		return minutosDisp;
	}

	/**
	 * @param minutosDisp the minutosDisp to set
	 */
	public void setMinutosDisp(int minutosDisp) {
		this.minutosDisp = minutosDisp;
	}
	
	public java.lang.String getDescricao() {
		return descricao;
	}

	public void setDescricao(java.lang.String descricao) {
		this.descricao = descricao;
	}

	public XMLGregorianCalendar getData() {
		return data;
	}

	public void setData(XMLGregorianCalendar data) {
		this.data = data;
	}

	public XMLGregorianCalendar getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(XMLGregorianCalendar horaInicial) {
		this.horaInicial = horaInicial;
	}

	public XMLGregorianCalendar getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(XMLGregorianCalendar horaFinal) {
		this.horaFinal = horaFinal;
	}

	public int getIdTipoPeriodo() {
		return idTipoPeriodo;
	}

	public void setIdTipoPeriodo(int idTipoPeriodo) {
		this.idTipoPeriodo = idTipoPeriodo;
	}

	public int getEmergenciaFlag() {
		return emergenciaFlag;
	}

	public void setEmergenciaFlag(int emergenciaFlag) {
		this.emergenciaFlag = emergenciaFlag;
	}

	public String getCodigoJanela() {
		return codigoJanela;
	}

	public void setCodigoJanela(String codigoJanela) {
		this.codigoJanela = codigoJanela;
	}

}
