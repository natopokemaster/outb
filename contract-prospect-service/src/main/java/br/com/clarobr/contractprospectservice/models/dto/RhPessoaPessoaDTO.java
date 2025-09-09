package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.RhPessoaPessoa;
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
public class RhPessoaPessoaDTO implements Serializable {

    private static final long serialVersionUID = 3698734267700276250L;

    private String idPessoaBase;

    private String idPessoa;

    private Integer idTipoRelacao;

    private Integer idStatus;

    private String codeBase;

    private String flStatusBi;

    public static RhPessoaPessoaDTO create(RhPessoaPessoa rhPessoaPessoa){
        if(Boolean.FALSE.equals(StringUtils.isNull(rhPessoaPessoa))){
            return new ModelMapper().map(rhPessoaPessoa, RhPessoaPessoaDTO.class);
        }
        return new RhPessoaPessoaDTO();
    }
}
