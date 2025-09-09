package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnPreposto;
import br.com.clarobr.contractprospectservice.util.StringUtils;
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
public class SnPrepostoDTO {

    private Integer idPreposto;

    private String cidContrato;

    private Integer numContrato;

    private String nomePreposto;

    private String relacao;

    private String cdBase;

    private String flStatusBi;

    public static SnPrepostoDTO create(SnPreposto snPreposto){
        if(Boolean.FALSE.equals(StringUtils.isNull(snPreposto))){
            return new ModelMapper().map(snPreposto, SnPrepostoDTO.class);
        }
        return new SnPrepostoDTO();
    }
}
