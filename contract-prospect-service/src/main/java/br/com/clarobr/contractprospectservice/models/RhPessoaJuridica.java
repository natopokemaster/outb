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
@Table( name = "RH_PESSOA_JURIDICA", schema = "NETRDM")
@Data
@ToString
public class RhPessoaJuridica {
    @Id
    @Column(name = "ID_EMPRESA")
    @NotNull
    private String idEmpresa;

    @Column(name = "INSCRICAO_ESTADUAL")
    @NotNull
    private String inscricaoEstadual;

    @Column(name = "CGC")
    @NotNull
    private String cgc;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;
}
