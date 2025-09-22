<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/clienteprospect/logical/entity/ClienteProspectDSL.ds">
            <web:function name="consultarClientesPorCPF" arity="1" operation="consultarClientesPorCPF" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="cpf" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="consultarClientePorContrato" arity="2" operation="consultarClientePorContrato" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="consultarClientesPorTelefoneContato" arity="2" operation="consultarClientesPorTelefoneContato" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="ddd" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="numeroTelefone" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="consultarClientesPorCNPJ" arity="1" operation="consultarClientesPorCNPJ" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="cnpj" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>