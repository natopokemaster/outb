package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoContratoDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnTipoContratoService {
    SnTipoContratoDTO findTipoContrato(SnContratoDTO snContratoDTO) throws UnprocessableEntityException;
    SnTipoContratoDTO findTipoContratoAndSetContract(SnContratoDTO snContratoDTO, Contract contract) throws UnprocessableEntityException;
}
