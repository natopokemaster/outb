(:: pragma bea:global-element-return element="ns0:inserirCacheOcorrencia" location="../wsdl/business/OcorrenciaDSLWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/evento/transformation/InserirCacheOcorrenciaPSRequestXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/atendimento/webservice/OcorrenciaJWS.ws";

declare function xf:InserirCacheOcorrenciaPSRequestXQuery($cdHashCode as xs:string,
    $dsEndpoint as xs:string,
    $xtRequisicao as xs:string,
    $xtResposta as xs:string,
    $numContrato as xs:integer,
    $cidContrato as xs:string)
    as element(ns0:inserirCacheOcorrencia) {
        <ns0:inserirCacheOcorrencia>
        	<ns0:cdHashCode>{ $cdHashCode }</ns0:cdHashCode>
            <ns0:dsEndpoint>{ $dsEndpoint }</ns0:dsEndpoint>
            <ns0:xtRequisicao>{ concat("<xml-fragment>",$xtRequisicao,"</xml-fragment>") }</ns0:xtRequisicao>
            <ns0:xtResposta>{ concat("<xml-fragment>",$xtResposta,"</xml-fragment>") }</ns0:xtResposta>
            <ns0:numContrato>{ $numContrato }</ns0:numContrato>
            <ns0:cidContrato>{ $cidContrato }</ns0:cidContrato>
        </ns0:inserirCacheOcorrencia>
};

declare variable $cdHashCode as xs:string external;
declare variable $dsEndpoint as xs:string external;
declare variable $xtRequisicao as xs:string external;
declare variable $xtResposta as xs:string external;
declare variable $numContrato as xs:integer external;
declare variable $cidContrato as xs:string external;

xf:InserirCacheOcorrenciaPSRequestXQuery($cdHashCode,
    $dsEndpoint,
    $xtRequisicao,
    $xtResposta,
    $numContrato,
    $cidContrato)