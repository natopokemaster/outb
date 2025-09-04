package br.com.clarobr.serviceusagesbroadbands.mapper;

import br.com.clarobr.serviceusagesbroadbands.models.CustomerInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
class CustomerInformationRowMapperTest {

    private CustomerInformationRowMapper rowMapper;
    private ResultSet resultSet;

    @BeforeEach
    void setUp() {
        rowMapper = new CustomerInformationRowMapper();
        resultSet = Mockito.mock(ResultSet.class);
    }

    @Test
    void testMapRow_ShouldReturnCustomerInformationWithValues_WhenFieldsAreNotNull() throws SQLException {
        when(resultSet.getString("NUM_CONTRATO")).thenReturn("295300");
        when(resultSet.getString("CID_CONTRATO")).thenReturn("25666");

        CustomerInformation customerInfo = rowMapper.mapRow(resultSet, 1);

        assertEquals("295300", customerInfo.getCustomerContractId());
        assertEquals("25666", customerInfo.getCityId());
    }

    @Test
    void testMapRow_ShouldReturnCustomerInformationWithNullValues_WhenFieldsAreNull() throws SQLException {
        when(resultSet.getString("NUM_CONTRATO")).thenReturn(null);
        when(resultSet.getString("CID_CONTRATO")).thenReturn(null);

        CustomerInformation customerInfo = rowMapper.mapRow(resultSet, 1);

        assertNull(customerInfo.getCustomerContractId());
        assertNull(customerInfo.getCityId());
    }

    @Test
    void testMapRow_ShouldReturnCustomerInformationWithEmptyValues_WhenFieldsAreEmpty() throws SQLException {
        when(resultSet.getString("NUM_CONTRATO")).thenReturn("");
        when(resultSet.getString("CID_CONTRATO")).thenReturn("");

        CustomerInformation customerInfo = rowMapper.mapRow(resultSet, 1);

        assertEquals("", customerInfo.getCustomerContractId());
        assertEquals("", customerInfo.getCityId());
    }
}
