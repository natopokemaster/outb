package br.com.netservicos.netcrmcore.venda.telefone.facade.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

import br.com.netservicos.core.bean.cp.CpAtributoBean;
import br.com.netservicos.core.bean.cp.CpPendenciasBean;
import br.com.netservicos.core.bean.cp.CpPontoBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpRelConcorrenteProspectBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciasVariacoesBean;
import br.com.netservicos.core.bean.cp.CpReservaTelefoneVoipBean;
import br.com.netservicos.core.bean.cp.CpStatusPropostaBean;
import br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.bean.UserInfo;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.exception.system.ResourceException;
import br.com.netservicos.framework.service.delegate.DelegateMethod;
import br.com.netservicos.framework.util.exception.BaseBusinessException;
import br.com.netservicos.framework.util.exception.BaseFailureException;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.venda.constants.TelefoneConstants;
import br.com.netservicos.netcrmcore.venda.core.facade.impl.AbstractNETCRMVendaEJBImpl;
import br.com.netservicos.netcrmcore.venda.resources.NETCRMVendaResources;
import br.com.netservicos.netcrmcore.venda.telefone.facade.NumeroTelefoneNETfoneService;

/**
 * EJB responsável por listar número de telefones disponíveis para venda
 * (asssinante).
 * 
 * @author marcio@mdantas.com.br
 * 
 * @ejb.bean name="NumeroTelefoneNETfoneEJB" type="Stateless"
 *           display-name="NumeroTelefoneNETfoneEJB"
 *           description="NumeroTelefoneNETfoneEJB Session EJB Stateless"
 *           view-type="both" jndi-name="netcrmcore/venda/ejb/NumeroTelefoneNETfoneEJB"
 *           local-jndi-name="netcrmcore/venda/ejb/local/NumeroTelefoneNETfoneEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class NumeroTelefoneNETfoneEJBImpl extends AbstractNETCRMVendaEJBImpl implements
		NumeroTelefoneNETfoneService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1713492184667431518L;
    private static final String MSG_SUCESSO = "SUCESSO";
    public static final Long    ID_CARACTERISTICA_VOIP                     = 4l;
    private static final String LST_RESERVA_VOIP_BY_IDPONTO = "lstReservaTelByIdPonto";
    public static final String LISTA_RESERVA_TEL_BY_DDD_TEL = "lstReservaTelByDddTel";
    public static final String PROC_PSN_MANTELEFONE_VOIP_ATUALIZA_PUBL_VOIP_AVAL 
    = "{call PSN_MANTELEFONE_VOIP.PR_ATUALIZAPUBLICACAOVOIPAVAL(?,?,?,?,?,?,?,?,?,?)}";
    public static final String RESERVA_TELEFONE_FAILED = 
        "N\u00e3o foi poss\u00edvel reservar o telefone";
    public static final String CANCELAR_RESERVA_TELEFONE_FAILED = 
        "N\u00e3o foi poss\u00edvel cancelar a reserva do telefone";
    private static final String PROC_PSN_MANTELEFONE_VOIP_CANCELA_RESERVATELVOIP_AVALIAR = 
        "{call PSN_MANTELEFONE_VOIP.PR_CANCELARESERVATELVOIPAVAL(?,?,?,?,?,?,?,?)}";
    private static final String RESERVA_BY_DDD_TEL = "findReservaTelByDddTel";
    
	
	/**
	 * Operação que realiza a listagem de números de telefones disponíveis.
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="CRM_CONSULTAR_NUMERO_TELEFONE"
	 */
	public List listarTelefones(final Bean bean) throws IOException {
		final DynamicBean dynaBean = (DynamicBean) bean;

		return obterListaTelefone(dynaBean);

	}
	
	/**
	 * Reserva o Telefone
	 * 
     * @ejb.interface-method view-type = "both"
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_RESERVAR_NUMERO_TELEFONE"
     * 
     * @param bean
     * @return DynamicBean
     */
    public DynamicBean reservaTelefoneVoip(final DynamicBean bean) {

        List retorno = new ArrayList();
        final DynamicBean beanRetorno = new DynamicBean();

        // Pega a proposta do Bean e valida-a
        CpPropostaBean proposta = validaProposta(bean);   
        
        String msgError = MSG_SUCESSO;
        String mensagemErro = null;
        Integer idStausProposta = Integer.valueOf(0);
        if (!GeralUtil.isNull(proposta.getStatusProposta())) {
            idStausProposta = proposta.getStatusProposta().getIdStatusProposta();
        }
        if (idStausProposta != 5){          
            
            String[] telefones =  (String[]) bean.get(TelefoneConstants.TELEFONES);
            
            //Valida telefones
            validaTelefones(telefones);
            
            List ponto = proposta.getPontos();
            Iterator itPontos = ponto.iterator();
    
            String item = null;
            int cont = 0;
            List listaReservas = new ArrayList();
                
            while(itPontos.hasNext()){
    
                CpPontoBean propostaPonto = (CpPontoBean) itPontos.next();
    
                if (ID_CARACTERISTICA_VOIP.equals(propostaPonto.getCaracteristica().getIdCaracteristica())) {
    
                    listaReservas = super.search(LST_RESERVA_VOIP_BY_IDPONTO, propostaPonto);
    
                    if(listaReservas.isEmpty()){
                        if(telefones.length > cont){
                            Boolean isPublica = false;
                            String ddd = null;
                            String telefone = null;
                            
                            while(telefones.length > cont){
                                isPublica = false;
                                item = (String) telefones[cont];
                                ddd = item.substring(0,TelefoneConstants.CONSTANT_2);
                                telefone = item.substring(TelefoneConstants.CONSTANT_3).toString();
                                
                                bean.set("ddd", ddd);
                                bean.set("telefone", telefone);
                                    
                                List obj = new ArrayList();
                                obj = super.search(LISTA_RESERVA_TEL_BY_DDD_TEL, bean);
    
                                cont++;
                                if(obj.isEmpty()){
                                   break;
                                }
                            }
                            // Executa a PROC de Reserva de Telefone
                            retorno = executeReserva(proposta, ddd, telefone);
                                
                            mensagemErro = (String) retorno.get(TelefoneConstants.CONSTANT_8);
                            BigDecimal codError = (BigDecimal) retorno.get(TelefoneConstants.CONSTANT_7);
                            if (!GeralUtil.isNull(codError) && codError.intValue() != TelefoneConstants.CONSTANT_1) {
                                msgError = (String) retorno.get(TelefoneConstants.CONSTANT_8);
                                break;
                            }
                            if(msgError.equals(MSG_SUCESSO)){
                                incluirReservaTelefoneVoip(propostaPonto.getIdPonto(), ddd, telefone);
                                isPublica = true;
                            }
                            if("1".equals((String)bean.get(TelefoneConstants.PUBLICA_NUMERO)) && isPublica){
                                publicacaoTelefone(bean);
                                isPublica = false;
                            }
                        }
                    }
                }
            }
    
            if (msgError.equals(MSG_SUCESSO)){
                releasePendenciaReservaTelefoneVoIP(proposta, null);
                if(!GeralUtil.isNull(mensagemErro)){
                    msgError = mensagemErro;
                }
            }
        }
        
        if (msgError.equals(MSG_SUCESSO)){
            msgError = RESERVA_TELEFONE_FAILED;        
        }
        
        beanRetorno.set(TelefoneConstants.MENSAGEM,msgError);
        return beanRetorno; 
    }

    /**
     * Executa a PROC de reserva de Telefone
     * @param retorno
     * @param proposta
     * @param ddd
     * @param telefone
     * @return
     */
    private List executeReserva(final CpPropostaBean proposta, final String ddd, final String telefone) {
        
        List retorno = new ArrayList();
        
        try {    
   
            BatchParameter[] parameters = {
                    new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                    new BatchParameter(proposta.getIdProposta(), Types.NUMERIC),
                    new BatchParameter(Integer.valueOf(TelefoneConstants.CONSTANT_5), Types.NUMERIC),
                    new BatchParameter(ddd, Types.VARCHAR),
                    new BatchParameter(telefone, Types.VARCHAR),
                    new BatchParameter(Integer.valueOf(TelefoneConstants.CONSTANT_1), Types.NUMERIC),
                    new BatchParameter(Integer.valueOf(TelefoneConstants.CONSTANT_1), Types.NUMERIC),
                    new BatchParameter(Types.NUMERIC, true),
                    new BatchParameter(Types.VARCHAR, true),
                    new BatchParameter(proposta.getNumContrato(), Types.NUMERIC)};
            
            retorno = getCurrentDAO().executeBatch( TelefoneConstants.
                                                    PROC_PSN_MANTELEFONE_VOIP_RESERVA_TELVOIP_AVALIAR_APPCLIENT,
                                                    parameters, true, true);
            
        } catch (Exception ex) {
            throw new BaseFailureException(ex);
        }
        return retorno;
    }

    /**
     * Valida a proposta 
     * @param bean
     * @return
     */
    private CpPropostaBean validaProposta(final DynamicBean bean) {
        CpPropostaBean proposta = new CpPropostaBean(); 
        proposta.setIdProposta( Long.valueOf((String)bean.get(TelefoneConstants.ID_PROPOSTA)));
        proposta = (CpPropostaBean) super.findByPrimaryKey( proposta);
        
        if(proposta == null){
            String mensagem = this.getMessage(NETCRMVendaResources.RESOURCE_PROPOSTA_INEXISTENTE);
            ResourceException ex = new ResourceException(NETCRMVendaResources.RESOURCE_PROPOSTA_INEXISTENTE, 
                                                    mensagem, this.getClass().getName());
            throw ex;
        }
        return proposta;
    }

    /**
     * Valida os telefones de entrada
     * @param telefones
     */
    private void validaTelefones(final String[] telefones) {
        
        for (int i = 0; i < telefones.length; i++) {
            String mensagemValidacao = null;
            String ddd = telefones[i].substring(0,2);
            String telefone = telefones[i].substring(TelefoneConstants.CONSTANT_3);
            if(ddd != null && ! ddd.equals("") && ddd.trim().length() != Integer.valueOf("2")){
                mensagemValidacao = this.getMessage(NETCRMVendaResources.DDD_INVALIDO, new Object[] { ddd });
                ResourceException ex = new ResourceException(NETCRMVendaResources.DDD_INVALIDO, 
                                                        mensagemValidacao, this.getClass().getName());
                throw ex;
            }
            if(telefone != null && ! telefone.equals("") && telefone.trim().length() != Integer.valueOf("8")){
                mensagemValidacao = this.getMessage(NETCRMVendaResources.TEL_INVALIDO, new Object[] { telefone });
                ResourceException ex = new ResourceException(NETCRMVendaResources.TEL_INVALIDO, 
                                                        mensagemValidacao, this.getClass().getName());
                throw ex;
            }
        }
    }
    
    
    /**
     * Publica o telefone
     * @param bean
     * @return
     */
    private Bean publicacaoTelefone(final Bean bean) { 
        DynamicBean dynaBean = (DynamicBean) bean;
        
        List retorno = new ArrayList();
        
        List<CpReservaTelefoneVoipBean> list =  super.search(RESERVA_BY_DDD_TEL, bean);
        
        if (!CollectionUtils.isEmpty(list)) {
        	
        	CpReservaTelefoneVoipBean publica = list.get(0);
             
	        Integer publicar = 1;
	        
	        if(GeralUtil.isNull(publica.getPublicar())){
	            publicar = 0;
	        }
	        String nome = publica.getNomePublicar();       
	        
	        Long idProposta = Long.valueOf((String) dynaBean.get(TelefoneConstants.ID_PROPOSTA));
	        CpPropostaBean proposta = obterProposta(idProposta);
	        Integer idStausProposta = 0;
	        if (!GeralUtil.isNull(proposta) && !GeralUtil.isNull(proposta.getStatusProposta())) {
	            idStausProposta = proposta.getStatusProposta().getIdStatusProposta();
	        }
	        
	        if (!idStausProposta.equals(TelefoneConstants.CONSTANT_5)){
	            
	            final String idCidade = proposta.getCidadeOperadora().getIdCidade();
	            
	            if (publicar.equals(Integer.valueOf(0)))
	                nome = null;
	            
	            String msgError = MSG_SUCESSO;
	            
	            try {                           
	                
	                BatchParameter[] parameters = {
	                        new BatchParameter(idCidade, Types.VARCHAR),
	                        new BatchParameter(idProposta, Types.NUMERIC),
	                        new BatchParameter(TelefoneConstants.CONSTANT_5, Types.NUMERIC),
	                        new BatchParameter(publica.getDdd(), Types.VARCHAR),
	                        new BatchParameter(publica.getTelefone(), Types.VARCHAR),
	                        new BatchParameter(publicar, Types.NUMERIC),
	                        new BatchParameter(nome, Types.VARCHAR),
	                        new BatchParameter(Long.valueOf(TelefoneConstants.CONSTANT_1), Types.NUMERIC),
	                        new BatchParameter(Types.NUMERIC, true),
	                        new BatchParameter(Types.VARCHAR, true)};
	                
	                retorno = getCurrentDAO().executeBatch(PROC_PSN_MANTELEFONE_VOIP_ATUALIZA_PUBL_VOIP_AVAL, 
	                                                        parameters, true, true);
	                                    
	            } catch (Exception ex) {
	                if (ex instanceof BaseBusinessException) {
	                    throw (BaseBusinessException) ex;
	                }
	                throw new BaseFailureException(ex);
	            }         
	            
	            BigDecimal codError = (BigDecimal) retorno.get(TelefoneConstants.CONSTANT_8);
	            if (!GeralUtil.isNull(codError) && codError.intValue() != 1) {
	                msgError = (String) retorno.get(TelefoneConstants.CONSTANT_9);
	                BaseBusinessException ex = new BaseBusinessException();
	                ex.addErrorKey(msgError);
	                throw ex;
	            }             
	            
	            if (MSG_SUCESSO.equals(msgError)) {
	                publica.setNomePublicar(nome);
	                publica.setPublicar(publicar);
	                super.update(publica, getUserSession().getCurrentDbService());
	            }
	        }
        }
        
        return dynaBean;
    }
    
    /**
     * Inclui uma reserva d nº telefônico
     * @param idPonto
     * @param ddd
     * @param tel
     */
     private void incluirReservaTelefoneVoip(final Long idPonto,final  String ddd, final String tel){
         CpPontoBean ponto = new CpPontoBean();
         ponto.setIdPonto(idPonto);

         CpReservaTelefoneVoipBean reservaTel = new CpReservaTelefoneVoipBean();
         reservaTel.setPonto(ponto);
         reservaTel.setDdd(ddd);
         reservaTel.setTelefone(tel);

         super.insert(reservaTel, getUserSession().getCurrentDbService());
     }

    
    
    /**
     * 
     * @param proposta
     * @param pontosVoip
     */
    private void releasePendenciaReservaTelefoneVoIP(final CpPropostaBean proposta, final Integer pontosVoip) {
        // Caso no cancelamento de Reservas de telefone VOIP não haja telefones,
        // exclui a pendência gerada

        // verifica se proposta tem números a portar e se tem pontos. a
        // pendencia de portabilidade tem
        // prioridade. desta forma, primeiro é removida a pendência de telefone
        // e depois a de portabilidade.
        // todos os números cadastrados no área local para portar devem ser
        // portados.
        // então, se existirem menor ou igual número de pontos que números a
        // portar, a pendência de telefone
        // deve ser removida.
        // se não houver números a portar, ou não houver pontos, remover
        // pendência de portabilidade
        
        int qtidadeDeNumerosAPortarDisponiveis = getQtdNumPortarDisp(proposta);
        
        if (qtidadeDeNumerosAPortarDisponiveis >= getNumeroTotaldePontosVoipNaoReservados(proposta, pontosVoip)) {
            List pendeciasTelFinalizar = super.search(CpRelPendenciaPropostaBean.LST_PENDENCIA_RESERVA_VOIP,
                    proposta);
            for (int i = 0; i < pendeciasTelFinalizar.size(); i++) {
                Long idRelPend = (Long) pendeciasTelFinalizar.get(i);
                CpRelPendenciaPropostaBean relPendenciaTelefone = new CpRelPendenciaPropostaBean();
                relPendenciaTelefone.setIdRelPendenciaProposta(idRelPend);
                // Efetuado a liberação da pendência de VoIP da proposta
                releasePendenciaProposta(relPendenciaTelefone);
            }
        }

        if (qtidadeDeNumerosAPortarDisponiveis == 0) {
            List lstPendenciasPortabilidadeAFinalizar = super.search(
                    CpRelPendenciaPropostaBean.LST_PENDENCIA_RESERVA_VOIP_PORTABILIDADE, proposta);
            for (int i = 0; i < lstPendenciasPortabilidadeAFinalizar.size(); i++) {
                Long idRelPend = (Long) lstPendenciasPortabilidadeAFinalizar.get(i);
                CpRelPendenciaPropostaBean relPendenciaPortabilidade = new CpRelPendenciaPropostaBean();
                relPendenciaPortabilidade.setIdRelPendenciaProposta(idRelPend);
                // Efetuado a liberação da pendência de VoIP da proposta
                releasePendenciaProposta(relPendenciaPortabilidade);
            }
        }
    }
   
    /**
     * Busca o número total de pontos voip adicionados e que não tem número reservado ainda.
     * Se numeroTotalPontosVoip for diferente de null, não efetua busca e apenas o retorna.
     * @param proposta
     * @return
     */
    private int getNumeroTotaldePontosVoipNaoReservados(final CpPropostaBean proposta, final Integer pontosVoip) {

        if (GeralUtil.isNull(pontosVoip)) {
            DynamicBean prop = new DynamicBean();
            prop.set(TelefoneConstants.PROPERTY_PROPOSTA, proposta);
            List listaDePontosVoip = super.search(CpPontoBean.LST_QTDADE_PRODUTOS_VOIP_NAO_RESERVADOS, prop, false);
            return listaDePontosVoip.size();
        } else {
            return pontosVoip.intValue();
        }
    }
    
    private int getQtdNumPortarDisp(CpPropostaBean proposta) {
        
        List listaDeDispPortabilidade = super.search(
                SnDispPortabilidadeBean.COUNT_DISP_PORTABILIDADE_DISPONIVEIS_BY_PROPOSTA, proposta, false);
        return ((Long) listaDeDispPortabilidade.get(0)).intValue();
    }
    	
	/**
	 * Operação que realiza o cancelamento da reserva de telefone.
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="CRM_CANCELAR_RESERVA_NUMERO_TELEFONE"
	 * 
	 * 
	 * 
	 */
	public DynamicBean cancelaReservaTelefoneVoip(DynamicBean bean) {
        List retorno = new ArrayList();

        CpPropostaBean proposta = validaProposta(bean);

        List ponto = proposta.getPontos();
        Iterator itPontos = ponto.iterator();
        Iterator itTel = null;
        String msgError = null;
        while(itPontos.hasNext()){
            
            CpPontoBean propostaPonto = (CpPontoBean)  itPontos.next();

            if(ID_CARACTERISTICA_VOIP.equals(propostaPonto.getCaracteristica().getIdCaracteristica())) {

                List reservaTel =  (List) propostaPonto.getReservasVoip();
                itTel = reservaTel.iterator();

                while(itTel.hasNext()){
                     CpReservaTelefoneVoipBean tel = (CpReservaTelefoneVoipBean) itTel.next();

                    // Cancela Reserva Telefonica
                    try {
                        BatchParameter[] parameters = {
                                new BatchParameter(proposta.getCidadeOperadora().getIdCidade(), Types.VARCHAR),
                                new BatchParameter(proposta.getIdProposta(), Types.NUMERIC),
                                new BatchParameter(TelefoneConstants.CONSTANT_5, Types.NUMERIC),
                                new BatchParameter(tel.getDdd(), Types.VARCHAR),
                                new BatchParameter(tel.getTelefone(), Types.VARCHAR),
                                new BatchParameter(TelefoneConstants.CONSTANT_1, Types.NUMERIC),
                                new BatchParameter(Types.NUMERIC,true),
                                new BatchParameter(Types.VARCHAR,true)};
                        
                        retorno = getCurrentDAO().executeBatch(
                                                  PROC_PSN_MANTELEFONE_VOIP_CANCELA_RESERVATELVOIP_AVALIAR, 
                                                                parameters, true, true);
                    } catch (Exception ex) {
                        if (ex instanceof BaseBusinessException) {
                            throw (BaseBusinessException) ex;
                        }
                        throw new BaseFailureException(ex);
                    }
                    msgError = (String) retorno.get(TelefoneConstants.CONSTANT_7);
                    BigDecimal codError = (BigDecimal) retorno.get(TelefoneConstants.CONSTANT_6);
                    if (codError != null && codError.intValue() != 1) {
                        BaseBusinessException ex = new BaseBusinessException();
                        ex.addErrorKey(msgError);
                        throw ex;
                    }

                    excluiReservaTelefoneVoip(propostaPonto.getIdPonto(), tel.getDdd(), tel.getTelefone());
                }
            }
        }
        
        geraPendencia(proposta.getIdProposta());
        
        DynamicBean dynamicBean = new DynamicBean();
        
        if(msgError != null){
            dynamicBean.set(TelefoneConstants.MENSAGEM, msgError);
        }else{
            dynamicBean.set(TelefoneConstants.MENSAGEM, CANCELAR_RESERVA_TELEFONE_FAILED);
        }
        return dynamicBean; 
        
    }
	
	/**
	 * Exclui as reservas de telefones
	 * 
	 * @param idPonto
	 * @param ddd
	 * @param tel
	 */
	private void excluiReservaTelefoneVoip(final Long idPonto, final String ddd, final String tel){
        CpPontoBean ponto = new CpPontoBean();
        ponto.setIdPonto(idPonto);

        List obj = new ArrayList();
        obj = super.search(LST_RESERVA_VOIP_BY_IDPONTO, ponto);

        if(!GeralUtil.isNull(obj) && !CollectionUtils.isEmpty(obj)){
            Long idVoip = (Long) obj.get(0);

            CpReservaTelefoneVoipBean reservaTel = new CpReservaTelefoneVoipBean();
            reservaTel.setIdVoip(idVoip);
            reservaTel.setPonto(ponto);
            reservaTel.setDdd(ddd);
            reservaTel.setTelefone(tel);

            super.delete(reservaTel, getUserSession().getCurrentDbService());
            getCurrentDAO().flush();
        }

    }
	
	/**
	 * Gera as Pendências
	 * 
	 * @param idProposta
	 */
	private void geraPendencia(final Long idProposta){
        CpPropostaBean proposta = obterProposta(idProposta);

        List pendencias = proposta.getPendenciasPropostaEmAberto();
        Iterator it = pendencias.iterator();
        boolean jaExistePendencia = false;
        CpRelPendenciaPropostaBean relPendencia = new CpRelPendenciaPropostaBean();
        CpPendenciasBean pendencia = new CpPendenciasBean();
        CpRelPendenciasVariacoesBean variacaoPend = new CpRelPendenciasVariacoesBean();

        while(it.hasNext()){
            relPendencia = (CpRelPendenciaPropostaBean)it.next();
            pendencia = relPendencia.getPendencia();
            variacaoPend = relPendencia.getPendenciaVariacao();
            if(pendencia.getIdPendencia().intValue() == TelefoneConstants.CONSTANT_15 && 
                                                 variacaoPend.getIdPendVariacao().intValue()== 
                                                     TelefoneConstants.CONSTANT_26){
                jaExistePendencia = true;
                break;
            }
        }
        if(!jaExistePendencia){
            pendencia = new CpPendenciasBean();
            variacaoPend = new CpRelPendenciasVariacoesBean();
            relPendencia = new CpRelPendenciaPropostaBean();
            pendencia.setIdPendencia(Long.valueOf(TelefoneConstants.CONSTANT_15));
            variacaoPend.setIdPendVariacao(Long.valueOf(TelefoneConstants.CONSTANT_26));
            relPendencia.setDtAbertura(new Date());
            relPendencia.setPendencia(pendencia);
            relPendencia.setPendenciaVariacao(variacaoPend);
            relPendencia.setProposta(proposta);
            relPendencia.setUsuario(getUserSession().getUserId());
            super.insert(relPendencia, getUserSession().getCurrentDbService());
            
            // Setando o status da proposta para pendente
            updateStatusProposta(proposta, new Integer(CpStatusPropostaBean.STATUS_PENDENTE));
            
        }
    }
	
	/**
	 * 
	 * @param proposta
	 * @param status
	 */
	private void updateStatusProposta(CpPropostaBean proposta, Integer status) {        
        proposta = obterProposta(proposta.getIdProposta());
        proposta.setStatusProposta(new CpStatusPropostaBean(status.intValue()));
        // Atualizando o status da proposta
        super.update(proposta, getUserSession().getCurrentDbService());
    }
	
	private List obterListaTelefone(final Bean bean) {
		
		DynamicBean dynaBean = (DynamicBean) bean;
		
		final BatchParameter[] parameters = new BatchParameter[TelefoneConstants.CONSTANT_11];
		parameters[TelefoneConstants.CONSTANT_0] = 
		    new BatchParameter(dynaBean.get(TelefoneConstants.PCIDADE_CONTRATO), Types.VARCHAR);
		parameters[TelefoneConstants.CONSTANT_1] = 
		    new BatchParameter(dynaBean.get(TelefoneConstants.PDDD_TELEFONE), Types.VARCHAR);
		parameters[TelefoneConstants.CONSTANT_2] = 
		    new BatchParameter(dynaBean.get(TelefoneConstants.PTELEFONE_INICIAL), Types.VARCHAR);
		parameters[TelefoneConstants.CONSTANT_3] = 
		    new BatchParameter("", Types.VARCHAR);
		parameters[TelefoneConstants.CONSTANT_4] = 
		    new BatchParameter(dynaBean.get(TelefoneConstants.GOLDEN), Types.NUMERIC);
		parameters[TelefoneConstants.CONSTANT_5] = 
		    new BatchParameter("0", Types.VARCHAR); //parametrizar portabilidade
		parameters[TelefoneConstants.CONSTANT_6] = 
		    new BatchParameter(0, Types.NUMERIC);
		parameters[TelefoneConstants.CONSTANT_7] = 
		    new BatchParameter(0, Types.NUMERIC);
		parameters[TelefoneConstants.CONSTANT_8] = 
		    new BatchParameter(BatchParameter.ORACLE_CURSOR, true);
		parameters[TelefoneConstants.CONSTANT_9] = 
		    new BatchParameter(dynaBean.get(TelefoneConstants.PNUMERO_CONTRATO), Types.NUMERIC);
		parameters[TelefoneConstants.CONSTANT_10] = 
		    new BatchParameter(dynaBean.get(TelefoneConstants.PID_PROPOSTA), Types.NUMERIC);

		List listaTelefones = (List) this.getCurrentDAO().executeBatch(
						TelefoneConstants.PROC_PSN_MANTELEFONE_VOIP_CONSULTA_TELEFONEVOIP_PORTABILIDADE,
						parameters).get(TelefoneConstants.CONSTANT_8);
		
		return setarDadosTelefone(listaTelefones);
				
	}		
	
	private List setarDadosTelefone(final List lst) {

		List<DynamicBean> telefoneList = new ArrayList<DynamicBean>();
		telefoneList = lst;
		
		return telefoneList;
	}
	
    /**
	 * Método responsável por recuperar as reservas de telefone voip.
	 * 
	 * @param bean
	 *            Bean contendo informações a serem filtradas
	 * 
	 * @author marcio@mdantas.com.br
	 * @since 13/10/2010
	 * 
	 * @ejb.interface-method view-type="local"
	 */
    public List retrieveReservaTelefoneVoip(final DynamicBean bean){

    	return super.search(TelefoneConstants.LIST_RESERVA_TELEFONE_BY_ID_PONTO_ASSINANTE, bean, false);
    }
	
	/**
	 * 
	 * @param pendenciaProposta
	 */
    private void releasePendenciaProposta(CpRelPendenciaPropostaBean pendenciaProposta) {
        UserInfo userInfo = getUserSession();
        Date dtAtual = new Date();
        CpRelPendenciasVariacoesBean pendVar = new CpRelPendenciasVariacoesBean();
        CpStatusPropostaBean status = new CpStatusPropostaBean();
        pendVar.setIdPendVariacao(Long.valueOf(TelefoneConstants.CONSTANT_99));
        pendVar = (CpRelPendenciasVariacoesBean) find(pendVar);

        CpRelPendenciaPropostaBean pendenciaPropostaSaved = (CpRelPendenciaPropostaBean) 
        getCurrentDAO().find(CpRelPendenciaPropostaBean.class,pendenciaProposta.getIdRelPendenciaProposta());
        CpPropostaBean proposta = pendenciaPropostaSaved.getProposta();
        proposta = (CpPropostaBean) getCurrentDAO().find(CpPropostaBean.class, proposta.getIdProposta());
        pendenciaPropostaSaved.setFnLiberarExcecao(pendenciaProposta.getFnLiberarExcecao());
        pendenciaPropostaSaved.setBackOffice(Integer.valueOf(1));
        pendenciaPropostaSaved.setPendenciaVariacao(pendVar);
        pendenciaPropostaSaved.setUsuario(getUserSession().getUserId());
        if (GeralUtil.isNull(pendenciaProposta.getDtFechamento()))
            pendenciaPropostaSaved.setDtFechamento(dtAtual);
        else
            pendenciaPropostaSaved.setDtFechamento(pendenciaProposta.getDtFechamento());

        pendenciaProposta = (CpRelPendenciaPropostaBean)super.find(pendenciaProposta);

        if(pendenciaProposta.getProposta().getProspect().getAtributos() != null &&
          pendenciaProposta.getProposta().getProspect().getAtributos().size() > 0){
            
            CpAtributoBean atributoProspect = (CpAtributoBean) 
            pendenciaProposta.getProposta().getProspect().getAtributos().get(0);
            // Caso origem seja "ASSINANTE DA CONCORRÊNCIA" (IdAtributo = 3) e
            // Caso tipo da pendência seja "ENVIO DE DOCUMENTO" (IdPendencia = 17)
            if (atributoProspect.getIdAtributo().intValue() == CpAtributoBean.ASSINANTE_CONCORRENCIA &&
                pendenciaProposta.getPendencia().getIdPendencia().longValue() == CpPendenciasBean.ENVIO_DOCUMENTO) {
                // Repassando informacoes do concorrente do prospect ao objeto a ser persistido
                CpRelConcorrenteProspectBean relConcorrProspect = new CpRelConcorrenteProspectBean();
                relConcorrProspect.setIdRelConcorrenteProspect(
                                                        pendenciaProposta.getProposta().getProspect().
                                                        getRelConcorrenteProspect().getIdRelConcorrenteProsp());
                relConcorrProspect = (CpRelConcorrenteProspectBean)super.find(relConcorrProspect);
                relConcorrProspect.setDsPacoteConcorrente(pendenciaProposta.
                                                        getProposta().getProspect().getRelConcorrenteProspect().
                                                        getDsPcteConcorrente());
                relConcorrProspect.setQtPontosConcorrente(pendenciaProposta.
                                                        getProposta().getProspect().getRelConcorrenteProspect().
                                                        getQtPtosConcorrente());
                relConcorrProspect.setVlConcorrente(pendenciaProposta.getProposta().
                                                        getProspect().getRelConcorrenteProspect().getVlConcorrente());

                super.update(relConcorrProspect, getUserSession().getCurrentDbService());
            }
            
        }
        
        // Persistindo as informações da pendência da proposta
        update(pendenciaPropostaSaved, getUserSession().getCurrentDbService());

        List list = super.search(CpPendenciasBean.LST_CP_PENDENCIAS_BY_PROPOSTA, proposta);
        if (list.isEmpty()) {

            DelegateMethod method = getDelegate().getDelegateMethod("PropostaEJB.validateDadosProposta",
                    new Object[] {pendenciaProposta.getProposta()}, getUserSession(), false);
            Boolean validation = (Boolean) method.execute();

            if (validation.booleanValue()) {
                status.setIdStatusProposta(Integer.valueOf(CpStatusPropostaBean.STATUS_PENDENTE_EM_AGENDAMENTO));
                proposta.setDtLiberacao(dtAtual);
            } else {
                status.setIdStatusProposta(Integer.valueOf(CpStatusPropostaBean.STATUS_EM_ANDAMENTO));
                proposta.setDtLiberacao(null);
            }
            status = (CpStatusPropostaBean) find(status);
            proposta.setStatusProposta(status);
            update(proposta, getUserSession().getCurrentDbService());
            CpRelPendenciaPropostaBean newPendPro = new CpRelPendenciaPropostaBean();
            CpPendenciasBean pend = new CpPendenciasBean();
            pend.setIdPendencia(Long.valueOf(1));
            pend = (CpPendenciasBean) find(pend);
            pendVar = new CpRelPendenciasVariacoesBean();
            pendVar.setIdPendVariacao(Long.valueOf(TelefoneConstants.CONSTANT_25));
            pendVar = (CpRelPendenciasVariacoesBean) find(pendVar);
            newPendPro.setPendenciaVariacao(pendVar);
            newPendPro.setDtAbertura(dtAtual);
            newPendPro.setProposta(proposta);
            newPendPro.setPendencia(pend);
            newPendPro.setUsuario(userInfo != null && userInfo.getUserId() != null ? userInfo.getUserId() : "");
            insert(newPendPro, userInfo.getCurrentDbService());
        } else {
            if (!proposta.getStatusProposta().getIdStatusProposta().equals(
                                                    Integer.valueOf(CpStatusPropostaBean.STATUS_ENVIADA)) 
                                                    && !proposta.getStatusProposta().getIdStatusProposta().
                                                    equals(Integer.valueOf(CpStatusPropostaBean.STATUS_CANCELADA))){
                status.setIdStatusProposta(Integer.valueOf(CpStatusPropostaBean.STATUS_PENDENTE));
                status = (CpStatusPropostaBean) find(status);
                proposta.setStatusProposta(status);
                proposta.setDtLiberacao(null);
                update(proposta, getUserSession().getCurrentDbService());
            }
        }

    }
    
	private CpPropostaBean obterProposta(final Long idProposta) {
		CpPropostaBean proposta = new CpPropostaBean();
		proposta.setIdProposta(idProposta);
        return (CpPropostaBean) super.findByPrimaryKey(proposta);
    }
}
