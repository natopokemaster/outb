/*
 * Created on 20/01/2005
 *
 * Copyright © 2004 NET.
 * Brasil
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of NET. 
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */
package br.com.netservicos.core.bean.cp;

import java.util.Date;

import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <P><B>
 * Description :
 * </B>
 * <BR>
 * 	Classe Bean que representa a tabela cp_rel_pendencia_proposta.
 * </P>
 * <P>
 * <B>
 * Issues :
 * </B>
 * <PRE>    
 * ==============================================================================
 * Description                              Date        By
 * ---------------------------------------- ----------- -------------------------
 * Adição dos atributos fnLiberarExcecao e
 * propostaAssinante, além da geração de um
 * serialUID único para a classe e da
 * adição dos métodos equals(), hashCode()
 * e toString()								09/10/2006	Rafael Nami
 * ==============================================================================
 * </PRE>
 *
 * <P><B>
 * Revision History:
 * </B><PRE>
 * ==============================================================================
 *                               Prior
 * Date       By                 Version  Project/CSR    Description
 * ---------- ------------------ -------- -------------- ------------------------
 * 15/09/2010 Wellington Maeda   N/A      Entidades     Created. 
 * ==============================================================================
 * </PRE>
 *
 *@hibernate.class table="Cp_Rel_Pendencia_Proposta"
 *                 dynamic-insert="true"
 *                 dynamic-update="true"
 *                 lazy="true"
 *                 batch-size="10"
 *                 
 *@hibernate.query name = "lstCpRelPendenciasPropostasEmAberto"
 *                   query = "SELECT pendencia.idPendencia,
 *                                   pendencia.descricao,
 *                                   relPendenciaProposta.idRelPendenciaProposta 
 *                            FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean AS relPendenciaProposta
 *                            JOIN relPendenciaProposta.pendencia pendencia
 *                            JOIN relPendenciaProposta.proposta proposta
 *                            WHERE relPendenciaProposta.dtFechamento is null AND
 *                                  proposta.idProposta = :idProposta" 
 *                 
 *                 
 *@hibernate.query name="lstPendenciaDuplicidadeEmbratelToDelete"
 *				query="select 
 * 								pp.idRelPendenciaProposta,
 * 								pp.pendencia.idPendencia
 * 							from
 * 								CpRelPendenciaPropostaBean pp
 * 					     where
 * 							pp.proposta.idProposta = :idProposta
 * 						and pp.pendencia.idPendencia IN (18,19)"
 *                 
 *
 *@hibernate.query name = "lstExistsCpRelPendenciaPropostaEnderecoAnaliseByProposta"
 *                  query = "SELECT pendenciaProposta.idRelPendenciaProposta 
 *                           FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pendenciaProposta
 *                           WHERE pendenciaProposta.proposta.idProposta = :idProposta AND
 *                                 ((pendenciaProposta.pendencia.idPendencia = 6 AND
 *                                 pendenciaProposta.pendenciaVariacao.idPendVariacao = 9) OR 
 *                                  (pendenciaProposta.pendencia.idPendencia = 8 AND
 *                                 pendenciaProposta.pendenciaVariacao.idPendVariacao = 18)) AND
 *                                 pendenciaProposta.dtFechamento IS NULL"
 *                                 
 *                                  
 *                                  
 *@hibernate.query name = "lstExistsCpRelPendenciaPropostaPerfilClienteByProposta"
 *                  query = "SELECT pendenciaProposta.idRelPendenciaProposta 
 *                           FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pendenciaProposta
 *                           WHERE pendenciaProposta.proposta.idProposta = :idProposta AND
 *                                 pendenciaProposta.pendencia.idPendencia = 16 AND
 *                                 pendenciaProposta.pendenciaVariacao.idPendVariacao = 27 AND
 *                                 pendenciaProposta.dtFechamento IS NULL"
 *                                 
 *@hibernate.query name = "lstCpRelPendenciaPropostaByPropostaAndPendenciaAndVariacao"
 *                  query = "FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pendenciaProposta
 *                           WHERE ((:idPendencia IS NULL) OR (pendenciaProposta.pendencia.idPendencia = :idPendencia)) AND
 *                                 ((pendenciaProposta.proposta.idProposta = :idProposta)) AND
 *                                 ((:idPendVariacao IS NULL) OR (pendenciaProposta.pendenciaVariacao.idPendVariacao = :idPendVariacao)) AND
 *                                 pendenciaProposta.dtFechamento IS NULL"
 *                                 
 *                                 
 *@hibernate.query name = "lstExistsCpRelPendenciaPropostaReservaVoipByPropostaAssinante"
 *                  query = "SELECT pendenciaProposta.idRelPendenciaProposta 
 *                           FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pendenciaProposta
 *                           WHERE pendenciaProposta.propostaAssinante.idPropostaAssinante = :idPropostaAssinante AND
 *                                 pendenciaProposta.pendencia.idPendencia = 15 AND
 *                                 pendenciaProposta.pendenciaVariacao.idPendVariacao = 26 AND
 *                                 pendenciaProposta.dtFechamento IS NULL"
 *                                 
 *                                 
 *@hibernate.query name = "lstExistsCpRelPendenciaPropostaReservaVoipPortabilidadeByProposta"
 *                  query = "SELECT pendenciaProposta.idRelPendenciaProposta 
 *                           FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pendenciaProposta
 *                           WHERE pendenciaProposta.proposta.idProposta = :idProposta AND
 *                                 pendenciaProposta.pendencia.idPendencia = 20 AND
 *                                 pendenciaProposta.pendenciaVariacao.idPendVariacao = 102 AND
 *                                 pendenciaProposta.dtFechamento IS NULL"     
 *
 *@hibernate.query name = "lstCpRelPendenciaPropostaReservaVoipByProposta"
 *                  query = "SELECT pendenciaProposta.idRelPendenciaProposta 
 *                           FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pendenciaProposta
 *                           WHERE pendenciaProposta.proposta.idProposta = :idProposta AND
 *                                 pendenciaProposta.pendencia.idPendencia = 15 AND
 *                                 pendenciaProposta.pendenciaVariacao.idPendVariacao = 26"
 * 
 *                                 
 *@hibernate.query name = "lstCpRelPendenciaPropostaReservaVoipPortabilidadeByProposta"
 *                  query = "SELECT pendenciaProposta.idRelPendenciaProposta 
 *                           FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pendenciaProposta
 *                           WHERE pendenciaProposta.proposta.idProposta = :idProposta AND
 *                                 pendenciaProposta.pendencia.idPendencia = 20 AND
 *                                 pendenciaProposta.pendenciaVariacao.idPendVariacao = 102"
 *                                 
 *                                 
 *@hibernate.query name = "lstExistsCpRelPendenciaPropostaReservaVoipByProposta"
 *                  query = "SELECT pendenciaProposta.idRelPendenciaProposta 
 *                           FROM br.com.netservicos.core.bean.cp.CpRelPendenciaPropostaBean pendenciaProposta
 *                           WHERE pendenciaProposta.proposta.idProposta = :idProposta AND
 *                                 pendenciaProposta.pendencia.idPendencia = 15 AND
 *                                 pendenciaProposta.pendenciaVariacao.idPendVariacao = 26 AND
 *                                 pendenciaProposta.dtFechamento IS NULL"
 *                                 
 */
public class CpRelPendenciaPropostaBean extends DomainBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5945568612748079222L;

	public static final String STATUS_PENDENCIA_CANCELADA = "C";
	    
    private static final String ID_REL_PENDENCIA_PROPOSTA = "idRelPendenciaProposta";
    public static final String LST_EXISTS_CP_REL_PENDENCIA_PROPOSTA_PERFIL_CLIENTE_VOIP_BY_PROPOSTA = "lstExistsCpRelPendenciaPropostaPerfilClienteByProposta";
    public static final String LST_CP_REL_PENDENCIA_PROPOSTA_BY_PROPOSTA_AND_PENDENCIA_AND_VARIACAO = "lstCpRelPendenciaPropostaByPropostaAndPendenciaAndVariacao";
    public static final String LST_EXISTS_CP_REL_PENDENCIA_PROPOSTA_RESERVA_VOIP_BY_PROPOSTA = "lstExistsCpRelPendenciaPropostaReservaVoipByProposta";
    public static final String LST_EXISTS_CP_REL_PENDENCIA_PROPOSTA_RESERVA_VOIP_PORT_BY_PROPOSTA_ASSINANTE = "lstExistsCpRelPendenciaPropostaReservaVoipPortabilidadeByProposta";
    public static final String LST_PENDENCIA_RESERVA_VOIP = "lstCpRelPendenciaPropostaReservaVoipByProposta";
    public static final String LST_PENDENCIA_RESERVA_VOIP_PORTABILIDADE = "lstCpRelPendenciaPropostaReservaVoipPortabilidadeByProposta";
    
    private Integer backOffice;
    private Date dtAbertura;
    private Date dtFechamento;
    private Long idRelPendenciaProposta;
    private String obs;
    private CpPendenciasBean pendencia;
    private CpRelPendenciasVariacoesBean pendenciaVariacao;
    private CpPropostaBean proposta;
    private CpMotivoRejeicaoPropBean motivoRejeicao;
    private String statusPendencia;
    private String usuario;
    private Integer fnLiberarExcecao;
    private CpPropostaAssinanteBean propostaAssinante;

    /**
     * Construtor padrão : Carrega as meta informações do bean.
     */
    public CpRelPendenciaPropostaBean() {
        super(ID_REL_PENDENCIA_PROPOSTA);
    }
    
    public CpRelPendenciaPropostaBean(Long idProposta) {
        this();
        
        setIdRelPendenciaProposta(idProposta);
    }
    
    public CpRelPendenciaPropostaBean(CpPropostaBean proposta) {
        this(proposta.getIdProposta());
        
        setProposta(proposta);
    }


    /**
     * Obtains and returns the new value of the backOffice attribute.
     * 
     * @return Returns the backOffice.
     * 
     * @hibernate.property
     * 		column="back_office"
     * 
     */
    public Integer getBackOffice() {
        return backOffice;
    }

    /**
     * Obtains and returns the new value of the dtAbertura attribute.
     * 
     * @return Returns the dtAbertura.
     * 
     * @hibernate.property
     * 		column="dt_abertura"
     * 		type = "date" 
     * 		not-null="true"
     */
    public Date getDtAbertura() {
        return dtAbertura;
    }

    /**
     * Obtains and returns the new value of the dtFechamento attribute.
     * 
     * @return Returns the dtFechamento.
     * 
     * @hibernate.property
     * 		column="dt_fechamento"
     * 		type = "date"
     */
    public Date getDtFechamento() {
        return dtFechamento;
    }

    /**
     * @hibernate.id
     * 		column="id_rel_pendencia_proposta"	
     * 		generator-class="sequence"
     * @hibernate.generator-param
     *      name="sequence"
     *      value="scp_rel_pendencia_proposta"
     * @return
     */
    public Long getIdRelPendenciaProposta() {
        return idRelPendenciaProposta;
    }

    /**
     * Obtains and returns the new value of the obs attribute.
     * 
     * @return Returns the obs.
     * 
     * @hibernate.property
     */
    public String getObs() {
        return obs;
    }

    /**
     * @hibernate.many-to-one  
     * 		column="id_pendencia"
     * 		cascade="none"
     * 
     * @return
     */
    public CpPendenciasBean getPendencia() {
        return pendencia;
    }

    /**
     * @hibernate.many-to-one  
     * 		column="id_pend_variacao"
     * 		cascade="none" 
     */
    public CpRelPendenciasVariacoesBean getPendenciaVariacao() {
        return pendenciaVariacao;
    }

    /**
     * @hibernate.many-to-one
     *      column="id_proposta"
     * @return
     */
    public CpPropostaBean getProposta() {
        return proposta;
    }

    /**     
     * @hibernate.many-to-one
     *      column="id_motivo_rejeicao_prop"
     * @return
     */
    public CpMotivoRejeicaoPropBean getMotivoRejeicao() {
        return motivoRejeicao;
    }

    /**
     * Obtains and returns the new value of the statusPendencia attribute.
     * 
     * @return Returns the statusPendencia.
     * 
     * @hibernate.property
     * 		column="status_pendencia"
     */
    public String getStatusPendencia() {
        return statusPendencia;
    }

    /**
     * Obtains and returns the new value of the loginUsuario attribute.
     * 
     * @return Returns the loginUsuario.
     * 
     * @hibernate.property
     * 	column = "usuario"
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param backOffice The backOffice to set.
     * 
     */
    public void setBackOffice(Integer backOffice) {
        this.backOffice = backOffice;
    }

    /**
     * @param dtAbertura The dtAbertura to set.
     * 
     */
    public void setDtAbertura(Date dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    /**
     * @param dtFechamento The dtFechamento to set.
     * 
     */
    public void setDtFechamento(Date dtFechamento) {
        this.dtFechamento = dtFechamento;
    }

    public void setIdRelPendenciaProposta(Long idProposta) {
        this.idRelPendenciaProposta = idProposta;
    }

    /**
     * @param obs The obs to set.
     * 
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    public void setPendencia(CpPendenciasBean pendencia) {
        this.pendencia = pendencia;
    }

    /**
     * @param pendenciaVariacao The relPendenciasVariacoes to set.
     */
    public void setPendenciaVariacao(
            CpRelPendenciasVariacoesBean pendenciasVariacoes) {
        this.pendenciaVariacao = pendenciasVariacoes;
    }

    public void setProposta(CpPropostaBean proposta) {
        this.proposta = proposta;
    }

    public void setMotivoRejeicao(CpMotivoRejeicaoPropBean motivoRejeicao) {
        this.motivoRejeicao = motivoRejeicao;
    }

    /**
     * @param statusPendencia The statusPendencia to set.
     * 
     */
    public void setStatusPendencia(String statusPendencia) {
        this.statusPendencia = statusPendencia;
    }

    /**
     * @param loginUsuario The loginUsuario to set.
     * 
     */
    public void setUsuario(String loginUsuario) {
        this.usuario = loginUsuario;
    }

	/**
	 * Método de acesso ao atributo fnLiberarExcecao
	 * @return fnLiberarExcecao O valor do atributo fnLiberarExcecao
	 * 
	 * @hibernate.property
	 * 		column = "fn_liberar_excecao"
	 */
	public Integer getFnLiberarExcecao() {
		return fnLiberarExcecao;
	}

	/**
	 * @param fnLiberarExcecao the fnLiberarExcecao to set
	 */
	public void setFnLiberarExcecao(Integer fnLiberarExcecao) {
		this.fnLiberarExcecao = fnLiberarExcecao;
	}

	/**
	 * Método de acesso ao atributo propostaAssinante
	 * @return propostaAssinante O valor do atributo propostaAssinante
	 * 
	 * @hibernate.many-to-one
     *      column="id_proposta_assinante"
	 */
	public CpPropostaAssinanteBean getPropostaAssinante() {
		return propostaAssinante;
	}

	/**
	 * Método de modificação do atributo propostaAssinante
	 * @param propostaAssinante O valor a setar o atributo propostaAssinante
	 */
	public void setPropostaAssinante(CpPropostaAssinanteBean propostaAssinante) {
		this.propostaAssinante = propostaAssinante;
	}
}