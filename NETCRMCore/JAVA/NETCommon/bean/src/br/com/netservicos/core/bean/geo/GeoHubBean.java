package br.com.netservicos.core.bean.geo;

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela geo_hub.
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
 * Date       By             Version  Project/CSR     Description
 * ---------- -------------- -------- --------------- ---------------------------
 * 15/10/2005 Robin Gray  N/A                      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "geo_hub"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 * 					lazy="false"
 * 
 * @hibernate.cache
 *      usage="read-write"
 *
 */
public class GeoHubBean extends WebBean {

	
	private GeoHubKey compositeKey;
	
	private String huDescricao;
	
	private String huCod;
	
	private String heCodigo;
	
	public GeoHubBean() {
		super("compositeKey");
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @return Returns the compositeKey.
	 * 
	 * @hibernate.id
	 * type = "composite"
	 * 
	 */
	public GeoHubKey getCompositeKey() {
		return compositeKey;
	}


	/**
	 * @param compositeKey The compositeKey to set.
	 */
	public void setCompositeKey(GeoHubKey compositeKey) {
		this.compositeKey = compositeKey;
	}


	/**
	 * @return Returns the heCodigo.
	 * 
	 * @hibernate.property
	 * column="he_codigo"
	 * type = "string"
	 */
	public String getHeCodigo() {
		return heCodigo;
	}


	/**
	 * @param heCodigo The heCodigo to set.
	 */
	public void setHeCodigo(String heCodigo) {
		this.heCodigo = heCodigo;
	}


	/**
	 * @return Returns the huCod.
	 * 
	 * @hibernate.property
	 * column="hu_cod"
	 * type = "string"
	 */
	public String getHuCod() {
		return huCod;
	}


	/**
	 * @param huCod The huCod to set.
	 */
	public void setHuCod(String huCod) {
		this.huCod = huCod;
	}


	/**
	 * @return Returns the huDescricao.
	 * 
	 * @hibernate.property
	 * column="hu_descricao"
	 * type = "string"	 
	 *  
	 */
	public String getHuDescricao() {
		return huDescricao;
	}


	/**
	 * @param huDescricao The huDescricao to set.
	 */
	public void setHuDescricao(String huDescricao) {
		this.huDescricao = huDescricao;
	}

}
