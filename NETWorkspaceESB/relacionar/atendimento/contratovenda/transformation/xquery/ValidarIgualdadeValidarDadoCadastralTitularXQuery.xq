xquery version "1.0" encoding "Cp1252";
(:: pragma bea:local-element-parameter parameter="$dadoCadastralTitular1" type="ns0:parametrosValidarDadoCadastralTitular/dadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$dadoCadastralTitular2" type="ns0:parametrosValidarDadoCadastralTitular/dadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ValidarIgualdadeDadoCadastralTitularXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoVendaV2/";

declare function xf:ValidarIgualdadeDadoCadastralTitularXQuery($dadoCadastralTitular1 as element(),
    $dadoCadastralTitular2 as element(),
    $tipoPessoa as xs:string)
    as xs:boolean {
        xs:boolean(
			if ($tipoPessoa eq "fisica") then (
					data($dadoCadastralTitular1/nome) eq data($dadoCadastralTitular2/nome)
				and data($dadoCadastralTitular1/codigoSuframa) eq data($dadoCadastralTitular2/codigoSuframa)
				and data($dadoCadastralTitular1/pessoa/CPF) eq data($dadoCadastralTitular2/pessoa/CPF)
				and data($dadoCadastralTitular1/pessoa/RG) eq data($dadoCadastralTitular2/pessoa/RG)
				and data($dadoCadastralTitular1/pessoa/dataNascimento) eq data($dadoCadastralTitular2/pessoa/dataNascimento)
				and data($dadoCadastralTitular1/pessoa/orgaoExpedidor) eq data($dadoCadastralTitular2/pessoa/orgaoExpedidor)
				and data($dadoCadastralTitular1/pessoa/flagEstrangeiro) eq data($dadoCadastralTitular2/pessoa/flagEstrangeiro)
				and data($dadoCadastralTitular1/pessoa/nomePai) eq data($dadoCadastralTitular2/pessoa/nomePai)
				and data($dadoCadastralTitular1/pessoa/nomeMae) eq data($dadoCadastralTitular2/pessoa/nomeMae)
				and data($dadoCadastralTitular1/pessoa/sexo) eq data($dadoCadastralTitular2/pessoa/sexo)
				and data($dadoCadastralTitular1/pessoa/identificacaoEstadoCivil) eq data($dadoCadastralTitular2/pessoa/identificacaoEstadoCivil)
				and data($dadoCadastralTitular1/pessoa/identificacaoProfissao) eq data($dadoCadastralTitular2/pessoa/identificacaoProfissao)
				and data($dadoCadastralTitular1/pessoa/identificacaoEscolaridade) eq data($dadoCadastralTitular2/pessoa/identificacaoEscolaridade)								
			)  else (
					data($dadoCadastralTitular1/nome) eq data($dadoCadastralTitular2/nome)
				and data($dadoCadastralTitular1/codigoSuframa) eq data($dadoCadastralTitular2/codigoSuframa)
				and data($dadoCadastralTitular1/pessoa/CNPJ) eq data($dadoCadastralTitular2/pessoa/CNPJ)
				and data($dadoCadastralTitular1/pessoa/InscricaoEstadual) eq data($dadoCadastralTitular2/pessoa/InscricaoEstadual)
				and data($dadoCadastralTitular1/pessoa/orgaoExpedidor) eq data($dadoCadastralTitular2/pessoa/orgaoExpedidor)
			)
		)
};

declare variable $dadoCadastralTitular1 as element() external;
declare variable $dadoCadastralTitular2 as element() external;
declare variable $tipoPessoa as xs:string external;

xf:ValidarIgualdadeDadoCadastralTitularXQuery($dadoCadastralTitular1,
    $dadoCadastralTitular2,
    $tipoPessoa)
