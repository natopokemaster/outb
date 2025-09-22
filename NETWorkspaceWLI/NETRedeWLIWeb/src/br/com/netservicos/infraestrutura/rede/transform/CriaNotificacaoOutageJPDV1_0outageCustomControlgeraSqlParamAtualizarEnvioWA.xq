(:: pragma bea:dtfFile-class type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation" ::)
(:: pragma bea:java-type-return type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.outageCustomControlgeraSqlParamAtualizarEnvioWAObject" ::)

declare namespace xf = "http://tempuri.org/NETRedeWLIWeb/src/br/com/netservicos/infraestrutura/rede/transform/CriaNotificacaoOutageJPDV1_0outageCustomControlgeraSqlParamAtualizarEnvioWA/";
declare namespace ns-1 = "http://www.netservicos.com.br/rede/outage";

declare function xf:CriaNotificacaoOutageJPDV1_0outageCustomControlgeraSqlParamAtualizarEnvioWA($dsErro as xs:string,
    $fcEnvio as xs:string,
    $parametros as element(ns-1:ParametrosNotificarOutage),
    $tpEvento as xs:string)
    as element() {
        <outageCustomControlgeraSqlParamAtualizarEnvioWAObject>
            <pIdNotificacao>{ data($parametros/ns-1:notificacaoId) }</pIdNotificacao>
            <pCidContrato>{ data($parametros/ns-1:idCidadeContrato) }</pCidContrato>
            <pTpEvento>{ $tpEvento }</pTpEvento>
            <pFcEnvio>{ $fcEnvio }</pFcEnvio>
            <pDsErro>{ $dsErro }</pDsErro>
        </outageCustomControlgeraSqlParamAtualizarEnvioWAObject>
};

declare variable $dsErro as xs:string external;
declare variable $fcEnvio as xs:string external;
declare variable $parametros as element(ns-1:ParametrosNotificarOutage) external;
declare variable $tpEvento as xs:string external;

xf:CriaNotificacaoOutageJPDV1_0outageCustomControlgeraSqlParamAtualizarEnvioWA($dsErro,
    $fcEnvio,
    $parametros,
    $tpEvento)
