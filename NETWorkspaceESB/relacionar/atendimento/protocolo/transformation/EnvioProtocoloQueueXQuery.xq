(:: pragma bea:global-element-parameter parameter="$enviarProtocoloFilaRequest1" element="ns2:enviarProtocoloFilaRequest" location="../wsdl/proxyservice/EnvioProtocoloFilaWSDL.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:mensagemEnvioProtocolo" location="../schemas/MensagemEnvioProtocoloFila.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/protocolo/transformation/EnvioProtocoloQueueXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns1 = "http://www.netservicos.com.br/MensagemEnvioProtocoloFila";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoProposta";
declare namespace ns2 = "http://www.netservicos.com.br/EnvioProtocoloFila";
declare namespace con = "http://www.bea.com/wli/sb/context";
declare namespace tran = "http://www.bea.com/wli/sb/transports";

declare function xf:EnvioProtocoloQueueXQuery($enviarProtocoloFilaRequest1 as element(ns2:enviarProtocoloFilaRequest), $inbound as element(con:endpoint))
    as element(ns1:mensagemEnvioProtocolo) {
        <ns1:mensagemEnvioProtocolo>
            <ns1:reenvio>{ data($enviarProtocoloFilaRequest1/ns2:reenvio) }</ns1:reenvio>
            {
            	if(exists($enviarProtocoloFilaRequest1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta/node()) and data($enviarProtocoloFilaRequest1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta) ne '') then
					<ns1:identificacaoProposta>
						<ns3:Protocolo>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoProposta/ns3:Protocolo) }</ns3:Protocolo>
		                <ns3:Proposta>
		                    <ns3:NumeroProposta>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta) }</ns3:NumeroProposta>
		                    <ns3:CodigoOperadora>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoProposta/ns3:Proposta/ns3:CodigoOperadora) }</ns3:CodigoOperadora>
   		                    <ns3:IdentificacaoCidade>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoProposta/ns3:Proposta/ns3:IdentificacaoCidade) }</ns3:IdentificacaoCidade>
		                </ns3:Proposta>
		            </ns1:identificacaoProposta>            	
            	else()
            }
            
            {
            	if(exists($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:Contrato/ns0:NumeroContrato/node()) and data($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:Contrato/ns0:NumeroContrato) ne '') then
					<ns1:identificacaoContrato>
		                <ns0:SmartCard>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:SmartCard) }</ns0:SmartCard>
		                <ns0:Contrato>
		                    <ns0:NumeroContrato>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:Contrato/ns0:NumeroContrato) }</ns0:NumeroContrato>
		                    <ns0:CodigoOperadora>{data($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:Contrato/ns0:CodigoOperadora) }</ns0:CodigoOperadora>
   		                    <ns0:IdentificacaoCidade>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:Contrato/ns0:IdentificacaoCidade) }</ns0:IdentificacaoCidade>		                    
		                </ns0:Contrato>
		                <ns0:Protocolo>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:Protocolo) }</ns0:Protocolo>
		                <ns0:EnderecoMAC>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:EnderecoMAC) }</ns0:EnderecoMAC>
		                <ns0:AliasDatabase>{ data($enviarProtocoloFilaRequest1/ns2:identificacaoContrato/ns0:AliasDatabase) }</ns0:AliasDatabase>		                
		            </ns1:identificacaoContrato>
            	else()
            }
            <ns1:Protocolo>{ data($enviarProtocoloFilaRequest1/ns2:protocolo) }</ns1:Protocolo>
            <ns1:Authorization>{ data($inbound/con:transport/con:request/tran:headers/tran:user-header/@value) }</ns1:Authorization>
            <ns1:aliasDatabase>{ data($enviarProtocoloFilaRequest1/ns2:aliasDatabase) }</ns1:aliasDatabase>
        </ns1:mensagemEnvioProtocolo>
};

declare variable $enviarProtocoloFilaRequest1 as element(ns2:enviarProtocoloFilaRequest) external;
declare variable $aliasDatabase as xs:string external;
declare variable $inbound as element(con:endpoint) external;

xf:EnvioProtocoloQueueXQuery($enviarProtocoloFilaRequest1,$inbound)
