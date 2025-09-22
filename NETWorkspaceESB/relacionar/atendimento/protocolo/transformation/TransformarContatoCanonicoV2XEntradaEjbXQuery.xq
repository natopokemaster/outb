(:: pragma bea:global-element-parameter parameter="$associarProtocoloAtendimento1" element="ns3:associarProtocoloAtendimento" location="../wsdl/proxyservice/AssociarProtocoloAtendimentoWSDL12V2.wsdl" ::)
(:: pragma bea:global-element-return element="ns2:associarProtocoloAtendimento" location="../wsdl/business/AssociarProtocoloAtendimentoBS.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/protocolo/transformation/TransformarContatoCanonicoV2XEntradaEjbXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns1 = "java:br.com.netservicos.atendimento.protocolo.bean";
declare namespace ns3 = "http://www.netservicos.com.br/relacionar/atendimento/protocolo";
declare namespace ns2 = "http://www.openuri.org/";

declare function xf:TransformarContatoCanonicoV2XEntradaEjbXQuery($associarProtocoloAtendimento1 as element(ns3:associarProtocoloAtendimento))
    as element(ns2:associarProtocoloAtendimento) {
        <ns2:associarProtocoloAtendimento>
            <ns2:contato>
                <ns1:numeroProtocolo>{ data($associarProtocoloAtendimento1/ns3:contato/ns0:Protocolo) }</ns1:numeroProtocolo>
                <ns1:numeroChamado>{ data($associarProtocoloAtendimento1/ns3:contato/ns0:NumeroChamado) }</ns1:numeroChamado>
                {
                    for $evento in $associarProtocoloAtendimento1/ns3:contato/ns0:Eventos//ns0:OrdemInterna
                    return
                    <ns1:eventos>
                        <ns1:identificador>{fn:data($evento/ns0:Identificador)}</ns1:identificador>
                        <ns1:tipoIdentificador>1</ns1:tipoIdentificador>
                     </ns1:eventos>
                }
                {
                    for $evento in $associarProtocoloAtendimento1/ns3:contato/ns0:Eventos//ns0:RegistroSistemica
                    return
                        <ns1:eventos>
                        <ns1:identificador>{fn:data($evento/ns0:Identificador)}</ns1:identificador>
                        <ns1:tipoIdentificador>2</ns1:tipoIdentificador>
                        </ns1:eventos>
                }
                {
                    for $evento in $associarProtocoloAtendimento1/ns3:contato/ns0:Eventos//ns0:OrdemCampo
                    return
                        <ns1:eventos>
                        <ns1:identificador>{fn:data($evento/ns0:Identificador)}</ns1:identificador>
                        <ns1:tipoIdentificador>3</ns1:tipoIdentificador>
                        </ns1:eventos>
                }
                {
                    for $evento in $associarProtocoloAtendimento1/ns3:contato/ns0:Eventos//ns0:OrdemAtivacao
                    return
                        <ns1:eventos>
                        <ns1:identificador>{fn:data($evento/ns0:Identificador)}</ns1:identificador>
                        <ns1:tipoIdentificador>4</ns1:tipoIdentificador>
                        </ns1:eventos>
                }
                {
                    for $evento in $associarProtocoloAtendimento1/ns3:contato/ns0:Eventos//ns0:RegistroContato
                    return
                        <ns1:eventos>
                        <ns1:identificador>{fn:data($evento/ns0:Identificador)}</ns1:identificador>
                        <ns1:tipoIdentificador>5</ns1:tipoIdentificador>
                        </ns1:eventos>
                }
            </ns2:contato>
        </ns2:associarProtocoloAtendimento>
};

declare variable $associarProtocoloAtendimento1 as element(ns3:associarProtocoloAtendimento) external;

xf:TransformarContatoCanonicoV2XEntradaEjbXQuery($associarProtocoloAtendimento1)
