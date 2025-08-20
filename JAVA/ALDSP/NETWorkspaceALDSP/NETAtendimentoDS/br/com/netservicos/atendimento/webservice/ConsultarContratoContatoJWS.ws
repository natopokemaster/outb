<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/webservice/ConsultarContratoContatoJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/contrato/logical/ConsultarContratoContatoDSL.ds">
            <web:function name="consultarContratoPorProtocolo" arity="1" operation="consultarContratoPorProtocolo" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroProtocolo" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>