(:: pragma bea:local-element-parameter parameter="$dadoCobrancaRegistroType1" type="ns1:alterarResponse/ns1:DadoCobrancaRegistroType" location="../wsdl/business/DadoCobrancaBSWLIWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:RegistroContato" location="../../../../modelocanonicoV2/evento/Evento.xsd" ::)

declare namespace xf = "http://tempuri.org/relacionar/cliente/dadocobranca/transformation/TransformarRetornoEmEventoXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns1 = "http://br/com/netservicos/relacionar/cliente/jws";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";
declare namespace ns2 = "http://www.netservicos.com.br/NETClienteWLIWeb/DadoCobranca";

declare function xf:TransformarRetornoEmEventoXQuery($dadoCobrancaRegistroType1 as element())
    as element(ns0:RegistroContato) {
        <ns0:RegistroContato>
            {
                for $identificador in $dadoCobrancaRegistroType1/ns2:identificador
                return
                    <ns0:Identificador>{ xs:long( data($identificador) ) }</ns0:Identificador>
            }
            <ns0:Contato>
                {
                    for $Protocolo in $dadoCobrancaRegistroType1/ns2:Protocolo
                    return
                        <ns0:Protocolo>{ data($Protocolo) }</ns0:Protocolo>
                }
                {
                    for $NumeroChamado in $dadoCobrancaRegistroType1/ns2:NumeroChamado
                    return
                        <ns0:NumeroChamado>{ data($NumeroChamado) }</ns0:NumeroChamado>
                }
                {
                    for $NomeContato in $dadoCobrancaRegistroType1/ns2:NomeContato
                    return
                        <ns0:NomeContato>{ data($NomeContato) }</ns0:NomeContato>
                }
            </ns0:Contato>
        </ns0:RegistroContato>
};

declare variable $dadoCobrancaRegistroType1 as element() external;

xf:TransformarRetornoEmEventoXQuery($dadoCobrancaRegistroType1)
