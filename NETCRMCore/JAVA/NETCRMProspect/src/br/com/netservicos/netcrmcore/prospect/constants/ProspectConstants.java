package br.com.netservicos.netcrmcore.prospect.constants;

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
* @version $Revision: 1.3 $
 */
public abstract class ProspectConstants {
	

	//parametros serviço criar proposta
    public static final String CID_CONTRATO = "cidadeContrato";    
    public static final String MIDIA = "idMidia";    
    public static final String ID_TIPO_VENA = "idTipoVenda";
    public static final String ID_CAMPANHA = "idCampanha";
    public static final String ID_TIPO_CONTRATO = "idTipoContrato";
    public static final String ID_TIPO_ASSINANTE = "idTipoAssinante";
    
    public static final String NOME = "nome";
    public static final String DDD = "ddd";
    public static final String TELEFONE = "telefone";
    public static final String ID_PROSPECT = "idProspect";
    public static final String ID_PROPOSTA = "idProposta";   
    public static final String ID_PROPOSTA_ASSINANTE = "idPropostaAssinante";
    public static final String ID_PONTO = "idPonto";    
	public static final int STATUS_ABERTA = 1;
	public static final int STATUS_NAO_SE_APLICA = 2;
	public static final int STATUS_EM_ANDAMENTO = 3;
	public static final int STATUS_ENVIADA = 4;
	public static final int STATUS_CANCELADA = 5;
	public static final int STATUS_PENDENTE = 6;
	public static final int STATUS_PENDENTE_EM_AGENDAMENTO = 7;
	public static final int STATUS_FINALIZADA = 8;
	public static final int STATUS_ERRO_ENVIO = 9;
	
	    
	public static final String LISTA_USUARIO_BY_ID_AND_ID_FUNCIONARIO = "lstSnUsrByUseriId";
	public static final String LST_MIDIA_POR_CAMPANHA_E_CIDADE = "lstSQLMidiasByCidadeOperadora";

	
	public static final String MIDIA_INTERNET = "SITE INTERNET";	
	public static final String PROPERTY_COD_HP = "codHP";
	public static final String PROPERTY_ID_MIDIA = "idMidia";
	public static final String PROPERTY_ID_CAMPAMNHA = "idCampanha";
	public static final String PROPERTY_ID_TIPO_CONTRATO = "idTipoContrato";
	public static final String PROPERTY_ID_TIPO_ASSINANTE = "idTipoAssinante";
	public static final String PROPERTY_ID_TIPO_VENDA = "idTipoVenda";
	public static final String PROPERTY_ID_TIPO_SEGMENTO = "idTipoSegmento";

	//erros servico cirar proposta	
	public static final String DADOS_PROPOSTA_CID_CONTRATO_INFORMADO = "CRMCORE-0070";
	public static final String DADOS_PROPOSTA_COD_HP_INFORMADO = "CRMCORE-0071";
	public static final String DADOS_PROPOSTA_NOME_INFORMADO = "CRMCORE-0072";	
	public static final String GERAR_CONTRATO_ENDERECO_COBRANCA = "CRMCORE-0093";
	public static final String DADOS_PROPOSTA_TIPO_VENDA_INFORMADO = "CRMCORE-0100";
	public static final String DADOS_PROPOSTA_MIDIA_INFORMADO = "CRMCORE-0101";
	public static final String DADOS_PROPOSTA_CAMPANHA_INFORMADO = "CRMCORE-0102";
	public static final String DADOS_PROPOSTA_TIPO_CONTRATO_INFORMADO = "CRMCORE-0103";
	public static final String DADOS_PROPOSTA_TIPO_ASSINANTE_INFORMADO = "CRMCORE-0104";
	
	// constantes de gerar Contrato
	
	public static final String OBSERVACAO_EXTENSAO = "INSTALAR EXTENSAO NETFONE";	
	public static final String   BILLING_VIRTUA    = "B";
	public static final String   BILLING_NETSMS    = "N";
	public static final Integer  VENCIDO           = 0;
	public static final Integer  VINCENDO          = 1;
	public static final String MSG_ID_PROPOSTA_INVALIDO = "CRMCORE-0001";
	public static final Long ID_PONTO_PRINCIPAL = 5L;
    public static final Long ID_PONTO_ADICIONAL = 6L;
    public static final long DIGITAL = 2;
    public static final long DIGITALIZADO = 1;
    public static final long INTERNET = 3;
    public static final long ANALOGICO = 0;
    public static final long VOIP = 4;
    
    public static final int COBRANCA_DEBITO_CONTA = 2;
    public static final int COBRANCA_CARTAO_CREDITO = 3;
    
	public static final Long    TIPO_SEGMENTACAO_BLACK                     = new Long(1);
    public static final Long    TIPO_SEGMENTACAO_BLUE                      = new Long(2);
    public static final Long    TIPO_SEGMENTACAO_RED                       = new Long(3);
    public static final Long    TIPO_SEGMENTACAO_WHITE                     = new Long(4);
    public static final Long    TIPO_SEGMENTACAO_SEM_SEGMENTO              = new Long(5);
    
    public static final String PROPERTY_NUM_CONTRATO = "numContrato";
    public static final String PROPERTY_MSG_PREPOSTO = "mensagemPreposto";
    public static final String PROPERTY_LISTA_IRREGULARIDADES = "listaIrregularidades";
    public static final String PROPERTY_ID_ASSINANTE = "idAssinante";
    
    public static final Long TIPO_CARACTERISTICA_SD = 0L;
    public static final Long TIPO_CARACTERISTICA_HDTV = 1L;
    public static final Long TIPO_CARACTERISTICA_HDTV_DVR = 2L;
    public static final int REVISTA_BOLETO = 4;
    
	public static final String DT_FATURA_RATEIO = "lstDtFaturaRateio";
	public static final String PRODUTO_AGREGADO_ADICIONADOS = "lstProdutosAdicionados";
	public static final String LST_CP_TICKET_VIGENTE = "lstCpTicketSegmentacaoVigente";
	public static final String LST_USERNAME_BY_PROPOSTA_IDPESSOA = "lstUserNameByPropostaIdPessoa";
	public static final String LST_PREPOSTOS_BY_PROSPECT = "lstPrepostosByProspect";
	public static final String SELECT_BY_ID_PROPOSTA                   = "lstCpPropostaServicoByIdProposta"; 
	
	public static final String LST_EXISTS_CP_REL_PENDENCIA_PROPOSTA_ENDERECO_ANALISE_BY_PROPOSTA = "lstExistsCpRelPendenciaPropostaEnderecoAnaliseByProposta";	
	public static final String LST_REL_PENDENCIA_PROPOSTA_EM_ABERTO = "lstCpRelPendenciasPropostasEmAberto";
	public static final String FIND_SN_VLR_PARAMETRO = "findVlrParametro";
	public static final String LST_SN_VLR_PARAMETRO = "lstVlrParametroStr";	
	public static final String PROC_ISS_ENVIO_CONTRATO_ASSOCIA_ENDERECO                    = "{call ISS_ENVIO_CONTRATO.ASSOCIA_ENDERECO(?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_INCLUI_ASSINANTE                    = "{call ISS_ENVIO_CONTRATO.INCLUI_ASSINANTE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_INCLUI_ENDER_EXT                    = "{call ISS_ENVIO_CONTRATO.INCLUI_ENDER_EXT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_INCLUI_CONTRATO                     = "{call ISS_ENVIO_CONTRATO.INCLUI_CONTRATO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_PRSN_BUSCA_SIT_IRREG_CONTRATO       = "{call ISS_ENVIO_CONTRATO.PRSN_BUSCA_SIT_IRREG_CONTRATO (?,?,?)}";
	public static final String PROC_ISS_INCLUI_PRODUTO_AGREGADO = "{call ISS_ENVIO_CONTRATO.INCLUI_PRODUTO_AGREGADO(?,?,?,?,?,?,?,?)}";
	public static final String PROC_PSN_VANGUARDA_SSN_INSERE_SN_REL_ASS_SEGM               = "{call PSN_VANGUARDA.SSN_INSERE_SN_REL_ASS_SEGM(?,?,?,?,?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_INCLUI_PONTO                        = "{call ISS_ENVIO_CONTRATO.INCLUI_PONTO(?,?,?,?,?,?,?,?)}";
	public static final String PROC_INSERE_RETORNO_PONTO                                   = "{call PROD_JD.INSERE_RETORNO_PONTO(?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_INCLUI_PONTO_PRODUTO                = "{call ISS_ENVIO_CONTRATO.INCLUI_PONTO_PRODUTO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_BUSCA_CARACTERISTICA_PRODUTO                          = "{call PGSN_ATRIBUTOS.BUSCA_CARACTERISTICA_PRODUTO(?,?)}";
	public static final String PROC_ENDER_VALIDA_ENDERECO_SIEBEL                           = "{call IE_ENDERECOS.VALIDA_ENDERECO_SIEBEL(?,?,?,?,?,?)}"; 
	public static final String PROC_ISS_ENVIO_CONTRATO_INCLUI_PRODUTO_AGREGADO             = "{call ISS_ENVIO_CONTRATO.INCLUI_PRODUTO_AGREGADO(?,?,?,?,?,?,?,?)}";
	public static final String PROC_PSN_MATELEFONE_PR_CONFRESERVATELVOIPAVALJAVA           = "{call PSN_MANTELEFONE_VOIP.PR_CONFRESERVATELVOIPAVALJAVA(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_PSN_SOLICITACAO_ASS_GERAL_INSERE_SOLICITACAO = "{call PROD_JD.PSN_SOLICITACAO_ASS_GERAL.Insere_Solicitacao(?,?,?,?,?,?,?,?)}";
	public static final String PROC_SETAR_PONTO = "{call PROD_JD.pSnSolicAss.SETARPONTO(?)}";
	public static final String PROC_PGSMS_SERVICO_AVANCADO_BUSCA_PROPOSTA_SERVICOS         = "{call PROD_JD.PGSMS_SERVICOS_AVANCADOS.PRSN_BUSCA_PROPOSTA_SERVICOS(?,?,?)}";
	public static final String PROC_PSN_MAN_EXTEN_VOIP_PR_INS_EXTEN_VOIP = "{call PROD_JD.PSN_MAN_EXTEN_VOIP.PR_INS_EXTEN_VOIP(?,?,?,?)}";
	public static final String PROC_PGSMS_SERVICO_AVANCADO_INCLUI_SERVICO_AVANCADO         = "{call PROD_JD.PGSMS_SERVICOS_AVANCADOS.PRSN_INCLUI_SERVICO_AVANCADO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_INCLUI_CONTA_CORRENTE               = "{call ISS_ENVIO_CONTRATO.INCLUI_CONTA_CORRENTE(?,?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_ENVIO_CARTAO_MENS                   = "{call ISS_ENVIO_CONTRATO.ENVIO_CARTAO_MENSALIDADE(?,?,?,?,?,?,?,?,?)}";
	public static final String PROC_PGSMS_CONTRATO_INCLUI_PREPOSTO                         = "{call PGSMS_PREPOSTO.PRSMS_INCLUIRPREPOSTO(?,?,?,?,?,?)}";
	public static final String PROC_ISS_ENVIO_CONTRATO_FINALIZA_PROCESSO                   = "{call ISS_ENVIO_CONTRATO.FINALIZA_PROCESSO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	
	public static final String PROC_PGGED_ENDERECO_PR_ECN_LOGRADOURO                       = "{call PGGED_ENDERECO.PR_ECN_LOGRADOURO(?, ?, ?, ?, ?, ?)}";
    public static final String PROC_PGGED_ENDERECO_PR_ECN_CAIXA_POSTAL                     = "{call PGGED_ENDERECO.PR_ECN_CAIXA_POSTAL(?, ?, ?, ?, ?)}";
    
    public static final String ID_TIPO_PESSOA = "idTipoPessoa";
    public static final String DS_NOME =  "dsNome";
    public static final String DS_COMPLEMENTO = "dsComplemento";
    public static final String SEXO = "sexo";
    public static final String DS_EMAIL = "dsEmail";
    public static final String DT_NASCIMENTO = "dtNascimento";
    public static final String DS_CPF = "dsCpf";
    public static final String DS_CNPJ = "dsCnpj";
    public static final String DS_IE = "dsIe";
    public static final String DS_RG = "dsRg";
    public static final String DDD_CELULAR = "dddCelular";
    public static final String TEL_CELULAR = "telCelular";
    public static final String DDD_TEL_COM = "dddTelCom";
    public static final String TEL_COMERCIAL = "telComercial";
    public static final String DDD_TEL_RES = "dddTelRes";
    public static final String TEL_RESIDENCIAL = "telResidencial";
    public static final String PROFISSAO = "profissao";
    public static final String ORGAO_EXPEDIDOR = "orgaoExpedidor";
    public static final String ESTADO_CIVIL = "estadoCivil";
	public static final String MSG_ID_PROSPECT_INVALIDO = "CRMCORE-0073";
}
