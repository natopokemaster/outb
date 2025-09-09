package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnEstadoCivil;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnEstadoCivilDTO;
import br.com.clarobr.contractprospectservice.repository.SnEstadoCivilRepository;
import br.com.clarobr.contractprospectservice.services.SnEstadoCivilService;
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
public class SnEstadoCivilServiceImpl implements SnEstadoCivilService {

    @Autowired
    private SnEstadoCivilRepository snEstadoCivilRepository;

    @Override
    public SnEstadoCivilDTO findEstadoCivil(SnAssinanteDTO snAssinanteDTO) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ESTADO_CIVIL_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ESTADO_CIVIL_SERVICE_METHOD_FIND_ASSINANTE,
                snAssinanteDTO);
        SnEstadoCivil snEstadoCivil;

        try{
            snEstadoCivil = snEstadoCivilRepository.findByIdEstadoCivilAndCodeBaseAndFlStatusBi(snAssinanteDTO.getIdEstadoCivil(), snAssinanteDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI);
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ESTADO_CIVIL_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ESTADO_CIVIL_SERVICE_METHOD_FIND_ASSINANTE,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ESTADO_CIVIL_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ESTADO_CIVIL_SERVICE_METHOD_FIND_ASSINANTE,
                snEstadoCivil);
        return Boolean.FALSE.equals(StringUtils.isNull(snEstadoCivil)) ? SnEstadoCivilDTO.create(snEstadoCivil) : new SnEstadoCivilDTO();

    }
}
