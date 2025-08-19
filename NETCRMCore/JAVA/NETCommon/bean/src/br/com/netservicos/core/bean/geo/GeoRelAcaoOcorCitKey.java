package br.com.netservicos.core.bean.geo;

import java.io.Serializable;
import java.util.StringTokenizer;

import br.com.netservicos.framework.core.bean.BaseCompositeKey;
import br.com.netservicos.framework.util.exception.BaseFailureException;

public class GeoRelAcaoOcorCitKey implements Serializable, BaseCompositeKey {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2319927486161365954L;
	private String ciCodigo;
	private Integer idTipoOcorrencia;
	private String codTipoEdificacao;
	
	
	/**
	 * 
	 */
	public GeoRelAcaoOcorCitKey() {
		super();
	}



	/**
	 * @param ciCodigo
	 * @param idTipoOcorrencia
	 * @param codTipoEdificacao
	 */
	public GeoRelAcaoOcorCitKey(String ciCodigo, Integer idTipoOcorrencia, String codTipoEdificacao) {
		super();
		this.ciCodigo = ciCodigo;
		this.idTipoOcorrencia = idTipoOcorrencia;
		this.codTipoEdificacao = codTipoEdificacao;
	}



	public void buildKey(String value) {
		try {
			StringTokenizer tok = new StringTokenizer(value, "|");
			String ciCodigo = tok.nextToken();
			String idTipoOcorrencia = tok.nextToken();
			String codTipoEdificacao = tok.nextToken();
			this.ciCodigo = ciCodigo;
			this.idTipoOcorrencia = Integer.valueOf(idTipoOcorrencia);
			this.codTipoEdificacao = codTipoEdificacao;
		} catch (Exception e) {
			throw new BaseFailureException(e);
		}
		
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object key) {
		if (key instanceof GeoRelAcaoOcorCitKey) {
			GeoRelAcaoOcorCitKey comp = (GeoRelAcaoOcorCitKey) key;
			return this.getCodTipoEdificacao().equals(comp.getCodTipoEdificacao())
					&& this.getCiCodigo().equals(comp.getCiCodigo())
					&& this.getIdTipoOcorrencia().equals(comp.getIdTipoOcorrencia());
		} else {
			return super.equals(key);
		}
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int value = (getIdTipoOcorrencia().hashCode() + (getCiCodigo().hashCode() * 2) + (getCodTipoEdificacao().hashCode() * 3));
		return (int) (value ^ (value >>> 32));
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ciCodigo + "|" + idTipoOcorrencia + "|" + codTipoEdificacao;
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
	 * @return Returns the codTipoEdificacao.
	 *
	 * @hibernate.property
	 * column="cod_tipo_edificacao"
	 * type = "string"   
	 */
	public String getCodTipoEdificacao() {
		return codTipoEdificacao;
	}



	/**
	 * @param codTipoEdificacao The codTipoEdificacao to set.
	 */
	public void setCodTipoEdificacao(String codTipoEdificacao) {
		this.codTipoEdificacao = codTipoEdificacao;
	}



	/**
	 * @return Returns the idTipoOcorrencia.
	 * 
	 * @hibernate.property
	 * column="id_tipo_ocorrencia"
	 * type = "int"   
	 * 
	 */
	public Integer getIdTipoOcorrencia() {
		return idTipoOcorrencia;
	}



	/**
	 * @param idTipoOcorrencia The idTipoOcorrencia to set.
	 */
	public void setIdTipoOcorrencia(Integer idTipoOcorrencia) {
		this.idTipoOcorrencia = idTipoOcorrencia;
	}

	
}
