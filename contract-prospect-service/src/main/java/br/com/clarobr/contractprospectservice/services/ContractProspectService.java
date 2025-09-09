package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.BadRequestException;
import br.com.clarobr.contractprospectservice.exception.CircuitBreakerException;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.output.ContractProspectOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface ContractProspectService {
    ContractProspectOutput getContractProspect(ContractProspectInput request) throws Exception;

}
