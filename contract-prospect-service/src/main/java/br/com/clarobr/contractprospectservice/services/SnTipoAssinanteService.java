package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoAssinanteDTO;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnTipoAssinanteService {

    public SnTipoAssinanteDTO findSnAssinanteDTO(String cityId,
                                                 Integer customerAccountNumber,
                                                 String codeBase,
                                                 String flStatusBi
    ) throws UnprocessableEntityException;
}
