/*
 * Created on 17/08/2007
 * Project : NETCRMGesCom
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
 * $Id: ReciboRelacionamentoService.java,v 1.4 2011/08/26 14:41:31 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.gescom.reciborelacionamento.facade;

import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.Service;
/**
 * Ações de Recibo invocadas pelo serviço.
 * @author diego.amaral
 *
 */
public interface ReciboRelacionamentoService extends Service{

	Long criarReciboRelacionamento(DynamicBean bean) throws Exception ;
}
