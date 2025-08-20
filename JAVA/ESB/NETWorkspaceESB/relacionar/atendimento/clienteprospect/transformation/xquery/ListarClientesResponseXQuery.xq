(:: pragma bea:global-element-parameter parameter="$resultadoListarClientes1" element="ns12:resultadoListarClientes" location="../../wsdl/proxy/ClienteProspectSJWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns7:resultadoListarClientes" location="../../wsdl/proxy/ClienteProspectWSDLV1_0.wsdl" ::)

declare namespace ns13 = "http://www.netservicos.com.br/modelocanonico/v2/produto";
declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/endereco";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/clienteprospect/transformation/xquery/ListarClientesResponseXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/produtocontratado";
declare namespace ns7 = "http://www.netservicos.com.br/ClienteProspect/";
declare namespace ns16 = "http://www.netservicos.com.br/modelocanonico/v2/oferta";
declare namespace ns5 = "http://www.netservicos.com.br/modelocanonico/v2/cliente";
declare namespace ns12 = "http://www.netservicos.com.br/ClienteProspectSJ/";
declare namespace ns18 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace ns6 = "http://www.netservicos.com.br/modelocanonico/v2/venda";
declare namespace ns11 = "http://www.netservicos.com.br/modelocanonico/v2/moeda";
declare namespace ns9 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns17 = "http://www.netservicos.com.br/modelocanonico/v2/fatura";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/formapagamento";
declare namespace ns19 = "http://www.netservicos.com.br/modelocanonico/v2/contratoparceiro";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/contrato";
declare namespace ns14 = "http://www.netservicos.com.br/modelocanonico/v2/rede";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns15 = "http://www.netservicos.com.br/modelocanonico/v2/equipamento";
declare namespace ns10 = "http://www.netservicos.com.br/modelocanonico/v2/cobranca";
declare namespace ns8 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";

declare function xf:ListarClientesResponseXQuery($resultadoListarClientes1 as element(ns12:resultadoListarClientes))
    as element(ns7:resultadoListarClientes) {
        <ns7:resultadoListarClientes>
            {
                let $clientesProspect := $resultadoListarClientes1/ns12:clientesProspect
                return
                    <clientesProspect>
                        {
                            for $clienteProspect in $clientesProspect/ns5:clienteProspect
                            return
                                <ns5:clienteProspect>{ $clienteProspect/@* , $clienteProspect/node() }</ns5:clienteProspect>
                        }
                    </clientesProspect>
            }
            {
                for $mensagens in $resultadoListarClientes1/ns12:mensagens
                return
                    <mensagens>
                        {
                            for $mensagem in $mensagens/ns12:mensagem
                            return
                                <mensagem>
                                    <codigo>{ data($mensagem/ns12:codigo) }</codigo>
                                    <descricao>{ data($mensagem/ns12:descricao) }</descricao>
                                </mensagem>
                        }
                    </mensagens>
            }
        </ns7:resultadoListarClientes>
};

declare variable $resultadoListarClientes1 as element(ns12:resultadoListarClientes) external;

xf:ListarClientesResponseXQuery($resultadoListarClientes1)
