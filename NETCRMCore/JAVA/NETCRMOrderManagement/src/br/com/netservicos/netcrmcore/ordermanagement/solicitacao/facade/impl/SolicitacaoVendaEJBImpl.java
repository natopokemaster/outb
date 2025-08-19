package br.com.netservicos.netcrmcore.ordermanagement.solicitacao.facade.impl;

import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants.ID_SOLICITACAO_ASS;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants.INSTALADO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_FLAG_IMEDIATA;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_ID_PONTO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_ISENTO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_NOME_SOLICITANTE;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_OBSERVACAO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_TIPO_SOLICITACAO;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_TIPO_SOLIC_PROD;
import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants
	.MANUTENCAO_EXTENSAO_FONE_USR_CADASTRO;
import static br.com.netservicos.netcrmcore.ordermanagement.util.OrderManagementUtil.getBeanProperty;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.core.bean.sn.SnContratoKey;
import br.com.netservicos.core.bean.sn.SnOsBean;
import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.core.bean.sn.SnRelPontoExtensaoBean;
import br.com.netservicos.core.bean.sn.SnRelPontoExtensaoKey;
import br.com.netservicos.core.bean.sn.SnSolicitacaoAssBean;
import br.com.netservicos.core.bean.sn.SnTipoSolicBean;
import br.com.netservicos.core.bean.sn.SnTipoSolicProdBean;
import br.com.netservicos.core.bean.sn.SnUsrBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.netcrmcore.ordermanagement.core.facade.impl.AbstractNETCRMOrderManagementEJBImpl;
import br.com.netservicos.netcrmcore.ordermanagement.solicitacao.facade.SolicitacaoVendaService;

import br.com.netservicos.netcrmcore.ordermanagement.util.OrderManagementUtil;

/**
 * EJB responsável pela inserção efetiva de solicitações de extesão fone e atualização
 * dos dados da tabela SnOs e inserção de dados na tabela SnRelPontoExtensao.
 * 
 * @author mcalegari@artit.com.br
 * 
 * @ejb.bean 
 *		name="SolicitacaoVendaEJB"
 *		type="Stateless"
 * 		display-name="SolicitacaoVendaEJB"
 *		description="SolicitacaoVendaEJB Session EJB Stateless"
 *		view-type="both"
 *		jndi-name="netcrmcore/ordermanagement/ejb/SolicitacaoVendaEJB"
 *		local-jndi-name="netcrmcore/ordermanagement/ejb/local/SolicitacaoVendaEJB"
 *		transaction-type="Container"
 * 	
 * @ejb.interface
 *		local-extends="javax.ejb.EJBLocalObject"
 *		extends="javax.ejb.EJBObject"
 *
 * @ejb.home
 *		local-extends="javax.ejb.EJBLocalHome"
 *		extends="javax.ejb.EJBHome"
 *   
 */
public class SolicitacaoVendaEJBImpl extends
AbstractNETCRMOrderManagementEJBImpl implements SolicitacaoVendaService {

	private static final long serialVersionUID = -1246782948626019476L;
	
	//LOG
	private static Log logger = LogFactory.getLog(SolicitacaoVendaEJBImpl.class);
	
	/**
	 * Operação que insere a solicitação de venda na tabela SN_SOLICITACAO_ASS e atualiza a tabela de OS. 
	 */
	private Long inserirSolicitacao(Bean dadosSolicitacao) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.inserirSolicitacao::Inicio - Dados de Entrada: " + 
					"Bean: " + this.montarLogEntrada(dadosSolicitacao));
		}
		this.montarLogEntrada(dadosSolicitacao);
		
		//Popula Bean para inserção de dados no banco
		SnSolicitacaoAssBean snSolicitacaoAssBean = populaSolicitacaoAss(dadosSolicitacao);
		
		//Faz a inserção
		SnSolicitacaoAssBean snSolicAssRetorno = 
			(SnSolicitacaoAssBean) super.insert(snSolicitacaoAssBean, super.getUserSession().getCurrentDbService());

		super.getCurrentDAO().flush();
		
		//Pega o idPonto
		Long idPonto = Long.parseLong(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_ID_PONTO));
		
		//Busca Os através do ID da Solic
		List snOss = getOsBySolic(snSolicAssRetorno.getIdSolicitacaoAss());
		
		//Se encontrar alguma OS então seta o ID Ponto dela e faz update no banco
		if(snOss != null && !snOss.isEmpty()){
			SnOsBean snOsBean = (SnOsBean) snOss.get(0);
			
			snOsBean.setIdPonto(idPonto);
			
			super.update(snOsBean, super.getUserSession().getCurrentDbService());
		}		
		
		//Insere o registro de pontos de extensão:
		insereRelPontoExtensao(idPonto, 
				Integer.parseInt(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO)));

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.inserirSolicitacao::Fim");		
		}
		
		return snSolicAssRetorno.getIdSolicitacaoAss();
	}
	
	/**
	 * Operação que insere a solicitação de venda de extensão na tabela SN_SOLICITACAO_ASS.
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="SOLICITAR_EXTENSAO_FONE"
	 */
	public Long inserirSolicitacaoExtensaoFone(Bean dadosSolicitacao) {
		Long idSolicitacaoAss = inserirSolicitacao(dadosSolicitacao);
		
		return idSolicitacaoAss;
	}
	
	/**
	 * 
	 * Busca o registro Os através do Id da Solicitação informado
	 * 
	 * @param idSolicitacaoAss
	 * @return List com os registros selecionados
	 * 
	 */
	private List getOsBySolic(Long idSolicitacaoAss){

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.getOsBySolic::Inicio - Dados de Entrada: " + 
					"idSolicitacaoAss: " + String.valueOf(idSolicitacaoAss));		
		}
		
		DynamicBean bean = new DynamicBean();	
		
		bean.put(ID_SOLICITACAO_ASS, Long.toString(idSolicitacaoAss));
			
		List<?> ret = super.search(SnOsBean.GET_OS_BY_SOLIC, bean, false);

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.getOsBySolic::Fim");		
		}
		
		return ret;
		
	}
	
	/**
	 * 
	 * Preenche o bean para inserção no banco de dados
	 * 
	 * @param dadosSolicitacao
	 * @return SnSolicitacaoAssBean
	 * 
	 */
	private SnSolicitacaoAssBean populaSolicitacaoAss(Bean dadosSolicitacao){

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.populaSolicitacaoAss::Inicio");		
		}
		
		//Setando dados para inserção da solicitação conforme informações recebidas da entrada:
		SnSolicitacaoAssBean snSolicitacaoAssBean = new SnSolicitacaoAssBean();
		
		//Setando dados do contrato
		SnContratoBean snContratoBean = new SnContratoBean();
		
		SnContratoKey snContratoKey = new SnContratoKey();
		
		snContratoKey.setNumContrato(
				Long.parseLong(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO)));
		snContratoKey.setCidContrato(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO));
		snContratoBean.setCompositeKey(snContratoKey);
		
		snSolicitacaoAssBean.setContrato(snContratoBean);
		//Outros dados
		SnTipoSolicBean snTipoSolicBean = new SnTipoSolicBean();
		snTipoSolicBean.setIdTipoSolic(
				Integer.parseInt(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_TIPO_SOLICITACAO)));
		
		snSolicitacaoAssBean.setTipoSolic(snTipoSolicBean);
		
		snSolicitacaoAssBean.setNomeSolic(
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_NOME_SOLICITANTE));
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		snSolicitacaoAssBean.setDtCadastro(calendar);
		
		SnUsrBean snUsrBean = new SnUsrBean();
		snUsrBean.setIdUsr(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_USR_CADASTRO));
		snSolicitacaoAssBean.setUsrCadastro(snUsrBean);
		
		SnPlanoPgtoBean snPlanoPgtoBean = new SnPlanoPgtoBean(); 
		snPlanoPgtoBean.setIdPlanoPgto(
				Long.parseLong(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO)));
		
		snSolicitacaoAssBean.setPlanoPgto(snPlanoPgtoBean);
		
		SnTipoSolicProdBean snTipoSolicProdBean = new SnTipoSolicProdBean();
		snTipoSolicProdBean.setIdTipoSolicProd(
				Long.parseLong(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_TIPO_SOLIC_PROD)));
		
		snSolicitacaoAssBean.setTipoSolicProd(snTipoSolicProdBean);
		
		Boolean flagImediata = 
			Boolean.parseBoolean(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_FLAG_IMEDIATA));
		
		if(flagImediata.equals(Boolean.TRUE)){
			snSolicitacaoAssBean.setImediata(1);
		} else {
			snSolicitacaoAssBean.setImediata(0);
		}
		
		snSolicitacaoAssBean.setIsento(
				Integer.parseInt(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_ISENTO)));
		
		snSolicitacaoAssBean.setObs(getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_OBSERVACAO));

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.populaSolicitacaoAss::Fim");		
		}
		
		return snSolicitacaoAssBean;
	}
	
	/**
	 * 
	 * Preenche o bean de SnRelPontoExtensao para inserção no banco de dados
	 * 
	 * @param idPonto
	 * @return void
	 * 
	 */
	private void insereRelPontoExtensao(Long idPonto, Integer idLocalizacao){

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.insereRelPontoExtensao::Inicio - Dados de Entrada: " + 
					"idPonto: " + String.valueOf(idPonto) + " - idLocalizacao: " + String.valueOf(idLocalizacao));		
		}
		
		SnRelPontoExtensaoBean snRelPontoExtensaoBean = new SnRelPontoExtensaoBean();
		SnRelPontoExtensaoKey snRelPontoExtensaoKey = new SnRelPontoExtensaoKey();
		
		Long idRelPontoExtensao = getIdRelExtensao(snRelPontoExtensaoBean);
		
		snRelPontoExtensaoKey.setIdExtensao(idRelPontoExtensao);
		
		//Timestamp dataHora = new Timestamp(new Date().getTime());
		Calendar calendarIni = Calendar.getInstance();
		
		snRelPontoExtensaoKey.setDtIni(calendarIni);
				
		Calendar calendar = Calendar.getInstance();
		calendar.set(2049, 11, 30, 0, 0, 0);
		                                        
		snRelPontoExtensaoKey.setDtFim(calendar.getTime());
		
		snRelPontoExtensaoBean.setSnRelPontoExtensaoKey(snRelPontoExtensaoKey);
		
		snRelPontoExtensaoBean.setIdLocalizacao(idLocalizacao);
		
		snRelPontoExtensaoBean.setInstalado(Integer.valueOf(INSTALADO));
		
		snRelPontoExtensaoBean.setIdPonto(idPonto);
		
		super.insert(snRelPontoExtensaoBean, super.getUserSession().getCurrentDbService());

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.insereRelPontoExtensao::Fim");		
		}
		
	}
		
	/**
	 * 
	 * Busca no banco de dados o próximo id da tabela sn_rel_ponto_extensao
	 * 
	 * @param snRelPontoExtensaoBean
	 * @return Long
	 * 
	 */
	private Long getIdRelExtensao(SnRelPontoExtensaoBean snRelPontoExtensaoBean){

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.getIdRelExtensao::Inicio");		
		}

		DynamicBean bean = new DynamicBean(); 
		
		bean.put(snRelPontoExtensaoBean.ID_REL_PONTO_EXTENSAO, null);
			
		List<?> ret = super.search(snRelPontoExtensaoBean.GET_ID_REL_PONTO_EXTENSAO, bean, false);

		if (logger.isDebugEnabled()) {
			logger.debug("SolicitacaoVendaEJBImpl.getIdRelExtensao::Fim");		
		}
		
		if(ret != null && !ret.isEmpty()){
			return (Long) ret.get(0);
		}
		return null;

	}
	
	/**
	 * Metodo responsavel em montar log, com os dados da entrada.
	 * @param dadosExtensao
	 * de onde será extraido os dados da entrada
	 * @return
	 * dados para serem logados.
	 */
	
	private String montarLogEntrada(Bean dadosSolicitacao){
		StringBuffer dados = new StringBuffer();

		dados.append(MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO + ": " + 
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO));
		
		dados.append(OrderManagementUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO + ": " + 
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO));

		dados.append(OrderManagementUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_TIPO_SOLICITACAO + ": " +
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_TIPO_SOLICITACAO));
		
		dados.append(OrderManagementUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO + ": " +
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_NOME_SOLICITANTE));

		dados.append(OrderManagementUtil.getLineFeed());		
		dados.append(MANUTENCAO_EXTENSAO_FONE_USR_CADASTRO  + ": " + 
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_USR_CADASTRO));

		dados.append(OrderManagementUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO + ": " + 
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO));

		dados.append(OrderManagementUtil.getLineFeed());		
		dados.append(MANUTENCAO_EXTENSAO_FONE_TIPO_SOLIC_PROD + ": " + 
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_TIPO_SOLIC_PROD));
						
		dados.append(OrderManagementUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_FLAG_IMEDIATA + ": " +  
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_FLAG_IMEDIATA));
						
		dados.append(OrderManagementUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_ISENTO + ": " +  
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_ISENTO));
		
		dados.append(OrderManagementUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_OBSERVACAO + ": " +  
				getBeanProperty(dadosSolicitacao, MANUTENCAO_EXTENSAO_FONE_OBSERVACAO));
		
		return dados.toString();
	}
	
	
}
