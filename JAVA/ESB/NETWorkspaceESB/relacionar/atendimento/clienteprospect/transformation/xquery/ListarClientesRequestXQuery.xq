(:: pragma bea:global-element-parameter parameter="$parametrosListarClientes1" element="ns1:parametrosListarClientes" location="../../wsdl/proxy/ClienteProspectWSDLV1_0.wsdl" ::)
(:: pragma  parameter="$listaBasesAtivas" type="anyType" ::)
(:: pragma bea:global-element-return element="ns0:parametrosListarClientes" location="../../wsdl/proxy/ClienteProspectSJWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/clienteprospect/transformation/xquery/ListarClientesRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ClienteProspectSJ/";
declare namespace ns1 = "http://www.netservicos.com.br/ClienteProspect/";
declare namespace m = "http://www.openuri.org/";

declare function xf:ListarClientesRequestXQuery($parametrosListarClientes1 as element(ns1:parametrosListarClientes),
    $listaBasesAtivas as element(*))
    as element(ns0:parametrosListarClientes) {
        <ns0:parametrosListarClientes>
            <ns0:CPF>{ data($parametrosListarClientes1/CPF) }</ns0:CPF>
            <ns0:CNPJ>{ data($parametrosListarClientes1/CNPJ) }</ns0:CNPJ>
            {
                let $telefoneContato := $parametrosListarClientes1/telefoneContato
                return
                    <ns0:telefoneContato>
                        <ns0:DDD>{ data($telefoneContato/DDD) }</ns0:DDD>
                        <ns0:numeroTelefone>{ data($telefoneContato/numeroTelefone) }</ns0:numeroTelefone>
                    </ns0:telefoneContato>
            }
            <ns0:basesPesquisa>
	        {
	           for $baseAtiva in $listaBasesAtivas/m:return/item
	           return
		       	<ns0:aliasDatabase>{ data($baseAtiva) }</ns0:aliasDatabase>
	        }
	        </ns0:basesPesquisa>
            
        </ns0:parametrosListarClientes>
};

declare variable $parametrosListarClientes1 as element(ns1:parametrosListarClientes) external;
declare variable $listaBasesAtivas as element(*) external;

xf:ListarClientesRequestXQuery($parametrosListarClientes1,
    $listaBasesAtivas)
