(:: pragma bea:global-element-parameter parameter="$parametrosAlterarDadoContatoTitular1" element="ns1:parametrosAlterarDadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:IdentificacaoContrato" location="../../../../../modelocanonicoV2/geral/IdentificacaoContrato.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/AlterarDadoContatoTitularXIdentificaContratoXQeury/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns1 = "http://www.netservicos.com.br/ContratoVendaV2/";

declare function xf:AlterarDadoContatoTitularXIdentificaContratoXQeury($parametrosAlterarDadoContatoTitular1 as element(ns1:parametrosAlterarDadoContatoTitular))
    as element(ns0:IdentificacaoContrato) {
        let $identificacaoContrato := $parametrosAlterarDadoContatoTitular1/identificacaoContrato
        return
             <ns0:IdentificacaoContrato>
            	{ $identificacaoContrato/node() }
            </ns0:IdentificacaoContrato>
};

declare variable $parametrosAlterarDadoContatoTitular1 as element(ns1:parametrosAlterarDadoContatoTitular) external;

xf:AlterarDadoContatoTitularXIdentificaContratoXQeury($parametrosAlterarDadoContatoTitular1)
