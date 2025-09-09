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
@Table(name = "RH_PESSOA_PESSOA", schema = "NETRDM")
@Data
@ToString
public class RhPessoaPessoa {
    @Id
    @Column(name = "ID_PESSOA_BASE")
    @NotNull
    private String idPessoaBase;

    @Column(name = "ID_PESSOA")
    @NotNull
    private String idPessoa;

    @Column(name = "ID_TIPO_RELACAO")
    @NotNull
    private Integer idTipoRelacao;

    @Column(name = "ID_STATUS")
    @NotNull
    private Integer idStatus;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;
}
