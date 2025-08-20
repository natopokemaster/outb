<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/multicidade/logical/entity/MultiCidadeDSL_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/multicidade/logical/entity/MultiCidadeDSL.ds">
            <web:function name="ConsultarRegraEmpresa" arity="2" operation="ConsultarRegraEmpresa" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="P_PARAMERO" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="P_VALOR" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>