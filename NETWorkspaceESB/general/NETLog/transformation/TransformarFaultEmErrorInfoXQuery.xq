xquery version "1.0" encoding "Cp1252";
(:: pragma  parameter="$entrada" type="xs:anyType" ::)
(:: pragma bea:schema-type-return type="ns0:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETLog/transformation/TransformarFaultEmErrorInfoXQuery/";
declare namespace errorinfo = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
declare namespace sbcontext = "http://www.bea.com/wli/sb/context";
declare namespace sbconfig = "http://www.bea.com/wli/sb/stages/transform/config";
declare namespace jwErr =    "http://www.bea.com/2002/04/jwErrorDetail/";
declare namespace beafault = "http://www.bea.com/servers/wls70/webservice/fault/1.0.0";

declare function xf:TransformarFaultEmErrorInfoXQuery($fault as element(*))
    as element() {
        <errorinfo:ErrorInfo>     
      		 { if ($fault//sbconfig:http-response-code/node()) then (
			  <code>{fn:concat('HTTP-',$fault//sbconfig:http-response-code/node())}</code> 
			  ) else (
			  <code>{$fault//sbcontext:errorCode/node()}</code>
			  ) }
      		 { if (fn:string-length($fault//sbconfig:http-response-code/node()) > 0) then (
			  <message>{fn:concat($fault//sbcontext:errorCode/node(),'-',$fault//sbcontext:reason/node())}</message>
			  ) else (
			  <message>{fn:concat($fault//sbcontext:reason/node())}</message>
			  ) }
			  <exceptionDate>{data(fn:current-dateTime())}</exceptionDate>
			  <exceptionClassification></exceptionClassification>
			  <accessResourceName>{fn:replace(fn:concat($fault//sbcontext:location/sbcontext:path/node(),'.'
								          ,$fault//sbcontext:location/sbcontext:pipeline1/node(),'.'
								          ,$fault//sbcontext:location/sbcontext:stage/node(),'.'
								          ,$fault//sbcontext:location/sbcontext:node/node(),'.'
   								          ,$fault//sbcontext:location/sbcontext:error_handler/node()),'\.\.','.'
								          )}</accessResourceName>
			  <additionalInformation/>
              <validationMessages/>
      		 { if ($fault//sbconfig:ReceivedFaultDetail/node()) then ( 
	      		   if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/jwErr:jwErrorDetail/node()) then (              
				  <exceptionStackTrace>{fn:concat($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode,':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring,':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/jwErr:jwErrorDetail)}</exceptionStackTrace>
				  ) else if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/beafault:stacktrace/node()) then (              
				  <exceptionStackTrace>{fn:concat($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode,':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring,':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/beafault:stacktrace)}</exceptionStackTrace>
				  ) else if ($fault//sbconfig:ReceivedFaultDetail/sbconfig:detail/node()) then (              
				  <exceptionStackTrace>{fn:concat($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode,':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring,':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:detail)}</exceptionStackTrace>
               ) else (
				  <exceptionStackTrace>{fn:concat($fault//sbconfig:ReceivedFaultDetail/sbconfig:faultcode,':',
				                                  $fault//sbconfig:ReceivedFaultDetail/sbconfig:faultstring)}</exceptionStackTrace>
                 )
			  ) else (
              <exceptionStackTrace/>
              ) }
        </errorinfo:ErrorInfo>
};

declare variable $fault as element(*) external;

xf:TransformarFaultEmErrorInfoXQuery($fault)