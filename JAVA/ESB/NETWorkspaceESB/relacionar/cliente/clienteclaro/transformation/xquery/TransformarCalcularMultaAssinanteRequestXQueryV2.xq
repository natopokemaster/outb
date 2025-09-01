(:: pragma bea:global-element-parameter parameter="$parametrosListar1" element="ns2:parametrosListar" location="../../wsdl/proxy/ClienteClaroWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-parameter parameter="$netHeader1" element="ns3:NetHeader" location="../../../../../modelocanonicoV2/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns0:CalcularMultaAssinanteRequest" location="../../wsdl/business/ESB/Claro/CalcularMultaAssinante/v2/CalcularMultaAssinantev2.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/cliente/clienteclaro/transformation/xquery/TransformarCalcularMultaAssinanteRequestXQuery/";
declare namespace ns0 = "http://www.claro.com.br/EBS/Claro/v2";
declare namespace ns1 = "http://www.claro.com.br/EBO/Claro/v1";
declare namespace ns2 = "http://www.netservicos.com.br/ClienteClaroV2";
declare namespace ns3 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:TransformarCalcularMultaAssinanteRequestXQuery($parametrosListar1 as element(ns2:parametrosListar), $netHeader1 as element(ns3:NetHeader))
    as element(ns0:CalcularMultaAssinanteRequest) {
        <ns0:CalcularMultaAssinanteRequest>
            <ns0:cliente>
                <ns1:contratos>
                    <ns1:contrato>
                        <ns1:assinantes>
                            <ns1:assinante>
                                <ns1:numero-telefone>
                                    <ns1:msisdn>{ data($parametrosListar1/ns2:MSISDN) }</ns1:msisdn>
                                </ns1:numero-telefone>
                            </ns1:assinante>
                        </ns1:assinantes>
                    </ns1:contrato>
                </ns1:contratos>
            </ns0:cliente>
            <ns0:operacao>{ data('CANCELAMENTO') }</ns0:operacao>
            <ns0:motivo>
                <ns1:motivo-id>{ data('CSUBP') }</ns1:motivo-id>
            </ns0:motivo>
			<ns0:meta-informacao>
                <ns1:codigo-aplicacao-origem>{ data($netHeader1/aplicacao) }</ns1:codigo-aplicacao-origem>
                <ns1:codigo-operacao-origem>{ data('CLIENTE_CLARO') }</ns1:codigo-operacao-origem>
                <ns1:correlacao-id-origem>{ data($netHeader1/token) }</ns1:correlacao-id-origem>
                <ns1:endereco-aplicacao-origem>{ data('NET_SERVICOS') }</ns1:endereco-aplicacao-origem>
                <ns1:usuario-id-origem>{ data($netHeader1/username) }</ns1:usuario-id-origem>
                <ns1:data-hora-origem>{ xs:dateTime( fn:current-dateTime()) }</ns1:data-hora-origem>
                <ns1:canal-id-origem>{ data($netHeader1/aplicacao) }</ns1:canal-id-origem>
            </ns0:meta-informacao>
        </ns0:CalcularMultaAssinanteRequest>
};

declare variable $parametrosListar1 as element(ns2:parametrosListar) external;
declare variable $netHeader1 as element(ns3:NetHeader) external;

xf:TransformarCalcularMultaAssinanteRequestXQuery($parametrosListar1, $netHeader1)
