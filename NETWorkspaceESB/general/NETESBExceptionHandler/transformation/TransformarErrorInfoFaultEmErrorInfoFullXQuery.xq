xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$errorInfoFault" element="errorinfo:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)
(:: pragma  parameter="$additionalInformation" type="anyType" ::)
(:: pragma  parameter="$validationMessages" type="anyType" ::)
(:: pragma bea:schema-type-return type="ns0:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETESBExceptionHandler/transformation/TransformarErrorInfoEmErrorInfoFullXQuery/";
declare namespace errorinfo = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
declare namespace soap-env-11 = "http://schemas.xmlsoap.org/soap/envelope/";
declare namespace soap-env-12 = "http://www.w3.org/2003/05/soap-envelope";

declare function xf:TransformarSOAPFault12EmErrorInfoXQuery(
    $errorInfoFault as element(errorinfo:ErrorInfo),
    $messageCode as xs:string,
    $message as xs:string,
    $exceptionClassification as xs:string?,
    $accessResourceName as xs:string?,
    $additionalInformation as element(*)?,
    $validationMessages as element(*)?,
    $exceptionStackTrace as xs:string?,
    $macroProcesso as xs:string?,    
    $processo as xs:string?)
    as element() {
        <errorinfo:ErrorInfo>
      		  {if ($errorInfoFault/code/node()) then (
 			    <code>{data($errorInfoFault/code)}</code> 
			  ) else (
			  	<code>{$messageCode}</code>
			  ) }
      		  {if ($errorInfoFault/message/node()) then (
                <message>{data($errorInfoFault/message)}</message>
			  ) else (
			  	<message>{$message}</message>
			  ) }
      		  {if ($errorInfoFault/exceptionDate/node()) then (
                <exceptionDate>{data($errorInfoFault/exceptionDate)}</exceptionDate> 
			  ) else (
			  	<exceptionDate>{data(fn:current-dateTime())}</exceptionDate>
			  ) }
      		  {if ($errorInfoFault/exceptionClassification/node()) then (
 			    <exceptionClassification>{data($errorInfoFault/exceptionClassification)}</exceptionClassification> 
			  ) else (
			  	<exceptionClassification>{$exceptionClassification}</exceptionClassification>
			  ) }
      		  {if ($errorInfoFault/accessResourceName/node()) then (
 			    <accessResourceName>{data($errorInfoFault/accessResourceName)}</accessResourceName> 
			  ) else (
			  	<accessResourceName>{$accessResourceName}</accessResourceName>
			  ) }
      		  {if ($errorInfoFault/additionalInformation/node()) then (
 			    <additionalInformation>{ $errorInfoFault/additionalInformation/@* , $errorInfoFault/additionalInformation/node() }</additionalInformation>
			  ) else (
			  	<additionalInformation>{ $additionalInformation/@* , $additionalInformation/node() }</additionalInformation>
			  ) }
      		  {if ($errorInfoFault/validationMessages/node()) then (
 			    <validationMessages>{ $errorInfoFault/validationMessages/@* , $errorInfoFault/validationMessages/node() }</validationMessages>
			  ) else (
 			    <validationMessages>{ $validationMessages/@* , $validationMessages/node() }</validationMessages>
			  ) }
      		  {if ($errorInfoFault/exceptionStackTrace/node()) then (
 			    <exceptionStackTrace>{data($errorInfoFault/exceptionStackTrace)}</exceptionStackTrace>
			  ) else (
			  	<exceptionStackTrace>{$exceptionStackTrace}</exceptionStackTrace>
			  ) }			          
        </errorinfo:ErrorInfo>
};

declare variable $errorInfoFault as element(errorinfo:ErrorInfo) external;
declare variable $messageCode as xs:string external;
declare variable $message as xs:string external;
declare variable $exceptionClassification as xs:string? external;
declare variable $accessResourceName as xs:string? external;
declare variable $additionalInformation as element(*)? external;
declare variable $validationMessages as element(*)? external;
declare variable $exceptionStackTrace as xs:string? external;
declare variable $macroProcesso as xs:string? external;
declare variable $processo as xs:string? external;

xf:TransformarSOAPFault12EmErrorInfoXQuery(
    $errorInfoFault,
    $messageCode,
    $message,
    $exceptionClassification,
    $accessResourceName,
    $additionalInformation,
    $validationMessages,
    $exceptionStackTrace,
    $macroProcesso,
    $processo)