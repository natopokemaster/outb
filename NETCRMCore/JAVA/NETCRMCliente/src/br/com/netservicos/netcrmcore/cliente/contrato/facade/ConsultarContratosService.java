package br.com.netservicos.netcrmcore.cliente.contrato.facade;

import java.io.IOException;
import java.util.List;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.Service;


public interface ConsultarContratosService extends Service{
   
	public List<DynamicBean> consultarContratosPorImovelAndHP(Bean bean) throws IOException;
	
}
