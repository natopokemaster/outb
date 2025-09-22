(:: pragma bea:global-element-parameter parameter="$netHeader" element="ns0:NetHeader" location="../../../../modelocanonicoV2/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns0:NetHeader" location="../../../../modelocanonicoV2/geral/NETHeader.xsd" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/rede/outage/transformation/CheckTokenNetHeader/";
declare namespace ns0 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:CheckTokenNetHeader($netHeader as element(ns0:NetHeader)?,
    $uuid as xs:string)
    as element(ns0:NetHeader) {
        <ns0:NetHeader>
            {
                for $aplicacao in $netHeader/aplicacao
                return
                    <aplicacao>{ data($aplicacao) }</aplicacao>
            }
            {
                for $funcionalidade in $netHeader/funcionalidade
                return
                    <funcionalidade>{ data($funcionalidade) }</funcionalidade>
            }
            {
                for $versaoServico in $netHeader/versaoServico
                return
                    <versaoServico>{ data($versaoServico) }</versaoServico>
            }
            {
                if (string-length($netHeader/token) = 0) then
                	<token>{ $uuid }</token>
            	else 
            		for $token in $netHeader/token
	                return 
	                	<token>{ data($token) }</token>
            }
            {
                for $atendimento in $netHeader/atendimento
                return
                    <atendimento>{ $atendimento/@* , $atendimento/node() }</atendimento>
            }
            {
                for $username in $netHeader/username
                return
                    <username>{ data($username) }</username>
            }
        </ns0:NetHeader>
};

declare variable $netHeader as element(ns0:NetHeader) external;
declare variable $uuid as xs:string external;

xf:CheckTokenNetHeader($netHeader,
    $uuid)