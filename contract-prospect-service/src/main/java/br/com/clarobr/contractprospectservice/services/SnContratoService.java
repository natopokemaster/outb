package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnContratoService {
    SnContratoDTO findContratoByCustomerAccountIdAndCityId(ContractProspectInput contractProspectInput) throws UnprocessableEntityException, NotFoundException;

    SnContratoDTO findContratoByIdAssinate(SnAssinanteDTO snAssinanteDTO) throws UnprocessableEntityException, NotFoundException;
}
