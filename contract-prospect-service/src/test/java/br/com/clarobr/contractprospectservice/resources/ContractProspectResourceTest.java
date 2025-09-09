package br.com.clarobr.contractprospectservice.resources;


import br.com.clarobr.contractprospectservice.connectors.ContractUtilsConnector;
import br.com.clarobr.contractprospectservice.exception.BadRequestException;
import br.com.clarobr.contractprospectservice.exception.NotFoundException;
import br.com.clarobr.contractprospectservice.exception.UnprocessableEntityException;
import br.com.clarobr.contractprospectservice.models.address.Contract;
import br.com.clarobr.contractprospectservice.models.address.ContractIdentification;
import br.com.clarobr.contractprospectservice.models.common.CustomHttpEntity;
import br.com.clarobr.contractprospectservice.models.output.ContractProspectOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
class ContractProspectResourceTest {

    @Autowired
    private ContractProspectResource contractProspectResource;

    @MockBean
    private ContractUtilsConnector contractUtilsConnector;

    void initializePhysicalPerson() throws UnprocessableEntityException, NotFoundException, BadRequestException, JsonProcessingException {
        var response = new ContractIdentification("055202781080003","226057453445","sit6isp",new Contract("12419529","055","05776","ISP"),"226057453445");
        Mockito.when(contractUtilsConnector.getContractIdentification(Mockito.any())).thenReturn(response);
    }

    void initializeLegalPerson() throws UnprocessableEntityException, NotFoundException, BadRequestException, JsonProcessingException {
        var response = new ContractIdentification("055202781080003","168430975972","sit6isp",new Contract("1544370","021","02121","CTV"),"168430975972");
        Mockito.when(contractUtilsConnector.getContractIdentification(Mockito.any())).thenReturn(response);
    }

    @Test
    @Order(1)
    @DisplayName("Buscando dados do prospect Pessoa Física por Smartcard sucesso")
    void getContractProspectBySmartCardSucess() throws Exception {
        initializePhysicalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("smartCardNumber", "226057453445");
        ResponseEntity<CustomHttpEntity<ContractProspectOutput>>  response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getVerificationDigit());
        assertEquals("FISICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }

    @Test
    @Order(2)
    @DisplayName("Buscando dados do prospect Pessoa Física por Contrato e Código da Operadora sucesso")
    void getContractProspectByCustomerAccountIdAndOperatorCodeSucess() throws Exception {
        initializePhysicalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("customerAccountId", "12419529");
        headers.set("operatorCode", "055");

        ResponseEntity<CustomHttpEntity<ContractProspectOutput>>  response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getOrganization().getOperatorCode());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertEquals("FISICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertEquals(12419529, response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertEquals("055", response.getBody().getData().getCustomerProspects().get(0).getContract().getOrganization().getOperatorCode());

    }
    @Test
    @Order(3)
    @DisplayName("Buscando dados do prospect Pessoa Física por Contrato e Código da Cidade sucesso")
    void getContractProspectByCustomerAccountIdAndCityId() throws Exception {
        initializePhysicalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("customerAccountId", "12419529");
        headers.set("cityId", "05776");

        ResponseEntity<CustomHttpEntity<ContractProspectOutput>>  response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getOrganization().getOperatorCode());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertEquals("FISICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertEquals(12419529, response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertEquals("05776", response.getBody().getData().getCustomerProspects().get(0).getContract().getOrganization().getCityId());

    }

    @ParameterizedTest
    @ValueSource(strings = {"055202781080003"})
    @Order(4)
    @DisplayName("Buscando dados do prospect Pessoa Física por Número de Protocolo sucesso")
    @SuppressWarnings("All")
    void getContractProspectByProtocolNumber(String protocolNumber) throws Exception {
        initializePhysicalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("protocolNumber", protocolNumber);


        ResponseEntity<CustomHttpEntity<ContractProspectOutput>> response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull((response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId()));
        assertEquals("FISICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }
    @Test
    @Order(5)
    @DisplayName("Buscando dados do prospect Pessoa Física por Número de Protocolo sucesso")
    void getContractProspectByAddressableCode() throws Exception {
        initializePhysicalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("addressableCode", "226057453445");


        ResponseEntity<CustomHttpEntity<ContractProspectOutput>> response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull((response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId()));
        assertEquals("FISICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }

    @Test
    @Order(6)
    @DisplayName("Buscando dados do prospect Pessoa Física por Número de Protocolo sucesso")
    void getContractProspectByDocumentId() throws Exception {
        initializePhysicalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("identificationId", "25262523188");

        ResponseEntity<CustomHttpEntity<ContractProspectOutput>> response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull((response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId()));
        assertEquals("FISICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }

    @Test
    @Order(7)
    @DisplayName("Buscando dados do prospect Pessoa Física por Número de Protocolo sucesso")
    void getContractProspectByAreaCodeAndPhoneNumber()
            throws Exception {
        initializePhysicalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("areaCode", "21");
        headers.set("phoneNumber", "414817254");

        ResponseEntity<CustomHttpEntity<ContractProspectOutput>> response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull((response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId()));
        assertEquals("FISICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }

    /**
     *      Teste de Pessoa Juridica
     */

    @Test
    @Order(8)
    @DisplayName("Buscando dados do prospect Pessoa Juridica por Smartcard sucesso")
    void getContractProspectBySmartCardSucessLegalPerson() throws Exception {
        initializeLegalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("smartCardNumber", "168430975972");
        ResponseEntity<CustomHttpEntity<ContractProspectOutput>>  response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getVerificationDigit());
        assertEquals("JURIDICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }

    @Test
    @Order(9)
    @DisplayName("Buscando dados do prospect Pessoa Juridica por Contrato e Código da Operadora sucesso")
    void getContractProspectByCustomerAccountIdAndOperatorCodeSucessLegalPerson() throws Exception {
        initializeLegalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("customerAccountId", "1544370");
        headers.set("operatorCode", "021");

        ResponseEntity<CustomHttpEntity<ContractProspectOutput>>  response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getOrganization().getOperatorCode());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertEquals("JURIDICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertEquals(1544370, response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertEquals("021", response.getBody().getData().getCustomerProspects().get(0).getContract().getOrganization().getOperatorCode());

    }
    @Test
    @Order(10)
    @DisplayName("Buscando dados do prospect Pessoa Juridica por Contrato e Código da Cidade sucesso")
    void getContractProspectByCustomerAccountIdAndCityIdLegalPerson() throws Exception {
        initializeLegalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("customerAccountId", "1544370");
        headers.set("cityId", "02121");

        ResponseEntity<CustomHttpEntity<ContractProspectOutput>>  response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getContract().getOrganization().getOperatorCode());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertEquals("JURIDICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertEquals(1544370, response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId());
        assertEquals("02121", response.getBody().getData().getCustomerProspects().get(0).getContract().getOrganization().getCityId());

    }

    /**
     * Alterar protocolNumber para um CNPJ de vdd
     * @throws Exception
     */
    @ParameterizedTest
    @ValueSource(strings = {"055202781080003"})
    @Order(11)
    @DisplayName("Buscando dados do prospect Pessoa Juridica por Número de Protocolo sucesso")
    @SuppressWarnings("All")
    void getContractProspectByProtocolNumberLegalPerson(String protocolNumber) throws Exception {
        initializeLegalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("protocolNumber", protocolNumber);


        ResponseEntity<CustomHttpEntity<ContractProspectOutput>> response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull((response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId()));
        assertEquals("JURIDICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }
    @Test
    @Order(12)
    @DisplayName("Buscando dados do prospect Pessoa Juridica por Número de Protocolo sucesso")
    void getContractProspectByAddressableCodeLegalPerson() throws Exception {
        initializeLegalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("addressableCode", "226057453445");


        ResponseEntity<CustomHttpEntity<ContractProspectOutput>> response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull((response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId()));
        assertEquals("JURIDICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }

    @Test
    @Order(13)
    @DisplayName("Buscando dados do prospect Pessoa Juridica por Número de Protocolo sucesso")
    void getContractProspectByDocumentIdLegalPerson() throws Exception {
        initializeLegalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("identificationId", "488612086508700");

        ResponseEntity<CustomHttpEntity<ContractProspectOutput>> response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull((response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId()));
        assertEquals("JURIDICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }

    @Test
    @Order(14)
    @DisplayName("Buscando dados do prospect Pessoa Juridica por Número de Protocolo sucesso")
    void getContractProspectByAreaCodeAndPhoneNumberLegalPerson()
            throws Exception {
        initializeLegalPerson();
        HttpHeaders headers = new HttpHeaders();
        headers.set("areaCode", "22");
        headers.set("phoneNumber", "32173812");

        ResponseEntity<CustomHttpEntity<ContractProspectOutput>> response = contractProspectResource.getContractProspects(headers);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getId());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getName());
        assertNotNull(response.getBody().getData().getCustomerProspects().get(0).getPersonType());
        assertNotNull((response.getBody().getData().getCustomerProspects().get(0).getContract().getCustomerAccountId()));
        assertEquals("JURIDICA", response.getBody().getData().getCustomerProspects().get(0).getPersonType());

    }

    /**
     * Errors
     */

    @Test
    @Order(15)
    @DisplayName("Buscando dados do prospect por customer account id com caracter especial")
    void getContractProspectBadRequestByCustomerAccountId() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("customerAccountId", "313334521!");
        headers.set("operatorCode", "055");

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            contractProspectResource.getContractProspects(headers);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(16)
    @DisplayName("Buscando dados do prospect por operatorCode com caracter especial")
    void getContractProspectBadRequestByOperatorCode() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("customerAccountId", "1544370");
        headers.set("operatorCode", "05!");

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            contractProspectResource.getContractProspects(headers);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(17)
    @DisplayName("Buscando dados do prospect por cityId com caracter especial")
    void getContractProspectBadRequestBycityId() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("customerAccountId", "1544370");
        headers.set("cityId", "05776!");

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            contractProspectResource.getContractProspects(headers);
        });

        Assertions.assertNotNull(thrown);

    }

    @ParameterizedTest
    @ValueSource(strings = {"947462890208290!"})
    @Order(18)
    @DisplayName("Buscando dados do prospect por documentId com caracter especial")
    @SuppressWarnings("All")
    void getContractProspectBadRequestByDocumentId(String identificationId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("identificationId", identificationId);

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            contractProspectResource.getContractProspects(headers);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(19)
    @DisplayName("Buscando dados do prospect por Area Code")
    void getContractProspectBadRequestByAreaCode() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("areaCode", "011");

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            contractProspectResource.getContractProspects(headers);
        });

        Assertions.assertNotNull(thrown);

    }
    @Test
    @Order(19)
    @DisplayName("Buscando dados do prospect por PhoneNumber")
    void getContractProspectBadRequestByPhoneNumber() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("phoneNumber", "221219552");

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            contractProspectResource.getContractProspects(headers);
        });

        Assertions.assertNotNull(thrown);

    }

    @Test
    @Order(20)
    @DisplayName("Buscando dados do prospect por PhoneNumber com caracter especial")
    void getContractProspectBadRequestByPhoneNumberAndAreaCode() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("phoneNumber", "221219552!");
        headers.set("areaCode", "011");

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            contractProspectResource.getContractProspects(headers);
        });

        Assertions.assertNotNull(thrown);

    }
    @Test
    @Order(20)
    @DisplayName("Buscando dados do prospect por AreaCode com caracter especial")
    void getContractProspectBadRequestByPhoneNumberAndAreaCode2() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("phoneNumber", "221219552");
        headers.set("areaCode", "011!");

        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            contractProspectResource.getContractProspects(headers);
        });

        Assertions.assertNotNull(thrown);

    }
}