(:: pragma bea:global-element-parameter parameter="$consultarContratosPorProtocoloRequest1" element="ns1:consultarContratosPorProtocoloRequest" location="../wsdl/proxy/IdentificarContratos.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:identificarContratoPorProtocolo" location="../wsdl/business/IdentificarContratosDSL.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/ConsultarContratoPorProtocoloDSLXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/atendimento/webservice/IdentificarContratosJWS.ws";
declare namespace ns1 = "http://www.netservicos.com.br/IdentificarContratos/";

declare function xf:ConsultarContratoPorProtocoloDSLXQuery($consultarContratosPorProtocoloRequest1 as element(ns1:consultarContratosPorProtocoloRequest))
    as element(ns0:identificarContratoPorProtocolo) {
        <ns0:identificarContratoPorProtocolo>
            <ns0:protocolo>{ data($consultarContratosPorProtocoloRequest1/protocolo) }</ns0:protocolo>
        </ns0:identificarContratoPorProtocolo>
};

declare variable $consultarContratosPorProtocoloRequest1 as element(ns1:consultarContratosPorProtocoloRequest) external;

xf:ConsultarContratoPorProtocoloDSLXQuery($consultarContratosPorProtocoloRequest1)
