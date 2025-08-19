/*
 * Created on 20/01/2005
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
package br.com.netservicos.core.bean.cp;

import br.com.netservicos.core.bean.sn.SnCidadeOperadoraBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P>
 * <B> Description : </B> <BR>
 * Classe Bean que representa a tabela cp_cidade_operadora.
 * </P>
 * <P>
 * <B> Issues : </B>
 * 
 * <PRE>
 * 
 * ==============================================================================
 * Description Date By ---------------------------------------- -----------
 * -------------------------
 * ==============================================================================
 * 
 * </PRE>
 * 
 * <P>
 * <B> Revision History: </B>
 * 
 * <PRE>
 * 
 * ==============================================================================
 * Prior Date By Version Project/CSR Description 
 * Wellington Maeda N/A Entidades Created. 14/09/2010 
 * Development.
 * ==============================================================================
 * 
 * </PRE>
 * 
 * @hibernate.class table = "netsales.cp_cidade_operadora" batch-size="10" lazy="false"
 * 
 * @hibernate.cache usage="nonstrict-read-write"
 * 
 * 
 * @hibernate.query name = "lstCpCidadeOperadora" query = "FROM
 *                  br.com.netservicos.core.bean.cp.CpCidadeOperadoraBean
 *                  cidadeOperadora ORDER BY cidadeOperadora.nomeCidade"
 * 
 */

public class CpCidadeOperadoraBean extends DomainBean implements Comparable {

    private static final String ID_CIDADE = "idCidade";
    private static final long serialVersionUID = 1L;    
        
    private String idCidade;
    private String nomeCidade;
    private String uf;    
    private SnCidadeOperadoraBean snCidade;
    
    public CpCidadeOperadoraBean() {
        super(ID_CIDADE);        
    }

    public CpCidadeOperadoraBean(String idCidade) {
        this();
        this.idCidade = idCidade;
    }

    

    /**
     * @return Returns the idCidade.
     * @hibernate.id 
     * 		column="id_cidade" 
     * 		generator-class="assigned"
     */
    public String getIdCidade() {
        return idCidade;
    }

    /**
     * Obtains and returns the new value of the nomeCidade attribute.
     * 
     * @return Returns the nomeCidade.
     * @hibernate.property 
     * 		column="nome_cidade"
     * 		not-null="true"
     */
    public String getNomeCidade() {
        return nomeCidade;
    }

    /**
     * Obtains and returns the new value of the uf attribute.
     * 
     * @return Returns the uf.
     * @hibernate.property 
     *      not-null="true"
     */
    public String getUf() {
        return uf;
    }

    
    /**
     * @param idCidade
     *            The idCidade to set.
     * 
     */
    public void setIdCidade(String idCidade) {
        this.idCidade = idCidade;
    }

    /**
     * @param nomeCidade
     *            The nomeCidade to set.
     * 
     */
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    /**
     * @param uf
     *            The uf to set.
     * 
     */
    public void setUf(String uf) {
        this.uf = uf;
    }
    
    /**
     *@hibernate.one-to-one
     *      column="cid_contrato"
     *      lazy="proxy"
     *      insert="false"
     *      update="false"
     * */
    public SnCidadeOperadoraBean getSnCidade(){
    	return this.snCidade;
    }
    
    public void setSnCidade(SnCidadeOperadoraBean sn){
    	this.snCidade = sn;
    }
        
    /**
     * Implementação do compareTo da interface Comparable para
     * ordenar as listas usadas no union pelo nome da cidade.
     * @param o
     * @return
     */
    public int compareTo(Object o) {
       CpCidadeOperadoraBean cpCidadeOperadora = (CpCidadeOperadoraBean) o;
       int comparison = this.getNomeCidade().compareTo(cpCidadeOperadora.getNomeCidade());
       if (comparison != 0) {
           return comparison;
       }
       return 0;
    }    

    public boolean equals(Object aThat) {
        if (this == aThat)
            return true;
        if (!(aThat instanceof CpCidadeOperadoraBean))
            return false;

        CpCidadeOperadoraBean that = (CpCidadeOperadoraBean) aThat;
        return (this.getNomeCidade().equals(that.getNomeCidade()));
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		if (this.idCidade != null) {
			result = prime * result + this.idCidade.hashCode();
		}
		return result;
	}
  
}
