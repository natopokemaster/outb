package br.com.clarobr.serviceusagesbroadbands.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class CityIdRowMapper implements RowMapper<String> {

    @Override
    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
        return tratarCidContract(rs);
    }
    private String tratarCidContract(ResultSet rs) throws SQLException {
        var cityId = rs.getString("CITYID");
        // Se CITYID for null ou vazio, retorna um valor padrão " "
        return (cityId == null || cityId.isEmpty()) ? " " : cityId;
    }
}
