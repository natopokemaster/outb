(:: pragma bea:global-element-return element="ns0:consultarDadosOcorrencia" location="../schemas/DadosOcorrencia.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/evento/transformation/DadosOcorrenciaPSRequestXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/atendimento/webservice/OcorrenciaJWS.ws";

declare function xf:DadosOcorrenciaPSRequestXQuery($cdHashCode as xs:string,
    $idTipoOcorrencia as xs:integer,
    $descricao as xs:string,
    $numContrato as xs:string,
    $cidContrato as xs:string)
    as element(ns0:consultarDadosOcorrencia) {
        <ns0:consultarDadosOcorrencia>
        	<ns0:cdHashCode>{ $cdHashCode }</ns0:cdHashCode>
            <ns0:idTipoOcorrencia>{ $idTipoOcorrencia }</ns0:idTipoOcorrencia>
            <ns0:descricao>{ $descricao }</ns0:descricao>
            <ns0:numContrato>{ $numContrato }</ns0:numContrato>
            <ns0:cidContrato>{ $cidContrato }</ns0:cidContrato>
        </ns0:consultarDadosOcorrencia>
};

declare variable $cdHashCode as xs:string external;
declare variable $idTipoOcorrencia as xs:integer external;
declare variable $descricao as xs:string external;
declare variable $numContrato as xs:string external;
declare variable $cidContrato as xs:string external;

xf:DadosOcorrenciaPSRequestXQuery($cdHashCode,
    $idTipoOcorrencia,
    $descricao,
    $numContrato,
    $cidContrato)