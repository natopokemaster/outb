xquery version "1.0" encoding "Cp1252";
(:: pragma  parameter="$additionalInformation" type="anyType" ::)
(:: pragma  parameter="$validationMessages" type="anyType" ::)
(:: pragma bea:schema-type-return type="ns0:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETESBExceptionHandler/transformation/TransformarSOAPFault11EmErrorInfoXQuery/";
declare namespace errorinfo = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
declare namespace soap-env-11 = "http://schemas.xmlsoap.org/soap/envelope/";
declare namespace soap-env-12 = "http://www.w3.org/2003/05/soap-envelope";

declare function xf:TransformarSOAPFault11EmErrorInfoXQuery(
    $fault as element(*),
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
      		  {if ($fault//faultcode/node()) then (
	               if (matches(data($fault//faultcode),"MustUnderstand|Receiver|Sender|VersionMismatch" ) and
	      		       contains($fault//faultstring,":") and
	      		       contains(substring-before($fault//faultstring,":"),"-")) then (
				  <code>{substring-before($fault//faultstring,":")}</code>
				  ) else (
				  <code>{data($fault//faultcode)}</code>
				  )  
			  ) else (
			  	<code>{$messageCode}</code>
			  ) }
      		  {if ($fault//faultstring/node()) then (
                <message>{data($fault//faultstring)}</message>
			  ) else (
			  	<message>{$message}</message>
			  ) }
			  <exceptionDate>{data(fn:current-dateTime())}</exceptionDate>
			  <exceptionClassification>{$exceptionClassification}</exceptionClassification>
      		  {if ($fault//faultactor/node()) then (
 			    <accessResourceName>{data($fault//faultactor)}</accessResourceName> 
			  ) else (
			  	<accessResourceName>{$accessResourceName}</accessResourceName>
			  ) }	
			  <additionalInformation>{ $additionalInformation/@* , $additionalInformation/node() }</additionalInformation>
              <validationMessages>{ $validationMessages/@* , $validationMessages/node() }</validationMessages>
      		  {if ($fault//detail/node()) then (
 			    <exceptionStackTrace>{data($fault//detail)}</exceptionStackTrace>
			  ) else (
			  	<exceptionStackTrace>{$exceptionStackTrace}</exceptionStackTrace>
			  ) }				  
        </errorinfo:ErrorInfo>
};

declare variable $fault as element(*) external;
declare variable $messageCode as xs:string external;
declare variable $message as xs:string external;
declare variable $exceptionClassification as xs:string? external;
declare variable $accessResourceName as xs:string? external;
declare variable $additionalInformation as element(*)? external;
declare variable $validationMessages as element(*)? external;
declare variable $exceptionStackTrace as xs:string? external;
declare variable $macroProcesso as xs:string? external;
declare variable $processo as xs:string? external;

xf:TransformarSOAPFault11EmErrorInfoXQuery(
    $fault,
    $messageCode,
    $message,
    $exceptionClassification,
    $accessResourceName,
    $additionalInformation,
    $validationMessages,
    $exceptionStackTrace,
    $macroProcesso,
    $processo)