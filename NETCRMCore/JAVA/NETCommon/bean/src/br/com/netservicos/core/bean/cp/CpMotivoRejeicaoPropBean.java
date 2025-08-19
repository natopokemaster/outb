/*
 * Created on 07/05/2009
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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_motivo_rejeicao_prop.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Criação da classe						07/05/2009	Otavio Henrique V. Sanchez
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                                        Prior
 * Date       By                          Version  Project/CSR    Description
 * ---------- --------------------------  -------- -------------- ---------------
 * 07/05/2009 Otavio Henrique V. Sanchez  N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 * @hibernate.class
 *      table="netsales.cp_motivo_rejeicao_prop"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="false"
 *      batch-size="10"
 *      
 * @hibernate.cache
 *      usage = "read-write"
 *      
 * @author Otavio Henrique Vieira Sanchez 
 * 
 * 
 */

public class CpMotivoRejeicaoPropBean extends DomainBean { 

	private static final String ID_MOTIVO_REJEICAO_PROP = "idMotivoRejeicaoProp";
    private static final long serialVersionUID = 8L;
	private Long idMotivoRejeicaoProp;
    private String dsMotivoRejeicaoProp;
        
    public CpMotivoRejeicaoPropBean() {
        super(ID_MOTIVO_REJEICAO_PROP);
    }
    
    /**
     * @hibernate.id
     * 		column="id_motivo_rejeicao_prop"
     * 		generator-class="assigned"
     *  
     * @return
     */
    public Long getIdMotivoRejeicaoProp() {
        return idMotivoRejeicaoProp;
    }

    /**
     * 
     * @param idMotivoRejeicaoProp
     */
	public void setIdMotivoRejeicaoProp(Long idMotivoRejeicaoProp) {
		this.idMotivoRejeicaoProp = idMotivoRejeicaoProp;
	}

    /**
     * @hibernate.property 
     *         column="ds_motivo_rejeicao_prop"
     *         not-null="true"
     * @return
     */
	public String getDsMotivoRejeicaoProp() {
		return dsMotivoRejeicaoProp;
	}

	/**
	 * 
	 * @param dsMotivoRejeicaoProp
	 */
	public void setDsMotivoRejeicaoProp(String dsMotivoRejeicaoProp) {
		this.dsMotivoRejeicaoProp = dsMotivoRejeicaoProp;
	}

}