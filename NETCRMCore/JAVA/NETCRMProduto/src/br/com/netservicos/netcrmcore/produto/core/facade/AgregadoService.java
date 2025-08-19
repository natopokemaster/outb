/*
 * Created on 08/10/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.netcrmcore.produto.core.facade;

import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe responsavel por efetuar operaçoes de Produto
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 08/10/2010
 * @version 1.0
 */
public interface AgregadoService extends Service{

   /**
    * <p>
    * <b>Description:</b><br/>
    * <p>
    * Metodo responsavel por manter os dados de endereço de cobrança de um prospect.
    * 
    * @param Bean
    * @author Alessandro Mariano
    * @since 08/10/2010
    */
   void inserirAgregadoProposta(final DynamicBean dadosProdutoProposta);

}
