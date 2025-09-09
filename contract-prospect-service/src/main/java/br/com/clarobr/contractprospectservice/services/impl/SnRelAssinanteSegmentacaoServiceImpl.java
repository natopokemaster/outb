package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnRelAssinanteSegmentacao;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelAssinanteSegmentacaoDTO;
import br.com.clarobr.contractprospectservice.repository.SnRelAssinanteSegmentacaoRepository;
import br.com.clarobr.contractprospectservice.services.SnRelAssinanteSegmentacaoService;
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
public class SnRelAssinanteSegmentacaoServiceImpl implements SnRelAssinanteSegmentacaoService {

    @Autowired
    private SnRelAssinanteSegmentacaoRepository snRelAssinanteSegmentacaoRepository;


    @Override
    public SnRelAssinanteSegmentacaoDTO findRelAssinanteSegmentacao(SnContratoDTO snContratoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE_METHOD_FIND_REL_ASSINANTE_SEGMENTACAO,
                snContratoDTO);
        SnRelAssinanteSegmentacao snRelAssinanteSegmentacao;

        try {
            snRelAssinanteSegmentacao = snRelAssinanteSegmentacaoRepository.findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                    snContratoDTO.getNumContrato(), snContratoDTO.getCidContrato(), snContratoDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI
            );
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE_METHOD_FIND_REL_ASSINANTE_SEGMENTACAO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE_METHOD_FIND_REL_ASSINANTE_SEGMENTACAO,
                snRelAssinanteSegmentacao);
        return Boolean.FALSE.equals(StringUtils.isNull(snRelAssinanteSegmentacao)) ? SnRelAssinanteSegmentacaoDTO.create(snRelAssinanteSegmentacao) : new SnRelAssinanteSegmentacaoDTO();
    }
}
