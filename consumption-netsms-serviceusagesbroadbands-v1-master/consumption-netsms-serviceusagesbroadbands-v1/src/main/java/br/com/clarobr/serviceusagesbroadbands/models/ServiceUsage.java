package br.com.clarobr.serviceusagesbroadbands.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
public class ServiceUsage {

    @JsonProperty("dataAllowance")
    private DataAllowance dataAllowance;

    @JsonProperty("creditPools")
    private List<CreditPool> creditPools;
}
