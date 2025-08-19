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
* @author gmello
* @since 30/12/2009
* @version $Revision: 1.4 $
 */
public abstract class PropostaConstants {
	
    public static final String PONTOS = "pontos";
    public static final Integer ID_TIPO_ENDERECO_INSTALACAO = new Integer(1);
	
	public static final long DIGITAL = 2;
	public static final long DIGITALIZADO = 1;
	public static final long INTERNET = 3;
	public static final long ANALOGICO = 0;
	public static final long VOIP = 4;
	    
	public static final long VERIFICACAO_CREDITO_EXTERNO = 4;
	public static final long VERIFICACAO_CREDITO_INTERNO = 5;
	
	public static final long PROPOSTA_PEND_VERIFC_CRED_EXT = 21;    
    public static final long PROPOSTA_PEND_VERIFC_CRED_INT = 22;
    public static final String PROPERTY_COD_HP = "codHP";
	
	public static final String LISTA_USUARIO_BY_ID_AND_ID_FUNCIONARIO = "lstSnUsrByUseriId";
	
    public static final String ID_PROSPECT = "idProspect";
    public static final String ID_PROPOSTA = "idProposta";
    
    public static final int TECNOLOGIA_DIGITAL_SMS = 2;
    public static final int TECNOLOGIA_DIGITALIZADO_SMS = 1;
    public static final int TECNOLOGIA_ANALOGICO_SMS = 0;
    public static final int TECNOLOGIA_PADRAO = 999;
   
    public static final String ERRO_VALIDACAO = "CRMCORE-0070";
	public static final String MSG_ID_PROPOSTA_INVALIDO = "CRMCORE-0001";
	public static final String MSG_ID_PROSPECT_INVALIDO = "CRMCORE-0001";
	public static final String MSG_DADOS_CARTAO_INVALIDO = "CRMCORE-0002";
	public static final String MSG_ID_BANCO_INVALIDO = "CRMCORE-0003";
	public static final String MSG_DADOS_PROPOSTA_INVALIDA_FINALIZACAO = "CRMCORE-0075";
	public static final String MSG_PENDENCIA_PROPOSTA_FINALIZACAO = "CRMCORE-0080";
		
	public static final String LST_SN_REL_OBJ_TIPO_OS          = "{? = call prod_jd.PGSN_FATURAMENTO.VERIF_TIPO_OS_PRO_RATA(?)}";
	public static final String PROPERTY_PRIMEIRO_DIA_VENCIMENTO         = "{? = call prod_jd.PGSN_FATURAMENTO.RETORNA_VENC_PRIMEIRA_FATURA(?, ?, ?, ?, ?)}";

    public static final Long    TIPO_SEGMENTACAO_BLACK                     = new Long(1);
    public static final Long    TIPO_SEGMENTACAO_BLUE                      = new Long(2);
    public static final Long    TIPO_SEGMENTACAO_RED                       = new Long(3);
    public static final Long    TIPO_SEGMENTACAO_WHITE                     = new Long(4);
    public static final Long    TIPO_SEGMENTACAO_SEM_SEGMENTO              = new Long(5);
    
    public static final Long    FORMA_ENVIO_CORREIO                         = new Long(2);
    public static final Long    FORMA_ENVIO_EMAIL                          = new Long(3);
    
    public static final int BOLETO = 1;
    public static final int DEBITO_EM_CONTA = 2;
    public static final int CARTAO_DE_CREDITO = 3;
    public static final int LOCAL_EM_CAIXA = 4;
    public static final int DEBITO_EM_FOLHA_PGTO = 5;
    
    public static final String   BILLING_VIRTUA                           = "B";   
    public static final String   BILLING_NETSMS                           = "N";
    public static final Integer  VINCENDA_N                               = 0;   
    public static final Integer  VINCENDA_S                               = 1;
    public static final Integer  VENCIDO                                  = 0;
    public static final Integer  VINCENDO                                 = 1;
    public static final Integer  CONSTANT_3                                 = 3;
    public static final Integer  CONSTANT_2                                 = 2;
    public static final Integer  CONSTANT_1                                 = 1;
    
    public static final String LST_TIPO_VENDA_POR_DESCRICAO = "lstSQLTipoVendaByDescricao";
    public static final String LST_CAMPANHA_POR_DESCRICAO = "lstSQLCampanhaByDescricao";
    
    public static final String CANAL_VENDA_INTERNET = "INTERNET";
    public static final String CAMPANHA_INTERNET = "INTERNET";
    
    //Constanstes Proposta Assinante
    public static final String PRSN_ENVIA_VENDA_NETSALES_ASS                               = "{call PSN_ASSINANTE.PRSN_ENVIA_VENDA_NETSALES_ASS (?,?,?,?,?,?)}";
    public static final String PRSN_BUSCA_PRODUTO_VINCULO_INSTALADO                        = "{call PROD_JD.PGSMS_SERVICOS_AVANCADOS.PR_BUSCA_PROD_VINC_N_INSTALADO(?,?,?,?,?,?)}";
    public static final String PRSN_CANCELA_SERVICO_AVANCADO                               = "{call PROD_JD.PGSMS_SERVICOS_AVANCADOS.PRSN_CANCELA_SERVICO_AVANCADO(?,?)}";
    
    
    // Constants proposta assinante
    public static final String  ERRO_PROPOSTA_ASSINANTE_ENVIO_NOVA_VENDA                               = "Erro ao enviar dados ao NETSMS.";
    public static final String MSG_ERRO_ENVIO_NOVA_VENDA = "CRMCORE-0110";
    
}

