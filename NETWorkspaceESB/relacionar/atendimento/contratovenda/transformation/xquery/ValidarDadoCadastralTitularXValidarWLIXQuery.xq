(:: pragma bea:global-element-parameter parameter="$identificacaoContratoResponse1" element="ns1:IdentificacaoContratoResponse" location="../../../../../general/NETSMSDatabaseConfig/wsdl/proxy/TransformaIdentificacaoContratoWSDL12V1.wsdl" ::)
(:: pragma bea:global-element-parameter parameter="$consultarClientePorContratoResponse1" element="ns6:consultarClientePorContratoResponse" location="../../../clienteprospect/wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$dadoCadastralTitular1" type="ns3:parametrosValidarDadoCadastralTitular/dadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:validarDadoCadastralTitular" location="../../wsdl/business/ContratoVendaJWSBSWSDLV1_0.wsdl" ::)

declare namespace ns4 = "http://www.netservicos.com.br/ClientePropesct/schemas";
declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ValidarDadoCadastralTitularXValidarWLIXQuery/";
declare namespace ns0 = "http://br/com/netservicos/relacionar/atendimento/jws";
declare namespace ns1 = "http://www.netservicos.com.br/TransformaIdentificacaoContrato12V1";
declare namespace ns3 = "http://www.netservicos.com.br/ContratoVendaV2/";
declare namespace ns2 = "http://www.netservicos.com.br/IdentificadorContrato";
declare namespace ns5 = "http://www.netservicos.com.br/DadoCadastralTitular";
declare namespace ns6 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";

declare function xf:ValidarDadoCadastralTitularXValidarWLIXQuery($identificacaoContratoResponse1 as element(ns1:IdentificacaoContratoResponse),
    $consultarClientePorContratoResponse1 as element(ns6:consultarClientePorContratoResponse),
    $dadoCadastralTitular1 as element())
    as element(ns0:validarDadoCadastralTitular) {
        <ns0:validarDadoCadastralTitular>
            <ns2:IdentificadorContrato>
                <NumeroContrato>{ data($identificacaoContratoResponse1/ns1:Contrato/ns1:NumeroContrato) }</NumeroContrato>
                <CodigoOperadora>{ data($identificacaoContratoResponse1/ns1:Contrato/ns1:CodigoOperadora) }</CodigoOperadora>
                <IdentificacaoCidade>{ data($identificacaoContratoResponse1/ns1:Contrato/ns1:IdentificacaoCidade) }</IdentificacaoCidade>
            </ns2:IdentificadorContrato>
            <ns5:DadoCadastralTitular>
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
                    if (fn:upper-case(fn:data($consultarClientePorContratoResponse1/ns4:ClientesProspect/ns4:clienteProspect[1]/ns4:tipoPessoa)) eq xs:string("FISICA")) then
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
		  	            		<flagEstrangeiro>{ fn:data($flagEstrangeiro) }</flagEstrangeiro>
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
            </ns5:DadoCadastralTitular>
        </ns0:validarDadoCadastralTitular>
};

declare variable $identificacaoContratoResponse1 as element(ns1:IdentificacaoContratoResponse) external;
declare variable $consultarClientePorContratoResponse1 as element(ns6:consultarClientePorContratoResponse) external;
declare variable $dadoCadastralTitular1 as element() external;

xf:ValidarDadoCadastralTitularXValidarWLIXQuery($identificacaoContratoResponse1,
    $consultarClientePorContratoResponse1,
    $dadoCadastralTitular1)
