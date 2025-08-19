package br.com.netservicos.netcrmcore.venda.proposta.pendencia.facade.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import br.com.netservicos.core.bean.cp.CpAtributoBean;
import br.com.netservicos.core.bean.cp.CpPendenciasBean;
import br.com.netservicos.core.bean.cp.CpPontoBean;
import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpRelConcorrenteProspectBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciasVariacoesBean;
import br.com.netservicos.core.bean.cp.CpStatusPropostaBean;
import br.com.netservicos.core.bean.sn.SnDispPortabilidadeBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.bean.UserInfo;
import br.com.netservicos.framework.service.delegate.DelegateMethod;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.venda.core.facade.impl.AbstractNETCRMVendaEJBImpl;
import br.com.netservicos.netcrmcore.venda.proposta.pendencia.facade.PendenciaService;

/**
 * EJB responsável pela validação / alteração dos dados cadastrais do cliente.
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean name="PendenciaEJB" type="Stateless" display-name="PendenciaEJB"
 *           description="PendenciaEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netcrmcore/venda/ejb/PendenciaEJB"
 *           local-jndi-name="netcrmcore/venda/ejb/local/PendenciaEJB"
 *           transaction-type="Container"
 * 
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * 
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * 
 */
public class PendenciaEJBImpl extends AbstractNETCRMVendaEJBImpl implements 
		PendenciaService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1713492184667436066L;
	
	private static final Integer CONSTANT_99 = 99;
	private static final Integer CONSTANT_25 = 25;

	/**
	 * Método responsável por criar proposta
	 *  
	 * 
	 * @ejb.interface-method view-type = "both" 
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="CRM_GERAR_PENDENCIA_PROPOSTA"
	 */	
	public void inserirPendenciaProposta(Long idProposta, Long pendencia, Long pendenciaVariacao, 
	                                        Long idPendenciaVariacao, String obs){
		
		UserInfo userInfo = getUserSession();		
		CpRelPendenciaPropostaBean pendenciaProposta = new CpRelPendenciaPropostaBean();
		pendenciaProposta.setProposta(obterProposta(idProposta));
		pendenciaProposta.setPendencia(obterPendecia(pendencia));
		pendenciaProposta.setDtAbertura(new Date());
		pendenciaProposta.setUsuario(userInfo != null && userInfo.getUserId() == null ? "" : userInfo.getUserId());
		if (!StringUtils.isBlank(obs)) {
			pendenciaProposta.setObs(obs);
		}
	
		DynamicBean dynaBean = new DynamicBean();
		if (!GeralUtil.isNull(idPendenciaVariacao)) {
			dynaBean.set(GeralConstants.ATTRIBUTE_ID_PENDENCIA, idPendenciaVariacao);
		}else{
			dynaBean.set(GeralConstants.ATTRIBUTE_ID_PENDENCIA, pendencia);
		}
		dynaBean.set(GeralConstants.ATTRIBUTE_ID_VARIACAO,pendenciaVariacao);
		CpRelPendenciasVariacoesBean pendenciasVariacoes = getPendenciasVariacoes(dynaBean);		
		pendenciaProposta.setPendenciaVariacao(pendenciasVariacoes);		
		super.insert(pendenciaProposta, userInfo.getCurrentDbService());		
		atualizaStatusProposta(idProposta, GeralConstants.STATUS_PENDENTE);
	
	}
	
	/**
	 * Método responsável por criar proposta
	 *  
	 * 
	 * @ejb.interface-method view-type = "both" 
	 * @ejb.transaction type="RequiresNew"
	 * @ejb.permission role-name="CRM_GERAR_PENDENCIA_PROPOSTA"
	 */	
	public void inserirPendenciaEnderecoProposta(Long idProposta,
	                                        String statusComercialPayTv, String statusTecnicoPayTv) {
      
		CpPropostaBean proposta = obterProposta(idProposta);
        List pendencias = proposta.getPendenciasProposta();        
        if(!CollectionUtils.isEmpty(pendencias)){
            for (Iterator iter = pendencias.iterator(); iter.hasNext();) {
                CpRelPendenciaPropostaBean pendencia = (CpRelPendenciaPropostaBean) iter.next();
                if(pendencia.getPendencia().getIdPendencia().equals(Long.valueOf(GeralConstants.HP_ANALISE))||
                   pendencia.getPendencia().getIdPendencia().equals(Long.valueOf(GeralConstants.HP_INADIMPLENTE))||
                   pendencia.getPendencia().getIdPendencia().equals(Long.valueOf(GeralConstants.HP_INSTALADO))||
                   pendencia.getPendencia().getIdPendencia().equals(Long.valueOf(GeralConstants.HP_OUTROS))){
                	super.delete(pendencia, getUserSession().getCurrentDbService());
                }
            }
        }
		//Constraint 01 :
		if ("3".equals(statusTecnicoPayTv)) {			
			inserirPendenciaProposta(proposta.getIdProposta(),
			                                        GeralConstants.HP_INSTALADO,
			                                        GeralConstants.ENDERECO_HP_INSTALADO,  null,null);
		}else if("10".equals(statusTecnicoPayTv)){		
			inserirPendenciaProposta(proposta.getIdProposta(),
			                                        GeralConstants.HP_OUTROS,
			                                        GeralConstants.PENDENTE_INSTALACAO, null,null);
		}else if ("1".equals(statusTecnicoPayTv)) {			
			inserirPendenciaProposta(proposta.getIdProposta(), 
			        GeralConstants.HP_ANALISE, GeralConstants.ENDERECO_EM_ANALISE,  null,null);
		}
		
		else if (!"0".equals(statusTecnicoPayTv)) {		
			long idVariacao = -1;
			if ("1".equals(statusTecnicoPayTv)) {
				idVariacao = GeralConstants.ENDERECO_REJEITADO; 
			} else if ("4".equals(statusTecnicoPayTv)) {
				idVariacao = GeralConstants.ENDERECO_BLOQUEADO_ENGENHARIA;
			} else if ("5".equals(statusTecnicoPayTv)) {
				idVariacao = GeralConstants.INSTALACAO_NAO_DISPONIVEL;
			} else if ("6".equals(statusTecnicoPayTv)) {
				idVariacao = GeralConstants.ENDERECO_FORA_AREA;
			} else if ("7".equals(statusTecnicoPayTv)) {
				idVariacao = GeralConstants.MDU_SEM_BACKBONE;
			} else if ("8".equals(statusTecnicoPayTv)) {
				idVariacao = GeralConstants.MDU_EM_DISPONIBILIZACAO;
			} else if ("9".equals(statusTecnicoPayTv)) {
				idVariacao = GeralConstants.MDU_INTERROMPIDO;
			} else if ("11".equals(statusTecnicoPayTv)) {
				idVariacao = GeralConstants.NAO_CONSEGUE_ABRIR_SOLICITACAO;
			}
					
			inserirPendenciaProposta(proposta.getIdProposta(), GeralConstants.HP_OUTROS,
			       GeralConstants.HP_INADIMPLENTE, idVariacao, null);
		}
		
		if ("3".equals(statusComercialPayTv)) {		
			inserirPendenciaProposta(proposta.getIdProposta(), GeralConstants.HP_INADIMPLENTE, 
			                                        GeralConstants.ENDERECO_INADINPLENTE, null, null);
		}
	}
	
	private CpPropostaBean obterProposta(Long idProposta){
		CpPropostaBean proposta = new CpPropostaBean();
		proposta.setIdProposta(idProposta);
		proposta = (CpPropostaBean) super.findByPrimaryKey(proposta);
		return proposta;  
	}

	private CpPendenciasBean obterPendecia(Long idPendencia){
		CpPendenciasBean pendencia = new CpPendenciasBean();
		pendencia.setIdPendencia(idPendencia);
		pendencia = (CpPendenciasBean) super.findByPrimaryKey(pendencia);
		return pendencia;  
	}
	
	
	private CpRelPendenciasVariacoesBean getPendenciasVariacoes(DynamicBean filter) {		
		List list = search(GeralConstants.LST_BY_PENDENCIAS_VARIACOES, filter); 

		CpRelPendenciasVariacoesBean cpRelPendenciasVariacoes = new CpRelPendenciasVariacoesBean();
		
		if (!CollectionUtils.isEmpty(list)) {
			cpRelPendenciasVariacoes = (CpRelPendenciasVariacoesBean)list.get(0);
		}		
		return cpRelPendenciasVariacoes;
	}
	
	/**
     * 
     * @ejb.interface-method view-type = "both" 
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_GERAR_PENDENCIA_PROPOSTA"
     * 
     * @param proposta
     */
	public void insertPendenciaPerfil(Long idProposta) {
        UserInfo userInfo = getUserSession();
        CpRelPendenciaPropostaBean pendenciaProposta = new CpRelPendenciaPropostaBean();
        CpPropostaBean proposta = obterProposta(idProposta);
        pendenciaProposta.setProposta(proposta);
        CpPendenciasBean pendencia = new CpPendenciasBean(GeralConstants.CARACTERISTICA_PERFIL_FALTANDO);
        pendencia = (CpPendenciasBean) super.findByPrimaryKey(pendencia);
        pendenciaProposta.setPendencia(pendencia);
        pendenciaProposta.setDtAbertura(new Date());
        pendenciaProposta.setUsuario(userInfo != null && userInfo.getUserId() != null ? userInfo.getUserId() : "");
        pendenciaProposta.setObs("");
        pendenciaProposta.setPendenciaVariacao(new CpRelPendenciasVariacoesBean(
                                Long.valueOf(GeralConstants.CARACTERISTICA_PERFIL_FALTANDO_VARIACAO)));
        super.insert(pendenciaProposta, userInfo.getCurrentDbService());
        atualizaStatusProposta(idProposta, GeralConstants.STATUS_PENDENTE);
    }
	
	/**   
     * 
     * @ejb.interface-method view-type = "both" 
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_GERAR_PENDENCIA_PROPOSTA" 
     * 
     *
     */
    public void fecharPendenciaProposta(Long  idPendenciaProposta) {
        
        CpRelPendenciaPropostaBean pendenciaProposta = new CpRelPendenciaPropostaBean();
        pendenciaProposta.setIdRelPendenciaProposta(idPendenciaProposta);
        pendenciaProposta = (CpRelPendenciaPropostaBean) findByPrimaryKey(pendenciaProposta);        
        Date dtAtual = new Date();        
        CpRelPendenciasVariacoesBean pendVar = new CpRelPendenciasVariacoesBean();
        pendVar.setIdPendVariacao(Long.valueOf(CONSTANT_99));
        pendVar = (CpRelPendenciasVariacoesBean) findByPrimaryKey(pendVar);
        pendenciaProposta = (CpRelPendenciaPropostaBean) findByPrimaryKey(pendenciaProposta);
        pendenciaProposta.setBackOffice(Integer.valueOf(1));
        pendenciaProposta.setPendenciaVariacao(pendVar);        
        pendenciaProposta.setDtFechamento(dtAtual);      
        update(pendenciaProposta, getUserSession().getCurrentDbService());
    }

    /**
     * 
     * @ejb.interface-method view-type = "both" 
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_GERAR_PENDENCIA_PROPOSTA"  
     * 
     * @param proposta
     */
    public void insertPendenciaReservaTelefoneVoIP(Long idProposta, Integer numeroTotalPontosVoip) {

        CpPropostaBean proposta = obterProposta(idProposta);
        
        // Verificando se já existe uma pendencia de reserva de telefone VoIP
        // ativa para a proposta
        final List lstPendencias = super.search(
                CpRelPendenciaPropostaBean.LST_EXISTS_CP_REL_PENDENCIA_PROPOSTA_RESERVA_VOIP_BY_PROPOSTA, proposta,
                false);

        // verifica se já exista pendência de portabilidade para esta proposta
        final List lstPendenciasTelefoneVoipPortabilidade = super
                .search(
                        CpRelPendenciaPropostaBean.
                        LST_EXISTS_CP_REL_PENDENCIA_PROPOSTA_RESERVA_VOIP_PORT_BY_PROPOSTA_ASSINANTE,
                        proposta, false);

        int qtdeNumPortar = getQtidadeDeNumerosAPortarDisponiveis(proposta);
        
        if (lstPendencias.isEmpty()
                && (getNumeroTotaldePontosVoipNaoReservados(proposta, 
                       numeroTotalPontosVoip) > qtdeNumPortar)) {
            insertPendenciaTelefoneVoip(proposta);
        }

        if (lstPendenciasTelefoneVoipPortabilidade.isEmpty() && (qtdeNumPortar > 0)) {
            insertPendenciaTelefoneVoipPortabilidade(proposta);
        }
    }
    
    /**
     * Busca quantos números foram inseridos no Area Local e não foram reservados ainda
     * @param proposta
     * @return
     */
    private int getQtidadeDeNumerosAPortarDisponiveis(CpPropostaBean proposta) {
        
        List listaDeDispPortabilidade = super.search(
                SnDispPortabilidadeBean.COUNT_DISP_PORTABILIDADE_DISPONIVEIS_BY_PROPOSTA, proposta, false);
        return ((Long) listaDeDispPortabilidade.get(0)).intValue();
    }
    
    /**
     * 
     * @ejb.interface-method view-type = "both" 
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_GERAR_PENDENCIA_PROPOSTA" 
     * 
     * @param proposta
     */
    public void releasePendenciaReservaTelefoneVoIP(Long idProposta, Integer numeroTotalPontosVoip) {
        CpPropostaBean proposta = obterProposta(idProposta);
        int qtdeNumPortar = getQtidadeDeNumerosAPortarDisponiveis(proposta);
        
        if (qtdeNumPortar >= getNumeroTotaldePontosVoipNaoReservados(proposta, numeroTotalPontosVoip)) {
            final List lstPendenciasTelefoneAFinalizar = 
                super.search(CpRelPendenciaPropostaBean.LST_PENDENCIA_RESERVA_VOIP,
                    proposta);
            for (int i = 0; i < lstPendenciasTelefoneAFinalizar.size(); i++) {
                Long idRelPend = (Long) lstPendenciasTelefoneAFinalizar.get(i);
                CpRelPendenciaPropostaBean relPendenciaTelefone = new CpRelPendenciaPropostaBean();
                relPendenciaTelefone.setIdRelPendenciaProposta(idRelPend);
                // Efetuado a liberação da pendência de VoIP da proposta
                releasePendenciaProposta(relPendenciaTelefone);
            }
        }

        if (qtdeNumPortar == 0) {
            final List pendPortFin = super.search(
                    CpRelPendenciaPropostaBean.LST_PENDENCIA_RESERVA_VOIP_PORTABILIDADE, proposta);
            for (int i = 0; i < pendPortFin.size(); i++) {
                Long idRelPend = (Long) pendPortFin.get(i);
                final CpRelPendenciaPropostaBean relPendenciaPortabilidade = new CpRelPendenciaPropostaBean();
                relPendenciaPortabilidade.setIdRelPendenciaProposta(idRelPend);
                // Efetuado a liberação da pendência de VoIP da proposta
                releasePendenciaProposta(relPendenciaPortabilidade);
            }
        }
        
    }

    /**
     * 
     * @ejb.interface-method view-type = "both" 
     * @ejb.transaction type="Required"
     * @ejb.permission role-name="CRM_GERAR_PENDENCIA_PROPOSTA"   
     *
     * @param proposta
     */
    public void insertPendenciaAgendamento(Long idProposta) {
        UserInfo userInfo = getUserSession();
        final CpRelPendenciaPropostaBean pendenciaProposta = new CpRelPendenciaPropostaBean();
        CpPendenciasBean pend = new CpPendenciasBean();
        pend.setIdPendencia(new Long(GeralConstants.PENDENTE_AGENDAMENTO));
        pend = (CpPendenciasBean) super.findByPrimaryKey(pend);
        CpPropostaBean proposta = obterProposta(idProposta);
        pendenciaProposta.setProposta(proposta);
        pendenciaProposta.setPendencia(pend);
        pendenciaProposta.setDtAbertura(new Date());
        pendenciaProposta.setUsuario(userInfo != null && userInfo.getUserId() != null ? userInfo.getUserId() : "");
        pendenciaProposta.setObs("");
        pendenciaProposta.setPendenciaVariacao(new CpRelPendenciasVariacoesBean(Long.valueOf(CONSTANT_25)));        
        super.insert(pendenciaProposta, userInfo.getCurrentDbService());       
        atualizaStatusProposta(proposta.getIdProposta(), GeralConstants.STATUS_PENDENTE_EM_AGENDAMENTO);
        final List lst = proposta.getPendenciasPropostaEmAberto();//insere a pendencia manualmente na lista
        lst.add(pendenciaProposta);//pois o cache nao reconhece a nova pendencia e quando entra na tela
        proposta.setPendenciasPropostaEmAberto(lst);//a pendencia nao aparece
    }
    
    /**
     * insere pendência de portabilidade de telefone voip
     * 
     * @param proposta
     */
    private void insertPendenciaTelefoneVoip(CpPropostaBean proposta) {

        final CpPendenciasBean pendencia = new CpPendenciasBean(GeralConstants.RESERVA_TELEFONICA);
        final CpRelPendenciasVariacoesBean variacaoPend = new CpRelPendenciasVariacoesBean(Long.valueOf(
                GeralConstants.RESERVAR_TELEFONE));

        CpRelPendenciaPropostaBean relPendencia = new CpRelPendenciaPropostaBean();
        relPendencia.setDtAbertura(new Date());
        relPendencia.setPendencia(pendencia);
        relPendencia.setPendenciaVariacao(variacaoPend);
        relPendencia.setProposta(proposta);
        UserInfo userInfo = getUserSession();
        relPendencia.setUsuario(userInfo != null && userInfo.getUserId() != null ? userInfo.getUserId() : "");
        super.insert(relPendencia, getUserSession().getCurrentDbService());
        atualizaStatusProposta(proposta.getIdProposta(), GeralConstants.STATUS_PENDENTE);
    }
   
    /**
     * Busca o número total de pontos voip adicionados e que não tem número reservado ainda.
     * Se numeroTotalPontosVoip for diferente de null, não efetua busca e apenas o retorna.
     * @param proposta
     * @return
     */
    private int getNumeroTotaldePontosVoipNaoReservados(CpPropostaBean proposta, Integer numeroTotalPontosVoip) {

        if (GeralUtil.isNull(numeroTotalPontosVoip) && numeroTotalPontosVoip != 0) {
            DynamicBean prop = new DynamicBean();
            prop.set("proposta", proposta);
            List listaDePontosVoip = super.search(CpPontoBean.LST_QTDADE_PRODUTOS_VOIP_NAO_RESERVADOS, prop, false);
            return listaDePontosVoip.size();
        } else {
            return numeroTotalPontosVoip.intValue();
        }
    }
    
    /**
     * Insere pendência de telefone voip portabilidade
     * @param proposta
     */
    private void insertPendenciaTelefoneVoipPortabilidade(CpPropostaBean proposta) {

        final CpPendenciasBean pendencia = new CpPendenciasBean(GeralConstants.RESERVA_TELEFONICA_PORTABILIDADE);
        final CpRelPendenciasVariacoesBean variacaoPend = new CpRelPendenciasVariacoesBean(Long.valueOf(
                                                GeralConstants.RESERVAR_TELEFONE_PORTABILIDADE));

        CpRelPendenciaPropostaBean relPendencia = new CpRelPendenciaPropostaBean();
        relPendencia.setDtAbertura(new Date());
        relPendencia.setPendencia(pendencia);
        relPendencia.setPendenciaVariacao(variacaoPend);
        relPendencia.setProposta(proposta);
        UserInfo userInfo = getUserSession();
        relPendencia.setUsuario(userInfo != null && userInfo.getUserId() != null ? userInfo.getUserId() : "");

        super.insert(relPendencia, getUserSession().getCurrentDbService());

        atualizaStatusProposta(proposta.getIdProposta(), GeralConstants.STATUS_PENDENTE);
    }
    
    /**
     * Método responsável por criar proposta
     *     
     */
    private void atualizaStatusProposta(Long idProposta, Integer status) {       
        CpPropostaBean proposta = obterProposta(idProposta);
        proposta.setStatusProposta(new CpStatusPropostaBean(status.intValue()));        
        super.update(proposta, getUserSession().getCurrentDbService());
    }
    
    /**
     * Este método persiste a pendência passada como parâmetro pelas telas de pendências e pelo
     * releasePendenciaReservaTelefoneVoIP, fazendo alterações nos parâmetros em casos específicos
     * 
     * 
     *
     * @param pendenciaProposta
     *
     */
    private void releasePendenciaProposta(CpRelPendenciaPropostaBean pendenciaProposta) {
        UserInfo userInfo = getUserSession();
        Date dtAtual = new Date();
        CpRelPendenciasVariacoesBean pendVar = new CpRelPendenciasVariacoesBean();
        CpStatusPropostaBean status = new CpStatusPropostaBean();
        pendVar.setIdPendVariacao(Long.valueOf(CONSTANT_99));
        pendVar = (CpRelPendenciasVariacoesBean) findByPrimaryKey(pendVar);

        CpRelPendenciaPropostaBean pendenciaPropostaSaved = (CpRelPendenciaPropostaBean) 
        getCurrentDAO().findByPrimaryKey(CpRelPendenciaPropostaBean.class,
        pendenciaProposta.getIdRelPendenciaProposta());
        CpPropostaBean proposta = pendenciaPropostaSaved.getProposta();
        proposta = (CpPropostaBean) getCurrentDAO().findByPrimaryKey(CpPropostaBean.class, proposta.getIdProposta());
        pendenciaPropostaSaved.setFnLiberarExcecao(pendenciaProposta.getFnLiberarExcecao());
        pendenciaPropostaSaved.setBackOffice(Integer.valueOf(1));
        pendenciaPropostaSaved.setPendenciaVariacao(pendVar);
        pendenciaPropostaSaved.setUsuario(getUserSession().getUserId());
        if (pendenciaProposta.getDtFechamento() == null)
            pendenciaPropostaSaved.setDtFechamento(dtAtual);
        else
            pendenciaPropostaSaved.setDtFechamento(pendenciaProposta.getDtFechamento());

        pendenciaProposta = (CpRelPendenciaPropostaBean)super.findByPrimaryKey(pendenciaProposta);

        CpAtributoBean atributoProspect = (CpAtributoBean)
        pendenciaProposta.getProposta().getProspect().getAtributos().get(0);
        // Caso origem seja "ASSINANTE DA CONCORRÊNCIA" (IdAtributo = 3) e
        // Caso tipo da pendência seja "ENVIO DE DOCUMENTO" (IdPendencia = 17)
        if (atributoProspect.getIdAtributo().intValue() == GeralConstants.ASSINANTE_CONCORRENCIA &&
            pendenciaProposta.getPendencia().getIdPendencia().longValue() == GeralConstants.ENVIO_DOCUMENTO) {
            // Repassando informacoes do concorrente do prospect ao objeto a ser persistido
            CpRelConcorrenteProspectBean relConcorrenteProspectSaved = new CpRelConcorrenteProspectBean();
            relConcorrenteProspectSaved.setIdRelConcorrenteProspect(pendenciaProposta.getProposta().
            getProspect().getRelConcorrenteProspect().getIdRelConcorrenteProsp());
            relConcorrenteProspectSaved = (CpRelConcorrenteProspectBean)super.
            findByPrimaryKey(relConcorrenteProspectSaved);
            relConcorrenteProspectSaved.setDsPacoteConcorrente(pendenciaProposta.
            getProposta().getProspect().getRelConcorrenteProspect().getDsPcteConcorrente());
            relConcorrenteProspectSaved.setQtPontosConcorrente(pendenciaProposta.
            getProposta().getProspect().getRelConcorrenteProspect().getQtPtosConcorrente());
            relConcorrenteProspectSaved.setVlConcorrente(pendenciaProposta.getProposta().
            getProspect().getRelConcorrenteProspect().getVlConcorrente());

            super.update(relConcorrenteProspectSaved, getUserSession().getCurrentDbService());
        }

        // Persistindo as informações da pendência da proposta
        update(pendenciaPropostaSaved, getUserSession().getCurrentDbService());

        final List list = super.search(CpPendenciasBean.LST_CP_PENDENCIAS_BY_PROPOSTA, proposta);
        if (list.isEmpty()) {

            DelegateMethod method = getDelegate().getDelegateMethod("PropostaEJB.validateDadosProposta",
                    new Object[] {pendenciaProposta.getProposta()}, getUserSession(), false);
            Boolean validation = (Boolean) method.execute();

            if (validation.booleanValue()) {
                status.setIdStatusProposta(Integer.valueOf(GeralConstants.STATUS_PENDENTE_EM_AGENDAMENTO));
                proposta.setDtLiberacao(dtAtual);
            } else {
                status.setIdStatusProposta(Integer.valueOf(GeralConstants.STATUS_EM_ANDAMENTO));
                proposta.setDtLiberacao(null);
            }
            status = (CpStatusPropostaBean) findByPrimaryKey(status);
            proposta.setStatusProposta(status);
            update(proposta, getUserSession().getCurrentDbService());
            CpRelPendenciaPropostaBean newPendPro = new CpRelPendenciaPropostaBean();
            CpPendenciasBean pend = new CpPendenciasBean();
            pend.setIdPendencia(Long.valueOf(1));
            pend = (CpPendenciasBean) find(pend);
            pendVar = new CpRelPendenciasVariacoesBean();
            pendVar.setIdPendVariacao(Long.valueOf(CONSTANT_25));
            pendVar = (CpRelPendenciasVariacoesBean) findByPrimaryKey(pendVar);
            newPendPro.setPendenciaVariacao(pendVar);
            newPendPro.setDtAbertura(dtAtual);
            newPendPro.setProposta(proposta);
            newPendPro.setPendencia(pend);
            newPendPro.setUsuario(userInfo != null && userInfo.getUserId() != null ? userInfo.getUserId() : "");
            insert(newPendPro, userInfo.getCurrentDbService());
        } else {
            if (!proposta.getStatusProposta().getIdStatusProposta().equals(
                Integer.valueOf(GeralConstants.STATUS_ENVIADA)) && !proposta.getStatusProposta().
                getIdStatusProposta().equals(Integer.valueOf(GeralConstants.STATUS_CANCELADA))){
                status.setIdStatusProposta(Integer.valueOf(GeralConstants.STATUS_PENDENTE));
                status = (CpStatusPropostaBean) findByPrimaryKey(status);
                proposta.setStatusProposta(status);
                proposta.setDtLiberacao(null);
                update(proposta, getUserSession().getCurrentDbService());
            }
        }
    }
}
