package br.com.clarobr.contractprospectservice.services.impl;

import br.com.clarobr.contractprospectservice.connectors.ContractUtilsConnector;
import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.enums.TipoPessoa;
import br.com.clarobr.contractprospectservice.exception.BadRequestException;
import br.com.clarobr.contractprospectservice.exception.InternalServerErrorException;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import br.com.clarobr.contractprospectservice.models.address.ContractIdentification;
import br.com.clarobr.contractprospectservice.models.address.vo.ContractIdentificationVO;
import br.com.clarobr.contractprospectservice.models.common.ErrorVO;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoServicoDTO;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.objects.Agent;
import br.com.clarobr.contractprospectservice.models.objects.BusinessSegment;
import br.com.clarobr.contractprospectservice.models.objects.CancellationReason;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.CustomerProspect;
import br.com.clarobr.contractprospectservice.models.objects.EducationLevel;
import br.com.clarobr.contractprospectservice.models.objects.Email;
import br.com.clarobr.contractprospectservice.models.objects.IndividualIdentifications;
import br.com.clarobr.contractprospectservice.models.objects.MaritalStatus;
import br.com.clarobr.contractprospectservice.models.objects.Occupation;
import br.com.clarobr.contractprospectservice.models.objects.Organization;
import br.com.clarobr.contractprospectservice.models.objects.OrganizationIdentifications;
import br.com.clarobr.contractprospectservice.models.objects.OrganizationStatus;
import br.com.clarobr.contractprospectservice.models.objects.Partner;
import br.com.clarobr.contractprospectservice.models.objects.Sale;
import br.com.clarobr.contractprospectservice.models.objects.Status;
import br.com.clarobr.contractprospectservice.models.objects.Telephones;
import br.com.clarobr.contractprospectservice.models.objects.Type;
import br.com.clarobr.contractprospectservice.services.CustomerProspectService;
import br.com.clarobr.contractprospectservice.services.RhPessoaJuridicaService;
import br.com.clarobr.contractprospectservice.services.SnAssinanteService;
import br.com.clarobr.contractprospectservice.services.SnCidadeOperadoraService;
import br.com.clarobr.contractprospectservice.services.SnContratoService;
import br.com.clarobr.contractprospectservice.services.SnEscolaridadeService;
import br.com.clarobr.contractprospectservice.services.SnEstadoCivilService;
import br.com.clarobr.contractprospectservice.services.SnOrgaoExpedidorService;
import br.com.clarobr.contractprospectservice.services.SnPrepostoService;
import br.com.clarobr.contractprospectservice.services.SnProfissaoService;
import br.com.clarobr.contractprospectservice.services.SnRazaoCancelamentoService;
import br.com.clarobr.contractprospectservice.services.SnRelAssinanteSegmentacaoService;
import br.com.clarobr.contractprospectservice.services.SnRelStatusContratoService;
import br.com.clarobr.contractprospectservice.services.SnSexoService;
import br.com.clarobr.contractprospectservice.services.SnStatusContratoService;
import br.com.clarobr.contractprospectservice.services.SnTelefoneVoipService;
import br.com.clarobr.contractprospectservice.services.SnTipoAssinanteService;
import br.com.clarobr.contractprospectservice.services.SnTipoContratoService;
import br.com.clarobr.contractprospectservice.services.SnTipoSegmentoService;
import br.com.clarobr.contractprospectservice.services.SnTipoVendaService;
import br.com.clarobr.contractprospectservice.services.VsnVendedoresService;
import br.com.clarobr.contractprospectservice.util.CurrentVersion;
import br.com.clarobr.contractprospectservice.util.ErrorUtils;
import br.com.clarobr.contractprospectservice.util.Resilience4jUtils;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.control.Try;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author Alan Ricardo
 */
@Service
@Slf4j
public class CustomerProspectServiceImpl implements CustomerProspectService {

    @Autowired
    private SnContratoService snContratoService;

    @Autowired
    private SnAssinanteService snAssinanteService;

    @Autowired
    private SnOrgaoExpedidorService snOrgaoExpedidorService;

    @Autowired
    private SnProfissaoService snProfissaoService;

    @Autowired
    private SnSexoService snSexoService;

    @Autowired
    private SnEstadoCivilService snEstadoCivilService;

    @Autowired
    private SnEscolaridadeService snEscolaridadeService;

    @Qualifier("snTelefoneVoipServiceImpl")
    @Autowired
    private SnTelefoneVoipService telefoneVoipService;

    @Autowired
    private SnCidadeOperadoraService snCidadeOperadoraService;

    @Autowired
    private RhPessoaJuridicaService rhPessoaJuridicaService;

    @Autowired
    private SnTipoVendaService snTipoVendaService;

    @Autowired
    private SnTipoContratoService snTipoContratoService;

    @Autowired
    private SnRazaoCancelamentoService snRazaoCancelamentoService;

    @Autowired
    private SnRelStatusContratoService snRelStatusContratoService;

    @Autowired
    private VsnVendedoresService vsnVendedoresService;

    @Autowired
    private SnPrepostoService snPrepostoService;

    @Autowired
    private SnStatusContratoService snStatusContratoService;

    @Autowired
    private SnRelAssinanteSegmentacaoService snRelAssinanteSegmentacaoService;

    @Autowired
    private SnTipoSegmentoService snTipoSegmentoService;

    @Autowired
    private SnTipoAssinanteService snTipoAssinanteService;

    @Autowired
    private final ContractUtilsConnector contractUtilsConnector;

    private final CircuitBreaker circuitBreaker;

    private final Retry retry;

    @Autowired
    @SuppressWarnings("all")
    public CustomerProspectServiceImpl(ContractUtilsConnector contractUtilsConnector, CircuitBreakerRegistry circuitBreakerRegistry, RetryRegistry retryRegistry) {
        this.contractUtilsConnector = contractUtilsConnector;

        circuitBreaker = circuitBreakerRegistry.circuitBreaker("contract-prospect-service-circuitbreaker");
        circuitBreaker.getEventPublisher().onEvent((event) -> log.debug(event.toString()));
        final String logCircuitBreaker = Resilience4jUtils.logCircuitBreakerConfig(circuitBreaker);
        log.debug(logCircuitBreaker);

        retry = retryRegistry.retry("address-service-retry");
        retry.getEventPublisher().onEvent((event) -> log.debug(event.toString()));
        final String logRetry = Resilience4jUtils.logRetryConfig(retry);
        log.debug(logRetry);
    }
    private ContractIdentificationVO recoveryPorContrato(Throwable throwable) {

        log.error("RXJava - Recovery: error from address-service: {}", throwable.getMessage());
        final String secureLogMessage = circuitBreaker.getState().name();
        log.error("RXJava - Recovery: Circuit Breaker is {}, recovering using default Contract", secureLogMessage);

        return ContractIdentificationVO.initForRecovery(CurrentVersion.ARQ_REF_VERSION);
    }

    @SuppressWarnings("all")
    private ContractIdentificationVO requestContractIdentification(ContractProspectInput request) throws UnprocessableEntityException,
            NotFoundException,
            BadRequestException,
            InternalServerErrorException,
            JsonProcessingException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CUSTOMER_PROSPECT_SERVICE_REQUEST_CONTRACT_IDENTIFICATION,
                request);
        ContractIdentificationVO vo = new ContractIdentificationVO();

        Supplier<ContractIdentificationVO> findCustomerByContractConnectorBackend = () -> {
            try {
                log.debug("Start contractIdentificationConnector");
                vo.setContractIdentification(contractUtilsConnector.getContractIdentification(request));
                vo.setErrorVO(new ErrorVO());

            }
            catch (JsonProcessingException | NotFoundException | UnprocessableEntityException | BadRequestException e) {
                log.error(ContractProspectServiceConstansts.ERROR_UNHANDLED_EXCEPTION, ExceptionUtils.getStackTrace(e));
                ErrorVO error = ErrorUtils.createError(e);
                vo.setContractIdentification(ContractIdentification.initForRecovery(CurrentVersion.ARQ_REF_VERSION));
                vo.setErrorVO(error);
            }
            log.debug("Finish contractIdentificationConnector");
            return vo;
        };
        Supplier<ContractIdentificationVO> decoratedFindCustomerByContractConnectorBackend = Decorators.ofSupplier(findCustomerByContractConnectorBackend)
                .withRetry(retry).withCircuitBreaker(circuitBreaker).decorate();

        ContractIdentificationVO response = Try.ofSupplier(decoratedFindCustomerByContractConnectorBackend).recover(this::recoveryPorContrato).get();

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CUSTOMER_PROSPECT_SERVICE_REQUEST_CONTRACT_IDENTIFICATION,
                response);
        return response;
    }

    @SuppressWarnings("All")
    public  List<CustomerProspect>  getCustomerProspectData(ContractProspectInput contractProspectInput) throws Exception {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA,
                contractProspectInput);
        if (Boolean.FALSE.equals(StringUtils.isBlank(contractProspectInput.getDocumentId()))) {

            log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_DOCUMENT_ID,
                    contractProspectInput);
            return getCustomerProspectDataByDocumentId(contractProspectInput);
        }
        else if (Boolean.TRUE.equals(!StringUtils.isBlank(contractProspectInput.getPhoneNumber())) &&
                 Boolean.TRUE.equals(!StringUtils.isBlank(contractProspectInput.getAreaCode()))) {

            log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_AREA_CODE_AND_PHONE_NUMBER,
                    contractProspectInput);
            return getCustomerProspectDataByAreaCodeAndPhoneNumber(contractProspectInput);
        }
        else {

            var contractIdentificationVO = requestContractIdentification(contractProspectInput);

            if (!contractIdentificationVO.getErrorVO().isEmpty()) {
                log.error(ContractProspectServiceConstansts.ERROR_UNHANDLED_CB_EXCEPTION_BY + contractIdentificationVO.getErrorVO().getMessage());
                throw new Exception(contractIdentificationVO.getErrorVO().getException().getMessage()) ;
            }
            contractProspectInput = new ContractProspectInput(contractIdentificationVO.getContractIdentification());
            List<CustomerProspect> response = new ArrayList<>();
            response.add(getCustomerProspectDataByContractIdentification(contractProspectInput));

            log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                    ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA,
                    response);
            return response;

        }
    }

    private List<CustomerProspect> getCustomerProspectDataByAreaCodeAndPhoneNumber(ContractProspectInput contractProspectInput)
                                                                                   throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_AREA_CODE_AND_PHONE_NUMBER,
                contractProspectInput);
        List<CustomerProspect> customerProspectList = new ArrayList<>();

        // Busca as informações da tabela SnAssinante
        List<SnAssinanteDTO> snAssinanteDTOList = snAssinanteService.findAssinanteByAreaCodeAndPhoneNumber(contractProspectInput);

        for (SnAssinanteDTO snAssinanteDTO : snAssinanteDTOList) {

            // Busca as informações da tabela SnContrato
            var snContratoDTO = snContratoService.findContratoByIdAssinate(snAssinanteDTO);
            contractProspectInput.setCityId(snContratoDTO.getCidContrato());
            contractProspectInput.setCustomerAccountId(snContratoDTO.getNumContrato().toString());
            contractProspectInput.setCodeBase(snAssinanteDTO.getCodeBase());
            customerProspectList.add(customerProspect(snContratoDTO, contractProspectInput, snAssinanteDTO));

        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_AREA_CODE_AND_PHONE_NUMBER,
                customerProspectList);
        return customerProspectList;

    }

    private List<CustomerProspect> getCustomerProspectDataByDocumentId(ContractProspectInput contractProspectInput) throws UnprocessableEntityException, NotFoundException {
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_DOCUMENT_ID,
                contractProspectInput);
        List<CustomerProspect> customerProspectList = new ArrayList<>();

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_DOCUMENT_ID,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE_BY_DOCUMENT_ID,
                contractProspectInput);
        // Busca as informações da tabela SnAssinante
        List<SnAssinanteDTO> snAssinanteDTOList = snAssinanteService.findAssinanteByDocumentId(contractProspectInput);

        for(SnAssinanteDTO snAssinanteDTO : snAssinanteDTOList){
            // Busca as informações da tabela SnContrato
            var snContratoDTO = snContratoService.findContratoByIdAssinate(snAssinanteDTO);
            contractProspectInput.setCityId(snContratoDTO.getCidContrato());
            contractProspectInput.setCustomerAccountId(snContratoDTO.getNumContrato().toString());
            contractProspectInput.setCodeBase(snContratoDTO.getCodeBase());
            contractProspectInput.setCodeBase(snAssinanteDTO.getCodeBase());
            customerProspectList.add(customerProspect(snContratoDTO, contractProspectInput, snAssinanteDTO));
        }

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_DOCUMENT_ID,
                customerProspectList);
        return customerProspectList;

    }

    private CustomerProspect getCustomerProspectDataByContractIdentification(ContractProspectInput contractProspectInput) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_CONTRACT_IDENTIFICATION,
                contractProspectInput);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_CONTRACT_IDENTIFICATION,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_CONTRATO_BY_CUSTOMER_ACCOUNT_ID_AND_CITY_ID,
                contractProspectInput);
        // Busca as informações da tabela SnContrato
        var snContratoDTO = snContratoService.findContratoByCustomerAccountIdAndCityId(contractProspectInput);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_CONTRACT_IDENTIFICATION,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ASSINANTE_SERVICE_METHOD_FIND_ASSINANTE,
                contractProspectInput);
        // Busca as informações da tabela SnAssinante
        var snAssinanteDTO = snAssinanteService.findAssinante(snContratoDTO);


        contractProspectInput.setCodeBase(snAssinanteDTO.getCodeBase());

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_GET_CUSTOMER_PROSPECT_DATA_BY_CONTRACT_IDENTIFICATION,
                snContratoDTO, contractProspectInput, snAssinanteDTO);
        return customerProspect(snContratoDTO, contractProspectInput, snAssinanteDTO);

    }

    public CustomerProspect customerProspect(SnContratoDTO snContratoDTO, ContractProspectInput contractProspectInput, SnAssinanteDTO snAssinanteDTO) throws UnprocessableEntityException, NotFoundException {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                snContratoDTO, contractProspectInput, snAssinanteDTO);
        var response = new CustomerProspect();


        var contract = createContract(snContratoDTO, snAssinanteDTO);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_PROFISSAO_SERVICE_METHOD_FIND_PROFISSAO,
                snAssinanteDTO);
        // Busca as informações da tabela SnProfissao
        var snProfissaoDTO = snProfissaoService.findProfissao(snAssinanteDTO);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_SEXO_SERVICE_SERVICE_METHOD_FIND_SEXO,
                snAssinanteDTO);
        // Busca as informações da tabela SnSexo
        var snSexoDTO = snSexoService.findSexo(snAssinanteDTO);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_SN_ESTADO_CIVIL_SERVICE_SERVICE_METHOD_FIND_ESTADO_CIVIL,
                snAssinanteDTO);
        // Busca as informações da tabela SnEstadoCivil
        var snEstadoCivilDTO = snEstadoCivilService.findEstadoCivil(snAssinanteDTO);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ORGAO_EXPEDIDOR_SERVICE_SERVICE_METHOD_FIND_ORGAO_EXPEDIDOR,
                snAssinanteDTO);
        // Busca as informações da tabela SnOrgaoExpedidor
        var snOrgaoExpedidorDTO = snOrgaoExpedidorService.findOrgaoExpedidor(snAssinanteDTO);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_ESCOLARIDADE_SERVICE_SERVICE_METHOD_FIND_ESCOLARIDADE,
                snAssinanteDTO);
        // Busca as informações da tabela SnEscolaridade
        var snEscolaridadeDTO = snEscolaridadeService.findEscolaridade(snAssinanteDTO);


        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_TELEFONE_VOIP_SERVICE_SERVICE_METHOD_FIND_TELEPHONES,
                snAssinanteDTO, contractProspectInput);
        // Busca as informações da tabela SnTelefoneVoip
        List<Telephones> telephonesList = telefoneVoipService.findTelephones(snAssinanteDTO, contractProspectInput);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_CIDADE_OPERADORA_SERVICE_METHOD_FIND_CIDADE_OPERADORA_AND_SET_CONTRACT,
                contractProspectInput, contract);
        // Busca as informações da tabela SnCidadeOperadora
        var snCidadeOperadoraDTO = snCidadeOperadoraService.findCidadeOperadoraAndSetContract(contractProspectInput, contract);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_RH_PESSOA_JURIDICA_SERVICE_METHOD_FIND_RH_PESSOA_JURIDICA_AND_SET_CONTRACT,
                snCidadeOperadoraDTO, contract);
        // Busca as informações da tabela RhPessoaJuridica e seta no Contract
        rhPessoaJuridicaService.findRhPessoaJuridicaAndSetContract(snCidadeOperadoraDTO, contract);

        // Busca as informações da tabela SnTipoVenda
        var snTipoVendaDTO = snTipoVendaService.findTipoVendaAndSetContract(snContratoDTO, contract);

        contract.getSale().setType(new Type(snTipoVendaDTO.getIdTipoVenda(), snTipoVendaDTO.getDescricao()));
        // Busca as informações da tabela SnTipoContrato
        var snTipoContratoDTO = snTipoContratoService.findTipoContratoAndSetContract(snContratoDTO, contract);
        contract.setType(new Type(snTipoContratoDTO.getIdTipoContrato(), snTipoContratoDTO.getDescricao()));

        // Busca as informações da tabela SnRazaoCancelamento
        var snRazaoCancelamentoDTO = snRazaoCancelamentoService.findRazaoCancelamento(snContratoDTO);
        contract.getSale().setCancellationReason(new CancellationReason(new Type(snRazaoCancelamentoDTO.getIdRazaoCancelamento(), snRazaoCancelamentoDTO.getDescricao())));

        // Busca as informações da tabela SnRelStatusContrato
        var snStatusContrato = snRelStatusContratoService.findSnRelStatusContrato(snContratoDTO);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_STATUS_CONTRATO_SERVICE_METHOD_FIND_STATUS_CONTRATO_AND_SET_CONTRACT,
                snStatusContrato, contract);

        snStatusContratoService.setContractStatus(snStatusContrato, contract);


        // Busca as informações da tabela SnRelStatusContratoServico
        SnStatusContrato result = snStatusContratoService.findStatusContratoServico(snContratoDTO);
        snStatusContratoService.setContractStatusServico(result, contract);

        // Busca as informações da tabela SnRelAssinanteSegmentacao
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_REL_ASSINANTE_SEGMENTACAO_SERVICE_METHOD_FIND_REL_ASSINANTE_SEGMENTACAO,
                snContratoDTO);
        var snRelAssinanteSegmentacaoDTO = snRelAssinanteSegmentacaoService.findRelAssinanteSegmentacao(snContratoDTO);
        
        // Busca as informações da tabela SnTipoSegmento
        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_SN_TIPO_SEGMENTO_SERVICE_METHOD_FIND_TIPO_SEGMENTO_AND_SET_CONTRACT,
                snRelAssinanteSegmentacaoDTO, contract);
        snTipoSegmentoService.findTipoSegmentoAndSetContract(snRelAssinanteSegmentacaoDTO, contract);

        // Busca as informações da tabela SnRelContratoTipoAssinante
        var tipoCliente = snTipoAssinanteService.findSnAssinanteDTO(snContratoDTO.getCidContrato(),snContratoDTO.getNumContrato(), snContratoDTO.getCodeBase(),
                ContractProspectServiceConstansts.FL_STATUS_BI);
        contract.setCustomerSegmentType(tipoCliente.getDescricao());

        vsnVendedoresService.findVsnVendedorAndSetContract(snContratoDTO, snCidadeOperadoraDTO, contract);
        
        var snPrepostoDTO = snPrepostoService.findSnPrepostaByNumContratoAndCidContrato(snContratoDTO);
        contract.setAgent(new Agent(snPrepostoDTO.getIdPreposto(), snPrepostoDTO.getNomePreposto(),
                                                snPrepostoDTO.getRelacao()));

        response.setId(snAssinanteDTO.getIdAssinante());
        response.setName(snAssinanteDTO.getNomeTitular());
        response.setDocumentId(snAssinanteDTO.getCpf());
        response.setPersonType(TipoPessoa.returnPersonTypeDescription(snAssinanteDTO.getIdTipoPessoa()).getDescription());
        response.setIsForeigner(snAssinanteDTO.getEstrangeiro() != null);
        if(response.getPersonType().equals("JURIDICA")){
            response.setDocumentType(ContractProspectServiceConstansts.DEFAULT_COMPANY_DOCUMENT_TYPE);

            List<OrganizationIdentifications> organizationIdentificationsList = new ArrayList<>();
            var organizationIdentifications = new OrganizationIdentifications();
            organizationIdentifications.setType(ContractProspectServiceConstansts.DEFAULT_DOCUMENT_TYPE_JURIDICA);
            organizationIdentifications.setIdentificationId(snAssinanteDTO.getCpf());
            organizationIdentificationsList.add(organizationIdentifications);

            organizationIdentifications = new OrganizationIdentifications();
            organizationIdentifications.setType(ContractProspectServiceConstansts.DEFAULT_INSCRICAO_ESTADUAL);
            organizationIdentifications.setIdentificationId(snAssinanteDTO.getNumRg());
            organizationIdentifications.setIssuingAuthority(snOrgaoExpedidorDTO.getDescricao());
            organizationIdentificationsList.add(organizationIdentifications);

            response.setOrganizationIdentifications(organizationIdentificationsList);

            response.setBusinessSegment(new BusinessSegment(snProfissaoDTO.getIdProfissao(),snProfissaoDTO.getDescricao()));
            response.setFoundationDate(snAssinanteDTO.getDtNascimento());
            response.setOrganizationType(snSexoDTO.getDescricao());
            response.setOrganizationStatus(new OrganizationStatus(snEstadoCivilDTO.getIdEstadoCivil(),snEstadoCivilDTO.getDescricao()));

        }
        else {
            List<IndividualIdentifications> individualIdentificationsList = new ArrayList<>();
            response.setDocumentType(ContractProspectServiceConstansts.DEFAULT_DOCUMENT_TYPE_FISICA);
            IndividualIdentifications individualIdentifications;
            if(snAssinanteDTO.getIdOrgaoExpedidor() != 0){
                individualIdentifications = new IndividualIdentifications();

                individualIdentifications.setType(ContractProspectServiceConstansts.DEFAULT_RG);
                individualIdentifications.setIdentificationId(snAssinanteDTO.getNumRg());
                individualIdentifications.setIssuingAuthority(snOrgaoExpedidorDTO.getDescricao());
                individualIdentificationsList.add(individualIdentifications);
            }
            if(snAssinanteDTO.getIdOrgaoExpedidor() == 0){
                individualIdentifications = new IndividualIdentifications();

                individualIdentifications.setType(ContractProspectServiceConstansts.DEFAULT_PASSAPORTE);
                individualIdentifications.setIdentificationId(snAssinanteDTO.getNumRg());
                individualIdentifications.setIssuingAuthority(snOrgaoExpedidorDTO.getDescricao());
                individualIdentificationsList.add(individualIdentifications);
            }
            individualIdentifications = new IndividualIdentifications();
            individualIdentifications.setType(ContractProspectServiceConstansts.DEFAULT_DOCUMENT_TYPE_FISICA);
            individualIdentifications.setIdentificationId(snAssinanteDTO.getCpf());
            individualIdentificationsList.add(individualIdentifications);

            response.setIndividualIdentifications(individualIdentificationsList);
            response.setBirthDate(snAssinanteDTO.getDtNascimento());
            response.setMotherName(snAssinanteDTO.getNomeMae());
            response.setFatherName(snAssinanteDTO.getNomePai());
            response.setOccupation(new Occupation(snProfissaoDTO.getIdProfissao(), snProfissaoDTO.getDescricao()));
            response.setGender(snSexoDTO.getDescricao());
            response.setMaritalStatus(new MaritalStatus(snEstadoCivilDTO.getIdEstadoCivil(), snEstadoCivilDTO.getDescricao()));
            response.setEducationLevel(new EducationLevel(snEscolaridadeDTO.getIdEscolaridade(), snEscolaridadeDTO.getDescricao()));

        }
        response.setEmail(new Email(snAssinanteDTO.getEmail(), null, snAssinanteDTO.getEmailDefault() != 0));
        response.setTelephones(telephonesList);
        response.setContract(contract);

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CUSTOMER_PROSPECT,
                response);
        return response;
    }

    private Contract createContract(SnContratoDTO snContratoDTO, SnAssinanteDTO snAssinanteDTO) {

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_START,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CREATE_CONTRACT,
                snContratoDTO, snAssinanteDTO);
        var contract = new Contract();
        contract.setCustomerAccountId(snContratoDTO.getNumContrato());
        contract.setVerificationDigit(snContratoDTO.getDigitoVerificacao());

        var organization = new Organization();
        contract.setOrganization(organization);
        contract.setProductName(ContractProspectServiceConstansts.HARDFORNE);
        contract.setSale(new Sale());
        contract.getSale().setPurchaseDate(snContratoDTO.getDtVenda());
        contract.getSale().setCancellationDate(snContratoDTO.getDtCancelamento());
        contract.getSale().setRequestDate(snContratoDTO.getDtCadastro());
        contract.setNote(snContratoDTO.getObs());
        contract.setSuframaCode(snAssinanteDTO.getCdSuframa());
        contract.setEmbratelContractNumber(snContratoDTO.getEmbratelContractNumber());

        log.debug(ContractProspectServiceConstansts.DEFAULT_LOG_FORMAT_CALL_METHOD_INSIDE_CLASS_END,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CUSTOMER_PROSPECT_SERVICE,
                ContractProspectServiceConstansts.DEFAULT_LOG_MESSAGE_CLASS_CONTRACT_PROSPECT_SERVICE_METHOD_CREATE_CONTRACT,
                contract);
        return contract;

    }

}
