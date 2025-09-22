(:: pragma  parameter="$currentBody" type="anyType" ::)
(:: pragma  parameter="$currentFault" type="anyType" ::)
(:: pragma  parameter="$callResponse" type="anyType" ::)
(:: pragma  parameter="$currentInbound" type="anyType" ::)
(:: pragma  parameter="$messageParameters" type="anyType" ::)
(:: pragma  parameter="$additionalInformation" type="anyType" ::)
(:: pragma  parameter="$validationMessages" type="anyType" ::)
(:: pragma bea:global-element-return element="ns0:NETESBExceptionHandlerRequest" location="../wsdl/NETESBExceptionHandlerWSDL12V1.wsdl" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETESBExceptionHandler/transformation/TransformarEntradaExceptionHandlerXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/NETESBExceptionHandler12V1";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";

declare function xf:TransformarEntradaExceptionHandlerXQuery($currentBody as element(*)?,
    $currentFault as element(*)?,
    $callResponse as element(*)?,
    $currentInbound as element(*),
    $messageCode as xs:string,
    $messageParameters as element(*)?,
    $exceptionClassification as xs:string?,
    $accessResourceName as xs:string?,
    $additionalInformation as element(*)?,
    $validationMessages as element(*)?,
    $exceptionStackTrace as xs:string?,
    $macroProcesso as xs:string?,    
    $processo as xs:string?,    
    $responseSOAPVersion as xs:string)
    as element(ns0:NETESBExceptionHandlerRequest) {
        <ns0:NETESBExceptionHandlerRequest>
            <ns0:currentBody>{ $currentBody }</ns0:currentBody>
            <ns0:currentFault>{ $currentFault }</ns0:currentFault>
            <ns0:callResponse>{ $callResponse }</ns0:callResponse>
            <ns0:currentInbound>{ $currentInbound }</ns0:currentInbound>
            <ns0:messageCode>{ $messageCode }</ns0:messageCode>
            <ns0:messageParameters>{ $messageParameters/@* , $messageParameters/node() }</ns0:messageParameters>
            <ns0:exceptionClassification>{ $exceptionClassification }</ns0:exceptionClassification>
            <ns0:accessResourceName>{ $accessResourceName }</ns0:accessResourceName>
            <ns0:additionalInformation>{ $additionalInformation }</ns0:additionalInformation>
            <ns0:validationMessages>{ $validationMessages/@* , $validationMessages/node() }</ns0:validationMessages>
            <ns0:exceptionStackTrace>{ $exceptionStackTrace }</ns0:exceptionStackTrace>
            <ns0:macroProcesso>{ $macroProcesso }</ns0:macroProcesso>
            <ns0:processo>{ $processo }</ns0:processo>                        
            <ns0:responseSOAPVersion>{ $responseSOAPVersion }</ns0:responseSOAPVersion>
        </ns0:NETESBExceptionHandlerRequest>
};

declare variable $currentBody as element(*)? external;
declare variable $currentFault as element(*)? external;
declare variable $callResponse as element(*)? external;
declare variable $currentInbound as element(*) external;
declare variable $messageCode as xs:string external;
declare variable $messageParameters as element(*)? external;
declare variable $exceptionClassification as xs:string? external;
declare variable $accessResourceName as xs:string? external;
declare variable $additionalInformation as element(*)? external;
declare variable $validationMessages as element(*)? external;
declare variable $exceptionStackTrace as xs:string? external;
declare variable $macroProcesso as xs:string? external;
declare variable $processo as xs:string? external;
declare variable $responseSOAPVersion as xs:string external;

xf:TransformarEntradaExceptionHandlerXQuery($currentBody,
    $currentFault,
    $callResponse,
    $currentInbound,
    $messageCode,
    $messageParameters,
    $exceptionClassification,
    $accessResourceName,
    $additionalInformation,
    $validationMessages,
    $exceptionStackTrace,
    $macroProcesso,
    $processo,
    $responseSOAPVersion)