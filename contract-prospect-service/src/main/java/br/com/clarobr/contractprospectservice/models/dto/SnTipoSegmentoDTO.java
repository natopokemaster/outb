package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnTipoSegmento;
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
public class SnTipoSegmentoDTO implements Serializable {

    private static final long serialVersionUID = 6741551264111546302L;
    private Integer idTipoSegmento;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnTipoSegmentoDTO create(SnTipoSegmento snTipoSegmento){
        if(Boolean.FALSE.equals(StringUtils.isNull(snTipoSegmento))){
            return new ModelMapper().map(snTipoSegmento, SnTipoSegmentoDTO.class);
        }
        return new SnTipoSegmentoDTO();
    }
}
