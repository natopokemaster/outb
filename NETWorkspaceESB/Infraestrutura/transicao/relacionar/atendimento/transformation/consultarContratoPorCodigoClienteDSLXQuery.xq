(:: pragma bea:global-element-parameter parameter="$consultarContratoPorCodigoClienteRequest1" element="ns1:consultarContratoPorCodigoClienteRequest" location="../wsdl/proxy/IdentificarContratos.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:identificarContratoPorCodigoCliente" location="../wsdl/business/IdentificarContratosDSL.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/consultarContratoPorCodigoClienteDSLXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/atendimento/webservice/IdentificarContratosJWS.ws";
declare namespace ns1 = "http://www.netservicos.com.br/IdentificarContratos/";

declare function xf:consultarContratoPorCodigoClienteDSLXQuery($consultarContratoPorCodigoClienteRequest1 as element(ns1:consultarContratoPorCodigoClienteRequest),
    $cidadeContrato as xs:string)
    as element(ns0:identificarContratoPorCodigoCliente) {
        <ns0:identificarContratoPorCodigoCliente>
            <ns0:cidContrato>{ $cidadeContrato }</ns0:cidContrato>
            <ns0:numContrato>{ xs:integer( fn:substring(data($consultarContratoPorCodigoClienteRequest1/codigoCliente),4)) }</ns0:numContrato>
        </ns0:identificarContratoPorCodigoCliente>
};

declare variable $consultarContratoPorCodigoClienteRequest1 as element(ns1:consultarContratoPorCodigoClienteRequest) external;
declare variable $cidadeContrato as xs:string external;

xf:consultarContratoPorCodigoClienteDSLXQuery($consultarContratoPorCodigoClienteRequest1,
    $cidadeContrato)