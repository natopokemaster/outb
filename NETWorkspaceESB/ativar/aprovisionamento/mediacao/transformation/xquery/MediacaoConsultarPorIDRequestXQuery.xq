(:: pragma bea:global-element-parameter parameter="$mensagemMediacao1" element="ns2:mensagemMediacao" location="../../schemas/MensagemMediacao.xsd" ::)
(:: pragma bea:global-element-return element="ns1:consultarPorID" location="../../wsdl/business/MediacaoConsultaOrdemBSWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/ativar/aprovisionamento/mediacao/transformation/xquery/MediacaoConsultarPorIDRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";
declare namespace ns1 = "ld:br/com/netservicos/aprovisionamento/webservice/OrdemAtivacaoJWS.ws";
declare namespace ns2 = "http://www.netservicos.com.br/MensagemMediacao";

declare function xf:MediacaoConsultarPorIDRequestXQuery($mensagemMediacao1 as element(ns2:mensagemMediacao))
    as element(ns1:consultarPorID) {
        <ns1:consultarPorID>
            <ns1:identificadorOrdemAtivacao>{ data($mensagemMediacao1/ns2:identificadorOrdemAtivacao) }</ns1:identificadorOrdemAtivacao>
        </ns1:consultarPorID>
};

declare variable $mensagemMediacao1 as element(ns2:mensagemMediacao) external;

xf:MediacaoConsultarPorIDRequestXQuery($mensagemMediacao1)
