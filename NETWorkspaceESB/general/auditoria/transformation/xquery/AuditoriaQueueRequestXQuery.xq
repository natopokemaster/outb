(:: pragma bea:global-element-parameter parameter="$netHeader" element="ns1:NetHeader" location="../../../../modelocanonicoV2/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns0:auditoria" location="../../schema/AuditoriaQueue.xsd" ::)

declare namespace xf = "http://tempuri.org/vender/venda/procon/transformation/xquery/auditoriaQueueRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/AuditoriaQueue";
declare namespace ns2 = "http://www.netservicos.com.br/IdentificacaoOperadoraNET/";

declare function xf:auditoriaQueueRequestXQuery(
	$sistema as xs:string,
    $usuario as xs:string,
    $idCriticidade as xs:integer,
    $idAcao as xs:integer,
    $cidade as xs:string,
    $campo as xs:string,
    $nota as xs:string,
    $idRegistro as xs:string)
    as element(ns0:auditoria) {
        <ns0:auditoria>
	        <sistema>{ $sistema }</sistema>
            <usuario>{ $usuario }</usuario>
            <idCriticidade>{ xs:integer($idCriticidade) }</idCriticidade>
            <idAcao>{ $idAcao }</idAcao>
            <cidade>{ $cidade }</cidade>
            <campo>{ $campo }</campo>
            <nota>{ $nota }</nota>
            <idRegistro>{ $idRegistro }</idRegistro>
        </ns0:auditoria>
};

declare variable $sistema as xs:string external;
declare variable $usuario as xs:string external;
declare variable $idCriticidade as xs:integer external;
declare variable $idAcao as xs:integer external;
declare variable $cidade as xs:string external;
declare variable $campo as xs:string external;
declare variable $nota as xs:string external;
declare variable $idRegistro as xs:string external;

xf:auditoriaQueueRequestXQuery(
	$sistema,
    $usuario,
    $idCriticidade,
    $idAcao,
    $cidade,
    $campo,
    $nota,
    $idRegistro)
