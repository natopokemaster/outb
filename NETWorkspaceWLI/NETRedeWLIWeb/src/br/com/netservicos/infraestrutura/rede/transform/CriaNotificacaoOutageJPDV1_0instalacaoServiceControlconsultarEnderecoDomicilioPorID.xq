(:: pragma bea:dtfFile-class type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation" ::)
(:: pragma bea:java-type-return type="br.com.netservicos.infraestrutura.rede.transform.CriaNotificacaoOutageJPDV1_0Transformation.instalacaoServiceControlconsultarEnderecoDomicilioPorIDObject" ::)

declare namespace xf = "http://tempuri.org/NETRedeWLIWeb/src/br/com/netservicos/infraestrutura/rede/transform/CriaNotificacaoOutageJPDV1_0instalacaoServiceControlconsultarEnderecoDomicilioPorID/";
declare namespace ns0 = "http://www.netservicos.com.br/v2/NetHeader";
declare namespace ns-1 = "http://www.netservicos.com.br/Instalacao/";
declare namespace ns1 = "http://www.netservicos.com.br/rede/outage";

declare function xf:CriaNotificacaoOutageJPDV1_0instalacaoServiceControlconsultarEnderecoDomicilioPorID($idEnderInstalacao as xs:string,
    $parametros as element(ns1:ParametrosNotificarOutage),
    $versao as xs:string,
    $header as element(ns0:NetHeader))
    as element() {
        <instalacaoServiceControlconsultarEnderecoDomicilioPorIDObject>
            <request_Header_arg>
                <ns0:NetHeader>
                    {
                        for $aplicacao in $header/aplicacao
                        return
                            <aplicacao>{ data($aplicacao) }</aplicacao>
                    }
                    {
                        for $funcionalidade in $header/funcionalidade
                        return
                            <funcionalidade>{ data($funcionalidade) }</funcionalidade>
                    }
                    <versaoServico>{ $versao }</versaoServico>
                    {
                        for $token in $header/token
                        return
                            <token>{ data($token) }</token>
                    }
                    {
                        for $username in $header/username
                        return
                            <username>{ data($username) }</username>
                    }
                </ns0:NetHeader>
            </request_Header_arg>
            <consultarEnderecoDomicilioPorIDRequest_arg>
                <ns-1:consultarEnderecoDomicilioPorIDRequest>
                    <identificadorEndereco>{ xs:long( $idEnderInstalacao ) }</identificadorEndereco>
                    <identificadorCidade>{ data($parametros/ns1:idCidadeContrato) }</identificadorCidade>
                </ns-1:consultarEnderecoDomicilioPorIDRequest>
            </consultarEnderecoDomicilioPorIDRequest_arg>
        </instalacaoServiceControlconsultarEnderecoDomicilioPorIDObject>
};

declare variable $idEnderInstalacao as xs:string external;
declare variable $parametros as element(ns1:ParametrosNotificarOutage) external;
declare variable $versao as xs:string external;
declare variable $header as element(ns0:NetHeader) external;

xf:CriaNotificacaoOutageJPDV1_0instalacaoServiceControlconsultarEnderecoDomicilioPorID($idEnderInstalacao,
    $parametros,
    $versao,
    $header)
