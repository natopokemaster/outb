<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/fatura/physical/netsms/table/SnCrnoCobrancaInadimplenteDSP_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/fatura/physical/netsms/table/SnCrnoCobrancaInadimplenteDSP.ds">
            <web:function name="getByContractSnCrnoCobrancaInadimplenteDSP" arity="2" operation="getByContractSnCrnoCobrancaInadimplenteDSP" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="cidContrato" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>