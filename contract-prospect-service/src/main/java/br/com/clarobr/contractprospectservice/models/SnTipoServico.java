package br.com.clarobr.contractprospectservice.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Raphael Zanarelli
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "SN_TIPO_SERVICO", schema = "NETRDM")
@Data
@ToString
public class SnTipoServico {

    @Id
    @Column(name = "ID_TIPO_SERVICO")
    @NotNull
    private Integer id;

    @Column(name = "DS_DESCRICAO")
    @NotNull
    private String description;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;
}
