package br.com.clarobr.contractprospectservice.models;

import br.com.clarobr.contractprospectservice.models.dto.SnRelStatusContratoDTO;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.sql.Date;

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
@Table( name = "SN_REL_STATUS_CONTRATO", schema = "NETRDM")
@Data
@ToString
@SuppressWarnings("All")
public class SnRelStatusContrato {
    @Id
    @Column(name = "ID_STATUS")
    @NotNull
    private Integer idStatus;

    @Column(name = "DT_FIM")
    private Date dtFim;

    @Column(name = "NUM_CONTRATO")
    @NotNull
    private Integer numContrato;

    @Column(name="CID_CONTRATO")
    @NotNull
    private String cidContrato;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;

    public static SnRelStatusContrato create(SnRelStatusContratoDTO snRelStatusContratoDTO) {
        if(Boolean.FALSE.equals(StringUtils.isNull(snRelStatusContratoDTO))){
            return new ModelMapper().map(snRelStatusContratoDTO, SnRelStatusContrato.class);
        }
        return new SnRelStatusContrato();
    }
}
