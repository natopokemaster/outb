<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/autorizacaoproduto/logical/entity/AutorizacaoProdutoDSL_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/autorizacaoproduto/logical/entity/AutorizacaoProdutoDSL.ds">
            <web:function name="autorizarProduto" arity="2" operation="autorizarProduto" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="cpf" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="codigoParceiro" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>