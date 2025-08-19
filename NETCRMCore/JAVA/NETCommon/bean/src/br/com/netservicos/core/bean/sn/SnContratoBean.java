/**
* Created on 06/01/2009
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
* $Id: SnContratoBean.java,v 1.15 2011/03/17 17:18:23 T0196500 Exp $
*/
package br.com.netservicos.core.bean.sn;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_contrato
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
 *                           Prior
 * Date       By             Version  Project/CSR       Description
 * ---------- -------------- -------- --------------    -------------------------
 * 06/01/2009 Luis Carneiro  N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author Luis Henrique Carneiro
 * @since 06/01/2009
 * @version $Revision: 1.15 $
 * 
 * @hibernate.class 
 *      table="sn_contrato"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *      batch-size="10"
 *
 * @hibernate.query 
 *      name = "lstContratos"
 *      query = "FROM 
 *                  br.com.netservicos.core.bean.sn.SnContratoBean cont,
 *              WHERE 
 *                  cont.compositeKey.numContrato = :numContrato"
 * @hibernate.cache
 *      usage="read-write"
 */
public class SnContratoBean extends DomainBean {

    private static final long serialVersionUID = -2734588849396120155L;
    public static final String COMPOSITE_KEY = "compositeKey";
    public static final String PROCURA_CONTRATO_POR_NUM_CONTRATO_COD_OPERADORA = "procuraContratoPorNumContratoCodOperadora";
    public static final String LST_CONTRATO_BY_IMOVEL = "lstContratosByImovel";
    public static final String LST_CONTRATO_BY_HP = "lstContratosByHP";
    public static final String PROCURA_CONTRATO_POR_NUM_CONTRATO_CID_CONTRATO = "procuraContratoPorNumContratoCidContrato";
       
    public static final String LST_CONTRATO = "lstContratos";
    
    private SnAssinanteBean assinante;
    private SnContratoKey compositeKey;
    private Integer digitoVerificacao;
    private Integer idTipoContrato;
    private Integer idTipoDistribuicao;
    private Integer numPontoExtra;
    private Date dtVenda;
    private Date dtInstalacao;
    private Date dtCancelamento;
    private Integer idCicloCobranca;
    private Integer qtdRevistas;
    private Integer qtdRevistasCobraveis;
    private Integer qtdDecoders;
    private Integer qtdDecodersCobraveis;
    private String textoSituacaoIrregular;
    private Integer qtdAssinaturas;
    private Integer numContratoImp;
    private Integer numPtoExtraCob;
    private Integer adesaoPreDatado;
    private Date dtCadastro;
    private Long osInstImediata;
    private Date dtLibInstalacao;
    private Date dtRefEntrada;
    private Integer idTipoReajuste;
    private Integer prazoInstalacao;
    private String senha;
    private Integer totalPontos;
    private String obs;
    private Integer idTipoPreco;
    private Float valorIva;
    private Long numContratoEmbratel;
    private Integer contratoCortesia;
    private String fcCobrancaProRata;
    private Date dtFaturaRateio;
    private String tpFaturamentoVirtua;
    private SnFormaEnvioFaturaBean formaEnvioFatura;
    private SnDiaVctoBean diaVcto;    

    public SnContratoBean() {
        super(COMPOSITE_KEY);
    }

    /**
     * @return Returns the assinante.
     *
     * @hibernate.many-to-one   
     *      name="assinante"
     *      class="br.com.netservicos.core.bean.sn.SnAssinanteBean"
     *      column="id_assinante"
     *      cascade="none"
     *      lazy="proxy"      
     */
    public SnAssinanteBean getAssinante() {
        return assinante;
    }

    /**
     * @param assinante 
     *              The assinante to set.
     */
    public void setAssinante(SnAssinanteBean assinante) {
        this.assinante = assinante;
    }

    /**
     * @return Returns the compositeKey.
     *
     * @hibernate.id
     *      type="composite"
     */
    public SnContratoKey getCompositeKey() {
        return compositeKey;
    }

    /**
     * @param compositeKey 
     *              The compositeKey to set.
     */
    public void setCompositeKey(SnContratoKey compositeKey) {
        this.compositeKey = compositeKey;
    }

    /**
     * @return Returns the digitoVerificacao.
     *
     * @hibernate.property
     *      column="digito_verificacao"
     *      type="int"
     */
    public Integer getDigitoVerificacao() {
        return digitoVerificacao;
    }

    /**
     * @param digitoVerificacao 
     *              The digitoVerificacao to set.
     */
    public void setDigitoVerificacao(Integer digitoVerificacao) {
        this.digitoVerificacao = digitoVerificacao;
    }
    
    /**
     * @return the idTipoContrato
     *      column="id_tipo_contrato"
     *      type="int"
     */
    public Integer getIdTipoContrato() {
        return idTipoContrato;
    }

    /**
     * @param idTipoContrato the idTipoContrato to set
     */
    public void setIdTipoContrato(Integer idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    /**
     * @return Returns the idTipoDistribuicao.
     *
     * @hibernate.property
     *      column="id_tipo_distribuicao"
     *      type="int"
     */
    public Integer getIdTipoDistribuicao() {
        return idTipoDistribuicao;
    }

    /**
     * @param idTipoDistribuicao 
     *              The idTipoDistribuicao to set.
     */
    public void setIdTipoDistribuicao(Integer idTipoDistribuicao) {
        this.idTipoDistribuicao = idTipoDistribuicao;
    }

    /**
     * @return Returns the numPontoExtra.
     *
     * @hibernate.property
     *      column="num_ponto_extra"
     *      type="int"
     */
    public Integer getNumPontoExtra() {
        return numPontoExtra;
    }

    /**
     * @param numPontoExtra 
     *              The numPontoExtra to set.
     */
    public void setNumPontoExtra(Integer numPontoExtra) {
        this.numPontoExtra = numPontoExtra;
    }

    /**
     * @return Returns the dtVenda.
     *
     * @hibernate.property
     *      column="dt_venda"
     *      type="date"
     */
    public Date getDtVenda() {
        return dtVenda;
    }

    /**
     * @param dtVenda 
     *              The dtVenda to set.
     */
    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    /**
     * @return Returns the dtInstalacao.
     *
     * @hibernate.property
     *      column="dt_instalacao"
     *      type="date"
     */
    public Date getDtInstalacao() {
        return dtInstalacao;
    }

    /**
     * @param dtInstalacao 
     *              The dtInstalacao to set.
     */
    public void setDtInstalacao(Date dtInstalacao) {
        this.dtInstalacao = dtInstalacao;
    }

    /**
     * @return Returns the dtCancelamento.
     *
     * @hibernate.property
     *      column="dt_cancelamento"
     *      type="date"
     */
    public Date getDtCancelamento() {
        return dtCancelamento;
    }

    /**
     * @param dtCancelamento 
     *              The dtCancelamento to set.
     */
    public void setDtCancelamento(Date dtCancelamento) {
        this.dtCancelamento = dtCancelamento;
    }
    
    /**
     * @return the idCicloCobranca
     *      column="id_ciclo_cobranca"
     *      type="int"
     */
    public Integer getIdCicloCobranca() {
        return idCicloCobranca;
    }

    /**
     * @param idCicloCobranca the idCicloCobranca to set
     */
    public void setIdCicloCobranca(Integer idCicloCobranca) {
        this.idCicloCobranca = idCicloCobranca;
    }

    /**
     * @return Returns the qtdRevistas.
     *
     * @hibernate.property
     *      column="qtd_revistas"
     *      type="int"
     */
    public Integer getQtdRevistas() {
        return qtdRevistas;
    }

    /**
     * @param qtdRevistas 
     *              The qtdRevistas to set.
     */
    public void setQtdRevistas(Integer qtdRevistas) {
        this.qtdRevistas = qtdRevistas;
    }

    /**
     * @return Returns the qtdRevistasCobraveis.
     *
     * @hibernate.property
     *      column="qtd_revistas_cobraveis"
     *      type="int"
     */
    public Integer getQtdRevistasCobraveis() {
        return qtdRevistasCobraveis;
    }

    /**
     * @param qtdRevistasCobraveis 
     *              The qtdRevistasCobraveis to set.
     */
    public void setQtdRevistasCobraveis(Integer qtdRevistasCobraveis) {
        this.qtdRevistasCobraveis = qtdRevistasCobraveis;
    }

    /**
     * @return Returns the qtdDecoders.
     *
     * @hibernate.property
     *      column="qtd_decoders"
     *      type="int"
     */
    public Integer getQtdDecoders() {
        return qtdDecoders;
    }

    /**
     * @param qtdDecoders 
     *              The qtdDecoders to set.
     */
    public void setQtdDecoders(Integer qtdDecoders) {
        this.qtdDecoders = qtdDecoders;
    }

    /**
     * @return Returns the qtdDecodersCobraveis.
     *
     * @hibernate.property
     *      column="qtd_decoders_cobraveis"
     *      type="int"
     */
    public Integer getQtdDecodersCobraveis() {
        return qtdDecodersCobraveis;
    }

    /**
     * @param qtdDecodersCobraveis 
     *              The qtdDecodersCobraveis to set.
     */
    public void setQtdDecodersCobraveis(Integer qtdDecodersCobraveis) {
        this.qtdDecodersCobraveis = qtdDecodersCobraveis;
    }

    /**
     * @return Returns the textoSituacaoIrregular.
     *
     * @hibernate.property
     *      column="texto_situacao_irregular"
     *      type="string"
     */
    public String getTextoSituacaoIrregular() {
        return textoSituacaoIrregular;
    }

    /**
     * @param textoSituacaoIrregular 
     *              The textoSituacaoIrregular to set.
     */
    public void setTextoSituacaoIrregular(String textoSituacaoIrregular) {
        this.textoSituacaoIrregular = textoSituacaoIrregular;
    }

    /**
     * @return Returns the qtdAssinaturas.
     *
     * @hibernate.property
     *      column="qtd_assinaturas"
     *      type="int"
     */
    public Integer getQtdAssinaturas() {
        return qtdAssinaturas;
    }

    /**
     * @param qtdAssinaturas 
     *              The qtdAssinaturas to set.
     */
    public void setQtdAssinaturas(Integer qtdAssinaturas) {
        this.qtdAssinaturas = qtdAssinaturas;
    }

    /**
     * @return Returns the numContratoImp.
     *
     * @hibernate.property
     *      column="num_contrato_imp"
     *      type="int"
     */
    public Integer getNumContratoImp() {
        return numContratoImp;
    }

    /**
     * @param numContratoImp 
     *              The numContratoImp to set.
     */
    public void setNumContratoImp(Integer numContratoImp) {
        this.numContratoImp = numContratoImp;
    }

    /**
     * @return Returns the numPtoExtraCob.
     *
     * @hibernate.property
     *      column="num_pto_extra_cob"
     *      type="int"
     */
    public Integer getNumPtoExtraCob() {
        return numPtoExtraCob;
    }

    /**
     * @param numPtoExtraCob 
     *              The numPtoExtraCob to set.
     */
    public void setNumPtoExtraCob(Integer numPtoExtraCob) {
        this.numPtoExtraCob = numPtoExtraCob;
    }

    /**
     * @return Returns the adesaoPreDatado.
     *
     * @hibernate.property
     *      column="adesao_pre_datado"
     *      type="int"
     */
    public Integer getAdesaoPreDatado() {
        return adesaoPreDatado;
    }

    /**
     * @param adesaoPreDatado 
     *              The adesaoPreDatado to set.
     */
    public void setAdesaoPreDatado(Integer adesaoPreDatado) {
        this.adesaoPreDatado = adesaoPreDatado;
    }

    /**
     * @return Returns the dtCadastro.
     *
     * @hibernate.property
     *      column="dt_cadastro"
     *      type="date"
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * @param dtCadastro 
     *              The dtCadastro to set.
     */
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /**
     * @return Returns the osInstImediata.
     *
     * @hibernate.property
     *      column="os_inst_imediata"
     *      type="long"
     */
    public Long getOsInstImediata() {
        return osInstImediata;
    }

    /**
     * @param osInstImediata 
     *              The osInstImediata to set.
     */
    public void setOsInstImediata(Long osInstImediata) {
        this.osInstImediata = osInstImediata;
    }

    /**
     * @return Returns the dtLibInstalacao.
     *
     * @hibernate.property
     *      column="dt_lib_instalacao"
     *      type="date"
     */
    public Date getDtLibInstalacao() {
        return dtLibInstalacao;
    }

    /**
     * @param dtLibInstalacao 
     *              The dtLibInstalacao to set.
     */
    public void setDtLibInstalacao(Date dtLibInstalacao) {
        this.dtLibInstalacao = dtLibInstalacao;
    }

    /**
     * @return Returns the dtRefEntrada.
     *
     * @hibernate.property
     *      column="dt_ref_entrada"
     *      type="date"
     */
    public Date getDtRefEntrada() {
        return dtRefEntrada;
    }

    /**
     * @param dtRefEntrada 
     *              The dtRefEntrada to set.
     */
    public void setDtRefEntrada(Date dtRefEntrada) {
        this.dtRefEntrada = dtRefEntrada;
    }

    /**
     * @return Returns the idTipoReajuste.
     *
     * @hibernate.property
     *      column="id_tipo_reajuste"
     *      type="int"
     */
    public Integer getIdTipoReajuste() {
        return idTipoReajuste;
    }

    /**
     * @param idTipoReajuste 
     *              The idTipoReajuste to set.
     */
    public void setIdTipoReajuste(Integer idTipoReajuste) {
        this.idTipoReajuste = idTipoReajuste;
    }

    /**
     * @return Returns the prazoInstalacao.
     *
     * @hibernate.property
     *      column="prazo_instalacao"
     *      type="int"
     */
    public Integer getPrazoInstalacao() {
        return prazoInstalacao;
    }

    /**
     * @param prazoInstalacao 
     *              The prazoInstalacao to set.
     */
    public void setPrazoInstalacao(Integer prazoInstalacao) {
        this.prazoInstalacao = prazoInstalacao;
    }

    /**
     * @return Returns the senha.
     *
     * @hibernate.property
     *      column="senha"
     *      type="string"
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha 
     *              The senha to set.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return Returns the totalPontos.
     *
     * @hibernate.property
     *      column="total_pontos"
     *      type="int"
     */
    public Integer getTotalPontos() {
        return totalPontos;
    }

    /**
     * @param totalPontos 
     *              The totalPontos to set.
     */
    public void setTotalPontos(Integer totalPontos) {
        this.totalPontos = totalPontos;
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
     * @return Returns the idTipoPreco.
     *
     * @hibernate.property
     *      column="id_tipo_preco"
     *      type="int"
     */
    public Integer getIdTipoPreco() {
        return idTipoPreco;
    }

    /**
     * @param idTipoPreco 
     *              The idTipoPreco to set.
     */
    public void setIdTipoPreco(Integer idTipoPreco) {
        this.idTipoPreco = idTipoPreco;
    }

    /**
     * @return Returns the valorIva.
     *
     * @hibernate.property
     *      column="valor_iva"
     *      type="float"
     */
    public Float getValorIva() {
        return valorIva;
    }

    /**
     * @param valorIva 
     *              The valorIva to set.
     */
    public void setValorIva(Float valorIva) {
        this.valorIva = valorIva;
    }

    /**
     * @return Returns the numContratoEmbratel.
     *
     * @hibernate.property
     *      column="num_contrato_embratel"
     *      type="long"
     */
    public Long getNumContratoEmbratel() {
        return numContratoEmbratel;
    }

    /**
     * @param numContratoEmbratel 
     *              The numContratoEmbratel to set.
     */
    public void setNumContratoEmbratel(Long numContratoEmbratel) {
        this.numContratoEmbratel = numContratoEmbratel;
    }

    /**
     * @return Returns the contratoCortesia.
     *
     * @hibernate.property
     *      column="contrato_cortesia"
     *      type="int"
     */
    public Integer getContratoCortesia() {
        return contratoCortesia;
    }

    /**
     * @param contratoCortesia 
     *              The contratoCortesia to set.
     */
    public void setContratoCortesia(Integer contratoCortesia) {
        this.contratoCortesia = contratoCortesia;
    }

    /**
     * @return Returns the fcCobrancaProRata.
     *
     * @hibernate.property
     *      column="fc_cobranca_pro_rata"
     *      type="string"
     */
    public String getFcCobrancaProRata() {
        return fcCobrancaProRata;
    }

    /**
     * @param fcCobrancaProRata 
     *              The fcCobrancaProRata to set.
     */
    public void setFcCobrancaProRata(String fcCobrancaProRata) {
        this.fcCobrancaProRata = fcCobrancaProRata;
    }

    /**
     * @return Returns the dtFaturaRateio.
     *
     * @hibernate.property
     *      column="dt_fatura_rateio"
     *      type="date"
     */
    public Date getDtFaturaRateio() {
        return dtFaturaRateio;
    }

    /**
     * @param dtFaturaRateio 
     *              The dtFaturaRateio to set.
     */
    public void setDtFaturaRateio(Date dtFaturaRateio) {
        this.dtFaturaRateio = dtFaturaRateio;
    }

    /**
     * @return Returns the tpFaturamentoVirtua.
     *
     * @hibernate.property
     *      column="tp_faturamento_virtua"
     *      type="string"
     */
    public String getTpFaturamentoVirtua() {
        return tpFaturamentoVirtua;
    }

    /**
     * @param tpFaturamentoVirtua 
     *              The tpFaturamentoVirtua to set.
     */
    public void setTpFaturamentoVirtua(String tpFaturamentoVirtua) {
        this.tpFaturamentoVirtua = tpFaturamentoVirtua;
    }
    /**
     * @hibernate.many-to-one
     *      name="formaEnvioFatura"
     *      class="br.com.netservicos.core.bean.sn.SnFormaEnvioFaturaBean"
     *      column="id_forma_envio_fatura"
     *      cascade="none"
     *      lazy="false" 
     */  
    public SnFormaEnvioFaturaBean getFormaEnvioFatura() {
        return formaEnvioFatura;
    }

    /**
     * @param idFormaEnvioFatura 
     *              The idFormaEnvioFatura to set.
     */
    public void setFormaEnvioFatura(SnFormaEnvioFaturaBean formaEnvioFatura) {
        this.formaEnvioFatura = formaEnvioFatura;
    }
    
    /**
     * Obtains and returns the DiaVctoBean.
     *
     * @return Returns the diaVcto.
     * 
     * @hibernate.many-to-one  
     * class="br.com.netservicos.core.bean.sn.SnDiaVctoBean" 
     * column="id_dia_vcto"
     * cascade="none"
     * not-null="false"
     * lazy="proxy"
     * 
     */
    public SnDiaVctoBean getDiaVcto() {
        return diaVcto;
    }

    public void setDiaVcto(SnDiaVctoBean diaVcto) {
        this.diaVcto = diaVcto;
    }
}
