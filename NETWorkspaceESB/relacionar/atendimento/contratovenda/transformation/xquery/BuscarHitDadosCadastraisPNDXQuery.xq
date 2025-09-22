(:: pragma bea:global-element-return element="ns0:buscarVOIPHitALDadosCadastraisTodosStatus" location="../../../../../ativar/aprovisionamento/parceiro/wsdl/business/BuscarHit.wsdl" ::)

declare namespace xf = "http://www.netservicos.com.br/relacionar/atendimento/contratovenda/transformation/xquery/BuscarHitDadosCadastraisPNDXQuery/";
declare namespace ns0 = "ld:br/com/netservicos/aprovisionamento/parceiro/logical/entity/VOIPHitDSL_ws";

declare function xf:BuscarHitDadosCadastraisPNDXQuery($numeroContrato as xs:string)
    as element(ns0:buscarVOIPHitALDadosCadastraisTodosStatus) {
        <ns0:buscarVOIPHitALDadosCadastraisTodosStatus>
            <ns0:numeroContrato>{ xs:int( $numeroContrato ) }</ns0:numeroContrato>
        </ns0:buscarVOIPHitALDadosCadastraisTodosStatus>
};

declare variable $numeroContrato as xs:string external;

xf:BuscarHitDadosCadastraisPNDXQuery($numeroContrato)

