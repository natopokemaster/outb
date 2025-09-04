package br.com.clarobr.serviceusagesbroadbands.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DetailedCreditPool extends CreditPool{

    @JsonProperty("date")
    private String date;

    @JsonProperty("notification")
    private String notification;
}