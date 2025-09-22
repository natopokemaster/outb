(:: pragma bea:dtfFile-class type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation" ::)

declare namespace xf = "http://tempuri.org/NETRedeWLIWeb/src/br/com/netservicos/infraestrutura/rede/transform/CriaNotificacaoOutageJPDV1_0outageLegadoJDBCControlconsultarRolloutOutage/";
declare namespace ns-1 = "http://www.netservicos.com.br/rede/outage";

declare function xf:CriaNotificacaoOutageJPDV1_0outageLegadoJDBCControlconsultarRolloutOutage($parametros as element(ns-1:ParametrosNotificarOutage))
    as xs:string {
        data($parametros/ns-1:idCidadeContrato)
};

declare variable $parametros as element(ns-1:ParametrosNotificarOutage) external;

xf:CriaNotificacaoOutageJPDV1_0outageLegadoJDBCControlconsultarRolloutOutage($parametros)
