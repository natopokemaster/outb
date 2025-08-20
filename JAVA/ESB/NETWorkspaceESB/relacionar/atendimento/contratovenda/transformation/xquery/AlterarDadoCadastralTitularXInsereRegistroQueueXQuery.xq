(:: pragma bea:global-element-return element="ns0:auditoria" location="../../../../../general/auditoria/schema/AuditoriaQueue.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/AlterarDadoCadastralTitularXInsereRegistroQueueXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/AuditoriaQueue";

declare function xf:AlterarDadoCadastralTitularXInsereRegistroQueueXQuery($nota as xs:string,
    $idRegistro as xs:string,
    $campo as xs:string,
    $cidade as xs:string,
    $idAcao as xs:int,
    $criticidade as xs:int,
    $usuario as xs:string,
    $sistema as xs:string)
    as element(ns0:auditoria) {
        <ns0:auditoria>
            <sistema>{ $sistema }</sistema>
            <usuario>{ $usuario }</usuario>
            <idCriticidade>{ xs:integer( $criticidade ) }</idCriticidade>
            <idAcao>{ xs:integer( $idAcao ) }</idAcao>
            <cidade>{ $cidade }</cidade>
            <campo>{ $campo }</campo>
            <nota>{ $nota }</nota>
            <idRegistro>{ $idRegistro }</idRegistro>
        </ns0:auditoria>
};

declare variable $nota as xs:string external;
declare variable $idRegistro as xs:string external;
declare variable $campo as xs:string external;
declare variable $cidade as xs:string external;
declare variable $idAcao as xs:int external;
declare variable $criticidade as xs:int external;
declare variable $usuario as xs:string external;
declare variable $sistema as xs:string external;

xf:AlterarDadoCadastralTitularXInsereRegistroQueueXQuery($nota,
    $idRegistro,
    $campo,
    $cidade,
    $idAcao,
    $criticidade,
    $usuario,
    $sistema)
