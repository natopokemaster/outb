package br.com.netservicos.core.bean.ged;

import java.io.Serializable;

public class GedEnderecoKey implements Serializable {

    private Long codEndereco;
    private Long codCidade;
    private Long codLogradouro;

    public GedEnderecoKey() {
    }

    public GedEnderecoKey(Long codEndereco, Long codCidade, Long codLogradouro) {
        this.codEndereco = codEndereco;
        this.codCidade = codCidade;
        this.codLogradouro = codLogradouro;
    }
    
    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_endereco"
     * type = "long"
     */
    public Long getCodEndereco() {
        return codEndereco;
    }

    public void setCodEndereco(Long codEndereco) {
        this.codEndereco = codEndereco;
    }
    
    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_cidade"
     * type = "long"
     */
    public Long getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(Long codCidade) {
        this.codCidade = codCidade;
    }
    
    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_logradouro"
     * type = "long"
     */
    public Long getCodLogradouro() {
        return codLogradouro;
    }

    public void setCodLogradouro(Long codLogradouro) {
        this.codLogradouro = codLogradouro;
    }

    public boolean equals(Object key) {
        if (key instanceof GedEnderecoKey) {
            GedEnderecoKey comp = (GedEnderecoKey) key;
            return this.getCodEndereco().equals(comp.getCodEndereco())
                                                    && this.getCodCidade().equals(comp.getCodCidade())
                                                    && this.getCodLogradouro().equals(comp.getCodLogradouro());
        }
        else {
            return super.equals(key);
        }
    }

    public int hashCode() {
        final int prime = 32;
        int value = (getCodEndereco().hashCode() + getCodCidade().hashCode() + getCodLogradouro().hashCode() * 2);
        return (int) (value ^ (value >>> prime));
    }
    
}