(:: pragma bea:global-element-parameter parameter="$identificarContratoRequest1" element="ns0:identificarContratoRequest" location="../wsdl/business/IdentificarContratos11V1.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarContratoPorCodigoClienteRequest" location="../wsdl/proxy/IdentificarContratos.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/IdentificarContratoPorCodClienteRequestXQuery/";
declare namespace ns0 = "http://www.openuri.org/";
declare namespace ns1 = "http://www.netservicos.com.br/IdentificarContratos/";

declare function xf:IdentificarContratoPorCodClienteRequestXQuery($identificarContratoRequest1 as element(ns0:identificarContratoRequest))
    as element(ns1:consultarContratoPorCodigoClienteRequest) {
        <ns1:consultarContratoPorCodigoClienteRequest>
            <codigoCliente>{ data($identificarContratoRequest1/ns0:COD_ASSINANTE) }</codigoCliente>
        </ns1:consultarContratoPorCodigoClienteRequest>
};

declare variable $identificarContratoRequest1 as element(ns0:identificarContratoRequest) external;

xf:IdentificarContratoPorCodClienteRequestXQuery($identificarContratoRequest1)
