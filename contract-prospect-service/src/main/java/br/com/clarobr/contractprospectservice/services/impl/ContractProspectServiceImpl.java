package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.objects.CustomerProspect;
import br.com.clarobr.contractprospectservice.models.output.ContractProspectOutput;
import br.com.clarobr.contractprospectservice.services.ContractProspectService;
import br.com.clarobr.contractprospectservice.services.CustomerProspectService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContractProspectServiceImpl implements ContractProspectService {

    @Autowired
    private CustomerProspectService customerProspectService;

    @Override
    public ContractProspectOutput getContractProspect(ContractProspectInput request) throws Exception {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CONTRACT_PROSPECT_SERVICE,
                 ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CREATE_GET_CONTRACT_PROSPECTS,
                request);
        var response = new ContractProspectOutput();
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CREATE_GET_CONTRACT_PROSPECTS,
                request);
        List<CustomerProspect> customerProspectList =  customerProspectService.getCustomerProspectData(request);

        response.setCustomerProspects(customerProspectList);
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CONTRACT_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CREATE_GET_CONTRACT_PROSPECTS,
                response);
        return response;
    }


}
