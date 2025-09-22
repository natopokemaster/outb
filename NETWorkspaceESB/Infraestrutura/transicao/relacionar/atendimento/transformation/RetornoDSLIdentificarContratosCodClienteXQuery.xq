(:: pragma bea:global-element-parameter parameter="$identificarContratoPorCodigoClienteResponse1" element="ns1:identificarContratoPorCodigoClienteResponse" location="../wsdl/business/IdentificarContratosDSL.wsdl" ::)
(:: pragma bea:global-element-return element="ns0:contratos" location="../schema/ContratoAssinante.xsd" ::)

declare namespace xf = "http://tempuri.org/Infraestrutura/transicao/relacionar/atendimento/transformation/RetornoDSLIdentificarContratosCodClienteXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/ContratoAssinante";
declare namespace ns1 = "ld:br/com/netservicos/atendimento/webservice/IdentificarContratosJWS.ws";

declare function xf:RetornoDSLIdentificarContratosCodClienteXQuery($identificarContratoPorCodigoClienteResponse1 as element(ns1:identificarContratoPorCodigoClienteResponse))
    as element(ns0:contratos) {
        <ns0:contratos>
            {
                for $c in $identificarContratoPorCodigoClienteResponse1/ns0:contratoAssinante
                return
                    <ns0:contratoAssinante>
                        <ns0:CELULA>{ data($c/ns0:CELULA) }</ns0:CELULA>
                        <ns0:COD_IMOVEL>{ data($c/ns0:COD_IMOVEL) }</ns0:COD_IMOVEL>
                        <ns0:FLAG_INTERNET>{ data($c/ns0:SG_NEGOCIO/ns0:FLAG_INTERNET) }</ns0:FLAG_INTERNET>
                        <ns0:FLAG_NODE_SD>{ data($c/ns0:FLAG_NODE_SD) }</ns0:FLAG_NODE_SD>
                        <ns0:FLAG_PAYTV_ANALOGICO>{ data($c/ns0:SG_NEGOCIO/ns0:FLAG_PAYTV_ANALOGICO) }</ns0:FLAG_PAYTV_ANALOGICO>
                        <ns0:FLAG_PAYTV_DIGITAL>{ data($c/ns0:SG_NEGOCIO/ns0:FLAG_PAYTV_DIGITAL) }</ns0:FLAG_PAYTV_DIGITAL>
                        <ns0:FLAG_PJ>{ data($c/ns0:FLAG_PJ) }</ns0:FLAG_PJ>
                        <ns0:FLAG_VENDA_PPV_EVENTO>{ data($c/ns0:FLAG_VENDA_PPV_EVENTO) }</ns0:FLAG_VENDA_PPV_EVENTO>
                        <ns0:NODE>{ data($c/ns0:NODE) }</ns0:NODE>
                        <ns0:SA_CPF>{ data($c/ns0:SA_CPF) }</ns0:SA_CPF>
                        <ns0:SA_E_MAIL>{ data($c/ns0:SA_E_MAIL) }</ns0:SA_E_MAIL>
                        <ns0:SA_ID_ENDER_INSTALACAO>{ data($c/ns0:SA_ID_ENDER_INSTALACAO) }</ns0:SA_ID_ENDER_INSTALACAO>
                        <ns0:SA_ID_TIPO_PESSOA>{ data($c/ns0:SA_ID_TIPO_PESSOA) }</ns0:SA_ID_TIPO_PESSOA>
                        <ns0:SA_NOME_TITULAR>{ data($c/ns0:SA_NOME_TITULAR) }</ns0:SA_NOME_TITULAR>
                        <ns0:SC_CID_CONTRATO>{ data($c/ns0:SC_CID_CONTRATO) }</ns0:SC_CID_CONTRATO>
                        <ns0:SC_DT_CADASTRO>{ data($c/ns0:SC_DT_CADASTRO) }</ns0:SC_DT_CADASTRO>
                        <ns0:SC_ID_TIPO_COBRANCA>{ data($c/ns0:SC_ID_TIPO_COBRANCA) }</ns0:SC_ID_TIPO_COBRANCA>
                        <ns0:SC_ID_TIPO_CONTRATO>{ data($c/ns0:SC_ID_TIPO_CONTRATO) }</ns0:SC_ID_TIPO_CONTRATO>
                        <ns0:SC_NUM_CONTRATO>{ data($c/ns0:SC_NUM_CONTRATO) }</ns0:SC_NUM_CONTRATO>
                        <ns0:SCO_COD_OPERADORA>{ data($c/ns0:SCO_COD_OPERADORA) }</ns0:SCO_COD_OPERADORA>
                        <ns0:SCO_ID_EMPRESA>{ data($c/ns0:SCO_ID_EMPRESA) }</ns0:SCO_ID_EMPRESA>
                        <ns0:SDV_DIA>{ data($c/ns0:SDV_DIA) }</ns0:SDV_DIA>
                        <ns0:SE_ID_EDIFICACAO>{ data($c/ns0:SE_ID_EDIFICACAO) }</ns0:SE_ID_EDIFICACAO>
                        <ns0:SRAP_DESCRICAO>{ data($c/ns0:SRAP_DESCRICAO) }</ns0:SRAP_DESCRICAO>
                        <ns0:SRAS_ID_TIPO_SEGMENTO>{ data($c/ns0:SRAS_ID_TIPO_SEGMENTO) }</ns0:SRAS_ID_TIPO_SEGMENTO>
                        <ns0:SRCPC_ID_PERFIL_CLIENTE>{ data($c/ns0:SRCPC_ID_PERFIL_CLIENTE) }</ns0:SRCPC_ID_PERFIL_CLIENTE>
                        <ns0:SRSCA_ID_STATUS>{ data($c/ns0:SRSCA_ID_STATUS) }</ns0:SRSCA_ID_STATUS>
                        <ns0:SSC_DESCRICAO>{ data($c/ns0:SSC_DESCRICAO) }</ns0:SSC_DESCRICAO>
                        <ns0:STATUS_ADIMPL>{ data($c/ns0:STATUS_ADIMPL) }</ns0:STATUS_ADIMPL>
                        <ns0:STC_DESCRICAO>{ data($c/ns0:STC_DESCRICAO) }</ns0:STC_DESCRICAO>
                        <ns0:STS_DESCRICAO>{ data($c/ns0:STS_DESCRICAO) }</ns0:STS_DESCRICAO>
                        <ns0:FLAG_NETFONE>{ data($c/ns0:SG_NEGOCIO/ns0:FLAG_NETFONE) }</ns0:FLAG_NETFONE>
                        <ns0:DT_NASCIMENTO>{ data($c/ns0:DT_NASCIMENTO) }</ns0:DT_NASCIMENTO>                    
                        <ns0:FLAG_AREA_NOW>{ data($c/ns0:FLAG_AREA_NOW) }</ns0:FLAG_AREA_NOW>
                        <ns0:FLAG_CHIP_CLARO>{ data($c/ns0:FLAG_CHIP_CLARO) }</ns0:FLAG_CHIP_CLARO>
                        <ns0:FLAG_CLOUD>{ data($c/ns0:FLAG_CLOUD) }</ns0:FLAG_CLOUD>
                    </ns0:contratoAssinante>
            }
        </ns0:contratos>
};

declare variable $identificarContratoPorCodigoClienteResponse1 as element(ns1:identificarContratoPorCodigoClienteResponse) external;

xf:RetornoDSLIdentificarContratosCodClienteXQuery($identificarContratoPorCodigoClienteResponse1)
