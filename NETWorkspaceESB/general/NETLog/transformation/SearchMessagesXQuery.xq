xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$messages" element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)
(:: pragma bea:global-element-return element="ns0:Messages" location="../../../modelocanonicoV2/geral/Message.xsd" ::)

declare namespace xf = "http://tempuri.org/general/NETLog/transformation/SearchMessagesXQuery/";
declare namespace ns0 = "http://netservicos.com.br/core/schema";

declare function xf:SearchMessagesXQuery($messages as element(ns0:Messages),
    $messageCode as xs:string)
    as element(ns0:Messages) {
        <ns0:Messages>
            {
                for $MensagemRow in $messages/ns0:Message[ns0:ID_MSG = $messageCode]
                return
                    <ns0:Message>{ $MensagemRow/@* , $MensagemRow/node() }</ns0:Message>
            }
        </ns0:Messages>
};

declare variable $messages as element(ns0:Messages) external;
declare variable $messageCode as xs:string external;

xf:SearchMessagesXQuery($messages,
    $messageCode)