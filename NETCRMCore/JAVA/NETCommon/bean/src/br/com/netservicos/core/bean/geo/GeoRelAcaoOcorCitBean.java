package br.com.netservicos.core.bean.geo;

import java.util.Date;

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela geo_rel_acao_ocor_cit.<br>
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
 * Date       By             Version  Project/CSR     Description
 * ---------- -------------- -------- --------------- ---------------------------
 * 15/10/2005 Robin Gray  N/A                      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "geo_rel_acao_ocor_cit"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 * 					lazy="false"
 * 
 * @hibernate.cache
 *      usage="read-write"
 *      
 */

public class GeoRelAcaoOcorCitBean extends WebBean {



	/**
	 * 
	 */
	private static final long serialVersionUID = -4524141446884116159L;

	public GeoRelAcaoOcorCitKey compositeKey;
	
	public Integer tempoAnaliseMin;
	
	public Date tempoAnaliseFixo;
	
	public GeoRelAcaoOcorCitBean() {
		super("compositeKey");
	}

	/**
	 * @return Returns the compositeKey.
	 * 
	 * @hibernate.id
	 * type = "composite" 
	 */
	public GeoRelAcaoOcorCitKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 */
	public void setCompositeKey(GeoRelAcaoOcorCitKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * @return Returns the tempoAnaliseFixo.
	 * 
	 * @hibernate.property
	 * column="tempo_analise_fixo"
	 * type = "date" 
	 */
	public Date getTempoAnaliseFixo() {
		return tempoAnaliseFixo;
	}

	/**
	 * @param tempoAnaliseFixo The tempoAnaliseFixo to set.
	 */
	public void setTempoAnaliseFixo(Date tempoAnaliseFixo) {
		this.tempoAnaliseFixo = tempoAnaliseFixo;
	}

	/**
	 * @return Returns the tempoAnaliseMin.
	 * 
	 * @hibernate.property
	 * column="tempo_analise_min"
	 * type = "int" 
	 */
	public Integer getTempoAnaliseMin() {
		return tempoAnaliseMin;
	}

	/**
	 * @param tempoAnaliseMin The tempoAnaliseMin to set.
	 */
	public void setTempoAnaliseMin(Integer tempoAnaliseMin) {
		this.tempoAnaliseMin = tempoAnaliseMin;
	}
	
	
	
}
