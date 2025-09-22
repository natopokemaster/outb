<?xml version="1.0" encoding="UTF-8"?>
<web:WebServicesMap targetNamespace="ld:br/com/netservicos/atendimento/evento/logical/entity/TipoEventoDSL_ws" soapVersion="SOAP_1.2" transportType="HTTP" ADODotNETEnabled="false" basicAuthRequired="true" xmlns:web="http://www.bea.com/dsp/management/configuration/webservices">
  <web:dataServices>
    <web:dataService locator="ld:br/com/netservicos/atendimento/evento/logical/entity/TipoEventoDSL.ds">
      <web:function name="consultarPorEvento" arity="2" operation="consultarPorEvento" returnInHeader="false">
        <web:parameterMapping>
          <web:parameter name="identificadorEvento" wsdlMapping="SOAP_BODY"/>
          <web:parameter name="identificadorCidade" wsdlMapping="SOAP_BODY"/>
        </web:parameterMapping>
      </web:function>
    </web:dataService>
  </web:dataServices>
</web:WebServicesMap>