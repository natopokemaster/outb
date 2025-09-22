(:: pragma bea:global-element-parameter parameter="$netHeader1" element="ns2:NetHeader" location="../../../../../modelocanonico/geral/NETHeader.xsd" ::)
(:: pragma bea:global-element-parameter parameter="$identificacaoContratoResponse1" element="ns0:IdentificacaoContratoResponse" location="../../../../../general/NETSMSDatabaseConfig/wsdl/proxy/TransformaIdentificacaoContratoWSDL12V1.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:gerarOcorrenciaPrazoRequest" location="../../../../../general/ocorrencia/wsdl/business/GerarOcorrenciaPrazoWSDL.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/GerarOcorrenciaPrazoContratoVendaXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/TransformaIdentificacaoContrato12V1";
declare namespace ns1 = "http://www.openuri.org/";
declare namespace ns2 = "http://www.netservicos.com.br/v2/NetHeader";

declare function xf:GerarOcorrenciaPrazoContratoVendaXQuery($netHeader1 as element(ns2:NetHeader),
    $identificacaoContratoResponse1 as element(ns0:IdentificacaoContratoResponse))
    as element(ns1:gerarOcorrenciaPrazoRequest) {
        <ns1:gerarOcorrenciaPrazoRequest>
           <ns1:ORIGEM>{xs:string( data('ATENDIMENTO ELETRONICO') ) }</ns1:ORIGEM>
            {
                for $funcionalidade in $netHeader1/funcionalidade
                return
                    <ns1:CONSUMIDOR>{ data($funcionalidade) }</ns1:CONSUMIDOR>
            }
            <ns1:PROCESSO_GERADOR>{xs:string( data('CA1 - ALTERAR DADO CONTATO TITULAR') ) }</ns1:PROCESSO_GERADOR>
            <ns1:SITUACAO>{xs:string( data('FECHADA') ) }</ns1:SITUACAO>
            <ns1:TIPO_OCORRENCIA>{xs:string( data('CA1 - DADOS CADASTRAIS') ) }</ns1:TIPO_OCORRENCIA>
            <ns1:NUM_CONTRATO>{ xs:string( data($identificacaoContratoResponse1/ns0:Contrato/ns0:NumeroContrato) ) }</ns1:NUM_CONTRATO>
            <ns1:COD_OPERADORA>{ data($identificacaoContratoResponse1/ns0:Contrato/ns0:CodigoOperadora) }</ns1:COD_OPERADORA>
            <ns1:OBSERVACAO>{xs:string( data(' ') ) }</ns1:OBSERVACAO>
            <ns1:NOME_CONTATO>{xs:string( data(' ') ) }</ns1:NOME_CONTATO>
            <ns1:TELEFONE_CONTATO>{xs:string( data(' ') ) }</ns1:TELEFONE_CONTATO>
            <ns1:NUM_CHAMADA>{ data($netHeader1/atendimento/numeroChamada) }</ns1:NUM_CHAMADA>
            <ns1:PROTOCOLO>{ data($netHeader1/atendimento/numeroProtocolo) }</ns1:PROTOCOLO>
        </ns1:gerarOcorrenciaPrazoRequest>
};

declare variable $netHeader1 as element(ns2:NetHeader) external;
declare variable $identificacaoContratoResponse1 as element(ns0:IdentificacaoContratoResponse) external;

xf:GerarOcorrenciaPrazoContratoVendaXQuery($netHeader1,
    $identificacaoContratoResponse1)
