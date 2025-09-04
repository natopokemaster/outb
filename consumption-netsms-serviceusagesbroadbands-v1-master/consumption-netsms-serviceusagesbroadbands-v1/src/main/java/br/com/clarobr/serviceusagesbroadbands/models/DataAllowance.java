package br.com.clarobr.serviceusagesbroadbands.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class DataAllowance {
    private String quota;
}

