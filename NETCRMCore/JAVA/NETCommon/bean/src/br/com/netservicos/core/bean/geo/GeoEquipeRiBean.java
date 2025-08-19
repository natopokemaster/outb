package br.com.netservicos.core.bean.geo;

import br.com.netservicos.framework.core.bean.WebBean;
import br.com.netservicos.framework.util.BaseConstants;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela geo_equipe_ri.
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
 * 06/06/2005 Ramon Carvalho N/A      Entidades      Created.
 * 06/06/2005 Ramon Carvalho 1.0      Entidades      Development.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "geo_equipe_ri"
 *                   dynamic-insert = "true"
 *                   dynamic-update = "true"
 *  					proxy="br.com.netservicos.core.bean.geo.GeoEquipeRiBean"
 * 					lazy="true" 
 *
 * @hibernate.query name  = "lstGeoEquipeRi"
 *                   query = "FROM 	br.com.netservicos.core.bean.geo.GeoEquipeRiBean as bean"
 *
 * @hibernate.query name  = "lstGeoEquipeRiByIdPessoa"
 *                   query = "SELECT equipe
 *                   		 FROM 	br.com.netservicos.core.bean.geo.GeoTecnicoEquipeRiBean tecnicoEquipe,
 *                   				br.com.netservicos.core.bean.geo.GeoEquipeRiBean equipe
 *                   		 WHERE  tecnicoEquipe.compositeKey.idEquipeRi = equipe.idEquipeRi
 *                   		   AND  tecnicoEquipe.compositeKey.ciCodigo = equipe.ciCodigo
 *                   		   AND  tecnicoEquipe.compositeKey.idPessoa = :idPessoa"
 * 
 * 
 */
public class GeoEquipeRiBean extends WebBean {

	private String idEquipeRi;

	private String ciCodigo;

	private String descEquipeRi;

	private Integer ativo;

	private Long idEqTecnico;

	private String eMail;

	private String telefone;

    public static final String ID_EQUIPE_RI = "idEquipeRi";
	
    public GeoEquipeRiBean() {
    	super(ID_EQUIPE_RI);
    	metaData.put(BaseConstants.GENERATOR_TYPE,
				BaseConstants.GENERATOR_TYPE_SEQUENCE);
		metaData.put(BaseConstants.GENERATOR_SEQUENCE_NAME, "sie_id_equipe_ri");
    }
    
	public GeoEquipeRiBean(String idEquipeRi) {
		this();
		this.idEquipeRi = idEquipeRi;
	}

	/** 
	 * @hibernate.id
	 * generator-class="assigned"
	 * unsaved-value = "null" 
	 * column="id_equipe_ri"
	 */
	public String getIdEquipeRi() {
		return idEquipeRi;
	}

	public void setIdEquipeRi(String idEquipeRi) {
		this.idEquipeRi = idEquipeRi;
	}
	
	/**
	 * Obtains and returns the new value of the ativo attribute.
	 * 
	 * @return Returns the ativo.
	 * 
	 * @hibernate.property
	 * column="ativo"
	 * type = "int"
	 */
	public Integer getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo The ativo to set.
	 */
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	/**
	 * Obtains and returns the new value of the descEquipeRi attribute.
	 * 
	 * @return Returns the descEquipeRi.
	 * 
	 * @hibernate.property
	 * column="desc_equipe_ri"
	 * type = "string"
	 */
	public String getDescEquipeRi() {
		return descEquipeRi;
	}

	/**
	 * @param descEquipeRi The descEquipeRi to set.
	 */
	public void setDescEquipeRi(String descEquipeRi) {
		this.descEquipeRi = descEquipeRi;
	}

	/**
	 * Obtains and returns the new value of the eMail attribute.
	 * 
	 * @return Returns the eMail.
	 * 
	 * @hibernate.property
	 * column="e_mail"
	 * type = "string"
	 */
	public String getEMail() {
		return eMail;
	}

	/**
	 * @param eMail The eMail to set.
	 */
	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * Obtains and returns the new value of the idEqTecnico attribute.
	 * 
	 * @return Returns the idEqTecnico.
	 * 
	 * @hibernate.property
	 * column="id_eq_tecnico"
	 * type = "long"
	 */
	public Long getIdEqTecnico() {
		return idEqTecnico;
	}

	/**
	 * @param idEqTecnico The idEqTecnico to set.
	 */
	public void setIdEqTecnico(Long idEqTecnico) {
		this.idEqTecnico = idEqTecnico;
	}

	/**
	 * Obtains and returns the new value of the telefone attribute.
	 * 
	 * @return Returns the telefone.
	 * 
	 * @hibernate.property
	 * column="telefone"
	 * type = "string"
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone The telefone to set.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
