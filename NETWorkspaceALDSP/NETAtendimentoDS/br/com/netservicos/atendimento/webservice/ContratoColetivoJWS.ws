<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/contratocoletivo/logical/entity/ContratoColetivoDSL_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/contratocoletivo/logical/entity/ContratoColetivoDSL.ds">
            <web:function name="consultarMestre" arity="2" operation="consultarMestre" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="listarContratosColetivos" arity="2" operation="listarContratosColetivos" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>