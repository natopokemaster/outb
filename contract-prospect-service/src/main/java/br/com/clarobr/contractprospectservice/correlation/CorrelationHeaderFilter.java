package br.com.clarobr.contractprospectservice.correlation;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;

import lombok.extern.slf4j.Slf4j;

/**
 * CorrelationHeaderFilter
 */
@Slf4j
public class CorrelationHeaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Do nothing. Will be implemented in the future
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        final var httpServletRequest = (HttpServletRequest) servletRequest;
        String currentCorrId = httpServletRequest.getHeader(RequestCorrelation.CORRELATION_ID_HEADER);

        if (currentCorrId == null) {
            currentCorrId = UUID.randomUUID().toString();
            log.debug("No correlationId found in Header. Generated : {}", currentCorrId);
        } else {
            String secureLogMessage = currentCorrId.replaceAll("[\r\n]", "");
            log.debug("Found correlationId in Header : {} ", secureLogMessage);
        }
        MDC.put("correlationId", currentCorrId);
        RequestCorrelation.setId(currentCorrId);
        RequestCorrelation.setCorrelationid(currentCorrId);

        filterChain.doFilter(httpServletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        MDC.remove("correlationId");
    }

}