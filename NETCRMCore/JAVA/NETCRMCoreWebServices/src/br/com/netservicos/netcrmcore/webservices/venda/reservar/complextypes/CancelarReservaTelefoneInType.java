package br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class CancelarReservaTelefoneInType implements BaseComplexType {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private IdentificacaoOperadoraType cidadeOperadora;
    private String idProposta;
    
    public IdentificacaoOperadoraType getCidadeOperadora() {
        return cidadeOperadora;
    }

    public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
        this.cidadeOperadora = cidadeOperadora;
    }  

    public String getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(String idProposta) {
        this.idProposta = idProposta;
    }

      

}
