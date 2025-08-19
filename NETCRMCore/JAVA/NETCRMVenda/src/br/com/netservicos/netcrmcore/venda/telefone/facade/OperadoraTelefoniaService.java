package br.com.netservicos.netcrmcore.venda.telefone.facade;

import java.io.IOException;
import java.util.List;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;


public interface OperadoraTelefoniaService extends Service{
   
	public List listarOperadorasTelefonia(Bean bean) throws IOException;
	
}
