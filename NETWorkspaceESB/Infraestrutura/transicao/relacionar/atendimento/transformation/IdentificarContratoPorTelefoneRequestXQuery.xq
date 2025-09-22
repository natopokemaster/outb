(:: pragma bea:global-element-parameter parameter="$listarContratosPorTelefoneRequest1" element="ns1:listarContratosPorTelefoneRequest" location="../wsdl/proxy/ListarContratos.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:identificarContratosPorTelefone" location="../wsdl/business/IdentificarContratosDSL.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/IdentificarContratoPorTelefoneRequestXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/atendimento/webservice/IdentificarContratosJWS.ws";
declare namespace ns1 = "http://www.netservicos.com.br/ListarContratos/";

declare function xf:IdentificarContratoPorTelefoneRequestXQuery($listarContratosPorTelefoneRequest1 as element(ns1:listarContratosPorTelefoneRequest))
    as element(ns0:identificarContratosPorTelefone) {
        <ns0:identificarContratosPorTelefone>
            <ns0:telefone>{ data($listarContratosPorTelefoneRequest1/telefone) }</ns0:telefone>
        </ns0:identificarContratosPorTelefone>
};

declare variable $listarContratosPorTelefoneRequest1 as element(ns1:listarContratosPorTelefoneRequest) external;

xf:IdentificarContratoPorTelefoneRequestXQuery($listarContratosPorTelefoneRequest1)
