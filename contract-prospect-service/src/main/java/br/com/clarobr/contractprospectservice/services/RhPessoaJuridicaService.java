package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.RhPessoaJuridicaDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnCidadeOperadoraDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface RhPessoaJuridicaService {
    RhPessoaJuridicaDTO findRhPessoaJuridicaAndSetContract(SnCidadeOperadoraDTO snCidadeOperadoraDTO, Contract contract) throws UnprocessableEntityException;
    RhPessoaJuridicaDTO findRhPessoaJuridica(SnCidadeOperadoraDTO snCidadeOperadoraDTO) throws UnprocessableEntityException;
}
