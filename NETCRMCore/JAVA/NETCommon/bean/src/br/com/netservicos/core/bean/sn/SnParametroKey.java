/*
 * Created on 26/02/2005
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
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Key que representa a chave composta para a tabela sn_parametro.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * =============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * =============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                                  Prior
 * Date       By                   Version Project/CSR Description
 * ---------- -------------------- ------- ----------- -------------------------
 * 13/05/2005 Giovanni Formighieri N/A     Entidades   Created. 
 * ==============================================================================
 * </PRE>
 *
 *
 * 
 */
public class SnParametroKey implements Serializable, BaseCompositeKey {

	private static final long serialVersionUID = -4376062230182182529L;

	private String idEmpresa;

	private String nomeParametro;

	public SnParametroKey() {
	}

	public SnParametroKey(String idEmpresa, String nomeParametro) {
		this.idEmpresa = idEmpresa;
		this.nomeParametro = nomeParametro;
	}

	/*
	 * @see br.com.netservicos.framework.core.bean.BaseCompositeKey#buildKey(java.lang.String)
	 * 
	 */
	public void buildKey(String value) {
		StringTokenizer tok = new StringTokenizer(value, "|");
		String idEmpresa = tok.nextToken();
		String nomeParametro = tok.nextToken();
		this.idEmpresa = idEmpresa;
		this.nomeParametro = nomeParametro;
	}

	   /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((idEmpresa == null) ? 0 : idEmpresa.hashCode());
        result = prime * result
                + ((nomeParametro == null) ? 0 : nomeParametro.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        final SnParametroKey other = (SnParametroKey) obj;
        if (idEmpresa == null) {
            if (other.idEmpresa != null){
                return false;
            }
        } else if (!idEmpresa.equals(other.idEmpresa)){
            return false;
        }
        if (nomeParametro == null) {
            if (other.nomeParametro != null){
                return false;
            }
        } else if (!nomeParametro.equals(other.nomeParametro)){
            return false;
        }
        return true;
    }

	/**
	 * Obtains and returns the idEmpresa.
	 *
	 * @return Returns the idEmpresa.
	 * @hibernate.property column = "id_empresa"
	 * 
	 */
	public String getIdEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param idEmpresa The idEmpresa to set.
	 * 
	 */
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	/**
	 * @return Returns the nomeParametro.
	 * @hibernate.property column = "nome_parametro"
	 * 
	 */
	public String getNomeParametro() {
		return nomeParametro;
	}

	/**
	 * @param nomeParametro The nomeParametro to set.
	 * 
	 */
	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}

}
