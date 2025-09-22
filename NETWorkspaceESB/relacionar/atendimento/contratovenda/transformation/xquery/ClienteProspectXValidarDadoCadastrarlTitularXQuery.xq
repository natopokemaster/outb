(:: pragma bea:global-element-parameter parameter="$consultarClientePorContratoResponse1" element="ns2:consultarClientePorContratoResponse" location="../../../clienteprospect/wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)
(:: pragma bea:local-element-return type="ns0:parametrosValidarDadoCadastralTitular/dadoCadastralTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ClienteProspectXDadoCadastrarlTitularXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoVendaV2/";
declare namespace ns1 = "http://www.netservicos.com.br/ClientePropesct/schemas";
declare namespace ns2 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";

declare function xf:ClienteProspectXDadoCadastrarlTitularXQuery($consultarClientePorContratoResponse1 as element(ns2:consultarClientePorContratoResponse))
    as element() {
        <dadoCadastralTitular xmlns:con="http://www.netservicos.com.br/ContratoVendaV2/">
        	<nome>{ data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:nome) }</nome>
        	<codigoSuframa>{ data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:CodigoSuframa) }</codigoSuframa>
        	{
        	if (fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:tipoPessoa) eq xs:string("fisica")) then
        		<pessoa xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="con:PessoaFisicaType">
				<dataNascimento>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:DataNascimento)}</dataNascimento>
                <CPF>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:CPF)}</CPF>
                <RG>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:RG)}</RG>
                <orgaoExpedidor>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:OrgaoExpedidor)}</orgaoExpedidor>
  	            {
  	            if(not($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:IndicadorDeEstrangeiro/node())) then
  	            	<flagEstrangeiro>{fn:false()}</flagEstrangeiro>
				else
  	            	<flagEstrangeiro>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:IndicadorDeEstrangeiro)}</flagEstrangeiro>
				}
                {
                if(xs:boolean(fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:IndicadorDeEstrangeiro))) then
                	<passaporte>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:RG)}</passaporte>
                else ()
                }
                <nomePai>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:NomePai)}</nomePai>
                <nomeMae>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:NomeMae)}</nomeMae>
                <sexo>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:Sexo)}</sexo>
                <identificacaoEstadoCivil>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:EstadoCivil/ns1:Identificador)}</identificacaoEstadoCivil>
                <identificacaoProfissao>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:Profissao/ns1:Identificador)}</identificacaoProfissao>
                <identificacaoEscolaridade>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:GrauDeInstrucao/ns1:Identificador)}</identificacaoEscolaridade>        		</pessoa>
        	else
        		<pessoa xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:type="con:PessoaJuridicaType">
                	<CNPJ>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:CNPJ)}</CNPJ>
                	<InscricaoEstadual>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:InscricaoEstadual)}</InscricaoEstadual>
                	<orgaoExpedidor>{fn:data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:OrgaoExpedidor)}</orgaoExpedidor>
				</pessoa>
        	}
        </dadoCadastralTitular>
};

declare variable $consultarClientePorContratoResponse1 as element(ns2:consultarClientePorContratoResponse) external;

xf:ClienteProspectXDadoCadastrarlTitularXQuery($consultarClientePorContratoResponse1)
