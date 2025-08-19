package br.com.netservicos.netcrmcore.webservices.util;

import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_APLICACAO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_FUNCIONALIDADE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_NUMERO_CHAMADA;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_NUMERO_PROTOCOLO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_TOKEN;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_USERNAME;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants.NET_HEADER_VERSAO_SERVICO;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;

public class WebServicesUtil {

	/**
	 * Cria um dynamicBean, com dados do netheader.
	 * @param header
	 * Header de onde será pego os dados.
	 * @return
	 * dynamicBean que contém os dados do netHeader.
	 */
	public static DynamicBean criarBeanComDadosNetHeader(NETFrameworkWSHeader header){

		DynamicBean dados = new DynamicBean();
		
		//Adiciona os dados do NetHeader no Bean
		if (header != null) {
			dados.addBeanProperty(NET_HEADER_APLICACAO, header.getAplicacao());
			dados.addBeanProperty(NET_HEADER_FUNCIONALIDADE, header.getFuncionalidade());
			dados.addBeanProperty(NET_HEADER_VERSAO_SERVICO, header.getVersaoServico());
			dados.addBeanProperty(NET_HEADER_TOKEN, header.getToken());
			if (header.getAtendimento() != null) {
				dados.addBeanProperty(
						NET_HEADER_NUMERO_PROTOCOLO, header.getAtendimento().getNumeroProtocolo());
				dados.addBeanProperty(NET_HEADER_NUMERO_CHAMADA, header.getAtendimento().getNumeroChamada());
			}
			dados.addBeanProperty(NET_HEADER_USERNAME, header.getUsername());
		}

		return dados;
	}

}
