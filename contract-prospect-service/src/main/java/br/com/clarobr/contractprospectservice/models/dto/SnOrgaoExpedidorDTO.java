package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnOrgaoExpedidor;
import br.com.clarobr.contractprospectservice.util.StringUtils;
import java.io.Serializable;
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
public class SnOrgaoExpedidorDTO implements Serializable {

    private static final long serialVersionUID = -1834371658513496072L;
    private Integer idOrgaoExpedidor;

    private String descricao;

    private String codeBase;

    private String flStatusBi;

    public static SnOrgaoExpedidorDTO create(SnOrgaoExpedidor snOrgaoExpedidor){
        if(Boolean.FALSE.equals(StringUtils.isNull(snOrgaoExpedidor))){
            return new ModelMapper().map(snOrgaoExpedidor, SnOrgaoExpedidorDTO.class);
        }
        return new SnOrgaoExpedidorDTO();
    }
}
