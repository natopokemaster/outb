xquery version "1.0" encoding "Cp1252";
(:: pragma  parameter="$localFault" type="xs:anyType" ::)
(:: pragma  type="xs:anyType" ::)

declare namespace xf = "http://tempuri.org/general/NETESBExceptionHandler/transformation/TransformarLocationFromFaultEmLocationXQuery/";
declare namespace ctx = "http://www.bea.com/wli/sb/context";

declare function xf:TransformarLocationFromFaultEmLocationXQuery($localFault as element(*))
    as element(*) {
		   <ctx:location>
		      <ctx:node>{data($localFault//ctx:location/ctx:node)[1]}</ctx:node>
		      <ctx:pipeline>{data($localFault//ctx:location/ctx:pipeline)[1]}</ctx:pipeline>
		      <ctx:stage>{data($localFault//ctx:location/ctx:stage)[1]}</ctx:stage>
			  {if (not(empty(data($localFault//ctx:location/ctx:path)[1])) ) then (
		      <ctx:path>{data($localFault//ctx:location/ctx:path)[1]}</ctx:path>
		      ) else () }
		   </ctx:location>
};

declare variable $localFault as element(*) external;

xf:TransformarLocationFromFaultEmLocationXQuery($localFault)