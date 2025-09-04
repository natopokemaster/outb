package br.com.clarobr.serviceusagesbroadbands.filter;

import static br.com.clarobr.serviceusagesbroadbands.util.Constants.X_HEADER_CORRELATION_ID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import br.com.clarobr.common.base.constants.BaseConstansts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.slf4j.MDC;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.test.context.aot.DisabledInAotMode;

import java.io.IOException;
import java.util.UUID;

class CorrelationIdHeaderFilterTest {

    private CorrelationIdHeaderFilter filter;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private FilterChain chain;

    @BeforeEach
    void setUp() {
        filter = new CorrelationIdHeaderFilter();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        chain = mock(FilterChain.class);
    }

    @AfterEach
    void tearDown() {
        MDC.clear();
    }

    @Test
    void testDoFilter_WithExistingCorrelationId() throws IOException, ServletException {
        // Define o correlation ID existente
        String existingCorrelationId = "4huir8-3y898d-72ysd7s-38ued4f8";

        when(request.getHeader(X_HEADER_CORRELATION_ID)).thenReturn(existingCorrelationId);
        when(request.getRequestURI()).thenReturn("/serviceusagesbroadbands/consumption/v1/netsms/serviceusages/broadbands");

        filter.doFilter(request, response, chain);

        String correlationIdFromMDC = MDC.get(X_HEADER_CORRELATION_ID);
        assertEquals(existingCorrelationId, correlationIdFromMDC, "O correlation ID no MDC deveria corresponder ao correlation ID existente.");

        // Remover a invocação de eq() aqui, já que estamos passando os valores diretamente.
        verify(response).setHeader(X_HEADER_CORRELATION_ID, existingCorrelationId);

        verify(chain).doFilter(request, response);
    }

    @Test
    void testDoFilter_WithoutCorrelationId_GeneratesNewId() throws IOException, ServletException {
        // Configura o mock para retornar `null` para simular a ausência de `X_HEADER_CORRELATION_ID`
        when(request.getHeader(X_HEADER_CORRELATION_ID)).thenReturn(null);
        when(request.getRequestURI()).thenReturn("/serviceusagesbroadbands/consumption/v1/netsms/serviceusages/broadbands");

        filter.doFilter(request, response, chain);

        String correlationIdFromMDC = MDC.get(X_HEADER_CORRELATION_ID);

        assertNotNull(correlationIdFromMDC, "O correlation ID deveria ter sido gerado e adicionado ao MDC.");
        assertFalse(correlationIdFromMDC.isEmpty(), "O correlation ID gerado não deveria estar vazio.");

        // Remover a invocação de eq() aqui também
        verify(response).setHeader(X_HEADER_CORRELATION_ID, correlationIdFromMDC);

        verify(chain).doFilter(request, response);
    }

    @Test
    void testDestroy_ShouldClearMDCEntries() {
        MDC.put(BaseConstansts.CORRELATION_ID, "correlationId");
        MDC.put(BaseConstansts.APPLICATION, "SERVICEUSAGESBROADBANDS");
        MDC.put(BaseConstansts.ALIAS_BASE, "AliasBase");

        filter.destroy();

        // assert
        assertEquals(null, MDC.get(BaseConstansts.CORRELATION_ID));
        assertEquals(null, MDC.get(BaseConstansts.APPLICATION));
        assertEquals(null, MDC.get(BaseConstansts.ALIAS_BASE));
    }

    @Test
    void testGetApplicationName_ShouldReturnUppercaseAppName() {
        String uri = "/serviceusagesbroadbands/consumption/v1/netsms/serviceusages/broadbands";
        String appName = CorrelationIdHeaderFilter.getApplicationName(uri);
        assertEquals("SERVICEUSAGESBROADBANDS", appName);
    }

    @Test
    void testGetApplicationName_WithInvalidURI_ShouldReturnEmptyString() {
        String uri = "/invalidpath";
        String appName = CorrelationIdHeaderFilter.getApplicationName(uri);
        assertEquals("", appName);
    }
}
