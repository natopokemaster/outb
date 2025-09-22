(:: pragma bea:global-element-parameter parameter="$gerarRequest1" element="ns1:gerarRequest" location="../wsdl/proxyservice/ProtocoloWSDL12V3_0.wsdl" ::)
(:: pragma bea:global-element-parameter parameter="$gerarResponse1" element="ns1:gerarResponse" location="../wsdl/proxyservice/ProtocoloWSDL12V3_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns2:enviarProtocoloFilaRequest" location="../wsdl/proxyservice/EnvioProtocoloFilaWSDL.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/protocolo/transformation/TransformaProtocoloResponseXEnvioProtocoloFilaRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns1 = "http://www.netservicos.com.br/Protocolo";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoProposta";
declare namespace ns2 = "http://www.netservicos.com.br/EnvioProtocoloFila";

declare function xf:TransformaProtocoloResponseXEnvioProtocoloFilaRequestXQuery($gerarRequest1 as element(ns1:gerarRequest),
    $gerarResponse1 as element(ns1:gerarResponse),
    $aliasDatabase as xs:string)
    as element(ns2:enviarProtocoloFilaRequest) {
        <ns2:enviarProtocoloFilaRequest>
        	<ns2:reenvio>false</ns2:reenvio>
	        {
	            if(exists($gerarRequest1/ns1:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta/node()) and data($gerarRequest1/ns1:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta) ne '') then
					<ns2:identificacaoProposta>
			               <ns3:Proposta>
			                   <ns3:NumeroProposta>{ data($gerarRequest1/ns1:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta) }</ns3:NumeroProposta>
			                   <ns3:CodigoOperadora>{ substring(data($gerarResponse1/ns1:protocolo),0,4) }</ns3:CodigoOperadora>
			               </ns3:Proposta>
			           </ns2:identificacaoProposta>            	
	            else()
            }
            
            {
            	if(exists($gerarRequest1/ns1:identificacaoContrato/ns0:Contrato/ns0:NumeroContrato/node()) and data($gerarRequest1/ns1:identificacaoContrato/ns0:Contrato/ns0:NumeroContrato) ne '') then
					<ns2:identificacaoContrato>
		                <ns0:Contrato>
		                    <ns0:NumeroContrato>{ data($gerarRequest1/ns1:identificacaoContrato/ns0:Contrato/ns0:NumeroContrato) }</ns0:NumeroContrato>
		                    <ns0:CodigoOperadora>{ substring(data($gerarResponse1/ns1:protocolo),0,4) }</ns0:CodigoOperadora>
		                </ns0:Contrato>   
		            </ns2:identificacaoContrato>
            	else()
            }
            
            <ns2:protocolo>{ data($gerarResponse1/ns1:protocolo) }</ns2:protocolo>
            <ns2:aliasDatabase>{ $aliasDatabase }</ns2:aliasDatabase>
        </ns2:enviarProtocoloFilaRequest>
};

declare variable $gerarRequest1 as element(ns1:gerarRequest) external;
declare variable $gerarResponse1 as element(ns1:gerarResponse) external;
declare variable $aliasDatabase as xs:string external;

xf:TransformaProtocoloResponseXEnvioProtocoloFilaRequestXQuery($gerarRequest1,
    $gerarResponse1,
    $aliasDatabase)
