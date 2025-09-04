package br.com.clarobr.serviceusagesbroadbands.resource;

import br.com.clarobr.common.exception.BadRequestException;
import br.com.clarobr.common.exception.NotFoundException;
import br.com.clarobr.serviceusagesbroadbands.exception.UnprocessableEntityException;
import br.com.clarobr.serviceusagesbroadbands.helper.UsagesBroadbandsHelper;
import br.com.clarobr.serviceusagesbroadbands.models.UsageBroadbandsRequest;
import br.com.clarobr.serviceusagesbroadbands.models.UsagesBroadbandsResponse;
import br.com.clarobr.serviceusagesbroadbands.service.UsagesBroadbandsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UsagesBroadbandsResourceTest {

    @InjectMocks
    private UsagesBroadbandsResource usagesBroadbandsResource;

    @Mock
    private UsagesBroadbandsService usagesBroadbandsService;

    @Mock
    private UsagesBroadbandsHelper usagesBroadbandsHelper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindUsagesBroadbands_ThrowsBadRequestException() throws br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException {
        String xQueryString = "XQueryInvalida";
        Map<String, String> params = new HashMap<>();

        // Mock do helper para retornar parâmetros
        when(usagesBroadbandsHelper.getParamsFromQueryString(xQueryString)).thenReturn(params);

        // Serviço para lançar BadRequestException
        doThrow(new BadRequestException("Invalid request")).when(usagesBroadbandsService).verifyRequiredParams(params);

        // Assert
        assertThrows(BadRequestException.class, () -> {
            usagesBroadbandsResource.findUsagesBroadbands(xQueryString);
        });
    }

    @Test
    void testFindUsagesBroadbands_ThrowsNotFoundException() throws UnprocessableEntityException, br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException {
        String xQueryString = "XQueryValida";
        Map<String, String> params = new HashMap<>();
        params.put("customerContractId", "123456");
        params.put("addressableCode", "654321");
        params.put("startDate", "2023-01-01");
        params.put("endDate", "2023-12-31");
        params.put("detailed", "true");
        params.put("operatorCode", "789012");
        params.put("cityId", "345678");
        params.put("smartCardNumber", "987654");

        // Mock do helper para retornar os parâmetros simulados
        when(usagesBroadbandsHelper.getParamsFromQueryString(xQueryString)).thenReturn(params);

        // Configura o objeto de request esperado pelo método
        UsageBroadbandsRequest request = UsageBroadbandsRequest.builder()
                .customerContractId("123456")
                .addressableCode("654321")
                .startDate("2023-01-01")
                .endDate("2023-12-31")
                .detailed(true)
                .operatorCode("789012")
                .cityId("345678")
                .smartCardNumber("987654")
                .build();

        // Serviço lança NotFoundException ao receber o request
        when(usagesBroadbandsService.getUsagesBroadbands(request)).thenThrow(new NotFoundException("Resource not found"));

        // Assert
        assertThrows(NotFoundException.class, () -> {
            usagesBroadbandsResource.findUsagesBroadbands(xQueryString);
        });
    }

    @Test
    void testFindUsagesBroadbands() throws BadRequestException, NotFoundException, UnprocessableEntityException, br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException {
        String xQueryString = "customerContractId=295300&addressableCode=000E5CDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false&operatorCode=013&cityId=25666";
        Map<String, String> params = new HashMap<>();
        params.put("customerContractId", "295300");
        params.put("addressableCode", "000E5CDDDE92");
        params.put("startDate", "2012-02-16");
        params.put("endDate", "2013-01-30");
        params.put("detailed", "false");
        params.put("operatorCode", "013");
        params.put("cityId", "25666");

        // Mock do helper para retornar os parâmetros simulados
        when(usagesBroadbandsHelper.getParamsFromQueryString(xQueryString)).thenReturn(params);

        // Mock do serviço para retornar uma resposta simulada
        UsagesBroadbandsResponse mockResponse = new UsagesBroadbandsResponse();
        when(usagesBroadbandsService.getUsagesBroadbands(any(UsageBroadbandsRequest.class))).thenReturn(mockResponse);

        ResponseEntity<UsagesBroadbandsResponse> response = usagesBroadbandsResource.findUsagesBroadbands(xQueryString);

        // Assert
        assertEquals(ResponseEntity.ok(mockResponse), response);
        verify(usagesBroadbandsService, times(1)).verifyRequiredParams(params);
        verify(usagesBroadbandsService, times(1)).getUsagesBroadbands(any(UsageBroadbandsRequest.class));
    }
}
