package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.RhPessoaJuridica;
import br.com.clarobr.contractprospectservice.models.dto.RhPessoaJuridicaDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnCidadeOperadoraDTO;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.OrganizationIdentifications;
import br.com.clarobr.contractprospectservice.repository.RhPessoaJuridicaRepository;
import br.com.clarobr.contractprospectservice.services.RhPessoaJuridicaService;
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
public class RhPessoaJuridicaServiceImpl implements RhPessoaJuridicaService {

        @Autowired
        private RhPessoaJuridicaRepository rhPessoaJuridicaRepository;

        @Override
        public RhPessoaJuridicaDTO findRhPessoaJuridicaAndSetContract(SnCidadeOperadoraDTO snCidadeOperadoraDTO,
                        Contract contract) throws UnprocessableEntityException {

                log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_RH_PESSOA_JURIDICA_SERVICE,
                                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_RH_PESSOA_JURIDICA_SERVICE_METHOD_FIND_RH_PESSOA_JURIDICA_AND_SET_CONTRACT,
                                snCidadeOperadoraDTO, contract);

                var rhPessoaJuridicaDTO = findRhPessoaJuridica(snCidadeOperadoraDTO);
                var organizationIdentifications = new OrganizationIdentifications();
                organizationIdentifications.setIdentificationId(rhPessoaJuridicaDTO.getCgc());
                organizationIdentifications.setType(ContractProspectServiceConstansts.DEFAULT_COMPANY_DOCUMENT_TYPE);
                contract.getOrganization().getOrganizationIdentifications().add(organizationIdentifications);

                contract.getOrganization().setId(rhPessoaJuridicaDTO.getIdEmpresa());
                organizationIdentifications = new OrganizationIdentifications();
                organizationIdentifications.setIdentificationId(rhPessoaJuridicaDTO.getInscricaoEstadual());
                organizationIdentifications.setType(ContractProspectServiceConstansts.DEFAULT_INSCRICAO_ESTADUAL);
                contract.getOrganization().getOrganizationIdentifications().add(organizationIdentifications);

                log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_RH_PESSOA_JURIDICA_SERVICE,
                                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_RH_PESSOA_JURIDICA_SERVICE_METHOD_FIND_RH_PESSOA_JURIDICA_AND_SET_CONTRACT,
                                rhPessoaJuridicaDTO, contract);
                return rhPessoaJuridicaDTO;
        }

        @Override
        public RhPessoaJuridicaDTO findRhPessoaJuridica(SnCidadeOperadoraDTO snCidadeOperadoraDTO)
                        throws UnprocessableEntityException {

                log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_RH_PESSOA_JURIDICA_SERVICE,
                                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_RH_PESSOA_JURIDICA_SERVICE_METHOD_FIND_RH_PESSOA_JURIDICA,
                                snCidadeOperadoraDTO);
                RhPessoaJuridica rhPessoaJuridica;
                try {
                        rhPessoaJuridica = rhPessoaJuridicaRepository
                                        .findRhPessoaJuridicaByIdEmpresaAndCodeBaseAndFlStatusBi(
                                                        snCidadeOperadoraDTO.getIdEmpresa(),
                                                        snCidadeOperadoraDTO.getCodeBase(),
                                                        snCidadeOperadoraDTO.getFlStatusBi());
                } catch (Exception e) {
                        log.error(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_ERROR,
                                        ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_SN_ASSINANTE_SERVICE,
                                        ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE,
                                        ExceptionUtils.getMessage(e),
                                        ExceptionUtils.getStackTrace(e));
                        throw new UnprocessableEntityException(
                                        ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION
                                                        + ExceptionUtils.getMessage(e),
                                        ContractProspectServiceConstansts.CODE_UTILS_BAD_REQUEST);
                }
                log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_RH_PESSOA_JURIDICA_SERVICE,
                                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_RH_PESSOA_JURIDICA_SERVICE_METHOD_FIND_RH_PESSOA_JURIDICA,
                                rhPessoaJuridica);

                return Boolean.FALSE.equals(StringUtils.isNull(rhPessoaJuridica))
                                ? RhPessoaJuridicaDTO.create(rhPessoaJuridica)
                                : new RhPessoaJuridicaDTO();
        }
}
