/**
 * Created on 25/09/2009
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
 * $Id: ManutencaoDadosContatoService.java,v 1.2 2011/01/24 18:05:50 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.cliente.contratovenda.facade;


import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <P><B>Description :</B><BR>
 * Implementa o servico de manutencao de dados do contato
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
public interface ManutencaoDadosContatoService extends Service{
   
	/**
	* 
	* Operação que realiza as alterações de dados de contato do Assinante.
	* A operação recebe o bean contendo a identificação do contrato do cliente, além das novas informações de contato.
	* 
	* @param dadosContato Entidade que contém os dados de contato para um assinante específico.
	*/
	void alterarDadosContatoTitular(Bean dadosContato);
	
	/**
	* 
	* Operação que realiza as validações dos dados de contato do Assinante.
	* A operação recebe o bean contendo a identificação do contrato do cliente, além das novas informações de contato.
	* 
	* @param dadosContato Entidade que contém os dados de contato para um assinante específico.
	*/
	void validarDadosContatoTitular(Bean dadosContato);

}
