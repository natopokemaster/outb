(:: pragma bea:global-element-parameter parameter="$parametrosListarClientes1" element="ns0:parametrosListarClientes" location="../../wsdl/proxy/ClienteProspectDSLWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarClientesPorCNPJ" location="../../wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/clienteprospect/transformation/xquery/ConsultarClientesPorCNPJRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ClienteProspectDSL/";
declare namespace ns1 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";

declare function xf:ConsultarClientesPorCNPJRequestXQuery($parametrosListarClientes1 as element(ns0:parametrosListarClientes))
    as element(ns1:consultarClientesPorCNPJ) {
        <ns1:consultarClientesPorCNPJ>
            <ns1:cnpj>{ data($parametrosListarClientes1/ns0:CNPJ) }</ns1:cnpj>
        </ns1:consultarClientesPorCNPJ>
};

declare variable $parametrosListarClientes1 as element(ns0:parametrosListarClientes) external;

xf:ConsultarClientesPorCNPJRequestXQuery($parametrosListarClientes1)
