(:: pragma bea:global-element-parameter parameter="$netHeader1" element="ns2:NetHeader" location="../../../../../modelocanonicoV2/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarDadosCadastraisClienteRequest" location="../../wsdl/business/ESB/Claro/ConsultarDadosCadastraisCliente/v1/ConsultarDadosCadastraisClientev1.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/cliente/clienteclaro/transformation/xquery/TransformarConsultarDadosCadastraisClienteRequestXQuery/";
declare namespace ns0 = "http://www.claro.com.br/EBS/Claro/v1";
declare namespace ns1 = "http://www.claro.com.br/EBO/Claro/v1";
declare namespace ns2 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:TransformarConsultarDadosCadastraisClienteRequestXQuery($crmClienteId1 as xs:string, $netHeader1 as element(ns2:NetHeader))
    as element(ns0:ConsultarDadosCadastraisClienteRequest) {
        <ns0:ConsultarDadosCadastraisClienteRequest>
            <ns0:cliente>
                <ns1:crm-cliente-id>{ $crmClienteId1 }</ns1:crm-cliente-id>
            </ns0:cliente>
            <ns0:meta-informacao>
                <ns1:codigo-aplicacao-origem>{data($netHeader1/aplicacao)}</ns1:codigo-aplicacao-origem>
                <ns1:codigo-operacao-origem>{data('CLIENTE_CLARO')}</ns1:codigo-operacao-origem>
                <ns1:correlacao-id-origem>{data($netHeader1/token)}</ns1:correlacao-id-origem>
                <ns1:endereco-aplicacao-origem>{data('NET_SERVICOS')}</ns1:endereco-aplicacao-origem>
                <ns1:usuario-id-origem>{data($netHeader1/username)}</ns1:usuario-id-origem>
                <ns1:data-hora-origem>{xs:dateTime( fn:current-dateTime())}</ns1:data-hora-origem>
                <ns1:canal-id-origem>{data($netHeader1/aplicacao)}</ns1:canal-id-origem>
            </ns0:meta-informacao>
        </ns0:ConsultarDadosCadastraisClienteRequest>
};

declare variable $crmClienteId1 as xs:string external;
declare variable $netHeader1 as element(*) external;

xf:TransformarConsultarDadosCadastraisClienteRequestXQuery($crmClienteId1, $netHeader1)
