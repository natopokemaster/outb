(:: pragma bea:dtfFile-class type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation" ::)
(:: pragma bea:schema-type-parameter parameter="$forEachNode" type="ns-1:Node" ::)
(:: pragma bea:java-type-return type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.outageCustomControlgeraSqlParamCriarOutageNode2Object" ::)

declare namespace xf = "http://tempuri.org/NETRedeWLIWeb/src/br/com/netservicos/infraestrutura/rede/transform/CriaNotificacaoOutageJPDV1_0outageCustomControlgeraSqlParamCriarOutageNode2/";
declare namespace ns0 = "http://www.netservicos.com.br/v2/NetHeader";
declare namespace ns-1 = "http://www.netservicos.com.br/rede/outage";

declare function xf:CriaNotificacaoOutageJPDV1_0outageCustomControlgeraSqlParamCriarOutageNode2($header as element(ns0:NetHeader),
    $forEachNode as element(),
    $parametros as element(ns-1:ParametrosNotificarOutage))
    as element() {
        <outageCustomControlgeraSqlParamCriarOutageNode2Object>
            {
                for $username in $header/username
                return
                    <usuario>{ data($username) }</usuario>
            }
            <doc>
                <ns-1:ParametrosNotificarOutage>
                    <ns-1:notificacaoId>{ data($parametros/ns-1:notificacaoId) }</ns-1:notificacaoId>
                    <ns-1:idCidadeContrato>{ data($parametros/ns-1:idCidadeContrato) }</ns-1:idCidadeContrato>
                    <ns-1:sintoma>{ data($parametros/ns-1:sintoma) }</ns-1:sintoma>
                    {
                        for $segmentoNegocioID in $parametros/ns-1:segmentoNegocioID
                        return
                            <ns-1:segmentoNegocioID>{ data($segmentoNegocioID) }</ns-1:segmentoNegocioID>
                    }
                    {
                        for $dataHoraAbertura in $parametros/ns-1:dataHoraAbertura
                        return
                            <ns-1:dataHoraAbertura>{ data($dataHoraAbertura) }</ns-1:dataHoraAbertura>
                    }
                    {
                        for $dataHoraPrevista in $parametros/ns-1:dataHoraPrevista
                        return
                            <ns-1:dataHoraPrevista>{ data($dataHoraPrevista) }</ns-1:dataHoraPrevista>
                    }
                    {
                        for $observacao in $parametros/ns-1:observacao
                        return
                            <ns-1:observacao>{ data($observacao) }</ns-1:observacao>
                    }
                </ns-1:ParametrosNotificarOutage>
            </doc>
            {
                for $nodeId in $forEachNode/ns-1:nodeId
                return
                    <nodeId>{ data($nodeId) }</nodeId>
            }
        </outageCustomControlgeraSqlParamCriarOutageNode2Object>
};

declare variable $header as element(ns0:NetHeader) external;
declare variable $forEachNode as element() external;
declare variable $parametros as element(ns-1:ParametrosNotificarOutage) external;

xf:CriaNotificacaoOutageJPDV1_0outageCustomControlgeraSqlParamCriarOutageNode2($header,
    $forEachNode,
    $parametros)
