package br.com.netservicos.netcrmcore.venda.extensaofone.facade.impl;

import static br.com.netservicos.netcrmcore.ordermanagement.constants.OrderManagementConstants.ID_SOLICITACAO_ASS;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.CID_CONTRATO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.DDD_TELEFONE;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.ID_TIPO_SOLIC;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_DDD;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_ID_PONTO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants
	.MANUTENCAO_EXTENSAO_FONE_ID_TIPO_SOLICITACAO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_ISENTO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_NUMERO_EXTENSOES;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_TIPO_SOLICITACAO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_TIPO_SOLIC_PROD;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_USR_CADASTRO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_VAL_ISENTO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NET_HEADER_USERNAME;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NUM_CONTRATO;
import static br.com.netservicos.netcrmcore.venda.constants.VendaConstants.NUM_TELEFONE;
import static br.com.netservicos.netcrmcore.venda.resources.NETCRMVendaResources.ERRO_VALIDACAO;
import static br.com.netservicos.netcrmcore.venda.resources.NETCRMVendaResources.REGISTRO_INCONSISTENTE;
import static br.com.netservicos.netcrmcore.venda.resources.NETCRMVendaResources.REGISTRO_NAO_ENCONTRADO;
import static br.com.netservicos.netcrmcore.venda.resources.NETCRMVendaResources
	.REGISTRO_LOCAL_DOMICILIO_NAO_ENCONTRADO;
import static br.com.netservicos.netcrmcore.venda.resources.NETCRMVendaResources.REGISTRO_PLANO_PGTO_NAO_ENCONTRADO;
import static br.com.netservicos.netcrmcore.venda.util.VendaUtil.getBeanProperty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.netservicos.core.bean.sn.SnLocalizacaoBean;
import br.com.netservicos.core.bean.sn.SnOsBean;
import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.core.bean.sn.SnTelefoneVoipBean;
import br.com.netservicos.core.bean.sn.SnTipoSolicProdBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.exception.business.ValidationException;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.netcrmcore.ordermanagement.solicitacao.facade.SolicitacaoVendaService;
import br.com.netservicos.netcrmcore.venda.core.facade.impl.AbstractNETCRMVendaEJBImpl;
import br.com.netservicos.netcrmcore.venda.extensaofone.facade.ManutencaoExtensaoFoneService;

import br.com.netservicos.netcrmcore.venda.util.VendaUtil;

/**
 * EJB que gerencia a aquisição de extensões fone.
 * 
 * @author mcalegari@artit.com.br
 * 
 * @ejb.bean 
 *		name="ManutencaoExtensaoFoneEJB"
 *		type="Stateless"
 * 		display-name="ManutencaoExtensaoFoneEJB"
 *		description="ManutencaoExtensaoFoneEJB Session EJB Stateless"
 *		view-type="both"
 *		jndi-name="netcrmcore/venda/ejb/ManutencaoExtensaoFoneEJB"
 *		local-jndi-name="netcrmcore/venda/ejb/local/ManutencaoExtensaoFoneEJB"
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
public class ManutencaoExtensaoFoneEJBImpl extends
		AbstractNETCRMVendaEJBImpl implements ManutencaoExtensaoFoneService {

	//LOG
	private static Log logger = LogFactory.getLog(ManutencaoExtensaoFoneEJBImpl.class);
	
	private static final long serialVersionUID = 2377632362787840034L;

	/**
	 * Operação que recebe os dados da extensão, recupera o ponto a partir do telefone informado e 
	 * requisita a criação das solicitações. A operação retorna o id da ordem de campo 
	 * (OS para o legado) gerada pela solicitação de extensão
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="SOLICITAR_EXTENSAO_FONE"
	 */
	public String[] solicitarExtensaoFone(Bean dadosExtensao) {

		this.logar("ManutencaoExtensaoFoneEJBImpl.solicitarExtensaoFone::Inicio - Dados de Entrada: " + 
				"Bean: " + this.montarLogEntrada(dadosExtensao));
		
		String[] idOsList = null;
		List<ValidationMessage> informacoesInvalidasList = new ArrayList<ValidationMessage>();
		
		/*
		 * Busca no banco de dados o idPonto do telefone passado, caso não seja encontrado nenhum
		 * ou o retorno seja nulo então lança exception:
		 */
		
		List ret = searchTelVoipContrato(dadosExtensao);
		
		/*
		 * Com o retorno da tebela "SN_TELEFON_VOIP" do telefone enviado então é verificado
		 * se houve um retorno caso não lança exception, caso sim é verificado se o idPonto
		 * retornado é NULL caso sim então lança mais uma exception, caso esteja tudo OK
		 * então o bean da tabela "SN_SOLICITACAO_ASS" é populado para ser salvo:
		 */
		
		if(ret == null || ret.isEmpty()){
		
			informacoesInvalidasList.add(getValidationMessage(REGISTRO_NAO_ENCONTRADO, 
					new Object[]{getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_DDD), 
						getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE)}));
		
		}else{
			
			SnTelefoneVoipBean snTelefoneVoipBean = (SnTelefoneVoipBean) ret.get(0);
			
			if(snTelefoneVoipBean.getIdPonto() != null){
				
				//Valida se o local domicilio informado existe na tabela SN_LOCALIZACAO
				if(!isLocalDomicilioValido(
						Long.parseLong(getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO)))){
					informacoesInvalidasList.add(getValidationMessage(REGISTRO_LOCAL_DOMICILIO_NAO_ENCONTRADO, 
							new Object[]{getBeanProperty(dadosExtensao, 
									MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO)}));
				}else{
					//Valida se o plano de pagamento informado existe na tabela SN_PLANO_PAGTO
					if(!isPlanoPagtoValido(
							Long.parseLong(getBeanProperty(dadosExtensao, 
									MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO)))){
						informacoesInvalidasList.add(getValidationMessage(REGISTRO_PLANO_PGTO_NAO_ENCONTRADO, 
								new Object[]{getBeanProperty(dadosExtensao, 
										MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO)}));
					}else{
						//Popula dados que não vieram na requisição inicial:
						dadosExtensao.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_ID_PONTO, 
								Integer.toString(snTelefoneVoipBean.getIdPonto()));
						dadosExtensao.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_TIPO_SOLICITACAO, 
								MANUTENCAO_EXTENSAO_FONE_ID_TIPO_SOLICITACAO);
												
						Long idTipoSolicProd = getIdTipoSolicProdByTipoSolic(
								Long.parseLong(MANUTENCAO_EXTENSAO_FONE_ID_TIPO_SOLICITACAO));
						
						dadosExtensao.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_USR_CADASTRO, 
								getBeanProperty(dadosExtensao, NET_HEADER_USERNAME));
						
						dadosExtensao.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_TIPO_SOLIC_PROD, 
								Long.toString(idTipoSolicProd));
						dadosExtensao.addBeanProperty(MANUTENCAO_EXTENSAO_FONE_ISENTO, 
								MANUTENCAO_EXTENSAO_FONE_VAL_ISENTO);
						
						//Pegando o número de extensões para fazer o loop de solicitações
						Long numExtensoes = Long.parseLong(getBeanProperty(dadosExtensao, 
								MANUTENCAO_EXTENSAO_FONE_NUMERO_EXTENSOES));
						
						// lista com as mensagens de erro
						idOsList = new String[numExtensoes.intValue()];
						
						//Insere o número de extensões solicitados:
						for (int i = 0; i < numExtensoes; i++) {							
							SolicitacaoVendaService solicitacaoVendaService = 
								super.getService(SolicitacaoVendaService.class);
							Long idSolicitacao = solicitacaoVendaService.inserirSolicitacaoExtensaoFone(dadosExtensao);
							idOsList[i] = getOsBySolic(idSolicitacao);
						}

					}
				}
			}else{
				informacoesInvalidasList.add(getValidationMessage(REGISTRO_INCONSISTENTE, 
						new Object[]{getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_DDD), 
							getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE)}));
			}
			
		}
		
		// Lança excecao caso tenha ocorrido algum erro de validacao
		verificarErrosValidacao(informacoesInvalidasList);

		this.logar("ManutencaoExtensaoFoneEJBImpl.solicitarExtensaoFone::Fim");
		
		return idOsList;
	}
	
	/**
	 * 
	 * Busca o registro da tabela SnTelefoneVoip através do dados de entrada
	 * 
	 * @param dadosExtensao
	 * @return List
	 * 
	 */
	private List searchTelVoipContrato(Bean dadosExtensao){

		this.logar("ManutencaoExtensaoFoneEJBImpl.searchTelVoipContrato::Inicio");
		
		DynamicBean bean = new DynamicBean();	
		
		bean.put(DDD_TELEFONE, getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_DDD));
		bean.put(NUM_TELEFONE, getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE));
		bean.put(CID_CONTRATO, getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO));
		bean.put(NUM_CONTRATO, getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO));
			
		List<?> ret = super.search(SnTelefoneVoipBean.GET_TELEFONE_VOIP_CONTRATO, bean, false);

		this.logar("ManutencaoExtensaoFoneEJBImpl.searchTelVoipContrato::Fim");

		return ret;
		
	}
	
	/**
	 * 
	 * Busca o idTipoSolicProd através do idTipoSolic
	 * 
	 * @param idTipoSolic
	 * @return Integer
	 * 
	 */
	private Long getIdTipoSolicProdByTipoSolic(Long idTipoSolic){

		this.logar("ManutencaoExtensaoFoneEJBImpl.getIdTipoSolicProdByTipoSolic::Inicio");
		
		DynamicBean bean = new DynamicBean();	
		
		bean.put(ID_TIPO_SOLIC, Long.toString(idTipoSolic));
		
		List<?> ret = super.search(SnTipoSolicProdBean.GET_ID_TIPO_SOLIC_PROD_BY_TIPO_SOLIC, bean, false);
		
		Long idTipoSolicReturn = Long.valueOf(0);
		
		if (ret != null && !ret.isEmpty()){
			idTipoSolicReturn = (Long) ret.get(0);
		}

		this.logar("ManutencaoExtensaoFoneEJBImpl.getIdTipoSolicProdByTipoSolic::Fim");
		
		return idTipoSolicReturn;		
	}
	
	
	/**
	 * 
	 * Monta um Validation Message
	 * 
	 * @param messageCode
	 * @param arguments
	 * @return ValidationMessage
	 * 
	
	 */
	public ValidationMessage getValidationMessage(String messageCode, Object[] arguments) {

		this.logar("ManutencaoExtensaoFoneEJBImpl.getValidationMessage::Inicio");
		
		String message = null;
		if (arguments == null) {
			message = this.getMessage(messageCode);
		} else {
			message = this.getMessage(messageCode, arguments);
		}

		this.logar("ManutencaoExtensaoFoneEJBImpl.getValidationMessage::Fim");
		
		return new ValidationMessage(messageCode, message);
	}
	
	/**
	 * 
	 * Verifica se ha alguma mensagem de erro de validacao encontrada e lança uma exception
	 * contendo as mensagens de erro
	 * 
	 * @param mensagens Lista de ValidationMessage contendo os erros de validacao encontrados
	 * @throws ValidationException Excecao com as mensanges de erros encontrados
	 *	 
	 */
	public void verificarErrosValidacao(List<ValidationMessage> mensagens) throws ValidationException {

		this.logar("ManutencaoExtensaoFoneEJBImpl.verificarErrosValidacao::Inicio");
		
		if ( mensagens != null && !mensagens.isEmpty() ) {
			ValidationException validationException = null;
			
			Iterator<ValidationMessage> it = mensagens.iterator();
			if (it.hasNext()){
				ValidationMessage validationMessage = it.next();

				validationException = new ValidationException(ERRO_VALIDACAO, this.getMessage(ERRO_VALIDACAO), 
						validationMessage, this.getClass().getName()); 
				
				while (it.hasNext()){
					validationMessage = it.next();
					validationException.addValidationMessage(validationMessage);
				}
				
			}
			
			throw validationException;
		}

		this.logar("ManutencaoExtensaoFoneEJBImpl.verificarErrosValidacao::Fim");
		
	}
	
	/**
	 * 
	 * Busca o registro Os através do Id da Solicitação informado
	 * 
	 * @param idSolicitacaoAss
	 * @return String com o ID da OS
	 * 
	 */
	private String getOsBySolic(Long idSolicitacaoAss){

		this.logar("ManutencaoExtensaoFoneEJBImpl.getOsBySolic::Inicio");
		
		DynamicBean bean = new DynamicBean();	
		
		bean.put(ID_SOLICITACAO_ASS, Long.toString(idSolicitacaoAss));
			
		List<?> ret = super.search(SnOsBean.GET_OS_BY_SOLIC, bean, false);
		
		String idOs = "";
		
		if(ret != null && !ret.isEmpty()){
			SnOsBean snOsBean = (SnOsBean) ret.get(0);
			idOs = snOsBean.getCodOs();
		}
		
		this.logar("ManutencaoExtensaoFoneEJBImpl.getOsBySolic::Fim");
		
		return idOs;
		
	}
	
	/**
	 * Verifica se o idLocalizacao informado existe no banco de dados
	 * 
	 * @param idLocalizacao
	 * @return boolean
	 * 
	 */
	private boolean isLocalDomicilioValido(Long idLocalizacao){

		this.logar("ManutencaoExtensaoFoneEJBImpl.isLocalDomicilioValido::Inicio");
		
		SnLocalizacaoBean snLocalizacaoBean = new SnLocalizacaoBean();
		
		snLocalizacaoBean.setIdLocalizacao(idLocalizacao);
		
		SnLocalizacaoBean snLocalizacaoRetorno = (SnLocalizacaoBean) super.findByPrimaryKey(snLocalizacaoBean);
		
		this.logar("ManutencaoExtensaoFoneEJBImpl.isLocalDomicilioValido::Fim");
		
		if(snLocalizacaoRetorno == null){
			return false;
		}
		return true;

	}
	
	/**
	 * Verifica se o idPlanoPagamento informado existe no banco de dados
	 * 
	 * @param idPlanoPagamento
	 * @return boolean
	 * 
	 */
	private boolean isPlanoPagtoValido(Long idPlanoPagamento){

		this.logar("ManutencaoExtensaoFoneEJBImpl.isPlanoPagtoValido::Inicio");
		
		SnPlanoPgtoBean snPlanoPgtoBean = new SnPlanoPgtoBean();
		
		snPlanoPgtoBean.setIdPlanoPgto(idPlanoPagamento);
		
		SnPlanoPgtoBean snPlanoPgtoRetorno = (SnPlanoPgtoBean) super.findByPrimaryKey(snPlanoPgtoBean);

		this.logar("ManutencaoExtensaoFoneEJBImpl.isPlanoPagtoValido::Fim");
		
		if(snPlanoPgtoRetorno == null){
			return false;
		}
		return true;
		
	}
	
	/**
	 * Metodo responsavel em montar log, com os dados da entrada.
	 * @param dadosExtensao
	 * de onde será extraido os dados da entrada
	 * @return
	 * dados para serem logados.
	 */
	
	private String montarLogEntrada(Bean dadosExtensao){
		StringBuffer dados = new StringBuffer();

		dados.append(MANUTENCAO_EXTENSAO_FONE_DDD + ": " + 
				getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_DDD));
		
		dados.append(VendaUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE + ": " + 
				getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE));

		dados.append(VendaUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO + ": " +
				getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO));
		
		dados.append(VendaUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO + ": " +
				getBeanProperty(dadosExtensao,MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO));

		dados.append(VendaUtil.getLineFeed());		
		dados.append(MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO  + ": " + 
				getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO));

		dados.append(VendaUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO + ": " + 
				getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO));

		dados.append(VendaUtil.getLineFeed());		
		dados.append(NET_HEADER_USERNAME + ": " + 
				getBeanProperty(dadosExtensao, NET_HEADER_USERNAME));
						
		dados.append(VendaUtil.getLineFeed());
		dados.append(MANUTENCAO_EXTENSAO_FONE_NUMERO_EXTENSOES + ": " +  
				getBeanProperty(dadosExtensao, MANUTENCAO_EXTENSAO_FONE_NUMERO_EXTENSOES));
						
		return dados.toString();
	}
	
	/**
	 * Metódo responsável em logar 1 texto.
	 * @param texto
	 * texto que será logado.
	 */
	private void logar(String texto){
		if (logger.isDebugEnabled()) {
			logger.debug(texto);		
		}
	}
	
}
