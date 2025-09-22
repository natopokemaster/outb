(:: pragma bea:global-element-parameter parameter="$identificarContratoRequest1" element="ns0:identificarContratoRequest" location="../wsdl/business/IdentificarContratos11V1.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarContratoPorTelefoneRequest" location="../wsdl/proxy/IdentificarContratos.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/IdentificarContratosPorTelefoneXQuery/";
declare namespace ns0 = "http://www.openuri.org/";
declare namespace ns1 = "http://www.netservicos.com.br/IdentificarContratos/";

declare function xf:IdentificarContratosPorTelefoneXQuery($identificarContratoRequest1 as element(ns0:identificarContratoRequest))
    as element(ns1:consultarContratoPorTelefoneRequest) {
        <ns1:consultarContratoPorTelefoneRequest>
            <telefone>{ data($identificarContratoRequest1/ns0:TELEFONE) }</telefone>
        </ns1:consultarContratoPorTelefoneRequest>
};

declare variable $identificarContratoRequest1 as element(ns0:identificarContratoRequest) external;

xf:IdentificarContratosPorTelefoneXQuery($identificarContratoRequest1)
