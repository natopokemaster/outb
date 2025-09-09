package br.com.clarobr.contractprospectservice.models.input;

import br.com.clarobr.contractprospectservice.models.address.ContractIdentification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alan Ricardo
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class ContractProspectInput {
    private String smartCardNumber;
    private String customerAccountId;
    private String operatorCode;
    private String cityId;
    private String protocolNumber;
    private String addressableCode;
    private String documentId;
    private String areaCode;
    private String phoneNumber;
    private String codeBase;

    public ContractProspectInput(ContractIdentification contractIdentification) {
        this.smartCardNumber = contractIdentification.getSmartCardNumber();
        this.customerAccountId = contractIdentification.getContract().getCustomerAccountId();
        this.operatorCode = contractIdentification.getContract().getOperatorCode();
        this.cityId = contractIdentification.getContract().getCityId();
        this.protocolNumber = contractIdentification.getProtocolNumber();
        this.addressableCode = contractIdentification.getAddressableCode();
        this.codeBase = contractIdentification.getContract().getBaseCode();
    }
}
