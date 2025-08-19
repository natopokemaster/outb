package br.com.netservicos.netcrmcore.cliente.cobranca.facade;

import java.text.ParseException;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;
import br.com.netservicos.modelocanonico.evento.ws.types.RegistroContato;

public interface ManutencaoDadosCobrancaContratoService extends Service{

	public RegistroContato alterarDadosCobrancaContrato(Bean bean) throws ParseException;
	
}
