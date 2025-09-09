package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.dto.SnRelAssinanteSegmentacaoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoSegmentoDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
public interface SnTipoSegmentoService {
    SnTipoSegmentoDTO findTipoSegmento(SnRelAssinanteSegmentacaoDTO snRelAssinanteSegmentacaoDTO) throws UnprocessableEntityException;
    SnTipoSegmentoDTO findTipoSegmentoAndSetContract(SnRelAssinanteSegmentacaoDTO snRelAssinanteSegmentacaoDTO, Contract contract) throws UnprocessableEntityException;
}
