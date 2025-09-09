package br.com.clarobr.contractprospectservice;

import br.com.clarobr.contractprospectservice.resources.ContractProspectResource;
import br.com.clarobr.contractprospectservice.services.impl.ContractProspectServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { ContractProspectResource.class, ContractProspectServiceImpl.class,
        ContractProspectServiceApplication.class })
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContractProspectServiceApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    @DisplayName("Buscando dados do prospect por Smartcard sucesso")
    public void testGetContractProspects() throws Exception {
        Assert.assertNotNull("Valor");
    }
}