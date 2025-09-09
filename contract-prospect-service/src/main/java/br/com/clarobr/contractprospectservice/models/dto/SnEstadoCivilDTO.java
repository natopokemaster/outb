package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnEstadoCivil;
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
public class SnEstadoCivilDTO {

    private Integer idEstadoCivil;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnEstadoCivilDTO create(SnEstadoCivil snEstadoCivil){
        if(Boolean.FALSE.equals(StringUtils.isNull(snEstadoCivil))){
            return new ModelMapper().map(snEstadoCivil, SnEstadoCivilDTO.class);
        }
        return new SnEstadoCivilDTO();
    }
}
