(:: pragma bea:global-element-parameter parameter="$parametrosListar1" element="ns2:parametrosListar" location="../../wsdl/proxy/ClienteClaroWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-parameter parameter="$netHeader1" element="ns6:NetHeader" location="../../../../../modelocanonicoV2/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-return element="ns0:ListarAssinantesRequest" location="../../wsdl/business/ESB/Claro/ListarAssinantes/v1/ListarAssinantesv1.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/cliente/clienteclaro/transformation/xquery/TransformarListarAssinantesRequestXQuery/";
declare namespace ns0 = "http://www.claro.com.br/EBS/Claro/v1";
declare namespace ns1 = "http://www.claro.com.br/EBO/Claro/v1";
declare namespace ns2 = "http://www.netservicos.com.br/ClienteClaro";
declare namespace ns3 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:TransformarListarAssinantesRequestXQuery($parametrosListar1 as element(ns2:parametrosListar), $netHeader1 as element(ns3:NetHeader))
    as element(ns0:ListarAssinantesRequest) {
        <ns0:ListarAssinantesRequest>
            <ns0:cliente>
            	{
                	if (data($parametrosListar1/ns2:cpf) ne '')then
		                <ns1:dados-cadastrais-pf>
	    	                <ns1:cpf>{ data($parametrosListar1/ns2:cpf) }</ns1:cpf>
	        	        </ns1:dados-cadastrais-pf>
        	        else()
                }
                {
                	if (data($parametrosListar1/ns2:cnpj) ne '')then
		                <ns1:dados-cadastrais-pj>
		                    <ns1:cnpj>{ data($parametrosListar1/ns2:cnpj) }</ns1:cnpj>
		                </ns1:dados-cadastrais-pj>
        	        else()
                }
				{
                	if (data($parametrosListar1/ns2:mobileBan) ne '')then
		                <ns1:accounts>
		                    <ns1:account>
		                        <ns1:mobile-ban>{ data($parametrosListar1/ns2:mobileBan) }</ns1:mobile-ban>
		                    </ns1:account>
		                </ns1:accounts>
		            else()
				}
            </ns0:cliente>
            {
                if(data($parametrosListar1/ns2:paginacao/ns2:quantidadeTotalPagina) ne '')then
                    <ns0:tamanho-pagina>{ data($parametrosListar1/ns2:paginacao/ns2:quantidadeTotalPagina) }</ns0:tamanho-pagina>               
                else()
            }
            {
                if(data($parametrosListar1/ns2:paginacao/ns2:numeroPaginaAtual) ne '')then
                    <ns0:pagina>{ data($parametrosListar1/ns2:paginacao/ns2:numeroPaginaAtual) }</ns0:pagina>               
                else()
            }
            <ns0:meta-informacao>
                <ns1:codigo-aplicacao-origem>{data($netHeader1/aplicacao)}</ns1:codigo-aplicacao-origem>
                <ns1:codigo-operacao-origem>{data('CLIENTE_CLARO')}</ns1:codigo-operacao-origem>
                <ns1:correlacao-id-origem>{data($netHeader1/token)}</ns1:correlacao-id-origem>
                <ns1:endereco-aplicacao-origem>{data('NET_SERVICOS')}</ns1:endereco-aplicacao-origem>
                <ns1:usuario-id-origem>{data($netHeader1/username)}</ns1:usuario-id-origem>
                <ns1:data-hora-origem>{xs:dateTime( fn:current-dateTime())}</ns1:data-hora-origem>
                <ns1:canal-id-origem>{data($netHeader1/aplicacao)}</ns1:canal-id-origem>
            </ns0:meta-informacao>
        </ns0:ListarAssinantesRequest>
};

declare variable $parametrosListar1 as element(ns2:parametrosListar) external;
declare variable $netHeader1 as element(ns3:NetHeader) external;

xf:TransformarListarAssinantesRequestXQuery($parametrosListar1, $netHeader1)
