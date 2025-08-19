package br.com.netservicos.core.bean.ged;

import java.io.Serializable;

public class GedCidadeKey implements Serializable {

	private static final long serialVersionUID = -6226176756279021193L;
	
	private Long codCidade;
    private Long codOperadora;

    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_Cidade"
     * type = "long"
     */
	public Long getCodCidade() {
		return codCidade;
	}
    public GedCidadeKey() {
    }

	public void setCodCidade(Long codCidade) {
		this.codCidade = codCidade;
	}

	public GedCidadeKey(Long codCidade, Long codOperadora) {
        this.codCidade = codCidade;
        this.codOperadora = codOperadora;
    }
    
   
    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_operadora"
     * type = "long"
     */
    public Long getCodOperadora() {
        return codOperadora;
    }

    public void setCodOperadora(Long codOperadora) {
        this.codOperadora = codOperadora;
    }

    public boolean equals(Object key) {
        if (key instanceof GedCidadeKey) {
        	GedCidadeKey comp = (GedCidadeKey) key;
            return this.getCodCidade().equals(comp.getCodCidade())
                                                    && this.getCodOperadora().equals(comp.getCodOperadora());
        }
        else {
            return super.equals(key);
        }
    }

    public int hashCode() {
        final int prime = 32;
        int value = (getCodCidade().hashCode() + getCodOperadora().hashCode() * 2);
        return (int) (value ^ (value >>> prime));
    }
}