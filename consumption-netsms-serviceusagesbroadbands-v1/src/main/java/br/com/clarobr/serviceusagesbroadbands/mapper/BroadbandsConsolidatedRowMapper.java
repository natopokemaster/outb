package br.com.clarobr.serviceusagesbroadbands.mapper;

import br.com.clarobr.serviceusagesbroadbands.models.ConsolidatedUsage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BroadbandsConsolidatedRowMapper implements RowMapper<ConsolidatedUsage> {
    @Override
    public ConsolidatedUsage mapRow(ResultSet rs, int rowNum) throws SQLException {
        var consolidatedUsage = new ConsolidatedUsage();

        consolidatedUsage.setQuota(rs.getBigDecimal("FRANQUIA_CONTRATADA"));
        consolidatedUsage.setTotalUtilizado(rs.getBigDecimal("CONSUMO_TOTAL"));
        consolidatedUsage.setFranquiaContratada(rs.getBigDecimal("FRANQUIA_ADICIONAL_ADQUIRIDA"));
        consolidatedUsage.setTotalDisponivel(rs.getBigDecimal("SALDO_TOTAL"));
        consolidatedUsage.setPercentualUtilizado(rs.getBigDecimal("PERCENTUAL_UTILIZADO"));
        consolidatedUsage.setValidadeCredito(rs.getString("DATA_MAXIMA_CONSUMO"));

        return consolidatedUsage;
    }
}


