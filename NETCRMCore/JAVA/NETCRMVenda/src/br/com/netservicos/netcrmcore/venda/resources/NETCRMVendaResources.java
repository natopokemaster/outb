/**
 * Created on 02/07/2007
 * Project : NETExemplo
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
 * $Id: NETCRMVendaResources.java,v 1.5 2011/03/17 17:18:23 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.venda.resources;

/**
 * <P><B>Description :</B><BR>
 * 	TODO descrever
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Robin Michael Gray
 * @since 02/07/2007
 */
public final  class NETCRMVendaResources {
	
	/**
	 * Mapping for the bundle
	 */
	public final static String BUNDLE_NAME = "br/com/netservicos/netcrmcore/venda/resources/NETCRMVendaResourcesMessages";

	private NETCRMVendaResources(){
	     super();
	}
	   
	public final static String ERRO_EXEMPLO_TEST = "erro.exemplo.test";
	
	public final static String EXEMPLO_TASK_MESSAGE_GENERICO = "info.msg.generico";
	public final static String EXEMPLO_TASK_MESSAGE_STATISTIC_1 = "info.msg.statistic.1";
	public final static String EXEMPLO_TASK_MESSAGE_STATISTIC_2 = "info.msg.statistic.2";
	public static final String RESOURCE_PROPOSTA_INEXISTENTE = "CRMCORE-0076";
	public final static String DDD_INVALIDO = "CRMCORE-0077";
    public final static String TEL_INVALIDO = "CRMCORE-0078";
    
    public static final String ERRO_VALIDACAO = "CRMCORE-0072";
    public static final String REGISTRO_NAO_ENCONTRADO = "CRMCORE-0070";
    public static final String REGISTRO_INCONSISTENTE = "CRMCORE-0071";
    public static final String REGISTRO_LOCAL_DOMICILIO_NAO_ENCONTRADO = "CRMCORE-0073";
    public static final String REGISTRO_PLANO_PGTO_NAO_ENCONTRADO = "CRMCORE-0074";
}
