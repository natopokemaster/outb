<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/historicoatendimento/webservice/HistoricoAtendimentoJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/historicoatendimento/logical/library/PgsmsPesquisaAtendimentoDSL.ds">
            <web:function name="buscarHistoricoContrato" arity="5" operation="buscarHistoricoContrato" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dataIni" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dataFim" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="status" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="buscarHistoricoProtocolo" arity="5" operation="buscarHistoricoProtocolo" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="numeroProtocolo" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="identificacaoCidade" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dataIni" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dataFim" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="status" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>