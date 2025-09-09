package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnTipoContrato;
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
public class SnTipoContratoDTO implements Serializable {

    private static final long serialVersionUID = -2730442490192964556L;
    private Integer idTipoContrato;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnTipoContratoDTO create(SnTipoContrato snTipoContrato) {
        if(Boolean.FALSE.equals(StringUtils.isNull(snTipoContrato))){
            return new ModelMapper().map(snTipoContrato, SnTipoContratoDTO.class);
        }
        return new SnTipoContratoDTO();
    }
}
