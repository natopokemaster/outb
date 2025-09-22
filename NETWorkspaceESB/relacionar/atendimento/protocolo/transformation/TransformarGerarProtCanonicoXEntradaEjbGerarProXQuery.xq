(:: pragma bea:global-element-parameter parameter="$gerarProtocoloAtendimento1" element="ns0:gerarProtocoloAtendimento" location="../wsdl/proxyservice/GerarProtocoloAtendimentoWSDL12.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:gerarProtocoloAtendimento" location="../wsdl/business/GerarProtocoloAtendimentoWSDL12.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/protocolo/transformation/TransformarGerarProtCanonicoXEntradaEjbGerarProXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/";
declare namespace ns1 = "http://www.openuri.org/";

declare function xf:TransformarGerarProtCanonicoXEntradaEjbGerarProXQuery($gerarProtocoloAtendimento1 as element(ns0:gerarProtocoloAtendimento))
    as element(ns1:gerarProtocoloAtendimento) {
        <ns1:gerarProtocoloAtendimento>
            <ns1:numContrato>{ data($gerarProtocoloAtendimento1/ns0:numContrato) }{data($gerarProtocoloAtendimento1/numContrato)}</ns1:numContrato>
            <ns1:codOperadora>{ data($gerarProtocoloAtendimento1/ns0:codOperadora) }{data($gerarProtocoloAtendimento1/codOperadora)}</ns1:codOperadora>
            <ns1:protocolo>{ data($gerarProtocoloAtendimento1/ns0:protocolo) }{data($gerarProtocoloAtendimento1/protocolo)}</ns1:protocolo>
        </ns1:gerarProtocoloAtendimento>
};

declare variable $gerarProtocoloAtendimento1 as element(ns0:gerarProtocoloAtendimento) external;

xf:TransformarGerarProtCanonicoXEntradaEjbGerarProXQuery($gerarProtocoloAtendimento1)
