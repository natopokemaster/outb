package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnContrato;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.io.Serializable;
import java.sql.Date;
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
public class SnContratoDTO implements Serializable {

    private Integer numContrato;

    private String cidContrato;

    private Long idAssinante;

    private String idPessoaFisica;

    private String obs;

    private Integer digitoVerificacao;

    private Integer idTipoVenda;

    private Integer idTipoContrato;

    private Date dtVenda;

    private Date dtCancelamento;

    private Date dtCadastro;

    private Integer idRazaoCancelamento;

    private String codeBase;

    private String flStatusBi;

    private String embratelContractNumber;

    private String usrAtend;

    public static SnContratoDTO create(SnContrato snContrato){
        if(Boolean.FALSE.equals(StringUtils.isNull(snContrato))){
            return new ModelMapper().map(snContrato, SnContratoDTO.class);
        }
        return new SnContratoDTO();
    }
}
