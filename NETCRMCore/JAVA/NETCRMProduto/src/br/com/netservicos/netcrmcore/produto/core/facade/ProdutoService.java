/*
 * Created on 28/09/2010
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

import java.util.List;

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
 * @since 28/09/2010
 * @version 1.0
 */
public interface ProdutoService extends Service{

   /**
    * <p>
    * <b>Description:</b><br/>
    * <p>
    * Metodo responsavel por manter os dados de endereço de cobrança de um prospect.
    * 
    * @param DynamicBean
    * @author Alessandro Mariano
    * @since 28/09/2010
    */
   void inserirProdutoProposta(final DynamicBean dadosProdutoProposta);

   /**
    * <p>
    * <b>Description:</b><br/>
    * <p>
    * Metodo responsavel por deletar os produtos inseridos na proposta.
    * 
    * @param DynamicBean
    * @author Alessandro Mariano
    * @since 19/10/2010
    */
   void deleteAllProdutosProposta(final DynamicBean dadosDeleteProduto);

   /**
    * <p>
    * <b>Description:</b><br/>
    * <p>
    * Metodo responsavel por deletar os produtos inseridos na proposta.
    * 
    * @param DynamicBean
    * @return List<DynamicBean>
    * @author Alessandro Mariano
    * @since 20/10/2010
    */
   void deleteLstProdutosProposta(final DynamicBean dadosAgregado);

   /**
    * <p>
    * <b>Description:</b><br/>
    * <p>
    * Metodo responsavel por deletar os produtos inseridos na proposta.
    * 
    * @param DynamicBean
    * @return List<DynamicBean>
    * @author Alessandro Mariano
    * @since 20/10/2010
    */
   List<?> consultarProdutosContratados(final DynamicBean dadosProdutoContratado);
}
