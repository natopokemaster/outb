package br.com.netservicos.core.bean.sn;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>Description :</B><BR>
 * Classe Bean que representa a tabela sn_contrato_coletivo
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
 * 13/09/2010 Márcio Dantas	  N/A      NetCRM            Criação
 * ==============================================================================
 * </PRE>
 *
 * @author marcio@mdantas.com.br
 * @since 13/09/2010
 * @version $Revision: 1.2 $
 * 
 * @hibernate.class
 * 		table="sn_rel_contrato_mestre_filiado"
 *      dynamic-insert="true"
 *      dynamic-update="true"
 *      lazy="true" 
 *		batch-size="10"
 */
public class SnContratoColetivoBean extends DomainBean {

	private static final long serialVersionUID = 820618364406798054L;
	
	private SnContratoColetivoKey composite;
    
	private Integer idModalidadeColetivo;
	private Integer idModalidadeCobranca;
	private Integer idTipoRestricao;
	private Long valorAdesao; //decimal
	private Integer valorPlanoPgto;
	private String cortesia;
	private String contato;
	private String foneContato;
	private String obs;
	private Integer numPeriodoMinVigencia;
	private Date dtPeriodoMinVigencia;
	private Long valorConstrMdu; //decimal
	private Integer indicadorPlanoMdu;
	private Integer qtdPaAreaComum;
	private Integer numPeriodoPayback;
	private Date dtPeriodoPayback;
	private Integer numMultiploMensalidade;
	private Integer numTaxaPenetracao; //decimal
	private Integer indicadorTaxaPenetracao;
	private Integer numTaxaMigracao; //decimal
	private Integer indicadorTaxaMigracao;
	private Integer idCAracteristicaColetivo;
	
	public static final String ATRIBUTO_ID_COMPOSITE = "composite";
	
	/**
	 *  
	 */
	public SnContratoColetivoBean() {
		super(ATRIBUTO_ID_COMPOSITE);
	}

	/**
	 * 
	 * @return Composite
	 * 
	 * @hibernate.id
	 * type = "composite" 
	 */
	public SnContratoColetivoKey getComposite() {
		return composite;
	}
	
	/**
	 * 
	 * @param composite
	 */
	public void setComposite(SnContratoColetivoKey composite) {
		this.composite = composite;
	}

	/**
	 * @return the idModalidadeColetivo
	 * @hibernate.property
	 * column = "id_modalidade_coletivo"
	 * type = "int"
	 */
	public Integer getIdModalidadeColetivo() {
		return idModalidadeColetivo;
	}

	/**
	 * @param idModalidadeColetivo the idModalidadeColetivo to set
	 */
	public void setIdModalidadeColetivo(Integer idModalidadeColetivo) {
		this.idModalidadeColetivo = idModalidadeColetivo;
	}

	/**
	 * @return the idModalidadeCobranca
	 * @hibernate.property
	 * column = "id_modalidade_cobranca"
	 * type = "int"
	 */
	public Integer getIdModalidadeCobranca() {
		return idModalidadeCobranca;
	}

	/**
	 * @param idModalidadeCobranca the idModalidadeCobranca to set
	 */
	public void setIdModalidadeCobranca(Integer idModalidadeCobranca) {
		this.idModalidadeCobranca = idModalidadeCobranca;
	}

	/**
	 * @return the idTipoRestricao
	 * @hibernate.property
	 * column = "id_tipo_restricao"
	 * type = "int"
	 */
	public Integer getIdTipoRestricao() {
		return idTipoRestricao;
	}

	/**
	 * @param idTiporestricao the idTiporestricao to set
	 */
	public void setIdTipoRestricao(Integer idTipoRestricao) {
		this.idTipoRestricao = idTipoRestricao;
	}

	/**
	 * @return the valorAdesao
	 * @hibernate.property
	 * column = "valor_adesao"
	 * type = "long"
	 */
	public Long getValorAdesao() {
		return valorAdesao;
	}

	/**
	 * @param valorAdesao the valorAdesao to set
	 */
	public void setValorAdesao(Long valorAdesao) {
		this.valorAdesao = valorAdesao;
	}

	/**
	 * @return the valorPlanoPgto
	 * @hibernate.property
	 * column = "valor_plano_pgto"
	 * type = "int"
	 */
	public Integer getValorPlanoPgto() {
		return valorPlanoPgto;
	}

	/**
	 * @param valorPLanoPgto the valorPLanoPgto to set
	 */
	public void setValorPlanoPgto(Integer valorPlanoPgto) {
		this.valorPlanoPgto = valorPlanoPgto;
	}

	/**
	 * @return the cortesia
	 * @hibernate.property
	 * column = "cortesia"
	 * type = "string"
	 */
	public String getCortesia() {
		return cortesia;
	}

	/**
	 * @param cortesia the cortesia to set
	 */
	public void setCortesia(String cortesia) {
		this.cortesia = cortesia;
	}

	/**
	 * @return the contato
	 * @hibernate.property
	 * column = "contato"
	 * type = "string"
	 */
	public String getContato() {
		return contato;
	}

	/**
	 * @param contato the contato to set
	 */
	public void setContato(String contato) {
		this.contato = contato;
	}

	/**
	 * @return the foneContato
	 * @hibernate.property
	 * column = "fone_contato"
	 * type = "string"
	 */
	public String getFoneContato() {
		return foneContato;
	}

	/**
	 * @param foneContato the foneContato to set
	 */
	public void setFoneContato(String foneContato) {
		this.foneContato = foneContato;
	}

	/**
	 * @return the obs
	 * @hibernate.property
	 * column = "obs"
	 * type = "string"
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return the numPeriodoMinVigencia
	 * @hibernate.property
	 * column = "num_periodo_min_vigencia"
	 * type = "int"
	 */
	public Integer getNumPeriodoMinVigencia() {
		return numPeriodoMinVigencia;
	}

	/**
	 * @param numPeriodoMinVigencia the numPeriodoMinVigencia to set
	 */
	public void setNumPeriodoMinVigencia(Integer numPeriodoMinVigencia) {
		this.numPeriodoMinVigencia = numPeriodoMinVigencia;
	}

	/**
	 * @return the dtPeriodoMinVigencia
	 * @hibernate.property
	 * column = "periodo_min_vigencia"
	 * type = "date"
	 */
	public Date getDtPeriodoMinVigencia() {
		return dtPeriodoMinVigencia;
	}

	/**
	 * @param dtPeriodoMinVigencia the dtPeriodoMinVigencia to set
	 */
	public void setDtPeriodoMinVigencia(Date dtPeriodoMinVigencia) {
		this.dtPeriodoMinVigencia = dtPeriodoMinVigencia;
	}

	/**
	 * @return the valorConstrMdu
	 * @hibernate.property
	 * column = "valor_constr_mdu"
	 * type = "int"
	 */
	public Long getValorConstrMdu() {
		return valorConstrMdu;
	}

	/**
	 * @param valorConstrMdu the valorConstrMdu to set
	 */
	public void setValorConstrMdu(Long valorConstrMdu) {
		this.valorConstrMdu = valorConstrMdu;
	}

	/**
	 * @return the indicadorPlanoMdu
	 * @hibernate.property
	 * column = "indicador_plano_mdu"
	 * type = "int"
	 */
	public Integer getIndicadorPlanoMdu() {
		return indicadorPlanoMdu;
	}

	/**
	 * @param indicadorPlanoMdu the indicadorPlanoMdu to set
	 */
	public void setIndicadorPlanoMdu(Integer indicadorPlanoMdu) {
		this.indicadorPlanoMdu = indicadorPlanoMdu;
	}

	/**
	 * @return the qtdPaAreaComum
	 * @hibernate.property
	 * column = "qtd_pa_area_comum"
	 * type = "int"
	 */
	public Integer getQtdPaAreaComum() {
		return qtdPaAreaComum;
	}

	/**
	 * @param qtdPaAreaComum the qtdPaAreaComum to set
	 */
	public void setQtdPaAreaComum(Integer qtdPaAreaComum) {
		this.qtdPaAreaComum = qtdPaAreaComum;
	}

	/**
	 * @return the numPeriodoPayback
	 * @hibernate.property
	 * column = "num_periodo_payback"
	 * type = "int"
	 */
	public Integer getNumPeriodoPayback() {
		return numPeriodoPayback;
	}

	/**
	 * @param numPeriodoPayback the numPeriodoPayback to set
	 */
	public void setNumPeriodoPayback(Integer numPeriodoPayback) {
		this.numPeriodoPayback = numPeriodoPayback;
	}

	/**
	 * @return the dtPeriodoPayback
	 * @hibernate.property
	 * column = "dt_periodo_payback"
	 * type = "date"
	 */
	public Date getDtPeriodoPayback() {
		return dtPeriodoPayback;
	}

	/**
	 * @param dtPeriodoPayback the dtPeriodoPayback to set
	 */
	public void setDtPeriodoPayback(Date dtPeriodoPayback) {
		this.dtPeriodoPayback = dtPeriodoPayback;
	}

	/**
	 * @return the numMultiploMensalidade
	 * @hibernate.property
	 * column = "num_multiplo_mensalidade"
	 * type = "int"
	 */
	public Integer getNumMultiploMensalidade() {
		return numMultiploMensalidade;
	}

	/**
	 * @param numMultiploMensalidade the numMultiploMensalidade to set
	 */
	public void setNumMultiploMensalidade(Integer numMultiploMensalidade) {
		this.numMultiploMensalidade = numMultiploMensalidade;
	}

	/**
	 * @return the numTaxaPenetracao
	 * @hibernate.property
	 * column = "num_taxa_penetracao"
	 * type = "int"
	 */
	public Integer getNumTaxaPenetracao() {
		return numTaxaPenetracao;
	}

	/**
	 * @param numTaxaPenetracao the numTaxaPenetracao to set
	 */
	public void setNumTaxaPenetracao(Integer numTaxaPenetracao) {
		this.numTaxaPenetracao = numTaxaPenetracao;
	}

	/**
	 * @return the indicadorTaxaPenetracao
	 * @hibernate.property
	 * column = "indicador_taxa_penetracao"
	 * type = "int"
	 */
	public Integer getIndicadorTaxaPenetracao() {
		return indicadorTaxaPenetracao;
	}

	/**
	 * @param indicadorTaxaPenetracao the indicadorTaxaPenetracao to set
	 */
	public void setIndicadorTaxaPenetracao(Integer indicadorTaxaPenetracao) {
		this.indicadorTaxaPenetracao = indicadorTaxaPenetracao;
	}

	/**
	 * @return the numTaxaMigracao
	 * @hibernate.property
	 * column = "num_taxa_migracao"
	 * type = "int"
	 */
	public Integer getNumTaxaMigracao() {
		return numTaxaMigracao;
	}

	/**
	 * @param numTaxaMigracao the numTaxaMigracao to set
	 */
	public void setNumTaxaMigracao(Integer numTaxaMigracao) {
		this.numTaxaMigracao = numTaxaMigracao;
	}

	/**
	 * @return the indicadorTaxaMigracao
	 * @hibernate.property
	 * column = "indicador_taxa_migracao"
	 * type = "int"
	 */
	public Integer getIndicadorTaxaMigracao() {
		return indicadorTaxaMigracao;
	}

	/**
	 * @param indicadorTaxaMigracao the indicadorTaxaMigracao to set
	 */
	public void setIndicadorTaxaMigracao(Integer indicadorTaxaMigracao) {
		this.indicadorTaxaMigracao = indicadorTaxaMigracao;
	}

	/**
	 * @return the idCAracteristicaColetivo
	 * @hibernate.property
	 * column = "id_caracteristica_coletivo"
	 * type = "int"
	 */
	public Integer getIdCAracteristicaColetivo() {
		return idCAracteristicaColetivo;
	}

	/**
	 * @param idCAracteristicaColetivo the idCAracteristicaColetivo to set
	 */
	public void setIdCAracteristicaColetivo(Integer idCAracteristicaColetivo) {
		this.idCAracteristicaColetivo = idCAracteristicaColetivo;
	}
	
}
