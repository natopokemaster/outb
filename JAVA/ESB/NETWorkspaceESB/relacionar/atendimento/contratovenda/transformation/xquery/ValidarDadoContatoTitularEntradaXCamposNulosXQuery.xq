(:: pragma bea:local-element-parameter parameter="$dadoContatoTitular1" type="ns0:parametrosValidarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:local-element-return type="ns0:parametrosValidarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/ValidarDadoContatoTitularXCamposNulosXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoVendaV2/";

declare function xf:ValidarDadoContatoTitularXCamposNulosXQuery($dadoContatoTitular1 as element())
    as element() {
        <dadoContatoTitular>
            {
                for $telefones in $dadoContatoTitular1/telefones
                return
                    <telefones>
                        {
                            for $telefone in $telefones/telefone
                            return
                                <telefone>
                                    <dddTelefone>{ data($telefone/dddTelefone) }</dddTelefone>
                                    <numeroTelefone>{ data($telefone/numeroTelefone) }</numeroTelefone>
                                    <ramal>{ data($telefone/ramal) }</ramal>                                    
                                    <tipoTelefone>{ fn:upper-case(data($telefone/tipoTelefone)) }</tipoTelefone>
                                </telefone>
                        }
                    </telefones>
            }
            <email>                
            	<enderecoEmail>{ data($dadoContatoTitular1/email/enderecoEmail) }</enderecoEmail>
                <tipoEmail>{ data($dadoContatoTitular1/email/tipoEmail) }</tipoEmail>
                <aceitaContato>{ data($dadoContatoTitular1/email/aceitaContato) }</aceitaContato>              
            </email>
        </dadoContatoTitular>
};

declare variable $dadoContatoTitular1 as element() external;

xf:ValidarDadoContatoTitularXCamposNulosXQuery($dadoContatoTitular1)
