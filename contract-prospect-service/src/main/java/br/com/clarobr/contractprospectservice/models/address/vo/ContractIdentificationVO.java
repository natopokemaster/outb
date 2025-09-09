package br.com.clarobr.contractprospectservice.models.address.vo;

/**
 * @author Alan Ricardo
 */

import br.com.clarobr.contractprospectservice.models.address.ContractIdentification;
import br.com.clarobr.contractprospectservice.models.common.ErrorVO;
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
public class ContractIdentificationVO {

    private ContractIdentification contractIdentification;
    private ErrorVO errorVO;
    private String globalVersion;


    public static ContractIdentificationVO initForRecovery(String arqRefVersion) {
        var vo = new ContractIdentificationVO();

        vo.setGlobalVersion(arqRefVersion);
        vo.setContractIdentification(ContractIdentification.initForRecovery(arqRefVersion));
        vo.setErrorVO(ErrorVO.initForRecovery(arqRefVersion));

        return vo;
    }

}

