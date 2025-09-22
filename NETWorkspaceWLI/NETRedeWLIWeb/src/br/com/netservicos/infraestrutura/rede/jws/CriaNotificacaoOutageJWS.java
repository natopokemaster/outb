package br.com.netservicos.infraestrutura.rede.jws;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;

import weblogic.jws.Binding;

import br.com.netservicos.rede.util.message.RedeMensagemControl;

import com.bea.control.ProcessControlException;
import com.bea.jws.SoapFaultException;

@javax.jws.WebService
//@weblogic.jws.WLHttpTransport(contextPath="NETRedeWLIWeb", serviceUri="br/com/netservicos/infraestrutura/rede/control/process/CriaNotificacaoOutageJWS")
@weblogic.jws.WLHttpTransport(contextPath="NETRedeWLIWeb", serviceUri="br/com/netservicos/infraestrutura/rede/jws/CriaNotificacaoOutageJWS")
@SOAPBinding(parameterStyle=SOAPBinding.ParameterStyle.BARE)
@Binding(Binding.Type.SOAP12)
public class CriaNotificacaoOutageJWS {

    @org.apache.beehive.controls.api.bean.Control
    private br.com.netservicos.infraestrutura.rede.control.process.CriaNotificacaoOutageJPDV1_0ProcessControl _processControl;
    
    @javax.jws.WebMethod
    public java.lang.String criar(br.com.netservicos.rede.outage.ParametrosNotificarOutageDocument request,@WebParam(header = true) br.com.netservicos.v2.netHeader.NetHeaderDocument header)throws Exception {
    String resultado;	
     try{   
    	
    	 resultado =  _processControl.criar(request, header);
     } catch (Exception exc) {
         //Capturando a mensagem tratada e relançando
         while (!(exc instanceof br.com.netservicos.framework.exception.AbstractBaseException || exc.getCause() == null)) {
             exc = (Exception)exc.getCause();
         }
         throw exc;
     }
       return resultado;        
   }

}


