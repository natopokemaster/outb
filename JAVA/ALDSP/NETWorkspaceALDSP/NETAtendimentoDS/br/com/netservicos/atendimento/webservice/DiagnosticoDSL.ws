<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/diagnostico/logical/DiagnosticoDSL_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
  <web:dataServices>
    <web:dataService locator="ld:br/com/netservicos/atendimento/diagnostico/logical/entity/DiagnosticoDSL.ds">
      <web:function name="consultarEventos" arity="2" operation="consultarEventos" returnInHeader="false">
        <web:parameterMapping>
          <web:parameter name="codigoDiagnostico" wsdlMapping="SOAP_BODY"/>
          <web:parameter name="identificadorPontoInstalacao" wsdlMapping="SOAP_BODY"/>
        </web:parameterMapping>
      </web:function>
      <web:function name="consultarTipoDiagnosticoPorCodigo" arity="1" operation="consultarTipoDiagnosticoPorCodigo" returnInHeader="false">
        <web:parameterMapping>
          <web:parameter name="codigo" wsdlMapping="SOAP_BODY"/>
        </web:parameterMapping>
      </web:function>
      <web:function name="consultarEnderecavelSecundario" arity="1" operation="consultarEnderecavelSecundario" returnInHeader="false">
        <web:parameterMapping>
          <web:parameter name="enderecavelPrincipal" wsdlMapping="SOAP_BODY"/>
        </web:parameterMapping>
      </web:function>
    </web:dataService>
  </web:dataServices>
</web:WebServicesMap>