/*
 * Created on 25/01/2005
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

import java.util.List;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_status_proposta.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * 
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                            Prior
 * Date       By              Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 20/09/2010 Wellington Maeda N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "cp_status_proposta"
 *                  lazy="false"
 *                  mutable="false"
 *                   
 * @hibernate.cache
 *      usage="read-only"
 * 
 * 
 */
public class CpStatusPropostaBean extends DomainBean {

	
	
    private static final String ID_STATUS_PROPOSTA = "idStatusProposta";
    private static final long serialVersionUID = 1L;
    private String descricao;
    private Integer idStatusProposta;
    
    private List propostasAssinante;
    private List propostas;
    public static final int STATUS_PENDENTE_EM_AGENDAMENTO = 7;
    public static final int STATUS_EM_ANDAMENTO = 3;
    public static final int STATUS_ENVIADA = 4;
    public static final int STATUS_CANCELADA = 5;
    public static final int STATUS_PENDENTE = 6;
    

    /**
     *  
     */
    public CpStatusPropostaBean() {
        super(ID_STATUS_PROPOSTA);
        metaData.put("propostasAssinantes", CpPropostaAssinanteBean.class);
        metaData.put("propostas", CpPropostaBean.class);
    }

    public CpStatusPropostaBean(int id) {
        this();
        setIdStatusProposta(new Integer(id));
    }

    /**
     * Obtains and returns the new value of the descricao attribute.
     *
     * @return Returns the descricao.
     * 
     * @hibernate.property
     * 		not-null="true"
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return Returns the idStatusProposta.
     * 
     * @hibernate.id 
     * 		column="id_status_proposta"
     * 		generator-class="assigned"
     */
    public Integer getIdStatusProposta() {
        return idStatusProposta;
    }

    /**
     * @param descricao The descricao to set.
     * 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param idStatusProposta The idStatusProposta to set.
     * 
     */
    public void setIdStatusProposta(Integer idStatusProposta) {
        this.idStatusProposta = idStatusProposta;
    }
    
    /**
     * Método de acesso ao atributo propostas
	 * @return propostas O valor do atributo propostas
	 * 
	 * @hibernate.bag
     * 		table="cp_proposta"
     * 		cascade="none"
     * 		inverse="false"
     * 		lazy="true"
     * 		batch-size="5"
     * @hibernate.collection-one-to-many 
     * 		class="br.com.netservicos.core.bean.cp.CpPropostaBean"
     * @hibernate.collection-key
     * 		column="id_proposta"
	 */
	public List getPropostas() {
		return propostas;
	}

	/**
	 * Método de modificação do atributo propostas
	 * @param propostas O valor a ser setado no atributo propostas.
	 */
	public void setPropostas(List propostas) {
		this.propostas = propostas;
	}

	/**
	 * Método de acesso ao atributo propostasAssinante
	 * @return propostasAssinante O valor do atributo propostasAssinante
	 * 
	 * @hibernate.bag
     * 		table="cp_proposta_assinante"
     * 		cascade="none"
     * 		inverse="false"
     * 		lazy="true"
     * 		batch-size="5"
     * @hibernate.collection-one-to-many 
     * 		class="br.com.netservicos.core.bean.cp.CpPropostaAssinanteBean"
     * @hibernate.collection-key
     * 		column="id_proposta_assinante"
	 */
	public List getPropostasAssinante() {
		return propostasAssinante;
	}

	/**
	 * Método de modificação do atributo propostasAssinante
	 * @param propostasAssinante O valor para setar no atributo propostasAssinante.
	 */
	public void setPropostasAssinante(List propostasAssinante) {
		this.propostasAssinante = propostasAssinante;
	}

	/**
	 * Método responsável por comparação atributo a atributo entre duas instâncias
	 * de uma classe
	 * @param 	o 	Objeto a ser comparado com a instância da classe atual.
	 * @return 	se as duas instâncias são iguais ou não. 
	 * 
	 * @author Rafael Nami
	 * @since  09/10/2006
	 */
    public boolean equals(Object o) {
        if(this == o)
        	return true;
        if(!(o instanceof CpStatusPropostaBean))
        	return false;
        
        CpStatusPropostaBean obj = (CpStatusPropostaBean) o;
        
        if (idStatusProposta != null ? !idStatusProposta.equals(obj.getIdStatusProposta()) : obj
                                                .getIdStatusProposta() != null)
        	return false;
        return true;
    }
    
    /**
	 * Método responsável por retornar a instância da classe atual 
	 * no formato hash.
	 * @return  o hash da instância atual
	 * 
	 * @author Rafael Nami
	 * @since  09/10/2006
	 */
    public int hashCode() {
		final int prime = 32;
    	int value = (idStatusProposta != null ? idStatusProposta.hashCode() : 0);
		return (int) (value ^ (value >>> prime));
    }
    
    /**
	 * Método responsável por retornar a instância da classe atual
	 * no formato String.
	 * @return	a String da instância atual 
	 * 
	 * @author Rafael Nami
	 * @since  09/10/2006
	 */
    public String toString() {
    	StringBuilder result = new StringBuilder();
    	result.append("CP STATUS PROPOSTA\n");
    	if(idStatusProposta != null) {
    		result.append("ID STATUS PROPOSTA:");
    		result.append(idStatusProposta);
    		result.append("\n");
    	}
    	if(descricao != null) {
    		result.append("DESCRICAO:");
    		result.append(descricao);
    		result.append("\n");
    	}
    	if(propostas != null) {
    		result.append("Tamanho da lista de propostas:");
    		result.append(propostas.size());
    		result.append("\n");
    	}
    	if(propostasAssinante != null) {
    		result.append("Tamanho da lista de propostas assinante:");
    		result.append(propostasAssinante);
    		result.append("\n");
    	}
    	return result.toString();
    }

}