/*
 * Created on 13/12/2004
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

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_conta_corrente.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * 
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
 * 16/08/2005 Bruno Troiano  N/A      Entidades      Created.
 * 16/08/2005 Bruno Troiano  1.0		 Entidades		Implement.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table="cp_conta_corrente"
 * 		dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true"
 *                   
 *                   
 *
 * @hibernate.query name="lstCpContaCorrente"
 * 		query="FROM	br.com.netservicos.core.bean.cp.CpContaCorrenteBean contaCorrente"
 *                  
 */
public class CpContaCorrenteBean extends WebBean {

    private static final String ID_PROSPECT = "idProspect";
    private static final long serialVersionUID = 1L;
    private String agencia;
    private String conta;
    private String digitoAgencia;
    private String digitoConta;
    private String fone;
    private Long idBanco;
    private Long idProspect;
    private CpProspectBean prospect;
    private String titular;

    public CpContaCorrenteBean() {
        super(ID_PROSPECT);
    }
    
    public CpContaCorrenteBean(Long idProspect) {
        this();
        
        setIdProspect(idProspect);
    }
    
    public CpContaCorrenteBean(CpProspectBean prospect) {
        this(prospect.getIdProspect());
        
        setProspect(prospect);
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     * 		
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     * 		
     * 
     */
    public String getConta() {
        return conta;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     * 		column="digito_agencia"
     */
    public String getDigitoAgencia() {
        return digitoAgencia;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     * 		column="digito_conta"
     * 		
     */
    public String getDigitoConta() {
        return digitoConta;
    }

    /**
     * 
     * @return String
     * 
     * @hibernate.property
     */
    public String getFone() {
        return fone;
    }

    /**
     * 
     * @return Long
     * 
     * @hibernate.property
     * 		column="id_banco"
     * 		
     */
    public Long getIdBanco() {
        return idBanco;
    }

    /**
     * @hibernate.id
     *      column="id_prospect"
     *      generator-class="assigned"
     *      
     * @return
     */
    public Long getIdProspect() {
        return idProspect;
    }

    /**
     * @return Returns the idProspect.
     * 
     * @hibernate.one-to-one
     *      constrained="true"
     *      cascade="none"
     *      lazy="proxy"
     */
    public CpProspectBean getProspect() {
        return prospect;
    }

    /**
     * @return String
     * 
     * @hibernate.property
     */
    public String getTitular() {
        return titular;
    }

    /**
     * 
     * @param agencia
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * 
     * @param conta
     */
    public void setConta(String conta) {
        this.conta = conta;
    }

    /**
     * 
     * @param digitoAgencia
     */
    public void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    /**
     * 
     * @param digitoConta
     */
    public void setDigitoConta(String digitoConta) {
        this.digitoConta = digitoConta;
    }

    /**
     * 
     * @param fone
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * 
     * @param idBanco
     */
    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }

    public void setIdProspect(Long idProspect) {
        this.idProspect = idProspect;
    }

    /**
     * @param idProposta The idProspect to set.
     * 
     */
    public void setProspect(CpProspectBean idProposta) {
        this.prospect = idProposta;
    }

    /**
     * 
     * @param titular
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public boolean equals(Object obj) {
    	if (obj instanceof CpContaCorrenteBean)
    		if (((CpContaCorrenteBean) obj).getIdProspect().equals(idProspect))
    			return true;
    	return super.equals(obj);
    }
    
}