package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.objects.Telephones;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnTelefoneVoipService {
    List<Telephones> findTelephones(SnAssinanteDTO snAssinanteDTO, ContractProspectInput contractProspectInput) throws UnprocessableEntityException;
}
