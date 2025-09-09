
package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnStatusContrato;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.io.Serializable;
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
public class SnStatusContratoDTO implements Serializable {

    private static final long serialVersionUID = -4087688106226882534L;
    private Integer idStatusContrato;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnStatusContratoDTO create(SnStatusContrato snStatusContrato){
        if(Boolean.TRUE.equals(!StringUtils.isNull(snStatusContrato))){
            return new ModelMapper().map(snStatusContrato, SnStatusContratoDTO.class);
        }
        return new SnStatusContratoDTO();
    }
}
