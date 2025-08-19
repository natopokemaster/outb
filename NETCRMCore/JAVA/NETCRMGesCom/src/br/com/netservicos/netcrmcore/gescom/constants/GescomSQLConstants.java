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
 * $Id: GescomSQLConstants.java,v 1.4 2011/08/26 14:41:28 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.gescom.constants;
/**
 * <p>
 * <b>Description: </b><br>
 * Queries executadas pelo gescom.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Jorge Augusto
 * @since 03/06/2011
 * @version 1.0
 */
public final class GescomSQLConstants {

	
	private GescomSQLConstants(){}

	public static final String QRY_ENVIOAVISO_CIDCONTR_PRODUTO =
								"lstSnRelProdutoEnvioAvisoBeanByIdProdutoAndCidContrato";
	public static final String QRY_MOTIVO_REENVIO_POR_DESCRICAO = "procurarMotivoReenvioPorDescricao";
	public static final String QRY_LAYOUT_AVISO 	= "procurarLayoutAvisoParaLayoutAcordoComercial";
	public static final String QRY_FORMA_ENVIO_PPV_PADRAO = "procurarFormasEnvioPPVPadrao";
	public static final String QRY_TP_RELACIONAMENTO_POR_DESC = "procurarTipoRelacionamentoPorDescricao";
	public static final String QRY_CID_CONTR_POR_COD_OP = "procuraCidContratoPorCodOperadora";
	public static final String QRY_RECIBO_POR_EVENTO = "procurarReciboPorEvento";
	// CRMM_1410906_CI_001
	public static final String QRY_ID_RECIBO_EVENTO = "procurarIdReciboPorEvento";
	
	public static final String ATR_NM_ARQUIVO = "nmArquivo";
	public static final String ATR_ID_LAYOUT = "idLayout";
	public static final String ATR_STATUS_GER_AVISO = "0";

}
