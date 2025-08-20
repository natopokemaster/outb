(:: pragma bea:global-element-parameter parameter="$parametrosValidarDadoContatoTitular1" element="ns1:parametrosValidarDadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:IdentificacaoContrato" location="../../../../../modelocanonicoV2/geral/IdentificacaoContrato.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ValidarDadosContatoIdentificaContratoXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns1 = "http://www.netservicos.com.br/ContratoVendaV2/";

declare function xf:ValidarDadosContatoIdentificaContratoXQuery($parametrosValidarDadoContatoTitular1 as element(ns1:parametrosValidarDadoContatoTitular))
    as element(ns0:IdentificacaoContrato) {
        let $identificacaoContrato := $parametrosValidarDadoContatoTitular1/identificacaoContrato
        return
            <ns0:IdentificacaoContrato>
            	{ $identificacaoContrato/node() }
            </ns0:IdentificacaoContrato>
};

declare variable $parametrosValidarDadoContatoTitular1 as element(ns1:parametrosValidarDadoContatoTitular) external;

xf:ValidarDadosContatoIdentificaContratoXQuery($parametrosValidarDadoContatoTitular1)
