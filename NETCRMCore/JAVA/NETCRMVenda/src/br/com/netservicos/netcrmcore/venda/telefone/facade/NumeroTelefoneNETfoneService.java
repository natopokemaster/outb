package br.com.netservicos.netcrmcore.venda.telefone.facade;

import java.io.IOException;
import java.util.List;

import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.Service;


public interface NumeroTelefoneNETfoneService extends Service{
   
	public List listarTelefones(Bean bean) throws IOException;
	public DynamicBean reservaTelefoneVoip(DynamicBean bean) throws IOException;
	public DynamicBean cancelaReservaTelefoneVoip(DynamicBean bean);
	
}
