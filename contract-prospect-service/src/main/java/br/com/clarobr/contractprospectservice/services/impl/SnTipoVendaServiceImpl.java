package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnTipoVenda;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoVendaDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.Type;
import br.com.clarobr.contractprospectservice.repository.SnTipoVendaRepository;
import br.com.clarobr.contractprospectservice.services.SnTipoVendaService;
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
public class SnTipoVendaServiceImpl implements SnTipoVendaService {

    @Autowired
    private SnTipoVendaRepository snTipoVendaRepository;

    @Override
    public SnTipoVendaDTO findTipoVenda(SnContratoDTO snContratoDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_VENDA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_VENDA_SERVICE_METHOD_FIND_TIPO_VENDA,
                snContratoDTO);
        SnTipoVenda snTipoVenda;
        try{
            snTipoVenda = snTipoVendaRepository.findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBi(snContratoDTO.getIdTipoVenda(), snContratoDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI);
        }
        catch(Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_VENDA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_VENDA_SERVICE_METHOD_FIND_TIPO_VENDA,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_VENDA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_VENDA_SERVICE_METHOD_FIND_TIPO_VENDA,
                snTipoVenda);
        return Boolean.FALSE.equals(StringUtils.isNull(snTipoVenda)) ? SnTipoVendaDTO.create(snTipoVenda) : new SnTipoVendaDTO();
    }

    @Override
    public SnTipoVendaDTO findTipoVendaAndSetContract(SnContratoDTO snContratoDTO, Contract contract) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_VENDA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_VENDA_SERVICE_METHOD_FIND_TIPO_VENDA_AND_SET_CONTRACT,
                snContratoDTO, contract);
        var snTipoVendaDTO =findTipoVenda(snContratoDTO);
        contract.getSale().setType(new Type(snTipoVendaDTO.getIdTipoVenda(), snTipoVendaDTO.getDescricao()));

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TIPO_VENDA_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_VENDA_SERVICE_METHOD_FIND_TIPO_VENDA_AND_SET_CONTRACT,
                snTipoVendaDTO, contract);
        return snTipoVendaDTO;
    }
}
