package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnRelStatusContrato;
import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

/**
 * @author Alan Ricardo
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class SnRelStatusContratoDTO implements Serializable {

    private Integer numContrato;

    private String cidContrato;

    private Integer idStatus;

    private Date dtFim;

    private String codeBase;

    private String flStatusBi;

    public static SnStatusContratoDTO create(SnStatusContrato snStatusContrato ){
        if(Boolean.FALSE.equals(StringUtils.isNull(snStatusContrato))){
            return new ModelMapper().map(snStatusContrato, SnStatusContratoDTO.class);
        }
        return new SnStatusContratoDTO();
    }
}
