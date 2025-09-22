(:: pragma bea:global-element-parameter parameter="$consultarClientePorContratoResponse1" element="ns7:consultarClientePorContratoResponse" location="../../../clienteprospect/wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)
(:: pragma bea:global-element-parameter parameter="$identificacaoContratoResponse1" element="ns2:IdentificacaoContratoResponse" location="../../../../../general/NETSMSDatabaseConfig/wsdl/proxy/TransformaIdentificacaoContratoWSDL12V1.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$dadoCadastralTitular1" type="ns4:parametrosAlterarDadoCadastralTitular/dadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$registroContato1" type="ns4:parametrosAlterarDadoCadastralTitular/registroContato" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns1:alterarDadoCadastralTitular" location="../../wsdl/business/ContratoVendaJWSBSWSDLV1_0.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/ContratoVendaV2/";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/AlterarDadoCadastralTitularXAlterarWLIXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/RegistroContato";
declare namespace ns1 = "http://br/com/netservicos/relacionar/atendimento/jws";
declare namespace ns7 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";
declare namespace ns3 = "http://www.netservicos.com.br/IdentificadorContrato";
declare namespace ns2 = "http://www.netservicos.com.br/TransformaIdentificacaoContrato12V1";
declare namespace ns5 = "http://www.netservicos.com.br/ClientePropesct/schemas";
declare namespace ns6 = "http://www.netservicos.com.br/DadoCadastralTitular";

declare function xf:AlterarDadoCadastralTitularXAlterarWLIXQuery($consultarClientePorContratoResponse1 as element(ns7:consultarClientePorContratoResponse),
    $identificacaoContratoResponse1 as element(ns2:IdentificacaoContratoResponse),
    $dadoCadastralTitular1 as element(),
    $registroContato1 as element())
    as element(ns1:alterarDadoCadastralTitular) {
        <ns1:alterarDadoCadastralTitular>
            <ns3:IdentificadorContrato>
                <NumeroContrato>{ data($identificacaoContratoResponse1/ns2:Contrato/ns2:NumeroContrato) }</NumeroContrato>
                <CodigoOperadora>{ data($identificacaoContratoResponse1/ns2:Contrato/ns2:CodigoOperadora) }</CodigoOperadora>
                <IdentificacaoCidade>{ data($identificacaoContratoResponse1/ns2:Contrato/ns2:IdentificacaoCidade) }</IdentificacaoCidade>
            </ns3:IdentificadorContrato>
            <ns6:DadoCadastralTitular>
                {
                    for $nome in $dadoCadastralTitular1/nome
                    return
                        <nome>{ data($nome) }</nome>
                }
                {
                    for $codigoSuframa in $dadoCadastralTitular1/codigoSuframa
                    return
                        <codigoSuframa>{ data($codigoSuframa) }</codigoSuframa>
                }
                {
                	for $pessoa in $dadoCadastralTitular1/pessoa
                	return
                    if (fn:upper-case(fn:data($consultarClientePorContratoResponse1/ns5:ClientesProspect/ns5:clienteProspect[1]/ns5:tipoPessoa)) eq xs:string("FISICA")) then
        				<pessoa xmlns:dad="http://www.netservicos.com.br/DadoCadastralTitular" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="dad:PessoaFisicaType">
        					{
        					for $dataNascimento in $pessoa/dataNascimento
        					return
								<dataNascimento>{fn:data($dataNascimento)}</dataNascimento>
							}
        					{
        					for $CPF in $pessoa/CPF
        					return
			                	<CPF>{fn:data($CPF)}</CPF>
			                }
        					{
        					for $RG in $pessoa/RG
        					return
			                	<RG>{fn:data($RG)}</RG>
        					}
        					{
        					for $orgaoExpedidor in $pessoa/orgaoExpedidor
        					return
			                	<orgaoExpedidor>{fn:data($orgaoExpedidor)}</orgaoExpedidor>
        					}
        					{
        					for $flagEstrangeiro in $pessoa/flagEstrangeiro
        					return
			  	            	<flagEstrangeiro>{fn:data($flagEstrangeiro)}</flagEstrangeiro>
        					}
        					{
        					for $passaporte in $pessoa/passaporte
        					return
			                	<passaporte>{fn:data($passaporte)}</passaporte>
        					}
        					{
        					for $nomePai in $pessoa/nomePai
        					return
			                	<nomePai>{fn:data($nomePai)}</nomePai>
        					}
        					{
        					for $nomeMae in $pessoa/nomeMae
        					return
			                	<nomeMae>{fn:data($nomeMae)}</nomeMae>
        					}
        					{
        					for $sexo in $pessoa/sexo
        					return
			                	<sexo>{fn:upper-case(fn:data($sexo))}</sexo>
        					}
        					{
        					for $identificacaoEstadoCivil in $pessoa/identificacaoEstadoCivil
        					return
			                	<identificacaoEstadoCivil>{fn:data($identificacaoEstadoCivil)}</identificacaoEstadoCivil>
        					}
        					{
        					for $identificacaoProfissao in $pessoa/identificacaoProfissao
        					return
			                	<identificacaoProfissao>{fn:data($identificacaoProfissao)}</identificacaoProfissao>
        					}
        					{
        					for $identificacaoEscolaridade in $pessoa/identificacaoEscolaridade
        					return
			                	<identificacaoEscolaridade>{fn:data($identificacaoEscolaridade)}</identificacaoEscolaridade>        		
			                }
		                </pessoa>
		        	else
		        		<pessoa xmlns:dad="http://www.netservicos.com.br/DadoCadastralTitular" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="dad:PessoaJuridicaType">
        					{
        					for $CNPJ in $pessoa/CNPJ
        					return
			                	<CNPJ>{fn:data($CNPJ)}</CNPJ>
			                }
        					{
        					for $InscricaoEstadual in $pessoa/InscricaoEstadual
        					return
			                	<InscricaoEstadual>{fn:data($InscricaoEstadual)}</InscricaoEstadual>
			                }
        					{
        					for $orgaoExpedidor in $pessoa/orgaoExpedidor
        					return
			                	<orgaoExpedidor>{fn:data($orgaoExpedidor)}</orgaoExpedidor>
			                }
						</pessoa>
        	
                }
            </ns6:DadoCadastralTitular>
            <ns0:registroContato>
                {
                    for $nomeContato in $registroContato1/nomeContato
                    return
                        <nomeContato>{ data($nomeContato) }</nomeContato>
                }
                {
                    for $telefoneContato in $registroContato1/telefoneContato
                    return
                        <telefoneContato>{ $telefoneContato/@* , $telefoneContato/node() }</telefoneContato>
                }
                {
                    for $observacao in $registroContato1/observacao
                    return
                        <observacao>{ data($observacao) }</observacao>
                }
            </ns0:registroContato>
        </ns1:alterarDadoCadastralTitular>
};

declare variable $consultarClientePorContratoResponse1 as element(ns7:consultarClientePorContratoResponse) external;
declare variable $identificacaoContratoResponse1 as element(ns2:IdentificacaoContratoResponse) external;
declare variable $dadoCadastralTitular1 as element() external;
declare variable $registroContato1 as element() external;

xf:AlterarDadoCadastralTitularXAlterarWLIXQuery($consultarClientePorContratoResponse1,
    $identificacaoContratoResponse1,
    $dadoCadastralTitular1,
    $registroContato1)
