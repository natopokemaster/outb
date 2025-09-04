package br.com.clarobr.serviceusagesbroadbands.filter;

import static br.com.clarobr.common.base.constants.BaseConstansts.APPLICATION;
import static br.com.clarobr.serviceusagesbroadbands.util.Constants.*;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import br.com.clarobr.common.base.constants.BaseConstansts;
import br.com.clarobr.serviceusagesbroadbands.util.Correlation;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * CorrelationHeaderFilter
 *
 */
@Component
public class CorrelationIdHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final var httpServletRequest = (HttpServletRequest) servletRequest;
        final var applicationName = getApplicationName(httpServletRequest.getRequestURI());

        String currentCorrId = httpServletRequest.getHeader(X_HEADER_TRANSACTION_ID);

        if (StringUtils.isBlank(currentCorrId)) {
            currentCorrId = httpServletRequest.getHeader(X_HEADER_CORRELATION_ID);
        }

        if (StringUtils.isBlank(currentCorrId)) {
            currentCorrId = UUID.randomUUID().toString();
        }

        Correlation.setCorrelationid(currentCorrId);

        MDC.put(APPLICATION, applicationName);
        MDC.put(X_HEADER_CORRELATION_ID, currentCorrId);
        MDC.put(KEY_FIELD_CORRELATION_ID, currentCorrId);

        var httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader(X_HEADER_CORRELATION_ID, currentCorrId);

        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        MDC.remove(BaseConstansts.CORRELATION_ID);
        MDC.remove(BaseConstansts.APPLICATION);
        MDC.remove(BaseConstansts.ALIAS_BASE);
    }

    static String getApplicationName(final String requestURI) {
        final var appUri = StringUtils.substringBetween(requestURI, "/", "/");
        final var appName = Optional.ofNullable(appUri)
                                    .orElse("");
        return appName.toUpperCase(Locale.getDefault());
    }
}
