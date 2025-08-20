<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/chave/contrato/logical/BuscarChaveContratoDSL_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/chave/contrato/logical/BuscarChaveContratoDSL.ds">
            <web:function name="getChaveContrato" arity="2" operation="getChaveContrato" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="cidContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="numContrato" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>