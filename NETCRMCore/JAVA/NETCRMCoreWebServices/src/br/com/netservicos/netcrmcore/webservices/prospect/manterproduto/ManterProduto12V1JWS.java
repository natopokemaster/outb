package br.com.netservicos.netcrmcore.webservices.prospect.manterproduto;

import java.util.ArrayList;
import java.util.List;

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
import br.com.netservicos.netcrmcore.geral.constants.GeralConstants;
import br.com.netservicos.netcrmcore.geral.util.GeralUtil;
import br.com.netservicos.netcrmcore.produto.core.facade.AgregadoService;
import br.com.netservicos.netcrmcore.produto.core.facade.ProdutoService;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoFoneDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoTvDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosAgregadoVirtuaDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoFoneDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoTvDTO;
import br.com.netservicos.netcrmcore.produto.dto.DadosProdutoVirtuaDTO;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.AgregadoFoneType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.AgregadoTvType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.AgregadoVirtuaType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosAgregadoPropostaRetornoType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosAgregadoPropostaType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosDeleteAllProdutosType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosDeleteLstProdutosType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosProdutoFoneType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosProdutoPropostaRetornoType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosProdutoPropostaType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosProdutoTvType;
import br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes.DadosProdutoVirtuaType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name="ManterProduto12V1JWSService", serviceName="ManterProduto12V1JWSService", 
targetNamespace="http://www.netservicos.com.br/netcrmcore/ManterProduto12V1JWS")
@WLHttpTransport(contextPath = "netcrmcore", serviceUri = "ManterProduto12V1JWS", 
portName = "ManterProduto12V1JWSPort12")
//Anoteções das configurações de binding do web service		
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL)
@Binding(Binding.Type.SOAP12)
public class ManterProduto12V1JWS extends AbstractNETCRMCoreWS {

	private static final String HEADER = "header";
	private static final String CID_CONTRATO = "cidContrato";
	private static final String ID_PROPOSTA	= "idProposta";
	// Constantes para manter produto
	private static final String LST_DADOS_PRODUTO_NET_TV = "lstDadosProdutoNetTv";
	private static final String LST_DADOS_PRODUTO_NET_VIRTUA = "lstDadosProdutoNetVirtua";
	private static final String LST_DADOS_PRODUTO_NET_FONE = "lstDadosProdutoNetFone";
	// Constantes para manter agregado
	private static final String LST_DADOS_AGREGADO_TV = "lstDadosAgregadoTV";
	private static final String LST_DADOS_AGREGADO_VIRTUA = "lstDadosAgregadoVirtua";
	private static final String LST_DADOS_AGREGADO_FONE = "lstDadosAgregadoFone";
	private static final String LST_ID_PRODUTO = "lstIdProduto";

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
	@WebMethod(action="inserirDadosProdutoProposta")
	
	//Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole (role="ACESSO")})
	
	@WebResult(name="dadosProdutoPropostaRetorno",
			   partName="inserirDadosProdutoPropostaResponse",	
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes")
	public DadosProdutoPropostaRetornoType inserirDadosProdutoProposta(
			@WebParam(header = true, name = "NETFrameworkWSHeader", targetNamespace = 
			    "java:br.com.netservicos.framework.webservice.header") NETFrameworkWSHeader header,
			@WebParam(name = "dadosProdutoPropostaType", targetNamespace = 
			"java:br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes") 
			DadosProdutoPropostaType dadosProdutoPropostaType) {
		
		final DadosProdutoTvType[] lstProdutoTvType = dadosProdutoPropostaType.getLstProdutoTvType();
		final DadosProdutoVirtuaType[] lstProdutoVirtuaType = dadosProdutoPropostaType.getLstProdutoVirtuaType();
		final DadosProdutoFoneType[] lstProdutoFoneType = dadosProdutoPropostaType.getLstProdutoFoneType();
		
		List<DadosProdutoTvDTO> lstProdutoTvDTO = new ArrayList<DadosProdutoTvDTO>();
		List<DadosProdutoVirtuaDTO> lstProdutoVirtuaDTO = new ArrayList<DadosProdutoVirtuaDTO>();
		List<DadosProdutoFoneDTO> lstProdutoFoneDTO = new ArrayList<DadosProdutoFoneDTO>();
		
		if (lstProdutoTvType != null) {
			lstProdutoTvDTO = ManterProdutoHelper.copyPropertiesProdutoTV(lstProdutoTvType);
		}
		if (lstProdutoVirtuaType != null) {
			lstProdutoVirtuaDTO = ManterProdutoHelper.copyPropertiesProdutoVirtua(lstProdutoVirtuaType);
		}
		if (lstProdutoFoneType != null) {
			lstProdutoFoneDTO = ManterProdutoHelper.copyPropertiesProdutoFone(lstProdutoFoneType);
		}
	
		final DynamicBean dadosProduto = new DynamicBean();
		dadosProduto.set(HEADER, header);
		dadosProduto.set(CID_CONTRATO, dadosProdutoPropostaType.getCidadeOperadora().getCodigoOperadora());
		dadosProduto.set(ID_PROPOSTA, dadosProdutoPropostaType.getIdProposta());
		dadosProduto.set(LST_DADOS_PRODUTO_NET_TV, lstProdutoTvDTO);
		dadosProduto.set(LST_DADOS_PRODUTO_NET_VIRTUA, lstProdutoVirtuaDTO);
		dadosProduto.set(LST_DADOS_PRODUTO_NET_FONE, lstProdutoFoneDTO);

		final DadosProdutoPropostaRetornoType retorno = null;

		try {
			final ProdutoService service = super.getService(ProdutoService.class);
			service.inserirProdutoProposta(dadosProduto);
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_INSERIR_PRODUTO_PROPOSTA};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.
			                            RESOURCE_ERROR, parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
		return retorno;
	}
	
	//Nome da ação do web service
	@WebMethod(action="inserirDadosAgregadoProposta")
	
	//Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole (role="ACESSO")})
	
	@WebResult(name="dadosAgregadoPropostaRetorno",
			   partName="inserirDadosAgregadoPropostaResponse",	
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes") 
	public DadosAgregadoPropostaRetornoType inserirDadosAgregadoProposta(
			@WebParam(header = true, name = "NETFrameworkWSHeader", targetNamespace = 
			    "java:br.com.netservicos.framework.webservice.header") NETFrameworkWSHeader header,
			@WebParam(name = "dadosAgregadoPropostaType", targetNamespace = 
			    "java:br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes") 
			    DadosAgregadoPropostaType dadosAgregadoPropostaType) {

		final AgregadoTvType[] lstAgregadoTvType = dadosAgregadoPropostaType.getLstAgregadoTvType();
		final AgregadoVirtuaType[] lstAgregadoVirtuaType = dadosAgregadoPropostaType.getLstAgregadoVirtuaType();
		final AgregadoFoneType[] lstAgregadoFoneType = dadosAgregadoPropostaType.getLstAgregadoFoneType();
		
		List<DadosAgregadoTvDTO> lstAgregadoTvDTO = new ArrayList<DadosAgregadoTvDTO>();
		List<DadosAgregadoVirtuaDTO> lstAgregadoVirtuaDTO = new ArrayList<DadosAgregadoVirtuaDTO>();
		List<DadosAgregadoFoneDTO> lstAgregadoFoneDTO = new ArrayList<DadosAgregadoFoneDTO>();
		
		if (lstAgregadoTvType != null) {
			lstAgregadoTvDTO = ManterProdutoHelper.copyPropertiesAgregadoTV(lstAgregadoTvType);
		}
		if (lstAgregadoVirtuaType != null) {
			lstAgregadoVirtuaDTO = ManterProdutoHelper.copyPropertiesAgregadoVirtua(lstAgregadoVirtuaType);
		}
		if (lstAgregadoFoneType != null) {
			lstAgregadoFoneDTO = ManterProdutoHelper.copyPropertiesAgregadoFone(lstAgregadoFoneType);
		}

		final DynamicBean dadosAgregado = new DynamicBean();
		dadosAgregado.set(HEADER, header);
		dadosAgregado.set(CID_CONTRATO, dadosAgregadoPropostaType.getCidadeOperadora().getIdentificacaoCidade());
		dadosAgregado.set(ID_PROPOSTA, dadosAgregadoPropostaType.getIdProposta());
		dadosAgregado.set(LST_DADOS_AGREGADO_TV, lstAgregadoTvDTO);
		dadosAgregado.set(LST_DADOS_AGREGADO_VIRTUA, lstAgregadoVirtuaDTO);
		dadosAgregado.set(LST_DADOS_AGREGADO_FONE, lstAgregadoFoneDTO);

		final DadosAgregadoPropostaRetornoType retorno = null;

		try {
			final AgregadoService service = super.getService(AgregadoService.class);
			service.inserirAgregadoProposta(dadosAgregado);
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_INSERIR_AGREGADO_PROPOSTA};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
			                                        parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
		return retorno;
	}
	
	//Nome da ação do web service
	@WebMethod(action="deleteAllProdutosProposta")
	
	//Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole (role="ACESSO")})
	
	@WebResult(name="dadosProdutoPropostaRetorno",
			   partName="deleteAllProdutosPropostaResponse",	
targetNamespace="java:br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes")			   
	public DadosProdutoPropostaRetornoType deleteAllProdutosProposta(
			@WebParam(header = true, name = "NETFrameworkWSHeader", targetNamespace 
			= "java:br.com.netservicos.framework.webservice.header") NETFrameworkWSHeader header,
			@WebParam(name = "dadosDeleteAllProdutosType", targetNamespace = 
			    "java:br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes") 
			    DadosDeleteAllProdutosType dadosDeleteAllProdutosType) {

		final DynamicBean dadosDeleteProduto = new DynamicBean();
		dadosDeleteProduto.set(HEADER, header);
		dadosDeleteProduto.set(ID_PROPOSTA, dadosDeleteAllProdutosType.getIdProposta());

		final DadosProdutoPropostaRetornoType retorno = null;

		try {
			final ProdutoService service = super.getService(ProdutoService.class);
			service.deleteAllProdutosProposta(dadosDeleteProduto);
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_DELETE_ALL_PRODUTOS_PROPOSTA};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
			parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
		return retorno;
	}
	
	//Nome da ação do web service
	@SuppressWarnings(GeralConstants.UNCHECKED)
	@WebMethod(action="deleteLstAgregadosProposta")
	
	//Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole (role="ACESSO")})
	
	@WebResult(name="deleteLstProdutosProposta",
			   partName="deleteLstProdutosPropostaResponse",	
	targetNamespace="java:br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes")			   
	public DadosProdutoPropostaRetornoType deleteLstProdutosProposta(
			@WebParam(header = true, name = "NETFrameworkWSHeader", targetNamespace = 
			    "java:br.com.netservicos.framework.webservice.header") NETFrameworkWSHeader header,
			@WebParam(name = "dadosDeleteLstAgregadoType", targetNamespace = 
			    "java:br.com.netservicos.netcrmcore.webservices.prospect.manterproduto.complextypes") 
			    DadosDeleteLstProdutosType dadosDeleteLstProdutoType) {

		final Long[] lstIdProdutoType = dadosDeleteLstProdutoType.getLstIdProduto();
		
		List<Long> lstIdProduto = new ArrayList<Long>();
		
		if (lstIdProdutoType != null) {
			lstIdProduto = ManterProdutoHelper.copyPropertiesLong(lstIdProdutoType);
		}

		final DynamicBean dadosAgregado = new DynamicBean();
		dadosAgregado.set(HEADER, header);
		dadosAgregado.set(CID_CONTRATO, dadosDeleteLstProdutoType.getCidadeOperadora().getIdentificacaoCidade());
		dadosAgregado.set(ID_PROPOSTA, dadosDeleteLstProdutoType.getIdProposta());
		dadosAgregado.set(LST_ID_PRODUTO, lstIdProduto);

		final DadosProdutoPropostaRetornoType retorno = null;

		try {
			final ProdutoService service = super.getService(ProdutoService.class);
			service.deleteLstProdutosProposta(dadosAgregado);
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_DELETE_LST_AGREGADOS_PROPOSTA};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
			parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
		return retorno;
	}
}
