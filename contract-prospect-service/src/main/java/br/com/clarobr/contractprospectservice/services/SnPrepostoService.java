package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnPrepostoDTO;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnPrepostoService {
    SnPrepostoDTO findSnPrepostaByNumContratoAndCidContrato(SnContratoDTO snContratoDTO) throws UnprocessableEntityException;
}
