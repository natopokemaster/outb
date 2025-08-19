package br.com.netservicos.core.bean.ged;

import java.io.Serializable;

public class GedBairroKey implements Serializable {

    private Long codBairro;
    private Long codCidade;

    public GedBairroKey() {
    }

    public GedBairroKey(Long codBairro, Long codCidade) {
        this.codBairro = codBairro;
        this.codCidade = codCidade;
    }
    
    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_bairro"
     * type = "long"
     */
    public Long getCodBairro() {
        return codBairro;
    }

    public void setCodBairro(Long codBairro) {
        this.codBairro = codBairro;
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

    public boolean equals(Object key) {
        if (key instanceof GedBairroKey) {
            GedBairroKey comp = (GedBairroKey) key;
            return this.getCodBairro().equals(comp.getCodBairro())
                                                    && this.getCodCidade().equals(comp.getCodCidade());
        }
        else {
            return super.equals(key);
        }
    }

    public int hashCode() {
        final int prime = 32;
        int value = (getCodBairro().hashCode() + getCodCidade().hashCode() * 2);
        return (int) (value ^ (value >>> prime));
    }
    
}