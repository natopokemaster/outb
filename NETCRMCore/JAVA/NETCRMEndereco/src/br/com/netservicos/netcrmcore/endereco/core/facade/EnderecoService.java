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
 * $Id: EnderecoService.java,v 1.2 2011/01/19 16:25:27 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.endereco.core.facade;


import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
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
public interface EnderecoService extends Service{
   
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * Metodo responsavel por validar e associar/alterar o endereco de um prospect com o cod HP passado
     * 
     * @param dadosProsposta
     *  
     * @since 22/09/2010
     */
   DynamicBean alterarEnderecoProspect(Bean dadosProsposta);

   
   /**
    * <p>
    * <b>Description:</b><br/>
    * <p>
    * Metodo responsavel por manter os dados de endereço de cobrança de um prospect.
    * 
    * @param dadosProsposta
    * @author Alessandro Mariano
    * @since 22/09/2010
    */
   DynamicBean processaStatusPayTVEndereco(Long IdProposta,  Long idEnderecoProspect);   
      
   /**
    * <p>
    * <b>Description:</b><br/>
    * <p>
    * Metodo responsavel por retornar o endereco de Instalacao
    * 
    * @param dadosProsposta
    * @author Welligton Maeda
    * @since 22/09/2010
    */
   Boolean validateEnderecoInadimplente(Long idProposta);
   
   /**
    * <p>
    * <b>Description:</b><br/>
    * <p>
    * Metodo responsavel por retornar o endereco de Instalacao
    * 
    * @param dadosProsposta
    * @author Welligton Maeda
    * @since 22/09/2010
    */
   Boolean validateEnderecoInconsistente(Long idProposta);
   
   
}
