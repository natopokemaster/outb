package br.com.netservicos.netcrmcore.venda.agendamento.webservices;

import br.com.netservicos.framework.core.facade.WebService;

/**
 * <p>
 * <b>Description: </b><br>
 * </p>
 * <b> Issues: <br>
 * </b>
 * 
 * @author weollington.maeda
 * @since 05/10/2010
 * @version 1.0
 */
public interface AgendaOSWebService extends WebService {

	/**
	 * Auto generated method signature
	 * 
	 * @param liberarAgendaRequest2
	 * 
	 * @param netHeader3
	 */

	public br.com.netservicos.netvenda.axis2.ws.types.agenda.LiberarAgendaRequestResponse liberar(
			br.com.netservicos.netvenda.axis2.ws.types.agenda.LiberarAgendaRequest liberarAgendaRequest2,
			br.com.netservicos.netvenda.axis2.ws.types.agenda.Header netHeader3);

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param liberarAgendaRequest2
	 * 
	 * @param netHeader3
	 */
	public void startliberar(
			br.com.netservicos.netvenda.axis2.ws.types.agenda.LiberarAgendaRequest liberarAgendaRequest2,
			br.com.netservicos.netvenda.axis2.ws.types.agenda.Header netHeader3,
			final br.com.netservicos.netvenda.axis2.ws.services.agenda.AgendaOSServiceCallbackHandler callback);

	/**
	 * Auto generated method signature
	 * 
	 * @param agendarRequest5
	 * 
	 * @param netHeader6
	 */

	public br.com.netservicos.netvenda.axis2.ws.types.agenda.AgendarRequestResponse agendar(
			br.com.netservicos.netvenda.axis2.ws.types.agenda.AgendarRequest agendarRequest5,
			br.com.netservicos.netvenda.axis2.ws.types.agenda.Header netHeader6);

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param agendarRequest5
	 * 
	 * @param netHeader6
	 */
	public void startagendar(
			br.com.netservicos.netvenda.axis2.ws.types.agenda.AgendarRequest agendarRequest5,
			br.com.netservicos.netvenda.axis2.ws.types.agenda.Header netHeader6,
			final br.com.netservicos.netvenda.axis2.ws.services.agenda.AgendaOSServiceCallbackHandler callback);

	/**
	 * Auto generated method signature
	 * 
	 * @param reagendarRequest8
	 * 
	 * @param netHeader9
	 */

	public br.com.netservicos.netvenda.axis2.ws.types.agenda.ReagendarRequestResponse reagendar(
			br.com.netservicos.netvenda.axis2.ws.types.agenda.ReagendarRequest reagendarRequest8,
			br.com.netservicos.netvenda.axis2.ws.types.agenda.Header netHeader9);

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param reagendarRequest8
	 * 
	 * @param netHeader9
	 */
	public void startreagendar(
			br.com.netservicos.netvenda.axis2.ws.types.agenda.ReagendarRequest reagendarRequest8,
			br.com.netservicos.netvenda.axis2.ws.types.agenda.Header netHeader9,
			final br.com.netservicos.netvenda.axis2.ws.services.agenda.AgendaOSServiceCallbackHandler callback);

}
