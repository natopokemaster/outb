package br.com.clarobr.contractprospectservice.models.common;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Alan Ricardo
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorVO {

    private String message;
    private String stackTrace;
    private String detail;
    private Exception exception;

    @SuppressWarnings("all")
    public static ErrorVO initForRecovery(String arqRefVersion) {
        ErrorVO vo = new ErrorVO();
        vo.setMessage(ContractProspectServiceConstansts.ERROR_UNHANDLED_CB_EXCEPTION);
        vo.setStackTrace("");
        vo.setDetail("");
        vo.setException(new Exception(vo.getMessage()));
        return vo;
    }

    @SuppressWarnings("all")
    public boolean isEmpty() {

        if (message == null & stackTrace == null & detail == null & exception == null) {
            return true;
        }

        return false;
    }
}
