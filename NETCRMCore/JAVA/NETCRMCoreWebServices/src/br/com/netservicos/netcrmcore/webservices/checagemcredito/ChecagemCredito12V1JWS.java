package br.com.netservicos.netcrmcore.webservices.checagemcredito;

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
import br.com.netservicos.netcrmcore.cliente.constants.ClienteConstants;
import br.com.netservicos.netcrmcore.cliente.constants.CreditoConstants;
import br.com.netservicos.netcrmcore.cliente.core.facade.CreditoService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.checagemcredito.complextypes.ChecagemCreditoExternoInType;
import br.com.netservicos.netcrmcore.webservices.checagemcredito.complextypes.ChecagemCreditoInternoInType;
import br.com.netservicos.netcrmcore.webservices.checagemcredito.complextypes.ChecagemCreditoOutType;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;

//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name = CreditoConstants.WEBSERVICE_NAME, serviceName = CreditoConstants.WEBSERVICE_SERVICE_NAME, 
		targetNamespace = CreditoConstants.WEBSERVICE_TARGET)

// Anoteções das configurações de binding do web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)

@Binding(Binding.Type.SOAP12)
public class ChecagemCredito12V1JWS extends AbstractNETCRMCoreWS {

	// Declaração do contexto com anotação para injeção pelo container
	// É necessário que seja colocado na classe 'final'do webservice, caso
	// contrário a injeção ocorre
	@Context
	protected JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}
	
	private static final String CHECA_CNPJ = "N\u00e3o \u00e9 poss\u00edvel checar o cr\u00e9dito externo de CNPJ.";

	// Nome da ação do web service
	@WebMethod(action = CreditoConstants.WEB_METHOD_CHECAR_CRED_INTERNO_ACTION)
	
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole(role="ACESSO")}) //INCLUIR_INTEGRACAO_MANIFESTACAO
	
	@WebResult(name=CreditoConstants.WEB_PARAM_CHECAR_CREDITO_INTERNO,
			   partName="checarCreditoInternoResponse",
			   targetNamespace=CreditoConstants.WEB_PARAM_TARGET)
	public ChecagemCreditoOutType checarCreditoInterno(
			@WebParam(header = true, name = CreditoConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
				CreditoConstants.WEB_PARAM_HEADER_TARGET) final NETFrameworkWSHeader header,
			@WebParam(name = CreditoConstants.WEB_PARAM_CHECAR_CREDITO_INTERNO, targetNamespace =
				CreditoConstants.WEB_PARAM_TARGET) 
				final ChecagemCreditoInternoInType checCreditoType) {

		getUserInfo(header);// Popula as informações do usuário

		// Dynamic Bean
		final DynamicBean bean = new DynamicBean();
		
		//Instancia retorno
		final ChecagemCreditoOutType retorno = new ChecagemCreditoOutType();
		
						
		// Localiza e efetua chamada ao EJB
		try {
					
			bean.set(ClienteConstants.HEADER, header);
			bean.set(CreditoConstants.ID_PROSPECT, Long.valueOf(checCreditoType.getIdProspect()));
			
			if(!"".equals(checCreditoType.getCpf())){
                bean.set(CreditoConstants.CPF, Long.valueOf(checCreditoType.getCpf()));
            }
            if(!"".equals(checCreditoType.getCnpj())){
                bean.set(CreditoConstants.CNPJ, Long.valueOf(checCreditoType.getCnpj()));
            }
            bean.set(CreditoConstants.ID_TIPO_PESSOA, Integer.valueOf(checCreditoType.getIdTipoPessoa()));
									
			final CreditoService creditoService = super.getService(CreditoService.class);
			final DynamicBean dynamicRetorno =  creditoService.checarCreditoInterno(bean);
			
			if(dynamicRetorno.get("error")!= null){
			    
			    final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CHEC_CRED_INTERNO};
	            final SOAPFaultException soapException =  
	                generateSOAPFaultException(WebServicesConstants.RESOURCE_PROSPECT_INEXISTENTE,
	                    parameters, WebServicesConstants.RESOURCE_PROSPECT_INEXISTENTE);
	            
	            throw soapException;
			}
			    
			retorno.setStatusCredito( (String) dynamicRetorno.get(CreditoConstants.VERIFICACAO_CREDITO) );
			
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CHEC_CRED_INTERNO};
			final SOAPFaultException soapException =  
				generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR,
					parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw soapException;
		}
		
		return retorno;

	}
	
	// Nome da ação do web service
	@WebMethod(action = CreditoConstants.WEB_METHOD_CHECAR_CRED_EXTERNO_ACTION)
	
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole(role="ACESSO")}) //INCLUIR_INTEGRACAO_MANIFESTACAO
	
	@WebResult(name=CreditoConstants.WEB_PARAM_CHECAR_CREDITO_EXTERNO,
			   partName="checarCreditoExternoResponse",
			   targetNamespace=CreditoConstants.WEB_PARAM_TARGET)
	public ChecagemCreditoOutType checarCreditoExterno(
			@WebParam(header = true, name = CreditoConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
				CreditoConstants.WEB_PARAM_HEADER_TARGET) final NETFrameworkWSHeader header,
			@WebParam(name = CreditoConstants.WEB_PARAM_CHECAR_CREDITO_EXTERNO, targetNamespace =
				CreditoConstants.WEB_PARAM_TARGET) 
				final ChecagemCreditoExternoInType checCreditoType) {

		getUserInfo(header);// Popula as informações do usuário

		// Dynamic Bean
		final DynamicBean bean = new DynamicBean();
		
		//Instancia retorno
		final ChecagemCreditoOutType retorno = new ChecagemCreditoOutType();
		
						
		// Localiza e efetua chamada ao EJB
		try {
					
		    if("".equals(checCreditoType.getCnpj())){
		        
    			bean.set(ClienteConstants.HEADER, header);
    			bean.set(CreditoConstants.ID_PROSPECT, Long.valueOf(checCreditoType.getIdProspect()));
    			if(!"".equals(checCreditoType.getCpf())){
    				bean.set(CreditoConstants.CPF, Long.valueOf(checCreditoType.getCpf()));
    			}
    			if(!"".equals(checCreditoType.getCnpj())){
    				bean.set(CreditoConstants.CNPJ, Long.valueOf(checCreditoType.getCnpj()));
    			}
    			bean.set(CreditoConstants.ID_TIPO_PESSOA, Integer.valueOf(checCreditoType.getIdTipoPessoa()));
    			
    			bean.set(CreditoConstants.USER_GC, checCreditoType.getUserGC());
    	        bean.set(CreditoConstants.PASS_GC, checCreditoType.getPassGC());
    	        bean.set(CreditoConstants.USER_SERASA, checCreditoType.getUserSerasa());
    	        bean.set(CreditoConstants.PASS_SERASA, checCreditoType.getPassSerasa());
    									
    			final CreditoService creditoService = super.getService(CreditoService.class);
    			
    			DynamicBean dynamicRetorno = creditoService.checarCreditoExterno(bean);
    			
    			if(dynamicRetorno.get("error")!= null){
                    
                    final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CHEC_CRED_EXTERNO};
                    final SOAPFaultException soapException =  
                        generateSOAPFaultException(WebServicesConstants.RESOURCE_PROSPECT_INEXISTENTE,
                            parameters, WebServicesConstants.RESOURCE_PROSPECT_INEXISTENTE);
                    
                    throw soapException;
                }
    			retorno.setStatusCredito( (String) dynamicRetorno.get(CreditoConstants.VERIFICACAO_CREDITO) );
		    }else{
		        retorno.setStatusCredito(CHECA_CNPJ);
		    }
			
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CHEC_CRED_EXTERNO};
			final SOAPFaultException soapException =  
				generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR,
					parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw soapException;
		}
		
		return retorno;

	}
	
	
	
	// Nome da ação do web service
    @WebMethod(action = CreditoConstants.WEB_METHOD_CHECAR_CRED_INT_EXT_ACTION)
    
    // Definição das roles de acesso necessárias para a execução do web services
    @RolesAllowed({@SecurityRole(role="ACESSO")}) //INCLUIR_INTEGRACAO_MANIFESTACAO
    
    @WebResult(name=CreditoConstants.WEB_PARAM_CHECAR_CREDITO_INT_EXT,
               partName="checarCreditoInternoExternoResponse",
               targetNamespace=CreditoConstants.WEB_PARAM_TARGET)
    public ChecagemCreditoOutType checarCreditoInternoExterno(
            @WebParam(header = true, name = CreditoConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
                CreditoConstants.WEB_PARAM_HEADER_TARGET) final NETFrameworkWSHeader header,
            @WebParam(name = CreditoConstants.WEB_PARAM_CHECAR_CREDITO_INT_EXT, targetNamespace =
                CreditoConstants.WEB_PARAM_TARGET) 
                final ChecagemCreditoExternoInType checCreditoType) {

        getUserInfo(header);// Popula as informações do usuário

        // Dynamic Bean
        final DynamicBean bean = new DynamicBean();
        
        //Instancia retorno
        final ChecagemCreditoOutType retorno = new ChecagemCreditoOutType();
        
                        
        // Localiza e efetua chamada ao EJB
        try {
            if("".equals(checCreditoType.getCnpj())){
                    
                bean.set(ClienteConstants.HEADER, header);
                bean.set(CreditoConstants.ID_PROSPECT, Long.valueOf(checCreditoType.getIdProspect()));
                if(!"".equals(checCreditoType.getCpf())){
                    bean.set(CreditoConstants.CPF, Long.valueOf(checCreditoType.getCpf()));
                }
                if(!"".equals(checCreditoType.getCnpj())){
                    bean.set(CreditoConstants.CNPJ, Long.valueOf(checCreditoType.getCnpj()));
                }
                bean.set(CreditoConstants.ID_TIPO_PESSOA, Integer.valueOf(checCreditoType.getIdTipoPessoa()));
                
                bean.set(CreditoConstants.USER_GC, checCreditoType.getUserGC());
                bean.set(CreditoConstants.PASS_GC, checCreditoType.getPassGC());
                bean.set(CreditoConstants.USER_SERASA, checCreditoType.getUserSerasa());
                bean.set(CreditoConstants.PASS_SERASA, checCreditoType.getPassSerasa());
                                        
                final CreditoService creditoService = super.getService(CreditoService.class);
                final DynamicBean dynamicRetorno = creditoService.checarCreditoInternoExterno(bean);
                
                if(dynamicRetorno.get("error")!= null){
                    
                    final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CHEC_CRED_INT_EXT};
                    final SOAPFaultException soapException =  
                        generateSOAPFaultException(WebServicesConstants.RESOURCE_PROSPECT_INEXISTENTE,
                            parameters, WebServicesConstants.RESOURCE_PROSPECT_INEXISTENTE);
                    
                    throw soapException;
                }
                    retorno.setStatusCredito( (String) dynamicRetorno.get(CreditoConstants.VERIFICACAO_CREDITO) );
                
            }else{
                
                retorno.setStatusCredito(CHECA_CNPJ);
                
            }
            
            
        } catch (Exception e) {
            //Monta SOAPFaultException em caso de erro
            final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_CHEC_CRED_INT_EXT};
            final SOAPFaultException soapException =  
                generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR,
                    parameters, WebServicesConstants.RESOURCE_ERROR, e);
            
            throw soapException;
        }
        
        return retorno;
    }
}
