<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/webservice/IdentificarContratosJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/contrato/logical/entity/IdentificarContratosDSL.ds">
            <web:function name="identificarContratosPorDocumento" arity="1" operation="identificarContratosPorDocumento" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="documento" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="identificarContratoPorProtocolo" arity="1" operation="identificarContratoPorProtocolo" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="protocolo" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="identificarContratosPorTelefone" arity="1" operation="identificarContratosPorTelefone" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="telefone" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="identificarContratoPorCodigoCliente" arity="2" operation="identificarContratoPorCodigoCliente" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="cidContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="numContrato" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>