(:: pragma bea:global-element-parameter parameter="$errorInfo" element="ns1:ErrorInfo" location="../../../modelocanonicoV2/geral/ErrorInfo.xsd" ::)
(:: pragma bea:global-element-return element="ns0:NETFault" location="../../../modelocanonicoV2/geral/NETFault.xsd" ::)

declare namespace xf = "http://www.netservicos.com.br/general/NETLog/transformation/TransformarErrorInfoEmNETFault/";
declare namespace netfault = "http://www.netservicos.com.br/modelocanonico/v2/netfault";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/errorinfo";

declare function xf:TransformarErrorInfoEmNETFault($errorInfo as element(ns1:ErrorInfo))
    as element(netfault:NETFault) {
        <netfault:NETFault>
            <netfault:Code>
                <netfault:Value>{data('soap:Receiver')}</netfault:Value>
                <netfault:Subcode>
                    <netfault:Value>{ xs:QName( data($errorInfo/code) ) }</netfault:Value>
                </netfault:Subcode>
            </netfault:Code>
            <netfault:Reason>
                <netfault:Text>{ data($errorInfo/message) }</netfault:Text>
            </netfault:Reason>
            <netfault:Detail>
                <netfault:errorInfo>
                    <code>{ data($errorInfo/code) }</code>
                    <message>{ data($errorInfo/message) }</message>
                    <exceptionDate>{ data($errorInfo/exceptionDate) }</exceptionDate>
                    <exceptionClassification>{ data($errorInfo/exceptionClassification) }</exceptionClassification>
                    <accessResourceName>{ data($errorInfo/accessResourceName) }</accessResourceName>
                    <additionalInformation>{ $errorInfo/additionalInformation/@* , $errorInfo/additionalInformation/node() }</additionalInformation>
                    <validationMessages>{ $errorInfo/validationMessages/@* , $errorInfo/validationMessages/node() }</validationMessages>
                    <exceptionStackTrace>{ data($errorInfo/exceptionStackTrace) }</exceptionStackTrace>
                </netfault:errorInfo>
            </netfault:Detail>
        </netfault:NETFault>
};

declare variable $errorInfo as element(ns1:ErrorInfo) external;

xf:TransformarErrorInfoEmNETFault($errorInfo)