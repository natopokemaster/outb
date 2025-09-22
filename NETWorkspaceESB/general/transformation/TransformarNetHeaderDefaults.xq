(:: pragma bea:global-element-parameter parameter="$netHeaderIN" element="ns1:NetHeader" location="../../modelocanonicoV2/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns1:NetHeader" location="../../modelocanonicoV2/geral/NETHeader.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/general/transformation/TransformarNetHeaderDefaults/";
declare namespace ns1 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:TransformarNetHeaderV1emV2(
       $netHeaderIN as element(ns1:NetHeader)?,
       $aplicacaoDefault as xs:string?,
       $funcionalidadeDefault as xs:string?,
       $versaoServicoDefault as xs:string?,
       $tokenDefault as xs:string?,
       $numeroProtocoloDefault as xs:string?,
       $numeroChamadaDefault as xs:string?,
       $usernameDefault as xs:string?)
    as element(ns1:NetHeader) {
        <ns1:NetHeader>
            { if ($netHeaderIN/aplicacao/node()) then (
            	<aplicacao>{ data($netHeaderIN/aplicacao) }</aplicacao>
            ) else (
            	<aplicacao>{ $aplicacaoDefault }</aplicacao>
            ) }
            { if ($netHeaderIN/funcionalidade/node()) then (
            	<funcionalidade>{ data($netHeaderIN/funcionalidade) }</funcionalidade>
            ) else (
            	<funcionalidade>{ $funcionalidadeDefault }</funcionalidade>
            ) }
            { if ($netHeaderIN/versaoServico/node()) then (
            	<versaoServico>{ data($netHeaderIN/versaoServico) }</versaoServico>
            ) else (
            	<versaoServico>{ $versaoServicoDefault }</versaoServico>
            ) }
            { if ($netHeaderIN/token/node()) then (
            	<token>{ data($netHeaderIN/token) }</token>
            ) else (
            	<token>{ $tokenDefault }</token>
            ) }
            <atendimento>
                { if ($netHeaderIN/atendimento/numeroProtocolo/node()) then (
                	<numeroProtocolo>{ data($netHeaderIN/atendimento/numeroProtocolo) }</numeroProtocolo>
	            ) else (
                	<numeroProtocolo>{ $numeroProtocoloDefault }</numeroProtocolo>
	            ) }
                { if ($netHeaderIN/atendimento/numeroChamada/node()) then (
                	<numeroChamada>{ data($netHeaderIN/atendimento/numeroChamada) }</numeroChamada>
	            ) else (
                	<numeroChamada>{ $numeroChamadaDefault }</numeroChamada>
	            ) }                
            </atendimento>
            { if ($netHeaderIN/username/node()) then (
            	<username>{ data($netHeaderIN/username) }</username>
            ) else (
            	<username>{ $usernameDefault }</username>
            ) }
        </ns1:NetHeader>
};

declare variable $netHeaderIN as element(ns1:NetHeader)? external;
declare variable $aplicacaoDefault as xs:string? external;
declare variable $funcionalidadeDefault as xs:string? external;
declare variable $versaoServicoDefault as xs:string? external;
declare variable $tokenDefault as xs:string? external;
declare variable $numeroProtocoloDefault as xs:string? external;
declare variable $numeroChamadaDefault as xs:string? external;
declare variable $usernameDefault as xs:string? external;

xf:TransformarNetHeaderV1emV2($netHeaderIN,
                              $aplicacaoDefault,
                              $funcionalidadeDefault,
                              $versaoServicoDefault,
                              $tokenDefault,
                              $numeroProtocoloDefault,
                              $numeroChamadaDefault,
                              $usernameDefault)