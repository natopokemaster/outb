package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.RhPessoa;
import br.com.clarobr.contractprospectservice.models.RhPessoaPessoa;
import br.com.clarobr.contractprospectservice.models.dto.RhPessoaDTO;
import br.com.clarobr.contractprospectservice.models.dto.RhPessoaPessoaDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnCidadeOperadoraDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.VsnVendedoresDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.SalesPerson;
import br.com.clarobr.contractprospectservice.repository.RhPessoaPessoaRepository;
import br.com.clarobr.contractprospectservice.repository.RhPessoaRepository;
import br.com.clarobr.contractprospectservice.services.VsnVendedoresService;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */

@Service
@Slf4j
public class VsnVendedoresServiceImpl implements VsnVendedoresService {

    @Autowired
    private RhPessoaRepository rhPessoaRepository;

    @Autowired
    private RhPessoaPessoaRepository rhPessoaPessoaRepositry;

    @Override
    public VsnVendedoresDTO findVsnVendedor(SnContratoDTO snContratoDTO, SnCidadeOperadoraDTO snCidadeOperadoraDTO) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_VSN_VENDEDORES_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR,
                snContratoDTO, snCidadeOperadoraDTO);
        RhPessoa rhPessoa;

        try{
            rhPessoa = rhPessoaRepository.findRhPessoaByIdPessoaAndCodeBaseAndFlStatusBi(
                    snContratoDTO.getIdPessoaFisica(), snContratoDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI
            );
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_VSN_VENDEDORES_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }
        var rhPessoaDTO = Boolean.FALSE.equals(StringUtils.isNull(rhPessoa)) ? RhPessoaDTO.create(rhPessoa) : new RhPessoaDTO();

        RhPessoaPessoa rhPessoaPessoa;

        try {
            rhPessoaPessoa = rhPessoaPessoaRepositry.findRhPessoaPessoaByIdPessoaAndIdPessoaBaseAndIdTipoRelacaoAndIdStatusAndCodeBaseAndFlStatusBi(
                    rhPessoaDTO.getIdPessoa(), snCidadeOperadoraDTO.getIdEmpresa(), 10, 1, snContratoDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI
            );
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_VSN_VENDEDORES_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }
        var rhPessoaPessoaDTO = Boolean.FALSE.equals(StringUtils.isNull(rhPessoaPessoa)) ? RhPessoaPessoaDTO.create(rhPessoaPessoa) : new RhPessoaPessoaDTO();

        try{
            rhPessoa = rhPessoaRepository.findRhPessoaByIdPessoaAndCodeBaseAndFlStatusBi(
                    rhPessoaPessoaDTO.getIdPessoa(), rhPessoaDTO.getCodeBase(),
                    ContractProspectServiceConstansts.FL_STATUS_BI
            );
        }
        catch (Exception e){
            log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_VSN_VENDEDORES_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR,
                    ExceptionUtils.getMessage(e),
                    ExceptionUtils.getStackTrace(e));
            throw new UnprocessableEntityException(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION + ExceptionUtils.getMessage(e),
                    ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
        }

        var vsnVendedoresDTO = new VsnVendedoresDTO();
        vsnVendedoresDTO.setIdVendedor(rhPessoaPessoaDTO.getIdPessoa());
        vsnVendedoresDTO.setIdEmpresa(rhPessoaPessoaDTO.getIdPessoaBase());

        rhPessoaDTO = Boolean.FALSE.equals(StringUtils.isNull(rhPessoa)) ? RhPessoaDTO.create(rhPessoa) : new RhPessoaDTO();

        vsnVendedoresDTO.setNomeVendedor(rhPessoaDTO.getNomePessoa());
        vsnVendedoresDTO.setEmail(rhPessoaDTO.getEmail());
        vsnVendedoresDTO.setTelefone(rhPessoaDTO.getTelefone());

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_VSN_VENDEDORES_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR,
                vsnVendedoresDTO);
        return vsnVendedoresDTO;
    }


    @Override
    public VsnVendedoresDTO findVsnVendedorAndSetContract(SnContratoDTO snContratoDTO, SnCidadeOperadoraDTO snCidadeOperadoraDTO, Contract contract) throws UnprocessableEntityException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_VSN_VENDEDORES_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR_AND_SET_CONTRACT,
                snContratoDTO, snCidadeOperadoraDTO, contract);
        var vsnVendedoresDTO = findVsnVendedor(snContratoDTO, snCidadeOperadoraDTO );

        contract.setSalesPerson(new SalesPerson(snContratoDTO.getUsrAtend(),null,null,null));


        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_VSN_VENDEDORES_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_VSN_VENDEDORES_SERVICE_METHOD_FIND_VSN_VENDEDOR_AND_SET_CONTRACT,
                vsnVendedoresDTO, contract);
        return vsnVendedoresDTO;

    }

}
