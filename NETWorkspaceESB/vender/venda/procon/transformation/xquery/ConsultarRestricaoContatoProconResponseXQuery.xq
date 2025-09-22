(:: pragma bea:global-element-parameter parameter="$consultarRestricaoContatoProconResponse1" element="ns3:consultarRestricaoContatoProconResponse" location="../../wsdl/business/RestricaoContatoProconDSLBSV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:resultadoConsultarTelefoneLeiNaoPerturbe" location="../../wsdl/proxyservice/ProconWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/vender/venda/procon/transformation/xquery/ConsultarRestricaoContatoProconResponseXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/Procon/";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/cliente";
declare namespace ns3 = "ld:br/com/netservicos/venda/procon/logical/RestricaoContatoProconDSL_ws";
declare namespace ns2 = "ld:br/com/netservicos/venda/procon/physical/procon/table/ListaTelefoneProconDSP";

declare function xf:ConsultarRestricaoContatoProconResponseXQuery($consultarRestricaoContatoProconResponse1 as element(ns3:consultarRestricaoContatoProconResponse))
    as element(ns0:resultadoConsultarTelefoneLeiNaoPerturbe) {
        <ns0:resultadoConsultarTelefoneLeiNaoPerturbe>
            <restricaoContatoProcon>
                <ns1:restrito>{
	 				if (fn:data($consultarRestricaoContatoProconResponse1/ns2:ListaTelefoneProconDSP/ST_BLOQUEIO) eq "B") then
	 					fn:true()
	 				else
	 					fn:false()
                }</ns1:restrito>
                {
                if ($consultarRestricaoContatoProconResponse1/ns2:ListaTelefoneProconDSP/DT_ENTRADA/node()) then
                	<ns1:dataCadastro>{ data($consultarRestricaoContatoProconResponse1/ns2:ListaTelefoneProconDSP/DT_ENTRADA) }</ns1:dataCadastro>
                else ()
                }
                {
                if ($consultarRestricaoContatoProconResponse1/ns2:ListaTelefoneProconDSP/DT_RESTRICAO/node()) then
                	<ns1:dataRestricao>{ data($consultarRestricaoContatoProconResponse1/ns2:ListaTelefoneProconDSP/DT_RESTRICAO) }</ns1:dataRestricao>
                else ()
                }
                {
                 if ($consultarRestricaoContatoProconResponse1/ns2:ListaTelefoneProconDSP/SG_UF/node()) then
                	<ns1:origem>{ 
		                	if (fn:upper-case(fn:data($consultarRestricaoContatoProconResponse1/ns2:ListaTelefoneProconDSP/SG_UF)) ne "ABR") then
		                		xs:string("PROCON")
		                	else
		                		data($consultarRestricaoContatoProconResponse1/ns2:ListaTelefoneProconDSP/SG_UF)
		            }</ns1:origem>
                else ()
                }
            </restricaoContatoProcon>
        </ns0:resultadoConsultarTelefoneLeiNaoPerturbe>
};

declare variable $consultarRestricaoContatoProconResponse1 as element(ns3:consultarRestricaoContatoProconResponse) external;

xf:ConsultarRestricaoContatoProconResponseXQuery($consultarRestricaoContatoProconResponse1)
