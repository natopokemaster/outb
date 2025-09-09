package br.com.clarobr.contractprospectservice.models.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.sql.Date;
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
public class Sale implements Serializable {

    private static final long serialVersionUID = -2399208566510983154L;

    private Type type;
    private Date purchaseDate;
    private Date cancellationDate;
    private CancellationReason cancellationReason;
    private Date requestDate;

}
