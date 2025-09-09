package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnProfissao;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnProfissaoDTO;
import br.com.clarobr.contractprospectservice.repository.SnProfissaoRepository;
import br.com.clarobr.contractprospectservice.services.SnProfissaoService;
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
public class SnProfissaoServiceImpl implements SnProfissaoService {

    @Autowired
    private SnProfissaoRepository snProfissaoRepository;

    @Override
    public SnProfissaoDTO findProfissao(SnAssinanteDTO snAssinanteDTO) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_PROFISSAO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_PROFISSAO_SERVICE_METHOD_FIND_PROFISSAO,
                snAssinanteDTO);
        SnProfissao snProfissao;

        try{
            snProfissao = snProfissaoRepository.findByIdProfissaoAndCodeBaseAndFlStatusBi(snAssinanteDTO.getIdProfissao(), snAssinanteDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI);
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_PROFISSAO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_PROFISSAO_SERVICE_METHOD_FIND_PROFISSAO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_PROFISSAO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_PROFISSAO_SERVICE_METHOD_FIND_PROFISSAO,
                snProfissao);
        return Boolean.TRUE.equals(!StringUtils.isNull(snProfissao)) ? SnProfissaoDTO.create(snProfissao) : new SnProfissaoDTO();

    }
}
