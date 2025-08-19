package br.com.netservicos.netcrmcore.webservices.venda.reservar.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class CancelarReservaTelefoneOutType implements BaseComplexType  {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
