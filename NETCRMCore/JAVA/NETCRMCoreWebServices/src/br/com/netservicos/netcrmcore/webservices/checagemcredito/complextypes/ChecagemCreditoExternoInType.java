package br.com.netservicos.netcrmcore.webservices.checagemcredito.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class ChecagemCreditoExternoInType implements BaseComplexType{
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private IdentificacaoOperadoraType cidadeOperadora;
    private String idProspect;
    private String cpf;
    private String cnpj;
    private String idTipoPessoa;
    private String userGC;
    private String passGC;
    private String userSerasa;
    private String passSerasa;
    
    public IdentificacaoOperadoraType getCidadeOperadora() {
           return cidadeOperadora;
    }
    public void setCidadeOperadora(IdentificacaoOperadoraType cidadeOperadora) {
           this.cidadeOperadora = cidadeOperadora;
    }

    public String getIdProspect() {
        return idProspect;
    }
    public void setIdProspect(String idProspect) {
        this.idProspect = idProspect;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getIdTipoPessoa() {
        return idTipoPessoa;
    }
    public void setIdTipoPessoa(String idTipoPessoa) {
        this.idTipoPessoa = idTipoPessoa;
    }
    
    public String getUserGC() {
        return userGC;
    }
    public void setUserGC(String userGC) {
        this.userGC = userGC;
    }
    public String getPassGC() {
        return passGC;
    }
    public void setPassGC(String passGC) {
        this.passGC = passGC;
    }
    public String getUserSerasa() {
        return userSerasa;
    }
    public void setUserSerasa(String userSerasa) {
        this.userSerasa = userSerasa;
    }
    public String getPassSerasa() {
        return passSerasa;
    }
    public void setPassSerasa(String passSerasa) {
        this.passSerasa = passSerasa;
    }

}
