package br.com.clarobr.contractprospectservice.resources;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.BadRequestException;
import br.com.clarobr.contractprospectservice.exception.CircuitBreakerException;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.common.CustomHttpEntity;
import br.com.clarobr.contractprospectservice.models.output.ContractProspectOutput;
import br.com.clarobr.contractprospectservice.resources.openapi.ContractProspectResourceApi;
import br.com.clarobr.contractprospectservice.services.ContractProspectService;
import br.com.clarobr.contractprospectservice.util.ValidateUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/contracts/prospects")
@Validated
public class ContractProspectResource implements ContractProspectResourceApi {

    @Autowired
    private ContractProspectService contractProspectService;

    @Override
    @GetMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
               produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<CustomHttpEntity<ContractProspectOutput>> getContractProspects(@RequestHeader HttpHeaders httpHeaders) throws Exception {

        log.info(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_START_MESSAGE,
                 ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CONTRACT_PROSPECT_RESOURCE,
                 httpHeaders.toString());

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CONTRACT_PROSPECT_RESOURCE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_RESOURCE_METHOD_GET_CONTRACT_PROSPECTS,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VALIDATE_UTILS_METHOD_VALIDE_CONTRACT_PROSPECT_INPUT,
                httpHeaders);

        var request = ValidateUtils.valideContractProspectInput(httpHeaders);
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CONTRACT_PROSPECT_RESOURCE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_RESOURCE_METHOD_GET_CONTRACT_PROSPECTS,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CREATE_GET_CONTRACT_PROSPECTS,
                request);

        var prospect = contractProspectService.getContractProspect(request);

        log.info(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_END_MESSAGE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CONTRACT_PROSPECT_RESOURCE,
                prospect);
        var response = new CustomHttpEntity<ContractProspectOutput>(prospect);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
