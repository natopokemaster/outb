/*
 * Created on 20/04/2011
 * Project : NETCRMGesCom
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.netcrmcore.gescom.avisorelacionamento.facade;

import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.facade.Service;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe responsavel por efetuar operaçoes de Aviso Relacionamento
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/04/2011
 * @version 1.0
 */
public interface AvisoRelacionamentoService extends Service {

	/**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * Metodo responsavel por consultar os dados do Aviso Relacionamento.
     *
     * @param DynamicBean
     * @return Object
     * @author Alessandro Mariano
     * @since 20/10/2010
     */
	Object consultarAvisoRelacionamento(final DynamicBean dadosConsultarAvisoRelacionamento) throws Exception ;

	/**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * Metodo responsavel por gerarPDF dos dados do Aviso Relacionamento.
     *
     * @param DynamicBean
     * @return byte[]
     * @author Alessandro Mariano
     * @since 20/10/2010
     */
	byte[] gerarPDFAvisoRelacionamento(final DynamicBean dadosGerarPDFAvisoRelacionamento) throws Exception ;

	/**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * Metodo responsavel por gerarPDF dos dados do Aviso Relacionamento.
     *
     * @param DynamicBean
     * @return Object
     * @author Alessandro Mariano
     * @since 20/10/2010
     */
	Object gerarXMLAvisoRelacionamento(final DynamicBean dadosGerarPDFAvisoRelacionamento) throws Exception ;

	/**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * Metodo responsavel por reenviar o Aviso Relacionamento.
     *
     * @param DynamicBean
     * @return Long
     * @author Alessandro Mariano
     * @since 20/10/2010
     */
	Long reenviarAvisoRelacionamento(final DynamicBean dadosReenviarAvisoRelacionamento) throws Exception ;
}
