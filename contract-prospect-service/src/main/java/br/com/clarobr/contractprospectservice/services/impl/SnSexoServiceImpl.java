package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnSexo;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnSexoDTO;
import br.com.clarobr.contractprospectservice.repository.SnSexoRepository;
import br.com.clarobr.contractprospectservice.services.SnSexoService;
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
public class SnSexoServiceImpl implements SnSexoService {

    @Autowired
    private SnSexoRepository snSexoRepository;

    @Override
    public SnSexoDTO findSexo(SnAssinanteDTO snAssinanteDTO) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_SEXO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_SEXO_SERVICE_METHOD_FIND_SEXO,
                snAssinanteDTO);
        SnSexo snSexo;

        try{
            snSexo = snSexoRepository.findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBi(snAssinanteDTO.getIdSexo(),
                    snAssinanteDTO.getCodeBase(), ContractProspectServiceConstansts
                            .FL_STATUS_BI);
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_SEXO_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_SEXO_SERVICE_METHOD_FIND_SEXO,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_SEXO_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_SEXO_SERVICE_METHOD_FIND_SEXO,
                snSexo);
        return Boolean.FALSE.equals(StringUtils.isNull(snSexo)) ? SnSexoDTO.create(snSexo) : new SnSexoDTO();

    }
}
