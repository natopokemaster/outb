package br.com.clarobr.contractprospectservice.models.objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.sql.Date;
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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerProspect implements Serializable {

    private static final long serialVersionUID = -2450429844356239119L;

    private Integer id;
    private String name;
    @JsonIgnore
    private String documentId;
    @JsonIgnore
    private String documentType;
    private String personType;
    private List<OrganizationIdentifications> organizationIdentifications;
    private List<IndividualIdentifications> individualIdentifications;
    private BusinessSegment businessSegment;
    private Occupation occupation;
    private Date foundationDate;
    private Date birthDate;
    private String organizationType;
    private OrganizationStatus organizationStatus;
    private String gender;
    private MaritalStatus maritalStatus;
    private Boolean isForeigner;
    private EducationLevel educationLevel;
    private String motherName;
    private String fatherName;
    private Email email;
    private List<Telephones> telephones;
    private Contract contract;


}

