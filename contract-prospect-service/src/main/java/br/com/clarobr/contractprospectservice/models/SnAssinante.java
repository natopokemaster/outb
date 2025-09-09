package br.com.clarobr.contractprospectservice.models;

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
@Table( name = "SN_ASSINANTE", schema = "NETRDM")
@Data
@ToString
public class SnAssinante {
    @Id
    @Column(name = "ID_ASSINANTE")
    @NotNull
    private Long idAssinante;

    @Column(name = "DT_NASCIMENTO")
    @NotNull
    private Date dtNascimento;

    @Column(name = "CC_TEL_CEL")
    @NotNull
    private String ccTelCel;

    @Column(name = "CD_SUFRAMA")
    @NotNull
    private String cdSuframa;

    @Column(name = "CPF")
    @NotNull
    private String cpf;

    @Column(name = "ESTRANGEIRO")
    @NotNull
    private Integer estrangeiro;

    @Column(name = "E_MAIL")
    @NotNull
    private String email;

    @Column(name = "E_MAIL_DEFAULT")
    @NotNull
    private Integer emailDefault;

    @Column(name = "FAX")
    @NotNull
    private String fax;

    @Column(name = "ID_PROFISSAO")
    @NotNull
    private Integer idProfissao;

    @Column(name = "ID_SEXO")
    @NotNull
    private Integer idSexo;

    @Column(name = "ID_ESTADO_CIVIL")
    @NotNull
    private Integer idEstadoCivil;

    @Column(name = "ID_ESCOLARIDADE")
    @NotNull
    private Integer idEcoladorade;

    @Column(name = "ID_ORGAO_EXPEDIDOR")
    @NotNull
    private Integer idOrgaoExpedidor;

    @Column(name = "ID_TIPO_PESSOA")
    @NotNull
    private Integer idTipoPessoa;

    @Column(name = "NOME_MAE")
    @NotNull
    private String nomeMae;

    @Column(name = "NOME_PAI")
    @NotNull
    private String nomePai;

    @Column(name = "NOME_TITULAR")
    @NotNull
    private String nomeTitular;

    @Column(name = "NUM_RG")
    @NotNull
    private String numRg;

    @Column(name = "RAMAL")
    @NotNull
    private String ramal;

    @Column(name = "TEL_COM")
    @NotNull
    private String telCom;

    @Column(name = "TEL_OUTROS")
    @NotNull
    private String telOutros;

    @Column(name = "TEL_RES")
    @NotNull
    private String telRes;

    @Column(name = "CD_BASE")
    @NotNull
    private String codeBase;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;


}


