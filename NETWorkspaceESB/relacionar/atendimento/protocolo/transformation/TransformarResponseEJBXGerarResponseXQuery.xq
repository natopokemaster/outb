(:: pragma bea:global-element-parameter parameter="$gerarProtocoloAtendimentoResponse1" element="ns2:gerarProtocoloAtendimentoResponse" location="../wsdl/business/ProtocoloUnicoServiceEJBBSV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:gerarResponse" location="../wsdl/proxyservice/ProtocoloWSDL12V2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/protocolo/transformation/TransformarGerarProtocoloAtendimentoResponseEJBXGerarResponseXQuery/";
declare namespace ns0 = "java:br.com.netservicos.atendimento.protocolo.bean";
declare namespace ns1 = "http://www.netservicos.com.br/Protocolo";
declare namespace ns2 = "http://www.openuri.org/";

declare function xf:TransformarGerarProtocoloAtendimentoResponseEJBXGerarResponseXQuery($gerarProtocoloAtendimentoResponse1 as element(ns2:gerarProtocoloAtendimentoResponse))
    as element(ns1:gerarResponse) {
        let $gerarProtocoloAtendimentoResponse := $gerarProtocoloAtendimentoResponse1
        return
            <ns1:gerarResponse>
                <ns1:protocolo>{ data($gerarProtocoloAtendimentoResponse/ns2:return/ns0:numeroProtocolo) }</ns1:protocolo>
                <ns1:numeroChamada>{ data($gerarProtocoloAtendimentoResponse/ns2:return/ns0:numeroChamado) }</ns1:numeroChamada>
            </ns1:gerarResponse>
};

declare variable $gerarProtocoloAtendimentoResponse1 as element(ns2:gerarProtocoloAtendimentoResponse) external;

xf:TransformarGerarProtocoloAtendimentoResponseEJBXGerarResponseXQuery($gerarProtocoloAtendimentoResponse1)
