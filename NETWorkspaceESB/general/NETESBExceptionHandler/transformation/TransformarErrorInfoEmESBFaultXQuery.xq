(:: pragma bea:global-element-parameter parameter="$errorInfo" element="errorinfo:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)
(:: pragma  type="anyType" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETESBExceptionHandler/transformation/TransformarErrorInfoEmESBFaultXQuery/";
declare namespace errorinfo = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
declare namespace ctx = "http://www.bea.com/wli/sb/context";

declare function TransformarErrorInfoEmESBFaultXQuery(
	$messageCode as xs:string,
	$messageText as xs:string,
	$errorInfo as element(errorinfo:ErrorInfo),
    $customLocation as element(*)?)
    as element(*) {
		<ctx:fault>
		   <ctx:errorCode>{ data($messageCode) }</ctx:errorCode>
		   <ctx:reason>{ data($messageText) }</ctx:reason>
		   <ctx:details>{ $errorInfo }</ctx:details>
		   <ctx:location>
		      <ctx:node>{data($customLocation//ctx:node)}</ctx:node>
		      <ctx:pipeline>{data($customLocation//ctx:pipeline)}</ctx:pipeline>
		      <ctx:stage>{data($customLocation//ctx:stage)}</ctx:stage>
			  {if (not(empty(data($customLocation//ctx:path))) ) then (
		      <ctx:path>{data($customLocation//ctx:path)}</ctx:path>
		      ) else () }
		   </ctx:location>
		</ctx:fault>
		
			  		
};

declare variable $messageCode as xs:string external;
declare variable $messageText as xs:string external;
declare variable $errorInfo as element(errorinfo:ErrorInfo) external;
declare variable $customLocation as element(*)? external;

TransformarErrorInfoEmESBFaultXQuery(
	$messageCode,
	$messageText,
	$errorInfo,
	$customLocation)