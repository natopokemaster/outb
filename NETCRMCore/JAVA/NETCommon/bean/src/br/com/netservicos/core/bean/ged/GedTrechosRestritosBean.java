/*
 * Created on 12/09/2007
 *
 * Copyright © 2007 NET.
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
 *                           Prior
 * Date       By             Version  Project/CSR    Description
 * ---------- -------------- -------- -------------- ----------------------------
 * 12/09/2007 Rodrigo Silva  N/A      NETCommon      Created.
 * ==============================================================================
 * </PRE>
 * 
 * @hibernate.class 
 * 		table="TRECHOS_RESTRITOS"
 * 		dynamic-insert="true"
 * 		dynamic-update="true"
 * 		lazy="false"
 *                  
 * @hibernate.cache
 * 		usage="read-write"
 * 
 */

public class GedTrechosRestritosBean extends DomainBean {
	
	private static final long serialVersionUID = 1L;
	
	private GedTrechosRestritosKey compositeKey;
	private GedTipoTrechosRestritosBean tipoTrechosRestritos;
	private Long numImparFim;
	private Long numImparIni;
	private Long numParFim;
	private Long numParIni;
	
	/**
	 * @param primaryKeyName
	 */
	public GedTrechosRestritosBean() {
		super("compositeKey");
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.id
	 * 		type="composite"
	 */
	public GedTrechosRestritosKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 */
	public void setCompositeKey(GedTrechosRestritosKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="NUM_IMPAR_FIM"
	 */
	public Long getNumImparFim() {
		return numImparFim;
	}

	/**
	 * @param numImparFim The numImparFim to set.
	 */
	public void setNumImparFim(Long numImparFim) {
		this.numImparFim = numImparFim;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="NUM_IMPAR_INI"
	 */
	public Long getNumImparIni() {
		return numImparIni;
	}

	/**
	 * @param numImparIni The numImparIni to set.
	 */
	public void setNumImparIni(Long numImparIni) {
		this.numImparIni = numImparIni;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="NUM_PAR_FIM"
	 */
	public Long getNumParFim() {
		return numParFim;
	}

	/**
	 * @param numParFim The numParFim to set.
	 */
	public void setNumParFim(Long numParFim) {
		this.numParFim = numParFim;
	}

	/**
	 * @return Returns the descricao.
	 * 
	 * @hibernate.property
	 * 		column="NUM_PAR_INI"
	 */
	public Long getNumParIni() {
		return numParIni;
	}

	/**
	 * @param numParIni The numParIni to set.
	 */
	public void setNumParIni(Long numParIni) {
		this.numParIni = numParIni;
	}

	/**
	 * @return Returns the descricao.
	 * 
     * @hibernate.many-to-one 
     * 		class="br.com.netservicos.core.bean.ged.GedTipoTrechosRestritosBean"
     *      cascade="none"
     * @hibernate.column 
     * 		name="COD_RESTRICAO"
	 */
	public GedTipoTrechosRestritosBean getTipoTrechosRestritos() {
		return tipoTrechosRestritos;
	}

	/**
	 * @param tipoTrechosRestritos The tipoTrechosRestritos to set.
	 */
	public void setTipoTrechosRestritos(GedTipoTrechosRestritosBean tipoTrechosRestritos) {
		this.tipoTrechosRestritos = tipoTrechosRestritos;
	}
	
}