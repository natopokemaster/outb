(:: pragma bea:global-element-parameter parameter="$incluirRequisicaoInterna1" element="ns2:incluirRequisicaoInterna" location="../wsdl/proxy/IncluirRequisicaoInternaWSDL12V2_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns3:incluirRequisicaoInterna" location="../wsdl/business/IncluirRequisicaoInternaBSWSDL2_0.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/atendimento/usuario";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/evento/transformation/TransformarRequisicaoInternaCanonicoXRequisicaoInternaWLIXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns7 = "http://www.netservicos.com.br/atendimento/identificacaoContrato";
declare namespace ns3 = "http://br/com/netservicos/atendimento/jws";
declare namespace ns2 = "http://br/com/netservicos/atendimento/evento/requisicaointerna";
declare namespace ns5 = "http://www.netservicos.com.br/atendimento/evento";
declare namespace ns6 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";

declare function xf:TransformarRequisicaoInternaCanonicoXRequisicaoInternaWLIXQuery($incluirRequisicaoInterna1 as element(ns2:incluirRequisicaoInterna))
    as element(ns3:incluirRequisicaoInterna) {
        <ns3:incluirRequisicaoInterna>
            <ns5:RequisicaoInterna>
                <ns5:Usuario>
                    {
                        for $LoginUsuario in $incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Usuario/ns6:LoginUsuario
                        return
                            <ns4:LoginUsuario>{ data($LoginUsuario) }</ns4:LoginUsuario>
                    }
                    {
                        for $NomeUsuario in $incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Usuario/ns6:NomeUsuario
                        return
                            <ns4:NomeUsuario>{ data($NomeUsuario) }</ns4:NomeUsuario>
                    }
                </ns5:Usuario>
                {
                    for $Observacao in $incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Observacao
                    return
                        <ns5:Observacao>{ data($Observacao) }</ns5:Observacao>
                }
                {
                    for $OrigemEvento in $incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:OrigemEvento
                    return
                        <ns5:OrigemEvento>{ data($OrigemEvento) }</ns5:OrigemEvento>
                }
                <ns5:Tipo>
                    {
                        for $Identificador in $incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Tipo/ns0:Identificador
                        return
                            <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                    }
                    {
                        for $Descricao in $incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Tipo/ns0:Descricao
                        return
                            <ns5:Descricao>{ data($Descricao) }</ns5:Descricao>
                    }
                </ns5:Tipo>
                <ns5:nomeContato>{ data($incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Contato/ns0:NomeContato) }</ns5:nomeContato>
                { 
                  if ($incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Contato/ns0:FormaContato[ends-with(@xsi:type , ':FormaContatoTelefone')]) then
                <ns5:telefoneContato>{fn:concat(fn:data($incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Contato/ns0:FormaContato/ns0:DDD), 
                          fn:data($incluirRequisicaoInterna1/ns0:OrdemInterna/ns0:Contato/ns0:FormaContato/ns0:numeroTelefone))}</ns5:telefoneContato>
                   else    
                     <ns5:telefoneContato></ns5:telefoneContato>  
                } 
            </ns5:RequisicaoInterna>
            <ns7:IdentificacaoContrato>
                <ns7:Contrato>
                    <ns7:NumeroContrato>{ data($incluirRequisicaoInterna1/ns1:IdentificacaoContrato/ns1:Contrato/ns1:NumeroContrato) }</ns7:NumeroContrato>
                    <ns7:IdentificacaoCidade>{ data($incluirRequisicaoInterna1/ns1:IdentificacaoContrato/ns1:Contrato/ns1:IdentificacaoCidade) }</ns7:IdentificacaoCidade>
                </ns7:Contrato>
            </ns7:IdentificacaoContrato>
        </ns3:incluirRequisicaoInterna>
};

declare variable $incluirRequisicaoInterna1 as element(ns2:incluirRequisicaoInterna) external;

xf:TransformarRequisicaoInternaCanonicoXRequisicaoInternaWLIXQuery($incluirRequisicaoInterna1)
