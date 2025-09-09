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
@Table(name = "VSN_VENDEDORES", schema = "NETRDM")
@Data
@ToString
public class VsnVendedores {
    @Id
    @Column(name = "ID_VENDEDOR")
    @NotNull
    private String idVendedor;

    @Column(name = "ID_EMPRESA")
    @NotNull
    private String idEmpresa;

    @Column(name = "NOME_VENDEDOR")
    @NotNull
    private String nomeVendedor;

    @Column(name = "NOME_EMPRESA")
    @NotNull
    private String nomeEmpresa;

    @Column(name = "NOME_PESSOA")
    @NotNull
    private String nomePessoa;

    @Column(name = "ID_PESSOA")
    @NotNull
    private String idPessoa;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;
}
