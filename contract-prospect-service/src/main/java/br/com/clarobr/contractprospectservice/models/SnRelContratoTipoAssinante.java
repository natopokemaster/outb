package br.com.clarobr.contractprospectservice.models;

import java.math.BigInteger;
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

/**
 * @author Alan Ricardo
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table( name = "SN_REL_CONTRATO_TIPO_ASSINANTE", schema = "NETRDM")
@Data
@ToString
public class SnRelContratoTipoAssinante {
    @Id
    @Column(name = "ID_BI")
    @NotNull
    private BigInteger idBi;

    @Column(name = "NUM_CONTRATO")
    @NotNull
    private Integer numContrato;

    @Column(name="CID_CONTRATO")
    @NotNull
    private String cidContrato;

    @Column(name = "ID_TIPO_ASSINANTE")
    @NotNull
    private Integer idTipoAssinante;

    @Column(name = "DESCRICAO")
    @NotNull
    private String descricao;

    @Column(name = "DT_FIM")
    @NotNull
    private Date dtFim;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;
}
