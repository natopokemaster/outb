package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnPreposto;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnPrepostoDTO;
import br.com.clarobr.contractprospectservice.repository.SnPrepostoRepository;
import br.com.clarobr.contractprospectservice.services.SnPrepostoService;
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
public class SnPrepostoServiceImpl implements SnPrepostoService {

    @Autowired
    private SnPrepostoRepository snPrepostoRepository;

    @Override
    public SnPrepostoDTO findSnPrepostaByNumContratoAndCidContrato(SnContratoDTO snContratoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_PREPOSTO_SERVICE_METHOD_FIND_SN_PREPOSTA_BY_NUM_CONTRATO_AND_CID_CONTRATO,
                snContratoDTO);
        SnPreposto snPreposto;

        try {
            snPreposto = snPrepostoRepository.getFirstByNumContratoAndCidContratoAndCdBaseAndFlStatusBi(
                    snContratoDTO.getNumContrato(), snContratoDTO.getCidContrato(),
                    snContratoDTO.getCodeBase(), ContractProspectServiceConstansts.FL_STATUS_BI);
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_PREPOSTO_SERVICE_METHOD_FIND_SN_PREPOSTA_BY_NUM_CONTRATO_AND_CID_CONTRATO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_PREPOSTO_SERVICE_METHOD_FIND_SN_PREPOSTA_BY_NUM_CONTRATO_AND_CID_CONTRATO,
                snPreposto);
        return Boolean.FALSE.equals(StringUtils.isNull(snPreposto)) ? SnPrepostoDTO.create(snPreposto) : new SnPrepostoDTO();
    }
}
