package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnTelefoneVoip;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTelefoneVoipDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.objects.Telephones;
import br.com.clarobr.contractprospectservice.repository.SnTelefoneVoipRepository;
import br.com.clarobr.contractprospectservice.services.SnTelefoneVoipService;
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
public class SnTelefoneVoipServiceImpl implements SnTelefoneVoipService {

    @Autowired
    private SnTelefoneVoipRepository snTelefoneVoipRepository;

    @Override
    public List<Telephones> findTelephones(SnAssinanteDTO snAssinanteDTO, ContractProspectInput contractProspectInput) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TELEFONE_VOIP_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TELEFONE_VOIP_SERVICE_METHOD_FIND_TELEPHONES,
                snAssinanteDTO, contractProspectInput);
        List<SnTelefoneVoip> telefoneVoipList;

        try {
            telefoneVoipList = snTelefoneVoipRepository.findByCidContratoAndNumContratoAndCodeBaseAndFlStatusBi(
                    contractProspectInput.getCityId(),
                    Integer.valueOf(contractProspectInput.getCustomerAccountId()),
                    snAssinanteDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI,
                    ContractProspectServiceConstansts.DEFAULT_DATA_FIM
            );
        } catch (Exception e) {
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TELEFONE_VOIP_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TELEFONE_VOIP_SERVICE_METHOD_FIND_TELEPHONES,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }


        List<SnTelefoneVoipDTO> telefoneVoipDTOList = new ArrayList<>();

        telefoneVoipList.forEach(telefone -> {
            if(Boolean.FALSE.equals(StringUtils.isNull(telefone))){
                telefoneVoipDTOList.add(SnTelefoneVoipDTO.create(telefone));
            }
        });

        List<Telephones> telephonesList = new ArrayList<>();

        for (SnTelefoneVoipDTO i : telefoneVoipDTOList) {
            var telephones = new Telephones();
            telephones.setAreaCode("0" + i.getDddTelefoneVoip());
            telephones.setPhoneNumber(i.getNumTelefoneVoip());
            telephones.setExtension(null);
            telephones.setType(ContractProspectServiceConstansts.NETFONE_VALUE);
            telephones.setContactName(snAssinanteDTO.getNomeTitular());
            telephonesList.add(telephones);
        }

        var telephones = new Telephones();
        if (!StringUtils.isNull(snAssinanteDTO.getTelRes())) {
            telephones.setAreaCode("0" + snAssinanteDTO.getTelRes().substring(0, 2));
            telephones.setPhoneNumber(snAssinanteDTO.getTelRes().substring(2));
            telephones.setType(ContractProspectServiceConstansts.TELEFONE_RESIDENCIAL);
            telephones.setContactName(snAssinanteDTO.getNomeTitular());
            telephonesList.add(telephones);
        }

        telephones = new Telephones();
        if (!StringUtils.isNull(snAssinanteDTO.getTelCom())) {
            telephones.setAreaCode("0" + snAssinanteDTO.getTelCom().substring(0, 2));
            telephones.setPhoneNumber(snAssinanteDTO.getTelCom().substring(2));
            telephones.setType(ContractProspectServiceConstansts.TELEFONE_COMERCIAL);
            telephones.setContactName(snAssinanteDTO.getNomeTitular());
            telephonesList.add(telephones);
        }

        telephones = new Telephones();
        if (!StringUtils.isNull(snAssinanteDTO.getCcTelCel())) {
            telephones.setAreaCode("0" + snAssinanteDTO.getCcTelCel().substring(0, 2));
            telephones.setPhoneNumber(snAssinanteDTO.getCcTelCel().substring(2));
            telephones.setType(ContractProspectServiceConstansts.TELEFONE_CELULAR);
            telephones.setContactName(snAssinanteDTO.getNomeTitular());
            telephonesList.add(telephones);
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_TELEFONE_VOIP_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TELEFONE_VOIP_SERVICE_METHOD_FIND_TELEPHONES,
                telephonesList);
        return telephonesList;

    }


}
