package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnRelAssinanteSegmentacao;
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
public class SnRelAssinanteSegmentacaoDTO {

    private Integer idRelAssSegmentacao;

    private Integer idTipoSegmento;

    private Integer numContrato;

    private String cidContrato;

    private String codeBase;

    private String flStatusBi;

    public static SnRelAssinanteSegmentacaoDTO create(SnRelAssinanteSegmentacao snRelAssinanteSegmentacao){
        if(Boolean.FALSE.equals(StringUtils.isNull(snRelAssinanteSegmentacao))){
            return new ModelMapper().map(snRelAssinanteSegmentacao, SnRelAssinanteSegmentacaoDTO.class);
        }
        return new SnRelAssinanteSegmentacaoDTO();
    }

}
