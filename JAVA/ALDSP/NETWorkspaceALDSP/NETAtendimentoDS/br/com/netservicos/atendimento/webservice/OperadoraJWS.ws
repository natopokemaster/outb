<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/operadora/logical/entity/OperadoraDSL_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/operadora/logical/entity/OperadoraDSL.ds">
            <web:function name="consultarConcorrenteTelefoniaPorDescricao" arity="1" operation="consultarConcorrenteTelefoniaPorDescricao" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="descricao" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="listarConcorrentesTelefonia" arity="0" operation="listarConcorrentesTelefonia" returnInHeader="false"/>
            <web:function name="consultarConcorrenteTelefoniaPorID" arity="1" operation="consultarConcorrenteTelefoniaPorID" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="identificadorConcorrente" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>