package br.com.clarobr.contractprospectservice.models.output;

import br.com.clarobr.contractprospectservice.models.objects.CustomerProspect;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.List;
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
public class ContractProspectOutput implements Serializable {
    private static final long serialVersionUID = 6751292871553306427L;
    private List<CustomerProspect> customerProspects;

}
