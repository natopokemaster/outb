(:: pragma bea:global-element-parameter parameter="$parametrosListarClientes1" element="ns0:parametrosListarClientes" location="../../wsdl/proxy/ClienteProspectSJWSDLV1_0.wsdl" ::)
(:: pragma bea:local-element-return type="ns0:parametrosListarClientes/ns0:basesPesquisa/ns0:aliasDatabase" location="../../wsdl/proxy/ClienteProspectSJWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/clienteprospect/transformation/xquery/BasesErroXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ClienteProspectSJ/";

declare function xf:BasesErroXQuery($parametrosListarClientes1 as element(ns0:parametrosListarClientes),
    $itemDatabase as xs:int)
    as element() {
        <ns0:aliasDatabase>{ data($parametrosListarClientes1/ns0:basesPesquisa/ns0:aliasDatabase[$itemDatabase]) }</ns0:aliasDatabase>
};

declare variable $parametrosListarClientes1 as element(ns0:parametrosListarClientes) external;
declare variable $itemDatabase as xs:int external;

xf:BasesErroXQuery($parametrosListarClientes1,
    $itemDatabase)
