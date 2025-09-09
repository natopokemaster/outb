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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class OrganizationStatus implements Serializable {

    private static final long serialVersionUID = -3082935967755292351L;

    private Integer id;
    private String description;
}
