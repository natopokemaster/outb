package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnRazaoCancelamento;
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
public class SnRazaoCancelamentoDTO {

    private Integer idRazaoCancelamento;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnRazaoCancelamentoDTO create(SnRazaoCancelamento snRazaoCancelamento) {
        if (Boolean.FALSE.equals(StringUtils.isNull(snRazaoCancelamento))) {
            return new ModelMapper().map(snRazaoCancelamento, SnRazaoCancelamentoDTO.class);
        }
        return new SnRazaoCancelamentoDTO();
    }
}
