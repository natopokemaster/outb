(:: pragma bea:global-element-parameter parameter="$mensagemMediacao1" element="ns1:mensagemMediacao" location="../../schemas/MensagemMediacao.xsd" ::)
(:: pragma bea:global-element-return element="ns2:NetHeader" location="../../wsdl/business/MediacaoBSWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/ativar/aprovisionamento/mediacao/transformation/xquery/MediacaoNetHeaderRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";
declare namespace ns1 = "http://www.netservicos.com.br/MensagemMediacao";
declare namespace ns2 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:MediacaoNetHeaderRequestXQuery($mensagemMediacao1 as element(ns1:mensagemMediacao))
    as element(ns2:NetHeader) {
        <ns2:NetHeader>
            {
                for $aplicacao in $mensagemMediacao1/ns1:netHeader/aplicacao
                return
                    <aplicacao>{ data($aplicacao) }</aplicacao>
            }
            {
                for $funcionalidade in $mensagemMediacao1/ns1:netHeader/funcionalidade
                return
                    <funcionalidade>{ data($funcionalidade) }</funcionalidade>
            }
            {
                for $versaoServico in $mensagemMediacao1/ns1:netHeader/versaoServico
                return
                    <versaoServico>{ data($versaoServico) }</versaoServico>
            }
            {
                for $token in $mensagemMediacao1/ns1:netHeader/token
                return
                    <token>{ data($token) }</token>
            }
            <atendimento>
                <numeroProtocolo>{ data($mensagemMediacao1/ns1:netHeader/atendimento/numeroProtocolo) }</numeroProtocolo>
                <numeroChamada>{ data($mensagemMediacao1/ns1:netHeader/atendimento/numeroChamada) }</numeroChamada>
            </atendimento>
            {
                for $username in $mensagemMediacao1/ns1:netHeader/username
                return
                    <username>{ data($username) }</username>
            }
        </ns2:NetHeader>
};

declare variable $mensagemMediacao1 as element(ns1:mensagemMediacao) external;

xf:MediacaoNetHeaderRequestXQuery($mensagemMediacao1)
