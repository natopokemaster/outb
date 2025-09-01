xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$netHeader1" element="ns2:NetHeader" location="../../../../../modelocanonicoV2/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns0:ConsultarPlanoPrecoAssinanteRequest" location="../../wsdl/business/ESB/Claro/ConsultarPlanoPrecoAssinante/v1/ConsultarPlanoPrecoAssinantev1.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/cliente/clienteclaro/transformation/xquery/TransformarConsultarPlanoPrecoAssinanteRequestXQuery/";
declare namespace ns0 = "http://www.claro.com.br/EBS/Claro/v1";
declare namespace ns1 = "http://www.claro.com.br/EBO/Claro/v1";
declare namespace ns2 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:TransformarConsultarPlanoPrecoAssinanteRequestXQuery($tipoAssinatura1 as xs:string,
    $msisdn1 as xs:string,
    $mobileAssinanteId1 as xs:string,
    $netHeader1 as element(ns2:NetHeader))
    as element(ns0:ConsultarPlanoPrecoAssinanteRequest) {
        <ns0:ConsultarPlanoPrecoAssinanteRequest>
            <ns0:assinante>
                <ns1:tipo-assinatura>{ $tipoAssinatura1 }</ns1:tipo-assinatura>
            {
            if (fn:upper-case($tipoAssinatura1) eq 'CLARO_CARTAO')then 
                <ns1:aparelho>
                    <ns1:msisdn>{ $msisdn1 }</ns1:msisdn>
                </ns1:aparelho>
             else ()
           }
            {
            if (fn:upper-case($tipoAssinatura1) eq 'CLARO_CONTA'
                or fn:upper-case($tipoAssinatura1) eq 'CLARO_CONTROLE')then 
					<ns1:mobile-assinante-id>{ $mobileAssinanteId1 }</ns1:mobile-assinante-id>
             else()
             } 
            </ns0:assinante>
            <ns0:meta-informacao>
                <ns1:codigo-aplicacao-origem>{ data($netHeader1/aplicacao) }</ns1:codigo-aplicacao-origem>
                <ns1:codigo-operacao-origem>{ data('CLIENTE_CLARO') }</ns1:codigo-operacao-origem>
                <ns1:correlacao-id-origem>{ data($netHeader1/token) }</ns1:correlacao-id-origem>
                <ns1:endereco-aplicacao-origem>{ data('NET_SERVICOS') }</ns1:endereco-aplicacao-origem>
                <ns1:usuario-id-origem>{ data($netHeader1/username) }</ns1:usuario-id-origem>
                <ns1:data-hora-origem>{ xs:dateTime( fn:current-dateTime()) }</ns1:data-hora-origem>
                <ns1:canal-id-origem>{ data($netHeader1/aplicacao) }</ns1:canal-id-origem>
            </ns0:meta-informacao>
        </ns0:ConsultarPlanoPrecoAssinanteRequest>
};

declare variable $tipoAssinatura1 as xs:string external;
declare variable $msisdn1 as xs:string external;
declare variable $mobileAssinanteId1 as xs:string external;
declare variable $netHeader1 as element(ns2:NetHeader) external;

xf:TransformarConsultarPlanoPrecoAssinanteRequestXQuery($tipoAssinatura1,
    $msisdn1,
    $mobileAssinanteId1,
    $netHeader1)
