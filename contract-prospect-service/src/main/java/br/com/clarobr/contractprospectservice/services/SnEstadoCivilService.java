package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnEstadoCivilDTO;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnEstadoCivilService {
    SnEstadoCivilDTO findEstadoCivil(SnAssinanteDTO snAssinanteDTO) throws UnprocessableEntityException, NotFoundException;
}
