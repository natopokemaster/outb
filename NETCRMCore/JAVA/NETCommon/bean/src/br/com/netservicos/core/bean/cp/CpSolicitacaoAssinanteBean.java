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

import java.util.Date;

import br.com.netservicos.core.bean.sn.SnSolicDesabBean;
import br.com.netservicos.core.bean.sn.SnSolicitacaoAssBean;
import br.com.netservicos.framework.core.bean.DomainBean;

/**
 * <p>
 * <b>Description: </b><br>
 * Classe Bean que representa a tabela CP_SOLICITACAO_ASSINANTE.
 * </p>
 * <b> Issues: <br>
 * </b>
 * @author Alessandro Mariano
 * @since 21/09/2010
 * @version 1.0
 * @hibernate.class table = "cp_solicitacao_assinante" dynamic-insert="true"
 *                  dynamic-update="true" lazy="false" batch-size="10"
 * @hibernate.cache usage="read-write"
 */
public class CpSolicitacaoAssinanteBean extends DomainBean {


    private static final long serialVersionUID = -99554575510167178L;

    private static final String PRIMARY_KEY = "idSolicitacaoAss";

    private Long idSolicitacaoAss;
    private Integer fnSolicImediata;
    private Long idPerfilCliente;
    private Date dtCancelamento;
    private String dsObservacao;
    private String dsContato;
    private String nrDddContato;
    private String nrTelContato;
    private CpPropostaAssinanteBean propostaAssinante;
    private CpSolicitacaoVendaBean solicitacaoVenda;
    private SnSolicDesabBean solicDesab;
    private SnSolicitacaoAssBean solicitacaoAss;

    /**
     * Construtor padrão
     */
    public CpSolicitacaoAssinanteBean() {
        super(CpSolicitacaoAssinanteBean.PRIMARY_KEY);
    }
    
    /**
     * @return Returns the idSolicitacaoAss
     * @hibernate.id column = "ID_SOLICITACAO_ASSINANTE"
     *               length = "10"
     *               generator-class = "sequence"
     * @hibernate.generator-param name="sequence"
     *                            value="SQCP_SOLICITACAO_ASSINANTE"
     */
    public Long getIdSolicitacaoAss() {
        return this.idSolicitacaoAss;
    }

    /**
     * @return Returns the dsContato.
     * @hibernate.property column = "DS_CONTATO"
     */
    public String getDsContato() {
        return this.dsContato;
    }

    /**
     * @return Returns the dsObservacao
     * @hibernate.property column = "DS_OBSERVACAO"
     */
    public String getDsObservacao() {
        return this.dsObservacao;
    }

    /**
     * @return Returns the CpPropostaAssinanteBean
     * @hibernate.many-to-one
     *                        column = "ID_PROPOSTA_ASSINANTE"
     *                        lazy="proxy"
     */
    public CpPropostaAssinanteBean getPropostaAssinante() {
        return this.propostaAssinante;
    }

    /**
     * @return Returns the CpSolicitacaoVendaBean
     * @hibernate.many-to-one column = "ID_SOLICITACAO_VENDA"
     *                        lazy="proxy"
     */
    public CpSolicitacaoVendaBean getSolicitacaoVenda() {
        return this.solicitacaoVenda;
    }

    /**
     * @return Returns the dtCancelamento
     * @hibernate.property column = "DT_CANCELAMENTO"
     */
    public Date getDtCancelamento() {
        return this.dtCancelamento;
    }

    /**
     * @return Returns the fnSolicImediata
     * @hibernate.property column = "FN_SOLIC_IMEDIATA"
     *                     length = "1"
     */
    public Integer getFnSolicImediata() {
        return this.fnSolicImediata;
    }

    /**
     * @return Returns the SnSolicDesabBean
     * @hibernate.many-to-one class="br.com.netservicos.core.bean.sn.SnSolicDesabBean"
     *                        column = "ID_RAZAO_SOLIC"
     */
    public SnSolicDesabBean getSolicDesab() {
        return this.solicDesab;
    }

    /**
     * @return Returns the SnSolicitacaoAssBean
     * @hibernate.many-to-one
     *                        column = "ID_SOLICITACAO_ASS"
     *                        lazy="proxy"
     */
    public SnSolicitacaoAssBean getSolicitacaoAss() {
        return this.solicitacaoAss;
    }

    /**
     * @return Returns the idPerfilCliente.
     * @hibernate.property column="id_perfil_cliente"
     */
    public Long getIdPerfilCliente() {
        return this.idPerfilCliente;
    }

    /**
     * @return Returns the nrDddContato
     * @hibernate.property column="nr_ddd_contato"
     */
    public String getNrDddContato() {
        return this.nrDddContato;
    }

    /**
     * @return Returns the nrTelContato
     * @hibernate.property column="nr_tel_contato"
     */
    public String getNrTelContato() {
        return this.nrTelContato;
    }
    
    /**
	 * @param idSolicitacaoAss the idSolicitacaoAss to set
	 */
	public void setIdSolicitacaoAss(Long idSolicitacaoAss) {
		this.idSolicitacaoAss = idSolicitacaoAss;
	}

	/**
	 * @param fnSolicImediata the fnSolicImediata to set
	 */
	public void setFnSolicImediata(Integer fnSolicImediata) {
		this.fnSolicImediata = fnSolicImediata;
	}

	/**
	 * @param idPerfilCliente the idPerfilCliente to set
	 */
	public void setIdPerfilCliente(Long idPerfilCliente) {
		this.idPerfilCliente = idPerfilCliente;
	}

	/**
	 * @param dtCancelamento the dtCancelamento to set
	 */
	public void setDtCancelamento(Date dtCancelamento) {
		this.dtCancelamento = dtCancelamento;
	}

	/**
	 * @param dsObservacao the dsObservacao to set
	 */
	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	/**
	 * @param dsContato the dsContato to set
	 */
	public void setDsContato(String dsContato) {
		this.dsContato = dsContato;
	}

	/**
	 * @param nrDddContato the nrDddContato to set
	 */
	public void setNrDddContato(String nrDddContato) {
		this.nrDddContato = nrDddContato;
	}

	/**
	 * @param nrTelContato the nrTelContato to set
	 */
	public void setNrTelContato(String nrTelContato) {
		this.nrTelContato = nrTelContato;
	}

	/**
	 * @param propostaAssinante the propostaAssinante to set
	 */
	public void setPropostaAssinante(CpPropostaAssinanteBean propostaAssinante) {
		this.propostaAssinante = propostaAssinante;
	}

	/**
	 * @param solicDesab the solicDesab to set
	 */
	public void setSolicDesab(SnSolicDesabBean solicDesab) {
		this.solicDesab = solicDesab;
	}

	/**
	 * @param solicitacaoAss the solicitacaoAss to set
	 */
	public void setSolicitacaoAss(SnSolicitacaoAssBean solicitacaoAss) {
		this.solicitacaoAss = solicitacaoAss;
	}

	/**
	 * @param solicitacaoVenda the solicitacaoVenda to set
	 */
	public void setSolicitacaoVenda(CpSolicitacaoVendaBean solicitacaoVenda) {
		this.solicitacaoVenda = solicitacaoVenda;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        if (this.idSolicitacaoAss != null) {
            result = prime * result + this.idSolicitacaoAss.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(final Object key) {
        boolean test = super.equals(key);
        if (key instanceof CpSolicitacaoAssinanteBean) {
            final CpSolicitacaoAssinanteBean comp = (CpSolicitacaoAssinanteBean) key;
            test = this.getIdSolicitacaoAss().equals(comp.getIdSolicitacaoAss());
        }
        return test;
    }
}