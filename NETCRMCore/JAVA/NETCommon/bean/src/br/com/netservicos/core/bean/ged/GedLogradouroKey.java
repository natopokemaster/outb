package br.com.netservicos.core.bean.ged;

import java.io.Serializable;

public class GedLogradouroKey implements Serializable {

    private Long codLogradouro;
    private Long codCidade;

    public GedLogradouroKey() {
    }

    public GedLogradouroKey(Long codLogradouro, Long codCidade) {
        this.codLogradouro = codLogradouro;
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
        if (key instanceof GedLogradouroKey) {
            GedLogradouroKey comp = (GedLogradouroKey) key;
            return this.getCodLogradouro().equals(comp.getCodLogradouro())
                                                    && this.getCodCidade().equals(comp.getCodCidade());
        }
        else {
            return super.equals(key);
        }
    }

    public int hashCode() {
        final int prime = 32;
        int value = (getCodLogradouro().hashCode() + getCodCidade().hashCode() * 2);
        return (int) (value ^ (value >>> prime));
    }
    
}