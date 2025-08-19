package br.com.netservicos.netcrmcore.webservices.prospect.manterproposta;

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
import br.com.netservicos.framework.core.bean.Bean;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.prospect.constants.ProspectConstants;
import br.com.netservicos.netcrmcore.prospect.core.facade.ProspectService;
import br.com.netservicos.netcrmcore.prospect.gerarcontrato.facade.GerarContratoService;
import br.com.netservicos.netcrmcore.venda.constants.PropostaConstants;
import br.com.netservicos.netcrmcore.venda.proposta.facade.PropostaService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes.DadosCobrancaPropostaRetornoType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes.DadosCobrancaPropostaType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes.DadosEnderecoCobrancaRetornoType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes.DadosEnderecoCobrancaType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes.DadosPropostaRetornoType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes.DadosPropostaType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name="ManterProposta12V1JWSService", serviceName="ManterProposta12V1JWSService", 
targetNamespace="http://www.netservicos.com.br/netcrmcore/ManterProposta12V1JWS")
@WLHttpTransport(contextPath = "netcrmcore", serviceUri = 
"ManterProposta12V1JWS", portName = "ManterProposta12V1JWSPort12")
//Anoteções das configurações de binding do web service		
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL)
@Binding(Binding.Type.SOAP12)
public class ManterProposta12V1JWS extends AbstractNETCRMCoreWS {

	private static final String HEADER = "header";
	
	// Constantes para manter cobrança
	private static final String ID_PROPOSTA	= "idProposta";
	private static final String CID_CONTRATO = "cidContrato";
	private static final String ID_TIPO_COBRANCA = "idTipoCobranca";
	private static final String DIA_VENCIMENTO = "diaVencimento";
	private static final String IS_CHECKED_FATURA_EMAIL = "isCheckedFaturaEmail";
	
	// Contantes para manter dados da conta corrente
	private static final String ID_PROSPECT = "idProspect";
	private static final String TITULAR = "titular";
	private static final String ID_BANCO = "idBanco";
	private static final String AGENCIA = "agencia";
	private static final String CONTA = "conta";
	private static final String DIGITO_CONTA = "digitoConta";
	
	// Constantes para manter dados do endereco de cobranca
	private static final String ENDERECO = "endereco";	
	private static final String NUMERO = "numero";
	private static final String COMPLEMENTO	= "complemento";
	private static final String BAIRRO = "bairro";
	private static final String CIDADE = "cidade";
	private static final String ESTADO = "estado";
	private static final String CEP	= "cep";
	private static final String REFERENCIA = "referencia";

	// Declaração do contexto com anotação para injeção pelo container
	// É necessário que seja colocado na classe 'final'do webservice, caso
	// contrário a injeção ocorre
	@Context
	protected JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}
	
	
	//Nome da ação do web service
    @WebMethod(action="finalizarProposta")
    
    //Definição das roles de acesso necessárias para a execução do web services
    @RolesAllowed({@SecurityRole (role="ACESSO")})
                      
    public void finalizarProposta(
            @WebParam(header = true, name = "NETFrameworkWSHeader", targetNamespace = 
                "java:br.com.netservicos.framework.webservice.header") NETFrameworkWSHeader header,
            @WebParam(name = "dadosPropostaType", targetNamespace =
                "java:br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes")
                DadosPropostaType dadosPropostaType) { 

        final DynamicBean dados = new DynamicBean();
        dados.set(HEADER, header);
        dados.set(PropostaConstants.ID_PROPOSTA,dadosPropostaType.getIdProposta());
                
        try {
            final PropostaService service = super.getService(PropostaService.class);
            service.finalizarProposta(dados);            
        } catch (Exception e) {
            //Monta SOAPFaultException em caso de erro
            final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CRIAR_PROSPECT};
            final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
                                                    parameters, WebServicesConstants.RESOURCE_ERROR, e);
            
            throw exception;
        }        
    }
		
	
    //Nome da ação do web service
    @WebMethod(action="gerarContrato")
    
    //Definição das roles de acesso necessárias para a execução do web services
    @RolesAllowed({@SecurityRole (role="ACESSO")})
    
    @WebResult(name="gerarContrato",
               partName="gerarContratoResponse",
               targetNamespace=
                   "java:br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes")
    public DadosPropostaRetornoType gerarContrato(
            @WebParam(header = true, name = "NETFrameworkWSHeader", 
                          targetNamespace = "java:br.com.netservicos.framework.webservice.header") 
                          NETFrameworkWSHeader header,
            @WebParam(name = "dadosPropostaType", targetNamespace = 
                "java:br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes") 
                DadosPropostaType dadosPropostaType) {

        final DynamicBean dados = new DynamicBean();
        dados.set(HEADER, header);
        dados.set(PropostaConstants.ID_PROPOSTA,dadosPropostaType.getIdProposta());
        final DadosPropostaRetornoType dadosRetorno = new DadosPropostaRetornoType();                
        try {
            final GerarContratoService service = super.getService(GerarContratoService.class);
            final Bean retorno = service.gerarContrato(dadosPropostaType.getIdProposta());
            
            final Long numContrato = GeralUtil.toLong(retorno.getBeanProperty(ProspectConstants.PROPERTY_NUM_CONTRATO));
            final Long idAssinante = GeralUtil.toLong(retorno.getBeanProperty(ProspectConstants.PROPERTY_ID_ASSINANTE));
            dadosRetorno.setIdAssinante(idAssinante);
            dadosRetorno.setNumContrato(numContrato);
        } catch (Exception e) {
            //Monta SOAPFaultException em caso de erro
            final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CRIAR_PROSPECT};
            final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
                                                    parameters, WebServicesConstants.RESOURCE_ERROR, e);
            
            throw exception;
        }        
        
        return dadosRetorno;
    }
    
	//Nome da ação do web service
	@WebMethod(action="manterDadosCobrancaProposta")
	
	//Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole (role="ACESSO")})
	
	@WebResult(name="dadosCobrancaPropostaRetorno",
			   partName="manterDadosCobrancaPropostaResponse",	
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes")
	public DadosCobrancaPropostaRetornoType manterDadosCobrancaProposta(
			@WebParam(header = true, name = "NETFrameworkWSHeader", 
			targetNamespace = "java:br.com.netservicos.framework.webservice.header") NETFrameworkWSHeader header,
			@WebParam(name = "dadosCobrancaPropostaType", targetNamespace = 
			    "java:br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes") 
			    DadosCobrancaPropostaType dadosCobProposta) {

		final DynamicBean dadosCobranca = new DynamicBean();
		dadosCobranca.set(HEADER, header);
		dadosCobranca.set(ID_PROPOSTA, dadosCobProposta.getIdProposta());
		dadosCobranca.set(CID_CONTRATO, dadosCobProposta.getCidadeOperadora().getIdentificacaoCidade());
		dadosCobranca.set(ID_TIPO_COBRANCA, dadosCobProposta.getIdTipoCobranca());
		dadosCobranca.set(DIA_VENCIMENTO, dadosCobProposta.getDiaVencimento());
		dadosCobranca.set(IS_CHECKED_FATURA_EMAIL, dadosCobProposta.getIsCheckedFaturaEmail());

		dadosCobranca.set(ID_PROSPECT, dadosCobProposta.getIdProspect());
		dadosCobranca.set(TITULAR, dadosCobProposta.getTitular());
		dadosCobranca.set(ID_BANCO, dadosCobProposta.getIdBanco());
		dadosCobranca.set(AGENCIA, dadosCobProposta.getAgencia());
		dadosCobranca.set(CONTA, dadosCobProposta.getConta());
		dadosCobranca.set(DIGITO_CONTA, dadosCobProposta.getDigitoConta());

		final DadosCobrancaPropostaRetornoType retorno = null;

		try {
			final PropostaService service = super.getService(PropostaService.class);
			service.manterDadosCobranca(dadosCobranca);
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CRIAR_PROSPECT};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
			                                        parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
		return retorno;
	}
	
	//Nome da ação do web service
	@WebMethod(action="manterDadosEnderecoCobranca")
	
	//Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole (role="ACESSO")})
	
	@WebResult(name="dadosEnderecoCobrancaRetorno",
			   partName="manterDadosEnderecoCobrancaResponse",	
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes")
	public DadosEnderecoCobrancaRetornoType manterDadosEnderecoCobranca(
			@WebParam(header = true, name = "NETFrameworkWSHeader", 
			                         targetNamespace = "java:br.com.netservicos.framework.webservice.header") 
			                         NETFrameworkWSHeader header,
			@WebParam(name = "dadosEnderecoCobrancaType", 
targetNamespace = "java:br.com.netservicos.netcrmcore.webservices.prospect.manterproposta.complextypes") 
			     DadosEnderecoCobrancaType dadosEnderecoType) {

		final DynamicBean bean = new DynamicBean();
		bean.set(HEADER, header);

		bean.set(ID_PROSPECT, dadosEnderecoType.getIdProspect());
		bean.set(ENDERECO, dadosEnderecoType.getEndereco());
		bean.set(NUMERO, dadosEnderecoType.getNumero());
		bean.set(COMPLEMENTO, dadosEnderecoType.getComplemento());
		bean.set(BAIRRO, dadosEnderecoType.getBairro());
		bean.set(CIDADE, dadosEnderecoType.getCidade());
		bean.set(ESTADO, dadosEnderecoType.getEstado());
		bean.set(CEP, dadosEnderecoType.getCep());
		bean.set(REFERENCIA, dadosEnderecoType.getReferencia());

		final DadosEnderecoCobrancaRetornoType retorno = null;

		try {
			final ProspectService service = super.getService(ProspectService.class);
			service.manterDadosEnderecoCobranca(bean);
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CRIAR_PROSPECT};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
			                                        parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
		return retorno;
	}
}
