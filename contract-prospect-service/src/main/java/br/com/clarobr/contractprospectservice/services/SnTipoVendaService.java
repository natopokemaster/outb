package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoVendaDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnTipoVendaService {
    SnTipoVendaDTO findTipoVenda(SnContratoDTO snContratoDTO) throws UnprocessableEntityException;
    SnTipoVendaDTO findTipoVendaAndSetContract(SnContratoDTO snContratoDTO, Contract contract) throws UnprocessableEntityException;
}
