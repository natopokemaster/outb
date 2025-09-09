package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnTipoContrato;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoContratoDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.Type;
import br.com.clarobr.contractprospectservice.repository.SnTipoContratoRepository;
import br.com.clarobr.contractprospectservice.services.SnTipoContratoService;
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
public class SnTipoContratoServiceImpl implements SnTipoContratoService {

    @Autowired
    private SnTipoContratoRepository snTipoContratoRepository;

    @Override
    public SnTipoContratoDTO findTipoContrato(SnContratoDTO snContratoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_CONTRATO_SERVICE_METHOD_FIND_TIPO_CONTRATO,
                snContratoDTO);
        SnTipoContrato snTipoContrato;

        try{
            snTipoContrato = snTipoContratoRepository.findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBi(snContratoDTO.getIdTipoContrato(),
                    snContratoDTO.getCodeBase(), ContractProspectServiceConstansts.FL_STATUS_BI);
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
                snTipoContrato);
        return Boolean.FALSE.equals(StringUtils.isNull(snTipoContrato)) ? SnTipoContratoDTO.create(snTipoContrato): new SnTipoContratoDTO();
    }

    @Override
    public SnTipoContratoDTO findTipoContratoAndSetContract(SnContratoDTO snContratoDTO, Contract contract) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_CONTRATO_SERVICE_METHOD_FIND_TIPO_CONTRATO_AND_SET_CONTRACT,
                snContratoDTO, contract);
        var snTipoContratoDTO = findTipoContrato(snContratoDTO);
        contract.setType(new Type(snTipoContratoDTO.getIdTipoContrato(), snTipoContratoDTO.getDescricao()));

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_CONTRATO_SERVICE_METHOD_FIND_TIPO_CONTRATO_AND_SET_CONTRACT,
                snTipoContratoDTO, contract);
        return snTipoContratoDTO;
    }
}
