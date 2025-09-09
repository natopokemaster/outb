package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnTipoSegmento;
import br.com.clarobr.contractprospectservice.models.dto.SnRelAssinanteSegmentacaoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoSegmentoDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.Segment;
import br.com.clarobr.contractprospectservice.repository.SnTipoSegmentoRepository;
import br.com.clarobr.contractprospectservice.services.SnTipoSegmentoService;
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
public class SnTipoSegmentoServiceImpl implements SnTipoSegmentoService {

    @Autowired
    private SnTipoSegmentoRepository snTipoSegmentoRepository;

    @Override
    public SnTipoSegmentoDTO findTipoSegmento(SnRelAssinanteSegmentacaoDTO snRelAssinanteSegmentacaoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_SEGMENTO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_SEGMENTO_SERVICE_METHOD_FIND_TIPO_SEGMENTO,
                snRelAssinanteSegmentacaoDTO);
        SnTipoSegmento snTipoSegmento;

        try {
            snTipoSegmento = snTipoSegmentoRepository.findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBi(
                    snRelAssinanteSegmentacaoDTO.getIdTipoSegmento(), snRelAssinanteSegmentacaoDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI
            );
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_SEGMENTO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_SEGMENTO_SERVICE_METHOD_FIND_TIPO_SEGMENTO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_SEGMENTO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_SEGMENTO_SERVICE_METHOD_FIND_TIPO_SEGMENTO,
                snTipoSegmento);
        return Boolean.FALSE.equals(StringUtils.isNull(snTipoSegmento)) ? SnTipoSegmentoDTO.create(snTipoSegmento) : new SnTipoSegmentoDTO();

    }

    @Override
    public SnTipoSegmentoDTO findTipoSegmentoAndSetContract(SnRelAssinanteSegmentacaoDTO snRelAssinanteSegmentacaoDTO, Contract contract) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_SEGMENTO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_SEGMENTO_SERVICE_METHOD_FIND_TIPO_SEGMENTO_AND_SET_CONTRACT,
                snRelAssinanteSegmentacaoDTO,contract);

        var snTipoSegmentoDTO = findTipoSegmento(snRelAssinanteSegmentacaoDTO);
        contract.setSegment(new Segment(snTipoSegmentoDTO.getIdTipoSegmento(), snTipoSegmentoDTO.getDescricao()));

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_SEGMENTO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_SEGMENTO_SERVICE_METHOD_FIND_TIPO_SEGMENTO_AND_SET_CONTRACT,
                snTipoSegmentoDTO,contract);
        return snTipoSegmentoDTO;

    }
}
