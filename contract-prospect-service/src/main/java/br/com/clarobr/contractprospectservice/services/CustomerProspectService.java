package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.BadRequestException;
import br.com.clarobr.contractprospectservice.exception.CircuitBreakerException;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.objects.CustomerProspect;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface CustomerProspectService {
    List<CustomerProspect> getCustomerProspectData(ContractProspectInput contractProspectInput) throws Exception;

}
