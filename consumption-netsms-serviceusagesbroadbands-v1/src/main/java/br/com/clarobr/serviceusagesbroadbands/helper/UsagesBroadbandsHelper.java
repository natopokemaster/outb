package br.com.clarobr.serviceusagesbroadbands.helper;

import br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException;
import br.com.clarobr.serviceusagesbroadbands.constants.ErrorConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public final class UsagesBroadbandsHelper {


    /**
     * Gets the contract number from header.
     *
     * @param xQueryString
     * @throws BadRequestException
     */

    // Método para extrair os parâmetros da query string
    public Map<String, String> getParamsFromQueryString(final String xQueryString) throws BadRequestException {
        Map<String, String> params = new HashMap<>();
        log.info("Extraindo parametros da X-QueryString");

        if (StringUtils.isNotBlank(xQueryString)) {
            String[] pairs = xQueryString.split("&");

            for (String pair : pairs) {
                String[] keyValue = pair.split("=", 2);
                if (keyValue.length == 2 && StringUtils.isNotBlank(keyValue[0]) && StringUtils.isNotBlank(keyValue[1])) {
                    params.put(keyValue[0], keyValue[1]);
                } else {

                    var exception = new BadRequestException(ErrorConstants.ERROR_XQUERYSTRING_OUT_OF_STANDARD);
                    log.error("A X-QueryString informada esta fora do padrao: {}", xQueryString, exception);
                    throw exception;
                }
            }
        } else {
            log.warn("X-QueryString esta vazia ou nula.");
        }

        log.info("Parametros extraidos da X-QueryString: {}", params);
        return params;
    }

}
