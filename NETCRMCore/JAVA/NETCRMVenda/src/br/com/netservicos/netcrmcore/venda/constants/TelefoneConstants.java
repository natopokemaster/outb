package br.com.netservicos.netcrmcore.venda.constants;


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
* @author marcio@mdantas.com.br
* @since 20/09/2010
* @version $Revision: 1.2 $
 */
public abstract class TelefoneConstants {
	
	//Datasource value.
	public static final String DATASOURCE_NETSMS = "NETCRMCORE_BASE_";
	public static final String BASE_NETSMS_BH = "base.belo.horizonte";
	public static final String ENVIROMENT_CONFIG = 	"META-INF/enviromentConfig.properties";

	// Perfis
	public static final String PERFIL_CONSULTA_TELEFONE = "CRM_CONSULTAR_NUMERO_TELEFONE";
	public static final String PERFIL_RESERVA_TELEFONE = "CRM_RESERVAR_NUMERO_TELEFONE";
	
    //Parametros Procudere PSN_MANTELEFONE_VOIP.CONSULTA_TELEFONE_VOIP
    public static final String PCIDADE_CONTRATO = "cidadeContrato";
    public static final String PDDD_TELEFONE = "dddTelefoneVoip";
    public static final String PTELEFONE_INICIAL = "numeroTeleefoneVoipInicial";
    public static final String PGOLDEN = "golden";
    public static final String PPORTABILIDADE = "portabilidade";
    public static final String PNUMERO_CONTRATO = "numeroContrato";
    public static final String PID_PROPOSTA = "codigoProposta";
    
	public static final String PNUMERO_CONTRATO_AVALIACAO = "numeroContratoAvaliacao";
	public static final String PCODIGO_SISTEMA_EXTERNO = "codigoSistemaExterno";
	public static final String PCODIGO_PONTO = "codigoPonto";
	public static final String MENSAGEM = "mensagem";
	
	public static final String PCRIA_SOLIC_AUTOMATICA = "criaSolicAutomatica";
	public static final String PTIPO_SOLIC_AUTOMATICA = "tipoSolicAutomatica";
	public static final String PSOLIC_PROD_DE = "solicProdDe";
	public static final String PSOLIC_PROD_PARA = "solicProdPara";
	public static final String PREUTILIZACAO_FQND_PONTO = "reutilizacaoFQDNPonto";
	public static final String PCOMMIT = "commited";
	public static final String PNUMERO_PORTA = "numeroPorta";
    
    //Campos de Retorno da Proc PSN_MANTELEFONE_VOIP.CONSULTA_TELEFONE_VOIP
    public static final String CIDADE_CONTRATO = "CID_CONTRATO";
    public static final String NUMERO_CONTRATO = "NUM_CONTRATO";
    public static final String ID_PONTO = "ID_PONTO";
    public static final String DDD_TELEFONE_VOIP = "DDD_TELEFONE_VOIP";
    public static final String NUMERO_TELEFONE_VOIP = "NUM_TELEFONE_VOIP";
    public static final String FQDN = "FQDN";
    public static final String NUMERO_PORTA = "NUM_PORTA";
    public static final String DATA_INI = "DT_INI";
    public static final String DATA_FIM = "DT_FIM";
    public static final String DATA_ALTERACAO = "DT_ALTERACAO";
    public static final String ID_STATUS_TELEFONE_VOIP = "ID_STATUS_TELEFONE_VOIP";
    public static final String GOLDEN = "GOLDEN";
    public static final String TMID = "TM_ID";
    public static final String ID_ESCOLHIDO = "ID_ESCOLHIDO";
    public static final String PUBLICAR= "PUBLICAR";
    public static final String NOME_PUBLICACAO = "NOME_PUBLICACAO";
    public static final String NUMERO_CONTRATO_AVALIACAO = "NUM_CONTRATO_AVALIACAO";
    public static final String ID_SISTEMA_EXTERNO = "ID_SISTEMA_EXTERNO";
    public static final String CIDADE_CONTRATO_ORIGEM = "CID_CONTRATO_ORIGEM";
    public static final String ID_SOFTX = "ID_SOFTX";
    public static final String FC_NUMERO_PORTADO = "FC_NUMERO_PORTADO";
    public static final String FC_INTERCEPTADO = "FC_INTERCEPTADO";
    
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
	public static final String CONTRATO_ID_CICLO_COBRANCA = "idCicloCobranca";
	public static final String CONTRATO_ID_TIPO_CONTRATO = "idTipoContrato";
	public static final String CONTRATO_ID_STATUS = "idStatusContrato";
	
	//NumeroTelefone12V1JWS
	public static final String WEBSERVICE_NAME = "NumeroTelefoneNETfone12V1JWS";
	public static final String WEBSERVICE_SERVICE_NAME = "NumeroTelefoneNETfone12V1JWSService";
	public static final String WEBSERVICE_TARGET = "http://www.netservicos.com.br/netcrmcore/NumeroTelefoneNETfone12V1";
	
	public static final String WEB_PARAM_HEADER_NAME = "NETFrameworkWSHeader";
	public static final String WEB_PARAM_HEADER_TARGET = "java:br.com.netservicos.framework.webservice.header";
	public static final String WEB_PARAM_TARGET = "java:br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes";
	public static final String WEB_METHOD_LISTAR_NUMERO_TELEFONE_ASSINANTE_ACTION = "listarTelefones";
	public static final String WEB_PARAM_LISTAR_NUMERO_TELEFONE_ASSINANTE_NAME = "listarTelefonesIn";
	public static final String WEB_METHOD_RESERVAR_NUMERO_TELEFONE_ASSINANTE_ACTION = "reservarTelefone";
	public static final String WEB_METHOD_CANCELAR_RESERVAR_NUMERO_TELEFONE_ACTION = "cancelarReservaTelefone";
	public static final String WEB_PARAM_RESERVAR_NUMERO_TELEFONE_ASSINANTE_NAME = "reservarTelefoneIn";
	public static final String WEB_PARAM_CANCELAR_RESERVAR_NUMERO_TELEFONE_NAME = "cancelarReservaTelefoneIn";

	public static final String RESOURCE_LISTAR_NUMERO_TELEFONE = "Serviço NumeroTelefoneNETfoneWebService";
	public static final String HEADER = "header";
	
	public static final String LIMITE_TELEFONES = "limiteDeTelefones";
	
	//Constantes EJB
	public static final String PROPERTY_PROPOSTA = "proposta";
	public static final String PROPERTY_CONTRATO = "numeroContrato";
	
	public static final int     ID_TECNOLOGIA_ANALOGICO     	= 8;
    public static final int     ID_TECNOLOGIA_DIGITALIZADO      = 9;
    public static final int     ID_TECNOLOGIA_DIGITAL           = 10;
    public static final int     ID_TECNOLOGIA_INTERNET          = 11;
    public static final int     ID_TECNOLOGIA_VOIP              = 12;

    public static final long    ID_CARACTERISTICA_ANALOGICO     = 0;
    public static final long    ID_CARACTERISTICA_DIGITALIZADO  = 1;
    public static final long    ID_CARACTERISTICA_DIGITAL       = 2;
    public static final long    ID_CARACTERISTICA_INTERNET      = 3;
    public static final long    ID_CARACTERISTICA_VOIP          = 4;
    
    public static final Integer CONSTANT_0          = 0;
    public static final Integer CONSTANT_1          = 1;
    public static final Integer CONSTANT_2          = 2;
    public static final Integer CONSTANT_3          = 3;
    public static final Integer CONSTANT_4          = 4;
    public static final Integer CONSTANT_5          = 5;
    public static final Integer CONSTANT_6          = 6;
    public static final Integer CONSTANT_7          = 7;
    public static final Integer CONSTANT_8          = 8;
    public static final Integer CONSTANT_9          = 9;
    public static final Integer CONSTANT_10          = 10;
    public static final Integer CONSTANT_11          = 11;
    public static final Integer CONSTANT_15          = 15;
    public static final Integer CONSTANT_25          = 25;
    public static final Integer CONSTANT_26          = 26;
    public static final Integer CONSTANT_99          = 99;
    
    //Procedures
    public static final String PROC_PSN_MANTELEFONE_VOIP_CONSULTA_TELEFONEVOIP_PORTABILIDADE 		= "{call PSN_MANTELEFONE_VOIP.CONSULTA_TELEFONE_VOIP(?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String PROC_PSN_MANTELEFONE_VOIP_RESERVA_TEL_VOIP_AVAL_APP_CLIENT  			= "{call PSN_MANTELEFONE_VOIP.PR_RESERVATELVOIPAVALAPPCLIENT(?,?,?,?,?,?,?,?,?)}";
    public static final String PROC_PSN_MANTELEFONE_VOIP_RESERVA_TEL_VOIP_AVAL_APP_CLIENT_SOFTX  	= "{call PSN_MANTELEFONE_VOIP.PR_RESERVATELVOIPAVALAPPCLIENT(?,?,?,?,?,?,?,?,?,?)}";
    public static final String PROC_PSN_MATELEFONE_PR_CONFRESERVATELVOIPAVALJAVA           			= "{call PSN_MANTELEFONE_VOIP.PR_CONFRESERVATELVOIPAVALJAVA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    public static final String PROC_PSN_MANTELEFONE_VOIP_RESERVA_TELVOIP_AVALIAR_APPCLIENT = "{call PSN_MANTELEFONE_VOIP.pr_reservatelvoipavalappclient(?,?,?,?,?,?,?,?,?,?)}";
    public static final String TELEFONES = "telefones";
    public static final String TELEFONE = "telefone";
    public static final String DDD = "ddd";
    public static final String PUBLICA_NUMERO = "publicaNumero";
    public static final String ID_PROPOSTA = "idProposta";
    
    
    public static final String LST_TELEFONE_VOIP_TO_UPDATE = "lstTelefoneVoipToUpdate";

    public static final String LST_RESERVA_TELEFONE_VOIP_TELEFONES_RESERVADOS = "lstTelefonesReservadosAssinante";
	public static final String LIST_RESERVA_TELEFONE_BY_ID_PONTO_ASSINANTE = "listReservaTelByIdPontoAssinante";
	public static final String LIST_DELETE_RESERVA_TELEFONE_BY_ID_PONTO_ASSINANTE = "lstDeleteReservasByPontoAssinante";
	
}
