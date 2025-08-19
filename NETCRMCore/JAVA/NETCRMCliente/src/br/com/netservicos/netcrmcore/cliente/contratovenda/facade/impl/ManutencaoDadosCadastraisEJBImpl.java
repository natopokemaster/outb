package br.com.netservicos.netcrmcore.cliente.contratovenda.facade.impl;

import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_CNPJ;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_CODIGO_SUFRAMA;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_CPF;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_DATA_NASCIMENTO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_ESCOLARIDADE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_ESTADO_CIVIL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_ESTRANGEIRO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_INSCRICAO_ESTADUAL;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_NOME_MAE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_NOME_PAI;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_NOME_TITULAR;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_ORGAO_EXPEDIDOR;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_PASSAPORTE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_PROFISSAO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_RG;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_SEXO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_TIPO_PESSOA_FISICA;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.ASSINANTE_TIPO_PESSOA_JURIDICA;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.CONTRATO_CIDADE;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.CONTRATO_NUM_CONTRATO;
import static br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants
	.VALOR_ISENTO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.CNPJ_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.CNPJ_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.CPF_ATUAL_INADIMPLENTE;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.CPF_FORA_DO_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.CPF_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.CPF_NOVO_INADIMPLENTE;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DADOS_PF_COM_PJ;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DATA_NASCIMENTO_INVALIDA;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.DATA_NASCIMENTO_NAO_INFORMADA;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ERRO_SERVICO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ERRO_VALIDACAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ESCOLARIDADE_INEXISTENTE;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ESTADO_CIVIL_INEXISTENTE;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ESTADO_CIVIL_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.INSCRICAO_ESTADUAL_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.NOME_TITULAR_OBRIGATORIO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ORGAO_EXPEDIDOR_FORA_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ORGAO_EXPEDIDOR_PF_INEXISTENTE;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ORGAO_EXPEDIDOR_PF_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.ORGAO_EXPEDIDOR_PJ_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.PROFISSAO_INEXISTENTE;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.PROFISSAO_NAO_INFORMADA;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.RG_FORA_DO_PADRAO;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.SEXO_INEXISTENTE;
import static br.com.netservicos.netcrmcore.cliente.resources.NETCRMClienteResources
	.SEXO_NAO_INFORMADO;
import static br.com.netservicos.netcrmcore.cliente.util.ClienteUtil.getBeanProperty;
import static br.com.netservicos.netcrmcore.cliente.util.ClienteUtil
	.montarLogEntradaDadosCadastrais;
import static br.com.netservicos.netcrmcore.cliente.util.ClienteUtil
	.montarLogEntradaDadosRegistroContato;
import static br.com.netservicos.netcrmcore.cliente.util.ClienteUtil.isUpdating;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.netservicos.atendimento.evento.registrocontato
	.IncluirRegistroContato;
import br.com.netservicos.atendimento.evento.requisicaointerna
	.IncluirRequisicaoInterna;
import br.com.netservicos.atendimento.registrocontato.ws.service
	.IncluirRegistroContatoWebService;
import br.com.netservicos.atendimento.requisicaointerna.ws.service
	.IncluirRequisicaoInternaWebService;
import br.com.netservicos.core.bean.sn.SnAssinanteBean;
import br.com.netservicos.core.bean.sn.SnCPFInadimplenteBean;
import br.com.netservicos.core.bean.sn.SnContratoBean;
import br.com.netservicos.core.bean.sn.SnContratoKey;
import br.com.netservicos.core.bean.sn.SnEscolaridadeBean;
import br.com.netservicos.core.bean.sn.SnEstadoCivilBean;
import br.com.netservicos.core.bean.sn.SnOrgaoExpedidorBean;
import br.com.netservicos.core.bean.sn.SnParametroBean;
import br.com.netservicos.core.bean.sn.SnParametroKey;
import br.com.netservicos.core.bean.sn.SnProfissaoBean;
import br.com.netservicos.core.bean.sn.SnSexoBean;
import br.com.netservicos.core.bean.sn.SnTipoOcorrenciaBean;
import br.com.netservicos.core.bean.sn.SnTipoPessoaBean;
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.exception.business.ValidationException;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.framework.exception.system.ResourceException;
import br.com.netservicos.framework.service.webservice.WebServiceFactory;
import br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants;
import br.com.netservicos.netcrmcore.cliente.contratovenda.facade
	.ManutencaoDadosCadastraisService;
import br.com.netservicos.netcrmcore.cliente.core.facade.impl
	.AbstractNETCRMClienteEJBImpl;
import br.com.netservicos.netcrmcore.cliente.util.ClienteUtil;
import br.com.netservicos.netcrmcore.cliente.util.DateValidator;
import br.com.netservicos.netcrmcore.cliente.util.ValidadorCPFOrCNPJ;
import br.com.netservicos.netcrmcore.cliente.util.ValidatorInscricaoEstadual;

/**
 * EJB responsável pela validação / alteração dos dados cadastrais do cliente.
 * 
 * @author gmello@artit.com.br
 * 
 * @ejb.bean 
 *		name="ManutencaoDadosCadastraisEJB"
 *		type="Stateless"
 * 		display-name="ManutencaoDadosCadastraisEJB"
 *		description="ManutencaoDadosCadastraisEJB Session EJB Stateless"
 *		view-type="both"
 *		jndi-name="netcrmcore/cliente/ejb/ManutencaoDadosCadastraisEJB"
 *		local-jndi-name="netcrmcore/cliente/ejb/local/ManutencaoDadosCadastraisEJB"
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
public class ManutencaoDadosCadastraisEJBImpl extends
		AbstractNETCRMClienteEJBImpl implements ManutencaoDadosCadastraisService {

	//LOG
	private static Log logger = LogFactory.getLog(ManutencaoDadosCadastraisEJBImpl.class);
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1713492184667436066L;
	
	private static final String ESTADO_CIVIL_LGPD = "6";

	/**
	 * Operação que realiza as alterações dos dados cadastrais do Assinante. A
	 * operação recebe o bean contendo a identificação do contrato do cliente,
	 * além das novas informações cadastrais.
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="ALTERACAO_DADOS_CADASTRAIS_LIVRES"
	 * @ejb.permission role-name="ALTERACAO_DADOS_CADASTRAIS_RESTRITOS"
	 */
	public void alterarDadosCadastraisTitular(Bean dadosCadastrais) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:alterarDadosCadastraisTitular::Inicio");

		this.logar("Dados de Entrada: " + montarLogEntradaDadosCadastrais(dadosCadastrais));

		// Obtem o assinante
		SnAssinanteBean snAssinante = searchAssinanteByContrato(dadosCadastrais);
		
		// Se operador é Backoffice
		if (isBackOffice()) {
			processarAtualizacaoBackOffice(dadosCadastrais, snAssinante);
		}
		// Se operador é Atendente
		else if (isAtendente()) {
			processarAtualizacaoAtendente(dadosCadastrais, snAssinante);
		}

		this.logar("ManutencaoDadosCadastraisEJBImpl:alterarDadosCadastraisTitular::Fim");		
	}

	/**
	 * Operação que finaliza o processo de alteração dos dados cadastrais do
	 * titular para BackOffice e Atendente (apenas informações NÃO restritas). A
	 * operação também realiza a chamada ao serviço Registro, operação incluir.
	 * 
	 */
	private void inserirInformacaoRegistroContato(Bean dadosCadastrais, String observacao) {
	
		this.logar("ManutencaoDadosCadastraisEJBImpl:inserirInformacaoRegistroContato::Inicio");
		
		try {
			// Busca na base de dados o parâmetro com ID do Tipo Evento para Registro Contato
			SnParametroBean snParametro = searchParametro(ClienteConstants.PARAMETRO_REGISTRO_CONTATO);
			// Busca na base de dados o Tipo Ocorrência para Registro Contato
			SnTipoOcorrenciaBean snTipoOcorrencia = 
				searchTipoOcorrencia(snParametro.getVlrParametro().longValue());

			// Gera um Registro Contato
			IncluirRegistroContato incluirRegistroContato = ClienteUtil.getPayloadRegistroContato(
				dadosCadastrais, observacao, context.getCallerPrincipal().getName(), snTipoOcorrencia);

			// Loga algumas informações do Registro Contato
			this.logar(montarLogEntradaDadosRegistroContato(incluirRegistroContato));

			IncluirRegistroContatoWebService service = WebServiceFactory
					.getService(
							IncluirRegistroContatoWebService.class,
							context.getCallerPrincipal(),
							ClienteConstants.APPLICATION_CONTEXT_WEBSERVICE_XML);

			// Chama o webservice responsável por inserir um novo Registro Contato
			service.incluirRegistroContato(incluirRegistroContato, ClienteUtil
					.getHeaderWebService(dadosCadastrais));
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
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:inserirInformacaoRegistroContato::Fim");		
	}

	/**
	 * Operação que realiza as validações dos dados cadastrais do Assinante. A
	 * operação recebe o bean contendo a identificação do contrato do cliente,
	 * além das novas informações cadastrais.
	 * 
	 * @ejb.interface-method view-type = "both"
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="ALTERACAO_DADOS_CADASTRAIS_LIVRES"
	 * @ejb.permission role-name="ALTERACAO_DADOS_CADASTRAIS_RESTRITOS"
	 */	
	public void validarDadosCadastraisTitular(Bean dadosCadastrais) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:validarDadosCadastraisTitular::Inicio");

		this.logar("Dados de Entrada: " + montarLogEntradaDadosCadastrais(dadosCadastrais));

		// Obtem o assinante
		SnAssinanteBean snAssinante = searchAssinanteByContrato(dadosCadastrais);
		
		// lista com as mensagens de erro
		List<ValidationMessage> informacoesInvalidasList = new ArrayList<ValidationMessage>();
		
		// Valida informacoes gerais do bean
		validarInformacoesGerais(dadosCadastrais, snAssinante, informacoesInvalidasList);
		
		// Verifica se assinante é pessoa fisica ou juridica
		if (isPessoaFisica(snAssinante)) {
			// Pessoa Fisica
			// Valida os dados de pessoa fisica
			validarDadosPessoaFisica(dadosCadastrais, informacoesInvalidasList, snAssinante);
			
			// Caso o CPF tenha sido alterado pelo usuário, e o perfil atual seja BackOffice, então, 
			// tanto o CPF atual, quano o novo, deverão ser valiadados quanto a inadimplencia
			if (isBackOffice()) {
				// CPF atualmente no cadastro
				String cpfAntigo = snAssinante.getCpf();
				// CPF que se deseja inserir no cadastro
				String cpfNovo = getBeanProperty(dadosCadastrais, ASSINANTE_CPF);
				
				// Verificar se o CPF atual encontra-se inadimplente
				if (cpfInadimplente(cpfAntigo)) {
					informacoesInvalidasList.add(getValidationMessage(CPF_ATUAL_INADIMPLENTE, new Object[]{cpfAntigo}));
				}

				// Verificar se o novo CPF informado encontra-se inadimplente
				if (cpfInadimplente(cpfNovo)) {
					informacoesInvalidasList.add(getValidationMessage(CPF_NOVO_INADIMPLENTE, new Object[]{cpfNovo}));
				}
			}
		}
		// Pessoa Juridica
		else {
			// Valida os dados de pessoa juridica
			validarDadosPessoaJuridica(dadosCadastrais, informacoesInvalidasList, snAssinante);
		}
		
		// Lança excecao caso tenha ocorrido algum erro de validacao
		verificarErrosValidacao(informacoesInvalidasList);
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarDadosCadastraisTitular::Fim");
		
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

		this.logar("ManutencaoDadosCadastraisEJBImpl:verificarErrosValidacao::Inicio");
		
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

		this.logar("ManutencaoDadosCadastraisEJBImpl:verificarErrosValidacao::Fim");
		
	}
	
	/**
	 * 
	 * Verifica a situacao do CPF informado e retorna true caso o mesmo esteja inadimplente.
	 * 
	 * @param cpf CPF a ser verificado
	 * @return true se inadimplente
	 * 
	 * @since 30/12/2009
	 */
	private boolean cpfInadimplente(String cpf) {
		boolean inadimplente = false;
		
		// Consulta base de dados de inadimplencia
		SnCPFInadimplenteBean snCPFInadimplente = new SnCPFInadimplenteBean();
		snCPFInadimplente.setCpf(cpf);
		snCPFInadimplente = (SnCPFInadimplenteBean) findByPrimaryKey(snCPFInadimplente);

		// Verifica se ha retorno, portanto é inadimplente
		if (snCPFInadimplente != null && snCPFInadimplente.getDtGer() != null) {
			inadimplente = true;
		}

		return inadimplente;
	}
	
	/**
	 * 
	 * Operacao que valida informacoes gerais enviadas
	 * 
	 * @param dadosCadastrais
	 * @param snAssinante
	 * @return
	 * @throws ValidationException
	 * 
	 * @since 30/12/2009
	 */
	private void  validarInformacoesGerais(Bean dadosCadastrais, SnAssinanteBean snAssinante, 
			List<ValidationMessage> errorList) throws ValidationException {

		this.logar("ManutencaoDadosCadastraisEJBImpl:validarInformacoesGerais::Inicio");
		
		// Verifica a tentativa de informar dados de pessoa física para pessoa jurídica
		// e vice-versa (NESSE CASO A VALIDAÇÃO RETORNA IMEDIATAMENTE)
		validarConsistenciaDadosPJPF(dadosCadastrais, snAssinante);

		// Carrega nome do bean
		String nomeTitular = getBeanProperty(dadosCadastrais, ASSINANTE_NOME_TITULAR);
		
		// Verificar se o Nome do Titular foi informado;
		if ( isUpdating(nomeTitular, snAssinante.getNomeTitular()) && !informado(nomeTitular) ) {
			errorList.add(getValidationMessage(NOME_TITULAR_OBRIGATORIO, new Object[]{ASSINANTE_NOME_TITULAR}));
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarInformacoesGerais::Fim");		
	}
	
	/**
	 * 
	 * Verifica se o assinante informado é pessoa fisica ou juridica
	 * 
	 * @param snAssinante
	 * @return
	 * 
	 * @since 30/12/2009
	 */
	private boolean isPessoaFisica(SnAssinanteBean snAssinante) {
		// Identifica se assinante atual é pessoa fisica ou juridica
		boolean assPessoaFisica = true;
		if ( snAssinante.getTipoPessoa().getIdTipoPessoa().equals(Integer.valueOf(SnTipoPessoaBean.TP_JURIDICA)) ) {
			assPessoaFisica = false;
		}
		
		return assPessoaFisica;
	}
	
	/**
	 * 
	 * Operacao que verifica se o tipo de assinante passado é PF ou PJ e se as informacoes passadas no 
	 * bean sao do mesmo tipo. Se houver mistura entre informacoes de PF e PJ lanca excecao.
	 * 
	 * @param dadosCadastrais
	 * @param snAssinante
	 * @throws ValidationException
	 * 
	 * @since 30/12/2009
	 */
	private void validarConsistenciaDadosPJPF(Bean dadosCadastrais, SnAssinanteBean snAssinante) 
			throws ValidationException {

		this.logar("ManutencaoDadosCadastraisEJBImpl:validarConsistenciaDadosPJPF::Inicio");
		
		List<ValidationMessage> errorList = new ArrayList<ValidationMessage>();
		
		// Identifica se assinante atual é pessoa fisica ou juridica
		boolean assPessoaFisica = isPessoaFisica(snAssinante);
		
		// Verificar a tentativa de informar dados de pessoa física para pessoa jurídica
		// e vice-versa (NESSE CASO A VALIDAÇÃO DEVERÁ RETORNAR IMEDIATAMENTE)
		if (assPessoaFisica) {
			// Assinante é pessoa fisica
			// Carrega informacoes de pessoa juridica
			String cnpj = getBeanProperty(dadosCadastrais, ASSINANTE_CPF);
			
			//Verifica se assinante é PF e dados passados sao de PJ, o que nao é permitido
			if ( informado(cnpj) && validaCNPJ(cnpj) ) {
				errorList.add(getValidationMessage(DADOS_PF_COM_PJ, null));
			}
		}
		else {
			// Assinante é pessoa juridica
			// Carrega informacoes de pessoa fisica
			String cpf = getBeanProperty(dadosCadastrais, ASSINANTE_CNPJ);
			
			//Verifica se assinante é PJ e dados passados sao de PF, o que nao é permitido
			if ( informado(cpf) && validaCPF(cpf) ) {
				errorList.add(getValidationMessage(DADOS_PF_COM_PJ, null));
			}
		}
		
		//Se houve erro de dados PF misturados com dados PJ, retorna erro imediatamente
		verificarErrosValidacao(errorList);
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarConsistenciaDadosPJPF::Fim");		
	}

	/**
	 * 
	 * Valida os campos de pessoa juridica e retorna lista contendo erros encontrados.
	 * 
	 * @param dadosCadastrais
	 * @return Lista de codigos de erros
	 * 
	 * @since 30/12/2009
	 */
	private void validarDadosPessoaJuridica(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante) {
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarDadosPessoaJuridica::Inicio");
		
		String cnpj = getBeanProperty(dadosCadastrais, ASSINANTE_CNPJ);
		String inscricaoEstadual = getBeanProperty(dadosCadastrais, ASSINANTE_INSCRICAO_ESTADUAL);
		String orgaoExpedidor = getBeanProperty(dadosCadastrais, ASSINANTE_ORGAO_EXPEDIDOR);

	    // Verificar se o CNPJ foi informado;
		if (isUpdating(cnpj, snAssinante.getCpf())) {
			if (!informado(cnpj)) {
				errorList.add(getValidationMessage(CNPJ_NAO_INFORMADO, new Object[]{ASSINANTE_CNPJ}));
			}
			
		    // Verificar se o CNPJ informado apresenta o formato de acordo com o padrão definido no canônico e é válido
			if (informado(cnpj) && !validaCNPJ(cnpj)) {
				errorList.add(getValidationMessage(CNPJ_FORA_PADRAO, new Object[]{cnpj}));
			}
		}
		
		//Busca o orgao expedidor na base de dados
		SnOrgaoExpedidorBean snOrgaoExpedidorBean = searchOrgaoExpedidorByDescricao(orgaoExpedidor);
		boolean existeOrgaoExp = (snOrgaoExpedidorBean != null) ? true : false;
		
	    // Verificar se a Inscrição Estadual informada apresenta o formato de acordo com o padrão
		// definido no canônico (Não aplicável quando o valor for = "ISENTO");
		if (isUpdating(inscricaoEstadual, snAssinante.getNumRg())) {
			if (existeOrgaoExp && informado(inscricaoEstadual)
					&& !VALOR_ISENTO.equals(inscricaoEstadual)
					&& !validaInscricaoEstadual(inscricaoEstadual, snOrgaoExpedidorBean.getDescricao())) {
				errorList.add(getValidationMessage(INSCRICAO_ESTADUAL_FORA_PADRAO, new Object[]{inscricaoEstadual}));
			}
		}

		String oeBase = snAssinante.getOrgaoExpedidor() != null ? snAssinante.getOrgaoExpedidor().getDescricao() : null;
		if (isUpdating(orgaoExpedidor, oeBase)) {
			// Verificar se o órgão expedidor foi informado (Somente se a Inscrição Estadual 
			// estiver preenchida e não estiver com o valor ISENTO)
			if (informado(inscricaoEstadual)
					&& !VALOR_ISENTO.equals(inscricaoEstadual)
					&& !informado(orgaoExpedidor)) {
				errorList.add(getValidationMessage(ORGAO_EXPEDIDOR_PJ_NAO_INFORMADO, 
						new Object[]{ASSINANTE_ORGAO_EXPEDIDOR}));
			}
			
			// Verificar se o órgão expedidor existe
			if (informado(inscricaoEstadual)
					&& !VALOR_ISENTO.equals(inscricaoEstadual)
					&& informado(orgaoExpedidor)
					&& !existeOrgaoExp) {
				errorList.add(getValidationMessage(ORGAO_EXPEDIDOR_FORA_PADRAO, new Object[]{orgaoExpedidor}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarDadosPessoaJuridica::Fim");		
	}
	
	/**
	 * 
	 * Deverá ser feita a validação apenas dos campos que forem informados.
	 * As validações não devem retorna o erro imediatamente, ao invés disso, 
	 * as mensagens de erro deverão ser agrupadas e retornadas de uma só vez.
	 * 
	 * @param dadosCadastrais
	 * @return
	 * 
	 * @since 29/12/2009
	 */
	private void validarDadosPessoaFisica(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante) {
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarDadosPessoaFisica::Inicio");
		
		this.validarCpf(dadosCadastrais, errorList, snAssinante);
		this.validarRg(dadosCadastrais, errorList, snAssinante);
		this.validarOrgaoExpedidor(dadosCadastrais, errorList, snAssinante);
		this.validarDataNascimento(dadosCadastrais, errorList, snAssinante);
		this.validarProfissao(dadosCadastrais, errorList, snAssinante);
		this.validarEscolaridade(dadosCadastrais, errorList, snAssinante);
		this.validarEstadoCivil(dadosCadastrais, errorList, snAssinante);
		this.validarSexo(dadosCadastrais, errorList, snAssinante);
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarDadosPessoaFisica::Fim");
		
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
	
	/**
	 * 
	 * Valida o numero de inscricao estadual conforme o Estado do orgao expedidor
	 * 
	 * @param inscricaoEstadual
	 * @param orgaoExpedidor
	 * @return
	 * 
	 * @since 09/01/2010
	 */
	private boolean validaInscricaoEstadual(String inscricaoEstadual, String orgaoExpedidor) {
		return ValidatorInscricaoEstadual.checkIETodos(inscricaoEstadual, orgaoExpedidor);
	}
	
	/**
	 * 
	 * Verifica se o Estado Civil informado existe na base de dados
	 * 
	 * @param estadoCivil ID do Estado Civil(Integer)
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private boolean estadoCivilExistente(String estadoCivil) {
	
		this.logar("ManutencaoDadosCadastraisEJBImpl:estadoCivilExistente::Inicio");
		
		boolean existe = false;
		
		SnEstadoCivilBean snEstadoCivilBean = searchEstadoCivil(estadoCivil) ;

		if (snEstadoCivilBean != null) {
			existe = true;
		}
	
		this.logar("ManutencaoDadosCadastraisEJBImpl:estadoCivilExistente::Fim");
		
		return existe;
	}

	/**
	 * 
	 * Verifica se o sexo informado existe na base de dados
	 * 
	 * @param sexo Descricao
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private boolean sexoExistente(String sexo) {
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:sexoExistente::Inicio");
		
		boolean existe = false;
		
		SnSexoBean snSexoBean = searchSexoByDescricao(sexo);
		
		if (snSexoBean != null) {
			existe = true;
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:sexoExistente::Fim");
		
		return existe;
	}

	/**
	 * 
	 * Verifica se a data é valida
	 * 
	 * @param dataNascimento
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private boolean dataNascimentoValida(String dataNascimento) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:dataNascimentoValida::Inicio");
		
		boolean valido = DateValidator.isValid(dataNascimento, DateValidator.FORMATO_CURTO);
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:dataNascimentoValida::Fim");
		
		return valido;
	}
	
	/**
	 * 
	 * Verifica se a escolaridade informada existe na base de dados
	 * 
	 * @param escolaridade ID da escolaridade(Integer)
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private boolean escolaridadeExistente(String escolaridade) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:escolaridadeExistente::Inicio");
		
		boolean existe = false;
		
		SnEscolaridadeBean snEscolaridadeBean = searchEscolaridade(escolaridade);

		if (snEscolaridadeBean != null) {
			existe = true;
		}

		this.logar("ManutencaoDadosCadastraisEJBImpl:escolaridadeExistente::Fim");
		
		return existe;
	}

	/**
	 * 
	 * Verifica se a profissao informada existe na base de dados
	 * 
	 * @param profissao ID da profissao(Long)
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private boolean profissaoExistente(String profissao) {
		this.logar("ManutencaoDadosCadastraisEJBImpl:profissaoExistente::Inicio");
	
		boolean existe = false;
	
		SnProfissaoBean snProfissaoBean = searchProfissao(profissao);

		if (snProfissaoBean != null) {
			existe = true;
		}
	
		this.logar("ManutencaoDadosCadastraisEJBImpl:profissaoExistente::Fim");
		
		return existe;
	}
	
	
	/**
	 * 
	 * Valida se o CPF é valido
	 * 
	 * @param cpf
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private boolean validaCPF(String cpf) {
		return ValidadorCPFOrCNPJ.isValidCPF(cpf);
	}
	
	/**
	 * 
	 * Valida se o CNPJ é valido
	 * 
	 * @param cpf
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private boolean validaCNPJ(String cpf) {
		return ValidadorCPFOrCNPJ.isValidCNPJ(cpf);
	}

	/**
	 * 
	 * Valida se o RG é valido
	 * 
	 * @param rg
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private boolean validaRG(String rg) {
		boolean valido = false;
		if (rg != null && rg.length() < 21) {
			valido = true;
		}
		return valido;
	}

	
	/**
	 * 
	 * Operação que realiza as atualizacao de dados cadastrais nao restritos.
	 * 
	 * @param dadosCadastrais Campos novos
	 * @param snAssinante Assinante com campos atuais
	 *
	 * @since 29/12/2009
	 */
	private void processarAtualizacaoAtendente(Bean dadosCadastrais, SnAssinanteBean snAssinante) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:processarAtualizacaoAtendente::Inicio");
		
		// Atualiza snAssinante com modificacao de campos nao restritos, se houver.
		String observacaoRestrito = atualizarCamposNaoRestritosBean(dadosCadastrais, snAssinante);

		// Atualiza dados do assinante com informacoes nao restritas
		if ( !"".equals(observacaoRestrito)) {
			super.update(snAssinante, super.getUserSession().getCurrentDbService());
			
			// Invoca Registro do Contato
			inserirInformacaoRegistroContato(dadosCadastrais, observacaoRestrito);
		}

		// Valida se algum campo restrito foi modificado
		String observacoes = verificaAlteracaoDadosRestritos(dadosCadastrais, snAssinante);
		
		// Se algum campo restrito foi alterado, incluir requisicao interna para posterior atualizacao
		if ( !"".equals(observacoes)) {
			incluirRequisicaoInterna(observacoes, dadosCadastrais);
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:processarAtualizacaoAtendente::Fim");
		
	}
	
	/**
	 * Operação que realiza as atualizacao de dados cadastrais restritos e nao restritos.
	 * 
	 * @param dadosCadastrais Campos novos
	 * @param snAssinante Assinante com campos atuais
	 * 
 	 * @since 29/12/2009
	 * 
	 * @ejb.transaction type="Required"
	 * @ejb.permission role-name="BACKOFFICE"
	 * 
	 */
	private void processarAtualizacaoBackOffice(Bean dadosCadastrais, SnAssinanteBean snAssinante) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:processarAtualizacaoBackOffice::Inicio");
		
		// Atualiza snAssinante com modificacao de campos restritos e nao restritos, se houver.
		String observacaoNaoRestrito = atualizarCamposNaoRestritosBean(dadosCadastrais, snAssinante);
		String observacaoRestrito = atualizarCamposRestritosBean(dadosCadastrais, snAssinante);
		
		// Atualiza dados do assinante com informacoes restritas/nao restritas
		if ( !"".equals(observacaoNaoRestrito) || !"".equals(observacaoRestrito) ) {
			super.update(snAssinante, super.getUserSession().getCurrentDbService());

			// Invoca Registro do Contato
			inserirInformacaoRegistroContato(dadosCadastrais, (observacaoNaoRestrito + " " + observacaoRestrito) );
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:processarAtualizacaoBackOffice::Fim");		
		
	}
	
	/**
 	 *  
	 * Operacao que verifica se algum campo restrito que foi modificado e retorna uma String contendo a descricao dos
	 * campos modificados.
	 * 
	 * @param dadosCadastrais
	 * @param snAssinante
	 * @return null se nao ha alteracao, ou String com observacoes do que foi alterado.
	 * 
	 * @since 29/12/2009
	 */
	private String verificaAlteracaoDadosRestritos(Bean dadosCadastrais, SnAssinanteBean snAssinante) {
		return verificaAlteracaoDadosRestritos(dadosCadastrais, snAssinante, false);
	}
		
	/**
 	 *  
	 * Operacao que verifica se algum campo restrito que foi modificado e retorna uma String contendo a descricao dos
	 * campos modificados. Se alterarAssinante = true entao insere as alteracoes no SnAssinanteBean informado.
	 * Campos Restritos: Nome do Titular, Tipo de Pessoa, Orgão Expeditor, Código Suframa, Data de Nascimento, 
	 * CPF, CNPJ, RG, Passaport, Flag Estrangeiro, Nome do Pai, Nome da Mãe 
	 * @param dadosCadastrais
	 * @param snAssinante
	 * @param alterarAssinante Se TRUE insere as alteracoes no snAssinante passado
	 * @return null se nao ha alteracao, ou String com observacoes do que foi alterado.
	 * 
	 * @since 29/12/2009
	 */
	private String verificaAlteracaoDadosRestritos(Bean dadosCadastrais, SnAssinanteBean snAssinante, 
			boolean alterarAssinante) {
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:verificaAlteracaoDadosRestritos::Inicio");
		
		Map<String, Boolean> camposAlterados = new HashMap<String, Boolean>(); // Map contendo os atributos alterados
		
		StringBuffer observacoes = new StringBuffer(); // retorno contendo descricao dos campos modificados
		
		// Campos restritos obrigatorios
		String newNomeTitular = getBeanProperty(dadosCadastrais, ASSINANTE_NOME_TITULAR);
		String oldNomeTitular = snAssinante.getNomeTitular();
		String newOrgaoExpedidor = getBeanProperty(dadosCadastrais, ASSINANTE_ORGAO_EXPEDIDOR);
		SnOrgaoExpedidorBean oldOrgaoExpedidor = snAssinante.getOrgaoExpedidor();
		String newDtNascimento = getBeanProperty(dadosCadastrais, ASSINANTE_DATA_NASCIMENTO);
		Date oldDtNascimento = snAssinante.getDtNascimento();
		String newCpf = getBeanProperty(dadosCadastrais, ASSINANTE_CPF);
		if (newCpf != null && !"".equals(newCpf)) {
			newCpf = ValidadorCPFOrCNPJ.removerFormatacao(newCpf);
		}
		String newCnpj = getBeanProperty(dadosCadastrais, ASSINANTE_CNPJ);
		if (newCnpj != null && !"".equals(newCnpj)) {
			newCnpj = ValidadorCPFOrCNPJ.removerFormatacao(newCnpj);
		}
		String oldCpfOrCnpj = snAssinante.getCpf();

		// campos restritos nao obrigatorios
		String newCodigoSuframa = getBeanProperty(dadosCadastrais, ASSINANTE_CODIGO_SUFRAMA);
		String oldCodigoSuframa = snAssinante.getCdSuframa();
		String newIsEstrangeiro = 
			Boolean.getBoolean(getBeanProperty(dadosCadastrais, ASSINANTE_ESTRANGEIRO)) ? "1" : "0";
		Integer oldIsEstrangeiro = snAssinante.getEstrangeiro();
		String newNomePai = getBeanProperty(dadosCadastrais, ASSINANTE_NOME_PAI);
		String oldNomePai = snAssinante.getNomePai();
		String newNomeMae = getBeanProperty(dadosCadastrais, ASSINANTE_NOME_MAE);
		String oldNomeMae = snAssinante.getNomeMae();
		String newRG = getBeanProperty(dadosCadastrais, ASSINANTE_RG);
		String newPassaporte = getBeanProperty(dadosCadastrais, ASSINANTE_PASSAPORTE);
		String oldRgOrPassaporte = snAssinante.getNumRg();
		String newInscricaoEstadual = getBeanProperty(dadosCadastrais, ASSINANTE_INSCRICAO_ESTADUAL);
		String oldInscricoaEstaduaol = snAssinante.getNumRg();

		// Verifica se ha campos restritos alterados		
		String nomeTitular = (String) verificaCampoModificado(newNomeTitular, oldNomeTitular, String.class);
		SnOrgaoExpedidorBean orgaoExpedidor = (SnOrgaoExpedidorBean) verificaCampoModificado(newOrgaoExpedidor, 
				oldOrgaoExpedidor, SnOrgaoExpedidorBean.class);
		
		Date dataNascimento = null;
		if (isPessoaFisica(snAssinante)) {
			dataNascimento = (Date) verificaCampoModificado(newDtNascimento, oldDtNascimento, Date.class);
		}
		String cpf = (String) verificaCampoModificado(newCpf, oldCpfOrCnpj, String.class); 
		String cnpj = (String) verificaCampoModificado(newCnpj, oldCpfOrCnpj, String.class);
		String rg = (String) verificaCampoModificado(newRG, oldRgOrPassaporte, String.class);
		String passaporte = (String) verificaCampoModificado(newPassaporte, oldRgOrPassaporte, String.class);
		String codigoSuframa = (String) verificaCampoModificado(newCodigoSuframa, oldCodigoSuframa, String.class);
		Integer isEstrangeiro = (Integer) verificaCampoModificado(newIsEstrangeiro, oldIsEstrangeiro, Integer.class);
		String nomePai = (String) verificaCampoModificado(newNomePai, oldNomePai, String.class);
		String nomeMae = (String) verificaCampoModificado(newNomeMae, oldNomeMae, String.class);
		String inscricaoEstadual = 
			(String) verificaCampoModificado(newInscricaoEstadual, oldInscricoaEstaduaol, String.class);
		
		// Monta Observacao descrevendo campos modificados
		if (nomeTitular != null) {
			camposAlterados.put(ASSINANTE_NOME_TITULAR, Boolean.TRUE);
			observacoes.append("Nome do Titular para '").append(nomeTitular).append(ClienteUtil.getLineFeed());
		}
		if (orgaoExpedidor != null) {
			camposAlterados.put(ASSINANTE_ORGAO_EXPEDIDOR, Boolean.TRUE);
			observacoes.append("Orgao Expedidor para '").append(orgaoExpedidor.getDescricao())
				.append(ClienteUtil.getLineFeed());
		}
		if (dataNascimento != null) {
			camposAlterados.put(ASSINANTE_DATA_NASCIMENTO, Boolean.TRUE);
			SimpleDateFormat sd = new SimpleDateFormat(DateValidator.FORMATO_CURTO);
			observacoes.append("Data de Nascimentou para '").append(sd.format(dataNascimento))
				.append(ClienteUtil.getLineFeed());
		}
		if (informado(newCpf) && cpf != null) {
			camposAlterados.put(ASSINANTE_CPF, Boolean.TRUE);
			observacoes.append("Número do CPF para '").append(cpf).append(ClienteUtil.getLineFeed());
		}		
		if (informado(newCnpj) && cnpj != null) {
			camposAlterados.put(ASSINANTE_CNPJ, Boolean.TRUE);
			observacoes.append("Número do CNPJ para '").append(cnpj).append(ClienteUtil.getLineFeed());
		}		
		if (isEstrangeiro != null) {
			camposAlterados.put(ASSINANTE_ESTRANGEIRO, Boolean.TRUE);
			observacoes.append("Estrangeiro para '").append((isEstrangeiro == 0) ? "Não" : "Sim" )
				.append(ClienteUtil.getLineFeed());
		}		
		if (informado(newRG) && rg != null) {
			camposAlterados.put(ASSINANTE_RG, Boolean.TRUE);
			observacoes.append("Número de RG para '").append(rg).append(ClienteUtil.getLineFeed());
		}		
		if (informado(newPassaporte) && passaporte != null) {
			camposAlterados.put(ASSINANTE_PASSAPORTE, Boolean.TRUE);
			observacoes.append("Número do Passaporte para '").append(passaporte).append(ClienteUtil.getLineFeed());
		}		
		if (codigoSuframa != null) {
			camposAlterados.put(ASSINANTE_CODIGO_SUFRAMA, Boolean.TRUE);
			observacoes.append("Código Suframa para '").append(codigoSuframa).append(ClienteUtil.getLineFeed());
		}
		if (nomePai != null) {
			camposAlterados.put(ASSINANTE_NOME_PAI, Boolean.TRUE);
			observacoes.append("Nome pai para '").append(nomePai).append(ClienteUtil.getLineFeed());
		}		
		if (nomeMae != null) {
			camposAlterados.put(ASSINANTE_NOME_MAE, Boolean.TRUE);
			observacoes.append("Nome mãe para '").append(nomeMae).append(ClienteUtil.getLineFeed());
		}
		if (informado(newInscricaoEstadual) && inscricaoEstadual != null) {
			camposAlterados.put(ASSINANTE_INSCRICAO_ESTADUAL, Boolean.TRUE);
			observacoes.append("Número da Inscrição Estadual para '").append(inscricaoEstadual)
				.append(ClienteUtil.getLineFeed());
		}
		
		if (alterarAssinante) { // Atualiza campos restritos no SnAssinante
			if (isBackOffice()) { // So backoffice pode alterar campos restritos do assinante
				this.atualizarCamposRestritosAssinante(camposAlterados, snAssinante, nomeTitular, 
						dataNascimento, codigoSuframa, nomePai, nomeMae, inscricaoEstadual);
				this.atualuzarCamposRestritosDocumentos(camposAlterados, snAssinante, orgaoExpedidor,
						cpf, cnpj, isEstrangeiro, rg);
			} else { // Erro de programacao pois se o perfil é ATENDENTE, nao deveria tentar modicar campos restritos
				throw new RuntimeException(); 
			}
		}

		this.logar("ManutencaoDadosCadastraisEJBImpl:verificaAlteracaoDadosRestritos::Fim");
		
		return observacoes.toString();
	}
	
	/**
	 *  Operacao que invoca a inclusao de requisicao interna para os campos restritos alterados pelo atendente
	 */
	private void incluirRequisicaoInterna(String observacoes, Bean dadosCadastrais) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:incluirRequisicaoInterna::Inicio");
		
		try {
			IncluirRequisicaoInternaWebService
			service = WebServiceFactory.getService(
							IncluirRequisicaoInternaWebService.class,
							context.getCallerPrincipal(),
							ClienteConstants.APPLICATION_CONTEXT_WEBSERVICE_XML);
			
			IncluirRequisicaoInterna req = ClienteUtil.getPayloadRequisicaoInterna(
					observacoes, dadosCadastrais, context.getCallerPrincipal().getName());
			service.incluirRequisicaoInterna(req, ClienteUtil.getHeaderWebService(dadosCadastrais));

		} catch (Exception e) {
			if (!e.getMessage().contains("Sucesso")) {
				String mensagem = this
						.getMessage(
								ERRO_SERVICO,
								new Object[] { ClienteConstants.RESOURCE_INCLUIR_REQUISICAO_INTERNA });
				ResourceException ex = new ResourceException(ERRO_SERVICO,
						mensagem, this.getClass().getName(), e);
				throw ex;
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:incluirRequisicaoInterna::Fim");
		
	}
	
	/**
	 * Operacao que verifica se algum campo restrito foi modificado. Neste caso, atualiza
	 * as informacoes no snAssinanteBean e retorna true.
	 * @param dadosCadastrais Bean com campos modificados
	 * @param snAssinante Bean com campos atuais e que sera atualizado com os campos modificados
	 * 
	 * @return boolean indicando se snAssinanteBean foi atualizado e ha campos modificados
	 * 
	 * @since 29/12/2009
	 */
	private String atualizarCamposRestritosBean(Bean dadosCadastrais, SnAssinanteBean snAssinante) {
		return verificaAlteracaoDadosRestritos(dadosCadastrais, snAssinante, true);
	}

	
	/**
	 * Operacao que verifica se algum campo nao restrito foi modificado. Neste caso, atualiza
	 * as informacoes no snAssinanteBean e retorna true.
	 * @param dadosCadastrais Bean com campos modificados
	 * @param snAssinante Bean com campos atuais e que sera atualizado com os campos modificados
	 * 
	 * @return String indicando as alteracoes realizadas
	 * 
	 * @since 29/12/2009
	 */
	private String atualizarCamposNaoRestritosBean(Bean dadosCadastrais, SnAssinanteBean snAssinante) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:atualizarCamposNaoRestritosBean::Inicio");
		
		StringBuffer observacoes = new StringBuffer();
		
		// Campos nao restritos
		String newSexo = getBeanProperty(dadosCadastrais, ASSINANTE_SEXO);
		SnSexoBean oldSexo = snAssinante.getSexo();
		String newEstadoCivil = getBeanProperty(dadosCadastrais, ASSINANTE_ESTADO_CIVIL);
		SnEstadoCivilBean oldEstadoCivil = snAssinante.getEstadoCivil();
		String newProfissao = getBeanProperty(dadosCadastrais, ASSINANTE_PROFISSAO);
		SnProfissaoBean oldProfissao = snAssinante.getProfissao();
		String newEscolaridade = getBeanProperty(dadosCadastrais, ASSINANTE_ESCOLARIDADE);
		SnEscolaridadeBean oldEscolaridade = snAssinante.getEscolaridade();
		
		// Verifica se ha campos nao restritos alterados			
		SnSexoBean auxSexo = (SnSexoBean) verificaCampoModificado(newSexo, oldSexo, SnSexoBean.class);
		SnEstadoCivilBean auxEstadoCivil = 
			(SnEstadoCivilBean) verificaCampoModificado(newEstadoCivil, oldEstadoCivil, 
					SnEstadoCivilBean.class);
		
		SnProfissaoBean auxProfissao = 
			(SnProfissaoBean) verificaCampoModificado(newProfissao, oldProfissao, SnProfissaoBean.class);
		SnEscolaridadeBean auxEscolaridade = 
			(SnEscolaridadeBean) verificaCampoModificado(newEscolaridade, oldEscolaridade, SnEscolaridadeBean.class);

		// Atualiza o snAssinanteBean com os campos modificados
		if (auxSexo != null) {
			snAssinante.setSexo(auxSexo);
			observacoes.append("Sexo para '").append(auxSexo.getDescricao()).append(ClienteUtil.getLineFeed());
		}
		if (auxEstadoCivil != null) {
			SnEstadoCivilBean auxEstadoCivilLGPG = searchEstadoCivil(ESTADO_CIVIL_LGPD);
			snAssinante.setEstadoCivil(auxEstadoCivilLGPG);
			observacoes.append("Estado Civil para '").append(auxEstadoCivil.getDescricao())
				.append(ClienteUtil.getLineFeed());
		}
		if (auxProfissao != null) {
			snAssinante.setProfissao(auxProfissao);
			observacoes.append("Profissão para '").append(auxProfissao.getDescricao())
				.append(ClienteUtil.getLineFeed());
		}
		if (auxEscolaridade != null) {
			snAssinante.setEscolaridade(auxEscolaridade);
			observacoes.append("Escolaridade para '").append(auxEscolaridade.getDescricao())
				.append(ClienteUtil.getLineFeed());
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:atualizarCamposNaoRestritosBean::Fim");		
		
		return observacoes.toString();
	}
	
	/**
	 * Operação que compara se dois campos informados tem valores iguais. Se sim retorna Null, caso contrario
	 * busca na base(se necessario) o novo valor e retorna como objeto.
	 * 
	 * @param newValue Novo valor
	 * @param oldField Bean atualmente na base de dados
	 * @param classeBase Tipo de classe que se deseja comparar
	 * @return Null se iguais ou instancia da class informada se diferentes
	 * 
	 */
	private Object verificaCampoModificado(String newValue, Object oldField, Class<? extends Object> classeBase) {
		this.logar("ManutencaoDadosCadastraisEJBImpl:verificaCampoModificado::Inicio");
		
		Object bean = null;
		String oldValue = null;
		if (classeBase == SnSexoBean.class) { // SEXO - OBRIGATORIO PELA VALIDACAO
			oldValue = "";
			if (oldField != null) {
				oldValue = ((SnSexoBean) oldField).getDescricao();
			}
			if (!oldValue.equals(newValue)) { // Verifica se o usuario alterou o valor
				bean = searchSexoByDescricao(newValue);
			}
		} else if (classeBase == SnEstadoCivilBean.class) { // ESTADO CIVIL - OBRIGATORIO PELA VALIDACAO
			oldValue = "";
			if (oldField != null) {
				oldValue = (((SnEstadoCivilBean) oldField).getIdEstadoCivil()).toString();
			}
			if (!oldValue.equals(newValue)) { // verifica se o ID informado é diferente do atual
				bean = searchEstadoCivil(newValue);
			}
		} else if (classeBase == SnProfissaoBean.class) { // PROFISSAO - OBRIGATORIO PELA VALIDACAO
			oldValue = "";
			if (oldField != null) {
				oldValue = (((SnProfissaoBean) oldField).getIdProfissao()).toString();
			}
			if (!oldValue.equals(newValue)) { // verifica se o ID informado é diferente do atual
				bean = searchProfissao(newValue);
			}
		} else if (classeBase == SnEscolaridadeBean.class) { // ESCOLARIDADE - OBRIGATORIO PELA VALIDACAO
			oldValue = "";
			if (oldField != null) {
				oldValue = (((SnEscolaridadeBean) oldField).getIdEscolaridade()).toString();
			}
			if (!oldValue.equals(newValue)) { // verifica se o ID informado é diferente do atual
				bean = searchEscolaridade(newValue);
			}
		} else if (classeBase == SnOrgaoExpedidorBean.class) { // ORGAO EXPEDIDOR - OBRIGATORIO PELA VALIDACAO
			oldValue = "";
			if (oldField != null) {
				oldValue = ((SnOrgaoExpedidorBean) oldField).getDescricao();
			}
			if (!oldValue.equals(newValue)) { // Verifica se o usuario alterou o valor
				bean = searchOrgaoExpedidorByDescricao(newValue);
			}
		} else if (classeBase == SnTipoPessoaBean.class) { // TIPO PESSOA - SEMPRE VEM
			int oldValueInt = ((SnTipoPessoaBean) oldField).getIdTipoPessoa().intValue();

			if (oldValueInt == SnTipoPessoaBean.TP_FISICA) {
				if (ASSINANTE_TIPO_PESSOA_JURIDICA.equals(newValue)) {
					bean = searchTipoPessoa(SnTipoPessoaBean.TP_JURIDICA); // mudou para PJ
				}
			} else {
				if (ASSINANTE_TIPO_PESSOA_FISICA.equals(newValue)) {
					bean = searchTipoPessoa(SnTipoPessoaBean.TP_FISICA); // mudou para PF
				}
			}
		} else if (classeBase == Date.class) { // DATE - OBRIGATORIO PELA VALIDACAO
			SimpleDateFormat sd = new SimpleDateFormat(DateValidator.FORMATO_CURTO);
			oldValue = "";
			if (oldField != null) {
				oldValue = sd.format((Date) oldField);
			}
			if (!oldValue.equals(newValue)) { // Verifica se mudou a data
				try {
					bean = sd.parse(newValue); // Converte a String com a data para um Date
				}
				catch (Exception e) { // Nao foi possivel converter a data
					throw new RuntimeException(e.getMessage());
				}
			}
		} else if (classeBase == String.class) { // STRING - campos texto
			oldValue = (String) oldField;
			if (oldValue == null) {
				if (newValue != null && !"".equals(newValue)) {
					bean = newValue;
				}
			} else if (!oldValue.equals(newValue)) {
				if (newValue == null) {
					newValue = ""; //metodo so retorna null se campos sao iguais
				}
				bean = newValue;
			}
		} else if (classeBase == Integer.class) { // INTEGER - campos int
			
			bean = verificarCampoModificadoInteger(newValue, oldField);
			
		} else { // Erro de programacao pois foi informada classe que nao esta sendo tratada!!
			throw new RuntimeException();
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:verificaCampoModificado::Fim");
		
		return  bean;
	}

	/**
	 * 
	 * Busca um assinante na base de dados pelo contrato
	 * 
	 * @param dadosCadastrais Bean com idAssinante
	 * @return
	 * 
	 * @since 04/01/2010
	 */
	private SnAssinanteBean searchAssinanteByContrato(Bean dadosCadastrais) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchAssinanteByContrato::Inicio");
		
		SnContratoBean bean = new SnContratoBean();
		SnContratoKey key = new SnContratoKey();
		key.setCidContrato(getBeanProperty(dadosCadastrais, CONTRATO_CIDADE));
		key.setNumContrato(Long.valueOf(getBeanProperty(dadosCadastrais, CONTRATO_NUM_CONTRATO)));
		bean.setCompositeKey(key);

		Collection<?> ret = super.search(SnAssinanteBean.ASSINANTE_BY_NUMCONTRATO_CIDADE, bean, false);

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchAssinanteByContrato::Fim");
		
		if (!ret.isEmpty()) {
			return (SnAssinanteBean) ret.iterator().next();
		}
		
		return null;
	}
	
	/**
	 * 
	 * Busca o sexo pela descricao
	 * 
	 * @param descricao
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private SnSexoBean searchSexoByDescricao(String descricao) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchSexoByDescricao::Inicio");
		
		SnSexoBean bean = new SnSexoBean();
		bean.setDescricao(descricao);
		Collection<?> ret = super.search(SnSexoBean.SEXO_BY_DESCRICAO, bean, false);

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchSexoByDescricao::Fim");
		
		if (!ret.isEmpty()) {
			return (SnSexoBean) ret.iterator().next();
		}
		return null;
	}

	/**
	 * 
	 * Busca o orgao expedidor pela descricao
	 * 
	 * @param descricao
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private SnOrgaoExpedidorBean searchOrgaoExpedidorByDescricao(String descricao) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchOrgaoExpedidorByDescricao::Inicio");
		
		if ( !informado(descricao) ) {
			return null;
		}
		
		SnOrgaoExpedidorBean bean = new SnOrgaoExpedidorBean();
		bean.setDescricao(descricao);
		Collection<?> ret = super.search(SnOrgaoExpedidorBean.ORGAO_EXPEDIDOR_BY_DESCRICAO, bean, false);

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchOrgaoExpedidorByDescricao::Fim");
		
		if (!ret.isEmpty()) {
			return (SnOrgaoExpedidorBean) ret.iterator().next();
		}
		return null;
	}
    
	/**
	 * 
	 * Busca um estado civil pelo ID
	 * 
	 * @param id
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private SnEstadoCivilBean searchEstadoCivil(String id) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchEstadoCivil::Inicio");
		
		SnEstadoCivilBean snEstadoCivilBean = new SnEstadoCivilBean();
		try {
			snEstadoCivilBean.setIdEstadoCivil(Integer.valueOf(id));
			snEstadoCivilBean = (SnEstadoCivilBean) findByPrimaryKey(snEstadoCivilBean);
		}
		catch (Exception e ) {
			snEstadoCivilBean = null;
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:searchEstadoCivil::Fim");		
		
		return snEstadoCivilBean;
	}
	
	/**
	 * 
	 * Busca uma profissao pelo ID
	 * 
	 * @param id
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private SnProfissaoBean searchProfissao(String id) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchProfissao::Inicio");
		
		SnProfissaoBean snProfissaoBean = new SnProfissaoBean();
		try {
			snProfissaoBean.setIdProfissao(Long.valueOf(id));
			snProfissaoBean = (SnProfissaoBean) findByPrimaryKey(snProfissaoBean);
		}
		catch (Exception e) {
			snProfissaoBean = null;
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:searchProfissao::Fim");
		
		return snProfissaoBean;
	}	

	/**
	 * 
	 * Busca uma escolaridade pelo ID
	 * 
	 * @param id
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private SnEscolaridadeBean searchEscolaridade(String id) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchEscolaridade::Inicio");
		
		SnEscolaridadeBean snEscolaridadeBean = new SnEscolaridadeBean();
		try {
			snEscolaridadeBean.setIdEscolaridade(Integer.valueOf(id));
			snEscolaridadeBean = (SnEscolaridadeBean) findByPrimaryKey(snEscolaridadeBean);
		}
		catch(Exception e) {
			snEscolaridadeBean = null;
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:searchEscolaridade::Fim");
		
		return snEscolaridadeBean;
	}
	
	/**
	 * 
	 * Busca um tipo pessoa pelo ID
	 * 
	 * @param id
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private SnTipoPessoaBean searchTipoPessoa(Integer id) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:searchTipoPessoa::Inicio");
		
		SnTipoPessoaBean snTipoPessoaBean = new SnTipoPessoaBean();
		snTipoPessoaBean.setIdTipoPessoa(id);
		snTipoPessoaBean = (SnTipoPessoaBean) findByPrimaryKey(snTipoPessoaBean);
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:searchTipoPessoa::Fim");		
		
		return snTipoPessoaBean;
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
	 * Monta um Validation Message
	 * 
	 * @param messageCode
	 * @param arguments
	 * @return
	 * 
	 * @since 08/01/2010
	 */
	private ValidationMessage getValidationMessage(String messageCode, Object[] arguments) {

		this.logar("ManutencaoDadosCadastraisEJBImpl:getValidationMessage::Inicio");
		
		String message = null;
		if (arguments == null) {
			message = this.getMessage(messageCode);
		} else {
			message = this.getMessage(messageCode, arguments);
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:getValidationMessage::Fim");
		
		return new ValidationMessage(messageCode, message);
	}

	/**
	 * Verifica se o perfil passado é de Atendente
	 * @return
	 * 
	 * @since 29/12/2009
	 */
	public boolean isAtendente() {

		this.logar("ManutencaoDadosCadastraisEJBImpl:isAtendente::Inicio");
		
		boolean atendente = false;
		if (super.context.isCallerInRole(ClienteConstants.PERFIL_ATENDENTE)) {
			atendente = true;
		}

		this.logar("ManutencaoDadosCadastraisEJBImpl:isAtendente::Fim");
		
		return atendente;
	}

	/**
	 * 
 	 * Verifica se o perfil passado é de BackOffice
	 * 
	 * @return
	 * 
	 * @since 29/12/2009
	 */
	public boolean isBackOffice() {

		this.logar("ManutencaoDadosCadastraisEJBImpl:isBackOffice::Inicio");
		
		boolean backoffice = false;
		
		if (super.context.isCallerInRole(ClienteConstants.PERFIL_BACKOFFICE)) {
			backoffice = true;
		}

		this.logar("ManutencaoDadosCadastraisEJBImpl:isBackOffice::Fim");
		
		return backoffice;
	}
	
	/**
	 * Metodo responsavel em atualizar os dados de documento restritos do assinante. ()
	 */	
	private void atualuzarCamposRestritosDocumentos(Map<String, Boolean> camposAlterados, SnAssinanteBean snAssinante,
			SnOrgaoExpedidorBean orgaoExpedidor, String cpf, String cnpj, Integer isEstrangeiro, String rg){

		if (camposAlterados.get(ASSINANTE_ORGAO_EXPEDIDOR) != null) {
			snAssinante.setOrgaoExpedidor(orgaoExpedidor);
		}
		if (camposAlterados.get(ASSINANTE_CPF) != null) {
			snAssinante.setCpf(ValidadorCPFOrCNPJ.removerFormatacao(cpf));
		}		
		if (camposAlterados.get(ASSINANTE_CNPJ) != null) {
			snAssinante.setCpf(ValidadorCPFOrCNPJ.removerFormatacao(cnpj));
		}		
		if (camposAlterados.get(ASSINANTE_ESTRANGEIRO) != null) {
			snAssinante.setEstrangeiro(isEstrangeiro);
		}		
		if (camposAlterados.get(ASSINANTE_RG) != null) {
			snAssinante.setNumRg(rg);
		}		
		if (camposAlterados.get(ASSINANTE_PASSAPORTE) != null) {
			snAssinante.setNumRg(rg);
		}		
	}
	
	/**
	 * Metodo responsavel em atualizar os dados restritos do assinante. ()
	 */	
	private void atualizarCamposRestritosAssinante(Map<String, Boolean> camposAlterados, SnAssinanteBean snAssinante,
			String nomeTitular, Date dataNascimento, String codigoSuframa, String nomePai, 
			String nomeMae, String inscricaoEstadual){
		// Altera dados do assinante
		if (camposAlterados.get(ASSINANTE_NOME_TITULAR) != null) {
			snAssinante.setNomeTitular(nomeTitular);
		}
		if (camposAlterados.get(ASSINANTE_DATA_NASCIMENTO) != null) {
			snAssinante.setDtNascimento(dataNascimento);
		}
		if (camposAlterados.get(ASSINANTE_CODIGO_SUFRAMA)!= null) {
			snAssinante.setCdSuframa(codigoSuframa);
		}
		if (camposAlterados.get(ASSINANTE_NOME_PAI) != null) {
			snAssinante.setNomePai(nomePai);
		}		
		if (camposAlterados.get(ASSINANTE_NOME_MAE) != null) {
			snAssinante.setNomeMae(nomeMae);
		}
		if (camposAlterados.get(ASSINANTE_INSCRICAO_ESTADUAL) != null) {
			snAssinante.setNumRg(inscricaoEstadual);
		}
	}

	/**
	 * Metodo responsavel em validar o cpf.
	 * @param dadosCadastrais
	 * Bean que contém as informações cadastrais do assinante. 
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate. 
	 */
	private void validarCpf(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarCpf::Inicio");
		
		String cpf = getBeanProperty(dadosCadastrais, ASSINANTE_CPF);
		
		// Verificar se o CPF foi informado;
		if (isUpdating(cpf, snAssinante.getCpf())) {
			if ( !informado(cpf) ) {
				errorList.add(getValidationMessage(CPF_NAO_INFORMADO, new Object[]{ASSINANTE_CPF}));
			}
			
			// Verificar se o CPF informado apresenta o formato de acordo com o padrão definido no canônico e é válido;
			if ( informado(cpf) && !validaCPF(cpf) ) {
				errorList.add(getValidationMessage(CPF_FORA_DO_PADRAO, new Object[]{cpf}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarCpf::Fim");		
	}
	
	/**
	 * Metodo responsavel em validar o rg.
	 * @param dadosCadastrais
	 * Bean que contém as informações cadastrais do assinante. 
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate. 
	 */
	private void validarRg(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarRg::Inicio");
		
		String rg = getBeanProperty(dadosCadastrais, ASSINANTE_RG);
		
		// Verificar se o RG informado apresenta o formato de acordo com o padrão definido no canônico;
		if (isUpdating(rg, snAssinante.getNumRg())) {
			if ( informado(rg) && !validaRG(rg) ) {
				errorList.add(getValidationMessage(RG_FORA_DO_PADRAO, new Object[]{rg}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarRg::Fim");
		
	}

	/**
	 * Metodo responsavel em validar o orgão expedidor.
	 * @param dadosCadastrais
	 * Bean que contém as informações cadastrais do assinante. 
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate. 
	 */
	private void validarOrgaoExpedidor(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){

		this.logar("ManutencaoDadosCadastraisEJBImpl:validarOrgaoExpedidor::Inicio");
		
		String rg = getBeanProperty(dadosCadastrais, ASSINANTE_RG);
		String orgaoExpedidor = getBeanProperty(dadosCadastrais, ASSINANTE_ORGAO_EXPEDIDOR);
		
		// Verificar se o órgão expedidor foi informado (Somente se o RG estiver preenchido)
		String oeBase = 
			(snAssinante.getOrgaoExpedidor() != null) ? snAssinante.getOrgaoExpedidor().getDescricao() : null;
		if (isUpdating(orgaoExpedidor, oeBase)) {
			if ( informado(rg) && !informado(orgaoExpedidor)) {
				errorList.add(getValidationMessage(ORGAO_EXPEDIDOR_PF_NAO_INFORMADO, 
						new Object[]{ASSINANTE_ORGAO_EXPEDIDOR}));
			}

			// Verificar se o órgão expedidor existe
			//Busca o orgao expedidor na base de dados
			SnOrgaoExpedidorBean snOrgaoExpedidorBean = searchOrgaoExpedidorByDescricao(orgaoExpedidor);
			boolean existeOrgaoExp = (snOrgaoExpedidorBean != null) ? true : false;
			if ( informado(orgaoExpedidor) && !existeOrgaoExp ) {
				errorList.add(getValidationMessage(ORGAO_EXPEDIDOR_PF_INEXISTENTE, new Object[]{orgaoExpedidor}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarOrgaoExpedidor::Fim");
		
	}

	/**
	 * Metodo responsavel em validar a data de nascimento.
	 * @param dadosCadastrais
	 * Bean que contém as informações cadastrais do assinante. 
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate. 
	 */
	private void validarDataNascimento(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){

		this.logar("ManutencaoDadosCadastraisEJBImpl:validarDataNascimento::Inicio");
		
		String dataNascimento = getBeanProperty(dadosCadastrais, ASSINANTE_DATA_NASCIMENTO);
		
		// Verificar se a data de nascimento foi informada
		SimpleDateFormat formatter = new SimpleDateFormat(DateValidator.FORMATO_CURTO);
		if (isUpdating(dataNascimento, formatter.format(snAssinante.getDtNascimento())) ) {
			if ( !informado(dataNascimento) ) {
				errorList.add(getValidationMessage(DATA_NASCIMENTO_NAO_INFORMADA, 
						new Object[]{ASSINANTE_DATA_NASCIMENTO}));
			}
	
			// Verificar se a data de nascimento informada á válida
			if ( informado(dataNascimento) && !dataNascimentoValida(dataNascimento) ) {
				errorList.add(getValidationMessage(DATA_NASCIMENTO_INVALIDA, new Object[]{dataNascimento}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarDataNascimento::Fim");
		
	}

	/**
	 * Metodo responsavel em validar a profissão.
	 * @param dadosCadastrais
	 * Bean que contém as informações cadastrais do assinante. 
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate. 
	 */
	private void validarProfissao(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarProfissao::Inicio");

		String profissao = getBeanProperty(dadosCadastrais, ASSINANTE_PROFISSAO);
		
		// Verificar se a profissão foi informada.
		String profBase = 
			snAssinante.getProfissao() != null ? snAssinante.getProfissao().getIdProfissao().toString() : null;
		if (isUpdating(profissao, profBase)) {
			if ( !informado(profissao) ) {
				errorList.add(getValidationMessage(PROFISSAO_NAO_INFORMADA, new Object[]{ASSINANTE_PROFISSAO}));
			}
			
			// Verificar se a profissão informada existe
			if ( informado(profissao) && !profissaoExistente(profissao) ) {
				errorList.add(getValidationMessage(PROFISSAO_INEXISTENTE, new Object[]{profissao}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarProfissao::Fim");
		
	}

	/**
	 * Metodo responsavel em validar a escolaridade.
	 * @param dadosCadastrais
	 * Bean que contém as informações cadastrais do assinante. 
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate. 
	 */
	private void validarEscolaridade(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){

		this.logar("ManutencaoDadosCadastraisEJBImpl:validarEscolaridade::Inicio");
		
		String escolaridade = getBeanProperty(dadosCadastrais, ASSINANTE_ESCOLARIDADE);
		
		// Verificar se a escolaridade informada existe
		String escBase = 
			snAssinante.getEscolaridade() != null ? snAssinante.getEscolaridade().getIdEscolaridade().toString() : null;
		if (isUpdating(escolaridade, escBase)) {
			if ( !informado(escolaridade) || !escolaridadeExistente(escolaridade) ) {
				errorList.add(getValidationMessage(ESCOLARIDADE_INEXISTENTE, new Object[]{escolaridade}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarEscolaridade::Fim");		
	}

	/**
	 * Metodo responsavel em validar o estado civil.
	 * @param dadosCadastrais
	 * Bean que contém as informações cadastrais do assinante. 
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate. 
	 */
	private void validarEstadoCivil(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarEstadoCivil::Inicio");
		
		String estadoCivil = getBeanProperty(dadosCadastrais, ASSINANTE_ESTADO_CIVIL);
		
		// Verificar se o estado civil foi informado;
		String ecBase = 
			snAssinante.getEstadoCivil() != null ? snAssinante.getEstadoCivil().getIdEstadoCivil().toString() : null;
		if (isUpdating(estadoCivil, ecBase)) {
			if ( !informado(estadoCivil) ) {
				errorList.add(getValidationMessage(ESTADO_CIVIL_NAO_INFORMADO, new Object[]{ASSINANTE_ESTADO_CIVIL}));
			}
			
			// Verificar se o estado civil informado existe
			if ( informado(estadoCivil) && !estadoCivilExistente(estadoCivil) ) {
				errorList.add(getValidationMessage(ESTADO_CIVIL_INEXISTENTE, new Object[]{estadoCivil}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarEstadoCivil::Fim");		
	}

	/**
	 * Metodo responsavel em validar o sexo.
	 * @param dadosCadastrais
	 * Bean que contém as informações cadastrais do assinante. 
	 * @param errorList
	 * Lista que armazena os erros pegos anteriormente, nela será adicionado os erros de validação
	 * caso exista.
	 * @param snAssinante
	 * Bean que contém as informações do assinate. 
	 */
	private void validarSexo(Bean dadosCadastrais, List<ValidationMessage> errorList, 
			SnAssinanteBean snAssinante){

		this.logar("ManutencaoDadosCadastraisEJBImpl:validarSexo::Inicio");
		
		String sexo = getBeanProperty(dadosCadastrais, ASSINANTE_SEXO);
		
		// Verificar se o sexo foi informado;
		String sxBase = snAssinante.getSexo() != null ? snAssinante.getSexo().getDescricao() : null;
		if (isUpdating(sexo, sxBase)) {
			if ( !informado(sexo) ) {
				errorList.add(getValidationMessage(SEXO_NAO_INFORMADO, new Object[]{ASSINANTE_SEXO}));
			}
			
			// Verificar se o sexo informado existe 
			if ( informado(sexo) && !sexoExistente(sexo) ) {
				errorList.add(getValidationMessage(SEXO_INEXISTENTE, new Object[]{sexo}));
			}
		}
		
		this.logar("ManutencaoDadosCadastraisEJBImpl:validarSexo::Fim");		
	}

	/**
	 * Operação que compara se dois campos do tipo inteiro são iguais. Se sim retorna Null.
	 * @param newValue Novo valor
	 * @param oldField Bean atualmente na base de dados
	 * @return Null se iguais ou instancia da class informada se diferentes
	 */
	private Object verificarCampoModificadoInteger(String newValue, Object oldField){
		Object bean = null;
		String oldValue = null;
		
		if (oldField == null) {
			oldField = Integer.valueOf(0);
		}
		oldValue = oldField.toString();
		if (oldValue == null) {
			if (newValue != null && !"".equals(newValue)) {
				bean = Integer.valueOf(newValue);
			}
		} else if (!oldValue.equals(newValue)) {
			if (newValue == null ||  newValue.equals("")) {
				newValue = "0";
			}
			bean = Integer.valueOf(newValue);
		}
		
		return bean;
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
