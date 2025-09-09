package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoServicoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnStatusContratoDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.Partner;
import br.com.clarobr.contractprospectservice.models.objects.Status;
import br.com.clarobr.contractprospectservice.repository.SnRelStatusContratoServicoRepository;
import br.com.clarobr.contractprospectservice.repository.SnStatusContratoRepository;
import br.com.clarobr.contractprospectservice.services.SnStatusContratoService;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Ricardo
 */
@Service
@Slf4j
public class SnStatusContratoServiceImpl implements SnStatusContratoService {

    @Autowired
    private SnStatusContratoRepository snStatusContratoRepository;

    @Autowired
    private SnRelStatusContratoServicoRepository snRelStatusContratoServicoRepository;

    @Override
    public SnStatusContratoDTO findStatusContrato(SnRelStatusContratoDTO snRelStatusContratoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_STATUS_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO,
                snRelStatusContratoDTO);
        SnStatusContrato snStatusContrato;

        try{
            snStatusContrato = snStatusContratoRepository.findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi(
                    snRelStatusContratoDTO.getIdStatus(), snRelStatusContratoDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI
            );
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO,
                snRelStatusContratoDTO);
        return Boolean.FALSE.equals(StringUtils.isNull(snStatusContrato)) ? SnStatusContratoDTO.create(snStatusContrato) : new SnStatusContratoDTO();

    }

    @Override
    public void setContractStatus(SnStatusContrato snStatusContrato, Contract contract) {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_STATUS_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO_AND_SET_CONTRACT,
                snStatusContrato);

        contract.setStatus(new Status(snStatusContrato.getIdStatusContrato(), snStatusContrato.getDescricao()));

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_STATUS_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO_AND_SET_CONTRACT,
                snStatusContrato);
    }

    @Override
    public SnStatusContrato findStatusContratoServico(SnContratoDTO snContratoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_STATUS_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO,
                snContratoDTO);
        List<SnStatusContrato> result;

        try{
            result = snRelStatusContratoServicoRepository.findSnRelStatusContratoServicoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                    snContratoDTO.getNumContrato(), snContratoDTO.getCidContrato(), snContratoDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI,
                    ContractProspectServiceConstansts.DEFAULT_DATA_FIM
            );
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO,
                result);
        return result != null && !result.isEmpty() ? result.get(0) : new SnStatusContrato();

    }

    @Override
    public void setContractStatusServico(SnStatusContrato snStatusContrato, Contract contract) {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_STATUS_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO_AND_SET_CONTRACT,
                snStatusContrato);

        contract.setPartner(new Partner(contract.getEmbratelContractNumber() != null ? BigInteger.valueOf(Long.valueOf(contract.getEmbratelContractNumber())) : null,new Status(snStatusContrato.getIdStatusContrato(),snStatusContrato.getDescricao())));

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_STATUS_CONTRATO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO_AND_SET_CONTRACT,
                snStatusContrato);
    }

}
