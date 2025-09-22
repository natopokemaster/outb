(:: pragma bea:global-element-parameter parameter="$identificarContratoRequest1" element="ns0:identificarContratoRequest" location="../wsdl/business/IdentificarContratos11V1.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarContratoPorDocumentoRequest" location="../wsdl/proxy/IdentificarContratos.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/identificarContratosPorDocumentoXQuery/";
declare namespace ns0 = "http://www.openuri.org/";
declare namespace ns1 = "http://www.netservicos.com.br/IdentificarContratos/";

declare function xf:identificarContratosPorDocumentoXQuery($identificarContratoRequest1 as element(ns0:identificarContratoRequest))
    as element(ns1:consultarContratoPorDocumentoRequest) {
        <ns1:consultarContratoPorDocumentoRequest>
            <documento>{ data($identificarContratoRequest1/ns0:CPF_CNPJ) }</documento>
        </ns1:consultarContratoPorDocumentoRequest>
};

declare variable $identificarContratoRequest1 as element(ns0:identificarContratoRequest) external;

xf:identificarContratosPorDocumentoXQuery($identificarContratoRequest1)
