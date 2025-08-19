package br.com.netservicos.netcrmcore.venda.constants;

/**
 * 
* <P><B>Description :</B><BR>
* Constantes usadas pelos projetos relacionados a venda.
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
* @author mcalegari
* @since 25/02/2010
* @version $Revision: 1.4 $
 */
public final class VendaConstants {	

	private VendaConstants(){
		super();
	}
	
	public static final String PERFIL_EXTENSOES = "SOLICITAR_EXTENSAO_FONE";
	
	// Campos do Net Header
	public static final String NET_HEADER_APLICACAO = "aplicacao";
	public static final String NET_HEADER_FUNCIONALIDADE = "funcionalidade";
	public static final String NET_HEADER_VERSAO_SERVICO = "versaoServico";
	public static final String NET_HEADER_TOKEN = "token";
	public static final String NET_HEADER_NUMERO_PROTOCOLO = "numeroProtocolo";
	public static final String NET_HEADER_NUMERO_CHAMADA = "numeroChamada";
	public static final String NET_HEADER_USERNAME = "username";
		
	public static final String MANUTENCAO_EXTENSAO_FONE_CID_CONTRATO = "identificacaoCidade";
	public static final String MANUTENCAO_EXTENSAO_FONE_NUMERO_CONTRATO = "numeroContrato";
	public static final String MANUTENCAO_EXTENSAO_FONE_FLAG_IMEDIATA = "flagImediata";
	public static final String MANUTENCAO_EXTENSAO_FONE_ID_LOCAL_DOMICILIO = "identificadorLocalDomicilio";
	public static final String MANUTENCAO_EXTENSAO_FONE_ID_PLANO_PAGAMENTO = "identificadorPlanoPagamento";
	public static final String MANUTENCAO_EXTENSAO_FONE_NUMERO_EXTENSOES = "numeroExtensoes";
	public static final String MANUTENCAO_EXTENSAO_FONE_DDD = "ddd";
	public static final String MANUTENCAO_EXTENSAO_FONE_NUMERO_TELEFONE = "numeroTelefone";
	public static final String MANUTENCAO_EXTENSAO_FONE_ID_PONTO = "idPonto";
	public static final String MANUTENCAO_EXTENSAO_FONE_TIPO_SOLICITACAO = "tipoSolic";
	public static final String MANUTENCAO_EXTENSAO_FONE_NOME_SOLICITANTE = "nomeSolic";
	public static final String MANUTENCAO_EXTENSAO_FONE_DT_CADASTRO = "dtCadastro";
	public static final String MANUTENCAO_EXTENSAO_FONE_USR_CADASTRO = "usrCadastro";
	public static final String MANUTENCAO_EXTENSAO_FONE_TIPO_SOLIC_PROD = "tipoSolicProd";
	public static final String MANUTENCAO_EXTENSAO_FONE_ISENTO = "isento";
	public static final String MANUTENCAO_EXTENSAO_FONE_OBSERVACAO = "observacao";
	
	//Valores de campos:
	public static final String MANUTENCAO_EXTENSAO_FONE_ID_TIPO_SOLICITACAO = "236";
	public static final String MANUTENCAO_EXTENSAO_FONE_VAL_ISENTO = "0";
	
	public static final String DDD_TELEFONE = "dddTelefone";
	public static final String NUM_TELEFONE = "numTelefone";
	public static final String CID_CONTRATO = "cidContrato";
	public static final String NUM_CONTRATO = "numContrato";
	public static final String ID_TIPO_SOLIC = "idTipoSolic";
	public static final String ID_SOLICITACAO_ASS = "idSolicitacaoAss";
	
	// Constantes	
	public static final String APPLICATION_CONTEXT_WEBSERVICE_XML = 
		"META-INF/applicationContext-netcrmcore-webservices.xml";
}