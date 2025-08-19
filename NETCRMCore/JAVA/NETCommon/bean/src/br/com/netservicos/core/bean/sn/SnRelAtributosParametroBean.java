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
 * Classe Bean que representa a tabela sn_rel_atributos_parametro.
 * <BR><BR>
 * 
 * <P><B>Issues:</B>
 * 
 * <PRE>  
 * =============================================================================
 * Description                                   Date       By 
 * --------------------------------------------- ---------- --------------------
 * Adição dos métodos equals, hashCode e         10/10/2006 Rafael Nami 
 * toString.
 * 
 * Adicionado as queryNames                      13/12/2006 Joelson M. dos Reis 
 * <code>lstAtributoParametroTecnologias</code>,
 * <code>lstTecnologiasMudancaPacote</code>.
 * 
 * Adicionando HQLs
 * lstRelAtributosParametroSelecaoPopup e
 * lstTecnologiaSelecaoAgregadoPopup			 20/03/2007 Rafael Nami
 * 
 * Modificando a query 
 * lstFamiliaSelecaoAgregadoPopup para uma
 * native query									 20/04/2007 Rafael Nami
 * =============================================================================
 * </PRE>
 * 
 * <P><B>Revision History:</B>
 * 
 * <PRE>
 * =============================================================================
 * Prior Date By                   Version          Project/CSR    Description 
 * ---------- -------------------- ---------------  -------------- -------------
 * 17/01/2005 Bruno Borges         N/A              NETCommon      Criado
 * 17/01/2005 Bruno Borges         1.0              NETCommon      Atualizado
 * 10/10/2006 Rafael Nami          1.1              NETCommon      Atualizado
 * 13/12/2006 Joelson M. dos Reis  1.1.92.2.2.1     NETCommon      Atualizado
 * 20/03/2007 Rafael Nami		   1.2				NETCommon	   Atualizado
 * 20/04/2007 Rafael Nami		   1.3				NETCommon	   Atualizado
 * =============================================================================
 * </PRE>
 * 
 * @author Bruno Borges
 * @since 17/01/2005
 * @version 1.1.92.2.2.1
 * 
 * @hibernate.class table="sn_rel_atributos_parametro"
 *                  dynamic-insert="true"
 *                  dynamic-update="true"
 *                  lazy="true" 
 *
 * @hibernate.cache usage="read-write"
 * 
 */
public class SnRelAtributosParametroBean extends WebBean {

	public static final String LISTA_TECNOLOGIA_PONTO_PRINCIPAL = "getTecnologiaPontoPrincipal";
	public static final String LISTA_TECNOLOGIA_PONTO_PRINCIPAL_NAO_INSTALADO = "getTecnologiaPontoParametroNaoInstalado";
	private static final long serialVersionUID = 645076097868561159L;
	public static final Integer PARAMETRO_CLASSIFICACAO = Integer.valueOf(6);
	public static final Integer PARAMETRO_SERVICO = Integer.valueOf(1);
	public static final Integer PARAMETRO_COMERCIALIZACAO = Integer.valueOf(7);
	public static final Integer PARAMETRO_VELOCIDADE = Integer.valueOf(8);
	private SnAtributosBean atributo = null;
    private String descricao = null;
    private Long idAtributoParametro = null;
    private Long idNetsmsOrigem = null;
    private SnProdutoBean produto = null;

    public SnRelAtributosParametroBean() {
        super("idAtributoParametro");
    }

    /**
     * @hibernate.many-to-one
     *      column="id_atributo"
     * @return
     */
    public SnAtributosBean getAtributo() {
        return atributo;
    }

    /**
     * @hibernate.property
     *      not-null="true"
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @hibernate.many-to-one
     *      column="id_produto"
     * @return
     */
    public SnProdutoBean getProduto() {
        return produto;
    }    
    
    /**
     * @hibernate.id
     *      generator-class="sequence"
     *      column="id_atributo_parametro"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="SSN_ID_ATRIBUTO_PARAMETRO"
     * @return
     */
    public Long getIdAtributoParametro() {
        return idAtributoParametro;
    }

    /**
     * @hibernate.property
     *      column="id_netsms_origem"
     * @return
     */
    public Long getIdNetsmsOrigem() {
        return idNetsmsOrigem;
    }

    public void setAtributo(SnAtributosBean atributo) {
        this.atributo = atributo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdAtributoParametro(Long idAtributoParametro) {
        this.idAtributoParametro = idAtributoParametro;
    }

    public void setIdNetsmsOrigem(Long idNetsmsOrigem) {
        this.idNetsmsOrigem = idNetsmsOrigem;
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
		if(!(o instanceof SnRelAtributosParametroBean))
			return false;
		SnRelAtributosParametroBean obj = (SnRelAtributosParametroBean) o;
		
		if(idAtributoParametro != null ? !idAtributoParametro.equals(obj.getIdAtributoParametro()) : obj.getIdAtributoParametro() != null)
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
		int value = (idAtributoParametro != null ? idAtributoParametro.hashCode() : 0);
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
		result.append("SN REL ATRIBUTOS PARAMETRO\n");
		if(idAtributoParametro != null) {
			result.append("ID ATRIBUTO PARAMETRO:");
			result.append(idAtributoParametro);
			result.append("\n");
		}
		if(descricao != null) {
			result.append("DESCRICAO:");
			result.append(descricao);
			result.append("\n");
		}
		if(atributo != null) {
			if(atributo.getIdAtributo() != null) {
				result.append("ATRIBUTO:");
				result.append(atributo.getDescricao());
				result.append("\n");
			}
		}
		if(idNetsmsOrigem != null) {
			result.append("ID NETSMS ORIGEM:");
			result.append(idNetsmsOrigem);
			result.append("\n");
		}
		return result.toString();
	}
    
}