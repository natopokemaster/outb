(:: pragma bea:global-element-return element="ns1:inserirRegistroConsultaRestricaoContatoProcon" location="../../wsdl/business/RestricaoContatoProconDSLBSV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/vender/venda/procon/transformation/xquery/InserirRegistroConsultaRestricaoContatoProconXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/venda/procon/physical/procon/table/ConsultaTelefoneLogDSP";
declare namespace ns1 = "ld:br/com/netservicos/venda/procon/logical/RestricaoContatoProconDSL_ws";

declare function xf:InserirRegistroConsultaRestricaoContatoProconXQuery($numeroTelefone as xs:string,
    $statusBloqueio as xs:string,
    $usuario as xs:string)
    as element(ns1:inserirRegistroConsultaRestricaoContatoProcon) {
        <ns1:inserirRegistroConsultaRestricaoContatoProcon>
            <ns1:arg0>
                <ns0:ConsultaTelefoneLogDSP>
                    <NM_USUARIO>{ $usuario }</NM_USUARIO>
                    <DH_CONSULTA>{ fn:current-dateTime() }</DH_CONSULTA>
                    <NR_TELEFONE>{ $numeroTelefone }</NR_TELEFONE>
                    <ST_BLOQUEIO>{ $statusBloqueio }</ST_BLOQUEIO>
                </ns0:ConsultaTelefoneLogDSP>
            </ns1:arg0>
        </ns1:inserirRegistroConsultaRestricaoContatoProcon>
};

declare variable $numeroTelefone as xs:string external;
declare variable $statusBloqueio as xs:string external;
declare variable $usuario as xs:string external;

xf:InserirRegistroConsultaRestricaoContatoProconXQuery($numeroTelefone,
    $statusBloqueio,
    $usuario)
