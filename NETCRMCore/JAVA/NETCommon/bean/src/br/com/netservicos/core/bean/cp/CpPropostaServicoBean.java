/*
 * Created on 21/09/2010
 * Project : NETCommon
 * Copyright © 2010 NET.
 * Brasil
 * All rights reserved.
 * This software is the confidential and proprietary information of NET.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Sun.
 */

package br.com.netservicos.core.bean.cp;

import br.com.netservicos.core.bean.sn.SnPlanoPgtoBean;
import br.com.netservicos.core.bean.sn.SnProdutoBean;
import br.com.netservicos.core.bean.sn.SnPromocaoBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_PROPOSTA_SERVICO.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * 
 * @hibernate.class  table = "cp_proposta_servico" 
 *      dynamic-insert="true" dynamic-update="true"
 *      lazy="true" batch-size="10"
 *
 *@hibernate.query name  = "lstCpPropostaServicoByIdProposta"
 *                 query = "SELECT bean
 *                          FROM br.com.netservicos.core.bean.cp.CpPropostaServicoBean bean
 *                          WHERE bean.proposta.idProposta = :idProposta"
 *
 * */

public class CpPropostaServicoBean extends DomainBean {
	


	public static final String SELECT_BY_ID_PROPOSTA = "lstCpPropostaServicoByIdProposta";
	private static final long serialVersionUID = 1464367416946303491L;

	private static final String PRIMARY_KEY = "idPropostaServico";

	private Long idPropostaServico;   
	private String fcGeracaoOs;         
	private SnProdutoBean produto;
	private CpPropostaBean proposta;
	private CpSolicitacaoAssinanteBean solicitacaoAssinante;
	private SnPromocaoBean promocao;
	private SnPlanoPgtoBean planoPagamento;
	private Long idEquipeVenda;
	private Integer fnAgendaConveniencia;
	private Integer fnAgendaPadrao;
	private Integer idAgendamento;
	private Long idServicoContratoAnterior;	

    public CpPropostaServicoBean() {
        super(CpPropostaServicoBean.PRIMARY_KEY);
    }
	
    /**
     * @return Returns the idPropostaServico
     * @hibernate.id column="id_proposta_servico" generator-class="sequence"
     * @hibernate.generator-param name="sequence" value="sq_id_proposta_servico"
     */	
	public Long getIdPropostaServico() {
		return idPropostaServico;
	}
		
    /**
     * @return Returns the fcGeracaoOs.
     * @hibernate.property column = "fc_geracao_os" insert="true" update="true"
     */
    public String getFcGeracaoOs() {
        return this.fcGeracaoOs;
    }

    /**
     * @return Returns the SnProdutoBean.
     * @hibernate.many-to-one
     *                        class="br.com.netservicos.core.bean.sn.SnProdutoBean"
     *                        column = "id_produto" insert="true" update="true"
     *                        lazy="false"
     */
    public SnProdutoBean getProduto() {
        return this.produto;
    }

    /**
     * @return Returns the CpPropostaBean.
     * @hibernate.many-to-one
     *                        class="br.com.netservicos.core.bean.cp.CpPropostaBean"
     *                        column="id_proposta" lazy="false"
     */
    public CpPropostaBean getProposta() {
        return this.proposta;
    }
    
    /**
     * @hibernate.many-to-one
     *                        class="br.com.netservicos.core.bean.cp.CpSolicitacaoAssinanteBean"
     *                        column="id_solicitacao_assinante" lazy="false"
     * @return Returns the prospect.
     */
    public CpSolicitacaoAssinanteBean getSolicitacaoAssinante() {
        return this.solicitacaoAssinante;
    }

    /**
     * @return Returns the SnPromocaoBean.
     * @hibernate.many-to-one
     *                        class="br.com.netservicos.core.bean.sn.SnPromocaoBean"
     *                        column = "id_promocao" insert="true" update="true"
     *                        lazy="false"
     */
    public SnPromocaoBean getPromocao() {
        return this.promocao;
    }

    /**
     * @return Returns the id_plano_pgto.
     * @hibernate.many-to-one
     *                        class="br.com.netservicos.core.bean.sn.SnPlanoPgtoBean"
     *                        column = "id_plano_pgto" insert="true"
     *                        update="true" lazy="false"
     */
    public SnPlanoPgtoBean getPlanoPagamento() {
        return this.planoPagamento;
    }

	/**
     * @return Returns the idEquipeVenda.
     * @hibernate.property column = "id_equipe_venda"
     * 		insert="true" update="true"
     */		
	public Long getIdEquipeVenda() {
		return this.idEquipeVenda;
	}
    
	/**
     * @return Returns the fnAgendaConveniencia.
     * @hibernate.property column = "fn_agenda_conveniencia"
     * 		insert="true" update="true"
     */	
	public Integer getFnAgendaConveniencia() {
		return fnAgendaConveniencia;
	}
	
	/**
     * @return Returns the fnAgendaPadrao.
     * @hibernate.property column = "fn_agenda_padrao"
     * 		insert="true" update="true"
     */	
	public Integer getFnAgendaPadrao() {
		return fnAgendaPadrao;
	}
	
	/**
     * @return Returns the idAgendamento.
     * 
     * @hibernate.property column = "ID_AGENDAMENTO"
     * 		insert="true" update="true"
     */	
	public Integer getIdAgendamento() {
		return idAgendamento;
	}

	/**
     * @return Returns the idServicoContratoAnterior.
     * @hibernate.property column = "id_servico_contrato"
     * 		insert="true" update="true"
     */		
	public Long getIdServicoContratoAnterior() {
		return idServicoContratoAnterior;
	}

	/**
	 * @param idPropostaServico the idPropostaServico to set
	 */
	public void setIdPropostaServico(Long idPropostaServico) {
		this.idPropostaServico = idPropostaServico;
	}

	/**
	 * @param fcGeracaoOs the fcGeracaoOs to set
	 */
	public void setFcGeracaoOs(String fcGeracaoOs) {
		this.fcGeracaoOs = fcGeracaoOs;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(SnProdutoBean produto) {
		this.produto = produto;
	}

	/**
	 * @param proposta the proposta to set
	 */
	public void setProposta(CpPropostaBean proposta) {
		this.proposta = proposta;
	}

	/**
	 * @param solicitacaoAssinante the solicitacaoAssinante to set
	 */
	public void setSolicitacaoAssinante(
			CpSolicitacaoAssinanteBean solicitacaoAssinante) {
		this.solicitacaoAssinante = solicitacaoAssinante;
	}

	/**
	 * @param promocao the promocao to set
	 */
	public void setPromocao(SnPromocaoBean promocao) {
		this.promocao = promocao;
	}

	/**
	 * @param planoPagamento the planoPagamento to set
	 */
	public void setPlanoPagamento(SnPlanoPgtoBean planoPagamento) {
		this.planoPagamento = planoPagamento; 
	}

	/**
	 * @param idEquipeVenda the idEquipeVenda to set
	 */
	public void setIdEquipeVenda(Long idEquipeVenda) {
		this.idEquipeVenda = idEquipeVenda;
	}

	/**
	 * @param fnAgendaConveniencia the fnAgendaConveniencia to set
	 */
	public void setFnAgendaConveniencia(Integer fnAgendaConveniencia) {
		this.fnAgendaConveniencia = fnAgendaConveniencia;
	}

	/**
	 * @param fnAgendaPadrao the fnAgendaPadrao to set
	 */
	public void setFnAgendaPadrao(Integer fnAgendaPadrao) {
		this.fnAgendaPadrao = fnAgendaPadrao;
	}

	/**
	 * @param idAgendamento the idAgendamento to set
	 */
	public void setIdAgendamento(Integer idAgendamento) {
		this.idAgendamento = idAgendamento;
	}

	/**
	 * @param idServicoContratoAnterior the idServicoContratoAnterior to set
	 */
	public void setIdServicoContratoAnterior(Long idServicoContratoAnterior) {
		this.idServicoContratoAnterior = idServicoContratoAnterior;
	}
}