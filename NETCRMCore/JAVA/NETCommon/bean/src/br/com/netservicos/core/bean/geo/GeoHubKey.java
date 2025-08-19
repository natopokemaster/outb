package br.com.netservicos.core.bean.geo;

import java.io.Serializable;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;
import br.com.netservicos.framework.util.exception.BaseFailureException;

/**
 * @author rmgray
 *
 */
public class GeoHubKey implements BaseCompositeKey, Serializable {

	private String idHub;
	
	private String ciCodigo;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1722589815677445764L;
	
	/**
	 * 
	 */
	public GeoHubKey() {
		super();
	}

	/**
	 * @param idHub
	 * @param ciCodigo
	 */
	public GeoHubKey(String idHub, String ciCodigo) {
		super();
		this.idHub = idHub;
		this.ciCodigo = ciCodigo;
	}


	public boolean equals(Object key) {
		if (key instanceof GeoHubKey) {
			GeoHubKey comp = (GeoHubKey) key;
			return this.getIdHub().equals(comp.getIdHub())
					&& this.getCiCodigo().equals(comp.getCiCodigo());
		} else {
			return super.equals(key);
		}
	}

	public int hashCode() {
		int value = (getIdHub().hashCode() + getCiCodigo().hashCode() * 2);
		return (int) (value ^ (value >>> 32));
	}

	public void buildKey(String value) {
		try {
			StringTokenizer tok = new StringTokenizer(value, "|");
			String idHub = tok.nextToken();
			String ciCodigo = tok.nextToken();
			this.idHub = idHub;
			this.ciCodigo = ciCodigo;
		} catch (Exception e) {
			throw new BaseFailureException(e);
		}
		
	}
	
	public String toString() {
		return idHub + "|" + ciCodigo;
	}

	/**
	 * @return Returns the ciCodigo.
	 * 
	 * @hibernate.property
	 * column="ci_codigo"
	 * type = "string" 
	 */
	public String getCiCodigo() {
		return ciCodigo;
	}

	/**
	 * @param ciCodigo The ciCodigo to set.
	 */
	public void setCiCodigo(String ciCodigo) {
		this.ciCodigo = ciCodigo;
	}

	/**
	 * @return Returns the idHub.
	 * 
	 * @hibernate.property
	 * unsaved-value="null" 
	 * column="id_hub"
	 * type = "string"
	 * 
	 */
	public String getIdHub() {
		return idHub;
	}

	/**
	 * @param idHub The idHub to set.
	 */
	public void setIdHub(String idHub) {
		this.idHub = idHub;
	}

}
