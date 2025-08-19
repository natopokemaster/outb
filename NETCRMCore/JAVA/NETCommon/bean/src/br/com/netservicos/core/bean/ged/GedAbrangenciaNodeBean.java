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
 * 12/09/2007 Rodrigo Silva  N/A      NETCommon      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class 
 * 		table="ABRANGENCIA_NODE"
 * 		dynamic-insert="true"
 * 		dynamic-update="true"
 * 		lazy="false"
 *                  
 * @hibernate.cache
 * 		usage="read-write"
 * 
 *                           
 */
public class GedAbrangenciaNodeBean extends DomainBean {

	private static final long serialVersionUID = 4159056252636642384L;
	
	private GedAbrangenciaNodeKey compositeKey;
	private Long numImparFim;
	private Long numImparIni;
	private Long numParFim;
	private Long numParIni;
	private GedNodeBean node;
	
	/**
	 * Construtor padrão da classe
	 */
	public GedAbrangenciaNodeBean() {
		super("compositeKey");
	}

	/**
	 * Retorna o atributo compositeKey da classe.
	 * @return GedAbrangenciaNodeKey com o atributo compositeKey da classe.
	 * 
	 * @see br.com.netservicos.core.bean.ged.GedAbrangenciaNodeKey
	 * 
	 * @hibernate.id
	 * 		type="composite"
	 */
	public GedAbrangenciaNodeKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 */
	public void setCompositeKey(GedAbrangenciaNodeKey compositeKey) {
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
     * 		class="br.com.netservicos.core.bean.ged.GedNodeBean"
     *      insert="false"
     *      update="false"
     *      cascade="none"
     *      not-null="false"
     * @hibernate.column 
     * 		name="COD_NODE"
     * @hibernate.column 
     * 		name="COD_OPERADORA"
	 */
	public GedNodeBean getNode() {
		return node;
	}

	/**
	 * @param node The node to set.
	 */
	public void setNode(GedNodeBean node) {
		this.node = node;
	}
	
}