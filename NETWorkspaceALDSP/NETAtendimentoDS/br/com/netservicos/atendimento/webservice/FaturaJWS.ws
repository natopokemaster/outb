<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/webservice/FaturaJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/fatura/logical/entity/FaturaDSL.ds">
            <web:function name="listarFaturasContratoPagaveis" arity="3" operation="listarFaturasContratoPagaveis" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificadorCanalAtendimento" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="listarFaturasContrato" arity="6" operation="listarFaturasContrato" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificadorCanalAtendimento" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="quantidadeFaturas" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dataInicio" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dataFim" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>