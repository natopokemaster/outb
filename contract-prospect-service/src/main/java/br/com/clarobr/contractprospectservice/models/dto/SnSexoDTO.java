 package br.com.clarobr.contractprospectservice.models.dto;

 import br.com.clarobr.contractprospectservice.models.SnSexo;
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
public class SnSexoDTO implements Serializable {

     private static final long serialVersionUID = 5584902876016798424L;
     private Integer idSexo;

    private String descricao;

     private String codeBase;

     private String flStatusBi;

    public static SnSexoDTO create(SnSexo snSexo){
        if(Boolean.FALSE.equals(StringUtils.isNull(snSexo))){
            return new ModelMapper().map(snSexo, SnSexoDTO.class);
        }
        return new SnSexoDTO();
    }
}
