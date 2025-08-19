package br.com.netservicos.core.bean.ged;

import java.io.Serializable;

public class GedHpImovelKey implements Serializable {

	private static final long serialVersionUID = -6226176756279021193L;
	
	private Long codHP;
    private Long codOperadora;

    public GedHpImovelKey() {
    }

    public GedHpImovelKey(Long codHP, Long codOperadora) {
        this.codHP = codHP;
        this.codOperadora = codOperadora;
    }
    
    /** 
     * @return Long
     * 
     * @hibernate.property
     * column="cod_hp"
     * type = "long"
     */
    public Long getCodHP() {
        return codHP;
    }

    public void setCodHP(Long codHP) {
        this.codHP = codHP;
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
        if (key instanceof GedHpImovelKey) {
            GedHpImovelKey comp = (GedHpImovelKey) key;
            return this.getCodHP().equals(comp.getCodHP())
                                                    && this.getCodOperadora().equals(comp.getCodOperadora());
        }
        else {
            return super.equals(key);
        }
    }

    public int hashCode() {
        final int prime = 32;
        int value = (getCodHP().hashCode() + getCodOperadora().hashCode() * 2);
        return (int) (value ^ (value >>> prime));
    }
    
}