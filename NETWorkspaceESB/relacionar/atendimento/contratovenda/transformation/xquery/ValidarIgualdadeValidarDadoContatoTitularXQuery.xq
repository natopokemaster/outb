xquery version "1.0" encoding "Cp1252";
(:: pragma bea:local-element-parameter parameter="$dadoContatoTitular1" type="ns0:parametrosValidarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:local-element-parameter parameter="$dadoContatoTitular2" type="ns0:parametrosValidarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ValidarIgualdadeValidarDadoContatoTitularXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoVendaV2/";

declare function xf:ValidarIgualdadeValidarDadoContatoTitularXQuery(
	$dadoContatoTitular1 as element(),
    $dadoContatoTitular2 as element())
    as xs:boolean {
    	let $telefones1 := xf:ordenaTelefonePorTipo($dadoContatoTitular1/telefones/telefone)
    	let $telefones2 := xf:ordenaTelefonePorTipo($dadoContatoTitular2/telefones/telefone)    	
		return
			(
				every $i in 1 to max((count($telefones1), count($telefones2)))
				satisfies fn:deep-equal($telefones1[$i], $telefones2[$i]) 
			)
			and
			(
				every $i in 1 to max((count($dadoContatoTitular1/email), count($dadoContatoTitular2/email)))
				satisfies fn:deep-equal($dadoContatoTitular1/email/enderecoEmail, $dadoContatoTitular2/email/enderecoEmail) and 				
				fn:deep-equal($dadoContatoTitular1/email/aceitaContato, $dadoContatoTitular2/email/aceitaContato) 
			)
};

declare function xf:ordenaTelefonePorTipo(
	$telefonesIn as item()*)
    as item()* {
    	for $telefonesOut in $telefonesIn
    	order by $telefonesOut/tipoTelefone
    	return $telefonesOut
};
	
declare variable $dadoContatoTitular1 as element() external;
declare variable $dadoContatoTitular2 as element() external;

xf:ValidarIgualdadeValidarDadoContatoTitularXQuery($dadoContatoTitular1,
    $dadoContatoTitular2)
