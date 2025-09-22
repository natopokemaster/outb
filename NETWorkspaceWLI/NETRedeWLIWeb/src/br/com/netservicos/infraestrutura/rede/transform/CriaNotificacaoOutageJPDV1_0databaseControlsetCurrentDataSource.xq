(:: pragma bea:dtfFile-class type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation" ::)
(:: pragma bea:java-type-return type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.databaseControlsetCurrentDataSourceObject" ::)

declare namespace xf = "http://tempuri.org/NETRedeWLIWeb/src/br/com/netservicos/infraestrutura/rede/transform/CriaNotificacaoOutageJPDV1_0databaseControlsetCurrentDataSource/";
declare namespace ns-1 = "http://www.netservicos.com.br/rede/outage";

declare function xf:CriaNotificacaoOutageJPDV1_0databaseControlsetCurrentDataSource($jdbcRealm as xs:string,
    $parametros as element(ns-1:ParametrosNotificarOutage))
    as element() {
        <databaseControlsetCurrentDataSourceObject>
            <cidadeContrato>{ data($parametros/ns-1:idCidadeContrato) }</cidadeContrato>
            <jdbcRealm>{ $jdbcRealm }</jdbcRealm>
        </databaseControlsetCurrentDataSourceObject>
};

declare variable $jdbcRealm as xs:string external;
declare variable $parametros as element(ns-1:ParametrosNotificarOutage) external;

xf:CriaNotificacaoOutageJPDV1_0databaseControlsetCurrentDataSource($jdbcRealm,
    $parametros)
