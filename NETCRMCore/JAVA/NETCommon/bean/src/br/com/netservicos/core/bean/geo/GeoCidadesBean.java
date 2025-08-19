//Created on 19/05/2005
package br.com.netservicos.core.bean.geo;

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela geo_cidades.
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
 * 19/05/2005 Jussara Teodoro  N/A                      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "geo_cidades"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 * 					lazy="false"
 * 
 * @hibernate.cache
 *      usage="read-write"
 *
 * @hibernate.query name  = "lstGeoCidades"
 *                  query = "FROM	br.com.netservicos.core.bean.geo.GeoCidadesBean geoCidades"
 * 
 * @hibernate.query name  = "lstGeoCidadesDistinctEstado"
 *                  query = "SELECT DISTINCT geoCidades.ciEstado 
 *                  		 FROM br.com.netservicos.core.bean.geo.GeoCidadesBean geoCidades
 *                   		 ORDER BY geoCidades.ciEstado"
 * 
 * @hibernate.query name  = "lstGeoCidadesByGeoEstado"
 *                  query = "FROM br.com.netservicos.core.bean.geo.GeoCidadesBean geoCidades
 *                   		 WHERE ( geoCidades.ciEstado = :estado )
 *                   		 ORDER BY geoCidades.ciNome"
 * 
 * @hibernate.query name = "lstIdCidadeCorreiosByIdCidadeNetsales"
 * 					query="select geoCidades.idLocalidadeECN 
 * 							from br.com.netservicos.core.bean.geo.GeoCidadesBean geoCidades 
 * 							where geoCidades.ciCodigo = :ciCodigo"
 * 
 * 
 * @hibernate.query name = "lstIdCidadeCorreiosByIdDescricaoCidade"
 *                  query="select geoCidades.idLocalidadeECN 
 *                          from br.com.netservicos.core.bean.geo.GeoCidadesBean geoCidades 
 *                          where geoCidades.ciNome = UPPER(:ciNome)
 *                            and geoCidades.ciEstado = UPPER(:ciEstado)"
 * 
 * 
 * 
 * @hibernate.query name = "lstUFByIdCidadeNetsales"
 * 					query="select geoCidades.ciEstado 
 * 							from br.com.netservicos.core.bean.geo.GeoCidadesBean geoCidades 
 * 							where geoCidades.ciCodigo = :idCidade"
 * 
 */
public class GeoCidadesBean extends WebBean {

	private static final long serialVersionUID = -9141875251329384771L;

	public GeoCidadesBean() {
        super("ciCodigo");
    }

    private String ciCodigo;

	private String ciNome;

	private String ciCodUtm;

	private String ciDdd;

	private String ciEstado;

	private String ciPais;

	private String ciAno;

	private String ciAltitude;

	private String ciSinalLatitude;

	private String ciGrauLatitude;

	private String ciMinLatitude;

	private String ciSegLatitude;

	private String ciSinalLongitude;

	private String ciGrauLongitude;

	private String ciMinLongitude;

	private String ciSegLongitude;

	private String ciDdi;

	private String ciLogo;
	
	private String idLocalidadeECN;

	public static final String LST_CODIGO_CORREIO_BY_CODIGO_NETSALES = "lstIdCidadeCorreiosByIdCidadeNetsales";
	public static final String LST_ID_CIDADE_CORREIO_BY_ID_DESCRICAO_CIDADE = "lstIdCidadeCorreiosByIdDescricaoCidade";
	
	/**
	 * @return Returns the ciAltitude.
	 * 
	 * @hibernate.property
	 * column="ci_altitude"
	 * 
	 */
	public String getCiAltitude() {
		return ciAltitude;
	}

	/**
	 * @param ciAltitude The ciAltitude to set.
	 * 
	 */
	public void setCiAltitude(String ciAltitude) {
		this.ciAltitude = ciAltitude;
	}

	/**
	 * @return Returns the ciAno.
	 * 
	 * @hibernate.property
	 * column="ci_ano"
	 * 
	 */
	public String getCiAno() {
		return ciAno;
	}

	/**
	 * @param ciAno The ciAno to set.
	 * 
	 */
	public void setCiAno(String ciAno) {
		this.ciAno = ciAno;
	}

	/**
	 * @return Returns the ciCodigo.
	 * 
	 * 
	 * @hibernate.id 
	 * generator-class="assigned"
	 * column="ci_codigo"
	 * unsaved-value="null" 
	 */
	public String getCiCodigo() {
		return ciCodigo;
	}

	/**
	 * @param ciCodigo The ciCodigo to set.
	 * 
	 */
	public void setCiCodigo(String ciCodigo) {
		this.ciCodigo = ciCodigo;
	}

	/**
	 * @return Returns the ciCodUtm.
	 * 
	 * @hibernate.property
	 * column="ci_cod_utm"
	 */
	public String getCiCodUtm() {
		return ciCodUtm;
	}

	/**
	 * @param ciCodUtm The ciCodUtm to set.
	 * 
	 */
	public void setCiCodUtm(String ciCodUtm) {
		this.ciCodUtm = ciCodUtm;
	}

	/**
	 * @return Returns the ciDdd.
	 * 
	 * @hibernate.property
	 * column="ci_ddd"
	 */
	public String getCiDdd() {
		return ciDdd;
	}

	/**
	 * @param ciDdd The ciDdd to set.
	 * 
	 */
	public void setCiDdd(String ciDdd) {
		this.ciDdd = ciDdd;
	}

	/**
	 * @return Returns the ciDdi.
	 * 
	 * @hibernate.property
	 * column="ci_ddi"
	 */
	public String getCiDdi() {
		return ciDdi;
	}

	/**
	 * @param ciDdi The ciDdi to set.
	 * 
	 */
	public void setCiDdi(String ciDdi) {
		this.ciDdi = ciDdi;
	}

	/**
	 * @return Returns the ciEstado.
	 * 
	 * @hibernate.property
	 * column="ci_estado"
	 */
	public String getCiEstado() {
		return ciEstado;
	}

	/**
	 * @param ciEstado The ciEstado to set.
	 * 
	 */
	public void setCiEstado(String ciEstado) {
		this.ciEstado = ciEstado;
	}

	/**
	 * @return Returns the ciGrauLatitude.
	 * 
	 * @hibernate.property
	 * column="ci_grau_latitude"
	 */
	public String getCiGrauLatitude() {
		return ciGrauLatitude;
	}

	/**
	 * @param ciGrauLatitude The ciGrauLatitude to set.
	 * 
	 */
	public void setCiGrauLatitude(String ciGrauLatitude) {
		this.ciGrauLatitude = ciGrauLatitude;
	}

	/**
	 * @return Returns the ciGrauLongitude.
	 * 
	 * @hibernate.property
	 * column="ci_grau_longitude"
	 */
	public String getCiGrauLongitude() {
		return ciGrauLongitude;
	}

	/**
	 * @param ciGrauLongitude The ciGrauLongitude to set.
	 * 
	 */
	public void setCiGrauLongitude(String ciGrauLongitude) {
		this.ciGrauLongitude = ciGrauLongitude;
	}

	/**
	 * @return Returns the ciLogo.
	 * 
	 * @hibernate.property
	 * column="ci_logo"
	 */
	public String getCiLogo() {
		return ciLogo;
	}

	/**
	 * @param ciLogo The ciLogo to set.
	 * 
	 */
	public void setCiLogo(String ciLogo) {
		this.ciLogo = ciLogo;
	}

	/**
	 * @return Returns the ciMinLatitude.
	 * 
	 * @hibernate.property
	 * column="ci_min_latitude"
	 */
	public String getCiMinLatitude() {
		return ciMinLatitude;
	}

	/**
	 * @param ciMinLatitude The ciMinLatitude to set.
	 * 
	 */
	public void setCiMinLatitude(String ciMinLatitude) {
		this.ciMinLatitude = ciMinLatitude;
	}

	/**
	 * @return Returns the ciMinLongitude.
	 * 
	 * @hibernate.property
	 * column="ci_min_longitude"
	 */
	public String getCiMinLongitude() {
		return ciMinLongitude;
	}

	/**
	 * @param ciMinLongitude The ciMinLongitude to set.
	 * 
	 */
	public void setCiMinLongitude(String ciMinLongitude) {
		this.ciMinLongitude = ciMinLongitude;
	}

	/**
	 * @return Returns the ciNome.
	 * 
	 * @hibernate.property
	 * column="ci_nome"
	 */
	public String getCiNome() {
		return ciNome;
	}

	/**
	 * @param ciNome The ciNome to set.
	 * 
	 */
	public void setCiNome(String ciNome) {
		this.ciNome = ciNome;
	}

	/**
	 * @return Returns the ciPais.
	 * 
	 * @hibernate.property
	 * column="ci_pais"
	 */
	public String getCiPais() {
		return ciPais;
	}

	/**
	 * @param ciPais The ciPais to set.
	 * 
	 */
	public void setCiPais(String ciPais) {
		this.ciPais = ciPais;
	}

	/**
	 * @return Returns the ciSegLatitude.
	 * 
	 * @hibernate.property
	 * column="ci_seg_latitude"
	 */
	public String getCiSegLatitude() {
		return ciSegLatitude;
	}

	/**
	 * @param ciSegLatitude The ciSegLatitude to set.
	 * 
	 */
	public void setCiSegLatitude(String ciSegLatitude) {
		this.ciSegLatitude = ciSegLatitude;
	}

	/**
	 * @return Returns the ciSegLongitude.
	 * 
	 * @hibernate.property
	 * column="ci_seg_longitude"
	 */
	public String getCiSegLongitude() {
		return ciSegLongitude;
	}

	/**
	 * @param ciSegLongitude The ciSegLongitude to set.
	 * 
	 */
	public void setCiSegLongitude(String ciSegLongitude) {
		this.ciSegLongitude = ciSegLongitude;
	}

	/**
	 * @return Returns the ciSinalLatitude.
	 * 
	 * @hibernate.property
	 * column="ci_sinal_latitude"
	 */
	public String getCiSinalLatitude() {
		return ciSinalLatitude;
	}

	/**
	 * @param ciSinalLatitude The ciSinalLatitude to set.
	 * 
	 */
	public void setCiSinalLatitude(String ciSinalLatitude) {
		this.ciSinalLatitude = ciSinalLatitude;
	}

	/**
	 * @return Returns the ciSinalLongitude.
	 * 
	 * @hibernate.property
	 * column="ci_sinal_longitude"
	 */
	public String getCiSinalLongitude() {
		return ciSinalLongitude;
	}

	/**
	 * @param ciSinalLongitude The ciSinalLongitude to set.
	 * 
	 */
	public void setCiSinalLongitude(String ciSinalLongitude) {
		this.ciSinalLongitude = ciSinalLongitude;
	}

	/**
	 * @hibernate.property
	 * 		column="id_localidade_ecn"
	 * 
	 * @return The idLocalidadeECN attribute.
	 */
	public String getIdLocalidadeECN() {
		return idLocalidadeECN;
	}

	/**
	 * 
	 * @param idLocalidadeECN
	 */
	public void setIdLocalidadeECN(String idLocalidadeECN) {
		this.idLocalidadeECN = idLocalidadeECN;
	}
}
