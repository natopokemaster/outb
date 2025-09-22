(:: pragma bea:global-element-parameter parameter="$parametrosConsultarTelefoneLeiNaoPerturbe1" element="ns2:parametrosConsultarTelefoneLeiNaoPerturbe" location="../../wsdl/proxyservice/ProconWSDLV2_0.wsdl" ::)
(:: pragma bea:global-element-parameter parameter="$identificarOperadoraNETResponse1" element="ns0:identificarOperadoraNETResponse" location="../../../../../general/NETSMSDatabaseConfig/wsdl/proxy/IdentificacaoOperadoraNETWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns3:consultarListaRestricoesContatoProcon" location="../../wsdl/business/RestricaoContatoProconDSLBSV1_0.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace xf = "http://tempuri.org/vender/venda/procon/transformation/xquery/ConsultarListaRestricoesContatoProconRequestXQuery2/";
declare namespace ns0 = "http://www.netservicos.com.br/IdentificacaoOperadoraNET/";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";
declare namespace ns3 = "ld:br/com/netservicos/venda/procon/logical/RestricaoContatoProconDSL_ws";
declare namespace ns2 = "http://www.netservicos.com.br/Procon/";

declare function xf:ConsultarListaRestricoesContatoProconRequestXQuery2($parametrosConsultarTelefoneLeiNaoPerturbe1 as element(ns2:parametrosConsultarTelefoneLeiNaoPerturbe),
    $identificarOperadoraNETResponse1 as element(ns0:identificarOperadoraNETResponse))
    as element(ns3:consultarListaRestricoesContatoProcon) {
        <ns3:consultarListaRestricoesContatoProcon>
            {
                for $IdentificacaoCidade in $identificarOperadoraNETResponse1/ns4:IdentificacaoCidade
                return
                    <ns3:identificacaoCidade>{ data($IdentificacaoCidade) }</ns3:identificacaoCidade>
            }
            <ns3:ddd>{ data($parametrosConsultarTelefoneLeiNaoPerturbe1/ddd) }</ns3:ddd>
            <ns3:telefone>{ data($parametrosConsultarTelefoneLeiNaoPerturbe1/telefone) }</ns3:telefone>
        </ns3:consultarListaRestricoesContatoProcon>
};

declare variable $parametrosConsultarTelefoneLeiNaoPerturbe1 as element(ns2:parametrosConsultarTelefoneLeiNaoPerturbe) external;
declare variable $identificarOperadoraNETResponse1 as element(ns0:identificarOperadoraNETResponse) external;

xf:ConsultarListaRestricoesContatoProconRequestXQuery2($parametrosConsultarTelefoneLeiNaoPerturbe1,
    $identificarOperadoraNETResponse1)
