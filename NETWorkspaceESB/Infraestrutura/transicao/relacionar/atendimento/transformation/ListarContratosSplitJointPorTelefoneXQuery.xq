(:: pragma bea:global-element-parameter parameter="$identificarContratosRequest1" element="ns0:identificarContratosRequest" location="../wsdl/business/IdentificarContratoSplitJoin.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:listarContratosPorTelefoneRequest" location="../wsdl/proxy/ListarContratos.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/ListarContratosSplitJointPorTelefoneXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/IdentificarContratoSplitJoin/";
declare namespace ns1 = "http://www.netservicos.com.br/ListarContratos/";

declare function xf:ListarContratosSplitJointPorTelefoneXQuery($identificarContratosRequest1 as element(ns0:identificarContratosRequest),
    $contador as xs:int)
    as element(ns1:listarContratosPorTelefoneRequest) {
        <ns1:listarContratosPorTelefoneRequest>
            <telefone>{ data($identificarContratosRequest1/telefone) }</telefone>
            <base>{ data($identificarContratosRequest1/bases/baseAtiva[$contador]) }</base>
        </ns1:listarContratosPorTelefoneRequest>
};

declare variable $identificarContratosRequest1 as element(ns0:identificarContratosRequest) external;
declare variable $contador as xs:int external;

xf:ListarContratosSplitJointPorTelefoneXQuery($identificarContratosRequest1,
    $contador)
