(:: pragma bea:schema-type-parameter parameter="$message" type="ns2:Message" location="../../../modelocanonicoV2/geral/Message.xsd" ::)
(:: pragma bea:schema-type-return type="soap:Fault" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETLog/transformation/TransformarMensagemEmFaultESB/";
declare namespace soap = "http://www.w3.org/2003/05/soap-envelope";
declare namespace ns2 = "http://netservicos.com.br/core/schema";

declare function xf:TransformarMensagemEmFaultESB($message as element(),
    $locationNode as xs:string,
    $locationPipeline as xs:string,
    $locationStage as xs:string,
    $locationPath as xs:string)
    as element() {
        <soap:Fault>
            <soap:Code>
                <soap:Value>{data('soap:Receiver')}</soap:Value>
                <soap:Subcode>
                     <soap:Value>{ data($message//ns2:ID_MSG) }</soap:Value>
                </soap:Subcode>
            </soap:Code>
            <soap:Reason>
                <soap:Text xml:lang="pt">{ data($message//ns2:MENSAGEM_DETALHADA) }</soap:Text>
            </soap:Reason>
            <soap:Node>{ data($locationNode) }</soap:Node>
	         <soap:Detail>
	            <soap:fault xmlns:con="http://www.bea.com/wli/sb/context">
	               <soap:errorCode>{ data($message//ns2:ID_MSG) }</soap:errorCode>
	               <soap:reason>{ data($message//ns2:MENSAGEM_DETALHADA) }</soap:reason>
	               <soap:location>
	                  <soap:node>{ data($locationNode) }</soap:node>
	                  <soap:pipeline>{ data($locationPipeline) }</soap:pipeline>
	                  <soap:stage>{ data($locationStage) }</soap:stage>
	                  <soap:path>{ data($locationPath) }</soap:path>
	               </soap:location>
	            </soap:fault>
	         </soap:Detail>            
        </soap:Fault>
};

declare variable $message as element() external;
declare variable $locationNode as xs:string external;
declare variable $locationPipeline as xs:string external;
declare variable $locationStage as xs:string external;
declare variable $locationPath as xs:string external;

xf:TransformarMensagemEmFaultESB($message,
    $locationNode,
    $locationPipeline,
    $locationStage,
    $locationPath)