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
 * $Id: CreditoService.java,v 1.2 2011/01/19 16:25:26 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.cliente.core.facade;


import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <P><B>Description :</B><BR>
 * responsável pela verificacao do credito com os dados da proposta passado como parametro;
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
public interface CreditoService extends Service{
   
	/**
	 * 
	 * @param dados
	 * @return
	 */
	DynamicBean checarCreditoInterno(DynamicBean dados);
	
	/**
	 * 
	 * @param dados
	 * @return
	 */
	DynamicBean checarCreditoExterno(DynamicBean dados);
	
	/**
	 * 
	 * @param dados
	 * @return
	 */
	void consomeWebServiceSerasa(DynamicBean dados);
	
	/**
	 * 
	 * @param dados
	 * @return
	 */
    DynamicBean checarCreditoInternoExterno(DynamicBean dados);
    	
}
