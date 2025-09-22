(:: pragma bea:global-element-parameter parameter="$gerarResponse1" element="ns2:gerarResponse" location="../wsdl/proxyservice/ProtocoloWSDL12V3_0.wsdl" ::)
(:: pragma bea:global-element-parameter parameter="$gerarRequest1" element="ns2:gerarRequest" location="../wsdl/proxyservice/ProtocoloWSDL12V3_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:enviarProtocoloRequest" location="../../envioprotocolo/wsdl/proxyservice/EnvioProtocoloWSDL12V1.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/protocolo/transformation/TransformProcoloResponseXEnvioProtocoloRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/EnvioProtocolo";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoProposta";
declare namespace ns2 = "http://www.netservicos.com.br/Protocolo";

declare function xf:TransformProcoloResponseXEnvioProtocoloRequestXQuery($gerarResponse1 as element(ns2:gerarResponse),
    $gerarRequest1 as element(ns2:gerarRequest))
    as element(ns0:enviarProtocoloRequest) {
        <ns0:enviarProtocoloRequest>
            <ns0:reenvio>false</ns0:reenvio>
            {
            	if(exists($gerarRequest1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta/node()) and data($gerarRequest1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta) ne '') then
					<ns0:identificacaoProposta>
		                <ns3:Proposta>
		                    <ns3:NumeroProposta>{ data($gerarRequest1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta) }</ns3:NumeroProposta>
		                    <ns3:CodigoOperadora>{ substring(data($gerarResponse1/ns2:protocolo),0,4) }</ns3:CodigoOperadora>
		                </ns3:Proposta>
		            </ns0:identificacaoProposta>            	
            	else()
            }
            
            {
            	if(exists($gerarRequest1/ns2:identificacaoContrato/ns1:Contrato/ns1:NumeroContrato/node()) and data($gerarRequest1/ns2:identificacaoContrato/ns1:Contrato/ns1:NumeroContrato) ne '') then
					<ns0:identificacaoContrato>
		                <ns1:Contrato>
		                    <ns1:NumeroContrato>{ data($gerarRequest1/ns2:identificacaoContrato/ns1:Contrato/ns1:NumeroContrato) }</ns1:NumeroContrato>
		                    <ns1:CodigoOperadora>{ substring(data($gerarResponse1/ns2:protocolo),0,4) }</ns1:CodigoOperadora>
		                </ns1:Contrato>
		                
		            </ns0:identificacaoContrato>
            	else()
            }
            
         <ns0:protocolo>{ data($gerarResponse1/ns2:protocolo) }</ns0:protocolo>   
        </ns0:enviarProtocoloRequest>
};

declare variable $gerarResponse1 as element(ns2:gerarResponse) external;
declare variable $gerarRequest1 as element(ns2:gerarRequest) external;

xf:TransformProcoloResponseXEnvioProtocoloRequestXQuery($gerarResponse1,
    $gerarRequest1)
