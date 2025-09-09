package br.com.clarobr.contractprospectservice.util;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.CircuitBreakerException;
import br.com.clarobr.contractprospectservice.models.common.ErrorVO;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * @author Alan Ricardo
 */

public class ErrorUtils {

    private ErrorUtils() {
        throw new IllegalStateException(ContractProspectServiceConstansts.MESSAGE_UTILITY_CLASS);
    }


    public static ErrorVO createError(Exception e) {

        var error = new ErrorVO();

        error.setMessage(ExceptionUtils.getMessage(e));
        error.setStackTrace(ExceptionUtils.getStackTrace(e));
        error.setDetail(ExceptionUtils.getRootCauseMessage(e));
        error.setException(new CircuitBreakerException(e.getMessage()));

        return error;
    }

}
