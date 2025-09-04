package br.com.clarobr.serviceusagesbroadbands.mapper;

import br.com.clarobr.serviceusagesbroadbands.models.DetailedUsage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BroadbandsDetailedRowMapperTest {

    private BroadbandsDetailedRowMapper rowMapper;
    private ResultSet resultSet;

    @BeforeEach
    void setUp() {
        rowMapper = new BroadbandsDetailedRowMapper();
        resultSet = Mockito.mock(ResultSet.class);
    }

    @Test
    void testMapRow_ShouldMapResultSetToDetailedUsage() throws SQLException {
        // Configura o mock para o result set
        when(resultSet.getString("CD_ENDERECAVEL")).thenReturn("000E5CDDDE92");
        when(resultSet.getString("CID_CONTRATO")).thenReturn("25666");
        when(resultSet.getString("DT_CONSUMO")).thenReturn("2023-10-01");
        when(resultSet.getLong("ID_PONTO")).thenReturn(19845L);
        when(resultSet.getString("NUM_CONTRATO")).thenReturn("295300");
        when(resultSet.getBigDecimal("VL_BONUS")).thenReturn(new BigDecimal("10.00"));
        when(resultSet.getBigDecimal("VL_FRANQUIA_ACUMULADA")).thenReturn(new BigDecimal("5.00"));
        when(resultSet.getBigDecimal("VL_FRANQUIA_ADICIONAL")).thenReturn(new BigDecimal("15.00"));
        when(resultSet.getBigDecimal("VL_FRANQUIA_ADIC_ACUM_ADQ")).thenReturn(new BigDecimal("20.00"));
        when(resultSet.getBigDecimal("VL_FRANQUIA_CONSUMIDA")).thenReturn(new BigDecimal("25.00"));
        when(resultSet.getBigDecimal("VL_FRANQUIA_CONTRATO")).thenReturn(new BigDecimal("50.00"));
        when(resultSet.getString("FC_PENALIZA_NOTIFICA")).thenReturn("N");
        when(resultSet.getString("PC_FAIXA_PENALIZA_NOTIFICA")).thenReturn("50");


        DetailedUsage detailedUsage = rowMapper.mapRow(resultSet, 1);

        // assert
        assertEquals("000E5CDDDE92", detailedUsage.getCdEnderecavel());
        assertEquals("25666", detailedUsage.getCidContrato());
        assertEquals("2023-10-01", detailedUsage.getDtConsumo());
        assertEquals(19845L, detailedUsage.getIdPonto());
        assertEquals("295300", detailedUsage.getNumContrato());
        assertEquals(new BigDecimal("10.00"), detailedUsage.getVlBonus());
        assertEquals(new BigDecimal("5.00"), detailedUsage.getVlFranquiaAcumulada());
        assertEquals(new BigDecimal("15.00"), detailedUsage.getVlFranquiaAdicional());
        assertEquals(new BigDecimal("20.00"), detailedUsage.getVlFranquiaAdicAcumAdq());
        assertEquals(new BigDecimal("25.00"), detailedUsage.getVlFranquiaConsumida());
        assertEquals(new BigDecimal("50.00"), detailedUsage.getVlFranquiaContrato());
        assertEquals("N", detailedUsage.getFcPenalizaNotifica());
        assertEquals("50", detailedUsage.getPcFaixaPenalizaNotifica());
    }
}
