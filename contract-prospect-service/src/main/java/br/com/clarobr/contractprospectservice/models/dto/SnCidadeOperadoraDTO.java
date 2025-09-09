package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnCidadeOperadora;
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
public class SnCidadeOperadoraDTO implements Serializable {


    private static final long serialVersionUID = -4010535985429272794L;

    private String cidContrato;

    private String ciNome;

    private String codOperadora;

    private String nomePessoa;

    private String razaoSocial;

    private String idEmpresa;

    private String codeBase;

    private String flStatusBi;

    public static SnCidadeOperadoraDTO create(SnCidadeOperadora snCidadeOperadora){
        if(Boolean.FALSE.equals(StringUtils.isNull(snCidadeOperadora))){
            return new ModelMapper().map(snCidadeOperadora, SnCidadeOperadoraDTO.class);
        }
        return new SnCidadeOperadoraDTO();
    }

}
