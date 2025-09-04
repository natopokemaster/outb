package br.com.clarobr.serviceusagesbroadbands.models;

import lombok.Data;

@Data
public class CustomerInformation {
    String customerContractId;
    String cityId;

    public CustomerInformation(String customerContractId, String cityId) {
        this.customerContractId = customerContractId;
        this.cityId = cityId;
    }

    public CustomerInformation() {
    }
}
