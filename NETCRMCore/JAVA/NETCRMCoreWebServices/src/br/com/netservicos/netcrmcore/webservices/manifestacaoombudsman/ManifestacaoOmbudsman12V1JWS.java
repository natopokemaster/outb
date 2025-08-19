package br.com.netservicos.netcrmcore.webservices.manifestacaoombudsman;

import javax.jws.WebMethod;
import javax.jws.WebParam;
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
import br.com.netservicos.netcrmcore.oms.constants.ManifestacaoOmbudsmanConstants;
import br.com.netservicos.netcrmcore.oms.manifestacao.facade.ManifestacaoOmbudsmanService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.manifestacaoombudsman.complextypes.ManifestacaoClienteType;
import br.com.netservicos.netcrmcore.webservices.manifestacaoombudsman.complextypes.ManifestacaoContratoType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

//Anota��es para configura��o dos atributos do web services SOAP 1.2
@WebService(name = ManifestacaoOmbudsmanConstants.WEBSERVICE_NAME, serviceName = ManifestacaoOmbudsmanConstants.WEBSERVICE_SERVICE_NAME, targetNamespace = ManifestacaoOmbudsmanConstants.WEBSERVICE_TARGET)
// Anote��es das configura��es de binding do web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@Binding(Binding.Type.SOAP12)
public class ManifestacaoOmbudsman12V1JWS extends AbstractNETCRMCoreWS {

	// Declara��o do contexto com anota��o para inje��o pelo container
	// � necess�rio que seja colocado na classe 'final'do webservice, caso
	// contr�rio a inje��o ocorre
	@Context
	protected JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}

	// Nome da a��o do web service
	@WebMethod(action = ManifestacaoOmbudsmanConstants.WEB_METHOD_MANIFESTACAO_CONTRATO_ACTION)
	// Defini��o das roles de acesso necess�rias para a execu��o do web services
	@RolesAllowed({@SecurityRole(role="INCLUIR_INTEGRACAO_MANIFESTACAO")})
	
	public void incluirManifestacaoContrato(
			@WebParam(header = true, name = ManifestacaoOmbudsmanConstants.WEB_PARAM_HEADER_NAME, targetNamespace = ManifestacaoOmbudsmanConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = ManifestacaoOmbudsmanConstants.WEB_PARAM_MANIFESTACAO_CONTRATO_NAME, targetNamespace = ManifestacaoOmbudsmanConstants.WEB_PARAM_TARGET) ManifestacaoContratoType manifestacaoContratoType) {

		getUserInfo(header);// Popula as informa��es do usu�rio

		// Dynamic Bean
		DynamicBean integracaoManifestacaoBean = new DynamicBean();

		// Localiza e efetua chamada ao EJB
		try {
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.HEADER, header);
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.DSASSUNTO, manifestacaoContratoType.getDescricaoAssunto());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.DSCANALATENDIMENTO, manifestacaoContratoType.getCanal());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.CDOPERADORA, manifestacaoContratoType.getCodigoOperadora());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.DSMANIFESTACAO, manifestacaoContratoType.getDescricao());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.CDCONTRATO, manifestacaoContratoType.getNumeroContrato());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.CDPROTOCOLO,  manifestacaoContratoType.getProtocolo());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.TPPESSOA, manifestacaoContratoType.getTipoPessoa());
			
			ManifestacaoOmbudsmanService manifestacaoOmbudsmanService = super.getService(ManifestacaoOmbudsmanService.class);
			manifestacaoOmbudsmanService.incluirIntegracaoManifestacaoContrato(integracaoManifestacaoBean);

		} catch (Exception e) {
			// Monta SOAPFaultException em caso de erro
			if(e.getMessage().contains(WebServicesConstants.RESOURCE_ERROR_CANAL)){
				Object[] parameters = new Object[] { WebServicesConstants.RESOURCE_INCLUIR_MANIFESTACAO_CONTRATO };
				SOAPFaultException canalAtendimentoException = generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR_CANAL, parameters, WebServicesConstants.RESOURCE_ERROR_CANAL, e);
				throw canalAtendimentoException;
			}else{
				Object[] parameters = new Object[] { WebServicesConstants.RESOURCE_INCLUIR_MANIFESTACAO_CONTRATO };
				SOAPFaultException soapFaultException = generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR_OMS, parameters, WebServicesConstants.RESOURCE_ERROR_OMS, e);			
				throw soapFaultException;
			}
		}

	}

	// Nome da a��o do web service
	@WebMethod(action = ManifestacaoOmbudsmanConstants.WEB_METHOD_MANIFESTACAO_CLIENTE_ACTION)
	// Defini��o das roles de acesso necess�rias para a execu��o do web services
	@RolesAllowed({@SecurityRole (role="INCLUIR_INTEGRACAO_MANIFESTACAO")})
	
	public void incluirManifestacaoCliente(
			@WebParam(header = true, name = ManifestacaoOmbudsmanConstants.WEB_PARAM_HEADER_NAME, targetNamespace = ManifestacaoOmbudsmanConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = ManifestacaoOmbudsmanConstants.WEB_PARAM_MANIFESTACAO_CLIENTE_NAME, targetNamespace = ManifestacaoOmbudsmanConstants.WEB_PARAM_TARGET) ManifestacaoClienteType manifestacaoClienteType) {

		getUserInfo(header);// Popula as informa��es do usu�rio

		// Dynamic Bean
		DynamicBean integracaoManifestacaoBean = new DynamicBean();

		// Localiza e efetua chamada ao EJB
		try {
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.HEADER, header);
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.DSASSUNTO, manifestacaoClienteType.getDescricaoAssunto());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.NMBAIRRO, manifestacaoClienteType.getBairro());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.DSCANALATENDIMENTO, manifestacaoClienteType.getCanal());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.NRCEP, manifestacaoClienteType.getCep());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.NMCIDADE, manifestacaoClienteType.getCidade());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.CNPJ, manifestacaoClienteType.getCnpj());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.DSCOMPLEMENTO, manifestacaoClienteType.getComplemento());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.CPF, manifestacaoClienteType.getCpf());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.DSMANIFESTACAO, manifestacaoClienteType.getDescricao());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.DSEMAIL, manifestacaoClienteType.getEmail());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.NMLOGRADOURO, manifestacaoClienteType.getEndereco());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.NMCLIENTE, manifestacaoClienteType.getNome());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.NRLOGRADOURO, manifestacaoClienteType.getNumeroEndereco());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.NRTELEFONECLIENTE, manifestacaoClienteType.getDdd().concat(manifestacaoClienteType.getTelefoneContato()));
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.TPPESSOA, manifestacaoClienteType.getTipoPessoa());
			integracaoManifestacaoBean.set(ManifestacaoOmbudsmanConstants.SGUF, manifestacaoClienteType.getUf());

			ManifestacaoOmbudsmanService manifestacaoOmbudsmanService = super.getService(ManifestacaoOmbudsmanService.class);
			manifestacaoOmbudsmanService.incluirIntegracaoManifestacaoCliente(integracaoManifestacaoBean);

		} catch (Exception e) {
			// Monta SOAPFaultException em caso de erro
			if(e.getMessage().contains(WebServicesConstants.RESOURCE_ERROR_CANAL)){
				Object[] parameters = new Object[] { WebServicesConstants.RESOURCE_INCLUIR_MANIFESTACAO_CLIENTE };
				SOAPFaultException canalAtendimentoException = generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR_CANAL, parameters, WebServicesConstants.RESOURCE_ERROR_CANAL, e);
				throw canalAtendimentoException;
			}else{
				Object[] parameters = new Object[] { WebServicesConstants.RESOURCE_INCLUIR_MANIFESTACAO_CLIENTE };
				SOAPFaultException soapFaultException = generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR_OMS, parameters, WebServicesConstants.RESOURCE_ERROR_OMS, e);	
				throw soapFaultException;
			}
		}

	}

}
