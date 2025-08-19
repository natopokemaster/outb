/**
 * Created on 29/04/2008
 * Project : NETModelGeral
 *
 * Copyright © 2007 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Net Serviços.
 * 
 * $Id: GeralConstants.java,v 1.2 2011/01/19 16:25:11 T0196500 Exp $
 */
package br.com.netservicos.netcrmcore.geral.constants;

/**
 * 
 * <P><B>Classe para constantes :</B><BR>
 * 	TODO descrever
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 * @author Jonatas Piscirilo
 * @since 29/04/2008
 */

public class GeralConstants {

	public static final String ERRO_KEY = "error_key";
	
	public enum SimNao {S, N};
	
	public static final String APPLICATION_CONTEXT_WEBSERVICE = "META-INF/applicationContext-netcrmcore-webservices.xml";
	/**
	 * Prefix for the name of the database service (see applicationContext-netmodel.xml)
	 */
	public static final String PREFIXO_DATABASE_SERVICE      = "NETCRMCORE_BASE_";
	public static final String FORMATO_DATA_DD_MM_YYY        = "dd/MM/yyyy";
	public static final String FORMATO_DATA_DD_MM_YYY_HHMMSS = "dd/MM/yyyy HH:mm:SS";
	public static final String UNCHECKED = "unchecked";
	
	public static final String CASA_AG_SA = "CASA_AGEND_SERVAVANC";
	public static final String AGENDA_SA = "agendaSA";
	public static final String LETRA_S = "S";
    public static final String LETRA_A = "A";
    public static final String LETRA_L = "L";
    public static final String PROPOSTA = "proposta";
    public static final String ID_TP_PERIODO_SA = "idTipoPeriodoSA";
    public static final String AGENDA_RESPOSTA = "agendaResposta";
    public static final String SUCCESS_AG_SOLIC = "success_agendarSolic";
    public static final String SUCCESS_AG_SA = "success_agendarSA";
    public static final String ID_TIPO_PERIODO = "idTipoPeriodo";
    public static final String DATA_AGENDAMENTO = "dataAgendamento";
    public static final String LST_AG_SA_CASADA = "lstAgendaSACasada";
    public static final String AGENDA_AREA_SA = "agendaAreaSA";
    public static final String AGENDA_CLASSE_SA = "agendaClasseSA";
    public static final String AGENDA_MINUTOS_SA = "minutosRequeridosSA";    
    public static final String LST_AGENDA_SA = "lstAgendaSA";
    public static final String ENC_SENHA_USED = "encaixeSenhaUsed";
    public static final String _PROPOSTA = "Proposta";
    public static final String FLAG_CONV_ASS = "flagConvenienciaAssinante";
    public static final String FLAG_FORA_PADRAO = "flagForaPadrao";
    public static final String DATA_AGENDTO_SA = "dataAgendamentoSA";    
    public static final String FLAG_CONV_ASS_SA = "flagConvenienciaAssinanteSa";
    public static final String FLAG_FORA_PAD_SA = "flagForaPadraoSa";
    public static final String PROPOSTA_SA = "PropostaSA";
    public static final Integer NUMERO_UM = Integer.valueOf(1);
    public static final Integer NUMERO_TRINTA_UM = Integer.valueOf(31);
    public static final String NULL = "null";
    public static final String DOIS = "2";
    public static final String LETRA_UM = "1";
    public static final int INDIVIDUAL = 1;
    
	public static final String LST_PARAMETRO_BY_ID_EMPRESA = "lstParametroByIdEmpresa";
	public static final String LST_PROD_SA_INSER = "CpPropostaServicoBeanLstProdutosServicosAvancadosInseridos";	

	
	//Endereco Constants
	  public static final String ID_PROSPECT = "idProspect";
	  public static final String ID_PROPOSTA = "idProposta";
	  public static final String PROPERTY_COD_HP = "codHP";
	  public static final String PROPERTY_GED_ENDERECO = "gedEndereco";
	  public static final Integer ID_TIPO_ENDERECO_INSTALACAO = new Integer(1);
	  public static final Integer ID_TIPO_ENDERECO_COBRANCA = new Integer(2);
	  public static final Integer TECNOLOGIA_PTV                             = 1;
	  public static final Integer TECNOLOGIA_VIRTUA                          = 2;
	  public static final Integer TECNOLOGIA_DIGITAL                         = 3;
	  public static final Integer TECNOLOGIA_VOIP                            = 4;
	  public static final String STATUS_COMERCIAL = "pStatusComercial";
	  public static final String STATUS_TECNICO = "pStatusTecnico";
	  public static final String GERAR_CONTRATO_HP_INVALIDO = "CRMCORE-0099";
	  public static final String PROC_STATUS_COMERCIAL = "procStatusComercial";
	  public static final String PROC_STATUS_TECNICO = "procStatusTecnico";
	  public static final String STATUS_OK = "0";
	  public static final String STATUS_NAO_OK = "1";
	  public static final String PROPERTY_STATUS_ENDERECO_PTV_COMERCIAL = "statusEnderecoPTVComercial";
	  public static final String PROPERTY_STATUS_ENDERECO_PTV_TECNICO = "statusEnderecoPTVTecnico";
	  public static final String PROPERTY_STATUS_ENDERECO_VIRTUA_COMERCIAL = "statusEnderecoVirtuaComercial";
	  public static final String PROPERTY_STATUS_ENDERECO_VIRTUA_TECNICO = "statusEnderecoVirtuaTecnico";
	  public static final String PROPERTY_STATUS_ENDERECO_DIGITAL_COMERCIAL = "statusEnderecoDigitalComercial";
	  public static final String PROPERTY_STATUS_ENDERECO_DIGITAL_TECNICO = "statusEnderecoDigitalTecnico";
	  public static final String PROPERTY_STATUS_ENDERECO_VOIP_COMERCIAL = "statusEnderecoVoIPComercial";
	  public static final String PROPERTY_STATUS_ENDERECO_VOIP_TECNICO = "statusEnderecoVoIPTecnico";
	  public static final String PROC_VALIDA_TECNOLOGIA_VOIP   = "{call VALIDA_TECNOLOGIA_VOIP(?,?,?,?,?)}";
	  public static final String FUNCTION_PERMITE_VENDA_ENDER    = "{? = call PROD_JD.fsn_permite_venda_ender(?,?)}";
	  public static final String PROC_ENDER_LISTA_ENDERECOS   = "{call IE_ENDERECOS.LISTA_ENDERECOS(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
	  public static final String PROC_PGSN_TRECHOS_RESTRITOS_PR_VALIDA_TRECHO = "{call PGSN_TRECHOS_RESTRITOS.PR_VALIDA_TRECHO(?,?,?,?,?,?)}";
	  public static final int PENDENTE_AGENDAMENTO = 1;
	  public static final long HP_INADIMPLENTE = 7;	  
	  public static final long HP_INSTALADO = 6;	  
	  public static final long HP_OUTROS = 8;
	  public static final long HP_ANALISE = 9;
	  public static final String PONTOS = "pontos";	  
	  public static final String LABEL_NUMERO = "Numero:";
	  public static final String LABEL_BAIRRO = "Bairro:";
	  public static final String LABEL_CEP = "Cep:";
	  public static final String TIPO_EDIFICACAO_CASA = "CASA";
	  public static final String TIPO_EDIFICACAO_PREDIO = "PREDIO";
	  public static final String TIPO_EDIFICACAO_INDETERMINADO = "INDET.";
	  public static final Integer PTECNOLOGIA = new Integer(2);
	  
	  //pendencias
	  public static final String ATTRIBUTE_ID_PENDENCIA = "idPendencia";
	  public static final String ATTRIBUTE_ID_VARIACAO = "idVariacao";
	  
	  public static final int BRASILEIRO = 0;
	  public static final int STATUS_ABERTA = 1;
	  public static final int STATUS_NAO_SE_APLICA = 2;
	  public static final int STATUS_EM_ANDAMENTO = 3;
	  public static final int STATUS_ENVIADA = 4;
	  public static final int STATUS_CANCELADA = 5;
	  public static final int STATUS_PENDENTE = 6;
	  public static final int STATUS_PENDENTE_EM_AGENDAMENTO = 7;
	  public static final int STATUS_FINALIZADA = 8;
	  public static final int STATUS_ERRO_ENVIO = 9;
	  
	  public static final long ENDERECO_BLOQUEADO_ENGENHARIA = 12;
      public static final long ENDERECO_EM_ANALISE = 10;
      public static final long ENDERECO_FORA_AREA = 14;
      public static final long ENDERECO_HP_INSTALADO = 9;
      public static final long CONTRATOS_COLETIVOS_EDIFICACAO = 24;
      public static final long ENDERECO_INADINPLENTE = 20;
      public static final long ENDERECO_REJEITADO = 11;
      public static final long INSTALACAO_NAO_DISPONIVEL = 13;
      public static final long MDU_EM_DISPONIBILIZACAO = 16;
      public static final long MDU_INTERROMPIDO = 17;
      public static final long MDU_SEM_BACKBONE = 15;
      public static final long NAO_CONSEGUE_ABRIR_SOLICITACAO = 19;
      public static final long PENDENTE_INSTALACAO = 18;
      
      public static final String LST_BY_PENDENCIAS_VARIACOES = "lstCpRelPendenciasVariacoesByPendenciasAndVariacoes";   
      public static final int CARACTERISTICA_PERFIL_FALTANDO = 16;
      public static final long CARACTERISTICA_PERFIL_FALTANDO_VARIACAO = 27;
      public static final int RESERVAR_TELEFONE = 26;
      public static final int RESERVAR_TELEFONE_PORTABILIDADE = 102;
      
      public static final int CREDITO_EXTERNO = 2;
      public static final int CREDITO_INTERNO = 3;
      public static final int AGUARDANDO_SPC = 10;
      public static final int ERROR_SPC = 11;
      public static final int SOLICITADA_OPERADOR = 12;
      public static final int DADOS_INCONSISTENTES = 13;
      public static final int DOCUMENTO_PENDENTE = 14;
      public static final int RESERVA_TELEFONICA = 15;
      public static final long ENVIO_DOCUMENTO = 17;  
      public static final int BLACK_LIST_EBT = 18;
      public static final int DUPLICIDADE = 19;      
      public static final long RESERVA_TELEFONICA_PORTABILIDADE = 20;
      public static final int ASSINANTE_CONCORRENCIA = 3;
      
      
      
	
}
