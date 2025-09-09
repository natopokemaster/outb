package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnRazaoCancelamento;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRazaoCancelamentoDTO;
import br.com.clarobr.contractprospectservice.models.objects.CancellationReason;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.Type;
import br.com.clarobr.contractprospectservice.repository.SnRazaoCancelamentoRepository;
import br.com.clarobr.contractprospectservice.services.SnRazaoCancelamentoService;
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
public class SnRazaoCancelamentoServiceImpl implements SnRazaoCancelamentoService {

    @Autowired
    private SnRazaoCancelamentoRepository snRazaoCancelamentoRepository;


    @Override
    public SnRazaoCancelamentoDTO findRazaoCancelamento(SnContratoDTO snContratoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_RAZAO_CANCELAMENTO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_RAZAO_CANCELAMENTO_SERVICE_METHOD_FIND_RAZAO_CANCELAMENTO,
                snContratoDTO);
        SnRazaoCancelamento snRazaoCancelamento;

        try{
            snRazaoCancelamento =
                    snRazaoCancelamentoRepository.findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBi(
                            snContratoDTO.getIdRazaoCancelamento(),
                            snContratoDTO.getCodeBase(),
                            ContractProspectServiceConstansts.FL_STATUS_BI);
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_RAZAO_CANCELAMENTO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_RAZAO_CANCELAMENTO_SERVICE_METHOD_FIND_RAZAO_CANCELAMENTO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_RAZAO_CANCELAMENTO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_RAZAO_CANCELAMENTO_SERVICE_METHOD_FIND_RAZAO_CANCELAMENTO,
                snRazaoCancelamento);
        return Boolean.FALSE.equals(StringUtils.isNull(snRazaoCancelamento)) ? SnRazaoCancelamentoDTO.create(snRazaoCancelamento): new SnRazaoCancelamentoDTO();
    }

    @Override
    public SnRazaoCancelamentoDTO findRazaoCancelamentoAndSetContract(SnContratoDTO snContratoDTO, Contract contract) throws UnprocessableEntityException {
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_RAZAO_CANCELAMENTO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_RAZAO_CANCELAMENTO_SERVICE_METHOD_FIND_RAZAO_CANCELAMENTO,
                snContratoDTO, contract);
        var snRazaoCancelamentoDTO = findRazaoCancelamento(snContratoDTO);
        contract.getSale().setCancellationReason(new CancellationReason(new Type(snRazaoCancelamentoDTO.getIdRazaoCancelamento(), snRazaoCancelamentoDTO.getDescricao())));

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_RAZAO_CANCELAMENTO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_RAZAO_CANCELAMENTO_SERVICE_METHOD_FIND_RAZAO_CANCELAMENTO,
                snRazaoCancelamentoDTO, contract);
        return snRazaoCancelamentoDTO;
    }
}
