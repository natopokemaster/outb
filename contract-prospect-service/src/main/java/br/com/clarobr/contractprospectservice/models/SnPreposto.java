package br.com.clarobr.contractprospectservice.models;

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
@Table(name = "SN_PREPOSTO", schema = "NETRDM")
@Data
@ToString
public class SnPreposto {
    @Id
    @Column(name = "ID_PREPOSTO")
    @NotNull
    private Integer idPreposto;

    @Column(name = "CID_CONTRATO")
    @NotNull
    private String cidContrato;

    @Column(name = "NUM_CONTRATO")
    @NotNull
    private Integer numContrato;

    @Column(name = "NOME_PREPOSTO")
    @NotNull
    private String nomePreposto;

    @Column(name = "RELACAO")
    @NotNull
    private String relacao;

    @Column(name = "CD_BASE")
    @NotNull
    private String cdBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;

}
