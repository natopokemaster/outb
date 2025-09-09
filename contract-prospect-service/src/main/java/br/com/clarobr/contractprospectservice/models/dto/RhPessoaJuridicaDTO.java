package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.RhPessoaJuridica;
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
public class RhPessoaJuridicaDTO implements Serializable {

    private static final long serialVersionUID = 1195562204253357423L;

    private String idEmpresa;

    private String inscricaoEstadual;

    private String cgc;

    private String codeBase;

    private String flStatusBi;

    public static RhPessoaJuridicaDTO create(RhPessoaJuridica rhPessoaJuridica){
        if(Boolean.FALSE.equals(StringUtils.isNull(rhPessoaJuridica))){
            return new ModelMapper().map(rhPessoaJuridica, RhPessoaJuridicaDTO.class);
        }
        return new RhPessoaJuridicaDTO();
    }

}
