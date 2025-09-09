package br.com.clarobr.contractprospectservice.connectors;

/**
 * @author Alan Ricardo
 */


import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.BadRequestException;
import br.com.clarobr.contractprospectservice.exception.InternalServerErrorException;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.address.ContractIdentification;
import br.com.clarobr.contractprospectservice.models.common.ErrorResponse;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alan Ricardo
 */
@Slf4j
@Component(value = "utilsConnector")
public class ContractUtilsConnector extends Connector {
    private final String host;
    private final String path;
    private final String readTimeOut;
    private final String connectionTimeOut;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public ContractUtilsConnector(
            @Value("${app.utils.service.host}") String host,
            @Value("${app.utils.service.path}") String path,
            @Value("${app.utils.service.readtimeout}") String readTimeOut,
            @Value("${app.utils.service.connectiontimeout}") String connectionTimeOut) {

        this.host = host;
        this.path = path;
        this.readTimeOut = readTimeOut;
        this.connectionTimeOut = connectionTimeOut;
    }

    public ContractIdentification getContractIdentification(ContractProspectInput request)
            throws NotFoundException, JsonProcessingException, BadRequestException,
            UnprocessableEntityException {

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        if (request.getSmartCardNumber() != null) {
            headers.set(ContractProspectServiceConstansts.HEADER_KEY_SMARTCARD, request.getSmartCardNumber());
        }
        if (request.getCustomerAccountId() != null) {
            headers.set(
                    ContractProspectServiceConstansts.HEADER_KEY_CUSTOMER_ACCOUNT_ID,
                    String.valueOf(request.getCustomerAccountId()));
        }
        if (request.getCityId() != null) {
            headers.set(ContractProspectServiceConstansts.HEADER_KEY_CITY_ID, request.getCityId());
        }
        if (request.getOperatorCode() != null) {
            headers.set(
                    ContractProspectServiceConstansts.HEADER_KEY_OPERATOR_CODE,
                    request.getOperatorCode());
        }
        if (request.getProtocolNumber() != null) {
            headers.set(ContractProspectServiceConstansts.HEADER_KEY_PROTOCOL_NUMBER, request.getProtocolNumber());
        }
        if (request.getAddressableCode() != null) {
            headers.set(ContractProspectServiceConstansts.HEADER_KEY_ADDRESSABLE_CODE, request.getAddressableCode());
        }

        HttpEntity<Object> entity = new HttpEntity<>(headers);

        String url = host + path;

        log.debug(url);

        var restTemplate = new RestTemplate();

        restTemplate.setRequestFactory(new SimpleClientHttpRequestFactory());
        SimpleClientHttpRequestFactory rf =
                (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
        rf.setReadTimeout(Integer.valueOf(readTimeOut));
        rf.setConnectTimeout(Integer.valueOf(connectionTimeOut));

        ResponseEntity<ContractIdentification> response;

        final String error =
                ContractProspectServiceConstansts.ERROR_STARTS_DEFAULT
                        + host
                        + path
                        + ContractProspectServiceConstansts.ERROR_MIDDLE_DEFAULT;

        try {
            response = restTemplate.exchange(url, HttpMethod.GET, entity, ContractIdentification.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound ex) {
            throw new NotFoundException(ContractProspectServiceConstansts.ERROR_CONTRACT_UTILS_NOT_FOUND, ContractProspectServiceConstansts.CODE_NOT_FOUND);
        } catch (HttpClientErrorException.BadRequest ex) {
            throw new BadRequestException(error +
                    objectMapper.readValue(ex.getResponseBodyAsString(), ErrorResponse.class).getError().getDetailedMessage(), ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        } catch (HttpClientErrorException.UnprocessableEntity ex) {
            throw new UnprocessableEntityException(
                    error + objectMapper.readValue(ex.getResponseBodyAsString(), ErrorResponse.class).getError().getDetailedMessage(), ContractProspectServiceConstansts.CODE_UTILS_UNPROCESSABLE);
        } catch (Exception ex) {
            throw new InternalServerErrorException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + path + host + ContractProspectServiceConstansts.ERROR_MIDDLE_DEFAULT + ex.getMessage());
        }
    }
}
