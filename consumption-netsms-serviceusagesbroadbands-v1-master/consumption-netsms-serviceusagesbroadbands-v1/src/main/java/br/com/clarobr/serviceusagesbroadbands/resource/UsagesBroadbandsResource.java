package br.com.clarobr.serviceusagesbroadbands.resource;

import br.com.clarobr.common.connection.NoRequireAliasBase;
import br.com.clarobr.common.exception.NotFoundException;
import br.com.clarobr.serviceusagesbroadbands.exception.UnprocessableEntityException;
import br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException;
import br.com.clarobr.serviceusagesbroadbands.helper.UsagesBroadbandsHelper;
import br.com.clarobr.serviceusagesbroadbands.models.UsageBroadbandsRequest;
import br.com.clarobr.serviceusagesbroadbands.models.UsagesBroadbandsResponse;
import br.com.clarobr.serviceusagesbroadbands.service.UsagesBroadbandsService;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@Validated
@RequestMapping("consumption/v1")
public class UsagesBroadbandsResource {

    @Autowired
    private final UsagesBroadbandsService usagesBroadbandsService;

    @Autowired
    private UsagesBroadbandsHelper usagesBroadbandsHelper;

    public UsagesBroadbandsResource(UsagesBroadbandsService usagesBroadbandsService, UsagesBroadbandsHelper usagesBroadbandsHelper) {
        this.usagesBroadbandsService = usagesBroadbandsService;
        this.usagesBroadbandsHelper = usagesBroadbandsHelper;
    }

    @NoRequireAliasBase
    @GetMapping(value = "/netsms/serviceusages/broadbands")
    public ResponseEntity<UsagesBroadbandsResponse> findUsagesBroadbands(
            @RequestHeader(value = "X-QueryString")
            @NotBlank(message = "The parameter 'X-QueryString' is required.") String xQueryString)
            throws NotFoundException, UnprocessableEntityException, BadRequestException {

        Map<String, String> params = usagesBroadbandsHelper.getParamsFromQueryString(xQueryString);

        usagesBroadbandsService.verifyRequiredParams(params);
        var usageBroadbandsRequest = UsageBroadbandsRequest.builder()
                .customerContractId((params.get("customerContractId")))
                .addressableCode(params.get("addressableCode"))
                .startDate(params.get("startDate"))
                .endDate(params.get("endDate"))
                .detailed(Boolean.parseBoolean(params.get("detailed")))
                .operatorCode(params.get("operatorCode"))
                .cityId(params.get("cityId"))
                .smartCardNumber(params.get("smartCardNumber")).build();

        UsagesBroadbandsResponse usageData = usagesBroadbandsService.getUsagesBroadbands(usageBroadbandsRequest);

        return ResponseEntity.ok(usageData);
    }

}