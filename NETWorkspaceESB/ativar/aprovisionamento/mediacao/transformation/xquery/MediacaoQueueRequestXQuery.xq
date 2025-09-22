(:: pragma bea:global-element-parameter parameter="$parametrosExecutarMediacao1" element="ns0:parametrosExecutarMediacao" location="../../wsdl/proxy/MediacaoWSDLV1.wsdl" ::)
(:: pragma bea:global-element-return element="ns2:mensagemMediacao" location="../../schemas/MensagemMediacao.xsd" ::)

declare namespace xf = "http://tempuri.org/ativar/aprovisionamento/mediacao/transformation/xquery/MediacaoQueueRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/MediacaoV1/";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";
declare namespace ns2 = "http://www.netservicos.com.br/MensagemMediacao";

declare function xf:MediacaoQueueRequestXQuery($parametrosExecutarMediacao1 as element(ns0:parametrosExecutarMediacao))
    as element(ns2:mensagemMediacao) {
        <ns2:mensagemMediacao>
            <ns2:identificacaoOperadoraNET>
                <ns1:CodigoOperadora>{ data($parametrosExecutarMediacao1/identificacaoOperadoraNET/ns1:CodigoOperadora) }</ns1:CodigoOperadora>
                <ns1:IdentificacaoCidade>{ data($parametrosExecutarMediacao1/identificacaoOperadoraNET/ns1:IdentificacaoCidade) }</ns1:IdentificacaoCidade>
            </ns2:identificacaoOperadoraNET>
            <ns2:identificadorOrdemAtivacao>{ data($parametrosExecutarMediacao1/identificadorOrdemAtivacao) }</ns2:identificadorOrdemAtivacao>
        </ns2:mensagemMediacao>
};

declare variable $parametrosExecutarMediacao1 as element(ns0:parametrosExecutarMediacao) external;

xf:MediacaoQueueRequestXQuery($parametrosExecutarMediacao1)
