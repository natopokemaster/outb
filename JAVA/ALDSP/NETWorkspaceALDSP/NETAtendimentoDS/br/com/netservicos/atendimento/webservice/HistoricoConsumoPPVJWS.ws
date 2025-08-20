<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/webservice/HistoricoConsumoPPVJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/ppv/logical/entity/HistoricoConsumoPPVDSL.ds">
            <web:function name="listarCompras" arity="1" operation="listarCompras" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="listarCompras" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>