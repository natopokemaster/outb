(:: pragma bea:global-element-parameter parameter="$registroContatoIn" element="ns0:RegistroContato" location="../../../../modelocanonicoV2/evento/Evento.xsd" ::)
(:: pragma bea:global-element-return element="ns5:incluirRegistroContato" location="../wsdl/business/IncluirRegistroContatoBSWSDL2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/vender/venda/checagemcredito/transformation/xquery/ObterValoresIncluirRegistroContatoRequestXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns7 = "http://br/com/netservicos/atendimento/evento/registrocontato";
declare namespace xsi = "http://www.w3.org/2001/XMLSchema-instance";
declare namespace ns5 = "http://br/com/netservicos/atendimento/jws";
declare namespace ns6 = "http://www.netservicos.com.br/atendimento/usuario";
declare namespace ns1 = "http://www.netservicos.com.br/atendimento/geral";
declare namespace ns3 = "http://www.netservicos.com.br/atendimento/atendimento";
declare namespace ns2 = "http://www.netservicos.com.br/atendimento/RegistroContato";
declare namespace endereco = "http://www.netservicos.com.br/atendimento/endereco";
declare namespace enderecoCanon = "http://www.netservicos.com.br/modelocanonico/v2/endereco";
declare namespace ns8 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";
declare namespace ns9 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";

declare function xf:ObterValoresIncluirRegistroContatoRequestXQuery($incluirRegistroContatoRequest as element(ns7:incluirRegistroContato))
    as xs:string {
    
    let $loginUsuario := fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:Usuario/ns8:LoginUsuario)
    let $dataEvento := fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:DataEvento)
    let $observacao := fn:normalize-space(fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:Observacao))
    let $origemEvento := fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:OrigemEvento)
    let $tipoIdentificador := fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:Tipo/ns0:Identificador)
    let $tipoDescricao := fn:normalize-space(fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:Tipo/ns0:Descricao))
    let $nomeContato := fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:Contato/ns0:NomeContato)
    let $formaContato := fn:concat(xs:string(xs:integer(fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:Contato/ns0:FormaContato/ns0:DDD))),fn:data($incluirRegistroContatoRequest/ns0:RegistroContato/ns0:Contato/ns0:FormaContato/ns0:numeroTelefone))
    let $numeroContrato := fn:data($incluirRegistroContatoRequest/ns9:IdentificacaoContrato/ns9:Contrato/ns9:NumeroContrato)
    let $cidCidade := fn:data($incluirRegistroContatoRequest/ns9:IdentificacaoContrato/ns9:Contrato/ns9:IdentificacaoCidade)
   
    
    let $valores := fn:concat($loginUsuario,",",
                              $dataEvento,",",
                              $observacao,",",
                              $origemEvento,",",
                              $tipoIdentificador,",",
                              $tipoDescricao,",",
                              $nomeContato,",",
                              $formaContato,",",
                              $numeroContrato,",",
                              $cidCidade)
        
    return $valores

};

declare variable $incluirRegistroContatoRequest as element(ns7:incluirRegistroContato) external;
xf:ObterValoresIncluirRegistroContatoRequestXQuery($incluirRegistroContatoRequest)
