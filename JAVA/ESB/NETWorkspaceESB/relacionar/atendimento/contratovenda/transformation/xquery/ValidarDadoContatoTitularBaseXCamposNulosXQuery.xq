(:: pragma bea:global-element-parameter parameter="$consultarClientePorContratoResponse1" element="ns2:consultarClientePorContratoResponse" location="../../../clienteprospect/wsdl/business/ClienteProspectDSLBSWSDLV1_0.wsdl" ::)
(:: pragma bea:local-element-return type="ns0:parametrosValidarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ValidarDadoContatoTitularBaseXCamposNulosXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoVendaV2/";
declare namespace ns1 = "http://www.netservicos.com.br/ClientePropesct/schemas";
declare namespace ns2 = "ld:br/com/netservicos/atendimento/webservice/ClienteProspectJWS.ws";

declare function xf:ValidarDadoContatoTitularBaseXCamposNulosXQuery($consultarClientePorContratoResponse1 as element(ns2:consultarClientePorContratoResponse))
    as element() {
        <dadoContatoTitular>
            <telefones>
                {
                    for $telefoneContato in $consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:TelefonesContato/ns1:telefoneContato
                    return
                    	if (data($telefoneContato/ns1:tipoTelefone) ne "netfone") then
	                        <telefone>
	                            <dddTelefone>{ data($telefoneContato/ns1:DDD) }</dddTelefone>
	                            <numeroTelefone>{ data($telefoneContato/ns1:numeroTelefone) }</numeroTelefone>
	                            <ramal>{ data($telefoneContato/ns1:ramal) }</ramal>                           
	                            <tipoTelefone>{ fn:upper-case(data($telefoneContato/ns1:tipoTelefone)) }</tipoTelefone>
	                        </telefone>
	                    else ()
                }
            </telefones>
            <email>
                <enderecoEmail>{ data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:Emails/ns1:Emails[1]/ns1:EnderecoEmail) }</enderecoEmail>
                <tipoEmail>{ data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:Emails/ns1:Emails[1]/ns1:TipoEmail) }</tipoEmail>
                <aceitaContato>{ data($consultarClientePorContratoResponse1/ns1:ClientesProspect/ns1:clienteProspect[1]/ns1:Emails/ns1:Emails[1]/ns1:AceitaContato) }</aceitaContato>
            </email>
        </dadoContatoTitular>
};

declare variable $consultarClientePorContratoResponse1 as element(ns2:consultarClientePorContratoResponse) external;

xf:ValidarDadoContatoTitularBaseXCamposNulosXQuery($consultarClientePorContratoResponse1)
