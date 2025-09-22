xquery version "1.0" encoding "Cp1252";
(:: pragma  parameter="$fault" type="xs:anyType" ::)
(:: pragma  type="xs:anyType" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/rede/outage/transformation/TransformarFaultEmSoapFault12/";
declare namespace soap12-env="http://www.w3.org/2003/05/soap-envelope";
declare namespace ctx="http://www.bea.com/wli/sb/context";
declare namespace cfg="http://www.bea.com/wli/sb/stages/transform/config";

declare function xf:TransformarFaultEmSoapFault12($fault as element(ctx:fault))
    as element(*) {
        <soap12-env:Body>
			<soap12-env:Fault>
				<soap12-env:Code>
					<soap12-env:Value>{data($fault/ctx:errorCode)}</soap12-env:Value>
					<soap12-env:Subcode>
						<soap12-env:Value>
							{
								for $token in fn:tokenize(fn:replace(data($fault/ctx:details/cfg:ReceivedFaultDetail/cfg:faultstring), "[\[\]]", "#"),"#")
								return 
									if (fn:starts-with($token, "WLI") or fn:starts-with($token, "DSP")) then
										$token
									else ()
							}
						</soap12-env:Value>
					</soap12-env:Subcode>
				</soap12-env:Code>
				<soap12-env:Reason>
					<soap12-env:Text xml:lang="pt">
						{
							fn:data($fault/ctx:details/cfg:ReceivedFaultDetail/cfg:faultstring)
						}
					</soap12-env:Text>
				</soap12-env:Reason>
				<soap12-env:Node>
					{
						$fault/ctx:location
					}
				</soap12-env:Node>
				<soap12-env:Detail>
					{if (fn:string-length(data($fault/ctx:details/cfg:ReceivedFaultDetail/cfg:detail)) > 0) then 
						fn:data($fault/ctx:details/cfg:ReceivedFaultDetail/cfg:detail)
					 else
					 	fn:data(fn:concat($fault/ctx:errorCode, ': ', $fault/ctx:reason, ': ', $fault/ctx:details))}
				</soap12-env:Detail>
			</soap12-env:Fault>
		</soap12-env:Body>
};

declare variable $fault as element(*) external;

xf:TransformarFaultEmSoapFault12($fault)