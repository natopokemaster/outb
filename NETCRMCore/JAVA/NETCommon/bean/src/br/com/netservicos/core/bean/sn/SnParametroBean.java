/*
 * Created on 26/02/2005
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

import java.math.BigDecimal;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela sn_parametro
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
 *                                  Prior
 * Date       By                   Version Project/CSR Description
 * ---------- -------------------- ------- ----------- -------------------------
 * 15/09/2010 Wellington Maeda     N/A     Entidades   Created.  
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_parametro"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 * 				    lazy = "true"
 * 
 * @hibernate.cache
 *      usage="read-write"
 *
 * @hibernate.query name = "findVlrParametro"
 *                  query = "SELECT p.vlrParametro
 *                          FROM br.com.netservicos.core.bean.sn.SnParametroBean p
 *                          WHERE (p.empresa.cidContrato = :cidContrato)
 *                          AND UPPER(p.compositeKey.nomeParametro) LIKE UPPER('%'||:nomeParametro||'%')"
 *                          
 * @hibernate.query name = "lstVlrParametroStr"
 *                  query = "SELECT p.vlrParametroStr
 *                             FROM br.com.netservicos.core.bean.sn.SnParametroBean p
 *                              JOIN p.empresa cidadeOperadora
 *                            WHERE cidadeOperadora.cidContrato = :cidContrato 
 *                              AND UPPER(p.compositeKey.nomeParametro) LIKE UPPER('%'||:nomeParametro||'%')"
 *                                                           
 * @hibernate.query name = "findVlrParametroMulticidades"
 *                  query = "SELECT p.vlrParametro
 *                          FROM br.com.netservicos.core.bean.sn.SnParametroBean p
 *                          WHERE (p.empresa.cidContrato IN (:idCidadesParam))
 *                          AND UPPER(p.compositeKey.nomeParametro) LIKE UPPER('%'||:nomeParametro||'%')"
 *                          
 * @hibernate.query name = "parametroByNomeParametro"
 *                  query = "FROM br.com.netservicos.core.bean.sn.SnParametroBean parametro
 *                           WHERE
 *                              UPPER(parametro.compositeKey.nomeParametro) = UPPER(:compositeKey.nomeParametro)"
 * 
 */
public class SnParametroBean extends DomainBean {

    private static final long serialVersionUID = 2543736785050783472L;
    
    public static final String PARAMETRO_BY_NOME_PARAMETRO = "parametroByNomeParametro";    
    
    public static final String FIND_SN_VLR_PARAMETRO = "findVlrParametro";
    
	private SnParametroKey compositeKey;

	private BigDecimal vlrParametro;

	private String descricao;

	private String instrucao;

	private String vlrParametroStr;

	private Integer processarMestre;

	private SnCidadeOperadoraBean empresa;
	
	private String nomeParametro;

	public SnParametroBean() {
		super("compositeKey");
	}

	/**
	 * @hibernate.id
	 * type = "composite"
	 * 
	 */
	public SnParametroKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 * 
	 */
	public void setCompositeKey(SnParametroKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * Obtains and returns the new value of the vlrParametro attribute.
	 *
	 * @return Returns the vlrParametro.
	 * 
	 * @hibernate.property
	 * column = "vlr_parametro"
	 * type = "big_decimal"
	 *
	 * 
	 */
	public BigDecimal getVlrParametro() {
		return vlrParametro;
	}

	/**
	 * @param vlrParametro The vlrParametro to set.
	 * 
	 */
	public void setVlrParametro(BigDecimal vlrParametro) {
		this.vlrParametro = vlrParametro;
	}

	/**
	 * Obtains and returns the new value of the descricao attribute.
	 *
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * column = "descricao"
	 * type = "string"
	 * 
	 * 
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param preco The descricao to set.
	 * 
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Obtains and returns the new value of the instrucao attribute.
	 *
	 * @return Returns the instrucao.
	 * 
	 * @hibernate.property
	 * column = "instrucao"
	 * type = "string"
	 * 
	 * 
	 */
	public String getInstrucao() {
		return instrucao;
	}

	/**
	 * @param preco The instrucao to set.
	 * 
	 */
	public void setInstrucao(String instrucao) {
		this.instrucao = instrucao;
	}

	/**
	 * Obtains and returns the new value of the vlrParametroStr attribute.
	 *
	 * @return Returns the vlrParametroStr.
	 * 
	 * @hibernate.property
	 * column = "vlr_parametro_str"
	 * type = "string"
	 * 
	 * 
	 */
	public String getVlrParametroStr() {
		return vlrParametroStr;
	}

	/**
	 * @param preco The vlrParametroStr to set.
	 * 
	 */
	public void setVlrParametroStr(String vlrParametroStr) {
		this.vlrParametroStr = vlrParametroStr;
	}

	/**
	 * Obtains and returns the new value of the processarMestre attribute.
	 *
	 * @return Returns the processarMestre.
	 * 
	 * @hibernate.property
	 * column = "processar_mestre"
	 * type = "int"
	 * 
	 * 
	 */
	public Integer getProcessarMestre() {
		return processarMestre;
	}

	/**
	 * @param preco The processarMestre to set.
	 * 
	 */
	public void setProcessarMestre(Integer processarMestre) {
		this.processarMestre = processarMestre;
	}

	/**
	 * @hibernate.many-to-one 
	 * 		class="br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean"
	 * 		cascade="none"
	 * 		column="id_empresa"
	 * 		insert="false"
	 * 		update="false"
	 * 		property-ref="idEmpresa"
	 * 
	 * @return
	 */
	public SnCidadeOperadoraBean getEmpresa() {
		return empresa;
	}

	public void setEmpresa(SnCidadeOperadoraBean empresa) {
		this.empresa = empresa;
	}
	
	   /**
     * @return Returns the nomeParametro.
     * 
     * @hibernate.property
     * column = "NOME_PARAMETRO"
     * type = "string"
     */
    public String getNomeParametro() {
        return nomeParametro;
    }

    /**
     * @param nomeParametro
     *          The nomeParametro to set.
     */
    public void setNomeParametro(String nomeParametro) {
        this.nomeParametro = nomeParametro;
    }
}