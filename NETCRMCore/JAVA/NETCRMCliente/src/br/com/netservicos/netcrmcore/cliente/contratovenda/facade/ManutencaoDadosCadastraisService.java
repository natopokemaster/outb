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
 * $Id: ManutencaoDadosCadastraisService.java,v 1.2 2011/01/24 18:05:50 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.cliente.contratovenda.facade;


import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <P><B>Description :</B><BR>
 * responsável pela validação / alteração dos dados cadastrais do cliente.
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
public interface ManutencaoDadosCadastraisService extends Service{
   
	/**
	 * Operação que realiza as alterações dos dados cadastrais do Assinante. A
	 * operação recebe o bean contendo a identificação do contrato do cliente,
	 * além das novas informações cadastrais.
	 * 
	 * @param dadosCadastrais Entidade que contém os dados cadastrais para um assinante específico.
	 */
	void alterarDadosCadastraisTitular(Bean dadosCadastrais);
	
	/**
	 * Operação que realiza as validações dos dados cadastrais do Assinante. A
	 * operação recebe o bean contendo a identificação do contrato do cliente,
	 * além das novas informações cadastrais.
	 * 
	 * @param dadosCadastrais Entidade que contém os dados cadastrais para um assinante específico.
	 */
	void validarDadosCadastraisTitular(Bean dadosCadastrais);

}
