(:: pragma bea:global-element-parameter parameter="$errorInfo" element="errorinfo:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)
(:: pragma  type="anyType" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETESBExceptionHandler/transformation/TransformarErrorInfoEmSOAPFault12XQuery/";
declare namespace errorinfo = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
declare namespace soap-env-11 = "http://schemas.xmlsoap.org/soap/envelope/";

declare function xf:TransformarErrorInfoEmSOAPFault12XQuery(
	$messageCode as xs:string,
	$messageText as xs:string,
	$errorInfo as element(errorinfo:ErrorInfo)
   )
    as element(*) {
        <soap-env-11:Fault>
            <faultcode>{ data($messageCode) }</faultcode>
            <faultstring>{ data($messageText) }</faultstring>
            <faultactor>{ data($errorInfo/accessResourceName) }</faultactor>
	         <detail>
	        	<errorinfo:ErrorInfo> 	         
		            <code>{ data($errorInfo/code) }</code>
		            <message>{ data($errorInfo/message) }</message>
		            <exceptionDate>{ data($errorInfo/exceptionDate) }</exceptionDate>
		            <exceptionClassification>{ data($errorInfo/exceptionClassification) }</exceptionClassification>
		            <accessResourceName>{ data($errorInfo/accessResourceName) }</accessResourceName>
		            <additionalInformation>{ $errorInfo/additionalInformation/@* , $errorInfo/additionalInformation/node() }</additionalInformation>
                    <validationMessages>{ $errorInfo/validationMessages/@* , $errorInfo/validationMessages/node() }</validationMessages>
		            <exceptionStackTrace>{ data($errorInfo/exceptionStackTrace) }</exceptionStackTrace>
	        	</errorinfo:ErrorInfo> 
			</detail>
        </soap-env-11:Fault>        
};

declare variable $messageCode as xs:string external;
declare variable $messageText as xs:string external;
declare variable $errorInfo as element(errorinfo:ErrorInfo) external;

xf:TransformarErrorInfoEmSOAPFault12XQuery(
	$messageCode,
	$messageText,
	$errorInfo)