(:: pragma bea:global-element-parameter parameter="$identificacaoContratoResponse1" element="ns2:IdentificacaoContratoResponse" location="../../../../../general/NETSMSDatabaseConfig/wsdl/proxy/TransformaIdentificacaoContratoWSDL12V1.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$dadoContatoTitular1" type="ns4:parametrosAlterarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:validarDadoContatoTitular" location="../../wsdl/business/ContratoVendaJWSBSWSDLV1_0.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/ContratoVendaV2/";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/AlterarDadoContatoTitularEmValidarDadoContatoTitularXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/DadoContatoTitular";
declare namespace ns1 = "http://br/com/netservicos/relacionar/atendimento/jws";
declare namespace ns3 = "http://www.netservicos.com.br/IdentificadorContrato";
declare namespace ns2 = "http://www.netservicos.com.br/TransformaIdentificacaoContrato12V1";

declare function xf:AlterarDadoContatoTitularEmValidarDadoContatoTitularXQuery($identificacaoContratoResponse1 as element(ns2:IdentificacaoContratoResponse),
    $dadoContatoTitular1 as element())
    as element(ns1:validarDadoContatoTitular) {
        <ns1:validarDadoContatoTitular>
            <ns3:IdentificadorContrato>
                <NumeroContrato>{ data($identificacaoContratoResponse1/ns2:Contrato/ns2:NumeroContrato) }</NumeroContrato>
                <CodigoOperadora>{ data($identificacaoContratoResponse1/ns2:Contrato/ns2:CodigoOperadora) }</CodigoOperadora>
                <IdentificacaoCidade>{ data($identificacaoContratoResponse1/ns2:Contrato/ns2:IdentificacaoCidade) }</IdentificacaoCidade>
            </ns3:IdentificadorContrato>
            <ns0:DadoContatoTitular>
                <telefonesContato>
                    {
                        for $telefone in $dadoContatoTitular1/telefones/telefone
                        return
                            <telefone>
                                <dddTelefone>{ data($telefone/dddTelefone) }</dddTelefone>
                                <numeroTelefone>{ data($telefone/numeroTelefone) }</numeroTelefone>
                                {
                                    for $ramal in $telefone/ramal
                                    return
                                        <ramal>{ data($ramal) }</ramal>
                                }
                                <tipoTelefone>{ fn:upper-case(data($telefone/tipoTelefone)) }</tipoTelefone>
                            </telefone>
                    }
                </telefonesContato>
                {
                    for $email in $dadoContatoTitular1/email
                    return
                        <email>{ $email/@* , $email/node() }</email>
                }
            </ns0:DadoContatoTitular>
        </ns1:validarDadoContatoTitular>
};

declare variable $identificacaoContratoResponse1 as element(ns2:IdentificacaoContratoResponse) external;
declare variable $dadoContatoTitular1 as element() external;

xf:AlterarDadoContatoTitularEmValidarDadoContatoTitularXQuery($identificacaoContratoResponse1,
    $dadoContatoTitular1)
