/*
 * Created on 28/01/2005
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
 * 	Classe Bean que representa a tabela cp_scpc_proposta.
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
 * 
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "cp_scpc_proposta"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="true"
 *                   
 * 
 * 
 */
public class CpScpcPropostaBean extends DomainBean {
    
    public static final int STATUS_VALIDANDO = 2;
    public static final int STATUS_APROVADO = 1;
    public static final int STATUS_REPROVADO = 0;
    public static final int STATUS_ERRO_CONSULTA_SCPC = -1;

    public static final String ATRIBUTO_ID_PROPOSTA = "idProposta";
    public static final String DELETE_CP_SCPC_PROPOSTA_BY_PROPOSTA = "deleteCpScpcPropostaByProposta";
    public static final String LST_CP_SCPC_PROPOSTA_BY_PROPOSTA = "lstCpScpcPropostaByProposta";
    private static final long serialVersionUID = 1L;
    private String creditoNet;
    private String creditoScpc;
    private Date dataCriacaoLog;
    private Date dataNascimento;
    private Long idProposta;
    private String nome;
    private CpPropostaBean proposta;
    private String usuario;

    /**
     * 
     */
    public CpScpcPropostaBean() {
        super(ATRIBUTO_ID_PROPOSTA);
    }
    
    /**
     * Obtains and returns the new value of the creditoNet attribute.
     * 
     * @return Returns the creditoNet.
     * 
     * @hibernate.property
     * 		column="st_credito_net"
     * 
     */
    public String getCreditoNet() {
        return creditoNet;
    }

    /**
     * Obtains and returns the new value of the creditoScpc attribute.
     * 
     * @return Returns the creditoScpc.
     * 
     * @hibernate.property
     * 		column="st_credito_scpc"
     */
    public String getCreditoScpc() {
        return creditoScpc;
    }

    /**
     * Obtains and returns the new value of the dataCriacaoLog attribute.
     * 
     * @return Returns the dataCriacaoLog.
     * 
     * @hibernate.property
     * 		column="dt_criacao_log"
     * 		type = "date"
     */
    public Date getDataCriacaoLog() {
        return dataCriacaoLog;
    }

    /**
     * Obtains and returns the new value of the dataNascimento attribute.
     * 
     * @return Returns the dataNascimento.
     * 
     * @hibernate.property
     * 		column="dt_nascimento"
     * 		type = "date"
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @return Returns the idProspect.
     * @hibernate.id 
     * 		column="id_proposta"
     *		generator-class="foreign"
     * @hibernate.generator-param
     *      name="property"
     *      value="proposta"
     */
    public Long getIdProposta() {
        return idProposta;
    }

    /**
     * Obtains and returns the new value of the nome attribute.
     * 
     * @return Returns the nome.
     * 
     * @hibernate.property
     */
    public String getNome() {
        return nome;
    }

    /**
     * @hibernate.one-to-one
     * @return
     */
    public CpPropostaBean getProposta() {
        return proposta;
    }

    /**
     * Obtains and returns the new value of the usuario attribute.
     * 
     * @return Returns the usuario.
     * 
     * @hibernate.property
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param creditoNet The creditoNet to set. 
     */
    public void setCreditoNet(String creditoNet) {
        this.creditoNet = creditoNet;
    }

    /**
     * @param creditoScpc The creditoScpc to set. 
     */
    public void setCreditoScpc(String creditoScpc) {
        this.creditoScpc = creditoScpc;
    }

    /**
     * @param dataCriacaoLog The dataCriacaoLog to set.
     * 
     */
    public void setDataCriacaoLog(Date dataCriacaoLog) {
        this.dataCriacaoLog = dataCriacaoLog;
    }

    /**
     * @param dataNascimento The dataNascimento to set.
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @param idProspect The idProspect to set.
     * 
     */
    public void setIdProposta(Long idProspect) {
        this.idProposta = idProspect;
    }

    /**
     * @param nome The nome to set. 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProposta(CpPropostaBean proposta) {
        this.proposta = proposta;
    }

    /**
     * @param usuario The usuario to set. 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
