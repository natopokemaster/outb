package br.com.netservicos.core.bean.sn;

import java.io.Serializable;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;

public class SnRelTipoSolicTipoOsKey implements Serializable, BaseCompositeKey {

	private SnTipoOsBean tipoOs;

	private SnTipoSolicProdBean tipoSolicProd;

	/**
	 * Obtains and returns the SnTipoOsBean.
	 *
	 * @return Returns the tipoOs.
	 * 
	 * @hibernate.many-to-one  
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoOsBean" 
	 * 		column="id_tipo_os"
	 * 		cascade="none"
	 * 		not-null="true"
	 */
	public SnTipoOsBean getTipoOs() {
		return tipoOs;
	}

	/**
	 * @param tipoOs The tipoOs to set.
	 */
	public void setTipoOs(SnTipoOsBean tipoOs) {
		this.tipoOs = tipoOs;
	}

	/**
	 * Obtains and returns the SnTipoSolicProdBean.
	 *
	 * @return Returns the midia.
	 * 
	 * @hibernate.many-to-one  
	 * 		class="br.com.netservicos.core.bean.sn.SnTipoSolicProdBean" 
	 * 		column="id_tipo_solic_prod"
	 * 		cascade="none"
	 * 		not-null="true"
	 */
	public SnTipoSolicProdBean getTipoSolicProd() {
		return tipoSolicProd; 
	}
 
	/**
	 * @param campanha The campanha to set.
	 */
	public void setTipoSolicProd(SnTipoSolicProdBean tipoSolicProd) {
		this.tipoSolicProd = tipoSolicProd; 
	}

	/**
	 */
	public boolean equals(Object key) {
		if (key instanceof SnRelTipoSolicTipoOsKey) {
			SnRelTipoSolicTipoOsKey comp = (SnRelTipoSolicTipoOsKey) key;
			return this.getTipoOs().getIdTipoOs().equals(
					comp.getTipoOs().getIdTipoOs())
					&& this.getTipoSolicProd().getIdTipoSolicProd().equals(
							comp.getTipoSolicProd().getIdTipoSolicProd());
		} else {
			return super.equals(key);
		}
	}

	/**
	 */
	public int hashCode() {
		int value = (getTipoOs().getIdTipoOs().hashCode() + getTipoSolicProd()
				.getIdTipoSolicProd().hashCode() * 2);
		return (int) (value ^ (value >>> 32));
	}

	public void buildKey(String value) {
		// TODO Auto-generated method stub
	}

}