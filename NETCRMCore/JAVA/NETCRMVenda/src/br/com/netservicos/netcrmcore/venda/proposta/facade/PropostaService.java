/**
 * Created on 29/12/2009
 * Project : NETCliente
 *
 * Copyright © 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Serviços.
 * 
 * $Id: PropostaService.java,v 1.2 2011/01/19 16:25:32 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.venda.proposta.facade;


import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <P><B>Description :</B><BR>
 * responsável pela criação de uma proposta com dados basicos passados como parametro
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 *
 *
 * @version $Revision: 1.2 $
 */
public interface PropostaService extends Service{
   
	/**
	 * 
	 * 
	 * @param dadosProspect Entidade que contém os dados da proposta
	 */
	public Bean  inserirProposta(Bean dadosProposta);
	
	
	public void atualizaStatusProposta(Long idProposta, Integer status);		
	
	
	public void finalizarProposta(Bean bean);
	
	/**
	 * @param dadosCobranca Entidade que contém os dados da cobranca
	 */
	public void  manterDadosCobranca(final Bean dadosCobranca);
	
	public Boolean validateDadosProposta(Long idProposta);
	
	public Boolean validateDadosBasicosProposta(Long idProposta);
	
    public void executarAgendamento(Long idProposta);
	
   
			

}
