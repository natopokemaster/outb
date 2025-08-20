<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/webservice/OcorrenciaJWS.ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
    <web:dataServices>
        <web:dataService locator="ld:br/com/netservicos/atendimento/evento/logical/entity/StatusOcorrenciaDSL.ds">
            <web:function name="consultarStatusOcorrenciaByTipoOcorrencia" arity="1" operation="consultarStatusOcorrenciaByTipoOcorrencia" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="idTipoOcorrencia" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
        <web:dataService locator="ld:br/com/netservicos/atendimento/evento/physical/netsms/sql/OcorrenciaDSP.ds">
            <web:function name="inserirOcorrencia" arity="10" operation="inserirOcorrencia" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="idTipoOcorrencia" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="idAssinante" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="nomeInformante" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="telInformante" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dtOcorrencia" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="idUsr" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="situacao" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dtRetorno" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="idOrigemOcorrencia" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="obs" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="inserirCacheOcorrencia" arity="6" operation="inserirCacheOcorrencia" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="cdHashCode" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="dsEndpoint" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="xtRequisicao" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="xtResposta" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="numContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="cidContrato" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
            <web:function name="consultarDadosOcorrencia" arity="5" operation="consultarDadosOcorrencia" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="cdHashCode" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="descricao" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="idTipoOcorrencia" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="numContrato" wsdlMapping="SOAP_BODY"/>
                    <web:parameter name="cidContrato" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
        <web:dataService locator="ld:br/com/netservicos/atendimento/evento/logical/entity/OrigemOcorrenciaDSL.ds">
            <web:function name="consultarOrigemOcorrenciaByDescricao" arity="1" operation="consultarOrigemOcorrenciaByDescricao" returnInHeader="false">
                <web:parameterMapping>
                    <web:parameter name="descricao" wsdlMapping="SOAP_BODY"/>
                </web:parameterMapping>
            </web:function>
        </web:dataService>
    </web:dataServices>
</web:WebServicesMap>