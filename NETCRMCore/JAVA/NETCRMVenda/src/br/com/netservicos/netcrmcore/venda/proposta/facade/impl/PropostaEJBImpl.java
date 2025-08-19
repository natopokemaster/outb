package br.com.netservicos.netcrmcore.venda.proposta.facade.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.axis.utils.StringUtils;
import org.springframework.util.CollectionUtils;

import br.com.netservicos.core.bean.cp.CpChamadoBean;
import br.com.netservicos.core.bean.cp.CpCidadeOperadoraBean;
import br.com.netservicos.core.bean.cp.CpCobrancaBean;
import br.com.netservicos.core.bean.cp.CpContaCorrenteBean;
import br.com.netservicos.core.bean.cp.CpEnderecoProspectBean;
import br.com.netservicos.core.bean.cp.CpPontoBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpProspectBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean;
import br.com.netservicos.core.bean.cp.CpStatusPropostaBean;
import br.com.netservicos.core.bean.sn.SnCampanhaBean;
import br.com.netservicos.core.bean.sn.SnFormaEnvioFaturaBean;
import br.com.netservicos.core.bean.sn.SnParametroBean;
import br.com.netservicos.core.bean.sn.SnRelTipoSolicTipoOsBean;
import br.com.netservicos.core.bean.sn.SnTipoAssinanteBean;
import br.com.netservicos.core.bean.sn.SnTipoCobrancaBean;
import br.com.netservicos.core.bean.sn.SnTipoContratoBean;
import br.com.netservicos.core.bean.sn.SnTipoSegmentoBean;
import br.com.netservicos.core.bean.sn.SnTipoVendaBean;
import br.com.netservicos.core.bean.sn.SnUsrBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.venda.agendamento.facade.AgendamentoService;
import br.com.netservicos.netcrmcore.venda.constants.PropostaConstants;
import br.com.netservicos.netcrmcore.venda.core.facade.impl.AbstractNETCRMVendaEJBImpl;
import br.com.netservicos.netcrmcore.venda.proposta.facade.PropostaService;
import br.com.netservicos.netcrmcore.venda.proposta.facade.ValidacaoPropostaService;
import br.com.netservicos.netcrmcore.venda.proposta.pendencia.facade.PendenciaService;
import br.com.netservicos.netcrmcore.venda.util.VendaUtil;

/**
 * EJB responsável pela validação / alteração dos dados cadastrais do cliente.
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean name="PropostaEJB" type="Stateless" display-name="PropostaEJB"
 *           description="PropostaEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/venda/ejb/PropostaEJB"
 *           local-jndi-name="netcrmcore/venda/ejb/local/PropostaEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class PropostaEJBImpl extends AbstractNETCRMVendaEJBImpl implements
		PropostaService {

	private static final long serialVersionUID = 1713492184667436066L;
	
	private static final String ID_PROPOSTA = "idProposta";
	private static final String ID_PROSPECT = "idProspect";
	private static final String ID_TIPO_VENA = "idTipoVenda";
	private static final String ID_CAMPANHA = "idCampanha";
	private static final String ID_TIPO_CONTRATO = "idTipoContrato";
	private static final String ID_TIPO_ASSINANTE = "idTipoAssinante";
	private static final String ID_TIPO_SEGMENTO = "idTipoSegmento";
	
	
	private static final String ID_TIPO_COBRANCA = "idTipoCobranca";
	private static final String IS_CHECKED_FATURA_EMAIL = "isCheckedFaturaEmail";
	
	private static final String TITULAR = "titular";
	private static final String ID_BANCO = "idBanco";
	private static final String AGENCIA = "agencia";
	private static final String DIGITO_AGENCIA = "digitoAgencia";
	private static final String CONTA = "conta";
	private static final String DIGITO_CONTA = "digitoConta";

	/**
	 * Método responsável por criar proposta
	 *  
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="CRM_MANTER_PROPOSTA"
	 */
	public Bean inserirProposta(Bean dadosProposta) {

		CpPropostaBean proposta = new CpPropostaBean();
		
		Long idProspect = GeralUtil.toLong(dadosProposta.getBeanProperty(ID_PROSPECT));
		Integer idTipoVenda = GeralUtil.toInteger(dadosProposta.getBeanProperty(ID_TIPO_VENA));
		Integer idCampanha = GeralUtil.toInteger(dadosProposta.getBeanProperty(ID_CAMPANHA));
		Integer idTipoContrato = GeralUtil.toInteger(dadosProposta.getBeanProperty(ID_TIPO_CONTRATO));
		Integer idTipoAssinante = GeralUtil.toInteger(dadosProposta.getBeanProperty(ID_TIPO_ASSINANTE));
		Long idTipoSegmento = GeralUtil.toLong(dadosProposta.getBeanProperty(ID_TIPO_SEGMENTO));
		
		CpProspectBean prospect = new CpProspectBean();
		prospect.setIdProspect(idProspect);
		prospect = (CpProspectBean) super.findByPrimaryKey(prospect);
		proposta.setProspect(prospect);
		proposta.setCidadeOperadora(prospect.getCidadeOperadora());
		proposta.setStatusProposta(new CpStatusPropostaBean(
		                                        GeralConstants.STATUS_ABERTA));
		prospect.setEstrangeiro(GeralConstants.BRASILEIRO);
		proposta.setDtVenda(Calendar.getInstance().getTime());
		proposta.setTipoSegmento(obterTipoSegmento(idTipoSegmento));
		SnTipoAssinanteBean tipoAssinante = getTipoAssinante(idTipoAssinante);
		if(!GeralUtil.isNull(tipoAssinante)){
            proposta.setIdTipoAssinante(tipoAssinante.getIdTipoAssinante());
        }		
		SnTipoContratoBean tipoContrato = getTipoContrato(idTipoContrato);
		proposta.setIdTipoContrato(tipoContrato.getIdTipoContrato());	
		proposta.setIdMidia(prospect.getIdMidia());
		SnTipoVendaBean tipoVenda = getTipoVenda(idTipoVenda);
		SnCampanhaBean campanha = getCampanha(idCampanha); 		
		if(!GeralUtil.isNull(campanha)){
		    proposta.setIdCampanha(campanha.getIdCampanha());
		}
		if(!GeralUtil.isNull(tipoVenda)){
		    proposta.setIdTipoVenda(tipoVenda.getIdTipoVenda());
		}
		proposta.setDtAtend(new Date());		
		proposta.setIdAtendente(getUserSession().getUserId());			
		proposta.setIdVendedor(getVendedor());	
		proposta.setDtAtend(Calendar.getInstance().getTime());		
		super.insert(proposta, getUserSession().getCurrentDbService());
		inserirChamado(proposta);
		inserirPendenciaInicialProposta(proposta);
		atualizaStatusProposta(proposta.getIdProposta(),GeralConstants.STATUS_ABERTA);
		dadosProposta.addBeanProperty(ID_PROPOSTA, String.valueOf(proposta.getIdProposta()));
		return dadosProposta;
	}

    /**
     * @param proposta
     */
    private void inserirPendenciaInicialProposta(CpPropostaBean proposta) {
        PendenciaService pendecia = super.getService(PendenciaService.class);
		pendecia.inserirPendenciaProposta(proposta.getIdProposta(), 
		PropostaConstants.VERIFICACAO_CREDITO_INTERNO, PropostaConstants.PROPOSTA_PEND_VERIFC_CRED_INT, null,null);
		pendecia.inserirPendenciaProposta(proposta.getIdProposta(), 
		PropostaConstants.VERIFICACAO_CREDITO_EXTERNO, PropostaConstants.PROPOSTA_PEND_VERIFC_CRED_EXT, null,null);
    }

    /**
     * @param proposta
     */
    private void inserirChamado(CpPropostaBean proposta) {
        CpChamadoBean chamado = new CpChamadoBean();
		chamado.setProspect(proposta.getProspect());
		chamado.setUser(getUserSession().getUserId());
		super.insert(chamado, getUserSession().getCurrentDbService());
    }

    /**
     * @param proposta
     */
    @SuppressWarnings("rawtypes")
    private Long  getVendedor() {
        Long idVendedor = null;
        SnUsrBean user = new SnUsrBean();
        user.setIdUsr(getUserSession().getUserId());
        List usuario = super.search(
        		PropostaConstants.LISTA_USUARIO_BY_ID_AND_ID_FUNCIONARIO, 
        		user);
        if (!CollectionUtils.isEmpty(usuario)) {
            idVendedor = ((Long) usuario.get(0));
        }        
        return idVendedor;
    }
	
	 /**
     * 
     * @param proposta
     * @return
     */
    public SnTipoSegmentoBean obterTipoSegmento(Long idTipoSegmento) {
        SnTipoSegmentoBean item = new SnTipoSegmentoBean(); 
        if(GeralUtil.isNull(idTipoSegmento)){
            item = (SnTipoSegmentoBean) super.search("lstSnTipoSegmentoSemSegmento", new DynamicBean()).get(0);
        }else{
            item.setIdTipoSegmento(idTipoSegmento);
            item = (SnTipoSegmentoBean) super.findByPrimaryKey(item);
        }
        return item;
    }
    
	/**
     * Método responsável validar e finalizar a proposta
     *  
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_MANTER_PROPOSTA"
     */
    public void finalizarProposta(Bean bean){
        List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
        Long idProposta = VendaUtil.toLong(bean.getBeanProperty(PropostaConstants.ID_PROPOSTA));
        PropostaService propostaService = getService(PropostaService.class);
        Boolean statusProposta = propostaService.validateDadosProposta(idProposta);        
        if(!statusProposta){               
            errorList.add(getValidationMessage(PropostaConstants.MSG_DADOS_PROPOSTA_INVALIDA_FINALIZACAO,new Object[0]));
            verificarErrosValidacao(errorList);
        }
        propostaService.atualizaStatusProposta(idProposta,CpStatusPropostaBean.STATUS_PENDENTE);
    }
	
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * @param cidade
     * @param midia
     * @return Integer
     * @since 22/09/2010
     */    
    private SnTipoVendaBean getTipoVenda(Integer idTipoVenda) {
        SnTipoVendaBean tipoVenda = new SnTipoVendaBean();
        tipoVenda.setIdTipoVenda(idTipoVenda);
        tipoVenda = (SnTipoVendaBean) findByPrimaryKey(tipoVenda);
        return tipoVenda;
    }
    
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * @param cidade
     * @param midia
     * @return Integer
     * @since 22/09/2010
     */ 
    private SnCampanhaBean getCampanha(Integer idCampanha) {
        SnCampanhaBean campanha = new SnCampanhaBean();
        campanha.setIdCampanha(idCampanha);
        campanha = (SnCampanhaBean) findByPrimaryKey(campanha);
        return campanha;
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * @param cidade
     * @param midia
     * @return Integer
     * @since 22/09/2010
     */  
    private SnTipoContratoBean getTipoContrato(Integer idTipoContrato) {
        SnTipoContratoBean contrato = new SnTipoContratoBean();
        contrato.setIdTipoContrato(idTipoContrato);
        contrato = (SnTipoContratoBean) findByPrimaryKey(contrato);
        return contrato;
    }
    
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * @param cidade
     * @param midia
     * @return Integer
     * @since 22/09/2010
     */    
    private SnTipoAssinanteBean getTipoAssinante(Integer idTipoAssinante) {
        SnTipoAssinanteBean tipoAssinante = new SnTipoAssinanteBean();
        tipoAssinante.setIdTipoAssinante(idTipoAssinante);
        tipoAssinante = (SnTipoAssinanteBean) findByPrimaryKey(tipoAssinante);
        return tipoAssinante;
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>  
     * @param proposta
     * @return
     * @since 22/09/2010
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="RequiresNew"
     * @ejb.permission role-name="CRM_MANTER_PROPOSTA"
     * 
     */
    @SuppressWarnings("rawtypes")
    public Boolean validateDadosProposta(Long idProposta) {
        
       CpPropostaBean proposta = obterProposta(idProposta);
       
    //   PropostaService propostaService = getService(PropostaService.class);   
    //   propostaService.executarAgendamento(idProposta);
       
       ValidacaoPropostaService validacaoService = getService(ValidacaoPropostaService.class);
       Boolean statusValidacao = validacaoService.validarDadosProposta(idProposta);
       PropostaService propostaService = getService(PropostaService.class);       
       if(statusValidacao) {           
           List pendenciasAbertas = proposta.getPendenciasPropostaEmAberto();
           if (proposta.getPeriodoAgendamento()!= null) { 
               statusValidacao =  Boolean.TRUE;              
               for (int i = 0; i < pendenciasAbertas.size(); i++) {
                   CpRelPendenciaPropostaBean pendencia = (CpRelPendenciaPropostaBean) pendenciasAbertas.get(i);
                   if (GeralConstants.PENDENTE_AGENDAMENTO == pendencia.getPendencia().getIdPendencia().intValue()) {                       
                           pendencia = (CpRelPendenciaPropostaBean) super.findByPrimaryKey(pendencia);
                           delete(pendencia, getUserSession().getCurrentDbService());                   
                   }
               }                              
           }
       }
       
       final CpCobrancaBean cpCobranca = new CpCobrancaBean();
       cpCobranca.setIdProposta(proposta.getProspect().getProposta().getIdProposta());        
       final CpCobrancaBean cobranca = (CpCobrancaBean) this.getCurrentDAO().findByPrimaryKey(cpCobranca);
       
       if (!GeralUtil.isNull(cobranca)) {
           Integer idDiaVencimento = cobranca.getDiaVencimento();
           Integer diaVencimento = null;
           List listaDiasVencimento = super.search(CpCobrancaBean.LST_DIA_VENCIMENTO, proposta); 
           for (Iterator iter = listaDiasVencimento.iterator(); iter.hasNext();) {
               Object[] dados = (Object[]) iter.next();
               if (dados[0].equals(idDiaVencimento)) {
                   diaVencimento = (Integer) dados[1];
                   break;
               }
           }
           
           String vlrParam = this.returnParam(proposta.getCidadeOperadora()); 
           List tipoOS = super.search(SnRelTipoSolicTipoOsBean.LISTA_ID_TIPO_OS_PROSPECT, proposta);
           List validaOS = this.returnSnRelObjTipoOs((Integer) tipoOS.get(0));
           String idCidade = proposta.getCidadeOperadora().getIdCidade();
           DynamicBean dynaBean = new DynamicBean();  
           dynaBean.set("cidContrato", idCidade);
           
           if (vlrParam.equals("1")){
                  if (!GeralUtil.isNull(validaOS.get(0))){
                      Date primeiroDiaVencimento = null;
                      if (!GeralUtil.isNull(proposta.getPeriodoAgendamento())){
                              Date dataAgendamento = proposta.getPeriodoAgendamento().getDt();
                               Integer vincenda = 0;
                               String tipoFaturaBilling = getVerificarFaturaBilling(dynaBean);
                               
                               if (tipoFaturaBilling.equals(PropostaConstants.BILLING_NETSMS)){
                                   vincenda = getVincenda(dynaBean);
                                 } else if (tipoFaturaBilling.equals(PropostaConstants.BILLING_VIRTUA)){
                                   vincenda = getVincendoVencido(dynaBean);
                                 } else {
                                   vincenda = PropostaConstants.VINCENDA_S;
                                 }
                              
                              primeiroDiaVencimento = returnFirstVenc(dataAgendamento, diaVencimento, 
                                             proposta.getCidadeOperadora().getIdCidade(), vincenda);   
                              proposta.setDtFaturaRateio(primeiroDiaVencimento);
                              super.update(proposta,getCurrentDBService());
                             
                      }else {
                          primeiroDiaVencimento = null;
                          proposta.setDtFaturaRateio(primeiroDiaVencimento);
                          super.update(proposta,getCurrentDBService());
                      }
                  }
              }         
        }
       
       return statusValidacao;
       
    }
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>  
     * @param proposta
     * @return
     * @since 22/09/2010
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="RequiresNew"
     * @ejb.permission role-name="CRM_MANTER_PROPOSTA"
     * 
     */
    public void executarAgendamento(Long idProposta) {
        
       CpPropostaBean proposta = obterProposta(idProposta);
       AgendamentoService agendaService = getService(AgendamentoService.class);
       DynamicBean dynamicBean = new DynamicBean();
       dynamicBean.put("proposta", proposta);
       dynamicBean = agendaService.listPeriodosWA(dynamicBean);
       agendaService.liberaData(idProposta);
       agendaService.agendarPropostaWA(dynamicBean);
       dynamicBean.set("idTipoCliente", proposta);       
       agendaService.consultarBloqueio(dynamicBean);
    }
    
  
    
    /**
     * Método responsável validar e finalizar a proposta
     *  
     * 
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_MANTER_PROPOSTA"
     */
    @SuppressWarnings("rawtypes")
    public Boolean validateDadosBasicosProposta(Long idProposta) {   
        
       
        CpPropostaBean proposta = obterProposta(idProposta);     
        CpProspectBean prospect = proposta.getProspect();        
        List pontos = proposta.getPontos();
        if (CollectionUtils.isEmpty(pontos)) {
            return Boolean.FALSE;
        } else {    
            if (pontos.size() > 0){ 
                CpPontoBean ponto = (CpPontoBean) pontos.get(0); 
                if(GeralUtil.isNull(ponto.getProduto()) || GeralUtil.isNull(ponto.getPromocao()) || 
                       GeralUtil.isNull(ponto.getPlanoPgto())  || GeralUtil.isNull(ponto.getLocalizacao())){
                    return Boolean.FALSE;
                }
            }
        }            
        
        final CpCobrancaBean cpCobranca = new CpCobrancaBean();
        cpCobranca.setIdProposta(proposta.getIdProposta());        
        final CpCobrancaBean cobranca = (CpCobrancaBean) this.getCurrentDAO().findByPrimaryKey(cpCobranca);
        CpEnderecoProspectBean enderecoInstalacao = obterEnderecoInstalacao(prospect);
        
        if (!(GeralUtil.isNull(prospect.getNome()) || GeralUtil.isNull(prospect.getDddTelPrincipal()) ||
                GeralUtil.isNull(prospect.getTelPrincipal())  || GeralUtil.isNull(prospect.getCidadeOperadora()) ||
                GeralUtil.isNull(prospect.getIdMidia())  || GeralUtil.isNull(enderecoInstalacao)||
                GeralUtil.isNull(proposta.getPontos()) || GeralUtil.isNull(prospect.getIdTipoPessoa())  ||
                GeralUtil.isNull(proposta.getScpcProposta())|| GeralUtil.isNull(proposta.getIdTipoVenda()) || 
                GeralUtil.isNull(proposta.getIdCampanha()) || 
                GeralUtil.isNull(cobranca)) ) {                
                if (prospect.getIdTipoPessoa().equals(PropostaConstants.CONSTANT_1)){
                    if(GeralUtil.isNull(prospect.getCpf())  || GeralUtil.isNull(prospect.getRg()) ||
                       GeralUtil.isNull(prospect.getIdOrgaoExpedidor()) || GeralUtil.isNull(prospect.getIdProfissao())||
                       GeralUtil.isNull(prospect.getIdEstadoCivil()) || GeralUtil.isNull(prospect.getSexo()) ||
                       GeralUtil.isNull(prospect.getDataNascimento()))
                        return Boolean.FALSE;
                } else {
                    if (GeralUtil.isNull(prospect.getCnpj()))
                        return Boolean.FALSE;
                }
                if (cobranca.getTipoCobranca().equals(Integer.valueOf(PropostaConstants.CONSTANT_2))){
                    if (GeralUtil.isNull(prospect.getContaCorrente()) || 
                        GeralUtil.isNull(prospect.getContaCorrente().getIdBanco()) || 
                        GeralUtil.isNull(prospect.getContaCorrente().getConta())|| 
                        GeralUtil.isNull(prospect.getContaCorrente().getAgencia()))
                        return Boolean.FALSE;
                } else if (cobranca.getTipoCobranca().equals(PropostaConstants.CONSTANT_3)){
                    if (GeralUtil.isNull(prospect.getCartaoCredito()) || 
                        GeralUtil.isNull(prospect.getCartaoCredito().getOperadora()) || 
                        GeralUtil.isNull(prospect.getCartaoCredito().getNumero())|| 
                        GeralUtil.isNull(prospect.getCartaoCredito().getValidade()))
                        return Boolean.FALSE;
                }else if (cobranca.getTipoCobranca().equals(PropostaConstants.CONSTANT_1)){
                        if(GeralUtil.isNull(prospect.getEnderecos())){
                            return Boolean.FALSE;
                        }
                }
        } else {
            return Boolean.FALSE;
        }       
        return Boolean.TRUE;
    }
    
    @SuppressWarnings("rawtypes")
    private Date returnFirstVenc(Date dtAgenda, Integer idPrimeiroVenc, String cidContrato, Integer vincenda) {

        BatchParameter[] parameters = {
                new BatchParameter(Types.DATE, true),
                new BatchParameter(dtAgenda, Types.DATE),
                new BatchParameter(idPrimeiroVenc, Types.NUMERIC),
                new BatchParameter(cidContrato, Types.VARCHAR),
                new BatchParameter(null, Types.VARCHAR),
                new BatchParameter(vincenda, Types.NUMERIC)};

        List firstDiaVencimento = getCurrentDAO().executeBatch(PropostaConstants.
                                                PROPERTY_PRIMEIRO_DIA_VENCIMENTO, parameters);

        return (Date) firstDiaVencimento.get(0);

    }
    
    /**
     * Retorna o tipo de assinante (Vincendo = 1 / Vencido = 0) 
     * futuramente, pois hoje o NetSales cadastra apenas "assinantes" como Vincendo = 1;
     * 
     */
    @SuppressWarnings("rawtypes")
    private Integer getVincendoVencido(DynamicBean bean) {
        List list = super.search("lstVencidoVincendaProspect", bean);
        Integer flag = 1;

        if (!CollectionUtils.isEmpty(list)) {
          flag = (Integer) list.iterator().next();
        }
        if (flag == 0){
          return PropostaConstants.VENCIDO; 
        }
          return PropostaConstants.VINCENDO; 
    }
    
    /**
     * Retorna o tipo de faturamento (Verificar se a cidade na sn_parametro é VINCENDA ou não) 
     *  
     */
    @SuppressWarnings("rawtypes")
    private Integer getVincenda(DynamicBean bean) {
        
        bean.set("cidContrato", bean.get("cidContrato"));
        bean.set("nomeParametro", "VINCENDA");
        List list = super.search(SnParametroBean.FIND_SN_VLR_PARAMETRO, bean);
        BigDecimal flag = new BigDecimal(0);
       
        if (!CollectionUtils.isEmpty(list)) {
          flag = (BigDecimal) list.get(0);
        }
        
                
        if (flag.intValue() == 0){
          return PropostaConstants.VINCENDA_N;
        }   
          return PropostaConstants.VINCENDA_S;
    }
    
    /**
     * Retorna o tipo de faturamento (DATA_CORTE_BILLING_V <> 30/12/2049 
     * faturamento Billing NETSMS e se for = 30/12/2049 Billing Virtua)
     * Implementado na NSLP_1225389_NI_002
     */
    @SuppressWarnings("rawtypes")
    private String getVerificarFaturaBilling(DynamicBean bean) {
        
        bean.set("cidContrato", bean.get("cidContrato"));
        bean.set("nomeParametro", "DATA_CORTE_BILLING_V");
        List list = super.search("lstVlrParametroStr", bean);
        String flag = "30/12/2049";
       
        if (!CollectionUtils.isEmpty(list)) {
          flag = (String) list.get(0);
        }
        if (!flag.equals("30/12/2049")){
          return PropostaConstants.BILLING_NETSMS;
        }   
          return PropostaConstants.BILLING_VIRTUA;
    }

    @SuppressWarnings("rawtypes")
    private List returnSnRelObjTipoOs(Integer objTipoOs){
        BatchParameter[] parameters = {
                new BatchParameter(Types.VARCHAR, true),
                new BatchParameter(objTipoOs, Types.NUMERIC)};
        
        List snRelObjTipoOs = getCurrentDAO().executeBatch(PropostaConstants.LST_SN_REL_OBJ_TIPO_OS, parameters);
        return snRelObjTipoOs;
    }

    /**
     * @param prospect
     * @return
     */
    @SuppressWarnings("rawtypes")
    private CpEnderecoProspectBean obterEnderecoInstalacao(CpProspectBean prospect) {
        CpEnderecoProspectBean enderecoInstalacao = null;
        if (!CollectionUtils.isEmpty(prospect.getEnderecos())) {                
            for (Iterator iter = prospect.getEnderecos().iterator(); iter.hasNext();) {
                CpEnderecoProspectBean enderecoProspectBean = (CpEnderecoProspectBean) iter.next();
                if (PropostaConstants.ID_TIPO_ENDERECO_INSTALACAO.equals(
                     enderecoProspectBean.getTipoEndereco().getIdTipoEndereco())){
                        enderecoInstalacao = enderecoProspectBean;
                        break;
                }
            }
        }
        return enderecoInstalacao;
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
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param idProposta
     * @return
     * @since 22/09/2010
     */
    private CpPropostaBean obterProposta(Long idProposta){
        CpPropostaBean proposta = new CpPropostaBean();
        proposta.setLazyProperties(new String[]{PropostaConstants.PONTOS});
        proposta.setIdProposta(idProposta);
        proposta = (CpPropostaBean) super.findByPrimaryKey(proposta);
        return proposta;  
    }
	
    
    /**
     * <p>
     * <b>Description:</b><br/>
     * <p>
     * 
     * @param idProposta
     * @return
     * @since 22/09/2010
     */
    private CpProspectBean obterProspect(Long idProspect){
        CpProspectBean prospect = new CpProspectBean();        
        prospect.setIdProspect(idProspect);
        prospect = (CpProspectBean) super.findByPrimaryKey(prospect);
        return prospect;  
    }
    
	/**
     * <p>
     * <b>Description:</b><br/>
     * Método responsável por manter os dados de cobrança.
     * <p>
     * 
     * @since 21/09/2010
     * @author Alessandro Mariano
     * @param Bean
     *
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_MANTER_DADOS_COBRANCA"
     * 
     */
	public void manterDadosCobranca(final Bean dadosCobranca) {
		
		final List<ValidationMessage> erros =  validarDadosCobrancaProspota(dadosCobranca);
		if(erros.isEmpty()) {
			manutencaoCobranca(dadosCobranca);
			
			final Integer idTipoCobranca = Integer.valueOf((String)dadosCobranca.getBeanProperty(ID_TIPO_COBRANCA));
			
			if (idTipoCobranca.equals(Integer.valueOf("2"))) { //1-Boleto 2-Debito Conta Corrente
				manutencaoDadosDebitoContaCorrente(dadosCobranca);
			}
		}else{
		    this.verificarErrosValidacao(erros);
		}
	}
	
	/**
	 * <p>
     * <b>Description:</b><br/>
     * <p> 	
	 * @param dadosProsposta
	 * @return
	 * @since 22/09/2010
	 */
    private List<ValidationMessage> validarDadosCobrancaProspota(final Bean dadosCobranca) {
        
        List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
        
        final Long idProposta = Long.valueOf((String)dadosCobranca.getBeanProperty(ID_PROPOSTA));
        final Integer idTipoCobranca = Integer.valueOf((String)dadosCobranca.getBeanProperty(ID_TIPO_COBRANCA));
        final Long idProspect = Long.valueOf((String)dadosCobranca.getBeanProperty(ID_PROSPECT));
        
		final CpPropostaBean cpProposta = new CpPropostaBean();
		cpProposta.setIdProposta(idProposta);
	    
	    final CpPropostaBean localProposta = (CpPropostaBean) this.getCurrentDAO().findByPrimaryKey(cpProposta);
	    
	    if (GeralUtil.isNull(localProposta)) {
	    	errorList.add(getValidationMessage(PropostaConstants.MSG_ID_PROPOSTA_INVALIDO, new Object[]{ID_PROPOSTA}));
	    }
		
		if (idTipoCobranca.equals(PropostaConstants.CONSTANT_2)) { //1-Boleto 2-Debito Conta Corrente
			final CpProspectBean cpProspect = new CpProspectBean();
		    cpProspect.setIdProspect(idProspect);
		    
		    final CpProspectBean localProspect = (CpProspectBean) this.getCurrentDAO().findByPrimaryKey(cpProspect);
		    
		    if (localProspect == null) {
		    	errorList.add(getValidationMessage(PropostaConstants.MSG_ID_PROSPECT_INVALIDO,
		    	                                        new Object[]{ID_PROSPECT}));
		    }
		    
		    Long idBanco = null;
		    if (!StringUtils.isEmpty(dadosCobranca.getBeanProperty(ID_BANCO)) 
		                                            && !GeralUtil.isNull(dadosCobranca.getBeanProperty(ID_BANCO))) {
		    	idBanco = Long.valueOf((String)dadosCobranca.getBeanProperty(ID_BANCO));
		    }else {
		    	errorList.add(getValidationMessage(PropostaConstants.MSG_ID_BANCO_INVALIDO, new Object[]{ID_BANCO}));
		    }

	        final String conta = dadosCobranca.getBeanProperty(CONTA);
			final String digitoConta = dadosCobranca.getBeanProperty(DIGITO_CONTA);
			final String agencia = dadosCobranca.getBeanProperty(AGENCIA);
		    
		    if (!validaDadosDebitoContaCorrente(idBanco, conta, digitoConta, agencia)){
		    	errorList.add(getValidationMessage(PropostaConstants.MSG_DADOS_CARTAO_INVALIDO, new Object[0]));
		    }
		}

        return errorList;
    }
	
	private void manutencaoCobranca(final Bean dadosCobranca) {
		
		final Long idProposta = Long.valueOf((String)dadosCobranca.getBeanProperty(ID_PROPOSTA));
		final Integer idTipoCobranca = Integer.valueOf((String)dadosCobranca.getBeanProperty(ID_TIPO_COBRANCA));
		final Integer idDiaVencimento = (Integer) super.search("lstIdDiaVencimento", dadosCobranca).get(0);
		final Boolean isCheckedFaturaEmail = Boolean.valueOf(
		                                        (String)dadosCobranca.getBeanProperty(IS_CHECKED_FATURA_EMAIL));
		CpPropostaBean proposta = obterProposta(idProposta);
		final CpCobrancaBean localCobranca = searchCobrancaByPrimaryKey(idProposta);

		if (GeralUtil.isNull(localCobranca)) {
			final CpCobrancaBean cpCobranca = new CpCobrancaBean();
			cpCobranca.setProposta(proposta);
			SnTipoCobrancaBean tipoCobranca = obterTipoDeCobranca(idTipoCobranca);
			cpCobranca.setTipoCobranca(tipoCobranca);				
			cpCobranca.setDiaVencimento(idDiaVencimento);
			SnFormaEnvioFaturaBean formaEnvio = new SnFormaEnvioFaturaBean();			
			if (!isCheckedFaturaEmail){//2-Correios 3-Email
			    formaEnvio.setIdFormaEnvioFatura(Long.valueOf("2"));				
			} else {
			    formaEnvio.setIdFormaEnvioFatura(Long.valueOf("3"));				
			}
			formaEnvio = (SnFormaEnvioFaturaBean) super.findByPrimaryKey(formaEnvio);
	        cpCobranca.setIdFormaEnvFat(formaEnvio);
			
            this.getCurrentDAO().insert(cpCobranca);
        } else {
        	localCobranca.setProposta(proposta);
        	SnTipoCobrancaBean tipoCobranca = obterTipoDeCobranca(idTipoCobranca);            
        	localCobranca.setTipoCobranca(tipoCobranca);        	
        	localCobranca.setDiaVencimento(idDiaVencimento);        	
        	SnFormaEnvioFaturaBean formaEnvio = new SnFormaEnvioFaturaBean();            
            if (!isCheckedFaturaEmail){//2-Correios 3-Email
                formaEnvio.setIdFormaEnvioFatura(Long.valueOf("2"));                
            } else {
                formaEnvio.setIdFormaEnvioFatura(Long.valueOf("3"));                
            }
            formaEnvio = (SnFormaEnvioFaturaBean) super.findByPrimaryKey(formaEnvio);
            localCobranca.setIdFormaEnvFat(formaEnvio);
            this.getCurrentDAO().update(localCobranca);
        }  
                  
        Date dtFaturaRateio = this.returnFirstVenc(proposta);
        proposta.setDtFaturaRateio(dtFaturaRateio);
        this.getCurrentDAO().update(proposta);
          
	}
	
	@SuppressWarnings("rawtypes")
    private Date returnFirstVenc(CpPropostaBean proposta) {

        java.sql.Date data = null;

        try {

            List dtFaturaRateio = super.search(CpCobrancaBean.DT_FATURA_RATEIO, proposta); 
            Timestamp dtFatura = (Timestamp) dtFaturaRateio.get(0);

            SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

            String result = out.format(in.parse(dtFatura.toString()));
            data = new java.sql.Date(out.parse(result).getTime());

        } catch (Exception e) {
            data = null;
        }

        return data;

    }
	
	@SuppressWarnings("rawtypes")
    private String returnParam(CpCidadeOperadoraBean cpCidadeOperadoraBean) {
        
        DynamicBean bean = new DynamicBean();
        bean.set("cidContrato", cpCidadeOperadoraBean.getIdCidade());
        bean.set("nomeParametro", "ATIVAR_PRO_RATA");
        List vlrParametro = search(SnParametroBean.FIND_SN_VLR_PARAMETRO, bean);

        BigDecimal value = null;
        if (!vlrParametro.isEmpty()) {
            value = (BigDecimal) vlrParametro.get(0);
        }

        return value.toString();
        
    }

    /**
     * @param idTipoCobranca
     */
    private SnTipoCobrancaBean obterTipoDeCobranca(final Integer idTipoCobranca) {
        SnTipoCobrancaBean tipoCobranca= new SnTipoCobrancaBean();
        tipoCobranca.setIdTipoCobranca(idTipoCobranca);
        return (SnTipoCobrancaBean) super.findByPrimaryKey(tipoCobranca);
    }
	
	/**
	 * Operação que realiza a busca de cobranca
	 * 
	 * @param bean
	 * @return CpEnderecoProspectBean
	 * 
	 * @since 23/09/2010
	 */
	private CpCobrancaBean searchCobrancaByPrimaryKey(final Long idProposta) {
		final CpCobrancaBean cpCobranca = new CpCobrancaBean();
		cpCobranca.setIdProposta(idProposta);		
		final CpCobrancaBean retorno = (CpCobrancaBean) this.getCurrentDAO().findByPrimaryKey(cpCobranca);		
		return retorno;		
	}
	
	private void manutencaoDadosDebitoContaCorrente(final Bean dadosCobranca) {
		
		final Long idProspect = Long.valueOf((String)dadosCobranca.getBeanProperty(ID_PROSPECT));
		final String titular = dadosCobranca.getBeanProperty(TITULAR);
		final Long idBanco = Long.valueOf((String)dadosCobranca.getBeanProperty(ID_BANCO));
		final String agencia = dadosCobranca.getBeanProperty(AGENCIA);
		final String digitoAgencia =dadosCobranca.getBeanProperty(DIGITO_AGENCIA);
		final String conta = dadosCobranca.getBeanProperty(CONTA);
		final String digitoConta = dadosCobranca.getBeanProperty(DIGITO_CONTA);
			
		final CpContaCorrenteBean localContaCorrente = searchContaCorrenteByPrimaryKey(idProspect);

		if (localContaCorrente == null) {
		    CpProspectBean prospect = obterProspect(idProspect);
		    final CpContaCorrenteBean  cpContaCorrente = new CpContaCorrenteBean(prospect);			
			cpContaCorrente.setProspect(prospect);			
			cpContaCorrente.setTitular(titular);
			cpContaCorrente.setIdBanco(idBanco); 
			cpContaCorrente.setAgencia(agencia);
			cpContaCorrente.setDigitoAgencia(digitoAgencia);
			cpContaCorrente.setConta(conta);
			cpContaCorrente.setDigitoConta(digitoConta);
			this.getCurrentDAO().insert(cpContaCorrente);
		} else {			
			localContaCorrente.setTitular(titular);
			localContaCorrente.setIdBanco(idBanco);
			localContaCorrente.setAgencia(agencia);
			localContaCorrente.setDigitoAgencia(digitoAgencia);
			localContaCorrente.setConta(conta);
			localContaCorrente.setDigitoConta(digitoConta);
			this.getCurrentDAO().update(localContaCorrente);
		}
	}
	
	/**
	 * Operação que realiza a busca de cobranca
	 * 
	 * @param bean
	 * @return CpEnderecoProspectBean
	 * 
	 * @since 23/09/2010
	 */
	private CpContaCorrenteBean searchContaCorrenteByPrimaryKey(final Long idProspect) {
		final CpContaCorrenteBean cpProspect = new CpContaCorrenteBean();
		cpProspect.setIdProspect(idProspect);		
		final CpContaCorrenteBean retorno = (CpContaCorrenteBean) this.getCurrentDAO().findByPrimaryKey(cpProspect);		
		return retorno;
		
		
	}

	private Boolean validaDadosDebitoContaCorrente(final Long idBanco, final String conta,
	                                        final String digitoConta, final String agencia) {
		
		Boolean resultado = Boolean.FALSE;
		
		final String sql = "{call PSN_VALIDA_DV.VALIDA_DV(?,?,?,?)}";
		
		final BatchParameter[] parameters = { new BatchParameter(idBanco, Types.NUMERIC), 
				new BatchParameter(conta, Types.VARCHAR),
				new BatchParameter(digitoConta, Types.VARCHAR), 
				new BatchParameter(agencia, Types.VARCHAR) };
		
		try {
			getCurrentDAO().executeBatch(sql, parameters);
			resultado = Boolean.TRUE;
		}catch (Exception e) {
			resultado = Boolean.FALSE;
		}
		return resultado;
	}
}