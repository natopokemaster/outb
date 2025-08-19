/*
 * Created on 18/08/2005
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
package br.com.netservicos.core.bean.ged;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
* <P><B>
* Description :
* </B>
* <BR>
* 	Classe Bean que representa a tabela ged.imovel.
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
* 18/08/2005 Juliano Tarini N/A      Entidades      Created.
* ==============================================================================
* </PRE>
*
* @hibernate.class table = "cidade"
*                  dynamic-insert = "true"
*                  dynamic-update = "true"
*                  lazy="false"
*                  
* @hibernate.cache
*       usage = "read-write"
*       
*/
public class GedCidadeBean extends DomainBean {
	
	private static final long serialVersionUID = -519208456013332476L;
	
	private GedCidadeKey composite;
    private String sglEstado;
    private String nomCidade;
    private String indSMS;
    private String indVenda;

        
    public static final String RETORNA_COD_IMOVEL_BY_HP = "retornaCodImovelByHP";
    public static final String RETORNA_CODIGOS_IMOVEL_BY_HPS = "retornaCodigosImovelByHPs";
    public static final String COMPOSITE_KEY = "composite";
    
    public GedCidadeBean(){
        super(COMPOSITE_KEY);
    }
    
	/**
	 * @hibernate.id
	 * type = "composite"
	 */
    public GedCidadeKey getComposite() {
		return composite;
	}

	public void setComposite(GedCidadeKey composite) {
		this.composite = composite;
	}




    /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="sgl_estado"
	 * type = "string"
	 */
	public String getSglEstado() {
		return sglEstado;
	}

	/**
	 * @param sglEstado the sglEstado to set
	 */
	public void setSglEstado(String sglEstado) {
		this.sglEstado = sglEstado;
	}

	  /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="nom_Cidade"
	 * type = "string"
	 */
	public String getNomCidade() {
		return nomCidade;
	}

	/**
	 * @param nomCidade the nomCidade to set
	 */
	public void setNomCidade(String nomCidade) {
		this.nomCidade = nomCidade;
	}
	
	 /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_SMS"
	 * type = "string"
	 */
	public String getIndSMS() {
		return indSMS;
	}

	/**
	 * @param indSMS the indSMS to set
	 */
	public void setIndSMS(String indSMS) {
		this.indSMS = indSMS;
	}

	 /** 
	 * @return String
	 * 
	 * @hibernate.property
	 * column="ind_Venda"
	 * type = "string"
	 */
	public String getIndVenda() {
		return indVenda;
	}

	/**
	 * @param indVenda the indVenda to set
	 */
	public void setIndVenda(String indVenda) {
		this.indVenda = indVenda;
	}

	/**
	 * @return the rETORNA_CODIGOS_IMOVEL_BY_HPS
	 */
	public static String getRETORNA_CODIGOS_IMOVEL_BY_HPS() {
		return RETORNA_CODIGOS_IMOVEL_BY_HPS;
	}
	    
}
