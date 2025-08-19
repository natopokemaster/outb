/**
 * 
 */
package br.com.netservicos.core.bean.geo;

import java.io.Serializable;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;
import br.com.netservicos.framework.util.exception.BaseFailureException;

/**
 * @author rmgray
 *
 */
public class GeoSessaoKey implements Serializable, BaseCompositeKey {

	private String usCodigo;
	private String ciCodigo;
	private String seCodigo;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3337696982622272857L;

	
	
	
	/**
	 * 
	 */
	public GeoSessaoKey() {
		super();
	}



	/**
	 * @param usCodigo
	 * @param ciCodigo
	 * @param seCodigo
	 */
	public GeoSessaoKey(String usCodigo, String ciCodigo, String seCodigo) {
		super();
		this.usCodigo = usCodigo;
		this.ciCodigo = ciCodigo;
		this.seCodigo = seCodigo;
	}



	public void buildKey(String value) {
		try {
			StringTokenizer tok = new StringTokenizer(value, "|");
			String usCodigo = tok.nextToken();
			String ciCodigo = tok.nextToken();
			String seCodigo = tok.nextToken();
			this.usCodigo = usCodigo;
			this.ciCodigo = ciCodigo;
			this.seCodigo = seCodigo;
		} catch (Exception e) {
			throw new BaseFailureException(e);
		}
		
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object key) {
		if (key instanceof GeoSessaoKey) {
			GeoSessaoKey comp = (GeoSessaoKey) key;
			return this.getUsCodigo().equals(comp.getUsCodigo())
					&& this.getCiCodigo().equals(comp.getCiCodigo())
					&& this.getSeCodigo().equals(comp.getSeCodigo());
		} else {
			return super.equals(key);
		}
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int value = (getUsCodigo().hashCode() + (getCiCodigo().hashCode() * 2) + (getSeCodigo().hashCode() * 3));
		return (int) (value ^ (value >>> 32));
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return usCodigo + "|" + ciCodigo + "|" + seCodigo;
	}



	/**
	 * @return Returns the ciCodigo.
	 * 
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
	 * @return Returns the seCodigo.
	 * 
	 * 
	 * @hibernate.property
	 * column="se_codigo"
	 * type = "string"
	 */
	public String getSeCodigo() {
		return seCodigo;
	}

	/**
	 * @param seCodigo The seCodigo to set.
	 */
	public void setSeCodigo(String seCodigo) {
		this.seCodigo = seCodigo;
	}

	/**
	 * @return Returns the usCodigo.
	 * 
	 * 
	 * @hibernate.property
	 * column="us_codigo"
	 * type = "string" 
	 */
	public String getUsCodigo() {
		return usCodigo;
	}

	/**
	 * @param usCodigo The usCodigo to set.
	 */
	public void setUsCodigo(String usCodigo) {
		this.usCodigo = usCodigo;
	}

}
