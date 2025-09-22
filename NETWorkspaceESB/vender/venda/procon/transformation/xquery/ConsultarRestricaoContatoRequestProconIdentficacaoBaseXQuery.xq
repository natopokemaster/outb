(:: pragma bea:global-element-parameter parameter="$parametrosConsultarTelefoneLeiNaoPerturbe1" element="ns1:parametrosConsultarTelefoneLeiNaoPerturbe" location="../../wsdl/proxyservice/ProconWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:IdentificacaoOperadoraNET" location="../../../../../modelocanonicoV2/geral/IdentificacaoOperadoraNET.xsd" ::)

declare namespace xf = "http://tempuri.org/vender/venda/procon/transformation/xquery/ConsultarRestricaoContatoRequestProconIdentficacaoBaseXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";
declare namespace ns1 = "http://www.netservicos.com.br/Procon/";

declare function xf:ConsultarRestricaoContatoRequestProconIdentficacaoBaseXQuery($parametrosConsultarTelefoneLeiNaoPerturbe1 as element(ns1:parametrosConsultarTelefoneLeiNaoPerturbe))
    as element(ns0:IdentificacaoOperadoraNET) {
        let $identificacaoOperadoraNET := $parametrosConsultarTelefoneLeiNaoPerturbe1/identificacaoOperadoraNET
        return
            <ns0:IdentificacaoOperadoraNET>
                { $identificacaoOperadoraNET/node() }
            </ns0:IdentificacaoOperadoraNET>
};

declare variable $parametrosConsultarTelefoneLeiNaoPerturbe1 as element(ns1:parametrosConsultarTelefoneLeiNaoPerturbe) external;

xf:ConsultarRestricaoContatoRequestProconIdentficacaoBaseXQuery($parametrosConsultarTelefoneLeiNaoPerturbe1)
