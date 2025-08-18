package br.com.netservicos.relacionar.cliente.processos;

import java.util.ArrayList;

import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;

import br.com.netservicos.framework.exception.business.ValidationException;
import br.com.netservicos.framework.exception.business.ValidationMessage;
import br.com.netservicos.framework.service.webservice.header.Atendimento;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.framework.util.principal.PrincipalUtil;
import br.com.netservicos.framework.webservice.header.NETFrameworkWSHeaderDocument;
import br.com.netservicos.framework.wli.util.principal.PrincipalUtils;
import br.com.netservicos.geral.util.exception.NETExceptionHandler;
import br.com.netservicos.geral.util.exception.NETSoapFaultException;
import br.com.netservicos.geral.util.message.MessageMapperAttributesEnum;
import br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaRegistroType;
import br.com.netservicos.netcrmcore.manutencaoDadosCobrancaContrato12V1.AlterarDadosCobrancaContratoDocument;
import br.com.netservicos.netcrmcore.manutencaoDadosCobrancaContrato12V1.AlterarDadosCobrancaContratoDocument.AlterarDadosCobrancaContrato;
import br.com.netservicos.netcrmcore.manutencaoDadosCobrancaProposta12V1JWS.AlterarDadosCobrancaPropostaDocument;
import br.com.netservicos.netcrmcore.manutencaoDadosCobrancaProposta12V1JWS.AlterarDadosCobrancaPropostaDocument.AlterarDadosCobrancaProposta;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes.DadoCobrancaContratoType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes.DadoCobrancaPropostaType;
import br.com.netservicos.relacionar.cliente.custom.ClienteMessageCustomControl;

import com.bea.jpd.JpdContext;
import com.bea.jpd.ProcessDefinition;
@com.bea.wli.common.XQuery(prolog=
	"declare function exprFunction0($tipoDadoCobranca as xs:string) as xs:boolean {" + 
	"  $tipoDadoCobranca = \"C\""+
"};")
@com.bea.wli.jpd.Process(process = 
"<process name=\"DadoCobrancaJPDV1_0\">" + 
"  <onException name=\"OnException\">" + 
"    <perform name=\"Trata Exceção Global\" method=\"trataExcecaoGlobal\"/>" + 
"  </onException>" + 
"  <clientRequest name=\"alterar\" method=\"alterar\" returnMethod=\"retorno\">" + 
"    <perform name=\"Converter tipo\" method=\"convertType\"/>" + 
"    <perform name=\"Busca base de dados\" method=\"getDatabase\"/>" + 
"    <decision name=\"Decision\">" + 
"      <if name=\"Condition\" condition=\"exprFunction0($tipoDadoCobranca)\">" + 
"        <controlSend name=\"alterarDadosCobrancaContrato\" method=\"manutencaoDadosCobrancaContratoServiceControlAlterarDadosCobrancaContrato\">" + 
"          <onException name=\"OnException\">" + 
"            <perform name=\"Trata Exceção Chamada Serviço\" method=\"trataExcecaoChamadaServicoContrato\"/>" + 
"          </onException>" + 
"        </controlSend>" + 
"      </if>" + 
"      <default name=\"Default\">" + 
"        <controlSend name=\"alterarDadosCobrancaProposta\" method=\"manutencaoDadosCobrancaPropostaServiceControlAlterarDadosCobrancaProposta\">" + 
"          <onException name=\"OnException\">" + 
"            <perform name=\"Trata Exceção Chamada Serviço\" method=\"trataExcecaoChamadaServicoProposta\"/>" + 
"          </onException>" + 
"        </controlSend>" + 
"      </default>" + 
"    </decision>" + 
"  </clientRequest>" + 
"</process>")
public class DadoCobrancaJPDV1_0 implements ProcessDefinition {
	
	private static final String MANUT_DADOS_COBRANCA_PROPOSTA_SERVICE_JWSSERVICE_CONTROL = "MDCobrancaPropostaServiceJWSServiceControl";

	private static final String MANU_DADOS_COBRANCA_CONTRATO_SERVICE_JWSSERVICE_CONTROL = "MDCobrancaContratoServiceJWSServiceControl";

	@org.apache.beehive.controls.api.bean.Control
	private br.com.netservicos.relacionar.cliente.custom.ClienteMessageMapperCustomControl clienteMessageMapperCustomControl;

	public java.lang.String database;

	@org.apache.beehive.controls.api.bean.Control
	private br.com.netservicos.geral.seguranca.controles.custom.DatabaseCredentialsCustomControl databaseCredentialsCustomControl;

	public br.com.netservicos.netcrmcore.manutencaoDadosCobrancaProposta12V1JWS.AlterarDadosCobrancaPropostaResponseDocument propostaResponse;

	public br.com.netservicos.netcrmcore.manutencaoDadosCobrancaContrato12V1.AlterarDadosCobrancaContratoResponseDocument contratoResponse;

	public br.com.netservicos.netcrmcore.manutencaoDadosCobrancaContrato12V1.AlterarDadosCobrancaContratoDocument contratoDocument;

	@org.apache.beehive.controls.api.bean.Control
	private br.com.netservicos.relacionar.cliente.service.ManutencaoDadosCobrancaContratoServiceControl manutencaoDadosCobrancaContratoServiceControl;
	
	@org.apache.beehive.controls.api.bean.Control
	private br.com.netservicos.cliente.util.endpoint.ClienteEndPointCrtl clienteEndPointCrtl;

	public DadoCobrancaRegistroType registroContato;
	
	public br.com.netservicos.framework.webservice.header.NETFrameworkWSHeaderDocument netFrameworkWSHeaderDocument;
	
	public br.com.netservicos.netcrmcore.manutencaoDadosCobrancaProposta12V1JWS.AlterarDadosCobrancaPropostaDocument propostaDocument;
	
	@org.apache.beehive.controls.api.bean.Control
	public ClienteMessageCustomControl clienteMessageCustomControl;
	
	@org.apache.beehive.controls.api.bean.Control
	private br.com.netservicos.relacionar.cliente.service.ManutencaoDadosCobrancaPropostaServiceControl manutencaoDadosCobrancaPropostaServiceControl;
	
	public br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaType dadoCobrancaIn;
	
	public br.com.netservicos.v2.netHeader.NetHeaderDocument netHeaderIn;
	
	public char tipoDadoCobranca;
	
	public final String J_IDENTITY_BASE = "j_identity_base";
	
	@com.bea.wli.jpd.Context
	JpdContext context;
	
	private NETSoapFaultException ex;
	
	ArrayList<String> parameters;
	
	static final long serialVersionUID = 1L;
	
	public void alterar(br.com.netservicos.v2.netHeader.NetHeaderDocument netHeader, br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaType dadoCobrancaType) {
		// #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
		// input transform
		// parameter assignment
		this.netHeaderIn = netHeader;
		this.dadoCobrancaIn = dadoCobrancaType;
		// #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
	}
	
	
	
	
	public void convertType() throws Exception {
		
		NETFrameworkWSHeaderDocument header = NETFrameworkWSHeaderDocument.Factory.newInstance();
		NETFrameworkWSHeader netframeworkHeader = NETFrameworkWSHeader.Factory.newInstance();
		
		if(this.netHeaderIn != null){
			try{
			    netframeworkHeader.xsetAplicacao(netHeaderIn.getNetHeader().xgetAplicacao());
				//netframeworkHeader.setAplicacao(this.netHeaderIn.getNetHeader().getAplicacao().toString());				
			}catch(XmlValueOutOfRangeException e){
			}
			Atendimento atendimento = Atendimento.Factory.newInstance();
			if (netHeaderIn.getNetHeader().getAtendimento() != null){
				atendimento.setNumeroChamada(this.netHeaderIn.getNetHeader().getAtendimento().getNumeroChamada());
				atendimento.setNumeroProtocolo(this.netHeaderIn.getNetHeader().getAtendimento().getNumeroProtocolo());
			}
			netframeworkHeader.setAtendimento(atendimento);
			netframeworkHeader.setToken(this.netHeaderIn.getNetHeader().getToken());
			netframeworkHeader.setVersaoServico(this.netHeaderIn.getNetHeader().getVersaoServico());
			netframeworkHeader.setUsername(this.netHeaderIn.getNetHeader().getUsername());
		}
		header.setNETFrameworkWSHeader(netframeworkHeader);
		this.netFrameworkWSHeaderDocument = header;
		
		Boolean indicadorCoboletamentoInformado = Boolean.FALSE;
		
		if(this.dadoCobrancaIn.xmlText().contains("numeroContrato")) {

			Boolean idTipoPostagemInformado = Boolean.FALSE;
			
			AlterarDadosCobrancaContratoDocument body = AlterarDadosCobrancaContratoDocument.Factory.newInstance();
			AlterarDadosCobrancaContrato contrato = AlterarDadosCobrancaContrato.Factory.newInstance();
			DadoCobrancaContratoType dadoCobrancaContratoType = DadoCobrancaContratoType.Factory.newInstance();
			
			br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaContratoType tmp = (br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaContratoType)this.dadoCobrancaIn.changeType(br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaContratoType.Factory.newInstance().schemaType());
			
			dadoCobrancaContratoType.setIdentificacaoCidade(tmp.getIdentificacaoCidade());
			
			try{
				dadoCobrancaContratoType.setIdTipoPostagem(tmp.getIdTipoPostagem());
				idTipoPostagemInformado = Boolean.TRUE;
			}catch(XmlValueOutOfRangeException e){
			}
			try{
				dadoCobrancaContratoType.setIndicadorCoboletamento(tmp.getIndicadorCoboletamento());
				indicadorCoboletamentoInformado = Boolean.TRUE;
			}catch(XmlValueOutOfRangeException e){
			}
			if(idTipoPostagemInformado && indicadorCoboletamentoInformado){
				Object[] parametros = null;		
				String mensagem = null;
				
				ValidationException validationException = null;
				ValidationMessage validationMessage = null; 
		
				// Definindo parametros e mensagem da exceção
				parametros = new Object[0];
				mensagem = clienteMessageCustomControl.getUserMessage("WLI-CLIEN-0056", parametros);
				validationMessage = new ValidationMessage("WLI-GERAL-0056",mensagem);
				validationException = new ValidationException("WLI-GERAL-0056",mensagem,validationMessage,this.getClass().getName());
				//businessException = new BusinessException("WLI-CLIEN-0056",mensagem,this.getClass().getName());
				
				throw validationException;

			}
			
			dadoCobrancaContratoType.setNumeroContrato(tmp.getNumeroContrato());
			dadoCobrancaContratoType.setNomeContato(tmp.getNomeContato());
			dadoCobrancaContratoType.setTelefoneContato(tmp.getTelefoneContato());
			dadoCobrancaContratoType.setObservacao(tmp.getObservacao());		
			contrato.setDadoCobrancaContrato(dadoCobrancaContratoType);
			body.setAlterarDadosCobrancaContrato(contrato);
			
			this.contratoDocument = body;
			
			this.tipoDadoCobranca = 'C';
		}else {
			
			AlterarDadosCobrancaPropostaDocument body = AlterarDadosCobrancaPropostaDocument.Factory.newInstance();
			
			AlterarDadosCobrancaProposta proposta = AlterarDadosCobrancaProposta.Factory.newInstance();
			DadoCobrancaPropostaType dadoCobrancaPropostaType = DadoCobrancaPropostaType.Factory.newInstance();
			dadoCobrancaPropostaType.setIdentificacaoCidade(this.dadoCobrancaIn.getIdentificacaoCidade());
			
			try{
				Boolean indCoboletamento = this.dadoCobrancaIn.getIndicadorCoboletamento();
				indicadorCoboletamentoInformado = Boolean.TRUE;
			}catch(XmlValueOutOfRangeException e){
			}
			
			if(indicadorCoboletamentoInformado){
				Object[] parametros = null;		
				String mensagem = null;
				
				ValidationException validationException = null;
				ValidationMessage validationMessage = null; 
		
				// Definindo parametros e mensagem da exceção
				parametros = new Object[0];
				mensagem = clienteMessageCustomControl.getUserMessage("WLI-CLIEN-0057", parametros);
				validationMessage = new ValidationMessage("WLI-GERAL-0057",mensagem);
				validationException = new ValidationException("WLI-GERAL-0057",mensagem,validationMessage,this.getClass().getName());
				
				throw validationException;

			}
			
			br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaPropostaType tmp = (br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaPropostaType)this.dadoCobrancaIn.changeType(br.com.netservicos.netClienteWLIWeb.dadoCobranca.DadoCobrancaPropostaType.Factory.newInstance().schemaType());
			
			dadoCobrancaPropostaType.setIdTipoPostagem(tmp.getIdTipoPostagem());
			
			dadoCobrancaPropostaType.setNumeroProposta(tmp.getNumeroProposta());
			
			dadoCobrancaPropostaType.setIdentificacaoCidade(tmp.getIdentificacaoCidade());
			
			proposta.setDadoCobrancaPropostaType(dadoCobrancaPropostaType);
			
			body.setAlterarDadosCobrancaProposta(proposta);
			
			this.propostaDocument = body;
			
			this.tipoDadoCobranca = 'P';
		}
	}
	
		
	public void manutencaoDadosCobrancaPropostaServiceControlAlterarDadosCobrancaProposta() throws Exception {
        this.manutencaoDadosCobrancaPropostaServiceControl.setEndpointAddress(this.clienteEndPointCrtl.getEndPoint(MANUT_DADOS_COBRANCA_PROPOSTA_SERVICE_JWSSERVICE_CONTROL));
        manutencaoDadosCobrancaPropostaServiceControl.setUsername(databaseCredentialsCustomControl.getUserName());
        manutencaoDadosCobrancaPropostaServiceControl.setPassword(databaseCredentialsCustomControl.getUserPassword());
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform        
        // return method call
        this.propostaResponse = manutencaoDadosCobrancaPropostaServiceControl.alterarDadosCobrancaProposta(this.propostaDocument, this.netFrameworkWSHeaderDocument);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
    }
	
	
	public DadoCobrancaRegistroType retorno() {
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // return
        if(this.contratoResponse != null){
        	this.registroContato = DadoCobrancaRegistroType.Factory.newInstance();
        	this.registroContato.setNomeContato(this.contratoResponse.getAlterarDadosCobrancaContratoResponse().getRegistroEventoDadoCobranca().getNomeContato());
        	this.registroContato.setNumeroChamado(this.contratoResponse.getAlterarDadosCobrancaContratoResponse().getRegistroEventoDadoCobranca().getNumeroChamado());
        	this.registroContato.setFormaContato(this.contratoResponse.getAlterarDadosCobrancaContratoResponse().getRegistroEventoDadoCobranca().getFormaContato());
        	this.registroContato.setProtocolo(this.contratoResponse.getAlterarDadosCobrancaContratoResponse().getRegistroEventoDadoCobranca().getProtocolo());
        	this.registroContato.setIdentificador(this.contratoResponse.getAlterarDadosCobrancaContratoResponse().getRegistroEventoDadoCobranca().getIdentificador());
        }
        
        return registroContato;
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
    }




	public void manutencaoDadosCobrancaContratoServiceControlAlterarDadosCobrancaContrato() throws Exception {
	    manutencaoDadosCobrancaContratoServiceControl.setEndpointAddress(this.clienteEndPointCrtl.getEndPoint(MANU_DADOS_COBRANCA_CONTRATO_SERVICE_JWSSERVICE_CONTROL));
        manutencaoDadosCobrancaContratoServiceControl.setUsername(databaseCredentialsCustomControl.getUserName());
        manutencaoDadosCobrancaContratoServiceControl.setPassword(databaseCredentialsCustomControl.getUserPassword());        
        // #START: CODE GENERATED - PROTECTED SECTION - you can safely add code above this comment in this method. #//
        // input transform
        // return method call
        this.contratoResponse = manutencaoDadosCobrancaContratoServiceControl.alterarDadosCobrancaContrato(this.contratoDocument, this.netFrameworkWSHeaderDocument);
        // output transform
        // output assignments
        // #END  : CODE GENERATED - PROTECTED SECTION - you can safely add code below this comment in this method. #//
    }












	public void getDatabase() throws Exception {
		this.database = PrincipalUtil.getPrincipalPropertyValue(PrincipalUtils.getPrincipal(), this.J_IDENTITY_BASE);	
    }




	public void trataExcecaoGlobal() throws Exception {
		Exception e = context.getExceptionInfo().getException();
		
        this.ex =  NETExceptionHandler.getInstance().handlerException(e);
        
         throw this.ex;	
    }




	public void trataExcecaoChamadaServicoContrato() throws Exception {
		Exception e = context.getExceptionInfo().getException();
		
        parameters = new ArrayList<String>();
        parameters.add("ManutencaoDadosCobrancaContratoService");
		
         ex =  NETExceptionHandler.getInstance().handlerServiceException(e,                                                                         
                                                                         clienteMessageCustomControl,
                                                                         "WLI-CLIEN-0058",                                                                          
                                                                         parameters,
                                                                         clienteMessageMapperCustomControl,
                                                                         MessageMapperAttributesEnum.NOME_LEGADO_BUSINESS_CORE_CRM.toString());
        
         throw ex;	
    }




	public void trataExcecaoChamadaServicoProposta() throws Exception {
		Exception e = context.getExceptionInfo().getException();
		
        parameters = new ArrayList<String>();
        parameters.add("ManutencaoDadosCobrancaContratoService");
		
         ex =  NETExceptionHandler.getInstance().handlerServiceException(e,                                                                         
                                                                         clienteMessageCustomControl,
                                                                         "WLI-CLIEN-0058",                                                                          
                                                                         parameters,
                                                                         clienteMessageMapperCustomControl,
                                                                         MessageMapperAttributesEnum.NOME_LEGADO_BUSINESS_CORE_CRM.toString());
        
         throw ex;	
    }



	
	
	
	
	
}
