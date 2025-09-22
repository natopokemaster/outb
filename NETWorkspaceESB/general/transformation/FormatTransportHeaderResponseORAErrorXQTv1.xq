xquery version "2004-draft" encoding "Cp1252";
(:: pragma  parameter="$body" type="xs:anyType" ::)
(:: pragma  parameter="$fault" type="xs:anyType" ::)

  declare namespace xf   = "http://tempuri.org/general/TransportHeader/Transformation/FormatTransportHeaderResponseCodeXQTv1/";
  declare namespace con  = "http://www.bea.com/wli/sb/context";
  declare namespace err="http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
  declare namespace S11="http://schemas.xmlsoap.org/soap/envelope/";
  declare namespace S12="http://www.w3.org/2003/05/soap-envelope";

(: Função que extrai a situacao da mensagem de saída :)
(:declare function xf:extractStatus($msg as element(*)) as xs:string {:)
(:	data($msg//*//con:errorCode):)
(:};:)

(: Função principal  que processa o trace do request :)
(:declare function xf:FormatTransportHeaderResponseCode($body as element(*)) as xs:string {:)
(:  (xf:extractStatus($body)):)
(:};:)

(: Função principal que processa o trace do request :)
declare function xf:FormatTransportHeaderResponseCode($body as element(*)?, $fault as element(*)?) as xs:string {
      if (fn:contains($body, 'ORA-')) then
        concat('ORA-',substring(substring-after($body, 'ORA-'),1,5))
      else if (fn:contains($fault, 'ORA-')) then
		concat('ORA-',substring(substring-after($fault, 'ORA-'),1,5))
	  else
	  	'NF'
};


    					

declare variable $body as element(*)? external;
declare variable $fault as element(*)? external;

xf:FormatTransportHeaderResponseCode($body, $fault)