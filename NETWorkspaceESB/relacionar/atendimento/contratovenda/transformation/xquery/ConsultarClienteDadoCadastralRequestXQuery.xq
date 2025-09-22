(:: pragma bea:global-element-parameter parameter="$identificacaoContratoResponse1" element="ns0:IdentificacaoContratoResponse" location="../../../../../general/NETSMSDatabaseConfig/wsdl/proxy/TransformaIdentificacaoContratoWSDL12V1.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:consultarClientePorContrato" location="../../../clienteprospect/wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ConsultarClienteDadoCadastralRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/TransformaIdentificacaoContrato12V1";
declare namespace ns1 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";

declare function xf:ConsultarClienteDadoCadastralRequestXQuery($identificacaoContratoResponse1 as element(ns0:IdentificacaoContratoResponse))
    as element(ns1:consultarClientePorContrato) {
        <ns1:consultarClientePorContrato>
            <ns1:numeroContrato>{ data($identificacaoContratoResponse1/ns0:Contrato/ns0:NumeroContrato) }</ns1:numeroContrato>
            <ns1:identificacaoCidade>{ data($identificacaoContratoResponse1/ns0:Contrato/ns0:IdentificacaoCidade) }</ns1:identificacaoCidade>
        </ns1:consultarClientePorContrato>
};

declare variable $identificacaoContratoResponse1 as element(ns0:IdentificacaoContratoResponse) external;

xf:ConsultarClienteDadoCadastralRequestXQuery($identificacaoContratoResponse1)
