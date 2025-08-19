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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_tipo_os.
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
 *                            Prior
 * Date       By              Version  Project/CSR    Description
 * ---------- --------------  -------- -------------- ---------------------------
 * 16/05/2005 Ricardo Limonta N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_tipo_os"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 *                  lazy="false"
 *                  
 * @hibernate.cache
 *      usage = "read-write"
 *
 * @hibernate.query name  = "lstSnTipoOs"
 *                   query = "FROM br.com.netservicos.core.bean.sn.SnTipoOsBean bean
 * 							 ORDER BY bean.descricao"
 *
 * @hibernate.query name  = "lstSnTipoOsIdDesc"
 *                   query = "SELECT tipoOs.idTipoOs, tipoOs.descricao                   
 *                   FROM br.com.netservicos.core.bean.sn.SnTipoOsBean tipoOs
 *                   ORDER BY tipoOs.descricao"
 * 
 * 
 */
public class SnTipoOsBean extends DomainBean {

	/**
     * 
     */
    private static final long serialVersionUID = 8680568139847714732L;

    private Integer idTipoOs;

	private String descricao;

	private String descricaoAbrev;

	private SnStatusContratoBean statusContrato;

	private Integer cobraAntes;

	private Integer cobraDepois;

	private Integer emAtendimento;

	private Integer vencimento;

	private String descricaoCnab;

	private Integer prioridade;

	private Integer valido;

	public static final String ATRIBUTO_ID_TIPO_OS = "idTipoOs";

	public static final String LST_TIPO_OS_ID_DESC = "lstSnTipoOsIdDesc";

	/**
	 * Default method constructor.
	 * 
	 */
	public SnTipoOsBean() {
		super(ATRIBUTO_ID_TIPO_OS);
	}

	/**
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * unsaved-value = "null"
	 * column="ID_TIPO_OS"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getIdTipoOs() {
		return idTipoOs;
	}

	/**
	 * @param idTipoOs The idTipoOs to set.
	 * 
	 */
	public void setIdTipoOs(Integer idTipoOs) {
		this.idTipoOs = idTipoOs;
	}

	/**
	 * Obtains and returns the new value of the descricao attribute.
	 *
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * column="DESCRICAO"
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
		this.descricao = descricao;
	}

	/**
	 * Obtains and returns the new value of the descricaoAbrev attribute.
	 *
	 * @return Returns the descricaoAbrev.
	 * 
	 * @hibernate.property
	 * column="DESCRICAO_ABREV"
	 * type = "string"
	 * 
	 */
	public String getDescricaoAbrev() {
		return descricaoAbrev;
	}

	/**
	 * @param descricaoAbrev The descricaoAbrev to set.
	 * 
	 */
	public void setDescricaoAbrev(String descricaoAbrev) {
		this.descricaoAbrev = descricaoAbrev;
	}

	/**
	 * @return SnStatusContratoBean statusContrato with the updated value of the 
	 * statusContrato attribute
	 * 
	 * @hibernate.many-to-one  
	 * name="statusContrato"
	 * not-null="false"
	 * class="br.com.netservicos.core.bean.sn.SnStatusContratoBean" 
	 * column="ID_NOVO_STATUS" 
	 * 
	 */
	public SnStatusContratoBean getStatusContrato() {
		return statusContrato;
	}

	/** 
	 * @param SnStatusContratoBean statusContrato with the updated value of the 
	 * statusContrato attribute
	 * 
	 */
	public void setStatusContrato(SnStatusContratoBean statusContrato) {
		this.statusContrato = statusContrato;
	}

	/**
	 * 
	 * @return Returns the cobraAntes.
	 * 
	 * @hibernate.property
	 * column="COBRA_ANTES"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getCobraAntes() {
		return cobraAntes;
	}

	/**
	 * @param cobraAntes The cobraAntes to set.
	 * 
	 */
	public void setCobraAntes(Integer cobraAntes) {
		this.cobraAntes = cobraAntes;
	}

	/**
	 * 
	 * @return Returns the cobraDepois.
	 * 
	 * @hibernate.property
	 * column="COBRA_DEPOIS"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getCobraDepois() {
		return cobraDepois;
	}

	/**
	 * @param cobraDepois The cobraDepois to set.
	 * 
	 */
	public void setCobraDepois(Integer cobraDepois) {
		this.cobraDepois = cobraDepois;
	}

	/**
	 * 
	 * @return Returns the emAtendimento.
	 * 
	 * @hibernate.property
	 * column="EM_ATENDIMENTO"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getEmAtendimento() {
		return emAtendimento;
	}

	/**
	 * @param emAtendimento The emAtendimento to set.
	 * 
	 */
	public void setEmAtendimento(Integer emAtendimento) {
		this.emAtendimento = emAtendimento;
	}

	/**
	 * 
	 * @return Returns the vencimento.
	 * 
	 * @hibernate.property
	 * column="VENCIMENTO"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getVencimento() {
		return vencimento;
	}

	/**
	 * @param vencimento The vencimento to set.
	 * 
	 */
	public void setVencimento(Integer vencimento) {
		this.vencimento = vencimento;
	}

	/**
	 * Obtains and returns the new value of the descricaoCnab attribute.
	 *
	 * @return Returns the descricaoCnab.
	 * 
	 * @hibernate.property
	 * column="DESCRICAO_CNAB"
	 * type = "string"
	 * 
	 */
	public String getDescricaoCnab() {
		return descricaoCnab;
	}

	/**
	 * @param descricao The descricaoCnab to set.
	 * 
	 */
	public void setDescricaoCnab(String descricaoCnab) {
		this.descricaoCnab = descricaoCnab;
	}

	/**
	 * @return Returns the prioridade.
	 * 
	 * @hibernate.property
	 * column="PRIORIDADE"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getPrioridade() {
		return prioridade;
	}

	/**
	 * @param vencimento The prioridade to set.
	 * 
	 */
	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	/**
	 * @return Returns the valido.
	 * 
	 * @hibernate.property
	 * column="VALIDO"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getValido() {
		return valido;
	}

	/**
	 * @param valido The valido to set.
	 * 
	 */
	public void setValido(Integer valido) {
		this.valido = valido;
	}
}
