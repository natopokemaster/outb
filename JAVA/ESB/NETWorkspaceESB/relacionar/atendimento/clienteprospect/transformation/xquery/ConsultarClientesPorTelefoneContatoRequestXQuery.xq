(:: pragma bea:global-element-parameter parameter="$parametrosListarClientes1" element="ns0:parametrosListarClientes" location="../../wsdl/proxy/ClienteProspectDSLWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarClientesPorTelefoneContato" location="../../wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/clienteprospect/transformation/xquery/ConsultarClientesPorTelefoneContatoRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ClienteProspectDSL/";
declare namespace ns1 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";

declare function xf:ConsultarClientesPorTelefoneContatoRequestXQuery($parametrosListarClientes1 as element(ns0:parametrosListarClientes))
    as element(ns1:consultarClientesPorTelefoneContato) {
        <ns1:consultarClientesPorTelefoneContato>
            <ns1:ddd>{ data($parametrosListarClientes1/ns0:telefoneContato/ns0:DDD) }</ns1:ddd>
            <ns1:numeroTelefone>{ data($parametrosListarClientes1/ns0:telefoneContato/ns0:numeroTelefone) }</ns1:numeroTelefone>
        </ns1:consultarClientesPorTelefoneContato>
};

declare variable $parametrosListarClientes1 as element(ns0:parametrosListarClientes) external;

xf:ConsultarClientesPorTelefoneContatoRequestXQuery($parametrosListarClientes1)
