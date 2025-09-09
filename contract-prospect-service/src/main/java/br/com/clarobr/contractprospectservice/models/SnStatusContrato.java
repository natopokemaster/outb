package br.com.clarobr.contractprospectservice.models;

import br.com.clarobr.contractprospectservice.models.dto.SnStatusContratoDTO;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@Entity
@Table(name = "SN_STATUS_CONTRATO", schema = "NETRDM")
@Data
@ToString
public class SnStatusContrato {
    @Id
    @Column(name = "ID_STATUS_CONTRATO")
    @NotNull
    private Integer idStatusContrato;

    @Column(name = "DESCRICAO")
    @NotNull
    private String descricao;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;

    public static SnStatusContrato create(SnStatusContratoDTO consult) {
        if(Boolean.FALSE.equals(StringUtils.isNull(consult))){
            return new ModelMapper().map(consult, SnStatusContrato.class);
        }
        return new SnStatusContrato();
    }
}
