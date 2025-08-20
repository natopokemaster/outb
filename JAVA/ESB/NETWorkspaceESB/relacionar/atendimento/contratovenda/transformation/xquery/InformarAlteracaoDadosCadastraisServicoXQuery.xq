(:: pragma bea:global-element-parameter parameter="$parametrosAlterarDadoCadastralTitular1" element="ns2:parametrosAlterarDadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:informarAlteracaoDadosCadastraisRequest" location="../../../../cliente/parceiro/wsdl/proxy/InformarAlteracaoDadosCadastrais.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/InformarAlteracaoDadosCadastraisServicoXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/InformarAlteracaoDadosCadastrais/";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns2 = "http://www.netservicos.com.br/ContratoVendaV2/";

declare function xf:InformarAlteracaoDadosCadastraisServicoXQuery($parametrosAlterarDadoCadastralTitular1 as element(ns2:parametrosAlterarDadoCadastralTitular))
    as element(ns0:informarAlteracaoDadosCadastraisRequest) {
        <ns0:informarAlteracaoDadosCadastraisRequest>
            <numeroContrato>{ xs:int( data($parametrosAlterarDadoCadastralTitular1/identificacaoContrato/ns1:Contrato/ns1:NumeroContrato) ) }</numeroContrato>
            <codigoOperadora>{ data($parametrosAlterarDadoCadastralTitular1/identificacaoContrato/ns1:Contrato/ns1:CodigoOperadora) }</codigoOperadora>
            <reenvioMensagem>false</reenvioMensagem>
        </ns0:informarAlteracaoDadosCadastraisRequest>
};

declare variable $parametrosAlterarDadoCadastralTitular1 as element(ns2:parametrosAlterarDadoCadastralTitular) external;

xf:InformarAlteracaoDadosCadastraisServicoXQuery($parametrosAlterarDadoCadastralTitular1)
