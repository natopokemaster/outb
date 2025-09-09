package br.com.clarobr.contractprospectservice.models.address;

/**
 * @author Alan Ricardo
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contract {
    private String customerAccountId;
    private String operatorCode;
    private String cityId;
    private String baseCode;

}

