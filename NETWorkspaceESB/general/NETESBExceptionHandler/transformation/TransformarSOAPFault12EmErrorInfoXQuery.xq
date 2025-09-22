xquery version "1.0" encoding "Cp1252";
(:: pragma  parameter="$additionalInformation" type="anyType" ::)
(:: pragma  parameter="$validationMessages" type="anyType" ::)
(:: pragma bea:schema-type-return type="ns0:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETESBExceptionHandler/transformation/TransformarSOAPFault12EmErrorInfoXQuery/";
declare namespace errorinfo = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
declare namespace soap-env-11 = "http://schemas.xmlsoap.org/soap/envelope/";
declare namespace soap-env-12 = "http://www.w3.org/2003/05/soap-envelope";

declare function xf:TransformarSOAPFault12EmErrorInfoXQuery(
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
     		  {if ($fault//soap-env-12:Subcode/soap-env-12:Value/node()) then (
	                <code>{data($fault//soap-env-12:Subcode/soap-env-12:Value)}</code> 
			   ) else (
				    if (matches(data($fault//soap-env-12:Code/soap-env-12:Value),"MustUnderstand|Receiver|Sender|VersionMismatch" ) and 
	      		       contains($fault//soap-env-12:Reason/soap-env-12:Text,":") and
	      		       contains(substring-before($fault//soap-env-12:Reason/soap-env-12:Text,":"),"-")) then (
				  	<code>{substring-before($fault//soap-env-12:Reason/soap-env-12:Text,":")}</code> 
				  	) else if ($fault//soap-env-12:Code/soap-env-12:Value/node()) then (
				  	<code>{data($fault//soap-env-12:Code/soap-env-12:Value)}</code>
				    ) else (
			  	    <code>{$messageCode}</code>
  					)
				) }			  			          
      		  {if ($fault//soap-env-12:Reason/soap-env-12:Text/node()) then (
                <message>{data($fault//soap-env-12:Reason/soap-env-12:Text)}</message>
			  ) else (
			  	<message>{$message}</message>
			  ) }
			  <exceptionDate>{data(fn:current-dateTime())}</exceptionDate>
			  <exceptionClassification>{$exceptionClassification}</exceptionClassification>
      		  {if ($fault//soap-env-12:Node/node() or $fault//soap-env-12:Role/node() ) then (
 			    <accessResourceName>{concat(data($fault//soap-env-12:Node),'.',data($fault//soap-env-12:Role))}</accessResourceName>
			  ) else (
			  	<accessResourceName>{$accessResourceName}</accessResourceName>
			  ) }	
			  <additionalInformation>{ $additionalInformation/@* , $additionalInformation/node() }</additionalInformation>
              <validationMessages>{ $validationMessages/@* , $validationMessages/node() }</validationMessages>
      		  {if ($fault//soap-env-12:Detail/node()) then (
 			    <exceptionStackTrace>{data($fault//soap-env-12:Detail)}</exceptionStackTrace>
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

xf:TransformarSOAPFault12EmErrorInfoXQuery(
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