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
public interface ConsultarPeriodosWebService extends WebService {

	/**
	 * Auto generated method signature
	 * 
	 * @param consultarRequest0
	 * @param netHeader1
	 */
	public br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.ConsultarPeriodosResponse consultar(
			br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.ConsultarPeriodosRequest consultarRequest0,
			br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.Header netHeader1);

	/**
	 * Auto generated method signature for Asynchronous Invocations
	 * 
	 * @param consultarRequest0
	 * 
	 * @param netHeader1
	 */
	public void startconsultar(
			br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.ConsultarPeriodosRequest consultarRequest0,
			br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.Header netHeader1,
			final br.com.netservicos.netvenda.axis2.ws.services.disponibPeriodo.DisponibilidadePeriodoServiceCallbackHandler callback);

}
