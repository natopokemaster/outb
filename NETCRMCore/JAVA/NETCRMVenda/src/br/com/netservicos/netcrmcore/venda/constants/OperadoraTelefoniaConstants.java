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
* 04/10/2010 Márcio Dantas	1.0		  NETCombo			Criação.
* ==============================================================================
* </PRE>
*
* @author marcio@mdantas.com.br
* @since 04/10/2010
* @version $Revision: 1.2 $
 */
public abstract class OperadoraTelefoniaConstants {
	
	//Datasource value.
	public static final String DATASOURCE_NETSMS = "NETCRMCORE_BASE_";
	public static final String BASE_NETSMS_BH = "base.belo.horizonte";
	public static final String ENVIROMENT_CONFIG = 	"META-INF/enviromentConfig.properties";

	// Perfis
	public static final String PERFIL_CONSULTA_TELEFONE = "CRM_LISTAR_OPERADORA_TELEFONIA";
	
    //Campos de Entrada do WS
	public static final String PNUMERO_DDD = "numeroDDD";
	
    //Campos de Retorno do WS
    public static final String CODIGO_OPERADORA_TELEFONIA = "codigoOperadoraTelefonia";
    public static final String NOME_OPERADORA_TELEFONIA = "nomeOperadoraTelefonia";
    public static final String PRODUTO_EBT = "produtoEBT";
    public static final String NUMERO_DDD = "numeroDDD";
    
	// Campos do Net Header
	public static final String NET_HEADER_APLICACAO = "aplicacao";
	public static final String NET_HEADER_FUNCIONALIDADE = "funcionalidade";
	public static final String NET_HEADER_VERSAO_SERVICO = "versaoServico";
	public static final String NET_HEADER_TOKEN = "token";
	public static final String NET_HEADER_NUMERO_PROTOCOLO = "numeroProtocolo";
	public static final String NET_HEADER_NUMERO_CHAMADA = "numeroChamada";
	public static final String NET_HEADER_USERNAME = "username";
	
	//OperadoraTelefonia12V1JWS
	public static final String WEBSERVICE_NAME = "OperadoraTelefonia12V1JWS";
	public static final String WEBSERVICE_SERVICE_NAME = "OperadoraTelefonia12V1JWSService";
	public static final String WEBSERVICE_TARGET = "http://www.netservicos.com.br/netcrmcore/OperadoraTelefonia12V1";
	
	public static final String WEB_PARAM_HEADER_NAME = "NETFrameworkWSHeader";
	public static final String WEB_PARAM_HEADER_TARGET = "java:br.com.netservicos.framework.webservice.header";
	public static final String WEB_PARAM_TARGET = "java:br.com.netservicos.netcrmcore.webservices.venda.operadora.complextypes";
	public static final String WEB_METHOD_LISTAR_OPERADORA_TELEFONIA_ACTION = "listarOperadoraTelefonia";
	public static final String WEB_PARAM_LISTAR_OPERADORA_TELEFONIA_NAME = "listarOperadoraTelefoniaIn";

	public static final String RESOURCE_LISTAR_NUMERO_TELEFONE = "Serviço OperadoraTelefoniaWebService";
	public static final String HEADER = "header";
}
