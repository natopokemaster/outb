package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRazaoCancelamentoDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnRazaoCancelamentoService {
    SnRazaoCancelamentoDTO findRazaoCancelamento(SnContratoDTO snContratoDTO) throws UnprocessableEntityException;
    SnRazaoCancelamentoDTO findRazaoCancelamentoAndSetContract(SnContratoDTO snContratoDTO, Contract contract) throws UnprocessableEntityException;
}
