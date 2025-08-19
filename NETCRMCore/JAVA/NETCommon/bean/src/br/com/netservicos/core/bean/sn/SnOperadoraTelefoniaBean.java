/*
 * Created on 14/02/2008
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

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 *  Classe Bean que representa a tabela sn_operadora_telefonia.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>
 * ============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -----------------------
 *
 * ============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- --------------------------
 * 13/02/2008 Gustavo Sabino  N/A     Entidades      Created.
 * 13/02/2008 Gustavo Sabino  1.0     Entidades      Development.
 * ============================================================================
 * </PRE>
 *
 * @hibernate.class table = "sn_operadora_telefonia"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *
 * @hibernate.query name  = "lstOperadoraTelefonia"
 *           query = "SELECT operadoraTelefonia.idOperadoraTelefonia,
 *                           operadoraTelefonia.nmOperadoraTelefonia
 *                    FROM br.com.netservicos.core.bean.sn.SnOperadoraTelefoniaBean operadoraTelefonia
 *                    ORDER BY operadoraTelefonia.nmOperadoraTelefonia"
 *
 * @hibernate.cache
 *      usage = "read-write"
 *
 */

public class SnOperadoraTelefoniaBean extends DomainBean {

    /**
     *
     */
    private static final long serialVersionUID = 2797513620569945168L;
    public static final String LST_OPERADORA_TELEFONIA_BY_DDD = "lstOperadoraTelefoniaByDDD";

    /**
     *
     */
    private Long idOperadoraTelefonia;

    /**
     *
     */
    private String nmOperadoraTelefonia;

    /**
     *
     */
    private String fcProdutoEbt;

    /**
     *
     */
    public static final String ATRIBUTO_ID_OPERADORA_TELEFONIA
                        = "idOperadoraTelefonia";

    /**
     *
     * @param idOperadoraTelefonia Long
     */
    public SnOperadoraTelefoniaBean(Long idOperadoraTelefonia) {
        this();
        this.idOperadoraTelefonia = idOperadoraTelefonia;
    }

    /**
     *
     */
    public SnOperadoraTelefoniaBean() {
        super(ATRIBUTO_ID_OPERADORA_TELEFONIA);
    }

    /**
     * @hibernate.property
     *      column="fc_produto_ebt"
     * @return String
     */
    public String getFcProdutoEbt() {
        return fcProdutoEbt;
    }

    /**
     *
     * @param fcProdutoEbt String
     */
    public void setFcProdutoEbt(String fcProdutoEbt) {
        this.fcProdutoEbt = fcProdutoEbt;
    }

    /**
     * @hibernate.id
     * generator-class="sequence"
     * unsaved-value = "null"
     * column="id_operadora_telefonia"
     * type="long"
     *
     * @return Long
     */
    public Long getIdOperadoraTelefonia() {
        return idOperadoraTelefonia;
    }

    /**
     *
     * @param idOperadoraTelefonia Long
     */
    public void setIdOperadoraTelefonia(Long idOperadoraTelefonia) {
        this.idOperadoraTelefonia = idOperadoraTelefonia;
    }

    /**
     * @hibernate.property
     *      column="nm_operadora_telefonia"
     * @return String
     */
    public String getNmOperadoraTelefonia() {
        return nmOperadoraTelefonia;
    }

    /**
     *
     * @param nmOperadoraTelefonia String
     */
    public void setNmOperadoraTelefonia(String nmOperadoraTelefonia) {
        this.nmOperadoraTelefonia = nmOperadoraTelefonia;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    // @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((this.idOperadoraTelefonia == null)
                 ? 0 : this.idOperadoraTelefonia.hashCode());
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    //@Override
    public boolean equals(Object obj) {
        boolean result = true;
        if (this == obj) { result = true; }
        if (obj == null) { result = false; }
        if (getClass() != obj.getClass()) { result = false; }
        final SnOperadoraTelefoniaBean other = (SnOperadoraTelefoniaBean) obj;
        if (this.idOperadoraTelefonia == null) {
            if (other.idOperadoraTelefonia != null) {
                result = false;
            }
        } else {
            if (!this.idOperadoraTelefonia.equals(
                other.idOperadoraTelefonia)) {
                result = false;
            }
        }
        return result;
    }
}
