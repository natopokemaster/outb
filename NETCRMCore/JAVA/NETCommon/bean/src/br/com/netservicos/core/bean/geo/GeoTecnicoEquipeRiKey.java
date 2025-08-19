package br.com.netservicos.core.bean.geo;

import java.io.Serializable;
import java.util.StringTokenizer;

import br.com.netservicos.framework.util.exception.BaseFailureException;

public class GeoTecnicoEquipeRiKey implements Serializable {

	private String idPessoa;

	private String idEquipeRi;

	private String ciCodigo;

	public GeoTecnicoEquipeRiKey() {
	}

	public GeoTecnicoEquipeRiKey(String idPessoa, String idEquipeRi,
			String ciCodigo) {
		this.idPessoa = idPessoa;
		this.idEquipeRi = idEquipeRi;
		this.ciCodigo = ciCodigo;
	}

	/**
	 * @return Returns the idPessoa.
	 * 
	 * @hibernate.property
	 * column="id_pessoa"
	 * type = "string"
	 */
	public String getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}

	public boolean equals(Object key) {
		if (key instanceof GeoTecnicoEquipeRiKey) {
			GeoTecnicoEquipeRiKey comp = (GeoTecnicoEquipeRiKey) key;
			return this.getIdPessoa().equals(comp.getIdPessoa())
					&& this.getIdEquipeRi().equals(comp.getIdEquipeRi())
					&& this.getCiCodigo().equals(comp.getCiCodigo());
		} else {
			return super.equals(key);
		}
	}

	public int hashCode() {
		int value = (getIdPessoa().hashCode() + getIdEquipeRi().hashCode() * 2 + getCiCodigo()
				.hashCode() * 3);
		return (int) (value ^ (value >>> 32));
	}

	public void buildKey(String value) {
		try {
			StringTokenizer tok = new StringTokenizer(value, "|");
			String idPessoa = tok.nextToken();
			String idEquipe = tok.nextToken();
			String cidContrato = tok.nextToken();
			this.setIdPessoa(idPessoa);
			this.setIdEquipeRi(idEquipe);
			this.setCiCodigo(cidContrato);
		} catch (Exception e) {
			throw new BaseFailureException(e);
		}
	}

	public String toString() {
		return this.getIdPessoa() + "|" + this.getIdEquipeRi() + "|"
				+ this.getCiCodigo();
	}

	/**
	 * @return Returns the idEquipeRi.
	 * 
	 * @hibernate.property
	 * column="id_equipe_ri"
	 * type = "string"
	 */
	public String getIdEquipeRi() {
		return idEquipeRi;
	}

	public void setIdEquipeRi(String idEquipeRi) {
		this.idEquipeRi = idEquipeRi;
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

	public void setCiCodigo(String ciCodigo) {
		this.ciCodigo = ciCodigo;
	}

}
