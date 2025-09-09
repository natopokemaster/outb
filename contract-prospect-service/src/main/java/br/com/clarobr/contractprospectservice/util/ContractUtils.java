package br.com.clarobr.contractprospectservice.util;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.models.address.Contract;
import br.com.clarobr.contractprospectservice.models.address.ContractIdentification;

/**
 * @author Alan Ricardo
 */


@SuppressWarnings("all")
public abstract class ContractUtils {

    private ContractUtils() {
        throw new IllegalStateException(ContractProspectServiceConstansts.MESSAGE_UTILITY_CLASS);
    }

    public static ContractIdentification createContractRecovery() {
        var contractIdentification = new ContractIdentification();

        contractIdentification.setAliasDatabase("");
        contractIdentification.setContract(new Contract());
        contractIdentification.setProtocolNumber("");
        contractIdentification.setAddressableCode("");
        contractIdentification.setSmartCardNumber("");

        return contractIdentification;
    }

}
