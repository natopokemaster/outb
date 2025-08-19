/*
 * Created on 31/03/2011
 * Project : NETGESCOMCommon
 * Copyright © 2011 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.netcrmcore.gescom.avisorelacionamento.carta.pdf;


/**
 *
 * <p><b>Description: </b><br>
 * Carta de Acordo Comercial PDF para clientes Prospect.
 * </p>
 * <b>
 * Issues: <br>
 *
 * </b>
 * @author diego.amaral
 * @since 26/05/2011
 * @version
 */
public class CartaAcordoComercialProspect extends AbstractCartaAcordoComercial {

	/**
	 * Representa o nome do JASPER do acordo comercial.
	 */
	private static final String ACORDO_COMERCIAL_PROSPECT = "AcordoComercialProspect";

	/**
	 * Representa o nome do JASPER para acordo para cliente Prospect.
	 */
	public String getReportName() {
		return ACORDO_COMERCIAL_PROSPECT;
	}
}
