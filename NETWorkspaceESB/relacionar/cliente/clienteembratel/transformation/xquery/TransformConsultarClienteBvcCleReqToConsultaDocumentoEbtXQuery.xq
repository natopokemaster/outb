xquery version "1.0" encoding "Cp1252";
(:: pragma bea:global-element-parameter parameter="$consultarClienteBvcRequest" element="ns7:consultarClienteBvcRequest" location="../../wsdl/proxy/ClienteEmbratelWSDLV1.wsdl" ::)
(:: pragma bea:global-element-return element="ns17:Data" location="../../wsdl/business/SRV-1149.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/cliente/clienteembratel/transformation/xquery/TransformConsultarClienteBvcCleReqToConsultaDocumentoBVCXQuery/";
declare namespace ns20 = "http://www.netservicos.com.br/modelocanonico/v2/bolsacredito";
declare namespace ns13 = "http://www.netservicos.com.br/modelocanonico/v2/produto";
declare namespace ns4 = "http://www.netservicos.com.br/modelocanonico/v2/endereco";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/v2/produtocontratado";
declare namespace ns7 = "http://www.netservicos.com.br/ClienteEmbratelV1";
declare namespace ns16 = "http://www.netservicos.com.br/modelocanonico/v2/oferta";
declare namespace ns5 = "http://www.netservicos.com.br/modelocanonico/v2/cliente";
declare namespace ns12 = "http://www.netservicos.com.br/modelocanonico/v2/moeda";
declare namespace ns18 = "http://www.netservicos.com.br/modelocanonico/v2/fatura";
declare namespace ns6 = "http://www.netservicos.com.br/modelocanonico/v2/venda";
declare namespace ns11 = "http://www.netservicos.com.br/modelocanonico/v2/atendimento";
declare namespace ns9 = "http://www.netservicos.com.br/modelocanonico/v2/evento";
declare namespace ns17 = "http://www.embratel.com.br/schConsultaDocumento.xsd";
declare namespace ns19 = "http://www.netservicos.com.br/modelocanonico/v2/empresa";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/formapagamento";
declare namespace ns14 = "http://www.netservicos.com.br/modelocanonico/v2/rede";
declare namespace ns3 = "http://www.netservicos.com.br/modelocanonico/v2/contrato";
declare namespace ns2 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoContrato";
declare namespace ns21 = "http://www.netservicos.com.br/modelocanonico/v2/contratoparceiro";
declare namespace ns15 = "http://www.netservicos.com.br/modelocanonico/v2/equipamento";
declare namespace ns8 = "http://www.netservicos.com.br/modelocanonico/v2/usuario";
declare namespace ns10 = "http://www.netservicos.com.br/modelocanonico/v2/cobranca";

declare function xf:transformDateAAAAmmDDToEbtDateAAAAmmDD($date as xs:string) as xs:string? {

	let $year := xs:string(fn:substring($date, 0, 5))
	let $month := xs:string(fn:substring($date, 6, 2))
	let $day := xs:string(fn:substring($date, 9, 2))
	let $hour := xs:string(fn:substring($date, 12, 2))
	let $minute := xs:string(fn:substring($date, 15, 2))
	let $seconds := xs:string(fn:substring($date, 18, 2))

	let $ebtDate := fn:concat(fn:concat(fn:concat(fn:concat(fn:concat($year, $month), $day), $hour), $minute), $seconds)
	return
		$ebtDate
};

declare function xf:TransformConsultarClienteBvcCleReqToConsultaDocumentoBVCXQuery(
		$consultarClienteBvcRequest as element(ns7:consultarClienteBvcRequest),
		$keyCodeAccess as xs:string,
		$randonToken as xs:string)
    as element(ns17:Data) {

    	let $dateTime := fn-bea:remove-timezone-from-dateTime(current-dateTime())
		let $year := fn:year-from-dateTime($dateTime)
    	return (
	        <ns17:Data>
	        	<ns17:Header>
	        		<ns17:strSystemTrackingId>{ concat($year, $randonToken) }</ns17:strSystemTrackingId>
	        		<ns17:strResubmitFlag>NEW</ns17:strResubmitFlag>
	        		<ns17:strOriginalTrackingId>{ concat('NSMS_', $randonToken) }</ns17:strOriginalTrackingId>
	        		<ns17:strSystem>NET</ns17:strSystem>
	        		<ns17:strFlagSA>S</ns17:strFlagSA>
	        		<ns17:strTimeStamp>{ xf:transformDateAAAAmmDDToEbtDateAAAAmmDD(xs:string(fn:current-dateTime())) }</ns17:strTimeStamp>
	        		<ns17:strEventType>1149</ns17:strEventType>
	        	</ns17:Header>
	            <ns17:Solicitacao>
	            	<ns17:idt_solic>{ concat($year, $randonToken) }</ns17:idt_solic>
	            	<ns17:dta_hra_solic>{ data(fn-bea:dateTime-to-string-with-format("yyyyMMddHHmmss", fn:adjust-dateTime-to-timezone(fn:current-dateTime(), ()))) }</ns17:dta_hra_solic>
	            	<ns17:ind_base_pesquisada>1</ns17:ind_base_pesquisada>
	            	<ns17:cod_chave_acesso>{ $keyCodeAccess }</ns17:cod_chave_acesso>
	            	<ns17:sgl_sist_consumidor>NSMS</ns17:sgl_sist_consumidor>
	                <ns17:PessoaRequest>
	                {
	            		(: ind_tpo_pesquisa = 1-CNPJ8, 2-CNPJ14, 3-CPF :)
	            		(: considera somente CNPJ de tamanho 14 (completo) :)
	            		if (normalize-space($consultarClienteBvcRequest/ns7:clienteProspect/ns5:ClienteProspect/ns5:CNPJ) ne '') then
	            			<ns17:ind_tpo_pesquisa>2</ns17:ind_tpo_pesquisa>
						else if(normalize-space($consultarClienteBvcRequest/ns7:clienteProspect/ns5:ClienteProspect/ns5:CPF) ne '') then (
	            		 	<ns17:ind_tpo_pesquisa>3</ns17:ind_tpo_pesquisa>
	            		) else ()
	                }
	                {
	            		if (normalize-space($consultarClienteBvcRequest/ns7:clienteProspect/ns5:ClienteProspect/ns5:CNPJ) ne '') then
							<ns17:num_doc_pessoa>{ data($consultarClienteBvcRequest/ns7:clienteProspect/ns5:ClienteProspect/ns5:CNPJ) }</ns17:num_doc_pessoa>
						else if(normalize-space($consultarClienteBvcRequest/ns7:clienteProspect/ns5:ClienteProspect/ns5:CPF) ne '') then (
	            		 	<ns17:num_doc_pessoa>{ data($consultarClienteBvcRequest/ns7:clienteProspect/ns5:ClienteProspect/ns5:CPF) }</ns17:num_doc_pessoa>
	            		) else ()
	                }
	                </ns17:PessoaRequest>
	            </ns17:Solicitacao>
	        </ns17:Data>
        )
};

declare variable $consultarClienteBvcRequest as element(ns7:consultarClienteBvcRequest) external;
declare variable $keyCodeAccess as xs:string external;
declare variable $randonToken as xs:string external;

xf:TransformConsultarClienteBvcCleReqToConsultaDocumentoBVCXQuery($consultarClienteBvcRequest, $keyCodeAccess, $randonToken)