(:: pragma bea:dtfFile-class type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation" ::)
(:: pragma bea:java-type-return type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.outageLegadoJDBCControlbuscarContratoNotificacaoObject" ::)

declare namespace xf = "http://tempuri.org/NETRedeWLIWeb/src/br/com/netservicos/infraestrutura/rede/transform/CriaNotificacaoOutageJPDV1_0outageLegadoJDBCControlbuscarContratoNotificacao/";
declare namespace ns-1 = "http://www.netservicos.com.br/rede/outage";

declare function xf:CriaNotificacaoOutageJPDV1_0outageLegadoJDBCControlbuscarContratoNotificacao($logradouroId as xs:string,
    $parametros as element(ns-1:ParametrosNotificarOutage))
    as element() {
        <outageLegadoJDBCControlbuscarContratoNotificacaoObject>
            <pCidContrato>{ data($parametros/ns-1:idCidadeContrato) }</pCidContrato>
            <pNotificacao>{ data($parametros/ns-1:notificacaoId) }</pNotificacao>
            <pLogradouro>{ $logradouroId }</pLogradouro>
        </outageLegadoJDBCControlbuscarContratoNotificacaoObject>
};

declare variable $logradouroId as xs:string external;
declare variable $parametros as element(ns-1:ParametrosNotificarOutage) external;

xf:CriaNotificacaoOutageJPDV1_0outageLegadoJDBCControlbuscarContratoNotificacao($logradouroId,
    $parametros)
