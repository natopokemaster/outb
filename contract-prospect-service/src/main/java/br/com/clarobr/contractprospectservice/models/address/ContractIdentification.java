package br.com.clarobr.contractprospectservice.models.address;

/**
 * @author Alan Ricardo
 */

import br.com.clarobr.contractprospectservice.util.ContractUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContractIdentification {
    private String protocolNumber;
    private String addressableCode;
    private String aliasDatabase;
    private Contract contract;
    private String smartCardNumber;

    @SuppressWarnings("all")
    public static ContractIdentification initForRecovery(String arqRefVersion) {
        return ContractUtils.createContractRecovery();
    }

}

