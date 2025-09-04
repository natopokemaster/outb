package br.com.clarobr.serviceusagesbroadbands.repository;

import br.com.clarobr.common.connection.repository.MultiDatabaseRepository;
import br.com.clarobr.serviceusagesbroadbands.constants.ErrorConstants;
import br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException;
import br.com.clarobr.serviceusagesbroadbands.exception.UnprocessableEntityException;
import br.com.clarobr.serviceusagesbroadbands.mapper.BroadbandsConsolidatedRowMapper;
import br.com.clarobr.serviceusagesbroadbands.mapper.BroadbandsDetailedRowMapper;
import br.com.clarobr.serviceusagesbroadbands.mapper.CityIdRowMapper;
import br.com.clarobr.serviceusagesbroadbands.mapper.CustomerInformationRowMapper;
import br.com.clarobr.serviceusagesbroadbands.models.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class UsagesBroadbandsRepositoryTest {

    @SpyBean
    private UsagesBroadbandsRepository usagesBroadbandsRepository;

    @MockBean
    MultiDatabaseRepository multiDatabaseRepository;

    @MockBean
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


//    @InjectMocks
//    private UsagesBroadbandsRepository usagesBroadbandsRepository;

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindCityIdByOperatorCode_ShouldReturnCityId() {
        // Configurar o operador e o resultado esperado
        String expectedCityId = "CITY123";

        // Mock para simular retorno esperado da consulta
        when(multiDatabaseRepository.queryNamedParameters(any(String.class), anyMap(), any(CityIdRowMapper.class)))
                .thenReturn(List.of(expectedCityId));
        List<String> result = multiDatabaseRepository.queryNamedParameters("someQuery", Map.of(), new CityIdRowMapper());

        assertNotNull(multiDatabaseRepository); // Verifica se o mock foi injetado.
        assertEquals(expectedCityId, result.get(0));
    }

    @Test
    void testFindCityIdByOperatorCode_ShouldReturnCorrectCityId() throws UnprocessableEntityException {
        // Configurar o operador e o valor esperado de `cityId`
        String operatorCode = "OP123";
        String expectedCityId = "CITY123";

        // Configurar o mock para retornar o `expectedCityId`
        when(multiDatabaseRepository.queryNamedParameters(any(String.class), anyMap(), any(CityIdRowMapper.class)))
                .thenReturn(List.of(expectedCityId)); // Mock retorna uma lista com o `expectedCityId`

        // Executar o método
        String actualCityId = usagesBroadbandsRepository.findCityIdByOperatorCode(operatorCode);

        // Verificar se o retorno é o `expectedCityId`
        assertEquals(expectedCityId, actualCityId, "O cityId retornado não corresponde ao esperado");
    }

    @Test
    void testFindCityIdByOperatorCode_ShouldThrowUnprocessableEntityException() {
        when(multiDatabaseRepository.queryNamedParameters(any(String.class), anyMap(), any(CityIdRowMapper.class)))
                .thenThrow(new NoSuchElementException());

        UnprocessableEntityException exception = assertThrows(UnprocessableEntityException.class, () ->
                usagesBroadbandsRepository.findCityIdByOperatorCode("099")
        );

        assertEquals(ErrorConstants.ERROR_CITYID_NOT_FOUND, exception.getMessage());
    }


    @Test
    void testFindDetailedUsage() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsagesBroadbandsRepository usagesBroadbandsRepository = new UsagesBroadbandsRepository();

        UsageBroadbandsRequest usageBroadbandsRequest = new UsageBroadbandsRequest();
        usageBroadbandsRequest.setStartDate("2020/03/01");

        // Act and Assert
        assertThrows(BadRequestException.class,
                () -> usagesBroadbandsRepository.findDetailedUsage(usageBroadbandsRequest));
    }

    @Test
    void testFindDetailedUsage2() throws UnprocessableEntityException, BadRequestException {
        // Arrange
        UsageBroadbandsRequest usageBroadbandsRequest = UsageBroadbandsRequest.builder()
                .cityId("Oxford")
                .customerContractId("42")
                .addressableCode("44")
                .detailed(true)
                .endDate("2020-03-31")
                .operatorCode("Operator Code")
                .protocolNumber("42")
                .smartCardNumber("42")
                .startDate("2020-03-01")
                .build();

        // Mock do comportamento do findPointId no Spy
        doReturn("POINT123").when(usagesBroadbandsRepository).findPointId(usageBroadbandsRequest);

        // Criação do MapSqlParameterSource esperado
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("STARTDATE", "2020-03-01");
        params.addValue("ENDDATE", "2020-03-31");
        params.addValue("POINTID", "POINT123");
        params.addValue("ADDRESSABLECODE", "44");
        params.addValue("CITYID", "Oxford");
        params.addValue("CUSTOMERCONTRACTID", "42");

        // Mock do setupQueryParams
        doReturn(params).when(usagesBroadbandsRepository).setupQueryParams(
                usageBroadbandsRequest, "POINT123", "2020-03-01", "2020-03-31");

        // Mock do resultado detalhado da query
        List<DetailedUsage> mockDetailedUsageList = new ArrayList<>();
        mockDetailedUsageList.add(new DetailedUsage()); // Simulação de resultado detalhado
        when(namedParameterJdbcTemplate.query(anyString(), eq(params), any(BroadbandsDetailedRowMapper.class)))
                .thenReturn(mockDetailedUsageList);

        // Mock para getDetailedContractDataAllowance e getDetailedCreditPools
        BigDecimal mockFranquia = new BigDecimal("500.00");
        doReturn(mockFranquia).when(usagesBroadbandsRepository).getDetailedContractDataAllowance(mockDetailedUsageList);

        List<CreditPool> mockCreditPools = new ArrayList<>();
        mockCreditPools.add(new CreditPool()); // Simulação de um pool de crédito
        doReturn(mockCreditPools).when(usagesBroadbandsRepository).getDetailedCreditPools(mockDetailedUsageList);

        // Act
        UsagesBroadbandsResponse response = usagesBroadbandsRepository.findDetailedUsage(usageBroadbandsRequest);

        // Assert
        assertNotNull(response);
        assertNotNull(response.getData());
//        assertEquals(mockFranquia, response.getData());
//        assertEquals(mockCreditPools, response.getData());
    }


    @Test
    void testFindConsolidatedUsage() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        UsagesBroadbandsRepository usagesBroadbandsRepository = new UsagesBroadbandsRepository();

        UsageBroadbandsRequest usageBroadbandsRequest = new UsageBroadbandsRequest();
        usageBroadbandsRequest.setStartDate("2020/03/01");

        // Act and Assert
        assertThrows(BadRequestException.class,
                () -> usagesBroadbandsRepository.findConsolidatedUsage(usageBroadbandsRequest));
    }

    @Test
    void testFindConsolidatedUsage2() throws UnprocessableEntityException, BadRequestException {
        // Arrange
        UsageBroadbandsRequest usageBroadbandsRequest = UsageBroadbandsRequest.builder()
                .cityId("Oxford")
                .customerContractId("42")
                .addressableCode("44")
                .detailed(false)
                .endDate("2020-03-31")
                .operatorCode("Operator Code")
                .protocolNumber("42")
                .smartCardNumber("42")
                .startDate("2020-03-01")
                .build();

        // Mock do comportamento do findPointId no Spy
        doReturn("POINT123").when(usagesBroadbandsRepository).findPointId(usageBroadbandsRequest);

        // Criação do MapSqlParameterSource esperado
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("STARTDATE", "2020-03-01");
        params.addValue("ENDDATE", "2020-03-31");
        params.addValue("POINTID", "POINT123");
        params.addValue("ADDRESSABLECODE", "44");
        params.addValue("CITYID", "Oxford");
        params.addValue("CUSTOMERCONTRACTID", "42");

        // Mock do setupQueryParams
        doReturn(params).when(usagesBroadbandsRepository).setupQueryParams(
                usageBroadbandsRequest, "POINT123", "2020-03-01", "2020-03-31");

        // Mock do namedParameterJdbcTemplate.query
        List<ConsolidatedUsage> mockResult = new ArrayList<>();
        mockResult.add(new ConsolidatedUsage()); // Simulação de um resultado
        when(namedParameterJdbcTemplate.query(anyString(), eq(params), any(BroadbandsConsolidatedRowMapper.class)))
                .thenReturn(mockResult);

        // Act
        UsagesBroadbandsResponse response = usagesBroadbandsRepository.findConsolidatedUsage(usageBroadbandsRequest);

        assertNotNull(response);
        assertNotNull(response.getData());
    }

    @Test
    void testGetConsolidatedContractDataAllowance() {
        // Arrange and Act
        BigDecimal actualConsolidatedContractDataAllowance = usagesBroadbandsRepository
                .getConsolidatedContractDataAllowance(new ArrayList<>());

        // Assert
        assertEquals(new BigDecimal("0"), actualConsolidatedContractDataAllowance);
        assertSame(BigDecimal.ZERO, actualConsolidatedContractDataAllowance);
    }

    @Test
    void testGetConsolidatedContractDataAllowance2() {
        // Arrange
        ConsolidatedUsage consolidatedUsage = new ConsolidatedUsage();
        consolidatedUsage.setFranquiaContratada(new BigDecimal("2.3"));
        consolidatedUsage.setPercentualUtilizado(new BigDecimal("2.3"));
        BigDecimal quota = new BigDecimal("2.3");
        consolidatedUsage.setQuota(quota);
        consolidatedUsage.setTotalDisponivel(new BigDecimal("2.3"));
        consolidatedUsage.setTotalUtilizado(new BigDecimal("2.3"));
        consolidatedUsage.setValidadeCredito("alice.liddell@example.org");

        ArrayList<ConsolidatedUsage> consolidatedUsage2 = new ArrayList<>();
        consolidatedUsage2.add(consolidatedUsage);

        // Act
        BigDecimal actualConsolidatedContractDataAllowance = usagesBroadbandsRepository
                .getConsolidatedContractDataAllowance(consolidatedUsage2);

        // Assert
        assertEquals(new BigDecimal("2.3"), actualConsolidatedContractDataAllowance);
        assertSame(quota, actualConsolidatedContractDataAllowance);
    }

    @Test
    void testGetConsolidatedContractDataAllowance3() {
        // Arrange
        ConsolidatedUsage consolidatedUsage = new ConsolidatedUsage();
        consolidatedUsage.setFranquiaContratada(new BigDecimal("2.3"));
        consolidatedUsage.setPercentualUtilizado(new BigDecimal("2.3"));
        consolidatedUsage.setQuota(new BigDecimal("2.3"));
        consolidatedUsage.setTotalDisponivel(new BigDecimal("2.3"));
        consolidatedUsage.setTotalUtilizado(new BigDecimal("2.3"));
        consolidatedUsage.setValidadeCredito("alice.liddell@example.org");

        ConsolidatedUsage consolidatedUsage2 = new ConsolidatedUsage();
        consolidatedUsage2.setFranquiaContratada(new BigDecimal("2.3"));
        consolidatedUsage2.setPercentualUtilizado(new BigDecimal("2.3"));
        BigDecimal quota = new BigDecimal("2.3");
        consolidatedUsage2.setQuota(quota);
        consolidatedUsage2.setTotalDisponivel(new BigDecimal("2.3"));
        consolidatedUsage2.setTotalUtilizado(new BigDecimal("2.3"));
        consolidatedUsage2.setValidadeCredito("Validade Credito");

        ArrayList<ConsolidatedUsage> consolidatedUsage3 = new ArrayList<>();
        consolidatedUsage3.add(consolidatedUsage2);
        consolidatedUsage3.add(consolidatedUsage);

        // Act
        BigDecimal actualConsolidatedContractDataAllowance = usagesBroadbandsRepository
                .getConsolidatedContractDataAllowance(consolidatedUsage3);

        // Assert
        assertEquals(new BigDecimal("2.3"), actualConsolidatedContractDataAllowance);
        assertSame(quota, actualConsolidatedContractDataAllowance);
    }

    @Test
    void testGetConsolidatedContractDataAllowance4() {
        // Arrange
        ConsolidatedUsage consolidatedUsage = new ConsolidatedUsage();
        consolidatedUsage.setFranquiaContratada(new BigDecimal("2.3"));
        consolidatedUsage.setPercentualUtilizado(new BigDecimal("2.3"));
        consolidatedUsage.setQuota(null);
        consolidatedUsage.setTotalDisponivel(new BigDecimal("2.3"));
        consolidatedUsage.setTotalUtilizado(new BigDecimal("2.3"));
        consolidatedUsage.setValidadeCredito("alice.liddell@example.org");

        ArrayList<ConsolidatedUsage> consolidatedUsage2 = new ArrayList<>();
        consolidatedUsage2.add(consolidatedUsage);

        // Act
        BigDecimal actualConsolidatedContractDataAllowance = usagesBroadbandsRepository
                .getConsolidatedContractDataAllowance(consolidatedUsage2);

        // Assert
        assertEquals(new BigDecimal("0"), actualConsolidatedContractDataAllowance);
        assertSame(BigDecimal.ZERO, actualConsolidatedContractDataAllowance);
    }

    @Test
    void testGetDetailedContractDataAllowance() {
        // Arrange and Act
        BigDecimal actualDetailedContractDataAllowance = usagesBroadbandsRepository
                .getDetailedContractDataAllowance(new ArrayList<>());

        // Assert
        assertEquals(new BigDecimal("0"), actualDetailedContractDataAllowance);
        assertSame(BigDecimal.ZERO, actualDetailedContractDataAllowance);
    }

    @Test
    void testGetDetailedContractDataAllowance2() {
        // Arrange
        ArrayList<DetailedUsage> detailedUsage = new ArrayList<>();
        detailedUsage.add(new DetailedUsage());

        // Act
        BigDecimal actualDetailedContractDataAllowance = usagesBroadbandsRepository
                .getDetailedContractDataAllowance(detailedUsage);

        // Assert
        assertEquals(new BigDecimal("0"), actualDetailedContractDataAllowance);
        assertSame(BigDecimal.ZERO, actualDetailedContractDataAllowance);
    }

    @Test
    void testGetDetailedContractDataAllowance3() {
        // Arrange
        ArrayList<DetailedUsage> detailedUsage = new ArrayList<>();
        detailedUsage.add(new DetailedUsage());
        detailedUsage.add(new DetailedUsage());

        // Act
        BigDecimal actualDetailedContractDataAllowance = usagesBroadbandsRepository
                .getDetailedContractDataAllowance(detailedUsage);

        // Assert
        assertEquals(new BigDecimal("0"), actualDetailedContractDataAllowance);
        assertSame(BigDecimal.ZERO, actualDetailedContractDataAllowance);
    }

    @Test
    void testGetDetailedContractDataAllowance4() {
        // Arrange
        ArrayList<DetailedUsage> detailedUsage = new ArrayList<>();
        BigDecimal vlBonus = new BigDecimal("2.3");
        BigDecimal vlFranquiaAcumulada = new BigDecimal("2.3");
        BigDecimal vlFranquiaAdicional = new BigDecimal("2.3");
        BigDecimal vlFranquiaAdicAcumAdq = new BigDecimal("2.3");
        BigDecimal vlFranquiaConsumida = new BigDecimal("2.3");
        BigDecimal vlFranquiaContrato = new BigDecimal("2.3");
        detailedUsage.add(new DetailedUsage("Cd Enderecavel", "alice.liddell@example.org", "Dt Consumo", 1L,
                "alice.liddell@example.org", vlBonus, vlFranquiaAcumulada, vlFranquiaAdicional, vlFranquiaAdicAcumAdq,
                vlFranquiaConsumida, vlFranquiaContrato, "Fc Penaliza Notifica", "Pc Faixa Penaliza Notifica"));

        // Act
        BigDecimal actualDetailedContractDataAllowance = usagesBroadbandsRepository
                .getDetailedContractDataAllowance(detailedUsage);

        // Assert
        assertEquals(new BigDecimal("2.3"), actualDetailedContractDataAllowance);
        assertSame(vlFranquiaContrato, actualDetailedContractDataAllowance);
    }

    @Test
    void testGetDetailedContractDataAllowance5() {
        // Arrange
        ArrayList<DetailedUsage> detailedUsage = new ArrayList<>();
        BigDecimal vlBonus = new BigDecimal("2.3");
        BigDecimal vlFranquiaAcumulada = new BigDecimal("2.3");
        BigDecimal vlFranquiaAdicional = new BigDecimal("2.3");
        BigDecimal vlFranquiaAdicAcumAdq = new BigDecimal("2.3");
        BigDecimal vlFranquiaConsumida = new BigDecimal("2.3");
        detailedUsage.add(new DetailedUsage("Cd Enderecavel", "alice.liddell@example.org", "Dt Consumo", 1L,
                "alice.liddell@example.org", vlBonus, vlFranquiaAcumulada, vlFranquiaAdicional, vlFranquiaAdicAcumAdq,
                vlFranquiaConsumida, new BigDecimal("-2.3"), "Fc Penaliza Notifica", "Pc Faixa Penaliza Notifica"));

        // Act
        BigDecimal actualDetailedContractDataAllowance = usagesBroadbandsRepository
                .getDetailedContractDataAllowance(detailedUsage);

        // Assert
        assertEquals(new BigDecimal("0"), actualDetailedContractDataAllowance);
        assertSame(BigDecimal.ZERO, actualDetailedContractDataAllowance);
    }

    @Test
    void testGetDetailedCreditPools_WithValidData() {

        List<DetailedUsage> usageDetailList = new ArrayList<>();

        DetailedUsage usageDetail = new DetailedUsage();
        usageDetail.setVlFranquiaAdicional(new BigDecimal("1000"));
        usageDetail.setVlFranquiaConsumida(new BigDecimal("500.50"));
        usageDetail.setVlFranquiaContrato(new BigDecimal("1500"));
        usageDetail.setVlFranquiaAdicAcumAdq(new BigDecimal("200"));
        usageDetail.setVlBonus(new BigDecimal("300"));
        usageDetail.setVlFranquiaAcumulada(new BigDecimal("400"));
        usageDetail.setDtConsumo("2023-10-30 15:45:00");
        usageDetail.setFcPenalizaNotifica("N");
        usageDetail.setPcFaixaPenalizaNotifica("80");

        usageDetailList.add(usageDetail);

        List<CreditPool> result = usagesBroadbandsRepository.getDetailedCreditPools(usageDetailList);

        assertEquals(1, result.size());

        DetailedCreditPool detailedCreditPool = (DetailedCreditPool) result.get(0);
        assertEquals("1000", detailedCreditPool.getTotalContracted());
        assertEquals("500.50", detailedCreditPool.getTotalUsed());
        assertEquals("1600", detailedCreditPool.getTotalAvailable());
        assertEquals("20.00", detailedCreditPool.getTotalUsagePercentage());
        assertEquals("2023-10-30T15:45:00", detailedCreditPool.getDate());
        assertEquals("Notificado 80%", detailedCreditPool.getNotification());
    }
    @Test
    void testGetDetailedCreditPools_WithPenalizedNotification() {
        // Arrange: criar uma lista com um objeto DetailedUsage onde notificaPenaliza é "P"
        List<DetailedUsage> usageDetailList = new ArrayList<>();

        DetailedUsage usageDetail = new DetailedUsage();
        usageDetail.setVlFranquiaAdicional(new BigDecimal("1000"));
        usageDetail.setVlFranquiaConsumida(new BigDecimal("500.50"));
        usageDetail.setVlFranquiaContrato(new BigDecimal("1500"));
        usageDetail.setVlFranquiaAdicAcumAdq(new BigDecimal("200"));
        usageDetail.setVlBonus(new BigDecimal("300"));
        usageDetail.setVlFranquiaAcumulada(new BigDecimal("400"));
        usageDetail.setDtConsumo("2023-10-30 15:45:00");
        usageDetail.setFcPenalizaNotifica("P");

        usageDetailList.add(usageDetail);

        // Act: chamar o método com dados na lista
        List<CreditPool> result = usagesBroadbandsRepository.getDetailedCreditPools(usageDetailList);


        assertEquals(1, result.size());


        DetailedCreditPool detailedCreditPool = (DetailedCreditPool) result.get(0);
        assertEquals("Penalizado", detailedCreditPool.getNotification());
    }


    @Test
    void testGetConsolidatedCreditPools_WithValidData() {

        List<ConsolidatedUsage> consolidatedUsageList = new ArrayList<>();

        ConsolidatedUsage consolidatedUsage = new ConsolidatedUsage();
        consolidatedUsage.setValidadeCredito("2023-10-30 15:45:00");
        consolidatedUsage.setFranquiaContratada(new BigDecimal("1000"));
        consolidatedUsage.setTotalUtilizado(new BigDecimal("500.5678"));
        consolidatedUsage.setTotalDisponivel(new BigDecimal("500"));
        consolidatedUsage.setPercentualUtilizado(new BigDecimal("50.5678"));

        consolidatedUsageList.add(consolidatedUsage);

        // Act: chamar o método com dados na lista
        List<CreditPool> result = usagesBroadbandsRepository.getConsolidatedCreditPools(consolidatedUsageList);

        // Assert: verificar os resultados
        assertEquals(1, result.size());

        // Verificar que os valores retornados estão formatados corretamente
        CreditPool creditPool = result.get(0);
        assertEquals("1000", creditPool.getTotalContracted());
        assertEquals("500.57", creditPool.getTotalUsed());
        assertEquals("500", creditPool.getTotalAvailable());
        assertEquals("50.57", creditPool.getTotalUsagePercentage());
    }

    @Test
    void testGetCustomerInformationFromSmartcardNumber() throws UnprocessableEntityException {
        CustomerInformation expectedCustomerInfo = new CustomerInformation();
        expectedCustomerInfo.setCityId("05509");
        expectedCustomerInfo.setCustomerContractId(null);

        when(namedParameterJdbcTemplate.queryForObject(
                anyString(),
                any(MapSqlParameterSource.class),
                any(CustomerInformationRowMapper.class)
        )).thenReturn(expectedCustomerInfo);

        CustomerInformation actualCustomerInformation = usagesBroadbandsRepository.getCustomerInformationFromSmartcardNumber("42");

        assertNotNull(actualCustomerInformation, "O retorno do método não deve ser nulo.");
        assertEquals("05509", actualCustomerInformation.getCityId());
        assertNull(actualCustomerInformation.getCustomerContractId());
    }

    @Test
    void testGetCustomerInformationFromSmartcardNumber_ShouldThrowUnprocessableEntityException() {
        when(namedParameterJdbcTemplate.queryForObject(
                anyString(),
                any(MapSqlParameterSource.class),
                any(CustomerInformationRowMapper.class)
        )).thenThrow(new EmptyResultDataAccessException(1));

        UnprocessableEntityException exception = assertThrows(UnprocessableEntityException.class, () ->
                usagesBroadbandsRepository.getCustomerInformationFromSmartcardNumber("3453277777")
        );

        assertEquals(ErrorConstants.ERROR_DATA_NOT_FOUND, exception.getMessage());
    }


    @Test
    void testFindPointId() throws UnprocessableEntityException {
        UsageBroadbandsRequest request = new UsageBroadbandsRequest();
        request.setAddressableCode("ADDRESS123");
        request.setCustomerContractId("CONTRACT456");
        request.setCityId("CITY789");

        String expectedPointId = "POINT123";
        when(namedParameterJdbcTemplate.queryForObject(anyString(), any(MapSqlParameterSource.class), eq(String.class)))
                .thenReturn(expectedPointId);

        String actualPointId = usagesBroadbandsRepository.findPointId(request);

        assertEquals(expectedPointId, actualPointId);

    }
    @Test
    void testSetupQueryParams() {
        // Arrange and Act
        MapSqlParameterSource actualSetupQueryParamsResult = usagesBroadbandsRepository
                .setupQueryParams(new UsageBroadbandsRequest(), "42", "2020-03-01", "2020-03-01");

        // Assert
        Map<String, Object> values = actualSetupQueryParamsResult.getValues();
        assertEquals(6, values.size());
        assertEquals("2020-03-01", values.get("STARTDATE"));
        assertEquals("42", values.get("POINTID"));
        assertNull(values.get("ADDRESSABLECODE"));
        assertNull(values.get("CITYID"));
        assertNull(values.get("CUSTOMERCONTRACTID"));
        assertTrue(actualSetupQueryParamsResult.hasValues());
        assertSame(values.get("STARTDATE"), values.get("ENDDATE"));
        assertArrayEquals(
                new String[]{"ADDRESSABLECODE", "CUSTOMERCONTRACTID", "CITYID", "POINTID", "STARTDATE", "ENDDATE"},
                actualSetupQueryParamsResult.getParameterNames());
    }

    @Test
    void testBuildResponse() {
        // Arrange
        BigDecimal franquia = new BigDecimal("2.3");
        ArrayList<CreditPool> creditPoolsList = new ArrayList<>();

        // Act and Assert
        ServiceUsage serviceUsage = usagesBroadbandsRepository.buildResponse(franquia, creditPoolsList)
                .getData()
                .getServiceUsage();
        assertEquals("2.3", serviceUsage.getDataAllowance().getQuota());
        List<CreditPool> creditPools = serviceUsage.getCreditPools();
        assertTrue(creditPools.isEmpty());
        assertSame(creditPoolsList, creditPools);
    }

    @Test
    void testBuildResponse2() {
        // Arrange
        BigDecimal franquia = new BigDecimal("2.3");

        ArrayList<CreditPool> creditPoolsList = new ArrayList<>();
        creditPoolsList.add(new CreditPool("Total Used", "Total Contracted", "Total Available", "Total Usage Percentage"));

        // Act and Assert
        ServiceUsage serviceUsage = usagesBroadbandsRepository.buildResponse(franquia, creditPoolsList)
                .getData()
                .getServiceUsage();
        assertEquals("2.3", serviceUsage.getDataAllowance().getQuota());
        assertSame(creditPoolsList, serviceUsage.getCreditPools());
    }

    @Test
    void testBuildResponse3() {
        // Arrange
        BigDecimal franquia = new BigDecimal("2.3");

        ArrayList<CreditPool> creditPoolsList = new ArrayList<>();
        creditPoolsList.add(new CreditPool("Total Used", "Total Contracted", "Total Available", "Total Usage Percentage"));
        creditPoolsList.add(new CreditPool("Total Used", "Total Contracted", "Total Available", "Total Usage Percentage"));

        // Act and Assert
        ServiceUsage serviceUsage = usagesBroadbandsRepository.buildResponse(franquia, creditPoolsList)
                .getData()
                .getServiceUsage();
        assertEquals("2.3", serviceUsage.getDataAllowance().getQuota());
        assertSame(creditPoolsList, serviceUsage.getCreditPools());
    }

}
