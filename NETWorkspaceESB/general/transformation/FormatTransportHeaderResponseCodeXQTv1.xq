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

(: Função principal que processa o trace do request :)
(:declare function xf:FormatTransportHeaderResponseCode($body as element(*)) as xs:string {:)
(:  (xf:extractStatus($body)):)
(:};:)

(: Função principal que processa o trace do request :)
declare function xf:FormatTransportHeaderResponseCode($body as element(*)?, $fault as element(*)?) as xs:string {
  let $source := if (not(empty($body)) and lower-case(local-name($body/*[1])) eq 'fault') then $body else $fault
  return
    let $errorCodes := ($source/S11:Fault/faultcode[1][string-length(.) gt 0]/text(), 
                        $source/S12:Fault/S12:Code[1]/S12:Subcode/S12:Value[1][string-length(.) gt 0]/text(),
                        $source//con:errorCode[string-length(.) gt 0][1]/text(), 
                        $source//err:ErrorInfo/code[string-length(.) gt 0][1]/text())
    return
      if (not(empty($errorCodes))) then
        let $esbErrorCode1 := $errorCodes[not(starts-with(., 'BEA-'))][last()]
        return
          if ($esbErrorCode1 ne "") then $esbErrorCode1
          else $errorCodes[last()]
      else
        'NF'
}; 

declare variable $body as element(*)? external;
declare variable $fault as element(*)? external;

xf:FormatTransportHeaderResponseCode($body, $fault)