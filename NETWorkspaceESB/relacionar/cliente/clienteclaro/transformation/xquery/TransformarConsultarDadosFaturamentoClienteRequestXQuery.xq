(:: pragma bea:global-element-parameter parameter="$netHeader1" element="ns2:NetHeader" location="../../../../../modelocanonicoV2/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarDadosFaturamentoClienteRequest" location="../../wsdl/business/ESB/Claro/ConsultarDadosFaturamentoCliente/v1/ConsultarDadosFaturamentoClientev1.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/cliente/clienteclaro/transformation/xquery/TransformarConsultarDadosFaturamentoClienteRequestXQuery/";
declare namespace ns0 = "http://www.claro.com.br/EBS/Claro/v1";
declare namespace ns1 = "http://www.claro.com.br/EBO/Claro/v1";
declare namespace ns2 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:TransformarConsultarDadosFaturamentoClienteRequestXQuery($mobileAssinanteId1 as xs:string,
    $netHeader1 as element(ns2:NetHeader))
    as element(ns0:ConsultarDadosFaturamentoClienteRequest) {
        <ns0:ConsultarDadosFaturamentoClienteRequest>
            <ns0:cliente>
                <ns1:contratos>
                    <ns1:contrato>
                        <ns1:assinantes>
                            <ns1:assinante>
                                <ns1:mobile-assinante-id>{ $mobileAssinanteId1 }</ns1:mobile-assinante-id>
                            </ns1:assinante>
                        </ns1:assinantes>
                    </ns1:contrato>
                </ns1:contratos>
            </ns0:cliente>
            <ns0:meta-informacao>
                <ns1:codigo-aplicacao-origem>{ data($netHeader1/aplicacao) }</ns1:codigo-aplicacao-origem>
                <ns1:codigo-operacao-origem>{ data('CLIENTE_CLARO') }</ns1:codigo-operacao-origem>
                <ns1:correlacao-id-origem>{ data($netHeader1/token) }</ns1:correlacao-id-origem>
                <ns1:endereco-aplicacao-origem>{ data('NET_SERVICOS') }</ns1:endereco-aplicacao-origem>
                <ns1:usuario-id-origem>{ data($netHeader1/username) }</ns1:usuario-id-origem>
                <ns1:data-hora-origem>{ xs:dateTime( fn:current-dateTime()) }</ns1:data-hora-origem>
                <ns1:canal-id-origem>{ data($netHeader1/aplicacao) }</ns1:canal-id-origem>
            </ns0:meta-informacao>
        </ns0:ConsultarDadosFaturamentoClienteRequest>
};

declare variable $mobileAssinanteId1 as xs:string external;
declare variable $netHeader1 as element(ns2:NetHeader) external;

xf:TransformarConsultarDadosFaturamentoClienteRequestXQuery($mobileAssinanteId1,
    $netHeader1)
