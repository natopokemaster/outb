package br.com.clarobr.contractprospectservice.models;

import java.io.Serializable;
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
@Table( name = "SN_CONTRATO_COLETIVO", schema = "NETRDM")
@Data
@ToString
public class SnContratoColetivo implements Serializable {
    @Id
    @Column(name = "NUM_CONTRATO")
    @NotNull
    private Integer numContrato;

    @Column(name="CID_CONTRATO")
    @NotNull
    private String cidContrato;

    @Column(name = "CONTATO")
    @NotNull
    private String contato;

}
