/**
 * Created on 29/12/2009
 * Project : NETCliente
 *
 * Copyright � 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Servi�os.
 * 
 * $Id: ProspectService.java,v 1.2 2011/01/19 16:25:32 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.prospect.core.facade;


import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <P><B>Description :</B><BR>
 * respons�vel pela cria��o de uma proposta com dados basicos passados como parametro e alteracao 
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
public interface ProspectService extends Service{
   
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * M�todo responsavel por criar o prospect,proposta e associar o endere�o de 
     *     instala�ao com o HP
     * 
     * @param dadosProsposta
     * @return id prospect e id proposta 
     * @since 22/09/2010
     */
     Bean criarProposta(Bean dadosProsposta);  
	
	
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * Alteacao dos dados pessoais da prospect
     * 
     * @param bean
     * 
     * @since 22/09/2010
     */
    void alterarDadosPessoais(Bean bean);
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * Metodo responsavel por manter os dados de endere�o de cobran�a de um prospect.
     * 
     * @param dadosProsposta
     * @author Alessandro Mariano
     * @since 22/09/2010
     */
    void manterDadosEnderecoCobranca(Bean dadosEnderecoCobranca);
	

}
