package br.com.clarobr.contractprospectservice.models.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Alan Ricardo
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contract implements Serializable {

    private static final long serialVersionUID = -4775630475768166737L;

    private Integer customerAccountId;
    private Integer verificationDigit;
    private Organization organization =  new Organization();
    private Type type = new Type();
    private Sale sale = new Sale();
    private Status status = new Status();
    private Partner partner = new Partner();
    private String productName;
    private Segment segment = new Segment();
    private SalesPerson salesPerson = new SalesPerson();
    private String note;
    private Agent agent = new Agent();
    private String suframaCode;
    private String customerSegmentType;
    private String embratelContractNumber;

}
