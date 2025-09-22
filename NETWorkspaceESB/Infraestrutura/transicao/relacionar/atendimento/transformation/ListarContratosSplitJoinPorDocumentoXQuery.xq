(:: pragma bea:global-element-parameter parameter="$identificarContratosRequest1" element="ns0:identificarContratosRequest" location="../wsdl/business/IdentificarContratoSplitJoin.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:listarContratosPorDocumentoRequest" location="../wsdl/proxy/ListarContratos.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/ListarContratosSplitJoinPorDocumentoXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/IdentificarContratoSplitJoin/";
declare namespace ns1 = "http://www.netservicos.com.br/ListarContratos/";

declare function xf:ListarContratosSplitJoinPorDocumentoXQuery($identificarContratosRequest1 as element(ns0:identificarContratosRequest),
    $base_dados as xs:int)
    as element(ns1:listarContratosPorDocumentoRequest) {
        <ns1:listarContratosPorDocumentoRequest>
            <documento>{ data($identificarContratosRequest1/cpf) }</documento>
            <base>{ data($identificarContratosRequest1/bases/baseAtiva[$base_dados]) }</base>
        </ns1:listarContratosPorDocumentoRequest>
};

declare variable $identificarContratosRequest1 as element(ns0:identificarContratosRequest) external;
declare variable $base_dados as xs:int external;

xf:ListarContratosSplitJoinPorDocumentoXQuery($identificarContratosRequest1,
    $base_dados)
