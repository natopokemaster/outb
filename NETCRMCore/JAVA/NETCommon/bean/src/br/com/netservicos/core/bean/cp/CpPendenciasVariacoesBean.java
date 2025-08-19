/*
 * Created on 24/01/2005
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
package br.com.netservicos.core.bean.cp;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_pendencias_variacoes.
 * </P>
 * <P>
 * <B>
 * Issues :
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
 *                            Prior
 * Date       By              Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 15/09/2010 Wellington Maeda N/A      Entidades      Created. 
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "cp_pendencias_variacoes"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="true"
 *                   batch-size="10"
 *
 * @hibernate.cache
 *      usage="read-write"
 * 
 *
 */
public class CpPendenciasVariacoesBean extends DomainBean {

    
    private static final String ID_VARIACAO = "idVariacao";    
    private String descricao;
    private Date dtCriacao;
    private Long idVariacao;
    private String respCriacao;

    /**
     *  
     */
    public CpPendenciasVariacoesBean() {
        super(ID_VARIACAO);
    }
    
    public CpPendenciasVariacoesBean(int variacao) {
    	super(ID_VARIACAO);
    	setIdVariacao(new Long(variacao));
    }

    /**
     * Obtains and returns the new value of the descricao attribute.
     * 
     * @return Returns the descricao.
     * 
     * @hibernate.property
     * 		not-null="true"
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtains and returns the new value of the dtCriacao attribute.
     *
     * @return Returns the dtCriacao.
     * 
     * @hibernate.property
     * 		column="dt_criacao"
     * 		type = "date"
     * 		not-null="true"
     * 
     */
    public Date getDtCriacao() {
        return dtCriacao;
    }

    /**
     * @hibernate.id 
     * 		column="id_variacao"
     * 		generator-class="assigned"
     * 
     * @return
     */
    public Long getIdVariacao() {
        return idVariacao;
    }

    /**
     * Obtains and returns the new value of the respCriacao attribute.
     *
     * @return Returns the respCriacao.
     * 
     * @hibernate.property
     * 		column="resp_criacao"
     */
    public String getRespCriacao() {
        return respCriacao;
    }

    /**
     * @param descricao The descricao to set.
     * 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param dtCriacao The dtCriacao to set.
     * 
     */
    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public void setIdVariacao(Long idVariacao) {
        this.idVariacao = idVariacao;
    }

    /**
     * @param respCriacao The respCriacao to set.
     * 
     */
    public void setRespCriacao(String respCriacao) {
        this.respCriacao = respCriacao;
    }
}