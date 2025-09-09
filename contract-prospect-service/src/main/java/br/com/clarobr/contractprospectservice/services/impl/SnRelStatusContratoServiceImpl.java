package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnRelStatusContrato;
import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoDTO;
import br.com.clarobr.contractprospectservice.repository.SnRelStatusContratoRepository;
import br.com.clarobr.contractprospectservice.services.SnRelStatusContratoService;
import br.com.clarobr.contractprospectservice.services.SnStatusContratoService;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */

@Service
@Slf4j
public class SnRelStatusContratoServiceImpl implements SnRelStatusContratoService {

    @Autowired
    private SnRelStatusContratoRepository snRelStatusContratoRepository;

    @Override
    public SnStatusContrato findSnRelStatusContrato(SnContratoDTO snContratoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_REL_STATUS_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_FIND_SN_REL_STATUS_CONTRATO_SERVICE_METHOD_FIND_SN_REL_STATUS_CONTRATO,
                snContratoDTO);
        List<SnStatusContrato> snStatusContrato;

        try{
            snStatusContrato = snRelStatusContratoRepository.findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                    snContratoDTO.getNumContrato(), snContratoDTO.getCidContrato(), snContratoDTO.getCodeBase(), ContractProspectServiceConstansts.FL_STATUS_BI
            );
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_REL_STATUS_CONTRATO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_FIND_SN_REL_STATUS_CONTRATO_SERVICE_METHOD_FIND_SN_REL_STATUS_CONTRATO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }
        var result = snStatusContrato.get(0);
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_REL_STATUS_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_FIND_SN_REL_STATUS_CONTRATO_SERVICE_METHOD_FIND_SN_REL_STATUS_CONTRATO,
                snStatusContrato);
        return Boolean.FALSE.equals(StringUtils.isNull(result)) ? result : new SnStatusContrato();

    }
}
