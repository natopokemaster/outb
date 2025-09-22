package br.com.netservicos.infraestrutura.rede;

import javax.transaction.SystemException;
import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.apache.beehive.controls.api.bean.Control;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlString;

import weblogic.transaction.TxHelper;
import br.com.netservicos.geral.controles.custom.log.LogCustomControl;
import br.com.netservicos.infraestrutura.rede.constantes.Constantes;
import br.com.netservicos.infraestrutura.rede.control.custom.OutageCustomControl;
import br.com.netservicos.infraestrutura.rede.control.service.InstalacaoServiceControl;
import br.com.netservicos.infraestrutura.rede.control.service.OutageIntegracaoWAServiceControl;
import br.com.netservicos.rede.outage.EnderecoDescDocument;
import br.com.netservicos.rede.outage.ResultadoNotificarOutageDocument;
import br.com.netservicos.rede.outage.EnderecoDescDocument.EnderecoDesc;
import br.com.netservicos.rede.outage.EnderecoDescRowDocument.EnderecoDescRow;
import br.com.netservicos.rede.util.database.RedeJDBCRealm;
import br.com.netservicos.rede.util.endpoint.RedeEndPointCrtl;
import br.com.netservicos.rede.util.message.RedeMensagemControl;

import com.bea.control.annotations.Security;
import com.bea.jpd.JpdContext;
import com.bea.jpd.ProcessDefinition;
import com.bea.wli.common.Protocol;

@com.bea.wli.common.XQuery(prolog = 
"declare namespace ns-1 = \"http://www.netservicos.com.br/v2/NetHeader\";" + 
"declare namespace ns0 = \"http://www.netservicos.com.br/rede/outage\";" + 
"declare function exprFunction0($retRollout as xs:int) as xs:boolean {" + 
"  $retRollout = 1" + 
"};" + 
"declare function exprFunction1($parametros) {" + 
"  $parametros/ns0:pontoComum/ns0:node" + 
"};" + 
"declare function exprFunction3($iter_forNode) {" + 
"  $iter_forNode/ns0:celula" + 
"};" + 
"declare function exprFunction4($iter_forCelula) {" + 
"  $iter_forCelula/ns0:logradouro" + 
"};" + 
"declare function exprFunction5($header) as xs:boolean {" + 
"  fn:data($header/aplicacao) = \"NEW MONITOR\"" + 
"};" + 
"declare function exprFunction2($header) as xs:boolean {" + 
"  fn:data($header/aplicacao) = \"ATLAS\"" + 
"};" + 
"declare function exprFunction6($parametros) as element()* {" + 
"  $parametros/ns0:pontoComum/ns0:node" + 
"};")
@com.bea.wli.jpd.Process(process = 
"<process name=\"CriaNotificacaoOutageJPDV1_0\">" + 
"  <clientRequest name=\"Client Request with Return\" method=\"criar\" returnMethod=\"clientReturn\">" + 
"    <perform name=\"Inicializa variáveis\" method=\"initVariaveis\"/>" + 
"    <controlSend name=\"setCurrentDataSource\" method=\"databaseControlSetCurrentDataSource\"/>" + 
"    <controlSend name=\"consultarRolloutOutageWA\" method=\"outageLegadoJDBCControlConsultarRolloutOutage\"/>" + 
"    <decision name=\"Verifica se a cidade esta parametrizada para atualizar informações de Outage WA\">" + 
"      <if name=\"Cidade parametrizada\" condition=\"exprFunction0($retRollout)\">" + 
"        <decision name=\"Se header.aplicacao = &quot;ATLAS&quot;\">" + 
"          <if name=\"É ATLAS\" condition=\"exprFunction2($header)\">" + 
"            <decision name=\"Verifica se tem dados de node\">" + 
"              <metaData>" + 
"                <metaDataEntry key=\"collapsed\">true</metaDataEntry>" + 
"              </metaData>" + 
"              <if name=\"Possui nodes\" conditionMethod=\"verificaExisteNode\">" + 
"                <forEach name=\"Percorre lista de nodes\" variable=\"iter_forNode\" expression=\"exprFunction1($parametros)\">" + 
"                  <forEach name=\"Peercorre lista de celula\" variable=\"iter_forCelula\" expression=\"exprFunction3($iter_forNode)\">" + 
"                    <forEach name=\"Percorre lista logradouro\" variable=\"iter_forLograd\" expression=\"exprFunction4($iter_forCelula)\">" + 
"                      <perform name=\"Recupera logradouroId\" method=\"recuperaLogradouro\"/>" + 
"                      <controlSend name=\"buscarContratoNotificacao\" method=\"outageLegadoJDBCControlBuscarContratoNotificacao\"/>" + 
"                      <controlSend name=\"consultarEnderecoDomicilioPorID\" method=\"instalacaoServiceControlConsultarEnderecoDomicilioPorID\"/>" + 
"                      <decision name=\"Verifico se retornou dados\">" + 
"                        <if name=\"Retornou\" conditionMethod=\"verificaEnderInst\">" + 
"                          <perform name=\"Recupera dados do endereço\" method=\"recuperaDadosEnderById\"/>" + 
"                        </if>" + 
"                        <default name=\"Senão\">" + 
"                          <controlSend name=\"consultarEnderecoDomicilioPorContrato\" method=\"instalacaoServiceControlConsultarEnderecoDomicilioPorContrato\"/>" + 
"                          <perform name=\"Preenche dados de Endereço\" method=\"recuperaEnder\"/>" + 
"                        </default>" + 
"                      </decision>" + 
"                    </forEach>" + 
"                  </forEach>" + 
"                </forEach>" + 
"              </if>" + 
"              <default name=\"Senão\"/>" + 
"            </decision>" + 
"            <block name=\"Chama Service Control de Integração usando credenciais do usuário corrente\">" + 
"              <metaData>" + 
"                <metaDataEntry key=\"collapsed\">true</metaDataEntry>" + 
"              </metaData>" + 
"              <decision name=\"Verifica se tem dados de Endereço\">" + 
"                <if name=\"Possui dados endereço\" conditionMethod=\"verifcaDadosEnder\">" + 
"                  <controlSend name=\"montarRequestPontoComum\" method=\"outageCustomControlMontarRequestPontoComum\"/>" + 
"                  <controlSend name=\"notifyOutageRequest\" method=\"outageIntegracaoWAServiceControlNotifyOutageRequest2\"/>" + 
"                </if>" + 
"                <default name=\"Senão\">" + 
"                  <controlSend name=\"notifyOutageRequest\" method=\"outageIntegracaoWAServiceControlNotifyOutageRequest1\"/>" + 
"                </default>" + 
"              </decision>" + 
"              <controlSend name=\"geraSqlParamAtualizarEnvioWA\" method=\"outageCustomControlGeraSqlParamAtualizarEnvioWA\"/>" + 
"              <controlSend name=\"atualizarEnvioWA\" method=\"outageLegadoJDBCControlAtualizarEnvioWA\"/>" + 
"            </block>" + 
"          </if>" + 
"          <default name=\"Senão\"/>" + 
"        </decision>" + 
"      </if>" + 
"      <default name=\"Senão\"/>" + 
"    </decision>" + 
"    <decision name=\"Se header.aplicacao = &quot;NEW MONITOR&quot;\">" + 
"      <if name=\"Criar Outage no Atlas\" condition=\"exprFunction5($header)\">" + 
"        <forEach name=\"Percorre a lista de Node\" variable=\"forEachNode\" expression=\"exprFunction6($parametros)\">" + 
"          <controlSend name=\"Preparar parâmetros para procedure\" method=\"outageCustomControlGeraSqlParamCriarOutageNode1\"/>" + 
"          <controlSend name=\"Criar Outage Node\" method=\"outageLegadoJDBCControlCriar\"/>" + 
"        </forEach>" + 
"      </if>" + 
"      <default name=\"Senão\"/>" + 
"    </decision>" + 
"  </clientRequest>" + 
"</process>")
public class CriaNotificacaoOutageJPDV1_0 implements ProcessDefinition {

	public java.lang.String numContrato;

	public br.com.netservicos.instalacao.ConsultarEnderecoDomicilioPorIDResponseDocument docConsultarEndDomicilioPorIDRespDocument;

	public br.com.netservicos.rede.outage.Logradouro iter_forLograd;

	public br.com.netservicos.rede.outage.Celula iter_forCelula;

	public br.com.netservicos.rede.outage.Node iter_forNode;
	
	public br.com.netservicos.rede.outage.Node forEachNode;

	public br.com.netservicos.rede.outage.PontoComum pontoComum;

	public java.lang.String imovel;

	public java.util.HashMap map;

	public java.lang.String logradouroId;

	public br.com.netservicos.instalacao.ConsultarEnderecoDomicilioPorContratoResponseDocument docConsultarEnderecoResponseDocument;

	public java.lang.String idEnderInstalacao;

	public EnderecoDescDocument docDadosEnder;

	public java.lang.String dsErro;

	public org.apache.beehive.controls.system.jdbc.JdbcControl.SQLParameter[] sqlParamNotificar;

	public java.lang.String fcEnvio;

	public java.lang.String retCriarNotificacao;

	public br.com.netservicos.workassure.outage.NotifyOutageResponseDocument docNotifyOutageResponseDocument;

	public br.com.netservicos.workassure.outage.NotifyOutageRequestResponseDocument docNotifyOutageResponse;

	public int retRollout;

	@org.apache.beehive.controls.api.bean.Control
	@LogCustomControl.LogCategoryRealm(logCategoryRealm = CriaNotificacaoOutageJPDV1_0.class)
	private br.com.netservicos.rede.util.log.RedeLogCustomControl redeLogCustomControl;

	public java.lang.String password;

	public java.lang.String username;

	@org.apache.beehive.controls.api.bean.Control
	private br.com.netservicos.geral.seguranca.controles.custom.DatabaseCredentialsCustomControl databaseCredentialsCustomControl;

	@org.apache.beehive.controls.api.bean.Control
	private br.com.netservicos.geral.database.controles.custom.DatabaseControl databaseControl;

	public java.lang.String jdbcRealm = RedeJDBCRealm.REDE_ONLINE.getJdbcRealm();
	
	@com.bea.wli.jpd.Transform
	private br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation transformations;

	
	@org.apache.beehive.controls.api.bean.Control
	private br.com.netservicos.infraestrutura.rede.control.database.OutageLegadoJDBCControl outageLegadoJDBCControl;

	public br.com.netservicos.v2.netHeader.NetHeaderDocument header;

	public br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument parametros;

	@com.bea.wli.jpd.Context
	JpdContext context;

    private ResultadoNotificarOutageDocument docResultadoNotificarOutageDocument;
    
	static final long serialVersionUID = 1;

	@Control
	private RedeMensagemControl mensagemControl;

	 public Exception exProcessException;

	@Control
	private OutageIntegracaoWAServiceControl outageIntegracaoWAServiceControl;

	@Control
	private OutageCustomControl outageCustomControl;
	
	private TransactionManager tm = null;

	private Transaction saveTx = null;	
	
	@Control
	private InstalacaoServiceControl instalacaoServiceControl;

	@Control
	private RedeEndPointCrtl redeEndPointCrtl;

	private Long idNotificacaoCriada;
	
	public java.lang.String clientReturn() {
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("clientReturn::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // return
        redeLogCustomControl.logDebug("clientReturn() retCriarNotificacao >>>>>>>>>>>> " + retCriarNotificacao);
        return retCriarNotificacao;
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
    }


	@com.bea.wli.jpd.InputMessage(validate=true)
	@Security(rolesAllowed="CRIAR_OUTAGE")
	public void criar(br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument request, br.com.netservicos.v2.netHeader.NetHeaderDocument header) {
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("criar::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        // parameter assignment
        this.parametros = request;
        this.header = header;
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("criar::Fim");     
    }

	
	public void databaseControlSetCurrentDataSource() throws Exception {
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("databaseControlSetCurrentDataSource::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.databaseControlsetCurrentDataSourceObject obj = transformations.databaseControlsetCurrentDataSource(this.jdbcRealm, this.parametros);
        // method call
        databaseControl.setCurrentDataSource(obj.cidadeContrato, obj.jdbcRealm);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("databaseControlSetCurrentDataSource::Fim");
    }

 
	/**
	 *  Verifica se a cidade esta parametrizada para atualizar informações de Outage WA.
	 *  Chama a classe da camada de persistência para realizar um consulta do parâmetro
     *  'FIELD_SERVICES_OUTG' na base dados.
     *  Se retornar registro da consulta indica que a cidade está parametriza, caso contrário
     *  não.
	 */
	public void outageLegadoJDBCControlConsultarRolloutOutage() throws Exception {
	   if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageLegadoJDBCControlConsultarRolloutOutage::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        java.lang.String obj = transformations.outageLegadoJDBCControlconsultarRolloutOutage(this.parametros);
        // return method call
        this.retRollout = outageLegadoJDBCControl.consultarRolloutOutage(obj);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageLegadoJDBCControlConsultarRolloutOutage::Fim");        
    }

	public void initVariaveis() throws Exception {
	    if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("initVariaveis::Inicio");
	    idNotificacaoCriada = Long.parseLong("0");
	    
		docResultadoNotificarOutageDocument = ResultadoNotificarOutageDocument.Factory.newInstance();
		docResultadoNotificarOutageDocument.setResultadoNotificarOutage("OK");

		this.docDadosEnder = br.com.netservicos.rede.outage.EnderecoDescDocument.Factory.newInstance();
		this.retCriarNotificacao = "OK";
		
		this.fcEnvio = "S";
		this.dsErro = "";
		
		this.username = databaseCredentialsCustomControl.getUserName();
		this.password = databaseCredentialsCustomControl.getUserPassword();
		instalacaoServiceControl.setUsername(username);
	    instalacaoServiceControl.setPassword(password);
	    instalacaoServiceControl.setEndpointAddress(redeEndPointCrtl.getEndPoint("InstalacaoProxy"));
	     
	     
	    outageIntegracaoWAServiceControl.setEndpointAddress(this.redeEndPointCrtl.getEndPoint("OutageIntegracaoWA11V1"));
        outageIntegracaoWAServiceControl.setUsername(username);
        outageIntegracaoWAServiceControl.setPassword(password);
         
	    redeLogCustomControl.logDebug("initVariaveis() retCriarNotificacao >>>>>>>>>>>> " + retCriarNotificacao);
	    
		if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("initVariaveis::Fim");
    }

	public boolean isSoapFaultException() {
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("isSoapFaultException::Inicio");
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("isSoapFaultException::Fim");
         exProcessException = context.getExceptionInfo().getException();
        return ((this.exProcessException instanceof com.bea.jws.SoapFaultException));
    }

	public void outageLegadoJDBCControlAtualizarEnvioWA() throws Exception {
	   if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageLegadoJDBCControlAtualizarEnvioWA::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        // method call
        outageLegadoJDBCControl.atualizarEnvioWA(this.sqlParamNotificar);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageLegadoJDBCControlAtualizarEnvioWA::Fim");
    }

	public void recuperaMsgErro() throws Exception {
	   if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("recuperaMsgErro::Inicio");
	   this.dsErro = this.context.getExceptionInfo().getException().getMessage().substring(0,100);
	   this.fcEnvio = "N";
	   tm = TxHelper.getTransactionManager();
		try {
			saveTx = tm.suspend();
		} catch (SystemException e) {
			throw e;
		}
	 if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("recuperaMsgErro::Fim");	
    }

// TODO remover?
	public void outageCustomControlGeraSqlParamAtualizarEnvioWA1() throws Exception {
	   if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageCustomControlGeraSqlParamAtualizarEnvioWA1::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.outageCustomControlgeraSqlParamAtualizarEnvioWA2Object obj = transformations.outageCustomControlgeraSqlParamAtualizarEnvioWA2(this.dsErro, this.fcEnvio, this.parametros, Constantes.ACAO_NOTIFICAR);
        // return method call
        this.sqlParamNotificar = outageCustomControl.geraSqlParamAtualizarEnvioWA(obj.pIdNotificacao, obj.pCidContrato, obj.pTpEvento, obj.pFcEnvio, obj.pDsErro);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageCustomControlGeraSqlParamAtualizarEnvioWA1::Fim");
    }

	public void outageLegadoJDBCControlAtualizarEnvioWA1() throws Exception {
	  if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageLegadoJDBCControlAtualizarEnvioWA1::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        // method call
        outageLegadoJDBCControl.atualizarEnvioWA(this.sqlParamNotificar);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageLegadoJDBCControlAtualizarEnvioWA1::Fim");
    }

	public void outageCustomControlGeraSqlParamAtualizarEnvioWA() throws Exception {
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.outageCustomControlgeraSqlParamAtualizarEnvioWAObject obj = transformations.outageCustomControlgeraSqlParamAtualizarEnvioWA(this.dsErro, this.fcEnvio, this.parametros, Constantes.ACAO_NOTIFICAR);
        // return method call
        this.sqlParamNotificar = outageCustomControl.geraSqlParamAtualizarEnvioWA(obj.pIdNotificacao, obj.pCidContrato, obj.pTpEvento, obj.pFcEnvio, obj.pDsErro);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
    }

	public boolean verificaAplicacao() {
		return (!this.header.getNetHeader().getAplicacao().toString().equalsIgnoreCase("WORKASSURE"));
	}


	public void setaResume() throws Exception {
		if (tm != null && tm.getStatus() != 0) {
		  tm.resume(saveTx);
		}
    }

	
	public void mensagemControlFormatarExcecao1() throws Exception {
	    this.exProcessException = this.context.getExceptionInfo().getException();
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        // return method call
        this.exProcessException = mensagemControl.formatarExcecao(Constantes.codErroDefault, this.exProcessException, Constantes.AtorNotificar);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        throw this.exProcessException;
    }


	

	public boolean verifcaDadosEnder() {
	   if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("verifcaDadosEnder::Inicio");
	    if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("verifcaDadosEnder::Fim");
		return (this.docDadosEnder.getEnderecoDesc() != null  && this.docDadosEnder.getEnderecoDesc().getEnderecoDescRowList().size() > 0);
	}


	

	public void outageIntegracaoWAServiceControlNotifyOutageRequest1() throws Exception {
	    if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageIntegracaoWAServiceControlNotifyOutageRequest::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.workassure.outage.NotifyOutageRequestDocument obj = transformations.outageIntegracaoWAServiceControlnotifyOutageRequest(this.parametros);
        // return method call
        this.docNotifyOutageResponseDocument = outageIntegracaoWAServiceControl.notifyOutageRequest(obj);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageIntegracaoWAServiceControlNotifyOutageRequest::Fim");        
    }


	public void outageIntegracaoWAServiceControlNotifyOutageRequest2() throws Exception {
	    if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageIntegracaoWAServiceControlNotifyOutageRequest2::Inicio");
	    // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.workassure.outage.NotifyOutageRequestDocument obj = transformations.outageIntegracaoWAServiceControlnotifyOutageRequest2(this.parametros);
        // return method call
        this.docNotifyOutageResponseDocument = outageIntegracaoWAServiceControl.notifyOutageRequest(obj);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageIntegracaoWAServiceControlNotifyOutageRequest2::Fim");
    }


	public boolean verificaExisteNode() {
	    if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("verificaExisteNode::Inicio");
	    if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("verificaExisteNode::Fim");
		return (this.parametros.getParametrosNotificarOutage().getPontoComum() != null && this.parametros.getParametrosNotificarOutage().getPontoComum().getNodeList().size() > 0);
	}


	public void recuperaLogradouro() throws Exception {
	  if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("recuperaLogradouro::Inicio");
	  if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("recuperaLogradouro::Inicio");
	  logradouroId  = ((XmlString)iter_forLograd.execQuery(Constantes.namespaceOutage+" .//ns1:logradouroId")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	}


	public void outageLegadoJDBCControlBuscarContratoNotificacao() throws Exception {
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageLegadoJDBCControlBuscarContratoNotificacao1::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.outageLegadoJDBCControlbuscarContratoNotificacaoObject obj = transformations.outageLegadoJDBCControlbuscarContratoNotificacao(this.logradouroId, this.parametros);
        // return method call
        this.map = outageLegadoJDBCControl.buscarEnderInstImovelNotificacao(obj.pCidContrato, obj.pNotificacao, obj.pLogradouro);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if (map != null || !map.isEmpty()) {
			imovel = map.get("NOM_TIPO_IMOVEL").toString();
			numContrato = map.get("NUM_CONTRATO").toString();
			idEnderInstalacao =  map.get("ID_ENDER_INSTALACAO").toString();		  		   
		}       
		if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageLegadoJDBCControlBuscarContratoNotificacao1::Fim");        
    }


	public void outageCustomControlMontarRequestPontoComum() throws Exception {
	    if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageCustomControlMontarRequestPontoComum::Inicio");
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        // return method call
        this.pontoComum = outageCustomControl.montarRequestPontoComum(this.parametros.getParametrosNotificarOutage().getPontoComum(), this.docDadosEnder);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        this.parametros.getParametrosNotificarOutage().setPontoComum(pontoComum);
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageCustomControlMontarRequestPontoComum::Fim");
    }


	public void instalacaoServiceControlConsultarEnderecoDomicilioPorID() throws Exception {
     	       
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.instalacaoServiceControlconsultarEnderecoDomicilioPorIDObject obj = transformations.instalacaoServiceControlconsultarEnderecoDomicilioPorID(this.idEnderInstalacao, this.parametros, Constantes.VERSAO_INSTALAR, this.header);
        // return method call
        this.docConsultarEndDomicilioPorIDRespDocument = instalacaoServiceControl.consultarEnderecoDomicilioPorID(obj.request_Header_arg, obj.consultarEnderecoDomicilioPorIDRequest_arg);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
    }


	public boolean verificaEnderInst() {
		return  ( docConsultarEndDomicilioPorIDRespDocument != null && docConsultarEndDomicilioPorIDRespDocument.getConsultarEnderecoDomicilioPorIDResponse().getContratoDeVenda().getEnderecoContratoDeVendaList().size() > 0 &&  docConsultarEndDomicilioPorIDRespDocument.getConsultarEnderecoDomicilioPorIDResponse().getContratoDeVenda().getEnderecoContratoDeVendaArray(0).getEndereco() != null) ;
		}


	public void recuperaDadosEnderById() throws Exception {
     if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("recuperaEnderById::Inicio");
	  String tipoLogradouro;
	  String logradouro;
	  String numeroEndereco;
	  String complemento;   
	  String bairro;	          
	  if (docConsultarEndDomicilioPorIDRespDocument != null && docConsultarEndDomicilioPorIDRespDocument.getConsultarEnderecoDomicilioPorIDResponse().getContratoDeVenda().sizeOfEnderecoContratoDeVendaArray() > 0){
	      tipoLogradouro  = ((XmlString)docConsultarEndDomicilioPorIDRespDocument.execQuery( Constantes.namespaceEndereco+" .//ns1:tipoLogradouro")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      logradouro  = ((XmlString)docConsultarEndDomicilioPorIDRespDocument.execQuery( Constantes.namespaceEndereco+" .//ns1:logradouro")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      numeroEndereco  = ((XmlString)docConsultarEndDomicilioPorIDRespDocument.execQuery( Constantes.namespaceEndereco+" .//ns1:numeroEndereco")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      complemento  = ((XmlString)docConsultarEndDomicilioPorIDRespDocument.execQuery( Constantes.namespaceEndereco+" .//ns1:complemento")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      bairro  = ((XmlString)docConsultarEndDomicilioPorIDRespDocument.execQuery(Constantes.namespaceEndereco+" .//ns1:bairro")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      // Preenche dados do xml Endereco
	      EnderecoDesc enderDescDoc = this.docDadosEnder.addNewEnderecoDesc();
	      EnderecoDescRow enderRow = enderDescDoc.addNewEnderecoDescRow();
	      enderRow.setLogradouro(logradouro);
	      enderRow.setEndeCompleto(tipoLogradouro+" "+logradouro+", "+numeroEndereco+" "+complemento+ " - "+bairro);
	      enderRow.setImovel(this.imovel);
	  }
	  if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("recuperaEnderById::Inicio");
    }


	public void instalacaoServiceControlConsultarEnderecoDomicilioPorContrato() throws Exception {
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("instalacaoServiceControlConsultarEnderecoDomicilioPorContrato::Inicio");
	     // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.instalacaoServiceControlconsultarEnderecoDomicilioPorContratoObject obj = transformations.instalacaoServiceControlconsultarEnderecoDomicilioPorContrato(this.header, this.numContrato, this.parametros, Constantes.VERSAO_INSTALAR);
        // return method call
        this.docConsultarEnderecoResponseDocument = instalacaoServiceControl.consultarEnderecoDomicilioPorContrato(obj.request_Header_arg, obj.consultarEnderecoDomicilioPorContratoRequest_arg);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("instalacaoServiceControlConsultarEnderecoDomicilioPorContrato::Fim");        
    }


	public void recuperaEnder() throws Exception {
	  if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("recuperaEnder::Inicio");
	  String tipoLogradouro;
	  String logradouro;
	  String numeroEndereco;
	  String complemento;   
	  String bairro;	          
	  if (docConsultarEnderecoResponseDocument != null  && docConsultarEnderecoResponseDocument.getConsultarEnderecoDomicilioPorContratoResponse().getContratoDeVenda() != null){
	      tipoLogradouro  = ((XmlString)docConsultarEnderecoResponseDocument.execQuery( Constantes.namespaceEndereco+" .//ns1:tipoLogradouro")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      logradouro  = ((XmlString)docConsultarEnderecoResponseDocument.execQuery( Constantes.namespaceEndereco+" .//ns1:logradouro")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      numeroEndereco  = ((XmlString)docConsultarEnderecoResponseDocument.execQuery( Constantes.namespaceEndereco+" .//ns1:numeroEndereco")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      complemento  = ((XmlString)docConsultarEnderecoResponseDocument.execQuery( Constantes.namespaceEndereco+" .//ns1:complemento")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      bairro  = ((XmlString)docConsultarEnderecoResponseDocument.execQuery(Constantes.namespaceEndereco+" .//ns1:bairro")[0].changeType(XmlBeans.typeForClass(XmlString.class))).getStringValue();
	      // Preenche dados do xml Endereco
	      EnderecoDesc enderDescDoc = this.docDadosEnder.addNewEnderecoDesc();
	      EnderecoDescRow enderRow = enderDescDoc.addNewEnderecoDescRow();
	      enderRow.setLogradouro(logradouro);
	      enderRow.setEndeCompleto(tipoLogradouro+" "+logradouro+", "+numeroEndereco+" "+complemento+ " - "+bairro);
	      enderRow.setImovel(this.imovel);
	  }
	  if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("recuperaEnder::Inicio");
    }

	/**
	 * Cria a notificação de Outage na base do Atlas Antigo (apenas quando consumido pelo 'NEW MONITOR')
     * 
	 */
	public void outageLegadoJDBCControlCriar() throws Exception {
		if(redeLogCustomControl.isDebugEnabled())redeLogCustomControl.logDebug("outageLegadoJDBCControlCriar::Inicio idNotificacaoCriada: "  + idNotificacaoCriada);
		
	    // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        // method call
        outageLegadoJDBCControl.criar(this.sqlParamNotificar);

        idNotificacaoCriada =  Long.parseLong(this.sqlParamNotificar[10].value+"");
        retCriarNotificacao = idNotificacaoCriada+"";
        
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        
        if(redeLogCustomControl.isDebugEnabled())redeLogCustomControl.logDebug("outageLegadoJDBCControlCriar::Fim idNotificacaoCriada: "  + idNotificacaoCriada);
    }


	public void outageCustomControlGeraSqlParamCriarOutageNode1() throws Exception {
		if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageCustomControlGeraSqlParamCriarOutageNode1::Inicio");
	
	    // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.outageCustomControlgeraSqlParamCriarOutageNode2Object obj = transformations.outageCustomControlgeraSqlParamCriarOutageNode2(this.header, this.forEachNode, this.parametros);
        // return method call

        if(obj.doc.getParametrosNotificarOutage().getNotificacaoId() != null && !"".equalsIgnoreCase(obj.doc.getParametrosNotificarOutage().getNotificacaoId().trim()) && idNotificacaoCriada.longValue()==0){
        	idNotificacaoCriada = Long.parseLong(obj.doc.getParametrosNotificarOutage().getNotificacaoId());
        	if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageCustomControlGeraSqlParamCriarOutageNode1::notificacaoId: " + idNotificacaoCriada);
        }

        this.sqlParamNotificar = outageCustomControl.geraSqlParamCriarOutageNode(obj.usuario, obj.doc, obj.nodeId, Constantes.TP_PTO_COMUM_NODE, idNotificacaoCriada);
        
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
        
        if(redeLogCustomControl.isDebugEnabled()) redeLogCustomControl.logDebug("outageCustomControlGeraSqlParamCriarOutageNode1::Fim");
    }
}