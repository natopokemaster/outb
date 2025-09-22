<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/venda/procon/logical/RestricaoContatoProconDSL_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/venda/procon/logical/RestricaoContatoProconDSL.ds">
            <web:function name="inserirRegistroConsultaRestricaoContatoProcon" arity="1" operation="inserirRegistroConsultaRestricaoContatoProcon" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="arg0" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="consultarListaRestricoesContatoProcon" arity="3" operation="consultarListaRestricoesContatoProcon" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="ddd" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="telefone" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="consultarRestricaoContatoProcon" arity="3" operation="consultarRestricaoContatoProcon" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="ddd" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="telefone" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>