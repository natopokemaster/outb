package br.com.clarobr.contractprospectservice.service;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;

import br.com.clarobr.contractprospectservice.models.*;
import br.com.clarobr.contractprospectservice.models.dto.*;
import br.com.clarobr.contractprospectservice.models.input.ContractProspectInput;
import br.com.clarobr.contractprospectservice.models.objects.Contract;
import br.com.clarobr.contractprospectservice.models.objects.Segment;
import br.com.clarobr.contractprospectservice.models.objects.Status;
import br.com.clarobr.contractprospectservice.models.objects.Telephones;
import br.com.clarobr.contractprospectservice.models.objects.Type;
import br.com.clarobr.contractprospectservice.repository.*;
import br.com.clarobr.contractprospectservice.services.impl.*;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

/**
 * @author Alan Ricardo
 * @author Viviane Magalhães Siqueira
 */

@TestPropertySource(properties = "classpath:application-test.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("All")
class ContractProspectServiceTest {

    @Autowired
    private RhPessoaJuridicaServiceImpl rhPessoaJuridicaService;
    @Autowired
    private SnAssinanteServiceImpl snAssinanteService;
    @MockBean
    private SnAssinanteRepository snAssinanteRepository;
    @MockBean
    private SnCidadeOperadoraRepository snCidadeOperadoraRepository;
    @Autowired
    private SnCidadeOperadoraServiceImpl snCidadeOperadoraService;
    @Autowired
    private SnContratoServiceImpl snContratoService;
    @MockBean
    private SnContratoRepository snContratoRepository;
    @Autowired
    private SnEscolaridadeServiceImpl snEscolaridadeService;
    @MockBean
    private SnEscolaridadeRepository snEscolaridadeRepository;
    @Autowired
    private SnEstadoCivilServiceImpl snEstadoCivilService;
    @MockBean
    private SnEstadoCivilRepository snEstadoCivilRepository;
    @Autowired
    private SnOrgaoExpedidorServiceImpl snOrgaoExpedidorService;
    @MockBean
    private SnOrgaoExpedidorRepository snOrgaoExpedidorRepository;
    @Autowired
    private SnPrepostoServiceImpl snPrepostoService;
    @MockBean
    private SnPrepostoRepository snPrepostoRepository;
    @Autowired
    private SnProfissaoServiceImpl snProfissaoService;
    @MockBean
    private SnProfissaoRepository snProfissaoRepository;
    @Autowired
    private SnRazaoCancelamentoServiceImpl snRazaoCancelamentoService;
    @MockBean
    private SnRazaoCancelamentoRepository snRazaoCancelamentoRepository;
    @Autowired
    private SnRelAssinanteSegmentacaoServiceImpl snRelAssinanteSegmentacaoService;
    @MockBean
    private SnRelAssinanteSegmentacaoRepository snRelAssinanteSegmentacaoRepository;
    @Autowired
    private SnRelStatusContratoServiceImpl snRelStatusContratoService;
    @MockBean
    private SnRelStatusContratoRepository snRelStatusContratoRepository;
    @Autowired
    private SnSexoServiceImpl snSexoService;
    @MockBean
    private SnSexoRepository snSexoRepository;
    @Autowired
    private SnStatusContratoServiceImpl snStatusContratoService;
    @MockBean
    private SnStatusContratoRepository snStatusContratoRepository;
    @Autowired
    private SnTelefoneVoipServiceImpl snTelefoneVoipService;
    @MockBean
    private SnTelefoneVoipRepository snTelefoneVoipRepository;
    @Autowired
    private SnTipoContratoServiceImpl snTipoContratoService;
    @MockBean
    private SnTipoContratoRepository snTipoContratoRepository;
    @Autowired
    private SnTipoSegmentoServiceImpl snTipoSegmentoService;
    @MockBean
    private SnTipoSegmentoRepository snTipoSegmentoRepository;
    @Autowired
    private SnTipoVendaServiceImpl snTipoVendaService;
    @MockBean
    private SnTipoVendaRepository snTipoVendaRepository;
    @Autowired
    private VsnVendedoresServiceImpl vsnVendedoresService;
    @MockBean
    private RhPessoaRepository rhPessoaRepository;
    @MockBean
    private RhPessoaPessoaRepository rhPessoaPessoaRepositry;

    @Test
    @Order(1)
    @DisplayName("Buscando pessoa juridica com sucesso")
    void findRhPessoaJuridica() throws UnprocessableEntityException {

        SnCidadeOperadoraDTO request = new SnCidadeOperadoraDTO();
        request.setCidContrato("02121");
        request.setCiNome("VIA EMBRATEL");
        request.setCodOperadora("021");
        request.setNomePessoa("VIA EMBRATEL");
        request.setRazaoSocial("Embratel TVSAT Telecomunicac?es Ltda");
        request.setIdEmpresa("002121");
        request.setCodeBase("CTV");
        request.setFlStatusBi("A");

        RhPessoaJuridicaDTO result = rhPessoaJuridicaService.findRhPessoaJuridica(request);

        RhPessoaJuridicaDTO consult = new RhPessoaJuridicaDTO();
        consult.setIdEmpresa("002121");
        consult.setInscricaoEstadual("78387548");
        consult.setCgc("9132659000176");
        consult.setCodeBase("CTV");
        consult.setFlStatusBi("A");

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(2)
    @DisplayName("Buscando pessoa juridica passando null com falha")
    void findRhPessoaJuridicaWithNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            rhPessoaJuridicaService.findRhPessoaJuridica(null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(3)
    @DisplayName("Buscando pessoa juridica sem valor com erro")
    void findRhPessoaJuridicaWithoutValueFailed() throws UnprocessableEntityException {
        SnCidadeOperadoraDTO request = new SnCidadeOperadoraDTO();

        RhPessoaJuridicaDTO result = rhPessoaJuridicaService.findRhPessoaJuridica(request);

        RhPessoaJuridicaDTO consult = new RhPessoaJuridicaDTO();
        consult.setIdEmpresa("002121");
        consult.setInscricaoEstadual("78387548");
        consult.setCgc("9132659000176");
        consult.setCodeBase("CTV");
        consult.setFlStatusBi("A");

        Assertions.assertNotEquals(consult, result);

    }

    @Test
    @Order(4)
    @DisplayName("Buscando pessoa juridica e sentando contrato sucesso")
    void findRhPessoaJuridicaAndSetContractSucess() throws UnprocessableEntityException {

        SnCidadeOperadoraDTO request = new SnCidadeOperadoraDTO();

        request.setCidContrato("02121");
        request.setCiNome("VIA EMBRATEL");
        request.setCodOperadora("021");
        request.setNomePessoa("VIA EMBRATEL");
        request.setRazaoSocial("Embratel TVSAT Telecomunicac?es Ltda");
        request.setIdEmpresa("002121");
        request.setCodeBase("CTV");
        request.setFlStatusBi("A");
        Contract contract = new Contract();

        RhPessoaJuridicaDTO result = rhPessoaJuridicaService.findRhPessoaJuridicaAndSetContract(request, contract);

        RhPessoaJuridicaDTO consult = new RhPessoaJuridicaDTO();
        consult.setIdEmpresa("002121");
        consult.setInscricaoEstadual("78387548");
        consult.setCgc("9132659000176");
        consult.setCodeBase("CTV");
        consult.setFlStatusBi("A");

        Assertions.assertNotNull(contract.getOrganization());
        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(5)
    @DisplayName("Buscando pessoa juridica e sentando contrato sem valor falha")
    void findRhPessoaJuridicaAndSetContractWithouValueFalied() throws UnprocessableEntityException {
        SnCidadeOperadoraDTO request = new SnCidadeOperadoraDTO();

        Contract contract = new Contract();

        RhPessoaJuridicaDTO result = rhPessoaJuridicaService.findRhPessoaJuridicaAndSetContract(request, contract);

        RhPessoaJuridicaDTO consult = new RhPessoaJuridicaDTO();
        consult.setIdEmpresa("002121");
        consult.setInscricaoEstadual("78387548");
        consult.setCgc("9132659000176");
        consult.setCodeBase("CTV");
        consult.setFlStatusBi("A");

        Assertions.assertNotNull(contract.getOrganization());
        Assertions.assertNotEquals(consult, result);

    }

    @Test
    @Order(6)
    @DisplayName("Buscando pessoa juridica e setando contrato passando null com falha")
    void findRhPessoaJuridicaAndSetContractWithNullFailed() {

        Contract contract = new Contract();
        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            rhPessoaJuridicaService.findRhPessoaJuridicaAndSetContract(null, contract);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(7)
    @DisplayName("Buscando assinante com sucesso")
    void findAssinante() throws UnprocessableEntityException, NotFoundException {

        SnAssinante request = new SnAssinante();
        request.setIdAssinante(181873296L);
        request.setDtNascimento(Date.valueOf("1993-10-16"));
        request.setIdAssinante(18285804L);
        request.setCcTelCel(null);
        request.setCdSuframa(null);
        request.setCpf("48123027222");
        request.setEstrangeiro(null);
        request.setEmail("teste@descaracterizacao.com.br");
        request.setEmailDefault(0);
        request.setFax(null);
        request.setIdProfissao(53);
        request.setIdSexo(2);
        request.setIdEstadoCivil(6);
        request.setIdEcoladorade(0); //Modificar nome parametro
        request.setIdOrgaoExpedidor(0);
        request.setIdTipoPessoa(1);
        request.setNomeMae("VDYDXPV TNZRTUXL HTSDQ FBIJXT");
        request.setNomePai(null);
        request.setNomeTitular("HFHFREU ETLSNNAK HQBIQJRJ");
        request.setNumRg("2221326123");
        request.setRamal(null);
        request.setTelCom(null);
        request.setTelOutros(null);
        request.setTelRes("21131413172");
        request.setCodeBase("CTV");
        request.setFlStatusBi("A");

        when(snAssinanteRepository.findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBi(18285804L, "CTV", "A")).thenReturn(request);

        SnContratoDTO consult = new SnContratoDTO();

        consult.setIdAssinante(18285804L);
        consult.setCodeBase("CTV");
        consult.setFlStatusBi("A");

        SnAssinanteDTO snAssinanteDTO = snAssinanteService.findAssinante(consult);

        SnAssinanteDTO result = SnAssinanteDTO.create(request);
        Assertions.assertEquals(snAssinanteDTO, result);

    }

    @Test
    @Order(8)
    @DisplayName("Buscando assinante passando null com falha")
    void findSnAssinanteWithNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snAssinanteService.findAssinante(null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(8)
    @DisplayName("Buscando assinante passando contrato sem valor com erro")

    void findSnAssinanteWithSnContratoWithoutValueFailed() {

        SnContratoDTO request = new SnContratoDTO();
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            snAssinanteService.findAssinante(request);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(10)
    @DisplayName("Buscando assinante por documento com sucesso")
    void findAssinanteByDocumentId() throws UnprocessableEntityException, NotFoundException {
        /*
          dados de request
         */
        String cpf = "48123027222";

        ContractProspectInput contractProspectInput = new ContractProspectInput();
        contractProspectInput.setDocumentId(cpf);

        /*
        Montou um valor de resposta para a execução do metodo de buscar sn assinante por cpf
         */
        List<SnAssinante> snAssinanteList = new ArrayList<>();

        SnAssinante request = new SnAssinante();
        request.setIdAssinante(181873296L);
        request.setDtNascimento(Date.valueOf("1993-10-16"));
        request.setIdAssinante(18285804L);
        request.setCcTelCel(null);
        request.setCdSuframa(null);
        request.setCpf("48123027222");
        request.setEstrangeiro(null);
        request.setEmail("teste@descaracterizacao.com.br");
        request.setEmailDefault(0);
        request.setFax(null);
        request.setIdProfissao(53);
        request.setIdSexo(2);
        request.setIdEstadoCivil(6);
        request.setIdEcoladorade(0); //Modificar nome parametro
        request.setIdOrgaoExpedidor(0);
        request.setIdTipoPessoa(1);
        request.setNomeMae("VDYDXPV TNZRTUXL HTSDQ FBIJXT");
        request.setNomePai(null);
        request.setNomeTitular("HFHFREU ETLSNNAK HQBIQJRJ");
        request.setNumRg("2221326123");
        request.setRamal(null);
        request.setTelCom(null);
        request.setTelOutros(null);
        request.setTelRes("21131413172");
        request.setCodeBase("CTV");
        request.setFlStatusBi("A");

        snAssinanteList.add(request);
        /*
         * mocakando a respota
         */
        when(snAssinanteRepository.findAllByCpfAndFlStatusBi(cpf, "A")).thenReturn(snAssinanteList);
        List<SnAssinanteDTO> result = snAssinanteService.findAssinanteByDocumentId(contractProspectInput);

        List<SnAssinanteDTO> snAssinanteDTOList = new ArrayList<>();
        snAssinanteDTOList.add(SnAssinanteDTO.create(request));

        Assertions.assertEquals(snAssinanteDTOList, result);

    }

    @Test
    @Order(11)
    @DisplayName("Buscando assinante por documento sem valor com falha")
    void findAssinanteByDocumentIdWithNullFailed() {

        ContractProspectInput contractProspectInput = new ContractProspectInput();

        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            snAssinanteService.findAssinanteByDocumentId(contractProspectInput);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(12)
    @DisplayName("Buscando assinante por codigo da area e numero de telefone sem valor com falha")
    void findAssinanteByAreaCodeAndPhoneNumber() throws UnprocessableEntityException, NotFoundException {
        String area = "11";
        String tel = "982635865";
        ContractProspectInput contractProspectInput = new ContractProspectInput();
        contractProspectInput.setAreaCode(area);
        contractProspectInput.setPhoneNumber(tel);

        /*
        Montou um valor de resposta para a execução do metodo de buscar sn assinante por cpf
         */
        List<SnAssinante> snAssinanteList = new ArrayList<>();

        SnAssinante request = new SnAssinante();
        request.setIdAssinante(181873296L);
        request.setDtNascimento(Date.valueOf("1993-10-16"));
        request.setIdAssinante(18285804L);
        request.setCcTelCel(null);
        request.setCdSuframa(null);
        request.setCpf("48123027222");
        request.setEstrangeiro(null);
        request.setEmail("teste@descaracterizacao.com.br");
        request.setEmailDefault(0);
        request.setFax(null);
        request.setIdProfissao(53);
        request.setIdSexo(2);
        request.setIdEstadoCivil(6);
        request.setIdEcoladorade(0); //Modificar nome parametro
        request.setIdOrgaoExpedidor(0);
        request.setIdTipoPessoa(1);
        request.setNomeMae("VDYDXPV TNZRTUXL HTSDQ FBIJXT");
        request.setNomePai(null);
        request.setNomeTitular("HFHFREU ETLSNNAK HQBIQJRJ");
        request.setNumRg("2221326123");
        request.setRamal(null);
        request.setTelCom(null);
        request.setTelOutros(null);
        request.setTelRes("21131413172");
        request.setCodeBase("CTV");
        request.setFlStatusBi("A");

        snAssinanteList.add(request);
        /*
         * mocakando a respota
         */
        when(snAssinanteRepository.findAllByTelResAndFlStatusBi(area + tel, "A")).thenReturn(snAssinanteList);
        when(snAssinanteRepository.findAllByTelResAndFlStatusBi(area + tel, "A")).thenReturn(snAssinanteList);
        when(snAssinanteRepository.findAllByTelResAndFlStatusBi(area + tel, "A")).thenReturn(snAssinanteList);

        List<SnAssinanteDTO> result = snAssinanteService.findAssinanteByAreaCodeAndPhoneNumber(contractProspectInput);

        List<SnAssinanteDTO> snAssinanteDTOList = new ArrayList<>();
        snAssinanteDTOList.add(SnAssinanteDTO.create(request));

        Assertions.assertEquals(snAssinanteDTOList, result);

    }

    @Test
    @Order(13)
    @DisplayName("Buscando assinante por documento passando null com falha")
    void findAssinanteByAreaCodeAndPhoneNumberWithNullFailed() {

        ContractProspectInput contractProspectInput = new ContractProspectInput();

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snAssinanteService.findAssinanteByAreaCodeAndPhoneNumber(contractProspectInput);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(14)
    @DisplayName("Buscando cidade operadora e setando contrato com sucesso")
    void findCidadeOperadoraAndSetContract() throws UnprocessableEntityException {

        String cidContrato = "05776";
        String codeBase = "ISP";

        ContractProspectInput contractProspectInput = new ContractProspectInput();
        contractProspectInput.setCityId(cidContrato);
        contractProspectInput.setCodeBase(codeBase);

        SnCidadeOperadora request = new SnCidadeOperadora();
        request.setCidContrato("05776");
        request.setCiNome("JUNDIAI");
        request.setCodOperadora("055");
        request.setNomePessoa("CLARO - JUNDIAI");
        request.setRazaoSocial("CLARO S.A.");
        request.setIdEmpresa("000049");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnCidadeOperadoraDTO consult = SnCidadeOperadoraDTO.create(request);
        /*
         * mocakando a respota
         */
        when(snCidadeOperadoraRepository.findSnCidadeOperadoraByCidContratoAndCodeBaseAndFlStatusBi(cidContrato, codeBase, "A")).thenReturn(request);

        Contract contract = new Contract();

        SnCidadeOperadoraDTO result = snCidadeOperadoraService.findCidadeOperadoraAndSetContract(contractProspectInput, contract);


        Assertions.assertEquals(consult, result);

        Assertions.assertEquals(result.getRazaoSocial(), contract.getOrganization().getOrganizationName());
        Assertions.assertEquals(result.getNomePessoa(), contract.getOrganization().getTradingName());
        Assertions.assertEquals(result.getCodOperadora(), contract.getOrganization().getOperatorCode());
        Assertions.assertEquals(result.getCidContrato(), contract.getOrganization().getCityId());
        Assertions.assertEquals(result.getCiNome(), contract.getOrganization().getOperatorCityName());


    }

    @Test
    @Order(15)
    @DisplayName("Buscando cidade operadora e setando contrato passando null com falha")
    void findCidadeOperadoraAndSetContractWithNull() {
        ContractProspectInput contractProspectInput = null;
        Contract contract = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snCidadeOperadoraService.findCidadeOperadoraAndSetContract(contractProspectInput, contract);
        });

        Assertions.assertNotNull(thrown);
    }

    @Test
    @Order(16)
    @DisplayName("Buscando cidade operadora com sucesso")
    void findCidadeOperadora() throws UnprocessableEntityException {

        String cidContrato = "05776";
        String codeBase = "ISP";

        ContractProspectInput contractProspectInput = new ContractProspectInput();
        contractProspectInput.setCityId(cidContrato);
        contractProspectInput.setCodeBase(codeBase);

        SnCidadeOperadora request = new SnCidadeOperadora();
        request.setCidContrato("05776");
        request.setCiNome("JUNDIAI");
        request.setCodOperadora("055");
        request.setNomePessoa("CLARO - JUNDIAI");
        request.setRazaoSocial("CLARO S.A.");
        request.setIdEmpresa("000049");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnCidadeOperadoraDTO consult = SnCidadeOperadoraDTO.create(request);
        /*
         * mocakando a respota
         */
        when(snCidadeOperadoraRepository.findSnCidadeOperadoraByCidContratoAndCodeBaseAndFlStatusBi(cidContrato, codeBase, "A")).thenReturn(request);

        SnCidadeOperadoraDTO result = snCidadeOperadoraService.findCidadeOperadora(contractProspectInput);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(17)
    @DisplayName("Buscando cidade operadora sem valor com falha")
    void findCidadeOperadoraWithoutValueFailed() {

        ContractProspectInput contractProspectInput = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snCidadeOperadoraService.findCidadeOperadora(contractProspectInput);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(18)
    @DisplayName("Buscando contrato por numero do contrato e código da cidade com sucesso")
    void findContratoByCustomerAccountIdAndCityId() throws UnprocessableEntityException, NotFoundException {

        String numContrato = "256870";
        String cidContrato = "05509";
        String codeBase = "ISP";

        ContractProspectInput contractProspectInput = new ContractProspectInput();
        contractProspectInput.setCustomerAccountId(numContrato);
        contractProspectInput.setCityId(cidContrato);
        contractProspectInput.setCodeBase(codeBase);

        SnContrato request = new SnContrato();
        request.setNumContrato(181873296);
        request.setCidContrato("02121");
        request.setIdAssinante(18285804);
        request.setIdPessoaFisica("28720");
        request.setObs("Por gentileza, ligar para o cliente com 1hr de antecedência (17)981420011");
        request.setDigitoVerificacao(1);
        request.setIdTipoVenda(598);
        request.setIdTipoContrato(1);
        request.setDtVenda(Date.valueOf("2020-01-02"));
        request.setDtCancelamento(Date.valueOf("2020-01-13"));
        request.setDtCadastro(Date.valueOf("2020-01-02"));
        request.setIdRazaoCancelamento(125);
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnContratoDTO consult = SnContratoDTO.create(request);

        when(snContratoRepository.findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(Integer.valueOf(numContrato), cidContrato, codeBase, "A")).thenReturn(request);

        SnContratoDTO result = snContratoService.findContratoByCustomerAccountIdAndCityId(contractProspectInput);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(19)
    @DisplayName("Buscando contrato por numero do contrato e código da cidade passando null com falha")
    void findContratoByCustomerAccountIdAndCityIdWithNullFailed() {

        ContractProspectInput contractProspectInput = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snContratoService.findContratoByCustomerAccountIdAndCityId(contractProspectInput);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(20)
    @DisplayName("Buscando contrato por codigo do assinante com sucesso")
    void findContratoByIdAssinate() throws UnprocessableEntityException, NotFoundException {

        SnAssinanteDTO snAssinanteDTO = new SnAssinanteDTO();
        snAssinanteDTO.setIdAssinante(797819);
        snAssinanteDTO.setCodeBase("ISP");
        snAssinanteDTO.setFlStatusBi("A");


        SnContrato request = new SnContrato();
        request.setNumContrato(10056888);
        request.setCidContrato("05509");
        request.setIdAssinante(797819);
        request.setIdPessoaFisica("628512");
        request.setObs("venda feita por ana ativo local virtua standart 34,90+virtua 200l 29,90 a 4 mreses e apos 44,90+ net fone");
        request.setDigitoVerificacao(1);
        request.setIdTipoVenda(588);
        request.setIdTipoContrato(1);
        request.setDtVenda(Date.valueOf("2007-03-14"));
        request.setDtCancelamento(Date.valueOf("2016-02-20"));
        request.setDtCadastro(Date.valueOf("2007-03-14"));
        request.setIdRazaoCancelamento(1);
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnContratoDTO consult = SnContratoDTO.create(request);

        when(snContratoRepository.findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBi(snAssinanteDTO.getIdAssinante(), snAssinanteDTO.getCodeBase(),snAssinanteDTO.getFlStatusBi())).thenReturn(request);

        SnContratoDTO result = snContratoService.findContratoByIdAssinate(snAssinanteDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(21)
    @DisplayName("Buscando contrato por codigo do assinante passando null com falha")
    void findContratoByIdAssinateWithNullFailed() {

        SnAssinanteDTO snAssinanteDTO = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snContratoService.findContratoByIdAssinate(snAssinanteDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(22)
    @DisplayName("Buscando contrato por codigo do assinante sem valor com falha")
    void findContratoByIdAssinateWithoutValueFailed() {

        SnAssinanteDTO snAssinanteDTO = new SnAssinanteDTO();

        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            snContratoService.findContratoByIdAssinate(snAssinanteDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(23)
    @DisplayName("Buscando escolaridade com sucesso")
    void findEscolaridade() throws UnprocessableEntityException, NotFoundException {

        SnAssinanteDTO snAssinanteDTO = new SnAssinanteDTO();
        snAssinanteDTO.setIdEcoladorade(2);
        snAssinanteDTO.setCodeBase("ISP");
        snAssinanteDTO.setFlStatusBi("A");

        SnEscolaridade request = new SnEscolaridade();
        request.setIdEscolaridade(2);
        request.setDescricao("ENSINO MEDIO");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnEscolaridadeDTO consult = SnEscolaridadeDTO.create(request);

        when(snEscolaridadeRepository.findByIdEscolaridadeAndCodeBaseAndFlStatusBi(snAssinanteDTO.getIdEcoladorade(), snAssinanteDTO.getCodeBase(),snAssinanteDTO.getFlStatusBi())).thenReturn(request);

        SnEscolaridadeDTO result = snEscolaridadeService.findEscolaridade(snAssinanteDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(24)
    @DisplayName("Buscando escolaridade passando null com falha")
    void findEscolaridadeWithNullFailed() {

        SnAssinanteDTO snAssinanteDTO = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snEscolaridadeService.findEscolaridade(snAssinanteDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(25)
    @DisplayName("Buscando estado civil com sucesso")
    void findEstadoCivil() throws UnprocessableEntityException, NotFoundException {

        SnAssinanteDTO snAssinanteDTO = new SnAssinanteDTO();
        snAssinanteDTO.setIdEstadoCivil(6);
        snAssinanteDTO.setCodeBase("ISP");
        snAssinanteDTO.setFlStatusBi("A");

        SnEstadoCivil request = new SnEstadoCivil();
        request.setIdEstadoCivil(2);
        request.setDescricao("NAO INFORMADO");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnEstadoCivilDTO consult = SnEstadoCivilDTO.create(request);

        when(snEstadoCivilRepository.findByIdEstadoCivilAndCodeBaseAndFlStatusBi(snAssinanteDTO.getIdEstadoCivil(), snAssinanteDTO.getCodeBase(),snAssinanteDTO.getFlStatusBi())).thenReturn(request);

        SnEstadoCivilDTO result = snEstadoCivilService.findEstadoCivil(snAssinanteDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(26)
    @DisplayName("Buscando estado civil null com falha")
    void findEstadoCivilWithNullFailed() {

        SnAssinanteDTO snAssinanteDTO = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snEstadoCivilService.findEstadoCivil(snAssinanteDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(27)
    @DisplayName("Buscando orgao expedidor com sucesso")
    void findOrgaoExpedidor() throws UnprocessableEntityException, NotFoundException {

        SnAssinanteDTO snAssinanteDTO = new SnAssinanteDTO();
        snAssinanteDTO.setIdOrgaoExpedidor(1);
        snAssinanteDTO.setCodeBase("ISP");
        snAssinanteDTO.setFlStatusBi("A");

        SnOrgaoExpedidor request = new SnOrgaoExpedidor();
        request.setIdOrgaoExpedidor(1);
        request.setDescricao("SSP-SP");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnOrgaoExpedidorDTO consult = SnOrgaoExpedidorDTO.create(request);

        when(snOrgaoExpedidorRepository.findSnOrgaoExpedidorByIdOrgaoExpedidorAndCodeBaseAndFlStatusBi(snAssinanteDTO.getIdOrgaoExpedidor(), snAssinanteDTO.getCodeBase(),snAssinanteDTO.getFlStatusBi())).thenReturn(request);

        SnOrgaoExpedidorDTO result = snOrgaoExpedidorService.findOrgaoExpedidor(snAssinanteDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(28)
    @DisplayName("Buscando estado civil null com falha")
    void findOrgaoExpedidorWithNullFailed() {

        SnAssinanteDTO snAssinanteDTO = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snOrgaoExpedidorService.findOrgaoExpedidor(snAssinanteDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(29)
    @DisplayName("Buscando preposto por numero de contrato e ci contrato com sucesso")
    void findSnPrepostaByNumContratoAndCidContrato() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setNumContrato(10056888);
        snContratoDTO.setCidContrato("05509");
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnPreposto request = new SnPreposto();
        request.setIdPreposto(1);
        request.setCidContrato("05509");
        request.setNumContrato(10056888);
        request.setNomePreposto("");
        request.setRelacao("");
        request.setCdBase("ISP");
        request.setFlStatusBi("A");

        SnPrepostoDTO consult = SnPrepostoDTO.create(request);

        when(snPrepostoRepository.getFirstByNumContratoAndCidContratoAndCdBaseAndFlStatusBi(snContratoDTO.getNumContrato(), snContratoDTO.getCidContrato(), snContratoDTO.getCodeBase(),snContratoDTO.getFlStatusBi())).thenReturn(request);

        SnPrepostoDTO result = snPrepostoService.findSnPrepostaByNumContratoAndCidContrato(snContratoDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(30)
    @DisplayName("Buscando preposto por numero de contrato e ci contrato passando null com falha")
    void findSnPrepostaByNumContratoAndCidContratoWithNullFailed() {

        SnContratoDTO snContratoDTO = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snPrepostoService.findSnPrepostaByNumContratoAndCidContrato(snContratoDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(31)
    @DisplayName("Buscando profissao com sucesso")
    void findProfissao() throws UnprocessableEntityException, NotFoundException {

        SnAssinanteDTO snAssinanteDTO = new SnAssinanteDTO();
        snAssinanteDTO.setIdProfissao(51);
        snAssinanteDTO.setCodeBase("ISP");
        snAssinanteDTO.setFlStatusBi("A");

        SnProfissao request = new SnProfissao();
        request.setIdProfissao(51);
        request.setDescricao("OUTROS");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnProfissaoDTO consult = SnProfissaoDTO.create(request);

        when(snProfissaoRepository.findByIdProfissaoAndCodeBaseAndFlStatusBi(snAssinanteDTO.getIdProfissao(), snAssinanteDTO.getCodeBase(),snAssinanteDTO.getFlStatusBi())).thenReturn(request);

        SnProfissaoDTO result = snProfissaoService.findProfissao(snAssinanteDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(32)
    @DisplayName("Buscando profissao passando null com falha")
    void findProfissaoWithNullFailed() {

        SnAssinanteDTO snAssinanteDTO = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snProfissaoService.findProfissao(snAssinanteDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(33)
    @DisplayName("Buscando razao cancelamento com sucesso")
    void findRazaoCancelamento() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setIdRazaoCancelamento(1);
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnRazaoCancelamento request = new SnRazaoCancelamento();
        request.setIdRazaoCancelamento(1);
        request.setDescricao("INADIMPLENCIA");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnRazaoCancelamentoDTO consult = SnRazaoCancelamentoDTO.create(request);

        when(snRazaoCancelamentoRepository.findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBi(snContratoDTO.getIdRazaoCancelamento(), snContratoDTO.getCodeBase(),snContratoDTO.getFlStatusBi())).thenReturn(request);

        SnRazaoCancelamentoDTO result = snRazaoCancelamentoService.findRazaoCancelamento(snContratoDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(34)
    @DisplayName("Buscando razao cancelamento passando null com falha")
    void findRazaoCancelamentoWithNullFailed() {

        SnContratoDTO snContratoDTO = null;

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snRazaoCancelamentoService.findRazaoCancelamento(snContratoDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(35)
    @DisplayName("Buscando razao cancelamento e setando contrato com sucesso")
    void findRazaoCancelamentoAndSetContract() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setIdRazaoCancelamento(1);
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnRazaoCancelamento request = new SnRazaoCancelamento();
        request.setIdRazaoCancelamento(1);
        request.setDescricao("INADIMPLENCIA");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        Contract contract = new Contract();

        SnRazaoCancelamentoDTO consult = SnRazaoCancelamentoDTO.create(request);

        when(snRazaoCancelamentoRepository.findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBi(snContratoDTO.getIdRazaoCancelamento(), snContratoDTO.getCodeBase(),snContratoDTO.getFlStatusBi())).thenReturn(request);

        SnRazaoCancelamentoDTO result = snRazaoCancelamentoService.findRazaoCancelamentoAndSetContract(snContratoDTO, contract);

        Assertions.assertEquals(consult, result);
        Assertions.assertEquals(new Type(result.getIdRazaoCancelamento(), result.getDescricao()), contract.getSale().getCancellationReason().getType());

    }

    @Test
    @Order(36)
    @DisplayName("Buscando razao cancelamento setando passando null com falha")
    void findRazaoCancelamentoAndSetContractWithNullFailed() {

        SnContratoDTO snContratoDTO = null;
        Contract contract = null;
        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snRazaoCancelamentoService.findRazaoCancelamentoAndSetContract(snContratoDTO, contract);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(37)
    @DisplayName("Buscando sn rel assinante segmentacao  com sucesso")
    void findRelAssinanteSegmentacao() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setNumContrato(10315122);
        snContratoDTO.setCidContrato("05776");
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnRelAssinanteSegmentacao request = new SnRelAssinanteSegmentacao();
        request.setIdRelAssSegmentacao(190568);
        request.setIdTipoSegmento(1);
        request.setNumContrato(10315122);
        request.setCidContrato("05776");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");


        Contract contract = new Contract();

        SnRelAssinanteSegmentacaoDTO consult = SnRelAssinanteSegmentacaoDTO.create(request);

        when(snRelAssinanteSegmentacaoRepository.findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                snContratoDTO.getNumContrato(), snContratoDTO.getCidContrato(), snContratoDTO.getCodeBase(),snContratoDTO.getFlStatusBi())).thenReturn(request);

        SnRelAssinanteSegmentacaoDTO result = snRelAssinanteSegmentacaoService.findRelAssinanteSegmentacao(snContratoDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(38)
    @DisplayName("Buscando sn rel assinante segmentacao passando null com falha")
    void findRelAssinanteSegmentacaoWithNullFailed() {

        SnContratoDTO snContratoDTO = null;
        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snRelAssinanteSegmentacaoService.findRelAssinanteSegmentacao(snContratoDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(39)
    @DisplayName("Buscando sn rel status contrato com sucesso")
    void findSnRelStatusContrato() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setNumContrato(10315122);
        snContratoDTO.setCidContrato("05776");
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnStatusContrato request = new SnStatusContrato();
        request.setIdStatusContrato(1);
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");


        Contract contract = new Contract();



        when(snRelStatusContratoRepository.findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                snContratoDTO.getNumContrato(), snContratoDTO.getCidContrato(), snContratoDTO.getCodeBase(),snContratoDTO.getFlStatusBi())).thenReturn(List.of(request));

        SnStatusContrato result = snRelStatusContratoService.findSnRelStatusContrato(snContratoDTO);

        Assertions.assertEquals(request, result);

    }

    @Test
    @Order(40)
    @DisplayName("Buscando sn rel status contrato passando null com falha")
    void findSnRelStatusContratoWithNullFailed() {

        SnContratoDTO snContratoDTO = null;
        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snRelStatusContratoService.findSnRelStatusContrato(snContratoDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(41)
    @DisplayName("Buscando sn sexo com sucesso")
    void findSexo() throws UnprocessableEntityException, NotFoundException {

        SnAssinanteDTO snAssinante = new SnAssinanteDTO();
        snAssinante.setIdSexo(1);
        snAssinante.setCodeBase("ISP");
        snAssinante.setFlStatusBi("A");

        SnSexo request = new SnSexo();
        request.setIdSexo(1);
        request.setDescricao("FEMININO");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnSexoDTO consult = SnSexoDTO.create(request);

        when(snSexoRepository.findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBi(
                snAssinante.getIdSexo(), snAssinante.getCodeBase(),snAssinante.getFlStatusBi())).thenReturn(request);

        SnSexoDTO result = snSexoService.findSexo(snAssinante);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(42)
    @DisplayName("Buscando sn sexo passando null com falha")
    void findSexoWithNullFailed() {

        SnAssinanteDTO snAssinanteDTO = null;
        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snSexoService.findSexo(snAssinanteDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(43)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findStatusContrato() throws UnprocessableEntityException, NotFoundException {

        SnRelStatusContratoDTO snRelStatusContratoDTO = new SnRelStatusContratoDTO();
        snRelStatusContratoDTO.setIdStatus(35);
        snRelStatusContratoDTO.setCodeBase("ISP");
        snRelStatusContratoDTO.setFlStatusBi("A");

        SnStatusContrato request = new SnStatusContrato();
        request.setIdStatusContrato(35);
        request.setDescricao("CONECTADO(DESABILITADO PARCIAL)");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnStatusContratoDTO consult = SnStatusContratoDTO.create(request);

        when(snStatusContratoRepository.findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi(
                snRelStatusContratoDTO.getIdStatus(), snRelStatusContratoDTO.getCodeBase(),snRelStatusContratoDTO.getFlStatusBi())).thenReturn(request);

        SnStatusContratoDTO result = snStatusContratoService.findStatusContrato(snRelStatusContratoDTO);

        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(44)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findStatusContratoNullFailed() {

        SnRelStatusContratoDTO snRelStatusContratoDTO = null;
        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snStatusContratoService.findStatusContrato(snRelStatusContratoDTO);
        });

        Assertions.assertNotNull(thrown);

    }

    /*@Test
    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findStatusContratoAndSetContract() throws UnprocessableEntityException, NotFoundException {

        SnStatusContrato snStatusContrato = new SnStatusContrato();
        snStatusContrato.setIdStatusContrato(35);
        snStatusContrato.setCodeBase("ISP");
        snStatusContrato.setFlStatusBi("A");

        SnStatusContrato request = new SnStatusContrato();
        request.setIdStatusContrato(35);
        request.setDescricao("CONECTADO(DESABILITADO PARCIAL)");
        request.setCodeBase("ISP");
        request.setFlStatusBi("A");

        SnStatusContratoDTO consult = SnStatusContratoDTO.create(request);
        Contract contract = new Contract();

        when(snStatusContratoRepository.findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi(
                snStatusContrato.getIdStatusContrato(), snStatusContrato.getCodeBase(),snStatusContrato.getFlStatusBi())).thenReturn(request);

        snStatusContratoService.setContractStatus(snStatusContrato, contract);

        Status status = new Status(contract.getStatus().getId(),contract.getStatus().getDescription());

        Assertions.assertEquals(status, contract.getPartner().getStatus());

    }*/

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findSexoNullFailed() {

        Contract contract = new Contract();

        SnStatusContrato snStatusContrato = null;
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            snStatusContratoService.setContractStatus(snStatusContrato, contract);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(44)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findStatusContratoAndSetContractNullFailed() {

        Contract contract = new Contract();

        SnStatusContrato snStatusContratoDTO = null;
        RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
            snStatusContratoService.setContractStatus(snStatusContratoDTO, contract);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findTelephones() throws UnprocessableEntityException, NotFoundException {

        SnAssinanteDTO snAssinanteDTO = new SnAssinanteDTO();
        snAssinanteDTO.setCodeBase("ISP");
        snAssinanteDTO.setFlStatusBi("A");

        ContractProspectInput contractProspectInput = new ContractProspectInput();
        contractProspectInput.setCustomerAccountId("10451735");
        contractProspectInput.setCityId("05776");

        List<SnTelefoneVoip> request =  new ArrayList<>();
        request.add(new SnTelefoneVoip("11","24493276",Date.valueOf("1991-10-31"),Date.valueOf("1991-10-31"),null,null,null,null,null));

        when(snTelefoneVoipRepository.findByCidContratoAndNumContratoAndCodeBaseAndFlStatusBi(
                contractProspectInput.getCityId(), Integer.valueOf(contractProspectInput.getCustomerAccountId()),
                snAssinanteDTO.getCodeBase(),snAssinanteDTO.getFlStatusBi(),ContractProspectServiceConstansts.DEFAULT_DATA_FIM)).thenReturn(request);

        List<Telephones> result = snTelefoneVoipService.findTelephones(snAssinanteDTO, contractProspectInput);

        Assertions.assertNotNull(result);

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findTelephonesNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snTelefoneVoipService.findTelephones(null,null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findTipoContrato() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setIdTipoContrato(1);
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnTipoContrato request = new SnTipoContrato();
        request.setIdTipoContrato(snContratoDTO.getIdTipoContrato());
        request.setDescricao("INDIVIDUAL");
        request.setCodeBase(snContratoDTO.getCodeBase());
        request.setFlStatusBi(snContratoDTO.getFlStatusBi());

        SnTipoContratoDTO consult = SnTipoContratoDTO.create(request);

        when(snTipoContratoRepository.findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBi(
                snContratoDTO.getIdTipoContrato(), snContratoDTO.getCodeBase(),snContratoDTO.getFlStatusBi())).thenReturn(request);

        SnTipoContratoDTO result = snTipoContratoService.findTipoContrato(snContratoDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findTipoContratoAndSetContract() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setIdTipoContrato(1);
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnTipoContrato request = new SnTipoContrato();
        request.setIdTipoContrato(snContratoDTO.getIdTipoContrato());
        request.setDescricao("INDIVIDUAL");
        request.setCodeBase(snContratoDTO.getCodeBase());
        request.setFlStatusBi(snContratoDTO.getFlStatusBi());

        SnTipoContratoDTO consult = SnTipoContratoDTO.create(request);

        when(snTipoContratoRepository.findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBi(
                snContratoDTO.getIdTipoContrato(), snContratoDTO.getCodeBase(),snContratoDTO.getFlStatusBi())).thenReturn(request);

        Contract contract = new Contract();

        SnTipoContratoDTO result = snTipoContratoService.findTipoContratoAndSetContract(snContratoDTO, contract);

        Type type = new Type(consult.getIdTipoContrato(), consult.getDescricao());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);
        Assertions.assertEquals(type, contract.getType());

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findTipoContratoNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snTipoContratoService.findTipoContrato(null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findTipoContratoAndSetContractNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snTipoContratoService.findTipoContratoAndSetContract(null, null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findTipoSegmento() throws UnprocessableEntityException, NotFoundException {

        SnRelAssinanteSegmentacaoDTO snRelAssinanteSegmentacaoDTO = new SnRelAssinanteSegmentacaoDTO();
        snRelAssinanteSegmentacaoDTO.setIdRelAssSegmentacao(11);
        snRelAssinanteSegmentacaoDTO.setCodeBase("ISP");
        snRelAssinanteSegmentacaoDTO.setFlStatusBi("A");

        SnTipoSegmento request = new SnTipoSegmento();
        request.setIdTipoSegmento(snRelAssinanteSegmentacaoDTO.getIdTipoSegmento());
        request.setDescricao("BSOD");
        request.setCodeBase(snRelAssinanteSegmentacaoDTO.getCodeBase());
        request.setFlStatusBi(snRelAssinanteSegmentacaoDTO.getFlStatusBi());

        SnTipoSegmentoDTO consult = SnTipoSegmentoDTO.create(request);

        when(snTipoSegmentoRepository.findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBi(
                snRelAssinanteSegmentacaoDTO.getIdTipoSegmento(), snRelAssinanteSegmentacaoDTO.getCodeBase(),
                snRelAssinanteSegmentacaoDTO.getFlStatusBi())).thenReturn(request);

        Contract contract = new Contract();

        SnTipoSegmentoDTO result = snTipoSegmentoService.findTipoSegmento(snRelAssinanteSegmentacaoDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findTipoSegmentoNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snTipoSegmentoService.findTipoSegmento(null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findTipoSegmentoAndSetContract() throws UnprocessableEntityException, NotFoundException {

        SnRelAssinanteSegmentacaoDTO snRelAssinanteSegmentacaoDTO = new SnRelAssinanteSegmentacaoDTO();
        snRelAssinanteSegmentacaoDTO.setIdRelAssSegmentacao(11);
        snRelAssinanteSegmentacaoDTO.setCodeBase("ISP");
        snRelAssinanteSegmentacaoDTO.setFlStatusBi("A");

        SnTipoSegmento request = new SnTipoSegmento();
        request.setIdTipoSegmento(snRelAssinanteSegmentacaoDTO.getIdTipoSegmento());
        request.setDescricao("BSOD");
        request.setCodeBase(snRelAssinanteSegmentacaoDTO.getCodeBase());
        request.setFlStatusBi(snRelAssinanteSegmentacaoDTO.getFlStatusBi());

        SnTipoSegmentoDTO consult = SnTipoSegmentoDTO.create(request);

        when(snTipoSegmentoRepository.findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBi(
                snRelAssinanteSegmentacaoDTO.getIdTipoSegmento(), snRelAssinanteSegmentacaoDTO.getCodeBase(),
                snRelAssinanteSegmentacaoDTO.getFlStatusBi())).thenReturn(request);

        Contract contract = new Contract();

        SnTipoSegmentoDTO result = snTipoSegmentoService.findTipoSegmentoAndSetContract(snRelAssinanteSegmentacaoDTO, contract);

        Segment segment = new Segment(consult.getIdTipoSegmento(), contract.getType().getDescription());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);
        Assertions.assertEquals(segment, contract.getSegment());
        Assertions.assertEquals(consult.getDescricao(), contract.getCustomerSegmentType());

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findTipoSegmentoAndSetContractNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snTipoSegmentoService.findTipoSegmentoAndSetContract(null, null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findTipoVenda() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setIdTipoContrato(75);
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnTipoVenda request = new SnTipoVenda();
        request.setIdTipoVenda(75);
        request.setDescricao("TERC- TLVENDAS NACIONAL (0800)");
        request.setCodeBase(snContratoDTO.getCodeBase());
        request.setFlStatusBi(snContratoDTO.getFlStatusBi());

        SnTipoVendaDTO consult = SnTipoVendaDTO.create(request);

        when(snTipoVendaRepository.findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBi(
                snContratoDTO.getIdTipoVenda(), snContratoDTO.getCodeBase(),
                snContratoDTO.getFlStatusBi())).thenReturn(request);

        SnTipoVendaDTO result = snTipoVendaService.findTipoVenda(snContratoDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findTipoVendaNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snTipoVendaService.findTipoVenda(null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findTipoVendaAndSetContract() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO = new SnContratoDTO();
        snContratoDTO.setIdTipoContrato(75);
        snContratoDTO.setCodeBase("ISP");
        snContratoDTO.setFlStatusBi("A");

        SnTipoVenda request = new SnTipoVenda();
        request.setIdTipoVenda(75);
        request.setDescricao("TERC- TLVENDAS NACIONAL (0800)");
        request.setCodeBase(snContratoDTO.getCodeBase());
        request.setFlStatusBi(snContratoDTO.getFlStatusBi());

        SnTipoVendaDTO consult = SnTipoVendaDTO.create(request);

        when(snTipoVendaRepository.findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBi(
                snContratoDTO.getIdTipoVenda(), snContratoDTO.getCodeBase(),
                snContratoDTO.getFlStatusBi())).thenReturn(request);

        Contract contract = new Contract();

        SnTipoVendaDTO result = snTipoVendaService.findTipoVendaAndSetContract(snContratoDTO,contract);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findTipoVendaAndSetContractNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            snTipoVendaService.findTipoVendaAndSetContract(null, null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findVsnVendedor() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO =  new SnContratoDTO();
        SnCidadeOperadoraDTO snCidadeOperadoraDTO = new SnCidadeOperadoraDTO();


        RhPessoa request = new RhPessoa();
        request.setIdPessoa("005233");
        request.setCodTipoPessoa("F");
        request.setNomePessoa("RODRIGO CARVALHO DE SOUZA");
        request.setCodeBase(snContratoDTO.getCodeBase());
        request.setFlStatusBi(snContratoDTO.getFlStatusBi());

        when(rhPessoaRepository.findRhPessoaByIdPessoaAndCodeBaseAndFlStatusBi(
                snContratoDTO.getIdPessoaFisica(), snContratoDTO.getCodeBase(),
                snContratoDTO.getFlStatusBi())).thenReturn(request);

        RhPessoaPessoa request2 = new RhPessoaPessoa();
        request2.setIdPessoaBase("000154");
        request2.setIdPessoa("001310");
        request2.setIdTipoRelacao(2);
        request2.setIdStatus(0);
        request2.setCodeBase(snContratoDTO.getCodeBase());
        request2.setFlStatusBi(snContratoDTO.getFlStatusBi());

        when(rhPessoaPessoaRepositry.findRhPessoaPessoaByIdPessoaAndIdPessoaBaseAndIdTipoRelacaoAndIdStatusAndCodeBaseAndFlStatusBi(
                request.getIdPessoa(), request.getIdPessoa(), 10, 1,snContratoDTO.getCodeBase(),
                snContratoDTO.getFlStatusBi())).thenReturn(request2);


        Contract contract = new Contract();

        VsnVendedoresDTO result = vsnVendedoresService.findVsnVendedor(snContratoDTO, snCidadeOperadoraDTO);

        Assertions.assertNotNull(result);

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findVsnVendedorNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            vsnVendedoresService.findVsnVendedor(null, null);
        });

        Assertions.assertNotNull(thrown);

    }

    @Order(45)
    @DisplayName("Buscando sn status contrato e setando contrato com sucesso")
    void findVsnVendedorAndSetContract() throws UnprocessableEntityException, NotFoundException {

        SnContratoDTO snContratoDTO =  new SnContratoDTO();
        SnCidadeOperadoraDTO snCidadeOperadoraDTO = new SnCidadeOperadoraDTO();


        RhPessoa request = new RhPessoa();
        request.setIdPessoa("005233");
        request.setCodTipoPessoa("F");
        request.setNomePessoa("RODRIGO CARVALHO DE SOUZA");
        request.setCodeBase(snContratoDTO.getCodeBase());
        request.setFlStatusBi(snContratoDTO.getFlStatusBi());

        when(rhPessoaRepository.findRhPessoaByIdPessoaAndCodeBaseAndFlStatusBi(
                snContratoDTO.getIdPessoaFisica(), snContratoDTO.getCodeBase(),
                snContratoDTO.getFlStatusBi())).thenReturn(request);

        RhPessoaPessoa request2 = new RhPessoaPessoa();
        request2.setIdPessoaBase("000154");
        request2.setIdPessoa("001310");
        request2.setIdTipoRelacao(2);
        request2.setIdStatus(0);
        request2.setCodeBase(snContratoDTO.getCodeBase());
        request2.setFlStatusBi(snContratoDTO.getFlStatusBi());

        when(rhPessoaPessoaRepositry.findRhPessoaPessoaByIdPessoaAndIdPessoaBaseAndIdTipoRelacaoAndIdStatusAndCodeBaseAndFlStatusBi(
                request.getIdPessoa(), request.getIdPessoa(), 10, 1,snContratoDTO.getCodeBase(),
                snContratoDTO.getFlStatusBi())).thenReturn(request2);


        Contract contract = new Contract();

        VsnVendedoresDTO result = vsnVendedoresService.findVsnVendedorAndSetContract(snContratoDTO, snCidadeOperadoraDTO, new Contract());

        Assertions.assertNotNull(result);

    }

    @Test
    @Order(46)
    @DisplayName("Buscando sn rel assinante segmentacao setando passando null com falha")
    void findVsnVendedorAndSetContractNullFailed() {

        UnprocessableEntityException thrown = Assertions.assertThrows(UnprocessableEntityException.class, () -> {
            vsnVendedoresService.findVsnVendedorAndSetContract(null, null, null);
        });

        Assertions.assertNotNull(thrown);

    }

}
