package br.com.clarobr.serviceusagesbroadbands.repository;


import br.com.clarobr.common.base.utils.LogUtil;
import br.com.clarobr.common.connection.MultiBaseThreadStorage;
import br.com.clarobr.common.connection.repository.MultiDatabaseRepository;
import br.com.clarobr.serviceusagesbroadbands.constants.ErrorConstants;
import br.com.clarobr.serviceusagesbroadbands.constants.RepositoryConstants;
import br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException;
import br.com.clarobr.serviceusagesbroadbands.exception.UnprocessableEntityException;
import br.com.clarobr.serviceusagesbroadbands.mapper.BroadbandsConsolidatedRowMapper;
import br.com.clarobr.serviceusagesbroadbands.mapper.BroadbandsDetailedRowMapper;
import br.com.clarobr.serviceusagesbroadbands.mapper.CustomerInformationRowMapper;
import br.com.clarobr.serviceusagesbroadbands.mapper.CityIdRowMapper;
import br.com.clarobr.serviceusagesbroadbands.models.*;
import br.com.clarobr.serviceusagesbroadbands.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Slf4j
@Repository
public class UsagesBroadbandsRepository {

    @Autowired
    private MultiDatabaseRepository multiDatabaseRepository;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String ADDRESSABLECODE = "ADDRESSABLECODE";
    private static final String CUSTOMERCONTRACTID = "CUSTOMERCONTRACTID";
    private static final String CITYID = "CITYID";
    private static final String OPERATORCODE = "OPERATORCODE";
    private static final String STARTDATE = "STARTDATE";
    private static final String ENDDATE = "ENDDATE";
    private static final String POINTID = "POINTID";

    public String findCityIdByOperatorCode(String operatorCode) throws UnprocessableEntityException {

        String cityId;

        LogUtil.info(log, "CityId nao informado, consultando com o OperatorCode: {}", operatorCode);

        var sqlQuery = RepositoryConstants.QUERY_FETCH_CITY_ID_BY_OPERATOR_CODE;
        Map<String, Object> parametros = new HashMap<>();
        parametros.put(OPERATORCODE, operatorCode);

        try{
            MultiBaseThreadStorage.setBase("ISP");
            cityId = multiDatabaseRepository.queryNamedParameters(sqlQuery, parametros, new CityIdRowMapper()).get(0);
            LogUtil.info(log, "CityId retornado: {}", cityId);
        } catch (NoSuchElementException | EmptyResultDataAccessException | IndexOutOfBoundsException e) {
            LogUtil.error(log, "CityId nao encontrado para o operatorCode: " + operatorCode, e);
            throw new UnprocessableEntityException(ErrorConstants.API_SERVICEUSAGESBROADBANDS_001, ErrorConstants.ERROR_CITYID_NOT_FOUND);

        }
        finally {
            MultiBaseThreadStorage.finalizeBase();
        }
        return cityId;
    }

    public CustomerInformation getCustomerInformationFromSmartcardNumber(String smartcardNumber) throws UnprocessableEntityException {
        log.info("Iniciando metodo getCustomerInformationFromSmartcardNumber");

        CustomerInformation customerInformation;
        final var params = new MapSqlParameterSource().addValue(ADDRESSABLECODE, smartcardNumber);

        try {
            MultiBaseThreadStorage.setBase("ATLP");

            customerInformation = namedParameterJdbcTemplate.queryForObject(
                    RepositoryConstants.QUERY_FETCH_CUSTOMER_INFORMATION_BY_ADDRESSABLE_CODE,
                    params,
                    new CustomerInformationRowMapper()
            );

            if (customerInformation != null) {
                log.info("Retorno do getCustomerInformationFromSmartcardNumber: {}", customerInformation);
            } else {
                log.warn("Dados nao encontrados para getCustomerInformationFromSmartcardNumber: {}", smartcardNumber);
            }

        } catch (EmptyResultDataAccessException e) {
            log.error("Dados nao encontrados durante a consulta do CustomerContractId e CityId utilizando SmartCard/addressableCode.", e);
            throw new UnprocessableEntityException(ErrorConstants.API_SERVICEUSAGESBROADBANDS_002, ErrorConstants.ERROR_DATA_NOT_FOUND);
        } finally {
            MultiBaseThreadStorage.finalizeBase();
        }

        return customerInformation;
    }


    public UsagesBroadbandsResponse findDetailedUsage(UsageBroadbandsRequest usageBroadbandsRequest) throws UnprocessableEntityException, BadRequestException {
        LogUtil.info(log, "Iniciando o metodo findDetailedUsage");
        logDebugRequestParameters("findDetailedUsage", usageBroadbandsRequest);

        setMediationDatabase();

        try {
            String formattedStartDate = formatDate(usageBroadbandsRequest.getStartDate());
            String formattedEndDate = formatDate(usageBroadbandsRequest.getEndDate());

            String pointId = findPointId(usageBroadbandsRequest);

            LogUtil.info(log, "Consultando o consumo detalhado de banda larga no banco de dados");
            var params = setupQueryParams(usageBroadbandsRequest, pointId, formattedStartDate, formattedEndDate);
            List<DetailedUsage> usageDetailList = namedParameterJdbcTemplate.query(RepositoryConstants.QUERY_FETCH_DETAILED, params, new BroadbandsDetailedRowMapper());
            LogUtil.debug(log, "UsageDetailList retornado: {}", usageDetailList);

            BigDecimal franquia = getDetailedContractDataAllowance(usageDetailList);
            List<CreditPool> detalhado = getDetailedCreditPools(usageDetailList);

            return buildResponse(franquia, detalhado);

        } catch (ParseException e) {
            log.error("Erro ao converter as datas fornecidas no metodo findDetailedUsage.", e);
            throw new BadRequestException(ErrorConstants.ERROR_INVALID_FORMAT_DATE);

        } catch (EmptyResultDataAccessException | UnprocessableEntityException e) {
            log.error("Nenhum resultado encontrado durante a consulta no metodo findDetailedUsage.", e);
            throw new UnprocessableEntityException(ErrorConstants.API_SERVICEUSAGESBROADBANDS_002, ErrorConstants.ERROR_DATA_NOT_FOUND);

        } finally {
            MultiBaseThreadStorage.finalizeBase();
        }
    }

    public UsagesBroadbandsResponse findConsolidatedUsage(UsageBroadbandsRequest usageBroadbandsRequest) throws UnprocessableEntityException, BadRequestException {
        LogUtil.info(log, "Iniciando metodo findConsolidatedUsage");
        logDebugRequestParameters("findConsolidatedUsage", usageBroadbandsRequest);

        setMediationDatabase();

        try {
            String formattedStartDate = formatDate(usageBroadbandsRequest.getStartDate());
            String formattedEndDate = formatDate(usageBroadbandsRequest.getEndDate());

            String pointId = findPointId(usageBroadbandsRequest);

            LogUtil.info(log, "Consultando o consumo consolidado de banda larga no banco de dados");
            var params = setupQueryParams(usageBroadbandsRequest, pointId, formattedStartDate, formattedEndDate);
            List<ConsolidatedUsage> consolidatedUsageList = namedParameterJdbcTemplate.query(RepositoryConstants.QUERY_FETCH_CONSOLIDATED, params, new BroadbandsConsolidatedRowMapper());
            LogUtil.debug(log, "ConsolidatedUsageList retornado: {}", consolidatedUsageList);

            BigDecimal franquia = getConsolidatedContractDataAllowance(consolidatedUsageList);
            List<CreditPool> consolidado = getConsolidatedCreditPools(consolidatedUsageList);

            return buildResponse(franquia, consolidado);

        } catch (EmptyResultDataAccessException | UnprocessableEntityException e) {
            log.error("Nenhum resultado encontrado durante a consulta no metodo findConsolidatedUsage.", e);
            throw new UnprocessableEntityException(ErrorConstants.API_SERVICEUSAGESBROADBANDS_002, ErrorConstants.ERROR_DATA_NOT_FOUND);

        } catch (ParseException e) {
            log.error("Erro ao converter as datas fornecidas no metodo findConsolidatedUsage.", e);
            throw new BadRequestException(ErrorConstants.ERROR_INVALID_FORMAT_DATE);
        } finally {
            MultiBaseThreadStorage.finalizeBase();
        }
    }

    public String findPointId(UsageBroadbandsRequest usageBroadbandsRequest) throws UnprocessableEntityException {
        var params = new MapSqlParameterSource();
        params.addValue(ADDRESSABLECODE, usageBroadbandsRequest.getAddressableCode());
        params.addValue(CUSTOMERCONTRACTID, usageBroadbandsRequest.getCustomerContractId());
        params.addValue(CITYID, usageBroadbandsRequest.getCityId());
        LogUtil.info(log, "Consultando o ID do Ponto");
        LogUtil.debug(log, "Query Parameters: ADDRESSABLECODE={}, CUSTOMERCONTRACTID={}, CITYID={}",
                usageBroadbandsRequest.getAddressableCode(), usageBroadbandsRequest.getCustomerContractId(), usageBroadbandsRequest.getCityId());

        try {
            String pointId = namedParameterJdbcTemplate.queryForObject(
                    RepositoryConstants.QUERY_FETCH_ID_PONTO_HISTORICO_CONSUMO,
                    params,
                    String.class
            );

            LogUtil.debug(log, "ID do Ponto retornado: {}", pointId);
            return pointId;
        } catch (EmptyResultDataAccessException e) {
            LogUtil.error(log, "ID do Ponto nao encontrado para o contrato: {}", usageBroadbandsRequest.getCustomerContractId(), e);
            throw new UnprocessableEntityException(ErrorConstants.API_SERVICEUSAGESBROADBANDS_002, ErrorConstants.ERROR_DATA_NOT_FOUND);

        }
    }

    private void setMediationDatabase() {
        LogUtil.info(log, "Setando MultiBaseThread: MEDIATION");
        MultiBaseThreadStorage.setBase("MEDIATION");
    }

    MapSqlParameterSource setupQueryParams(UsageBroadbandsRequest usageBroadbandsRequest, String pointId, String formattedStartDate, String formattedEndDate) {
        var params = new MapSqlParameterSource();
        params.addValue(ADDRESSABLECODE, usageBroadbandsRequest.getAddressableCode());
        params.addValue(CUSTOMERCONTRACTID, usageBroadbandsRequest.getCustomerContractId());
        params.addValue(CITYID, usageBroadbandsRequest.getCityId());
        params.addValue(POINTID, pointId);
        params.addValue(STARTDATE, formattedStartDate);
        params.addValue(ENDDATE, formattedEndDate);
        LogUtil.debug(log,"Query Parameters: CUSTOMERCONTRACTID={}, CITYID={}, POINTID={}, STARTDATE={}, ENDDATE={}",
                usageBroadbandsRequest.getCustomerContractId(), usageBroadbandsRequest.getCityId(), pointId, formattedStartDate, formattedEndDate);

        return params;
    }

    private String formatDate(String date) throws ParseException {
        return DateUtils.convertToDDMMYYYY(date);
    }

    public BigDecimal getConsolidatedContractDataAllowance(List<ConsolidatedUsage> consolidatedUsage){

        BigDecimal franquiaContrato = BigDecimal.ZERO;

        for (ConsolidatedUsage quota : consolidatedUsage) {
            if (quota.getQuota() != null && quota.getQuota().compareTo(franquiaContrato) > 0) {
                franquiaContrato = quota.getQuota();
            }
        }

        return franquiaContrato;
    }

    public BigDecimal getDetailedContractDataAllowance(List<DetailedUsage> detailedUsage){

        BigDecimal franquiaContrato = BigDecimal.ZERO;

        for (DetailedUsage quota : detailedUsage) {
            if (quota.getVlFranquiaContrato() != null && quota.getVlFranquiaContrato().compareTo(franquiaContrato) > 0) {
                franquiaContrato = quota.getVlFranquiaContrato();
            }
        }

        return franquiaContrato;
    }

    public List<CreditPool> getConsolidatedCreditPools(List<ConsolidatedUsage> consolidatedUsageList){

        var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        var inputDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<CreditPool> consolidatedCreditPools = new ArrayList<>();

        // Iterar sobre a lista de ConsolidatedUsage
        for (ConsolidatedUsage consolidatedUsage : consolidatedUsageList) {

            String rawDate = consolidatedUsage.getValidadeCredito();
            var parsedDate = LocalDateTime.parse(rawDate, inputDateTimeFormatter);

            String formattedMonth = parsedDate.format(dateFormatter);

            BigDecimal totalContracted = consolidatedUsage.getFranquiaContratada() != null ? consolidatedUsage.getFranquiaContratada() : BigDecimal.ZERO;
            BigDecimal totalUsed = consolidatedUsage.getTotalUtilizado() != null ? consolidatedUsage.getTotalUtilizado().setScale(2, RoundingMode.HALF_UP) : BigDecimal.ZERO;
            BigDecimal totalAvailable = consolidatedUsage.getTotalDisponivel() != null && consolidatedUsage.getTotalDisponivel().compareTo(BigDecimal.ZERO) >= 0
                    ? consolidatedUsage.getTotalDisponivel() : BigDecimal.ZERO;

            BigDecimal usagePercentage = consolidatedUsage.getPercentualUtilizado() != null
                    ? consolidatedUsage.getPercentualUtilizado().setScale(2, RoundingMode.HALF_UP)
                    : BigDecimal.ZERO;

            var consolidatedCreditPool = new ConsolidatedCreditPool();
            consolidatedCreditPool.setTotalContracted(totalContracted.toString());
            consolidatedCreditPool.setTotalUsed(totalUsed.toString());
            consolidatedCreditPool.setTotalAvailable(totalAvailable.toString());
            consolidatedCreditPool.setTotalUsagePercentage(usagePercentage.toString());
            consolidatedCreditPool.setMonth(formattedMonth);

            consolidatedCreditPools.add(consolidatedCreditPool);
        }

        return consolidatedCreditPools;
    }

    public List<CreditPool> getDetailedCreditPools(List<DetailedUsage> usageDetailList){
        var dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        var inputDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<CreditPool> detailedCreditPools = new ArrayList<>();

        for( DetailedUsage usageDetail : usageDetailList){
            BigDecimal totalContracted = usageDetail.getVlFranquiaAdicional() != null ? usageDetail.getVlFranquiaAdicional() : BigDecimal.ZERO;
            BigDecimal totalUsed = usageDetail.getVlFranquiaConsumida() != null ? usageDetail.getVlFranquiaConsumida() : BigDecimal.ZERO;
            BigDecimal totalAvailable = usageDetail.getVlFranquiaContrato().add(usageDetail.getVlFranquiaAdicAcumAdq()).add(usageDetail.getVlBonus()).subtract(usageDetail.getVlFranquiaAcumulada());
            totalAvailable = totalAvailable.compareTo(BigDecimal.ZERO) >= 0 ? totalAvailable : BigDecimal.ZERO;

            BigDecimal usagePercentage = usageDetail.getVlFranquiaAcumulada()
                    .divide(
                            usageDetail.getVlFranquiaContrato()
                                    .add(usageDetail.getVlFranquiaAdicAcumAdq())
                                    .add(usageDetail.getVlBonus()),
                            4, RoundingMode.HALF_UP)
                    .multiply(new BigDecimal(100))
                    .setScale(2, RoundingMode.HALF_UP);
            String date = LocalDateTime.parse(usageDetail.getDtConsumo(), inputDateTimeFormatter).format(dateFormatter);
            var detailedCreditPool = new DetailedCreditPool();

            detailedCreditPool.setTotalContracted(totalContracted.toString());
            detailedCreditPool.setTotalUsed(totalUsed.toString());
            detailedCreditPool.setTotalAvailable(totalAvailable.toString());
            detailedCreditPool.setTotalUsagePercentage(usagePercentage.toString());
            detailedCreditPool.setDate(date);

            String notificaPenaliza = usageDetail.getFcPenalizaNotifica();

            if (notificaPenaliza != null) {
                if (notificaPenaliza.equals("N")) {
                    detailedCreditPool.setNotification("Notificado " + usageDetail.getPcFaixaPenalizaNotifica() + "%");
                } else if (notificaPenaliza.equals("P")) {
                    detailedCreditPool.setNotification("Penalizado");
                }
            } else {
                detailedCreditPool.setNotification("");
            }

            detailedCreditPools.add(detailedCreditPool);
        }
        return detailedCreditPools;
    }

    public UsagesBroadbandsResponse buildResponse(BigDecimal franquia, List<CreditPool> creditPoolsList) {
        var response = new UsagesBroadbandsResponse();
        var creditPools = new CreditPools();
        var dataAllowance = new DataAllowance();
        var serviceUsage = new ServiceUsage();
        var usageData = new UsagesData();

        dataAllowance.setQuota(franquia.toString());
        serviceUsage.setDataAllowance(dataAllowance);
        usageData.setServiceUsage(serviceUsage);

        creditPools.setCreditPoolList(creditPoolsList);
        serviceUsage.setCreditPools(creditPools.getCreditPoolList());

        response.setData(usageData);
        return response;
    }

    private void logDebugRequestParameters(String methodName, UsageBroadbandsRequest usageBroadbandsRequest) {
        LogUtil.debug(log, "Parametros {} - customerContractId: {}, cityId: {}, addressableCode: {}, startDate: {}, endDate: {}",
                methodName, usageBroadbandsRequest.getCustomerContractId(), usageBroadbandsRequest.getCityId(),
                usageBroadbandsRequest.getAddressableCode(), usageBroadbandsRequest.getStartDate(),
                usageBroadbandsRequest.getEndDate());
    }
}
