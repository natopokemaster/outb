package br.com.clarobr.contractprospectservice.models.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;
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
public class Organization implements Serializable {

    private static final long serialVersionUID = 4995856145622934946L;

    private String id;
    private String organizationName;
    private List<OrganizationIdentifications> organizationIdentifications = new ArrayList<>();
    private String tradingName;
    private String operatorCode;
    private String cityId;
    private String operatorCityName;
}
