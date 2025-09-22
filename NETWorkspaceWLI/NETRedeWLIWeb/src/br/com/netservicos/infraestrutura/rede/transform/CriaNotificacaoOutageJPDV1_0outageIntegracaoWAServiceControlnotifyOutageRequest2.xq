(:: pragma bea:dtfFile-class type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation" ::)

declare namespace xf = "http://tempuri.org/NETRedeWLIWeb/src/br/com/netservicos/infraestrutura/rede/transform/CriaNotificacaoOutageJPDV1_0outageIntegracaoWAServiceControlnotifyOutageRequest/";
declare namespace ns0 = "http://www.netservicos.com.br/rede/outage";
declare namespace ns-1 = "http://www.netservicos.com.br/workassure/outage";

declare function xf:CriaNotificacaoOutageJPDV1_0outageIntegracaoWAServiceControlnotifyOutageRequest($parametros as element(ns0:ParametrosNotificarOutage))
    as element(ns-1:notifyOutageRequest) {
        <ns-1:notifyOutageRequest>
            <ns-1:notificacaoId>{ data($parametros/ns0:notificacaoId) }</ns-1:notificacaoId>
            <ns-1:idCidadeContrato>{ data($parametros/ns0:idCidadeContrato) }</ns-1:idCidadeContrato>
            {
                let $pontoComum := $parametros/ns0:pontoComum
                return
                    <ns-1:pontoComum>
                        <ns-1:headendId>{ data($pontoComum/ns0:headendId) }</ns-1:headendId>
                        {
                            for $hubId in $pontoComum/ns0:hubId
                            return
                                <ns-1:hubId>{ data($hubId) }</ns-1:hubId>
                        }
                        {
                            for $node in $pontoComum/ns0:node
                            return
                                <ns-1:node>
                                    <ns-1:nodeId>{ data($node/ns0:nodeId) }</ns-1:nodeId>
                                    {
                                        for $celula in $node/ns0:celula
                                        return
                                            <ns-1:celula>
                                                {
                                                    for $cellId in $celula/ns0:cellId
                                                    return
                                                        <ns-1:cellId>{ data($cellId) }</ns-1:cellId>
                                                }
                                                {
                                                    for $logradouro in $celula/ns0:logradouro
                                                    return
                                                        <ns-1:logradouro>
                                                            {
                                                                for $logradouroId in $logradouro/ns0:logradouroId
                                                                return
                                                                    <ns-1:logradouroId>{ data($logradouroId) }</ns-1:logradouroId>
                                                            }
                                                            {
                                                                for $logradouroDesc in $logradouro/ns0:logradouroDesc
                                                                return
                                                                    <ns-1:logradouroDesc>{ data($logradouroDesc) }</ns-1:logradouroDesc>
                                                            }
                                                            {
                                                                for $imovel in $logradouro/ns0:imovel
                                                                return
                                                                    <ns-1:imovel>
                                                                        {
                                                                            for $imovelId in $imovel/ns0:imovelId
                                                                            return
                                                                                <ns-1:imovelId>{ data($imovelId) }</ns-1:imovelId>
                                                                        }
                                                                        {
                                                                            for $imovelDesc in $imovel/ns0:imovelDesc
                                                                            return
                                                                                <ns-1:imovelDesc>{ data($imovelDesc) }</ns-1:imovelDesc>
                                                                        }
                                                                        {
                                                                            for $hp in $imovel/ns0:hp
                                                                            return
                                                                                <ns-1:hp>
                                                                                    {
                                                                                        for $hpId in $hp/ns0:hpId
                                                                                        return
                                                                                            <ns-1:hpId>{ data($hpId) }</ns-1:hpId>
                                                                                    }
                                                                                    {
                                                                                        for $enderecoCompleto in $hp/ns0:enderecoCompleto
                                                                                        return
                                                                                            <ns-1:enderecoCompleto>{ data($enderecoCompleto) }</ns-1:enderecoCompleto>
                                                                                    }
                                                                                </ns-1:hp>
                                                                        }
                                                                    </ns-1:imovel>
                                                            }
                                                        </ns-1:logradouro>
                                                }
                                            </ns-1:celula>
                                    }
                                </ns-1:node>
                        }
                    </ns-1:pontoComum>
            }
            <ns-1:sintoma>{ data($parametros/ns0:sintoma) }</ns-1:sintoma>
            {
                for $segmentoNegocioID in $parametros/ns0:segmentoNegocioID
                return
                    <ns-1:segmentoNegocioID>{ data($segmentoNegocioID) }</ns-1:segmentoNegocioID>
            }
            <ns-1:dataHoraAbertura>{ xs:string( data($parametros/ns0:dataHoraAbertura) ) }</ns-1:dataHoraAbertura>
            {
                for $dataHoraPrevista in $parametros/ns0:dataHoraPrevista
                return
                    <ns-1:dataHoraPrevista>{ xs:string( data($dataHoraPrevista) ) }</ns-1:dataHoraPrevista>
            }
            {
                for $observacao in $parametros/ns0:observacao
                return
                    <ns-1:observacao>{ data($observacao) }</ns-1:observacao>
            }
        </ns-1:notifyOutageRequest>
};

declare variable $parametros as element(ns0:ParametrosNotificarOutage) external;

xf:CriaNotificacaoOutageJPDV1_0outageIntegracaoWAServiceControlnotifyOutageRequest($parametros)
