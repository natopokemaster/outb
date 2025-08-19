/*
 * Created on 13/02/2010
 * Project : NETVendaGeral
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.netcrmcore.geral.constants;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Enum de uso geral para Web Services.
 * </p>
 * <b> Issues: <br>
 * </b>
 * 
 * @author wellignton.maeda
 * @since 05/10/2010
 * @version
 */
public enum GeralWebServicesEnum {

	ERRO_SERV_OPER_NET("erro.servico.operadoraNET"), ERRO_SERV_DISPONIBILIDADE_PERIODO(
			"erro.servico.disponibilidadePeriodoNET"), ERRO_SERV_AGENDA_OS_AGENDAR(
			"erro.servico.erro.servico.agendaOs.agendar"), ERRO_SERV_AGENDA_OS_LIBERAR(
			"erro.servico.erro.servico.agendaOs.liberar"), ERRO_SERV_AGENDA_OS_REAGENDAR(
			"erro.servico.erro.servico.agendaOs.reagendar"), ERRO_SERV_CONSULTA_BLOQUEIO(
			"erro.servico.erro.servico.bloqueioAgenda.consulta"),

	;

	/**
	 * String.
	 */
	private String name;

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * <p>
	 * 
	 * @return String
	 * @since 05/10/2010
	 * @author  wellignton.maeda
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	private GeralWebServicesEnum(final String nameParam) {
		name = nameParam;
	}

}
