package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.RhPessoa;
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
public class RhPessoaDTO implements Serializable {

    private static final long serialVersionUID = -7510185789690967600L;

    private String idPessoa;

    private String codTipoPessoa;

    private String nomePessoa;

    private String email;

    private String telefone;

    private String codeBase;

    private String flStatusBi;

    public static RhPessoaDTO create(RhPessoa rhPessoa){
        if(Boolean.FALSE.equals(StringUtils.isNull(rhPessoa))){
            return new ModelMapper().map(rhPessoa, RhPessoaDTO.class);
        }
        return new RhPessoaDTO();
    }

}
