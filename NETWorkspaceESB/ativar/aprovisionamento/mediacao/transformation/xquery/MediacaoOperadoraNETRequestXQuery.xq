(:: pragma bea:global-element-parameter parameter="$mensagemMediacao1" element="ns1:mensagemMediacao" location="../../schemas/MensagemMediacao.xsd" ::)
(:: pragma bea:global-element-return element="ns0:IdentificacaoOperadoraNET" location="../../../../../modelocanonicoV2/geral/IdentificacaoOperadoraNET.xsd" ::)

declare namespace xf = "http://tempuri.org/ativar/aprovisionamento/mediacao/transformation/xquery/MediacaoOperadoraNETRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";
declare namespace ns1 = "http://www.netservicos.com.br/MensagemMediacao";

declare function xf:MediacaoOperadoraNETRequestXQuery($mensagemMediacao1 as element(ns1:mensagemMediacao))
    as element(ns0:IdentificacaoOperadoraNET) {
        <ns0:IdentificacaoOperadoraNET>
        	{if (not(empty($mensagemMediacao1/ns1:identificacaoOperadoraNET/ns0:CodigoOperadora)) and data($mensagemMediacao1/ns1:identificacaoOperadoraNET/ns0:CodigoOperadora) ne '' )  then (
        		<ns0:CodigoOperadora>{ data($mensagemMediacao1/ns1:identificacaoOperadoraNET/ns0:CodigoOperadora) }</ns0:CodigoOperadora>)
        	else if (not(empty($mensagemMediacao1/ns1:identificacaoOperadoraNET/ns0:IdentificacaoCidade)) and data($mensagemMediacao1/ns1:identificacaoOperadoraNET/ns0:IdentificacaoCidade) ne '') then (
	            <ns0:IdentificacaoCidade>{ data($mensagemMediacao1/ns1:identificacaoOperadoraNET/ns0:IdentificacaoCidade) }</ns0:IdentificacaoCidade>)
	        else()}    
        </ns0:IdentificacaoOperadoraNET>
};

declare variable $mensagemMediacao1 as element(ns1:mensagemMediacao) external;

xf:MediacaoOperadoraNETRequestXQuery($mensagemMediacao1)
