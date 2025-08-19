/*
 * Created on 25/02/2010
 * Project : NETVendaGeral
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.netcrmcore.venda.agendamento.facade;

import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <p>
 * <b>Description: </b><br>
 * Interface que define regras comuns para agendamento.
 * </p>
 * <b> Issues: <br>
 * </b>
 *  
 * @author Wellington Maeda
 * @since 05/10/2010
 * @version 1.0
 */
public interface AgendamentoService extends Service {

	

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Liberar Periodos WA
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @return DynamicBean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 */
	public DynamicBean listPeriodosWA(DynamicBean dynamicBean);

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Lista períodos SA casada WA
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @return DynamicBean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 */
	public DynamicBean listPeriodosSACasadaWA(DynamicBean dynamicBean);

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Lista períodos SA WA
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @return DynamicBean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 */
	public DynamicBean listPeriodosSAWA(DynamicBean dynamicBean);

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Agendar proposta WA
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @since 13/11/2009
	 * @author wellington.maeda
	 */
	public void agendarPropostaWA(DynamicBean dynamicBean);

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Liberar agenda
	 * <p>
	 * 
	 * @param CpPropostaBean
	 *            proposta
	 * @since 20/05/2010
	 * @author wellington.maeda
	 */
	public void liberaData(Long idProposta);

	
	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Rollout
	 * <p>
	 * 
	 * @param String
	 *            cidContrato
	 * @return Integer
	 * @since 20/05/2010
	 * @author wellington.maeda
	 */
	public Integer getRollout(String cidContrato);



	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Consultar Bloqueio da Agenda
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @return boolean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 */
	public boolean consultarBloqueio(DynamicBean dynamicBean);

}
