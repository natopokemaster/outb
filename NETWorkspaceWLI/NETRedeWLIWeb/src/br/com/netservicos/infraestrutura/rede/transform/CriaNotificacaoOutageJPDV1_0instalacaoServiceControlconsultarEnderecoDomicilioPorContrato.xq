(:: pragma bea:dtfFile-class type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation" ::)
(:: pragma bea:java-type-return type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.instalacaoServiceControlconsultarEnderecoDomicilioPorContratoObject" ::)

declare namespace xf = "http://tempuri.org/NETRedeWLIWeb/src/br/com/netservicos/infraestrutura/rede/transform/CriaNotificacaoOutageJPDV1_0instalacaoServiceControlconsultarEnderecoDomicilioPorContrato/";
declare namespace ns0 = "http://www.netservicos.com.br/Instalacao/";
declare namespace ns-1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns1 = "http://www.netservicos.com.br/rede/outage";
declare namespace ns2 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:CriaNotificacaoOutageJPDV1_0instalacaoServiceControlconsultarEnderecoDomicilioPorContrato($header as element(ns2:NetHeader),
    $numContrato as xs:string,
    $parametros as element(ns1:ParametrosNotificarOutage),
    $versao as xs:string)
    as element() {
        <instalacaoServiceControlconsultarEnderecoDomicilioPorContratoObject>
            <request_Header_arg>
                <ns2:NetHeader>
                    {
                        for $aplicacao in $header/aplicacao
                        return
                            <aplicacao>{ data($aplicacao) }</aplicacao>
                    }
                    <versaoServico>{ $versao }</versaoServico>
                </ns2:NetHeader>
            </request_Header_arg>
            <consultarEnderecoDomicilioPorContratoRequest_arg>
                <ns0:consultarEnderecoDomicilioPorContratoRequest>
                    <identificacaoContrato>
                        <ns-1:Contrato>
                            <ns-1:NumeroContrato>{ xs:long( $numContrato ) }</ns-1:NumeroContrato>
                            <ns-1:IdentificacaoCidade>{ data($parametros/ns1:idCidadeContrato) }</ns-1:IdentificacaoCidade>
                        </ns-1:Contrato>
                    </identificacaoContrato>
                </ns0:consultarEnderecoDomicilioPorContratoRequest>
            </consultarEnderecoDomicilioPorContratoRequest_arg>
        </instalacaoServiceControlconsultarEnderecoDomicilioPorContratoObject>
};

declare variable $header as element(ns2:NetHeader) external;
declare variable $numContrato as xs:string external;
declare variable $parametros as element(ns1:ParametrosNotificarOutage) external;
declare variable $versao as xs:string external;

xf:CriaNotificacaoOutageJPDV1_0instalacaoServiceControlconsultarEnderecoDomicilioPorContrato($header,
    $numContrato,
    $parametros,
    $versao)
