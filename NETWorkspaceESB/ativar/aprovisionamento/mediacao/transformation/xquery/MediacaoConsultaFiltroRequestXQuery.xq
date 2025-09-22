(:: pragma bea:global-element-parameter parameter="$mensagemMediacao1" element="ns2:mensagemMediacao" location="../../schemas/MensagemMediacao.xsd" ::)
(:: pragma bea:global-element-return element="ns0:consultarMediacao" location="../../wsdl/business/MediacaoConsultaFiltroBSWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/ativar/aprovisionamento/mediacao/transformation/xquery/MediacaoConsultaFiltroRequestXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/aprovisionamento/webservice/ConsultaMediacaoJWS.ws";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";
declare namespace ns3 = "http://www.netservicos.com.br/v2/NetHeader";
declare namespace ns2 = "http://www.netservicos.com.br/MensagemMediacao";

declare function xf:MediacaoConsultaFiltroRequestXQuery($mensagemMediacao1 as element(ns2:mensagemMediacao))
    as element(ns0:consultarMediacao) {
        <ns0:consultarMediacao>
            <ns0:cidadeContrato>{ data($mensagemMediacao1/ns2:identificacaoOperadoraNET/ns1:IdentificacaoCidade) }</ns0:cidadeContrato>
            <ns0:identificadorOrdemAtivacao>{ xs:int( data($mensagemMediacao1/ns2:identificadorOrdemAtivacao) ) }</ns0:identificadorOrdemAtivacao>
        </ns0:consultarMediacao>
};

declare variable $mensagemMediacao1 as element(ns2:mensagemMediacao) external;

xf:MediacaoConsultaFiltroRequestXQuery($mensagemMediacao1)