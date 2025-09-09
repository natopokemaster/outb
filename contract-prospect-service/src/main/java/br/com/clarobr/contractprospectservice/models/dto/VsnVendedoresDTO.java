package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.VsnVendedores;
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
public class VsnVendedoresDTO implements Serializable {

    private static final long serialVersionUID = -219577843246482974L;
    private String idVendedor;

    private String idEmpresa;

    private String nomeVendedor;

    private String nomeEmpresa;

    private String nomePessoa;

    private String email;

    private String telefone;

    private String idPessoa;

    private String codeBase;

    private String flStatusBi;

    public static VsnVendedoresDTO create(VsnVendedores vsnVendedores) {
        if(Boolean.FALSE.equals(StringUtils.isNull(vsnVendedores))){
            return new ModelMapper().map(vsnVendedores, VsnVendedoresDTO.class);
        }
        return new VsnVendedoresDTO();
    }
}
