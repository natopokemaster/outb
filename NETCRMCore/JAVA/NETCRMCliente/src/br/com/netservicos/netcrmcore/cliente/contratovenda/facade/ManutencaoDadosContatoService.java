/**
 * Created on 25/09/2009
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
	* Opera��o que realiza as altera��es de dados de contato do Assinante.
	* A opera��o recebe o bean contendo a identifica��o do contrato do cliente, al�m das novas informa��es de contato.
	* 
	* @param dadosContato Entidade que cont�m os dados de contato para um assinante espec�fico.
	*/
	void alterarDadosContatoTitular(Bean dadosContato);
	
	/**
	* 
	* Opera��o que realiza as valida��es dos dados de contato do Assinante.
	* A opera��o recebe o bean contendo a identifica��o do contrato do cliente, al�m das novas informa��es de contato.
	* 
	* @param dadosContato Entidade que cont�m os dados de contato para um assinante espec�fico.
	*/
	void validarDadosContatoTitular(Bean dadosContato);

}
