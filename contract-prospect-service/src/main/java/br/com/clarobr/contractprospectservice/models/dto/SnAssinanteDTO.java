package br.com.clarobr.contractprospectservice.models.dto;

import br.com.clarobr.contractprospectservice.models.SnAssinante;
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
public class SnAssinanteDTO implements Serializable {

    private static final long serialVersionUID = -5018161104267779574L;

    private Integer idAssinante;

    private Date dtNascimento;

    private String ccTelCel;

    private String cdSuframa;

    private String cpf;

    private Integer estrangeiro;

    private String email;

    private Integer emailDefault;

    private String fax;

    private Integer idProfissao;

    private Integer idSexo;

    private Integer idEstadoCivil;

    private Integer idEcoladorade;

    private Integer idOrgaoExpedidor;

    private Integer idTipoPessoa;

    private String nomeMae;

    private String nomePai;

    private String nomeTitular;

    private String numRg;

    private String ramal;

    private String telCom;

    private String telOutros;

    private String telRes;

    private String codeBase;

    private String flStatusBi;

    public static SnAssinanteDTO create(SnAssinante snAssinante){
        if(Boolean.FALSE.equals(StringUtils.isNull(snAssinante))){
            return new ModelMapper().map(snAssinante, SnAssinanteDTO.class);
        }
        return new SnAssinanteDTO();
    }

}
