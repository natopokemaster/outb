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
* @author Wellington Maeda
* @since 30/12/2009
* @version $Revision: 1.4 $
 */
public abstract class CreditoConstants {
	
	/** Procedure para execucao de consulta ao credito externo nas base que estiver executando a proposta.*/
    public static final String PLSQL_CRED_EX_NETSALES = 
    	"{CALL netsales.psn_credito_externo.pr_verifica_credito_externo" +
    	"(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    /** Procedure para execucao de consulta ao credito externo na base SPC. */
    public static final String PLSQL_CREDITO_EXTERNO_SPC = 
    	"{CALL psn_credito_externo.pr_verifica_credito_externo" +
    	"(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    /** Procedure para execucao de inserção na tabela spc_cons. */
    public static final String PR_INSERE_REQUISICAO = 
    	"{CALL netsales.psn_credito_externo.pr_insere_requisicao" +
    	"(?,?,?,?,?,?,?,?,?,?,?,?)}";
    /** Procedure para execucao de ATUALIZAÇÃO na tabela spc_cons. */
    public static final String PR_ATUALIZA_REQUISICAO = 
    	"{CALL netsales.psn_credito_externo.pr_atualiza_requisicao" +
    	"(?,?,?,?,?,?,?,?,?,?,?,?)}";
    /** Procedure para execucao de pegar o registro do credito interno. */
    public static final String PR_PEGA_DADOS_SPC_CONS = 
    	"{CALL netsales.psn_credito_externo.pr_pega_dados_spc_cons" +
    	"(?,?,?,?,?,?,?,?,?)}";
    /** Procedure para execucao de inserão na tabela de det_spc. */
    public static final String PR_INSERE_RETORNO_SERASA = 
    	"{CALL netsales.psn_credito_externo.pr_insere_retorno_serasa" +
    	"(?,?,?,?,?,?)}";
    /** Procedure para execucao de consulta ao credito interno. */
    public static final String PLSQL_CREDITO_INTERNO =
    	"{? = call FSN_PERMITE_VENDA_CPF(?,?,?)}";

    public static final String PROC_STATUS_CREDITO_APROVADO = "S";
    public static final String PROC_STATUS_CREDITO_REPROVADO = "N";
    public static final String PROC_STATUS_AGUARDANDO_SCPC = "E"; 
    public static final String PROC_STATUS_CONSULTA_NAO_EXECUTADA_SCPC = "V";
    public static final String PROC_STATUS_ERRO_CONSULTA_SCPC = "A";

    public static final String PESQUISA_BLACK_LISTA_ATIVA = "0";
    public static final String PESQUISA_DUPLIDADE_CPF_ATIVA = "0";
    public static final String ATIVAR_CONWEB_SERASA_ATIVA = "0";
    public static final String CREDITO_EXTERNO_APROVADO = "APROVADO";
    public static final String CREDITO_EXTERNO_NAO_APROVADO = "NÃO APROVADO";
    public static final String CREDITO_EXTERNO_DADOS_INVALIDOS = "DADOS INVALIDOS PARA CONSULTA 03. CPF: ";
    public static final String CREDITO_EXTERNO_FALHA_EXECUCAO = "FALHA NA EXECUCAO DO WEBSERVICE 05,06. CPF: ";
    public static final String CREDITO_EXTERNO_NADA_CONSTA = "NADA CONSTA 01,02. CPF: ";
    public static final String CREDITO_EXTERNO_REPROVADO = "OCORRENCIAS DE DEBITOS/TITULOS PROTESTADOS 04. CPF: ";    
    public static final String CREDITO_EXTERNO_RETORNO_OK = "1";
    public static final String CREDITO_EXTERNO_COD_RESPOSTA_NADA_CONSTA = "120";
    public static final String CREDITO_EXTERNO_COD_RESPOSTA_NAO_APROVADO = "125";
    public static final String CREDITO_EXTERNO_COD_RESPOSTA_DEMAIS_SIT = "000";
    public static final String DBSERVICE_NAME = "NETSALES_BASE_SPC";
    public static final String JDBC_DAO = "jdbc";
    
	// Pendencias Constants    
    public static final int CREDITO_EXTERNO = 2;
    public static final int CREDITO_INTERNO = 3;
    public static final int VERIFICACAO_CREDITO_EXTERNO = 4;
    public static final int VERIFICACAO_CREDITO_INTERNO = 5; 
    public static final int AGUARDANDO_SPC = 10;
    public static final int ERROR_SPC = 11;
    public static final int SOLICITADA_OPERADOR = 12;
    public static final int DADOS_INCONSISTENTES = 13;
    public static final int DOCUMENTO_PENDENTE = 14;
    public static final int RESERVA_TELEFONICA = 15;
    public static final int CARACTERISTICA_PERFIL_FALTANDO = 16;
    public static final long CARACTERISTICA_PERFIL_FALTANDO_VARIACAO = 27;
    public static final long ENVIO_DOCUMENTO = 17;    
    public static final int BLACK_LIST_EBT = 18;
    public static final int DUPLICIDADE = 19;        
    public static final long RESERVA_TELEFONICA_PORTABILIDADE = 20;
    
    // Pendencias Variacoes Constants
    public static final int ENDERECO_BLOQUEADO_ENGENHARIA = 12;
    public static final int ENDERECO_EM_ANALISE = 10;
    public static final int ENDERECO_FORA_AREA = 14;
    public static final int ENDERECO_HP_INSTALADO = 9;
    public static final int CONTRATOS_COLETIVOS_EDIFICACAO = 24;
    public static final int ENDERECO_INADINPLENTE = 20;
    public static final int ENDERECO_REJEITADO = 11;    
    public static final int INSTALACAO_NAO_DISPONIVEL = 13;
    public static final int MDU_EM_DISPONIBILIZACAO = 16;
    public static final int MDU_INTERROMPIDO = 17;
    public static final int MDU_SEM_BACKBONE = 15;
    public static final int NAO_CONSEGUE_ABRIR_SOLICITACAO = 19;
    public static final int PENDENTE_INSTALACAO = 18;    
    public static final int PROPOSTA_PEND_VERIFC_CRED_EXT = 21;    
    public static final int PROPOSTA_PEND_VERIFC_CRED_INT = 22;    
    public static final int RESERVAR_TELEFONE = 26;
    public static final int RESERVAR_TELEFONE_PORTABILIDADE = 102;
    public static final Long PENDENCIA_VARIACAO_18 = 18l;
    public static final Integer PENDENCIA_VARIACAO_19 = 19;
    public static final Long PENDENCIA_VARIACAO_29 = 29l;
    
    // Constantes status proposta
    public static final int STATUS_ABERTA = 1;
	public static final int STATUS_NAO_SE_APLICA = 2;
	public static final int STATUS_EM_ANDAMENTO = 3;
	public static final int STATUS_ENVIADA = 4;
	public static final int STATUS_CANCELADA = 5;
	public static final int STATUS_PENDENTE = 6;
	public static final int STATUS_PENDENTE_EM_AGENDAMENTO = 7;
	public static final int STATUS_FINALIZADA = 8;
	public static final int STATUS_ERRO_ENVIO = 9;
	
	//Status proposta
	public static final int STATUS_VALIDANDO = 2;
	public static final int STATUS_APROVADO = 1;
	public static final int STATUS_REPROVADO = 0;
	public static final int STATUS_ERRO_CONSULTA_SCPC = -1;
	    
	//Querys
	public static final String LST_PARAN_VERIFICA_DUPLICIDADE_CPF = "lstParamConsultaDuplicidadeCpf";
	public static final String LST_PARAN_VERIFICA_BLACK_LIST = "lstParamConsultaBlackList";
	public static final String LST_ALL = "lstCpCidadeOperadora";
	public static final String LST_PARAN_VALIDAR_SERASA = "lstParamValidarSerasa";
	public static final String FIND_SN_VLR_PARAMETRO = "findVlrParametro";
	public static final String FIND_PEND_VARIACAO = "findRelPendenciaVariacao";
	public static final String LST_DUPLICIDADE_CPF = "lstDuplicidadeCpf";
	public static final String LST_DUPLICIDADE_CNPJ = "lstDuplicidadeCnpj";
	public static final String LST_PEND_EMBRATEL= "lstPendenciaDuplicidadeEmbratelToDelete";
	public static final String LST_DUPL_PROPOSTA= "lstContratoDuplicidadeProposta";
	public static final String LST_PEND_FRAUDE_EMBR_CPF="lstPendenciaFraudeEmbratelCpf";
	public static final String LST_PEND_FRAUDE_EMBR_CNPJ="lstPendenciaFraudeEmbratelCnpj";
	public static final String VALR_PEFIN_ULT ="VALR PEFIN ULT";
	public static final String VALR_PENDENCIAS_FINAN ="VALR PENDENCIAS FINANCEIRAS ULT";
	public static final String ARROBA ="@";
	public static final String CID_CONTRATO ="cidContrato";
	public static final String NOME_PARAMETRO ="nomeParametro";
	public static final String ID_PENDENCIA ="idPendencia";
	public static final String ID_VARIACAO ="idVariacao";
	public static final String FIND_BASES ="findBasesNETSMS"; 
	
	public static final String NUM_MESES_TELECHEQUE = "NUM_MESES_TELECHEQUE";
	public static final String MESES_MINIMO_SCPC = "MESES_MINIMO_SCPC";
	public static final String MESES_MAXIMO_SCPC = "MESES_MAXIMO_SCPC";
	public static final String VALOR_MINIMO_SCPC = "VALOR_MINIMO_SCPC";
	public static final String DADOS_POLITICA = "DADOSPOLITICA";
	public static final String DATA_ULT_OCORR = "DATA DA ULTIMA OCORRENCIA DO CHEQUE";
	public static final String VR_CHEQUES_SEM_FUNDOS = "VR CHEQUES SEM FUNDOS ATE A DATA";
	public static final String DATA_ULTIMA_OCORR_PROTE = "DATA DA ULTIMA OCORRENCIA DO PROTESTO";
	public static final String VR_PROTESTOS_ATE_DATA = "VR PROTESTOS ATE A DATA";
	public static final String DATA_ULTIMA_OCORR_ACOES = "DATA DA ULTIMA OCORRENCIA DAS ACOES JUDI";
	public static final String DATA_ULTIMA_OCORR_REFIN = "DATA DA ULTIMA OCORRENCIA DO REFIN";
	public static final String DATA_ULTIMA_OCORR_PEFIN = "DATA DA ULTIMA OCORRENCIA DO PEFIN";
	public static final String VENCTO = "VENCTO -";
	public static final String DATA = "- 03 DATA -";
	public static final String VR_ACOES_JUDICIAIS_ATE_DATA = "VR ACOES JUDICIAIS ATE A DATA";
	public static final String GRAFIA_TITULAR = "GRAFIA DO TITULAR";
	public static final String GRAFIA_MAE = "GRAFIA DA MAE";
	public static final String DATA_DE_NASCIMENTO = "DATA DE NASCIMENTO";
	
	
	public static final String LST_PARAN_HAB_CONS_WEB_SERVICE_SERASA = "lstParamHabilConsWebServiSerasa";
	
	public static final String CREDITO_APROVADO = "Cr\u00e9dito Aprovado";
	public static final String CREDITO_REPROVADO = "Cr\u00e9dito Reprovado";
	public static final String PROB_CONS_SCPC = "Problemas na consulta ao SCPC";
	public static final String VALIDANDO = "Validando Cr\u00e9dito...";
	public static final String ID_PROSPECT = "idProspect";
	public static final String CPF = "cpf";
	public static final String CNPJ = "cnpj";
	public static final String ID_TIPO_PESSOA = "idTipoPessoa";
	public static final String IE = "ie";
	public static final String VERIFICACAO_CREDITO = "verificacaoCredito";
	public static final Integer CONSTANT_07 = 7;
	public static final Integer CONSTANT_40 = 40;
	public static final Integer CONSTANT_25 = 25;
	public static final Integer CONSTANT_03 = 3;
	public static final Integer CONSTANT_23 = 23;
	public static final Integer CONSTANT_22 = 22;
	public static final Integer CONSTANT_21 = 21;
	public static final Integer CONSTANT_06 = 6;
	public static final Integer CONSTANT_05 = 5;
	public static final Integer CONSTANT_04 = 4;
	public static final Integer CONSTANT_02 = 2;
	public static final Integer CONSTANT_12 = 12;
	public static final Integer CONSTANT_13 = 13;
	public static final Integer CONSTANT_11 = 11;
	public static final Integer CONSTANT_08 = 8;
	public static final Integer CONSTANT_95 = 95;
	public static final String RETORNO = "retorno";
	public static final String ID_PROPOSTA = "idProposta";
	
	public static final String  USER_GC = "userGC";
	public static final String  PASS_GC = "passGC";
	public static final String  USER_SERASA = "userSerasa";
	public static final String  PASS_SERASA = "passSerasa";
	
	
	public static final String WEBSERVICE_TARGET = "http://www.netservicos.com.br/netcrmcore/ChecagemCredito12V1";
	public static final String WEBSERVICE_NAME = "ChecagemCredito12V1JWS";
	public static final String WEBSERVICE_SERVICE_NAME = "ChecagemCredito12V1JWSService";
	public static final String WEB_METHOD_CHECAR_CRED_INTERNO_ACTION = "checarCreditoInterno";
	public static final String WEB_METHOD_CHECAR_CRED_EXTERNO_ACTION = "checarCreditoExterno";
	public static final String WEB_METHOD_CHECAR_CRED_INT_EXT_ACTION = "checarCreditoInternoExterno";
	public static final String WEB_PARAM_HEADER_NAME = "NETFrameworkWSHeader";
	public static final String WEB_PARAM_HEADER_TARGET = "java:br.com.netservicos.framework.webservice.header";
	public static final String WEB_PARAM_CHECAR_CREDITO_INTERNO = "checarCreditoInterno";
	public static final String WEB_PARAM_CHECAR_CREDITO_EXTERNO = "checarCreditoExterno";
	public static final String WEB_PARAM_CHECAR_CREDITO_INT_EXT = "checarCreditoInternoExterno";
	public static final String WEB_PARAM_TARGET = 
		"java:br.com.netservicos.netcrmcore.webservices.checagemcredito.complextypes";
	
}
