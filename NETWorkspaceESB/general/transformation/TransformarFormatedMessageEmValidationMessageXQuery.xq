(:: pragma bea:global-element-parameter parameter="$formatedMessage1" element="ns0:formatedMessage" location="../NETLog/wsdl/proxy/MessageUtilWSDL12.wsdl" ::)
(:: pragma bea:local-element-complex-return type="ns1:ValidationMessagesType/validationMessage" location="../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)

declare namespace xf = "http://tempuri.org/general/NETESBExceptionHandler/transformation/TransformarFormatedMessageEmValidationMessageXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/MessageUtil";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";
declare namespace ns2 = "http://netservicos.com.br/core/schema";

declare function xf:TransformarFormatedMessageEmValidationMessageXQuery($formatedMessage1 as element(ns0:formatedMessage))
    as element() {
        <validationMessage>
            <code>{ data($formatedMessage1/ns2:Message/ns2:ID_MSG) }</code>
            <message>{ data($formatedMessage1/ns2:Message/ns2:MENSAGEM_USUARIO) }</message>
        </validationMessage>
};

declare variable $formatedMessage1 as element(ns0:formatedMessage) external;

xf:TransformarFormatedMessageEmValidationMessageXQuery($formatedMessage1)