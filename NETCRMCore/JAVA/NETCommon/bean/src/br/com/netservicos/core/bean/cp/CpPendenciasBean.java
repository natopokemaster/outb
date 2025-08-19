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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_pendencias.
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
 * 13/12/2004 Ramon Carvalho N/A      Entidades      Created.
 * 13/12/2004 Ramon Carvalho 1.0      Entidades      Development.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "cp_pendencias"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="true"
 *                   batch-size="10"
 *
 * @hibernate.cache
 *      usage="read-write"
 *
 * @hibernate.query name = "lstParamConsultaDuplicidadeCpf"
 * 					query = "SELECT 
 * 								parametro.vlrParametro
 * 							FROM 
 * 								br.com.netservicos.core.bean.sn.SnParametroBean parametro
 * 							WHERE 
 * 									parametro.compositeKey.nomeParametro = 'DUPLICIDADE_CPF'
 * 								AND parametro.compositeKey.idEmpresa = :idEmpresa"
 * 
 * 
 * @hibernate.query name = "lstParamConsultaBlackList"
 * 					query = "SELECT 
 * 								parametro.vlrParametro
 * 							FROM 
 * 								br.com.netservicos.core.bean.sn.SnParametroBean parametro
 * 							WHERE 
 * 									parametro.compositeKey.nomeParametro = 'PESQUISA_BLACK_LIST'
 * 								AND parametro.compositeKey.idEmpresa = :idEmpresa"
 * 
 * @hibernate.query name = "lstParamValidarSerasa"
 * 					query = "SELECT 
 * 								parametro.vlrParametro
 * 							FROM 
 * 								br.com.netservicos.core.bean.sn.SnParametroBean parametro
 * 							WHERE 
 * 									parametro.compositeKey.nomeParametro = 'VALIDAR_SERASA'
 * 								AND parametro.compositeKey.idEmpresa = :idEmpresa"
 * 
 * 
 * @hibernate.query name = "lstParamHabilConsWebServiSerasa"
 * 					query = "SELECT 
 * 								parametro.vlrParametro
 * 							FROM 
 * 								br.com.netservicos.core.bean.sn.SnParametroBean parametro
 * 							WHERE 
 * 									parametro.compositeKey.nomeParametro = 'ATIVA_CONSWEB_SERASA'
 * 								AND parametro.compositeKey.idEmpresa = :idEmpresa"
 * 
 *
 *@hibernate.query name = "lstCpPendenciasByPropostaAssinante"
 *                 query = "SELECT pend_pro.idRelPendenciaProposta,
 *                          pend_pro.pendencia.idPendencia,
 *                          pend_pro.pendencia.descricao,
 *                          pend_pro.pendenciaVariacao.idPendVariacao
 *                          FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pend_pro
 *                          WHERE (pend_pro.dtFechamento is null AND
 *                                 pend_pro.propostaAssinante.idPropostaAssinante = :idPropostaAssinante)" 
 *                                 
 *@hibernate.query name = "lstCpPendenciasByProposta"
 *                 query = "SELECT pend_pro.idRelPendenciaProposta,
 *                          pend_pro.pendencia.idPendencia,
 *                          pend_pro.pendencia.descricao,
 *                          pend_pro.pendenciaVariacao.idPendVariacao
 *                          FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pend_pro
 *                          WHERE (pend_pro.dtFechamento is null AND
 *                                 pend_pro.proposta.idProposta = :idProposta)"
 * 
 *  
 */
public class CpPendenciasBean extends DomainBean {
    public static final long ENVIO_DOCUMENTO = 17;
    
    public static final String LST_CP_PENDENCIAS_BY_PROPOSTA = "lstCpPendenciasByProposta";
    private static final String ID_PENDENCIA = "idPendencia";
           
    private static final long serialVersionUID = 1L;

    private String descricao;
    private Long idPendencia;
    private Integer prazoResolucao;

    /**
     *
     */
    public CpPendenciasBean() {
        super(ID_PENDENCIA);
    }

    public CpPendenciasBean(Long idPendencia) {
        this();

        setIdPendencia(idPendencia);
    }

    public CpPendenciasBean(int idPendencia) {
        this(new Long(idPendencia));
    }

    /**
     * Obtains and returns the new value of the descricao attribute.
     *
     * @return Returns the descricao.
     *
     * @hibernate.property
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @hibernate.id
     * 		column="id_pendencia"
     * 		generator-class="assigned"
     *
     * @return
     */
    public Long getIdPendencia() {
        return idPendencia;
    }

    /**
     * Obtains and returns the new value of the prazoSolucao attribute.
     *
     * @return Returns the prazoSolucao.
     *
     * @hibernate.property
     *    column="prazo_resolucao"
     */
    public Integer getPrazoResolucao() {
        return prazoResolucao;
    }

    /**
     * @param descricao The descricao to set.
     *
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdPendencia(Long idPendencia) {
        this.idPendencia = idPendencia;
    }

    /**
     * @param prazoSolucao The prazoSolucao to set.
     *
     */
    public void setPrazoResolucao(Integer prazoResolucao) {
        this.prazoResolucao = prazoResolucao;
    }

}