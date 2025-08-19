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
 * $Id: GerarContratoService.java,v 1.3 2011/01/19 16:25:30 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.prospect.gerarcontrato.facade;


import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <P><B>Description :</B><BR>
 * responsável pela gerar um contrato com os dados da proposta 
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 *
 *
 * @version $Revision: 1.3 $
 */
public interface GerarContratoService extends Service{
   
   
    
    public Bean gerarContrato(Long idProposta);
    
    
    public void tratarErroEnvioContrato(final Long idProposta );

}
