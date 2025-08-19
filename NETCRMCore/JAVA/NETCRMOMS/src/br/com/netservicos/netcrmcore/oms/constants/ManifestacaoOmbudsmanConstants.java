package br.com.netservicos.netcrmcore.oms.constants;


/**
 * 
* <P><B>Description : Classe de Constantes do servico Manifestação Ombudsman</B><BR>
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
* @author jorge.silva
* @since 09/04/2010
* @version $Revision: 1.2 $
*/
public class ManifestacaoOmbudsmanConstants {
	
	public static final int HASH_CODE = 31;
	
	//Datasource value.
	public static final String DATASOURCE_OMS = "NETCRMCORE_BASE_";
	public static final String BASE_OMS = "base.oms";
	
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

	// Constantes Servicos - Campos do Net Header
	public static final String NET_HEADER_APLICACAO = "aplicacao";
	public static final String NET_HEADER_FUNCIONALIDADE = "funcionalidade";
	public static final String NET_HEADER_VERSAO_SERVICO = "versaoServico";
	public static final String NET_HEADER_TOKEN = "token";
	public static final String NET_HEADER_NUMERO_PROTOCOLO = "numeroProtocolo";
	public static final String NET_HEADER_NUMERO_CHAMADA = "numeroChamada";
	public static final String NET_HEADER_USERNAME = "username";
	

	// Constantes EJB
	public static final String AGUARDANDO_ANALISE_OUVIDORIA = "0";
	public static final String PESSOA_FISICA = "F";
	public static final String PESSOA_JURIDICA = "J";
	public static final String ENVIROMENT_CONFIG = 	"META-INF/enviromentConfig.properties";
	public static final String CANAL_ATENDIMENTO = "canalAtendimento";
	
	
	//ManifestacaoOmbudsman12V1JWS
	public static final String WEBSERVICE_NAME = "ManifestacaoOmbudsman12V1JWS";
	public static final String WEBSERVICE_SERVICE_NAME = "ManifestacaoOmbudsman12V1JWSService";
	public static final String WEBSERVICE_TARGET = "http://www.netservicos.com.br/netcrmcore/ManifestacaoOmbudsman12V1";
	
	public static final String WEB_PARAM_HEADER_NAME = "NETFrameworkWSHeader";
	public static final String WEB_PARAM_HEADER_TARGET = "java:br.com.netservicos.framework.webservice.header";
	public static final String WEB_PARAM_TARGET = "java:br.com.netservicos.netcrmcore.webservices.manifestacaoombudsman.complextypes";
	public static final String WEB_METHOD_MANIFESTACAO_CONTRATO_ACTION = "incluirManifestacaoContrato";
	public static final String WEB_METHOD_MANIFESTACAO_CLIENTE_ACTION = "incluirManifestacaoCliente";
	public static final String WEB_PARAM_MANIFESTACAO_CONTRATO_NAME = "manifestacaoContrato";
	public static final String WEB_PARAM_MANIFESTACAO_CLIENTE_NAME = "manifestacaoCliente";
	
	public static final String RESOURCE_MANIFESTACAO_OMBUDSMAN = "Serviço IncluirManifestacaoOmbudsmanWebService";

}
