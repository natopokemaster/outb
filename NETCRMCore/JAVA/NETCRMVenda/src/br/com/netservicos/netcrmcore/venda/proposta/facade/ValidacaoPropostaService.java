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
 * $Id: ValidacaoPropostaService.java,v 1.2 2011/01/19 16:25:32 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.venda.proposta.facade;


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
public interface ValidacaoPropostaService extends Service{
   
    public Boolean validarDadosProposta(Long idProposta);

}
