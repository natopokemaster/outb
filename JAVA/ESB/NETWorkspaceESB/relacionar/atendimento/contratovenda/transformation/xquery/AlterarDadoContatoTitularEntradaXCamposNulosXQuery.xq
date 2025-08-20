xquery version "1.0" encoding "Cp1252";
(:: pragma bea:local-element-parameter parameter="$dadoContatoTitular1" type="ns0:parametrosAlterarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)
(:: pragma bea:local-element-return type="ns0:parametrosAlterarDadoContatoTitular/dadoContatoTitular" location="../../wsdl/proxyservice/ContratoVendaWSDLV2_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/relacionar/atendimento/contratovenda/transformation/xquery/AlterarDadoContatoTitularEntradaXCamposNulos/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoVendaV2/";

declare function xf:AlterarDadoContatoTitularEntradaXCamposNulos($dadoContatoTitular1 as element())
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

                {
                if (compare(upper-case(data($dadoContatoTitular1/email/aceitaContato)), "TRUE") = 0) then
                	<aceitaContato>1</aceitaContato>              
                else
	                if (compare(upper-case(data($dadoContatoTitular1/email/aceitaContato)), "FALSE") = 0) then
	                	<aceitaContato>0</aceitaContato>                              	                
	                else
	                	<aceitaContato>{ data($dadoContatoTitular1/email/aceitaContato) }</aceitaContato>                              
                }
                
            </email>
        </dadoContatoTitular>
};

declare variable $dadoContatoTitular1 as element() external;

xf:AlterarDadoContatoTitularEntradaXCamposNulos($dadoContatoTitular1)
