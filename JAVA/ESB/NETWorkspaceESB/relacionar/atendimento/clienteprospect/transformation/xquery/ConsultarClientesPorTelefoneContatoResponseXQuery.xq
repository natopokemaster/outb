(:: pragma bea:global-element-parameter parameter="$consultarClientesPorTelefoneContatoResponse1" element="ns8:consultarClientesPorTelefoneContatoResponse" location="../../wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns11:resultadoListarClientes" location="../../wsdl/proxy/ClienteProspectDSLWSDLV1_0.wsdl" ::)

declare namespace ns20 = "http://www.netservicos.com.br/modelocanonico/v2/contratoparceiro";
declare namespace ns13 = "http://www.netservicos.com.br/modelocanonico/v2/produto";
declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/endereco";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/clienteprospect/transformation/xquery/ConsultarClientesPorTelefoneContatoResponseXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/produtocontratado";
declare namespace ns7 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";
declare namespace ns16 = "http://www.netservicos.com.br/modelocanonico/v2/oferta";
declare namespace ns5 = "http://www.netservicos.com.br/modelocanonico/v2/cliente";
declare namespace ns12 = "http://www.netservicos.com.br/modelocanonico/v2/moeda";
declare namespace ns18 = "http://www.netservicos.com.br/modelocanonico/v2/fatura";
declare namespace ns6 = "http://www.netservicos.com.br/modelocanonico/v2/venda";
declare namespace ns11 = "http://www.netservicos.com.br/ClienteProspectDSL/";
declare namespace ns9 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns17 = "http://www.netservicos.com.br/ClientePropesct/schemas";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/formapagamento";
declare namespace ns19 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/contrato";
declare namespace ns14 = "http://www.netservicos.com.br/modelocanonico/v2/rede";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns15 = "http://www.netservicos.com.br/modelocanonico/v2/equipamento";
declare namespace ns10 = "http://www.netservicos.com.br/modelocanonico/v2/cobranca";
declare namespace ns8 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";

declare function xf:ConsultarClientesPorTelefoneContatoResponseXQuery($consultarClientesPorTelefoneContatoResponse1 as element(ns8:consultarClientesPorTelefoneContatoResponse))
    as element(ns11:resultadoListarClientes) {
        <ns11:resultadoListarClientes>
            {
                let $ClientesProspect := $consultarClientesPorTelefoneContatoResponse1/ns17:ClientesProspect
                return
                    <ns11:clientesProspect>
                        {
                            for $clienteProspect in $ClientesProspect/ns17:clienteProspect
                            return
                                <ns5:clienteProspect>
                                    {
                                        for $Identificador in $clienteProspect/ns17:Identificador
                                        return
                                            <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                                    }
                                    {
                                        for $nome in $clienteProspect/ns17:nome
                                        return
                                            <ns5:nome>{ data($nome) }</ns5:nome>
                                    }
                                    {
                                        for $tipoPessoa in $clienteProspect/ns17:tipoPessoa
                                        return
                                            <ns5:tipoPessoa>{ data($tipoPessoa) }</ns5:tipoPessoa>
                                    }
                                    {
                                        for $CPF in $clienteProspect/ns17:CPF
                                        return
                                            <ns5:CPF>{ data($CPF) }</ns5:CPF>
                                    }
                                    {
                                        for $RG in $clienteProspect/ns17:RG
                                        return
                                            <ns5:RG>{ data($RG) }</ns5:RG>
                                    }
                                    {
                                        for $CNPJ in $clienteProspect/ns17:CNPJ
                                        return
                                            <ns5:CNPJ>{ data($CNPJ) }</ns5:CNPJ>
                                    }
                                    {
                                        for $InscricaoEstadual in $clienteProspect/ns17:InscricaoEstadual
                                        return
                                            <ns5:InscricaoEstadual>{ data($InscricaoEstadual) }</ns5:InscricaoEstadual>
                                    }
                                    {
                                        for $OrgaoExpedidor in $clienteProspect/ns17:OrgaoExpedidor
                                        return
                                            <ns5:OrgaoExpedidor>{ data($OrgaoExpedidor) }</ns5:OrgaoExpedidor>
                                    }
                                    {
                                        for $Profissao in $clienteProspect/ns17:Profissao
                                        return
                                            <ns5:Profissao>
                                                {
                                                    for $Identificador in $Profissao/ns17:Identificador
                                                    return
                                                        <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                                                }
                                                {
                                                    for $Descricao in $Profissao/ns17:Descricao
                                                    return
                                                        <ns5:Descricao>{ data($Descricao) }</ns5:Descricao>
                                                }
                                            </ns5:Profissao>
                                    }
                                    {
                                        for $DataNascimento in $clienteProspect/ns17:DataNascimento
                                        return
                                            <ns5:DataNascimento>{ data($DataNascimento) }</ns5:DataNascimento>
                                    }
                                    {
                                        for $Sexo in $clienteProspect/ns17:Sexo
                                        return
                                            <ns5:Sexo>{ data($Sexo) }</ns5:Sexo>
                                    }
                                    {
                                        for $EstadoCivil in $clienteProspect/ns17:EstadoCivil
                                        return
                                            <ns5:EstadoCivil>
                                                {
                                                    for $Identificador in $EstadoCivil/ns17:Identificador
                                                    return
                                                        <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                                                }
                                                {
                                                    for $Descricao in $EstadoCivil/ns17:Descricao
                                                    return
                                                        <ns5:Descricao>{ data($Descricao) }</ns5:Descricao>
                                                }
                                            </ns5:EstadoCivil>
                                    }
                                    {
                                        for $IndicadorDeEstrangeiro in $clienteProspect/ns17:IndicadorDeEstrangeiro
                                        return
                                            <ns5:IndicadorDeEstrangeiro>{ data($IndicadorDeEstrangeiro) }</ns5:IndicadorDeEstrangeiro>
                                    }
                                    {
                                        for $GrauDeInstrucao in $clienteProspect/ns17:GrauDeInstrucao
                                        return
                                            <ns5:GrauDeInstrucao>
                                                {
                                                    for $Identificador in $GrauDeInstrucao/ns17:Identificador
                                                    return
                                                        <ns5:Identificador>{ data($Identificador) }</ns5:Identificador>
                                                }
                                                {
                                                    for $Descricao in $GrauDeInstrucao/ns17:Descricao
                                                    return
                                                        <ns5:Descricao>{ data($Descricao) }</ns5:Descricao>
                                                }
                                            </ns5:GrauDeInstrucao>
                                    }
                                    {
                                        for $NomeMae in $clienteProspect/ns17:NomeMae
                                        return
                                            <ns5:NomeMae>{ data($NomeMae) }</ns5:NomeMae>
                                    }
                                    {
                                        for $NomePai in $clienteProspect/ns17:NomePai
                                        return
                                            <ns5:NomePai>{ data($NomePai) }</ns5:NomePai>
                                    }
                                    {
                                        for $Emails in $clienteProspect/ns17:Emails
                                        return
                                            <ns5:Emails>
                                                {
                                                    for $Emails0 in $Emails/ns17:Emails
                                                    return
                                                        <ns5:Emails>
                                                            {
                                                                for $EnderecoEmail in $Emails0/ns17:EnderecoEmail
                                                                return
                                                                    <ns5:EnderecoEmail>{ data($EnderecoEmail) }</ns5:EnderecoEmail>
                                                            }
                                                            <ns5:TipoEmail>{ data($Emails0/ns17:TipoEmail) }</ns5:TipoEmail>
                                                            <ns5:AceitaContato>{ data($Emails0/ns17:AceitaContato) }</ns5:AceitaContato>
                                                        </ns5:Emails>
                                                }
                                            </ns5:Emails>
                                    }
                                    {
                                        for $TelefonesContato in $clienteProspect/ns17:TelefonesContato
                                        return
                                            <ns5:TelefonesContato>
                                                {
                                                    for $telefoneContato in $TelefonesContato/ns17:telefoneContato
                                                    return
                                                        <ns5:telefoneContato>
                                                            {
                                                                for $IdentificadorTelefoneContato in $telefoneContato/ns17:IdentificadorTelefoneContato
                                                                return
                                                                    <ns5:IdentificadorTelefoneContato>{ data($IdentificadorTelefoneContato) }</ns5:IdentificadorTelefoneContato>
                                                            }
                                                            {
                                                                for $DDD in $telefoneContato/ns17:DDD
                                                                return
                                                                    <ns5:DDD>{ data($DDD) }</ns5:DDD>
                                                            }
                                                            {
                                                                for $numeroTelefone in $telefoneContato/ns17:numeroTelefone
                                                                return
                                                                    <ns5:numeroTelefone>{ data($numeroTelefone) }</ns5:numeroTelefone>
                                                            }
                                                            {
                                                                for $ramal in $telefoneContato/ns17:ramal
                                                                return
                                                                    <ns5:ramal>{ data($ramal) }</ns5:ramal>
                                                            }
                                                            {
                                                                for $tipoTelefone in $telefoneContato/ns17:tipoTelefone
                                                                return
                                                                    <ns5:tipoTelefone>{ data($tipoTelefone) }</ns5:tipoTelefone>
                                                            }
                                                            {
                                                                for $nomeRecado in $telefoneContato/ns17:nomeRecado
                                                                return
                                                                    <ns5:nomeRecado>{ data($nomeRecado) }</ns5:nomeRecado>
                                                            }
                                                        </ns5:telefoneContato>
                                                }
                                            </ns5:TelefonesContato>
                                    }
                                    {
                                        for $ContratosDeVenda in $clienteProspect/ns17:ContratosDeVenda
                                        return
                                            <ns5:ContratosDeVenda>
                                                {
                                                    for $contratoDeVenda in $ContratosDeVenda/ns17:contratoDeVenda
                                                    return
                                                        <ns3:contratoDeVenda>
                                                            {
                                                                for $numeroContrato in $contratoDeVenda/ns17:numeroContrato
                                                                return
                                                                    <ns3:numeroContrato>{ data($numeroContrato) }</ns3:numeroContrato>
                                                            }
                                                            {
                                                                for $digitoVerificador in $contratoDeVenda/ns17:digitoVerificador
                                                                return
                                                                    <ns3:digitoVerificador>{ data($digitoVerificador) }</ns3:digitoVerificador>
                                                            }
                                                            {
                                                                for $operadoraNET in $contratoDeVenda/ns17:operadoraNET
                                                                return
                                                                    <ns3:operadoraNET>
                                                                        {
                                                                            for $identificador in $operadoraNET/ns17:identificador
                                                                            return
                                                                                <ns19:identificador>{ data($identificador) }</ns19:identificador>
                                                                        }
                                                                        {
                                                                            for $NomeEmpresa in $operadoraNET/ns17:NomeEmpresa
                                                                            return
                                                                                <ns19:NomeEmpresa>{ data($NomeEmpresa) }</ns19:NomeEmpresa>
                                                                        }
                                                                        {
                                                                            for $CNPJ in $operadoraNET/ns17:CNPJ
                                                                            return
                                                                                <ns19:CNPJ>{ data($CNPJ) }</ns19:CNPJ>
                                                                        }
                                                                        {
                                                                            for $inscricaoEstadual in $operadoraNET/ns17:inscricaoEstadual
                                                                            return
                                                                                <ns19:inscricaoEstadual>{ data($inscricaoEstadual) }</ns19:inscricaoEstadual>
                                                                        }
                                                                        {
                                                                            for $nomeFantasia in $operadoraNET/ns17:nomeFantasia
                                                                            return
                                                                                <ns19:nomeFantasia>{ data($nomeFantasia) }</ns19:nomeFantasia>
                                                                        }
                                                                        {
                                                                            for $CodigoOperdaora in $operadoraNET/ns17:CodigoOperdaora
                                                                            return
                                                                                <ns19:CodigoOperdaora>{ data($CodigoOperdaora) }</ns19:CodigoOperdaora>
                                                                        }
                                                                        {
                                                                            for $IdentificacaoCidade in $operadoraNET/ns17:IdentificacaoCidade
                                                                            return
                                                                                <ns19:IdentificacaoCidade>{ data($IdentificacaoCidade) }</ns19:IdentificacaoCidade>
                                                                        }
                                                                        {
                                                                            for $NomeOperadora in $operadoraNET/ns17:NomeOperadora
                                                                            return
                                                                                <ns19:NomeOperadora>{ data($NomeOperadora) }</ns19:NomeOperadora>
                                                                        }
                                                                    </ns3:operadoraNET>
                                                            }
                                                            {
                                                                for $dataVenda in $contratoDeVenda/ns17:dataVenda
                                                                return
                                                                    <ns3:dataVenda>{ data($dataVenda) }</ns3:dataVenda>
                                                            }
                                                            {
                                                                for $dataCancelamento in $contratoDeVenda/ns17:dataCancelamento
                                                                return
                                                                    <ns3:dataCancelamento>{ data($dataCancelamento) }</ns3:dataCancelamento>
                                                            }
                                                            {
                                                                for $motivoCancelamento in $contratoDeVenda/ns17:motivoCancelamento
                                                                return
                                                                    <ns3:motivoCancelamento>{ data($motivoCancelamento) }</ns3:motivoCancelamento>
                                                            }
                                                            {
                                                                for $dataCadastro in $contratoDeVenda/ns17:dataCadastro
                                                                return
                                                                    <ns3:dataCadastro>{ data($dataCadastro) }</ns3:dataCadastro>
                                                            }
                                                            {
                                                                for $observacao in $contratoDeVenda/ns17:observacao
                                                                return
                                                                    <ns3:observacao>{ data($observacao) }</ns3:observacao>
                                                            }
                                                        </ns3:contratoDeVenda>
                                                }
                                            </ns5:ContratosDeVenda>
                                    }
                                    {
                                        for $CodigoSuframa in $clienteProspect/ns17:CodigoSuframa
                                        return
                                            <ns5:CodigoSuframa>{ data($CodigoSuframa) }</ns5:CodigoSuframa>
                                    }
                                    {
                                        for $TipoCliente in $clienteProspect/ns17:TipoCliente
                                        return
                                            <ns5:TipoCliente>{ data($TipoCliente) }</ns5:TipoCliente>
                                    }
                                </ns5:clienteProspect>
                        }
                    </ns11:clientesProspect>
            }
        </ns11:resultadoListarClientes>
};

declare variable $consultarClientesPorTelefoneContatoResponse1 as element(ns8:consultarClientesPorTelefoneContatoResponse) external;

xf:ConsultarClientesPorTelefoneContatoResponseXQuery($consultarClientesPorTelefoneContatoResponse1)
