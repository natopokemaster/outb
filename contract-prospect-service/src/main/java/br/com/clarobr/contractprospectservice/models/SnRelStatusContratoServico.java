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
import java.sql.Date;

/**
 * @author Raphael Zanarelli
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table( name = "SN_REL_STATUS_CTO_SERV", schema = "NETRDM")
@Data
@ToString
public class SnRelStatusContratoServico {
    @Id
    @Column(name = "ID_STATUS_CONTRATO")
    private Integer contractStatusId;

    @Column(name = "ID_TIPO_SERVICO")
    private Integer serviceTypeId;

    @Column(name = "NUM_CONTRATO")
    private Integer contractNumber;

    @Column(name="CID_CONTRATO")
    private String cityCode;

    @Column(name = "DT_FIM")
    private Date endDate;

    @Column(name = "FL_STATUS_BI")
    @NotNull
    private String flStatusBi;

    @Column(name = "CD_BASE")
    private String baseCode;

}
