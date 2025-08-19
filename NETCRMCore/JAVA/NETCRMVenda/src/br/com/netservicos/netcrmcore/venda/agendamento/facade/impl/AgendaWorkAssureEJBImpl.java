package br.com.netservicos.netcrmcore.venda.agendamento.facade.impl;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.netservicos.framework.service.webservice.WebServiceFactory;
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.constants.GeralWebServicesEnum;
import br.com.netservicos.netcrmcore.geral.constants.ServicoConsumoEnum;
import br.com.netservicos.netcrmcore.geral.exception.NETCRMWebServiceException;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.AgendaRequisicaoBean;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.AgendaRequisicaoBean.Entidade;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.AgendaRespostaBean;
import br.com.netservicos.netcrmcore.venda.agendamento.dto.PeriodoBean;
import br.com.netservicos.netcrmcore.venda.agendamento.facade.AgendaWorkAssureService;
import br.com.netservicos.netcrmcore.venda.agendamento.webservices.AgendaOSWebService;
import br.com.netservicos.netcrmcore.venda.agendamento.webservices.BloqueioAgendaWebService;
import br.com.netservicos.netcrmcore.venda.agendamento.webservices.ConsultarPeriodosWebService;
import br.com.netservicos.netcrmcore.venda.core.facade.impl.AbstractNETCRMVendaEJBImpl;
import br.com.netservicos.netvenda.axis2.ws.types.agenda.AgendarRequest;
import br.com.netservicos.netvenda.axis2.ws.types.agenda.GrupoEntidadeAgendavel;
import br.com.netservicos.netvenda.axis2.ws.types.agenda.Header;
import br.com.netservicos.netvenda.axis2.ws.types.agenda.LiberarAgendaRequest;
import br.com.netservicos.netvenda.axis2.ws.types.agenda.Periodo;
import br.com.netservicos.netvenda.axis2.ws.types.agenda.ReagendarRequest;
import br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.ConsultarBloqueioAgendaRequest;
import br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.ConsultarBloqueioAgendaResponse;
import br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.ConsultarPeriodosRequest;
import br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.ConsultarPeriodosResponse;
import br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.EntidadeAgendavel;
import br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.GrupoEntidadeAgendavel.EntidadesAgendaveis;

/**
 * <P>
 * <B>Componente para agendamento usando WorkAssure como banckend.</B><BR>
 * </P>
 * <P>
 * <B> Issues : <BR>
 * None </B>
 * 
 *@author wellington.maeda
 * @since 13/05/2010
 * @version 1.0
 * @ejb.bean name="AgendaWorkAssureEJB" type="Stateless"
 *           display-name="AgendaWorkAssureEJB"
 *           description="AgendaWorkAssureEJB Session EJB Stateless"
 *           view-type="both"
 *           jndi-name="netservicos/netcrmcore/venda/ejb/AgendaWorkAssureEJB"
 *           local-jndi-name=
 *           "netservicos/netcrmcore/venda/ejb/local/AgendaWorkAssureEJB"
 *           transaction-type="Container"
 * @ejb.interface local-extends="javax.ejb.EJBLocalObject"
 *                extends="javax.ejb.EJBObject"
 * @ejb.home local-extends="javax.ejb.EJBLocalHome" extends="javax.ejb.EJBHome"
 * @ejb.transaction type="Required"
 * 
 */
public class AgendaWorkAssureEJBImpl extends AbstractNETCRMVendaEJBImpl implements AgendaWorkAssureService { 

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    private static final Log LOGGER = LogFactory.getLog(AgendaWorkAssureEJBImpl.class);

    /**
     * <p>
     * <b>Description:</b><br/>
     * Método responsável pela chamada do serviço de Agendar Proposta
     * <p>
     * 
     * @param AgendaRequisicaoBean
     *            req
     * @return boolean
     * @since 14/05/2010
     * @author wellington.maeda
     * 
     * @ejb.interface-method view-type = "both"
     */

    public boolean agendar(final AgendaRequisicaoBean req) throws NETCRMWebServiceException {
        // Set de objetos para o serviço
        final Header request_header = new Header();
        request_header.setUsername(getUserSession().getUserId());
        request_header.setAplicacao(ServicoConsumoEnum.APLICACAO.getString());

        final AgendarRequest agendarRequest = new AgendarRequest();

        final GrupoEntidadeAgendavel gpEntAgendavel = getGrupoEntidadeAgendavel(req);

        gpEntAgendavel.setOrdensCampoCasadas(false);
        agendarRequest.setGrupoEntidadeAgendavel(gpEntAgendavel);
        agendarRequest.setEncaixeSenha(req.getEncaixeSenha());

        agendarRequest.setConveniencia(req.getFlagConvenienciaAssinante());
        agendarRequest.setForaPadrao(req.getFlagForaPadrao());

        final Periodo periodo = getPeriodo(req);

        agendarRequest.setPeriodo(periodo);

        AgendaOSWebService agendaOSWS = null;

        try {            
            agendaOSWS = WebServiceFactory.getService(AgendaOSWebService.class,context.getCallerPrincipal()
                                                    ,GeralConstants.APPLICATION_CONTEXT_WEBSERVICE);
            
            agendaOSWS.agendar(agendarRequest, request_header);
 
        } catch (final Exception ex) {
            LOGGER.error(GeralWebServicesEnum.ERRO_SERV_AGENDA_OS_AGENDAR.getName());
            LOGGER.error(ex.getMessage());
            throw new NETCRMWebServiceException(ex.getCause(), GeralWebServicesEnum.ERRO_SERV_AGENDA_OS_AGENDAR
                    .getName(), ex.getMessage());
        }

        return true;
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * Método responsável pela chamada do serviço de Consultar Periodos
     * <p>
     * 
     * @param AgendaRequisicaoBean
     *            req
     * @return AgendaRespostaBean
     * @since 13/05/2010
     * @author wellington.maeda
     * 
     * @ejb.interface-method view-type = "both"
     */

    public AgendaRespostaBean consultarPeriodos(final AgendaRequisicaoBean req) {
        // Set de objetos para o serviço
        final br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.Header request_header =
            new br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.Header();
        request_header.setUsername(getUserSession().getUserId());
        request_header.setAplicacao(ServicoConsumoEnum.APLICACAO.getString());

        final ConsultarPeriodosRequest consultaPeriodos = new ConsultarPeriodosRequest();

        consultaPeriodos.setDataInicial(req.getDataInicial());
        // consultarPeriodosRequest.setEmergenciaFlag(req.getEmergenciaFlag());
        // Este número está fixo no JSP e foi copiado de Agendamento.jsp
        consultaPeriodos.setNumeroDias(req.getNumeroDias().intValue());
        consultaPeriodos.setEncaixeSenha(req.getEncaixeSenha());

        final br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.GrupoEntidadeAgendavel gpEntAgendavel =
            getGrupoEntidadeAgendavelPeriodo(req);

        gpEntAgendavel.setOrdensCampoCasadas(false);
        consultaPeriodos.setGrupoEntidadeAgendavel(gpEntAgendavel);

        AgendaRespostaBean agendaResp = null;

        // lista periodos WA
        try {            
            final ConsultarPeriodosWebService consPeriodosWS = WebServiceFactory.getService(ConsultarPeriodosWebService.class,context.getCallerPrincipal()
                                                    ,GeralConstants.APPLICATION_CONTEXT_WEBSERVICE);
            final ConsultarPeriodosResponse consPeriodosResp = consPeriodosWS.consultar(consultaPeriodos,
                    request_header);
            agendaResp = getAgendaRespostaBean(consPeriodosResp);

        } catch (final Exception ex) {
            LOGGER.error(GeralWebServicesEnum.ERRO_SERV_DISPONIBILIDADE_PERIODO.getName());
            LOGGER.error(ex.getMessage());
            throw new NETCRMWebServiceException(ex.getCause(),
                    GeralWebServicesEnum.ERRO_SERV_DISPONIBILIDADE_PERIODO.getName(), ex.getMessage());
        }

        return agendaResp;
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * Método responsável pela chamada do serviço de Liberar Agenda
     * <p>
     * 
     * @param AgendaRequisicaoBean
     *            req
     * @return boolean
     * @since 14/05/2010
     * @author wellington.maeda
     * 
     * @ejb.interface-method view-type = "both"
     */
    public boolean liberarAgenda(final AgendaRequisicaoBean req) throws NETCRMWebServiceException {
        // Set de objetos para o serviço
        final Header request_header = new Header();
        request_header.setUsername(getUserSession().getUserId());
        request_header.setAplicacao(ServicoConsumoEnum.APLICACAO.getString());

        final LiberarAgendaRequest liberarAgRequest = new LiberarAgendaRequest();

        final GrupoEntidadeAgendavel gpEntAgendavel = getGrupoEntidadeAgendavel(req);

        liberarAgRequest.setGrupoEntidadeAgendavel(gpEntAgendavel);

        final Periodo periodo = getPeriodo(req);

        liberarAgRequest.setPeriodo(periodo);

        try {          
            
            final AgendaOSWebService agendaOSWS   = WebServiceFactory.getService(AgendaOSWebService.class,context.getCallerPrincipal()
                                                    ,GeralConstants.APPLICATION_CONTEXT_WEBSERVICE);
            
            agendaOSWS.liberar(liberarAgRequest, request_header);

        } catch (final Exception ex) {
            LOGGER.error(GeralWebServicesEnum.ERRO_SERV_AGENDA_OS_LIBERAR.getName());
            LOGGER.error(ex.getMessage());
            throw new NETCRMWebServiceException(ex.getCause(), GeralWebServicesEnum.ERRO_SERV_AGENDA_OS_LIBERAR
                    .getName(), ex.getMessage());
        }

        return true;
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * Método responsável pela chamada do serviço de Reagendar Proposta
     * <p>
     * 
     * @param AgendaRequisicaoBean
     *            req
     * @return boolean
     * @since 14/05/2010
     * @author wellington.maeda
     * 
     * @ejb.interface-method view-type = "both"
     */
    public boolean reagendar(final AgendaRequisicaoBean req) {
        // Set de objetos para o serviço
        final Header request_header = new Header();
        request_header.setUsername(getUserSession().getUserId());
        request_header.setAplicacao(ServicoConsumoEnum.APLICACAO.getString());

        final ReagendarRequest reagendarRequest = new ReagendarRequest();

        final GrupoEntidadeAgendavel gpEntAgendavel = getGrupoEntidadeAgendavel(req);

        reagendarRequest.setGrupoEntidadeAgendavel(gpEntAgendavel);
        reagendarRequest.setIdMotivoReagendamento(req.getIdMotivoReagendamento().intValue());
        reagendarRequest.setConveniencia(req.getFlagConvenienciaAssinante());
        reagendarRequest.setForaPadrao(req.getFlagForaPadrao());

        final Periodo periodo = getPeriodo(req);

        reagendarRequest.setPeriodo(periodo);

        AgendaOSWebService agendaOSWS = null;

        try {
          
            agendaOSWS  = WebServiceFactory.getService(AgendaOSWebService.class,context.getCallerPrincipal()
                                                    ,GeralConstants.APPLICATION_CONTEXT_WEBSERVICE);
            
            agendaOSWS.reagendar(reagendarRequest, request_header);

        } catch (final Exception ex) {
            LOGGER.error(GeralWebServicesEnum.ERRO_SERV_AGENDA_OS_REAGENDAR.getName());
            LOGGER.error(ex.getMessage());
            throw new NETCRMWebServiceException(ex.getCause(), GeralWebServicesEnum.ERRO_SERV_AGENDA_OS_REAGENDAR
                    .getName(), ex.getMessage());
        }

        return true;
    }

    /**
     * <p>
     * <b>Description:</b><br/>
     * Método responsável pela chamada do serviço de Consultar Bloqueio Agenda
     * <p>
     * 
     * @param AgendaRequisicaoBean
     *            req
     * @return boolean
     * @since 14/05/2010
     * @author wellington.maeda
     * 
     * @ejb.interface-method view-type = "both"
     */
    public boolean consultarBloqueio(final AgendaRequisicaoBean req) {
        // Set de objetos para o serviço
        final br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.Header request_header =
            new br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.Header();
        request_header.setUsername(getUserSession().getUserId());
        request_header.setAplicacao(ServicoConsumoEnum.APLICACAO.getString());

        final ConsultarBloqueioAgendaRequest bloqueioRequest = new ConsultarBloqueioAgendaRequest();

        final br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.GrupoEntidadeAgendavel gpEntAgendavel =
            getGrupoEntidadeAgendavelBloqueio(req);
        bloqueioRequest.setGrupoEntidadeAgendavel(gpEntAgendavel);

        final br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.Periodo periodo = getPeriodoBloqueio(req);
        bloqueioRequest.setPeriodo(periodo);

        BloqueioAgendaWebService bloqueioWS = null;
        ConsultarBloqueioAgendaResponse bloqueioResponse = null;
        try {            
            bloqueioWS  = WebServiceFactory.getService(BloqueioAgendaWebService.class,context.getCallerPrincipal()
                                                    ,GeralConstants.APPLICATION_CONTEXT_WEBSERVICE);
            
            bloqueioResponse = bloqueioWS.consultarBloqueioAgenda(bloqueioRequest, request_header);

        } catch (final Exception ex) {
            LOGGER.error(GeralWebServicesEnum.ERRO_SERV_CONSULTA_BLOQUEIO.getName());
            LOGGER.error(ex.getMessage());
            throw new NETCRMWebServiceException(ex.getCause(), GeralWebServicesEnum.ERRO_SERV_CONSULTA_BLOQUEIO
                    .getName(), ex.getMessage());
        }
        return bloqueioResponse.isBloqueado();
    }
    
    /**
     * @param AgendaRequisicaoBean
     *            ar
     * @return GrupoEntidadeAgendavel
     * @throws IllegalArgumentException
     */

    private GrupoEntidadeAgendavel getGrupoEntidadeAgendavel(final AgendaRequisicaoBean agendaReq)
    throws IllegalArgumentException {

        final GrupoEntidadeAgendavel gpEntAgendavel = new GrupoEntidadeAgendavel();
        gpEntAgendavel.setCidadeContrato(agendaReq.getCidContrato());
        gpEntAgendavel.setEntidadesAgendaveis(
                new br.com.netservicos.netvenda.axis2.ws.types.agenda.GrupoEntidadeAgendavel.EntidadesAgendaveis());
        gpEntAgendavel.getEntidadesAgendaveis();

        final Iterator<Entidade> iterEntidades = agendaReq.getEntidades().iterator();
        while (iterEntidades.hasNext()) {
            final Entidade entidade = iterEntidades.next();
            gpEntAgendavel.getEntidadesAgendaveis().getEntidadeAgendavel().add(
                    getEntidadeAgendavelAgenda(entidade));
        }
        return gpEntAgendavel;
    }

    /**
     * @param AgendaRequisicaoBean
     *            ar
     * @return GrupoEntidadeAgendavel
     * @throws IllegalArgumentException
     */

    private br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.GrupoEntidadeAgendavel
    getGrupoEntidadeAgendavelPeriodo(final AgendaRequisicaoBean agendaReq) throws IllegalArgumentException {

        final br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.GrupoEntidadeAgendavel gpEntAgendavel =
            new br.com.netservicos.netvenda.axis2.ws.types.disponibPeriodo.GrupoEntidadeAgendavel();
        gpEntAgendavel.setCidadeContrato(agendaReq.getCidContrato());

        gpEntAgendavel.setEntidadesAgendaveis(new EntidadesAgendaveis());
        gpEntAgendavel.getEntidadesAgendaveis();

        final Iterator<Entidade> iterEntidades = agendaReq.getEntidades().iterator();

        while (iterEntidades.hasNext()) {
            final Entidade entidade = iterEntidades.next();
            gpEntAgendavel.getEntidadesAgendaveis().getEntidadeAgendavel().add(
                    getEntidadeAgendavelPeriodo(entidade));
        }

        return gpEntAgendavel;
    }

    /**
     * @param AgendaRequisicaoBean
     *            ar
     * @return GrupoEntidadeAgendavel
     * @throws IllegalArgumentException
     */
    private br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.GrupoEntidadeAgendavel
    getGrupoEntidadeAgendavelBloqueio(final AgendaRequisicaoBean agendaReq) throws IllegalArgumentException {
        final br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.GrupoEntidadeAgendavel gpEntAgendavel =
            new br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.GrupoEntidadeAgendavel();
        gpEntAgendavel.setCidadeContrato(agendaReq.getCidContrato());
        gpEntAgendavel.setEntidadesAgendaveis(new br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.
                GrupoEntidadeAgendavel.EntidadesAgendaveis());
        gpEntAgendavel.getEntidadesAgendaveis();

        final Iterator<Entidade> iterEntidades = agendaReq.getEntidades().iterator();
        while (iterEntidades.hasNext()) {
            final Entidade entidade = iterEntidades.next();
            gpEntAgendavel.getEntidadesAgendaveis().getEntidadeAgendavel().add(
                    getEntidadeAgendavelBloqueio(entidade));
        }
        return gpEntAgendavel;
    }

    /**
     * @param AgendaRequisicaoBean
     *            req
     * @return Periodo
     */
    private Periodo getPeriodo(final AgendaRequisicaoBean req) {
        final Periodo periodo = new Periodo();

        periodo.setData(req.getPeriodoBean().getData());
        periodo.setEmergenciaFlag(req.getPeriodoBean().getEmergenciaFlag());
        periodo.setIdTipoPeriodo(req.getPeriodoBean().getIdTipoPeriodo());
        return periodo;
    }

    /**
     * @param AgendaRequisicaoBean
     *            req
     * @return Periodo
     */
    private br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.Periodo getPeriodoBloqueio(
            final AgendaRequisicaoBean req) {
        final br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.Periodo periodo =
            new br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.Periodo();

        periodo.setData(req.getPeriodoBean().getData());
        periodo.setEmergenciaFlag(req.getPeriodoBean().getEmergenciaFlag());
        periodo.setIdTipoPeriodo(req.getPeriodoBean().getIdTipoPeriodo());
        return periodo;
    }

    /**
     * @param Entidade
     *            e
     * @return EntidadeAgendavel
     */
    private br.com.netservicos.netvenda.axis2.ws.types.agenda.EntidadeAgendavel getEntidadeAgendavelAgenda(
            final Entidade entidade) throws IllegalArgumentException {
        final br.com.netservicos.netvenda.axis2.ws.types.agenda.EntidadeAgendavel entidAgend =
            new br.com.netservicos.netvenda.axis2.ws.types.agenda.EntidadeAgendavel();
        entidAgend.setIdEntidade(entidade.getIdEntidade());
        entidAgend.setIdTipoEntidade(entidade.getIdTipoEntidade());
        entidAgend.setAcao(entidade.getAcao());
        return entidAgend;
    }

    /**
     * @param Entidade
     *            e
     * @return EntidadeAgendavel
     * @throws IllegalArgumentException
     */
    private EntidadeAgendavel getEntidadeAgendavelPeriodo(final Entidade entidade) throws IllegalArgumentException {
        final EntidadeAgendavel entidAgend = new EntidadeAgendavel();
        entidAgend.setIdEntidade(entidade.getIdEntidade());
        entidAgend.setIdTipoEntidade(entidade.getIdTipoEntidade());
        entidAgend.setAcao(entidade.getAcao());
        return entidAgend;
    }

    /**
     * @param Entidade
     *            e
     * @return EntidadeAgendavel
     * @throws IllegalArgumentException
     */
    private br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.EntidadeAgendavel getEntidadeAgendavelBloqueio(
            final Entidade entidade) throws IllegalArgumentException {
        final br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.EntidadeAgendavel entidAgend =
            new br.com.netservicos.netvenda.axis2.ws.types.bloqueioAgenda.EntidadeAgendavel();
        entidAgend.setIdEntidade(entidade.getIdEntidade());
        entidAgend.setIdTipoEntidade(entidade.getIdTipoEntidade());
        entidAgend.setAcao(entidade.getAcao());
        return entidAgend;
    }

    /**
     * @param ConsultarPeriodosResponse
     *            consPeriodosResp
     * @return AgendaRespostaBean
     */
    private AgendaRespostaBean getAgendaRespostaBean(final ConsultarPeriodosResponse consPeriodosResp) {
        final AgendaRespostaBean agendaResposta = new AgendaRespostaBean();
        agendaResposta.setAgendaArea(consPeriodosResp.getAgendaArea());
        agendaResposta.setMinutosRequeridos(consPeriodosResp.getMinutosRequeridos() == null ? 0 : consPeriodosResp
                .getMinutosRequeridos().intValue());
        agendaResposta.setAgendaClasse(consPeriodosResp.getAgendaClasse());
        agendaResposta.setAgendaSegmento(consPeriodosResp.getAgendaSegmento());
 
        for (int i = 0; i < consPeriodosResp.getPeriodos().getPeriodoAgendamento().size(); i++) {
            final PeriodoBean periodo = new PeriodoBean();
            // ignora os períodos não emergenciais
            if (consPeriodosResp.getPeriodos().getPeriodoAgendamento().get(i).getEmergencial().intValue() == 0) {
                periodo.setDescricao(consPeriodosResp.getPeriodos().getPeriodoAgendamento().get(i).getDescricao());
                periodo.setData(consPeriodosResp.getPeriodos().getPeriodoAgendamento().get(i).getData());
                periodo.setHoraFinal(consPeriodosResp.getPeriodos().getPeriodoAgendamento().get(i).getHoraFinal());
                periodo.setHoraInicial(consPeriodosResp.getPeriodos().getPeriodoAgendamento().get(i)
                        .getHoraInicial());
                periodo.setIdTipoPeriodo(consPeriodosResp.getPeriodos().getPeriodoAgendamento().get(i)
                        .getIdTipoPeriodo().intValue());
                agendaResposta.adicionarNovoPeriodoBean(periodo);
            }
        }

        return agendaResposta;
    }
}
