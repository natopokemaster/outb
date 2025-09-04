package br.com.clarobr.serviceusagesbroadbands.mapper;

import br.com.clarobr.serviceusagesbroadbands.models.ConsolidatedUsage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BroadbandsConsolidatedRowMapperTest {

    private BroadbandsConsolidatedRowMapper rowMapper;
    private ResultSet resultSet;

    @BeforeEach
    void setUp() {
        rowMapper = new BroadbandsConsolidatedRowMapper();
        resultSet = Mockito.mock(ResultSet.class);
    }

    @Test
    void testMapRow_ShouldMapResultSetToConsolidatedUsage() throws SQLException {

        // Configura o mock para o result set
        when(resultSet.getBigDecimal("FRANQUIA_CONTRATADA")).thenReturn(new BigDecimal("2000"));
        when(resultSet.getBigDecimal("CONSUMO_TOTAL")).thenReturn(new BigDecimal("1000"));
        when(resultSet.getBigDecimal("FRANQUIA_ADICIONAL_ADQUIRIDA")).thenReturn(new BigDecimal("0"));
        when(resultSet.getBigDecimal("SALDO_TOTAL")).thenReturn(new BigDecimal("1000"));
        when(resultSet.getBigDecimal("PERCENTUAL_UTILIZADO")).thenReturn(new BigDecimal("50"));
        when(resultSet.getString("DATA_MAXIMA_CONSUMO")).thenReturn("2023-12-31");

        ConsolidatedUsage consolidatedUsage = rowMapper.mapRow(resultSet, 1);

        // verifica se os valores foram mapeados
        assertEquals(new BigDecimal("2000"), consolidatedUsage.getQuota());
        assertEquals(new BigDecimal("1000"), consolidatedUsage.getTotalUtilizado());
        assertEquals(new BigDecimal("0"), consolidatedUsage.getFranquiaContratada());
        assertEquals(new BigDecimal("1000"), consolidatedUsage.getTotalDisponivel());
        assertEquals(new BigDecimal("50"), consolidatedUsage.getPercentualUtilizado());
        assertEquals("2023-12-31", consolidatedUsage.getValidadeCredito());
    }
}
