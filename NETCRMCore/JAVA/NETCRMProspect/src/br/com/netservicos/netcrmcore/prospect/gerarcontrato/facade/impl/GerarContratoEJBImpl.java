package br.com.netservicos.netcrmcore.prospect.gerarcontrato.facade.impl;

import java.math.BigDecimal;
import java.sql.Types;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

import br.com.netservicos.core.bean.cp.CpCartaoCreditoBean;
import br.com.netservicos.core.bean.cp.CpChamadoBean;
import br.com.netservicos.core.bean.cp.CpCobrancaBean;
import br.com.netservicos.core.bean.cp.CpContaCorrenteBean;
import br.com.netservicos.core.bean.cp.CpEnderecoProspectBean;
import br.com.netservicos.core.bean.cp.CpMotivoFinalizacaoBean;
import br.com.netservicos.core.bean.cp.CpPontoBean;
import br.com.netservicos.core.bean.cp.CpPrepostoProspectBean;
import br.com.netservicos.core.bean.cp.CpProdutosAgregadosBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpPropostaServicoBean;
import br.com.netservicos.core.bean.cp.CpProspectBean;
import br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean;
import br.com.netservicos.core.bean.cp.CpStatusPropostaBean;
import br.com.netservicos.core.bean.cp.CpVendedorBean;
import br.com.netservicos.core.bean.sn.SnTipoPessoaBean;
import br.com.netservicos.core.bean.sn.SnTipoSegmentoBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.bean.ResultSetBeanCollection;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.framework.util.exception.BaseBusinessException;
import br.com.netservicos.framework.util.exception.BaseFailureException;
import br.com.netservicos.netcrmcore.endereco.core.facade.EnderecoService;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.prospect.constants.GerarContratoConstants;
import br.com.netservicos.netcrmcore.prospect.constants.ProspectConstants;
import br.com.netservicos.netcrmcore.prospect.core.facade.impl.AbstractNETCRMProspectEJBImpl;
import br.com.netservicos.netcrmcore.prospect.core.helper.GerarContratoHelper;
import br.com.netservicos.netcrmcore.prospect.gerarcontrato.facade.GerarContratoService;
import br.com.netservicos.netcrmcore.venda.agendamento.facade.AgendamentoService;
import br.com.netservicos.netcrmcore.venda.constants.PropostaConstants;
import br.com.netservicos.netcrmcore.venda.proposta.facade.PropostaService;
import br.com.netservicos.netcrmcore.venda.proposta.pendencia.facade.PendenciaService;

/**
 * EJB responsável pela validação / alteração dos dados cadastrais do cliente.
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean name="GerarContratoEJB" type="Stateless" display-name="ProspectEJB"
 *           description="GerarContratoEJB Session EJB Stateless"
 *           view-type="both"
 *           jndi-name="netcrmcore/prospect/ejb/GerarContratoEJB"
 *           local-jndi-name="netcrmcore/prospect/ejb/local/GerarContratoEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @weblogic.transaction-descriptor trans-timeout-seconds = "120"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class GerarContratoEJBImpl extends AbstractNETCRMProspectEJBImpl implements GerarContratoService {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1713492184667436066L;
    

    /**
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="RequiresNew"
     * @ejb.permission role-name="CRM_GERAR_CONTRATO"
     */
    public Bean gerarContrato(final Long idProposta) {

        final DynamicBean retorno = new DynamicBean();

        final CpPropostaBean proposta = obterProposta(idProposta);
        this.verificaPendenciasProposta(proposta);
        final CpProspectBean prospect = proposta.getProspect();
        final CpEnderecoProspectBean endInstalacao = obterEnderecoInstalacao(prospect.getIdProspect());
        final CpEnderecoProspectBean enderecoCobranca = obterEnderecoCobranca(prospect.getIdProspect());

        this.validateStatusEndereco(proposta, endInstalacao, Integer.valueOf(1));
        final Long idEndereco = associarEnderecoNETSMS(proposta, endInstalacao);
        final Long idAssinante = inserirAssinanteNETSMS(idEndereco, proposta);

        this.inserirEnderecoCobrancaNETSMS(enderecoCobranca, proposta, idAssinante);
        proposta.setDtVenda(getCurrentDAO().getSysdate());
        final Long numContrato = inserirContratoNETSMS(proposta, idAssinante);
        proposta.setNumContrato(numContrato.intValue());

        this.inserirProdutoAgregadoEnvioContrato(proposta, numContrato);
        this.selecionaSegmentoProposta(proposta, endInstalacao);
        this.trataInsercoesPontosProposta(proposta, idEndereco, idAssinante, numContrato, endInstalacao);
        this.inserirServosAvancados(proposta, numContrato);
        //naoo é necessario pois a proposta vai ser finalizada na hora que é feito o agendamento
        //this.trataBloqueioAgenda(proposta);

        final CpCobrancaBean cobranca = obterCobrancaProposta(proposta);
        this.inserirDadosCobranca(proposta, numContrato, cobranca);

        insertContratoPreposto(numContrato, proposta);

        finalizaGeracaoContrato(proposta, numContrato, idEndereco, idAssinante);

        proposta.setNumContrato(Integer.valueOf(numContrato.intValue()));
        final CpStatusPropostaBean status = new CpStatusPropostaBean(ProspectConstants.STATUS_ENVIADA);
        proposta.setStatusProposta(status);
        super.update(proposta, getUserSession().getCurrentDbService());

        finalizaChamados(proposta);
        retorno.addBeanProperty(ProspectConstants.PROPERTY_NUM_CONTRATO, GeralUtil.toString(numContrato));
        retorno.addBeanProperty(ProspectConstants.PROPERTY_ID_ASSINANTE, GeralUtil.toString(idAssinante));

        return retorno;
    }
    
    
    /**
     * Método responsável por criar proposta
     *  
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="RequiresNew"
     * @ejb.permission role-name="CRM_MANTER_PROPOSTA"
     */
    public void atualizaStatusProposta(Long idProposta, Integer status) {       
        CpPropostaBean proposta = obterProposta(idProposta);
        proposta.setStatusProposta(new CpStatusPropostaBean(status.intValue()));        
        super.update(proposta, getUserSession().getCurrentDbService());
    }

    /**
     * @param proposta
     * @param numContrato
     * @param cobranca
     */
    private void inserirDadosCobranca(final CpPropostaBean proposta,
                                            final Long numContrato, final CpCobrancaBean cobranca) {

        if (GerarContratoHelper.validaInclusaoContaCorrente(proposta, cobranca)) {
            insertContaCorrenteNETSMS(proposta, numContrato);
        }
        if (GerarContratoHelper.validaCartaoInclusaoCredito(proposta, cobranca)) {
            sendCartaoMensalidadeNETSMS(proposta, numContrato);
        }
    }

    /**
     * @param proposta
     * @return
     */
    private CpCobrancaBean obterCobrancaProposta(final CpPropostaBean proposta) {
        final CpCobrancaBean cpCobranca = new CpCobrancaBean();
        cpCobranca.setIdProposta(proposta.getIdProposta());
        final CpCobrancaBean cobranca = (CpCobrancaBean) this.getCurrentDAO().findByPrimaryKey(cpCobranca);
        return cobranca;
    }

    /**
     * @param proposta
     */
    private void trataBloqueioAgenda(final CpPropostaBean proposta) {
        boolean agendaBloqueada = Boolean.FALSE;
        agendaBloqueada = this.validateBloqueioAgenda(proposta);

        if (agendaBloqueada) {   
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(GerarContratoConstants.MSG_ERRO_TRATA_BLOQUEIO_AGENDA, new Object[0]));
        }
    }

    /**
     * @param proposta
     * @param numContrato
     */
    private void inserirServosAvancados(final CpPropostaBean proposta, final Long numContrato) {
        final BatchParameter[] parametros = GerarContratoHelper.obterParametrosBuscaServicosProposta(proposta);

        final List resultSetCol = (List) getCurrentDAO()
                                                .executeBatch(ProspectConstants.
                                               PROC_PGSMS_SERVICO_AVANCADO_BUSCA_PROPOSTA_SERVICOS,
                                               parametros);

        final ResultSetBeanCollection retornaProposta = (ResultSetBeanCollection) resultSetCol.get(0);
        List retorno = new ArrayList();
        
        for (int i = 0; i < retornaProposta.size(); i++) {
            DynamicBean dynamicBean = (DynamicBean) retornaProposta.get(i);

            BigDecimal idProduto = (BigDecimal) dynamicBean.get(GerarContratoConstants.ID_PRODUTO);
            BigDecimal idPromocao = (BigDecimal) dynamicBean.get(GerarContratoConstants.ID_PROMOCAO);
            BigDecimal idPlanoPgto = (BigDecimal) dynamicBean.get(GerarContratoConstants.ID_PLANO_PGTO);
            BigDecimal idTipoVenda = (BigDecimal) dynamicBean.get(GerarContratoConstants.ID_TIPO_VENDA);
            BigDecimal idEquipeVenda = (BigDecimal) dynamicBean.get(GerarContratoConstants.ID_EQUIPE_VENDA);
            BigDecimal idMidia = (BigDecimal) dynamicBean.get(GerarContratoConstants.ID_MIDIA);
            BigDecimal idCampanha = (BigDecimal) dynamicBean.get(GerarContratoConstants.ID_CAMPANHA);

            CpVendedorBean vendedor = proposta.getVendedor();
            vendedor = (CpVendedorBean) super.initializeLazyProperties(vendedor);

            BatchParameter[] parameters = GerarContratoHelper.obterParametrosEnvioIssServAvancados(proposta,
                                          numContrato, dynamicBean, idProduto, idPromocao, idPlanoPgto,
                                          idTipoVenda, idEquipeVenda, idMidia, idCampanha, vendedor);            

            retorno = getCurrentDAO().executeBatch(ProspectConstants.
                                                    PROC_PGSMS_SERVICO_AVANCADO_INCLUI_SERVICO_AVANCADO,
                                                    parameters);

            final String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_18);
            final BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_19);
            trataErroRetornoProcedure(proposta, msgError, codError);
        }
    }

    /**
     * @param proposta
     * @param msgError
     * @param codError
     */
    private void trataErroRetornoProcedure(final CpPropostaBean proposta, final String msgError,
                                            final BigDecimal codError) {
        if (!GeralUtil.isNull(codError) && !codError.equals(BigDecimal.ZERO)) {                
            tratarErroEnvioContrato(proposta.getIdProposta());                
            lancarErrosValidacao(GerarContratoConstants.MSG_ERRO_ENVIO_CONTRATO, msgError);
        }
    }

    /**
     * @param proposta
     * @param idEndereco
     * @param idAssinante
     * @param numContrato
     */
    private void trataInsercoesPontosProposta(final CpPropostaBean proposta,
                                        final Long idEndereco,final Long idAssinante,
                                        final Long numContrato ,final CpEnderecoProspectBean endInstalacao) {
        Long idPonto = null;
        Iterator pontos = proposta.getPontos().iterator();
        while (pontos.hasNext()) {
            CpPontoBean ponto = (CpPontoBean) pontos.next();         
            idPonto = inseirPontoProposta(proposta, idEndereco, numContrato, idPonto, ponto);          
            this.inserirPontoProdutoNETSMS(proposta, ponto, idPonto, numContrato, 
                                                    idAssinante, idEndereco,endInstalacao);           
            this.inserirProdutoAgregado(proposta, idEndereco, idAssinante, numContrato, idPonto, ponto);
            if (ponto.getCaracteristica().getIdCaracteristica().longValue() == ProspectConstants.VOIP) {
                this.confirmaReservaTel(proposta, idPonto, numContrato, ponto);
            }           
            this.insereSolicitacaoExtensaoNETFone(proposta, numContrato, ponto);
        }
    }

    /**
     * @param proposta
     */
    private void finalizaChamados(final CpPropostaBean proposta) {
               
        if (!CollectionUtils.isEmpty(proposta.getProspect().getChamados())) {
            Iterator chamados = proposta.getProspect().getChamados().iterator();                    
            while (chamados.hasNext()) {
                CpChamadoBean chamado = (CpChamadoBean) chamados.next();
                CpMotivoFinalizacaoBean motivoFinalizacao = new CpMotivoFinalizacaoBean();
                motivoFinalizacao.setIdMotivoFinalizacao(Integer.valueOf(1));
                chamado.setMotivoFinalizacao(motivoFinalizacao);        
                super.update(chamado, getUserSession().getCurrentDbService());
            }
        }
    }

    /**
     * @param proposta
     * @param idEndereco
     * @param idAssinante
     * @param numContrato
     * @param idPonto
     * @param ponto
     * @param prodAgregado
     */
    private void inserirProdutoAgregado(final CpPropostaBean proposta,final Long idEndereco, 
                                            final Long idAssinante,
                                            final Long numContrato, 
                                            final Long idPonto, 
                                            final CpPontoBean ponto) {

        List lstProdAgregados = ponto.getProdutosAgregados();
        Iterator prodAgregados = lstProdAgregados.iterator();
        while (prodAgregados.hasNext()) {
            CpProdutosAgregadosBean prodAgregado = (CpProdutosAgregadosBean) prodAgregados.next();
            if (prodAgregado.getProduto().getTipoProduto().getIdTipoProduto().equals(
                                                    Integer.valueOf(ProspectConstants.REVISTA_BOLETO))) {
                insertProdutoAgregado(proposta, prodAgregado, numContrato);
            }else {
                
                insertPontoProdutoAgregadoNETSMS(proposta, prodAgregado, idPonto, numContrato, idAssinante,
                                                        idEndereco, ponto);
            }
        }
    }

    /**
     * @param proposta
     * @param idEndereco
     * @param numContrato
     * @param idPonto
     * @param ponto
     * @return
     */
    private Long inseirPontoProposta(final CpPropostaBean proposta, 
                                            final Long idEndereco, 
                                            final Long numContrato, 
                                            Long idPonto,
                                            final CpPontoBean ponto) {
        if (GerarContratoHelper.validaInserirPonto(ponto)) {
            idPonto = insertPontoNETSMS(proposta, numContrato, ponto, idEndereco);
        }       
        if (GerarContratoHelper.verificaPontoDigital(ponto)) {
            insertRetornoTelefonicoNETSMS(proposta, ponto, idPonto);
        }        
        if (GerarContratoHelper.verificaPontoDigitalizado(ponto)) {
            insertRetornoTelefonicoNETSMS(proposta, ponto, idPonto);
        }
        return idPonto;
    }

    /**
     * @param proposta
     * @param enderecoInstalacao
     */
    private void selecionaSegmentoProposta(CpPropostaBean proposta, CpEnderecoProspectBean enderecoInstalacao) {                   
            SnTipoSegmentoBean segmento = new SnTipoSegmentoBean();
            segmento.setIdTipoSegmento(ProspectConstants.TIPO_SEGMENTACAO_SEM_SEGMENTO);
            proposta.setTipoSegmento(segmento);        
    }

    /**
     * 
     * Finaliza Processo de Envio do Contrato Chama Procedure:
     * ISS_ENVIO_CONTRATO.FINALIZA_PROCESSO
     * 
     * @return void Finaliza Processo de Envio do Contrato
     */
    public void finalizaGeracaoContrato(final CpPropostaBean proposta, final Long numContrato, final Long idEndereco,
                                            final Long idAssinante) {

        List retorno = new ArrayList();         
        Integer idPeriodo = null;
        final StringBuffer plst_solic = new StringBuffer();
        final StringBuffer plst_prod_de = new StringBuffer();
        final StringBuffer plst_prod_para = new StringBuffer();             
        
        List pontos = proposta.getPontosPrincipais();
        String produtosPP = GerarContratoHelper.obterDescricaoPontoPrincipal(pontos);      
        String produtosAdicPP = GerarContratoHelper.obterDescricaoPontoAdicionaisPP(pontos);      
        
        // Montando o parametro para os pontos adicionais        
        List pontosAdicionais = proposta.getPontosAdicionais();
        String produtosPA =  GerarContratoHelper.obterDescricaoPontoAdicionais(pontosAdicionais);      
        String produtosAdicPA = GerarContratoHelper.obterDescricaoPontoAdicionaisPA(pontosAdicionais);

        /*
         * Montando o parametro para dados adicionais de pontos Aquisicao,
         * provedor, ip_extra, degustacao
         */
        Iterator dadosPontos = proposta.getDadosPontos().iterator();
        while (dadosPontos.hasNext()) {
            CpPontoBean ponto = (CpPontoBean) dadosPontos.next();
            if (ponto.getPontoPai().getTipoPonto().getIdTipoPonto().equals(ProspectConstants.ID_PONTO_PRINCIPAL)) {
                produtosAdicPP += GerarContratoConstants.ASTERISCO + 
                ponto.getProduto().getIdProduto() + GerarContratoConstants.ASTERISCO;
            } else {
                produtosAdicPA += GerarContratoConstants.ASTERISCO + 
                ponto.getProduto().getIdProduto() + GerarContratoConstants.ASTERISCO;
            }
        }
        
        boolean validateSA = false;
        List propostaServicos = super.search(CpPropostaServicoBean.SELECT_BY_ID_PROPOSTA, proposta);
        if (!CollectionUtils.isEmpty(propostaServicos)) {
            for (Iterator it = propostaServicos.iterator(); it.hasNext();) {
                CpPropostaServicoBean cpProposta = ((CpPropostaServicoBean) it.next());
                if (!GeralUtil.isNull(cpProposta.getFcGeracaoOs())
                                                        && cpProposta.getFcGeracaoOs().trim()
                                                           .equals(GerarContratoConstants.S)) {
                    idPeriodo = cpProposta.getIdAgendamento();
                    if (plst_solic.toString().equals("")) {
                        plst_solic.append(GerarContratoConstants.SOLIC_917);
                        plst_prod_de.append(GerarContratoConstants.SOLIC_999);
                        plst_prod_para.append(cpProposta.getProduto().getIdProduto());
                    } else {
                        plst_solic.append(GerarContratoConstants.ASTERISCO_SOLIC_917);
                        plst_prod_de.append(GerarContratoConstants.ASTERISCO_SOLIC_999);
                        plst_prod_para.append(GerarContratoConstants.ASTERISCO + 
                        cpProposta.getProduto().getIdProduto());
                    }
                    validateSA = true;

                }
            }
        }
        
        final DynamicBean dynamicBean = new DynamicBean();
        dynamicBean.set("cidContrato", proposta.getCidadeOperadora().getIdCidade());
        dynamicBean.set("idProposta",proposta.getIdProposta());
        
        Integer idAgendamento = null;
        String areaDespacho = new String();
        
        List listAgendamento = super.search("lstAgendamento", dynamicBean);
        
        if( !listAgendamento.isEmpty()){        	
        	final Object[] obj = (Object[]) listAgendamento.get(0);
        	idAgendamento = (Integer)obj[0];
        	areaDespacho = (String)obj[1];        	
        }else{
        	idAgendamento = proposta.getIdAgendamento();
        	areaDespacho = proposta.getIdAreaDespacho();
        }
        
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametrosFinalizaContrato(proposta,
                                                    numContrato, idEndereco, idAssinante, produtosPP,
                                                    produtosAdicPP, produtosPA, produtosAdicPA, idPeriodo,
                                                    plst_solic, plst_prod_de, plst_prod_para,idAgendamento,areaDespacho);

            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_FINALIZA_PROCESSO,
                                                    parameters);
        } catch (Exception ex) {
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(GerarContratoConstants.MSG_ERRO_FINALIZAR_CONTRATO, new Object[0]));
        }
        String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_13);
        BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_14);
        if (!GeralUtil.isNull(codError) && !codError.equals(BigDecimal.ZERO)) {	           
            String[] msg = msgError.split("#");
            msgError = "";
            for (int i = 0; i < msg.length; i++) {
                msgError = msgError + msg[i] + GerarContratoConstants.TAB;
            }           
            tratarErroEnvioContrato(proposta.getIdProposta());            
            lancarErrosValidacao(GerarContratoConstants.MSG_ERRO_ENVIO_CONTRATO, msgError);
        }
    }

    /**
     * @ejb.interface-method view-type="local" Inclui Contrato Preposto Chama
     *                       Procedure: PROC_PGSMS_CONTRATO_INCLUI_PREPOSTO
     * @return String
     */
    public String insertContratoPreposto(final Long numContrato,final CpPropostaBean proposta) {
        List retorno = new ArrayList();
        String msgRetorno = "";
        CpProspectBean prospect = new CpProspectBean();        
        prospect = proposta.getProspect();
        List prepostos = super.search(CpPrepostoProspectBean.LST_PREPOSTOS_BY_PROSPECT, prospect);
        
        if (CollectionUtils.isEmpty(prepostos)){
            return msgRetorno;
        }         

        Iterator itPrepostos = prepostos.iterator();
        while (itPrepostos.hasNext()) {
            Object nextObj = itPrepostos.next();
            CpPrepostoProspectBean preposto = null;
            preposto = (CpPrepostoProspectBean) nextObj;

            try {
                BatchParameter[] parameters = GerarContratoHelper.obterParmetrosInserirPreposto(numContrato,
                                                        proposta, preposto);
                retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_PGSMS_CONTRATO_INCLUI_PREPOSTO,
                                                        parameters);
            } catch (Exception ex) {
                tratarErroEnvioContrato(proposta.getIdProposta());
                if (ex instanceof BaseBusinessException) {
                    throw (BaseBusinessException) ex;
                }
                throw new BaseFailureException(ex);
            }

            String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_5);
            BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_4);

            if (!GeralUtil.isNull(codError) && !codError.equals(BigDecimal.ZERO)) {
                msgRetorno = msgError;
            }
        }
        return msgRetorno;
    }

    /**
     * Envia Cartao Mensalidade Chama Procedure:
     * ISS_ENVIO_CONTRATO.ENVIO_CARTAO_MENSALIDADE
     * 
     * @return void Envia Cartao Mensalidade
     */
    public void sendCartaoMensalidadeNETSMS(final CpPropostaBean proposta, final Long numContrato) {

        CpCartaoCreditoBean cartao = proposta.getProspect().getCartaoCredito();

        List retorno = new ArrayList();
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametrosInserirCartaoCredito(proposta,
                                                    numContrato, cartao);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_ENVIO_CARTAO_MENS,
                                                    parameters);
        } catch (Exception ex) {
            tratarErroEnvioContrato(proposta.getIdProposta());           
        }
        String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_7);
        BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_9);
        trataErroRetornoProcedure(proposta, msgError, codError);

    }

    /**
     * 
     * Inclui Conta Corrente Chama Procedure:
     * ISS_ENVIO_CONTRATO.INCLUI_CONTA_CORRENTE
     * 
     * @return void Inclui Conta Corrente
     */

    private void insertContaCorrenteNETSMS(final CpPropostaBean proposta, final  Long numContrato) {

        List retorno = new ArrayList();
        CpContaCorrenteBean contaCorrente = proposta.getProspect().getContaCorrente();
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametrosInserirContaCorrente(proposta,
                                                    numContrato, contaCorrente);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_INCLUI_CONTA_CORRENTE,
                                                    parameters);
        } catch (Exception ex) {
            tratarErroEnvioContrato(proposta.getIdProposta());           
        }
        String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_8);
        BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_9);
        trataErroRetornoProcedure(proposta, msgError, codError);

    }

    private boolean validateBloqueioAgenda(CpPropostaBean proposta) {
        DynamicBean dynamicBean = new DynamicBean();
        dynamicBean.set(GerarContratoConstants.PROPOSTA, proposta);
        dynamicBean.set(GerarContratoConstants.ID_TIPO_CLIENTE, proposta);
        AgendamentoService agendaService = getService(AgendamentoService.class);
        return  agendaService.consultarBloqueio(dynamicBean);
    }

    /**
     * Insere solicitações de Extensão NETFone
     */
    private void insereSolicitacaoExtensaoNETFone(CpPropostaBean proposta, Long numContrato, CpPontoBean ponto) {
        try {
            DynamicBean bean = new DynamicBean();
            bean.put(ProspectConstants.ID_PONTO, ponto.getIdPonto());
            bean.put(ProspectConstants.ID_PROPOSTA, proposta.getIdProposta());
            List resultExtensoes = super.search(GerarContratoConstants.QUERY_LST_EXTENSOES_NETFONE_PROPOSTA_PONTO, bean);

            if (!CollectionUtils.isEmpty(resultExtensoes)) {               
                List lista = super.search(GerarContratoConstants.QUERY_LST_TIPO_SOLIC_PROD_EXTENSAO_VOIP, new DynamicBean());
                Long idTipoSolicProd = (Long) lista.get(0);              

                BatchParameter[] paramSetPonto = new BatchParameter[1];
                Iterator it = resultExtensoes.iterator();
                while (it.hasNext()) {
                    Object[] obj = (Object[]) it.next();
                    int qtde = ((Integer) obj[4]).intValue();

                    for (int x = 0; x < qtde; x++) {
                        BatchParameter[] parameters = GerarContratoHelper.obterParametrosExtensaoNETFone(proposta,
                                                                numContrato, idTipoSolicProd, obj);

                        /* Processa a procedure de associacao do ponto */
                        paramSetPonto[0] = new BatchParameter(String.valueOf(ponto.getIdPonto().longValue()),
                                                                Types.VARCHAR);
                        getCurrentDAO().executeBatch(ProspectConstants.PROC_SETAR_PONTO, paramSetPonto);

                        /* Processa a procedure de criacao da solicitacao */
                        List list = getCurrentDAO().executeBatch(
                                                                ProspectConstants.PROC_PSN_SOLICITACAO_ASS_GERAL_INSERE_SOLICITACAO,
                                                                parameters);

                        // Inserindo Extensões
                        this.insereExtensaoNETFone(new Long(ponto.getIdPonto().longValue()));
                    }
                }
            }
        } catch (Exception e) {            
            lancarErrosValidacao(getValidationMessage(GerarContratoConstants.MSG_ERRO_EXTENSAO_NETFONE, new Object[0]));
        }
    }

    /**
     * Insere extensões NETFone da Proposta
     */
    private void insereExtensaoNETFone(Long idPontoContrato) {
        try {          
            BatchParameter[] parameters = GerarContratoHelper.obterParametrosInserirExtensaoVoio(idPontoContrato);           
            List list = getCurrentDAO().executeBatch(ProspectConstants.PROC_PSN_MAN_EXTEN_VOIP_PR_INS_EXTEN_VOIP,
                                                    parameters);

            if (!GeralUtil.isNull(list.get(2)) && ((BigDecimal) list.get(2)).equals(BigDecimal.ZERO)) {                
                lancarErrosValidacao(getValidationMessage(list.get(3) != null ? (String) list.get(3)
                                                        : GerarContratoConstants.MSG_ERRO_INSERIR_EXTENSAO_NETFONE, new Object[0]));
            }
        } catch (Exception e) {
            lancarErrosValidacao(getValidationMessage(GerarContratoConstants.MSG_ERRO_INSERIR_EXTENSAO_NETFONE, new Object[0]));    
        }
    }

    /**
     * 
     * Confirma reserva telefonica Chama Procedure:
     * PSN_MANTELEFONE_VOIP.PR_CONFIRMARESERVATELVOIPAVAL
     * 
     * @return void
     */
    private void confirmaReservaTel(CpPropostaBean proposta, Long idPonto, Long numContrato, CpPontoBean ponto) {

        List retorno = new ArrayList();
        Iterator itTel = null;
        List reservaTel = (List) ponto.getReservasVoip();
        itTel = reservaTel.iterator();

        while (itTel.hasNext()) {
            Object nextTel = itTel.next();
            CpReservaTelefoneVoipBean tel = null;
            tel = (CpReservaTelefoneVoipBean) nextTel;

            try {
                BatchParameter[] parameters = GerarContratoHelper.obterParametrosReservaTelefoneVoip(proposta,
                                                        idPonto, numContrato, tel);
                retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_PSN_MATELEFONE_PR_CONFRESERVATELVOIPAVALJAVA,
                                                        parameters);
            } catch (Exception ex) {
                tratarErroEnvioContrato(proposta.getIdProposta());                
            }
            String msgError = (String) retorno.get(16);
            BigDecimal codError = (BigDecimal) retorno.get(15);
            if (!GeralUtil.isNull(codError) && !codError.equals(BigDecimal.ONE)) {               
                tratarErroEnvioContrato(proposta.getIdProposta());                
                lancarErrosValidacao(GerarContratoConstants.MSG_ERRO_ENVIO_CONTRATO, msgError);
            }
        }
    }

    /**
     * 
     * Inclui Produtos no Ponto Chama Procedure:
     * ISS_ENVIO_CONTRATO.INCLUI_PONTO_PRODUTO
     * 
     * @return void Inclui Produtos Agregados no Ponto- Canais a la Carte no
     *         Ponto
     */

    private void insertPontoProdutoAgregadoNETSMS(CpPropostaBean proposta, CpProdutosAgregadosBean prodAgregado,
                                            Long idPonto, Long numContrato, Long idAssinante, Long idEndereco,
                                            CpPontoBean ponto) {
        Integer adesao = Integer.valueOf(GerarContratoConstants.CONSTANT_3);
        List retorno = new ArrayList();
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametroIncluiPontoProduto(proposta,
                                                    prodAgregado, idPonto, numContrato, idAssinante, idEndereco,
                                                    adesao);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_INCLUI_PONTO_PRODUTO,
                                                    parameters);
        } catch (Exception ex) {            
            tratarErroEnvioContrato(proposta.getIdProposta());            
            lancarErrosValidacao(getValidationMessage(
                GerarContratoConstants.MSG_ERRO_INSERIR_PONTO_PRODUTO_AGREGADO, new Object[0]));
        }
        String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_17);
        BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_18);
        trataErroRetornoProcedure(proposta, msgError, codError);
    }

    /**
     * 
     * Inclui Produtos no Ponto Chama Procedure:
     * ISS_ENVIO_CONTRATO.INCLUI_PONTO_PRODUTO
     * 
     * @return void Inclui Produtos no Ponto
     */

    private void inserirPontoProdutoNETSMS(final CpPropostaBean proposta, 
                                            final CpPontoBean ponto, 
                                            final Long idPonto,
                                            final Long numContrato, 
                                            final Long idAssinante, 
                                            final Long idEndereco , 
                                            final CpEnderecoProspectBean endInstalacao) {

        Integer adesao = null;
        List retorno = new ArrayList();

        if (GerarContratoHelper.validaInserirPonto(ponto)) {
            if (ponto.getTipoPonto().getIdTipoPonto().equals(ProspectConstants.ID_PONTO_PRINCIPAL)) {
                adesao = new Integer(1);
            }
            if (ponto.getTipoPonto().getIdTipoPonto().equals(ProspectConstants.ID_PONTO_ADICIONAL)) {
                adesao = Integer.valueOf(2);
            }
        } else {
            adesao = Integer.valueOf(3);
        }
        try {
            String obsOs = GeralUtil.getString(proposta.getObsos());
            Long tipoTecnologia = this.retrieveTipoTecnologia(ponto.getProduto().getIdProduto());
            if (!GeralUtil.isNull(tipoTecnologia) && (tipoTecnologia.equals(ProspectConstants.TIPO_CARACTERISTICA_HDTV) 
                || tipoTecnologia.equals(ProspectConstants.TIPO_CARACTERISTICA_HDTV_DVR))) {
                Boolean isVoip = this.retrieveEnderecoIsVoipByProposta(proposta, endInstalacao);
                if (isVoip) {
                    obsOs += GerarContratoConstants.COMPRA_CONTROLE_REMOTO_DISPPONIVEL;
                } else {
                    obsOs += GerarContratoConstants.COMPRA_CONTROLE_REMOTO_INDISPPONIVEL;
                }
            }

            BatchParameter[] parameters = GerarContratoHelper.obterParametrosIssEnvioIncluirPonto(proposta, ponto,
                                                    idPonto, numContrato, idAssinante, idEndereco, adesao, obsOs);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_INCLUI_PONTO_PRODUTO,
                                                    parameters);
        } catch (Exception ex) {            
            tratarErroEnvioContrato(proposta.getIdProposta());           
        }
        final String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_17);
        final BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_18);
        trataErroRetornoProcedure(proposta, msgError, codError);
    }
    /**
     * 
     * @param proposta
     * @param endInstalacao
     * @return
     */
    private Boolean retrieveEnderecoIsVoipByProposta(final CpPropostaBean proposta , 
                                            final CpEnderecoProspectBean endInstalacao) {

        String idCidade = proposta.getCidadeOperadora().getIdCidade();        
        Integer idEdificacao = endInstalacao.getIdEdificacao();
        Integer servico = GeralConstants.TECNOLOGIA_VOIP;
        return retrieveEnderecoIsVoip(idCidade, idEdificacao, servico);
    }

    private Boolean retrieveEnderecoIsVoip(final String idCidade, 
                                           final Integer idEdificacao,
                                           final Integer servico) {

        final BatchParameter[] parameters = GerarContratoHelper.
        obterParametrosValidaEnderecoSiebel(idCidade, idEdificacao, servico);
        List result = getCurrentDAO().executeBatch(ProspectConstants.PROC_ENDER_VALIDA_ENDERECO_SIEBEL, parameters);
        long statusRetorno = ((BigDecimal) result.get(GerarContratoConstants.CONSTANT_5)).longValue();
        long statusTecnico = ((BigDecimal) result.get(GerarContratoConstants.CONSTANT_4)).longValue();
        long statusComercial = ((BigDecimal) result.get(GerarContratoConstants.CONSTANT_3)).longValue();
        if (statusRetorno == 0) {
            if ((statusTecnico == 0 || statusTecnico == 5) && statusComercial == 0) {             
                return true;
            }
        }
        return false;
    }

    

    /**
     * 
     * @param idProduto
     * @return
     */
    private Long retrieveTipoTecnologia(final Long idProduto) {

        List result = null;
        Long retorno = null;
        BatchParameter[] parameters = GerarContratoHelper.obterParametrosCaracteristicaProduto(idProduto);
        result = getCurrentDAO().executeBatch(ProspectConstants.PROC_BUSCA_CARACTERISTICA_PRODUTO, parameters);
        if (!CollectionUtils.isEmpty(result) && !GeralUtil.isNull(result.get(1))) {
            retorno =  ((BigDecimal) result.get(1)).longValue();
        }         
        return retorno;
    }

   

    /**
     * 
     * Insere retorno telefonico INSERE_RETORNO_PONTO
     * 
     * @return void Insere Retorno Telefonico
     */
    private void insertRetornoTelefonicoNETSMS(final CpPropostaBean proposta, 
                                               final CpPontoBean ponto,
                                               final Long idPonto) {

        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametroRetornoPonto(proposta, ponto, idPonto);
            getCurrentDAO().executeBatch(ProspectConstants.PROC_INSERE_RETORNO_PONTO, parameters);
        } catch (Exception ex) {
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(
            GerarContratoConstants.MSG_ERRO_INSERIR_RETORNO_TELEFONICO, new Object[0]));
        }
    }

    /**
     * 
     * Inclui Ponto Chama Procedure: ISS_ENVIO_CONTRATO.INCLUI_PONTO
     * 
     * @return void Inclui Ponto
     */

    private Long insertPontoNETSMS(final CpPropostaBean proposta, 
                                   final Long numContrato, 
                                   final CpPontoBean ponto, 
                                   final Long idEndereco) {
        Long idPonto = null;
        List retorno = new ArrayList();
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametrosEnvioIssInserirPonto(proposta,
                                                    numContrato, ponto, idEndereco);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_INCLUI_PONTO,
                                                    parameters);
        } catch (Exception ex) {
            tratarErroEnvioContrato(proposta.getIdProposta());            
        }
        String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_6);
        BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_7);
        if (!GeralUtil.isNull(codError) && !codError.equals(BigDecimal.ZERO)) {           
            tratarErroEnvioContrato(proposta.getIdProposta());        
            lancarErrosValidacao(GerarContratoConstants.MSG_ERRO_ENVIO_CONTRATO, msgError);
        } else {
            idPonto = GeralUtil.toLong((BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_5));
        }

        return idPonto;
    }

    /**
     * 
     * @param proposta
     */
    public void insertSegmentoNetSms(final CpPropostaBean proposta) {
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametrosSegmento(proposta);
            getCurrentDAO().executeBatch(ProspectConstants.PROC_PSN_VANGUARDA_SSN_INSERE_SN_REL_ASS_SEGM,
                                                    parameters);
        } catch (Exception ex) {
            lancarErrosValidacao(getValidationMessage(
           GerarContratoConstants.MSG_ERRO_INSERIR_SEGMENTO_NETSMS, new Object[0]));       
        }
    }
    
      
    

    /**
     * 
     * Inclui os Agregados Informativos. Chama Procedure:
     * ISS_ENVIO_CONTRATO.INCLUI_PRODUTO_AGREGADO
     * 
     * @return void Inclui Contrato
     */
    private void inserirProdutoAgregadoEnvioContrato(final CpPropostaBean proposta, final Long numContrato) {
        DynamicBean bean = new DynamicBean();
        bean.put(ProspectConstants.ID_PROPOSTA, proposta.getIdProposta());
        List result = super.search(ProspectConstants.PRODUTO_AGREGADO_ADICIONADOS, bean);
        if (!CollectionUtils.isEmpty(result)) {
            for (Iterator iterator = result.iterator(); iterator.hasNext();) {
                Object[] agregado = (Object[]) iterator.next();
                BatchParameter[] parameters = GerarContratoHelper.obterParametrosEnvioIssProdAgregados(proposta,
                                                        numContrato, agregado);
                getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_INCLUI_PRODUTO_AGREGADO, parameters);
            }
        }
    }

    /**
     * 
     * Inclui Produtos Agregados Chama Procedure:
     * ISS_ENVIO_CONTRATO.INCLUI_PRODUTO_AGREGADO
     * 
     * @return void Inclui Produtos Agregados
     */

    private void insertProdutoAgregado(final CpPropostaBean proposta, final CpProdutosAgregadosBean produtoAgregado,
                                            final Long numContrato) {
        List retorno = new ArrayList();
        List username = super.search(ProspectConstants.LST_USERNAME_BY_PROPOSTA_IDPESSOA, proposta);

        try {
            final BatchParameter[] parameters = GerarContratoHelper.
            obterParametrosIncluirProdutoAgregado(proposta, produtoAgregado,
                                                    numContrato, username);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_INCLUI_PRODUTO_AGREGADO,
                                                    parameters);
        } catch (Exception ex) {
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(
            GerarContratoConstants.MSG_ERRO_INSERIR_PONTO_PRODUTO_AGREGADO, new Object[0]));   
        }
        String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_6);
        BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_7);
        trataErroRetornoProcedure(proposta, msgError, codError);
    }

    /**
     * 
     * Inclui Contrato Chama Procedure: ISS_ENVIO_CONTRATO.INCLUI_CONTRATO
     * 
     * @return void Inclui Contrato
     * @throws Exception
     */
    private Long inserirContratoNETSMS(final CpPropostaBean proposta, final Long idAssinante) {

        List retorno = new ArrayList();
        Long numContrato = null;
        final CpCobrancaBean cobranca = obterCobrancaProposta(proposta);

        final Date dtfatura = obterPrimeiroVencimento(proposta);
        verificaFaturaBilling(proposta);
        Integer vencidoVincendo = verificaVincendo(proposta);
        int numeroPontos = proposta.getPontosAdicionais().size();
        try {
            BatchParameter[] parameters = GerarContratoHelper
                                                    .obterParametrosEnvioIssContrato(proposta, idAssinante,
                                                                                            cobranca, dtfatura,
                                                                                            vencidoVincendo,
                                                                                            numeroPontos);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_INCLUI_CONTRATO,
                                                    parameters);
        } catch (Exception ex) {
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(GerarContratoConstants.
            MSG_ERRO_INSERIR_CONTRATO_NETSMS, new Object[0]));   
        }

        numContrato = GeralUtil.toLong((BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_21));
        String msgError = String.valueOf(retorno.get(GerarContratoConstants.CONSTANT_21));
        final BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_23);      
        if (!GeralUtil.isNull(codError) && codError.intValue() == GerarContratoConstants.CONSTANT_3.intValue()) {            
            List irregularidades = obterIrregularidadesContrato(numContrato, proposta);
            List<DynamicBean> erros = new ArrayList<DynamicBean>();
            if(!CollectionUtils.isEmpty(irregularidades)) {
                erros = (List<DynamicBean>) irregularidades.get(0);
            }
            for (Iterator iter = irregularidades.iterator(); iter.hasNext();) {
                DynamicBean erro = (DynamicBean) iter.next();
                if(erro != null ){
                	msgError = msgError + erro.get(GerarContratoConstants.DESCRICAO) + GerarContratoConstants.TAB;
            	}                     
            }       
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(GerarContratoConstants.MSG_ERRO_ENVIO_CONTRATO, msgError);   
        }
        trataErroRetornoProcedure(proposta, msgError, codError);
        return numContrato;
    }

    /**
     * Recupera a lista de irregularidades referentes a proposta a ser enviada.
     * 
     * @param numContrato
     * @param proposta
     * @return
     */
    public List obterIrregularidadesContrato(final Long numContrato, final CpPropostaBean proposta) {
        List dados = null;
        try {
            BatchParameter[] parameters = {new BatchParameter(numContrato, Types.NUMERIC), 
                                 new BatchParameter(proposta.getCidadeOperadora().getIdCidade(),Types.VARCHAR),
                                 new BatchParameter(BatchParameter.ORACLE_CURSOR, Boolean.TRUE), };
            dados = getCurrentDAO().executeBatch(ProspectConstants.
                                                    PROC_ISS_ENVIO_CONTRATO_PRSN_BUSCA_SIT_IRREG_CONTRATO,
                                                    parameters);
        } catch (Exception ex) {
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(
                                                    GerarContratoConstants.MSG_ERRO_OBTER_IRREGULARIDADES_CONTRATO,
                                                    new Object[0]));
        }
        return dados;
    }
    

    /**
     * Retorna o tipo de assinante (Vincendo = 1 / Vencido = 0) SN_PARAMETRO
     * Correção na NSLP_1225389_NI_002
     */
    private Integer verificaVincendo(final CpPropostaBean proposta) {

        final DynamicBean params = new DynamicBean();
        params.put(GerarContratoConstants.CID_CONTRATO, proposta.getCidadeOperadora().getIdCidade());
        params.put(GerarContratoConstants.NOME_PARAMETRO,GerarContratoConstants.VINCENDA);
        List list = search(ProspectConstants.FIND_SN_VLR_PARAMETRO, params, Boolean.FALSE);
        BigDecimal flag = new BigDecimal(0);
        if (!CollectionUtils.isEmpty(list)) {
            flag = (BigDecimal) list.get(0);
        }
        return flag.intValue();
    }

    /**
     * 
     * @param proposta
     * @return
     */
    public String verificaFaturaBilling(CpPropostaBean proposta) {

        DynamicBean params = new DynamicBean();
        params.set(GerarContratoConstants.CID_CONTRATO, proposta.getCidadeOperadora().getIdCidade());
        params.set(GerarContratoConstants.NOME_PARAMETRO, GerarContratoConstants.DATA_CORTE_BILLING);
        List list = search(ProspectConstants.LST_SN_VLR_PARAMETRO, params, Boolean.FALSE);
        String flag = GerarContratoConstants.DATA_FIM;

        if (!CollectionUtils.isEmpty(list)) {
            flag = (String) list.get(0);
        }
        if (flag.equals(GerarContratoConstants.DATA_FIM)) {
            return ProspectConstants.BILLING_VIRTUA;
        }
        return ProspectConstants.BILLING_NETSMS;
    }

    /**
     * @param proposta
     * @throws Exception
     */
    private Date obterPrimeiroVencimento(CpPropostaBean proposta) {
        List datasRateio = super.search(ProspectConstants.DT_FATURA_RATEIO, proposta);
        return GerarContratoHelper.obterPrimeiroVencimento(proposta, datasRateio);
    }

    /**
     * @param proposta
     */
    private void verificaPendenciasProposta(CpPropostaBean proposta) {
        // Verifica se existem pendências que não foram fechadas.
        List pendenciasDB = super.search(ProspectConstants.LST_REL_PENDENCIA_PROPOSTA_EM_ABERTO, proposta,
                                                Boolean.FALSE);
        if (!pendenciasDB.isEmpty()) {    
            StringBuilder msgErro = new StringBuilder(GerarContratoConstants.
                                                    DESCRICAO_ERRO_PENDECIAS+GerarContratoConstants.TAB);
            
            for (Iterator iter = pendenciasDB.iterator(); iter.hasNext();) {
                Object[] item = (Object[]) iter.next();
                String msg = item[0]+" "+item[1]+" "+item[GerarContratoConstants.CONSTANT_2]+GerarContratoConstants.TAB;
                msgErro.append(msg);
            }
            
            
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(GerarContratoConstants.MSG_ERRO_PENDENCIAS_CONTRATO, msgErro.toString());
        }
    }

    /**
     * 
     * Inclui Assinante Chama Procedure: ISS_ENVIO_CONTRATO.INCLUI_ASSINANTE
     * 
     * @return idAssinante Inclui Assinante
     */
    private Long inserirAssinanteNETSMS(final Long idEnder, final CpPropostaBean proposta) {
        List retorno = new ArrayList();
        Long idAssinante = null;
        CpProspectBean prospect = proposta.getProspect();      
        String telResidencial = prospect.getDddTelRes() + prospect.getTelRes();      
        String telComercial = null;
        if (!GeralUtil.isNull(prospect.getDddTelCom()))
            telComercial = prospect.getDddTelCom();
        if (!GeralUtil.isNull(prospect.getTelCom())){
            telComercial += prospect.getTelCom();
        }      
        String telFax = null;
        if (!GeralUtil.isNull(prospect.getDddTelFax())) {
            telFax = prospect.getDddTelFax();
        }
        if (!GeralUtil.isNull(prospect.getTelFax())) {
            telFax += prospect.getTelFax();
        }
        String telOutros = null;
        if (!GeralUtil.isNull(prospect.getTelOutros())) {
            telOutros = prospect.getTelOutros();
        }
        String cpf = null;
        String cnpj = null;

        if (!GeralUtil.isNull(prospect.getIdTipoPessoa()) && prospect.getIdTipoPessoa().
            equals(Integer.valueOf(SnTipoPessoaBean.TP_FISICA))) {           
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            numberFormat.setMinimumIntegerDigits(GerarContratoConstants.CONSTANT_11);
            cpf = numberFormat.format(prospect.getCpf());
            cpf = cpf.replace(".", "");
            cpf = GeralUtil.preencheZero(cpf, GerarContratoConstants.CONSTANT_11);
        } else {
            cnpj = prospect.getCnpj().toString();
            cnpj = GeralUtil.preencheZero(cnpj, GerarContratoConstants.CONSTANT_14);
        }
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametrosEnvioIssAssinante(idEnder, prospect,
                                                    telResidencial, telComercial, telFax, telOutros, cpf, cnpj);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_INCLUI_ASSINANTE,
                                                    parameters);
        } catch (Exception ex) {           
            tratarErroEnvioContrato(proposta.getIdProposta());            
            lancarErrosValidacao(getValidationMessage(GerarContratoConstants.
            MSG_ERRO_INSERIR_ASSINANTE_NETSMS, new Object[0]));   
        }
        final String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_23);
        final BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_24);
        if (!GeralUtil.isNull(codError) && !codError.equals(BigDecimal.ZERO)) {           
            tratarErroEnvioContrato(proposta.getIdProposta());            
            lancarErrosValidacao(GerarContratoConstants.MSG_ERRO_ENVIO_CONTRATO, msgError);
        } else {
            idAssinante = GeralUtil.toLong(((BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_22)));
        }
        return idAssinante;
    }

    /**
     * 
     * Associa endereco Chama Procedure: ISS_ENVIO_CONTRATO.ASSOCIA_ENDERECO
     * 
     * @return void Associa endereco
     */
    private Long associarEnderecoNETSMS(final CpPropostaBean proposta, final CpEnderecoProspectBean endInstalacao) {
        final Integer idEdificacao = endInstalacao.getIdEdificacao();      
        List retorno = new ArrayList(GerarContratoConstants.CONSTANT_3);
        Long idEndereco = null;
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametroIssEnvioEndereco(idEdificacao);
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_ASSOCIA_ENDERECO,
                                                    parameters);
        } catch (Exception ex) {           
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(GerarContratoConstants.MSG_ERRO_ASSOCIAR_ENDERECO_NETSMS, new Object[0]));
        }
        String msgError = (String) retorno.get(2);
        BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_3);
        if (!GeralUtil.isNull(codError) && !codError.equals(BigDecimal.ZERO)) {           
            String[] msg = msgError.split("#");
            msgError = "";
            for (int i = 0; i < msg.length; i++) {
                msgError = msgError + msg[i] + GerarContratoConstants.TAB;
            }          
            tratarErroEnvioContrato(proposta.getIdProposta());            
            lancarErrosValidacao(GerarContratoConstants.MSG_ERRO_ENVIO_CONTRATO, msgError);
        } else {
            idEndereco = GeralUtil.toLong((BigDecimal) retorno.get(1));
        }
        return idEndereco;
    }

    /**
     * 
     * @param idCidade
     * @param idEdificacao
     * @param servico
     * @param end
     * @param proposta
     */
    private void validateStatusEndereco(final CpPropostaBean proposta, 
                                            final CpEnderecoProspectBean endInstalacao,
                                            final Integer servico) {

        List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();        
        try {
            EnderecoService enderecoService = getService(EnderecoService.class);
            final DynamicBean dynaStatusPayTv = enderecoService.processaStatusPayTVEndereco(proposta.getIdProposta(), 
                                                    endInstalacao.getIdEnderecoProspect()); 
            
            String statusComPayTv = (String) dynaStatusPayTv.get(GeralConstants.PROC_STATUS_COMERCIAL);
            String statusTecPayTv = (String) dynaStatusPayTv.get(GeralConstants.PROC_STATUS_TECNICO);
                 
            PendenciaService pendencia = getService(PendenciaService.class);
            pendencia.inserirPendenciaEnderecoProposta(proposta.getIdProposta(), statusComPayTv, statusTecPayTv);
            
            List verify = super.search(ProspectConstants.
            LST_EXISTS_CP_REL_PENDENCIA_PROPOSTA_ENDERECO_ANALISE_BY_PROPOSTA,
                                                    proposta);
            if (!CollectionUtils.isEmpty(verify)) {
                errorList.add(getValidationMessage(PropostaConstants.MSG_PENDENCIA_PROPOSTA_FINALIZACAO, new Object[0]));
                tratarErroEnvioContrato(proposta.getIdProposta());
            }
        } catch (Exception e) {           
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(
            GerarContratoConstants.MSG_ERRO_VALIDAR_STATUS_ENDERECO_NETSMS, new Object[0]));
        }
    }

    /**
     * 
     * Inclui Endereco Externo Chama Procedure:
     * ISS_ENVIO_CONTRATO.INCLUI_ENDER_EXT
     * 
     * @return void Inclui Endereco externo
     */
    private void inserirEnderecoCobrancaNETSMS(CpEnderecoProspectBean enderecoCobranca, CpPropostaBean proposta,
                                            Long idAssinante) {
        List retorno = new ArrayList();
        try {
            BatchParameter[] parameters = GerarContratoHelper.obterParametrosIssIncluirEnderecoExterno(
                                                    enderecoCobranca, idAssinante, getUserSession());
            retorno = getCurrentDAO().executeBatch(ProspectConstants.PROC_ISS_ENVIO_CONTRATO_INCLUI_ENDER_EXT,
                                                    parameters);
        } catch (Exception ex) {          
            tratarErroEnvioContrato(proposta.getIdProposta());
            lancarErrosValidacao(getValidationMessage(ProspectConstants.GERAR_CONTRATO_ENDERECO_COBRANCA, new Object[0]));
        }
        final String msgError = (String) retorno.get(GerarContratoConstants.CONSTANT_14);
        final BigDecimal codError = (BigDecimal) retorno.get(GerarContratoConstants.CONSTANT_15);
        trataErroRetornoProcedure(proposta, msgError, codError);
    }

    /**
     * Método responsável por criar proposta
     *  
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="RequiresNew"
     * @ejb.permission role-name="CRM_GERAR_CONTRATO"
     */
    public void tratarErroEnvioContrato(final Long idProposta) {              
        
        CpPropostaBean proposta = obterProposta(idProposta);
        
        
        final DynamicBean dynamicBean = new DynamicBean();
        dynamicBean.set("cidContrato", proposta.getCidadeOperadora().getIdCidade());
        dynamicBean.set("idProposta",proposta.getIdProposta());        
        Integer idAgendamento = null;                
        
        List listAgendamento = super.search("lstAgendamento", dynamicBean);
        
        if( !listAgendamento.isEmpty()){        	
        	final Object[] obj = (Object[]) listAgendamento.get(0);
        	idAgendamento = (Integer)obj[0];        	        	
        }else{
        	idAgendamento = proposta.getIdAgendamento();        	
        }
        
        if (!GeralUtil.isNull(idAgendamento) && !GeralUtil.isNull(proposta.getIdProposta())) {            

            CpPropostaBean newProposta = new CpPropostaBean(idProposta);
            newProposta = (CpPropostaBean) super.findByPrimaryKey(newProposta);           
            
            final CpStatusPropostaBean status = new CpStatusPropostaBean();
            status.setIdStatusProposta( CpStatusPropostaBean.STATUS_PENDENTE);
            newProposta.setDtVenda(null);
            newProposta.setNumContrato(null);
            newProposta.setStatusProposta(status); 
            super.update(newProposta, getUserSession().getCurrentDbService());          
            
           AgendamentoService agendaService = getService(AgendamentoService.class);
           agendaService.liberaData(proposta.getIdProposta());
            
        }else{
            PropostaService propostaService = getService(PropostaService.class);
            propostaService.atualizaStatusProposta(proposta.getIdProposta(), CpStatusPropostaBean.STATUS_PENDENTE);
        }
        
    }

   

    /**
     * 
     * @param idProposta
     * @return
     */
    private CpPropostaBean obterProposta(final Long idProposta) {
        CpPropostaBean proposta = new CpPropostaBean();
        proposta.setIdProposta(idProposta);
        proposta = (CpPropostaBean) super.findByPrimaryKey(proposta);
        return proposta;
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param prospect
     * @return
     * 
     * 
     */
    private CpEnderecoProspectBean obterEnderecoCobranca(final Long idProspect) {
        CpProspectBean prospect = new CpProspectBean();
        prospect.setIdProspect(idProspect);
        prospect = (CpProspectBean) super.findByPrimaryKey(prospect);
        CpEnderecoProspectBean enderecoCobranca = null;
        if (!CollectionUtils.isEmpty(prospect.getEnderecos())) {
            for (Iterator iter = prospect.getEnderecos().iterator(); iter.hasNext();) {
                CpEnderecoProspectBean enderecoProspectBean = (CpEnderecoProspectBean) iter.next();
                if (GeralConstants.ID_TIPO_ENDERECO_COBRANCA.equals(enderecoProspectBean.getTipoEndereco()
                                                        .getIdTipoEndereco())) {
                    enderecoCobranca = enderecoProspectBean;
                    break;
                }
            }
        }
        return enderecoCobranca;
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param prospect
     * @return
     * 
     * 
     */
    private CpEnderecoProspectBean obterEnderecoInstalacao(final Long idProspect) {
        CpProspectBean prospect = new CpProspectBean();
        prospect.setIdProspect(idProspect);
        prospect = (CpProspectBean) super.findByPrimaryKey(prospect);
        CpEnderecoProspectBean enderecoInstalacao = null;
        if (!CollectionUtils.isEmpty(prospect.getEnderecos())) {
            for (Iterator iter = prospect.getEnderecos().iterator(); iter.hasNext();) {
                CpEnderecoProspectBean enderecoProspectBean = (CpEnderecoProspectBean) iter.next();
                if (GeralConstants.ID_TIPO_ENDERECO_INSTALACAO.equals(enderecoProspectBean.getTipoEndereco()
                                                        .getIdTipoEndereco())) {

                    enderecoInstalacao = enderecoProspectBean;
                    break;
                }
            }
        }
        return enderecoInstalacao;
    }
}
