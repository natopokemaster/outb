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
 * $Id: GescomConstants.java,v 1.3 2011/08/26 14:41:28 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.gescom.constants;
/**
 * Constantes Gerais
 * @author diego.amaral
 *
 */
public final class GescomConstants {

	private GescomConstants(){}

	/**
	 * Tag que identifica inicio de texto Sublinhado na ContentRenderer.
	 */
	public static final String INI_UNDERLINE = "<u>";
	/**
	 * Tag de reposicao para de inicio texto em negrito no jasper report.
	 */
	public static final String INI_REP_BOLD = "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">";
	/**
	 * Tag de reposicao para de inicio texto em Italico no jasper report.
	 */
	public static final String INI_REP_ITALIC = "<style isItalic=\"true\" pdfFontName=\"Helvetica-BoldOblique\"> ";
	/**
	 * Tag de reposicao para de inicio texto em sublinhado no jasper report.
	 */
	public static final String INI_REP_ULINE = "<style isUnderline=\"true\" pdfFontName=\"Helvetica\">";

	public static final String END_TAG = "(</b>|</i>|</u>)";

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
}
