package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnCidadeOperadora;
import br.com.clarobr.contractprospectservice.models.dto.SnCidadeOperadoraDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.repository.SnCidadeOperadoraRepository;
import br.com.clarobr.contractprospectservice.services.SnCidadeOperadoraService;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
@Slf4j
public class SnCidadeOperadoraServiceImpl implements SnCidadeOperadoraService {

    @Autowired
    private SnCidadeOperadoraRepository snCidadeOperadoraRepository;

    @Override
    public SnCidadeOperadoraDTO findCidadeOperadoraAndSetContract(ContractProspectInput contractProspectInput, Contract contract) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CIDADE_OPERADORA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CIDADE_OPERADORA_SERVICE_METHOD_FIND_CIDADE_OPERADORA_AND_SET_CONTRACT,
                contractProspectInput);
        var snCidadeOperadoraDTO = findCidadeOperadora(contractProspectInput);

        contract.getOrganization().setOrganizationName(snCidadeOperadoraDTO.getRazaoSocial());
        contract.getOrganization().setTradingName(snCidadeOperadoraDTO.getNomePessoa());
        contract.getOrganization().setOperatorCode(snCidadeOperadoraDTO.getCodOperadora());
        contract.getOrganization().setCityId(snCidadeOperadoraDTO.getCidContrato());
        contract.getOrganization().setOperatorCityName(snCidadeOperadoraDTO.getCiNome());

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CIDADE_OPERADORA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CIDADE_OPERADORA_SERVICE_METHOD_FIND_CIDADE_OPERADORA_AND_SET_CONTRACT,
                snCidadeOperadoraDTO);
        return snCidadeOperadoraDTO;

    }

    @Override
    public SnCidadeOperadoraDTO findCidadeOperadora(ContractProspectInput contractProspectInput) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CIDADE_OPERADORA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CIDADE_OPERADORA_SERVICE_METHOD_FIND_CIDADE_OPERADORA,
                contractProspectInput);
        SnCidadeOperadora snCidadeOperadora;

        try{
            snCidadeOperadora = snCidadeOperadoraRepository.findSnCidadeOperadoraByCidContratoAndCodeBaseAndFlStatusBi(contractProspectInput.getCityId(),
                    contractProspectInput.getCodeBase(), ContractProspectServiceConstansts.FL_STATUS_BI);
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CIDADE_OPERADORA_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CIDADE_OPERADORA_SERVICE_METHOD_FIND_CIDADE_OPERADORA,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CIDADE_OPERADORA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CIDADE_OPERADORA_SERVICE_METHOD_FIND_CIDADE_OPERADORA,
                contractProspectInput);
        return Boolean.FALSE.equals(StringUtils.isNull(snCidadeOperadora))  ? SnCidadeOperadoraDTO.create(snCidadeOperadora): new SnCidadeOperadoraDTO();

    }
}
