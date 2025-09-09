package br.com.clarobr.contractprospectservice.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
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
@Table(name = "SN_TELEFONE_VOIP", schema = "NETRDM")
@Data
@ToString
@IdClass(SnTelefoneVoip.TelefoneVoipId.class)
public class SnTelefoneVoip {

    @Id
    @Column(name = "DDD_TELEFONE_VOIP")
    @NotNull
    private String dddTelefoneVoip;

    @Id
    @Column(name = "NUM_TELEFONE_VOIP")
    @NotNull
    private String numTelefoneVoip;

    @Id
    @Column(name = "DT_FIM")
    @NotNull
    private Date dtFim;

    @Id
    @Column(name = "DT_INI")
    @NotNull
    private Date dtIni;

    @Column(name = "ID_STATUS_TELEFONE_VOIP")
    @NotNull
    private String idStatusTelefoneVoip;

    @Column(name = "NUM_CONTRATO")
    @NotNull
    private Integer numContrato;

    @Column(name = "CID_CONTRATO")
    @NotNull
    private String cidContrato;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;


    @Getter
    @Setter
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TelefoneVoipId implements Serializable {
        private static final long serialVersionUID = -6606963069522290442L;
        private String dddTelefoneVoip;
        private String numTelefoneVoip;
        private Date dtFim;
        private Date dtIni;
    }
}
