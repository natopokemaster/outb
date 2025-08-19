/**
 * Created on 02/06/2005
 * Project : ADM 
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.geo;

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * @author  :Luciano Teixeira 
 * @version : 
 * <P><B>* 
 * </B>
 * <BR>
 * TODO:
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By	
 * ---------------------------------------- ----------- ------------------------- 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                             Prior
 * Date       By               Version  Description
 * ---------- ---------------- -------- -----------------------------------------
 * 02/06/2005 Luciano Teixeira N/A      Created 	
 * ==============================================================================
 * </PRE>
 * @hibernate.class table = "geo_tipo_edificacao"
 * 					lazy="false"
 * 
 * @hibernate.cache
 *      usage = "read-write"
 * 
 * @hibernate.query name  = "lstGeoTipoEdificacoes"
 *                  query = "FROM br.com.netservicos.core.bean.geo.GeoTipoEdificacaoBean tipoEdificacao
 * 							 ORDER BY	tipoEdificacao.descricaoTipo "
 *
 *  
 */
public class GeoTipoEdificacaoBean extends WebBean {

	private String codTipoEdificacao;

	private String descricaoTipo;

	public static final String ATRIBUTO_COD_TIPO_EDIFICACAO = "codTipoEdificacao";

	public GeoTipoEdificacaoBean() {
		super(ATRIBUTO_COD_TIPO_EDIFICACAO);
	}

	public GeoTipoEdificacaoBean(String codTipoEdificacao) {
		this();
		this.codTipoEdificacao = codTipoEdificacao;
	}

	/**
	 * Retorna o cidContrato.
	 * @return Returns the cidContrato.
	 * @hibernate.id 
	 * 		generator-class="assigned"
	 * 		unsaved-value = "null"
	 * 		column="cod_tipo_edificacao"
	 * 
	 */
	public String getCodTipoEdificacao() {
		return this.codTipoEdificacao;
	}

	/**
	 * @param codTipoEdificacao O código do tipo de edificação. 
	 * 
	 */
	public void setCodTipoEdificacao(String codTipoEdificacao) {
		this.codTipoEdificacao = codTipoEdificacao;
	}

	/**
	 * Retorna a descrição tipo
	 * @return Retorna a descricaoTipo.
	 * @hibernate.property
	 * column="descricao_tipo"
	 * type = "string"
	 * 
	 */
	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	/**
	 * 
	 * @param descricaoTipo A descrição tipo.
	 * 
	 */
	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}

}
