package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnAssinanteService {

    SnAssinanteDTO findAssinante(SnContratoDTO snContratoDTO) throws UnprocessableEntityException, NotFoundException;

    List<SnAssinanteDTO> findAssinanteByDocumentId(ContractProspectInput contractProspectInput) throws UnprocessableEntityException, NotFoundException;
    List<SnAssinanteDTO> findAssinanteByAreaCodeAndPhoneNumber(ContractProspectInput contractProspectInput) throws UnprocessableEntityException, NotFoundException;
}
