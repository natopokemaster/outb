/*
 * Created on 25/01/2005
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
package br.com.netservicos.core.bean.sn;

import java.util.List;

import br.com.netservicos.framework.core.bean.WebBean;
import br.com.netservicos.framework.util.BaseConstants;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_tipo_assinante.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 25/01/2005 Ramon Carvalho N/A      Entidades      Created.
 * 25/01/2005 Ramon Carvalho 1.0      Entidades      Development.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_tipo_assinante"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 *                  lazy="true"
 *                  
 * @hibernate.cache
 *      usage="read-write"
 * 
 * @hibernate.query name  = "lstSnTipoAssinante"
 *                   query = "FROM	br.com.netservicos.core.bean.sn.SnTipoAssinanteBean tipoAssinante
 * 							 ORDER BY tipoAssinante.descricao"
 *     
 *                                      
 * 
 */
public class SnTipoAssinanteBean extends WebBean {

	private Integer idTipoAssinante;

	private String descricao;

	private Integer codigoSefaz = CODIGO_SE_FAZ;

	private String cfop = CFOP;

	private Integer adesaoFimDemo = ADESAO_FIM_DEMO;

	private List promocoes;

	private List tipoVendas;

	private List relCidades;

	private List relTipoSolicitacoes;

	private List relClassePrecos;

	private List relTipoVenda;
	private List relPromocao;

	public static final String ATRIBUTO_ID_TIPO_ASSINANTE = "idTipoAssinante";

	public static final Integer ADESAO_FIM_DEMO = new Integer(0);
	public static final Integer CODIGO_SE_FAZ = new Integer(3);
	public static final String CFOP = "5307";
	public static final String ATRIBUTO_REL_CLASSE_PRECO_TIPO_ASSINANTE = "relClassePrecos";
	public static final String ATRIBUTO_REL_TIPO_ASSINANTE_OPERADORA = "relCidades";
	public static final String ATRIBUTO_REL_TIPO_ASSINANTE_TIPO_SOLIC = "relTipoSolicitacoes";
	public static final String ATRIBUTO_REL_TIPO_ASSINANTE_TIPO_VENDA = "relTipoVenda";
	public static final String ATRIBUTO_REL_TIPO_ASSINANTE_PROMOCAO = "relPromocao";

	/**
	 *  
	 */
	public SnTipoAssinanteBean() {
		super(ATRIBUTO_ID_TIPO_ASSINANTE);
		metaData.put(BaseConstants.GENERATOR_TYPE,
				BaseConstants.GENERATOR_TYPE_SEQUENCE);
		metaData.put(BaseConstants.GENERATOR_SEQUENCE_NAME,
				"ssn_id_tipo_assinante");
		metaData.put(ATRIBUTO_REL_CLASSE_PRECO_TIPO_ASSINANTE,
				SnRelClassePrecoTipoAssinanteBean.class);
		metaData.put(ATRIBUTO_REL_TIPO_ASSINANTE_OPERADORA,
				SnRelTipoAssinanteOperadoraBean.class);
		metaData.put(ATRIBUTO_REL_TIPO_ASSINANTE_TIPO_SOLIC,
				SnRelTipoAssinanteTipoSolicBean.class);
		metaData.put(ATRIBUTO_REL_TIPO_ASSINANTE_TIPO_VENDA,
				SnRelTipoVendaTipoAssinanteBean.class);
		metaData.put(ATRIBUTO_REL_TIPO_ASSINANTE_PROMOCAO,
				SnRelPromocaoTipoAssinanteBean.class);
	}

	public SnTipoAssinanteBean(Integer idTipoAssinante) {
		this();
		this.idTipoAssinante = idTipoAssinante;
	}

	/**
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * unsaved-value = "null"
	 * column="id_tipo_assinante"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getIdTipoAssinante() {
		return idTipoAssinante;
	}

	/**
	 * @param idTipoAssinante The idTipoAssinante to set.
	 * 
	 */
	public void setIdTipoAssinante(Integer idTipoAssinante) {
		this.idTipoAssinante = idTipoAssinante;
	}

	/**
	 * Obtains and returns the new value of the adesaoFimDemo attribute.
	 *
	 * @return Returns the adesaoFimDemo.
	 * 
	 * @hibernate.property
	 * column="adesao_fim_demo"
	 * type = "int"
	 * 
	 */
	public Integer getAdesaoFimDemo() {
		return adesaoFimDemo;
	}

	/**
	 * @param adesaoFimDemo The adesaoFimDemo to set.
	 * 
	 */
	public void setAdesaoFimDemo(Integer adesaoFimDemo) {
		this.adesaoFimDemo = adesaoFimDemo;
	}

	/**
	 * Obtains and returns the new value of the cfop attribute.
	 *
	 * @return Returns the cfop.
	 * 
	 * @hibernate.property
	 * column="cfop"
	 * type = "string"
	 * 
	 */
	public String getCfop() {
		return cfop;
	}

	/**
	 * @param cfop The cfop to set.
	 * 
	 */
	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	/**
	 * Obtains and returns the new value of the codigoSefaz attribute.
	 *
	 * @return Returns the codigoSefaz.
	 * 
	 * @hibernate.property
	 * column="codigo_sefaz"
	 * type = "int"
	 * 
	 */
	public Integer getCodigoSefaz() {
		return codigoSefaz;
	}

	/**
	 * @param codigoSefaz The codigoSefaz to set.
	 * 
	 */
	public void setCodigoSefaz(Integer codigoSefaz) {
		this.codigoSefaz = codigoSefaz;
	}

	/**
	 * Obtains and returns the new value of the descricao attribute.
	 *
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * column="descricao"
	 * type = "string"
	 * 
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao The descricao to set.
	 * 
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao != null ? descricao.toUpperCase() : null;
	}

	/**
	 * @hibernate.bag table = "SN_REL_PROMOCAO_TIPO_ASSINANTE"
	 * lazy = "true" 
	 * inverse = "true"
	 * @hibernate.collection-key column = "ID_TIPO_ASSINANTE" 
	 * @hibernate.collection-many-to-many
	 * class = "br.com.netservicos.core.bean.sn.SnPromocaoBean"
	 * column = "ID_PROMOCAO" 
	 * @return
	 * 
	 */
	public List getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List promocoes) {
		this.promocoes = promocoes;
	}

	/**
	 * @hibernate.bag table = "SN_REL_TIPO_VENDA_TIPO_ASN"
	 * lazy = "true" 
	 * inverse = "true"
	 * @hibernate.collection-key column = "ID_TIPO_ASSINANTE" 
	 * @hibernate.collection-many-to-many 
	 * class = "br.com.netservicos.core.bean.sn.SnTipoVendaBean"
	 * column = "ID_TIPO_VENDA" 
	 * @return
	 * 
	 */
	public List getTipoVendas() {
		return tipoVendas;
	}

	public void setTipoVendas(List tipoVendas) {
		this.tipoVendas = tipoVendas;
	}

	/**
	 * @hibernate.bag table = "SN_REL_TIPO_ASSINANTE_OPER"
	 * lazy = "true" 
	 * inverse = "true"
	 * @hibernate.collection-one-to-many 
	 * class = "br.com.netservicos.core.bean.sn.SnRelTipoAssinanteOperadoraBean"
	 * @hibernate.collection-key
	 * column = "id_tipo_assinante"
	 */
	public List getRelCidades() {
		return relCidades;
	}

	public void setRelCidades(List relCidades) {
		this.relCidades = relCidades;
	}

	/**
	 * @hibernate.bag table = "SN_REL_CLASSE_PRECO_TIPO_ASS"
	 * lazy = "true" 
	 * inverse = "true"
	 * @hibernate.collection-one-to-many 
	 * class = "br.com.netservicos.core.bean.sn.SnRelClassePrecoTipoAssinanteBean"
	 * @hibernate.collection-key
	 * column = "id_tipo_assinante"
	 * @return
	 * 
	 */
	public List getRelClassePrecos() {
		return relClassePrecos;
	}

	public void setRelClassePrecos(List relClassePrecos) {
		this.relClassePrecos = relClassePrecos;
	}

	/**
	 * @hibernate.bag table = "SN_REL_TP_ASSINANTE_TP_SOLIC"
	 * lazy = "true" 
	 * inverse = "true"
	 * @hibernate.collection-one-to-many 
	 * class = "br.com.netservicos.core.bean.sn.SnRelTipoAssinanteTipoSolicBean"
	 * @hibernate.collection-key
	 * column = "id_tipo_assinante"
	 * 
	 */
	public List getRelTipoSolicitacoes() {
		return relTipoSolicitacoes;
	}

	public void setRelTipoSolicitacoes(List relTipoSolicitacoes) {
		this.relTipoSolicitacoes = relTipoSolicitacoes;
	}

	/**
	 * @hibernate.bag table = "SN_REL_TIPO_VENDA_TIPO_ASN"
	 * lazy = "true" 
	 * inverse = "true"
	 * @hibernate.collection-one-to-many 
	 * class = "br.com.netservicos.core.bean.sn.SnRelTipoVendaTipoAssinanteBean"
	 * @hibernate.collection-key
	 * column = "id_tipo_assinante"
	 */
	public List getRelTipoVenda() {
		return relTipoVenda;
	}

	public void setRelTipoVenda(List relTipoVenda) {
		this.relTipoVenda = relTipoVenda;
	}

	/**
	 * @hibernate.bag table = "SN_REL_PROMOCAO_TIPO_ASSINANTE"
	 * lazy = "true" 
	 * inverse = "true"
	 * @hibernate.collection-one-to-many 
	 * class = "br.com.netservicos.core.bean.sn.SnRelPromocaoTipoAssinanteBean"
	 * @hibernate.collection-key
	 * column = "id_tipo_assinante"
	 */
	public List getRelPromocao() {
		return relPromocao;
	}

	public void setRelPromocao(List relPromocao) {
		this.relPromocao = relPromocao;
	}

}
