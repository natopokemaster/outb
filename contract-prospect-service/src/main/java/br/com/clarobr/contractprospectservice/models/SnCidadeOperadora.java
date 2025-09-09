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
@Table( name = "SN_CIDADE_OPERADORA", schema = "NETRDM")
@Data
@ToString
public class SnCidadeOperadora {

    @Id
    @Column(name="CID_CONTRATO")
    @NotNull
    private String cidContrato;

    @Column(name = "CI_NOME")
    @NotNull
    private String ciNome;

    @Column(name = "COD_OPERADORA")
    @NotNull
    private String codOperadora;

    @Column(name = "NOME_PESSOA")
    @NotNull
    private String nomePessoa;

    @Column(name = "RAZAO_SOCIAL")
    @NotNull
    private String razaoSocial;

    @Column(name = "ID_EMPRESA")
    @NotNull
    private String idEmpresa;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;
}
