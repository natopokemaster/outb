package br.com.clarobr.contractprospectservice.services;

import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoServicoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnStatusContratoDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Alan Ricardo
 */

@Service
public interface SnStatusContratoService {
    SnStatusContratoDTO findStatusContrato(SnRelStatusContratoDTO snRelStatusContratoDTO) throws UnprocessableEntityException;
    void setContractStatus(SnStatusContrato snStatusContrato, Contract contract) throws UnprocessableEntityException;

    SnStatusContrato findStatusContratoServico(SnContratoDTO snContratoDTO) throws UnprocessableEntityException;
    void setContractStatusServico(SnStatusContrato snStatusContrato, Contract contract) throws UnprocessableEntityException;
}
