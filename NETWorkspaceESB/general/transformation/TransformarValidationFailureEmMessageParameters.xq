xquery version "1.0" encoding "Cp1252";
(:: pragma  parameter="$validationFailure" type="xs:anyType" ::)
(:: pragma bea:global-element-return element="ns0:MessageParameters" location="../../modelocanonicoV2/geral/Logging.xsd" ::)

declare namespace xf = "http://tempuri.org/general/transformation/TransformarValidationFailureEmMessageParameters/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/logging";
declare namespace con1= "http://www.bea.com/wli/sb/stages/transform/config";

declare function xf:TransformarValidationFailureEmMessageParameters($validationFailure as element(*))
    as element(ns0:MessageParameters) {
        <ns0:MessageParameters>
        	<ns0:value>{ fn:string-join((for $message in $validationFailure/con1:message return fn:data($message)), '&#xA;') }</ns0:value>
        </ns0:MessageParameters>
};

declare variable $validationFailure as element(*) external;

xf:TransformarValidationFailureEmMessageParameters($validationFailure)
