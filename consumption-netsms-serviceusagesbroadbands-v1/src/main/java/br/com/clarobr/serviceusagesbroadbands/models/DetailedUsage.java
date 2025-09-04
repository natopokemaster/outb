package br.com.clarobr.serviceusagesbroadbands.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class DetailedUsage{
    private String cdEnderecavel;
    private String cidContrato;
    private String dtConsumo;
    private Long idPonto;
    private String numContrato;
    private BigDecimal vlBonus;
    private BigDecimal vlFranquiaAcumulada;
    private BigDecimal vlFranquiaAdicional;
    private BigDecimal vlFranquiaAdicAcumAdq;
    private BigDecimal vlFranquiaConsumida;
    private BigDecimal vlFranquiaContrato;
    private String fcPenalizaNotifica;
    private String pcFaixaPenalizaNotifica;
}
