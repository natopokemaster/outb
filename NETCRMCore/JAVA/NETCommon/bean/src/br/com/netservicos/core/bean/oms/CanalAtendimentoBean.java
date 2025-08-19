package br.com.netservicos.core.bean.oms;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * .
 * <P>
 * <B>Description :</B><BR>
 * Class which represents the table CANAL_ATENDIMENTO
 * </P>
 * <P>
 * <B> Issues : <BR>
 * None </B>
 * 
 * @author Rodnei Vete
 * @since 09/10/2009
 * 
 * @hibernate.class table = "CANAL_ATENDIMENTO" schema = "NETOMS" dynamic-insert
 *                  = "true" dynamic-update = "true" lazy="true"
 * 
 * 
 * @hibernate.cache usage = "read-write"
 * 
 */
public class CanalAtendimentoBean extends DomainBean {

	/**
	 * long.
	 */
	private static final long serialVersionUID = 8644797195801384020L;
	private static final String PRIMARY_KEY = "idCanalAtendimento";

	public static final String PROCURA_CANAL_POR_DESCRICAO = "procuraCanalPorDescricao";
	
	private Long idCanalAtendimento;
	private String dsCanalAtendimento;
	private String fcAtivo;
	private String fcArquivo;
	private String fcIntegracao;
	private Integer qtDiasAtendimento;
	private Date dhUltimaAtualizacao;
	private String tpGrupoCanalAtendimento;
	private Integer idTempoResposta;
	
	/**
	 * Construtor padrão
	 */
	public CanalAtendimentoBean() {
		super(PRIMARY_KEY);
	}

	/**
	 * @return Long
	 * @hibernate.id column = "id_canal_atendimento" generator-class =
	 *               "sequence"
	 * @hibernate.generator-param name = "sequence" value =
	 *                            "NETOMS.sq_canal_atendimento"
	 */

	public Long getIdCanalAtendimento() {
		return this.idCanalAtendimento;
	}

	/**
	 * @param idCanalAtendimento
	 *            the idCanalAtendimento to set
	 */
	public void setIdCanalAtendimento(Long idCanalAtendimento) {
		this.idCanalAtendimento = idCanalAtendimento;
	}

	/**
	 * @return the dsCanalAtendimento
	 * 
	 * @hibernate.property column="ds_canal_atendimento" type="string"
	 */
	public String getDsCanalAtendimento() {
		return this.dsCanalAtendimento;
	}

	/**
	 * @param dsCanalAtendimento
	 *            the dsCanalAtendimento to set
	 */
	public void setDsCanalAtendimento(String dsCanalAtendimento) {
		this.dsCanalAtendimento = dsCanalAtendimento;
	}

	/**
	 * @return the fcAtivo
	 * 
	 * @hibernate.property column="fc_ativo" type="string"
	 */
	public String getFcAtivo() {
		return this.fcAtivo;
	}

	/**
	 * @param fcAtivoP
	 *            the fcAtivo to set
	 */
	public void setFcAtivo(final String fcAtivoP) {
		this.fcAtivo = fcAtivoP;
	}

	/**
	 * @return the fcArquivo
	 * 
	 * @hibernate.property column="fc_arquivo" type="string"
	 */
	public String getFcArquivo() {
		return this.fcArquivo;
	}

	/**
	 * @param fcArquivo
	 *            the fcArquivo to set
	 */
	public void setFcArquivo(final String fcArquivo) {
		this.fcArquivo = fcArquivo;
	}

	/**
	 * @return the fcIntegracao
	 * 
	 * @hibernate.property column="fc_integracao" type="string"
	 */
	public String getFcIntegracao() {
		return this.fcIntegracao;
	}

	/**
	 * @param fcIntegracao
	 *            the fcIntegracao to set
	 */
	public void setFcIntegracao(final String fcIntegracao) {
		this.fcIntegracao = fcIntegracao;
	}

	/**
	 * @return the idTempoResposta
	 * 
	 * @hibernate.property column="id_tempo_resposta" type="integer"
	 */
	public Integer getIdTempoResposta() {
		return idTempoResposta;
	}

	/**
	 * @param idTempoResposta
	 *            the idTempoResposta to set
	 */
	public void setIdTempoResposta(Integer idTempoResposta) {
		this.idTempoResposta = idTempoResposta;
	}

	/**
	 * @return the qtDiasAtendimento
	 * 
	 * @hibernate.property column="qt_dias_atendimento" type="integer"
	 */
	public Integer getQtDiasAtendimento() {
		return this.qtDiasAtendimento;
	}

	/**
	 * @param qtDiasAtendimentoP
	 *            the qtDiasAtendimento to set
	 */
	public void setQtDiasAtendimento(Integer qtDiasAtendimento) {
		this.qtDiasAtendimento = qtDiasAtendimento;
	}

	/**
	 * @return the dhUltimaAtualizacao
	 * 
	 * @hibernate.property column="dh_ultima_atualizacao" type="date"
	 */
	public Date getDhUltimaAtualizacao() {
		return this.dhUltimaAtualizacao;
	}

	/**
	 * @param dhUltimaAtualizacaoP
	 *            the dhUltimaAtualizacao to set
	 */
	public void setDhUltimaAtualizacao(final Date dhUltimaAtualizacao) {
		this.dhUltimaAtualizacao = dhUltimaAtualizacao;
	}

	/**
	 * @return the tpGrupoCanalAtendimento
	 * 
	 * @hibernate.property column="tp_grupo_canal_atendimento" type="string"
	 */
	public String getTpGrupoCanalAtendimento() {
		return this.tpGrupoCanalAtendimento;
	}

	/**
	 * @param tpGrupoCanalAtendimento
	 *            the tpGrupoCanalAtendimento to set
	 */
	public void setTpGrupoCanalAtendimento(String tpGrupoCanalAtendimento) {
		this.tpGrupoCanalAtendimento = tpGrupoCanalAtendimento;
	}
	
	@Override
	public int hashCode() {
		final int value = this.idCanalAtendimento == null ? 0
				: this.idCanalAtendimento.hashCode();
		return value ^ (value >>> 31);
	}

	@Override
	public boolean equals(final Object key) {
		boolean test = super.equals(key);
		if (key instanceof CanalAtendimentoBean) {
			final CanalAtendimentoBean comp = (CanalAtendimentoBean) key;
			test = this.getIdCanalAtendimento().equals(
					comp.getIdCanalAtendimento());
		}
		return test;
	}

}
