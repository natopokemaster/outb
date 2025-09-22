(:: pragma bea:global-element-parameter parameter="$listarContratosPorDocumentoRequest1" element="ns1:listarContratosPorDocumentoRequest" location="../wsdl/proxy/ListarContratos.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:identificarContratosPorDocumento" location="../wsdl/business/IdentificarContratosDSL.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/IdentificarContratoPorDocumentoRequestXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/atendimento/webservice/IdentificarContratosJWS.ws";
declare namespace ns1 = "http://www.netservicos.com.br/ListarContratos/";

declare function xf:IdentificarContratoPorDocumentoRequestXQuery($listarContratosPorDocumentoRequest1 as element(ns1:listarContratosPorDocumentoRequest))
    as element(ns0:identificarContratosPorDocumento) {
        <ns0:identificarContratosPorDocumento>
            <ns0:documento>{ data($listarContratosPorDocumentoRequest1/documento) }</ns0:documento>
        </ns0:identificarContratosPorDocumento>
};

declare variable $listarContratosPorDocumentoRequest1 as element(ns1:listarContratosPorDocumentoRequest) external;

xf:IdentificarContratoPorDocumentoRequestXQuery($listarContratosPorDocumentoRequest1)
