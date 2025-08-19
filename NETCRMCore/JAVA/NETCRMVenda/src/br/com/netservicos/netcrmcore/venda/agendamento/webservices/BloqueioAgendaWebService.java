package br.com.netservicos.netcrmcore.venda.agendamento.webservices;

import br.com.netservicos.framework.core.facade.WebService;

/**
 * <p>
 * <b>Description: </b><br>
 * </p>
 * <b> Issues: <br>
 * </b>
 * 
 * @author wellington.maeda
 * @since 05/10/2010
 * @version 1.0
 */

public interface BloqueioAgendaWebService extends WebService {
	/**
	 * Auto generated method signature
	 * 
	 * @param parametroConsultarBloqueioAgenda0
	 * 
	 * @param netHeader1
	 */

	public br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.ConsultarBloqueioAgendaResponse consultarBloqueioAgenda(
			br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.ConsultarBloqueioAgendaRequest parametroConsultarBloqueioAgenda0,
			br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.Header netHeader1);

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param parametroConsultarBloqueioAgenda0
	 * 
	 * @param netHeader1
	 */
	public void startconsultarBloqueioAgenda(
			br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.ConsultarBloqueioAgendaRequest parametroConsultarBloqueioAgenda0,
			br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.Header netHeader1,
			final br.com.netservicos.netvenda.axis2.ws.services.bloqueioAgenda.BloqueioAgendaServiceCallbackHandler callback);
}
