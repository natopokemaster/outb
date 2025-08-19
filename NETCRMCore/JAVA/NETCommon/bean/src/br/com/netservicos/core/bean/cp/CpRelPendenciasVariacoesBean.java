/*
 * Created on 13/12/2004
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
 * 	Classe Bean que representa a tabela cp_rel_pendencias_variacoes.
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
 * ---------- -------------- -------- -------------- ----------------------------
 * 15/09/2010 Wellington Maeda N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 * @hibernate.class table = "cp_rel_pendencias_variacoes"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="true"
 *                   batch-size="10"
 *                   
 * @hibernate.cache
 *      usage="read-write"
 *
 * @hibernate.query name = "lstCpRelPendenciasVariacoesByPendenciasAndVariacoes"
 * 					query = "FROM br.com.netservicos.core.bean.cp.CpRelPendenciasVariacoesBean bean 
 * 							 WHERE ((:idPendencia IS NULL) OR (bean.pendencias.idPendencia = :idPendencia)) AND
 * 								   ((:idVariacao IS NULL) OR (bean.pendenciasVariacoes.idVariacao = :idVariacao))"
 * 
 * @hibernate.query name = "findRelPendenciaVariacao"
 *                  query = "FROM br.com.netservicos.core.bean.cp.CpRelPendenciasVariacoesBean bean 
 *                           WHERE bean.pendencias.idPendencia = :idPendencia AND bean.pendenciasVariacoes.idVariacao = :idVariacao"
 * 
 */
public class CpRelPendenciasVariacoesBean extends DomainBean {

    private static final String ID_PEND_VARIACAO = "idPendVariacao";
    public static final String FIND_PEND_VARIACAO = "findRelPendenciaVariacao";
    private static final long serialVersionUID = 1L;
    private Date dtCriacao;
    private Long idPendVariacao;
    private CpPendenciasBean pendencias;
    private CpPendenciasVariacoesBean pendenciasVariacoes;
    private String respCriacao;

    /**
     *  
     */
    public CpRelPendenciasVariacoesBean() {
        super(ID_PEND_VARIACAO);
    }

    public CpRelPendenciasVariacoesBean(Long long1) {
        this();
        
        setIdPendVariacao(long1);
    }

    /**
     * Obtains and returns the new value of the dtCriacao attribute.
     *
     * @return Returns the dtCriacao.
     * 
     * @hibernate.property
     * 		column="dt_criacao"
     * 		type = "date"
     */
    public Date getDtCriacao() {
        return dtCriacao;
    }

    /**
     * @hibernate.id 
     * 		column="id_pend_variacao"
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="scp_rel_pendencias_variacoes"
     * 
     * @return
     */
    public Long getIdPendVariacao() {
        return idPendVariacao;
    }

    /**
     * Obtains and returns the pendencias Bean.
     *
     * @return Returns the pendencias.
     * 
     * @hibernate.many-to-one  
     *    column="id_pendencia"
     *    cascade="none"
     */
    public CpPendenciasBean getPendencias() {
        return pendencias;
    }

    /**
     * Obtains and returns the pendenciasVariacoes Bean.
     *
     * @return Returns the pendenciasVariacoes.
     * 
     * @hibernate.many-to-one  
     *     column="id_variacao" 
     *     cascade="none"
     */
    public CpPendenciasVariacoesBean getPendenciasVariacoes() {
        return pendenciasVariacoes;
    }

    /**
     * Obtains and returns the new value of the respCriacao attribute.
     *
     * @return Returns the respCriacao.
     * 
     * @hibernate.property
     * 		column="resp_criacao"
     * 
     */
    public String getRespCriacao() {
        return respCriacao;
    }

    /**
     * @param dtCriacao The dtCriacao to set.
     * 
     */
    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public void setIdPendVariacao(Long idPendVariacao) {
        this.idPendVariacao = idPendVariacao;
    }

    /**
     * @param pendencias The pendencias to set.
     * 
     */
    public void setPendencias(CpPendenciasBean pendencias) {
        this.pendencias = pendencias;
    }

    /**
     * @param pendenciasVariacoes The pendenciasVariacoes to set.
     */
    public void setPendenciasVariacoes(
            CpPendenciasVariacoesBean pendenciasVariacoes) {
        this.pendenciasVariacoes = pendenciasVariacoes;
    }

    /**
     * @param respCriacao The respCriacao to set.
     * 
     */
    public void setRespCriacao(String respCriacao) {
        this.respCriacao = respCriacao;
    }

}