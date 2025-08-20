(:: pragma bea:global-element-parameter parameter="$parametrosListarClientes1" element="ns1:parametrosListarClientes" location="../../wsdl/proxy/ClienteProspectSJWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:parametrosListarClientes" location="../../wsdl/proxy/ClienteProspectDSLWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/clienteprospect/transformation/xquery/ListarClientesSplitJoinEmProxyDSL/";
declare namespace ns0 = "http://www.netservicos.com.br/ClienteProspectDSL/";
declare namespace ns1 = "http://www.netservicos.com.br/ClienteProspectSJ/";

declare function xf:ListarClientesSplitJoinEmProxyDSL($parametrosListarClientes1 as element(ns1:parametrosListarClientes),
    $itemDatabase as xs:int)
    as element(ns0:parametrosListarClientes) {
        <ns0:parametrosListarClientes>
            <ns0:CPF>{ data($parametrosListarClientes1/ns1:CPF) }</ns0:CPF>
            <ns0:CNPJ>{ data($parametrosListarClientes1/ns1:CNPJ) }</ns0:CNPJ>
            {
                let $telefoneContato := $parametrosListarClientes1/ns1:telefoneContato
                return
                    <ns0:telefoneContato>
                        <ns0:DDD>{ data($telefoneContato/ns1:DDD) }</ns0:DDD>
                        <ns0:numeroTelefone>{ data($telefoneContato/ns1:numeroTelefone) }</ns0:numeroTelefone>
                    </ns0:telefoneContato>
            }
            <ns0:aliasDatabase>{ data($parametrosListarClientes1/ns1:basesPesquisa/ns1:aliasDatabase[$itemDatabase]) }</ns0:aliasDatabase>
        </ns0:parametrosListarClientes>
};

declare variable $parametrosListarClientes1 as element(ns1:parametrosListarClientes) external;
declare variable $itemDatabase as xs:int external;

xf:ListarClientesSplitJoinEmProxyDSL($parametrosListarClientes1,
    $itemDatabase)
