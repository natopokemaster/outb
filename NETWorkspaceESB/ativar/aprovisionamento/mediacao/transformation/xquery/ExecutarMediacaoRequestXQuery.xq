(:: pragma bea:global-element-parameter parameter="$mensagemMediacao1" element="ns2:mensagemMediacao" location="../../schemas/MensagemMediacao.xsd" ::)
(:: pragma bea:global-element-parameter parameter="$ordemAtivacao1" element="ns3:OrdemAtivacao" location="../../wsdl/business/MediacaoConsultaOrdemBSWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:executarMediacao" location="../../wsdl/business/MediacaoBSWSDLV1_0.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/v2/NetHeader";
declare namespace xf = "http://tempuri.org/ativar/aprovisionamento/mediacao/transformation/xquery/ExecutarMediacaoRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/jws/MediacaoJWS";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";
declare namespace ns3 = "http://www.netservicos.com.br/OrdemAtivacao/schemas";
declare namespace ns2 = "http://www.netservicos.com.br/MensagemMediacao";

declare function xf:ExecutarMediacaoRequestXQuery($mensagemMediacao1 as element(ns2:mensagemMediacao),
    $ordemAtivacao1 as element(ns3:OrdemAtivacao))
    as element(ns0:executarMediacao) {
        <ns0:executarMediacao>
			<ns4:NetHeader>
                {
                    for $aplicacao in $mensagemMediacao1/ns2:netHeader/aplicacao
                    return
                        <aplicacao>{ data($aplicacao) }</aplicacao>
                }
                {
                    for $funcionalidade in $mensagemMediacao1/ns2:netHeader/funcionalidade
                    return
                        <funcionalidade>{ data($funcionalidade) }</funcionalidade>
                }
                {
                    for $versaoServico in $mensagemMediacao1/ns2:netHeader/versaoServico
                    return
                        <versaoServico>{ data($versaoServico) }</versaoServico>
                }
                {
                    for $token in $mensagemMediacao1/ns2:netHeader/token
                    return
                        <token>{ data($token) }</token>
                }
                <atendimento>
                    <numeroProtocolo>{ data($mensagemMediacao1/ns2:netHeader/atendimento/numeroProtocolo) }</numeroProtocolo>
                    <numeroChamada>{ data($mensagemMediacao1/ns2:netHeader/atendimento/numeroChamada) }</numeroChamada>
                </atendimento>
                {
                    for $username in $mensagemMediacao1/ns2:netHeader/username
                    return
                        <username>{ data($username) }</username>
                }
            </ns4:NetHeader>
            <ns3:OrdemAtivacao>{ $ordemAtivacao1/@* , $ordemAtivacao1/node() }</ns3:OrdemAtivacao>
        </ns0:executarMediacao>
};

declare variable $mensagemMediacao1 as element(ns2:mensagemMediacao) external;
declare variable $ordemAtivacao1 as element(ns3:OrdemAtivacao) external;

xf:ExecutarMediacaoRequestXQuery($mensagemMediacao1,
    $ordemAtivacao1)
