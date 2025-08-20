<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/devolucaovalores/DevolucaoValoresJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/devolucaovalores/logical/entity/DevolucaoValoresDSL.ds">
            <web:function name="inserir" arity="19" operation="inserir" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numDocumento" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="nomeCompleto" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="idBanco" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="agencia" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="conta" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="digito" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="idMotivoReembolso" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dobro" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="reemissao" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dddTelefone1" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="numTelefone1" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dddTelefone2" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="numTelefone2" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dddCelular" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="numCelular" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="email" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="observacao" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="pchamada" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="pprotocolo" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="consultar" arity="1" operation="consultar" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numDocumento" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>