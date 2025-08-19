/*
 * Created on 16/08/2005
 *
 * Copyright © 2005 NET.
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
 * 	Classe Bean que representa a tabela cp_tipo_endereco.
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
 *                              Prior
 * Date       By                Version  Project/CSR    Description
 * ---------- ----------------  -------- -------------- ----------------------------
 * 14/09/2010 Wellington Maeda  N/A      Entidades      Created. 
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class 
 *      table="cp_tipo_endereco"
 *      lazy="false"
 *      batch-size="10"
 *      mutable="false"
 *      
 * @hibernate.cache
 *      usage="read-only"
 */
public class CpTipoEnderecoBean extends DomainBean {

    private static final String ID_TIPO_ENDERECO = "idTipoEndereco";
    private static final long serialVersionUID = 1L;
    
    public static final int INSTALACAO = 1;
    public static final int COBRANCA = 2;
    
    private String descricao;
    private Integer idTipoEndereco;

    public CpTipoEnderecoBean() {
        super(ID_TIPO_ENDERECO);
    }

    /**
     * @hibernate.property 
     *         column="ds_tipo_endereco"
     *         not-null="true"
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @hibernate.id
     * 		column="id_tipo_endereco"
     * 		generator-class="assigned"
     *  
     * @return
     */
    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

}
