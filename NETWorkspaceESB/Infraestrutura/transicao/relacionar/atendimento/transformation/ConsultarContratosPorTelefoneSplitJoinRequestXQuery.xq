(:: pragma bea:global-element-parameter parameter="$consultarContratoPorTelefoneRequest1" element="ns3:consultarContratoPorTelefoneRequest" location="../wsdl/proxy/IdentificarContratos.wsdl" ::)
(:: pragma  parameter="$listaBasesAtivas" type="anyType" ::)
(:: pragma bea:global-element-return element="ns0:identificarContratos" location="../wsdl/business/IdentificarContratoSplitJoin.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/ConsultarContratosPorTelefoneSplitJoinRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/IdentificarContratoSplitJoin/";
declare namespace ns3 = "http://www.netservicos.com.br/IdentificarContratos/";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace m = "http://www.openuri.org/";

declare function xf:ConsultarContratosPorTelefoneSplitJoinRequestXQuery($consultarContratoPorTelefoneRequest1 as element(ns3:consultarContratoPorTelefoneRequest),
    $listaBasesAtivas as element(*))
    as element(ns0:identificarContratos) {
        <ns0:identificarContratos>
            <telefone>{ data($consultarContratoPorTelefoneRequest1/telefone) }</telefone>            
            <bases>
             {
             
	           for $baseAtiva in $listaBasesAtivas/m:return/item
	           return
		       	<baseAtiva>{ data($baseAtiva) }</baseAtiva>
	        }
             	
            </bases>       
        </ns0:identificarContratos>
};

declare variable $consultarContratoPorTelefoneRequest1 as element(ns3:consultarContratoPorTelefoneRequest) external;
declare variable $listaBasesAtivas as element(*) external;

xf:ConsultarContratosPorTelefoneSplitJoinRequestXQuery($consultarContratoPorTelefoneRequest1,
    $listaBasesAtivas)
