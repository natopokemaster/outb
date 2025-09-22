(:: pragma bea:global-element-parameter parameter="$operadoraNET1" element="ns0:OperadoraNET" location="../../../../modelocanonico/geral/Empresa.xsd" ::)
(:: pragma bea:global-element-return element="ns1:IdentificacaoOperadoraNET" location="../../../../modelocanonicoV2/geral/IdentificacaoOperadoraNET.xsd" ::)

declare namespace xf = "http://tempuri.org/general/NETSMSDatabaseConfig/transformation/xquery/OperadoraNETIdentificarOperadoraNETXQuery/";
declare namespace ns0 = "http://www.netservicos.com.br/modelocanonico/empresa";
declare namespace ns1 = "http://www.netservicos.com.br/modelocanonico/v2/identificacaoOperadoraNET";

declare function xf:OperadoraNETIdentificarOperadoraNETXQuery($operadoraNET1 as element(ns0:OperadoraNET))
    as element(ns1:IdentificacaoOperadoraNET) {
        <ns1:IdentificacaoOperadoraNET>
            <ns1:CodigoOperadora>{ data($operadoraNET1/ns0:CodigoOperdaora) }</ns1:CodigoOperadora>
            <ns1:IdentificacaoCidade>{ data($operadoraNET1/ns0:IdentificacaoCidade) }</ns1:IdentificacaoCidade>
        </ns1:IdentificacaoOperadoraNET>
};

declare variable $operadoraNET1 as element(ns0:OperadoraNET) external;

xf:OperadoraNETIdentificarOperadoraNETXQuery($operadoraNET1)