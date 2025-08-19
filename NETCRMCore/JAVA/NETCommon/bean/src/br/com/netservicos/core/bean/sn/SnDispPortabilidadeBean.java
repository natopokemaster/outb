/*
 * Created on 14/02/2008
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

import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Bean que representa a tabela sn_disp_portabilidade.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>
 * =============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 *
 * =============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * =============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ---------------------------
 * 13/02/2008 Gustavo Sabino  N/A     Entidades      Created.
 * 13/02/2008 Gustavo Sabino  1.0     Entidades      Development.
 * =============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_disp_portabilidade"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *
 * @hibernate.cache
 *      usage = "read-write"
 *
 * @hibernate.query name  = "lstSnDispPortabilidade"
 *   query = "FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp"
 *
 * @hibernate.query name  = "lstSnDispPortabilidadeByOperadora"
 *   query = "select count(*)
 *            FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp
 *            WHERE disp.idOperadoraDoadora = :idOperadoraTelefonia"
 *
 * @hibernate.query name  = "lstDispPortabilidadeByContrato"
 *   query = "SELECT distinct disp.idOperadoraDoadora,
 *                   disp.dddTelefoneVoip,
 *                   disp.numTelefoneVoip
 *            FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp,
 *                 br.com.netservicos.core.bean.sn.SnTelefoneVoipBean telVoip
 *            WHERE disp.numContrato = :contrato.compositeKey.numContrato
 *              AND disp.cidContrato = :contrato.compositeKey.cidContrato
 *              AND telVoip.compositeKey.dddTelefoneVoip = disp.dddTelefoneVoip
 *              AND telVoip.compositeKey.numTelefoneVoip = disp.numTelefoneVoip
 *              AND telVoip.compositeKey.dtFim = TO_DATE('30/12/2049','DD/MM/YYYY')
 *              AND TO_CHAR(telVoip.idStatusTelefoneVoip) in ('U', 'T')"
 *
 * @hibernate.query name  = "lstDispPortabilidadeByPendencia"
 *  query = "SELECT disp.idOperadoraDoadora,
 *                  disp.dddTelefoneVoip,
 *                  disp.numTelefoneVoip
 *           FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp,
 *                br.com.netservicos.core.bean.sn.SnTelefoneVoipBean telVoip
 *           WHERE disp.numContrato =:proposta.contrato.compositeKey.numContrato
 *             AND disp.cidContrato =:proposta.contrato.compositeKey.cidContrato
 *             AND telVoip.compositeKey.dddTelefoneVoip = disp.dddTelefoneVoip
 *             AND telVoip.compositeKey.numTelefoneVoip = disp.numTelefoneVoip
 *             AND telVoip.compositeKey.dtFim = TO_DATE('30/12/2049','DD/MM/YYYY')
 *             AND telVoip.idStatusTelefoneVoip ||'' = 'D'"
 *
 * @hibernate.query name  = "lstDispPortabilidadeByAssinante"
 *   query = "FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp,
 *                 br.com.netservicos.core.bean.sn.SnTelefoneVoipBean telVoip
 *            WHERE disp.numContrato = :numContrato
 *              AND disp.cidContrato = :cidContrato
 *              AND telVoip.compositeKey.dddTelefoneVoip = disp.dddTelefoneVoip
 *              AND telVoip.compositeKey.numTelefoneVoip = disp.numTelefoneVoip
 *              AND telVoip.compositeKey.dtFim = TO_DATE('30/12/2049','DD/MM/YYYY')
 *              AND TO_CHAR(telVoip.idStatusTelefoneVoip) = 'U'"
 *
 * @hibernate.query name  = "lstDispPortabilidadeByProspect"
 *   query = "FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp,
 *                 br.com.netservicos.core.bean.sn.SnTelefoneVoipBean telVoip
 *            WHERE disp.idProposta = :idProposta
 *              AND telVoip.compositeKey.dddTelefoneVoip = disp.dddTelefoneVoip
 *              AND telVoip.compositeKey.numTelefoneVoip = disp.numTelefoneVoip
 *              AND telVoip.compositeKey.dtFim = TO_DATE('30/12/2049','DD/MM/YYYY')
 *              AND telVoip.idStatusTelefoneVoip = 'A'"
 *
 * @hibernate.query name  = "lstConsultaAreaLocalPorContrato"
 *  query = "SELECT disp.dddTelefoneVoip,
 *                  disp.numTelefoneVoip,
 *                  disp.fcAreaLocal,
 *                  disp.dtDispPortabilidade,
 *                  tel.idStatusTelefoneVoip
 *           FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp,
 *                br.com.netservicos.core.bean.sn.SnTelefoneVoipBean tel
 *           WHERE tel.compositeKey.dddTelefoneVoip = disp.compositeKey.dddTelefoneVoip
 *             AND tel.compositeKey.numTelefoneVoip = disp.compositeKey.numTelefoneVoip
 *             AND disp.cidContrato = :contrato.compositeKey.cidContrato
 *             AND disp.numContrato = :contrato.compositeKey.numContrato
 *             AND tel.compositeKey.dtFim = TO_DATE('30/12/2049', 'DD/MM/YYYY')"
 *
@hibernate.query name  = "lstConsultaAreaLocalPorContratoECidContrato"
 *   query = "SELECT disp.dddTelefoneVoip,
 *                   disp.numTelefoneVoip,
 *                   disp.fcAreaLocal,
 *                   disp.dtDispPortabilidade
 *            FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp
 *            WHERE disp.numContrato = :proposta.contrato.compositeKey.numContrato
 *              AND disp.cidContrato = :proposta.contrato.compositeKey.cidContrato"
 *
 * @hibernate.query name  = "lstConsultaAreaLocalPorProposta"
 *  query = "SELECT disp.dddTelefoneVoip,
 *                                  disp.numTelefoneVoip,
 *                                  disp.fcAreaLocal,
 *                                  disp.dtDispPortabilidade,
 *                                  tel.idStatusTelefoneVoip
 *           FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp,
 *                br.com.netservicos.core.bean.sn.SnTelefoneVoipBean tel
 *           WHERE tel.compositeKey.dddTelefoneVoip = disp.compositeKey.dddTelefoneVoip
 *             AND tel.compositeKey.numTelefoneVoip = disp.compositeKey.numTelefoneVoip
 *             AND disp.idProposta = :proposta.idProposta
 *             AND tel.compositeKey.dtFim = TO_DATE('30/12/2049', 'DD/MM/YYYY')"
 *
 * @hibernate.query name  = "countSnDispPortabilidadeByNumContrato"
 *   query = "select count(*)
 *            FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp
 *            WHERE disp.numContrato =:numContrato
 *              AND disp.fcAreaLocal = 'S'"
 *
 * @hibernate.query name  = "countSnDispPortabilidadeDisponiveisByNumProposta"
 *  query = "select count(*)
 *           FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp,
 *                br.com.netservicos.core.bean.sn.SnTelefoneVoipBean telVoip
 *           WHERE disp.idProposta = :idProposta
 *             AND telVoip.compositeKey.dddTelefoneVoip = disp.dddTelefoneVoip
 *             AND telVoip.compositeKey.numTelefoneVoip = disp.numTelefoneVoip
 *             AND disp.fcAreaLocal = 'S'
 *             AND telVoip.idStatusTelefoneVoip||'' = 'D'
 *             AND telVoip.compositeKey.dtFim = TO_DATE('30/12/2049','DD/MM/YYYY')"
 *
 * @hibernate.query name  = "lstSnDispPortabilidadeByNumProposta"
 *  query = "select disp.idProposta
 *           FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp
 *           WHERE disp.idProposta = :proposta.idProposta
 *             AND disp.fcAreaLocal = 'S'"
 *
 * @hibernate.query name  = "lstSnDispPortabilidadeDisponiveisByNumProposta"
 *  query = "select telVoip.idStatusTelefoneVoip
 *           FROM br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean disp,
 *                br.com.netservicos.core.bean.sn.SnTelefoneVoipBean telVoip
 *           WHERE disp.idProposta = :proposta.idProposta
 *             AND telVoip.compositeKey.dddTelefoneVoip = disp.dddTelefoneVoip
 *             AND telVoip.compositeKey.numTelefoneVoip = disp.numTelefoneVoip
 *             AND disp.fcAreaLocal = 'S'
 *             AND telVoip.idStatusTelefoneVoip = 'D'"
 *
 */


public class SnDispPortabilidadeBean extends DomainBean {

    private static final long serialVersionUID = 934842170621471434L;

    public static final String LST_DISP_PORTABILIDADE_BY_CONTRATO = "lstDispPortabilidadeByContrato";
    public static final String COUNT_DISP_PORTABILIDADE_DISPONIVEIS_BY_PROPOSTA = "countSnDispPortabilidadeDisponiveisByNumProposta";
    public static final String COUNT_DISP_PORTABILIDADE_BY_CONTRATO = "countSnDispPortabilidadeByNumContrato";
    public static final String LST_DISP_PORTABILIDADE_BY_ASSINANTE = "lstDispPortabilidadeByAssinante";
    public static final String LST_DISP_PORTABILIDADE_BY_PROSPECT = "lstDispPortabilidadeByProspect";

    private SnDispPortabilidadeKey compositeKey;
    private SnContratoBean contrato;
    private SnOperadoraTelefoniaBean operadoraDoadora;
    private CpPropostaBean proposta;
    private String dddTelefoneVoip;
    private String numTelefoneVoip;
    private Long idOperadoraDoadora;
    private String cidContrato;
    private String fcAreaLocal;
    private Long numContrato;
    private Long idProposta;
    private Integer cdCnl;
    private Integer fnTipoPortabilidade;
    private Integer idSoftx;
    private Date dtDispPortabilidade;
    private Long idOperadoraFiscal;

    /**
     * Construtor default da classe.
     */
    public SnDispPortabilidadeBean() {
        super("compositeKey");
    }

    /**
     *
     * @param compositeKey SnDispPortabilidadeKey
     */
    public SnDispPortabilidadeBean(SnDispPortabilidadeKey compositeKey) {
        this();
        this.compositeKey = compositeKey;
    }

    /**
     * @hibernate.id
     * type = "composite"
     * @return SnDispPortabilidadeKey
     */
    public SnDispPortabilidadeKey getCompositeKey() {
        return compositeKey;
    }

    /**
     * @param compositeKey The compositeKey to set.
     *
     */
    public void setCompositeKey(SnDispPortabilidadeKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    /**
     * Método de acesso ao atributo contrato.
     * @return O valor do atributo contrato
     */
    public SnContratoBean getContrato() {
        return contrato;
    }

    /**
     * Método de modificação do atributo contrato.
     * @param contrato Valor setado para o atributo contrato
     */
    public void setContrato(SnContratoBean contrato) {
        this.contrato = contrato;
    }

    /**
     * Obtains and returns the CpPropostaBean.
     *
     * @return Returns the proposta.
     *
     * @hibernate.many-to-one
     *     class="br.com.netservicos.core.bean.cp.CpPropostaBean"
     *     column="id_proposta"
     *     cascade="none"
     *     not-null="false"
     */
    public CpPropostaBean getProposta() {
        return proposta;
    }

    /**
     * Método de modificação do atributo proposta.
     * @param proposta Valor setado o atributo contrato
     */
    public void setProposta(CpPropostaBean proposta) {
        this.proposta = proposta;
    }

    /**
     * Obtains and returns the SnOperadoraTelefoniaBean.
     *
     * @return Returns the operadoraDoadora.
     *
     * @hibernate.many-to-one
     *     class="br.com.netservicos.core.bean.sn.SnOperadoraTelefoniaBean"
     *     column="id_operadora_doadora"
     *     cascade="none"
     *     not-null="false"
     *
     */
    public SnOperadoraTelefoniaBean getOperadoraDoadora() {
        return operadoraDoadora;
    }

    /**
     * Método de modificação do atributo operadoraDoadora.
     * @param operadoraDoadora Valor setado para o atributo operadoraDoadora
     */
    public void setOperadoraDoadora(SnOperadoraTelefoniaBean operadoraDoadora) {
        this.operadoraDoadora = operadoraDoadora;
    }

    /**
     * @return Returns the cidContrato.
     * @hibernate.property column = "cid_contrato"
     * insert = "false" update = "false"
     */
    public String getCidContrato() {
        return cidContrato;
    }

    /**
     * @param cidContrato The cidContrato to set.
     *
     */
    public void setCidContrato(String cidContrato) {
        this.cidContrato = cidContrato;
    }

    /**
     * @hibernate.property
     *     column="ddd_telefone_voip"
     *     insert = "false" update = "false"
     * @return String
     */
    public String getDddTelefoneVoip() {
        return dddTelefoneVoip;
    }

    /** @param dddTelefoneVoip The dddTelefoneVoip to set.
     *
     */
    public void setDddTelefoneVoip(String dddTelefoneVoip) {
        this.dddTelefoneVoip = dddTelefoneVoip;
    }

    /**
     * @hibernate.property
     *     column="fc_area_local"
     * @return String
     */
    public String getFcAreaLocal() {
        return fcAreaLocal;
    }

    /** @param fcAreaLocal The fcAreaLocal to set.
     *
     */
    public void setFcAreaLocal(String fcAreaLocal) {
        this.fcAreaLocal = fcAreaLocal;
    }

    /**
     * @hibernate.property
     *      column="id_operadora_doadora"
     *      insert = "false" update = "false"
     * @return Long
     */
    public Long getIdOperadoraDoadora() {
        return idOperadoraDoadora;
    }

    /** @param idOperadoraDoadora The idOperadoraDoadora to set.
     *
     */
    public void setIdOperadoraDoadora(Long idOperadoraDoadora) {
        this.idOperadoraDoadora = idOperadoraDoadora;
    }

    /**
     * @hibernate.property
     *      column="id_proposta"
     *      insert = "false" update = "false"
     * @return Long
     */
    public Long getIdProposta() {
        return idProposta;
    }

    /** @param idProposta The idProposta to set.
     *
     */
    public void setIdProposta(Long idProposta) {
        this.idProposta = idProposta;
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
     * @hibernate.property
     *      column="num_telefone_voip"
     *      insert = "false" update = "false"
     * @return String
     */
    public String getNumTelefoneVoip() {
        return numTelefoneVoip;
    }

    /** @param numTelefoneVoip The numTelefoneVoip to set.
     *
     */
    public void setNumTelefoneVoip(String numTelefoneVoip) {
        this.numTelefoneVoip = numTelefoneVoip;
    }

    /**
     * Obtains and returns the new value of the idSoftx attribute.
     *
     * @return Returns the idSoftx.
     *
     * @hibernate.property
     * column="id_softx"
     * type = "int"
     */
    public Integer getIdSoftx() {
        return idSoftx;
    }

    /** @param idSoftx The idSoftx to set.
     *
     */
    public void setIdSoftx(Integer idSoftx) {
        this.idSoftx = idSoftx;
    }

    /**
     * @hibernate.property
     *      column="dt_disp_portabilidade"
     *      type = "date"
     * @return Date
     */
    public Date getDtDispPortabilidade() {
        return dtDispPortabilidade;
    }

    /** @param dtDispPortabilidade The dtDispPortabilidade to set.
     *
     */
    public void setDtDispPortabilidade(Date dtDispPortabilidade) {
        this.dtDispPortabilidade = dtDispPortabilidade;
    }

    /**
     * @hibernate.property
     *      column="id_operadora_fiscal"
     *      type = "long"
     * @return Long
     */
    public Long getIdOperadoraFiscal() {
        return idOperadoraFiscal;
    }

    /** @param idOperadoraFiscal The idOperadoraFiscal to set.
     *
     */
    public void setIdOperadoraFiscal(Long idOperadoraFiscal) {
        this.idOperadoraFiscal = idOperadoraFiscal;
    }

    /**
     * @hibernate.property
     *      column="cd_cnl"
     *      type = "int"
     * @return Integer
     */
    public Integer getCdCnl() {
        return cdCnl;
    }

    /** @param cdCnl The cdCnl to set.
     *
     */
    public void setCdCnl(Integer cdCnl) {
        this.cdCnl = cdCnl;
    }

    /**
     * @hibernate.property
     *      column="fn_tipo_portabilidade"
     *      type = "int"
     * @return Integer
     */
    public Integer getFnTipoPortabilidade() {
        return fnTipoPortabilidade;
    }

    /** @param fnTipoPortabilidade The fnTipoPortabilidade to set.
     *
     */
    public void setFnTipoPortabilidade(Integer fnTipoPortabilidade) {
        this.fnTipoPortabilidade = fnTipoPortabilidade;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.compositeKey == null) ? 0 : this.compositeKey.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = false;
        if (key instanceof SnDispPortabilidadeBean) {
            final SnDispPortabilidadeBean comp = (SnDispPortabilidadeBean) key;
            test = this.getCompositeKey().equals(comp.getCompositeKey());
        } else {
            test = super.equals(key);
        }
        return test;
    }
}
