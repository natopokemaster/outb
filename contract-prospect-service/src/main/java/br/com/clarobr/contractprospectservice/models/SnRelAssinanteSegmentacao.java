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
@Table( name = "SN_REL_ASSINANTE_SEGMENTACAO", schema = "NETRDM")
@Data
@ToString
@SuppressWarnings("All")
public class SnRelAssinanteSegmentacao {
    @Id
    @Column(name = "ID_REL_ASS_SEGMENTACAO")
    @NotNull
    private Integer idRelAssSegmentacao;

    @Column(name = "ID_TIPO_SEGMENTO")
    @NotNull
    private Integer idTipoSegmento;

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

}
