(:: pragma bea:global-element-return element="ns0:inserirOcorrencia" location="../schemas/InserirOcorrencia.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/evento/transformation/InserirOcorrenciaPSRequestXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/atendimento/webservice/OcorrenciaJWS.ws";

declare function xf:InserirOcorrenciaPSRequestXQuery($idTipoOcorrencia as xs:integer,
    $idAssinante as xs:integer,
    $nomeInformante as xs:string,
    $telInformante as xs:string,
    $dtOcorrencia as xs:dateTime,
    $idUsr as xs:string,
    $situacao as xs:integer,
    $dtRetorno as xs:dateTime,
    $idOrigemOcorrencia as xs:integer,
    $obs as xs:string)    
    as element(ns0:inserirOcorrencia) {
        <ns0:inserirOcorrencia>
            <ns0:idTipoOcorrencia>{ $idTipoOcorrencia }</ns0:idTipoOcorrencia>
            <ns0:idAssinante>{ $idAssinante }</ns0:idAssinante>
            <ns0:nomeInformante>{ $nomeInformante }</ns0:nomeInformante>
            <ns0:telInformante>{ $telInformante }</ns0:telInformante>
            <ns0:dtOcorrencia>{ $dtOcorrencia }</ns0:dtOcorrencia>
            <ns0:idUsr>{ $idUsr }</ns0:idUsr>
            <ns0:situacao>{ $situacao }</ns0:situacao>
            <ns0:idOrigemOcorrencia>{ $idOrigemOcorrencia }</ns0:idOrigemOcorrencia>
            <ns0:obs>{ $obs }</ns0:obs>
        </ns0:inserirOcorrencia>
};

declare variable $idTipoOcorrencia as xs:integer external;
declare variable $idAssinante as xs:integer external;
declare variable $nomeInformante as xs:string external;
declare variable $telInformante as xs:string external;
declare variable $dtOcorrencia as xs:dateTime external;
declare variable $idUsr as xs:string external;
declare variable $situacao as xs:integer external;
declare variable $dtRetorno as xs:dateTime external;
declare variable $idOrigemOcorrencia as xs:integer external;
declare variable $obs as xs:string external;

xf:InserirOcorrenciaPSRequestXQuery($idTipoOcorrencia,
    $idAssinante,
    $nomeInformante,
    $telInformante,
    $dtOcorrencia,
    $idUsr,
    $situacao,
    $dtRetorno,
    $idOrigemOcorrencia,
    $obs)