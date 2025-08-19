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
package br.com.netservicos.netcrmcore.gescom.constants;

/**
 * <p>
 * <b>Description: </b><br>
 *
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 20/04/2011
 * @version 1.0
 */
public final class AvisoConstants {

    public static final String PARAM_BASE_LOGADA = "baseLogada";
    public static final String PARAM_POSSUI_COMBO_MULTI = "possuiComboMulti";
    public static final String SIM = "SIM";
    public static final String NAO = "NAO";

	//Campos do Net Header
	public static final String NET_HEADER = "header";

	//Constantes EJB
	public static final String CID_CONTRATO 		= "cidContrato";
	public static final String MOTIVO				= "motivo";
	public static final String USUARIO				= "usuario";
	public static final String IDENTIFICADOR_AVISO	= "identificadorAviso";
	public static final String DH_GERACAO 			= "dhGeracao";
	public static final Long ID_STATUS_PENDENTE 	= 1L;

	//AvisoRelacionamento12V1JWS
	public static final String WEB_SERVICE_NAME 			= "AvisoRelacionamento12V1JWS";
	public static final String WEB_SERVICE_SERVICE_NAME 	= "AvisoRelacionamento12V1JWSService";
	public static final String WEB_SERVICE_TARGET
		= "http://www.netservicos.com.br/netcrmcore/AvisoRelacionamento12V1";

	public static final String WEB_METHOD_CONSULTAR_ACTION 			= "consultar";
	public static final String WEB_METHOD_GERAR_PDF_ACTION 			= "gerarPDF";
	public static final String WEB_METHOD_SOLICITAR_REENVIO_ACTION 	= "solicitarReenvio";

	public static final String WEB_PARAM_HEADER_NAME 				= "NETFrameworkWSHeader";
	public static final String WEB_PARAM_HEADER_TARGET = "java:br.com.netservicos.framework.webservice.header";
	public static final String WEB_PARAM_TARGET
		= "java:br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes";
	public static final String WEB_PARAM_CONSULTAR_NAME 			= "consultar";
	public static final String WEB_PARAM_GERAR_PDF_NAME 			= "gerarPDF";
	public static final String WEB_PARAM_SOLICITAR_REENVIO_NAME 	= "solicitarReenvio";
	public static final String WEB_PARAM_IDENTIFICADOR_CIDADE_NAME 	= "identificadorCidade";

	public static final String WEB_RESULT_CONSULTAR_NAME 				= "consultarRetorno";
	public static final String WEB_RESULT_CONSULTAR_PARTNAME 			= "consultarResponse";
	public static final String WEB_RESULT_GERAR_PDF_NAME 				= "gerarPDFRetorno";
	public static final String WEB_RESULT_GERAR_PDF_PARTNAME 			= "gerarPDFResponse";
	public static final String WEB_RESULT_SOLICITAR_REENVIO_NAME 		= "solicitarReenvioRetorno";
	public static final String WEB_RESULT_SOLICITAR_REENVIO_PARTNAME 	= "solicitarReenvioResponse";
	public static final String WEB_RESULT_TARGET
		= "java:br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes";

	/**
	 * Tag que identifica inicio de texto Negrigo na Carta.
	 */
	public static final String INIT_BOLD = "<b>";
	/**
	 * Tag que identifica fim de texto Negrigo na Carta.
	 */
	public static final String END_BOLD = "</b>";
	/**
	 * Tag que identifica inicio de texto Italico na Carta.
	 */
	public static final String INIT_ITALIC = "<i>";
	/**
	 * Tag que identifica fim de texto Italico na Carta.
	 */
	public static final String END_ITALIC = "</i>";
	/**
	 * Tag que identifica inicio de texto Sublinhado na Carta.
	 */
	public static final String INIT_UNDERLINE = "<u>";
	/**
	 * Tag que identifica fim de texto Sublinhado na Carta.
	 */
	public static final String END_UNDERLINE = "</u>";
	/**
	 * Tag de reposicao para de inicio texto em negrito no jasper report.
	 */
	public static final String INIT_REPLACEMENT_BOLD = "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">";
	/**
	 * Tag de reposicao para de inicio texto em Italico no jasper report.
	 */
	public static final String INIT_REPLACEMENT_ITALIC =
							"<style isItalic=\"true\" pdfFontName=\"Helvetica-BoldOblique\"> ";
	/**
	 * Tag de reposicao para de inicio texto em sublinhado no jasper report.
	 */
	public static final String INIT_REPLACEMENT_UNDERLINE = "<style isUnderline=\"true\" pdfFontName=\"Helvetica\">";
	/**
	 * Tag  de reposicao para fim texto em negrito, italico ou sublinhado no jasper report.
	 */
	public static final String END_REPLACEMENT = "</style>";



	private AvisoConstants(){}

}
