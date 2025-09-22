(:: pragma bea:global-element-return element="ns0:resultadoConsultarDadosCertidaoNascimento" location="../../WSDL/proxy/ValidaCertidaoNascimentoWSDL12V2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/Equipamento/ValidarCertidaoNascimento/transformation/xquery/TransformarConsultarDadosCertidaoNascRespXquery/";
declare namespace ns0 = "http://www.netservicos.com.br/ValidaCertidaoNascimento/";

declare function xf:TransformarConsultarDadosCertidaoNascRespXquery($consultarDadosCertidaoNascimentoResponse as xs:string)
    as element(ns0:resultadoConsultarDadosCertidaoNascimento) {
        
        let $dadosCertidao := tokenize($consultarDadosCertidaoNascimentoResponse, ",")
        return
	        <ns0:resultadoConsultarDadosCertidaoNascimento>
	            <ns0:caIdStatus>{ substring-after(data($dadosCertidao[1]), ":")}</ns0:caIdStatus>
	            <ns0:dataInstalacao>{ substring-after(data($dadosCertidao[2]), ":")}</ns0:dataInstalacao>
	            <ns0:horaInstalacao>{ substring-after(data($dadosCertidao[3]), ":")}</ns0:horaInstalacao>
	            <ns0:flagRegiao>{ xs:int(substring-after(data($dadosCertidao[4]), ":"))}</ns0:flagRegiao>
	            <ns0:statusFinal>{ substring-after(data($dadosCertidao[5]), ":")}</ns0:statusFinal>
	            <ns0:stbType>{ substring-after(data($dadosCertidao[6]), ":")}</ns0:stbType>
	            <ns0:idQs>{ substring-after(data($dadosCertidao[7]), ":")}</ns0:idQs>
	            <ns0:nvQs>{ substring-after(data($dadosCertidao[8]), ":")}</ns0:nvQs>
	        </ns0:resultadoConsultarDadosCertidaoNascimento>
};

declare variable $consultarDadosCertidaoNascimentoResponse as xs:string external;

xf:TransformarConsultarDadosCertidaoNascRespXquery($consultarDadosCertidaoNascimentoResponse)
