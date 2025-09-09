package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnTipoVenda;
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
public class SnTipoVendaDTO implements Serializable {

    private static final long serialVersionUID = 5156643330087726208L;
    private Integer idTipoVenda;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnTipoVendaDTO create(SnTipoVenda snTipoVenda){
        if(Boolean.FALSE.equals(StringUtils.isNull(snTipoVenda))){
            return new ModelMapper().map(snTipoVenda, SnTipoVendaDTO.class);
        }
        return new SnTipoVendaDTO();
    }
}
