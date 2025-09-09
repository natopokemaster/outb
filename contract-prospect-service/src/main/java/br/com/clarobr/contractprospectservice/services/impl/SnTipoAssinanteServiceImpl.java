package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnTipoAssinante;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoAssinanteDTO;
import br.com.clarobr.contractprospectservice.repository.SnTipoAssinanteRepository;
import br.com.clarobr.contractprospectservice.services.SnTipoAssinanteService;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * @author Alan Ricardo
 */

@Service
@Slf4j
public class SnTipoAssinanteServiceImpl implements SnTipoAssinanteService {

    @Autowired
    private SnTipoAssinanteRepository snTipoAssinanteRepository;

    @Override
    public SnTipoAssinanteDTO findSnAssinanteDTO(String cityId, Integer customerAccountNumber, String codeBase, String flStatusBi) throws UnprocessableEntityException {
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_CONTRATO_SERVICE_METHOD_FIND_TIPO_CONTRATO,
                cityId, customerAccountNumber);
        SnTipoAssinante snTipoAssinante;

        try{
            snTipoAssinante = snTipoAssinanteRepository.findAllByIdTipoAssinante(cityId, customerAccountNumber, codeBase, flStatusBi, ContractProspectServiceConstansts.DEFAULT_DATA_FIM);
        }
        catch(Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_CONTRATO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_CONTRATO_SERVICE_METHOD_FIND_TIPO_CONTRATO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_CONTRATO_SERVICE_METHOD_FIND_TIPO_CONTRATO,
                snTipoAssinante);
        return SnTipoAssinanteDTO.create(snTipoAssinante);
    }
}
