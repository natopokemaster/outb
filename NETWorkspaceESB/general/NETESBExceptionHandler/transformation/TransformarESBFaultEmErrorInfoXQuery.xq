xquery version "1.0" encoding "Cp1252";
(:: pragma  parameter="$additionalInformation" type="anyType" ::)
(:: pragma  parameter="$validationMessages" type="anyType" ::)
(:: pragma bea:schema-type-return type="ns0:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETESBExceptionHandler/transformation/TransformarESBFaultEmErrorInfoXQuery/";
declare namespace errorinfo = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
declare namespace sbcontext = "http://www.bea.com/wli/sb/context";
declare namespace sbconfig = "http://www.bea.com/wli/sb/stages/transform/config";
declare namespace jwErr =    "http://www.bea.com/2002/04/jwErrorDetail/";
declare namespace beafault = "http://www.bea.com/servers/wls70/webservice/fault/1.0.0";

declare function xf:TransformarESBFaultEmErrorInfoXQuery(
    $fault as element(*),
    $exceptionClassification as xs:string,
    $accessResourceName as xs:string,
    $additionalInformation as element(*),
    $validationMessages as element(*),
    $exceptionStackTrace as xs:string)
    as element() {
        <errorinfo:ErrorInfo> 
       		 { if ($fault//sbconfig:http-response-code/node() and 
      		      (fn:not($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()))) then (
			  <code>{fn:concat('HTTP-',$fault//sbconfig:http-response-code/node())}</code> 
			  )else if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()) then (
			  <code>{$fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()}</code>			  
			  )else if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode/node()) then (
			  <code>{$fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode/node()}</code>			  
			  ) else (
			  <code>{$fault//sbcontext:errorCode/node()}</code>
			  ) }
      		 { if (fn:string-length($fault//sbconfig:http-response-code/node()) > 0 and 
      		      (fn:not($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()) )) then (
			  <message>{fn:concat($fault//sbcontext:errorCode/node(),'-',$fault/sbcontext:reason/node())}</message>
			  )else if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:reason/node()) then (
			  <message>{$fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:reason/node()}</message>			  
			  )else if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring/node()) then (
			  <message>{$fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring/node()}</message>			
			  ) else (
			  <message>{fn:concat($fault//sbcontext:reason/node())}</message>
			  ) }
			  <exceptionDate>{data(fn:current-dateTime())}</exceptionDate>
			  { if ((fn:string-length($fault//sbconfig:http-response-code/node()) > 0 and 
      		      (fn:not($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()) )) and
			         fn:matches(fn:concat($fault//sbconfig:http-response-code/node()),"401")  ) then ( 			  
   			    <exceptionClassification>{"CLASSIFICATION_SECURITY"}</exceptionClassification>
			  ) else if ((fn:string-length($fault//sbconfig:http-response-code/node()) > 0 and 
      		      (fn:not($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()) )) and
			         fn:matches(fn:concat($fault//sbconfig:http-response-code/node()),"404")  ) then (              
				  <exceptionClassification>{"CLASSIFICATION_RESOURCE"}</exceptionClassification>
			  ) else if ($fault//sbcontext:errorCode/node() and (
			         fn:matches(fn:concat($fault//sbcontext:errorCode/node()),"BEA-3825")  or 
			         fn:matches(fn:concat($fault//sbcontext:errorCode/node()),"BEA-3800") )) then (             
				  <exceptionClassification>{"CLASSIFICATION_RESOURCE"}</exceptionClassification>
			  ) else if ((fn:string-length($fault/sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()) > 0) and (
			         fn:matches(fn:concat($fault/sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()),"BEA-3825")  or 
			         fn:matches(fn:concat($fault/sbconfig:ReceivedFaultDetail/sbconfig:detail/sbcontext:fault/sbcontext:errorCode/node()),"BEA-3800") )) then (              
				  <exceptionClassification>{"CLASSIFICATION_RESOURCE"}</exceptionClassification>				  
               ) else if ((fn:string-length($exceptionClassification) > 0) ) then (              
				  <exceptionClassification>{$exceptionClassification}</exceptionClassification>
               ) else (
                <exceptionClassification>{"CLASSIFICATION_UNEXPECTED"}</exceptionClassification>
              ) }								          
			  { if ($fault//sbcontext:location/sbcontext:node/node()) then ( 
			    <accessResourceName>{fn:replace(fn:concat($fault//sbcontext:location/sbcontext:path/node(),'.'
								          ,$fault//sbcontext:location/sbcontext:pipeline1/node(),'.'
								          ,$fault//sbcontext:location/sbcontext:stage/node(),'.'
								          ,$fault//sbcontext:location/sbcontext:node/node(),'.'
   								          ,$fault//sbcontext:location/sbcontext:error_handler/node()),'\.\.','.'
								          )}</accessResourceName>
			  ) else (
                <accessResourceName>{$accessResourceName}</accessResourceName>
              ) }								          
			  <additionalInformation>{ $additionalInformation/@* , $additionalInformation/node()  }</additionalInformation>
              <validationMessages>{ $validationMessages/@* , $validationMessages/node() }</validationMessages>
      		 { if ($fault//sbconfig:ReceivedFaultDetail/node()) then ( 
	      		   if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/jwErr:jwErrorDetail/node()) then (              
				  <exceptionStackTrace>{fn:concat($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode/node(),':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring/node(),':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/jwErr:jwErrorDetail/node())}</exceptionStackTrace>
				  ) else if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/beafault:stacktrace/node()) then (              
				  <exceptionStackTrace>{fn:concat($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode/node(),':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring/node(),':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/beafault:stacktrace/node())}</exceptionStackTrace>
				  ) else if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/node()) then (              
				  <exceptionStackTrace>{fn:concat($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode/node(),':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring/node(),':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/node())}</exceptionStackTrace>
               ) else (
				  <exceptionStackTrace>{fn:concat($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode/node(),':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring/node())}</exceptionStackTrace>
                 )
			  ) else (
              <exceptionStackTrace>{fn:data($exceptionStackTrace)}</exceptionStackTrace>
              ) }
        </errorinfo:ErrorInfo>
};

declare variable $fault as element(*) external;

declare variable $exceptionClassification as xs:string external;
declare variable $accessResourceName as xs:string external;
declare variable $additionalInformation as element(*) external;
declare variable $validationMessages as element(*) external;
declare variable $exceptionStackTrace as xs:string external;


xf:TransformarESBFaultEmErrorInfoXQuery($fault,
    $exceptionClassification,
    $accessResourceName,
    $additionalInformation,
    $validationMessages,
    $exceptionStackTrace)