(:: pragma bea:global-element-parameter parameter="$identificacaoContratoResponse1" element="ns3:IdentificacaoContratoResponse" location="../../../../../general/NETSMSDatabaseConfig/wsdl/proxy/TransformaIdentificacaoContratoWSDL12V1.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$dadoContatoTitular1" type="ns5:parametrosAlterarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$registroContato1" type="ns5:parametrosAlterarDadoContatoTitular/registroContato" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns2:alterarDadoContatoTitular" location="../../wsdl/business/ContratoVendaJWSBSWSDLV1_0.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/IdentificadorContrato";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/AlterarDadoContatoTitularXAlterarDadoContatoWLIXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/DadoContatoTitular";
declare namespace ns1 = "http://www.netservicos.com.br/RegistroContato";
declare namespace ns3 = "http://www.netservicos.com.br/TransformaIdentificacaoContrato12V1";
declare namespace ns2 = "http://br/com/netservicos/relacionar/atendimento/jws";
declare namespace ns5 = "http://www.netservicos.com.br/ContratoVendaV2/";

declare function xf:AlterarDadoContatoTitularXAlterarDadoContatoWLIXQuery($identificacaoContratoResponse1 as element(ns3:IdentificacaoContratoResponse),
    $dadoContatoTitular1 as element(),
    $registroContato1 as element())
    as element(ns2:alterarDadoContatoTitular) {
        <ns2:alterarDadoContatoTitular>
            <ns4:IdentificadorContrato>
                <NumeroContrato>{ data($identificacaoContratoResponse1/ns3:Contrato/ns3:NumeroContrato) }</NumeroContrato>
                <CodigoOperadora>{ data($identificacaoContratoResponse1/ns3:Contrato/ns3:CodigoOperadora) }</CodigoOperadora>
                <IdentificacaoCidade>{ data($identificacaoContratoResponse1/ns3:Contrato/ns3:IdentificacaoCidade) }</IdentificacaoCidade>
            </ns4:IdentificadorContrato>
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
            {
                let $registroContato := $registroContato1
                return
                    <ns1:registroContato>
                        {
                            for $nomeContato in $registroContato/nomeContato
                            return
                                <nomeContato>{ data($nomeContato) }</nomeContato>
                        }
                        {
                            for $telefoneContato in $registroContato/telefoneContato
                            return
                                <telefoneContato>{ $telefoneContato/@* , $telefoneContato/node() }</telefoneContato>
                        }
                        {
                            for $observacao in $registroContato/observacao
                            return
                                <observacao>{ data($observacao) }</observacao>
                        }
                    </ns1:registroContato>
            }
        </ns2:alterarDadoContatoTitular>
};

declare variable $identificacaoContratoResponse1 as element(ns3:IdentificacaoContratoResponse) external;
declare variable $dadoContatoTitular1 as element() external;
declare variable $registroContato1 as element() external;

xf:AlterarDadoContatoTitularXAlterarDadoContatoWLIXQuery($identificacaoContratoResponse1,
    $dadoContatoTitular1,
    $registroContato1)
