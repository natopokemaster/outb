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
@Table(name = "RH_PESSOA", schema = "NETRDM")
@Data
@ToString
public class RhPessoa {
    @Id
    @Column(name = "ID_PESSOA")
    @NotNull
    private String idPessoa;

    @Column(name = "COD_TIPO_PESSOA")
    @NotNull
    private String codTipoPessoa;

    @Column(name = "NOME_PESSOA")
    @NotNull
    private String nomePessoa;

    @Column(name = "E_MAIL")
    @NotNull
    private String email;

    @Column(name = "TELEFONE")
    @NotNull
    private String telefone;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;

}
