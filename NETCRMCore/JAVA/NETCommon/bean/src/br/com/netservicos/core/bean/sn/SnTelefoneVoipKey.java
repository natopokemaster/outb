/*
 * Created on 04/02/2005
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

import java.io.Serializable;
import java.util.Date;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Key que representa a chave composta para a tabela sn_contrato.
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
 * 03/07/2005 Leonardo W.       N/A     Entidades      Created.
 * 03/07/2005 Leonardo W.       1.0     Entidades      Development.
 * ==============================================================================
 * </PRE>
 * 
 * 
 */
public class SnTelefoneVoipKey implements Serializable {

    private static final long serialVersionUID = 749089986124641276L;
    private String dddTelefoneVoip;

    private String numTelefoneVoip;
    
    private Date dtIni;
    
    private Date dtFim; 
    

    /**
     *  
     */
    public SnTelefoneVoipKey() {
    }

    /**
     *  
     */
    public SnTelefoneVoipKey(String dddTelefoneVoip, String numTelefoneVoip, Date dtIni, Date dtFim) {
        this.dddTelefoneVoip = dddTelefoneVoip;
        this.numTelefoneVoip = numTelefoneVoip;
        this.dtIni = dtIni;
        this.dtFim = dtFim;
    }

    /**
     * 
     */
    public boolean equals(Object key) {
        if (key instanceof SnTelefoneVoipKey) {
            SnTelefoneVoipKey comp = (SnTelefoneVoipKey) key;
            return this.getDddTelefoneVoip().equals(comp.getDddTelefoneVoip())
                    && this.getNumTelefoneVoip().equals(comp.getNumTelefoneVoip())
                    && this.getDtIni().compareTo(comp.getDtIni()) == 0
                    && this.getDtFim().compareTo(comp.getDtFim()) == 0;
        } else {
            return super.equals(key);
        }
    }

    /**
     * 
     */
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((dddTelefoneVoip == null) ? 0 : dddTelefoneVoip.hashCode());
        result = prime * result + ((dtFim == null) ? 0 : dtFim.hashCode());
        result = prime * result + ((dtIni == null) ? 0 : dtIni.hashCode());
        result = prime * result
                + ((numTelefoneVoip == null) ? 0 : numTelefoneVoip.hashCode());
        return result;
    }

    /**
     * @return Returns the cidContrato.
     * @hibernate.property column = "ddd_telefone_voip"
     * 
     */
    public String getDddTelefoneVoip() {
        return dddTelefoneVoip;
    }

    /**
     * @param dddTelefoneVoip The dddTelefoneVoip to set.
     * 
     */
    public void setDddTelefoneVoip(String dddTelefoneVoip) {
        this.dddTelefoneVoip = dddTelefoneVoip;
    }

    /**
     * @return Returns the numTelefoneVoip.
     * @hibernate.property column = "num_telefone_voip"
     * 
     */
    public String getNumTelefoneVoip() {
        return numTelefoneVoip;
    }

    /**
     * @param numTelefoneVoip The numTelefoneVoip to set.
     * 
     */
    public void setnumTelefoneVoip(String numTelefoneVoip) {
        this.numTelefoneVoip = numTelefoneVoip;
    }

    /**
     * @return Returns the dtIni.
     * @hibernate.property column = "dt_ini"
     * type = "timestamp"
     */
    public Date getDtIni() {
        return dtIni;
    }

    /**
     * @param dtIni The dtIni to set.
     * 
     */
    public void setDtIni(Date dtIni) {
        this.dtIni = dtIni;
    }
    
    /**
     * @return Returns the dtFim.
     * @hibernate.property column = "dt_fim"
     * type = "timestamp"
     */
    public Date getDtFim() {
        return dtFim;
    }

    /**
     * @param dtFim The dtFim to set.
     * 
     */
    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }
    
    public void publicateTelefone(String telefone){
        
        this.dddTelefoneVoip = telefone.substring(0,2);
        this.numTelefoneVoip = telefone.substring(2,telefone.length());
        
    }
    
}
