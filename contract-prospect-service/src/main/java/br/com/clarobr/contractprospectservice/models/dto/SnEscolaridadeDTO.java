package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnEscolaridade;
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
public class SnEscolaridadeDTO {

    private Integer idEscolaridade;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnEscolaridadeDTO create(SnEscolaridade snEscolaridade){
        if(Boolean.FALSE.equals(StringUtils.isNull(snEscolaridade))){
            return new ModelMapper().map(snEscolaridade, SnEscolaridadeDTO.class);
        }
        return new SnEscolaridadeDTO();
    }
}
