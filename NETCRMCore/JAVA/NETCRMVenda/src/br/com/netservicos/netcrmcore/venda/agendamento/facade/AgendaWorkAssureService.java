package br.com.netservicos.netcrmcore.venda.agendamento.facade;

import br.com.netservicos.framework.core.facade.Service;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.AgendaRequisicaoBean;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.AgendaRespostaBean;

/**
 * <p>
 * <b>Description: </b><br>
 * </p>
 * <b> Interface que define regras comuns para agendamento. <br>
 * </b>
 * 
 * @author wellington.maeda
 * @since 05/10/2010
 * @version
 */
public interface AgendaWorkAssureService extends Service { 

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Consultar Períodos
	 * <p>
	 * 
	 * @param AgendaRequisicaoBean
	 *            req
	 * @return boolean
	 * @since 05/10/2010
	 * @author wellington.maeda
	 */
	public AgendaRespostaBean consultarPeriodos(AgendaRequisicaoBean req);

	/** 
	 * <p>
	 * <b>Description:</b><br/>
	 * Agendar
	 * <p>
	 * 
	 * @param AgendaRequisicaoBean
	 *            req
	 * @return boolean
	 * @since 05/10/2010
	 * @author wellington.maeda
	 */
	public boolean agendar(AgendaRequisicaoBean req);

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Liberar
	 * <p>
	 * 
	 * @param AgendaRequisicaoBean
	 *            req
	 * @return boolean
	 * @since 05/10/2010
	 * @author wellington.maeda
	 */
	public boolean liberarAgenda(AgendaRequisicaoBean req);

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Reagendar
	 * <p>
	 * 
	 * @param AgendaRequisicaoBean
	 *            req
	 * @return boolean
	 * @since 05/10/2010
	 * @author wellington.maeda
	 */
	public boolean reagendar(AgendaRequisicaoBean req);

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * Consultar Bloqueio
	 * <p>
	 * 
	 * @param AgendaRequisicaoBean
	 *            req
	 * @return boolean
	 * @since 05/10/2010
	 * @author wellington.maeda
	 */
	public boolean consultarBloqueio(AgendaRequisicaoBean req);
}
