/**
* Created on 01/03/2010
* Project : NETCommon
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
* $Id: SnRelPontoExtensaoBean.java,v 1.5 2011/01/26 12:12:57 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;


import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_rel_ponto_extensao
 * </P>
 * <P>
 * <B> Issues : <BR>
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    	Description
 * ---------- -------------- -------- --------------    -------------------------
 * 01/03/2010 mcalegari      N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author Mauro Cesar Calegari
 * @since 01/03/2010
 * @version $Revision: 1.5 $
 *
 * @hibernate.class 
 *		table="sn_rel_ponto_extensao"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *
 */
public class SnRelPontoExtensaoBean extends DomainBean {
	
	private static final long serialVersionUID = -4693141557491376749L;
	
	public static final String COMPOSITE_KEY = "compositeKey";
	
	public static final String ID_REL_PONTO_EXTENSAO = "id_extensao";
	public static final String GET_ID_REL_PONTO_EXTENSAO = "getIdRelPontoExtensao";
	
	private SnRelPontoExtensaoKey snRelPontoExtensaoKey;
	private Long idPonto;
	private Integer idLocalizacao;
	private Integer instalado;
	private String obsLocalizacao;

	public SnRelPontoExtensaoBean() {
		super(COMPOSITE_KEY);
	}
	
	public SnRelPontoExtensaoBean(SnRelPontoExtensaoKey snRelExtensaoKey) {
		this();
		this.snRelPontoExtensaoKey = snRelExtensaoKey;
	}

	/**
	 * @return Returns the compositeKey.
	 *
     * @hibernate.id
     * type = "composite"
	 */
	public SnRelPontoExtensaoKey getSnRelPontoExtensaoKey() {
		return snRelPontoExtensaoKey;
	}
	
	public void setSnRelPontoExtensaoKey(SnRelPontoExtensaoKey snRelPontoExtensaoKey) {
		this.snRelPontoExtensaoKey = snRelPontoExtensaoKey;
	}
	
	/**
	 * @return Returns the Id Ponto.
	 *
	 * @hibernate.property
	 *		column="id_ponto"
	 *		type="long"
	 */
	public Long getIdPonto() {
		return idPonto;
	}
	
	public void setIdPonto(Long idPonto) {
		this.idPonto = idPonto;
	}
	
	/**
	 * @return Returns the Id Localização.
	 *
	 * @hibernate.property
	 *		column="id_localizacao"
	 *		type="integer"
	 */
	public Integer getIdLocalizacao() {
		return idLocalizacao;
	}
	
	public void setIdLocalizacao(Integer idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}
	
	/**
	 * @return Returns the instalado.
	 *
	 * @hibernate.property
	 *		column="instalado"
	 *		type="integer"
	 */
	public Integer getInstalado() {
		return instalado;
	}
	
	public void setInstalado(Integer instalado) {
		this.instalado = instalado;
	}
	
	/**
	 * @return Returns the Observacao Localizacao.
	 *
	 * @hibernate.property
	 *		column="obs_localizacao"
	 *		type="string"
	 */
	public String getObsLocalizacao() {
		return obsLocalizacao;
	}
	
	public void setObsLocalizacao(String obsLocalizacao) {
		this.obsLocalizacao = obsLocalizacao;
	}
}
