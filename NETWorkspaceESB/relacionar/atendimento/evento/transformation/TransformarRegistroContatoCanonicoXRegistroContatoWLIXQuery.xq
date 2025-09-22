(:: pragma bea:global-element-parameter parameter="$registroContatoIn" element="ns0:RegistroContato" location="../../../../modelocanonicoV2/evento/Evento.xsd" ::)
(:: pragma bea:global-element-parameter parameter="$identificacaoContratoIn" element="ns4:IdentificacaoContrato" location="../../../../modelocanonicoV2/geral/IdentificacaoContrato.xsd" ::)
(:: pragma bea:global-element-return element="ns5:incluirRegistroContato" location="../wsdl/business/IncluirRegistroContatoBSWSDL2_0.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/evento/transformation/TransformarRegistroContatoCanonicoXRegistroContatoWLIXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns7 = "http://www.netservicos.com.br/atendimento/evento";
declare namespace xsi = "http://www.w3.org/2001/XMLSchema-instance";
declare namespace ns5 = "http://br/com/netservicos/atendimento/jws";
declare namespace ns6 = "http://www.netservicos.com.br/atendimento/usuario";
declare namespace ns1 = "http://www.netservicos.com.br/atendimento/geral";
declare namespace ns3 = "http://www.netservicos.com.br/atendimento/atendimento";
declare namespace ns2 = "http://www.netservicos.com.br/atendimento/RegistroContato";
declare namespace endereco = "http://www.netservicos.com.br/atendimento/endereco";
declare namespace enderecoCanon = "http://www.netservicos.com.br/modelocanonico/v2/endereco";
declare namespace ns8 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";

declare function xf:TransformarRegistroContatoCanonicoXRegistroContatoWLIXQuery($registroContatoIn as element(ns0:RegistroContato),
    $identificacaoContratoIn as element(ns4:IdentificacaoContrato))
    as element(ns5:incluirRegistroContato) {
        <ns5:incluirRegistroContato>
            <ns2:RegistroContato>
                <ns7:Usuario>
                    {
                        for $LoginUsuario in $registroContatoIn/ns0:Usuario/ns8:LoginUsuario
                        return
                            <ns6:LoginUsuario>{ data($LoginUsuario) }</ns6:LoginUsuario>
                    }
                    {
                        for $NomeUsuario in $registroContatoIn/ns0:Usuario/ns8:NomeUsuario
                        return
                            <ns6:NomeUsuario>{ data($NomeUsuario) }</ns6:NomeUsuario>
                    }
                    {
                        for $CPF in $registroContatoIn/ns0:Usuario/ns8:CPF
                        return
                            <ns6:CPF>{ data($CPF) }</ns6:CPF>
                    }
                    <ns6:EmailUsuario>
                        {
                            for $EnderecoEmail in $registroContatoIn/ns0:Usuario/ns8:EmailUsuario/ns8:EnderecoEmail
                            return
                                <ns6:EnderecoEmail>{ data($EnderecoEmail) }</ns6:EnderecoEmail>
                        }
                    </ns6:EmailUsuario>
                    <ns6:TelefoneUsuario>
                        {
                            for $DDD in $registroContatoIn/ns0:Usuario/ns8:TelefoneUsuario/ns8:DDD
                            return
                                <ns6:DDD>{ data($DDD) }</ns6:DDD>
                        }
                        {
                            for $Telefone in $registroContatoIn/ns0:Usuario/ns8:TelefoneUsuario/ns8:Telefone
                            return
                                <ns6:Telefone>{ data($Telefone) }</ns6:Telefone>
                        }
                        {
                            for $Ramal in $registroContatoIn/ns0:Usuario/ns8:TelefoneUsuario/ns8:Ramal
                            return
                                <ns6:Ramal>{ data($Ramal) }</ns6:Ramal>
                        }
                    </ns6:TelefoneUsuario>
                </ns7:Usuario>
                <ns7:DataEvento>{current-dateTime()}</ns7:DataEvento>
                {
                    for $Observacao in $registroContatoIn/ns0:Observacao
                    return
                        <ns7:Observacao>{ data($Observacao) }</ns7:Observacao>
                }
                {
                    for $OrigemEvento in $registroContatoIn/ns0:OrigemEvento
                    return
                        <ns7:OrigemEvento>{ data($OrigemEvento) }</ns7:OrigemEvento>
                }
                {
                    for $Identificador in $registroContatoIn/ns0:Identificador
                    return
                        <ns7:Identificador>{ data($Identificador) }</ns7:Identificador>
                }
                {
                    for $Descricao in $registroContatoIn/ns0:Descricao
                    return
                        <ns7:Descricao>{ data($Descricao) }</ns7:Descricao>
                }
                <ns7:Tipo>
                    {
                        for $Identificador in $registroContatoIn/ns0:Tipo/ns0:Identificador
                        return
                            <ns7:Identificador>{ data($Identificador) }</ns7:Identificador>
                    }
                    {
                        for $Descricao in $registroContatoIn/ns0:Tipo/ns0:Descricao
                        return
                            <ns7:Descricao>{ data($Descricao) }</ns7:Descricao>
                    }
                </ns7:Tipo>
                <ns2:Contato>
                    <ns7:Usuario>
                        {
                            for $LoginUsuario in $registroContatoIn/ns0:Contato/ns0:Usuario/ns8:LoginUsuario
                            return
                                <ns6:LoginUsuario>{ data($LoginUsuario) }</ns6:LoginUsuario>
                        }
                        {
                            for $NomeUsuario in $registroContatoIn/ns0:Contato/ns0:Usuario/ns8:NomeUsuario
                            return
                                <ns6:NomeUsuario>{ data($NomeUsuario) }</ns6:NomeUsuario>
                        }
                        {
                            for $CPF in $registroContatoIn/ns0:Contato/ns0:Usuario/ns8:CPF
                            return
                                <ns6:CPF>{ data($CPF) }</ns6:CPF>
                        }
                        <ns6:EmailUsuario>
                            {
                                for $EnderecoEmail in $registroContatoIn/ns0:Contato/ns0:Usuario/ns8:EmailUsuario/ns8:EnderecoEmail
                                return
                                    <ns6:EnderecoEmail>{ data($EnderecoEmail) }</ns6:EnderecoEmail>
                            }
                        </ns6:EmailUsuario>
                        <ns6:TelefoneUsuario>
                            {
                                for $DDD in $registroContatoIn/ns0:Contato/ns0:Usuario/ns8:TelefoneUsuario/ns8:DDD
                                return
                                    <ns6:DDD>{ data($DDD) }</ns6:DDD>
                            }
                            {
                                for $Telefone in $registroContatoIn/ns0:Contato/ns0:Usuario/ns8:TelefoneUsuario/ns8:Telefone
                                return
                                    <ns6:Telefone>{ data($Telefone) }</ns6:Telefone>
                            }
                            {
                                for $Ramal in $registroContatoIn/ns0:Contato/ns0:Usuario/ns8:TelefoneUsuario/ns8:Ramal
                                return
                                    <ns6:Ramal>{ data($Ramal) }</ns6:Ramal>
                            }
                        </ns6:TelefoneUsuario>
                    </ns7:Usuario>
                    <ns7:Tipo>
                        {
                            for $Identificador in $registroContatoIn/ns0:Contato/ns0:Tipo/ns0:Identificador
                            return
                                <ns7:Identificador>{ data($Identificador) }</ns7:Identificador>
                        }
                        {
                            for $Descricao in $registroContatoIn/ns0:Contato/ns0:Tipo/ns0:Descricao
                            return
                                <ns7:Descricao>{ data($Descricao) }</ns7:Descricao>
                        }
                    </ns7:Tipo>
                    {
                        for $Protocolo in $registroContatoIn/ns0:Contato/ns0:Protocolo
                        return
                            <ns7:Protocolo>{ data($Protocolo) }</ns7:Protocolo>
                    }
                    {
                        for $NumeroChamado in $registroContatoIn/ns0:Contato/ns0:NumeroChamado
                        return
                            <ns7:NumeroChamado>{ data($NumeroChamado) }</ns7:NumeroChamado>
                    }
                    {
                        for $NomeContato in $registroContatoIn/ns0:Contato/ns0:NomeContato
                        return
                            <ns7:NomeContato>{ data($NomeContato) }</ns7:NomeContato>
                    }
                    <ns7:FormaContato>
                    {
                     if ($registroContatoIn/ns0:Contato/ns0:FormaContato[ends-with(@xsi:type , ':FormaContatoTelefone')]) then (
                        <ns3:FormaContatoTelefone>
	                        <ns3:DDD>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:DDD)}</ns3:DDD>
	                        <ns3:numeroTelefone>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:numeroTelefone)}</ns3:numeroTelefone>
	                        <ns3:ramal>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:ramal)}</ns3:ramal>
	                        <ns3:tipoTelefone>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:tipoTelefone)}</ns3:tipoTelefone>
                        </ns3:FormaContatoTelefone>
                     ) else (
	                     <ns3:FormaContatoTelefone/>
                     )
                     }
                     
                     {
                     if ($registroContatoIn/ns0:Contato/ns0:FormaContato[ends-with(@xsi:type , ':FormaContatoEmail')]) then (
                        <ns3:FormaContatoEmail>
	                        <ns3:EnderecoEmail>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:EnderecoEmail)}</ns3:EnderecoEmail>
                        </ns3:FormaContatoEmail>
                     ) else (
	                     <ns3:FormaContatoEmail>
	                     <ns3:EnderecoEmail/>
	                     </ns3:FormaContatoEmail>
                     )
                     }                     

                     {
                     if ($registroContatoIn/ns0:Contato/ns0:FormaContato[ends-with(@xsi:type , ':FormaContatoCorrespondencia')]) then (
                        <ns3:FormaContatoCorrespondencia>
	                        <ns3:endereco>
		<endereco:identificadorEndereco>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:identificadorEndereco)}</endereco:identificadorEndereco>
		<endereco:pais>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:pais)}</endereco:pais>
		<endereco:UF>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:UF)}</endereco:UF>
		<endereco:idCidade>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:idCidade)}</endereco:idCidade>
		<endereco:cidade>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:cidade)}</endereco:cidade>
		<endereco:CEP>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:CEP)}</endereco:CEP>
		<endereco:bairro>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:bairro)}</endereco:bairro>
		<endereco:tipoLogradouro>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:tipoLogradouro)}</endereco:tipoLogradouro>
		<endereco:idLogradouro>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:idLogradouro)}</endereco:idLogradouro>
		<endereco:logradouro>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:logradouro)}</endereco:logradouro>
		<endereco:numeroEndereco>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:numeroEndereco)}</endereco:numeroEndereco>
		<endereco:complemento>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:complemento)}</endereco:complemento>
		<endereco:referencia>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:referencia)}</endereco:referencia>
		<endereco:higienizado>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:higienizado)}</endereco:higienizado>
		<endereco:CaixaPostal>{data($registroContatoIn/ns0:Contato/ns0:FormaContato/ns0:endereco/enderecoCanon:CaixaPostal)}</endereco:CaixaPostal>		                        
							</ns3:endereco>
                        </ns3:FormaContatoCorrespondencia>
                     ) else (
	                     <ns3:FormaContatoCorrespondencia/>
                     )
                     }                     
(::                                          
                        <ns3:FormaContatoCorrespondencia>
                            <ns3:endereco>
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:identificadorEndereco/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:pais/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:UF/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:idCidade/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:cidade/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:CEP/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:bairro/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:tipoLogradouro/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:idLogradouro/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:logradouro/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:numeroEndereco/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:complemento/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:referencia/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:higienizado/>
                                }
                                {
                                    for $FormaContato in $registroContatoIn/ns0:Contato/ns0:FormaContato
                                    return
                                        <endereco:CaixaPostal/>
                                }
                            </ns3:endereco>
                        </ns3:FormaContatoCorrespondencia>
                        ::)
                    </ns7:FormaContato>
                           
                </ns2:Contato>
            </ns2:RegistroContato>
            <ns1:IdentificadorContrato>
                <ns1:NumeroContrato>{ data($identificacaoContratoIn/ns4:Contrato/ns4:NumeroContrato) }</ns1:NumeroContrato>
                <ns1:IdentificacaoCidade>{ data($identificacaoContratoIn/ns4:Contrato/ns4:IdentificacaoCidade) }</ns1:IdentificacaoCidade>
            </ns1:IdentificadorContrato>
        </ns5:incluirRegistroContato>
};

declare variable $registroContatoIn as element(ns0:RegistroContato) external;
declare variable $identificacaoContratoIn as element(ns4:IdentificacaoContrato) external;

xf:TransformarRegistroContatoCanonicoXRegistroContatoWLIXQuery($registroContatoIn,
    $identificacaoContratoIn)
