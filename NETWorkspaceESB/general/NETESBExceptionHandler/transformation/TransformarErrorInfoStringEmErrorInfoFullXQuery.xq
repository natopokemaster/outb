(:: pragma  parameter="$elemErrorInfoString" type="anyType" ::)
(:: pragma  type="anyType" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETESBExceptionHandler/transformation/TransformarErrorInfoStringEmErrorInfoFullXQuery/";
declare namespace err = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";

declare function xf:teste($elemErrorInfoString as element(*))
    as element(*) {
       fn-bea:inlinedXML(
         fn:concat(
                   '<err:ErrorInfo'
		           ,fn:substring-before(
		                 fn:substring-after($elemErrorInfoString
		                                    ,'<err:ErrorInfo')
		                                ,'</err:ErrorInfo>')
                   ,'</err:ErrorInfo>'))
};

declare variable $elemErrorInfoString as element(*) external;

xf:teste($elemErrorInfoString)