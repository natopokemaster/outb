package br.com.netservicos.relacionar.cliente.jws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.beehive.controls.api.bean.Control;

import weblogic.jws.Binding;
import br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaRegistroType;
import br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaType;
import br.com.netservicos.v2.netHeader.NetHeaderDocument;
import br.com.netservicos.relacionar.cliente.control.DadoCobrancaProcessControl;

@WebService
@Binding(Binding.Type.SOAP12)
public class DadoCobrancaJWS {

	@Control
	private DadoCobrancaProcessControl dadoCobrancaProcessControl;

	@WebMethod
	public DadoCobrancaRegistroType alterar(@WebParam(header = true) NetHeaderDocument  netHeader,
						  DadoCobrancaType dadoCobrancaType) {
		
		return dadoCobrancaProcessControl.alterar(netHeader, dadoCobrancaType);
	}
}