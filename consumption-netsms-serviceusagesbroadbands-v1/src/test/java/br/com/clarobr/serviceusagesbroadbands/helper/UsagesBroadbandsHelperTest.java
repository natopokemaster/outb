package br.com.clarobr.serviceusagesbroadbands.helper;
import br.com.clarobr.serviceusagesbroadbands.constants.ErrorConstants;
import br.com.clarobr.serviceusagesbroadbands.exception.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsagesBroadbandsHelperTest {

    private UsagesBroadbandsHelper helper;

    @BeforeEach
    void setUp() {
        helper = new UsagesBroadbandsHelper();
    }

    @Test
    void testGetParamsFromQueryString_ValidString() throws BadRequestException {
        String queryString = "customerContractId=295300&addressableCode=000E5CDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false&operatorCode=013";

        Map<String, String> params = helper.getParamsFromQueryString(queryString);

        assertEquals(6, params.size());
        assertEquals("295300", params.get("customerContractId"));
        assertEquals("000E5CDDDE92", params.get("addressableCode"));
        assertEquals("2012-02-16", params.get("startDate"));
        assertEquals("2013-01-30", params.get("endDate"));
        assertEquals("false", params.get("detailed"));
        assertEquals("013", params.get("operatorCode"));
    }

    @Test
    void testGetParamsFromQueryString_InvalidString() {
        String queryString = "customerContractId=295300&&operatorCode=013&addressableCode=000E5CDDDE92&startDate=2012-02-16&endDate=2013-01-30&detailed=false";

        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> helper.getParamsFromQueryString(queryString));

        assertEquals(ErrorConstants.ERROR_XQUERYSTRING_OUT_OF_STANDARD, exception.getMessage());
    }


    @Test
    void testGetParamsFromQueryString_EmptyString() throws BadRequestException {
        String queryString = "";

        Map<String, String> params = helper.getParamsFromQueryString(queryString);

        assertTrue(params.isEmpty());
    }

    @Test
    void testGetParamsFromQueryString_NullString() throws BadRequestException {
        String queryString = null;

        Map<String, String> params = helper.getParamsFromQueryString(queryString);

        assertTrue(params.isEmpty());
    }
}
