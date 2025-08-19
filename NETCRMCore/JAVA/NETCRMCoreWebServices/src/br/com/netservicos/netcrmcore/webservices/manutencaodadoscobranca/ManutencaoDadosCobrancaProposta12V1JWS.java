package br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.rpc.soap.SOAPFaultException;

import weblogic.jws.Binding;
import weblogic.jws.Context;
import weblogic.jws.WLHttpTransport;
import weblogic.jws.security.RolesAllowed;
import weblogic.jws.security.SecurityRole;
import weblogic.wsee.jws.JwsContext;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.modelocanonico.evento.ws.types.Evento;
import br.com.netservicos.modelocanonico.evento.ws.types.RegistroContato;
import br.com.netservicos.netcrmcore.cliente.cobranca.facade.ManutencaoDadosCobrancaPropostaService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes.DadoCobrancaPropostaType;
import br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes.RegistroEventoDadoCobrancaType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;


//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name="ManutencaoDadosCobrancaProposta12V1JWSService",
		serviceName="ManutencaoDadosCobrancaProposta12V1JWSService",
		targetNamespace="http://www.netservicos.com.br/netcrmcore/ManutencaoDadosCobrancaProposta12V1JWS")
@WLHttpTransport(
		contextPath = "netcrmcore", 
		serviceUri = "ManutencaoDadosCobrancaProposta12V1JWS", 
		portName = "ManutencaoDadosCobrancaProposta12V1JWSPort12")
//Anoteções das configurações de binding do web service		
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL)
@Binding(Binding.Type.SOAP12)
public class ManutencaoDadosCobrancaProposta12V1JWS extends AbstractNETCRMCoreWS {

	//Constantes WebBean
	private static final String NR_PROPOSTA	=	"numProposta";
	private static final String CD_CIDADE	=	"ciNome";
	private static final String TIPO_POSTAGEM	=	"idTipoPostagem";
	//private static final String NOME_CONTATO	=	"nomeContato";
	//private static final String TELEFONE_CONTATO	=	"telefoneContato";
	//private static final String OBSERVACAO	=	"observacao";
	private static final String HEADER	=	"header";
	
	
	//Constantes Servicos
	// Campos do Net Header
	public static final String NET_HEADER_APLICACAO = "aplicacao";
	public static final String NET_HEADER_FUNCIONALIDADE = "funcionalidade";
	public static final String NET_HEADER_VERSAO_SERVICO = "versaoServico";
	public static final String NET_HEADER_TOKEN = "token";
	public static final String NET_HEADER_NUMERO_PROTOCOLO = "numeroProtocolo";
	public static final String NET_HEADER_NUMERO_CHAMADA = "numeroChamada";
	public static final String NET_HEADER_USERNAME = "username";
	
	
	
	
	//Declaração do contexto com anotação para injeção pelo container
	//É necessário que seja colocado na classe 'final'do webservice, caso contrário a injeção ocorre
	@Context
	protected JwsContext context;
	
	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}


	//Nome da ação do web service
	@WebMethod(action="alterarDadosCobrancaProposta")
	//Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole (role="ALTERAR_DADO_COBRANCA_PROPOSTA")})	
	@WebResult(name="registroEventoDadoCobranca",
			    partName="alterarDadosCobrancaPropostaResponse",	
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes")
	public RegistroEventoDadoCobrancaType alterarDadosCobrancaProposta(@WebParam(header = true, name="NETFrameworkWSHeader",
									 targetNamespace="java:br.com.netservicos.framework.webservice.header") NETFrameworkWSHeader header,
									 @WebParam(name="dadoCobrancaPropostaType",
											   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.manutencaodadoscobranca.complextypes") DadoCobrancaPropostaType dadoCobrancaPropostaType){
		
		getUserInfo(header);//Popula as informações do usuário
			
		//Dynamic Bean
		DynamicBean dadosCobranca = new DynamicBean();
		
		//Instancia retorno
		RegistroEventoDadoCobrancaType retorno = null;
		//Localiza e efetua chamada ao EJB
		
		try {
			
			RegistroContato evento = null;			
			
			dadosCobranca.set(NR_PROPOSTA, dadoCobrancaPropostaType.getNumeroProposta());
			dadosCobranca.set(CD_CIDADE, dadoCobrancaPropostaType.getIdentificacaoCidade());
			dadosCobranca.set(TIPO_POSTAGEM, dadoCobrancaPropostaType.getIdTipoPostagem().longValue());
			dadosCobranca.set(HEADER, header);
			
			ManutencaoDadosCobrancaPropostaService manutencaoDadosCobrancaService = super.getService(ManutencaoDadosCobrancaPropostaService.class);
			evento = manutencaoDadosCobrancaService.alterarDadosCobrancaProposta(dadosCobranca);
			
			retorno = converteEventoToRetorno(evento);
			
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_ALTERAR_DADOS_COBRANCA_PROPOSTA};
			SOAPFaultException soapFaultException =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw soapFaultException;
		}
		
		return retorno;
	}

	private RegistroEventoDadoCobrancaType converteEventoToRetorno(RegistroContato evento) {
		
		RegistroEventoDadoCobrancaType retorno = new RegistroEventoDadoCobrancaType();
		//para proposta nao eh gerado uma ocorrencia
		//if (evento instanceof RegistroContato) {
		//	RegistroContato registroContato = (RegistroContato) evento;
		//	retorno.setNomeContato(registroContato.getContato().getNomeContato());
		//	retorno.setNumeroChamado(registroContato.getContato().getNumeroChamado());
		//	retorno.setFormaContato(formaContato)(registroContato.getObservacao());
		//	retorno.setProtocolo(registroContato.getContato().getProtocolo());
		//}
		
		return retorno;
	}
	
}
