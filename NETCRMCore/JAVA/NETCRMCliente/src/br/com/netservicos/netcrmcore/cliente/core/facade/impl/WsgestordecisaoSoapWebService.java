package br.com.netservicos.netcrmcore.cliente.core.facade.impl;

import br.com.netservicos.framework.core.facade.WebService;
import br.com.netservicos.netvenda.axis2.ws.types.consultaserasa.AnalisarCredito;
import br.com.netservicos.netvenda.axis2.ws.types.consultaserasa.AnalisarCreditoResponse;
import br.com.netservicos.netvenda.axis2.ws.types.consultaserasa.Header;

public interface WsgestordecisaoSoapWebService extends WebService {
     AnalisarCreditoResponse analisarCredito(AnalisarCredito parameters,Header requeseader);
}
