package br.com.clarobr.serviceusagesbroadbands.mapper;

import br.com.clarobr.serviceusagesbroadbands.models.CustomerInformation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerInformationRowMapper implements RowMapper<CustomerInformation> {
    @Override
    public CustomerInformation mapRow(ResultSet rs, int rowNum) throws SQLException {
        var customerInformation = new CustomerInformation();
        customerInformation.setCustomerContractId(rs.getString("NUM_CONTRATO"));
        customerInformation.setCityId(rs.getString("CID_CONTRATO"));
        return customerInformation;
    }

}
