/*
 * Created on 17/01/2005
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Bean que representa a tabela SN_REL_ATRIBUTOS_PARAMETROS.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Adição dos métodos equals, hashCode e
 * toString									10/10/2006	Rafael Nami
 * Adição da HQL 
 * lstClassificacaoSelecaoPopup				20/03/2007  Rafael Nami
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 17/01/2005 Bruno Borges   1.0      Entidades      Development.
 * 10/10/2006 Rafael Nami    1.1	  NETCommon		 Desenvolvido.
 * 20/03/2007 Rafael Nami	 1.2	  NETCommon		 Atualizado.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class
 *      table="sn_rel_atributos_produto"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true"
 *
 *      
 * @author Bruno Borges
 */
public class SnRelAtributosProdutoBean extends WebBean {

	private static final long serialVersionUID = 8020655268467471396L;
	private SnRelAtributosParametroBean atributoParametro = null;
    private Long idAtributoProduto = null;
    private SnProdutoBean produto = null;

    public SnRelAtributosProdutoBean() {
        super("idAtributoProduto");
    }

    /**
     * @hibernate.many-to-one
     *      column="id_atributo_parametro"
     * @return
     */
    public SnRelAtributosParametroBean getAtributoParametro() {
        return atributoParametro;
    }

    /**
     * @hibernate.id
     *      generator-class="sequence"
     *      column="id_atributo_produto"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="SSN_ID_ATRIBUTO_PRODUTO"
     * @return
     */
    public Long getIdAtributoProduto() {
        return idAtributoProduto;
    }

    /**
     * @hibernate.many-to-one
     *      column="id_produto"
     * @return
     */
    public SnProdutoBean getProduto() {
        return produto;
    }

    public void setAtributoParametro(SnRelAtributosParametroBean atributo) {
        this.atributoParametro = atributo;
    }

    public void setIdAtributoProduto(Long idAtributoParametro) {
        this.idAtributoProduto = idAtributoParametro;
    }

    public void setProduto(SnProdutoBean produto) {
        this.produto = produto;
    }

    /**
	 * Método responsável por comparação atributo a atributo entre duas instâncias
	 * de uma classe
	 * @param 	o 	Objeto a ser comparado com a instância da classe atual.
	 * @return 	se as duas instâncias são iguais ou não. 
	 * 
	 * @author Rafael Nami
	 * @since  10/10/2006
	 */
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SnRelAtributosProdutoBean))
			return false;
		SnRelAtributosProdutoBean obj = (SnRelAtributosProdutoBean) o;
		
		if(idAtributoProduto != null ? !idAtributoProduto.equals(obj.getIdAtributoProduto()) : obj.getIdAtributoProduto() != null)
			return false;
		return true;
	}
	
	/**
	 * Método responsável por retornar a instância da classe atual 
	 * no formato hash.
	 * @return  o hash da instância atual
	 * 
	 * @author Rafael Nami
	 * @since  10/10/2006
	 */
	public int hashCode() {
		int value = (idAtributoProduto != null ? idAtributoProduto.hashCode() : 0);
		return (int) (value ^ (value >>> 32));
	}
	
	/**
	 * Método responsável por retornar a instância da classe atual
	 * no formato String.
	 * @return	a String da instância atual
	 * 
	 *  @author Rafael Nami
	 *  @since  10/10/2006
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SN REL ATRIBUTOS PRODUTO\n");
		if(idAtributoProduto != null) {
			result.append("ID ATRIBUTO PRODUTO:");
			result.append(idAtributoProduto);
			result.append("\n");
		}
		if(atributoParametro != null) {
			if(atributoParametro.getIdAtributoParametro() != null) {
				result.append("ATRIBUTO PARAMETRO:");
				result.append(atributoParametro.getDescricao());
				result.append("\n");
			}
		}
		if(produto != null) {
			if(produto.getIdProduto() != null) {
				result.append("PRODUTO:");
				result.append(produto.getDescricao());
				result.append("\n");
			}
		}
		return result.toString();
	}
}