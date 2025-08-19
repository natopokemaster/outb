/*
 * Created on 25/02/2010
 * Project : NETVendaGeral
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.netcrmcore.venda.agendamento.facade.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import br.com.netservicos.core.bean.cp.CpPropostaBean;
import br.com.netservicos.core.bean.cp.CpPropostaServicoBean;
import br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean;
import br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean;
import br.com.netservicos.core.bean.sn.SnParametroBean;
import br.com.netservicos.core.bean.sn.SnParametroKey;
import br.com.netservicos.core.bean.sn.SnPeriodoBean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.core.dao.BatchParameter;
import br.com.netservicos.framework.util.exception.BaseFailureException;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.exception.NETCRMWebServiceException;
import br.com.netservicos.netcrmcore.geral.util.DateUtils;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.AgendaRequisicaoBean;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.AgendaRequisicaoBean.Entidade;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.AgendaRespostaBean;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.PeriodoBean;
import br.com.netservicos.netcrmcore.venda.agendamento.facade.AgendaWorkAssureService;
import br.com.netservicos.netcrmcore.venda.agendamento.facade.AgendamentoService;
import br.com.netservicos.netcrmcore.venda.core.facade.impl.AbstractNETCRMVendaEJBImpl;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

/**
 * <P>
 * <B>Componente EJB responsável por regras de negócio relacionadas da tela de
 * Agendamento.</B><BR>
 * </P>
 * <P>
 * <B> Issues : <BR> 
 * None </B>
 * 
 * @author wellington.maeda
 * @since 20/05/2010
 * @version 1.0
 * @ejb.bean name="AgendamentoEJB" type="Stateless"
 *           display-name="AgendamentoEJB"
 *           description="AgendamentoEJB Session EJB Stateless" view-type="both"
 *           jndi-name="netservicos/netcrmcore/venda/ejb/AgendamentoEJB"
 *           local-jndi
 *           -name="netservicos/netcrmcore/venda/ejb/local/AgendamentoEJB"
 *           transaction-type="Container"
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * @ejb.transaction type="Required"
 * 
 */

public class AgendamentoEJBImpl extends AbstractNETCRMVendaEJBImpl implements AgendamentoService {

	private static final long serialVersionUID = -3973783765268532836L;

	public static final String FUNC_CONS_ROLLOUT = "{? = call PROD_JD.PGSMS_AGENDA_FIELD_SERVICES.FCSMS_CONSULTAR_ROLLOUT(?)}";

	/**
	 * <p>
	 * <b>Método responsável por fazer a validação da Agenda Casada</b><br/>
	 * <p>
	 * 
	 * @param CpPropostaBean
	 *            proposta
	 * @return List<?>
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * 
	 */
	private List<?> validateAgendaCasada(final CpPropostaBean proposta) {

		final CpPropostaBean cpPropostaBean = (CpPropostaBean) super.findByPrimaryKey(proposta);
		SnCidadeOperadoraBean snCidOperadora = new SnCidadeOperadoraBean();
		snCidOperadora.setCidContrato(cpPropostaBean.getCidadeOperadora().getIdCidade());
		snCidOperadora = (SnCidadeOperadoraBean) super.findByPrimaryKey(snCidOperadora);
		final SnParametroBean snParametroBean = new SnParametroBean();
		final SnParametroKey snParametroKey = new SnParametroKey();
		snParametroKey.setNomeParametro(GeralConstants.CASA_AG_SA);		
		snParametroBean.setCompositeKey(snParametroKey);
		return super.search(GeralConstants.LST_PARAMETRO_BY_ID_EMPRESA, snParametroBean, Boolean.FALSE);
	}

	/**
	 * <p>
	 * <b>Método responsável por lista proposta de serviço avançado:</b><br/>
	 * <p>
	 * 
	 * @param CpPropostaBean
	 *            proposta
	 * @return List<?>
	 * @since 20/05/2010
	 * @author wellington.maeda  
	 * 
	 */
	private List<?> retriveSA(final CpPropostaBean proposta) {

		List<?> listPropoServ = this.search(GeralConstants.LST_PROD_SA_INSER, proposta, Boolean.FALSE);
		Boolean validateSA = Boolean.FALSE;
		for (final Iterator<?> it = listPropoServ.iterator(); it.hasNext();) {
			final CpPropostaServicoBean cpPropServ = ((CpPropostaServicoBean) it.next());
			if (cpPropServ.getFcGeracaoOs() != null
					&& cpPropServ.getFcGeracaoOs().trim().equals(GeralConstants.LETRA_S)) {
				validateSA = Boolean.TRUE;
			}
		}
		if (!validateSA.booleanValue()) {
			listPropoServ = new ArrayList<Object>();
		}
		return listPropoServ;
	}

	/**
	 * <p>
	 * <b>Método responsável por fazer o agendamento da proposta WA</b><br/>
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public void agendarPropostaWA(final DynamicBean dynamicBean) {
		final CpPropostaBean propostaBeanForm = (CpPropostaBean) dynamicBean.get(GeralConstants.PROPOSTA);
		final AgendaRequisicaoBean agendaRequisicao = new AgendaRequisicaoBean();
		final AgendaWorkAssureService assureService = getService(AgendaWorkAssureService.class);

		// 1) verifica se o id do periodo que foi criado já esta na proposta
		final CpPropostaBean propBeanPersisted = (CpPropostaBean) super.findByPrimaryKey(propostaBeanForm);

		// 1.1) antes realizada a chamada à proc de liberar agenda porém, toda
		// vez que a consulta de período é feita, a liberação da agenda
		// da proposta já é feita. Devido à isso, foi removida à parte onde se
		// realiza a liberação da agenda.

		// 1.2) Setup de vo´s para a chamada do serviços de agendamento.
		// Segue a seguinte regra:
		// 1.2.1) Quando é necessário agendar só produtos normais, passar apenas
		// 1 entidade com o id da Proposta
		// 1.2.2) Quando é necessário agendar prods normais e serv avanc com a
		// flag de CASA_AGEND_SERVAVANC = false,
		// chamar o serviço passando inicialmente só a proposta e depois chamar
		// o serviço novamente passando o id da proposta serviço e
		// tipo entidade PropostaSA
		// 1.2.3) Quando é necessário agendar prods normais e serv avanc com a
		// flag de CASA_AGEND_SERVAVANC = true,
		// chamar o serviço passando uma entidade de proposta e uma entidade
		// PropostaSA, chamando o serviço de agenda apenas 1 vez

		setDadosComunsProposta(agendaRequisicao, propBeanPersisted, dynamicBean);
		setEntidadesAgendaveisProposta(agendaRequisicao, propBeanPersisted, GeralConstants.LETRA_A);
		setPeriodoAgendar(agendaRequisicao, dynamicBean);

		// 2) Verifica se existe serviços avançado, "resetando" o vo de agenda
		// requição.
		// 2.1)Setup de vo´s para a chamada do serviços de agendamento para
		// serviços avançados
		final Integer idTipoPeriodoSA = (Integer) dynamicBean.get(GeralConstants.ID_TP_PERIODO_SA);

		Boolean agendaNormalSA = Boolean.FALSE;
		if (idTipoPeriodoSA != null) {
			final List<?> retAgendaCasada = validateAgendaCasada(propBeanPersisted);
			agendaNormalSA = Double.valueOf(retAgendaCasada.get(0).toString()).equals(Double.valueOf(0)) ? Boolean.TRUE
					: Boolean.FALSE;

			// Se não casa agenda, agenda os produtos normais, zera a lista de
			// entidades, seta a entidade agendavel PropostaSA e agenda
			// novamente
			if (!agendaNormalSA.booleanValue()) {
				// Agenda os produtos normais
				assureService.agendar(agendaRequisicao);

				// Prepara o VO para o agendamento de Serv Avanc
				agendaRequisicao.getEntidades().clear();
				setPeriodoAgendarServAvanc(agendaRequisicao, dynamicBean);
			}
			setEntidadesAgendaveisPropostaServAvanc(agendaRequisicao, propBeanPersisted, GeralConstants.LETRA_A);
		}

		// 3) Chamada ao serviço para agendar produtos normais ou serv avanc ou
		// ambos, dependendo do parâmetro 'CASA_AGEND_SERVAVANC'
		assureService.agendar(agendaRequisicao);

		// Atualização das pendências das propostas
		final Iterator<?> pendEmAberto = propBeanPersisted.getLstPendenciasProposta().iterator();

		final Date dtFechamento = new Date();

		while (pendEmAberto.hasNext()) {
			final CpRelPendenciaPropostaBean pendenciaProposta = (CpRelPendenciaPropostaBean) pendEmAberto.next();
			pendenciaProposta.setDtFechamento(dtFechamento);
			super.update(pendenciaProposta, getUserSession().getCurrentDbService());
		}
	}

	/**
	 * <p>
	 * <b>Método responsável por liberar o agendamento da proposta</b><br/>
	 * <p>
	 * 
	 * @param CpPropostaBean
	 *            proposta
	 * @since 20/05/10
	 * @author wellington.maeda
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public void liberaData(final Long idProposta) throws NETCRMWebServiceException {
	    
		CpPropostaBean cpProposta = new CpPropostaBean();
		cpProposta.setIdProposta(idProposta);
		cpProposta = (CpPropostaBean) super.findByPrimaryKey(cpProposta);
		final DynamicBean dynamicBean = new DynamicBean();
		dynamicBean.put(GeralConstants.PROPOSTA, cpProposta);

		liberarAgendaPropostaWA(dynamicBean);

	}

	/**
	 * <p>
	 * <b>Método responsável por lista os períodos da agenda do SA Casada
	 * WA:</b><br/>
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @return DynamicBean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public DynamicBean listPeriodosSACasadaWA(final DynamicBean dynamicBean) {
		CpPropostaBean propostaBean = (CpPropostaBean) dynamicBean.get(GeralConstants.PROPOSTA);
		propostaBean = (CpPropostaBean) super.findByPrimaryKey(propostaBean);

		// Consultar Periodos
		DynamicBean retorno = listPeriodosWA(dynamicBean);
		AgendaRespostaBean agendaResposta = (AgendaRespostaBean) retorno.get(GeralConstants.AGENDA_RESPOSTA);
		final List<PeriodoBean> listPeriodos = agendaResposta.getPeriodos();

		// Consulta Periodos SA
		dynamicBean.put(GeralConstants.DATA_AGENDAMENTO, DateUtils.getDataAtual(GeralConstants.FORMATO_DATA_DD_MM_YYY));
		retorno = listPeriodosSAWA(retorno);
		agendaResposta = (AgendaRespostaBean) retorno.get(GeralConstants.AGENDA_RESPOSTA);
		final List<PeriodoBean> listPeriodosSA = agendaResposta.getPeriodos();

		final List<PeriodoBean> listPerSACasadas = new ArrayList<PeriodoBean>();

		for (final PeriodoBean periodoBean : listPeriodos) {
			for (final PeriodoBean periodoSABean : listPeriodosSA) {
				if (periodoBean.getData().toGregorianCalendar().getTime().compareTo(
						periodoSABean.getData().toGregorianCalendar().getTime()) == 0
						&& periodoBean.getIdTipoPeriodo() == periodoSABean.getIdTipoPeriodo()) {
					listPerSACasadas.add(periodoSABean);
				}
			}
		}

		// Seta a combinação das 2 listagens de período no dyna bean
		retorno.put(GeralConstants.LST_AG_SA_CASADA, listPerSACasadas);
		agendaResposta.setPeriodo((ArrayList<PeriodoBean>) listPerSACasadas);
		dynamicBean.set(GeralConstants.AGENDA_RESPOSTA, agendaResposta);

		return retorno;
	}

	/**
	 * <p>
	 * <b>Método responsável por lista períodos SA WA</b><br/>
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @return DynamicBean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public DynamicBean listPeriodosSAWA(final DynamicBean dynamicBean) {
		AgendaRequisicaoBean agendaRequisicao = new AgendaRequisicaoBean();
		CpPropostaBean propostaBeanForm = (CpPropostaBean) dynamicBean.get(GeralConstants.PROPOSTA);
		final CpPropostaBean propostaPersisted = (CpPropostaBean) super.findByPrimaryKey(propostaBeanForm);
		propostaBeanForm = (CpPropostaBean) super.findByPrimaryKey(propostaBeanForm);

		final List<?> listParAgend = validateAgendaCasada(propostaBeanForm);
		final Double valorParametro = Double.valueOf(listParAgend.get(0).toString());

		// Prepara a Consulta Periodos SA
		agendaRequisicao = new AgendaRequisicaoBean();
		setDadosComunsProposta(agendaRequisicao, propostaPersisted, dynamicBean);
		setEntidadesAgendaveisPropostaServAvanc(agendaRequisicao, propostaPersisted, GeralConstants.LETRA_A);
		setDadosConsultarPeriodos(agendaRequisicao);

		final AgendaWorkAssureService assureService = getService(AgendaWorkAssureService.class);
		final AgendaRespostaBean agendaResposta = assureService.consultarPeriodos(agendaRequisicao);

		final List<PeriodoBean> listPeriodoSA = new ArrayList<PeriodoBean>();

		final SimpleDateFormat formatter = new SimpleDateFormat(GeralConstants.FORMATO_DATA_DD_MM_YYY);

		final String dataAgendamento = dynamicBean.get(GeralConstants.DATA_AGENDAMENTO).toString();

		if (dataAgendamento != null && StringUtils.isNotBlank(dataAgendamento)) {
			// Acrecenta dias conforme Parametro retornado na Lista
			// listaParametroAgendamento
			Date dtAgendFormatada;
			try {
				dtAgendFormatada = formatter.parse(dataAgendamento);
			} catch (final java.text.ParseException ex) {
				throw new BaseFailureException(ex);
			}
			final Calendar calendarDtSA = Calendar.getInstance();
			calendarDtSA.setTime(dtAgendFormatada);
			calendarDtSA.add(Calendar.DATE, valorParametro.intValue() - 1);

			// Verifica se possui a Data na Lista de PERIODOS
			for (final PeriodoBean periodoBean : agendaResposta.getPeriodos()) {
				if (calendarDtSA.getTime().before(periodoBean.getData().toGregorianCalendar().getTime())) {
					listPeriodoSA.add(periodoBean);
				}
			}
			dynamicBean.put(GeralConstants.LST_AGENDA_SA, listPeriodoSA); 
			dynamicBean.put(GeralConstants.AGENDA_AREA_SA, agendaResposta.getAgendaArea());
			dynamicBean.put(GeralConstants.AGENDA_CLASSE_SA, agendaResposta.getAgendaClasse());
			dynamicBean.put(GeralConstants.AGENDA_MINUTOS_SA, Integer.valueOf(agendaResposta
					.getMinutosRequeridos()));
			agendaResposta.setPeriodo((ArrayList<PeriodoBean>) listPeriodoSA);
			dynamicBean.set(GeralConstants.AGENDA_RESPOSTA, agendaResposta);
		}else{
			dynamicBean.set(GeralConstants.AGENDA_RESPOSTA, null);
		}

		return dynamicBean;
	}

	/**
	 * <p>
	 * <b>Método responsável por lista período WA</b><br/>
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @return DynamicBean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public DynamicBean listPeriodosWA(final DynamicBean dynamicBean) {
		final AgendaRequisicaoBean agendaRequisicao = new AgendaRequisicaoBean();
		CpPropostaBean propostaBean = (CpPropostaBean) dynamicBean.get(GeralConstants.PROPOSTA);
		propostaBean = (CpPropostaBean) super.findByPrimaryKey(propostaBean);

		setDadosComunsProposta(agendaRequisicao, propostaBean, dynamicBean);
		setDadosConsultarPeriodos(agendaRequisicao);
		setEntidadesAgendaveisProposta(agendaRequisicao, propostaBean, GeralConstants.LETRA_A);

		final AgendaWorkAssureService assureService = getService(AgendaWorkAssureService.class);
		final AgendaRespostaBean agendaResp = assureService.consultarPeriodos(agendaRequisicao);

		dynamicBean.set(GeralConstants.AGENDA_RESPOSTA, agendaResp);

		return dynamicBean;
	}

	/**
	 * <p>
	 * <b>Método responsável por consultar se agendar está bloqueada</b><br/>
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @return Boolean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * @ejb.interface-method view-type = "both"
	 */
	public boolean consultarBloqueio(final DynamicBean dynamicBean) {
		final AgendaRequisicaoBean agendaRequisicao = new AgendaRequisicaoBean();
		CpPropostaBean propostaBean = (CpPropostaBean) dynamicBean.get(GeralConstants.PROPOSTA);
		propostaBean = (CpPropostaBean) super.findByPrimaryKey(propostaBean);
		Boolean retorno = Boolean.FALSE;

		// Verifica se existe agenda para a proposta
		if (propostaBean.getPeriodoAgendamento() != null
				&& propostaBean.getPeriodoAgendamento().getIdTipoPeriodo().intValue() != 0) {
			// 1) Realiza setup de vo´s para a chamada do serviço de liberar,
			// apenas com produtos normais.

			dynamicBean.set(GeralConstants.DATA_AGENDAMENTO, new SimpleDateFormat(
					GeralConstants.FORMATO_DATA_DD_MM_YYY).format(propostaBean.getPeriodoAgendamento().getDt()));

			dynamicBean.set(GeralConstants.ID_TIPO_PERIODO, propostaBean.getPeriodoAgendamento()
					.getIdTipoPeriodo());

			setDadosComunsProposta(agendaRequisicao, propostaBean, dynamicBean);
			setPeriodoAgendarBloqueio(agendaRequisicao, dynamicBean, propostaBean.getPeriodoAgendamento());

			final AgendaRequisicaoBean agendaReqEntid = new AgendaRequisicaoBean();
			setEntidadesAgendaveisProposta(agendaReqEntid, propostaBean, GeralConstants.LETRA_A);
			setEntidadesAgendaveisPropostaServAvanc(agendaReqEntid, propostaBean, GeralConstants.LETRA_A);

			// Este loop esta sendo realizado devido a limitação do serviço de
			// consultar bloqueio não consultar
			// várias entidades ao mesmo tempo.
			for (final Entidade entidade : agendaReqEntid.getEntidades()) {
				// Adiciona a entidade
				agendaRequisicao.adicionarNovaEntidade(entidade);
				final AgendaWorkAssureService assureService = getService(AgendaWorkAssureService.class);

				if (assureService.consultarBloqueio(agendaRequisicao)) {
					retorno = Boolean.TRUE;
				}
				// Remove a entidade ao final do loop
				agendaRequisicao.getEntidades().clear();
			}
		}
		return retorno.booleanValue();
	}

	/**
	 * <p>
	 * <b>Método Auxiliar que seta os dados comuns da requisição do serviço de
	 * AgendaOS para uma entidade do tipo Proposta</b><br/>
	 * <p>
	 * 
	 * @param agendaRequisicao
	 * @param cpPropostaBean
	 * @param dynamicBean
	 */
	private void setDadosComunsProposta(final AgendaRequisicaoBean agendaRequisicao,
			final CpPropostaBean cpPropostaBean, final DynamicBean dynamicBean) {
		agendaRequisicao.setCidContrato(cpPropostaBean.getCidadeOperadora().getIdCidade());

		if (dynamicBean.get(GeralConstants.ENC_SENHA_USED) == null
				|| StringUtils.isBlank(dynamicBean.get(GeralConstants.ENC_SENHA_USED).toString())) {

			agendaRequisicao.setEncaixeSenha(null);
		} else {
			agendaRequisicao.setEncaixeSenha((String) dynamicBean.get(GeralConstants.ENC_SENHA_USED));
		}
	}

	/**
	 * <p>
	 * <b>Método Auxiliar que seta os dados de entidades agendaveis da
	 * requisição do serviço, para proposta</b><br/>
	 * <p>
	 * 
	 * @param agendaRequisicao
	 * @param cpPropostaBean
	 * @param acao
	 */
	private void setEntidadesAgendaveisProposta(final AgendaRequisicaoBean agendaRequisicao,
			final CpPropostaBean cpPropostaBean, final String acao) {
		final Entidade entidade = agendaRequisicao.new Entidade();
		entidade.setIdEntidade(cpPropostaBean.getIdProposta().toString());
		entidade.setIdTipoEntidade(GeralConstants._PROPOSTA);
		entidade.setAcao(acao);
		agendaRequisicao.adicionarNovaEntidade(entidade);
	}

	/**
	 * <p>
	 * <b>Método Auxiliar que seta os dados de período da requisição do serviço
	 * de AgendaOS</b><br/>
	 * <p>
	 * 
	 * @param agendaRequisicao
	 * @param dynamicBean
	 */
	private void setPeriodoAgendar(final AgendaRequisicaoBean agendaRequisicao, final DynamicBean dynamicBean) {
		final Integer idTipoPeriodo = (Integer) dynamicBean.get(GeralConstants.ID_TIPO_PERIODO);
		Date dtAgendamento = null;
		try {
			dtAgendamento = new SimpleDateFormat(GeralConstants.FORMATO_DATA_DD_MM_YYY).parse((String) dynamicBean
					.get(GeralConstants.DATA_AGENDAMENTO));

			final PeriodoBean periodoBean = new PeriodoBean("", new XMLGregorianCalendarImpl(
					setDataCalendar(dtAgendamento)), new XMLGregorianCalendarImpl(new GregorianCalendar()),
					new XMLGregorianCalendarImpl(new GregorianCalendar()), idTipoPeriodo.intValue(), 0, "");
 
			agendaRequisicao.setPeriodoBean(periodoBean);

			final int flagConvAss = dynamicBean.get(GeralConstants.FLAG_CONV_ASS) == null ? 0
					: ((Integer) dynamicBean.get(GeralConstants.FLAG_CONV_ASS)).intValue();

			final int flagForaPadrao = dynamicBean.get(GeralConstants.FLAG_FORA_PADRAO) == null ? 0
					: ((Integer) dynamicBean.get(GeralConstants.FLAG_FORA_PADRAO)).intValue();

			agendaRequisicao.setFlagForaPadrao(Integer.valueOf(flagForaPadrao));
			agendaRequisicao.setFlagConvenienciaAssinante(Integer.valueOf(flagConvAss));
		} catch (final Exception ex) {
			throw new BaseFailureException(ex);
		}
	}

	/**
	 * <p>
	 * <b>Método Auxiliar que seta os dados de período da requisição do serviço
	 * de AgendaOS, para serviços avançados</b><br/>
	 * <p>
	 * 
	 * @param agendaRequisicao
	 * @param dynamicBean
	 */
	private void setPeriodoAgendarServAvanc(final AgendaRequisicaoBean agendaRequisicao,
			final DynamicBean dynamicBean) {
		final Integer idTipoPeriodo = (Integer) dynamicBean.get(GeralConstants.ID_TP_PERIODO_SA);
		Date dataAgendamento = null;
		try {
			dataAgendamento = new SimpleDateFormat(GeralConstants.FORMATO_DATA_DD_MM_YYY)
			.parse((String) dynamicBean.get(GeralConstants.DATA_AGENDTO_SA));
		} catch (final Exception ex) {
			throw new BaseFailureException(ex);
		}
		final PeriodoBean periodoBean = new PeriodoBean("", new XMLGregorianCalendarImpl(
				setDataCalendar(dataAgendamento)), new XMLGregorianCalendarImpl(new GregorianCalendar()),
				new XMLGregorianCalendarImpl(new GregorianCalendar()), idTipoPeriodo.intValue(), 0, "");

		agendaRequisicao.setPeriodoBean(periodoBean);

		final int flagConvAssinante = dynamicBean.get(GeralConstants.FLAG_CONV_ASS_SA) == null ? 0
				: ((Integer) dynamicBean.get(GeralConstants.FLAG_CONV_ASS_SA)).intValue();

		final int flagForaPadrao = dynamicBean.get(GeralConstants.FLAG_FORA_PAD_SA) == null ? 0
				: ((Integer) dynamicBean.get(GeralConstants.FLAG_FORA_PAD_SA)).intValue();

		agendaRequisicao.setFlagForaPadrao(Integer.valueOf(flagForaPadrao));
		agendaRequisicao.setFlagConvenienciaAssinante(Integer.valueOf(flagConvAssinante));

	}

	/**
	 * <p>
	 * <b>Método Auxiliar que seta os dados de entidades agendaveis da
	 * requisição do serviço, para proposta com serv. avanc.</b><br/>
	 * <p>
	 * 
	 * @param agendaRequisicao
	 * @param cpPropostaBean
	 * @param acao
	 */
	private void setEntidadesAgendaveisPropostaServAvanc(final AgendaRequisicaoBean agendaRequisicao,
			final CpPropostaBean cpPropostaBean, final String acao) {
		Entidade entidade = null;

		final List<?> listPropServico = this.search(GeralConstants.LST_PROD_SA_INSER, cpPropostaBean,
				Boolean.FALSE);
		if (listPropServico != null && !listPropServico.isEmpty()) {
			for (final Iterator<?> it = listPropServico.iterator(); it.hasNext();) {
				final CpPropostaServicoBean cpPropServBean = ((CpPropostaServicoBean) it.next());
				if (cpPropServBean.getFcGeracaoOs() != null
						&& cpPropServBean.getFcGeracaoOs().trim().equals(GeralConstants.LETRA_S)) {
					entidade = agendaRequisicao.new Entidade();
					entidade.setIdEntidade(cpPropServBean.getIdPropostaServico().toString());
					entidade.setIdTipoEntidade(GeralConstants.PROPOSTA_SA);
					entidade.setAcao(acao);
					agendaRequisicao.adicionarNovaEntidade(entidade);
					break;
				}
			}
		}
	}

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * <p>
	 * 
	 * @param DynamicBean
	 *            dynamicBean
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * @ejb.interface-method view-type = "both"
	 */

	public void liberarAgendaPropostaWA(final DynamicBean dynamicBean) throws NETCRMWebServiceException {
		final CpPropostaBean propostaBeanForm = (CpPropostaBean) dynamicBean.get(GeralConstants.PROPOSTA);

		// Verifica se existe agenda para a proposta
		if (propostaBeanForm.getPeriodoAgendamento() != null
				&& propostaBeanForm.getPeriodoAgendamento().getIdTipoPeriodo().intValue() != 0) {
			// 1) Realiza setup de vo´s para a chamada do serviço de liberar,
			// apenas com produtos normais.

			dynamicBean.set(GeralConstants.DATA_AGENDAMENTO, new SimpleDateFormat(
					GeralConstants.FORMATO_DATA_DD_MM_YYY)
			.format(propostaBeanForm.getPeriodoAgendamento().getDt()));

			dynamicBean.set(GeralConstants.ID_TIPO_PERIODO, propostaBeanForm.getPeriodoAgendamento()
					.getIdTipoPeriodo());

			final AgendaRequisicaoBean agendaRequisicao = new AgendaRequisicaoBean();

			setDadosComunsProposta(agendaRequisicao, propostaBeanForm, dynamicBean);
			setEntidadesAgendaveisProposta(agendaRequisicao, propostaBeanForm, GeralConstants.LETRA_L);

			setPeriodoLiberarAgenda(agendaRequisicao, propostaBeanForm.getPeriodoAgendamento());

			// Realiza a chamada ao serviço de liberação de agenda. obs: note
			// que nenhuma verificação de serviços avançados é feita pois
			// ao liberar a agenda de uma proposta e esta proposta possuir serv
			// avanc, o agendamento destes produtos deverão
			// ser removidos obrigatóriamente
			final AgendaWorkAssureService assureService = getService(AgendaWorkAssureService.class);
			assureService.liberarAgenda(agendaRequisicao);
		}
	}

	/**
	 * Método Auxiliar que seta os dados comuns da requisição do serviço de
	 * DisponibilidadePeriodo
	 * 
	 * @param agendaRequisicao
	 */
	private void setDadosConsultarPeriodos(final AgendaRequisicaoBean agendaRequisicao) {
		agendaRequisicao.setDataInicial(new XMLGregorianCalendarImpl(new GregorianCalendar()));
		agendaRequisicao.setEmergenciaFlag(Integer.valueOf(0));
		agendaRequisicao.setNumeroDias(Integer.valueOf(10));

	}

	/**
	 * Método Auxiliar que seta os dados de período da requisição do serviço de
	 * AgendaOS
	 * 
	 * @param agendaRequisicao
	 * @param snPeriodoBean
	 */
	private void setPeriodoLiberarAgenda(final AgendaRequisicaoBean agendaRequisicao,
			final SnPeriodoBean snPeriodoBean) {
		final Integer idTipoPeriodo = snPeriodoBean.getIdTipoPeriodo();
		final Date dataAgendamento = new Date(snPeriodoBean.getDt().getTime());
		final PeriodoBean periodoBean = new PeriodoBean("", new XMLGregorianCalendarImpl(
				setDataCalendar(dataAgendamento)), new XMLGregorianCalendarImpl(new GregorianCalendar()),
				new XMLGregorianCalendarImpl(new GregorianCalendar()), idTipoPeriodo.intValue(), 0, "");
		agendaRequisicao.setPeriodoBean(periodoBean);
	}

	/**
	 * Método Auxiliar que seta os dados de período da requisição para o serviço
	 * BloqueioAgenda
	 * 
	 * @param agendaRequisicao
	 * @param dynamicBean
	 */
	private void setPeriodoAgendarBloqueio(final AgendaRequisicaoBean agendaRequisicao,
			final DynamicBean dynamicBean, final SnPeriodoBean snPeriodoBean) {

		final Integer idTipoPeriodo = snPeriodoBean.getIdTipoPeriodo();
		final Date dataAgendamento = new Date(snPeriodoBean.getDt().getTime());
		final PeriodoBean periodoBean = new PeriodoBean("", new XMLGregorianCalendarImpl(
				setDataCalendar(dataAgendamento)), new XMLGregorianCalendarImpl(new GregorianCalendar()),
				new XMLGregorianCalendarImpl(new GregorianCalendar()), idTipoPeriodo.intValue(), 0, "");
		agendaRequisicao.setPeriodoBean(periodoBean);
 
		final int flagConvAssinante = dynamicBean.get(GeralConstants.FLAG_CONV_ASS) == null ? 0
				: ((Integer) dynamicBean.get(GeralConstants.FLAG_CONV_ASS)).intValue();

		final int flagForaPadrao = dynamicBean.get(GeralConstants.FLAG_FORA_PADRAO) == null ? 0
				: ((Integer) dynamicBean.get(GeralConstants.FLAG_FORA_PADRAO)).intValue();

		agendaRequisicao.setFlagForaPadrao(Integer.valueOf(flagForaPadrao));
		agendaRequisicao.setFlagConvenienciaAssinante(Integer.valueOf(flagConvAssinante));
	}

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * <p>
	 * 
	 * @param String
	 *            cidContrato
	 * @return Integer
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * @ejb.interface-method view-type = "both"
	 */

	public Integer getRollout(final String cidContrato) {

		final BatchParameter[] parameters = new BatchParameter[2];
		parameters[0] = new BatchParameter(java.sql.Types.NUMERIC, true);
		parameters[1] = new BatchParameter(cidContrato, java.sql.Types.VARCHAR);
		final List<?> freturn = getCurrentDAO().executeBatch(FUNC_CONS_ROLLOUT, parameters);

		// Function de rollout retorna apenas um resultado sempre (int indicando
		// status de rollout)
		return Integer.valueOf(freturn.get(0).toString());
	}

	/**
	 * <p>
	 * <b>Description:</b><br/>
	 * <p>
	 * 
	 * @param CpPropostaBean
	 *            propostaBean
	 * @return Integer
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * 
	 */
	private Integer getRolloutByProposta(final CpPropostaBean propostaBean) {
		final CpPropostaBean cpProposta = (CpPropostaBean) super.findByPrimaryKey(propostaBean);
		return getRollout(cpProposta.getCidadeOperadora().getIdCidade());
	}

	/**
	 * <p>
	 * <b>Lista período disponivel por data para agendamento:</b><br/>
	 * <p>
	 * 
	 * @param CpPropostaBean
	 *            propostaBean
	 * @return List<PeriodoBean> 
	 * @since 20/05/2010
	 * @author wellington.maeda
	 * 
	 * 
	 */ 
	private List<PeriodoBean> listPeriodoDispByData(final AgendaRespostaBean ageRespostaBean, final Integer dia,
			final Integer mes, final Integer ano) {
		final List<PeriodoBean> listPeriodo = new ArrayList<PeriodoBean>();

		for (final PeriodoBean periodo : ageRespostaBean.getPeriodos()) {
			if (periodo.getData().getDay() == dia.intValue() && periodo.getData().getMonth() == mes.intValue()
					&& periodo.getData().getYear() == ano.intValue()) {

				listPeriodo.add(periodo);
			}
		}
		return listPeriodo;
	}

	/**
	 * <p>
	 * <b>Lista o status disponivel por data para o agendamento:</b><br/>
	 * <p>
	 * 
	 * @param AgendaRespostaBean
	 *            ageRespostaBean
	 * @param Integer
	 *            varMes
	 * @param Integer
	 *            varAno
	 * @return String
	 * 
	 * @since 20/05/2010
	 * @author wellington.maeda 
	 * 
	 *
	 */

	private String listStatusByData(final AgendaRespostaBean ageRespostaBean, final Integer varMes,
			final Integer varAno) {
		final List<String> status = new ArrayList<String>();
		status.add(GeralConstants.NULL);

		for (int i = 1; i <= GeralConstants.NUMERO_TRINTA_UM.intValue(); i += GeralConstants.NUMERO_UM.intValue()) {
			String statusCapacidade = GeralConstants.DOIS;
			if(ageRespostaBean != null){
				for (final PeriodoBean periodo : ageRespostaBean.getPeriodos()) {
					if (periodo.getData().getDay() == i && periodo.getData().getMonth() == varMes.intValue()
							&& periodo.getData().getYear() == varAno.intValue()) {
						statusCapacidade = GeralConstants.LETRA_UM;
						break;
					}
				}
			}
			status.add(statusCapacidade);
		}
		return status.toString();
	}

	private GregorianCalendar setDataCalendar(final Date data) {
		final GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(data);
		return cal;
	}
}
