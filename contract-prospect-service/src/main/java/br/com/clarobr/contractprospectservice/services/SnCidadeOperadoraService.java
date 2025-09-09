package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnCidadeOperadoraDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnCidadeOperadoraService {
    SnCidadeOperadoraDTO findCidadeOperadoraAndSetContract(ContractProspectInput contractProspectInput, Contract contract) throws UnprocessableEntityException;
    SnCidadeOperadoraDTO findCidadeOperadora(ContractProspectInput contractProspectInput) throws UnprocessableEntityException;
}
