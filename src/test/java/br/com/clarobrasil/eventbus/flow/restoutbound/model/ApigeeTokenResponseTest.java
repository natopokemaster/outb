package br.com.clarobrasil.eventbus.flow.restoutbound.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ApigeeTokenResponseTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGettersAndSetters() {
        // Given
        ApigeeTokenResponse response = new ApigeeTokenResponse();

        // When
        response.setRefreshTokenExpiresIn("3600");
        response.setApiProductList("product1,product2");
        response.setApiProductListJson(Arrays.asList("product1", "product2"));
        response.setOrganizationName("testOrg");
        response.setDeveloperEmail("test@example.com");
        response.setTokenType("Bearer");
        response.setIssuedAt(1625000000000L);
        response.setClientId("testClientId");
        response.setAccessToken("testAccessToken");
        response.setApplicationName("testApp");
        response.setScope("read write");
        response.setExpiresIn(3600L);
        response.setRefreshCount("0");
        response.setStatus("approved");

        // Then
        assertEquals("3600", response.getRefreshTokenExpiresIn());
        assertEquals("product1,product2", response.getApiProductList());
        assertEquals(Arrays.asList("product1", "product2"), response.getApiProductListJson());
        assertEquals("testOrg", response.getOrganizationName());
        assertEquals("test@example.com", response.getDeveloperEmail());
        assertEquals("Bearer", response.getTokenType());
        assertEquals(1625000000000L, response.getIssuedAt());
        assertEquals("testClientId", response.getClientId());
        assertEquals("testAccessToken", response.getAccessToken());
        assertEquals("testApp", response.getApplicationName());
        assertEquals("read write", response.getScope());
        assertEquals(3600L, response.getExpiresIn());
        assertEquals("0", response.getRefreshCount());
        assertEquals("approved", response.getStatus());
    }

    @Test
    void testJsonSerialization() throws Exception {
        // Given
        ApigeeTokenResponse response = new ApigeeTokenResponse();
        response.setRefreshTokenExpiresIn("3600");
        response.setApiProductList("product1,product2");
        response.setApiProductListJson(Arrays.asList("product1", "product2"));
        response.setOrganizationName("testOrg");
        response.setDeveloperEmail("test@example.com");
        response.setTokenType("Bearer");
        response.setIssuedAt(1625000000000L);
        response.setClientId("testClientId");
        response.setAccessToken("testAccessToken");
        response.setApplicationName("testApp");
        response.setScope("read write");
        response.setExpiresIn(3600L);
        response.setRefreshCount("0");
        response.setStatus("approved");

        // When
        String json = objectMapper.writeValueAsString(response);

        // Then
        assertTrue(json.contains("\"refresh_token_expires_in\":\"3600\""));
        assertTrue(json.contains("\"api_product_list\":\"product1,product2\""));
        assertTrue(json.contains("\"api_product_list_json\":[\"product1\",\"product2\"]"));
        assertTrue(json.contains("\"organization_name\":\"testOrg\""));
        assertTrue(json.contains("\"developer.email\":\"test@example.com\""));
        assertTrue(json.contains("\"token_type\":\"Bearer\""));
        assertTrue(json.contains("\"issued_at\":1625000000000"));
        assertTrue(json.contains("\"client_id\":\"testClientId\""));
        assertTrue(json.contains("\"access_token\":\"testAccessToken\""));
        assertTrue(json.contains("\"application_name\":\"testApp\""));
        assertTrue(json.contains("\"scope\":\"read write\""));
        assertTrue(json.contains("\"expires_in\":3600"));
        assertTrue(json.contains("\"refresh_count\":\"0\""));
        assertTrue(json.contains("\"status\":\"approved\""));
    }

    @Test
    void testJsonDeserialization() throws Exception {
        // Given
        String json = "{\n" +
                "  \"refresh_token_expires_in\": \"3600\",\n" +
                "  \"api_product_list\": \"product1,product2\",\n" +
                "  \"api_product_list_json\": [\"product1\", \"product2\"],\n" +
                "  \"organization_name\": \"testOrg\",\n" +
                "  \"developer.email\": \"test@example.com\",\n" +
                "  \"token_type\": \"Bearer\",\n" +
                "  \"issued_at\": 1625000000000,\n" +
                "  \"client_id\": \"testClientId\",\n" +
                "  \"access_token\": \"testAccessToken\",\n" +
                "  \"application_name\": \"testApp\",\n" +
                "  \"scope\": \"read write\",\n" +
                "  \"expires_in\": 3600,\n" +
                "  \"refresh_count\": \"0\",\n" +
                "  \"status\": \"approved\"\n" +
                "}";

        // When
        ApigeeTokenResponse response = objectMapper.readValue(json, ApigeeTokenResponse.class);

        // Then
        assertEquals("3600", response.getRefreshTokenExpiresIn());
        assertEquals("product1,product2", response.getApiProductList());
        assertEquals(Arrays.asList("product1", "product2"), response.getApiProductListJson());
        assertEquals("testOrg", response.getOrganizationName());
        assertEquals("test@example.com", response.getDeveloperEmail());
        assertEquals("Bearer", response.getTokenType());
        assertEquals(1625000000000L, response.getIssuedAt());
        assertEquals("testClientId", response.getClientId());
        assertEquals("testAccessToken", response.getAccessToken());
        assertEquals("testApp", response.getApplicationName());
        assertEquals("read write", response.getScope());
        assertEquals(3600L, response.getExpiresIn());
        assertEquals("0", response.getRefreshCount());
        assertEquals("approved", response.getStatus());
    }

    @Test
    void testToString() {
        // Given
        ApigeeTokenResponse response = new ApigeeTokenResponse();
        response.setAccessToken("testAccessToken");
        response.setClientId("testClientId");

        // When
        String toString = response.toString();

        // Then
        assertTrue(toString.contains("accessToken=testAccessToken"));
        assertTrue(toString.contains("clientId=testClientId"));
        assertTrue(toString.contains("ApigeeTokenResponse"));
    }

    @Test
    void testSerializable() throws Exception {
        // Given
        ApigeeTokenResponse original = new ApigeeTokenResponse();
        original.setAccessToken("testAccessToken");
        original.setClientId("testClientId");
        original.setApiProductListJson(Arrays.asList("product1", "product2"));

        // When
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(original);
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        ApigeeTokenResponse deserialized = (ApigeeTokenResponse) ois.readObject();
        ois.close();

        // Then
        assertEquals(original.getAccessToken(), deserialized.getAccessToken());
        assertEquals(original.getClientId(), deserialized.getClientId());
        assertEquals(original.getApiProductListJson(), deserialized.getApiProductListJson());
    }

    @Test
    void testNullValues() throws Exception {
        // Given
        ApigeeTokenResponse response = new ApigeeTokenResponse();
        // All fields are null by default

        // When
        String json = objectMapper.writeValueAsString(response);
        ApigeeTokenResponse deserialized = objectMapper.readValue(json, ApigeeTokenResponse.class);

        // Then
        assertNull(deserialized.getAccessToken());
        assertNull(deserialized.getClientId());
        assertNull(deserialized.getApiProductListJson());
    }

    @Test
    void testEmptyCollections() throws Exception {
        // Given
        ApigeeTokenResponse response = new ApigeeTokenResponse();
        response.setApiProductListJson(List.of());

        // When
        String json = objectMapper.writeValueAsString(response);

        // Then
        assertTrue(json.contains("\"api_product_list_json\":[]"));

        // When
        ApigeeTokenResponse deserialized = objectMapper.readValue(json, ApigeeTokenResponse.class);

        // Then
        assertNotNull(deserialized.getApiProductListJson());
        assertTrue(deserialized.getApiProductListJson().isEmpty());
    }

    @Test
    void testEqualsAndHashCode() {
        // Given
        ApigeeTokenResponse response1 = new ApigeeTokenResponse();
        response1.setAccessToken("testAccessToken");
        response1.setClientId("testClientId");

        ApigeeTokenResponse response2 = new ApigeeTokenResponse();
        response2.setAccessToken("testAccessToken");
        response2.setClientId("testClientId");

        ApigeeTokenResponse response3 = new ApigeeTokenResponse();
        response3.setAccessToken("differentAccessToken");
        response3.setClientId("testClientId");

        // Then
        assertEquals(response1, response2);
        assertEquals(response1.hashCode(), response2.hashCode());
        assertNotEquals(response1, response3);
        assertNotEquals(response1.hashCode(), response3.hashCode());
    }
}