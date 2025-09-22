(:: pragma bea:global-element-parameter parameter="$contratos1" element="ns0:contratos" location="../schema/ContratoAssinante.xsd" ::)
(:: pragma bea:global-element-return element="ns2:identificarContratoRequestResponse" location="../wsdl/business/IdentificarContratos11V1.wsdl" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/retornoConsultarContratoXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoAssinante";
declare namespace ns1 = "http://netservicos.com.br/core/schema";
declare namespace ns3 = "http://netservicos.com.br/atender/contrato/schema";
declare namespace ns2 = "http://www.openuri.org/";

declare function xf:retornoConsultarContratoXQuery($contratos1 as element(ns0:contratos))
    as element(ns2:identificarContratoRequestResponse) {
        <ns2:identificarContratoRequestResponse>
            <ns3:RetornoIdentificaContrato>
            	<ns1:RetornoPadrao>
               		<ns1:RetornoPadraoRow>
                  		<PROVEDOR>br.com.netservicos.atender.processos.IdentificarContratos</PROVEDOR>
                  		<CATEGORIA_MENSAGEM>SUCESSO</CATEGORIA_MENSAGEM>
                  		<CODIGO_MENSAGEM>ATR-0000</CODIGO_MENSAGEM>
                  		<TEXTO_MENSAGEM>Operação executada com sucesso</TEXTO_MENSAGEM>
               		</ns1:RetornoPadraoRow>
            	</ns1:RetornoPadrao>
                <ns3:ContratoAssinante>
                
                {for $contratoAssinante in $contratos1/ns0:contratoAssinante
                return
                   <ns3:ContratoAssinanteRow>
                        <SCO_COD_OPERADORA>{ data($contratoAssinante/ns0:SCO_COD_OPERADORA) }</SCO_COD_OPERADORA>
                        <SC_NUM_CONTRATO>{ data($contratoAssinante/ns0:SC_NUM_CONTRATO) }</SC_NUM_CONTRATO>
                        <SC_CID_CONTRATO>{ data($contratoAssinante/ns0:SC_CID_CONTRATO) }</SC_CID_CONTRATO>
                        <SC_ID_TIPO_CONTRATO>{ data($contratoAssinante/ns0:SC_ID_TIPO_CONTRATO) }</SC_ID_TIPO_CONTRATO>
                        <SA_NOME_TITULAR>{ data($contratoAssinante/ns0:SA_NOME_TITULAR) }</SA_NOME_TITULAR>
                        <SA_CPF>{ data($contratoAssinante/ns0:SA_CPF) }</SA_CPF>
                        <SA_ID_TIPO_PESSOA>{ data($contratoAssinante/ns0:SA_ID_TIPO_PESSOA) }</SA_ID_TIPO_PESSOA>
                        <SRAS_ID_TIPO_SEGMENTO>{ data($contratoAssinante/ns0:SRAS_ID_TIPO_SEGMENTO) }</SRAS_ID_TIPO_SEGMENTO>
                        <STS_DESCRICAO>{ data($contratoAssinante/ns0:STS_DESCRICAO) }</STS_DESCRICAO>
                        <SRSCA_ID_STATUS>{ data($contratoAssinante/ns0:SRSCA_ID_STATUS) }</SRSCA_ID_STATUS>
                        <SSC_DESCRICAO>{ data($contratoAssinante/ns0:SSC_DESCRICAO) }</SSC_DESCRICAO>
                        <SCO_ID_EMPRESA>{ data($contratoAssinante/ns0:SCO_ID_EMPRESA) }</SCO_ID_EMPRESA>
                        <SDV_DIA>{ data($contratoAssinante/ns0:SDV_DIA) }</SDV_DIA>
                        <SC_DT_CADASTRO>{ data($contratoAssinante/ns0:SC_DT_CADASTRO) }</SC_DT_CADASTRO>
                        <SC_ID_TIPO_COBRANCA>{ data($contratoAssinante/ns0:SC_ID_TIPO_COBRANCA) }</SC_ID_TIPO_COBRANCA>
                        <STC_DESCRICAO>{ data($contratoAssinante/ns0:STC_DESCRICAO) }</STC_DESCRICAO>
                        <SA_ID_ENDER_INSTALACAO>{ data($contratoAssinante/ns0:SA_ID_ENDER_INSTALACAO) }</SA_ID_ENDER_INSTALACAO>
                        <SE_ID_EDIFICACAO>{ data($contratoAssinante/ns0:SE_ID_EDIFICACAO) }</SE_ID_EDIFICACAO>
                        <COD_IMOVEL>{ data($contratoAssinante/ns0:COD_IMOVEL) }</COD_IMOVEL>
                        <NODE>{ data($contratoAssinante/ns0:NODE) }</NODE>
                        <CELULA>{ data($contratoAssinante/ns0:CELULA) }</CELULA>
                        <FLAG_PJ>{ data($contratoAssinante/ns0:FLAG_PJ) }</FLAG_PJ>
                        <STATUS_ADIMPL>{ data($contratoAssinante/ns0:STATUS_ADIMPL) }</STATUS_ADIMPL>
                        <FLAG_PAYTV_ANALOGICO>{ data($contratoAssinante/ns0:FLAG_PAYTV_ANALOGICO) }</FLAG_PAYTV_ANALOGICO>
                        <FLAG_PAYTV_DIGITAL>{ data($contratoAssinante/ns0:FLAG_PAYTV_DIGITAL) }</FLAG_PAYTV_DIGITAL>
                        <FLAG_INTERNET>{ data($contratoAssinante/ns0:FLAG_INTERNET) }</FLAG_INTERNET>
                        <FLAG_NETFONE>{ data($contratoAssinante/ns0:FLAG_NETFONE) }</FLAG_NETFONE>
                        <FLAG_VENDA_PPV_EVENTO>{ data($contratoAssinante/ns0:FLAG_VENDA_PPV_EVENTO) }</FLAG_VENDA_PPV_EVENTO>
                        <FLAG_NODE_SD>{ data($contratoAssinante/ns0:FLAG_NODE_SD) }</FLAG_NODE_SD>
                        <SRCPC_ID_PERFIL_CLIENTE>{ data($contratoAssinante/ns0:SRCPC_ID_PERFIL_CLIENTE) }</SRCPC_ID_PERFIL_CLIENTE>
                        <SRAP_DESCRICAO>{ data($contratoAssinante/ns0:SRAP_DESCRICAO) }</SRAP_DESCRICAO>
                        <SA_E_MAIL>{ data($contratoAssinante/ns0:SA_E_MAIL) }</SA_E_MAIL>
                    </ns3:ContratoAssinanteRow>
                    }
                    
                </ns3:ContratoAssinante>
            </ns3:RetornoIdentificaContrato>
        </ns2:identificarContratoRequestResponse>
};

declare variable $contratos1 as element(ns0:contratos) external;

xf:retornoConsultarContratoXQuery($contratos1)
