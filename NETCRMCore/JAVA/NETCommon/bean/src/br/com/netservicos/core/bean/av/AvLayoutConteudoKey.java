package br.com.netservicos.core.bean.av;

import java.io.Serializable;
import java.util.Date;

/**
 * <P>
 * <B>Description :</B><BR>
 * Classe Bean que representa as chaves primárias da tabela AV_LAYOUT_CONTEUDO.
 * </P>
 * <B> Issues : <BR>
 *
 *
 */
public class AvLayoutConteudoKey implements Serializable{

	/**
	 * long
	 */
	private static final long serialVersionUID = 5818210060847924531L;

	/**
	 * CD_LAYOUT_CONTEUDO VARCHAR2(5) NOT NULL, Codigo do layout de conteudo.
	 */
	private String codigoLayout;

	/**
	 *  DT_INI DATE NOT NULL, Data inicio do layout de conteudo.
	 */
	private Date dtIni;

	/**
	 *  DT_FIM DATE NOT NULL, Data fim do layout do conteudo.
	 */
	private Date dtFim;


	/**
	 * Recupera o codigo layout do conteudo.
	 * 
	 * @return the codigoLayout
	 * @hibernate.property column="CD_LAYOUT_CONTEUDO" type="string"
	 */
	public String getCodigoLayout() {
		return this.codigoLayout;
	}

	/**
	 * @param codigoLayout
	 *            the codigoLayout to set
	 */
	public void setCodigoLayout(final String codigoLayout) {
		this.codigoLayout = codigoLayout;
	}

	/**
	 * Recupera a data de inicio do layout de conteudo.
	 * 
	 * @return the dtIni
	 * @hibernate.property column="DT_INI" type="date"
	 */
	public Date getDtIni() {
		return this.dtIni;
	}

	/**
	 * @param dtIni
	 *            the dtIni to set
	 */
	public void setDtIni(final Date dtIni) {
		this.dtIni = dtIni;
	}

	/**
	 * Recupera a data fim do layout de conteudo.
	 * 
	 * @return the dtFim
	 * @hibernate.property column="DT_FIM" type="date"
	 */
	public Date getDtFim() {
		return this.dtFim;
	}

	/**
	 * @param dtFim
	 *            the dtFim to set
	 */
	public void setDtFim(final Date dtFim) {
		this.dtFim = dtFim;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.codigoLayout == null) ? 0 : this.codigoLayout.hashCode());
		result = prime * result + ((this.dtFim == null) ? 0 : this.dtFim.hashCode());
		result = prime * result + ((this.dtIni == null) ? 0 : this.dtIni.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AvLayoutConteudoKey other = (AvLayoutConteudoKey) obj;
		if (this.codigoLayout == null) {
			if (other.codigoLayout != null) {
				return false;
			}
		} else if (!this.codigoLayout.equals(other.codigoLayout)) {
			return false;
		}
		if (this.dtFim == null) {
			if (other.dtFim != null) {
				return false;
			}
		} else if (!this.dtFim.equals(other.dtFim)) {
			return false;
		}
		if (this.dtIni == null) {
			if (other.dtIni != null) {
				return false;
			}
		} else if (!this.dtIni.equals(other.dtIni)) {
			return false;
		}
		return true;
	}

}
