/**
* Created on 10/03/2010
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
* $Id: SnOsBean.java,v 1.7 2011/03/17 17:18:23 T0196500 Exp $
*/

package br.com.netservicos.core.bean.sn;

import java.math.BigDecimal;
import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_os
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
 *                              Prior
 * Date       By                Version  Project/CSR        Description
 * ---------- ----------------- -------- --------------    -------------------------
 * 10/03/2010 Mauro C. Calegari  N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author Mauro Cesar Calegari
 * @since 10/03/2010
 * @version $Revision: 1.7 $
 * 
 * </PRE>
 * @hibernate.class table = "sn_os"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   proxy="br.com.netservicos.core.bean.sn.SnOsBean"
 *                   lazy="true"
 *                  
 * @hibernate.query name  = "getOsBySolic"
 *                  query = "SELECT so 
 *                  from br.com.netservicos.core.bean.sn.SnOsBean so 
 *                  where so.solicitacaoAss.idSolicitacaoAss = :idSolicitacaoAss"
 */

public class SnOsBean extends DomainBean {
    
    /**
     * 
     */
    private static final long serialVersionUID = -2036846675542159370L;

    public static final String GET_OS_BY_SOLIC = "getOsBySolic";
    
    public static final String ATRIBUTO_ID_OS = "codOs";
    
    private String codOs;
    private Integer consumoMaterial;
    private Date dataContato;
    private BigDecimal descontoMulta;
    //private RhPessoaFisicaBean despachoTecnico;
    private Date dtAgendamento;
    private Date dtAtend;
    private Date dtBaixa;
    private Date dtDespacho;
    private Date dtExecucao;
    private Date dtPrazo;
    private String emergencia;
    private Integer emissao;
    private SnEnderBean ender;
    private Date hrInicioExecucao;
    private Date hrTerminoExecucao;
    //private Long idDispAcesso;
    //private String idEmpDespacho;
    //private String idEquipe;
    //private Long idOcorrencia;
    private Long idPonto;
    private Long imediata;
    private Integer isento;
    private String nomeSolic;
    private String obs;
    //private SnPeriodoBean periodo;
    //private SnPlanoPgtoBean planoPgto;
    private SnSolicitacaoAssBean solicitacaoAss;
    //private SnStatusOsBean status;
    private String telSolic;
    //private SnTipoClienteBean tipoCliente;
    //private SnTipoFechamentoBean tipoFechamento;
    //private SnTipoOsBean tipoOs;
    //private SnUsrBean usrAtend;
    //private SnUsrBean usrBaixa;
    //private SnUsrBean usrDespacho;
    
    
    public SnOsBean() {
        super(ATRIBUTO_ID_OS);
    }

    /**
     * @return Returns the codOs.
     *
     * @hibernate.id
     * generator-class="assigned"
     * unsaved-value = "null"
     * column="cod_os"
     * @hibernate.generator-param
     * name = "sequence"
     * value = "ssn_cod_os"
     */
    public String getCodOs() {
        return codOs;
    }

    /**
     * @param codOs 
     *              The codOs to set.
     */
    public void setCodOs(String codOs) {
        this.codOs = codOs;
    }

    /**
     * @return Returns the consumoMaterial.
     *
     * @hibernate.property
     *      column="consumo_material"
     *      type="int"
     */
    public Integer getConsumoMaterial() {
        return consumoMaterial;
    }

    /**
     * @param consumoMaterial 
     *              The consumoMaterial to set.
     */
    public void setConsumoMaterial(Integer consumoMaterial) {
        this.consumoMaterial = consumoMaterial;
    }

    /**
     * @return Returns the dataContato.
     *
     * @hibernate.property
     *      column="data_contato"
     *      type="date"
     */
    public Date getDataContato() {
        return dataContato;
    }

    /**
     * @param dataContato 
     *              The dataContato to set.
     */
    public void setDataContato(Date dataContato) {
        this.dataContato = dataContato;
    }

    /**
     * @return Returns the descontoMulta.
     *
     * @hibernate.property
     *      column="desconto_multa"
     *      type="big_decimal"
     */
    public BigDecimal getDescontoMulta() {
        return descontoMulta;
    }

    /**
     * @param descontoMulta 
     *              The descontoMulta to set.
     */
    public void setDescontoMulta(BigDecimal descontoMulta) {
        this.descontoMulta = descontoMulta;
    }

    /**
     * @return Returns the dtAgendamento.
     *
     * @hibernate.property
     *      column="dt_agendamento"
     *      type="date"
     */
    public Date getDtAgendamento() {
        return dtAgendamento;
    }

    /**
     * @param dtAgendamento 
     *              The dtAgendamento to set.
     */
    public void setDtAgendamento(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    /**
     * @return Returns the dtAtend.
     *
     * @hibernate.property
     *      column="dt_atend"
     *      type="date"
     */
    public Date getDtAtend() {
        return dtAtend;
    }

    /**
     * @param dtAtend 
     *              The dtAtend to set.
     */
    public void setDtAtend(Date dtAtend) {
        this.dtAtend = dtAtend;
    }

    /**
     * @return Returns the dtBaixa.
     *
     * @hibernate.property
     *      column="dt_baixa"
     *      type="date"
     */
    public Date getDtBaixa() {
        return dtBaixa;
    }

    /**
     * @param dtBaixa 
     *              The dtBaixa to set.
     */
    public void setDtBaixa(Date dtBaixa) {
        this.dtBaixa = dtBaixa;
    }

    /**
     * @return Returns the dtDespacho.
     *
     * @hibernate.property
     *      column="dt_despacho"
     *      type="date"
     */
    public Date getDtDespacho() {
        return dtDespacho;
    }

    /**
     * @param dtDespacho 
     *              The dtDespacho to set.
     */
    public void setDtDespacho(Date dtDespacho) {
        this.dtDespacho = dtDespacho;
    }

    /**
     * @return Returns the dtExecucao.
     *
     * @hibernate.property
     *      column="dt_execucao"
     *      type="date"
     */
    public Date getDtExecucao() {
        return dtExecucao;
    }

    /**
     * @param dtExecucao 
     *              The dtExecucao to set.
     */
    public void setDtExecucao(Date dtExecucao) {
        this.dtExecucao = dtExecucao;
    }

    /**
     * @return Returns the dtPrazo.
     *
     * @hibernate.property
     *      column="dt_prazo"
     *      type="date"
     */
    public Date getDtPrazo() {
        return dtPrazo;
    }

    /**
     * @param dtPrazo 
     *              The dtPrazo to set.
     */
    public void setDtPrazo(Date dtPrazo) {
        this.dtPrazo = dtPrazo;
    }

    /**
     * @return Returns the emergencia.
     *
     * @hibernate.property
     *      column="emergencia"
     *      type="string"
     */
    public String getEmergencia() {
        return emergencia;
    }

    /**
     * @param emergencia 
     *              The emergencia to set.
     */
    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }

    /**
     * @return Returns the emissao.
     *
     * @hibernate.property
     *      column="emissao"
     *      type="int"
     */
    public Integer getEmissao() {
        return emissao;
    }

    /**
     * @param emissao 
     *              The emissao to set.
     */
    public void setEmissao(Integer emissao) {
        this.emissao = emissao;
    }

    /**
     * @return Returns the ender.
     *
     * @hibernate.many-to-one
     *      name="ender"
     *      class="br.com.netservicos.core.bean.sn.SnEnderBean"
     *      column="id_ender"
     *      cascade="none"
     *      lazy="proxy"      
     */
    public SnEnderBean getEnder() {
        return ender;
    }

    /**
     * @param ender 
     *              The ender to set.
     */
    public void setEnder(SnEnderBean ender) {
        this.ender = ender;
    }

    /**
     * @return Returns the hrInicioExecucao.
     *
     * @hibernate.property
     *      column="hr_inicio_execucao"
     *      type="date"
     */
    public Date getHrInicioExecucao() {
        return hrInicioExecucao;
    }

    /**
     * @param hrInicioExecucao 
     *              The hrInicioExecucao to set.
     */
    public void setHrInicioExecucao(Date hrInicioExecucao) {
        this.hrInicioExecucao = hrInicioExecucao;
    }

    /**
     * @return Returns the hrTerminoExecucao.
     *
     * @hibernate.property
     *      column="hr_termino_execucao"
     *      type="date"
     */
    public Date getHrTerminoExecucao() {
        return hrTerminoExecucao;
    }

    /**
     * @param hrTerminoExecucao 
     *              The hrTerminoExecucao to set.
     */
    public void setHrTerminoExecucao(Date hrTerminoExecucao) {
        this.hrTerminoExecucao = hrTerminoExecucao;
    }

    /**
     * @return Returns the imediata.
     *
     * @hibernate.property
     *      column="imediata"
     *      type="long"
     */
    public Long getImediata() {
        return imediata;
    }

    /**
     * @param imediata 
     *              The imediata to set.
     */
    public void setImediata(Long imediata) {
        this.imediata = imediata;
    }

    /**
     * @return Returns the isento.
     *
     * @hibernate.property
     *      column="isento"
     *      type="int"
     */
    public Integer getIsento() {
        return isento;
    }

    /**
     * @param isento 
     *              The isento to set.
     */
    public void setIsento(Integer isento) {
        this.isento = isento;
    }

    /**
     * @return Returns the nomeSolic.
     *
     * @hibernate.property
     *      column="nome_solic"
     *      type="string"
     */
    public String getNomeSolic() {
        return nomeSolic;
    }

    /**
     * @param nomeSolic 
     *              The nomeSolic to set.
     */
    public void setNomeSolic(String nomeSolic) {
        this.nomeSolic = nomeSolic;
    }

    /**
     * @return Returns the obs.
     *
     * @hibernate.property
     *      column="obs"
     *      type="string"
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs 
     *              The obs to set.
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return Returns the solicitacaoAss.
     *
     * @hibernate.many-to-one
     *      name="solicitacaoAss"
     *      class="br.com.netservicos.core.bean.sn.SnSolicitacaoAssBean"
     *      column="id_solicitacao_ass"
     *      cascade="none"
     *      lazy="proxy" 
     */
    public SnSolicitacaoAssBean getSolicitacaoAss() {
        return solicitacaoAss;
    }

    /**
     * @param solicitacaoAss 
     *              The solicitacaoAss to set.
     */
    public void setSolicitacaoAss(SnSolicitacaoAssBean solicitacaoAss) {
        this.solicitacaoAss = solicitacaoAss;
    }

    /**
     * @return Returns the telSolic.
     *
     * @hibernate.property
     *      column="tel_solic"
     *      type="string"
     */
    public String getTelSolic() {
        return telSolic;
    }

    /**
     * @param telSolic 
     *              The telSolic to set.
     */
    public void setTelSolic(String telSolic) {
        this.telSolic = telSolic;
    }

    /**
     * @return Returns the idPonto.
     *
     * @hibernate.property
     *      column="id_ponto"
     *      type="long"
     */
    public Long getIdPonto() {
        return idPonto;
    }

    /**
     * @param idPonto 
     *              The idPonto to set.
     */
    public void setIdPonto(Long idPonto) {
        this.idPonto = idPonto;
    }

}
