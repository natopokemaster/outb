xquery version "1.0" encoding "Cp1252";
(:: pragma  parameter="$validationFailure" type="xs:anyType" ::)

declare namespace xf = "http://tempuri.org/general/transformation/TransformarValidationFailureEmFaultReason/";
declare namespace con1= "http://www.bea.com/wli/sb/stages/transform/config";

declare function xf:TransformarValidationFailureEmFaultReason($validationFailure as element(*))
    as xs:string {
        fn:string-join((for $message in $validationFailure/con1:message return fn:data($message)), '&#xA;')
};

declare variable $validationFailure as element(*) external;

xf:TransformarValidationFailureEmFaultReason($validationFailure)
