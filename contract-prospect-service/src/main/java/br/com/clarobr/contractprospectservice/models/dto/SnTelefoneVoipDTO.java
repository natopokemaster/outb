package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnTelefoneVoip;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.io.Serializable;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

/**
 * @author Alan Ricardo
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
public class SnTelefoneVoipDTO implements Serializable {

    private static final long serialVersionUID = -6984249718050917956L;
    private String dddTelefoneVoip;

    private String numTelefoneVoip;

    private Date dtFim;

    private Date dtIni;

    private String idStatusTelefoneVoip;

    private Integer numContrato;

    private String cidContrato;

    private String codeBase;

    private String flStatusBi;

    public static SnTelefoneVoipDTO create(SnTelefoneVoip telefoneVoip){
        if(Boolean.FALSE.equals(StringUtils.isNull(telefoneVoip))){
            return new ModelMapper().map(telefoneVoip, SnTelefoneVoipDTO.class);
        }
        return new SnTelefoneVoipDTO();
    }
}
