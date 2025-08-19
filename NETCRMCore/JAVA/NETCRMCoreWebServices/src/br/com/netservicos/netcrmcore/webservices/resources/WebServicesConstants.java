/**
 * Created on 20/02/2008
 * Project : ModuloCobrancaWebServices
 *
 * Copyright  2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Servicos.
 * 
 * $Id: WebServicesConstants.java,v 1.10 2011/08/26 14:41:27 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.webservices.resources;

/**
 * <P><B>Description :</B><BR>
 * 	Constants for the web services.
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Anton Vlassov
 * @since 20/02/2008
 */
public final class WebServicesConstants {
	
    /**
     * Mapping for the bundle
     */
    public final static String BUNDLE_KEY = "br/com/netservicos/netcrmcore/webservices/resources/WebServicesMessages";
    
    private WebServicesConstants(){
        super();
    }
    
	
	/**
	 * WebLogic Constants
	 * 
	 */
	
	public final static String WEBLOGIC_SOAP12_FACTORY = "weblogic.xml.saaj.SOAP12FactoryImpl";
	public final static String WEBLOGIC_SOAP11_FACTORY = "weblogic.xml.saaj.SOAPFactoryImpl";
	
	public static final String RESOURCE_ERROR = "CRMCORE-0069";
	public static final String RESOURCE_ALTERAR_DADOS_CADASTRAIS_TITULAR = "EJB ManutencaoDadosCadastraisService.alterarDadosCadastraisTitular";
	public static final String RESOURCE_VALIDAR_DADOS_CADASTRAIS_TITULAR = "EJB ManutencaoDadosCadastraisService.validarDadosCadastraisTitular";
	public static final String RESOURCE_ALTERAR_DADOS_COBRANCA_CONTRATO = "EJB ManutencaoDadosCobrancaContratoService.alterarDadosCobrancaContrato";
	public static final String RESOURCE_ALTERAR_DADOS_COBRANCA_PROPOSTA = "EJB ManutencaoDadosCobrancaPropostaService.alterarDadosCobrancaProposta";	
	public static final String RESOURCE_ALTERAR_DADOS_CONTATO_TITULAR = "EJB ManutencaoDadosContatoService.alterarDadosContatoTitular";
	public static final String RESOURCE_VALIDAR_DADOS_CONTATO_TITULAR = "EJB ManutencaoDadosContatoService.validarDadosContatoTitular";
	public static final String RESOURCE_CRIAR_PROSPECT = "EJB ProspectService.criarProposta";
	public static final String RESOURCE_CRIAR_PROPOSTA_ASSINANTE = "EJB PropostaAssinanteService.criarProposta";
	public static final String RESOURCE_INSERIR_PRODUTO_PROPOSTA = "EJB ProdutoService.inserirProdutoProposta";
	public static final String RESOURCE_INSERIR_AGREGADO_PROPOSTA = "EJB AgregadoService.inserirAgregadoProposta";
	public static final String RESOURCE_CHEC_CRED_INTERNO = "EJB CreditoService.checarCreditoInterno";
	public static final String RESOURCE_CHEC_CRED_EXTERNO = "EJB CreditoService.checarCreditoExterno";
	public static final String RESOURCE_CHEC_CRED_INT_EXT = "EJB CreditoService.checarCreditoInternoExterno";
	public static final String RESOURCE_ALTERAR_DADOS_CADASTRAIS = "EJB ProspectEJBImpl.alterarDadosPessoais";
	public static final String RESOURCE_RESERVA_TELEFONE = "EJB NumeroTelefoneNETfoneEJBImpl.reservaTelefoneVoip";

	public static final String TIPO_TELEFONE_CELULAR = "CELULAR";
	public static final String TIPO_TELEFONE_COMERCIAL = "COMERCIAL";
	public static final String TIPO_TELEFONE_FAX = "FAX";
	public static final String TIPO_TELEFONE_OUTROS = "OUTROS";
	public static final String TIPO_TELEFONE_RESIDENCIAL = "RESIDENCIAL";
	public static final String RESOURCE_PROSPECT_INEXISTENTE = "CRMCORE-0076";
	public static final String RESOURCE_PROPOSTA_INEXISTENTE = "CRMCORE-0084";
	
	public static final String RESOURCE_ERROR_CANAL = "CRMCORE-0075";
	public static final String RESOURCE_ERROR_OMS = "CRMCORE-0069";
	public static final String RESOURCE_INCLUIR_MANIFESTACAO_CONTRATO = "EJB ManifestacaoOmbudsmanService.incluirManifestacaoContrato";
	public static final String RESOURCE_INCLUIR_MANIFESTACAO_CLIENTE = "EJB ManifestacaoOmbudsmanService.incluirManifestacaoCliente";

	public static final String RESOURCE_ERROR_CONSULTAR_CONTRATOS = "CRMCORE-0077";
	public static final String RESOURCE_CONSULTAR_CONTRATOS_POR_EDIFICACAO = "EJB ConsultarContratosService.consultarContratosPorEdificacao";
	
	public static final String RESOURCE_ERROR_LISTAR_TELEFONES = "CRMCORE-0079";
	public static final String RESOURCE_LISTAR_TELEFONES = "EJB NumeroTelefoneService.listarTelefones";
	
	public static final String RESOURCE_ERROR_RESERVAR_TELEFONES = "CRMCORE-0081";
	public static final String RESOURCE_RESERVAR_TELEFONES = "EJB NumeroTelefoneService.reservarTelefones";
	
	public static final String RESOURCE_ERROR_LISTAR_OPERADORA_TELEFONIA = "CRMCORE-00783";
	public static final String RESOURCE_LISTAR_OPERADORA_TELEFONIA = "EJB OperadoraTelefoniaService.listarOperadoraTelefonia";

	public static final String RESOURCE_DELETE_ALL_PRODUTOS_PROPOSTA = "EJB ProdutoService.deleteAllProdutosProposta";
	public static final String RESOURCE_DELETE_LST_AGREGADOS_PROPOSTA = "EJB ProdutoService.deleteLstAgregadosProposta";
	
	public static final String RESOURCE_MANUTENCAO_EXTENSAO_FONE = 
		"EJB ManutencaoExtensaoFoneService.solicitarExtensaoFone";
	public static final String RESOURCE_ERROR_EXTENSAO_FONE = "CRMCORE-0001";
	
	// constantes demanda RLCP_33577_NI_004_CI_001
	public static final String RESOURCE_MANUTENCAO_DADOS_CONTRATO_PARCERIA_CANCELAR_PRODUTO = "EJB ManutencaoDadosContratoParceria.cancelarProduto";
    public static final String RESOURCE_MANUTENCAO_DADOS_CONTRATO_PARCERIA = "EJB ManutencaoDadosContratoParceria.registrarParceriaContrato";
    public static final String RESOURCE_ERROR_REGISTRAR_CONTRATO_PARCERIA = "CRMCORE-0001";

    public static final String RESOURCE_CONTRATO_PARCERIA_ALTERAR_NUMERO_CELULAR = "EJB ManutencaoDadosContratoParceria.alterarNumeroCelular";
    public static final String RESOURCE_CONTRATO_PARCERIA_CANCELAR_PRODUTO = "EJB ManutencaoDadosContratoParceria.cancelarProduto";
    public static final String RESOURCE_CONTRATO_PARCERIA_REGISTRAR_PARCERIA_CONTRATO = "EJB ManutencaoDadosContratoParceria.registrarParceriaContrato";

    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_ABORTAR_EVENTO = "EJB ControleIntegracaoParceiro.abortarEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_APLICAR_POLITICA_RETENTATIVA = "EJB ControleIntegracaoParceiro.aplicarPoliticaRetentativa";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_BUSCAR_EVENTO = "EJB ControleIntegracaoParceiro.buscarEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_FECHAR_EVENTO = "EJB ControleIntegracaoParceiro.fecharEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_OBTER_EVENTOS = "EJB ControleIntegracaoParceiro.obterEventos";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_REGISTRAR_ERRO_INTEGRACAO_EVENTO = "EJB ControleIntegracaoParceiro.registrarErroIntegracaoEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_REGISTRAR_INTEGRACAO_EVENTO = "EJB ControleIntegracaoParceiro.registrarIntegracaoEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_REGISTRAR_PUBLICACAO_EVENTO = "EJB ControleIntegracaoParceiro.registrarPublicacaoEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_REGISTRAR_RECEBIMENTO_EVENTO = "EJB ControleIntegracaoParceiro.registrarRecebimentoEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_REGISTRAR_RESPOSTA_EVENTO = "EJB ControleIntegracaoParceiro.registrarRespostaEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_PUBLICAR_EVENTO = "EJB ControleIntegracaoParceiro.publicarEvento";
    public static final String RESOURCE_CONTROLE_INTEGRACAO_PARCEIRO_INTEGRAR_EVENTO = "EJB ControleIntegracaoParceiro.integrarEvento";

    public static final String VERDADEIRO = "true";
    public static final String FALSO = "false";

    // constantes usadas na declaração dos web services
    public static final String NETHEADER = "NetHeader";
    public static final String REQUESTHEADER = "requestHeader";
    
    //Contants  dos servicos Manutencacao dado cobranca contrato/proposta
    public static final String NR_CONTRATO = "numContrato";
    public static final String CD_CIDADE = "ciNome";
    public static final String INDICADOR_COBOLETAMENTO = "indicadorCoBoletamento";
    public static final String TIPO_POSTAGEM = "idTipoPostagem";
    public static final String NOME_CONTATO = "nomeContato";
    public static final String TELEFONE_CONTATO = "telefoneContato";
    public static final String OBSERVACAO = "observacao";
    public static final String HEADER = "header";
    public static final String NR_PROPOSTA = "numProposta";
    public static final String MESSAGE_ERROR_PROPOSTA = "manutencao.dados.cobranca.proposta.error";
    public static final String MESSAGE_ERROR_CONTRATO = "manutencao.dados.cobranca.contrato.error";
    
    //Constants dos servicos Aviso Relacionamento
    public static final String RESOURCE_ERROR_GERAR_PDF = "CRMCORE-0111";
    public static final String RESOURCE_ERROR_MOTIVO_INVALIDO = "CRMCORE-0112";
    public static final String RESOURCE_ERROR_ID_AVISO_INVALIDO = "CRMCORE-0113";
    public static final String RESOURCE_AVISO_RELACIONAMENTO_CONSULTAR = "EJB AvisoRelacionamentoService.consultar";
    public static final String RESOURCE_AVISO_RELACIONAMENTO_GERAR_PDF = "EJB AvisoRelacionamentoService.gerarPDF";
    public static final String RESOURCE_AVISO_RELACIONAMENTO_SOLICITAR_REENVIO = "EJB AvisoRelacionamentoService.solicitarReenvio";
    
    public static final String RESOURCE_ERROR_CRIAR_RECIBO = "CRMCORE-0109";
    public static final String RESOURCE_ERROR_CRIAR_RECIBO_DUPLICADO = "CRMCORE-0114";
    public static final String RESOURCE_CRIAR_RECIBO_RELACIONAMENTO = "EJB ReciboRelacionamentoService.criarReciboRelacionamento";
    
}