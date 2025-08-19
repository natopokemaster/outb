package br.com.netservicos.netcrmcore.webservices.checagemcredito.complextypes;

import br.com.netservicos.framework.core.bean.BaseComplexType;
import br.com.netservicos.netcrmcore.webservices.complextypes.IdentificacaoOperadoraType;

public class ChecagemCreditoInternoInType implements BaseComplexType{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3555694666821148411L;
	
	private IdentificacaoOperadoraType cidadeOperadora;
	private String idProspect;
	private String cpf;
	private String cnpj;
	private String idTipoPessoa;
	
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
   
	
}
