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

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_chamado.
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
 * 13/12/2004 Ramon Carvalho N/A      Entidades      Created.
 * 13/12/2004 Ramon Carvalho 1.0      Entidades      Development.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "cp_chamado"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *                   lazy="false"
 *                   batch-size="10"
 *                   
 *
 * 
 */
public class CpChamadoBean extends DomainBean {

	public static final String LST_CP_CHAMADO_BY_PROSPECT = "lstCpChamadoByProspect";
    private static final String ID_CHAMADO = "idChamado";
    private static final long serialVersionUID = -2037594742868571958L;
    private Date dtChamado;
    private Long idChamado;
    private String idUser;
    private CpMotivoFinalizacaoBean motivoFinalizacao;
    private String obs;
    private CpProspectBean prospect;
    private String usuLogon;

    /**
     *  
     */
    public CpChamadoBean() {
        super(ID_CHAMADO);
    }
    
    public CpChamadoBean(Long idChamado) {
        this();
        
        setIdChamado(idChamado);
    }

    /**
     * Obtains and returns the new value of the dtChamado attribute.
     * 
     * @return Returns the dt_chamado.
     * 
     * @hibernate.property
     *      column="dt_chamado"
     *      type = "date"
     */
    public Date getDtChamado() {
        return dtChamado;
    }

    /**
     * @hibernate.id 
     * 		column="id_chamado"
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="scp_chamado"
     * @return
     */
    public Long getIdChamado() {
        return idChamado;
    }

    /**
     * Obtains and returns the CpMotivoFinalizacaoBean.
     *
     * @return Returns the motivoFinalizacao.
     * 
     * @hibernate.many-to-one  
     * 		column = "id_motivo_finalizacao"
     * 		cascade="none"
     */
    public CpMotivoFinalizacaoBean getMotivoFinalizacao() {
        return motivoFinalizacao;
    }

    /**
     * Obtains and returns the new value of the obs attribute.
     * 
     * @return Returns the obs.
     * 
     * @hibernate.property
     */
    public String getObs() {
        return obs;
    }

    /**
     * Obtains and returns the CpProspectBean.
     *
     * @return Returns the prospect.
     * 
     * @hibernate.many-to-one  
     * 		column="id_prospect" 
     * 		cascade="none"
     *      not-null="true"
     */
    public CpProspectBean getProspect() {
        return prospect;
    }

    /**
     * @hibernate.property
     *      column="id_user"
     */
    public String getUser() {
        return idUser;
    }

    /**
     * Obtains and returns the new value of the usuLogon attribute.
     * 
     * @return Returns the usu_logon.
     * 
     * @hibernate.property
     *      column="usu_logon"
     */
    public String getUsuLogon() {
        return usuLogon;
    }

    /**
     * @param dtChamado The dtChamado to set.
     * 
     */
    public void setDtChamado(Date dtChamado) {
        this.dtChamado = dtChamado;
    }

    public void setIdChamado(Long idChamado) {
        this.idChamado = idChamado;
    }

    /**
     * @param motivoFinalizacao The motivoFinalizacao to set.
     * 
     */
    public void setMotivoFinalizacao(CpMotivoFinalizacaoBean motivoFinalizacao) {
        this.motivoFinalizacao = motivoFinalizacao;
    }

    /**
     * @param obs The obs to set.
     * 
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @param prospect The prospect to set.
     * 
     */
    public void setProspect(CpProspectBean prospect) {
        this.prospect = prospect;
    }

    /**
     * @param user The user to set.
     * 
     */
    public void setUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     * @param usuLogon The usuLogon to set.
     * 
     */
    public void setUsuLogon(String usuLogon) {
        this.usuLogon = usuLogon;
    }

}