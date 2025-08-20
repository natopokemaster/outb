<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/webservice/CanalAtendimentoJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/canalatendimento/logical/entity/CanalAtendimentoDSL.ds">
            <web:function name="consultarPorID" arity="1" operation="consultarPorID" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="identificadorCanalAtendimento" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>