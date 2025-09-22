(:: pragma bea:global-element-parameter parameter="$consultarListaRestricoesContatoProconResponse1" element="ns3:consultarListaRestricoesContatoProconResponse" location="../../wsdl/business/RestricaoContatoProconDSLBSV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:resultadoConsultarTelefoneLeiNaoPerturbe" location="../../wsdl/proxyservice/ProconWSDLV2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/vender/venda/procon/transformation/xquery/ConsultarListaRestricoesContatoProconResponseXQuery2/";
declare namespace ns0 = "http://www.netservicos.com.br/Procon/";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/cliente";
declare namespace ns3 = "ld:br/com/netservicos/venda/procon/logical/RestricaoContatoProconDSL_ws";
declare namespace ns2 = "ld:br/com/netservicos/venda/procon/physical/procon/table/ListaTelefoneProconDSP";

declare function xf:ConsultarListaRestricoesContatoProconResponseXQuery2($consultarListaRestricoesContatoProconResponse1 as element(ns3:consultarListaRestricoesContatoProconResponse))
    as element(ns0:resultadoConsultarTelefoneLeiNaoPerturbe) {
        <ns0:resultadoConsultarTelefoneLeiNaoPerturbe>
            {
                let $listTelefones :=
                for $ListaTelefoneProconDSP in $consultarListaRestricoesContatoProconResponse1/ns2:listaItensTelefoneProcon[1]/ListaTelefoneProconDSP
                return
		            <restricaoContatoProcon>
		                <ns1:restrito>{
			 				if (fn:data($ListaTelefoneProconDSP/ST_BLOQUEIO) eq "B") then
			 					fn:true()
			 				else
			 					fn:false()
		                }</ns1:restrito>
		                {
		                if ($ListaTelefoneProconDSP/DT_ENTRADA/node()) then
		                	<ns1:dataCadastro>{ data($ListaTelefoneProconDSP/DT_ENTRADA) }</ns1:dataCadastro>
		                else ()
		                }
		                {
		                if ($ListaTelefoneProconDSP/DT_RESTRICAO/node()) then
		                	<ns1:dataRestricao>{ data($ListaTelefoneProconDSP/DT_RESTRICAO) }</ns1:dataRestricao>
		                else ()
		                }
		                {
		                 if ($ListaTelefoneProconDSP/SG_UF/node()) then
		                	<ns1:origem>{ 
		                	if (fn:upper-case(fn:data($ListaTelefoneProconDSP/SG_UF)) ne "ABR") then
		                		xs:string("PROCON")
		                	else
		                		data($ListaTelefoneProconDSP/SG_UF)
		                	}</ns1:origem>
		                else ()
		                }
		            </restricaoContatoProcon>                    
		           return
		           if ($listTelefones/node()) then
		           	$listTelefones
		           else 
		           	 <restricaoContatoProcon>
		                <ns1:restrito>{fn:false()}</ns1:restrito>
		             </restricaoContatoProcon>                  
		            
            }
        </ns0:resultadoConsultarTelefoneLeiNaoPerturbe>
};

declare variable $consultarListaRestricoesContatoProconResponse1 as element(ns3:consultarListaRestricoesContatoProconResponse) external;

xf:ConsultarListaRestricoesContatoProconResponseXQuery2($consultarListaRestricoesContatoProconResponse1)
