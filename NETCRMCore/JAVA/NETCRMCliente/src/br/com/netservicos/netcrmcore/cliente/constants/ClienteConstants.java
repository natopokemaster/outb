package br.com.netservicos.netcrmcore.cliente.constants;

/**
 * 
* <P><B>Description :</B><BR>
* TODO descrever
* </P>
* <P>
* <B> Issues : <BR>
* </B>
* <PRE>    
* ==============================================================================
* Description                              Date        By
* ---------------------------------------- ----------- ------------------------
* 
* ==============================================================================
* </PRE>
*
* <P><B>
* Revision History:
* </B><PRE>
* ==============================================================================
*                           Prior
* Date       By             Version  Project/CSR    	Description
* ---------- -------------- -------- --------------    -------------------------
* 
* ==============================================================================
* </PRE>
*
* @author gmello
* @since 30/12/2009
* @version $Revision: 1.5 $
 */
public abstract class ClienteConstants {
	
	// Perfis
	public static final String PERFIL_ATENDENTE = "ALTERACAO_DADOS_CADASTRAIS_LIVRES";
	public static final String PERFIL_BACKOFFICE = "ALTERACAO_DADOS_CADASTRAIS_RESTRITOS";

	// Campos do Net Header
	public static final String NET_HEADER_APLICACAO = "aplicacao";
	public static final String NET_HEADER_FUNCIONALIDADE = "funcionalidade";
	public static final String NET_HEADER_VERSAO_SERVICO = "versaoServico";
	public static final String NET_HEADER_TOKEN = "token";
	public static final String NET_HEADER_NUMERO_PROTOCOLO = "numeroProtocolo";
	public static final String NET_HEADER_NUMERO_CHAMADA = "numeroChamada";
	public static final String NET_HEADER_USERNAME = "username";
	
	// Campos do Contrato
	public static final String CONTRATO_CIDADE = "cidContrato";
	public static final String CONTRATO_NUM_CONTRATO = "numContrato";
	public static final String ID_PROPOSTA_ASSINANTE = "idPropostaAssinante";
	public static final String CONTRATO_ID_CICLO_COBRANCA = "idCicloCobranca";
	public static final String CONTRATO_ID_TIPO_CONTRATO = "idTipoContrato";
	public static final String CONTRATO_ID_STATUS = "idStatusContrato";
	
	// Campos do Assinante
	public static final String ASSINANTE_NOME_TITULAR = "NOME TITULAR";
	public static final String ASSINANTE_TIPO_PESSOA = "TIPO PESSOA";
	public static final String ASSINANTE_TIPO_PESSOA_FISICA = "PESSOA FISICA";
	public static final String ASSINANTE_TIPO_PESSOA_JURIDICA = "PESSOA JURIDICA";
	public static final String ASSINANTE_DATA_NASCIMENTO = "DATA NASCIMENTO";
	public static final String ASSINANTE_CPF = "CPF";
	public static final String ASSINANTE_RG = "RG";
	public static final String ASSINANTE_ORGAO_EXPEDIDOR = "ORGAO EXPEDIDOR";
	public static final String ASSINANTE_ESTRANGEIRO = "ESTRANGEIRO";
	public static final String ASSINANTE_PASSAPORTE = "PASSAPORTE";
	public static final String ASSINANTE_NOME_PAI = "NOME PAI";
	public static final String ASSINANTE_NOME_MAE = "NOME MAE";
	public static final String ASSINANTE_SEXO = "SEXO";
	public static final String ASSINANTE_ESTADO_CIVIL = "ESTADO CIVIL";
	public static final String ASSINANTE_PROFISSAO = "PROFISSAO";
	public static final String ASSINANTE_ESCOLARIDADE = "ESCOLARIDADE";
	public static final String ASSINANTE_CNPJ = "CNPJ";
	public static final String ASSINANTE_INSCRICAO_ESTADUAL = "INSCRICAO ESTADUAL";
	public static final String ASSINANTE_CODIGO_SUFRAMA = "CODIGO SUFRAMA";
	public static final String ASSINANTE_CODIGO = "codigoAssinante";
	public static final String ASSINANTE_NOME_TITULAR_ASINANTE = "nomeTitular";
	
	// Campos do dado contato
	public static final String DADOS_CONTATO_EMAIL = "EMAIL";
	public static final String DADOS_CONTATO_ACEITA_CONTATO = "ACEITA CONTATO";
	public static final String DADOS_CONTATO_RESIDENCIAL = "RESIDENCIAL";
	public static final String DADOS_CONTATO_DDD_RESIDENCIAL = "DDD RESIDENCIAL";
	public static final String DADOS_CONTATO_TELEFONE_RESIDENCIAL = "TELEFONE RESIDENCIAL";
	public static final String DADOS_CONTATO_RAMAL_RESIDENCIAL = "RAMAL RESIDENCIAL";
	public static final String DADOS_CONTATO_COMERCIAL = "COMERCIAL";
	public static final String DADOS_CONTATO_DDD_COMERCIAL = "DDD COMERCIAL";
	public static final String DADOS_CONTATO_TELEFONE_COMERCIAL = "TELEFONE COMERCIAL";
	public static final String DADOS_CONTATO_RAMAL_COMERCIAL = "RAMAL COMERCIAL";
	public static final String DADOS_CONTATO_CELULAR = "CELULAR";
	public static final String DADOS_CONTATO_DDD_CELULAR = "DDD CELULAR";
	public static final String DADOS_CONTATO_TELEFONE_CELULAR = "TELEFONE CELULAR";
	public static final String DADOS_CONTATO_RAMAL_CELULAR = "RAMAL CELULAR";
	public static final String DADOS_CONTATO_FAX = "FAX";
	public static final String DADOS_CONTATO_DDD_FAX = "DDD FAX";
	public static final String DADOS_CONTATO_TELEFONE_FAX = "TELEFONE FAX";
	public static final String DADOS_CONTATO_RAMAL_FAX = "RAMAL FAX";
	public static final String DADOS_CONTATO_OUTROS = "OUTROS";
	public static final String DADOS_CONTATO_DDD_OUTROS = "DDD OUTROS";
	public static final String DADOS_CONTATO_TELEFONE_OUTROS = "TELEFONE OUTROS";
	public static final String DADOS_CONTATO_RAMAL_OUTROS = "RAMAL OUTROS";
	
	// Campos do registro contato
	public static final String DADOS_REGISTRO_CONTATO_EVENTO = "1";
	public static final String DADOS_REGISTRO_CONTATO_NOME_CONTATO = "nomeContato";
	public static final String DADOS_REGISTRO_CONTATO_DDD_TELEFONE = "dddTelefone";
	public static final String DADOS_REGISTRO_CONTATO_NUMERO_TELEFONE = "numeroTelefone";
	public static final String DADOS_REGISTRO_CONTATO_OBSERVACAO = "observacao";
	public static final String DADOS_REGISTRO_CONTATO_TIPO_EVENTO_REGISTRO_CONTATO   = "CA1 - AUT - ALTERACAO DE OUTROS DADOS CADASTRAIS";
	public static final String DADOS_REGISTRO_CONTATO_TIPO_EVENTO_REQUISICAO_INTERNA = "CA1 - DOC - ALTERACAO DO CPF/RG";
	public static final String PARAMETRO_REGISTRO_CONTATO = "ID_TPO_OCOR_REG_CONT";
	
	//Campos do imovel (HP)
	public static final String HP_IMOVEL_CODIGO_OPERADORA = "codigoOperadora";
	public static final String HP_IMOVEL_CODIGO_HP = "codigoHP";
	
	// Constantes
	public static final String VALOR_ISENTO = "ISENTO";
	public static final String RESOURCE_INCLUIR_REGISTRO_CONTATO = "Serviço IncluirRegistroContatoWebService";
	public static final String RESOURCE_INCLUIR_REQUISICAO_INTERNA = "Serviço IncluirRequisicaoInternaWebService";
	public static final String APPLICATION_CONTEXT_WEBSERVICE_XML = "META-INF/applicationContext-netcrmcore-webservices.xml";
	
	//ConsultarContratos12V1JWS
	public static final String WEBSERVICE_NAME = "ConsultarContratos12V1JWS";
	public static final String WEBSERVICE_SERVICE_NAME = "ConsultarContratos12V1JWSService";
	public static final String WEBSERVICE_TARGET = "http://www.netservicos.com.br/netcrmcore/ConsultarContratos12V1";
	
	public static final String WEB_PARAM_HEADER_NAME = "NETFrameworkWSHeader";
	public static final String WEB_PARAM_HEADER_TARGET = "java:br.com.netservicos.framework.webservice.header";
	public static final String WEB_PARAM_TARGET = "java:br.com.netservicos.netcrmcore.webservices.consultarcontratos.complextypes";
	public static final String WEB_METHOD_CONSULTAR_CONTRATOS_EDIFICACAO_ACTION = "consultarContratosPorEdificacao";
	public static final String WEB_PARAM_IDENTIFICACAO_OPERADORA_NET_NAME = "identificaoOperadoraNET";
	public static final String WEB_PARAM_CONSULTAR_CONTRATOS_EDIFICACAO_NAME = "contratoEdificacaoIn";
	public static final String RESOURCE_CONSULTAR_CONTATOS = "Serviço ConsultarContratosWebService";
	
	
	//ManterProspect12V1JWS
	public static final String WEBSERVICE_NAME_CRIAR_PROSPECT = "ManterProspect12V1JWS";
	public static final String WEBSERVICE_SERVICE_NAME_CRIAR_PROSPECT = "ManterProspect12V1JWSService";
	public static final String WEBSERVICE_TARGET_CRIAR_PROSPECT = "http://www.netservicos.com.br/netcrmcore/ManterProspect12V1";
	public static final String WEB_METHOD_CRIAR_PROSPECT_ACTION = "criarProposta";
	public static final String WEB_PARAM_TARGET_CRIAR_PROSPECT = "java:br.com.netservicos.netcrmcore.webservices.prospect.manterprospect.complextypes";
	public static final String WEB_PARAM_CRIAR_PROSPECT_NAME = "dadosProspectIn";
	public static final String WEB_PARAM_CRIAR_PROSPECT_NOME_NAME = "nome";
	public static final String WEB_PARAM_CRIAR_PROSPECT_CID_CONTRATO_NAME = "cidadeContrato";
	public static final String WEB_PARAM_CRIAR_PROSPECT_DDD_TELEFONE_NAME = "dddTelPrincipal";
	public static final String WEB_PARAM_CRIAR_PROSPECT_TELEFONE_NAME = "telPrincipal";
	
	//ManterPropostaAssinante12V1JWS
    public static final String WEBSERVICE_NAME_CRIAR_PROPOSTA_ASSINANTE= "ManterPropostaAssinante12V1JWS";
    public static final String WEBSERVICE_SERVICE_NAME_CRIAR_PROPOSTA_ASSINANTE = "ManterPropostaAssinante12V1JWSService";
    public static final String WEBSERVICE_TARGET_CRIAR_PROPOSTA_ASSINANTE = "http://www.netservicos.com.br/netcrmcore/ManterPropostaAssinante12V1";
    public static final String WEB_METHOD_CRIAR_PROPOSTA_ASSINANTE_ACTION = "criarProposta";
    public static final String WEB_METHOD_FINALIZAR_PROPOSTA_ASSINANTE_ACTION = "finalizarProposta";
    public static final String WEB_PARAM_TARGET_CRIAR_PROPOSTA_ASSINANTE = "java:br.com.netservicos.netcrmcore.webservices.base.manterproposta.complextypes";
    public static final String WEB_PARAM_CRIAR_PROPOSTA_ASSINANTE_NAME = "dadosPropostaAssinanteIn";
    
    
    
    
	
	// Constantes WebBean
	public static final String IDCANALATENDIMENTO = "idCanalAtendimento";
	public static final String DSCANALATENDIMENTO = "dsCanalAtendimento";
	public static final String CDOPERADORA = "cdOperadora";
	public static final String CDPROTOCOLO = "cdProtocolo";
	public static final String CDCIDADE = "cdCidade";
	public static final String CDCONTRATO = "cdContrato";
	public static final String CPF = "cpf";
	public static final String CNPJ = "cnpj";
	public static final String DSMANIFESTACAO = "dsManifestacao";
	public static final String DSCOMPLEMENTO = "dsComplemento";
	public static final String DSASSUNTO = "dsAssunto";
	public static final String DSEMAIL = "dsEmail";
	public static final String NMCIDADE = "nmCidade";
	public static final String NMBAIRRO = "nmBairro";
	public static final String NMLOGRADOURO = "nmLogradouro";
	public static final String NMCLIENTE = "nomeCliente";
	public static final String NRTELEFONECLIENTE = "nrTelCliente";
	public static final String NRCEP = "nrCep";
	public static final String NRDOCUMENTO = "nrDocumento";
	public static final String NRLOGRADOURO = "nrLogradouro";
	public static final String SGUF = "sgUf";
	public static final String TPPESSOA = "TpPessoa";
	public static final String HEADER = "header";
	
	

	
}
