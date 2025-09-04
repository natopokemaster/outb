package br.com.clarobr.serviceusagesbroadbands.service;

import br.com.clarobr.serviceusagesbroadbands.constants.ErrorConstants;
import br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException;
import br.com.clarobr.serviceusagesbroadbands.exception.UnprocessableEntityException;
import br.com.clarobr.serviceusagesbroadbands.models.UsageBroadbandsRequest;
import br.com.clarobr.serviceusagesbroadbands.models.UsagesBroadbandsResponse;
import br.com.clarobr.serviceusagesbroadbands.repository.UsagesBroadbandsRepository;
import br.com.clarobr.serviceusagesbroadbands.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;


@Slf4j
@Service
public class UsagesBroadbandsService {

    @Autowired
    private UsagesBroadbandsRepository usagesBroadbandsRepository;

    public static final String CUSTOMER_CONTRACT_ID = "customerContractId";
    public static final String SMART_CARD_NUMBER = "smartCardNumber";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    public static final String DETAILED = "detailed";
    public static final String ADDRESSABLE_CODE = "addressableCode";

    public UsagesBroadbandsResponse getUsagesBroadbands(UsageBroadbandsRequest usageBroadbandsRequest) throws UnprocessableEntityException, BadRequestException {

        // Verifica se smartCardNumber foi passado
        if (usageBroadbandsRequest.getSmartCardNumber() != null && !usageBroadbandsRequest.getSmartCardNumber().isBlank()) {
            log.info("Iniciando o metodo getUsagesBroadbands utilizando o smartCardNumber: {}", usageBroadbandsRequest.getSmartCardNumber());

            String smartCardNumberFromRequest = usageBroadbandsRequest.getSmartCardNumber();

            var customerInformation = usagesBroadbandsRepository.getCustomerInformationFromSmartcardNumber(smartCardNumberFromRequest);

            usageBroadbandsRequest.setCustomerContractId(customerInformation.getCustomerContractId());
            usageBroadbandsRequest.setCityId(customerInformation.getCityId());

        }
        else if (usageBroadbandsRequest.getCustomerContractId() != null && !usageBroadbandsRequest.getCustomerContractId().isBlank()) {

            if (usageBroadbandsRequest.getOperatorCode() != null && !usageBroadbandsRequest.getOperatorCode().isBlank()) {
                log.info("Iniciando o metodo getUsagesBroadbands utilizando o customerContractId: {} e OperatorCode: {}", usageBroadbandsRequest.getCustomerContractId(), usageBroadbandsRequest.getOperatorCode());
                usageBroadbandsRequest.setCityId(usagesBroadbandsRepository.findCityIdByOperatorCode(usageBroadbandsRequest.getOperatorCode()));
            }else {
                log.info("Iniciando o metodo getUsagesBroadbands utilizando o customerContractId: {} e cityId: {}", usageBroadbandsRequest.getCustomerContractId(), usageBroadbandsRequest.getCityId());
            }

        } else {
            log.error("Necessario fornecer smartCardNumber ou customerContractId com operatorCode.");
        }

        // Verifica se a requisição é detalhada
        if (usageBroadbandsRequest.getDetailed() != null && usageBroadbandsRequest.getDetailed()) {
            return usagesBroadbandsRepository.findDetailedUsage(usageBroadbandsRequest);
        } else {
            return usagesBroadbandsRepository.findConsolidatedUsage(usageBroadbandsRequest);
        }
    }

    public void verifyRequiredParams(Map<String, String> params) throws BadRequestException {
        log.info("Validando parametros obrigatorios");

        boolean hasRequiredParams = params.containsKey(CUSTOMER_CONTRACT_ID) &&
                StringUtils.isNotBlank(params.get(CUSTOMER_CONTRACT_ID)) ||
                params.containsKey(SMART_CARD_NUMBER) &&
                        StringUtils.isNotBlank(params.get(SMART_CARD_NUMBER));

        if (!hasRequiredParams) {

            var exception = new BadRequestException(ErrorConstants.ERROR_REQUIRED_PARAMETERS);
            log.error("Campo obrigatorio ausente! Necessario informar pelo menos um: 'customerContractId: {}', 'smartCardNumber: {}'",
                    params.get(CUSTOMER_CONTRACT_ID), params.get(SMART_CARD_NUMBER), exception);
            throw exception;
        }

        if (!params.containsKey(END_DATE) || StringUtils.isBlank(params.get(END_DATE))) {
            log.info("Campo endDate ausente na requisicao, inserindo a data atual");
            params.putIfAbsent(END_DATE, LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }


        if (!params.containsKey(START_DATE) || StringUtils.isBlank(params.get(START_DATE))) {
            log.info("Campo startDate ausente na requisicao, inserindo a data de 30 dias atras");

            LocalDate referenceDate = null;
            if (params.containsKey(END_DATE)) {
                referenceDate = LocalDate.parse(params.get(END_DATE), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

            params.put(START_DATE, DateUtils.getLast30Days(referenceDate));
        }

        verifyCustomerContractIdAndOperatorCode(params);
        verifyAddressableCode(params);
        validateStartAndEndDates(params);
        verifyDetailed(params);

    }

    void verifyCustomerContractIdAndOperatorCode(Map<String, String> params) throws BadRequestException {
        boolean customerContractIdPresent = params.containsKey(CUSTOMER_CONTRACT_ID) && StringUtils.isNotBlank(params.get(CUSTOMER_CONTRACT_ID));
        boolean operatorCodeOrCityIdAbsent = (!params.containsKey("operatorCode") || StringUtils.isBlank(params.get("operatorCode"))) &&
                (!params.containsKey("cityId") || StringUtils.isBlank(params.get("cityId")));

        if (customerContractIdPresent && operatorCodeOrCityIdAbsent) {
            var exception = new BadRequestException(ErrorConstants.ERROR_MISSING_CITYID_OPERATORCODE);
            log.error("operatorCode ou cityId sao obrigatorios quando customerContractId esta presente", exception);
            throw exception;

        }

    }

    void verifyAddressableCode(Map<String, String> params) throws BadRequestException {
        if (!params.containsKey(ADDRESSABLE_CODE) || StringUtils.isBlank(params.get(ADDRESSABLE_CODE))) {
            var exception = new BadRequestException(ErrorConstants.ERROR_MANDATORY_PARAMETERS);
            log.error("Necessario fornecer 'addressableCode'.", exception);
            throw exception;
        }
    }

    void validateStartAndEndDates(Map<String, String> params) throws BadRequestException {
        verifyStartDate(params);
        verifyEndDate(params);

        var startDate = LocalDate.parse(params.get(START_DATE), DateTimeFormatter.ISO_DATE);
        var endDate = LocalDate.parse(params.get(END_DATE), DateTimeFormatter.ISO_DATE);

        if (endDate.isBefore(startDate)) {
            var exception = new BadRequestException(ErrorConstants.ERROR_END_DATE_EARLIER_START_DATE);
            log.error("Campo endDate anterior a startDate: startDate={}, endDate={}", startDate, endDate, exception);
            throw exception;
        }
    }

    void verifyStartDate(Map<String, String> params) throws BadRequestException {
        if (!DateUtils.isValidDate(params.get(START_DATE))) {
            var exception = new BadRequestException(ErrorConstants.ERROR_INVALID_FORMAT_DATE);
            log.error("startDate nao esta em um formato valido: {}", params.get(START_DATE), exception);
            throw exception;

        }
    }

    void verifyEndDate(Map<String, String> params) throws BadRequestException {
        if (!DateUtils.isValidDate(params.get(END_DATE))) {
            var exception = new BadRequestException(ErrorConstants.ERROR_INVALID_FORMAT_DATE);
            log.error("endDate nao esta em um formato valido: {}", params.get(END_DATE), exception);
            throw exception;
        }
    }

    void verifyDetailed(Map<String, String> params) throws BadRequestException {
        if (!params.containsKey(DETAILED) || StringUtils.isBlank(params.get(DETAILED))) {
            var exception = new BadRequestException(ErrorConstants.ERROR_MANDATORY_PARAMETERS);
            log.error("Necessario fornecer o parametro booleano 'detailed'.", exception);
            throw exception;
        }
    }

}
