(:: pragma bea:global-element-parameter parameter="$resultadoListarClientes1" element="ns7:resultadoListarClientes" location="../../wsdl/proxy/ClienteProspectDSLWSDLV1_0.wsdl" ::)
(:: pragma bea:local-element-return type="ns7:resultadoListarClientesSJ/clientesProspect" location="../../wsdl/proxy/ClienteProspectSJWSDLV1_0.wsdl" ::)

declare namespace ns13 = "http://www.netservicos.com.br/modelocanonico/v2/rede";
declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/endereco";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/clienteprospect/transformation/xquery/ConsultarClientesSplitJoinResponseXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/produtocontratado";
declare namespace ns7 = "http://www.netservicos.com.br/ClienteProspect/";
declare namespace ns16 = "http://www.netservicos.com.br/modelocanonico/v2/fatura";
declare namespace ns5 = "http://www.netservicos.com.br/modelocanonico/v2/cliente";
declare namespace ns12 = "http://www.netservicos.com.br/modelocanonico/v2/produto";
declare namespace ns18 = "http://www.netservicos.com.br/modelocanonico/v2/contratoparceiro";
declare namespace ns6 = "http://www.netservicos.com.br/modelocanonico/v2/venda";
declare namespace ns11 = "http://www.netservicos.com.br/modelocanonico/v2/moeda";
declare namespace ns9 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns17 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/formapagamento";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/contrato";
declare namespace ns14 = "http://www.netservicos.com.br/modelocanonico/v2/equipamento";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns15 = "http://www.netservicos.com.br/modelocanonico/v2/oferta";
declare namespace ns10 = "http://www.netservicos.com.br/modelocanonico/v2/cobranca";
declare namespace ns8 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";

declare function xf:ConsultarClientesSplitJoinResponseXQuery($resultadoListarClientes1 as element(ns7:resultadoListarClientes))
    as element() {
        <clientesProspect>
            {
                for $clienteProspect in $resultadoListarClientes1/clientesProspect/ns5:clienteProspect
                return
                    <ns5:clienteProspect>{ $clienteProspect/@* , $clienteProspect/node() }</ns5:clienteProspect>
            }
        </clientesProspect>
};

declare variable $resultadoListarClientes1 as element(ns7:resultadoListarClientes) external;

xf:ConsultarClientesSplitJoinResponseXQuery($resultadoListarClientes1)
