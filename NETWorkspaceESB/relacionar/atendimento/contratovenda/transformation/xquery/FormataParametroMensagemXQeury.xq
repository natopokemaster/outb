(:: pragma bea:global-element-return element="ns0:logMessage" location="../../../../../general/NETLog/wsdl/proxy/MessageUtilWSDL12.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/FormataParametroMensagemXQeury/";
declare namespace ns0 = "http://www.netservicos.com.br/MessageUtil";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/logging";

declare function xf:FormataParametroMensagemXQeury($parametros as xs:string, 
$processo as xs:string,
$macroProcesso as xs:string,
$codigoErro as xs:string)
    as element(ns0:logMessage) {
        <ns0:logMessage>
        	<ns0:messageCode>{fn:data($codigoErro)}</ns0:messageCode>
            <ns0:messageParameters>
            { 
            	let $lista:= fn:tokenize($parametros,",")
	            for $item in $lista
	            return
                <ns1:value>{fn:data($item)}</ns1:value>
               }
            </ns0:messageParameters>
           	<ns0:macroProcesso>{fn:data($macroProcesso)}</ns0:macroProcesso>
       		<ns0:processo>{fn:data($processo)}</ns0:processo>
        </ns0:logMessage>
        
};

declare variable $parametros as xs:string external;
declare variable $processo as xs:string external;
declare variable $macroProcesso as xs:string external;
declare variable $codigoErro as xs:string external;

xf:FormataParametroMensagemXQeury($parametros, $processo,
$macroProcesso,
$codigoErro)

