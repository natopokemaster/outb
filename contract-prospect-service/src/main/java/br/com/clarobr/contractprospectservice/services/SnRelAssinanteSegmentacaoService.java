package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelAssinanteSegmentacaoDTO;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnRelAssinanteSegmentacaoService {
    SnRelAssinanteSegmentacaoDTO findRelAssinanteSegmentacao(SnContratoDTO snContratoDTO) throws UnprocessableEntityException;
}
