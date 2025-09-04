package br.com.clarobr.serviceusagesbroadbands.mapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CityIdRowMapperTest {

    private final CityIdRowMapper rowMapper = new CityIdRowMapper();
    private final ResultSet resultSet = mock(ResultSet.class);

    @ParameterizedTest
    @ValueSource(strings = {"25666", "", "null"})
    void testMapRow_ShouldReturnCorrectCityId(String cityIdValue) throws SQLException {
        if ("null".equals(cityIdValue)) {
            when(resultSet.getString("CITYID")).thenReturn(null);
        } else {
            when(resultSet.getString("CITYID")).thenReturn(cityIdValue);
        }

        // Executa o método mapRow
        String cityId = rowMapper.mapRow(resultSet, 1);

        // Determina o valor esperado com base no valor do parâmetro
        String expected = ("null".equals(cityIdValue) || cityIdValue.isEmpty()) ? " " : cityIdValue;

        // assert
        assertEquals(expected, cityId);
    }


}
