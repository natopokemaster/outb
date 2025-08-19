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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_motivo_finalizacao.
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
 * 25/01/2005 Ramon Carvalho N/A      Entidades      Created. 
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "cp_motivo_finalizacao"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="true"
 *                   batch-size="10"
 *                   
 * @hibernate.cache
 *      usage="read-write"
 *
 * 
 */
public class CpMotivoFinalizacaoBean extends DomainBean {

    private static final String ID_MOTIVO_FINALIZACAO = "idMotivoFinalizacao";
    private static final String LIST_TELAS = "telas";
    private static final long serialVersionUID = 1L;
    private String descricao;
    private Integer idMotivoFinalizacao;
    
    public CpMotivoFinalizacaoBean() {
        super(ID_MOTIVO_FINALIZACAO);  
    }

    /**
     * Obtains and returns the new value of the descricao attribute.
     *
     * @return Returns the descricao.
     * 
     * @hibernate.property
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return Returns the idMotivoFinalizacao.
     * 
     * @hibernate.id 
     * 		column="id_motivo_finalizacao"
     * 		generator-class="sequence"
     * @hibernate.generator-param 
     * 		name="sequence" 
     * 		value="scp_motivo_finalizacao"
     */
    public Integer getIdMotivoFinalizacao() {
        return idMotivoFinalizacao;
    }

    

    /**
     * @param descricao The descricao to set.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param idMotivoFinalizacao The idMotivoFinalizacao to set.
     * 
     */
    public void setIdMotivoFinalizacao(Integer idMotivoFinalizacao) {
        this.idMotivoFinalizacao = idMotivoFinalizacao;
    }

   

}
