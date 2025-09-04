package br.com.clarobr.serviceusagesbroadbands.mapper;

import br.com.clarobr.serviceusagesbroadbands.models.DetailedUsage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BroadbandsDetailedRowMapper implements RowMapper<DetailedUsage> {

    @Override
    public DetailedUsage mapRow(ResultSet rs, int rowNum) throws SQLException {
        var detailedUsage = new DetailedUsage();

        detailedUsage.setCdEnderecavel(rs.getString("CD_ENDERECAVEL"));
        detailedUsage.setCidContrato(rs.getString("CID_CONTRATO"));
        detailedUsage.setDtConsumo(rs.getString("DT_CONSUMO"));
        detailedUsage.setIdPonto(rs.getLong("ID_PONTO"));
        detailedUsage.setNumContrato(rs.getString("NUM_CONTRATO"));
        detailedUsage.setVlBonus(rs.getBigDecimal("VL_BONUS"));
        detailedUsage.setVlFranquiaAcumulada(rs.getBigDecimal("VL_FRANQUIA_ACUMULADA"));
        detailedUsage.setVlFranquiaAdicional(rs.getBigDecimal("VL_FRANQUIA_ADICIONAL"));
        detailedUsage.setVlFranquiaAdicAcumAdq(rs.getBigDecimal("VL_FRANQUIA_ADIC_ACUM_ADQ"));
        detailedUsage.setVlFranquiaConsumida(rs.getBigDecimal("VL_FRANQUIA_CONSUMIDA"));
        detailedUsage.setVlFranquiaContrato(rs.getBigDecimal("VL_FRANQUIA_CONTRATO"));
        detailedUsage.setFcPenalizaNotifica(rs.getString("FC_PENALIZA_NOTIFICA"));
        detailedUsage.setPcFaixaPenalizaNotifica(rs.getString("PC_FAIXA_PENALIZA_NOTIFICA"));

        return detailedUsage;
    }
}
