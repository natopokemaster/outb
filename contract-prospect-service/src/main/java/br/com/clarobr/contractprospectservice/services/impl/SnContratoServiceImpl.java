package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnContrato;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.repository.SnContratoRepository;
import br.com.clarobr.contractprospectservice.services.SnContratoService;
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
public class SnContratoServiceImpl implements SnContratoService {

    @Autowired
    private SnContratoRepository snContratoRepository;

    @Override
    public SnContratoDTO findContratoByCustomerAccountIdAndCityId(ContractProspectInput contractProspectInput) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CONTRATO_SERVICE_METHOD_FIND_CONTRATO_BY_CUSTOMER_ACCOUNT_ID_AND_CITY_ID,
                contractProspectInput);
        SnContrato snContrato;

        try{
            snContrato = snContratoRepository.findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(Integer.valueOf(contractProspectInput.getCustomerAccountId()),
                    contractProspectInput.getCityId(), contractProspectInput.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI);
            if(snContrato != null && snContrato.getObs() != null && !snContrato.getObs().isEmpty()){
                snContrato.setObs(snContrato.getObs().replaceAll("[^A-Za-z0-9\\s]( ){3,}",""));
            }
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CONTRATO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CONTRATO_SERVICE_METHOD_FIND_CONTRATO_BY_CUSTOMER_ACCOUNT_ID_AND_CITY_ID,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        if(Boolean.TRUE.equals(StringUtils.isNull(snContrato))){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.ERROR_RESOURCE_NOT_FOUND);
            throw new NotFoundException(ContractProspectServiceConstansts.ERROR_RESOURCE_NOT_FOUND, ContractProspectServiceConstansts.CODE_NOT_FOUND);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CONTRATO_SERVICE_METHOD_FIND_CONTRATO_BY_CUSTOMER_ACCOUNT_ID_AND_CITY_ID,
                snContrato);
        return Boolean.FALSE.equals(StringUtils.isNull(snContrato)) ? SnContratoDTO.create(snContrato) : new SnContratoDTO();

    }

    @Override
    public SnContratoDTO findContratoByIdAssinate(SnAssinanteDTO snAssinanteDTO) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CONTRATO_SERVICE_METHOD_FIND_CONTRATO_BY_ID_ASSINATE,
                snAssinanteDTO);
        SnContrato snContrato;

        try{
            snContrato = snContratoRepository.findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBi(
                    snAssinanteDTO.getIdAssinante(),
                    snAssinanteDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI);
            if(snContrato != null && snContrato.getObs() != null && !snContrato.getObs().isEmpty()){
                snContrato.setObs(snContrato.getObs().replaceAll("[^A-Za-z0-9\\s]( ){3,}",""));
            }
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CONTRATO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CONTRATO_SERVICE_METHOD_FIND_CONTRATO_BY_ID_ASSINATE,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        if(Boolean.TRUE.equals(StringUtils.isNull(snContrato))){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.ERROR_RESOURCE_NOT_FOUND);
            throw new NotFoundException(ContractProspectServiceConstansts.ERROR_RESOURCE_NOT_FOUND, ContractProspectServiceConstansts.CODE_NOT_FOUND);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CONTRATO_SERVICE_METHOD_FIND_CONTRATO_BY_ID_ASSINATE,
                snContrato);
        return Boolean.FALSE.equals(StringUtils.isNull(snContrato)) ? SnContratoDTO.create(snContrato) : new SnContratoDTO();
    }
}
