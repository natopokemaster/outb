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
@Table(name = "SN_TIPO_VENDA", schema = "NETRDM")
@Data
@ToString
public class SnTipoVenda {
    @Id
    @Column(name = "ID_TIPO_VENDA")
    @NotNull
    private Integer idTipoVenda;

    @Column(name = "DESCRICAO")
    @NotNull
    private String descricao;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;
}
