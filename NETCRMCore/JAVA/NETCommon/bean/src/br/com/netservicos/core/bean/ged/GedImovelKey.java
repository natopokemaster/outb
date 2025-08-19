package br.com.netservicos.core.bean.ged;

import java.io.Serializable;

public class GedImovelKey implements Serializable {

	private static final long serialVersionUID = 2749233340951100024L;
	private Long codImovel;
    private Long codOperadora;

    public GedImovelKey() {
    }

    public GedImovelKey(Long codImovel, Long codOperadora) {
        this.codImovel = codImovel;
        this.codOperadora = codOperadora;
    }
    
    /** 
	 * @return Long
	 * 
	 * @hibernate.property
	 * column="cod_imovel"
	 * type = "long"
	 */
    public Long getCodImovel() {
        return codImovel;
    }

    public void setCodImovel(Long codImovel) {
        this.codImovel = codImovel;
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
        if (key instanceof GedImovelKey) {
            GedImovelKey comp = (GedImovelKey) key;
            return this.getCodImovel().equals(comp.getCodImovel())
                                                    && this.getCodOperadora().equals(comp.getCodOperadora());
        }
        else {
            return super.equals(key);
        }
    }

    public int hashCode() {
        final int prime = 32;
        int value = (getCodImovel().hashCode() + getCodOperadora().hashCode() * 2);
        return (int) (value ^ (value >>> prime));
    }
    
}