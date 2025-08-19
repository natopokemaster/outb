/*
 * Created on 04/02/2005
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

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Bean que representa a tabela sn_contrato.
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
 * 03/07/2005 Leonardo W.       N/A     Entidades      Created.
 * 03/07/2005 Leonardo W.       1.0     Entidades      Development.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_telefone_voip"
 *                   dynamic-insert = "false"
 *                   dynamic-update = "false"
 *                   
 * @hibernate.cache
 *      usage = "read-write"
 * 
 * 
 * @hibernate.query
 *      name = "lstTelefoneVoip2"
 *      query = "from
 *                  SnTelefoneVoipBean telefoneVoip
 *               where
 *                  telefoneVoip.compositeKey.dddTelefoneVoip = :ddd and
 *                  telefoneVoip.compositeKey.numTelefoneVoip = :telefone and
 *                  telefoneVoip.compositeKey.dtIni < sysdate and
 *                  telefoneVoip.compositeKey.dtFim = TO_DATE('30/12/2049','DD/MM/YYYY')"
 * 
 * @hibernate.query
 *      name = "lstTelefoneVoipToUpdate"
 *      query = "FROM br.com.netservicos.core.bean.sn.SnTelefoneVoipBean telefoneVoip
 *               WHERE
 *                  telefoneVoip.compositeKey.dddTelefoneVoip = :ddd and
 *                  telefoneVoip.compositeKey.numTelefoneVoip = :telefone and
 *                  telefoneVoip.compositeKey.dtIni < sysdate and
 *                  telefoneVoip.compositeKey.dtFim = TO_DATE('30/12/2049','DD/MM/YYYY') and
 *                  telefoneVoip.idStatusTelefoneVoip = 'A' and
 *                  telefoneVoip.idSistemaExterno = 5 and
 *                  telefoneVoip.numContratoAvaliacao = :idPropostaAssinante and
 *                  telefoneVoip.cidContrato = TO_NUMBER(:cidContrato)"
 * 
 * @hibernate.query
 *      name = "lstNumContratoTelefoneVoip"
 *      query = "select
 *                  tel.numContrato
 *               from
 *                  br.com.netservicos.core.bean.sn.SnTelefoneVoipBean tel
 *               where
 *                  tel.cidContrato = :cidContrato and
 *                  tel.compositeKey.numTelefoneVoip = :telefone and
 *                  tel.compositeKey.dtFim > sysdate and
 *                  tel.idStatusTelefoneVoip = 'U'"
 * 
 * @hibernate.query
 *      name = "lstNumContratoTelefoneVoipWithDdd"
 *      query = "select
 *                  tel.numContrato
 *              from
 *                  br.com.netservicos.core.bean.sn.SnTelefoneVoipBean tel
 *               where
 *                  tel.cidContrato = :cidContrato and
 *                  tel.compositeKey.numTelefoneVoip = :telefone and
 *                  tel.compositeKey.dtFim > sysdate and
 *                  tel.idStatusTelefoneVoip = 'U' and
 *                  tel.compositeKey.dddTelefoneVoip = :dddVoip"
 *
 *@hibernate.query
 *      name = "getTelefoneVoipContrato"
 *      query = "SELECT tel
 *              FROM
 *                  br.com.netservicos.core.bean.sn.SnTelefoneVoipBean tel
 *               where
 *                  tel.compositeKey.dddTelefoneVoip = :dddTelefone and
 *                  tel.compositeKey.numTelefoneVoip = :numTelefone and
 *                  tel.compositeKey.dtIni <= trunc(sysdate) and
 *                  tel.compositeKey.dtFim >= trunc(sysdate) and
 *                  tel.cidContrato || '' = :cidContrato and
 *                  tel.numContrato + 0 = :numContrato and
 *                  tel.idStatusTelefoneVoip || '' = 'U'"
 * 
 */
public class SnTelefoneVoipBean extends DomainBean {
         
    private static final long serialVersionUID = -5295567125340214362L;

    public static final String GET_TELEFONE_VOIP_CONTRATO = "getTelefoneVoipContrato";
    public static final String STATUS_TELEFONE_ATIVO = "A";
    
    public static final String STATUS_TELEFONE_DISPONIVEL = "D";
    
    private SnTelefoneVoipKey compositeKey;

    private Long golden;
    
    private SnCidadeOperadoraBean cidade;
    
    private Long numContrato;
    
    private Long cidContrato;
    
    private Date dtAlteracao;
    
    private Integer idPonto;
    
    private String fqdn;
    
    private Integer numPorta;
    
    private String idStatusTelefoneVoip;
    
    private Integer tmId;
    
    private Integer idEscolhido;
    
    private Integer publicar;
    
    private String nomePublicacao;
    
    private Integer numContratoAvaliacao;
    
    private Long idSistemaExterno;
    
    private Long cidContratoOrigem;

    /**
     *
     */
    private String fcNumeroPortado;

    /**
     *
     */
    private String fcInterceptado;

    /**
     *  
     */
    public SnTelefoneVoipBean() {
        super("compositeKey");
    }

    /**
     * @hibernate.id
     * type = "composite"
     * 
     */
    public SnTelefoneVoipKey getCompositeKey() {
        return compositeKey;
    }

    /**
     * @param compositeKey The compositeKey to set.
     * 
     */
    public void setCompositeKey(SnTelefoneVoipKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    /**
     * Obtains and returns the SnCidadeOperadoraBean.
     *
     * @return Returns the cidade.
     * 
     * @hibernate.many-to-one  
     *      class="br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean" 
     *      column="cid_contrato"
     *      cascade="none"
     *      not-null="false"
     * 
     */
    public SnCidadeOperadoraBean getCidade() {
        return cidade;
    }

    /**
     * @param cidade The cidade to set.
     * 
     */
    public void setCidade(SnCidadeOperadoraBean cidade) {
        this.cidade = cidade;
    }
        
    /**
     * Obtains and returns the new value of the dtAlteracao attribute.
     *
     * @return Returns the dtAlteracao.
     * 
     * @hibernate.property
     * column="dt_alteracao"
     * type = "timestamp"
     * 
     */
    public Date getDtAlteracao() {
        return dtAlteracao;
    }

    /**
     * @param dtAlteracao The dtAlteracao to set.
     * 
     */
    public void setDtAlteracao(Date dtAlteracao) {
        this.dtAlteracao = dtAlteracao;
    }
    
    /**
     * @return Returns the numContrato.
     * @hibernate.property column = "num_contrato"
     * 
     */
    public Long getNumContrato() {
        return numContrato;
    }

    
    /** @param numContrato The numContrato to set.
     * 
     */
    public void setNumContrato(Long numContrato) {
        this.numContrato = numContrato;
    }
    
    /**
     * @return Returns the cidContrato.
     * @hibernate.property column = "cid_contrato"
     * insert = "false" update = "false"
     */
    public Long getCidContrato() {
        return cidContrato;
    }

    /**
     * @param cidContrato The cidContrato to set.
     * 
     */
    public void setCidContrato(Long cidContrato) {
        this.cidContrato = cidContrato;
    }
    
    /**
     * @hibernate.property
     *      column="cid_contrato_origem"
     */
    
    public Long getCidContratoOrigem() {
        return cidContratoOrigem;
    }

    public void setCidContratoOrigem(Long cidContratoOrigem) {
        this.cidContratoOrigem = cidContratoOrigem;
    }

    /**
     * @hibernate.property
     *      column="FQDN"
     */
    
    public String getFQDN() {
        return fqdn;
    }

    public void setFQDN(String fqdn) {
        this.fqdn = fqdn;
    }

    /**
     * @hibernate.property
     *      column="id_Escolhido"
     */
    
    public Integer getIdEscolhido() {
        return idEscolhido;
    }

    public void setIdEscolhido(Integer idEscolhido) {
        this.idEscolhido = idEscolhido;
    }

    /**
     * @hibernate.property
     *      column="id_Ponto"
     */
    
    public Integer getIdPonto() {
        return idPonto;
    }

    public void setIdPonto(Integer idPonto) {
        this.idPonto = idPonto;
    }

    /**
     * @hibernate.property
     *      column="id_Sistema_Externo"
     */
    
    public Long getIdSistemaExterno() {
        return idSistemaExterno;
    }

    public void setIdSistemaExterno(Long idSistemaExterno) {
        this.idSistemaExterno = idSistemaExterno;
    }

    /**
     * @hibernate.property
     *      column="id_Status_Telefone_Voip"
     */
    
    public String getIdStatusTelefoneVoip() {
        return idStatusTelefoneVoip;
    }

    public void setIdStatusTelefoneVoip(String idStatusTelefoneVoip) {
        this.idStatusTelefoneVoip = idStatusTelefoneVoip;
    }

    /**
     * @hibernate.property
     *      column="nome_Publicacao"
     */
    
    public String getNomePublicacao() {
        return nomePublicacao;
    }

    public void setNomePublicacao(String nomePublicacao) {
        this.nomePublicacao = nomePublicacao;
    }

    /**
     * @hibernate.property
     *      column="num_Contrato_Avaliacao"
     */
    
    public Integer getNumContratoAvaliacao() {
        return numContratoAvaliacao;
    }

    public void setNumContratoAvaliacao(Integer numContratoAvaliacao) {
        this.numContratoAvaliacao = numContratoAvaliacao;
    }

    /**
     * @hibernate.property
     *      column="num_Porta"
     */
    
    public Integer getNumPorta() {
        return numPorta;
    }

    public void setNumPorta(Integer numPorta) {
        this.numPorta = numPorta;
    }

    /**
     * @hibernate.property
     *      column="publicar"
     */
    
    public Integer getPublicar() {
        return publicar;
    }

    public void setPublicar(Integer publicar) {
        this.publicar = publicar;
    }

    /**
     * @hibernate.property
     *      column="tm_Id"
     */
    
    public Integer getTmId() {
        return tmId;
    }

    public void setTmId(Integer tmId) {
        this.tmId = tmId;
    }
    
    /**
     * Obtains and returns the new value of the golden attribute.
     *
     * @return Returns the golden.
     * 
     * @hibernate.property   
     * type = "long"
     * 
     */
    public Long getGolden() {
        return golden;
    }

    /**
     * @param golden The golden to set.
     * 
     */
    public void setGolden(Long golden) {
        this.golden = golden;
    }

    /**
     * Obtains and returns the new value of the fcInterceptado attribute.
     *
     * @return Returns the fcInterceptado.
     *
     * @hibernate.property
     * column="fc_interceptado"
     *
     */
    public String getFcInterceptado() {
        return fcInterceptado;
    }

    /**
     * @param fcInterceptado The fcInterceptado to set.
     *
     */
    public void setFcInterceptado(String fcInterceptado) {
        this.fcInterceptado = fcInterceptado;
    }

    /**
     * Obtains and returns the new value of the fcNumeroPortado attribute.
     *
     * @return Returns the fcNumeroPortado.
     *
     * @hibernate.property
     * column="fc_numero_portado"
     *
     */
    public String getFcNumeroPortado() {
        return fcNumeroPortado;
    }

    /**
     * @param fcNumeroPortado The fcNumeroPortado to set.
     *
     */
    public void setFcNumeroPortado(String fcNumeroPortado) {
        this.fcNumeroPortado = fcNumeroPortado;
    }
}