/*
 * Created on 03/06/2011
 * Project : NETCRMGesCom
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.netcrmcore.gescom.constants;

/**
 * <p>
 * <b>Description: </b><br>
 *
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Jorge Augusto
 * @since 03/06/2011
 * @version 1.0
 */
public final class ReciboConstants {

	private ReciboConstants(){}

	//Campos do Net Header
	public static final String NET_HEADER = "header";

	//EJB Recibo Relacionamento
	public static final String RECIBO_RELACIONAMENTO = "reciboRelacionamento";
	public static final String CODIGO_OPERADORA	= "cdOperadora";
	public static final String TIPO_RELACIONAMENTO	= "tipoRelacionamento";
	public static final String CID_CONTRATO	= "cidContrato";
	public static final String TIPO_RECIBO_VENDA = "VENDA";
	public static final String ID_PRODUTO = "idProduto";
	public static final String TP_EVENTO = "tpEvento";
	public static final String ENVIO_PADRAO = "ENVIO_PADRAO";
	public static final String ID_FORMA_ENVIO = "idFormaEnvio";
	public static final String NR_ORDEM	= "nrOrdem";
	public static final String PPV = "PPV";
	public static final String ID_RECIBO_RELACIONAMENTO = "idReciboRelacionamento";
	public static final String ID_EVENTO = "idEvento";
	public static final String ID_TIPO_RELACIONAMENTO = "idTipoRelacionamento";
	public static final int ZERO = 0;
	

	//ReciboRelacionamento12V1JWS
	public static final String NODE_PROTOCOLO = "//reciboRelacionamento/Protocolo/text()";

	public static final String WEB_SERVICE_NAME = "ReciboRelacionamento12V1JWS";
	public static final String WEB_SERVICE_SERVICE_NAME = "ReciboRelacionamento12V1JWSService";
	public static final String WEB_SERVICE_TARGET = "http://www.netservicos.com.br/netcrmcore/ReciboRelacionamento12V1";

	public static final String WEB_METHOD_CRIAR_ACTION = "criarReciboRelacionamento";

	public static final String WEB_PARAM_HEADER_NAME = "NETFrameworkWSHeader";
	public static final String WEB_PARAM_HEADER_TARGET = "java:br.com.netservicos.framework.webservice.header";
	public static final String WEB_PARAM_CRIAR_NAME = "criarReciboRelacionamento";
	public static final String WEB_PARAM_TARGET
		= "java:br.com.netservicos.netcrmcore.webservices.reciborelacionamento.complextypes";

	public static final String WEB_RESULT_CRIAR_RECIBO_NAME 		= "idReciboRelacionamento";
	public static final String WEB_RESULT_CRIAR_RECIBO_PARTNAME 	= "criarReciboRelacionamento";
	public static final String WEB_RESULT_TARGET
		= "java:br.com.netservicos.netcrmcore.webservices.reciborelacionamento.complextypes";



}

