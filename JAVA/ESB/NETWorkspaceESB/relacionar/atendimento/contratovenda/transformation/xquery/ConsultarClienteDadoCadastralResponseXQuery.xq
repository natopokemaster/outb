(:: pragma bea:global-element-parameter parameter="$consultarClientePorContratoResponse1" element="ns9:consultarClientePorContratoResponse" location="../../../clienteprospect/wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns7:resultadoConsultarDadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)

declare namespace ns20 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace ns13 = "http://www.netservicos.com.br/modelocanonico/v2/moeda";
declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/endereco";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ConsultarClienteDadoCadastralResponseXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/produtocontratado";
declare namespace ns7 = "http://www.netservicos.com.br/ContratoVendaV2/";
declare namespace ns16 = "http://www.netservicos.com.br/modelocanonico/v2/equipamento";
declare namespace ns5 = "http://www.netservicos.com.br/modelocanonico/v2/cliente";
declare namespace ns12 = "http://www.netservicos.com.br/modelocanonico/v2/atendimento";
declare namespace ns18 = "http://www.netservicos.com.br/ClientePropesct/schemas";
declare namespace ns6 = "http://www.netservicos.com.br/modelocanonico/v2/venda";
declare namespace ns11 = "http://www.netservicos.com.br/modelocanonico/v2/cobranca";
declare namespace ns9 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";
declare namespace ns17 = "http://www.netservicos.com.br/modelocanonico/v2/oferta";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/formapagamento";
declare namespace ns19 = "http://www.netservicos.com.br/modelocanonico/v2/fatura";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/contrato";
declare namespace ns14 = "http://www.netservicos.com.br/modelocanonico/v2/produto";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns15 = "http://www.netservicos.com.br/modelocanonico/v2/rede";
declare namespace ns21 = "http://www.netservicos.com.br/modelocanonico/v2/contratoparceiro";
declare namespace ns10 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns8 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";

declare function xf:ConsultarClienteDadoCadastralResponseXQuery($consultarClientePorContratoResponse1 as element(ns9:consultarClientePorContratoResponse))
    as element(ns7:resultadoConsultarDadoCadastralTitular) {
        <ns7:resultadoConsultarDadoCadastralTitular>
            {
                let $result :=
                    for $clienteProspect in $consultarClientePorContratoResponse1/ns18:ClientesProspect/ns18:clienteProspect
                    return
                        <clienteProspect>
                            {
                                for $Identificador in $clienteProspect/ns18:Identificador
                                return
                                    <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                            }
                            {
                                for $nome in $clienteProspect/ns18:nome
                                return
                                    <ns5:nome>{ data($nome) }</ns5:nome>
                            }
                            {
                                for $tipoPessoa in $clienteProspect/ns18:tipoPessoa
                                return
                                    <ns5:tipoPessoa>{ data($tipoPessoa) }</ns5:tipoPessoa>
                            }
                            {
                                for $CPF in $clienteProspect/ns18:CPF
                                return
                                    <ns5:CPF>{ data($CPF) }</ns5:CPF>
                            }
                            {
                                for $RG in $clienteProspect/ns18:RG
                                return
                                    <ns5:RG>{ data($RG) }</ns5:RG>
                            }
                            {
                                for $CNPJ in $clienteProspect/ns18:CNPJ
                                return
                                    <ns5:CNPJ>{ data($CNPJ) }</ns5:CNPJ>
                            }
                            {
                                for $InscricaoEstadual in $clienteProspect/ns18:InscricaoEstadual
                                return
                                    <ns5:InscricaoEstadual>{ data($InscricaoEstadual) }</ns5:InscricaoEstadual>
                            }
                            {
                                for $OrgaoExpedidor in $clienteProspect/ns18:OrgaoExpedidor
                                return
                                    <ns5:OrgaoExpedidor>{ data($OrgaoExpedidor) }</ns5:OrgaoExpedidor>
                            }
                            {
                                for $Profissao in $clienteProspect/ns18:Profissao
                                return
                                    <ns5:Profissao>
                                        {
                                            for $Identificador in $Profissao/ns18:Identificador
                                            return
                                                <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                                        }
                                        {
                                            for $Descricao in $Profissao/ns18:Descricao
                                            return
                                                <ns5:Descricao>{ data($Descricao) }</ns5:Descricao>
                                        }
                                    </ns5:Profissao>
                            }
                            {
                                for $DataNascimento in $clienteProspect/ns18:DataNascimento
                                return
                                    <ns5:DataNascimento>{ data($DataNascimento) }</ns5:DataNascimento>
                            }
                            {
                                for $Sexo in $clienteProspect/ns18:Sexo
                                return
                                    <ns5:Sexo>{ data($Sexo) }</ns5:Sexo>
                            }
                            {
                                for $EstadoCivil in $clienteProspect/ns18:EstadoCivil
                                return
                                    <ns5:EstadoCivil>
                                        {
                                            for $Identificador in $EstadoCivil/ns18:Identificador
                                            return
                                                <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                                        }
                                        {
                                            for $Descricao in $EstadoCivil/ns18:Descricao
                                            return
                                                <ns5:Descricao>{ data($Descricao) }</ns5:Descricao>
                                        }
                                    </ns5:EstadoCivil>
                            }
                            {
                                for $IndicadorDeEstrangeiro in $clienteProspect/ns18:IndicadorDeEstrangeiro
                                return
                                    <ns5:IndicadorDeEstrangeiro>{ data($IndicadorDeEstrangeiro) }</ns5:IndicadorDeEstrangeiro>
                            }
                            {
                                for $GrauDeInstrucao in $clienteProspect/ns18:GrauDeInstrucao
                                return
                                    <ns5:GrauDeInstrucao>
                                        {
                                            for $Identificador in $GrauDeInstrucao/ns18:Identificador
                                            return
                                                <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                                        }
                                        {
                                            for $Descricao in $GrauDeInstrucao/ns18:Descricao
                                            return
                                                <ns5:Descricao>{ data($Descricao) }</ns5:Descricao>
                                        }
                                    </ns5:GrauDeInstrucao>
                            }
                            {
                                for $NomeMae in $clienteProspect/ns18:NomeMae
                                return
                                    <ns5:NomeMae>{ data($NomeMae) }</ns5:NomeMae>
                            }
                            {
                                for $NomePai in $clienteProspect/ns18:NomePai
                                return
                                    <ns5:NomePai>{ data($NomePai) }</ns5:NomePai>
                            }
                            {
                                for $Emails in $clienteProspect/ns18:Emails
                                return
                                    <ns5:Emails>
                                        {
                                            for $Emails0 in $Emails/ns18:Emails
                                            return
                                                <ns5:Emails>
                                                    {
                                                        for $EnderecoEmail in $Emails0/ns18:EnderecoEmail
                                                        return
                                                            <ns5:EnderecoEmail>{ data($EnderecoEmail) }</ns5:EnderecoEmail>
                                                    }
                                                    {
                                                        for $TipoEmail in $Emails0/ns18:TipoEmail
                                                        return
                                                            <ns5:TipoEmail>{ data($TipoEmail) }</ns5:TipoEmail>
                                                    }
                                                    {
                                                        for $AceitaContato in $Emails0/ns18:AceitaContato
                                                        return
                                                            <ns5:AceitaContato>{ data($AceitaContato) }</ns5:AceitaContato>
                                                    }
                                                </ns5:Emails>
                                        }
                                    </ns5:Emails>
                            }
                            {
                                for $TelefonesContato in $clienteProspect/ns18:TelefonesContato
                                return
                                    <ns5:TelefonesContato>
                                        {
                                            for $telefoneContato in $TelefonesContato/ns18:telefoneContato
                                            return
                                                <ns5:telefoneContato>
                                                    {
                                                        for $IdentificadorTelefoneContato in $telefoneContato/ns18:IdentificadorTelefoneContato
                                                        return
                                                            <ns5:IdentificadorTelefoneContato>{ data($IdentificadorTelefoneContato) }</ns5:IdentificadorTelefoneContato>
                                                    }
                                                    {
                                                        for $DDD in $telefoneContato/ns18:DDD
                                                        return
                                                            <ns5:DDD>{ data($DDD) }</ns5:DDD>
                                                    }
                                                    {
                                                        for $numeroTelefone in $telefoneContato/ns18:numeroTelefone
                                                        return
                                                            <ns5:numeroTelefone>{ data($numeroTelefone) }</ns5:numeroTelefone>
                                                    }
                                                    {
                                                        for $ramal in $telefoneContato/ns18:ramal
                                                        return
                                                            <ns5:ramal>{ data($ramal) }</ns5:ramal>
                                                    }
                                                    {
                                                        for $tipoTelefone in $telefoneContato/ns18:tipoTelefone
                                                        return
                                                            <ns5:tipoTelefone>{ data($tipoTelefone) }</ns5:tipoTelefone>
                                                    }
                                                    {
                                                        for $nomeRecado in $telefoneContato/ns18:nomeRecado
                                                        return
                                                            <ns5:nomeRecado>{ data($nomeRecado) }</ns5:nomeRecado>
                                                    }
                                                </ns5:telefoneContato>
                                        }
                                    </ns5:TelefonesContato>
                            }
                            {
                                for $ContratosDeVenda in $clienteProspect/ns18:ContratosDeVenda
                                return
                                    <ns5:ContratosDeVenda>
                                        {
                                            for $contratoDeVenda in $ContratosDeVenda/ns18:contratoDeVenda
                                            return
                                                <ns3:contratoDeVenda>
                                                    {
                                                        for $numeroContrato in $contratoDeVenda/ns18:numeroContrato
                                                        return
                                                            <ns3:numeroContrato>{ data($numeroContrato) }</ns3:numeroContrato>
                                                    }
                                                    {
                                                        for $digitoVerificador in $contratoDeVenda/ns18:digitoVerificador
                                                        return
                                                            <ns3:digitoVerificador>{ data($digitoVerificador) }</ns3:digitoVerificador>
                                                    }
                                                    {
                                                        for $operadoraNET in $contratoDeVenda/ns18:operadoraNET
                                                        return
                                                            <ns3:operadoraNET>
                                                                {
                                                                    for $identificador in $operadoraNET/ns18:identificador
                                                                    return
                                                                        <ns20:identificador>{ data($identificador) }</ns20:identificador>
                                                                }
                                                                {
                                                                    for $NomeEmpresa in $operadoraNET/ns18:NomeEmpresa
                                                                    return
                                                                        <ns20:NomeEmpresa>{ data($NomeEmpresa) }</ns20:NomeEmpresa>
                                                                }
                                                                {
                                                                    for $CNPJ in $operadoraNET/ns18:CNPJ
                                                                    return
                                                                        <ns20:CNPJ>{ data($CNPJ) }</ns20:CNPJ>
                                                                }
                                                                {
                                                                    for $inscricaoEstadual in $operadoraNET/ns18:inscricaoEstadual
                                                                    return
                                                                        <ns20:inscricaoEstadual>{ data($inscricaoEstadual) }</ns20:inscricaoEstadual>
                                                                }
                                                                {
                                                                    for $nomeFantasia in $operadoraNET/ns18:nomeFantasia
                                                                    return
                                                                        <ns20:nomeFantasia>{ data($nomeFantasia) }</ns20:nomeFantasia>
                                                                }
                                                                {
                                                                    for $CodigoOperdaora in $operadoraNET/ns18:CodigoOperdaora
                                                                    return
                                                                        <ns20:CodigoOperdaora>{ data($CodigoOperdaora) }</ns20:CodigoOperdaora>
                                                                }
                                                                {
                                                                    for $IdentificacaoCidade in $operadoraNET/ns18:IdentificacaoCidade
                                                                    return
                                                                        <ns20:IdentificacaoCidade>{ data($IdentificacaoCidade) }</ns20:IdentificacaoCidade>
                                                                }
                                                                {
                                                                    for $NomeOperadora in $operadoraNET/ns18:NomeOperadora
                                                                    return
                                                                        <ns20:NomeOperadora>{ data($NomeOperadora) }</ns20:NomeOperadora>
                                                                }
                                                            </ns3:operadoraNET>
                                                    }
                                                    {
                                                        for $dataVenda in $contratoDeVenda/ns18:dataVenda
                                                        return
                                                            <ns3:dataVenda>{ data($dataVenda) }</ns3:dataVenda>
                                                    }
                                                    {
                                                        for $dataCancelamento in $contratoDeVenda/ns18:dataCancelamento
                                                        return
                                                            <ns3:dataCancelamento>{ data($dataCancelamento) }</ns3:dataCancelamento>
                                                    }
                                                    {
                                                        for $motivoCancelamento in $contratoDeVenda/ns18:motivoCancelamento
                                                        return
                                                            <ns3:motivoCancelamento>{ data($motivoCancelamento) }</ns3:motivoCancelamento>
                                                    }
                                                    {
                                                        for $dataCadastro in $contratoDeVenda/ns18:dataCadastro
                                                        return
                                                            <ns3:dataCadastro>{ data($dataCadastro) }</ns3:dataCadastro>
                                                    }
                                                    {
                                                        for $observacao in $contratoDeVenda/ns18:observacao
                                                        return
                                                            <ns3:observacao>{ data($observacao) }</ns3:observacao>
                                                    }
                                                </ns3:contratoDeVenda>
                                        }
                                    </ns5:ContratosDeVenda>
                            }
                            {
                                for $CodigoSuframa in $clienteProspect/ns18:CodigoSuframa
                                return
                                    <ns5:CodigoSuframa>{ data($CodigoSuframa) }</ns5:CodigoSuframa>
                            }
                            {
                                for $TipoCliente in $clienteProspect/ns18:TipoCliente
                                return
                                    <ns5:TipoCliente>{ data($TipoCliente) }</ns5:TipoCliente>
                            }
                        </clienteProspect>
                return
                    $result[1]
            }
        </ns7:resultadoConsultarDadoCadastralTitular>
};

declare variable $consultarClientePorContratoResponse1 as element(ns9:consultarClientePorContratoResponse) external;

xf:ConsultarClienteDadoCadastralResponseXQuery($consultarClientePorContratoResponse1)
