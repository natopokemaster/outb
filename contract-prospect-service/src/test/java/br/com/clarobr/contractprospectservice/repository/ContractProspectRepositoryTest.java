package br.com.clarobr.contractprospectservice.repository;

import br.com.clarobr.contractprospectservice.constants.ContractProspectServiceConstansts;
import br.com.clarobr.contractprospectservice.models.SnRelStatusContrato;
import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import br.com.clarobr.contractprospectservice.models.SnTipoSegmento;
import br.com.clarobr.contractprospectservice.models.dto.RhPessoaDTO;
import br.com.clarobr.contractprospectservice.models.dto.RhPessoaJuridicaDTO;
import br.com.clarobr.contractprospectservice.models.dto.RhPessoaPessoaDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnAssinanteDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnCidadeOperadoraDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnEscolaridadeDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnEstadoCivilDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnOrgaoExpedidorDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnProfissaoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRazaoCancelamentoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelAssinanteSegmentacaoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnSexoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnStatusContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTelefoneVoipDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoContratoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoSegmentoDTO;
import br.com.clarobr.contractprospectservice.models.dto.SnTipoVendaDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Alan Ricardo
 */

@TestPropertySource(properties = "classpath:application-test.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings("All")
class ContractProspectRepositoryTest {

    @Autowired
    private RhPessoaJuridicaRepository rhPessoaJuridicaRepository;

    @Autowired
    private RhPessoaPessoaRepository rhPessoaPessoaRepository;

    @Autowired
    private RhPessoaRepository rhPessoaRepository;

    @Autowired
    private SnAssinanteRepository snAssinanteRepository;

    @Autowired
    private SnCidadeOperadoraRepository snCidadeOperadoraRepository;

    @Autowired
    private SnContratoRepository snContratoRepository;

    @Autowired
    private SnEscolaridadeRepository snEscolaridadeRepository;

    @Autowired
    private SnEstadoCivilRepository snEstadoCivilRepository;

    @Autowired
    private SnOrgaoExpedidorRepository snOrgaoExpedidorRepository;

    @Autowired
    private SnProfissaoRepository snProfissaoRepository;

    @Autowired
    private SnRazaoCancelamentoRepository snRazaoCancelamentoRepository;

    @Autowired
    private SnRelAssinanteSegmentacaoRepository snRelAssinanteSegmentacaoRepository;

    @Autowired
    @MockBean
    private SnRelStatusContratoRepository snRelStatusContratoRepository;

    @Autowired
    private SnSexoRepository snSexoRepository;

    @Autowired
    @MockBean
    private SnStatusContratoRepository snStatusContratoRepository;

    @Autowired
    private SnTelefoneVoipRepository snTelefoneVoipRepository;

    @Autowired
    private SnTipoContratoRepository snTipoContratoRepository;

    @Autowired
    private SnTipoSegmentoRepository snTipoSegmentoRepository;

    @Autowired
    private SnTipoVendaRepository snTipoVendaRepository;

    @Test
    @Order(1)
    @DisplayName("Buscando dados da tabela pessoa juridica com sucesso")
    void findRhPessoaJuridica() {

        /**
         *  request de entrada
         */
        String idEmpresa = "002121";
        String codeBase = "CTV";
        String flStatusBi = "A";

        /**
         * Execução do método
         */
        RhPessoaJuridicaDTO result = RhPessoaJuridicaDTO.create(
                rhPessoaJuridicaRepository.findRhPessoaJuridicaByIdEmpresaAndCodeBaseAndFlStatusBi(idEmpresa, codeBase, flStatusBi));

        /**
         * Mock do response da execução
         */
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
    @DisplayName("Buscando dados da tabela pessoa juridica sem string com falha" )
    void findRhPessoaJuridicaWithouString() {

        String idEmpresa = "";
        String codeBase = "";
        String flStatusBi = "";

        RhPessoaJuridicaDTO result = RhPessoaJuridicaDTO.create(
                rhPessoaJuridicaRepository.findRhPessoaJuridicaByIdEmpresaAndCodeBaseAndFlStatusBi(idEmpresa, codeBase, flStatusBi));

        RhPessoaJuridicaDTO consult = new RhPessoaJuridicaDTO();
        consult.setIdEmpresa("002121");
        consult.setInscricaoEstadual("78387548");
        consult.setCgc("9132659000176");
        consult.setCodeBase("CTV");
        consult.setFlStatusBi("A");
        Assertions.assertNotEquals(consult, result);
    }

    @Test
    @Order(3)
    @DisplayName("Buscando dados da tabela pessoa juridica passando null falha")
    void findRhPessoaJuridicaWithNullFailed() {

        String idEmpresa = null;
        String codeBase = null;
        String flStatusBi = null;

        RhPessoaJuridicaDTO result = RhPessoaJuridicaDTO.create(
                rhPessoaJuridicaRepository.findRhPessoaJuridicaByIdEmpresaAndCodeBaseAndFlStatusBi(idEmpresa, codeBase, flStatusBi));

        RhPessoaJuridicaDTO consult = new RhPessoaJuridicaDTO();
        consult.setIdEmpresa("002121");
        consult.setInscricaoEstadual("78387548");
        consult.setCgc("9132659000176");
        consult.setCodeBase("CTV");
        consult.setFlStatusBi("A");
        Assertions.assertNotEquals(consult, result);
    }

    /**
     * Adicionar massa de teste quando adicionarem a tabela em ODS
     */
    @Test
    @Order(4)
    @DisplayName("Buscando dados da tabela pessoa pessoa passando valores sucesso")
    void findRhPessoaPessoa() {


        String idPessoa = "000045";
        String idPessoaBase = "000049";
        Integer tipoRelacao = 6;
        Integer idStatus = 0;
        String codeBase = "ISP";
        String flStatusBi = "A";
        RhPessoaPessoaDTO result =
                RhPessoaPessoaDTO.create(rhPessoaPessoaRepository.findRhPessoaPessoaByIdPessoaAndIdPessoaBaseAndIdTipoRelacaoAndIdStatusAndCodeBaseAndFlStatusBi(
                        idPessoa, idPessoaBase, tipoRelacao, idStatus, codeBase, flStatusBi));

        RhPessoaPessoaDTO consult = new RhPessoaPessoaDTO("000049","000045",6,0,"ISP","A");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);
    }
    @Order(5)
    @DisplayName("Buscando dados da tabela pessoa pessoa passando valores vazios falha")
    @Test
    void findRhPessoaPessoaWithoutValue() {


        String idPessoa = "";
        String idPessoaBase = "";
        Integer tipoRelacao = 0;
        Integer idStatus = 0;
        String codeBase = "";
        String flStatusBi = "";
        RhPessoaPessoaDTO result =
                RhPessoaPessoaDTO.create(rhPessoaPessoaRepository.findRhPessoaPessoaByIdPessoaAndIdPessoaBaseAndIdTipoRelacaoAndIdStatusAndCodeBaseAndFlStatusBi(
                        idPessoa, idPessoaBase, tipoRelacao, idStatus, codeBase, flStatusBi));


        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdPessoa());
    }

    @Order(6)
    @DisplayName("Buscando dados da tabela pessoa pessoa passando valores nulos falha")
    void findRhPessoaPessoaSendNull(){
        String idPessoa = null;
        String idPessoaBase = null;
        Integer tipoRelacao = null;
        Integer idStatus = null;
        String codeBase = null;
        String flStatusBi = null;
        RhPessoaPessoaDTO result =
                RhPessoaPessoaDTO.create(rhPessoaPessoaRepository.findRhPessoaPessoaByIdPessoaAndIdPessoaBaseAndIdTipoRelacaoAndIdStatusAndCodeBaseAndFlStatusBi(
                        idPessoa, idPessoaBase, tipoRelacao, idStatus, codeBase, flStatusBi));


        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdPessoa());
    }

    @Order(7)
    @DisplayName("Buscando dados da tabela pessoa com sucesso")
    void findRhPessoaByIdPessoa(){
        String idPessoa = "005233";
        String codeBase = "ISP";
        String flStatusBi = "A";
        RhPessoaDTO result = RhPessoaDTO.create(rhPessoaRepository.findRhPessoaByIdPessoaAndCodeBaseAndFlStatusBi(idPessoa,codeBase, flStatusBi));

        RhPessoaDTO consult = new RhPessoaDTO();
        consult.setIdPessoa("005843");
        consult.setCodTipoPessoa("J");
        consult.setNomePessoa("CLARO - ILHEUS");
        consult.setEmail("mauricio.assumpcao@netservicos.com.br");
        consult.setCodeBase("ISP");
        consult.setFlStatusBi("A");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result,consult);
    }

    @Order(8)
    @DisplayName("Buscando dadps da tabela pessoa passando strings vazias, falha")
    @Test
    void findRhPessoaByIdPessoaWithEmptyString() {

        String idPessoa = "";
        String codeBase = "";
        String flStatusBi = "";

        RhPessoaDTO result = RhPessoaDTO.create(rhPessoaRepository.findRhPessoaByIdPessoaAndCodeBaseAndFlStatusBi(idPessoa,codeBase, flStatusBi));

        RhPessoaDTO consult = new RhPessoaDTO();
        consult.setIdPessoa("005843");
        consult.setCodTipoPessoa("J");
        consult.setNomePessoa("CLARO - ILHEUS");
        consult.setEmail("mauricio.assumpcao@netservicos.com.br");
        consult.setCodeBase("ISP");
        consult.setFlStatusBi("A");

        Assertions.assertNotEquals(consult, result);
    }

    @Order(9)
    @DisplayName("Buscando dadps da tabela pessoa passando strings nulas, falha")
    @Test
    void findRhPessoaByIdPessoaWithNullString() {

        String idPessoa = null;
        String codeBase = null;
        String flStatusBi = null;

        RhPessoaDTO result = RhPessoaDTO.create(rhPessoaRepository.findRhPessoaByIdPessoaAndCodeBaseAndFlStatusBi(idPessoa,codeBase, flStatusBi));

        RhPessoaDTO consult = new RhPessoaDTO();
        consult.setIdPessoa("005843");
        consult.setCodTipoPessoa("J");
        consult.setNomePessoa("CLARO - ILHEUS");
        consult.setEmail("mauricio.assumpcao@netservicos.com.br");
        consult.setCodeBase("ISP");
        consult.setFlStatusBi("A");

        Assertions.assertNotEquals(consult,result);
    }

    @Order(10)
    @DisplayName("Buscando dados da tabela sn assiante pelo celular e fl status bi Pessoa Fisica")
    @Test
    void findAllByCcTelCelAndFlStatusBiPhysicalPerson() {

        /**
         * Pessoa fisica
         */
        String tel = "79242475120";
        String flStatusBi = "A";

        List<SnAssinanteDTO> snAssinanteDTO =
                snAssinanteRepository.findAllByCcTelCelAndFlStatusBi(tel, flStatusBi)
                        .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());


        Assertions.assertNotNull(snAssinanteDTO);
        // Assertions.assertEquals("27131241x", snAssinanteDTO.get(0).getNumRg());
    }

    @Order(11)
    @DisplayName("Buscando dados da tabela sn assiante pelo celular e fl status bi pessoa Juridica")
    @Test
    void findAllByCcTelCelAndFlStatusBiPhysicalPersonLegalPerson() {

        /**
         * Pessoa juridica
         */
        String tel = "92633036390";
        String flStatusBi = "A";

        List<SnAssinanteDTO> snAssinanteDTO =
                snAssinanteRepository.findAllByCcTelCelAndFlStatusBi(tel, flStatusBi)
                        .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());


        Assertions.assertNotNull(snAssinanteDTO);
        // Assertions.assertEquals("ISENTO", snAssinanteDTO.get(0).getNumRg());
    }

    @Order(12)
    @DisplayName("Buscando dados da tabela sn assiante pelo celular e fl status bi passando string sem valor, falha")
    @Test
    void findAllByCcTelCelAndFlStatusBiWithStringWithoutValues() {

        String tel = "";
        String flStatusBi = "";

        List<SnAssinanteDTO> snAssinanteDTO =
                snAssinanteRepository.findAllByCcTelCelAndFlStatusBi(tel, flStatusBi)
                        .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());


        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertEquals(0, snAssinanteDTO.size());
    }

    @Order(13)
    @DisplayName("Buscando dados da tabela sn assiante pelo celular e fl status bi passando null, falha")
    @Test
    void findAllByCcTelCelAndFlStatusBiWithNullValues() {

        String tel = null;
        String flStatusBi = null;

        List<SnAssinanteDTO> snAssinanteDTO =
                snAssinanteRepository.findAllByCcTelCelAndFlStatusBi(tel, flStatusBi)
                        .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());


        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertEquals(0, snAssinanteDTO.size());
    }

    @Order(14)
    @DisplayName("Buscando dados da tabela sn assiante pelo id assinante e fl status bi pessoa fisica")
    @Test
    void findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBiPhysicalPerson() {

        Long idAssinante = 5760162L;
        String codeBase = "ISP";
        String flStatusBi = "A";

        SnAssinanteDTO snAssinanteDTO = SnAssinanteDTO.create(
                snAssinanteRepository.findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBi(idAssinante, codeBase, flStatusBi));

        Assertions.assertNotNull(snAssinanteDTO);
        // Assertions.assertEquals(idAssinante, Long.valueOf(snAssinanteDTO.getIdAssinante()));
        // Assertions.assertEquals("27131241x", snAssinanteDTO.getNumRg());
    }
    @Order(15)
    @DisplayName("Buscando dados da tabela sn assiante pelo id assinante e fl status bi pessoa juridica")
    @Test
    void findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBiLegalPerson() {

        Long idAssinante = 5818627L;
        String codeBase = "ISP";
        String flStatusBi = "A";

        SnAssinanteDTO snAssinanteDTO = SnAssinanteDTO.create(
                snAssinanteRepository.findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBi(idAssinante, codeBase, flStatusBi));

        Assertions.assertNotNull(snAssinanteDTO);
        // Assertions.assertEquals(idAssinante, Long.valueOf(snAssinanteDTO.getIdAssinante()));
        // Assertions.assertEquals("ISENTO", snAssinanteDTO.getNumRg());
    }

    @Order(16)
    @DisplayName("Buscando dados da tabela sn assiante pelo id assinante e fl status bi passando string sem valor, falha")
    @Test
    void findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBiWithoutValues() {

        Long idAssinante = 0L;
        String codeBase = "";
        String flStatusBi = "";

        SnAssinanteDTO snAssinanteDTO = SnAssinanteDTO.create(
                snAssinanteRepository.findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBi(idAssinante, codeBase, flStatusBi));

        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertNull(snAssinanteDTO.getIdAssinante());
    }

    @Order(17)
    @DisplayName("Buscando dados da tabela sn assiante pelo id assinante e fl status bi passando null, falha")
    @Test
    void findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBiWithNullValues() {

        Long idAssinante = null;
        String codeBase = null;
        String flStatusBi = null;

        SnAssinanteDTO snAssinanteDTO = SnAssinanteDTO.create(
                snAssinanteRepository.findSnAssinanteByIdAssinanteAndCodeBaseAndFlStatusBi(idAssinante, codeBase, flStatusBi));

        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertNull(snAssinanteDTO.getIdAssinante());
    }

    @Order(18)
    @DisplayName("Buscando dados da tabela sn assiante pelo cpf e fl status bi pessoa fisica")
    @Test
    void findAllByCpfAndFlStatusBiPhysicalPerson() {

        String documentId = "41573100200";
        String flStatusBi = "A";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByCpfAndFlStatusBi(documentId, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
       // Assertions.assertEquals(documentId, snAssinanteDTO.get(0).getCpf());
       // Assertions.assertEquals("27131241x", snAssinanteDTO.get(0).getNumRg());
    }

    @Order(19)
    @DisplayName("Buscando dados da tabela sn assiante pelo cpf e fl status bi pessoa juridica")
    @Test
    void findAllByCpfAndFlStatusBiLegalPerson() {

        String documentId = "596321118967172";
        String flStatusBi = "A";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByCpfAndFlStatusBi(documentId, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
       // Assertions.assertEquals(documentId, snAssinanteDTO.get(0).getCpf());
       // Assertions.assertEquals("ISENTO", snAssinanteDTO.get(0).getNumRg());
    }

    @Order(20)
    @DisplayName("Buscando dados da tabela sn assiante pelo cpf e fl status bi passando string sem valor, falha")
    @Test
    void findAllByCpfAndFlStatusBiWithoutValues() {

        String documentId = "";
        String flStatusBi = "";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByCpfAndFlStatusBi(documentId, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertEquals(0, snAssinanteDTO.size());
    }

    @Order(21)
    @DisplayName("Buscando dados da tabela sn assiante pelo cpf e fl status bi passando null, falha")
    @Test
    void findAllByCpfAndFlStatusBiWithNullValues() {

        String documentId = null;
        String flStatusBi = null;

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByCpfAndFlStatusBi(documentId, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertEquals(0, snAssinanteDTO.size());
    }

    @Order(22)
    @DisplayName("Buscando dados da tabela sn assiante pelo tel res e fl status bi pessoa fisica")
    @Test
    void findAllByTelResAndFlStatusBiPhysicalPerson() {

        String tel = "";
        String flStatusBi = "A";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByTelResAndFlStatusBi(tel, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
       // Assertions.assertEquals(tel, snAssinanteDTO.get(0).getTelRes());
       // Assertions.assertEquals("27131241x", snAssinanteDTO.get(0).getNumRg());
    }

    @Order(23)
    @DisplayName("Buscando dados da tabela sn assiante pelo tel res e fl status bi pessoa juridica")
    @Test
    void findAllByTelResAndFlStatusBiLegalPerson() {

        String tel = "";
        String flStatusBi = "A";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByTelResAndFlStatusBi(tel, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
      //  Assertions.assertEquals(tel, snAssinanteDTO.get(0).getTelRes());
      //  Assertions.assertEquals("ISENTO", snAssinanteDTO.get(0).getNumRg());
    }

    @Order(24)
    @DisplayName("Buscando dados da tabela sn assiante pelo tel res e fl status bi passando string sem valor, falha")
    @Test
    void findAllByTelResAndFlStatusBiWithoutValues() {

        String tel = "";
        String flStatusBi = "";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByTelResAndFlStatusBi(tel, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertEquals(0, snAssinanteDTO.size());
    }

    @Order(25)
    @DisplayName("Buscando dados da tabela sn assiante pelo tel res e fl status bi passando null, falha")
    @Test
    void findAllByTelResAndFlStatusBiWithNullValues() {

        String tel = null;
        String flStatusBi = null;

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByTelResAndFlStatusBi(tel, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertEquals(0, snAssinanteDTO.size());
    }

    @Order(26)
    @DisplayName("Buscando dados da tabela sn assiante pelo tel com e fl status bi pessoa fisica")
    @Test
    void findAllByTelComAndFlStatusBiPhysicalPerson() {

        String tel = "";
        String flStatusBi = "A";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByTelComAndFlStatusBi(tel, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
     //   Assertions.assertEquals(tel, snAssinanteDTO.get(0).getTelRes());
     //   Assertions.assertEquals("27131241x", snAssinanteDTO.get(0).getNumRg());
    }

    @Order(27)
    @DisplayName("Buscando dados da tabela sn assiante pelo tel com e fl status bi pessoa juridica")
    @Test
    void findAllByTelComAndFlStatusBiLegalPerson() {

        String tel = "";
        String flStatusBi = "A";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByTelComAndFlStatusBi(tel, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
    //    Assertions.assertEquals(tel, snAssinanteDTO.get(0).getTelRes());
    //    Assertions.assertEquals("ISENTO", snAssinanteDTO.get(0).getNumRg());
    }

    @Order(28)
    @DisplayName("Buscando dados da tabela sn assiante pelo tel com e fl status bi passando string sem valor, falha")
    @Test
    void findAllByTelComAndFlStatusBiWithoutValues() {

        String tel = "";
        String flStatusBi = "";

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByTelComAndFlStatusBi(tel, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertEquals(0, snAssinanteDTO.size());
    }

    @Order(29)
    @DisplayName("Buscando dados da tabela sn assiante pelo tel com e fl status bi passando null, falha")
    @Test
    void findAllByTelComAndFlStatusBiWithNullValues() {

        String tel = null;
        String flStatusBi = null;

        List<SnAssinanteDTO> snAssinanteDTO = snAssinanteRepository.findAllByTelComAndFlStatusBi(tel, flStatusBi)
                .stream().map(SnAssinanteDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(snAssinanteDTO);
        Assertions.assertEquals(0, snAssinanteDTO.size());
    }

    @Order(30)
    @DisplayName("Buscando dados da tabela sn_cidade_operadora pelo city id, code base e fl status bi")
    @Test
    void findSnCidadeOperadora() {

        String cityCode = "05776";
        String codeBase = "ISP";
        String flStatusBi = "A";

        SnCidadeOperadoraDTO result = SnCidadeOperadoraDTO.create(snCidadeOperadoraRepository.findSnCidadeOperadoraByCidContratoAndCodeBaseAndFlStatusBi(cityCode,
                codeBase, flStatusBi));

        SnCidadeOperadoraDTO consult = new SnCidadeOperadoraDTO();
        consult.setCidContrato("05776");
        consult.setCiNome("JUNDIAI");
        consult.setCodOperadora("055");
        consult.setNomePessoa("CLARO - JUNDIAI");
        consult.setRazaoSocial("CLARO S.A.");
        consult.setIdEmpresa("000049");
        consult.setCodeBase("ISP");
        consult.setFlStatusBi("A");


        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(31)
    @DisplayName("Buscando dados da tabela sn_cidade_operadora pelo city id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findSnCidadeOperadoraWithoutValues() {

        String cityCode = "";
        String codeBase = "";
        String flStatusBi = "";

        SnCidadeOperadoraDTO result = SnCidadeOperadoraDTO.create(snCidadeOperadoraRepository.findSnCidadeOperadoraByCidContratoAndCodeBaseAndFlStatusBi(cityCode,
                codeBase, flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getCidContrato());
    }

    @Order(32)
    @DisplayName("Buscando dados da tabela sn_cidade_operadora pelo city id, code base e fl status bi passando null, falha")
    @Test
    void findSnCidadeOperadoraWithNullValues() {

        String cityCode = null;
        String codeBase = null;
        String flStatusBi = null;

        SnCidadeOperadoraDTO result = SnCidadeOperadoraDTO.create(snCidadeOperadoraRepository.findSnCidadeOperadoraByCidContratoAndCodeBaseAndFlStatusBi(cityCode,
                codeBase, flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getCidContrato());
    }

    @Order(33)
    @DisplayName("Buscando dados da tabela sn_contrato pelo id assinante, code base e fl status bi")
    @Test
    void findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBi() {

        Integer idAssinante = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnContratoDTO result = SnContratoDTO.create(snContratoRepository.findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBi(idAssinante, codeBase, flStatusBi));
        SnContratoDTO consult = new SnContratoDTO();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(34)
    @DisplayName("Buscando dados da tabela sn_contrato pelo id assinante, code base e fl status bi passando string sem valor, falha")
    @Test
    void findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idAssinante = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnContratoDTO result = SnContratoDTO.create(snContratoRepository.findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBi(idAssinante, codeBase, flStatusBi));
        SnContratoDTO consult = new SnContratoDTO();

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getNumContrato());
    }

    @Order(35)
    @DisplayName("Buscando dados da tabela sn_cidade_operadora pelo city id, code base e fl status bi passando null, falha")
    @Test
    void findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idAssinante = null;
        String codeBase = null;
        String flStatusBi = null;

        SnContratoDTO result = SnContratoDTO.create(snContratoRepository.findSnContratoByIdAssinanteAndCodeBaseAndFlStatusBi(idAssinante, codeBase, flStatusBi));
        SnContratoDTO consult = new SnContratoDTO();

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getNumContrato());
    }

    @Order(36)
    @DisplayName("Buscando dados da tabela sn_contrato pelo num contrato, city id, code base e fl status bi")
    @ParameterizedTest
    @ValueSource(strings = {"","",""})
    void findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi() {

        Integer numContrato = 0;
        String cidContrato = "02121";
        String codeBase = "";
        String flStatusBi = "";

        SnContratoDTO result = SnContratoDTO.create(snContratoRepository.findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                numContrato,
                cidContrato,
                codeBase,
                flStatusBi));
        SnContratoDTO consult = new SnContratoDTO();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(37)
    @DisplayName("Buscando dados da tabela sn_contrato pelo num contrato, city id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer numContrato = 0;
        String cidContrato = "";
        String codeBase = "";
        String flStatusBi = "";

        SnContratoDTO result = SnContratoDTO.create(snContratoRepository.findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                numContrato,
                cidContrato,
                codeBase,
                flStatusBi));
        SnContratoDTO consult = new SnContratoDTO();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);
    }

    @Order(38)
    @DisplayName("Buscando dados da tabela sn_cidade_operadora pelo city id, code base e fl status bi passando null, falha")
    @Test
    void findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer numContrato = 0;
        String cidContrato = "";
        String codeBase = "";
        String flStatusBi = "";

        SnContratoDTO result = SnContratoDTO.create(snContratoRepository.findSnContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                numContrato,
                cidContrato,
                codeBase,
                flStatusBi));
        SnContratoDTO consult = new SnContratoDTO();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);
    }
    @Order(39)
    @DisplayName("Buscando dados da tabela sn_escolaridade pelo escolaridade id, code base e fl status bi")
    @Test
    void findByIdEscolaridadeAndAndCodeBaseAndFlStatusBi() {

        Integer escolaridadeId = 3;
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnEscolaridadeDTO result = SnEscolaridadeDTO.create(snEscolaridadeRepository.findByIdEscolaridadeAndCodeBaseAndFlStatusBi(escolaridadeId,
                codeBase, flStatusBi));

        SnEscolaridadeDTO consult = new SnEscolaridadeDTO();
        consult.setIdEscolaridade(3);
        consult.setDescricao("ENSINO SUPERIOR");
        consult.setCodeBase("CTV");
        consult.setFlStatusBi("A");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(40)
    @DisplayName("Buscando dados da tabela sn_escolaridade pelo escolaridade id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findByIdEscolaridadeAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer escolaridadeId = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnEscolaridadeDTO result = SnEscolaridadeDTO.create(snEscolaridadeRepository.findByIdEscolaridadeAndCodeBaseAndFlStatusBi(escolaridadeId,
                codeBase, flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdEscolaridade());
    }

    @Order(41)
    @DisplayName("Buscando dados da tabela sn_escolaridade pelo escolaridade id, code base e fl status bi passando null, falha")
    @Test
    void findByIdEscolaridadeAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer escolaridadeId = null;
        String codeBase = null;
        String flStatusBi = null;

        SnEscolaridadeDTO result = SnEscolaridadeDTO.create(snEscolaridadeRepository.findByIdEscolaridadeAndCodeBaseAndFlStatusBi(escolaridadeId,
                codeBase, flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdEscolaridade());
    }

    @Order(42)
    @DisplayName("Buscando dados da tabela sn_estado_civil pelo estado civil id, code base e fl status bi")
    @Test
    void findByIdEstadoCivilAndCodeBaseAndFlStatusBi() {

        Integer idEstadoCivil = 2;
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnEstadoCivilDTO result = SnEstadoCivilDTO.create(snEstadoCivilRepository.findByIdEstadoCivilAndCodeBaseAndFlStatusBi(
                idEstadoCivil,
                codeBase,
                flStatusBi));
        SnEstadoCivilDTO consult = new SnEstadoCivilDTO();
        consult.setIdEstadoCivil(2);
        consult.setDescricao("CASADO");
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(43)
    @DisplayName("Buscando dados da tabela sn_estado_civil pelo estado civil id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findByIdEstadoCivilAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idEstadoCivil = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnEstadoCivilDTO result = SnEstadoCivilDTO.create(snEstadoCivilRepository.findByIdEstadoCivilAndCodeBaseAndFlStatusBi(
                idEstadoCivil,
                codeBase,
                flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdEstadoCivil());
    }

    @Order(44)
    @DisplayName("Buscando dados da tabela sn_estado_civil pelo estado civil id, code base e fl status bi passando null, falha")
    @Test
    void findByIdEstadoCivilAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idEstadoCivil = null;
        String codeBase = null;
        String flStatusBi = null;

        SnEstadoCivilDTO result = SnEstadoCivilDTO.create(snEstadoCivilRepository.findByIdEstadoCivilAndCodeBaseAndFlStatusBi(
                idEstadoCivil,
                codeBase,
                flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdEstadoCivil());
    }

    @Order(45)
    @DisplayName("Buscando dados da tabela sn_orgao_expedidor pelo id orgão expedidor, code base e fl status bi")
    @Test
    void findByIdOrgaoExpedidorAndCodeBaseAndFlStatusBi() {

        Integer idOrgaoExpedidor = 1;
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnOrgaoExpedidorDTO result = SnOrgaoExpedidorDTO.create(snOrgaoExpedidorRepository.findSnOrgaoExpedidorByIdOrgaoExpedidorAndCodeBaseAndFlStatusBi(
                idOrgaoExpedidor,
                codeBase,
                flStatusBi));
        SnOrgaoExpedidorDTO consult = new SnOrgaoExpedidorDTO();
        consult.setIdOrgaoExpedidor(1);
        consult.setDescricao("SSP-SP");
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(46)
    @DisplayName("Buscando dados da tabela sn_orgao_expedidor pelo id orgão expedidor, code base e fl status bi passando string sem valor, falha")
    @Test
    void findByIdOrgaoExpedidorAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idOrgaoExpedidor = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnOrgaoExpedidorDTO result = SnOrgaoExpedidorDTO.create(snOrgaoExpedidorRepository.findSnOrgaoExpedidorByIdOrgaoExpedidorAndCodeBaseAndFlStatusBi(
                idOrgaoExpedidor,
                codeBase,
                flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdOrgaoExpedidor());
    }

    @Order(47)
    @DisplayName("Buscando dados da tabela sn_orgao_expedidor pelo id orgão expedidor, code base e fl status bi passando null, falha")
    @Test
    void findByIdOrgaoExpedidorAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idOrgaoExpedidor = null;
        String codeBase = null;
        String flStatusBi = null;

        SnOrgaoExpedidorDTO result = SnOrgaoExpedidorDTO.create(snOrgaoExpedidorRepository.findSnOrgaoExpedidorByIdOrgaoExpedidorAndCodeBaseAndFlStatusBi(
                idOrgaoExpedidor,
                codeBase,
                flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdOrgaoExpedidor());
    }

    @Order(48)
    @DisplayName("Buscando dados da tabela sn_profissao pelo profissao id, code base e fl status bi")
    @Test
    void findByIdProfissaoAndCodeBaseAndFlStatusBi() {

        Integer idProfissao = 3;
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnProfissaoDTO result = SnProfissaoDTO.create(snProfissaoRepository.findByIdProfissaoAndCodeBaseAndFlStatusBi(
                idProfissao,
                codeBase,
                flStatusBi));

        SnProfissaoDTO consult = new SnProfissaoDTO();
        consult.setIdProfissao(idProfissao);
        consult.setDescricao("CONTADOR");
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(49)
    @DisplayName("Buscando dados da tabela sn_profissao pelo profissao id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findByIdProfissaoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idProfissao = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnProfissaoDTO result = SnProfissaoDTO.create(snProfissaoRepository.findByIdProfissaoAndCodeBaseAndFlStatusBi(
                idProfissao,
                codeBase,
                flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdProfissao());
    }

    @Order(50)
    @DisplayName("Buscando dados da tabela sn_escolaridade pelo escolaridade id, code base e fl status bi passando null, falha")
    @Test
    void findByIdProfissaoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idProfissao = null;
        String codeBase = null;
        String flStatusBi = null;

        SnProfissaoDTO result = SnProfissaoDTO.create(snProfissaoRepository.findByIdProfissaoAndCodeBaseAndFlStatusBi(
                idProfissao,
                codeBase,
                flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdProfissao());
    }

    @Order(51)
    @DisplayName("Buscando dados da tabela sn_razao_cancelamento pelo razao id, code base e fl status bi")
    @Test
    void findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBi() {

        Integer idRazao = 2;
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnRazaoCancelamentoDTO result = SnRazaoCancelamentoDTO.create(
                snRazaoCancelamentoRepository.findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBi(
                        idRazao,
                        codeBase,
                        flStatusBi));

        SnRazaoCancelamentoDTO consult = new SnRazaoCancelamentoDTO();
        consult.setIdRazaoCancelamento(idRazao);
        consult.setDescricao("INICIATIVA DO ASSINANTE");
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.getIdRazaoCancelamento());

    }

    @Order(52)
    @DisplayName("Buscando dados da tabela sn_razao_cancelamento pelo razao id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idRazao = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnRazaoCancelamentoDTO result = SnRazaoCancelamentoDTO.create(
                snRazaoCancelamentoRepository.findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBi(
                        idRazao,
                        codeBase,
                        flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdRazaoCancelamento());
    }

    @Order(53)
    @DisplayName("Buscando dados da tabela sn_escolaridade pelo escolaridade id, code base e fl status bi passando null, falha")
    @Test
    void findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idRazao = null;
        String codeBase = null;
        String flStatusBi = null;

        SnRazaoCancelamentoDTO result = SnRazaoCancelamentoDTO.create(
                snRazaoCancelamentoRepository.findSnRazaoCancelamentoByIdRazaoCancelamentoAndCodeBaseAndFlStatusBi(
                        idRazao,
                        codeBase,
                        flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdRazaoCancelamento());
    }

    @Order(54)
    @DisplayName("Buscando dados da tabela sn_rel_assinante_segmentacao pelo razao id, code base e fl status bi")
    @Test
    void findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi() {

        Integer numContrato = 49641256;
        String cidContrato = "02121";
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnRelAssinanteSegmentacaoDTO result = SnRelAssinanteSegmentacaoDTO.create(
                snRelAssinanteSegmentacaoRepository.findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                        numContrato,
                        cidContrato,
                        codeBase,
                        flStatusBi));
        SnRelAssinanteSegmentacaoDTO consult = new SnRelAssinanteSegmentacaoDTO();
        consult.setNumContrato(numContrato);
        consult.setCidContrato(cidContrato);
        consult.setIdTipoSegmento(5);
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);


        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getNumContrato());

    }

    @Order(55)
    @DisplayName("Buscando dados da tabela sn_rel_assinante_segmentacao pelo razao id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer numContrato = 0;
        String cidContrato = "";
        String codeBase = "";
        String flStatusBi = "";

        SnRelAssinanteSegmentacaoDTO result = SnRelAssinanteSegmentacaoDTO.create(
                snRelAssinanteSegmentacaoRepository.findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                        numContrato,
                        cidContrato,
                        codeBase,
                        flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdRelAssSegmentacao());
    }

    @Order(56)
    @DisplayName("Buscando dados da tabela sn_rel_assinante_segmentacao pelo razao id, code base e fl status bi passando null, falha")
    @Test
    void findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer numContrato = null;
        String cidContrato = null;
        String codeBase = null;
        String flStatusBi = null;

        SnRelAssinanteSegmentacaoDTO result = SnRelAssinanteSegmentacaoDTO.create(
                snRelAssinanteSegmentacaoRepository.findSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                        numContrato,
                        cidContrato,
                        codeBase,
                        flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdRelAssSegmentacao());
    }

    /*@Order(57)
    @DisplayName("Buscando dados da tabela sn_rel_status_contrato pelo razao id, code base e fl status bi")
    @Test
    void findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBifindSnRelAssinanteSegmentacaoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi() {

        Integer numContrato = 756374;
        String cidContrato = "02121";
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnRelStatusContratoDTO consult = new SnRelStatusContratoDTO();
        consult.setNumContrato(numContrato);
        consult.setCidContrato(cidContrato);
        consult.setIdStatus(49641256);
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);
        Mockito.when(snRelStatusContratoRepository.
                findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(Mockito.anyInt(),Mockito.anyString(),Mockito.anyString(),Mockito.anyString()))
                .thenReturn(List.of(SnRelStatusContrato.create(consult)));
        var result = SnRelStatusContratoDTO.create(
                snRelStatusContratoRepository.findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                        numContrato,
                        cidContrato,
                        codeBase,
                        flStatusBi).get(0));



        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(58)
    @DisplayName("Buscando dados da tabela sn_rel_status_contrato pelo razao id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer numContrato = 0;
        String cidContrato = "";
        String codeBase = "";
        String flStatusBi = "";

        SnRelStatusContratoDTO result = SnRelStatusContratoDTO.create(
                snRelStatusContratoRepository.findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                        numContrato,
                        cidContrato,
                        codeBase,
                        flStatusBi).get(0));


        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdStatus());
    }*/

    /*@Order(59)
    @DisplayName("Buscando dados da tabela sn_rel_status_contrato pelo razao id, code base e fl status bi passando null, falha")
    @Test
    void findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer numContrato = null;
        String cidContrato = null;
        String codeBase = null;
        String flStatusBi = null;

        SnRelStatusContratoDTO result = SnRelStatusContratoDTO.create(
                snRelStatusContratoRepository.findSnRelStatusContratoByNumContratoAndCidContratoAndCodeBaseAndFlStatusBi(
                        numContrato,
                        cidContrato,
                        codeBase,
                        flStatusBi).get(0));
        SnRelStatusContratoDTO consult = new SnRelStatusContratoDTO();
        consult.setNumContrato(numContrato);
        consult.setCidContrato(cidContrato);
        consult.setIdStatus(1);
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getNumContrato());
    }*/

    @Order(60)
    @DisplayName("Buscando dados da tabela sn_sexo pelo sexo id, code base e fl status bi")
    @Test
    void findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBi() {

        Integer idSexo = 3;
        String codeBase = "ISP";
        String flStatusBi = "A";

        SnSexoDTO result = SnSexoDTO.create(
                snSexoRepository.findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBi(
                        idSexo,
                        codeBase,
                        flStatusBi));
        SnSexoDTO consult = new SnSexoDTO();

        consult.setIdSexo(idSexo);
        consult.setDescricao("MASCULINO");
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(61)
    @DisplayName("Buscando dados da tabela sn_sexo pelo sexo id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idSexo = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnSexoDTO result = SnSexoDTO.create(
                snSexoRepository.findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBi(
                        idSexo,
                        codeBase,
                        flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdSexo());
    }

    @Order(62)
    @DisplayName("Buscando dados da tabela sn_sexo pelo sexo id, code base e fl status bi passando null, falha")
    @Test
    void findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idSexo = null;
        String codeBase = null;
        String flStatusBi = null;

        SnSexoDTO result = SnSexoDTO.create(
                snSexoRepository.findSnSexoByIdSexoAndAndCodeBaseAndFlStatusBi(
                        idSexo,
                        codeBase,
                        flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdSexo());
    }

    @Order(63)
    @DisplayName("Buscando dados da tabela sn_status_contrato pelo sexo id, code base e fl status bi")
    @Test
    void findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi() {

        Integer idStatus = 35;
        String codeBase = "ISP";
        String flStatusBi = "A";

        SnStatusContratoDTO consult = new SnStatusContratoDTO();
        consult.setIdStatusContrato(idStatus);
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);
        consult.setDescricao("CONECTADO(DESABILITADO PARCIAL)");
        Mockito.when(snStatusContratoRepository.findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi(
                Mockito.anyInt(),Mockito.anyString(),Mockito.anyString())).thenReturn(SnStatusContrato.create(consult));
        SnStatusContratoDTO result = SnStatusContratoDTO.create(
                snStatusContratoRepository.findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi(
                        idStatus,
                        codeBase,
                        flStatusBi));




        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);

    }

    @Order(64)
    @DisplayName("Buscando dados da tabela sn_sexo pelo sexo id, code base e fl status bi passando string sem valor, falha")
    @Test
    void findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idStatus = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnStatusContratoDTO result = SnStatusContratoDTO.create(
                snStatusContratoRepository.findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi(
                        idStatus,
                        codeBase,
                        flStatusBi));


        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getDescricao());
    }

    @Order(65)
    @DisplayName("Buscando dados da tabela sn_sexo pelo sexo id, code base e fl status bi passando null, falha")
    @Test
    void findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idStatus = null;
        String codeBase = null;
        String flStatusBi = null;

        SnStatusContratoDTO result = SnStatusContratoDTO.create(
                snStatusContratoRepository.findSnStatusContratoByIdStatusContratoAndCodeBaseAndFlStatusBi(
                        idStatus,
                        codeBase,
                        flStatusBi));

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getDescricao());
    }

    /*@Order(66)
    @DisplayName("Buscando dados da tabela sn_telefone_voip pelo cid contrato, num contrato , code base e fl status bi")
    @Test
    void findAllByCidContratoAndNumContratoAndCodeBaseAndFlStatusBi() {

        Integer numContrato = 182969947;
        String cidContrato = "02121";
        String codeBase = "CTV";
        String flStatusBi = "A";


        List<SnTelefoneVoipDTO> resultList = snTelefoneVoipRepository.findByCidContratoAndNumContratoAndCodeBaseAndFlStatusBi(
                        cidContrato,
                        numContrato,
                        codeBase,
                        flStatusBi,
                ContractProspectServiceConstansts.DEFAULT_DATA_FIM
                ).stream().map(SnTelefoneVoipDTO::create).collect(Collectors.toList());

        SnTelefoneVoipDTO consult = new SnTelefoneVoipDTO();
        consult.setDddTelefoneVoip("21");
        consult.setNumTelefoneVoip("20838026");
        consult.setDtFim(Date.valueOf("2020-09-01"));
        consult.setDtIni(Date.valueOf("2020-08-26"));
        consult.setIdStatusTelefoneVoip("U");
        consult.setNumContrato(numContrato);
        consult.setCidContrato(cidContrato);
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);
        List<SnTelefoneVoipDTO> consultList = new ArrayList<>();
        consultList.add(consult);
        consult = new SnTelefoneVoipDTO();
        consult.setDddTelefoneVoip("21");
        consult.setNumTelefoneVoip("20838026");
        consult.setDtFim(Date.valueOf("2049-12-30"));
        consult.setDtIni(Date.valueOf("2020-09-01"));
        consult.setIdStatusTelefoneVoip("C");
        consult.setNumContrato(numContrato);
        consult.setCidContrato(cidContrato);
        consult.setCodeBase(codeBase);
        consult.setFlStatusBi(flStatusBi);
        consultList.add(consult);
        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(consultList.get(0).getNumTelefoneVoip(), resultList.get(0).getNumTelefoneVoip());
        Assertions.assertEquals(consultList.get(1).getNumTelefoneVoip(), resultList.get(1).getNumTelefoneVoip());

    }*/

    @Order(67)
    @DisplayName("Buscando dados da tabela sn_telefone_voip pelo cid contrato, num contrato , code base e fl status bi passando string sem valor, falha")
    @Test
    void findByCidContratoAndNumContratoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer numContrato = 0;
        String cidContrato = "";
        String codeBase = "";
        String flStatusBi = "";


        List<SnTelefoneVoipDTO> resultList = snTelefoneVoipRepository.findByCidContratoAndNumContratoAndCodeBaseAndFlStatusBi(
                cidContrato,
                numContrato,
                codeBase,
                flStatusBi,
                ContractProspectServiceConstansts.DEFAULT_DATA_FIM
        ).stream().map(SnTelefoneVoipDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(0, resultList.size());
    }

    @Order(68)
    @DisplayName("Buscando dados da tabela sn_telefone_voip pelo cid contrato, num contrato , code base e fl status bi passando null, falha")
    @Test
    void findByCidContratoAndNumContratoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer numContrato = null;
        String cidContrato = null;
        String codeBase = null;
        String flStatusBi = null;


        List<SnTelefoneVoipDTO> resultList = snTelefoneVoipRepository.findByCidContratoAndNumContratoAndCodeBaseAndFlStatusBi(
                cidContrato,
                numContrato,
                codeBase,
                flStatusBi,
                ContractProspectServiceConstansts.DEFAULT_DATA_FIM
        ).stream().map(SnTelefoneVoipDTO::create).collect(Collectors.toList());

        Assertions.assertNotNull(resultList);
        Assertions.assertEquals(0, resultList.size());
    }

    @Order(69)
    @DisplayName("Buscando dados da tabela sn tipo contrato")
    @Test
    void findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBi() {

        Integer idTipoContrato = 1;
        String codeBase = "ISP";
        String flStatusBi = "A";


        SnTipoContratoDTO result =  SnTipoContratoDTO.create(
                snTipoContratoRepository.findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBi(
                        idTipoContrato,
                        codeBase,
                        flStatusBi
                )
        );
        SnTipoContratoDTO consult  = new SnTipoContratoDTO(idTipoContrato,"INDIVIDUAL",codeBase,flStatusBi);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);
    }

    @Order(70)
    @DisplayName("Buscando dados da tabela sn tipo contrato, passando strings vazias")
    @Test
    void findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idTipoContrato = 0;
        String codeBase = "";
        String flStatusBi = "";


        SnTipoContratoDTO result =  SnTipoContratoDTO.create(
                snTipoContratoRepository.findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBi(
                        idTipoContrato,
                        codeBase,
                        flStatusBi
                )
        );

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdTipoContrato());
    }

    @Order(71)
    @DisplayName("Buscando dados da tabela sn tipo contrato, passando null falha")
    @Test
    void findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idTipoContrato = null;
        String codeBase = null;
        String flStatusBi = null;


        SnTipoContratoDTO result =  SnTipoContratoDTO.create(
                snTipoContratoRepository.findSnTipoContratoByIdTipoContratoAndCodeBaseAndFlStatusBi(
                        idTipoContrato,
                        codeBase,
                        flStatusBi
                )
        );

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdTipoContrato());
    }

    @Order(72)
    @DisplayName("Buscando dados da tabela sn tipo segmento ")
    @Test
    void findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBi() {

        Integer idTipoSegmento = 11;
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnTipoSegmentoDTO result = SnTipoSegmentoDTO.create(
                snTipoSegmentoRepository.findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBi(
                        idTipoSegmento,
                        codeBase,
                        flStatusBi
                        )
        );
        SnTipoSegmentoDTO consult = new SnTipoSegmentoDTO(idTipoSegmento, "BSOD", codeBase, flStatusBi);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);
    }

    @Order(73)
    @DisplayName("Buscando dados da tabela sn_telefone_voip, passando strings vazias")
    @Test
    void findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idTipoSegmento = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnTipoSegmentoDTO result = SnTipoSegmentoDTO.create(
                snTipoSegmentoRepository.findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBi(
                        idTipoSegmento,
                        codeBase,
                        flStatusBi
                )
        );

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdTipoSegmento());
    }

    @Order(74)
    @DisplayName("Buscando dados da tabela sn_telefone_voip, passando null falha")
    @Test
    void findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idTipoSegmento = null;
        String codeBase = null;
        String flStatusBi = null;

        SnTipoSegmentoDTO result = SnTipoSegmentoDTO.create(
                snTipoSegmentoRepository.findSnTipoSegmentoByIdTipoSegmentoAndCodeBaseAndFlStatusBi(
                        idTipoSegmento,
                        codeBase,
                        flStatusBi
                )
        );

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdTipoSegmento());
    }

    @Order(75)
    @DisplayName("Buscando dados da tabela sn tipo segmento ")
    @Test
    void findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBi() {

        Integer idTipoVenda = 75;
        String codeBase = "CTV";
        String flStatusBi = "A";

        SnTipoVendaDTO result = SnTipoVendaDTO.create(
                snTipoVendaRepository.findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBi(
                        idTipoVenda,
                        codeBase,
                        flStatusBi
                )
        );
        SnTipoVendaDTO consult = new SnTipoVendaDTO(idTipoVenda,"TERC- TLVENDAS NACIONAL (0800)",
                codeBase, flStatusBi);



        Assertions.assertNotNull(result);
        Assertions.assertEquals(consult, result);
    }

    @Order(76)
    @DisplayName("Buscando dados da tabela sn_telefone_voip, passando strings vazias")
    @Test
    void findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBiWithoutValues() {

        Integer idTipoVenda = 0;
        String codeBase = "";
        String flStatusBi = "";

        SnTipoVendaDTO result = SnTipoVendaDTO.create(
                snTipoVendaRepository.findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBi(
                        idTipoVenda,
                        codeBase,
                        flStatusBi
                )
        );

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdTipoVenda());
    }

    @Order(77)
    @DisplayName("Buscando dados da tabela sn_telefone_voip, passando null falha")
    @Test
    void findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBiWithNullValues() {

        Integer idTipoVenda = null;
        String codeBase = null;
        String flStatusBi = null;

        SnTipoVendaDTO result = SnTipoVendaDTO.create(
                snTipoVendaRepository.findSnTipoVendaByIdTipoVendaAndCodeBaseAndFlStatusBi(
                        idTipoVenda,
                        codeBase,
                        flStatusBi
                )
        );

        Assertions.assertNotNull(result);
        Assertions.assertNull(result.getIdTipoVenda());

    }

}

