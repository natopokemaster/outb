package br.com.clarobr.serviceusagesbroadbands.service;

import br.com.clarobr.serviceusagesbroadbands.config.SpringContextHolder;
import br.com.clarobr.serviceusagesbroadbands.constants.ErrorConstants;
import br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException;
import br.com.clarobr.serviceusagesbroadbands.exception.UnprocessableEntityException;
import br.com.clarobr.serviceusagesbroadbands.models.*;
import br.com.clarobr.serviceusagesbroadbands.repository.UsagesBroadbandsRepository;
import br.com.clarobr.serviceusagesbroadbands.util.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static br.com.clarobr.serviceusagesbroadbands.service.UsagesBroadbandsService.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Import(TestConfig.class)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class UsagesBroadbandsServiceTest {

    @InjectMocks
    private UsagesBroadbandsService usagesBroadbandsService;

    @Mock
    private UsagesBroadbandsRepository usagesBroadbandsRepository;

    @Mock
    private DateUtils dateUtils;


    @Mock
    private MessageSource messageResources;

    @TestConfiguration
    static class TestConfig {

        @Bean
        SpringContextHolder springContextHolder() {
            return new SpringContextHolder();
        }
    }

    @Autowired
    private SpringContextHolder springContextHolder;

    @Test
    void testSpringContextHolderInitialization() {
        assertNotNull(springContextHolder);
        // Adicione mais testes conforme necessário
    }

    @Test
    void testVerifyCustomerContractIdAndOperatorCode_WithOperatorCode() {
        // Arrange
        Map<String, String> params = new HashMap<>();
        params.put("customerContractId", "12345"); // Define um customerContractId válido
        params.put("operatorCode", "validOperatorCode"); // Define um operatorCode válido
        // Não define cityId

        // Act & Assert
        assertDoesNotThrow(() -> {
            usagesBroadbandsService.verifyCustomerContractIdAndOperatorCode(params);
        });
    }

    @Test
    void testVerifyCustomerContractIdAndOperatorCode_WithCityId() {
        // Arrange
        Map<String, String> params = new HashMap<>();
        params.put("customerContractId", "12345"); // Define um customerContractId válido
        params.put("cityId", "validCityId"); // Define um cityId válido
        // Não define operatorCode

        // Act & Assert
        assertDoesNotThrow(() -> {
            usagesBroadbandsService.verifyCustomerContractIdAndOperatorCode(params);
        });
    }

    @Test
    void testVerifyCustomerContractIdAndOperatorCode() throws BadRequestException {
        usagesBroadbandsService.verifyCustomerContractIdAndOperatorCode(Map.of("params", "params"));
    }

    @Test
    void testVerifyCustomerContractIdAndOperatorCode_MissingOperatorCodeAndCityId() {
        Map<String, String> params = new HashMap<>();
        params.put("customerContractId", "56512368");

        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            usagesBroadbandsService.verifyCustomerContractIdAndOperatorCode(params);
        });


        assertEquals(ErrorConstants.ERROR_MISSING_CITYID_OPERATORCODE, exception.getMessage());
    }

    @Test
    void testVerifyRequiredParams_MissingRequiredParameters() {
        // Arrange
        Map<String, String> params = new HashMap<>(); // Simula um mapa sem parâmetros obrigatórios

        // Act & Assert
        assertThrows(BadRequestException.class, () -> {
            usagesBroadbandsService.verifyRequiredParams(params);
        });
    }


    /**
     * Method under test: {@link UsagesBroadbandsService#verifyDetailed(Map)}
     */
    @Test
    void testVerifyDetailed() {
        // Arrange, Act and Assert
        Map<String, String> params = new HashMap<>();
        assertThrows(BadRequestException.class, () -> usagesBroadbandsService.verifyDetailed(params));
    }
    /**
     * Method under test: {@link UsagesBroadbandsService#verifyAddressableCode(Map)}
     */
    @Test
    void testVerifyAddressableCode() {
        Map<String, String> params = new HashMap<>();
        // Arrange, Act and Assert
        assertThrows(BadRequestException.class, () -> usagesBroadbandsService.verifyAddressableCode(params));
    }
    @Test
    void testGetUsagesBroadbandsWithCustomerContractIdAndOperatorCode() throws UnprocessableEntityException, BadRequestException {
        UsageBroadbandsRequest request = new UsageBroadbandsRequest();
        request.setCustomerContractId("customerContractId");
        request.setOperatorCode("operatorCode");

        // Mock do repositório
        when(usagesBroadbandsRepository.findCityIdByOperatorCode("operatorCode")).thenReturn("cityId");

        UsagesBroadbandsResponse response = new UsagesBroadbandsResponse();
        when(usagesBroadbandsRepository.findConsolidatedUsage(request)).thenReturn(response);

        UsagesBroadbandsResponse result = usagesBroadbandsService.getUsagesBroadbands(request);

        assertNotNull(result);
        verify(usagesBroadbandsRepository, times(1)).findCityIdByOperatorCode("operatorCode");
        verify(usagesBroadbandsRepository, times(1)).findConsolidatedUsage(request);
    }

    @Test
    void testGetUsagesBroadbandsWithCustomerContractIdAndCityId() throws UnprocessableEntityException, BadRequestException {
        UsageBroadbandsRequest request = new UsageBroadbandsRequest();
        request.setCustomerContractId("customerContractId");
        request.setOperatorCode("cityId");

        UsagesBroadbandsResponse result = usagesBroadbandsService.getUsagesBroadbands(request);

        assertNotNull(request);
    }

    // Teste de getUsagesBroadbands com smartCardNumber
    @Test
    void testGetUsagesBroadbandsWithSmartCardNumber() throws UnprocessableEntityException, BadRequestException {
        UsageBroadbandsRequest request = new UsageBroadbandsRequest();
        request.setSmartCardNumber("123456");

        // Mock do repositório
        when(usagesBroadbandsRepository.getCustomerInformationFromSmartcardNumber("123456"))
                .thenReturn(new CustomerInformation("customerContractId", "cityId"));

        UsagesBroadbandsResponse response = new UsagesBroadbandsResponse();
        when(usagesBroadbandsRepository.findConsolidatedUsage(request)).thenReturn(response);

        UsagesBroadbandsResponse result = usagesBroadbandsService.getUsagesBroadbands(request);

        assertNotNull(result);
        verify(usagesBroadbandsRepository, times(1)).getCustomerInformationFromSmartcardNumber("123456");
        verify(usagesBroadbandsRepository, times(1)).findConsolidatedUsage(request);
    }
    @Test
    void testGetUsagesBroadbandsWithCustomerContractId() throws UnprocessableEntityException, BadRequestException {
        UsageBroadbandsRequest usageBroadbandsRequest = new UsageBroadbandsRequest();
        usageBroadbandsRequest.setCustomerContractId("123");
        usageBroadbandsRequest.setOperatorCode("ABC");
        Mockito.when(usagesBroadbandsRepository.findCityIdByOperatorCode(Mockito.anyString()))
                .thenReturn("456");
        usagesBroadbandsService.getUsagesBroadbands(usageBroadbandsRequest);
        Assertions.assertEquals("456", usageBroadbandsRequest.getCityId());
        Mockito.verify(usagesBroadbandsRepository, Mockito.times(1))
                .findCityIdByOperatorCode(Mockito.anyString());
    }
    @Test
    void testGetUsagesBroadbandsWithDetailed() throws UnprocessableEntityException, BadRequestException {
        UsageBroadbandsRequest usageBroadbandsRequest = new UsageBroadbandsRequest();
        usageBroadbandsRequest.setDetailed(true);
        Mockito.when(usagesBroadbandsRepository.findDetailedUsage(Mockito.any(UsageBroadbandsRequest.class)))
                .thenReturn(new UsagesBroadbandsResponse());
        UsagesBroadbandsResponse response = usagesBroadbandsService.getUsagesBroadbands(usageBroadbandsRequest);
        Assertions.assertNotNull(response);
        Mockito.verify(usagesBroadbandsRepository, Mockito.times(1))
                .findDetailedUsage(Mockito.any(UsageBroadbandsRequest.class));
    }
    @Test
    void testGetUsagesBroadbandsWithoutDetailed() throws UnprocessableEntityException, BadRequestException {
        UsageBroadbandsRequest usageBroadbandsRequest = new UsageBroadbandsRequest();
        usageBroadbandsRequest.setDetailed(false);
        Mockito.when(usagesBroadbandsRepository.findConsolidatedUsage(Mockito.any(UsageBroadbandsRequest.class)))
                .thenReturn(new UsagesBroadbandsResponse());
        UsagesBroadbandsResponse response = usagesBroadbandsService.getUsagesBroadbands(usageBroadbandsRequest);
        Assertions.assertNotNull(response);
        Mockito.verify(usagesBroadbandsRepository, Mockito.times(1))
                .findConsolidatedUsage(Mockito.any(UsageBroadbandsRequest.class));
    }

    @Test
    void testValidDates() throws BadRequestException {
        Map<String, String> params = new HashMap<>();
        params.put(START_DATE, "2022-01-01");
        params.put(END_DATE, "2022-01-31");
        usagesBroadbandsService.validateStartAndEndDates(params); // não deve lançar exceção
    }

    @Test
    void testInvalidEndDate() {
        Map<String, String> params = new HashMap<>();
        params.put(START_DATE, "2022-01-01");
        params.put(END_DATE, "01-01-2022"); // formato inválido

        assertThrows(BadRequestException.class, () -> usagesBroadbandsService.validateStartAndEndDates(params));
    }

    @Test
    void testInvalidStartDate() {
        Map<String, String> params = new HashMap<>();
        params.put(START_DATE, "01-01-2022"); // formato inválido
        params.put(END_DATE, "2022-01-01");

        assertThrows(BadRequestException.class, () -> usagesBroadbandsService.verifyStartDate(params));
    }

    @Test
    void validateStartAndEndDates_TestEndDateBeforeStartDate() {
        Map<String, String> params = new HashMap<>();
        params.put(START_DATE, "2022-01-01");
        params.put(END_DATE, "2021-01-01"); //Data final anterior a data inicial

        assertThrows(BadRequestException.class, () -> usagesBroadbandsService.validateStartAndEndDates(params));
    }

    @Test
    void testVerifyRequiredParams_MissingEndDate() throws BadRequestException {
        // Arrange
        Map<String, String> params = new HashMap<>();
        params.put("customerContractId", "12345");
        params.put("cityId", "345678");
        params.put("addressableCode", "000E5CDDDE92");
        params.put("startDate", "2022-01-01");
        params.put("detailed", "false");

        usagesBroadbandsService.verifyRequiredParams(params);
        // Act & Assert
        assertNotNull(params.get("startDate"));
    }
    @Test
    void testVerifyRequiredParams_MissingStartDate() throws BadRequestException {
        // Arrange
        Map<String, String> params = new HashMap<>();
        params.put("customerContractId", "12345");
        params.put("cityId", "345678");
        params.put("addressableCode", "000E5CDDDE92");
        params.put("endDate", "2022-01-01");
        params.put("detailed", "false");

        usagesBroadbandsService.verifyRequiredParams(params);
        // Act & Assert
        assertNotNull(params.get("endDate"));
    }
}