package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnProfissao;
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
public class SnProfissaoDTO {

    private Integer idProfissao;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnProfissaoDTO create(SnProfissao snProfissao){
        if(Boolean.FALSE.equals(StringUtils.isNull(snProfissao))){
            return new ModelMapper().map(snProfissao, SnProfissaoDTO.class);
        }
        return new SnProfissaoDTO();
    }
}
