package br.com.netservicos.netcrmcore.webservices.venda.reservar;

import java.util.List;

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
import br.com.netservicos.netcrmcore.venda.constants.TelefoneConstants;
import br.com.netservicos.netcrmcore.venda.telefone.facade.NumeroTelefoneNETfoneService;
import br.com.netservicos.netcrmcore.webservices.AbstractNETCRMCoreWS;
import br.com.netservicos.netcrmcore.webservices.resources.WebServicesConstants;
import br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes.CancelarReservaTelefoneInType;
import br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes.CancelarReservaTelefoneOutType;
import br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes.ListarTelefoneInType;
import br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes.ListarTelefoneOutType;
import br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes.ReservarTelefoneInType;
import br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes.ReservarTelefoneOutType;

//Anotações para configuração dos atributos do web services SOAP 1.2
@WebService(name = TelefoneConstants.WEBSERVICE_NAME, serviceName = 
    TelefoneConstants.WEBSERVICE_SERVICE_NAME, targetNamespace = TelefoneConstants.WEBSERVICE_TARGET)

// Anoteções das configurações de binding do web service
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)

@Binding(Binding.Type.SOAP12)
public class NumeroTelefoneNETfone12V1JWS extends AbstractNETCRMCoreWS {

	// Declaração do contexto com anotação para injeção pelo container
	// É necessário que seja colocado na classe 'final'do webservice, caso
	// contrário a injeção ocorre
	@Context
	protected JwsContext context;

	@Override
	protected JwsContext getWSContext() {
		return this.context;
	}

	// Nome da ação do web service
	@WebMethod(action = TelefoneConstants.WEB_METHOD_LISTAR_NUMERO_TELEFONE_ASSINANTE_ACTION)
	
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole(role="ACESSO")}) //INCLUIR_INTEGRACAO_MANIFESTACAO
	
	@WebResult(name="listarTelefones",
			   partName="listarTelefonesResponse",
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes")
	public ListarTelefoneOutType[] listarTelefones(
			@WebParam(header = true, name = TelefoneConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
			    TelefoneConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = TelefoneConstants.WEB_PARAM_LISTAR_NUMERO_TELEFONE_ASSINANTE_NAME, targetNamespace = 
			    TelefoneConstants.WEB_PARAM_TARGET) ListarTelefoneInType listarTelType) {

		getUserInfo(header);// Popula as informações do usuário
		
		// Dynamic Bean
		final DynamicBean integracaoBean = new DynamicBean();
		
		//Instancia retorno
		ListarTelefoneOutType[] retorno;

		// Localiza e efetua chamada ao EJB
		try {
			integracaoBean.set(TelefoneConstants.HEADER, header);
			integracaoBean.set(TelefoneConstants.WEB_PARAM_LISTAR_NUMERO_TELEFONE_ASSINANTE_NAME, 
			                                        listarTelType);
			integracaoBean.addBeanProperty(TelefoneConstants.PCIDADE_CONTRATO, 
			                                        listarTelType.getCidContrato());
			integracaoBean.addBeanProperty(TelefoneConstants.PDDD_TELEFONE, 
			                                        listarTelType.getDddTelefoneVoip());
			integracaoBean.addBeanProperty(TelefoneConstants.PTELEFONE_INICIAL, 
			                                        listarTelType.getNumTelefoneVoipInicial());
			integracaoBean.addBeanProperty(TelefoneConstants.PGOLDEN, 
			                                        listarTelType.getGolden());
			integracaoBean.addBeanProperty(TelefoneConstants.PNUMERO_CONTRATO, 
			                                        listarTelType.getNumContrato());
			integracaoBean.addBeanProperty(TelefoneConstants.PID_PROPOSTA, 
			                                        listarTelType.getNumContrato());
			integracaoBean.addBeanProperty(TelefoneConstants.LIMITE_TELEFONES, 
			                                        listarTelType.getLimiteDeTelefones());
			
			// Chama o EJB e traz os dados numa lista para 
			final NumeroTelefoneNETfoneService listarService = super.getService(NumeroTelefoneNETfoneService.class);
			final List<?> lista = listarService.listarTelefones(integracaoBean);
			
			Integer limiteDeTelefone = null;
			final Integer limiteIntegracao = lista.size();
			Integer limiteParaRemover = 0;
			
			// Validando a quantidade de linhas para retornar
			if((listarTelType.getLimiteDeTelefones() != null && 
			                                        !listarTelType.getLimiteDeTelefones().equals(""))){
				limiteDeTelefone = Integer.valueOf(listarTelType.getLimiteDeTelefones());
				if(limiteDeTelefone >= limiteIntegracao){
					limiteDeTelefone = null;
				} else {
					limiteParaRemover = (limiteIntegracao - limiteDeTelefone);
					for (int j = 0; j < limiteParaRemover; j++) {
						lista.remove(lista.size()-1);
					}
				}
			}
			
			retorno = new ListarTelefoneOutType[lista.size()];
			
			for (int j = 0; j < retorno.length; j++) {
				for (Object object : lista) {
					final ListarTelefoneOutType tel = new ListarTelefoneOutType();
					final DynamicBean bean = (DynamicBean) object;
					tel.setCidContrato(bean.get(TelefoneConstants.CIDADE_CONTRATO).toString());
					//tel.setNumContrato(bean.get(TelefoneConstants.NUMERO_CONTRATO).toString());
					//tel.setIdPonto(bean.get(TelefoneConstants.ID_PONTO).toString());
					tel.setDddTelefoneVoip(bean.get(TelefoneConstants.DDD_TELEFONE_VOIP).toString());
					tel.setNumTelefoneVoip(bean.get(TelefoneConstants.NUMERO_TELEFONE_VOIP).toString());
					//tel.setFQDN(bean.get(TelefoneConstants.FQDN).toString());
					//tel.setNumPorta(bean.get(TelefoneConstants.NUMERO_PORTA).toString());
					tel.setDtIni(bean.get(TelefoneConstants.DATA_INI).toString());
					tel.setDtFim(bean.get(TelefoneConstants.DATA_FIM).toString());
					//tel.setDtAlteracao(bean.get(TelefoneConstants.DATA_ALTERACAO).toString());
					tel.setCidContrato(bean.get(TelefoneConstants.CIDADE_CONTRATO).toString());
					tel.setIdStatusTelefoneVoip(bean.get(TelefoneConstants.ID_STATUS_TELEFONE_VOIP).toString());
					tel.setGolden(bean.get(TelefoneConstants.GOLDEN).toString());
					//tel.setTmId(bean.get(TelefoneConstants.TMID).toString());
					//tel.setIdEscolhido(bean.get(TelefoneConstants.ID_ESCOLHIDO).toString());
					//tel.setPublicar(bean.get(TelefoneConstants.PUBLICAR).toString());
					//tel.setNomePublicacao(bean.get(TelefoneConstants.NOME_PUBLICACAO).toString());
					//tel.setNumContratoAvaliacao(bean.get(TelefoneConstants.NUMERO_CONTRATO_AVALIACAO).toString());
					//tel.setIdSistemaExterno(bean.get(TelefoneConstants.ID_SISTEMA_EXTERNO).toString());
					//tel.setCidContratoOrigem(bean.get(TelefoneConstants.CIDADE_CONTRATO_ORIGEM).toString());
					tel.setIdSoftX(bean.get(TelefoneConstants.ID_SOFTX).toString());
					tel.setFcNumeroPortado(bean.get(TelefoneConstants.FC_NUMERO_PORTADO).toString());
					tel.setFcInterceptado(bean.get(TelefoneConstants.CIDADE_CONTRATO).toString());
					retorno[j] = tel;
					j++;
				}
				return retorno;
			}
			return null;
			
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_LISTAR_TELEFONES};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
			                                        parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
	}
	
	// Nome da ação do web service
	@WebMethod(action = TelefoneConstants.WEB_METHOD_RESERVAR_NUMERO_TELEFONE_ASSINANTE_ACTION)
	
	// Definição das roles de acesso necessárias para a execução do web services
	@RolesAllowed({@SecurityRole(role="ACESSO")})
	
	@WebResult(name="reservarTelefones",
			   partName="reservarTelefonesResponse",
			   targetNamespace="java:br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes")
	public ReservarTelefoneOutType reservarTelefones(
			@WebParam(header = true, name = TelefoneConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
			    TelefoneConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
			@WebParam(name = TelefoneConstants.WEB_PARAM_RESERVAR_NUMERO_TELEFONE_ASSINANTE_NAME, targetNamespace = 
			    TelefoneConstants.WEB_PARAM_TARGET) ReservarTelefoneInType reservarTelInType) {

		getUserInfo(header);// Popula as informações do usuário
		
		// Dynamic Bean
		final DynamicBean bean = new DynamicBean();
		
		final ReservarTelefoneOutType reOutType = new ReservarTelefoneOutType();
		
		// Localiza e efetua chamada ao EJB
		try {
			bean.set(TelefoneConstants.HEADER, header);
			bean.set(TelefoneConstants.ID_PROPOSTA, reservarTelInType.getIdProposta());
			bean.set(TelefoneConstants.PUBLICA_NUMERO, reservarTelInType.getPublicaNumero());
			
			String [] telefones = new String[reservarTelInType.getDadosReservaTelefone().length];
			for (int i = 0; i < reservarTelInType.getDadosReservaTelefone().length; i++) {
                telefones[i]= reservarTelInType.getDadosReservaTelefone()[i].getDdd() +"-"+ 
                reservarTelInType.getDadosReservaTelefone()[i].getTelefone();
            }
			
			bean.set(TelefoneConstants.TELEFONES, telefones);						
			 
			final NumeroTelefoneNETfoneService reservarService = super.getService(NumeroTelefoneNETfoneService.class);
			final DynamicBean retorno  = reservarService.reservaTelefoneVoip(bean);
						
			reOutType.setMensagem((String)retorno.get(TelefoneConstants.MENSAGEM));
			
			
		} catch (Exception e) {
			//Monta SOAPFaultException em caso de erro
			final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_RESERVAR_TELEFONES};
			final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
			                                        parameters, WebServicesConstants.RESOURCE_ERROR, e);
			
			throw exception;
		}
		
		return reOutType;
		
	}
	
	
	// Nome da ação do web service
    @WebMethod(action = TelefoneConstants.WEB_METHOD_CANCELAR_RESERVAR_NUMERO_TELEFONE_ACTION)
    
    // Definição das roles de acesso necessárias para a execução do web services
    @RolesAllowed({@SecurityRole(role="ACESSO")})
    
    @WebResult(name="cancelarReservaTelefone",
               partName="cancelarReservaTelefoneResponse",
               targetNamespace="java:br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes")
    public CancelarReservaTelefoneOutType cancelarReservaTelefone(
            @WebParam(header = true, name = TelefoneConstants.WEB_PARAM_HEADER_NAME, targetNamespace = 
                TelefoneConstants.WEB_PARAM_HEADER_TARGET) NETFrameworkWSHeader header,
            @WebParam(name = TelefoneConstants.WEB_PARAM_CANCELAR_RESERVAR_NUMERO_TELEFONE_NAME, targetNamespace =
                TelefoneConstants.WEB_PARAM_TARGET) CancelarReservaTelefoneInType cancelarType) {

        getUserInfo(header);// Popula as informações do usuário
        
        // Dynamic Bean
       final  DynamicBean bean = new DynamicBean();
        
       final CancelarReservaTelefoneOutType reOutType = new CancelarReservaTelefoneOutType();
        
        // Localiza e efetua chamada ao EJB
        try {
            
            bean.set(TelefoneConstants.ID_PROPOSTA, cancelarType.getIdProposta());
                                    
            final NumeroTelefoneNETfoneService reservarService = super.getService(NumeroTelefoneNETfoneService.class);
            final DynamicBean retorno  = reservarService.cancelaReservaTelefoneVoip(bean);
                        
            reOutType.setMensagem((String)retorno.get(TelefoneConstants.MENSAGEM));
            
            
        } catch (Exception e) {
            //Monta SOAPFaultException em caso de erro
            final Object[] parameters = new Object[]{WebServicesConstants.RESOURCE_RESERVAR_TELEFONES};
            final SOAPFaultException exception =  generateSOAPFaultException(WebServicesConstants.RESOURCE_ERROR, 
                                                    parameters, WebServicesConstants.RESOURCE_ERROR, e);
            
            throw exception;
        }
        
        return reOutType;
        
    }
	
}
	
	
