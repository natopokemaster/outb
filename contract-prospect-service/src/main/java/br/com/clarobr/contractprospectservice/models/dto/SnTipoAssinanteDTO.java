package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnTipoAssinante;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.math.BigInteger;
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
public class SnTipoAssinanteDTO {

    private BigInteger idBi;

    private Integer idTipoAssinante;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnTipoAssinanteDTO create(SnTipoAssinante snTipoAssinante) {
        if(Boolean.FALSE.equals(StringUtils.isNull(snTipoAssinante))){
            return new ModelMapper().map(snTipoAssinante, SnTipoAssinanteDTO.class);
        }
        return new SnTipoAssinanteDTO();
    }
}
