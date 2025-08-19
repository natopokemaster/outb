package br.com.netservicos.netcrmcore.cliente.contratovenda.facade.impl;

import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.CONTRATO_CIDADE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.CONTRATO_NUM_CONTRATO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_CELULAR;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_COMERCIAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_DDD_CELULAR;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_DDD_COMERCIAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_DDD_RESIDENCIAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_EMAIL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_RAMAL_COMERCIAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_RESIDENCIAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_TELEFONE_CELULAR;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_TELEFONE_COMERCIAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_TELEFONE_RESIDENCIAL;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_CELULAR_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_CELULAR_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_COMERCIAL_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_COMERCIAL_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_RESIDENCIAL_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_RESIDENCIAL_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_EMAIL_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_RAMAL_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_CELULAR_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_CELULAR_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_COMERCIAL_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_COMERCIAL_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_RESIDENCIAL_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_RESIDENCIAL_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ERRO_SERVICO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ERRO_VALIDACAO;
import static br.com.netservicos.netcrmcore.cliente.util.ClienteUtil.getBeanProperty;
import static br.com.netservicos.netcrmcore.cliente.util.ClienteUtil
	.montarLogEntradaDadosContato;
import static br.com.netservicos.netcrmcore.cliente.util.ClienteUtil
	.montarLogEntradaDadosRegistroContato;
import static br.com.netservicos.netcrmcore.cliente.util.ClienteUtil.isUpdating;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import br.com.netservicos.atendimento.evento.registrocontato.IncluirRegistroContato;
import br.com.netservicos.atendimento.registrocontato.ws.service
	.IncluirRegistroContatoWebService;
import br.com.netservicos.core.bean.sn.SnAssinanteBean;
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.core.bean.sn.SnContratoKey;
import br.com.netservicos.core.bean.sn.SnParametroBean;
import br.com.netservicos.core.bean.sn.SnParametroKey;
import br.com.netservicos.core.bean.sn.SnTipoOcorrenciaBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.exception.business.ValidationException;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.framework.exception.system.ResourceException;
import br.com.netservicos.framework.service.webservice.WebServiceFactory;
import br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants;
import br.com.netservicos.netcrmcore.cliente.contratovenda.facade
	.ManutencaoDadosContatoService;
import br.com.netservicos.netcrmcore.cliente.util.ClienteUtil;
import br.com.netservicos.netcrmcore.cliente.util.ValidatorEmail;
import br.com.netservicos.netcrmcore.cliente.core.facade.impl
	.AbstractNETCRMClienteEJBImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_DDD_OUTROS;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_DDD_FAX;

import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_FAX_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_TELEFONE_FAX;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_FAX_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_FAX_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_FAX_FORA_PADRAO;

import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_TELEFONE_OUTROS;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_OUTROS_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_DDD_OUTROS_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_OUTROS_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_CONTATO_TELEFONE_OUTROS_FORA_PADRAO;

import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_OUTROS;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.DADOS_CONTATO_FAX;

/**
 * Implementa o servico de manutencao de dados do contato
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean 
 *		name="ManutencaoDadosContatoEJB"
 *		type="Stateless"
 * 		display-name="ManutencaoDadosContatoEJB"
 *		description="ManutencaoDadosContatoEJB Session EJB Stateless"
 *		view-type="both"
 *		jndi-name="netcrmcore/cliente/ejb/ManutencaoDadosContatoEJB"
 *		local-jndi-name="netcrmcore/cliente/ejb/local/ManutencaoDadosContatoEJB"
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
public class ManutencaoDadosContatoEJBImpl extends
		AbstractNETCRMClienteEJBImpl implements	ManutencaoDadosContatoService {

	private static final String EMAIL_ALTERADO_PARA = "Email alterado para '";
	private static final String TELEFONE_RESIDENCIAL_ALTERADO_PARA = "Telefone Residencial alterado para '";
	private static final String TELEFONE_COMERCIAL_ALTERADO_PARA = "Telefone Comercial alterado para '";
	private static final String RAMAL_ALTERADO_PARA = "Ramal alterado para '";
	private static final String TELEFONE_CELULAR_ALTERADO_PARA = "Telefone Celular alterado para '";
	private static final String ACEITA_CONTATO_ALTERADO_PARA = "Aceita Contato alterado para '";
	private static final String TELEFONE_FAX_ALTERADO_PARA = "Telefone Fax alterado para '";
	private static final String TELEFONE_OUTROS_ALTERADO_PARA = "Telefone Outros alterado para '";
	
	//LOG
	private static Log logger = LogFactory.getLog(ManutencaoDadosCadastraisEJBImpl.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7296056414607636773L;

	/**
	 * Operação que realiza as alterações de dados de contato do Assinante.
	 * A operação recebe o bean contendo a identificação do contrato do 
	 * cliente, além das novas informações de contato.
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="ALTERACAO_DADOS_CONTATO"
	 */
	public void alterarDadosContatoTitular(Bean dadosContato) {

		this.logar("ManutencaoDadosContatoEJBImpl:alterarDadosContatoTitular::Inicio");

		this.logar("Dados de Entrada: " + montarLogEntradaDadosContato(dadosContato));

		// Obtem o assinante
		SnAssinanteBean snAssinante = searchAssinanteByContrato(dadosContato);
		
		// Se encontrar o assinante
		if (snAssinante != null) {
			// Atualiza informacoes do assinante
			String observacoes = atualizaInformacoesAssinante((DynamicBean) dadosContato, snAssinante);
			// Atualiza assinante no banco de dados
			super.update(snAssinante, super.getUserSession().getCurrentDbService());
			
			if ( !"".equals(observacoes)) {
				// Invoca Registro do Contato
				inserirInformacaoRegistroContato(dadosContato, observacoes);
			}
			
		}
		
		this.logar("ManutencaoDadosContatoEJBImpl:alterarDadosContatoTitular::Fim");
		
	}

	/**
	 * Operação que realiza as validações dos dados de contato do Assinante.
	 * A operação recebe o bean contendo a identificação do contrato do
	 *  cliente, além das novas informações de contato. 
	 * 
 	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="ALTERACAO_DADOS_CONTATO"
	 * 
	 */
	public void validarDadosContatoTitular(Bean dadosContato) {

		this.logar("ManutencaoDadosContatoEJBImpl:validarDadosContatoTitular::Inicio");

		this.logar("Dados de Entrada: " + montarLogEntradaDadosContato(dadosContato));

		// Obtem o assinante
		SnAssinanteBean snAssinante = searchAssinanteByContrato(dadosContato);

		// lista com as mensagens de erro
		List<ValidationMessage> informacoesInvalidasList = new ArrayList<ValidationMessage>();

		// Valida informacoes do contato
		validarAssinante(dadosContato, informacoesInvalidasList, snAssinante);
		
		// Lança excecao caso tenha ocorrido algum erro de validacao
		verificarErrosValidacao(informacoesInvalidasList);
		
		this.logar("ManutencaoDadosContatoEJBImpl:validarDadosContatoTitular::Fim");
				
	}
	
	/**
	 * 
	 * Copia as propriedades do bean para o assinante consultado
	 * 
	 * @param dadosContato
	 * @param snAssinante
	 * 
	 * @since 04/01/2010
	 */
	private String atualizaInformacoesAssinante(DynamicBean dadosContato, SnAssinanteBean snAssinante) {

		this.logar("ManutencaoDadosContatoEJBImpl:atualizaInformacoesAssinante::Inicio");
		
		String email = getBeanProperty(dadosContato, DADOS_CONTATO_EMAIL);
		String telRes = ClienteUtil.lpad(getBeanProperty(dadosContato, DADOS_CONTATO_DDD_RESIDENCIAL), "0", 2) 
			+ getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_RESIDENCIAL);
		String telCom = ClienteUtil.lpad(getBeanProperty(dadosContato, DADOS_CONTATO_DDD_COMERCIAL), "0", 2) 
			+ getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_COMERCIAL);
		String ramal = getBeanProperty(dadosContato, DADOS_CONTATO_RAMAL_COMERCIAL);
		String telCel = ClienteUtil.lpad(getBeanProperty(dadosContato, DADOS_CONTATO_DDD_CELULAR), "0", 2) 
			+ getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_CELULAR);
		String telFax = ClienteUtil.lpad(getBeanProperty(dadosContato, DADOS_CONTATO_DDD_FAX), "0", 2) 
			+ getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_FAX);
		String telOut = ClienteUtil.lpad(getBeanProperty(dadosContato, DADOS_CONTATO_DDD_OUTROS), "0", 2) 
			+ getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_OUTROS);

		Integer aceitaContato = 
			(new Boolean(getBeanProperty(dadosContato, ClienteConstants.DADOS_CONTATO_ACEITA_CONTATO)))? 1:0;
		
		Integer emailDefault = (snAssinante.getEmailDefault()==null?0:snAssinante.getEmailDefault());
		
		StringBuffer observacoes = new StringBuffer();
		
		// Adiciona os dados do Bean no assinante
		if (isUpdating(email, snAssinante.getEmail())) {
			snAssinante.setEmail(email);
			observacoes.append(EMAIL_ALTERADO_PARA).append(email).append(ClienteUtil.getLineFeed());
		}
		
		if (isUpdating(telRes, snAssinante.getTelRes())) {
			snAssinante.setTelRes(telRes);
			observacoes.append(TELEFONE_RESIDENCIAL_ALTERADO_PARA).append(telRes).append(ClienteUtil.getLineFeed());
		}
		
		if (isUpdating(telCom, snAssinante.getTelCom())) {
			snAssinante.setTelCom(telCom);
			observacoes.append(TELEFONE_COMERCIAL_ALTERADO_PARA).append(telCom).append(ClienteUtil.getLineFeed());
		}
		
		if (isUpdating(ramal, snAssinante.getRamal())) {
			snAssinante.setRamal(ramal);
			observacoes.append(RAMAL_ALTERADO_PARA).append(ramal).append(ClienteUtil.getLineFeed());
		}
		
		if (isUpdating(telCel, snAssinante.getCcTelCel())) {
			snAssinante.setCcTelCel(telCel);
			observacoes.append(TELEFONE_CELULAR_ALTERADO_PARA).append(telCel).append(ClienteUtil.getLineFeed());
		}

		if (isUpdating(telFax, snAssinante.getFax())) {
			snAssinante.setFax(telFax);
			observacoes.append(TELEFONE_FAX_ALTERADO_PARA).append(telFax).append(ClienteUtil.getLineFeed());
		}
		
		if (isUpdating(telOut, snAssinante.getTelOutros())) {
			snAssinante.setTelOutros(telOut);
			observacoes.append(TELEFONE_OUTROS_ALTERADO_PARA).append(telOut).append(ClienteUtil.getLineFeed());
		}
		
		if (aceitaContato.compareTo(emailDefault) != 0) {
			snAssinante.setEmailDefault(aceitaContato);
			observacoes.append(ACEITA_CONTATO_ALTERADO_PARA).append(aceitaContato).append(ClienteUtil.getLineFeed());
		}

		this.logar("ManutencaoDadosContatoEJBImpl:atualizaInformacoesAssinante::Fim");
		
		return observacoes.toString();
	}
	
	/**
	 * 
	 * Valida dados cadastrais do assinante
	 * 
	 * @param dadosCadastrais
	 * @param mensagens
	 * 
	 * @since 04/01/2010
	 */
	private void validarAssinante(Bean dadosContato, List<ValidationMessage> mensagens, SnAssinanteBean snAssinante) {

		this.logar("ManutencaoDadosContatoEJBImpl:validarAssinante::Inicio");
		
		// Lista de erros enco
		List<ValidationMessage> errorList = mensagens;
		
		// Carrega informacoes do bean
		boolean comInformado = Boolean.parseBoolean(getBeanProperty(dadosContato, DADOS_CONTATO_COMERCIAL));		
		String email = getBeanProperty(dadosContato, DADOS_CONTATO_EMAIL);
		String ramal = getBeanProperty(dadosContato, DADOS_CONTATO_RAMAL_COMERCIAL);
		
		this.validarTelefoneCelular(dadosContato, errorList, snAssinante);
		this.validarTelefoneComercial(dadosContato, errorList, snAssinante);
		this.validarTelefoneResidencial(dadosContato, errorList, snAssinante);
		this.validarTelefoneFax(dadosContato, errorList, snAssinante);
		this.validarTelefoneOutros(dadosContato, errorList, snAssinante);		
		
		if (isUpdating(ramal, snAssinante.getRamal()) && comInformado) {
			// Verificar se o ramal informado apresenta o formato de acordo com o padrão definido no 
			// canônico (SOMENTE PARA TELEFONE COMERCIAL)
			if (informado(ramal) && !validaRamal(ramal)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_RAMAL_FORA_PADRAO, new Object[]{ramal}));
			}
		}

		// Verificar se o endereço de e-mail informado apresenta o formato de acordo com o padrão definido no canônico
		if (isUpdating(email, snAssinante.getEmail()) &&
				informado(email) && !validaEmail(email) ) {
			errorList.add(getValidationMessage(DADOS_CONTATO_EMAIL_FORA_PADRAO, new Object[]{email}));
		}
		
		this.logar("ManutencaoDadosContatoEJBImpl:validarAssinante::Fim");
		
	}

	/**
	 * 
	 * Busca um assinante na base de dados pelo idAssinante
	 * 
	 * @param dadosContato Bean com idAssinante
	 * @return
	 * 
	 * @since 04/01/2010
	 */
	private SnAssinanteBean searchAssinanteByContrato(Bean dadosContato) {

		this.logar("ManutencaoDadosContatoEJBImpl:searchAssinanteByContrato::Inicio");
		
		DynamicBean bean = (DynamicBean) dadosContato;

		// Busca dados do contrato
		Long numContrato = Long.valueOf(bean.get(CONTRATO_NUM_CONTRATO).toString());
		String cidContrato = (String) bean.get(CONTRATO_CIDADE);
		
		// Monta chave para buscar pelo contrato
		SnContratoBean snContrato = new SnContratoBean();
		SnContratoKey key = new SnContratoKey();
		snContrato.setCompositeKey(key);
		key.setNumContrato(numContrato);
		key.setCidContrato(cidContrato);
		
		// Busca o assinante
		Collection<?> ret = super.search(SnAssinanteBean.ASSINANTE_BY_NUMCONTRATO_CIDADE, snContrato);

		this.logar("ManutencaoDadosContatoEJBImpl:searchAssinanteByContrato::Fim");
		
		if (!ret.isEmpty()) {
			return (SnAssinanteBean) ret.iterator().next();
		}
		
		return null;
	}

	/**
	 * 
	 * Busca um parametro pelo nome
	 * 
	 * @param id
	 * @return
	 * 
	 * @since 11/06/2010
	 */
	private SnParametroBean searchParametro(String nomeParametro) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchParametro::Inicio");

		SnParametroBean bean = new SnParametroBean();
		SnParametroKey key = new SnParametroKey();
		key.setNomeParametro(nomeParametro);
		bean.setCompositeKey(key);
		Collection<?> ret = super.search(SnParametroBean.PARAMETRO_BY_NOME_PARAMETRO, bean);
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:searchParametro::Fim");		
		
		if (!ret.isEmpty()) {
			return (SnParametroBean) ret.iterator().next();
		}
		return null;
	}

	/**
	 * 
	 * Busca um tipo ocorrencia pelo ID
	 * 
	 * @param id
	 * @return
	 * 
	 * @since 11/06/2010
	 */
	private SnTipoOcorrenciaBean searchTipoOcorrencia(Long idTipoOcorrencia) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchTipoOcorrencia::Inicio");

		SnTipoOcorrenciaBean bean = new SnTipoOcorrenciaBean();
		bean.setIdTipoOcorrencia(idTipoOcorrencia);
		Collection<?> ret = super.search(SnTipoOcorrenciaBean.BUSCAR_POR_ID, bean);
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:searchTipoOcorrencia::Fim");		
		
		if (!ret.isEmpty()) {
			return (SnTipoOcorrenciaBean) ret.iterator().next();
		}
		return null;
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
	private void verificarErrosValidacao(List<ValidationMessage> mensagens) throws ValidationException {

		this.logar("ManutencaoDadosContatoEJBImpl:verificarErrosValidacao::Inicio");
		
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

		this.logar("ManutencaoDadosContatoEJBImpl:verificarErrosValidacao::Fim");
		
	}
	
	/**
	 * 
	 * Verifica se o campo passado é diferente de nulo e de vazio.
	 * 
	 * @param str Campo a ser verificado
	 * @return true se campo nao é nulo nem vazio.
	 * 
	 * @since 30/12/2009
	 */
	private boolean informado(String str) {
		boolean existe = true;
		
		if (str == null || "".equals(str)) {
			existe = false;
		}
		
		return existe;
	}

	private boolean validaTelefone(String telefone) {
		return telefone.matches("^[0-9]{8,9}$");
	}
	
	private boolean validaDDD(String ddd) {
		return ddd.matches("^[0-9]{2,2}$");
	}
	
	private boolean validaRamal(String ramal) {
		return ramal.matches("^[0-9]{1,4}$");
	}
	
	private boolean validaEmail(String email) {
		return ValidatorEmail.isValid(email);
	}
	
	/**
	 * Operação que finaliza o processo de alteração dos dados cadastrais do
	 * titular para BackOffice e Atendente (apenas informações NÃO restritas). A
	 * operação também realiza a chamada ao serviço Registro, operação incluir.
	 * 
	 */
	private void inserirInformacaoRegistroContato(Bean dadosContato, String observacoes) {

		this.logar("ManutencaoDadosContatoEJBImpl:inserirInformacaoRegistroContato::Inicio");
		
		try {
			// Busca na base de dados o parâmetro com ID do Tipo Evento para Registro Contato
			SnParametroBean snParametro = searchParametro(ClienteConstants.PARAMETRO_REGISTRO_CONTATO);
			// Busca na base de dados o Tipo Ocorrência para Registro Contato
			SnTipoOcorrenciaBean snTipoOcorrencia = 
				searchTipoOcorrencia(snParametro.getVlrParametro().longValue());

			// Gera um Registro Contato
			IncluirRegistroContato incluirRegistroContato = ClienteUtil.getPayloadRegistroContato(
					dadosContato, observacoes, context.getCallerPrincipal().getName(), snTipoOcorrencia);

			// Loga algumas informações do Registro Contato
			this.logar(montarLogEntradaDadosRegistroContato(incluirRegistroContato));

			IncluirRegistroContatoWebService service = 
				WebServiceFactory.getService(
							IncluirRegistroContatoWebService.class,
							context.getCallerPrincipal(),
							ClienteConstants.APPLICATION_CONTEXT_WEBSERVICE_XML);

			// Chama o webservice responsável por inserir um novo Registro Contato
			service.incluirRegistroContato(incluirRegistroContato, ClienteUtil
					.getHeaderWebService(dadosContato));

		} catch (Exception e) {
			if (!e.getMessage().contains("Sucesso")) {

				String mensagem = this
						.getMessage(
								ERRO_SERVICO,
								new Object[] { ClienteConstants.RESOURCE_INCLUIR_REGISTRO_CONTATO });
				ResourceException ex = new ResourceException(ERRO_SERVICO,
						mensagem, this.getClass().getName(), e);
				throw ex;
			}
		}
		
		this.logar("ManutencaoDadosContatoEJBImpl:inserirInformacaoRegistroContato::Fim");
		
	}


	/**
	 * 
	 * Monta um Validation Message
	 * 
	 * @param messageCode
	 * @param arguments
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private ValidationMessage getValidationMessage(String messageCode, Object[] arguments) {

		this.logar("ManutencaoDadosContatoEJBImpl:getValidationMessage::Inicio");
		
		String message = null;
		if (arguments == null) {
			message = this.getMessage(messageCode);
		} else {
			message = this.getMessage(messageCode, arguments);
		}
		
		this.logar("ManutencaoDadosContatoEJBImpl:getValidationMessage::Fim");
		
		return new ValidationMessage(messageCode, message);
	}
	
	/**
	 * Metodo responsavel em realizar a validação dos dados do telefone celular do assinante.
	 * @param dadosContato
	 * Bean que contém as informações do contato do assinante.
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate.
	 */
	private void validarTelefoneCelular(Bean dadosContato, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		// Carrega informacoes do bean
		boolean celularInformado = Boolean.parseBoolean(getBeanProperty(dadosContato, DADOS_CONTATO_CELULAR));
		String dddCelular = getBeanProperty(dadosContato, DADOS_CONTATO_DDD_CELULAR);
		String telCelular = getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_CELULAR);
		
		//CELULAR
		if (celularInformado 
				&& isUpdating(dddCelular+telCelular, snAssinante.getCcTelCel())) {
			// Verifica se o DDD foi informado
			if (!informado(dddCelular)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_CELULAR_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_DDD_CELULAR}));
			}
			// Verificar se o DDD informado apresenta o formato de acordo com o padrão definido no canônico
			if (informado(dddCelular) && !validaDDD(dddCelular)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_CELULAR_FORA_PADRAO, new Object[]{dddCelular}));
			}
			// Verifica se o número do telefone foi informado
			if (!informado(telCelular)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_CELULAR_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_TELEFONE_CELULAR}));
			}
			// Verificar se o número de telefone informado apresenta o formato de acordo com o padrão 
			// definido no canônico
			if (informado(telCelular) && !validaTelefone(telCelular)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_CELULAR_FORA_PADRAO, 
						new Object[]{telCelular}));
			}
		}
	}
	
	/**
	 * Metodo responsavel em realizar a validação dos dados do telefone comercial do assinante.
	 * @param dadosContato
	 * Bean que contém as informações do contato do assinante.
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate.
	 */
	private void validarTelefoneComercial(Bean dadosContato, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		boolean comInformado = Boolean.parseBoolean(getBeanProperty(dadosContato, DADOS_CONTATO_COMERCIAL));
		String dddCom = getBeanProperty(dadosContato, DADOS_CONTATO_DDD_COMERCIAL);
		String telCom = getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_COMERCIAL);
		
		//COMERCIAL
		if (comInformado 
				&& isUpdating(dddCom+telCom, snAssinante.getTelCom())) {
			// Verifica se o DDD foi informado
			if (!informado(dddCom)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_COMERCIAL_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_DDD_COMERCIAL}));
			}
			// Verificar se o DDD informado apresenta o formato de acordo com o padrão definido no canônico
			if (informado(dddCom) && !validaDDD(dddCom)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_COMERCIAL_FORA_PADRAO, 
						new Object[]{dddCom}));
			}
			// Verifica se o número do telefone foi informado
			if (!informado(telCom)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_COMERCIAL_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_TELEFONE_COMERCIAL}));
			}
			// Verificar se o número de telefone informado apresenta o formato de acordo com o padrão 
			// definido no canônico
			if (informado(telCom) && !validaTelefone(telCom)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_COMERCIAL_FORA_PADRAO, 
						new Object[]{telCom}));
			}
		}
		
	}
	
	/**
	 * Metodo responsavel em realizar a validação dos dados do telefone residencial do assinante.
	 * @param dadosContato
	 * Bean que contém as informações do contato do assinante.
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate.
	 */
	private void validarTelefoneResidencial(Bean dadosContato, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		boolean residencialInformado = Boolean.parseBoolean(getBeanProperty(dadosContato, DADOS_CONTATO_RESIDENCIAL));
		String dddResidencial = getBeanProperty(dadosContato, DADOS_CONTATO_DDD_RESIDENCIAL);
		String telResidencial = getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_RESIDENCIAL);
		
		if (residencialInformado && 
				isUpdating(dddResidencial+telResidencial, snAssinante.getTelRes())) {
			// Verifica se o DDD foi informado
			if (!informado(dddResidencial)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_RESIDENCIAL_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_DDD_RESIDENCIAL}));
			}
			// Verificar se o DDD informado apresenta o formato de acordo com o padrão definido no canônico
			if (informado(dddResidencial) && !validaDDD(dddResidencial)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_RESIDENCIAL_FORA_PADRAO, 
						new Object[]{dddResidencial}));
			}
			// Verifica se o número do telefone foi informado
			if (!informado(telResidencial)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_RESIDENCIAL_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_TELEFONE_RESIDENCIAL}));
			}
			// Verificar se o número de telefone informado apresenta o formato de acordo com o 
			// padrão definido no canônico
			if (informado(telResidencial) && !validaTelefone(telResidencial)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_RESIDENCIAL_FORA_PADRAO, 
						new Object[]{telResidencial}));
			}
		}
	}

	/**
	 * Metodo responsavel em realizar a validação dos dados do telefone Fax do assinante.
	 * @param dadosContato
	 * Bean que contém as informações do contato do assinante.
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate.
	 */
	private void validarTelefoneFax(Bean dadosContato, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		// Carrega informacoes do bean
		boolean faxInformado = Boolean.parseBoolean(getBeanProperty(dadosContato, DADOS_CONTATO_FAX));
		String dddFax = getBeanProperty(dadosContato, DADOS_CONTATO_DDD_FAX);
		String telFax = getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_FAX);
		
		//Fax
		if (faxInformado 
				&& isUpdating(dddFax+ telFax, snAssinante.getFax())) {
			// Verifica se o DDD foi informado
			if (!informado(dddFax)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_FAX_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_DDD_FAX}));
			}
			// Verificar se o DDD informado apresenta o formato de acordo com o padrão definido no canônico
			if (informado(dddFax) && !validaDDD(dddFax)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_FAX_FORA_PADRAO, new Object[]{dddFax}));
			}
			// Verifica se o número do telefone foi informado
			if (!informado(telFax)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_FAX_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_TELEFONE_FAX}));
			}
			// Verificar se o número de telefone informado apresenta o formato de acordo com o padrão 
			// definido no canônico
			if (informado(telFax) && !validaTelefone(telFax)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_FAX_FORA_PADRAO, 
						new Object[]{telFax}));
			}
		}
	}

	/**
	 * Metodo responsavel em realizar a validação dos dados do telefone Outros do assinante.
	 * @param dadosContato
	 * Bean que contém as informações do contato do assinante.
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate.
	 */
	private void validarTelefoneOutros(Bean dadosContato, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		// Carrega informacoes do bean
		boolean outrosInformado = Boolean.parseBoolean(getBeanProperty(dadosContato, DADOS_CONTATO_OUTROS));
		String dddOutros = getBeanProperty(dadosContato, DADOS_CONTATO_DDD_OUTROS);
		String telOutros = getBeanProperty(dadosContato, DADOS_CONTATO_TELEFONE_OUTROS);
		
		//Outros
		if (outrosInformado 
				&& isUpdating(dddOutros+ telOutros, snAssinante.getTelOutros())) {
			// Verifica se o DDD foi informado
			if (!informado(dddOutros)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_OUTROS_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_DDD_OUTROS}));
			}
			// Verificar se o DDD informado apresenta o formato de acordo com o padrão definido no canônico
			if (informado(dddOutros) && !validaDDD(dddOutros)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_DDD_OUTROS_FORA_PADRAO, new Object[]{dddOutros}));
			}
			// Verifica se o número do telefone foi informado
			if (!informado(telOutros)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_OUTROS_NAO_INFORMADO, 
						new Object[]{DADOS_CONTATO_TELEFONE_OUTROS}));
			}
			// Verificar se o número de telefone informado apresenta o formato de acordo com o padrão 
			// definido no canônico
			if (informado(telOutros) && !validaTelefone(telOutros)) {
				errorList.add(getValidationMessage(DADOS_CONTATO_TELEFONE_OUTROS_FORA_PADRAO, 
						new Object[]{telOutros}));
			}
		}
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
