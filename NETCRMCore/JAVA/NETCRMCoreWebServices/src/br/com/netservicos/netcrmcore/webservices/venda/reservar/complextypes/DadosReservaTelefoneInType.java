package br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class DadosReservaTelefoneInType implements BaseComplexType {
      
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String ddd;
    private String telefone;
    
    public String getDdd() {
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
