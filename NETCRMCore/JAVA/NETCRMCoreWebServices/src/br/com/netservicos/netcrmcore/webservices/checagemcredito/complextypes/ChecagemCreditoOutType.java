package br.com.netservicos.netcrmcore.webservices.checagemcredito.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;

public class ChecagemCreditoOutType implements BaseComplexType {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private String statusCredito;

    public String getStatusCredito() {
        return statusCredito;
    }

    public void setStatusCredito(String statusCredito) {
        this.statusCredito = statusCredito;
    }
}
