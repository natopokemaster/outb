package br.com.clarobr.serviceusagesbroadbands.constants;

public class RepositoryConstants {
    public static final String QUERY_FETCH_CITY_ID_BY_OPERATOR_CODE = String.join(" ",
            "SELECT CID_CONTRATO AS CITYID",
            "FROM PROD_JD.SN_CIDADE_BASE C2",
            "WHERE (:OPERATORCODE = C2.COD_OPERADORA)",
            "AND ROWNUM = 1"
    );

    public static final String QUERY_FETCH_ID_PONTO_HISTORICO_CONSUMO = """
        SELECT MAX(t2."ID_PONTO") AS c18
        FROM (
            SELECT :ADDRESSABLECODE AS c1,
                   t1."CD_ENDERECAVEL",
                   t1."CID_CONTRATO",
                   t1."DH_DESPENALIZACAO",
                   t1."DH_PENALIZACAO",
                   t1."DT_CONSUMO",
                   t1."ID_PONTO",
                   t1."ID_PRODUTO",
                   t1."NM_ALIAS",
                   t1."NUM_CONTRATO",
                   t1."VL_BONUS",
                   t1."VL_FRANQUIA_ACUMULADA",
                   t1."VL_FRANQUIA_ADICIONAL",
                   t1."VL_FRANQUIA_ADIC_ACUM_ADQ",
                   t1."VL_FRANQUIA_CONSUMIDA",
                   t1."VL_FRANQUIA_CONTRATO",
                   t1."VL_FRANQUIA_REFERENCIA"
            FROM "NETMED"."HISTORICO_CONSUMO" t1
            WHERE (:ADDRESSABLECODE = t1."CD_ENDERECAVEL")
              AND (:CUSTOMERCONTRACTID = t1."NUM_CONTRATO")
              AND (:CITYID = t1."CID_CONTRATO")
        ) t2
        GROUP BY t2.c1
    """;

    public static final String QUERY_FETCH_CONSOLIDATED = """
        SELECT
            TO_CHAR(t1."DT_CONSUMO", 'MM-YYYY') AS MES_ANO,
            MAX(t1."DT_CONSUMO") AS DATA_MAXIMA_CONSUMO,
            ROUND(MAX(t1."VL_FRANQUIA_ACUMULADA"), 2) AS CONSUMO_TOTAL,
            ROUND(MAX(t1."VL_FRANQUIA_ADIC_ACUM_ADQ"), 2) AS FRANQUIA_ADICIONAL_ADQUIRIDA,
            ROUND((MAX(t1."VL_FRANQUIA_CONTRATO") + MAX(t1."VL_FRANQUIA_ADIC_ACUM_ADQ") + MAX(t1."VL_BONUS")) - MAX(t1."VL_FRANQUIA_ACUMULADA"), 2) AS SALDO_TOTAL,
            ROUND((MAX(t1."VL_FRANQUIA_ACUMULADA") / (MAX(t1."VL_FRANQUIA_CONTRATO") + MAX(t1."VL_FRANQUIA_ADIC_ACUM_ADQ") + MAX(t1."VL_BONUS"))) * 100, 2) AS PERCENTUAL_UTILIZADO,
            MAX(t1."VL_FRANQUIA_CONTRATO") AS FRANQUIA_CONTRATADA
        FROM NETMED.HISTORICO_CONSUMO t1
        WHERE (:CITYID = t1."CID_CONTRATO")
          AND (:CUSTOMERCONTRACTID = t1."NUM_CONTRATO")
          AND (:POINTID = t1."ID_PONTO")
          AND (TO_DATE(:STARTDATE, 'DD/MM/YYYY') <= t1."DT_CONSUMO")
          AND (TO_DATE(:ENDDATE, 'DD/MM/YYYY') >= t1."DT_CONSUMO")
        GROUP BY TO_CHAR(t1."DT_CONSUMO", 'MM-YYYY')
        ORDER BY MES_ANO
    """;

    public static final String QUERY_FETCH_DETAILED = String.join(" ",
            "SELECT CONSUMO.CID_CONTRATO,",
            "       CONSUMO.DT_CONSUMO,",
            "       CONSUMO.ID_PONTO,",
            "       CONSUMO.NUM_CONTRATO,",
            "       CONSUMO.VL_BONUS,",
            "       CONSUMO.VL_FRANQUIA_ACUMULADA,",
            "       CONSUMO.VL_FRANQUIA_ADICIONAL,",
            "       CONSUMO.VL_FRANQUIA_ADIC_ACUM_ADQ,",
            "       CONSUMO.VL_FRANQUIA_CONSUMIDA,",
            "       CONSUMO.VL_FRANQUIA_CONTRATO,",
            "       CONSUMO.CD_ENDERECAVEL,",
            "       PENALIZACAO.FC_PENALIZA_NOTIFICA,",
            "       PENALIZACAO.PC_FAIXA_PENALIZA_NOTIFICA",
            "FROM NETMED.HISTORICO_CONSUMO CONSUMO",
            "LEFT OUTER JOIN (SELECT NOTIFICA_PENALIZA.CID_CONTRATO AS CID_CONTRATO,",
            "                          NOTIFICA_PENALIZA.DH_NOTIFICA_PENALIZA AS DH_NOTIFICA_PENALIZA,",
            "                          NOTIFICA_PENALIZA.FC_PENALIZA_NOTIFICA AS FC_PENALIZA_NOTIFICA,",
            "                          NOTIFICA_PENALIZA.ID_PONTO AS ID_PONTO,",
            "                          NOTIFICA_PENALIZA.NUM_CONTRATO AS NUM_CONTRATO,",
            "                          FAIXA_NOTIFICA_PENALIZA.PC_FAIXA_PENALIZA_NOTIFICA AS PC_FAIXA_PENALIZA_NOTIFICA",
            "                    FROM NETMED.NOTIFICA_PENALIZA NOTIFICA_PENALIZA",
            "                    JOIN NETMED.FAIXA_PENALIZA_NOTIFICA FAIXA_NOTIFICA_PENALIZA",
            "                      ON ((NOTIFICA_PENALIZA.ID_FAIXA_PENALIZA_NOTIFICA = FAIXA_NOTIFICA_PENALIZA.ID_FAIXA_PENALIZA_NOTIFICA) AND",
            "                          (NOTIFICA_PENALIZA.CID_CONTRATO = FAIXA_NOTIFICA_PENALIZA.CID_CONTRATO))",
            "                    WHERE (((:CITYID = NOTIFICA_PENALIZA.CID_CONTRATO) AND",
            "                           (:CUSTOMERCONTRACTID = NOTIFICA_PENALIZA.NUM_CONTRATO)) AND",
            "                           (:CITYID = FAIXA_NOTIFICA_PENALIZA.CID_CONTRATO))) PENALIZACAO",
            "ON ((CONSUMO.ID_PONTO = PENALIZACAO.ID_PONTO) AND",
            "   (TRUNC(CONSUMO.DT_CONSUMO) = TRUNC(PENALIZACAO.DH_NOTIFICA_PENALIZA)) AND",
            "   (CONSUMO.CID_CONTRATO = PENALIZACAO.CID_CONTRATO) AND",
            "   (CONSUMO.NUM_CONTRATO = PENALIZACAO.NUM_CONTRATO))",
            "WHERE ((:CUSTOMERCONTRACTID = CONSUMO.NUM_CONTRATO) AND",
            "       (:CITYID = CONSUMO.CID_CONTRATO) AND",
            "       (CONSUMO.DT_CONSUMO >= TO_DATE(:STARTDATE, 'DD/MM/YYYY')) AND",
            "       (CONSUMO.DT_CONSUMO <= TO_DATE(:ENDDATE, 'DD/MM/YYYY')) AND",
            "       (:POINTID = CONSUMO.ID_PONTO))",
            "ORDER BY CONSUMO.NUM_CONTRATO ASC,",
            "         CONSUMO.CID_CONTRATO ASC,",
            "         CONSUMO.ID_PONTO ASC,",
            "         CONSUMO.DT_CONSUMO ASC"
    );

    public static final String QUERY_FETCH_CUSTOMER_INFORMATION_BY_ADDRESSABLE_CODE = """
        SELECT
            "OPERACAO"."CD_OPERACAO_NETSMS" AS CID_CONTRATO,
            "LOCAL"."CD_CONTRATO_NETSMS" AS NUM_CONTRATO
        FROM "NETHOME"."ENDERECAVEL",
             "NETHOME"."EQUIPAMENTO",
             "NETHOME"."OPERACAO",
             "NETHOME"."LOCAL"
        WHERE "ENDERECAVEL"."ID_EQUIPAMENTO" = "EQUIPAMENTO"."ID_EQUIPAMENTO"
          AND "EQUIPAMENTO"."ID_OPERACAO" = "OPERACAO"."ID_OPERACAO"
          AND "EQUIPAMENTO"."ID_LOCAL" = "LOCAL"."ID_LOCAL"
          AND :ADDRESSABLECODE = "ENDERECAVEL"."CD_ENDERECAVEL"
    """;

    private RepositoryConstants() {
        throw new IllegalStateException("Utility class");
    }

}
