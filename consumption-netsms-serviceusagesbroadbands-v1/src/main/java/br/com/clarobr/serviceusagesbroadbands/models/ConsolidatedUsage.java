package br.com.clarobr.serviceusagesbroadbands.models;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ConsolidatedUsage {

    private BigDecimal quota;
    private String validadeCredito;
    private BigDecimal franquiaContratada;
    private BigDecimal totalUtilizado;
    private BigDecimal totalDisponivel;
    private BigDecimal percentualUtilizado;


}