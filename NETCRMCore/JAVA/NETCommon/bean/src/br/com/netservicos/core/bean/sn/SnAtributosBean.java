package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * @hibernate.class
 *      table="sn_atributos"
 * 
 * @author Bruno Borges
 */
public class SnAtributosBean extends WebBean {

    private Long idAtributo = null;
    private String descricao = null;

    public SnAtributosBean() {
        super("idAtributo");
    }

    /**
     * @hibernate.property
     *      not-null="true"
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @hibernate.id
     *      generator-class="sequence"
     *      column="id_atributo"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="SSN_ID_ATRIBUTOS"
     * @return
     */
    public Long getIdAtributo() {
        return idAtributo;
    }

    public void setIdAtributo(Long idAtributo) {
        this.idAtributo = idAtributo;
    }

}