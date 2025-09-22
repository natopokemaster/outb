(:: pragma bea:global-element-parameter parameter="$auditoria1" element="ns0:auditoria" location="../../schema/AuditoriaQueue.xsd" ::)
(:: pragma bea:global-element-return element="ns2:inserirRegistroAuditoria" location="../../wsdl/business/AuditoriaDSLBSV1_0.wsdl" ::)

declare namespace xf = "http://tempuri.org/general/auditoria/transformation/xquery/InserirRegistroAuditoriaXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/AuditoriaQueue";
declare namespace ns1 = "http://www.netservicos.com.br/Auditoria";
declare namespace ns2 = "ld:br/com/netservicos/seguranca/logical/entity/AuditoriaDSL_ws";

declare function xf:InserirRegistroAuditoriaXQuery($auditoria1 as element(ns0:auditoria))
    as element(ns2:inserirRegistroAuditoria) {
        <ns2:inserirRegistroAuditoria>
            <ns2:auditoria>
                <ns1:auditoria>
                    {
                        for $sistema in $auditoria1/sistema
                        return
                            <ns1:PSISTEMA>{ data($sistema) }</ns1:PSISTEMA>
                    }
                    {
                        for $usuario in $auditoria1/usuario
                        return
                            <ns1:PUSUARIO>{ data($usuario) }</ns1:PUSUARIO>
                    }
                    <ns1:PCRITICIDADE>{ xs:decimal( data($auditoria1/idCriticidade) ) }</ns1:PCRITICIDADE>
                    {
                        for $idAcao in $auditoria1/idAcao
                        return
                            <ns1:PACAO>{ xs:decimal( data($idAcao) ) }</ns1:PACAO>
                    }
                    {
                        for $cidade in $auditoria1/cidade
                        return
                            <ns1:PCIDADE>{ data($cidade) }</ns1:PCIDADE>
                    }
                    {
                        for $campo in $auditoria1/campo
                        return
                            <ns1:PCAMPO>{ data($campo) }</ns1:PCAMPO>
                    }
                    {
                        for $idRegistro in $auditoria1/idRegistro
                        return
                            <ns1:PIDREGISTRO>{ data($idRegistro) }</ns1:PIDREGISTRO>
                    }
                    {
                        for $nota in $auditoria1/nota
                        return
                            <ns1:PNOTA>{ data($nota) }</ns1:PNOTA>
                    }
                </ns1:auditoria>
            </ns2:auditoria>
        </ns2:inserirRegistroAuditoria>
};

declare variable $auditoria1 as element(ns0:auditoria) external;

xf:InserirRegistroAuditoriaXQuery($auditoria1)
