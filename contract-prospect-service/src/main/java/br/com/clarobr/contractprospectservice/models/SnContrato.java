package br.com.clarobr.contractprospectservice.models;

import java.io.Serializable;
import java.sql.Date;
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
@Table( name = "SN_CONTRATO", schema = "NETRDM")
@Data
@ToString
public class SnContrato implements Serializable {
    @Id
    @Column(name = "NUM_CONTRATO")
    @NotNull
    private Integer numContrato;

    @Column(name="CID_CONTRATO")
    @NotNull
    private String cidContrato;

    @Column(name = "ID_ASSINANTE")
    @NotNull
    private Integer idAssinante;

    @Column(name = "ID_PESSOA_FISICA")
    @NotNull
    private String idPessoaFisica;

    @Column(name = "OBS")
    @NotNull
    private String obs;

    @Column(name = "DIGITO_VERIFICACAO")
    @NotNull
    private Integer digitoVerificacao;

    @Column(name = "ID_TIPO_VENDA")
    @NotNull
    private Integer idTipoVenda;

    @Column(name = "ID_TIPO_CONTRATO")
    @NotNull
    private Integer idTipoContrato;

    @Column(name = "DT_VENDA")
    @NotNull
    private Date dtVenda;

    @Column(name = "DT_CANCELAMENTO")
    @NotNull
    private Date dtCancelamento;

    @Column(name = "DT_CADASTRO")
    @NotNull
    private Date dtCadastro;

    @Column(name = "ID_RAZAO_CANCELAMENTO")
    @NotNull
    private Integer idRazaoCancelamento;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "NUM_CONTRATO_EMBRATEL")
    private String embratelContractNumber;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;

    @Column(name = "USR_ATENDENTE")
    private String usrAtend;

}
