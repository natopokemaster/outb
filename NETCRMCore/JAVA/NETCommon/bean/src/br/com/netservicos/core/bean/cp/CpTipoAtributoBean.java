/*
 * Created on 13/09/2005
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
*   Classe Bean que representa a tabela cp_tipo_atributo.
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
* 14/09/2010 Wellington Maeda N/A      Entidades      Created.
* ==============================================================================
* </PRE>
*
* @hibernate.class 
*       table="cp_tipo_atributo"
*       lazy="false"
*       mutable="false"
*       batch-size="10"
*       
* @hibernate.cache
 *      usage="read-write"
*/
public class CpTipoAtributoBean extends DomainBean {

    private static final long serialVersionUID = 1L;
    private Long idTipoAtributo;
    private String descricao;
    
    public static final String ID_TIPO_ATRIBUTO = "idTipoAtributo";

    public CpTipoAtributoBean() {
        super(ID_TIPO_ATRIBUTO);
    }
    
    /**
     * @hibernate.id 
     *      generator-class="sequence"
     *      column="id_tipo_atributo"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="scp_tipo_atributo"
     */
    public Long getIdTipoAtributo() {
        return idTipoAtributo;
    }

    public void setIdTipoAtributo(Long idTipoAtributo) {
        this.idTipoAtributo = idTipoAtributo;
    }

    /**
     * @hibernate.property
     *      not-null="true"
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
