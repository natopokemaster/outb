package br.com.netservicos.core.bean.sn;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_tipo_ocorrencia
 * </P>
 * <P>
 * <B> Issues : <BR>
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- ------------------------
 * 
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                           Prior
 * Date       By             Version  Project/CSR    	Description
 * ---------- -------------- -------- --------------    -------------------------
 * ==============================================================================
 * </PRE>
 *
 * 
 * @hibernate.class 
 * 		table="sn_tipo_ocorrencia"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 *		schema="prod_jd"
 *
 * @hibernate.query name = "buscarPorId"
 * 					query = "FROM br.com.netservicos.core.bean.sn.SnTipoOcorrenciaBean tipo
 * 							  where	tipo.idTipoOcorrencia = :idTipoOcorrencia"
 *
 * @hibernate.query name = "buscarPorDescricao"
 * 					query = "FROM br.com.netservicos.core.bean.sn.SnTipoOcorrenciaBean tipo
 * 							  where	tipo.descricao = :descricao"
 */
public class SnTipoOcorrenciaBean extends DomainBean {

	private static final long serialVersionUID = 62526520660972693L;
	private static final String ID_TIPO_OCORRENCIA = "idTipoOcorrencia";
	public static final String BUSCAR_POR_ID = "buscarPorId";
	public static final String BUSCAR_POR_DESCRICAO = "buscarPorDescricao";
	public static final String GET_BY_DESCRIPTION = "SnTipoOcorrencia.get.by.description";

	public SnTipoOcorrenciaBean(){
		super(ID_TIPO_OCORRENCIA);
	}
	
	private Long idTipoOcorrencia;
	private String descricao;
	private Integer encerradaPorQuemAbriu;
	private Integer relacionadaCanal;
	private Integer flagHistorico;
	private Integer idDepto;

	/**
	 * @return Returns the idTipoOcorrencia.
	 *
	 * @hibernate.id 
	 * 		generator-class="assigned"
	 * 		unsaved-value="null"
	 * 		column="id_tipo_ocorrencia"
	 */
	public Long getIdTipoOcorrencia() {
		return idTipoOcorrencia;
	}
	public void setIdTipoOcorrencia(Long idTipoOcorrencia) {
		this.idTipoOcorrencia = idTipoOcorrencia;
	}
	
	/**
     * @return Returns the descricao.
     * 
     * @hibernate.property
     * 		column = "descricao"
     */
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
     * @return Returns the encerradaPorQuemAbriu.
     * 
     * @hibernate.property
     * 		column = "encerrada_por_quem_abriu"
     */
	public Integer getEncerradaPorQuemAbriu() {
		return encerradaPorQuemAbriu;
	}
	public void setEncerradaPorQuemAbriu(Integer encerradaPorQuemAbriu) {
		this.encerradaPorQuemAbriu = encerradaPorQuemAbriu;
	}
	
	/**
     * @return Returns the relacionadaCanal.
     * 
     * @hibernate.property
     * 		column = "relacionada_a_canal"
     */
	public Integer getRelacionadaCanal() {
		return relacionadaCanal;
	}
	public void setRelacionadaCanal(Integer relacionadaCanal) {
		this.relacionadaCanal = relacionadaCanal;
	}
	
	/**
     * @return Returns the flagHistorico.
     * 
     * @hibernate.property
     * 		column = "flag_historico"
     */
	public Integer getFlagHistorico() {
		return flagHistorico;
	}
	public void setFlagHistorico(Integer flagHistorico) {
		this.flagHistorico = flagHistorico;
	}
	
	/**
     * @return Returns the idDepto.
     * 
     * @hibernate.property
     * 		column = "id_depto"
     */
	public Integer getIdDepto() {
		return idDepto;
	}
	public void setIdDepto(Integer idDepto) {
		this.idDepto = idDepto;
	}
		
}
