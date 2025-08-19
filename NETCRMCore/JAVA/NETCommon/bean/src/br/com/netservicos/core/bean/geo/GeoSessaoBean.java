package br.com.netservicos.core.bean.geo;

import java.util.Date;

import br.com.netservicos.framework.core.bean.WebBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela geo_sessao
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
 * 15/10/2005 Robin Gray N/A      Entidades      Created.
 * ==============================================================================
 * </PRE>
 *
 * @hibernate.class table = "geo_sessao"
 *                  dynamic-insert = "true"
 *                  dynamic-update = "true"
 * 					lazy="false" 
 *
 * @hibernate.query name="lstSessoesAtlas"
 * 					query=" FROM br.com.netservicos.core.bean.geo.GeoSessaoBean as bean
 * 							where bean.compositeKey.seCodigo = :sessaoId"
 * 
 */

public class GeoSessaoBean extends WebBean {
	
	public static final String LST_SESSOES_ATLAS = "lstSessoesAtlas";
	
	public static final String KEY_SESSAO_ID = "sessaoId";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1085229138961972458L;

	private GeoSessaoKey compositeKey;
	
	private Date seData;
	
	private String tipoOperacao;
	
	private String operSistema;
	
	private Integer modulo;
	
	private Integer grupo;
	
	public GeoSessaoBean() {
		super("compositeKey");
	}

	/**
	 * @return Returns the compositeKey.
	 * 
	 * @hibernate.id
	 * type = "composite"
	 */
	public GeoSessaoKey getCompositeKey() {
		return compositeKey;
	}

	/**
	 * @param compositeKey The compositeKey to set.
	 */
	public void setCompositeKey(GeoSessaoKey compositeKey) {
		this.compositeKey = compositeKey;
	}

	/**
	 * @return Returns the grupo.
	 * 
	 * @hibernate.property
	 * column="grupo"
	 * type = "int" 
	 */
	public Integer getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo The grupo to set.
	 */
	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return Returns the modulo.
	 * 
	 * @hibernate.property
	 * column="modulo"
	 * type = "int" 
	 */
	public Integer getModulo() {
		return modulo;
	}

	/**
	 * @param modulo The modulo to set.
	 */
	public void setModulo(Integer modulo) {
		this.modulo = modulo;
	}

	/**
	 * @return Returns the operSistema.
	 * 
	 * @hibernate.property
	 * column="oper_sistema"
	 * type = "string" 
	 */
	public String getOperSistema() {
		return operSistema;
	}

	/**
	 * @param operSistema The operSistema to set.
	 */
	public void setOperSistema(String operSistema) {
		this.operSistema = operSistema;
	}

	/**
	 * @return Returns the seData.
	 * 
	 * @hibernate.property
	 * column="se_data"
	 * type = "date" 
	 * 
	 */
	public Date getSeData() {
		return seData;
	}

	/**
	 * @param seData The seData to set.
	 */
	public void setSeData(Date seData) {
		this.seData = seData;
	}

	/**
	 * @return Returns the tipoOperacao.
	 * 
	 * @hibernate.property
	 * column="tipo_operacao"
	 * type = "string" 
	 */
	public String getTipoOperacao() {
		return tipoOperacao;
	}

	/**
	 * @param tipoOperacao The tipoOperacao to set.
	 */
	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
}
