package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnCidadeOperadoraDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.VsnVendedoresDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */

@Service
public interface VsnVendedoresService {
    VsnVendedoresDTO findVsnVendedor(SnContratoDTO snContratoDTO, SnCidadeOperadoraDTO snCidadeOperadoraDTO) throws UnprocessableEntityException;
    VsnVendedoresDTO findVsnVendedorAndSetContract(SnContratoDTO snContratoDTO, SnCidadeOperadoraDTO snCidadeOperadoraDTO, Contract contract) throws UnprocessableEntityException;
}
