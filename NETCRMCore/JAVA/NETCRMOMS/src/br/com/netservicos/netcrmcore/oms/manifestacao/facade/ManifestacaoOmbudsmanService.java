package br.com.netservicos.netcrmcore.oms.manifestacao.facade;

import java.io.IOException;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;

public interface ManifestacaoOmbudsmanService extends Service{
	
	public void incluirIntegracaoManifestacaoContrato(Bean bean)throws IOException;
	
	public void incluirIntegracaoManifestacaoCliente(Bean bean)throws IOException;

}
