package br.com.clarobr.serviceusagesbroadbands.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsageBroadbandsRequest {

    String customerContractId;
    String addressableCode;
    String startDate;
    String endDate;
    Boolean detailed;
    String operatorCode;
    String cityId;
    String protocolNumber;
    String smartCardNumber;

}
