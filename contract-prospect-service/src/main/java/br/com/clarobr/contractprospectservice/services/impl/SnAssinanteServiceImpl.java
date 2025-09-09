package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnAssinante;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.repository.SnAssinanteRepository;
import br.com.clarobr.contractprospectservice.services.SnAssinanteService;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
@Slf4j
public class SnAssinanteServiceImpl implements SnAssinanteService {

    @Autowired
    private SnAssinanteRepository snAssinanteRepository;

    @Override
    public SnAssinanteDTO findAssinante(SnContratoDTO snContratoDTO) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE,
                snContratoDTO);
        SnAssinante snAssinante;

        try{
            snAssinante = snAssinanteRepository.findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBi(snContratoDTO.getIdAssinante(), snContratoDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI);
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }
        if(Boolean.TRUE.equals(StringUtils.isNull(snAssinante))){
            throw new NotFoundException(ContractProspectServiceConstansts.ERROR_RESOURCE_NOT_FOUND, ContractProspectServiceConstansts.CODE_NOT_FOUND);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE,
                snAssinante);

        return Boolean.TRUE.equals(!StringUtils.isNull( snAssinante)) ? SnAssinanteDTO.create(snAssinante) : new SnAssinanteDTO();

    }

    @Override
    public List<SnAssinanteDTO> findAssinanteByDocumentId(ContractProspectInput contractProspectInput) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_DOCUMENT_ID,
                contractProspectInput);
        List<SnAssinante> snAssinante;

        try{
            snAssinante = snAssinanteRepository.findAllByCpfAndFlStatusBi(contractProspectInput.getDocumentId(),
                    ContractProspectServiceConstansts.FL_STATUS_BI);
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_DOCUMENT_ID,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }
        if(snAssinante.isEmpty()){
            throw new NotFoundException(ContractProspectServiceConstansts.ERROR_RESOURCE_NOT_FOUND, ContractProspectServiceConstansts.CODE_NOT_FOUND);
        }
        List<SnAssinanteDTO> snAssinanteDTOList = new ArrayList<>();
        snAssinante.forEach(snAssinante1 -> {
            if(Boolean.FALSE.equals(StringUtils.isNull( snAssinante))){
                snAssinanteDTOList.add(SnAssinanteDTO.create(snAssinante1));
            }
        });
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_DOCUMENT_ID,
                snAssinanteDTOList);
        return snAssinanteDTOList;
    }

    @Override
    public List<SnAssinanteDTO> findAssinanteByAreaCodeAndPhoneNumber(ContractProspectInput contractProspectInput) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_PHONE_NUMBER_AND_AREA_CODE,
                contractProspectInput);
        List<SnAssinante> snAssinante = new ArrayList<>();

        try{
            snAssinante.addAll(snAssinanteRepository.findAllByTelComAndFlStatusBi(
                     Integer.valueOf(contractProspectInput.getAreaCode())  + contractProspectInput.getPhoneNumber(),
                    ContractProspectServiceConstansts.FL_STATUS_BI));
            snAssinante.addAll(snAssinanteRepository.findAllByTelResAndFlStatusBi(
                    Integer.valueOf(contractProspectInput.getAreaCode())  + contractProspectInput.getPhoneNumber(),
                    ContractProspectServiceConstansts.FL_STATUS_BI));
            snAssinante.addAll(snAssinanteRepository.findAllByCcTelCelAndFlStatusBi(
                    Integer.valueOf(contractProspectInput.getAreaCode())  + contractProspectInput.getPhoneNumber(),
                    ContractProspectServiceConstansts.FL_STATUS_BI));

        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_PHONE_NUMBER_AND_AREA_CODE,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }
        if(snAssinante.isEmpty()){
            throw new NotFoundException(ContractProspectServiceConstansts.ERROR_RESOURCE_NOT_FOUND, ContractProspectServiceConstansts.CODE_NOT_FOUND);
        }
        List<SnAssinanteDTO> snAssinanteDTOList = new ArrayList<>();
        snAssinante.forEach(snAssinante1 -> {
            if(Boolean.FALSE.equals(StringUtils.isNull( snAssinante1))){
                snAssinanteDTOList.add(SnAssinanteDTO.create(snAssinante1));
            }
        });
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_PHONE_NUMBER_AND_AREA_CODE,
                snAssinanteDTOList);
        return snAssinanteDTOList;
    }
}
