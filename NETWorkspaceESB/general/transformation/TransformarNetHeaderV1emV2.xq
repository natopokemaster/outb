(:: pragma bea:global-element-parameter parameter="$netHeaderV1" element="ns0:NetHeader" location="../../modelocanonico/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns1:NetHeader" location="../../modelocanonicoV2/geral/NETHeader.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/general/transformation/TransformarNetHeaderV1emV2/";
declare namespace ns0 = "http://www.netservicos.com.br/NetHeader";
declare namespace ns1 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:TransformarNetHeaderV1emV2($netHeaderV1 as element(ns0:NetHeader))
    as element(ns1:NetHeader) {
    <ns1:NetHeader>
        <aplicacao>{ data($netHeaderV1/aplicacao) }</aplicacao>
        <funcionalidade>{ data($netHeaderV1/funcionalidade) }</funcionalidade>
        <versaoServico>{ data($netHeaderV1/versaoServico) }</versaoServico>
        <token>{ data($netHeaderV1/token) }</token>
        <atendimento>
            <numeroProtocolo>{ data($netHeaderV1/atendimento/numeroProtocolo) }</numeroProtocolo>
            <numeroChamada>{ data($netHeaderV1/atendimento/numeroChamada) }</numeroChamada>
        </atendimento>
        <username>{ data($netHeaderV1/username) }</username>
    </ns1:NetHeader>
};

declare variable $netHeaderV1 as element(ns0:NetHeader) external;

xf:TransformarNetHeaderV1emV2($netHeaderV1)