(:: pragma bea:global-element-parameter parameter="$consultarContratoPorDocumentoRequest1" element="ns3:consultarContratoPorDocumentoRequest" location="../wsdl/proxy/IdentificarContratos.wsdl" ::)
(:: pragma  parameter="$listaBasesAtivas" type="anyType" ::)
(:: pragma bea:global-element-return element="ns0:identificarContratos" location="../wsdl/business/IdentificarContratoSplitJoin.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/RTRTRRTRTRT/";
declare namespace ns0 = "http://www.netservicos.com.br/IdentificarContratoSplitJoin/";
declare namespace ns3 = "http://www.netservicos.com.br/IdentificarContratos/";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace m = "http://www.openuri.org/";

declare function xf:ConsultarContratosSplitJoinRequestXQuery($consultarContratoPorDocumentoRequest1 as element(ns3:consultarContratoPorDocumentoRequest),
    $listaBasesAtivas as element(*))
    as element(ns0:identificarContratos) {
        <ns0:identificarContratos>                  
             <cpf>{ data($consultarContratoPorDocumentoRequest1/documento) }</cpf>                
        	 <bases>
             {
             
	           for $baseAtiva in $listaBasesAtivas/m:return/item
	           return
		       	<baseAtiva>{ data($baseAtiva) }</baseAtiva>
	        }                         
         </bases>    
            
        </ns0:identificarContratos>
                              
};

declare variable $consultarContratoPorDocumentoRequest1 as element(ns3:consultarContratoPorDocumentoRequest) external;
declare variable $listaBasesAtivas as element(*) external;

xf:ConsultarContratosSplitJoinRequestXQuery($consultarContratoPorDocumentoRequest1,
    $listaBasesAtivas)
