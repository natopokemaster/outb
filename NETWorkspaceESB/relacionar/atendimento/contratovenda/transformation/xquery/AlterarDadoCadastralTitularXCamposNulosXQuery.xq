xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$consultarClientePorContratoResponse1" element="ns2:consultarClientePorContratoResponse" location="../../../clienteprospect/wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$dadoCadastralTitular1" type="ns0:parametrosAlterarDadoCadastralTitular/dadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:local-element-return type="ns0:parametrosAlterarDadoCadastralTitular/dadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/AlterarDadoCadastralTitularXCamposNulosXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoVendaV2/";
declare namespace ns1 = "http://www.netservicos.com.br/ClientePropesct/schemas";
declare namespace ns2 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";

declare function xf:AlterarDadoCadastralTitularXCamposNulosXQuery($consultarClientePorContratoResponse1 as element(ns2:consultarClientePorContratoResponse),
    $dadoCadastralTitular1 as element())
    as element() {
        <dadoCadastralTitular xmlns:con="http://www.netservicos.com.br/ContratoVendaV2/">
        	<nome>{ data($dadoCadastralTitular1/nome) }</nome>
        	<codigoSuframa>{ data($dadoCadastralTitular1/codigoSuframa) }</codigoSuframa>
        	{
        	if (fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:tipoPessoa) eq xs:string("fisica")) then
        		<pessoa xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="con:PessoaFisicaType">
					<dataNascimento>{fn:data($dadoCadastralTitular1/pessoa/dataNascimento)}</dataNascimento>
                	<CPF>{fn:data($dadoCadastralTitular1/pessoa/CPF)}</CPF>
                	<RG>{fn:data($dadoCadastralTitular1/pessoa/RG)}</RG>
                	<orgaoExpedidor>{fn:data($dadoCadastralTitular1/pessoa/orgaoExpedidor)}</orgaoExpedidor>
  	            	{
  	            	if(not($dadoCadastralTitular1/pessoa/flagEstrangeiro/node())) then
  	            		<flagEstrangeiro>{fn:false()}</flagEstrangeiro>
					else
  	            		<flagEstrangeiro>{fn:data($dadoCadastralTitular1/pessoa/flagEstrangeiro)}</flagEstrangeiro>
					}
                	{
                	if(xs:boolean(fn:data($dadoCadastralTitular1/pessoa/flagEstrangeiro))) then
                		<passaporte>{fn:data($dadoCadastralTitular1/pessoa/RG)}</passaporte>
                	else ()
                	}
                	<nomePai>{fn:data($dadoCadastralTitular1/pessoa/nomePai)}</nomePai>
                	<nomeMae>{fn:data($dadoCadastralTitular1/pessoa/nomeMae)}</nomeMae>
                	<sexo>{fn:upper-case(fn:data($dadoCadastralTitular1/pessoa/sexo))}</sexo>
                	<identificacaoEstadoCivil>{fn:data($dadoCadastralTitular1/pessoa/identificacaoEstadoCivil)}</identificacaoEstadoCivil>
                	<identificacaoProfissao>{fn:data($dadoCadastralTitular1/pessoa/identificacaoProfissao)}</identificacaoProfissao>
                	<identificacaoEscolaridade>{fn:data($dadoCadastralTitular1/pessoa/identificacaoEscolaridade)}</identificacaoEscolaridade>        		
                </pessoa>
        	else
        		<pessoa xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="con:PessoaJuridicaType">
                	<CNPJ>{fn:data($dadoCadastralTitular1/pessoa/CNPJ)}</CNPJ>
                	<InscricaoEstadual>{fn:data($dadoCadastralTitular1/pessoa/InscricaoEstadual)}</InscricaoEstadual>
                	<orgaoExpedidor>{fn:data($dadoCadastralTitular1/pessoa/orgaoExpedidor)}</orgaoExpedidor>
				</pessoa>
        	}
        </dadoCadastralTitular>
};

declare variable $consultarClientePorContratoResponse1 as element(ns2:consultarClientePorContratoResponse) external;
declare variable $dadoCadastralTitular1 as element() external;

xf:AlterarDadoCadastralTitularXCamposNulosXQuery($consultarClientePorContratoResponse1,
    $dadoCadastralTitular1)
