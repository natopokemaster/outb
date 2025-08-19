package br.com.netservicos.netcrmcore.webservices.avisorelacionamento;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.rpc.soap.SOAPFaultException;

import weblogic.jws.Binding;
import weblogic.jws.Context;
import weblogic.jws.security.RolesAllowed;
import weblogic.jws.security.SecurityRole;
import weblogic.wsee.jws.JwsContext;
import br.com.netservicos.framework.core.bean.DynamicBean;
import br.com.netservicos.framework.service.webservice.header.NETFrameworkWSHeader;
import br.com.netservicos.netcrmcore.gescom.avisorelacionamento.facade.AvisoRelacionamentoService;
import br.com.netservicos.netcrmcore.gescom.constants.AvisoConstants;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes.DadosConsultarAvisoRelacionamentoRetornoType;
import br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes.DadosConsultarAvisoRelacionamentoType;
import br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes.DadosGerarPDFAvisoRelacionamentoRetornoType;
import br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes.DadosGerarPDFAvisoRelacionamentoType;
import br.com.netservicos.netcrmcore.webservices.avisorelacionamento.complextypes.DadosSolicitarReenvioAvisoRelacionamentoType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

/**
 * JWS que recebe as requisições ao CORE, responsável pela consulta, geração de PDF e solicitação de reenvio de avisos. 
 * Esta camada é uma casca para exposição do serviço implementado no EJB. Utiliza soap 1.2
 * 
 */

//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name = AvisoConstants.WEB_SERVICE_NAME, serviceName = 
	AvisoConstants.WEB_SERVICE_SERVICE_NAME, targetNamespace = AvisoConstants.WEB_SERVICE_TARGET)
// Anoteções das configurações de binding do web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@Binding(Binding.Type.SOAP12)
public class AvisoRelacionamento12V1JWS extends AbstractNETCRMCoreWS {

	// Declaração do contexto com anotação para injeção pelo container
	// É necessário que seja colocado na classe 'final'do webservice, caso
	// contrário a injeção ocorre
	@Context
	protected JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}

	/**
	 * 
	 * Operação que realiza a consulta de dados do Aviso.
	 *
	 * @param header
	 * informacoes do header enviados no request.
	 * 
	 * @param consultar
	 * informacoes necessarias para realizar a consulta do arquivo xml do aviso.
	 * 
	 * @param identificadorCidade 
	 * identificacao cidade
	 * 
	 * @return arquivo xml que representa o acordo comercial.
	 */
	
	// Nome da ação do web service
	@WebMethod(action = AvisoConstants.WEB_METHOD_CONSULTAR_ACTION)
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed( { @SecurityRole(role = "ACESSO") })
	@WebResult(name = AvisoConstants.WEB_RESULT_CONSULTAR_NAME, partName = 
		AvisoConstants.WEB_RESULT_CONSULTAR_PARTNAME, targetNamespace = AvisoConstants.WEB_RESULT_TARGET)
	public DadosConsultarAvisoRelacionamentoRetornoType consultar(
			@WebParam(header = true, name = AvisoConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
				AvisoConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = AvisoConstants.WEB_PARAM_CONSULTAR_NAME, targetNamespace = 
				AvisoConstants.WEB_PARAM_TARGET) DadosConsultarAvisoRelacionamentoType consultar,
			@WebParam(name = AvisoConstants.WEB_PARAM_IDENTIFICADOR_CIDADE_NAME) String identificadorCidade){
		
		final DynamicBean dadosConsultarAvisoRelacionamento = new DynamicBean();
		dadosConsultarAvisoRelacionamento.set(AvisoConstants.NET_HEADER, header);
		dadosConsultarAvisoRelacionamento.set(AvisoConstants.IDENTIFICADOR_AVISO, consultar.getIdentificadorAviso());
		
		final DadosConsultarAvisoRelacionamentoRetornoType retorno = new DadosConsultarAvisoRelacionamentoRetornoType();

		try {
			
			final AvisoRelacionamentoService service = super.getService(AvisoRelacionamentoService.class);
			retorno.setXml(service.consultarAvisoRelacionamento(dadosConsultarAvisoRelacionamento));
			
		} catch (Exception e) {
			// Monta SOAPFaultException em caso de erro
			final SOAPFaultException soapFaultException = generateSOAPFaultException(
					WebServicesConstants.RESOURCE_AVISO_RELACIONAMENTO_CONSULTAR, 
					WebServicesConstants.RESOURCE_ERROR_ID_AVISO_INVALIDO, e);

			throw soapFaultException;
		}

		return retorno;
	}

	/**
	 * Operação responsável por gerarPDF de um determinado Aviso.
	 * 
	 * @param header
	 * informacoes do header enviados no request.
	 * 
	 * @param gerarPDF
	 * informacoes necessarias para realizar a geracao do arquivo PDF do aviso.
	 * 
	 * @param identificadorCidade
	 *  identificacao cidade
	 * 
	 * @return arquivos xml e pdf que representam o acordo comercial do aviso. 
	 */
	
	// Nome da ação do web service
	@WebMethod(action = AvisoConstants.WEB_METHOD_GERAR_PDF_ACTION)
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed( { @SecurityRole(role = "ACESSO") })
	@WebResult(name = AvisoConstants.WEB_RESULT_GERAR_PDF_NAME, partName = 
		AvisoConstants.WEB_RESULT_GERAR_PDF_PARTNAME, targetNamespace = AvisoConstants.WEB_RESULT_TARGET)
	public DadosGerarPDFAvisoRelacionamentoRetornoType gerarPDF(
			@WebParam(header = true, name = AvisoConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
				AvisoConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = AvisoConstants.WEB_PARAM_GERAR_PDF_NAME, targetNamespace = 
				AvisoConstants.WEB_PARAM_TARGET) DadosGerarPDFAvisoRelacionamentoType gerarPDF,
			@WebParam(name = AvisoConstants.WEB_PARAM_IDENTIFICADOR_CIDADE_NAME) String identificadorCidade) {
		
		final DynamicBean dadosGerarPDFAvisoRelacionamento = new DynamicBean();
		dadosGerarPDFAvisoRelacionamento.set(AvisoConstants.NET_HEADER, header);
		dadosGerarPDFAvisoRelacionamento.set(AvisoConstants.IDENTIFICADOR_AVISO, gerarPDF.getIdentificadorAviso());

		final DadosGerarPDFAvisoRelacionamentoRetornoType retorno = new DadosGerarPDFAvisoRelacionamentoRetornoType();

		try {
			
			final AvisoRelacionamentoService service = super.getService(AvisoRelacionamentoService.class);

			retorno.setXml(service.gerarXMLAvisoRelacionamento(dadosGerarPDFAvisoRelacionamento));
			retorno.setPdf(service.gerarPDFAvisoRelacionamento(dadosGerarPDFAvisoRelacionamento));
			
		} catch (Exception e) {
			
			// Monta SOAPFaultException em caso de erro
			if(e.getMessage().contains(WebServicesConstants.RESOURCE_ERROR_ID_AVISO_INVALIDO)){
				SOAPFaultException soapFaultException = generateSOAPFaultException(
						WebServicesConstants.RESOURCE_AVISO_RELACIONAMENTO_GERAR_PDF,  
						WebServicesConstants.RESOURCE_ERROR_ID_AVISO_INVALIDO, e);
				throw soapFaultException;
			}else{
				// Monta SOAPFaultException em caso de erro
				Long idAviso = (Long)dadosGerarPDFAvisoRelacionamento.get(AvisoConstants.IDENTIFICADOR_AVISO);
				
				final Object[] parameters = new Object[] {idAviso.toString(), e.getMessage()};
				final SOAPFaultException soapFaultException = generateSOAPFaultException(
						WebServicesConstants.RESOURCE_ERROR_GERAR_PDF, parameters,
						WebServicesConstants.RESOURCE_ERROR_GERAR_PDF, e);
				throw soapFaultException;
			}
		}
		return retorno;
	}

	/**
	 * Operação responsável por reenviar um novo aviso para o cliente.
	 * 
	 * @param header
	 * informacoes do header enviados no request.
	 * 
	 * @param solicitarReenvio
	 * informacoes necessarias para realizar o reenvio do aviso.
	 * 
	 * @param identificadorCidade
	 * identificacao cidade
	 */
	// Nome da ação do web service
	@WebMethod(action = AvisoConstants.WEB_METHOD_SOLICITAR_REENVIO_ACTION)
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed( { @SecurityRole(role = "ACESSO") })
	public void solicitarReenvio(
			@WebParam(header = true, name = AvisoConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
				AvisoConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = AvisoConstants.WEB_PARAM_SOLICITAR_REENVIO_NAME, targetNamespace = 
				AvisoConstants.WEB_PARAM_TARGET) DadosSolicitarReenvioAvisoRelacionamentoType solicitarReenvio,
			@WebParam(name = AvisoConstants.WEB_PARAM_IDENTIFICADOR_CIDADE_NAME) String identificadorCidade) {

		final DynamicBean dadosReenviarAvisoRelacionamento = new DynamicBean();
		
		dadosReenviarAvisoRelacionamento.set(AvisoConstants.NET_HEADER, header);
		dadosReenviarAvisoRelacionamento.set(AvisoConstants.IDENTIFICADOR_AVISO, solicitarReenvio.getIdentificadorAviso());
		dadosReenviarAvisoRelacionamento.set(AvisoConstants.MOTIVO, solicitarReenvio.getMotivo());
		dadosReenviarAvisoRelacionamento.set(AvisoConstants.USUARIO, header.getUsername());
		
		try {
		
			final AvisoRelacionamentoService service = super.getService(AvisoRelacionamentoService.class);
			service.reenviarAvisoRelacionamento(dadosReenviarAvisoRelacionamento);

		} catch (Exception e) {
			// Monta SOAPFaultException em caso de erro
			if(e.getMessage().contains(WebServicesConstants.RESOURCE_ERROR_ID_AVISO_INVALIDO)){
				SOAPFaultException soapFaultException = generateSOAPFaultException(
						WebServicesConstants.RESOURCE_AVISO_RELACIONAMENTO_SOLICITAR_REENVIO,  
						WebServicesConstants.RESOURCE_ERROR_ID_AVISO_INVALIDO, e);
				throw soapFaultException;
			}else{
				SOAPFaultException soapFaultException = generateSOAPFaultException(
						WebServicesConstants.RESOURCE_AVISO_RELACIONAMENTO_SOLICITAR_REENVIO,  
						WebServicesConstants.RESOURCE_ERROR_MOTIVO_INVALIDO, e);			
				throw soapFaultException;
			}
		}
	}
}
