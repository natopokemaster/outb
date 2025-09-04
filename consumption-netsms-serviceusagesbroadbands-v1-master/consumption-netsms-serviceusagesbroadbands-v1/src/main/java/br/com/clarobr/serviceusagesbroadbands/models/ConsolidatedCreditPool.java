package br.com.clarobr.serviceusagesbroadbands.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConsolidatedCreditPool extends CreditPool{

    @JsonProperty("month")
    private String month;
}
