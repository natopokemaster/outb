(:: pragma bea:global-element-parameter parameter="$mensagemEnvioProtocolo1" element="ns2:mensagemEnvioProtocolo" location="../schemas/MensagemEnvioProtocoloFila.xsd" ::)
(:: pragma bea:global-element-return element="ns0:enviarProtocoloRequest" location="../../envioprotocolo/wsdl/proxyservice/EnvioProtocoloWSDL12V1.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/protocolo/transformation/TransformMensagemEnvioProtocoloXEnvioProtocoloRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/EnvioProtocolo";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoProposta";
declare namespace ns2 = "http://www.netservicos.com.br/MensagemEnvioProtocoloFila";

declare function xf:TransformMensagemEnvioProtocoloXEnvioProtocoloRequestXQuery($mensagemEnvioProtocolo1 as element(ns2:mensagemEnvioProtocolo))
    as element(ns0:enviarProtocoloRequest) {
        <ns0:enviarProtocoloRequest>
            <ns0:reenvio>{ data($mensagemEnvioProtocolo1/ns2:reenvio) }</ns0:reenvio>
			            {
            if(exists($mensagemEnvioProtocolo1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta/node()) and data($mensagemEnvioProtocolo1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta) ne '') then
					<ns0:identificacaoProposta>
						<ns3:Protocolo>{ data($mensagemEnvioProtocolo1/ns2:identificacaoProposta/ns3:Protocolo) }</ns3:Protocolo>
		                <ns3:Proposta>
		                    <ns3:NumeroProposta>{ data($mensagemEnvioProtocolo1/ns2:identificacaoProposta/ns3:Proposta/ns3:NumeroProposta) }</ns3:NumeroProposta>
		                    <ns3:CodigoOperadora>{ data($mensagemEnvioProtocolo1/ns2:identificacaoProposta/ns3:Proposta/ns3:CodigoOperadora) }</ns3:CodigoOperadora>
		                </ns3:Proposta>
		            </ns0:identificacaoProposta>            	
            	else()
            }
            
            {
            	if(exists($mensagemEnvioProtocolo1/ns2:identificacaoContrato/ns1:Contrato/ns1:NumeroContrato/node()) and data($mensagemEnvioProtocolo1/ns2:identificacaoContrato/ns1:Contrato/ns1:NumeroContrato) ne '') then
					<ns0:identificacaoContrato>
		                <ns1:SmartCard>{ data($mensagemEnvioProtocolo1/ns2:identificacaoContrato/ns1:SmartCard) }</ns1:SmartCard>
		                <ns1:Contrato>
		                    <ns1:NumeroContrato>{ data($mensagemEnvioProtocolo1/ns2:identificacaoContrato/ns1:Contrato/ns1:NumeroContrato) }</ns1:NumeroContrato>
		                    <ns1:CodigoOperadora>{data($mensagemEnvioProtocolo1/ns2:identificacaoContrato/ns1:Contrato/ns1:CodigoOperadora) }</ns1:CodigoOperadora>		                    
		                </ns1:Contrato>
		                <ns1:Protocolo>{ data($mensagemEnvioProtocolo1/ns2:identificacaoContrato/ns1:Protocolo) }</ns1:Protocolo>
		                <ns1:EnderecoMAC>{ data($mensagemEnvioProtocolo1/ns2:identificacaoContrato/ns1:EnderecoMAC) }</ns1:EnderecoMAC>
		                <ns1:AliasDatabase>{ data($mensagemEnvioProtocolo1/ns2:identificacaoContrato/ns1:AliasDatabase) }</ns1:AliasDatabase>		                
		            </ns0:identificacaoContrato>
            	else()
            }
            <ns0:protocolo>{ data($mensagemEnvioProtocolo1/ns2:Protocolo) }</ns0:protocolo>
        </ns0:enviarProtocoloRequest>
};

declare variable $mensagemEnvioProtocolo1 as element(ns2:mensagemEnvioProtocolo) external;

xf:TransformMensagemEnvioProtocoloXEnvioProtocoloRequestXQuery($mensagemEnvioProtocolo1)
